package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassesResponse {
    @SerializedName("body")
    @Expose
    private PassesResponseBody body;

    @SerializedName("error")
    @Expose
    private PassesResponseError error;

    public PassesResponseBody getBody() {
        return body;
    }

    public void setBody(PassesResponseBody body) {
        this.body = body;
    }

    public PassesResponseError getError() {
        return error;
    }

    public void setError(PassesResponseError error) {
        this.error = error;
    }
}
