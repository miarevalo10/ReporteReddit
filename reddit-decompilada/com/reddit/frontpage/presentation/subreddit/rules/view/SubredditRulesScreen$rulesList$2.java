package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesScreen.kt */
final class SubredditRulesScreen$rulesList$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ SubredditRulesScreen f37090a;

    SubredditRulesScreen$rulesList$2(SubredditRulesScreen subredditRulesScreen) {
        this.f37090a = subredditRulesScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View a = this.f37090a.K;
        if (a == null) {
            Intrinsics.m26842a();
        }
        return (RecyclerView) a.findViewById(C1761R.id.rules);
    }
}
