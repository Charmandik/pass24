package ru.tenant.pass24.apiModelsNonUsed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ChangePasswordResponseError {
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;
}
