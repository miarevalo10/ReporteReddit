package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&JV\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH&JH\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J:\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030%H&J:\u0010'\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&J:\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&J:\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&J>\u0010*\u001a\u00020\u0003\"\b\b\u0000\u0010+*\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H+0,2\u0006\u0010 \u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH&¨\u0006."}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "", "onCommentsSelected", "", "presentationLinkPosition", "", "presentationLink", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "linkPositions", "", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "onCommunitySelected", "onCrossPostSelected", "links", "", "Lcom/reddit/frontpage/domain/model/Link;", "onHideLinkSelected", "", "", "presentationModels", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "onLinkHidden", "Lkotlin/Function0;", "onLinkSelected", "onModerateSelected", "onPreviewSelected", "link", "onReportLinkSelected", "view", "Lcom/reddit/frontpage/presentation/listing/common/ReportableLinkActionView;", "onLinkReported", "Lkotlin/Function1;", "", "onSaveLinkSelected", "onShareSelected", "onSourceSelected", "onSubscribeLinkSelected", "T", "Lcom/reddit/frontpage/presentation/listing/common/ListingView;", "onLinkSubscribed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserLinkActions.kt */
public interface UserLinkActions {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: UserLinkActions.kt */
    public static final class DefaultImpls {
    }

    <T extends Listable> void mo4879a(int i, ListingView<? super T> listingView, Link link, Function0<Unit> function0);

    void mo4880a(int i, LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map, List<Listable> list2, Function0<Unit> function0);

    void mo4881a(Link link, LinkPresentationModel linkPresentationModel);

    void mo4882a(LinkPresentationModel linkPresentationModel);

    void mo4883a(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map);

    void mo4884a(LinkPresentationModel linkPresentationModel, Map<String, Integer> map, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame);

    void mo4885b(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map);

    void mo4886b(LinkPresentationModel linkPresentationModel, Map<String, Integer> map, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame);

    void mo4887c(LinkPresentationModel linkPresentationModel, List<Link> list, Map<String, Integer> map);
}
