package com.reddit.frontpage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.internal.zzbq;
import com.instabug.library.Instabug;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.frontpage.auth.RedditGoogleAuthUtil;
import com.reddit.frontpage.util.InstabugUtil;
import com.reddit.frontpage.util.IntentUtil;
import timber.log.Timber;

public class GoogleSignInActivity extends AppCompatActivity implements OnConnectionFailedListener {
    GoogleApiClient f40544a;
    ProgressDialog f40545b;
    @BindView
    FrameLayout container;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1761R.layout.activity_single_container);
        ButterKnife.a(this);
        bundle = new Builder(GoogleSignInOptions.f);
        bundle.a.add(GoogleSignInOptions.b);
        bundle = bundle.b();
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this);
        zzce com_google_android_gms_common_api_internal_zzce = new zzce(this);
        zzbq.b(true, "clientId must be non-negative");
        builder.b = 0;
        builder.c = this;
        builder.a = com_google_android_gms_common_api_internal_zzce;
        this.f40544a = builder.a(Auth.e, bundle).a();
        new AlertDialog.Builder(this).a("Authentication Required").b("This is an internal build. You will need to verify your @reddit.com email address.\n\nPlease do not share any unreleased features or details with the public").a(false).a("Get Google Play release", new GoogleSignInActivity$$Lambda$0(this)).b("Verify email", new GoogleSignInActivity$$Lambda$1(this)).c();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001) {
            m41952a(Auth.h.getSignInResultFromIntent(intent));
        }
    }

    final void m41952a(GoogleSignInResult googleSignInResult) {
        Timber.b("handleSignInResult: %s", new Object[]{String.valueOf(googleSignInResult.a.b())});
        if (googleSignInResult.a.b()) {
            googleSignInResult = googleSignInResult.b;
            if (RedditGoogleAuthUtil.m21798a(googleSignInResult.b)) {
                InternalSettings.a().n();
                InstabugUtil.m23734b();
                if (!(googleSignInResult.c == null || googleSignInResult.b == null)) {
                    Instabug.identifyUser(googleSignInResult.c, googleSignInResult.b);
                }
                startActivity(IntentUtil.m23751a((Context) this, true));
                finish();
                return;
            }
            Snackbar.a(this.container, "You did not login with an @reddit.com account. Please try again.", 0).a();
            Auth.h.revokeAccess(this.f40544a).a(new GoogleSignInActivity$$Lambda$3(this));
            return;
        }
        Timber.b("Failed signin, status: %s", new Object[]{googleSignInResult.a.toString()});
        m41954d();
    }

    final void m41954d() {
        startActivityForResult(Auth.h.getSignInIntent(this.f40544a), 9001);
    }

    public final void m41953a(ConnectionResult connectionResult) {
        Timber.b("onConnectionFailed: %s", new Object[]{connectionResult.toString()});
    }
}
