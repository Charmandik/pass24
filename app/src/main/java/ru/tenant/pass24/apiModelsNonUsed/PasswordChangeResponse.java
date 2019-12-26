package ru.tenant.pass24.apiModelsNonUsed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordChangeResponse {
    @SerializedName("body")
    @Expose
    private boolean body;
    @SerializedName("error")
    @Expose
    private ChangePasswordResponseError error;
}
