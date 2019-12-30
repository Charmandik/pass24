package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PassesCollection {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("object")
    @Expose
    private PassesCollectionObject object;

    @SerializedName("tenant")
    @Expose
    private CollectionTenant tenant;

    @SerializedName("fromConfidant")
    @Expose
    private boolean fromConfidant;

    @SerializedName("address")
    @Expose
    private CollectionAddress address;

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
    private CollectionGuestData guestData;

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
    private List<CollectionOptions> options;

    @SerializedName("inviteLink")
    @Expose
    private String inviteLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PassesCollectionObject getObject() {
        return object;
    }

    public void setObject(PassesCollectionObject object) {
        this.object = object;
    }

    public CollectionTenant getTenant() {
        return tenant;
    }

    public void setTenant(CollectionTenant tenant) {
        this.tenant = tenant;
    }

    public boolean isFromConfidant() {
        return fromConfidant;
    }

    public void setFromConfidant(boolean fromConfidant) {
        this.fromConfidant = fromConfidant;
    }

    public CollectionAddress getAddress() {
        return address;
    }

    public void setAddress(CollectionAddress address) {
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

    public CollectionGuestData getGuestData() {
        return guestData;
    }

    public void setGuestData(CollectionGuestData guestData) {
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


    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    public List<CollectionOptions> getOptions() {
        return options;
    }

    public void setOptions(List<CollectionOptions> options) {
        this.options = options;
    }
}
