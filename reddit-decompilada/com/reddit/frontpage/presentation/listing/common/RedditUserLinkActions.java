package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.SubredditUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJF\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J:\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0016JV\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0016JF\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J:\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0,H\u0016J:\u0010.\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0016J:\u0010/\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0016J:\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0016J>\u00101\u001a\u00020\n\"\b\b\u0000\u00102*\u00020!2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H2032\u0006\u0010'\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0016J\u0010\u00105\u001a\u00020-2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditUserLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsNavigator", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "(Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;)V", "onCommentsSelected", "", "presentationLinkPosition", "", "presentationLink", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "linkPositions", "", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onCommunitySelected", "onCrossPostSelected", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "onHideLinkSelected", "", "", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "onLinkHidden", "Lkotlin/Function0;", "onLinkSelected", "onModerateSelected", "onPreviewSelected", "link", "onReportLinkSelected", "view", "Lcom/reddit/frontpage/presentation/listing/common/ReportableLinkActionView;", "onLinkReported", "Lkotlin/Function1;", "", "onSaveLinkSelected", "onShareSelected", "onSourceSelected", "onSubscribeLinkSelected", "T", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "onLinkSubscribed", "useAdClickBehavior", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditUserLinkActions.kt */
public final class RedditUserLinkActions implements UserLinkActions {
    private final ListingNavigator f28372a;
    private final SessionManager f28373b;
    private final AdsNavigator f28374c;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20591a;

