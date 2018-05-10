package com.bluelinelabs.conductor;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;

public class ChangeHandlerFrameLayout extends FrameLayout implements ControllerChangeListener {
    private int f12222a;

    public ChangeHandlerFrameLayout(Context context) {
        super(context);
    }

    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12222a <= 0) {
            if (super.onInterceptTouchEvent(motionEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public final void mo847a(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        this.f12222a++;
    }

    public final void mo848b(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        this.f12222a--;
    }
}
