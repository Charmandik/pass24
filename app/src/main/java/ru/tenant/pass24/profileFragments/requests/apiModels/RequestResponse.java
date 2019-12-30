package ru.tenant.pass24.profileFragments.requests.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestResponse {
    @SerializedName("body")
    @Expose
    private RequestResponseBody body;

    @SerializedName("error")
    @Expose
    private RequestResponseError error;

    public RequestResponseBody getBody() {
        return body;
    }

    public void setBody(RequestResponseBody body) {
        this.body = body;
    }

    public RequestResponseError getError() {
        return error;
    }

    public void setError(RequestResponseError error) {
        this.error = error;
    }
}
