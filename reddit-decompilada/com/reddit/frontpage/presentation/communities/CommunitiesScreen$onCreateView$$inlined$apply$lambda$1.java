package com.reddit.frontpage.presentation.communities;

import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll.FastScrollView;
import com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationSection;
import com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"com/reddit/frontpage/presentation/communities/CommunitiesScreen$onCreateView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesScreen$onCreateView$1;Landroid/support/v7/widget/RecyclerView;)V", "lm", "Landroid/support/v7/widget/LinearLayoutManager;", "showingFastScroll", "", "getShowingFastScroll", "()Z", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
public final class CommunitiesScreen$onCreateView$$inlined$apply$lambda$1 extends OnScrollListener {
    final /* synthetic */ RecyclerView f28126a;
    final /* synthetic */ CommunitiesScreen f28127b;
    final /* synthetic */ View f28128c;
    private final LinearLayoutManager f28129d;

    CommunitiesScreen$onCreateView$$inlined$apply$lambda$1(RecyclerView recyclerView, CommunitiesScreen communitiesScreen, View view) {
        this.f28126a = recyclerView;
        this.f28127b = communitiesScreen;
        this.f28128c = view;
        recyclerView = this.f28126a.getLayoutManager();
        if (recyclerView == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        this.f28129d = (LinearLayoutManager) recyclerView;
    }

    public final void m29481a(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.m26847b(recyclerView, "recyclerView");
        Object obj = this.f28128c;
        Intrinsics.m26843a(obj, "view");
        obj = (FastScrollView) obj.findViewById(C1761R.id.communities_fastscroll);
        Intrinsics.m26843a(obj, "view.communities_fastscroll");
        i2 = 0;
        if ((((View) obj).getVisibility() == 8 ? 1 : 0) == 0) {
            i = new Function0<Boolean>() {
                public final /* synthetic */ Object invoke() {
                    return Boolean.valueOf(m36815a());
                }

                public final boolean m36815a() {
                    boolean z;
                    IntRange intRange = new IntRange(this.f28129d.k(), this.f28129d.m());
                    CommunitiesAdapter a = this.f28127b.m40556O();
                    Collection arrayList = new ArrayList();
                    Iterator it = intRange.iterator();
                    while (true) {
                        boolean z2 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((Number) next).intValue() == -1) {
                            z2 = false;
                        }
                        if (z2) {
                            arrayList.add(next);
                        }
                    }
                    Iterable<Number> iterable = (List) arrayList;
                    if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                        for (Number intValue : iterable) {
                            if (a.f28118a.get(intValue.intValue()) instanceof SubredditDiscoveryUnitItemPresentationModel) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        return false;
                    }
                    Collection arrayList2 = new ArrayList();
                    for (Object next2 : iterable) {
                        if (a.f28118a.get(((Number) next2).intValue()) instanceof CommunityListItemPresentationModel) {
                            arrayList2.add(next2);
                        }
                    }
                    Iterable<Number> iterable2 = (List) arrayList2;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
                    for (Number intValue2 : iterable2) {
                        next2 = a.f28118a.get(intValue2.intValue());
                        if (next2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.communities.model.CommunityListItemPresentationModel");
                        }
                        arrayList.add(((CommunityListItemPresentationModel) next2).mo7150a().f20471c);
                    }
                    Iterable<Object> iterable3 = (List) arrayList;
                    if (!((iterable3 instanceof Collection) && ((Collection) iterable3).isEmpty())) {
                        for (Object obj : iterable3) {
                            if (!Intrinsics.m26845a(obj, CommunityPresentationSection.f20492f)) {
                                if (!Intrinsics.m26845a(obj, CommunityPresentationSection.f20490d)) {
                                    z = false;
                                    continue;
                                    if (z) {
                                        return true;
                                    }
                                }
                            }
                            z = true;
                            continue;
                            if (z) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }.m36815a();
            Object obj2 = this.f28128c;
            Intrinsics.m26843a(obj2, "view");
            obj2 = (FastScrollView) obj2.findViewById(C1761R.id.communities_fastscroll);
            Intrinsics.m26843a(obj2, "view.communities_fastscroll");
            if (((View) obj2).getVisibility() == 0) {
                i2 = 1;
            }
            if (i != i2) {
                i2 = this.f28128c;
                if (i2 == 0) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ViewGroup viewGroup = (ViewGroup) i2;
                Fade fade = new Fade();
                fade.a(recyclerView, true);
                TransitionManager.a(viewGroup, fade);
                Object obj3 = this.f28128c;
                Intrinsics.m26843a(obj3, "view");
                obj3 = (FastScrollView) obj3.findViewById(C1761R.id.communities_fastscroll);
                Intrinsics.m26843a(obj3, "view.communities_fastscroll");
                ViewsKt.m24108c((View) obj3, i);
            }
        }
    }
}
