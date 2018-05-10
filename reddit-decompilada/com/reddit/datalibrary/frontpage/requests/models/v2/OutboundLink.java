package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.structure.BaseModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/OutboundLink;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "Ljava/io/Serializable;", "url", "", "expiration", "", "created", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreated", "()Ljava/lang/Long;", "setCreated", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExpiration", "setExpiration", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/reddit/datalibrary/frontpage/requests/models/v2/OutboundLink;", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@Parcel
/* compiled from: OutboundLink.kt */
public final class OutboundLink extends BaseModel implements Serializable {
    private Long created;
    private Long expiration;
    private String url;

    public OutboundLink() {
        this(null, null, null, 7, null);
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
        return new OutboundLink(str, l, l2);
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

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public /* synthetic */ OutboundLink(String str, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != null) {
            str = null;
        }
        if ((i & 2) != null) {
            l = Long.valueOf(0);
        }
        if ((i & 4) != 0) {
            l2 = Long.valueOf(0);
        }
        this(str, l, l2);
    }

    public final Long getExpiration() {
        return this.expiration;
    }

    public final void setExpiration(Long l) {
        this.expiration = l;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final void setCreated(Long l) {
        this.created = l;
    }

    public OutboundLink(String str, Long l, Long l2) {
        this.url = str;
        this.expiration = l;
        this.created = l2;
    }
}
