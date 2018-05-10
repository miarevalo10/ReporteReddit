package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelVariants {
    static final Creator<Variants> CREATOR = new C18001();
    static final TypeAdapter<Variant> VARIANT_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C18001 implements Creator<Variants> {
        C18001() {
        }

        public final Variants createFromParcel(Parcel parcel) {
            return new Variants((Variant) PaperParcelVariants.VARIANT_PARCELABLE_ADAPTER.a(parcel), (Variant) PaperParcelVariants.VARIANT_PARCELABLE_ADAPTER.a(parcel), (Variant) PaperParcelVariants.VARIANT_PARCELABLE_ADAPTER.a(parcel));
        }

        public final Variants[] newArray(int i) {
            return new Variants[i];
        }
    }

    private PaperParcelVariants() {
    }

    static void writeToParcel(Variants variants, Parcel parcel, int i) {
        VARIANT_PARCELABLE_ADAPTER.a(variants.getObfuscated(), parcel, i);
        VARIANT_PARCELABLE_ADAPTER.a(variants.getGif(), parcel, i);
        VARIANT_PARCELABLE_ADAPTER.a(variants.getMp4(), parcel, i);
    }
}
