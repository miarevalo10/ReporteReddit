package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/domain/model/OutboundLink;", "Lpaperparcel/PaperParcelable;", "url", "", "expiration", "", "created", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreated", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiration", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/reddit/frontpage/domain/model/OutboundLink;", "equals", "", "other", "", "hashCode", "", "toLegacy", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/OutboundLink;", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class OutboundLink implements PaperParcelable {
    public static final Creator<OutboundLink> CREATOR = PaperParcelOutboundLink.CREATOR;
    public static final Companion Companion = new Companion();
    private final Long created;
    private final Long expiration;
    private final String url;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/OutboundLink$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/OutboundLink;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ OutboundLink copy$default(OutboundLink outboundLink, String str, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outboundLink.url;
        }
        if ((i & 2) != 0) {
            l = outboundLink.expiration;
        }
        if ((i & 4) != 0) {
            l2 = outboundLink.created;
        }
        return outboundLink.copy(str, l, l2);
    }

    public final String component1() {
        return this.url;
    }

    public final Long component2() {
        return this.expiration;
    }

    public final Long component3() {
        return this.created;
    }

    public final OutboundLink copy(String str, Long l, Long l2) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        return new OutboundLink(str, l, l2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OutboundLink) {
                OutboundLink outboundLink = (OutboundLink) obj;
                if (Intrinsics.m26845a(this.url, outboundLink.url) && Intrinsics.m26845a(this.expiration, outboundLink.expiration) && Intrinsics.m26845a(this.created, outboundLink.created)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.expiration;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        l = this.created;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("OutboundLink(url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", expiration=");
        stringBuilder.append(this.expiration);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public OutboundLink(String str, Long l, Long l2) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        this.url = str;
        this.expiration = l;
        this.created = l2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getUrl() {
        return this.url;
    }

    public final Long getExpiration() {
        return this.expiration;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final com.reddit.datalibrary.frontpage.requests.models.v2.OutboundLink toLegacy() {
        return new com.reddit.datalibrary.frontpage.requests.models.v2.OutboundLink(this.url, this.expiration, this.created);
    }
}
