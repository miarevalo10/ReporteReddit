package com.reddit.frontpage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/domain/model/LiveCommentResponse;", "", "type", "", "payload", "Lcom/reddit/frontpage/domain/model/LiveComment;", "(Ljava/lang/String;Lcom/reddit/frontpage/domain/model/LiveComment;)V", "getPayload", "()Lcom/reddit/frontpage/domain/model/LiveComment;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public final class LiveCommentResponse {
    private final LiveComment payload;
    private final String type;

    public static /* synthetic */ LiveCommentResponse copy$default(LiveCommentResponse liveCommentResponse, String str, LiveComment liveComment, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveCommentResponse.type;
        }
        if ((i & 2) != 0) {
            liveComment = liveCommentResponse.payload;
        }
        return liveCommentResponse.copy(str, liveComment);
    }

    public final String component1() {
        return this.type;
    }

    public final LiveComment component2() {
        return this.payload;
    }

    public final LiveCommentResponse copy(String str, LiveComment liveComment) {
        Intrinsics.m26847b(str, "type");
        Intrinsics.m26847b(liveComment, "payload");
        return new LiveCommentResponse(str, liveComment);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LiveCommentResponse) {
                LiveCommentResponse liveCommentResponse = (LiveCommentResponse) obj;
                if (Intrinsics.m26845a(this.type, liveCommentResponse.type) && Intrinsics.m26845a(this.payload, liveCommentResponse.payload)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        LiveComment liveComment = this.payload;
        if (liveComment != null) {
            i = liveComment.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LiveCommentResponse(type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", payload=");
        stringBuilder.append(this.payload);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LiveCommentResponse(String str, LiveComment liveComment) {
        Intrinsics.m26847b(str, "type");
        Intrinsics.m26847b(liveComment, "payload");
        this.type = str;
        this.payload = liveComment;
    }

    public final String getType() {
        return this.type;
    }

    public final LiveComment getPayload() {
        return this.payload;
    }
}
