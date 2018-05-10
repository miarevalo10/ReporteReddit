package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.raizlabs.android.dbflow.structure.BaseModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "Ljava/io/Serializable;", "url", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "setType", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "EventType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@Parcel
/* compiled from: AdEvent.kt */
public final class AdEvent extends BaseModel implements Serializable {
    public static final int CLICK = 2;
    public static final int COMMENT = 6;
    public static final int COMMENTS_VIEW = 3;
    public static final int COMMENT_DOWNVOTE = 9;
    public static final int COMMENT_UPVOTE = 8;
    public static final int DOWNVOTE = 5;
    public static final EventType EventType = new EventType();
    public static final int IMPRESSION = 1;
    public static final int UPVOTE = 4;
    public static final int VIEWABLE_IMPRESSION = 7;
    private int type;
    private String url;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent$EventType;", "", "()V", "CLICK", "", "COMMENT", "COMMENTS_VIEW", "COMMENT_DOWNVOTE", "COMMENT_UPVOTE", "DOWNVOTE", "IMPRESSION", "UPVOTE", "VIEWABLE_IMPRESSION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdEvent.kt */
    public static final class EventType {
        private EventType() {
        }
    }

    public AdEvent() {
        this(null, 0, 3, null);
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdEvent) {
            AdEvent adEvent = (AdEvent) obj;
            if (Intrinsics.a(this.url, adEvent.url)) {
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

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public /* synthetic */ AdEvent(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != null) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        this(str, i);
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public AdEvent(String str, int i) {
        this.url = str;
        this.type = i;
    }
}
