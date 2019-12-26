package ru.tenant.pass24.ProfileFragments.passes.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class PassesPagination {
    @SerializedName("prev")
    @Expose
    private int prev;

    @SerializedName("next")
    @Expose
    private int next;

    @SerializedName("perPage")
    @Expose
    private int perPage;

    @SerializedName("current")
    @Expose
    private int current;

    @SerializedName("last")
    @Expose
    private int last;

    @SerializedName("total")
    @Expose
    private int total;

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
