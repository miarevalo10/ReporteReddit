package com.reddit.frontpage.presentation.subreddit.rules.presenter;

import com.reddit.datalibrary.frontpage.data.model.SubredditRulesResponse;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesPresenter.kt */
final class SubredditRulesPresenter$attach$1<T, R> implements Function<T, R> {
    public static final SubredditRulesPresenter$attach$1 f28791a = new SubredditRulesPresenter$attach$1();

    SubredditRulesPresenter$attach$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        SubredditRulesResponse subredditRulesResponse = (SubredditRulesResponse) obj;
        Intrinsics.m26847b(subredditRulesResponse, "it");
        return subredditRulesResponse.getSubredditRules();
    }
}
