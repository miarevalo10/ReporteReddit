package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.CommunitiesPresenter.Companion;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\f2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\nJ\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0002J*\u0010\u001c\u001a\u00020\u00112\"\u0010\u001d\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\u001f0\u0018\u0012\u0004\u0012\u00020\u00110\u001eJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020\u00112\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\nJ\u0019\u0010%\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u001e\u0010&\u001a\u00020\u00112\u0016\u0010'\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\u001f0\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"com/reddit/frontpage/presentation/communities/CommunitiesPresenter$models$1", "Lkotlin/collections/AbstractMutableList;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityListItem;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;)V", "computedModels", "", "defaultSections", "Lcom/reddit/frontpage/presentation/communities/Section;", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "discoveryUnits", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "size", "", "getSize", "()I", "userSections", "add", "", "index", "element", "addDiscoveryUnit", "position", "model", "buildCommunityList", "", "clearDiscoveryUnits", "computeModels", "get", "mutateCommunitySections", "action", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/communities/CommunitySection;", "removeAt", "removeDiscoveryUnit", "discoveryUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "replaceDiscoveryUnit", "set", "setSections", "sections", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
public final class CommunitiesPresenter$models$1 extends AbstractMutableList<CommunityListItem> {
    final List<GeneralCarouselCollectionPresentationModel<?>> f40003a = ((List) new ArrayList());
    final /* synthetic */ CommunitiesPresenter f40004b;
    private final List<CommunityListItem> f40005c = ((List) new ArrayList());
    private final List<Section<CommunityPresentationModel>> f40006d = ((List) new ArrayList());
    private final List<Section<CommunityPresentationModel>> f40007e = ((List) new ArrayList());

    CommunitiesPresenter$models$1(CommunitiesPresenter communitiesPresenter) {
        this.f40004b = communitiesPresenter;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        CommunityListItem communityListItem = (CommunityListItem) obj;
        Intrinsics.m26847b(communityListItem, "element");
        this.f40005c.add(i, communityListItem);
    }

    public final /* bridge */ boolean contains(Object obj) {
        return !(obj instanceof CommunityListItem) ? null : super.contains((CommunityListItem) obj);
    }

    public final /* synthetic */ Object get(int i) {
        return m40549a(i);
    }

    public final /* bridge */ int indexOf(Object obj) {
        return !(obj instanceof CommunityListItem) ? -1 : super.indexOf((CommunityListItem) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        return !(obj instanceof CommunityListItem) ? -1 : super.lastIndexOf((CommunityListItem) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        return !(obj instanceof CommunityListItem) ? null : super.remove((CommunityListItem) obj);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        return m40550a(i, (CommunityListItem) obj);
    }

    public final void m40553a(Function1<? super List<? extends Section<CommunityPresentationModel>>, Unit> function1) {
        Intrinsics.m26847b(function1, "action");
        function1.mo6492a(this.f40004b.m34635e() ? this.f40006d : this.f40007e);
        m40555b();
    }

    public final void m40552a(List<? extends Section<CommunityPresentationModel>> list) {
        Intrinsics.m26847b(list, "sections");
        if (this.f40004b.m34635e()) {
            MutableListsKt.m24089a(this.f40006d, list);
        } else {
            MutableListsKt.m24089a(this.f40007e, list);
        }
        m40555b();
    }

    public final void m40551a(GeneralCarouselCollectionPresentationModel<?> generalCarouselCollectionPresentationModel) {
        Intrinsics.m26847b(generalCarouselCollectionPresentationModel, "discoveryUnit");
        int i = 0;
        for (GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel2 : this.f40003a) {
            if (Intrinsics.m26845a(generalCarouselCollectionPresentationModel2.f36358f, generalCarouselCollectionPresentationModel.f36358f)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            this.f40003a.set(i, generalCarouselCollectionPresentationModel);
            m40555b();
        }
    }

    public final int mo7320a() {
        return this.f40005c.size();
    }

    public final CommunityListItem m40549a(int i) {
        return (CommunityListItem) this.f40005c.get(i);
    }

    public final CommunityListItem m40550a(int i, CommunityListItem communityListItem) {
        Intrinsics.m26847b(communityListItem, "element");
        return (CommunityListItem) this.f40005c.set(i, communityListItem);
    }

    final void m40555b() {
        List list = this.f40005c;
        list.clear();
        List arrayList = new ArrayList();
        for (GeneralCarouselCollectionPresentationModel a : CollectionsKt___CollectionsKt.m41449n(this.f40003a)) {
            CommunityListItem a2 = CommunitiesPresenter.m34613a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Companion companion = CommunitiesPresenter.f33806d;
        arrayList.add(CommunitiesPresenter.m34627c(CommunityPresentationModel.m22801a(CommunitiesPresenter.f33807s, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, 16383)));
        List list2;
        if (r0.f40004b.m34635e()) {
            list2 = r0.f40006d;
        } else {
            list2 = r0.f40007e;
        }
        for (Section b : r3) {
            arrayList.addAll(CommunitiesPresenter.m34623b(CollectionsKt___CollectionsKt.m41449n(b.mo4809b())));
        }
        list.addAll(arrayList);
    }

    public final /* synthetic */ Object mo7321b(int i) {
        return (CommunityListItem) this.f40005c.remove(i);
    }
}
