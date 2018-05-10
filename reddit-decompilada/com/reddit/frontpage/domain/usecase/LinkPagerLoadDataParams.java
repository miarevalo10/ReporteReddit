package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "(Lcom/reddit/frontpage/presentation/listing/common/ListingType;)V", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "HistoryParams", "StandardParams", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
public abstract class LinkPagerLoadDataParams implements Params {
    public final ListingType f28013a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB!\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams;", "selectedLinkId", "", "username", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;)V", "getSelectedLinkId", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "getUsername", "LoadData", "LoadMore", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams$LoadData;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams$LoadMore;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerLoadData.kt */
    public static abstract class HistoryParams extends LinkPagerLoadDataParams {
        final String f33742b;
        public final String f33743c;
        public final HistorySortType f33744d;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams$LoadData;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams;", "selectedLinkId", "", "linkPosition", "", "username", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;)V", "getLinkPosition", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerLoadData.kt */
        public static final class LoadData extends HistoryParams {
            final int f36339e;

            public LoadData(String str, int i, String str2, HistorySortType historySortType) {
                Intrinsics.m26847b(str2, "username");
                Intrinsics.m26847b(historySortType, "sort");
                super(str, str2, historySortType);
                this.f36339e = i;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams$LoadMore;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams;", "after", "", "username", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;)V", "getAfter", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerLoadData.kt */
        public static final class LoadMore extends HistoryParams {
            public final String f36340e;

            public LoadMore(String str, String str2, HistorySortType historySortType) {
                Intrinsics.m26847b(str2, "username");
                Intrinsics.m26847b(historySortType, "sort");
                super(null, str2, historySortType);
                this.f36340e = str;
            }
        }

        private HistoryParams(String str, String str2, HistorySortType historySortType) {
            super(ListingType.f20577d);
            this.f33742b = str;
            this.f33743c = str2;
            this.f33744d = historySortType;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B-\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams;", "selectedLinkId", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/common/ListingType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getSelectedLinkId", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "LoadData", "LoadMore", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams$LoadData;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams$LoadMore;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerLoadData.kt */
    public static abstract class StandardParams extends LinkPagerLoadDataParams {
        final String f33745b;
        public final SortType f33746c;
        public final SortTimeFrame f33747d;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams$LoadData;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams;", "linkId", "", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/lang/String;ILcom/reddit/frontpage/presentation/listing/common/ListingType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getLinkPosition", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerLoadData.kt */
        public static final class LoadData extends StandardParams {
            final int f36341e;

            public LoadData(String str, int i, ListingType listingType, SortType sortType, SortTimeFrame sortTimeFrame) {
                Intrinsics.m26847b(str, "linkId");
                Intrinsics.m26847b(listingType, "listingType");
                Intrinsics.m26847b(sortType, "sort");
                super(str, listingType, sortType, sortTimeFrame);
                this.f36341e = i;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams$LoadMore;", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams;", "after", "", "adDistance", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/common/ListingType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getAdDistance", "()Ljava/lang/String;", "getAfter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerLoadData.kt */
        public static final class LoadMore extends StandardParams {
            public final String f36342e;
            final String f36343f;

            public LoadMore(String str, String str2, ListingType listingType, SortType sortType, SortTimeFrame sortTimeFrame) {
                Intrinsics.m26847b(listingType, "listingType");
                Intrinsics.m26847b(sortType, "sort");
                super(null, listingType, sortType, sortTimeFrame);
                this.f36342e = str;
                this.f36343f = str2;
            }
        }

        private StandardParams(String str, ListingType listingType, SortType sortType, SortTimeFrame sortTimeFrame) {
            super(listingType);
            this.f33745b = str;
            this.f33746c = sortType;
            this.f33747d = sortTimeFrame;
        }
    }

    private LinkPagerLoadDataParams(ListingType listingType) {
        this.f28013a = listingType;
    }
}
