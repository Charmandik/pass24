package ru.tenant.pass24.profileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PassesResponseBody {
    @SerializedName("pagination")
    @Expose
    private PassesPagination pagination;

    @SerializedName("collection")
    @Expose
    private List<PassesCollection> collection;


    public PassesPagination getPagination() {
        return pagination;
    }

    public void setPagination(PassesPagination pagination) {
        this.pagination = pagination;
    }

    public List<PassesCollection> getCollection() {
        return collection;
    }

    public void setCollection(List<PassesCollection> collection) {
        this.collection = collection;
    }
}
