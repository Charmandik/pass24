package ru.tenant.pass24.authorizationFragments.registration.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.authorizationFragments.login.apiModels.ErrorResponse;

public class RegistryResponse {
    @SerializedName("body")
    @Expose
    private RegistryResponseBody body;
    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public RegistryResponseBody getBody() {
        return body;
    }

    public void setBody(RegistryResponseBody body) {
        this.body = body;
    }
}
