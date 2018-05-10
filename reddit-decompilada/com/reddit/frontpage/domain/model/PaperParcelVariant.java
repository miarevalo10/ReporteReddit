package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelVariant {
    static final Creator<Variant> CREATOR = new C17991();
    static final TypeAdapter<List<ImageResolution>> IMAGE_RESOLUTION_LIST_ADAPTER = new ListAdapter(IMAGE_RESOLUTION_PARCELABLE_ADAPTER);
    static final TypeAdapter<ImageResolution> IMAGE_RESOLUTION_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C17991 implements Creator<Variant> {
        C17991() {
        }

        public final Variant createFromParcel(Parcel parcel) {
            return new Variant((List) PaperParcelVariant.IMAGE_RESOLUTION_LIST_ADAPTER.a(parcel), (ImageResolution) PaperParcelVariant.IMAGE_RESOLUTION_PARCELABLE_ADAPTER.a(parcel));
        }

        public final Variant[] newArray(int i) {
            return new Variant[i];
        }
    }

    private PaperParcelVariant() {
    }

    static void writeToParcel(Variant variant, Parcel parcel, int i) {
        IMAGE_RESOLUTION_LIST_ADAPTER.a(variant.getResolutions(), parcel, i);
        IMAGE_RESOLUTION_PARCELABLE_ADAPTER.a(variant.getSource(), parcel, i);
    }
}
