package ru.tenant.pass24.authorizationFragments.PasswordRecovery.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.authorizationFragments.Login.apiModels.ErrorResponse;

public class PasswordResetResponse {
    @SerializedName("body")
    @Expose
    private boolean body;
    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }
}
