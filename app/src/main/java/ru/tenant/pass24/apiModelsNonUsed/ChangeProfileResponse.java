package ru.tenant.pass24.apiModelsNonUsed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeProfileResponse {
    @SerializedName("body")
    @Expose
    private ChangeProfileResponseBody body;

    @SerializedName("error")
    @Expose
    private ChangeProfileResponseError error;
}
