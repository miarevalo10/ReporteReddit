package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.view.View;
import android.widget.ScrollView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesScreen.kt */
final class SubredditRulesScreen$descriptionContainer$2 extends Lambda implements Function0<ScrollView> {
    final /* synthetic */ SubredditRulesScreen f37087a;

    SubredditRulesScreen$descriptionContainer$2(SubredditRulesScreen subredditRulesScreen) {
        this.f37087a = subredditRulesScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View a = this.f37087a.K;
        if (a == null) {
            Intrinsics.m26842a();
        }
        return (ScrollView) a.findViewById(C1761R.id.description_container);
    }
}
