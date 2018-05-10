package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadItem;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "numSubscribers", "", "subscribed", "", "(Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;Ljava/lang/String;Z)V", "getModel", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getNumSubscribers", "()Ljava/lang/String;", "getSubscribed", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchModels.kt */
public final class CommunitySearchTypeAheadItem extends CommunitySearchItem {
    public static final Companion f28764e = new Companion();
    final CommunityPresentationModel f28765c;
    final String f28766d;
    private final boolean f28767f;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadItem$Companion;", "", "()V", "VIEW_TYPE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchModels.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommunitySearchTypeAheadItem) {
            CommunitySearchTypeAheadItem communitySearchTypeAheadItem = (CommunitySearchTypeAheadItem) obj;
            if (Intrinsics.m26845a(this.f28765c, communitySearchTypeAheadItem.f28765c) && Intrinsics.m26845a(this.f28766d, communitySearchTypeAheadItem.f28766d)) {
                if (this.f28767f == communitySearchTypeAheadItem.f28767f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        CommunityPresentationModel communityPresentationModel = this.f28765c;
        int i = 0;
        int hashCode = (communityPresentationModel != null ? communityPresentationModel.hashCode() : 0) * 31;
        String str = this.f28766d;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f28767f;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommunitySearchTypeAheadItem(model=");
        stringBuilder.append(this.f28765c);
        stringBuilder.append(", numSubscribers=");
        stringBuilder.append(this.f28766d);
        stringBuilder.append(", subscribed=");
        stringBuilder.append(this.f28767f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CommunitySearchTypeAheadItem(CommunityPresentationModel communityPresentationModel, String str, boolean z) {
        Intrinsics.m26847b(communityPresentationModel, "model");
        Intrinsics.m26847b(str, "numSubscribers");
        super(3, communityPresentationModel.f20481m);
        this.f28765c = communityPresentationModel;
        this.f28766d = str;
        this.f28767f = z;
    }
}
