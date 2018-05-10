package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.SerializedName;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;

public class Notification extends BaseThing implements Replyable {
    @SerializedName(a = "new")
    public boolean _new;
    public String body;
    public String context;
    long created;
    String link_id;
    String subject;
    public String subreddit;
    String subreddit_name_prefixed;
    String title;
    String type;

    public Listing<ReplyableWrapper> getReplies() {
        return null;
    }

    public void setReplies(Listing<ReplyableWrapper> listing) {
    }

    public Notification() {
        super((byte) 0);
    }
}
