package ru.tenant.pass24.authorizationFragments.registration.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistryCheckResponse {
    @SerializedName("body")
    @Expose
    private boolean body;
    @SerializedName("error")
    @Expose
    private ErrorRegistryCheckResponse error;


    public boolean isBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public ErrorRegistryCheckResponse getError() {
        return error;
    }

    public void setError(ErrorRegistryCheckResponse error) {
        this.error = error;
    }
}
