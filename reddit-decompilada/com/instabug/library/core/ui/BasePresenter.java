package com.instabug.library.core.ui;

import com.instabug.library.core.ui.BaseContract.Presenter;
import com.instabug.library.core.ui.BaseContract.View;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends View> implements Presenter {
    protected WeakReference<V> view;

    public BasePresenter(V v) {
        this.view = new WeakReference(v);
    }
}
