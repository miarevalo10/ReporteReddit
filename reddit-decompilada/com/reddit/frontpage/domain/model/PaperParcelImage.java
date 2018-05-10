package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelImage {
    static final Creator<Image> CREATOR = new C17881();
    static final TypeAdapter<List<ImageResolution>> IMAGE_RESOLUTION_LIST_ADAPTER = new ListAdapter(IMAGE_RESOLUTION_PARCELABLE_ADAPTER);
    static final TypeAdapter<ImageResolution> IMAGE_RESOLUTION_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<Variants> VARIANTS_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C17881 implements Creator<Image> {
        C17881() {
        }

        public final Image createFromParcel(Parcel parcel) {
            return new Image((List) PaperParcelImage.IMAGE_RESOLUTION_LIST_ADAPTER.a(parcel), (ImageResolution) PaperParcelImage.IMAGE_RESOLUTION_PARCELABLE_ADAPTER.a(parcel), (Variants) PaperParcelImage.VARIANTS_PARCELABLE_ADAPTER.a(parcel));
        }

        public final Image[] newArray(int i) {
            return new Image[i];
        }
    }

    private PaperParcelImage() {
    }

    static void writeToParcel(Image image, Parcel parcel, int i) {
        IMAGE_RESOLUTION_LIST_ADAPTER.a(image.getResolutions(), parcel, i);
        IMAGE_RESOLUTION_PARCELABLE_ADAPTER.a(image.getSource(), parcel, i);
        VARIANTS_PARCELABLE_ADAPTER.a(image.getVariants(), parcel, i);
    }
}
