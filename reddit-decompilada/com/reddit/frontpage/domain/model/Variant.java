package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/domain/model/Variant;", "Lpaperparcel/PaperParcelable;", "resolutions", "", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "source", "(Ljava/util/List;Lcom/reddit/frontpage/domain/model/ImageResolution;)V", "getResolutions", "()Ljava/util/List;", "getSource", "()Lcom/reddit/frontpage/domain/model/ImageResolution;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class Variant implements PaperParcelable {
    public static final Creator<Variant> CREATOR = PaperParcelVariant.CREATOR;
    public static final Companion Companion = new Companion();
    private final List<ImageResolution> resolutions;
    private final ImageResolution source;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Variant$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Variant;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Variant copy$default(Variant variant, List list, ImageResolution imageResolution, int i, Object obj) {
        if ((i & 1) != 0) {
            list = variant.resolutions;
        }
        if ((i & 2) != 0) {
            imageResolution = variant.source;
        }
        return variant.copy(list, imageResolution);
    }

    public final List<ImageResolution> component1() {
        return this.resolutions;
    }

    public final ImageResolution component2() {
        return this.source;
    }

    public final Variant copy(List<ImageResolution> list, ImageResolution imageResolution) {
        Intrinsics.m26847b(list, "resolutions");
        Intrinsics.m26847b(imageResolution, "source");
        return new Variant(list, imageResolution);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Variant) {
                Variant variant = (Variant) obj;
                if (Intrinsics.m26845a(this.resolutions, variant.resolutions) && Intrinsics.m26845a(this.source, variant.source)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.resolutions;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ImageResolution imageResolution = this.source;
        if (imageResolution != null) {
            i = imageResolution.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Variant(resolutions=");
        stringBuilder.append(this.resolutions);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Variant(List<ImageResolution> list, ImageResolution imageResolution) {
        Intrinsics.m26847b(list, "resolutions");
        Intrinsics.m26847b(imageResolution, "source");
        this.resolutions = list;
        this.source = imageResolution;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final List<ImageResolution> getResolutions() {
        return this.resolutions;
    }

    public final ImageResolution getSource() {
        return this.source;
    }
}
