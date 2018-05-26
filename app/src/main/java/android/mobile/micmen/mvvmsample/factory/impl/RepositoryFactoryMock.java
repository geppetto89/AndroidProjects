package android.mobile.micmen.mvvmsample.factory.impl;

import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.impl.FetchingDataRepositoryFake;

public class RepositoryFactoryMock extends RepositoryFactoryDefault {

    private FetchingDataRepositoryFake fetchingDataRepositoryFake;

    @Override
    public FetchingDataRepository makeFetchingDataRepository() {
        fetchingDataRepositoryFake = new FetchingDataRepositoryFake();
        return fetchingDataRepositoryFake;
    }
}
