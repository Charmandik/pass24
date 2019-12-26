package ru.tenant.pass24.ProfileFragments.feed.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedCollection {
    @SerializedName("subjectType")
    @Expose
    private String subjectType;

    @SerializedName("subject")
    @Expose
    private FeedCollectionSubject subject;

    @SerializedName("happenedAt")
    @Expose
    private String happenedAt;

    @SerializedName("initiatedBy")
    @Expose
    private FeedCollectionInitiatedBy initiatedBy;

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("eventData")
    @Expose
    private FeedCollectionEventData eventData;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("message")
    @Expose
    private String message;

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public FeedCollectionSubject getSubject() {
        return subject;
    }

    public void setSubject(FeedCollectionSubject subject) {
        this.subject = subject;
    }

    public String getHappenedAt() {
        return happenedAt;
    }

    public void setHappenedAt(String happenedAt) {
        this.happenedAt = happenedAt;
    }

    public FeedCollectionInitiatedBy getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(FeedCollectionInitiatedBy initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FeedCollectionEventData getEventData() {
        return eventData;
    }

    public void setEventData(FeedCollectionEventData eventData) {
        this.eventData = eventData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
