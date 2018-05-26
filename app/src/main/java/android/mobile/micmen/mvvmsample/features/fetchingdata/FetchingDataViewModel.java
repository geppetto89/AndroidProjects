package android.mobile.micmen.mvvmsample.features.fetchingdata;

import android.arch.lifecycle.ViewModel;
import android.mobile.micmen.mvvmsample.core.TestApplication;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.FetchingDataRepository;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * <h1> View Model for the fetching data activity </h1>
 *
 * manages network calls
 * provides a rx-java subject to the view setting the values to display
 *
 * @author Michele Meninno
 */
public class FetchingDataViewModel extends ViewModel {

    private FetchingDataRepository repository = TestApplication.getInstance().getRepositoryFactory().makeFetchingDataRepository();
    private Subject<DataFetched> dataFetchedSubject = PublishSubject.create();

    public DataFetched getDataFetchedSubjectResource() {
        return dataFetchedSubjectResource;
    }

    private DataFetched dataFetchedSubjectResource = new DataFetched(null, DataFetched.Status.EMPTY, 0);
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public Subject<DataFetched> getDataFetchedSubject() {
        return dataFetchedSubject;
    }

    public void retrieveNextData() {
        dataFetchedSubjectResource.setStatus(DataFetched.Status.LOADING);
        dataFetchedSubject.onNext(dataFetchedSubjectResource);
        compositeDisposable.add(repository
                .fetchNewDataFromUrl()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rowDataFetched ->
                {
                    dataFetchedSubjectResource.setTimesFetched(dataFetchedSubjectResource.getTimesFetched() + 1);
                    dataFetchedSubjectResource.setValue(rowDataFetched.getValue());
                    dataFetchedSubjectResource.setStatus(DataFetched.Status.SUCCESS);
                    dataFetchedSubject.onNext(dataFetchedSubjectResource);
                }, throwable ->
                {
                    dataFetchedSubjectResource.setStatus(DataFetched.Status.ERROR);
                    dataFetchedSubject.onNext(dataFetchedSubjectResource);
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
