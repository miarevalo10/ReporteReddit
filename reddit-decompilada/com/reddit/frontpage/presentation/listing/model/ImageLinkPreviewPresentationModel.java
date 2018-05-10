package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.presentation.listing.util.LinkPreviewUtilKt;
import com.reddit.frontpage.presentation.listing.util.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "Lpaperparcel/PaperParcelable;", "resolutions", "", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "(Ljava/util/List;)V", "getResolutions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "getPreview", "size", "Lcom/reddit/frontpage/presentation/listing/util/Size;", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: LinkPresentationModel.kt */
public final class ImageLinkPreviewPresentationModel implements PaperParcelable {
    public static final Creator<ImageLinkPreviewPresentationModel> CREATOR = PaperParcelImageLinkPreviewPresentationModel.f20618c;
    public static final Companion f28428b = new Companion();
    public final List<ImageResolution> f28429a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
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
            if (obj instanceof ImageLinkPreviewPresentationModel) {
                if (Intrinsics.m26845a(this.f28429a, ((ImageLinkPreviewPresentationModel) obj).f28429a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.f28429a;
        return list != null ? list.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImageLinkPreviewPresentationModel(resolutions=");
        stringBuilder.append(this.f28429a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ImageLinkPreviewPresentationModel(List<ImageResolution> list) {
        Intrinsics.m26847b(list, "resolutions");
        this.f28429a = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final ImageResolution m29675a(Size size) {
        Intrinsics.m26847b(size, "size");
        return LinkPreviewUtilKt.m23079a(this.f28429a, size);
    }
}
