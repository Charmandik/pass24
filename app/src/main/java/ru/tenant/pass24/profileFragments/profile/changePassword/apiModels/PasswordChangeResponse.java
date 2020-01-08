package ru.tenant.pass24.profileFragments.profile.changePassword.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordChangeResponse {
    @SerializedName("body")
    @Expose
    private boolean body;

    @SerializedName("error")
    @Expose
    private ChangePasswordResponseError error;

    public boolean isBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public ChangePasswordResponseError getError() {
        return error;
    }

    public void setError(ChangePasswordResponseError error) {
        this.error = error;
    }
}
