package com.reddit.frontpage.presentation.communities.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/CommunityListItemPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "viewType", "", "(Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;I)V", "getModel", "()Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "getUniqueID", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityListItem.kt */
public abstract class CommunityListItemPresentationModel extends CommunityListItem {
    private final CommunityPresentationModel f36453c;

    public CommunityPresentationModel mo7150a() {
        return this.f36453c;
    }

    public long getUniqueID() {
        return mo7150a().f20481m;
    }

    public CommunityListItemPresentationModel(CommunityPresentationModel communityPresentationModel, int i) {
        Intrinsics.m26847b(communityPresentationModel, "model");
        super(i, communityPresentationModel.f20481m);
        this.f36453c = communityPresentationModel;
    }
}
