package com.reddit.frontpage.presentation.listing.common;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jp\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u0013H\u0002J5\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001fH\u0002¢\u0006\u0002\u0010 J`\u0010!\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010$\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010%\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010&\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010'\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010(\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010)\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J`\u0010*\u001a\u00020\"\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016Jt\u0010+\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\t0\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditModeratorLinkActions;", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "repository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "attemptReplaceLinkStateAndUpdateView", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "view", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "position", "", "numLinks", "link", "Lcom/reddit/frontpage/domain/model/Link;", "links", "", "linkPositions", "", "", "presentationLink", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "presentationModels", "getValidLinkPresentationPosition", "presentationModel", "initialPosition", "previousNumLinks", "listables", "", "(Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;IILjava/util/List;)Ljava/lang/Integer;", "onModerateApprove", "Lio/reactivex/disposables/Disposable;", "presentationModelPosition", "onModerateDistinguish", "onModerateLockComments", "onModerateMarkNsfw", "onModerateMarkSpoiler", "onModeratePinAnnouncement", "onModerateRemove", "onModerateRemoveAsSpam", "replaceLinkAndUpdateView", "linkPosition", "replaceLink", "Lkotlin/Function1;", "replacePresentationLink", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditModeratorLinkActions.kt */
public final class RedditModeratorLinkActions implements ModeratorLinkActions {
    private final LinkRepository f28370a;
    private final PostExecutionThread f28371b;

