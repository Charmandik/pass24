package ru.tenant.pass24.profileFragments.VehicleBrand.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleBrandResponseBody {

    @SerializedName("pagination")
    @Expose
    private VehicleBrandPagination pagination;

    @SerializedName("collection")
    @Expose
    private List<VehicleBrandCollection> collection;

    public VehicleBrandPagination getPagination() {
        return pagination;
    }

    public void setPagination(VehicleBrandPagination pagination) {
        this.pagination = pagination;
    }

    public List<VehicleBrandCollection> getCollection() {
        return collection;
    }

    public void setCollection(List<VehicleBrandCollection> collection) {
        this.collection = collection;
    }
}
