package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy;", "Lpaperparcel/PaperParcelable;", "start", "", "distance", "index", "orderType", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderType;", "(IIILcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderType;)V", "getDistance", "()I", "getIndex", "getOrderType", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderType;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: OrderBy.kt */
public final class OrderBy implements PaperParcelable {
    public static final Creator<OrderBy> CREATOR = PaperParcelOrderBy.CREATOR;
    public static final Companion Companion = new Companion();
    public final int distance;
    final int index;
    public final OrderType orderType;
    public final int start;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy;", "kotlin.jvm.PlatformType", "default", "index", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OrderBy.kt */
    public static final class Companion {
        private Companion() {
        }

        public static OrderBy m9382a() {
            return new OrderBy(0, 0, -1, OrderType.INDEX, 3);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderBy) {
            OrderBy orderBy = (OrderBy) obj;
            if (this.start == orderBy.start) {
                if (this.distance == orderBy.distance) {
                    return (this.index == orderBy.index) && Intrinsics.a(this.orderType, orderBy.orderType);
                }
            }
        }
    }

    public final int hashCode() {
        int i = ((((this.start * 31) + this.distance) * 31) + this.index) * 31;
        OrderType orderType = this.orderType;
        return i + (orderType != null ? orderType.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("OrderBy(start=");
        stringBuilder.append(this.start);
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", orderType=");
        stringBuilder.append(this.orderType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public OrderBy(int i, int i2, int i3, OrderType orderType) {
        Intrinsics.b(orderType, "orderType");
        this.start = i;
        this.distance = i2;
        this.index = i3;
        this.orderType = orderType;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public /* synthetic */ OrderBy(int i, int i2, int i3, OrderType orderType, int i4) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        this(i, i2, i3, orderType);
    }
}
