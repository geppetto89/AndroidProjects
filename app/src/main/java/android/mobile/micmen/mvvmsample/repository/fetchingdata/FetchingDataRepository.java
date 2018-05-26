package android.mobile.micmen.mvvmsample.repository.fetchingdata;

import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched;

import io.reactivex.Observable;

public interface FetchingDataRepository {

    Observable<DataFetched> fetchNewDataFromUrl();

}
