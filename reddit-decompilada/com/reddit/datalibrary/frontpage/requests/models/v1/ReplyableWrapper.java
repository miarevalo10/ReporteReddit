package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.datalibrary.frontpage.requests.models.Replyable;

public abstract class ReplyableWrapper<T extends Thing & Replyable> extends ThingWrapper<T> {
    public abstract String mo3814a();

    public final String m16425b() {
        return getData().getId();
    }

    public String getName() {
        return getData().getName();
    }
}
