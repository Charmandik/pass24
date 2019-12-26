package ru.tenant.pass24.ProfileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FeedResponse {
    @SerializedName("body")
    @Expose
    private FeedResponseBody body;

    @SerializedName("error")
    @Expose
    private FeedResponseError error;

    public FeedResponseBody getBody() {
        return body;
    }

    public void setBody(FeedResponseBody body) {
        this.body = body;
    }

    public FeedResponseError getError() {
        return error;
    }

    public void setError(FeedResponseError error) {
        this.error = error;
    }
}
