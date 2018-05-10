package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics.DefaultImpls;
import com.reddit.frontpage.presentation.search.CommunityTypeAheadSearchPresenter.Result.Error;
import com.reddit.frontpage.presentation.search.CommunityTypeAheadSearchPresenter.Result.Success;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunityTypeAheadSearchPresenter.kt */
final class CommunityTypeAheadSearchPresenter$attach$4<T> implements Consumer<Result> {
    final /* synthetic */ CommunityTypeAheadSearchPresenter f28778a;

    CommunityTypeAheadSearchPresenter$attach$4(CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter) {
        this.f28778a = communityTypeAheadSearchPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Result) obj;
        if (obj instanceof Success) {
            Success success = (Success) obj;
            Object obj2 = success.f28771a;
            CommunitySearchTypeAheadMoreResultsItem communitySearchTypeAheadMoreResultsItem = success.f28772b;
            List list = success.f28773c;
            obj = success.f28774d;
            if ((Intrinsics.m26845a(this.f28778a.f37067c.mo7429b(), obj2) ^ 1) == 0) {
                MutableListsKt.m24089a(this.f28778a.f37066b, obj);
                MutableListsKt.m24089a(this.f28778a.f37065a, list);
                this.f28778a.f37067c.mo7428a(CollectionsKt___CollectionsKt.m41419a((Collection) obj, (Object) communitySearchTypeAheadMoreResultsItem));
                Iterable<CommunitySearchTypeAheadItem> iterable = (Iterable) obj;
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (CommunitySearchTypeAheadItem communitySearchTypeAheadItem : iterable) {
                    String str = communitySearchTypeAheadItem.f28765c.f20472d;
                    if (str == null) {
                        Intrinsics.m26842a();
                    }
                    arrayList.add(str);
                }
                int i = null;
                for (String str2 : (List) arrayList) {
                    int i2 = i + 1;
                    SearchResultItem searchResultItem = (SearchResultItem) list.get(i);
                    if (searchResultItem instanceof SubredditSearchResultItem) {
                        DefaultImpls.m22656a(this.f28778a.f37073i, i, str2, null, ((SubredditSearchResultItem) searchResultItem).getSubreddit(), 4);
                    } else if (searchResultItem instanceof AccountSearchResultItem) {
                        DefaultImpls.m22656a(this.f28778a.f37073i, i, str2, ((AccountSearchResultItem) searchResultItem).getAccount(), null, 8);
                    }
                    i = i2;
                }
            }
        } else if (Intrinsics.m26845a(obj, Error.f28770a) != null) {
            this.f28778a.f37065a.clear();
            this.f28778a.f37066b.clear();
            this.f28778a.f37067c.mo7428a(CollectionsKt__CollectionsKt.m26791a(new CommunitySearchTypeAheadMoreResultsItem(this.f28778a.f37067c.mo7429b())));
        }
    }
}
