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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class FetchingDataUILogicTest {

    @Rule
    public ActivityTestRule<FetchingDataActivity> mActivityRule = new ActivityTestRule<>(FetchingDataActivity.class);

    @Test
    public void testInitialValueOfCounter() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        Assert.assertEquals(0, viewModel.getDataFetchedSubjectResource().getTimesFetched());
    }

    @Test
    public void testCounterClick() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        TestObserver<DataFetched> fetchedTestObserver = new TestObserver<>();
        viewModel.getDataFetchedSubject().subscribe(fetchedTestObserver);
        try {
            onView(withId(R.id.fetching_data_button)).perform(click());
            fetchedTestObserver.await(5, TimeUnit.SECONDS);
            Assert.assertEquals(1, fetchedTestObserver.values().get(0).getTimesFetched());
        } catch (InterruptedException e) {
            Log.d(FetchingDataViewModelTest.class.getSimpleName(), e.getMessage());
        }
    }

    @Test
    public void testResponseCode() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        TestObserver<DataFetched> fetchedTestObserver = new TestObserver<>();
        viewModel.getDataFetchedSubject().subscribe(fetchedTestObserver);
        try {
            onView(withId(R.id.fetching_data_button)).perform(click());
            fetchedTestObserver.await(5, TimeUnit.SECONDS);
            Assert.assertNotNull(fetchedTestObserver.values().get(0).getValue());


        } catch (InterruptedException e) {
            Log.d(FetchingDataViewModelTest.class.getSimpleName(), e.getMessage());
        }
    }

    @Test
    public void test100Click() {
        FetchingDataViewModel viewModel = ViewModelProviders.of(mActivityRule.getActivity()).get(FetchingDataViewModel.class);
        TestObserver<DataFetched> fetchedTestObserver = new TestObserver<>();
        viewModel.getDataFetchedSubject().subscribe(fetchedTestObserver);
        try {
            for(int i=100; i>0; i--) {
                onView(withId(R.id.fetching_data_button)).perform(click());
            }
            fetchedTestObserver.await(5, TimeUnit.SECONDS);
            Assert.assertEquals(100, fetchedTestObserver.values().get(0).getTimesFetched());
        } catch (InterruptedException e) {
            Log.d(FetchingDataViewModelTest.class.getSimpleName(), e.getMessage());
        }
    }

}
