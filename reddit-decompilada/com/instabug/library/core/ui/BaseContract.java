package com.instabug.library.core.ui;

public interface BaseContract {

    public interface Presenter {
    }

    public interface View<C> {
        void finishActivity();

        C getViewContext();
    }
}
