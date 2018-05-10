package com.reddit.frontpage.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/domain/model/CommentResponse;", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "comments", "", "Lcom/reddit/frontpage/domain/model/IComment;", "(Lcom/reddit/frontpage/domain/model/Link;Ljava/util/List;)V", "getComments", "()Ljava/util/List;", "getLink", "()Lcom/reddit/frontpage/domain/model/Link;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public final class CommentResponse {
    private final List<IComment> comments;
    private final Link link;

    public static /* synthetic */ CommentResponse copy$default(CommentResponse commentResponse, Link link, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            link = commentResponse.link;
        }
        if ((i & 2) != 0) {
            list = commentResponse.comments;
        }
        return commentResponse.copy(link, list);
    }

    public final Link component1() {
        return this.link;
    }

    public final List<IComment> component2() {
        return this.comments;
    }

    public final CommentResponse copy(Link link, List<? extends IComment> list) {
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(list, "comments");
        return new CommentResponse(link, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CommentResponse) {
                CommentResponse commentResponse = (CommentResponse) obj;
                if (Intrinsics.m26845a(this.link, commentResponse.link) && Intrinsics.m26845a(this.comments, commentResponse.comments)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Link link = this.link;
        int i = 0;
        int hashCode = (link != null ? link.hashCode() : 0) * 31;
        List list = this.comments;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommentResponse(link=");
        stringBuilder.append(this.link);
        stringBuilder.append(", comments=");
        stringBuilder.append(this.comments);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CommentResponse(Link link, List<? extends IComment> list) {
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(list, "comments");
        this.link = link;
        this.comments = list;
    }

    public final Link getLink() {
        return this.link;
    }

    public final List<IComment> getComments() {
        return this.comments;
    }
}
