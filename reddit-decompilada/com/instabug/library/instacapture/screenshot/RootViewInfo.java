package com.instabug.library.instacapture.screenshot;

import android.view.View;
import android.view.WindowManager.LayoutParams;

public class RootViewInfo {
    private final LayoutParams layoutParams;
    private final int left;
    private final int top;
    private final View view;

    public RootViewInfo(View view, LayoutParams layoutParams) {
        this.view = view;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.left = iArr[null];
        this.top = iArr[1];
        this.layoutParams = layoutParams;
    }

    public View getView() {
        return this.view;
    }

    public int getTop() {
        return this.top;
    }

    public int getLeft() {
        return this.left;
    }

    public LayoutParams getLayoutParams() {
        return this.layoutParams;
    }
}
