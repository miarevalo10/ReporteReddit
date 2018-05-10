package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil.Mp4PreviewParams;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelMp4LinkPreviewPresentationModel {
    static final TypeAdapter<Mp4PreviewParams> f20636a = new ParcelableAdapter();
    static final Creator<Mp4LinkPreviewPresentationModel> f20637b = new C18291();

    static class C18291 implements Creator<Mp4LinkPreviewPresentationModel> {
        C18291() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Mp4LinkPreviewPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Mp4LinkPreviewPresentationModel((Mp4PreviewParams) PaperParcelMp4LinkPreviewPresentationModel.f20636a.a(parcel));
        }
    }

    private PaperParcelMp4LinkPreviewPresentationModel() {
    }

    static void writeToParcel(Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel, Parcel parcel, int i) {
        f20636a.a(mp4LinkPreviewPresentationModel.f28435a, parcel, i);
    }
}
