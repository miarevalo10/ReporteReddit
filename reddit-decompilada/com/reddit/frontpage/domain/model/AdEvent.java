package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/domain/model/AdEvent;", "Lpaperparcel/PaperParcelable;", "url", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class AdEvent implements PaperParcelable {
    public static final Creator<AdEvent> CREATOR = PaperParcelAdEvent.CREATOR;
    public static final Companion Companion = new Companion();
    private final int type;
    private final String url;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/AdEvent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/AdEvent;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ AdEvent copy$default(AdEvent adEvent, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adEvent.url;
        }
        if ((i2 & 2) != 0) {
            i = adEvent.type;
        }
        return adEvent.copy(str, i);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.type;
    }

    public final AdEvent copy(String str, int i) {
        return new AdEvent(str, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdEvent) {
            AdEvent adEvent = (AdEvent) obj;
            if (Intrinsics.m26845a(this.url, adEvent.url)) {
                if (this.type == adEvent.type) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.url;
        return ((str != null ? str.hashCode() : 0) * 31) + this.type;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AdEvent(url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AdEvent(String str, int i) {
        this.url = str;
        this.type = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }
}
