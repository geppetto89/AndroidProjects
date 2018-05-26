package android.mobile.micmen.mvvmsample.network.fetching_data;

import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingDataResponse;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingUrlReponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FetchingDataService {

    @GET
    Observable<FetchingUrlReponse> getFetchingUrl(@Url String url);

    @GET
    Observable<FetchingDataResponse> getFetchingDataFromUrl(@Url String url);

    @GET("2e034207-6102-11e8-9c58-f45c89c9c1ad/")
    Observable<FetchingDataResponse> getFetchingData();

}
