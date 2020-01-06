package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehiclePassError {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("details")
    @Expose
    private VehiclePassErrorDetails details;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VehiclePassErrorDetails getDetails() {
        return details;
    }

    public void setDetails(VehiclePassErrorDetails details) {
        this.details = details;
    }
}
