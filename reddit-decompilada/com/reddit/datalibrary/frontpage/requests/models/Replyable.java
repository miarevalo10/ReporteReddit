package com.reddit.datalibrary.frontpage.requests.models;

import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import java.io.Serializable;

public interface Replyable extends Serializable {
    Listing<ReplyableWrapper> getReplies();

    void setReplies(Listing<ReplyableWrapper> listing);
}
