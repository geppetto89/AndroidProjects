
package android.mobile.micmen.mvvmsample.network.fetching_data.dto;

import com.google.gson.annotations.SerializedName;

public class FetchingDataResponse {

    @SerializedName("path")
    private String mPath;
    @SerializedName("response_code")
    private String mResponseCode;

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(String responseCode) {
        mResponseCode = responseCode;
    }

}
