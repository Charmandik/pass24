package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class VehiclePassErrorDetails {

    @SerializedName("addressId")
    @Expose
    private List<String> addressId;

    @SerializedName("startsAt")
    @Expose
    private List<String> startsAt;

    @SerializedName("expiresAt")
    @Expose
    private List<String> expiresAt;

    @SerializedName("durationType")
    @Expose
    private List<String> durationType;

    @SerializedName("guestData")
    @Expose
    private List<String> guestData;

    @SerializedName("guestData.vehicleType")
    @Expose
    private List<String> guestData_vehicleType;

    @SerializedName("guestData.modelid")
    @Expose
    private List<String> guestData_modelid;

    @SerializedName("guestData.plateNumber")
    @Expose
    private List<String> guestData_plateNumber;

    @SerializedName("comment")
    @Expose
    private List<String> comment;

    @SerializedName("options")
    @Expose
    private List<String> options;

    public List<String> getAddressId() {
        return addressId;
    }

    public void setAddressId(List<String> addressId) {
        this.addressId = addressId;
    }

    public List<String> getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(List<String> startsAt) {
        this.startsAt = startsAt;
    }

    public List<String> getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(List<String> expiresAt) {
        this.expiresAt = expiresAt;
    }

    public List<String> getDurationType() {
        return durationType;
    }

    public void setDurationType(List<String> durationType) {
        this.durationType = durationType;
    }

    public List<String> getGuestData() {
        return guestData;
    }

    public void setGuestData(List<String> guestData) {
        this.guestData = guestData;
    }

    public List<String> getGuestData_vehicleType() {
        return guestData_vehicleType;
    }

    public void setGuestData_vehicleType(List<String> guestData_vehicleType) {
        this.guestData_vehicleType = guestData_vehicleType;
    }

    public List<String> getGuestData_modelid() {
        return guestData_modelid;
    }

    public void setGuestData_modelid(List<String> guestData_modelid) {
        this.guestData_modelid = guestData_modelid;
    }

    public List<String> getGuestData_plateNumber() {
        return guestData_plateNumber;
    }

    public void setGuestData_plateNumber(List<String> guestData_plateNumber) {
        this.guestData_plateNumber = guestData_plateNumber;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
