package com.reddit.frontpage.presentation.subreddit.rules.presenter;

import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/domain/model/Subreddit;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesPresenter.kt */
final class SubredditRulesPresenter$loadSubredditDescription$1<T, R> implements Function<T, R> {
    public static final SubredditRulesPresenter$loadSubredditDescription$1 f28794a = new SubredditRulesPresenter$loadSubredditDescription$1();

    SubredditRulesPresenter$loadSubredditDescription$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Subreddit subreddit = (Subreddit) obj;
        Intrinsics.m26847b(subreddit, "it");
        return subreddit.getDescriptionHtml();
    }
}
