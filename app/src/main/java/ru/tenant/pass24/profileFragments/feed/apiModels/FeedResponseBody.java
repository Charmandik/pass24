package ru.tenant.pass24.profileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedResponseBody {
    @SerializedName("pagination")
    @Expose
    private FeedPagination pagination;

    @SerializedName("collection")
    @Expose
    private List<FeedCollection> collection;

    public FeedPagination getPagination() {
        return pagination;
    }

    public void setPagination(FeedPagination pagination) {
        this.pagination = pagination;
    }

    public List<FeedCollection> getCollection() {
        return collection;
    }

    public void setCollection(List<FeedCollection> collection) {
        this.collection = collection;
    }
}
