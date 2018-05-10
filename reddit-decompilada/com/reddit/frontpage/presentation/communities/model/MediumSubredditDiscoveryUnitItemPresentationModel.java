package com.reddit.frontpage.presentation.communities.model;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0017\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/MediumSubredditDiscoveryUnitItemPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/model/SubredditDiscoveryUnitItemPresentationModel;", "model", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "(Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;)V", "listableType", "", "getListableType", "()I", "getModel", "()Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "component1", "copy", "createCopy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunityListItem.kt */
public final class MediumSubredditDiscoveryUnitItemPresentationModel extends SubredditDiscoveryUnitItemPresentationModel {
    public static final Companion f39083c = new Companion();
    private final GeneralCarouselCollectionPresentationModel<?> f39084d;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/communities/model/MediumSubredditDiscoveryUnitItemPresentationModel$Companion;", "", "()V", "VIEW_TYPE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunityListItem.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int getListableType() {
        return 13;
    }

    public final GeneralCarouselCollectionPresentationModel<?> mo7151a() {
        return this.f39084d;
    }

    public MediumSubredditDiscoveryUnitItemPresentationModel(GeneralCarouselCollectionPresentationModel<?> generalCarouselCollectionPresentationModel) {
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
        super(5, generalCarouselCollectionPresentationModel);
        this.f39084d = generalCarouselCollectionPresentationModel;
    }

    public final SubredditDiscoveryUnitItemPresentationModel mo7152a(GeneralCarouselCollectionPresentationModel<?> generalCarouselCollectionPresentationModel) {
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
        return new MediumSubredditDiscoveryUnitItemPresentationModel(generalCarouselCollectionPresentationModel);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediumSubredditDiscoveryUnitItemPresentationModel(model=");
        stringBuilder.append(this.f39084d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = this.f39084d;
        return generalCarouselCollectionPresentationModel != null ? generalCarouselCollectionPresentationModel.hashCode() : 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MediumSubredditDiscoveryUnitItemPresentationModel) {
                if (Intrinsics.m26845a(this.f39084d, ((MediumSubredditDiscoveryUnitItemPresentationModel) obj).f39084d) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
