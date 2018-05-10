package com.reddit.frontpage.presentation.onboarding;

import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder$scrollListener$1", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder;)V", "lastPosition", "Landroid/graphics/Point;", "onScrollChanged", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
public final class OnboardingScreen$TabAdapterViewHolder$scrollListener$1 implements OnScrollChangedListener {
    final /* synthetic */ TabAdapterViewHolder f20941a;
    private Point f20942b;

    OnboardingScreen$TabAdapterViewHolder$scrollListener$1(TabAdapterViewHolder tabAdapterViewHolder) {
        this.f20941a = tabAdapterViewHolder;
    }

    public final void onScrollChanged() {
        if (this.f20941a.f28718q.v_()) {
            Point e = ViewsKt.m24110e(this.f20941a.f28717p);
            Point point = this.f20942b;
            if (point == null || point.x != e.x) {
                boolean z;
                this.f20942b = e;
                int width = (this.f20941a.f28718q.m40848S().getWidth() / 2) - (this.f20941a.f28717p.getWidth() / 2);
                int width2 = this.f20941a.f28715a.getWidth() / 2;
                AppCompatImageView appCompatImageView = this.f20941a.f28715a;
                int i = width - width2;
                width += width2;
                int i2 = e.x;
                if (i <= i2) {
                    if (width >= i2) {
                        z = true;
                        appCompatImageView.setSelected(z);
                        if (this.f20941a.f28715a.isSelected()) {
                            ((TextView) ((Lazy) this.f20941a.f28718q.f40121G).mo5678b()).setText(((SubredditCategory) this.f20941a.f28718q.aa().f28713a.m22715a(this.f20941a.d())).getName());
                        }
                    }
                }
                z = false;
                appCompatImageView.setSelected(z);
                if (this.f20941a.f28715a.isSelected()) {
                    ((TextView) ((Lazy) this.f20941a.f28718q.f40121G).mo5678b()).setText(((SubredditCategory) this.f20941a.f28718q.aa().f28713a.m22715a(this.f20941a.d())).getName());
                }
            }
        }
    }
}
