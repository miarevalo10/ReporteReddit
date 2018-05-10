package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesScreen.kt */
final class SubredditRulesScreen$description$2 extends Lambda implements Function0<BaseHtmlTextView> {
    final /* synthetic */ SubredditRulesScreen f37086a;

    SubredditRulesScreen$description$2(SubredditRulesScreen subredditRulesScreen) {
        this.f37086a = subredditRulesScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View a = this.f37086a.K;
        if (a == null) {
            Intrinsics.m26842a();
        }
        return (BaseHtmlTextView) a.findViewById(C1761R.id.subreddit_description);
    }
}
