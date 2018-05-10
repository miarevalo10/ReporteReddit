package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerContract.kt */
public interface LinkPagerContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "", "()V", "linkPosition", "", "getLinkPosition", "()I", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "selectedLinkId", "", "getSelectedLinkId", "()Ljava/lang/String;", "HistoryParameters", "StandardParameters", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters$StandardParameters;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters$HistoryParameters;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerContract.kt */
    public static abstract class Parameters {

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters$HistoryParameters;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "selectedLinkId", "", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "username", "sort", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "(Ljava/lang/String;ILcom/reddit/frontpage/presentation/listing/common/ListingType;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;)V", "getLinkPosition", "()I", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "getSelectedLinkId", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "getUsername", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerContract.kt */
        public static final class HistoryParameters extends Parameters {
            final String f28414a;
            final HistorySortType f28415b;
            private final String f28416c;
            private final int f28417d;
            private final ListingType f28418e;

            public final String mo4888a() {
                return this.f28416c;
            }

            public final int mo4889b() {
                return this.f28417d;
            }

            public final ListingType mo4890c() {
                return this.f28418e;
            }

            public HistoryParameters(String str, int i, ListingType listingType, String str2, HistorySortType historySortType) {
                Intrinsics.m26847b(str, "selectedLinkId");
                Intrinsics.m26847b(listingType, "listingType");
                Intrinsics.m26847b(str2, "username");
                Intrinsics.m26847b(historySortType, "sort");
                super();
                this.f28416c = str;
                this.f28417d = i;
                this.f28418e = listingType;
                this.f28414a = str2;
                this.f28415b = historySortType;
            }
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters$StandardParameters;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Parameters;", "selectedLinkId", "", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Ljava/lang/String;ILcom/reddit/frontpage/presentation/listing/common/ListingType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getLinkPosition", "()I", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "getSelectedLinkId", "()Ljava/lang/String;", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: LinkPagerContract.kt */
        public static final class StandardParameters extends Parameters {
            final SortType f28419a;
            final SortTimeFrame f28420b;
            private final String f28421c;
            private final int f28422d;
            private final ListingType f28423e;

            public final String mo4888a() {
                return this.f28421c;
            }

            public final int mo4889b() {
                return this.f28422d;
            }

            public final ListingType mo4890c() {
                return this.f28423e;
            }

            public StandardParameters(String str, int i, ListingType listingType, SortType sortType, SortTimeFrame sortTimeFrame) {
                Intrinsics.m26847b(str, "selectedLinkId");
                Intrinsics.m26847b(listingType, "listingType");
                Intrinsics.m26847b(sortType, "sort");
                super();
                this.f28421c = str;
                this.f28422d = i;
                this.f28423e = listingType;
                this.f28419a = sortType;
                this.f28420b = sortTimeFrame;
            }
        }

        public abstract String mo4888a();

        public abstract int mo4889b();

        public abstract ListingType mo4890c();

        private Parameters() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$View;", "", "notifyListingChanged", "", "notifyLoadError", "notifyLoadMoreError", "setCurrentPosition", "position", "", "setListing", "listing", "", "Lcom/reddit/frontpage/domain/model/Link;", "showContentView", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerContract.kt */
    public interface View {
        void mo7359a();

        void mo7360a(int i);

        void mo7361a(List<Link> list);

        void mo7362b();

        void mo7363c();

        void mo7364d();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "loadMore", "", "onPageSelected", "position", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }
}
