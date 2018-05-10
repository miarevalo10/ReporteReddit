package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelImageResolution {
    static final Creator<ImageResolution> CREATOR = new C09601();

    static class C09601 implements Creator<ImageResolution> {
        C09601() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ImageResolution[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ImageResolution((String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt());
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
