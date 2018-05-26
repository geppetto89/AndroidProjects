package android.mobile.micmen.mvvmsample;

import android.arch.lifecycle.ViewModelProviders;
import android.mobile.micmen.mvvmsample.features.fetchingdata.FetchingDataActivity;
import android.mobile.micmen.mvvmsample.features.fetchingdata.FetchingDataViewModel;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;
import io.reactivex.observers.TestObserver;


@RunWith(AndroidJUnit4.class)
public class FetchingDataViewModelTest {

    @Rule
    public ActivityTestRule<FetchingDataActivity> mActivityRule = new ActivityTestRule<>(FetchingDataActivity.class);

    @Test
    public void testSubjectNotNull() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        Assert.assertNotNull(viewModel.getDataFetchedSubject());
    }

    @Test
    public void testFetchingDataEmptyBeforeCall() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        Assert.assertEquals(DataFetched.Status.EMPTY, viewModel.getDataFetchedSubjectResource().getStatus());
    }

    @Test
    public void testFetchingDataStatusAfterCall() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        viewModel.retrieveNextData();
        Assert.assertEquals(DataFetched.Status.LOADING, viewModel.getDataFetchedSubjectResource().getStatus());
    }

    @Test
    public void testFetchingDataSuccessAfterCallResponse() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        TestObserver<DataFetched> fetchedTestObserver = new TestObserver<>();
        viewModel.getDataFetchedSubject().subscribe(fetchedTestObserver);
        try {
            viewModel.retrieveNextData();
            fetchedTestObserver.await(5, TimeUnit.SECONDS);
            Assert.assertEquals(DataFetched.Status.SUCCESS , fetchedTestObserver.values().get(0).getStatus());
        } catch (InterruptedException e) {
            Log.d(FetchingDataViewModelTest.class.getSimpleName(), e.getMessage());
        }
    }


}
