package ru.tenant.pass24.authorizationFragments.registryConfirm.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendConfirmPhoneRequest {
    @SerializedName("phone")
    @Expose
    private String phone;

    public SendConfirmPhoneRequest(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