    @Inject
    public RedditModeratorLinkActions(LinkRepository linkRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(linkRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f28370a = linkRepository;
        this.f28371b = postExecutionThread;
    }

    private static <T extends Listable> void m29615a(ListingView<? super T> listingView, List<Link> list, List<T> list2, int i, int i2, Function1<? super Link, Link> function1, Function1<? super T, ? extends T> function12) {
        list.set(i2, function1.mo6492a(list.get(i2)));
        list2.set(i, function12.mo6492a(list2.get(i)));
        listingView.mo7330b((List) list2);
        listingView.mo7328b(i);
    }

    public final <T extends Listable> Disposable mo4871a(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.f33950C ^ 1;
        m29615a(listingView2, list3, list4, i, intValue, new RedditModeratorLinkActions$onModerateMarkNsfw$1(z), new RedditModeratorLinkActions$onModerateMarkNsfw$2(z));
        obj = CompletablesKt.m24074b((Completable) (z ? new RedditModeratorLinkActions$onModerateMarkNsfw$markNsfw$1(redditModeratorLinkActions.f28370a) : new RedditModeratorLinkActions$onModerateMarkNsfw$markNsfw$2(redditModeratorLinkActions.f28370a)).mo6492a(linkPresentationModel.getName()), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateMarkNsfw$3.f28320a, new RedditModeratorLinkActions$onModerateMarkNsfw$4(redditModeratorLinkActions, listingView2, i, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "markNsfw(presentationLin…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4872b(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.f33953F ^ 1;
        m29615a(listingView2, list3, list4, i, intValue, new RedditModeratorLinkActions$onModerateMarkSpoiler$1(z), new RedditModeratorLinkActions$onModerateMarkSpoiler$2(z));
        obj = CompletablesKt.m24074b((Completable) (z ? new RedditModeratorLinkActions$onModerateMarkSpoiler$markSpoiler$1(redditModeratorLinkActions.f28370a) : new RedditModeratorLinkActions$onModerateMarkSpoiler$markSpoiler$2(redditModeratorLinkActions.f28370a)).mo6492a(linkPresentationModel.getName()), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateMarkSpoiler$3.f28330a, new RedditModeratorLinkActions$onModerateMarkSpoiler$4(redditModeratorLinkActions, listingView2, i, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "markSpoiler(presentation…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4873c(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.f33995v ^ 1;
        m29615a(listingView2, list3, list4, i, intValue, new RedditModeratorLinkActions$onModerateLockComments$1(z), new RedditModeratorLinkActions$onModerateLockComments$2(z));
        obj = CompletablesKt.m24074b((Completable) (z ? new RedditModeratorLinkActions$onModerateLockComments$lock$1(redditModeratorLinkActions.f28370a) : new RedditModeratorLinkActions$onModerateLockComments$lock$2(redditModeratorLinkActions.f28370a)).mo6492a(linkPresentationModel.getName()), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateLockComments$3.f28310a, new RedditModeratorLinkActions$onModerateLockComments$4(redditModeratorLinkActions, listingView2, i, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "lock(presentationLink.na…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4874d(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.f33992s ^ 1;
        m29615a(listingView2, list3, list4, i, intValue, new RedditModeratorLinkActions$onModeratePinAnnouncement$1(z), new RedditModeratorLinkActions$onModeratePinAnnouncement$2(z));
        obj = CompletablesKt.m24074b((Completable) (z ? new RedditModeratorLinkActions$onModeratePinAnnouncement$pin$1(redditModeratorLinkActions.f28370a) : new RedditModeratorLinkActions$onModeratePinAnnouncement$pin$2(redditModeratorLinkActions.f28370a)).mo6492a(linkPresentationModel.getName()), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModeratePinAnnouncement$3.f28340a, new RedditModeratorLinkActions$onModeratePinAnnouncement$4(redditModeratorLinkActions, listingView2, i, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "pin(presentationLink.nam…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4875e(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        if (!Intrinsics.m26845a(linkPresentationModel2.f33993t, DistinguishType.c)) {
            if (!Intrinsics.m26845a(linkPresentationModel2.f33993t, DistinguishType.d)) {
                DistinguishType distinguishType;
                if (Intrinsics.m26845a(linkPresentationModel2.f33993t, DistinguishType.b)) {
                    distinguishType = DistinguishType.a;
                } else {
                    distinguishType = DistinguishType.b;
                }
                DistinguishType distinguishType2 = distinguishType;
                int i2 = i;
                m29615a(listingView2, list3, list4, i2, intValue, new RedditModeratorLinkActions$onModerateDistinguish$1(Intrinsics.m26845a((Object) distinguishType2, DistinguishType.a) ? Link.Companion.getMODERATOR() : null), new RedditModeratorLinkActions$onModerateDistinguish$2(distinguishType2));
                obj = CompletablesKt.m24074b(redditModeratorLinkActions.f28370a.m22411a(linkPresentationModel.getName(), distinguishType2, false), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateDistinguish$3.f28300a, new RedditModeratorLinkActions$onModerateDistinguish$4(redditModeratorLinkActions, listingView2, i2, size, link, list3, map2, linkPresentationModel2, list4));
                Intrinsics.m26843a(obj, "repository.distinguish(p…)\n            }\n        )");
                return obj;
            }
        }
        obj = Completable.complete().subscribe();
        Intrinsics.m26843a(obj, "Completable.complete().subscribe()");
        return obj;
    }

    public final <T extends Listable> Disposable mo4876f(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.ab ^ 1;
        int i2 = i;
        m29615a(listingView2, list3, list4, i2, intValue, new RedditModeratorLinkActions$onModerateRemove$1(z), new RedditModeratorLinkActions$onModerateRemove$2(z));
        obj = CompletablesKt.m24074b(redditModeratorLinkActions.f28370a.m22412a(linkPresentationModel.getName(), false), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateRemove$3.f28350a, new RedditModeratorLinkActions$onModerateRemove$4(redditModeratorLinkActions, listingView2, i2, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "repository.remove(presen…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4877g(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.ab ^ true;
        int i2 = i;
        m29615a(listingView2, list3, list4, i2, intValue, new RedditModeratorLinkActions$onModerateRemoveAsSpam$1(z), new RedditModeratorLinkActions$onModerateRemoveAsSpam$2(z));
        obj = CompletablesKt.m24074b(redditModeratorLinkActions.f28370a.m22412a(linkPresentationModel.getName(), true), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateRemoveAsSpam$3.f28360a, new RedditModeratorLinkActions$onModerateRemoveAsSpam$4(redditModeratorLinkActions, listingView2, i2, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "repository.remove(presen…)\n            }\n        )");
        return obj;
    }

    public final <T extends Listable> Disposable mo4878h(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<T> list2, ListingView<? super T> listingView) {
        RedditModeratorLinkActions redditModeratorLinkActions = this;
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        List<Link> list3 = list;
        Map<String, Integer> map2 = map;
        Intrinsics.m26847b(linkPresentationModel2, "presentationLink");
        Intrinsics.m26847b(list3, "links");
        Intrinsics.m26847b(map2, "linkPositions");
        List<T> list4 = list2;
        Intrinsics.m26847b(list4, "presentationModels");
        ListingView<? super T> listingView2 = listingView;
        Intrinsics.m26847b(listingView2, "view");
        Object obj = map2.get(linkPresentationModel2.f33976c);
        if (obj == null) {
            Intrinsics.m26842a();
        }
        int intValue = ((Number) obj).intValue();
        int size = list2.size();
        Link link = (Link) list3.get(intValue);
        boolean z = linkPresentationModel2.f33996w ^ 1;
        int i2 = i;
        m29615a(listingView2, list3, list4, i2, intValue, new RedditModeratorLinkActions$onModerateApprove$1(z), new RedditModeratorLinkActions$onModerateApprove$2(z));
        obj = CompletablesKt.m24074b(redditModeratorLinkActions.f28370a.m22430i(linkPresentationModel.getName()), redditModeratorLinkActions.f28371b).subscribe(RedditModeratorLinkActions$onModerateApprove$3.f28290a, new RedditModeratorLinkActions$onModerateApprove$4(redditModeratorLinkActions, listingView2, i2, size, link, list3, map2, linkPresentationModel2, list4));
        Intrinsics.m26843a(obj, "repository.approve(prese…)\n            }\n        )");
        return obj;
    }

    public static final /* synthetic */ void m29616a(RedditModeratorLinkActions redditModeratorLinkActions, ListingView listingView, int i, int i2, Link link, List list, Map map, LinkPresentationModel linkPresentationModel, List list2) {
        Integer valueOf;
        List list3 = list2;
        if (i2 == list2.size()) {
            valueOf = Integer.valueOf(i);
        } else {
            Object next;
            Iterator a = SequencesKt___SequencesKt.m33708a(CollectionsKt___CollectionsKt.m41455t(new IntRange(i - 1, i + 1)), (Function1) new RedditModeratorLinkActions$getValidLinkPresentationPosition$1(list3)).mo5679a();
            while (a.hasNext()) {
                Object obj;
                next = a.next();
                if (((Listable) list3.get(((Number) next).intValue())).getUniqueID() == linkPresentationModel.getUniqueID()) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            next = null;
            valueOf = (Integer) next;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
            Map map2 = map;
            Object obj2 = map2.get(linkPresentationModel2.f33977d);
            if (obj2 == null) {
                Intrinsics.m26842a();
            }
            int intValue2 = ((Number) obj2).intValue();
            RedditModeratorLinkActions redditModeratorLinkActions2 = redditModeratorLinkActions;
            ListingView listingView2 = listingView;
            List list4 = list;
            List list5 = list3;
            Map map3 = map2;
            LinkPresentationModel linkPresentationModel3 = linkPresentationModel2;
            Link link2 = link;
            Function1 c2868x50e78e53 = new C2868x50e78e53(redditModeratorLinkActions2, listingView2, list4, list5, map3, linkPresentationModel3, link2);
            m29615a(listingView, list, list3, intValue, intValue2, c2868x50e78e53, new C2869x50e78e54(redditModeratorLinkActions2, listingView2, list4, list5, map3, linkPresentationModel3, link2));
        }
    }
}
