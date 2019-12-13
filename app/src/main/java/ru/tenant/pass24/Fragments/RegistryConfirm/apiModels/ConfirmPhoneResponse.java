package ru.tenant.pass24.Fragments.RegistryConfirm.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.Fragments.Login.apiModels.ErrorResponse;

public class ConfirmPhoneResponse {
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
