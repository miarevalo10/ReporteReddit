package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "sections", "", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/CommunitySection;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onFavoriteClicked$1 extends Lambda implements Function1<List<? extends Section<CommunityPresentationModel>>, Unit> {
    final /* synthetic */ CommunityPresentationModel f36418a;
    final /* synthetic */ boolean f36419b;

    CommunitiesPresenter$onFavoriteClicked$1(CommunityPresentationModel communityPresentationModel, boolean z) {
        this.f36418a = communityPresentationModel;
        this.f36419b = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List<Section> list = (List) obj;
        Intrinsics.m26847b(list, "sections");
        for (Section a : list) {
            a.mo4806a(new C2814x950ba2a(this), new C2815x950ba2b(this), new ArrayList());
        }
        return Unit.f25273a;
    }
}
