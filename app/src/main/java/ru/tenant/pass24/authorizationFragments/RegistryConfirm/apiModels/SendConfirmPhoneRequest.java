package ru.tenant.pass24.authorizationFragments.RegistryConfirm.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendConfirmPhoneRequest {
    @SerializedName("phone")
    @Expose
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  SendConfirmPhoneRequest(String phone){
        this.phone = phone;
    }
}
