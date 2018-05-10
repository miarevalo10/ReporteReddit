package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.communities.CommunitiesPresenter.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J>\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"com/reddit/frontpage/presentation/communities/CommunitiesPresenter$topSection$1", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "Lcom/reddit/frontpage/presentation/communities/LinkedSection;", "()V", "linkedSize", "", "getLinkedSize", "()I", "visibleItems", "", "getVisibleItems", "()Ljava/util/List;", "changeAll", "", "predicate", "Lkotlin/Function1;", "", "action", "positionsChanged", "Lcom/reddit/frontpage/presentation/communities/SectionChangeSet;", "insert", "Lcom/reddit/frontpage/presentation/communities/RangeChange;", "item", "comparison", "isSectionItem", "onSectionClicked", "remove", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
public final class CommunitiesPresenter$topSection$1 implements LinkedSection, Section<CommunityPresentationModel> {
    private final int f28117a;

    CommunitiesPresenter$topSection$1() {
    }

    public final /* synthetic */ RangeChange mo4805a(Object obj, Function1 function1) {
        Intrinsics.m26847b((CommunityPresentationModel) obj, "item");
        Intrinsics.m26847b(function1, "comparison");
        throw ((Throwable) new UnsupportedOperationException("Insert not supported for this section"));
    }

    public final /* synthetic */ boolean mo4807a(Object obj) {
        Intrinsics.m26847b((CommunityPresentationModel) obj, "item");
        return null;
    }

    public final /* synthetic */ RangeChange mo4808b(Object obj, Function1 function1) {
        Intrinsics.m26847b((CommunityPresentationModel) obj, "item");
        Intrinsics.m26847b(function1, "comparison");
        throw ((Throwable) new UnsupportedOperationException("Remove not supported for this section"));
    }

    public final int mo4804a() {
        return this.f28117a;
    }

    public final List<CommunityPresentationModel> mo4809b() {
        CommunityPresentationModel[] communityPresentationModelArr = new CommunityPresentationModel[1];
        Companion companion = CommunitiesPresenter.f33806d;
        communityPresentationModelArr[0] = CommunitiesPresenter.f33807s;
        return CollectionsKt__CollectionsKt.m26797c(communityPresentationModelArr);
    }

    public final SectionChangeSet mo4810c() {
        throw new UnsupportedOperationException("This section contains no section item");
    }

    public final void mo4806a(Function1<? super CommunityPresentationModel, Boolean> function1, Function1<? super CommunityPresentationModel, CommunityPresentationModel> function12, List<SectionChangeSet> list) {
        Intrinsics.m26847b(function1, "predicate");
        Intrinsics.m26847b(function12, "action");
        Intrinsics.m26847b(list, "positionsChanged");
        throw ((Throwable) new UnsupportedOperationException("This section does not allow processing"));
    }
}
