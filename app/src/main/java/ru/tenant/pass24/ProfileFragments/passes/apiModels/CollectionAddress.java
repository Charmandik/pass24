package ru.tenant.pass24.ProfileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CollectionAddress {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;
}
