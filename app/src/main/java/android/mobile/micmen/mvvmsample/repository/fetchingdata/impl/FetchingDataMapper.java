package android.mobile.micmen.mvvmsample.repository.fetchingdata.impl;

import android.mobile.micmen.mvvmsample.core.Mapper;
import android.mobile.micmen.mvvmsample.network.fetching_data.dto.FetchingDataResponse;
import android.mobile.micmen.mvvmsample.repository.fetchingdata.model.DataFetched;

public class FetchingDataMapper implements Mapper<FetchingDataResponse, DataFetched>{

    @Override
    public DataFetched map(FetchingDataResponse elementToMap) {
        return new DataFetched(elementToMap.getResponseCode());
    }
}
