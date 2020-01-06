package ru.tenant.pass24.apiModelsNonUsed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ChangeProfileResponseErrorDetails {
    @SerializedName("email")
    @Expose
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
