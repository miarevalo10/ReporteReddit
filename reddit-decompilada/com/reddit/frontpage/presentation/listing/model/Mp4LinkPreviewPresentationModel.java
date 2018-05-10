package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtil.Mp4PreviewParams;
import com.reddit.frontpage.presentation.listing.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;", "Lpaperparcel/PaperParcelable;", "params", "Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;", "(Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;)V", "getParams", "()Lcom/reddit/frontpage/presentation/listing/util/LinkPreviewUtil$Mp4PreviewParams;", "component1", "copy", "equals", "", "other", "", "getPreviewUrl", "", "size", "Lcom/reddit/frontpage/presentation/listing/util/Size;", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: LinkPresentationModel.kt */
public final class Mp4LinkPreviewPresentationModel implements PaperParcelable {
    public static final Creator<Mp4LinkPreviewPresentationModel> CREATOR = PaperParcelMp4LinkPreviewPresentationModel.f20637b;
    public static final Companion f28434b = new Companion();
    final Mp4PreviewParams f28435a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/model/Mp4LinkPreviewPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Mp4LinkPreviewPresentationModel) {
                if (Intrinsics.m26845a(this.f28435a, ((Mp4LinkPreviewPresentationModel) obj).f28435a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Mp4PreviewParams mp4PreviewParams = this.f28435a;
        return mp4PreviewParams != null ? mp4PreviewParams.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Mp4LinkPreviewPresentationModel(params=");
        stringBuilder.append(this.f28435a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Mp4LinkPreviewPresentationModel(Mp4PreviewParams mp4PreviewParams) {
        Intrinsics.m26847b(mp4PreviewParams, "params");
        this.f28435a = mp4PreviewParams;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String m29676a(Size size) {
        Intrinsics.m26847b(size, "size");
        LinkPreviewUtil linkPreviewUtil = LinkPreviewUtil.f20852a;
        return LinkPreviewUtil.m23078a(size, this.f28435a);
    }
}
