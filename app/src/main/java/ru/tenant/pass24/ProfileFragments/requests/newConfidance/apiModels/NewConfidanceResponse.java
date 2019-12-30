package ru.tenant.pass24.ProfileFragments.requests.newConfidance.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewConfidanceResponse {
    @SerializedName("body")
    @Expose
    private NewConfidanceResponseBody body;

    @SerializedName("error")
    @Expose
    private NewConfidanceAddressError error;

    public NewConfidanceResponseBody getBody() {
        return body;
    }

    public void setBody(NewConfidanceResponseBody body) {
        this.body = body;
    }

    public NewConfidanceAddressError getError() {
        return error;
    }

    public void setError(NewConfidanceAddressError error) {
        this.error = error;
    }
}
