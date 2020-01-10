package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.tenant.pass24.profileFragments.passes.apiModels.VehicleGuestData;

public class CreateVehiclePassRequest {

    @SerializedName("addressId")
    @Expose
    private int addressId;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    @SerializedName("durationType")
    @Expose
    private int durationType;

    @SerializedName("guestType")
    @Expose
    private int guestType;

    @SerializedName("guestData")
    @Expose
    private VehicleGuestData vehicleGuestData;

    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("options")
    @Expose
    private List<Integer> options;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public int getDurationType() {
        return durationType;
    }

    public void setDurationType(int durationType) {
        this.durationType = durationType;
    }

    public int getGuestType() {
        return guestType;
    }

    public void setGuestType(int guestType) {
        this.guestType = guestType;
    }

    public VehicleGuestData getVehicleGuestData() {
        return vehicleGuestData;
    }

    public void setVehicleGuestData(VehicleGuestData vehicleGuestData) {
        this.vehicleGuestData = vehicleGuestData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }
}
