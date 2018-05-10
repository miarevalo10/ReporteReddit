package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.ImageResolution;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelImageLinkPreviewPresentationModel {
    static final TypeAdapter<ImageResolution> f20616a = new ParcelableAdapter();
    static final TypeAdapter<List<ImageResolution>> f20617b = new ListAdapter(f20616a);
    static final Creator<ImageLinkPreviewPresentationModel> f20618c = new C18261();

    static class C18261 implements Creator<ImageLinkPreviewPresentationModel> {
        C18261() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ImageLinkPreviewPresentationModel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ImageLinkPreviewPresentationModel((List) PaperParcelImageLinkPreviewPresentationModel.f20617b.a(parcel));
        }
    }

    private PaperParcelImageLinkPreviewPresentationModel() {
    }

    static void writeToParcel(ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel, Parcel parcel, int i) {
        f20617b.a(imageLinkPreviewPresentationModel.f28429a, parcel, i);
    }
}
