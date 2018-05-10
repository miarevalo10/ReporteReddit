package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent f5736a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f5736a = intent;
    }
}
