package com.bluelinelabs.conductor.internal;

import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeCompletedListener;

public class NoOpControllerChangeHandler extends ControllerChangeHandler {
    public final boolean mo867c() {
        return true;
    }

    public final void mo862a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener) {
        controllerChangeCompletedListener.mo853a();
    }

    public final ControllerChangeHandler mo866b() {
        return new NoOpControllerChangeHandler();
    }
}
