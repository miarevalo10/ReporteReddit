package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelOutboundLink {
    static final Creator<OutboundLink> CREATOR = new C17931();

    static class C17931 implements Creator<OutboundLink> {
        C17931() {
        }

        public final OutboundLink createFromParcel(Parcel parcel) {
            return new OutboundLink((String) StaticAdapters.x.a(parcel), (Long) Utils.a(parcel, StaticAdapters.e), (Long) Utils.a(parcel, StaticAdapters.e));
        }

        public final OutboundLink[] newArray(int i) {
            return new OutboundLink[i];
        }
    }

    private PaperParcelOutboundLink() {
    }

    static void writeToParcel(OutboundLink outboundLink, Parcel parcel, int i) {
        StaticAdapters.x.a(outboundLink.getUrl(), parcel, i);
        Utils.a(outboundLink.getExpiration(), parcel, i, StaticAdapters.e);
        Utils.a(outboundLink.getCreated(), parcel, i, StaticAdapters.e);
    }
}
