package com.reddit.frontpage.presentation.communities.model;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u00020\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/SubredditDiscoveryUnitItemPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "viewType", "", "model", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "(ILcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;)V", "getModel", "()Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "createCopy", "getUniqueID", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityListItem.kt */
public abstract class SubredditDiscoveryUnitItemPresentationModel extends CommunityListItem {
    private final GeneralCarouselCollectionPresentationModel<?> f36454c;

    public abstract SubredditDiscoveryUnitItemPresentationModel mo7152a(GeneralCarouselCollectionPresentationModel<?> generalCarouselCollectionPresentationModel);

    public GeneralCarouselCollectionPresentationModel<?> mo7151a() {
        return this.f36454c;
    }

    public SubredditDiscoveryUnitItemPresentationModel(int i, GeneralCarouselCollectionPresentationModel<?> generalCarouselCollectionPresentationModel) {
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
        super(i, generalCarouselCollectionPresentationModel.getUniqueID());
        this.f36454c = generalCarouselCollectionPresentationModel;
    }

    public long getUniqueID() {
        return mo7151a().f36359g;
    }
}
