package ru.tenant.pass24.profileFragments.trustedPeople.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfidanceResponseBody {
    @SerializedName("pagination")
    @Expose
    private ConfidancePagination pagination;

    @SerializedName("collection")
    @Expose
    private List<ConfidanceCollection> collection;

    public ConfidancePagination getPagination() {
        return pagination;
    }

    public void setPagination(ConfidancePagination pagination) {
        this.pagination = pagination;
    }

    public List<ConfidanceCollection> getCollection() {
        return collection;
    }

    public void setCollection(List<ConfidanceCollection> collection) {
        this.collection = collection;
    }
}
