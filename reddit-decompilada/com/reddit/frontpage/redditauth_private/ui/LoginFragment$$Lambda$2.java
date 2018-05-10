package com.reddit.frontpage.redditauth_private.ui;

import android.widget.Button;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class LoginFragment$$Lambda$2 implements Consumer {
    private final LoginFragment f28843a;

    LoginFragment$$Lambda$2(LoginFragment loginFragment) {
        this.f28843a = loginFragment;
    }

    public final void accept(Object obj) {
        LoginFragment loginFragment = this.f28843a;
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        boolean z = false;
        boolean z2 = loginFragment.username.getText().length() == 0;
        obj = textViewAfterTextChangeEvent.b().length() == null ? 1 : null;
        Button button = loginFragment.loginButton;
        if (!z2 && obj == null) {
            z = true;
        }
        button.setEnabled(z);
    }
}
