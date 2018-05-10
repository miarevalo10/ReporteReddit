package com.reddit.frontpage.presentation.listing.model;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/LiveUpdateEventPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "id", "", "title", "viewerCount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "listableType", "getListableType", "()I", "getTitle", "getViewerCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getUniqueID", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LiveUpdateEventPresentationModel.kt */
public final class LiveUpdateEventPresentationModel implements Listable {
    public final String f34000a;
    public final String f34001b;
    public final int f34002c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveUpdateEventPresentationModel) {
            LiveUpdateEventPresentationModel liveUpdateEventPresentationModel = (LiveUpdateEventPresentationModel) obj;
            if (Intrinsics.m26845a(this.f34000a, liveUpdateEventPresentationModel.f34000a) && Intrinsics.m26845a(this.f34001b, liveUpdateEventPresentationModel.f34001b)) {
                if (this.f34002c == liveUpdateEventPresentationModel.f34002c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int getListableType() {
        return 3;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public final int hashCode() {
        String str = this.f34000a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f34001b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.f34002c;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LiveUpdateEventPresentationModel(id=");
        stringBuilder.append(this.f34000a);
        stringBuilder.append(", title=");
        stringBuilder.append(this.f34001b);
        stringBuilder.append(", viewerCount=");
        stringBuilder.append(this.f34002c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LiveUpdateEventPresentationModel(String str, String str2, int i) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "title");
        this.f34000a = str;
        this.f34001b = str2;
        this.f34002c = i;
    }

    public final long getUniqueID() {
        return Util.m24024f(this.f34000a);
    }
}
