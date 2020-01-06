package ru.tenant.pass24.profileFragments.requests.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestResponseBody {
    @SerializedName("pagination")
    @Expose
    private RequestPagination pagination;

    @SerializedName("collection")
    @Expose
    private List<RequestCollection> collection;

    public RequestPagination getPagination() {
        return pagination;
    }

    public void setPagination(RequestPagination pagination) {
        this.pagination = pagination;
    }

    public List<RequestCollection> getCollection() {
        return collection;
    }

    public void setCollection(List<RequestCollection> collection) {
        this.collection = collection;
    }
}
