package com.reddit.frontpage.domain.model;

import com.reddit.datalibrary.frontpage.data.model.RedditModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/domain/model/ILink;", "Lcom/reddit/datalibrary/frontpage/data/model/RedditModel;", "()V", "createdUtc", "", "getCreatedUtc", "()J", "id", "", "getId", "()Ljava/lang/String;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/domain/model/LiveUpdateEvent;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Link.kt */
public abstract class ILink implements RedditModel {
    public abstract long getCreatedUtc();

    public abstract String getId();

    private ILink() {
    }
}
