package com.reddit.frontpage.redditauth_private.ui;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LoginFragment_ViewBinding implements Unbinder {
    private LoginFragment f28845b;

    public LoginFragment_ViewBinding(LoginFragment loginFragment, View view) {
        this.f28845b = loginFragment;
        loginFragment.registerPrompt = (TextView) Utils.b(view, C1761R.id.register_prompt, "field 'registerPrompt'", TextView.class);
        loginFragment.loginButton = (Button) Utils.b(view, C1761R.id.confirm, "field 'loginButton'", Button.class);
        loginFragment.username = (AutoCompleteTextView) Utils.b(view, C1761R.id.username, "field 'username'", AutoCompleteTextView.class);
        loginFragment.password = (EditText) Utils.b(view, C1761R.id.password, "field 'password'", EditText.class);
        loginFragment.forgotPassword = (TextView) Utils.b(view, C1761R.id.forgot_password, "field 'forgotPassword'", TextView.class);
        loginFragment.loader = (ProgressBar) Utils.b(view, C1761R.id.loader, "field 'loader'", ProgressBar.class);
    }

    public final void m29914a() {
        LoginFragment loginFragment = this.f28845b;
        if (loginFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28845b = null;
        loginFragment.registerPrompt = null;
        loginFragment.loginButton = null;
        loginFragment.username = null;
        loginFragment.password = null;
        loginFragment.forgotPassword = null;
        loginFragment.loader = null;
    }
}
