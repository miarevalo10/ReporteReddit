package com.reddit.frontpage.redditauth_private.ui;

import android.widget.Button;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class RegisterFragment$$Lambda$2 implements Consumer {
    private final RegisterFragment f28848a;

    RegisterFragment$$Lambda$2(RegisterFragment registerFragment) {
        this.f28848a = registerFragment;
    }

    public final void accept(Object obj) {
        RegisterFragment registerFragment = this.f28848a;
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        boolean z = false;
        boolean z2 = registerFragment.username.getText().length() == 0;
        obj = textViewAfterTextChangeEvent.b().length() == null ? 1 : null;
        Button button = registerFragment.registerButton;
        if (!z2 && obj == null) {
            z = true;
        }
        button.setEnabled(z);
    }
}
