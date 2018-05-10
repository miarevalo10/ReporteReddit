package com.reddit.datalibrary.frontpage.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "T", "", "children", "", "after", "", "before", "adDistance", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdDistance", "()Ljava/lang/String;", "getAfter", "getBefore", "getChildren", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Listing.kt */
public final class Listing<T> {
    private final String adDistance;
    private final String after;
    private final String before;
    private final List<T> children;

    public static /* synthetic */ Listing copy$default(Listing listing, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listing.children;
        }
        if ((i & 2) != 0) {
            str = listing.after;
        }
        if ((i & 4) != 0) {
            str2 = listing.before;
        }
        if ((i & 8) != 0) {
            str3 = listing.adDistance;
        }
        return listing.copy(list, str, str2, str3);
    }

    public final List<T> component1() {
        return this.children;
    }

    public final String component2() {
        return this.after;
    }

    public final String component3() {
        return this.before;
    }

    public final String component4() {
        return this.adDistance;
    }

    public final Listing<T> copy(List<? extends T> list, String str, String str2, String str3) {
        Intrinsics.b(list, "children");
        return new Listing(list, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Listing) {
                Listing listing = (Listing) obj;
                if (Intrinsics.a(this.children, listing.children) && Intrinsics.a(this.after, listing.after) && Intrinsics.a(this.before, listing.before) && Intrinsics.a(this.adDistance, listing.adDistance)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.children;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.after;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.before;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.adDistance;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Listing(children=");
        stringBuilder.append(this.children);
        stringBuilder.append(", after=");
        stringBuilder.append(this.after);
        stringBuilder.append(", before=");
        stringBuilder.append(this.before);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.adDistance);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Listing(List<? extends T> list, String str, String str2, String str3) {
        Intrinsics.b(list, "children");
        this.children = list;
        this.after = str;
        this.before = str2;
        this.adDistance = str3;
    }

    public final List<T> getChildren() {
        return this.children;
    }

    public final String getAfter() {
        return this.after;
    }

    public final String getBefore() {
        return this.before;
    }

    public /* synthetic */ Listing(List list, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != null) {
            str = null;
        }
        if ((i & 4) != null) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        this(list, str, str2, str3);
    }

    public final String getAdDistance() {
        return this.adDistance;
    }
}
