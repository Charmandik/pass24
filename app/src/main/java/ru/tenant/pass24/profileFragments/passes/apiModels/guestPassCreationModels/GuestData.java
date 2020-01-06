package ru.tenant.pass24.profileFragments.passes.apiModels.guestPassCreationModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuestData {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
