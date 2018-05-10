package com.reddit.frontpage.redditauth_private.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.instabug.library.model.State;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.api.errors.LoginError;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.ui.BaseFragment;
import com.reddit.frontpage.redditauth_private.account.Credentials;
import com.reddit.frontpage.redditauth_private.account.TokenRetriever;
import com.reddit.frontpage.util.SchedulerProvider;
import timber.log.Timber;

public class RegisterFragment extends BaseFragment {
    OnRegistrationListener f37143a;
    private RegisterTask f37144b;
    private Unbinder f37145c;
    @BindView
    ProgressBar loader;
    @BindView
    TextView loginPrompt;
    @BindView
    TextView password;
    @BindView
    AutoCompleteTextView recoveryEmail;
    @BindView
    Button registerButton;
    @BindView
    TextView terms;
    @BindView
    AutoCompleteTextView username;

    class C18741 implements OnEditorActionListener {
        final /* synthetic */ RegisterFragment f21031a;

        C18741(RegisterFragment registerFragment) {
            this.f21031a = registerFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2) {
                if (i != 0) {
                    return null;
                }
            }
            textView = AppAnalytics.m21858b();
            textView.f19954a = this.f21031a.getAnalyticsScreenName();
            textView.f19955b = "continue";
            textView.m21825a();
            RegisterFragment.m37503a(this.f21031a);
            return true;
        }
    }

    class C18752 implements OnClickListener {
        final /* synthetic */ RegisterFragment f21032a;

        C18752(RegisterFragment registerFragment) {
            this.f21032a = registerFragment;
        }

        public void onClick(View view) {
            view = AppAnalytics.m21858b().m21823a(view);
            view.f19954a = this.f21032a.getAnalyticsScreenName();
            view.f19955b = "signup";
            view.m21825a();
            RegisterFragment.m37503a(this.f21032a);
        }
    }

    public interface OnRegistrationListener {
        void mo7785a(String str, Scope scope, Credentials credentials);

        void mo7789g();
    }

    private class RegisterTask extends AsyncTask<Void, Void, Credentials> {
        final /* synthetic */ RegisterFragment f21033a;
        private final RedditAuthClient f21034b;
        private final String f21035c;
        private final String f21036d;
        private final String f21037e;
        private Exception f21038f;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m23250a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Credentials credentials = (Credentials) obj;
            super.onPostExecute(credentials);
            if (!this.f21033a.isDetached()) {
                if (this.f21033a.f37143a != null) {
                    if (credentials != null) {
                        this.f21033a.f37143a.mo7785a(this.f21035c, Scope.WILD_SCOPE, credentials);
                    } else {
                        if ((this.f21038f.getCause() instanceof LoginError) != null) {
                            LoginError loginError = (LoginError) this.f21038f.getCause();
                            TextView a = RegisterFragment.m37501a(this.f21033a, loginError);
                            a.setError(loginError.b);
                            a.requestFocus();
                        } else {
                            Snackbar.a(this.f21033a.getView(), this.f21038f.getMessage(), -1).a();
                        }
                        this.f21033a.m37504a(true);
                        this.f21033a.f37143a;
                    }
                }
                this.f21033a.f37144b = null;
            }
        }

        RegisterTask(RegisterFragment registerFragment, RedditAuthClient redditAuthClient, String str, String str2, String str3) {
            this.f21033a = registerFragment;
            this.f21034b = redditAuthClient;
            this.f21035c = str;
            this.f21036d = str2;
            this.f21037e = str3;
        }

        private Credentials m23250a() {
            try {
                return TokenRetriever.m23229a(this.f21034b, this.f21035c, this.f21036d, this.f21037e);
            } catch (Throwable e) {
                Timber.c(e, "Unable to retrieve token with username and password", new Object[0]);
                this.f21038f = e;
                return null;
            }
        }
    }

    public String getAnalyticsScreenName() {
        return "signup";
    }

    public static RegisterFragment m37502a() {
        return new RegisterFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C1761R.layout.rdt_fragment_register, viewGroup, false);
        this.f37145c = ButterKnife.a(this, layoutInflater);
        this.loginPrompt.setOnClickListener(new RegisterFragment$$Lambda$0(this));
        viewGroup = this.username;
        bundle = AppAnalytics.m21867d();
        bundle.f19972a = getAnalyticsScreenName();
        bundle.f19973b = "username";
        viewGroup.setOnFocusChangeListener(bundle.m21833a());
        viewGroup = this.password;
        bundle = AppAnalytics.m21867d();
        bundle.f19972a = getAnalyticsScreenName();
        bundle.f19973b = "password";
        viewGroup.setOnFocusChangeListener(bundle.m21833a());
        RxTextView.b(this.username).observeOn(SchedulerProvider.m23887c()).subscribe(new RegisterFragment$$Lambda$1(this));
        RxTextView.b(this.password).observeOn(SchedulerProvider.m23887c()).subscribe(new RegisterFragment$$Lambda$2(this));
        viewGroup = this.password;
        bundle = AppAnalytics.m21867d();
        bundle.f19972a = getAnalyticsScreenName();
        bundle.f19973b = State.KEY_EMAIL;
        viewGroup.setOnFocusChangeListener(bundle.m21833a());
        this.recoveryEmail.setOnEditorActionListener(new C18741(this));
        this.registerButton.setOnClickListener(new C18752(this));
        this.terms.setText(Html.fromHtml(getString(C1761R.string.rdt_login_terms)));
        this.terms.setMovementMethod(LinkMovementMethod.getInstance());
        return layoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37145c.a();
    }

    public void onAttach(android.app.Activity r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        super.onAttach(r2);
        r2 = (com.reddit.frontpage.redditauth_private.ui.RegisterFragment.OnRegistrationListener) r2;	 Catch:{ ClassCastException -> 0x0008 }
        r1.f37143a = r2;	 Catch:{ ClassCastException -> 0x0008 }
        return;
    L_0x0008:
        r2 = "Activity must implement OnRegistrationListener";
        r0 = 0;
        r0 = new java.lang.Object[r0];
        timber.log.Timber.b(r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.redditauth_private.ui.RegisterFragment.onAttach(android.app.Activity):void");
    }

    private void m37504a(boolean z) {
        this.registerButton.setText(z ? getString(C1761R.string.rdt_label_register) : "");
        this.registerButton.setEnabled(z);
        this.loader.setVisibility(z ? true : false);
    }

    static /* synthetic */ void m37503a(RegisterFragment registerFragment) {
        if (registerFragment.f37144b == null) {
            String obj = registerFragment.username.getText().toString();
            String charSequence = registerFragment.password.getText().toString();
            String obj2 = registerFragment.recoveryEmail.getText().toString();
            registerFragment.username.setError(null);
            registerFragment.password.setError(null);
            registerFragment.m37504a(false);
            registerFragment.getActivity();
            registerFragment.f37144b = new RegisterTask(registerFragment, new RedditAuthClient(), obj, charSequence, obj2);
            registerFragment.f37144b.execute(new Void[0]);
        }
    }

    static /* synthetic */ TextView m37501a(RegisterFragment registerFragment, LoginError loginError) {
        if ("passwd2".equals(loginError.c)) {
            return registerFragment.password;
        }
        if ("passwd".equals(loginError.c)) {
            return registerFragment.password;
        }
        "user".equals(loginError.c);
        return registerFragment.username;
    }
}
