package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelImageResolution {
    static final Creator<ImageResolution> CREATOR = new C17891();

    static class C17891 implements Creator<ImageResolution> {
        C17891() {
        }

        public final ImageResolution createFromParcel(Parcel parcel) {
            return new ImageResolution((String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt());
        }

        public final ImageResolution[] newArray(int i) {
            return new ImageResolution[i];
        }
    }

    private PaperParcelImageResolution() {
    }

    static void writeToParcel(ImageResolution imageResolution, Parcel parcel, int i) {
        StaticAdapters.x.a(imageResolution.getUrl(), parcel, i);
        parcel.writeInt(imageResolution.getWidth());
        parcel.writeInt(imageResolution.getHeight());
    }
}
