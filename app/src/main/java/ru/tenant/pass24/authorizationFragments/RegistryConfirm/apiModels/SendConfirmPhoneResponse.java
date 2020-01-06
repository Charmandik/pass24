package ru.tenant.pass24.authorizationFragments.RegistryConfirm.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.authorizationFragments.PasswordRecovery.apiModels.ErrorPasswordRecoveryResponse;

public class SendConfirmPhoneResponse {
    @SerializedName("body")
    @Expose
    private boolean body;
    @SerializedName("error")
    @Expose
    private ErrorPasswordRecoveryResponse error;

    public boolean isBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public ErrorPasswordRecoveryResponse getError() {
        return error;
    }

    public void setError(ErrorPasswordRecoveryResponse error) {
        this.error = error;
    }
}
