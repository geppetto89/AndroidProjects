package android.mobile.micmen.mvvmsample.repository.fetchingdata.impl;

import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingDataResponse;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingUrlReponse;

import io.reactivex.Observable;

public class FetchingDataRepositoryFake extends FetchingDataRepositoryAbstract {

    private FetchingDataResponse createFetchingDataResponse() throws InterruptedException {
        Thread.sleep(2000);
        FetchingDataResponse fetchingDataResponse = new FetchingDataResponse();
        fetchingDataResponse.setResponseCode("mocked response");
        return fetchingDataResponse;
    }

    private FetchingUrlReponse createUrlResponse() throws InterruptedException {
        Thread.sleep(1000);
        return new FetchingUrlReponse();
    }

    @Override
    protected Observable<FetchingDataResponse> fetchingDataFromUrlCall(String path) {
        return Observable.defer(() -> Observable.just(createFetchingDataResponse()));
    }

    @Override
    protected Observable<FetchingUrlReponse> fetchingUrlCall() {
        return Observable.defer(() -> Observable.just(createUrlResponse()));
    }
}
