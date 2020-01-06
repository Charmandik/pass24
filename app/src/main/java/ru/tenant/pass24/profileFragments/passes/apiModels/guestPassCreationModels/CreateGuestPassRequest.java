package ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateGuestPassRequest {
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
    private GuestData guestData;

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

    public GuestData getGuestData() {
        return guestData;
    }

    public void setGuestData(GuestData guestData) {
        this.guestData = guestData;
    }
}
