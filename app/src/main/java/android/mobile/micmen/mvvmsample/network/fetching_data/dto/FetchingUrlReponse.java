package android.mobile.micmen.mvvmsample.network.fetching_data.dto;

import com.google.gson.annotations.SerializedName;

public class FetchingUrlReponse {

    @SerializedName("next_path")
    private String urlContainingPathTocall;

    public String getUrlContainingPathTocall() {
        return urlContainingPathTocall;
    }

    public void setUrlContainingPathTocall(String urlContainingPathTocall) {
        this.urlContainingPathTocall = urlContainingPathTocall;
    }
}
