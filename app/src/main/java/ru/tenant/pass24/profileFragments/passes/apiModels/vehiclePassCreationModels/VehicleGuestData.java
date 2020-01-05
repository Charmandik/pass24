package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.tenant.pass24.profileFragments.requests.apiModels.VehicleModel;

public class VehicleGuestData {
    @SerializedName("vehicleType")
    @Expose
    private int vehicleType;

    @SerializedName("model")
    @Expose
    private VehicleModel model;

    @SerializedName("plateNumber")
    @Expose
    private String plateNumber;

    @SerializedName("typePlateNumber")
    @Expose
    private String typePlateNumber;

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleModel getModel() {
        return model;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getTypePlateNumber() {
        return typePlateNumber;
    }

    public void setTypePlateNumber(String typePlateNumber) {
        this.typePlateNumber = typePlateNumber;
    }
}
