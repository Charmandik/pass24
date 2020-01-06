package ru.tenant.pass24.profileFragments.trustedPeople.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfidanceResponse {
    @SerializedName("body")
    @Expose
    private ConfidanceResponseBody body;

    @SerializedName("error")
    @Expose
    private ConfidanceResponseError error;

    public ConfidanceResponseBody getBody() {
        return body;
    }

    public void setBody(ConfidanceResponseBody body) {
        this.body = body;
    }

    public ConfidanceResponseError getError() {
        return error;
    }

    public void setError(ConfidanceResponseError error) {
        this.error = error;
    }
}
