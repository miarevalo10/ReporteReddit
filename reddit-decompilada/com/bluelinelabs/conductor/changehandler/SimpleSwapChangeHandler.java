package com.bluelinelabs.conductor.changehandler;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeCompletedListener;

public class SimpleSwapChangeHandler extends ControllerChangeHandler implements OnAttachStateChangeListener {
    private boolean f12257b;
    private boolean f12258c;
    private ViewGroup f12259d;
    private ControllerChangeCompletedListener f12260e;

    public final boolean mo867c() {
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
    }

    public SimpleSwapChangeHandler() {
        this(true);
    }

    public SimpleSwapChangeHandler(boolean z) {
        this.f12257b = z;
    }

    public final void mo861a(Bundle bundle) {
        super.mo861a(bundle);
        bundle.putBoolean("SimpleSwapChangeHandler.removesFromViewOnPush", this.f12257b);
    }

    public final void mo864b(Bundle bundle) {
        super.mo864b(bundle);
        this.f12257b = bundle.getBoolean("SimpleSwapChangeHandler.removesFromViewOnPush");
    }

    public final void mo863a(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.mo863a(controllerChangeHandler, controller);
        this.f12258c = true;
    }

    public final void mo860a() {
        if (this.f12260e != null) {
            this.f12260e.mo853a();
            this.f12260e = null;
            this.f12259d.removeOnAttachStateChangeListener(this);
            this.f12259d = null;
        }
    }

    public final void mo862a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (!this.f12258c) {
            if (view != null && (!z || this.f12257b)) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
        }
        if (viewGroup.getWindowToken() != null) {
            controllerChangeCompletedListener.mo853a();
            return;
        }
        this.f12260e = controllerChangeCompletedListener;
        this.f12259d = viewGroup;
        viewGroup.addOnAttachStateChangeListener(this);
    }

    public final boolean mo865e() {
        return this.f12257b;
    }

    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        if (this.f12260e != null) {
            this.f12260e.mo853a();
            this.f12260e = null;
            this.f12259d = null;
        }
    }

    public final ControllerChangeHandler mo866b() {
        return new SimpleSwapChangeHandler(this.f12257b);
    }
}
