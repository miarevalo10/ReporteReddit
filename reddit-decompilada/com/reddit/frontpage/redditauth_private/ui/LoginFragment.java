package com.reddit.frontpage.redditauth_private.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.reddit.datalibrary.frontpage.redditauth.api.InterceptingRequestBuilder.OnInterceptListener;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.api.errors.LoginError;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.ui.BaseFragment;
import com.reddit.frontpage.redditauth_private.account.Credentials;
import com.reddit.frontpage.redditauth_private.account.TokenRetriever;
import com.reddit.frontpage.util.SchedulerProvider;
import timber.log.Timber;

public class LoginFragment extends BaseFragment {
    OnLoginListener f37137a;
    private OnInterceptListener f37138b;
    private LoginTask f37139c;
    private Unbinder f37140d;
    @BindView
    TextView forgotPassword;
    @BindView
    ProgressBar loader;
    @BindView
    Button loginButton;
    @BindView
    EditText password;
    @BindView
    TextView registerPrompt;
    @BindView
    AutoCompleteTextView username;

    class C18711 implements OnEditorActionListener {
        final /* synthetic */ LoginFragment f21022a;

        C18711(LoginFragment loginFragment) {
            this.f21022a = loginFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2) {
                if (i != 0) {
                    return null;
                }
            }
            textView = AppAnalytics.m21858b();
            textView.f19954a = this.f21022a.getAnalyticsScreenName();
            textView.f19955b = "continue";
            textView.m21825a();
            LoginFragment.m37494a(this.f21022a);
            return true;
        }
    }

    class C18722 implements OnClickListener {
        final /* synthetic */ LoginFragment f21023a;

        C18722(LoginFragment loginFragment) {
            this.f21023a = loginFragment;
        }

        public void onClick(View view) {
            view = AppAnalytics.m21858b().m21823a(view);
            view.f19954a = this.f21023a.getAnalyticsScreenName();
            view.f19955b = "login";
            view.m21825a();
            LoginFragment.m37494a(this.f21023a);
        }
    }

    class C18733 implements OnClickListener {
        final /* synthetic */ LoginFragment f21024a;

        C18733(LoginFragment loginFragment) {
            this.f21024a = loginFragment;
        }

        public void onClick(View view) {
            view = AppAnalytics.m21858b().m21823a(view);
            view.f19954a = this.f21024a.getAnalyticsScreenName();
            view.f19955b = "forgotpassword";
            view.m21825a();
            this.f21024a.f37137a.mo7788f();
        }
    }

    private class LoginTask extends AsyncTask<Void, Void, Pair<Credentials, String>> {
        RedditAuthClient f21025a;
        String f21026b;
        String f21027c;
        Exception f21028d;
        final /* synthetic */ LoginFragment f21029e;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m23244a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Pair pair = (Pair) obj;
            Credentials credentials = (Credentials) pair.a;
            String str = (String) pair.b;
            if (this.f21029e.getActivity() != null) {
                this.f21029e.f37139c = null;
                this.f21029e.m37495a(true);
                if (!(credentials == null && this.f21028d == null)) {
                    if (this.f21029e.f37137a != null) {
                        if (this.f21028d != null) {
                            if ((this.f21028d.getCause() instanceof LoginError) != null) {
                                obj = ((LoginError) this.f21028d.getCause()).b;
                            } else {
                                obj = this.f21029e.getString(C1761R.string.error_network_error);
                            }
                            Snackbar.a(this.f21029e.getView(), obj, -1).a();
                            this.f21029e.f37137a;
                            return;
                        }
                    }
                }
                this.f21029e.f37137a.mo7786a(str, this.f21027c, Scope.WILD_SCOPE, credentials);
            }
        }

        LoginTask(LoginFragment loginFragment, RedditAuthClient redditAuthClient, String str, String str2) {
            this.f21029e = loginFragment;
            this.f21025a = redditAuthClient;
            this.f21026b = str;
            this.f21027c = str2;
        }

        private Pair<Credentials, String> m23244a() {
            Object a;
            Object obj = null;
            try {
                a = TokenRetriever.m23228a(this.f21025a, this.f21026b, this.f21027c, this.f21029e.f37138b, Scope.WILD_SCOPE);
            } catch (Exception e) {
                this.f21028d = e;
                a = null;
            }
            try {
                obj = (String) FrontpageApplication.m28875k().mo4614b().m22394a(this.f21026b).map(LoginFragment$LoginTask$$Lambda$0.f28844a).blockingGet();
            } catch (Throwable e2) {
                Timber.c(e2, "Error getting real username during login", new Object[0]);
                this.f21028d = e2;
            }
            return Pair.a(a, obj);
        }
    }

    public interface OnLoginListener {
        void mo7786a(String str, String str2, Scope scope, Credentials credentials);

        void mo7787e();

        void mo7788f();
    }

    public String getAnalyticsScreenName() {
        return "login";
    }

    public static LoginFragment m37493a() {
        return new LoginFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C1761R.layout.rdt_fragment_login, viewGroup, false);
        this.f37140d = ButterKnife.a(this, layoutInflater);
        this.registerPrompt.setOnClickListener(new LoginFragment$$Lambda$0(this));
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
        RxTextView.b(this.username).observeOn(SchedulerProvider.m23887c()).subscribe(new LoginFragment$$Lambda$1(this));
        RxTextView.b(this.password).observeOn(SchedulerProvider.m23887c()).subscribe(new LoginFragment$$Lambda$2(this));
        this.password.setOnEditorActionListener(new C18711(this));
        this.loginButton.setOnClickListener(new C18722(this));
        this.forgotPassword.setOnClickListener(new C18733(this));
        return layoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37140d.a();
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
        r0 = r2;	 Catch:{ ClassCastException -> 0x000d }
        r0 = (com.reddit.frontpage.redditauth_private.ui.LoginFragment.OnLoginListener) r0;	 Catch:{ ClassCastException -> 0x000d }
        r1.f37137a = r0;	 Catch:{ ClassCastException -> 0x000d }
        r2 = (com.reddit.datalibrary.frontpage.redditauth.api.InterceptingRequestBuilder.OnInterceptListener) r2;	 Catch:{ ClassCastException -> 0x000d }
        r1.f37138b = r2;	 Catch:{ ClassCastException -> 0x000d }
        return;
    L_0x000d:
        r2 = "Activity must implement OnLoginListener and OnInterceptListener";
        r0 = 0;
        r0 = new java.lang.Object[r0];
        timber.log.Timber.e(r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.redditauth_private.ui.LoginFragment.onAttach(android.app.Activity):void");
    }

    private void m37495a(boolean z) {
        this.loginButton.setText(z ? getString(C1761R.string.rdt_label_login) : "");
        this.loginButton.setEnabled(z);
        this.loader.setVisibility(z ? true : false);
    }

    static /* synthetic */ void m37494a(LoginFragment loginFragment) {
        if (loginFragment.f37139c == null) {
            String obj = loginFragment.username.getText().toString();
            String obj2 = loginFragment.password.getText().toString();
            loginFragment.m37495a(false);
            loginFragment.getActivity();
            loginFragment.f37139c = new LoginTask(loginFragment, new RedditAuthClient(), obj, obj2);
            loginFragment.f37139c.execute(new Void[0]);
        }
    }
}
