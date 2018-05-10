package com.reddit.frontpage.redditauth_private.ui;

import android.widget.Button;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class RegisterFragment$$Lambda$1 implements Consumer {
    private final RegisterFragment f28847a;

    RegisterFragment$$Lambda$1(RegisterFragment registerFragment) {
        this.f28847a = registerFragment;
    }

    public final void accept(Object obj) {
        RegisterFragment registerFragment = this.f28847a;
        boolean z = false;
        obj = ((TextViewAfterTextChangeEvent) obj).b().length() == null ? 1 : null;
        boolean z2 = registerFragment.password.getText().length() == 0;
        Button button = registerFragment.registerButton;
        if (obj == null && !z2) {
            z = true;
        }
        button.setEnabled(z);
    }
}
