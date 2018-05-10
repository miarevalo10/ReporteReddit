package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/domain/model/Image;", "Lpaperparcel/PaperParcelable;", "resolutions", "", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "source", "variants", "Lcom/reddit/frontpage/domain/model/Variants;", "(Ljava/util/List;Lcom/reddit/frontpage/domain/model/ImageResolution;Lcom/reddit/frontpage/domain/model/Variants;)V", "getResolutions", "()Ljava/util/List;", "getSource", "()Lcom/reddit/frontpage/domain/model/ImageResolution;", "getVariants", "()Lcom/reddit/frontpage/domain/model/Variants;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class Image implements PaperParcelable {
    public static final Creator<Image> CREATOR = PaperParcelImage.CREATOR;
    public static final Companion Companion = new Companion();
    private final List<ImageResolution> resolutions;
    private final ImageResolution source;
    private final Variants variants;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Image$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Image;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Image copy$default(Image image, List list, ImageResolution imageResolution, Variants variants, int i, Object obj) {
        if ((i & 1) != 0) {
            list = image.resolutions;
        }
        if ((i & 2) != 0) {
            imageResolution = image.source;
        }
        if ((i & 4) != 0) {
            variants = image.variants;
        }
        return image.copy(list, imageResolution, variants);
    }

    public final List<ImageResolution> component1() {
        return this.resolutions;
    }

    public final ImageResolution component2() {
        return this.source;
    }

    public final Variants component3() {
        return this.variants;
    }

    public final Image copy(List<ImageResolution> list, ImageResolution imageResolution, Variants variants) {
        Intrinsics.m26847b(list, "resolutions");
        Intrinsics.m26847b(imageResolution, "source");
        Intrinsics.m26847b(variants, "variants");
        return new Image(list, imageResolution, variants);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Image) {
                Image image = (Image) obj;
                if (Intrinsics.m26845a(this.resolutions, image.resolutions) && Intrinsics.m26845a(this.source, image.source) && Intrinsics.m26845a(this.variants, image.variants)) {
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
        hashCode = (hashCode + (imageResolution != null ? imageResolution.hashCode() : 0)) * 31;
        Variants variants = this.variants;
        if (variants != null) {
            i = variants.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Image(resolutions=");
        stringBuilder.append(this.resolutions);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", variants=");
        stringBuilder.append(this.variants);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Image(List<ImageResolution> list, ImageResolution imageResolution, Variants variants) {
        Intrinsics.m26847b(list, "resolutions");
        Intrinsics.m26847b(imageResolution, "source");
        Intrinsics.m26847b(variants, "variants");
        this.resolutions = list;
        this.source = imageResolution;
        this.variants = variants;
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

    public final Variants getVariants() {
        return this.variants;
    }
}
