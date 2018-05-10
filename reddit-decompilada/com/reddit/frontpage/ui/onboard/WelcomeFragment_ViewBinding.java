package com.reddit.frontpage.ui.onboard;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class WelcomeFragment_ViewBinding implements Unbinder {
    private WelcomeFragment f29176b;

    public WelcomeFragment_ViewBinding(WelcomeFragment welcomeFragment, View view) {
        this.f29176b = welcomeFragment;
        welcomeFragment.background = (ImageView) Utils.b(view, C1761R.id.background, "field 'background'", ImageView.class);
        welcomeFragment.loginButton = (Button) Utils.b(view, C1761R.id.login_button, "field 'loginButton'", Button.class);
        welcomeFragment.signupButton = (Button) Utils.b(view, C1761R.id.signup_button, "field 'signupButton'", Button.class);
        welcomeFragment.facebookButton = Utils.a(view, C1761R.id.facebook_button, "field 'facebookButton'");
        welcomeFragment.facebookProgress = (ProgressBar) Utils.b(view, C1761R.id.facebook_progress, "field 'facebookProgress'", ProgressBar.class);
        welcomeFragment.googleButton = Utils.a(view, C1761R.id.google_button, "field 'googleButton'");
        welcomeFragment.googleProgress = (ProgressBar) Utils.b(view, C1761R.id.google_progress, "field 'googleProgress'", ProgressBar.class);
        welcomeFragment.skipText = (TextView) Utils.b(view, C1761R.id.skip_text, "field 'skipText'", TextView.class);
        welcomeFragment.terms = (TextView) Utils.b(view, C1761R.id.terms, "field 'terms'", TextView.class);
    }

    public final void m30289a() {
        WelcomeFragment welcomeFragment = this.f29176b;
        if (welcomeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29176b = null;
        welcomeFragment.background = null;
        welcomeFragment.loginButton = null;
        welcomeFragment.signupButton = null;
        welcomeFragment.facebookButton = null;
        welcomeFragment.facebookProgress = null;
        welcomeFragment.googleButton = null;
        welcomeFragment.googleProgress = null;
        welcomeFragment.skipText = null;
        welcomeFragment.terms = null;
    }
}
