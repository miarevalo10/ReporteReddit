package com.reddit.datalibrary.frontpage.requests.models.v1;

public class EmptyMessageListing extends MessageListing {
    private EmptyListChildren<ReplyableWrapper> data;

    public final ListChildren<ReplyableWrapper> mo3815a() {
        if (this.data == null) {
            this.data = new EmptyListChildren();
        }
        return this.data;
    }
}
