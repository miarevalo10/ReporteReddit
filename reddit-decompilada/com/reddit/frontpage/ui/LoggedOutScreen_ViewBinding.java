package com.reddit.frontpage.ui;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LoggedOutScreen_ViewBinding implements Unbinder {
    private LoggedOutScreen f28885b;

    public LoggedOutScreen_ViewBinding(LoggedOutScreen loggedOutScreen, View view) {
        this.f28885b = loggedOutScreen;
        loggedOutScreen.messageView = (TextView) Utils.b(view, C1761R.id.message, "field 'messageView'", TextView.class);
        loggedOutScreen.loginButton = (Button) Utils.b(view, C1761R.id.login_button, "field 'loginButton'", Button.class);
        loggedOutScreen.signupButton = (Button) Utils.b(view, C1761R.id.signup_button, "field 'signupButton'", Button.class);
        loggedOutScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        loggedOutScreen.toolbarTitle = (TextView) Utils.b(view, C1761R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    }

    public final void m29942a() {
        LoggedOutScreen loggedOutScreen = this.f28885b;
        if (loggedOutScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28885b = null;
        loggedOutScreen.messageView = null;
        loggedOutScreen.loginButton = null;
        loggedOutScreen.signupButton = null;
        loggedOutScreen.toolbar = null;
        loggedOutScreen.toolbarTitle = null;
    }
}
