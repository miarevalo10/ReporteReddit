package com.reddit.datalibrary.frontpage.requests.models.v1;

import java.io.Serializable;

public class MessageWrapper extends ReplyableWrapper<Message> implements Serializable {
    public final String mo3814a() {
        return ((Message) getData()).parent_id;
    }
}
