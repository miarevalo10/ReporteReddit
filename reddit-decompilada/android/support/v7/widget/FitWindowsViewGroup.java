package android.support.v7.widget;

import android.graphics.Rect;

public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void mo426a(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
