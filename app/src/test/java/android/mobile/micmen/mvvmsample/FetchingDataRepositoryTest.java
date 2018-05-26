package android.mobile.micmen.mvvmsample;


import android.mobile.micmen.mvvmsample.factory.RepositoryFactory;
import android.mobile.micmen.mvvmsample.factory.ServiceFactory;
import android.mobile.micmen.mvvmsample.factory.impl.RepositoryFactoryDefault;
import android.mobile.micmen.mvvmsample.factory.impl.ServiceFactoryImpl;
import android.mobile.micmen.mvvmsample.network.fetching_data.FetchingDataService;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.impl.FetchingDataMapper;

import junit.framework.Assert;

import org.junit.Test;

import io.reactivex.schedulers.Schedulers;

public class FetchingDataRepositoryTest {

    @Test
    public void testFetchingData() {
        RepositoryFactory repositoryFactory = new RepositoryFactoryDefault();
        FetchingDataRepository fetchingDataRepository = repositoryFactory.makeFetchingDataRepository();
        fetchingDataRepository.fetchNewDataFromUrl().blockingSubscribe(
                dataFetched ->
                {
                    Assert.assertNotNull(dataFetched.getValue());
                }
        );
    }

    @Test
    public void testFetchingDataService() {
        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Assert.assertNotNull(serviceFactory.makeService(FetchingDataService.class));
    }

    @Test
    public void testFetchingDataMapper() {
        FetchingDataMapper mapper = new FetchingDataMapper();
        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        FetchingDataService fetchingDataService = serviceFactory.makeService(FetchingDataService.class);
        fetchingDataService
                .getFetchingData()
                .observeOn(Schedulers.io())
                .blockingSubscribe(fetchingDataResponse -> Assert.assertNotNull(mapper.map(fetchingDataResponse)) );
    }


}
