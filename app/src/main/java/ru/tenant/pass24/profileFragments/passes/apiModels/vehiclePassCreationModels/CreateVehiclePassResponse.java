package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateVehiclePassResponse {
    @SerializedName("body")
    @Expose
    private VehiclePassBody body;

    @SerializedName("error")
    @Expose
    private VehiclePassError error;

    public VehiclePassBody getBody() {
        return body;
    }

    public void setBody(VehiclePassBody body) {
        this.body = body;
    }

    public VehiclePassError getError() {
        return error;
    }

    public void setError(VehiclePassError error) {
        this.error = error;
    }
}
