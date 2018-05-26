package android.mobile.micmen.mvvmsample.features.fetchingdata

import android.arch.lifecycle.ViewModelProviders
import android.mobile.micmen.mvvmsample.R
import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

/**
 * Shows the values retrieved from the network
 *
 * @author Michele Meninno
 */
class FetchingDataActivity : AppCompatActivity() {

    private lateinit var responseCodeTw: TextView
    private lateinit var fetchingValueCounter: TextView
    private lateinit var fetchingButton: TextView
    private lateinit var viewModel: FetchingDataViewModel
    private lateinit var progressBar: View
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching_data)
        viewModel = ViewModelProviders.of(this).get(FetchingDataViewModel::class.java)
        fetchingButton = findViewById(R.id.fetching_data_button)
        progressBar = findViewById(R.id.fetching_data_progress_bar)
        responseCodeTw = findViewById(R.id.fetching_data_response_code_tw)
        fetchingValueCounter = findViewById(R.id.fetching_data_counter_tw)
        initUI()
        initUIlogic()
    }

    private fun initUI() {
        responseCodeTw.text = resources.getString(R.string.response_code_parametric_string, "--")
        fetchingValueCounter.text = resources.getString(R.string.times_fetched_parametric_string, "--")
    }

    private fun initUIlogic() {
        fetchingButton.setOnClickListener {
            viewModel.retrieveNextData()
        }
        viewModel.dataFetchedSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { dataFetched ->
                    run {
                        if (dataFetched.status == DataFetched.Status.SUCCESS) {
                            progressBar.visibility = View.GONE
                            fetchingValueCounter.visibility = View.VISIBLE
                            responseCodeTw.text = resources.getString(R.string.response_code_parametric_string, dataFetched.value)
                            fetchingValueCounter.text = resources.getString(R.string.times_fetched_parametric_string, dataFetched.timesFetched.toString())
                        }
                        if (dataFetched.status == DataFetched.Status.ERROR) {
                            progressBar.visibility = View.GONE
                            responseCodeTw.text = resources.getString(R.string.network_error_message)
                            fetchingValueCounter.visibility = View.INVISIBLE
                        }
                        if(dataFetched.status == DataFetched.Status.LOADING){
                            progressBar.visibility = View.VISIBLE
                        }
                    }
                })
    }


    override fun onDestroy() {
        super.onDestroy()
        //to avoid memory leaks
        compositeDisposable.clear()
    }
}
