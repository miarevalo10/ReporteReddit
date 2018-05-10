package com.reddit.frontpage.ui.home;

import android.content.Context;
import android.view.View;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HomeLoggedOutScreen.kt */
final class HomeLoggedOutScreen$onCreateView$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ HomeLoggedOutScreen f37252a;
    final /* synthetic */ SessionManager f37253b;

    HomeLoggedOutScreen$onCreateView$$inlined$apply$lambda$2(HomeLoggedOutScreen homeLoggedOutScreen, SessionManager sessionManager) {
        this.f37252a = homeLoggedOutScreen;
        this.f37253b = sessionManager;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37253b;
        Object am_ = this.f37252a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        obj.a(ContextsKt.m24080d((Context) am_), true);
        return Unit.f25273a;
    }
}
