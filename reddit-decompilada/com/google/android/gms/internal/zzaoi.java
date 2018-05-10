package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;

@zzzv
@TargetApi(11)
public class zzaoi extends WebChromeClient {
    private final zzanh f6667a;

    public zzaoi(zzanh com_google_android_gms_internal_zzanh) {
        this.f6667a = com_google_android_gms_internal_zzanh;
    }

    private static Context m5474a(WebView webView) {
        if (!(webView instanceof zzanh)) {
            return webView.getContext();
        }
        zzanh com_google_android_gms_internal_zzanh = (zzanh) webView;
        Context d = com_google_android_gms_internal_zzanh.mo3467d();
        return d != null ? d : com_google_android_gms_internal_zzanh.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        String str;
        if (webView instanceof zzanh) {
            zzd s = ((zzanh) webView).mo4011s();
            if (s == null) {
                str = "Tried to close an AdWebView not associated with an overlay.";
            } else {
                s.m17401a();
                return;
            }
        }
        str = "Tried to close a WebView that wasn't an AdWebView.";
        zzakb.m5371e(str);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder stringBuilder = new StringBuilder((19 + String.valueOf(message).length()) + String.valueOf(sourceId).length());
        stringBuilder.append("JS: ");
        stringBuilder.append(message);
        stringBuilder.append(" (");
        stringBuilder.append(sourceId);
        stringBuilder.append(":");
        stringBuilder.append(lineNumber);
        stringBuilder.append(")");
        message = stringBuilder.toString();
        if (message.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (zzaop.f6675a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzakb.m5368c(message);
                break;
            case 2:
                zzakb.m5371e(message);
                break;
            case 5:
                zzakb.m5366b(message);
                break;
            default:
                zzakb.m5370d(message);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f6667a.mo4019w());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(131072, j4), 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            boolean z;
            zzbs.m4486e();
            if (!zzahn.m5179a(this.f6667a.getContext(), this.f6667a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzbs.m4486e();
                if (!zzahn.m5179a(this.f6667a.getContext(), this.f6667a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        zzd s = this.f6667a.mo4011s();
        if (s == null) {
            zzakb.m5371e("Could not get ad overlay when hiding custom view.");
        } else {
            s.m17408b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m5475a(m5474a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m5475a(m5474a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m5475a(m5474a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m5475a(m5474a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        j += 131072;
        if (5242880 - j2 < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m5476a(view, -1, customViewCallback);
    }

    private final boolean m5475a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            if (!(this.f6667a == null || this.f6667a.mo4019w() == null || this.f6667a.mo4019w().f6623j == null)) {
                zzw com_google_android_gms_ads_internal_zzw = this.f6667a.mo4019w().f6623j;
                if (!(com_google_android_gms_ads_internal_zzw == null || com_google_android_gms_ads_internal_zzw.m4520a())) {
                    str2 = new StringBuilder((11 + String.valueOf(str).length()) + String.valueOf(str3).length());
                    str2.append("window.");
                    str2.append(str);
                    str2.append("('");
                    str2.append(str3);
                    str2.append("')");
                    com_google_android_gms_ads_internal_zzw.m4519a(str2.toString());
                    return null;
                }
            }
            str = new Builder(context);
            str.setTitle(str2);
            if (z) {
                jsResult = new LinearLayout(context);
                jsResult.setOrientation(1);
                z = new TextView(context);
                z.setText(str3);
                str3 = new EditText(context);
                str3.setText(str4);
                jsResult.addView(z);
                jsResult.addView(str3);
                context = str.setView(jsResult).setPositiveButton(17039370, new zzaoo(jsPromptResult, str3)).setNegativeButton(17039360, new zzaon(jsPromptResult)).setOnCancelListener(new zzaom(jsPromptResult)).create();
            } else {
                context = str.setMessage(str3).setPositiveButton(17039370, new zzaol(jsResult)).setNegativeButton(17039360, new zzaok(jsResult)).setOnCancelListener(new zzaoj(jsResult)).create();
            }
            context.show();
        } catch (Context context2) {
            zzakb.m5369c("Fail to display Dialog.", context2);
        }
        return true;
    }

    protected final void m5476a(View view, int i, CustomViewCallback customViewCallback) {
        zzd s = this.f6667a.mo4011s();
        if (s == null) {
            zzakb.m5371e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        s.f17108e = new FrameLayout(s.f17104a);
        s.f17108e.setBackgroundColor(-16777216);
        s.f17108e.addView(view, -1, -1);
        s.f17104a.setContentView(s.f17108e);
        s.f17115l = true;
        s.f17109f = customViewCallback;
        s.f17107d = true;
        s.m17402a(i);
    }
}
