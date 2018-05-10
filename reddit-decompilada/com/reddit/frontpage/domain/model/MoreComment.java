package com.reddit.frontpage.domain.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/domain/model/MoreComment;", "Lcom/reddit/frontpage/domain/model/IComment;", "id", "", "kindWithId", "parentKindWithId", "children", "", "count", "", "depth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)V", "getChildren", "()Ljava/util/List;", "getCount", "()I", "getDepth", "getId", "()Ljava/lang/String;", "getKindWithId", "getParentKindWithId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public final class MoreComment extends IComment {
    private final List<String> children;
    private final int count;
    private final int depth;
    private final String id;
    @Json(a = "name")
    private final String kindWithId;
    @Json(a = "parent_id")
    private final String parentKindWithId;

    public static /* synthetic */ MoreComment copy$default(MoreComment moreComment, String str, String str2, String str3, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = moreComment.getId();
        }
        if ((i3 & 2) != 0) {
            str2 = moreComment.getKindWithId();
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = moreComment.getParentKindWithId();
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            list = moreComment.children;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            i = moreComment.count;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = moreComment.depth;
        }
        return moreComment.copy(str, str4, str5, list2, i4, i2);
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getKindWithId();
    }

    public final String component3() {
        return getParentKindWithId();
    }

    public final List<String> component4() {
        return this.children;
    }

    public final int component5() {
        return this.count;
    }

    public final int component6() {
        return this.depth;
    }

    public final MoreComment copy(String str, String str2, String str3, List<String> list, int i, int i2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "kindWithId");
        Intrinsics.m26847b(str3, "parentKindWithId");
        Intrinsics.m26847b(list, "children");
        return new MoreComment(str, str2, str3, list, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MoreComment) {
            MoreComment moreComment = (MoreComment) obj;
            if (Intrinsics.m26845a(getId(), moreComment.getId()) && Intrinsics.m26845a(getKindWithId(), moreComment.getKindWithId()) && Intrinsics.m26845a(getParentKindWithId(), moreComment.getParentKindWithId()) && Intrinsics.m26845a(this.children, moreComment.children)) {
                if (this.count == moreComment.count) {
                    if (this.depth == moreComment.depth) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String id = getId();
        int i = 0;
        int hashCode = (id != null ? id.hashCode() : 0) * 31;
        String kindWithId = getKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = getParentKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        List list = this.children;
        if (list != null) {
            i = list.hashCode();
        }
        return ((((hashCode + i) * 31) + this.count) * 31) + this.depth;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MoreComment(id=");
        stringBuilder.append(getId());
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", parentKindWithId=");
        stringBuilder.append(getParentKindWithId());
        stringBuilder.append(", children=");
        stringBuilder.append(this.children);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", depth=");
        stringBuilder.append(this.depth);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getId() {
        return this.id;
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final String getParentKindWithId() {
        return this.parentKindWithId;
    }

    public final List<String> getChildren() {
        return this.children;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getDepth() {
        return this.depth;
    }

    public MoreComment(String str, String str2, String str3, List<String> list, int i, int i2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "kindWithId");
        Intrinsics.m26847b(str3, "parentKindWithId");
        Intrinsics.m26847b(list, "children");
        super();
        this.id = str;
        this.kindWithId = str2;
        this.parentKindWithId = str3;
        this.children = list;
        this.count = i;
        this.depth = i2;
    }
}
