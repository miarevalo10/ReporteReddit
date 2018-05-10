package com.reddit.frontpage.presentation.listing.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil.Mp4PreviewParams;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelLinkPreviewUtil_Mp4PreviewParams {
    static final TypeAdapter<ImageResolution> f20853a = new ParcelableAdapter();
    static final TypeAdapter<List<ImageResolution>> f20854b = new ListAdapter(f20853a);
    static final Creator<Mp4PreviewParams> f20855c = new C18511();

    static class C18511 implements Creator<Mp4PreviewParams> {
        C18511() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Mp4PreviewParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Mp4PreviewParams(parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel), parcel.readInt() == 1, (List) PaperParcelLinkPreviewUtil_Mp4PreviewParams.f20854b.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel));
        }
    }

    private PaperParcelLinkPreviewUtil_Mp4PreviewParams() {
    }

    static void writeToParcel(Mp4PreviewParams mp4PreviewParams, Parcel parcel, int i) {
        parcel.writeInt(mp4PreviewParams.f28522a);
        StaticAdapters.x.a(mp4PreviewParams.f28523b, parcel, i);
        parcel.writeInt(mp4PreviewParams.f28524c);
        f20854b.a(mp4PreviewParams.f28525d, parcel, i);
        StaticAdapters.x.a(mp4PreviewParams.f28526e, parcel, i);
        parcel.writeInt(mp4PreviewParams.f28527f);
        StaticAdapters.x.a(mp4PreviewParams.f28528g, parcel, i);
    }
}
