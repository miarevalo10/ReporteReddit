package com.reddit.frontpage.presentation.onboarding;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/reddit/frontpage/presentation/onboarding/OnboardingScreen$tabListener$2$1", "invoke", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$tabListener$2$1;"}, k = 3, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
final class OnboardingScreen$tabListener$2 extends Lambda implements Function0<C23161> {
    final /* synthetic */ OnboardingScreen f37016a;

    OnboardingScreen$tabListener$2(OnboardingScreen onboardingScreen) {
        this.f37016a = onboardingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new OnScrollListener() {
            private int f28720b = -1;

            public final void m29828a(RecyclerView recyclerView, int i) {
                Intrinsics.m26847b(recyclerView, "recyclerView");
                boolean z = true;
                switch (i) {
                    case 0:
                        int m;
                        ViewsKt.m24107c(this.f37016a.m40850U());
                        Object layoutManager = recyclerView.getLayoutManager();
                        Intrinsics.m26843a(layoutManager, "recyclerView.layoutManager");
                        if (((LinearLayoutManager) ((layoutManager instanceof LinearLayoutManager) == 0 ? 0 : layoutManager)) != null) {
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                            i = linearLayoutManager.k();
                            m = ((linearLayoutManager.m() - i) / 2) + i;
                        } else {
                            m = -1;
                        }
                        if (m != this.f28720b) {
                            this.f37016a.m40850U().setText(null);
                            ((AppBarLayout) ((Lazy) this.f37016a.f40120F).mo5678b()).setExpanded(true);
                            if (Math.abs(m - (this.f28720b != -1 ? this.f28720b : 0)) > 1) {
                                z = false;
                            }
                            this.f37016a.m40849T().setCurrentItem(m, z);
                            OnboardingScreen.m40858a(this.f37016a, m);
                            this.f28720b = m;
                            break;
                        }
                        break;
                    case 1:
                        ViewsKt.m24105b(this.f37016a.m40850U());
                        ((AppBarLayout) ((Lazy) this.f37016a.f40120F).mo5678b()).setExpanded(true);
                        return;
                    default:
                        break;
                }
            }
        };
    }
}
