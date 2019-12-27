package ru.tenant.pass24.apiModelsNonUsed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("body")
    @Expose
    private ProfileResponseBody body;

    @SerializedName("error")
    @Expose
    private ProfileResponseError error;

    public ProfileResponseBody getBody() {
        return body;
    }

    public void setBody(ProfileResponseBody body) {
        this.body = body;
    }

    public ProfileResponseError getError() {
        return error;
    }

    public void setError(ProfileResponseError error) {
        this.error = error;
    }
}
