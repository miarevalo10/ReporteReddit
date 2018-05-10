package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.fabric.sdk.android.services.network.UrlUtils;
import java.net.URI;
import java.util.Map.Entry;

class OAuthWebViewClient extends WebViewClient {
    private final String f23931a;
    private final Listener f23932b;

    interface Listener {
        void mo5479a(Bundle bundle);

        void mo5480a(WebView webView);

        void mo5481a(WebViewException webViewException);
    }

    public OAuthWebViewClient(String str, Listener listener) {
        this.f23931a = str;
        this.f23932b = listener;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f23932b.mo5480a(webView);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(this.f23931a)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView = UrlUtils.m26423a(URI.create(str), (boolean) null);
        Bundle bundle = new Bundle(webView.size());
        for (Entry entry : webView.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        this.f23932b.mo5479a(bundle);
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f23932b.mo5481a(new WebViewException(i, str, str2));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f23932b.mo5481a(new WebViewException(sslError.getPrimaryError(), null, null));
    }
}
