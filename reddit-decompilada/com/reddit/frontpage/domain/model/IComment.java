package com.reddit.frontpage.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/model/IComment;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "kindWithId", "getKindWithId", "parentKindWithId", "getParentKindWithId", "getInternalCommentReplies", "", "Lcom/reddit/frontpage/domain/model/Comment;", "Lcom/reddit/frontpage/domain/model/MoreComment;", "Lcom/reddit/frontpage/domain/model/LiveComment;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public abstract class IComment {
    public abstract String getId();

    public abstract String getKindWithId();

    public abstract String getParentKindWithId();

    private IComment() {
    }

    public List<IComment> getInternalCommentReplies() {
        return CollectionsKt___CollectionsKt.m41428c(CollectionsKt__CollectionsKt.m26790a());
    }
}
