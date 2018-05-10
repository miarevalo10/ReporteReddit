package com.reddit.frontpage.presentation.detail.common;

import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@PaperParcel
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/common/Link;", "Lcom/reddit/frontpage/presentation/detail/common/Editable;", "Lcom/reddit/frontpage/domain/model/Link;", "model", "(Lcom/reddit/frontpage/domain/model/Link;)V", "getModel", "()Lcom/reddit/frontpage/domain/model/Link;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Editable.kt */
public final class Link extends Editable<com.reddit.frontpage.domain.model.Link> {
    public static final Creator<Link> CREATOR = PaperParcelLink.f20508b;
    public static final Companion f33843b = new Companion();
    public final com.reddit.frontpage.domain.model.Link f33844a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/common/Link$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/detail/common/Link;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Editable.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public Link(com.reddit.frontpage.domain.model.Link link) {
        Intrinsics.m26847b(link, "model");
        super();
        this.f33844a = link;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Link(model=");
        stringBuilder.append(this.f33844a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        com.reddit.frontpage.domain.model.Link link = this.f33844a;
        return link != null ? link.hashCode() : 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Link) {
                if (Intrinsics.m26845a(this.f33844a, ((Link) obj).f33844a) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
