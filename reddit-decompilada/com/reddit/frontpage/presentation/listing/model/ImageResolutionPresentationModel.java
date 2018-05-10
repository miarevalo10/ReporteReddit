package com.reddit.frontpage.presentation.listing.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;", "Lpaperparcel/PaperParcelable;", "url", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: LinkPresentationModel.kt */
public final class ImageResolutionPresentationModel implements PaperParcelable {
    public static final Creator<ImageResolutionPresentationModel> CREATOR = PaperParcelImageResolutionPresentationModel.f20619a;
    public static final Companion f28430d = new Companion();
    final String f28431a;
    final int f28432b;
    final int f28433c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/model/ImageResolutionPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageResolutionPresentationModel) {
            ImageResolutionPresentationModel imageResolutionPresentationModel = (ImageResolutionPresentationModel) obj;
            if (Intrinsics.m26845a(this.f28431a, imageResolutionPresentationModel.f28431a)) {
                if (this.f28432b == imageResolutionPresentationModel.f28432b) {
                    if (this.f28433c == imageResolutionPresentationModel.f28433c) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f28431a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.f28432b) * 31) + this.f28433c;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImageResolutionPresentationModel(url=");
        stringBuilder.append(this.f28431a);
        stringBuilder.append(", width=");
        stringBuilder.append(this.f28432b);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f28433c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ImageResolutionPresentationModel(String str, int i, int i2) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        this.f28431a = str;
        this.f28432b = i;
        this.f28433c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }
}
