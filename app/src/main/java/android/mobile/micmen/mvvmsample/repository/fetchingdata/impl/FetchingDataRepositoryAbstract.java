package android.mobile.micmen.mvvmsample.repository.fetchingdata.impl;

import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingDataResponse;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingUrlReponse;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public abstract class FetchingDataRepositoryAbstract implements FetchingDataRepository {

    private FetchingDataMapper mapper = new FetchingDataMapper();

    @Override
    public Observable<DataFetched> fetchNewDataFromUrl() {
        return fetchingUrlCall()
                .subscribeOn(Schedulers.io())
                .concatMap(url ->
                        fetchingDataFromUrlCall(url.getUrlContainingPathTocall())
                                .observeOn(Schedulers.computation())
                                .map(fetchingDataResponse -> mapper.map(fetchingDataResponse)));
    }

    protected abstract Observable<FetchingDataResponse> fetchingDataFromUrlCall(String path);

    protected abstract Observable<FetchingUrlReponse> fetchingUrlCall();

}
