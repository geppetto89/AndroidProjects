package android.mobile.micmen.mvvmsample.factory.impl;

import android.mobile.micmen.mvvmsample.factory.RepositoryFactory;
import android.mobile.micmen.mvvmsample.factory.ServiceFactory;
import android.mobile.micmen.mvvmsample.network.fetching_data.FetchingDataService;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.impl.FetchingDataRepositoryImpl;

/**
 * <h1> Repository Factory Implementation<h1/>
 *
 * creates actual repositories
 *
 * @author Michele Meninno
 */

public class RepositoryFactoryDefault implements RepositoryFactory {

    private ServiceFactory serviceFactory = new ServiceFactoryImpl();

    @Override
    public FetchingDataRepository makeFetchingDataRepository() {
        return new FetchingDataRepositoryImpl(serviceFactory.makeService(FetchingDataService.class));
    }
}
