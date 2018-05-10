package com.bluelinelabs.conductor.internal;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;

public class ViewAttachHandler implements OnAttachStateChangeListener {
    public boolean f3184a = false;
    public OnAttachStateChangeListener f3185b;
    private boolean f3186c = false;
    private boolean f3187d = false;
    private ReportedState f3188e = ReportedState.VIEW_DETACHED;
    private ViewAttachListener f3189f;

    private interface ChildAttachListener {
        void mo868a();
    }

    private enum ReportedState {
        VIEW_DETACHED,
        ACTIVITY_STOPPED,
        ATTACHED
    }

    public interface ViewAttachListener {
        void mo850a();

        void mo851a(boolean z);

        void mo852b();
    }

    class C10551 implements ChildAttachListener {
        final /* synthetic */ ViewAttachHandler f12261a;

        C10551(ViewAttachHandler viewAttachHandler) {
            this.f12261a = viewAttachHandler;
        }

        public final void mo868a() {
            this.f12261a.f3187d = true;
            this.f12261a.m2772a();
        }
    }

    public ViewAttachHandler(ViewAttachListener viewAttachListener) {
        this.f3189f = viewAttachListener;
    }

    public void onViewAttachedToWindow(View view) {
        if (!this.f3186c) {
            this.f3186c = true;
            final ChildAttachListener c10551 = new C10551(this);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() == 0) {
                    c10551.mo868a();
                    return;
                }
                this.f3185b = new OnAttachStateChangeListener(this) {
                    boolean f3177a = null;
                    final /* synthetic */ ViewAttachHandler f3179c;

                    public void onViewDetachedFromWindow(View view) {
                    }

                    public void onViewAttachedToWindow(View view) {
                        if (!this.f3177a) {
                            this.f3177a = true;
                            c10551.mo868a();
                            view.removeOnAttachStateChangeListener(this);
                            this.f3179c.f3185b = null;
                        }
                    }
                };
                m2768a(viewGroup).addOnAttachStateChangeListener(this.f3185b);
                return;
            }
            c10551.mo868a();
        }
    }

    public void onViewDetachedFromWindow(View view) {
        this.f3186c = false;
        if (this.f3187d) {
            this.f3187d = false;
            m2773a(false);
        }
    }

    public final void m2772a() {
        if (this.f3186c && this.f3187d && !this.f3184a && this.f3188e != ReportedState.ATTACHED) {
            this.f3188e = ReportedState.ATTACHED;
            this.f3189f.mo850a();
        }
    }

    public final void m2773a(boolean z) {
        Object obj = this.f3188e == ReportedState.ACTIVITY_STOPPED ? 1 : null;
        if (z) {
            this.f3188e = ReportedState.ACTIVITY_STOPPED;
        } else {
            this.f3188e = ReportedState.VIEW_DETACHED;
        }
        if (obj == null || z) {
            this.f3189f.mo851a(z);
        } else {
            this.f3189f.mo852b();
        }
    }

    public static View m2768a(ViewGroup viewGroup) {
        while (viewGroup.getChildCount() != 0) {
            viewGroup = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (!(viewGroup instanceof ViewGroup)) {
                return viewGroup;
            }
            viewGroup = viewGroup;
        }
        return viewGroup;
    }
}
