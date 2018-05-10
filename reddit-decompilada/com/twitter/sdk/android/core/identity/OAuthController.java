package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.network.HttpRequest;

class OAuthController implements Listener {
    final Listener f30708a;
    TwitterAuthToken f30709b;
    final OAuth1aService f30710c;
    private final ProgressBar f30711d;
    private final WebView f30712e;
    private final TwitterAuthConfig f30713f;

    interface Listener {
        void mo5478a(int i, Intent intent);
    }

    class C27201 extends Callback<OAuthResponse> {
        final /* synthetic */ OAuthController f34636a;

        C27201(OAuthController oAuthController) {
            this.f34636a = oAuthController;
        }

        public final void mo6518a(Result<OAuthResponse> result) {
            this.f34636a.f30709b = ((OAuthResponse) result.f23920a).f23962a;
            result = this.f34636a.f30710c.f23966c.buildUponBaseHostUrl("oauth", "authorize").appendQueryParameter("oauth_token", this.f34636a.f30709b.f30691b).build().toString();
            Fabric.m26243b().mo5562a("Twitter", "Redirecting user to web view to complete authorization flow");
            OAuthController.m31735a(this.f34636a.f30712e, new OAuthWebViewClient(this.f34636a.f30710c.m31748a(this.f34636a.f30713f), this.f34636a), result, new OAuthWebChromeClient());
        }

        public final void mo6519a(TwitterException twitterException) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to get request token", twitterException);
            this.f34636a.m31739a(1, new TwitterAuthException("Failed to get request token"));
        }
    }

    class C27212 extends Callback<OAuthResponse> {
        final /* synthetic */ OAuthController f34637a;

        C27212(OAuthController oAuthController) {
            this.f34637a = oAuthController;
        }

        public final void mo6518a(Result<OAuthResponse> result) {
            Intent intent = new Intent();
            OAuthResponse oAuthResponse = (OAuthResponse) result.f23920a;
            intent.putExtra("screen_name", oAuthResponse.f23963b);
            intent.putExtra("user_id", oAuthResponse.f23964c);
            intent.putExtra("tk", oAuthResponse.f23962a.f30691b);
            intent.putExtra("ts", oAuthResponse.f23962a.f30692c);
            this.f34637a.f30708a.mo5478a(-1, intent);
        }

        public final void mo6519a(TwitterException twitterException) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to get access token", twitterException);
            this.f34637a.m31739a(1, new TwitterAuthException("Failed to get access token"));
        }
    }

    OAuthController(ProgressBar progressBar, WebView webView, TwitterAuthConfig twitterAuthConfig, OAuth1aService oAuth1aService, Listener listener) {
        this.f30711d = progressBar;
        this.f30712e = webView;
        this.f30713f = twitterAuthConfig;
        this.f30710c = oAuth1aService;
        this.f30708a = listener;
    }

    protected final void m31739a(int i, TwitterAuthException twitterAuthException) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", twitterAuthException);
        this.f30708a.mo5478a(i, intent);
    }

    static void m31735a(WebView webView, WebViewClient webViewClient, String str, WebChromeClient webChromeClient) {
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(false);
        settings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(str);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    private void m31734a() {
        this.f30712e.stopLoading();
        m31737b();
    }

    private void m31737b() {
        this.f30711d.setVisibility(8);
    }

    public final void mo5480a(WebView webView) {
        m31737b();
        webView.setVisibility(0);
    }

    public final void mo5479a(Bundle bundle) {
        Fabric.m26243b().mo5562a("Twitter", "OAuth web view completed successfully");
        String string = bundle.getString("oauth_verifier");
        StringBuilder stringBuilder;
        if (string != null) {
            Fabric.m26243b().mo5562a("Twitter", "Converting the request token to an access token.");
            bundle = this.f30710c;
            Callback c27212 = new C27212(this);
            TwitterAuthToken twitterAuthToken = this.f30709b;
            stringBuilder = new StringBuilder();
            stringBuilder.append(bundle.f23966c.getBaseHostUrl());
            stringBuilder.append("/oauth/access_token");
            String stringBuilder2 = stringBuilder.toString();
            OAuth1aHeaders oAuth1aHeaders = new OAuth1aHeaders();
            bundle.f30721a.getAccessToken(OAuth1aHeaders.m25872a(bundle.f23965b.f30696d, twitterAuthToken, null, HttpRequest.METHOD_POST, stringBuilder2, null), string).a(bundle.m31747a(c27212));
        } else {
            stringBuilder = new StringBuilder("Failed to get authorization, bundle incomplete ");
            stringBuilder.append(bundle);
            Fabric.m26243b().mo5568c("Twitter", stringBuilder.toString(), null);
            m31739a(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
        }
        m31734a();
    }

    public final void mo5481a(WebViewException webViewException) {
        Fabric.m26243b().mo5568c("Twitter", "OAuth web view completed with an error", webViewException);
        m31739a(1, new TwitterAuthException("OAuth web view completed with an error"));
        m31734a();
    }
}
