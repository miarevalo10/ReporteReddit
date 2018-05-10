package com.reddit.frontpage.redditauth_private.ui;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class RegisterFragment_ViewBinding implements Unbinder {
    private RegisterFragment f28849b;

    public RegisterFragment_ViewBinding(RegisterFragment registerFragment, View view) {
        this.f28849b = registerFragment;
        registerFragment.loginPrompt = (TextView) Utils.b(view, C1761R.id.login_prompt, "field 'loginPrompt'", TextView.class);
        registerFragment.username = (AutoCompleteTextView) Utils.b(view, C1761R.id.username, "field 'username'", AutoCompleteTextView.class);
        registerFragment.password = (TextView) Utils.b(view, C1761R.id.password, "field 'password'", TextView.class);
        registerFragment.recoveryEmail = (AutoCompleteTextView) Utils.b(view, C1761R.id.email, "field 'recoveryEmail'", AutoCompleteTextView.class);
        registerFragment.registerButton = (Button) Utils.b(view, C1761R.id.confirm, "field 'registerButton'", Button.class);
        registerFragment.loader = (ProgressBar) Utils.b(view, C1761R.id.loader, "field 'loader'", ProgressBar.class);
        registerFragment.terms = (TextView) Utils.b(view, C1761R.id.terms, "field 'terms'", TextView.class);
    }

    public final void m29916a() {
        RegisterFragment registerFragment = this.f28849b;
        if (registerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28849b = null;
        registerFragment.loginPrompt = null;
        registerFragment.username = null;
        registerFragment.password = null;
        registerFragment.recoveryEmail = null;
        registerFragment.registerButton = null;
        registerFragment.loader = null;
        registerFragment.terms = null;
    }
}
