package android.mobile.micmen.mvvmsample.core;

import android.app.Application;
import android.mobile.micmen.mvvmsample.BuildConfig;
import android.mobile.micmen.mvvmsample.factory.RepositoryFactory;
import android.mobile.micmen.mvvmsample.factory.impl.RepositoryFactoryDefault;
import android.mobile.micmen.mvvmsample.factory.impl.RepositoryFactoryMock;

/**
 * <h1>Application singleton<h1/>
 * <p>
 * provides repositories injection based on flavor
 *
 * @author Michele Meninno
 */

public class TestApplication extends Application {

    private RepositoryFactory repositoryFactory;
    private static TestApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        //dependency injection based on flavor
        if (BuildConfig.IS_MOCK) {
            repositoryFactory = new RepositoryFactoryMock();
        } else {
            repositoryFactory = new RepositoryFactoryDefault();
        }
        instance = this;
    }

    public static TestApplication getInstance() {
        return instance;
    }

    public RepositoryFactory getRepositoryFactory() {
        return repositoryFactory;
    }
}
