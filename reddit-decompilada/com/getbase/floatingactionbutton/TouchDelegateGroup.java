package com.getbase.floatingactionbutton;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

public class TouchDelegateGroup extends TouchDelegate {
    private static final Rect f3944d = new Rect();
    final ArrayList<TouchDelegate> f3945a = new ArrayList();
    TouchDelegate f3946b;
    boolean f3947c;

    public TouchDelegateGroup(View view) {
        super(f3944d, view);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3947c) {
            return false;
        }
        TouchDelegate touchDelegate = null;
        switch (motionEvent.getAction()) {
            case 0:
                for (int i = 0; i < this.f3945a.size(); i++) {
                    TouchDelegate touchDelegate2 = (TouchDelegate) this.f3945a.get(i);
                    if (touchDelegate2.onTouchEvent(motionEvent)) {
                        this.f3946b = touchDelegate2;
                        return true;
                    }
                }
                break;
            case 1:
            case 3:
                TouchDelegate touchDelegate3 = this.f3946b;
                this.f3946b = null;
                touchDelegate = touchDelegate3;
                break;
            case 2:
                touchDelegate = this.f3946b;
                break;
            default:
                break;
        }
        if (touchDelegate == null || touchDelegate.onTouchEvent(motionEvent) == null) {
            return false;
        }
        return true;
    }
}
