package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.google.gson.annotations.SerializedName;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;

public class Message extends BaseThing implements Replyable {
    @SerializedName(a = "new")
    public boolean _new;
    public String author;
    private String body;
    public String body_html;
    public String context;
    public String dest;
    private String distinguished;
    private int first_message;
    public String first_message_name;
    public String link_title;
    String parent_id;
    public MessageListing replies;
    public String subject;
    public String subreddit;
    public String subreddit_name_prefixed;
    private boolean was_comment;

    public Message() {
        super((byte) 0);
    }

    public void setReplies(Listing<ReplyableWrapper> listing) {
        this.replies = (MessageListing) listing;
    }

    public /* bridge */ /* synthetic */ Listing getReplies() {
        return this.replies;
    }
}
