package com.reddit.frontpage.ui.home;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/ui/home/HomeLoggedOutScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/home/HomeTab;", "()V", "newUserLayoutListener", "com/reddit/frontpage/ui/home/HomeLoggedOutScreen$newUserLayoutListener$1", "Lcom/reddit/frontpage/ui/home/HomeLoggedOutScreen$newUserLayoutListener$1;", "getAnalyticsPageType", "", "getLayoutId", "", "notifyOffScreen", "", "notifyOnScreen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppBarOffsetChanged", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "verticalOffset", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HomeLoggedOutScreen.kt */
public final class HomeLoggedOutScreen extends BaseScreen implements HomeTab {
    public static final Companion f39171v = new Companion();
    private final HomeLoggedOutScreen$newUserLayoutListener$1 f39172w = new HomeLoggedOutScreen$newUserLayoutListener$1(this);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/home/HomeLoggedOutScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "newInstance", "Lcom/reddit/frontpage/ui/home/HomeLoggedOutScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HomeLoggedOutScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static HomeLoggedOutScreen m23371a() {
            return new HomeLoggedOutScreen();
        }
    }

    public static final HomeLoggedOutScreen m39147w() {
        return Companion.m23371a();
    }

    public final void ap() {
    }

    public final void aq() {
    }

    public final String getAnalyticsPageType() {
        return "home";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_home_logged_out;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        layoutInflater.inflate(C1761R.layout.login_buttons, (FrameLayout) obj.findViewById(C1761R.id.action_container));
        layoutInflater = SessionManager.b();
        viewGroup = this.K;
        Object obj2 = (Button) viewGroup.findViewById(C1761R.id.login_button);
        Intrinsics.m26843a(obj2, "login_button");
        ((View) obj2).setOnClickListener(new HomeLoggedOutScreen$inlined$sam$OnClickListener$i$7f478c20(new HomeLoggedOutScreen$onCreateView$$inlined$apply$lambda$1(this, layoutInflater)));
        obj2 = (Button) viewGroup.findViewById(C1761R.id.signup_button);
        Intrinsics.m26843a(obj2, "signup_button");
        ((View) obj2).setOnClickListener((OnClickListener) new HomeLoggedOutScreen$inlined$sam$OnClickListener$i$7f478c20(new HomeLoggedOutScreen$onCreateView$$inlined$apply$lambda$2(this, layoutInflater)));
        ViewGroup viewGroup2 = (ConstraintLayout) viewGroup.findViewById(C1761R.id.new_user_container);
        ViewsKt.m24105b(viewGroup2);
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener((OnGlobalLayoutListener) this.f39172w);
        Object obj3 = this.K;
        Intrinsics.m26843a(obj3, "rootView");
        return obj3;
    }

    public final void mo6987a(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (ConstraintLayout) obj.findViewById(C1761R.id.new_user_container);
        Intrinsics.m26843a(obj, "rootView.new_user_container");
        obj.getViewTreeObserver().removeOnGlobalLayoutListener(this.f39172w);
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i == 1 && i2 == 2) {
            OnboardingUtil.m23162a(this);
        }
    }

    public final void mo7215a(AppBarLayout appBarLayout, int i) {
        Intrinsics.m26847b(appBarLayout, "appBarLayout");
        appBarLayout = this.K;
        if (appBarLayout != null) {
            i = (float) ((-i) / 2);
            Object obj = (ConstraintLayout) appBarLayout.findViewById(C1761R.id.new_user_container);
            Intrinsics.m26843a(obj, "view.new_user_container");
            obj.setTranslationY(i);
            Object obj2 = (FrameLayout) appBarLayout.findViewById(C1761R.id.action_container);
            Intrinsics.m26843a(obj2, "view.action_container");
            obj2.setTranslationY(i);
        }
    }
}
