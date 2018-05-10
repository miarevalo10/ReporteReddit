package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.model.SearchType;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c*\b\u0012\u0004\u0012\u00020\u00100\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/search/RecentSearchPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchPresenter;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$RecentSearchPresenter;", "view", "Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;", "navigator", "Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;", "repository", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "analytics", "Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchContract$View;Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;Lcom/reddit/frontpage/domain/repository/SearchRepository;Lcom/reddit/frontpage/presentation/analytics/SearchAnalytics;Lcom/reddit/common/rx/PostExecutionThread;)V", "items", "", "", "models", "Lcom/reddit/frontpage/presentation/search/CommunitySearchItem;", "attach", "", "onItemClicked", "position", "", "onItemDismissed", "onQuerySubmitted", "query", "toPresentationModels", "", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecentSearchPresenter.kt */
public final class RecentSearchPresenter extends CommunitySearchPresenter implements com.reddit.frontpage.presentation.search.CommunitySearchContract.RecentSearchPresenter {
    public static final Companion f37076d = new Companion();
    final List<String> f37077a = ((List) new ArrayList());
    final CommunitySearchNavigator f37078b;
    final SearchAnalytics f37079c;
    private final List<CommunitySearchItem> f37080e = ((List) new ArrayList());
    private final View f37081f;
    private final SearchRepository f37082g;
    private final PostExecutionThread f37083h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/search/RecentSearchPresenter$Companion;", "", "()V", "MAX_RECENT_ITEMS", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RecentSearchPresenter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Inject
    public RecentSearchPresenter(View view, CommunitySearchNavigator communitySearchNavigator, SearchRepository searchRepository, SearchAnalytics searchAnalytics, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(communitySearchNavigator, "navigator");
        Intrinsics.m26847b(searchRepository, "repository");
        Intrinsics.m26847b(searchAnalytics, "analytics");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        this.f37081f = view;
        this.f37078b = communitySearchNavigator;
        this.f37082g = searchRepository;
        this.f37079c = searchAnalytics;
        this.f37083h = postExecutionThread;
    }

    public final void attach() {
        Object filter = this.f37081f.mo7424a().map(new RecentSearchPresenter$attach$1(this)).distinctUntilChanged((BiPredicate) RecentSearchPresenter$attach$2.f28782a).filter(RecentSearchPresenter$attach$3.f28783a).switchMap(new RecentSearchPresenter$attach$4(this)).onErrorReturn(RecentSearchPresenter$attach$5.f28787a).filter(RecentSearchPresenter$attach$6.f28788a);
        Intrinsics.m26843a(filter, "view.query\n        .map …{ it.first.isNotEmpty() }");
        filter = ObservablesKt.m24092b(filter, this.f37083h).subscribe((Consumer) new RecentSearchPresenter$attach$7(this));
        Intrinsics.m26843a(filter, "view.query\n        .map …::onRecentView)\n        }");
        handleDispose(filter);
    }

    public final void m37462a(int i) {
        String str = (String) this.f37077a.remove(i);
        this.f37080e.remove(i);
        Object subscribe = this.f37082g.m22490b(str, SearchType.SUBREDDIT).subscribe();
        Intrinsics.m26843a(subscribe, "repository.deleteQuery(query).subscribe()");
        handleDispose(subscribe);
        this.f37081f.mo7428a(this.f37080e);
    }

    public final void m37463a(String str) {
        Intrinsics.m26847b(str, "query");
        Object subscribe = CompletablesKt.m24074b(this.f37082g.m22486a(str, SearchType.SUBREDDIT), this.f37083h).subscribe();
        Intrinsics.m26843a(subscribe, "repository.saveQuery(que…ead)\n        .subscribe()");
        handleDispose(subscribe);
        this.f37078b.mo7427a(str);
    }

    public static final /* synthetic */ List m37457a(List list) {
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (String recentSearchItem : iterable) {
            arrayList.add(new RecentSearchItem(recentSearchItem));
        }
        return (List) arrayList;
    }
}
