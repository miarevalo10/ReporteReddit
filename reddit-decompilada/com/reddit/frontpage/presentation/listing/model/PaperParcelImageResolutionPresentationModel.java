package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelImageResolutionPresentationModel {
    static final Creator<ImageResolutionPresentationModel> f20619a = new C18271();

    static class C18271 implements Creator<ImageResolutionPresentationModel> {
        C18271() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ImageResolutionPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ImageResolutionPresentationModel((String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt());
        }
    }

    private PaperParcelImageResolutionPresentationModel() {
    }

    static void writeToParcel(ImageResolutionPresentationModel imageResolutionPresentationModel, Parcel parcel, int i) {
        StaticAdapters.x.a(imageResolutionPresentationModel.f28431a, parcel, i);
        parcel.writeInt(imageResolutionPresentationModel.f28432b);
        parcel.writeInt(imageResolutionPresentationModel.f28433c);
    }
}
