package com.reddit.frontpage.redditauth_private.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.android.volley.NetworkResponse;
import com.reddit.datalibrary.frontpage.redditauth.account.AuthUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.api.InterceptingRequestBuilder.OnInterceptListener;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.redditauth_private.account.Credentials;
import com.reddit.frontpage.redditauth_private.ui.LoginFragment.OnLoginListener;
import com.reddit.frontpage.redditauth_private.ui.RegisterFragment.OnRegistrationListener;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;

public class AuthActivity extends AccountAuthenticatorActivity implements OnInterceptListener, OnLoginListener, OnRegistrationListener {
    private Toolbar f40834b;
    private boolean f40835c;
    private NavigationListener f40836d;

    public interface NavigationListener {
        void mo4939a();

        void mo4940b();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        setContentView(C1761R.layout.rdt_activity_single_container_toolbar);
        this.f40834b = (Toolbar) findViewById(C1761R.id.toolbar);
        if (this.f40834b != null) {
            a(this.f40834b);
        }
        c().a().b(true);
        c().a();
        c().a().c(false);
        if (bundle == null) {
            getSupportFragmentManager().a().a(C1761R.id.container, LoginSignUpPagerFragment.m37500a(getIntent().getBooleanExtra("com.reddit.is_signup", false)), "login_pager").c();
        }
    }

    private void m42734b(String str, Scope scope, Credentials credentials) {
        str = AuthUtil.a(this, str, scope, credentials);
        scope = new Intent();
        scope.putExtra("authAccount", str.name);
        scope.putExtra("accountType", str.type);
        this.f40738a = scope.getExtras();
        setResult(-1, scope);
        finish();
    }

    public final void m42737a(NavigationListener navigationListener) {
        this.f40836d = navigationListener;
    }

    public final void mo7724d() {
        this.f40836d = null;
    }

    public void onBackPressed() {
        if (this.f40836d != null) {
            this.f40836d.mo4939a();
        }
        super.onBackPressed();
    }

    public final void mo7786a(String str, String str2, Scope scope, Credentials credentials) {
        if (this.f40835c) {
            getSupportFragmentManager().a().b(C1761R.id.container, AuthenticatorFragment.m37477a(str, str2)).a().a(null).c();
            this.f40835c = null;
            return;
        }
        if (credentials != null) {
            m42734b(str, scope, credentials);
        }
    }

    public final void mo7787e() {
        ((LoginSignUpPagerFragment) getSupportFragmentManager().a("login_pager")).viewPager.setCurrentItem(1, true);
    }

    public final void mo7788f() {
        View inflate = LayoutInflater.from(this).inflate(C1761R.layout.rdt_fragment_forgotpassword, null);
        TextView textView = (TextView) inflate.findViewById(C1761R.id.username);
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog((Context) this, (byte) 0);
        redditAlertDialog.f21113a.a(C1761R.string.rdt_forgot_password_title).a(inflate).a(C1761R.string.action_email_me, new AuthActivity$$Lambda$0(this, textView)).b(C1761R.string.action_cancel, null);
        AlertDialog b = redditAlertDialog.m23324b();
        b.setOnShowListener(AuthActivity$$Lambda$1.f21015a);
        b.show();
    }

    public final void mo7785a(String str, Scope scope, Credentials credentials) {
        SessionManager.b().d = true;
        m42734b(str, scope, credentials);
    }

    public final void mo7789g() {
        ((LoginSignUpPagerFragment) getSupportFragmentManager().a("login_pager")).viewPager.setCurrentItem(0, true);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (this.f40836d != null) {
                this.f40836d.mo4940b();
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void m42736a(NetworkResponse networkResponse) {
        this.f40835c = networkResponse.a == 202 ? true : null;
    }
}
