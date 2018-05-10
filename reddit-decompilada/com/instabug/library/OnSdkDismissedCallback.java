package com.instabug.library;

import com.instabug.library.bugreporting.model.Bug.Type;

public interface OnSdkDismissedCallback {

    public enum DismissType {
        SUBMIT,
        CANCEL,
        ADD_ATTACHMENT
    }

    void onSdkDismissed(DismissType dismissType, Type type);
}
