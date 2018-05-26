package android.mobile.micmen.mvvmsample.repository.fetchingdata.impl;

import android.mobile.micmen.mvvmsample.network.RetrofitClient;
import android.mobile.micmen.mvvmsample.network.fetching_data.FetchingDataService;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingDataResponse;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingUrlReponse;

import io.reactivex.Observable;

/**
 * <h1>Fetching data repository default implementation</h1>
 * <p>
 * set the background test for network calls
 * maps the dto obtained from the network with the model object
 */
public class FetchingDataRepositoryImpl extends FetchingDataRepositoryAbstract {

    private FetchingDataService service;

    public FetchingDataRepositoryImpl(FetchingDataService service) {
        this.service = service;
    }

    @Override
    protected Observable<FetchingDataResponse> fetchingDataFromUrlCall(String path) {
        return service.getFetchingDataFromUrl(path);
    }

    @Override
    protected Observable<FetchingUrlReponse> fetchingUrlCall() {
        return service.getFetchingUrl(RetrofitClient.BASE_URL);
    }

}
