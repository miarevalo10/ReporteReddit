package com.reddit.frontpage.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.getbase.floatingactionbutton.AddFloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import java.util.ArrayList;
import java.util.List;

public class FloatingActionsView extends FrameLayout {
    final List<Runnable> f21866a;
    public View f21867b;
    @BindView
    public FloatingActionButton button;
    @BindView
    FloatingActionsMenu menu;
    @BindView
    public AddFloatingActionButton menuExpand;
    @BindView
    ViewStub menuStub;
    @BindView
    FloatingActionButton menuSubmitImage;
    @BindView
    FloatingActionButton menuSubmitLink;
    @BindView
    FloatingActionButton menuSubmitSelf;
    @BindView
    View overlay;

    public FloatingActionsView(Context context) {
        this(context, null);
    }

    public FloatingActionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21866a = new ArrayList();
        m24138c();
    }

    @TargetApi(21)
    public FloatingActionsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f21866a = new ArrayList();
        m24138c();
    }

    private void m24138c() {
        inflate(getContext(), C1761R.layout.merge_floating_action_view, this);
        ButterKnife.a(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.overlay.setOnTouchListener(new FloatingActionsView$$Lambda$0(this));
        postDelayed(new FloatingActionsView$$Lambda$1(this), 250);
    }

    final void m24139a() {
        for (Runnable run : this.f21866a) {
            run.run();
        }
        this.f21866a.clear();
    }

    public final void m24140a(Runnable runnable) {
        if (this.menuSubmitImage != null) {
            runnable.run();
        } else {
            this.f21866a.add(runnable);
        }
    }

    public View getActiveView() {
        return this.f21867b;
    }

    public void setButtonIcon(int i) {
        this.button.setIconDrawable(ResourcesUtil.m22736g(getContext(), i));
    }

    public final void m24141b() {
        m24140a(new FloatingActionsView$$Lambda$8(this));
    }

    public void setButtonOnClickedListener(OnClickListener onClickListener) {
        this.button.setOnClickListener(onClickListener);
    }

    public void setMenuOnClickedListener(OnClickListener onClickListener) {
        m24140a(new FloatingActionsView$$Lambda$9(this, onClickListener));
    }

    public void setMenuSubmitMediaOnClickedListener(OnClickListener onClickListener) {
        m24140a(new FloatingActionsView$$Lambda$10(this, onClickListener));
    }

    public void setMenuSubmitSelfOnClickedListener(OnClickListener onClickListener) {
        m24140a(new FloatingActionsView$$Lambda$11(this, onClickListener));
    }

    public void setMenuSubmitLinkOnClickedListener(OnClickListener onClickListener) {
        m24140a(new FloatingActionsView$$Lambda$12(this, onClickListener));
    }

    public static void m24137a(final View view, boolean z) {
        if (view.getVisibility() != 8) {
            if (z) {
                z = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{view.getAlpha(), 0.0f});
                z.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        view.setVisibility(8);
                        view.setEnabled(false);
                    }
                });
                z.start();
                return;
            }
            view.setVisibility(8);
            view.setEnabled(false);
        }
    }
}
