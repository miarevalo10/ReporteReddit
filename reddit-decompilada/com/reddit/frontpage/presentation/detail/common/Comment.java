package com.reddit.frontpage.presentation.detail.common;

import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@PaperParcel
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/common/Comment;", "Lcom/reddit/frontpage/presentation/detail/common/Editable;", "Lcom/reddit/frontpage/domain/model/Comment;", "model", "(Lcom/reddit/frontpage/domain/model/Comment;)V", "getModel", "()Lcom/reddit/frontpage/domain/model/Comment;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Editable.kt */
public final class Comment extends Editable<com.reddit.frontpage.domain.model.Comment> {
    public static final Creator<Comment> CREATOR = PaperParcelComment.f20506b;
    public static final Companion f33841b = new Companion();
    final com.reddit.frontpage.domain.model.Comment f33842a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/common/Comment$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/detail/common/Comment;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Editable.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public Comment(com.reddit.frontpage.domain.model.Comment comment) {
        Intrinsics.m26847b(comment, "model");
        super();
        this.f33842a = comment;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Comment(model=");
        stringBuilder.append(this.f33842a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        com.reddit.frontpage.domain.model.Comment comment = this.f33842a;
        return comment != null ? comment.hashCode() : 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Comment) {
                if (Intrinsics.m26845a(this.f33842a, ((Comment) obj).f33842a) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
