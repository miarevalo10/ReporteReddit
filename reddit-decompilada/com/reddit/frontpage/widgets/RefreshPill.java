package com.reddit.frontpage.widgets;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0002\u0014\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/widgets/RefreshPill;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "com/reddit/frontpage/widgets/RefreshPill$listener$1", "Lcom/reddit/frontpage/widgets/RefreshPill$listener$1;", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "revealAnimationListener", "com/reddit/frontpage/widgets/RefreshPill$revealAnimationListener$1", "Lcom/reddit/frontpage/widgets/RefreshPill$revealAnimationListener$1;", "trackScrolling", "", "animateIn", "", "show", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RefreshPill.kt */
public final class RefreshPill extends FrameLayout {
    public static final Companion f21942a = new Companion();
    private boolean f21943b;
    private final RefreshPill$revealAnimationListener$1 f21944c;
    private final RefreshPill$listener$1 f21945d;
    private RecyclerView f21946e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/widgets/RefreshPill$Companion;", "", "()V", "SHOW_ANIMATION_DELAY", "", "SHOW_ANIMATION_DURATION", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RefreshPill.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public RefreshPill(Context context) {
        this(context, null, 0, 6, null);
    }

    public RefreshPill(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RefreshPill(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public RefreshPill(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        View.inflate(context, C1761R.layout.view_refresh_pill, this);
        this.f21944c = new RefreshPill$revealAnimationListener$1(this);
        this.f21945d = new RefreshPill$listener$1(this, context);
    }

    public final void m24195a() {
        if (!ViewsKt.m24104a(this)) {
            RefreshPill$listener$1 refreshPill$listener$1 = this.f21945d;
            refreshPill$listener$1.f29479c = refreshPill$listener$1.f29478b;
            ViewsKt.m24103a((View) this, true);
            ViewsKt.m24102a((View) this, (Function0) new RefreshPill$show$1(this));
        }
    }

    public final RecyclerView getRecyclerView() {
        return this.f21946e;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            RecyclerView recyclerView2 = this.f21946e;
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(this.f21945d);
            }
        } else {
            recyclerView.addOnScrollListener(this.f21945d);
        }
        this.f21946e = recyclerView;
    }

    public static final /* synthetic */ void m24192a(RefreshPill refreshPill) {
        refreshPill.setY(-((float) refreshPill.getHeight()));
        refreshPill.animate().translationY(0.0f).setDuration(400).setInterpolator(new OvershootInterpolator()).setListener((AnimatorListener) refreshPill.f21944c).setStartDelay(100).start();
    }
}
