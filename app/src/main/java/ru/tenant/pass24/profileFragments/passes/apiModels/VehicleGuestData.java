package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleGuestData {

    @SerializedName("vehicleType")
    @Expose
    private int vehicleType;

    @SerializedName("modelId")
    @Expose
    private int modelId;

    @SerializedName("plateNumber")
    @Expose
    private String plateNumber;

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
