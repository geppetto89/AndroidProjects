package android.mobile.micmen.mvvmsample.factory;

import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;

/**
 * Provides a list of repository to build in the project
 *
 * @author Michele Meninno
 */
public interface RepositoryFactory {

    FetchingDataRepository makeFetchingDataRepository();

}
