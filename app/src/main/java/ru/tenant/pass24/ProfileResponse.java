package ru.tenant.pass24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.AuthorizationFragments.Registration.apiModels.RegistryResponseBody;

public class ProfileResponse {
    @SerializedName("body")
    @Expose
    private ProfileResponseBody body;

    @SerializedName("error")
    @Expose
    private ProfileResponseError error;
}
