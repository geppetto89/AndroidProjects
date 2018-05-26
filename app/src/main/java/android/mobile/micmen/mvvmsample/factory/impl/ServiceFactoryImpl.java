package android.mobile.micmen.mvvmsample.factory.impl;

import android.mobile.micmen.mvvmsample.factory.ServiceFactory;
import android.mobile.micmen.mvvmsample.network.RetrofitClient;

import retrofit2.Retrofit;

/**
 * <h1>Retrofit service factory implementation </h1>
 *
 * provides retrofit services using the retrofit client
 *
 * @author Michele Meninno
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private Retrofit retrofit = RetrofitClient.getClient();

    @Override
    public <T> T makeService(Class<T> tClass) {
        return retrofit.create(tClass);
    }
}
