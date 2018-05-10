package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.C2061R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.identity.OAuthController.C27201;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthService;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.network.HttpRequest;

public class OAuthActivity extends Activity implements Listener {
    OAuthController f30705a;
    private ProgressBar f30706b;
    private WebView f30707c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2061R.layout.tw__activity_oauth);
        this.f30706b = (ProgressBar) findViewById(C2061R.id.tw__spinner);
        this.f30707c = (WebView) findViewById(C2061R.id.tw__web_view);
        int i = 0;
        bundle = bundle != null ? bundle.getBoolean("progress", false) : true;
        ProgressBar progressBar = this.f30706b;
        if (bundle == null) {
            i = 8;
        }
        progressBar.setVisibility(i);
        bundle = TwitterCore.m31719a();
        this.f30705a = new OAuthController(this.f30706b, this.f30707c, (TwitterAuthConfig) getIntent().getParcelableExtra("auth_config"), new OAuth1aService(bundle, bundle.m31725b(), new TwitterApi()), this);
        bundle = this.f30705a;
        Fabric.m26243b().mo5562a("Twitter", "Obtaining request token to start the sign in flow");
        OAuthService oAuthService = bundle.f30710c;
        Callback c27201 = new C27201(bundle);
        TwitterAuthConfig twitterAuthConfig = oAuthService.f23965b.f30696d;
        bundle = new StringBuilder();
        bundle.append(oAuthService.f23966c.getBaseHostUrl());
        bundle.append("/oauth/request_token");
        String stringBuilder = bundle.toString();
        bundle = oAuthService.f30721a;
        OAuth1aHeaders oAuth1aHeaders = new OAuth1aHeaders();
        bundle.getTempToken(OAuth1aHeaders.m25872a(twitterAuthConfig, null, oAuthService.m31748a(twitterAuthConfig), HttpRequest.METHOD_POST, stringBuilder, null)).a(oAuthService.m31747a(c27201));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f30706b.getVisibility() == 0) {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        this.f30705a.m31739a(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    public final void mo5478a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}
