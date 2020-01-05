package ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehiclePassBody {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("object")
    @Expose
    private VehiclePassObject object;

    @SerializedName("tenant")
    @Expose
    private VehiclePassTenant tenant;

    @SerializedName("fromConfidant")
    @Expose
    private boolean fromConfidant;

    @SerializedName("address")
    @Expose
    private VehiclePassAddress address;

    @SerializedName("startsAt")
    @Expose
    private String startsAt;

    @SerializedName("expiresAt")
    @Expose
    private String expiresAt;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("closedAt")
    @Expose
    private String closedAt;

    @SerializedName("durationType")
    @Expose
    private int durationType;

    @SerializedName("guestType")
    @Expose
    private int guestType;

    @SerializedName("guestData")
    @Expose
    private VehicleGuestData guestData;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("options")
    @Expose
    private List<Integer> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehiclePassObject getObject() {
        return object;
    }

    public void setObject(VehiclePassObject object) {
        this.object = object;
    }

    public VehiclePassTenant getTenant() {
        return tenant;
    }

    public void setTenant(VehiclePassTenant tenant) {
        this.tenant = tenant;
    }

    public boolean isFromConfidant() {
        return fromConfidant;
    }

    public void setFromConfidant(boolean fromConfidant) {
        this.fromConfidant = fromConfidant;
    }

    public VehiclePassAddress getAddress() {
        return address;
    }

    public void setAddress(VehiclePassAddress address) {
        this.address = address;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
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

    public VehicleGuestData getGuestData() {
        return guestData;
    }

    public void setGuestData(VehicleGuestData guestData) {
        this.guestData = guestData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