        static {
            int[] iArr = new int[LinkType.values().length];
            f20591a = iArr;
            iArr[LinkType.SELF_IMAGE.ordinal()] = 1;
            f20591a[LinkType.IMAGE.ordinal()] = 2;
            f20591a[LinkType.WEBSITE.ordinal()] = 3;
            f20591a[LinkType.VIDEO.ordinal()] = 4;
            f20591a[LinkType.CROSSPOST.ordinal()] = 5;
        }
    }

    public RedditUserLinkActions(ListingNavigator listingNavigator, SessionManager sessionManager, AdsNavigator adsNavigator) {
        Intrinsics.m26847b(listingNavigator, "navigator");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsNavigator, "adsNavigator");
        this.f28372a = listingNavigator;
        this.f28373b = sessionManager;
        this.f28374c = adsNavigator;
    }

    public final void mo4884a(LinkPresentationModel linkPresentationModel, Map<String, Integer> map, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(map, "linkPositions");
        Intrinsics.m26847b(listingType, "listingType");
        Intrinsics.m26847b(linkSortType, "sort");
        if (m29625b(linkPresentationModel)) {
            map = this.f28372a;
            linkPresentationModel = linkPresentationModel.av;
            if (linkPresentationModel == null) {
                Intrinsics.m26842a();
            }
            map.mo4853g(linkPresentationModel);
            return;
        }
        map = map.get(linkPresentationModel.f33976c);
        if (map == null) {
            Intrinsics.m26842a();
        }
        this.f28372a.mo4846a(linkPresentationModel.f33977d, ((Number) map).intValue(), listingType, linkSortType, sortTimeFrame);
    }

    public final void mo4881a(Link link, LinkPresentationModel linkPresentationModel) {
        do {
            Intrinsics.m26847b(link, "link");
            Intrinsics.m26847b(linkPresentationModel, "presentationLink");
            boolean b = m29625b(linkPresentationModel);
            switch (WhenMappings.f20591a[linkPresentationModel.f33975b.ordinal()]) {
                case 1:
                    if (b) {
                        this.f28372a.mo4853g(link);
                        return;
                    } else {
                        this.f28372a.mo4850d(link);
                        return;
                    }
                case 2:
                    if (b) {
                        this.f28372a.mo4853g(link);
                        return;
                    } else {
                        this.f28372a.mo4850d(link);
                        return;
                    }
                case 3:
                    if (b) {
                        this.f28372a.mo4853g(link);
                        return;
                    } else {
                        this.f28372a.mo4851e(link);
                        return;
                    }
                case 4:
                    this.f28372a.mo4849c(link);
                    return;
                case 5:
                    link = link.getCrossPostParentList();
                    link = link != null ? (Link) CollectionsKt___CollectionsKt.m41434e((List) link) : null;
                    linkPresentationModel = linkPresentationModel.am;
                    if (link != null) {
                    }
                    Timber.e("Unable to preview crosspost. Parent link is null", new Object[null]);
                default:
                    StringBuilder stringBuilder = new StringBuilder("Cannot click on preview for non-preview type: ");
                    stringBuilder.append(linkPresentationModel.f33975b.name());
                    throw ((Throwable) new IllegalArgumentException(stringBuilder.toString()));
            }
        } while (linkPresentationModel != null);
        Timber.e("Unable to preview crosspost. Parent link is null", new Object[null]);
    }

    public final <T extends Listable> void mo4879a(int i, ListingView<? super T> listingView, Link link, Function0<Unit> function0) {
        Intrinsics.m26847b(listingView, "view");
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(function0, "onLinkSubscribed");
        if (this.f28373b.c().isAnonymous()) {
            this.f28372a.mo4843a();
            return;
        }
        Object a = SubredditUtil.m23911a(link.getSubreddit(), false);
        Intrinsics.m26843a(a, "isSubscribed");
        if (a.booleanValue()) {
            this.f28372a.mo4848b(link.getSubreddit());
            return;
        }
        this.f28373b.c();
        SubredditUtil.m23917a(link);
        listingView.mo7328b(i);
        function0.invoke();
    }

    public final void mo4883a(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(map, "linkPositions");
        linkPresentationModel = map.get(linkPresentationModel.f33976c);
        if (linkPresentationModel == null) {
            Intrinsics.m26842a();
        }
        this.f28372a.mo4847b((Link) list.get(((Number) linkPresentationModel).intValue()));
    }

    public final void mo4885b(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(map, "linkPositions");
        map = map.get(linkPresentationModel.f33976c);
        if (map == null) {
            Intrinsics.m26842a();
        }
        Link link = (Link) list.get(((Number) map).intValue());
        if (m29625b(linkPresentationModel) != null) {
            this.f28372a.mo4853g(link);
        } else {
            this.f28372a.mo4851e(link);
        }
    }

    public final void mo4886b(LinkPresentationModel linkPresentationModel, Map<String, Integer> map, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(map, "linkPositions");
        Intrinsics.m26847b(listingType, "listingType");
        Intrinsics.m26847b(linkSortType, "sort");
        map = map.get(linkPresentationModel.f33976c);
        if (map == null) {
            Intrinsics.m26842a();
        }
        this.f28372a.mo4846a(linkPresentationModel.f33977d, ((Number) map).intValue(), listingType, linkSortType, sortTimeFrame);
    }

    public final void mo4887c(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(map, "linkPositions");
        linkPresentationModel = map.get(linkPresentationModel.f33976c);
        if (linkPresentationModel == null) {
            Intrinsics.m26842a();
        }
        this.f28372a.mo4852f((Link) list.get(((Number) linkPresentationModel).intValue()));
    }

    public final void mo4882a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        String a = SubredditUtil.m23912a(linkPresentationModel.f33979f);
        ListingNavigator listingNavigator = this.f28372a;
        Intrinsics.m26843a((Object) a, "subreddit");
        listingNavigator.mo4848b(a);
    }

    public final void mo4880a(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<Listable> list2, Function0<Unit> function0) {
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        Intrinsics.m26847b(list, "links");
        Intrinsics.m26847b(map, "linkPositions");
        Intrinsics.m26847b(list2, "presentationModels");
        Intrinsics.m26847b(function0, "onLinkHidden");
        Object obj = linkPresentationModel.f33976c;
        Object obj2 = map.get(obj);
        if (obj2 == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj2).intValue();
        int i2 = 0;
        Map linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.m36115a(map.size()));
        for (Entry entry : map.entrySet()) {
            int intValue2;
            Object key = entry.getKey();
            if (i2 != 0) {
                intValue2 = ((Number) entry.getValue()).intValue() - 1;
            } else {
                if (Intrinsics.m26845a((String) entry.getKey(), obj)) {
                    i2 = 1;
                }
                intValue2 = ((Number) entry.getValue()).intValue();
            }
            linkedHashMap.put(key, Integer.valueOf(intValue2));
        }
        Map b = MapsKt__MapsKt.m36124b(linkedHashMap);
        b.remove(obj);
        map.clear();
        map.putAll(b);
        LinkUtil.m23800d(((Link) list.get(intValue)).getKindWithId());
        list.remove(intValue);
        list2.remove(i);
        function0.invoke();
    }

    private static boolean m29625b(LinkPresentationModel linkPresentationModel) {
        if (linkPresentationModel.f33962O) {
            linkPresentationModel = linkPresentationModel.av;
            linkPresentationModel = (linkPresentationModel == null || AdsNavigator.m23453a(linkPresentationModel) == null) ? null : 1;
            if (linkPresentationModel != null) {
                return true;
            }
        }
        return false;
    }
}
