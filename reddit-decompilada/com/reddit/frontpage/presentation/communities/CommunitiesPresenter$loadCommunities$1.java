package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.Section;
import com.reddit.frontpage.presentation.communities.CommunitiesPresenter.DiscoveryUnitLoadResult.Result;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModelType;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$LinkedCommunityLoadResult;", "kotlin.jvm.PlatformType", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$loadCommunities$1<T> implements Consumer<Pair<? extends LinkedCommunityLoadResult, ? extends DiscoveryUnitLoadResult>> {
    final /* synthetic */ CommunitiesPresenter f28109a;

    CommunitiesPresenter$loadCommunities$1(CommunitiesPresenter communitiesPresenter) {
        this.f28109a = communitiesPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        CommunitiesPresenter$loadCommunities$1 communitiesPresenter$loadCommunities$1 = this;
        Pair pair = (Pair) obj;
        LinkedCommunityLoadResult linkedCommunityLoadResult = (LinkedCommunityLoadResult) pair.f25267a;
        DiscoveryUnitLoadResult discoveryUnitLoadResult = (DiscoveryUnitLoadResult) pair.f25268b;
        if (discoveryUnitLoadResult instanceof Result) {
            Result result = (Result) discoveryUnitLoadResult;
            if (result.f28106a instanceof GeneralCarouselCollectionPresentationModel) {
                if (result.f28106a.mo6935b() >= 3) {
                    CommunitiesPresenter$models$1 a = communitiesPresenter$loadCommunities$1.f28109a.f33808b;
                    a.f40003a.clear();
                    a.m40555b();
                    GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = (GeneralCarouselCollectionPresentationModel) result.f28106a;
                    Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "model");
                    a.f40003a.add(generalCarouselCollectionPresentationModel);
                    a.m40555b();
                } else {
                    communitiesPresenter$loadCommunities$1.f28109a.f33808b.m40551a((GeneralCarouselCollectionPresentationModel) result.f28106a);
                }
            }
        }
        LinkedCollapsibleSection linkedCollapsibleSection = new LinkedCollapsibleSection(linkedCommunityLoadResult.f20442a.f20440a, communitiesPresenter$loadCommunities$1.f28109a.f33817l, Section.f28099b, linkedCommunityLoadResult.f20442a.f20441b);
        communitiesPresenter$loadCommunities$1.f28109a.f33810e = linkedCollapsibleSection;
        LinkedCollapsibleSection linkedCollapsibleSection2 = new LinkedCollapsibleSection(linkedCommunityLoadResult.f20443b.f20440a, linkedCollapsibleSection, Section.f28100c, linkedCommunityLoadResult.f20443b.f20441b);
        communitiesPresenter$loadCommunities$1.f28109a.f33811f = linkedCollapsibleSection2;
        linkedCollapsibleSection = new LinkedCollapsibleSection(linkedCommunityLoadResult.f20444c.f20440a, linkedCollapsibleSection2, Section.f28101d, linkedCommunityLoadResult.f20444c.f20441b);
        communitiesPresenter$loadCommunities$1.f28109a.f33812g = linkedCollapsibleSection;
        linkedCollapsibleSection2 = new LinkedCollapsibleSection(linkedCommunityLoadResult.f20445d.f20440a, linkedCollapsibleSection, Section.f28102e, linkedCommunityLoadResult.f20445d.f20441b);
        communitiesPresenter$loadCommunities$1.f28109a.f33813h = linkedCollapsibleSection2;
        if (!linkedCommunityLoadResult.f20446e.f20440a.isEmpty()) {
            CommunityPresentationModelType communityPresentationModelType = CommunityPresentationModelType.f20485c;
            String string = FrontpageApplication.f27402a.getString(C1761R.string.mod);
            CommunityPresentationSection communityPresentationSection = CommunityPresentationSection.f20493g;
            Integer valueOf = Integer.valueOf(C1761R.drawable.ic_icon_moderate);
            Integer valueOf2 = Integer.valueOf(C1761R.attr.rdt_default_key_color);
            Companion companion = CommunityPresentationModel.f20468o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(CommunityPresentationSection.f20493g.ordinal()));
            stringBuilder.append(0);
            linkedCommunityLoadResult.f20446e.f20440a.add(0, new CommunityPresentationModel("com.reddit.frontpage.DEFAULT_ID", communityPresentationModelType, communityPresentationSection, string, null, null, null, null, valueOf, valueOf2, null, false, Companion.m22800a(stringBuilder.toString(), new String[0]), false, 9456));
        }
        communitiesPresenter$loadCommunities$1.f28109a.f33814i = new LinkedCollapsibleSection(linkedCommunityLoadResult.f20446e.f20440a, linkedCollapsibleSection2, Section.f28103f, linkedCommunityLoadResult.f20446e.f20441b);
        communitiesPresenter$loadCommunities$1.f28109a.f33808b.m40552a(CollectionsKt__CollectionsKt.m26796b((Object[]) new Section[]{CommunitiesPresenter.m34626c(communitiesPresenter$loadCommunities$1.f28109a), CommunitiesPresenter.m34630d(communitiesPresenter$loadCommunities$1.f28109a), CommunitiesPresenter.m34633e(communitiesPresenter$loadCommunities$1.f28109a), CommunitiesPresenter.m34636f(communitiesPresenter$loadCommunities$1.f28109a), CommunitiesPresenter.m34637g(communitiesPresenter$loadCommunities$1.f28109a)}));
        communitiesPresenter$loadCommunities$1.f28109a.m34644a();
    }
}
