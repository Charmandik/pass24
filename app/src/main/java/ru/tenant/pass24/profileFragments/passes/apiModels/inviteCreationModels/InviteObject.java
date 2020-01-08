package ru.tenant.pass24.profileFragments.passes.apiModels.inviteCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InviteObject {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("settings")
    @Expose
    private InviteObject settings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public InviteObject getSettings() {
        return settings;
    }

    public void setSettings(InviteObject settings) {
        this.settings = settings;
    }
}
