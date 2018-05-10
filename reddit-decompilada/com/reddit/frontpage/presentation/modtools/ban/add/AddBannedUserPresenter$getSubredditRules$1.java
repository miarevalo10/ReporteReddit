package com.reddit.frontpage.presentation.modtools.ban.add;

import com.reddit.datalibrary.frontpage.data.model.SubredditRulesResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: AddBannedUserPresenter.kt */
final class AddBannedUserPresenter$getSubredditRules$1<T> implements Consumer<SubredditRulesResponse> {
    final /* synthetic */ AddBannedUserPresenter f28569a;

    AddBannedUserPresenter$getSubredditRules$1(AddBannedUserPresenter addBannedUserPresenter) {
        this.f28569a = addBannedUserPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        SubredditRulesResponse subredditRulesResponse = (SubredditRulesResponse) obj;
        Intrinsics.m26847b(subredditRulesResponse, "response");
        this.f28569a.f34064a.mo7378a(subredditRulesResponse.getAllRules());
    }
}
