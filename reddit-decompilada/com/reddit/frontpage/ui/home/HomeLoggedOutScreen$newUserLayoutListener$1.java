package com.reddit.frontpage.ui.home;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"com/reddit/frontpage/ui/home/HomeLoggedOutScreen$newUserLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Lcom/reddit/frontpage/ui/home/HomeLoggedOutScreen;)V", "onGlobalLayout", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HomeLoggedOutScreen.kt */
public final class HomeLoggedOutScreen$newUserLayoutListener$1 implements OnGlobalLayoutListener {
    final /* synthetic */ HomeLoggedOutScreen f21222a;

    HomeLoggedOutScreen$newUserLayoutListener$1(HomeLoggedOutScreen homeLoggedOutScreen) {
        this.f21222a = homeLoggedOutScreen;
    }

    public final void onGlobalLayout() {
        View a = this.f21222a.K;
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a.findViewById(C1761R.id.new_user_container);
            if (constraintLayout != null) {
                constraintLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LayoutParams layoutParams = constraintLayout.getLayoutParams();
                Object a2 = this.f21222a.K;
                Intrinsics.m26843a(a2, "this@HomeLoggedOutScreen.rootView");
                layoutParams.height = a2.getHeight();
                ViewsKt.m24107c(constraintLayout);
                constraintLayout.requestLayout();
            }
        }
    }
}
