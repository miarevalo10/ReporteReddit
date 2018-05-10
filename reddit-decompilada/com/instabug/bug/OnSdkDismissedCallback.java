package com.instabug.bug;

import com.instabug.bug.model.C0478b;

public interface OnSdkDismissedCallback {

    public enum DismissType {
        SUBMIT,
        CANCEL,
        ADD_ATTACHMENT
    }

    void onSdkDismissed(DismissType dismissType, C0478b c0478b);
}
