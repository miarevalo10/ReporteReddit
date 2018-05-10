package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import java.util.ArrayList;

public class More extends BaseThing implements Replyable {
    public ArrayList<String> children;
    public int count;
    String parent_id;

    public Listing<ReplyableWrapper> getReplies() {
        return null;
    }

    public void setReplies(Listing<ReplyableWrapper> listing) {
    }

    public More() {
        super((byte) 0);
    }
}
