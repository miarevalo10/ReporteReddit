package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/domain/model/Variants;", "Lpaperparcel/PaperParcelable;", "obfuscated", "Lcom/reddit/frontpage/domain/model/Variant;", "gif", "mp4", "(Lcom/reddit/frontpage/domain/model/Variant;Lcom/reddit/frontpage/domain/model/Variant;Lcom/reddit/frontpage/domain/model/Variant;)V", "getGif", "()Lcom/reddit/frontpage/domain/model/Variant;", "getMp4", "getObfuscated", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class Variants implements PaperParcelable {
    public static final Creator<Variants> CREATOR = PaperParcelVariants.CREATOR;
    public static final Companion Companion = new Companion();
    private final Variant gif;
    private final Variant mp4;
    private final Variant obfuscated;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Variants$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Variants;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public Variants() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Variants copy$default(Variants variants, Variant variant, Variant variant2, Variant variant3, int i, Object obj) {
        if ((i & 1) != 0) {
            variant = variants.obfuscated;
        }
        if ((i & 2) != 0) {
            variant2 = variants.gif;
        }
        if ((i & 4) != 0) {
            variant3 = variants.mp4;
        }
        return variants.copy(variant, variant2, variant3);
    }

    public final Variant component1() {
        return this.obfuscated;
    }

    public final Variant component2() {
        return this.gif;
    }

    public final Variant component3() {
        return this.mp4;
    }

    public final Variants copy(Variant variant, Variant variant2, Variant variant3) {
        return new Variants(variant, variant2, variant3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Variants) {
                Variants variants = (Variants) obj;
                if (Intrinsics.m26845a(this.obfuscated, variants.obfuscated) && Intrinsics.m26845a(this.gif, variants.gif) && Intrinsics.m26845a(this.mp4, variants.mp4)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Variant variant = this.obfuscated;
        int i = 0;
        int hashCode = (variant != null ? variant.hashCode() : 0) * 31;
        Variant variant2 = this.gif;
        hashCode = (hashCode + (variant2 != null ? variant2.hashCode() : 0)) * 31;
        variant2 = this.mp4;
        if (variant2 != null) {
            i = variant2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Variants(obfuscated=");
        stringBuilder.append(this.obfuscated);
        stringBuilder.append(", gif=");
        stringBuilder.append(this.gif);
        stringBuilder.append(", mp4=");
        stringBuilder.append(this.mp4);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Variants(Variant variant, Variant variant2, Variant variant3) {
        this.obfuscated = variant;
        this.gif = variant2;
        this.mp4 = variant3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final Variant getObfuscated() {
        return this.obfuscated;
    }

    public final Variant getGif() {
        return this.gif;
    }

    public /* synthetic */ Variants(Variant variant, Variant variant2, Variant variant3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != null) {
            variant = null;
        }
        if ((i & 2) != null) {
            variant2 = null;
        }
        if ((i & 4) != 0) {
            variant3 = null;
        }
        this(variant, variant2, variant3);
    }

    public final Variant getMp4() {
        return this.mp4;
    }
}
