package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcelable.Creator;
import com.raizlabs.android.dbflow.structure.BaseModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.parceler.Parcel;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@PaperParcel
@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B#\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "Ljava/io/Serializable;", "Lpaperparcel/PaperParcelable;", "resolution", "Lcom/reddit/frontpage/domain/model/ImageResolution;", "(Lcom/reddit/frontpage/domain/model/ImageResolution;)V", "url", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "setHeight", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@Parcel
/* compiled from: ImageResolution.kt */
public final class ImageResolution extends BaseModel implements Serializable, PaperParcelable {
    public static final Creator<ImageResolution> CREATOR = PaperParcelImageResolution.CREATOR;
    public static final Companion Companion = new Companion();
    private int height;
    private String url;
    private int width;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ImageResolution.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ImageResolution() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ ImageResolution copy$default(ImageResolution imageResolution, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageResolution.url;
        }
        if ((i3 & 2) != 0) {
            i = imageResolution.width;
        }
        if ((i3 & 4) != 0) {
            i2 = imageResolution.height;
        }
        return imageResolution.copy(str, i, i2);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final ImageResolution copy(String str, int i, int i2) {
        Intrinsics.b(str, UpdateFragment.FRAGMENT_URL);
        return new ImageResolution(str, i, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageResolution) {
            ImageResolution imageResolution = (ImageResolution) obj;
            if (Intrinsics.a(this.url, imageResolution.url)) {
                if (this.width == imageResolution.width) {
                    if (this.height == imageResolution.height) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.url;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImageResolution(url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(android.os.Parcel parcel, int i) {
        Intrinsics.b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.b(str, "<set-?>");
        this.url = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public /* synthetic */ ImageResolution(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != null) {
            str = "";
        }
        if ((i3 & 2) != null) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(str, i, i2);
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public ImageResolution(String str, int i, int i2) {
        Intrinsics.b(str, UpdateFragment.FRAGMENT_URL);
        this.url = str;
        this.width = i;
        this.height = i2;
    }

    public ImageResolution(com.reddit.frontpage.domain.model.ImageResolution imageResolution) {
        Intrinsics.b(imageResolution, "resolution");
        this(imageResolution.getUrl(), imageResolution.getWidth(), imageResolution.getHeight());
    }
}
