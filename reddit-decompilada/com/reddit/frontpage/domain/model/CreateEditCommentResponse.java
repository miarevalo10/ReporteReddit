package com.reddit.frontpage.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/domain/model/CreateEditCommentResponse;", "Lcom/reddit/frontpage/domain/model/ErrorResponse;", "comment", "Lcom/reddit/frontpage/domain/model/Comment;", "errors", "", "", "(Lcom/reddit/frontpage/domain/model/Comment;Ljava/util/List;)V", "getComment", "()Lcom/reddit/frontpage/domain/model/Comment;", "getErrors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public final class CreateEditCommentResponse extends ErrorResponse {
    private final Comment comment;
    private final List<List<String>> errors;

    public static /* synthetic */ CreateEditCommentResponse copy$default(CreateEditCommentResponse createEditCommentResponse, Comment comment, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            comment = createEditCommentResponse.comment;
        }
        if ((i & 2) != 0) {
            list = createEditCommentResponse.errors;
        }
        return createEditCommentResponse.copy(comment, list);
    }

    public final Comment component1() {
        return this.comment;
    }

    public final List<List<String>> component2() {
        return this.errors;
    }

    public final CreateEditCommentResponse copy(Comment comment, List<? extends List<String>> list) {
        Intrinsics.m26847b(list, "errors");
        return new CreateEditCommentResponse(comment, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CreateEditCommentResponse) {
                CreateEditCommentResponse createEditCommentResponse = (CreateEditCommentResponse) obj;
                if (Intrinsics.m26845a(this.comment, createEditCommentResponse.comment) && Intrinsics.m26845a(this.errors, createEditCommentResponse.errors)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Comment comment = this.comment;
        int i = 0;
        int hashCode = (comment != null ? comment.hashCode() : 0) * 31;
        List list = this.errors;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CreateEditCommentResponse(comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(", errors=");
        stringBuilder.append(this.errors);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final Comment getComment() {
        return this.comment;
    }

    public /* synthetic */ CreateEditCommentResponse(Comment comment, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            list = CollectionsKt__CollectionsKt.m26790a();
        }
        this(comment, list);
    }

    public final List<List<String>> getErrors() {
        return this.errors;
    }

    public CreateEditCommentResponse(Comment comment, List<? extends List<String>> list) {
        Intrinsics.m26847b(list, "errors");
        super(list);
        this.comment = comment;
        this.errors = list;
    }
}
