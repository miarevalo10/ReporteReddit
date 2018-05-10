package com.reddit.datalibrary.frontpage.data.provider;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/ListingRequestParams;", "", "after", "", "sortType", "", "sortTimeFrame", "adDistance", "(Ljava/lang/String;IILjava/lang/String;)V", "getAdDistance", "()Ljava/lang/String;", "getAfter", "getSortTimeFrame", "()I", "getSortType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingRequestParams.kt */
public final class ListingRequestParams {
    public static final Companion f10790e = new Companion();
    public final String f10791a;
    public final int f10792b;
    public final int f10793c;
    public final String f10794d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/ListingRequestParams$Companion;", "", "()V", "AD_DISTANCE", "", "AFTER", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListingRequestParams.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListingRequestParams) {
            ListingRequestParams listingRequestParams = (ListingRequestParams) obj;
            if (Intrinsics.a(this.f10791a, listingRequestParams.f10791a)) {
                if (this.f10792b == listingRequestParams.f10792b) {
                    return (this.f10793c == listingRequestParams.f10793c) && Intrinsics.a(this.f10794d, listingRequestParams.f10794d);
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.f10791a;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.f10792b) * 31) + this.f10793c) * 31;
        String str2 = this.f10794d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ListingRequestParams(after=");
        stringBuilder.append(this.f10791a);
        stringBuilder.append(", sortType=");
        stringBuilder.append(this.f10792b);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.f10793c);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.f10794d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ListingRequestParams(String str, int i, int i2, String str2) {
        this.f10791a = str;
        this.f10792b = i;
        this.f10793c = i2;
        this.f10794d = str2;
    }
}
