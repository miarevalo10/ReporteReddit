package com.reddit.frontpage.presentation.communities.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityListItemNonFavoritablePresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItemPresentationModel;", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "(Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;)V", "listableType", "", "getListableType", "()I", "getModel", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityListItem.kt */
public final class CommunityListItemNonFavoritablePresentationModel extends CommunityListItemPresentationModel {
    public static final Companion f39077c = new Companion();
    private final CommunityPresentationModel f39078d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityListItemNonFavoritablePresentationModel$Companion;", "", "()V", "VIEW_TYPE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunityListItem.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int getListableType() {
        return 21;
    }

    public final CommunityPresentationModel mo7150a() {
        return this.f39078d;
    }

    public CommunityListItemNonFavoritablePresentationModel(CommunityPresentationModel communityPresentationModel) {
        Intrinsics.m26847b(communityPresentationModel, "model");
        super(communityPresentationModel, 3);
        this.f39078d = communityPresentationModel;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommunityListItemNonFavoritablePresentationModel(model=");
        stringBuilder.append(this.f39078d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        CommunityPresentationModel communityPresentationModel = this.f39078d;
        return communityPresentationModel != null ? communityPresentationModel.hashCode() : 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CommunityListItemNonFavoritablePresentationModel) {
                if (Intrinsics.m26845a(this.f39078d, ((CommunityListItemNonFavoritablePresentationModel) obj).f39078d) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
