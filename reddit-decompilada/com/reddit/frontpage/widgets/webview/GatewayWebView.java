package com.reddit.frontpage.widgets.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

public class GatewayWebView extends WebView {
    private Map<String, String> f22279a;

    public GatewayWebView(Context context) {
        super(context);
        m24415a();
    }

    public GatewayWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24415a();
    }

    public GatewayWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24415a();
    }

    @TargetApi(21)
    public GatewayWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24415a();
    }

    private void m24415a() {
        this.f22279a = new HashMap(2);
        Session session = SessionManager.b().c;
        if (!session.isAnonymous()) {
            Map map = this.f22279a;
            String str = HttpRequest.HEADER_AUTHORIZATION;
            StringBuilder stringBuilder = new StringBuilder("Bearer ");
            stringBuilder.append(session.b);
            map.put(str, stringBuilder.toString());
            this.f22279a.put("Client-Vendor-ID", Config.g);
            try {
                Account a = AccountStorage.b.a(session);
                if (a != null) {
                    this.f22279a.put("Reddit-User_Id", a.getId());
                }
            } catch (Throwable e) {
                Timber.c(e, "Failed to get account.", new Object[0]);
            }
        }
    }

    public void loadUrl(String str) {
        super.loadUrl(str, this.f22279a);
        Timber.b("ObservableWebView loaded %s", new Object[]{str});
        Timber.b("ObservableWebView headers %s", new Object[]{this.f22279a});
    }
}
