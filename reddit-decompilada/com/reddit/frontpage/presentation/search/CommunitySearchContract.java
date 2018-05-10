package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.presentation.common.BasePresenter;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchContract;", "", "CommunitySearchItemComparable", "CommunitySearchResultsPresenter", "CommunityTypeAheadSearchPresenter", "RecentSearchPresenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchContract.kt */
public interface CommunitySearchContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;", "", "currentQuery", "", "getCurrentQuery", "()Ljava/lang/String;", "query", "Lio/reactivex/Observable;", "getQuery", "()Lio/reactivex/Observable;", "diffAndSetItems", "", "items", "", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "showLoadError", "showNoResults", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CommunitySearchContract.kt */
    public interface View {
        Observable<String> mo7424a();

        void mo7428a(List<? extends CommunitySearchItem> list);

        String mo7429b();

        void mo7430c();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchResultsPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchItemComparable;", "onItemClicked", "", "position", "", "onItemSubscribed", "onLoadMoreMore", "onQuerySubmitted", "query", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface CommunitySearchResultsPresenter extends BasePresenter {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunityTypeAheadSearchPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchItemComparable;", "onItemClicked", "", "position", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface CommunityTypeAheadSearchPresenter extends BasePresenter {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$RecentSearchPresenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$CommunitySearchItemComparable;", "onItemClicked", "", "position", "", "onItemDismissed", "onQuerySubmitted", "query", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface RecentSearchPresenter extends BasePresenter {
    }
}
