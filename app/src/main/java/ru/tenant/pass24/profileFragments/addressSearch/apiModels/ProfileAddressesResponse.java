package ru.tenant.pass24.profileFragments.addressSearch.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileAddressesResponse {

    @SerializedName("body")
    @Expose
    private List<ProfileAddressesResponseBody> body;

    @SerializedName("error")
    @Expose
    private ProfileAddressesResponseError error;

    public List<ProfileAddressesResponseBody> getBody() {
        return body;
    }

    public void setBody(List<ProfileAddressesResponseBody> body) {
        this.body = body;
    }

    public ProfileAddressesResponseError getError() {
        return error;
    }

    public void setError(ProfileAddressesResponseError error) {
        this.error = error;
    }
}
