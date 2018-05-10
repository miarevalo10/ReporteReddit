package com.reddit.frontpage.presentation.subreddit.rules.presenter;

import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "description", "", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditRulesPresenter.kt */
final class SubredditRulesPresenter$loadSubredditDescription$3<T> implements Consumer<String> {
    final /* synthetic */ SubredditRulesPresenter f28796a;

    SubredditRulesPresenter$loadSubredditDescription$3(SubredditRulesPresenter subredditRulesPresenter) {
        this.f28796a = subredditRulesPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Object obj2;
        String str = (String) obj;
        CharSequence charSequence = str;
        if (charSequence != null) {
            if (!StringsKt__StringsJVMKt.m41943a(charSequence)) {
                obj2 = null;
                if (obj2 != null) {
                    View a = this.f28796a.f34173a;
                    if (str == null) {
                        Intrinsics.m26842a();
                    }
                    a.mo7186a(str);
                }
                this.f28796a.f34173a.mo7188b();
                return;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            this.f28796a.f34173a.mo7188b();
            return;
        }
        View a2 = this.f28796a.f34173a;
        if (str == null) {
            Intrinsics.m26842a();
        }
        a2.mo7186a(str);
    }
}
