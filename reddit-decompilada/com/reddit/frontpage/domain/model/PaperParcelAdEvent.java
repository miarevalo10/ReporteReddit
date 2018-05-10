package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelAdEvent {
    static final Creator<AdEvent> CREATOR = new C17861();

    static class C17861 implements Creator<AdEvent> {
        C17861() {
        }

        public final AdEvent createFromParcel(Parcel parcel) {
            return new AdEvent((String) StaticAdapters.x.a(parcel), parcel.readInt());
        }

        public final AdEvent[] newArray(int i) {
            return new AdEvent[i];
        }
    }

    private PaperParcelAdEvent() {
    }

    static void writeToParcel(AdEvent adEvent, Parcel parcel, int i) {
        StaticAdapters.x.a(adEvent.getUrl(), parcel, i);
        parcel.writeInt(adEvent.getType());
    }
}
