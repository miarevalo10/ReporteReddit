package com.reddit.frontpage.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import timber.log.Timber;

public class LoggedOutScreen extends BaseScreen {
    @State
    Boolean fullScreenOverride;
    @BindView
    Button loginButton;
    @BindView
    TextView messageView;
    @BindView
    Button signupButton;
    @State
    int textRes;
    @State
    int titleRes;
    @BindView
    Toolbar toolbar;
    @BindView
    TextView toolbarTitle;

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.screen_logged_out;
    }

    public static LoggedOutScreen m39031a(int i, int i2, Boolean bool) {
        LoggedOutScreen loggedOutScreen = new LoggedOutScreen();
        loggedOutScreen.titleRes = i;
        loggedOutScreen.textRes = i2;
        loggedOutScreen.fullScreenOverride = bool;
        return loggedOutScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        try {
            this.messageView.setText(ao_().getString(this.textRes));
        } catch (LayoutInflater layoutInflater2) {
            try {
                Timber.c(layoutInflater2, "Resources.NotFoundException: LoggedOutScreen message not found. Using default.", new Object[0]);
                this.messageView.setText(ao_().getString(C1761R.string.label_logged_out_inbox));
            } catch (LayoutInflater layoutInflater22) {
                Timber.c(layoutInflater22, "Resources.NotFoundException: LoggedOutScreen message not found. Using fallback.", new Object[0]);
                this.messageView.setText("Sign up to share your interests.");
            }
        }
        this.loginButton.setOnClickListener(new LoggedOutScreen$$Lambda$0(this));
        this.signupButton.setOnClickListener(new LoggedOutScreen$$Lambda$1(this));
        return this.K;
    }

    protected final void mo7185a(ActionBar actionBar) {
        try {
            this.toolbarTitle.setText(ao_().getString(this.titleRes));
            if (this.fullScreenOverride != null && this.fullScreenOverride.booleanValue()) {
                actionBar.f();
            }
        } catch (Throwable e) {
            try {
                Timber.c(e, "Resources.NotFoundException: LoggedOutScreen title not found. Using default.", new Object[0]);
                actionBar.a(ao_().getString(C1761R.string.label_join_reddit));
            } catch (ActionBar actionBar2) {
                Timber.c(actionBar2, "Resources.NotFoundException: LoggedOutScreen title not found. Using fallback.", new Object[0]);
                this.messageView.setText("Join Reddit");
            }
        }
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        if (i == 1) {
            switch (i2) {
                case 1:
                    ((RedditThemedActivity) am_()).m41959b(true);
                    return;
                case 2:
                    OnboardingUtil.m23162a(this);
                    return;
                default:
                    break;
            }
        }
        super.mo7202a(i, i2, intent);
    }

    public final int mo7143u() {
        if (this.fullScreenOverride != null) {
            return this.fullScreenOverride.booleanValue() ? 2 : 1;
        } else {
            return super.mo7143u();
        }
    }
}
