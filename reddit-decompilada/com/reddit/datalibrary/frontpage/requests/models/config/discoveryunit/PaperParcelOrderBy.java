package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.TypeAdapter;
import paperparcel.internal.EnumAdapter;

final class PaperParcelOrderBy {
    static final Creator<OrderBy> CREATOR = new C09531();
    static final TypeAdapter<OrderType> ORDER_TYPE_ENUM_ADAPTER = new EnumAdapter(OrderType.class);

    static class C09531 implements Creator<OrderBy> {
        C09531() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new OrderBy[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OrderBy(parcel.readInt(), parcel.readInt(), parcel.readInt(), (OrderType) PaperParcelOrderBy.ORDER_TYPE_ENUM_ADAPTER.a(parcel));
        }
    }

    private PaperParcelOrderBy() {
    }

    static void writeToParcel(OrderBy orderBy, Parcel parcel, int i) {
        parcel.writeInt(orderBy.start);
        parcel.writeInt(orderBy.distance);
        parcel.writeInt(orderBy.index);
        ORDER_TYPE_ENUM_ADAPTER.a(orderBy.orderType, parcel, i);
    }
}
