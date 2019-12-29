package ru.tenant.pass24.ProfileFragments.VehicleBrand.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.tenant.pass24.Helpers.Retrofit.apiInterfaces.VehicleBrand;

public class VehicleBrandResponse {
    @SerializedName("body")
    @Expose
    private List<VehicleBrandCollection> body;

    @SerializedName("error")
    @Expose
    private VehicleBrandResponseError error;

    public List<VehicleBrandCollection> getBody() {
        return body;
    }

    public void setBody(List<VehicleBrandCollection> body) {
        this.body = body;
    }

    public VehicleBrandResponseError getError() {
        return error;
    }

    public void setError(VehicleBrandResponseError error) {
        this.error = error;
    }
}
