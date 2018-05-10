package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.bluelinelabs.conductor.ChangeHandlerFrameLayout;

public class ScreenContainer extends ChangeHandlerFrameLayout {
    public ScreenContainer(Context context) {
        super(context);
    }

    public ScreenContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ScreenContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }
}
