package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.authorizationFragments.login.apiModels.ErrorResponse;

public class DeletePassResponse {
    @SerializedName("body")
    @Expose
    private PassesCollection body;

    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public PassesCollection getBody() {
        return body;
    }

    public void setBody(PassesCollection body) {
        this.body = body;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
