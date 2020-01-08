package ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.tenant.pass24.profileFragments.passes.apiModels.vehiclePassCreationModels.VehicleGuestData;
import ru.tenant.pass24.profileFragments.requests.apiModels.Tenant;

public class InviteResponseBody {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("tenant")
    @Expose
    private Tenant tenant;

    @SerializedName("fromConfidant")
    @Expose
    private boolean fromConfidant;

    @SerializedName("address")
    @Expose
    private InviteAddressInfo address;

    @SerializedName("object")
    @Expose
    private InviteObject object;

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

    @SerializedName("inviteLink")
    @Expose
    private String inviteLink;

    @SerializedName("options")
    @Expose
    private List<InviteOptions> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public boolean isFromConfidant() {
        return fromConfidant;
    }

    public void setFromConfidant(boolean fromConfidant) {
        this.fromConfidant = fromConfidant;
    }

    public InviteAddressInfo getAddress() {
        return address;
    }

    public void setAddress(InviteAddressInfo address) {
        this.address = address;
    }

    public InviteObject getObject() {
        return object;
    }

    public void setObject(InviteObject object) {
        this.object = object;
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

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    public List<InviteOptions> getOptions() {
        return options;
    }

    public void setOptions(List<InviteOptions> options) {
        this.options = options;
    }
}
