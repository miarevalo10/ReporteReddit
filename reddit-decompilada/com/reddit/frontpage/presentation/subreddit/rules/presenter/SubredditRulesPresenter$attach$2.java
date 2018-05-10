package com.reddit.frontpage.presentation.subreddit.rules.presenter;

import com.reddit.datalibrary.frontpage.data.model.SubredditRule;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "rules", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesPresenter.kt */
final class SubredditRulesPresenter$attach$2<T> implements Consumer<List<? extends SubredditRule>> {
    final /* synthetic */ SubredditRulesPresenter f28792a;

    SubredditRulesPresenter$attach$2(SubredditRulesPresenter subredditRulesPresenter) {
        this.f28792a = subredditRulesPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        List list = (List) obj;
        Intrinsics.m26843a((Object) list, "rules");
        if ((list.isEmpty() ^ 1) != 0) {
            this.f28792a.f34173a.mo7190d();
            this.f28792a.f34173a.mo7187a(list);
            return;
        }
        this.f28792a.m34877a();
    }
}
