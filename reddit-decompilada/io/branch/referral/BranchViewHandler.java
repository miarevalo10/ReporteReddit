package io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.instabug.library.model.NetworkLog;
import org.json.JSONObject;

public class BranchViewHandler {
    private static BranchViewHandler f24537d;
    boolean f24538a;
    BranchView f24539b = null;
    String f24540c;
    private boolean f24541e;
    private boolean f24542f = false;
    private boolean f24543g;
    private Dialog f24544h;

    private class BranchView {
        final /* synthetic */ BranchViewHandler f24527a;
        private String f24528b;
        private String f24529c;
        private int f24530d;
        private String f24531e;
        private String f24532f;

        private BranchView(io.branch.referral.BranchViewHandler r1, org.json.JSONObject r2, java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f24527a = r1;
            r0.<init>();
            r1 = "";
            r0.f24528b = r1;
            r1 = "";
            r0.f24529c = r1;
            r1 = 1;
            r0.f24530d = r1;
            r1 = "";
            r0.f24531e = r1;
            r1 = "";
            r0.f24532f = r1;
            r0.f24529c = r3;	 Catch:{ Exception -> 0x006b }
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewID;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.has(r1);	 Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x006b }
        L_0x0024:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewID;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x006b }
            r0.f24528b = r1;	 Catch:{ Exception -> 0x006b }
        L_0x002e:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewNumOfUse;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.has(r1);	 Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x0042;	 Catch:{ Exception -> 0x006b }
        L_0x0038:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewNumOfUse;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x006b }
            r0.f24530d = r1;	 Catch:{ Exception -> 0x006b }
        L_0x0042:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewUrl;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.has(r1);	 Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x006b }
        L_0x004c:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewUrl;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x006b }
            r0.f24531e = r1;	 Catch:{ Exception -> 0x006b }
        L_0x0056:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewHtml;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.has(r1);	 Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x006b }
        L_0x0060:
            r1 = io.branch.referral.Defines.Jsonkey.BranchViewHtml;	 Catch:{ Exception -> 0x006b }
            r1 = r1.bc;	 Catch:{ Exception -> 0x006b }
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x006b }
            r0.f24532f = r1;	 Catch:{ Exception -> 0x006b }
        L_0x006a:
            return;
        L_0x006b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchViewHandler.BranchView.<init>(io.branch.referral.BranchViewHandler, org.json.JSONObject, java.lang.String):void");
        }

        public static void m26111a(Context context, String str) {
            PrefHelper.m26151a(context);
            context = new StringBuilder("bnc_branch_view_use_");
            context.append(str);
            PrefHelper.m26167c(context.toString(), PrefHelper.m26173f(str) + 1);
        }

        static /* synthetic */ boolean m26112a(BranchView branchView, Context context) {
            PrefHelper.m26151a(context);
            if (branchView.f24530d <= PrefHelper.m26173f(branchView.f24528b)) {
                if (branchView.f24530d != -1) {
                    return null;
                }
            }
            return true;
        }
    }

    public interface IBranchViewEvents {
        void mo5542b(String str);

        void mo5544c(String str);

        void mo5546d(String str);
    }

    private class loadBranchViewTask extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ BranchViewHandler f24533a;
        private final BranchView f24534b;
        private final Context f24535c;
        private final IBranchViewEvents f24536d;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m26119a();
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            super.onPostExecute(bool);
            if (bool.booleanValue() != null) {
                this.f24533a.m26127b(this.f24534b, this.f24535c, this.f24536d);
            } else if (this.f24536d != null) {
                this.f24536d.mo5546d(this.f24534b.f24529c);
            }
            this.f24533a.f24542f = false;
        }

        public loadBranchViewTask(BranchViewHandler branchViewHandler, BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
            this.f24533a = branchViewHandler;
            this.f24534b = branchView;
            this.f24535c = context;
            this.f24536d = iBranchViewEvents;
        }

        private java.lang.Boolean m26119a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r8 = this;
            r0 = 0;
            r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            r2 = -1;
            r3 = new java.net.URL;	 Catch:{ Exception -> 0x004c }
            r4 = r8.f24534b;	 Catch:{ Exception -> 0x004c }
            r4 = r4.f24531e;	 Catch:{ Exception -> 0x004c }
            r3.<init>(r4);	 Catch:{ Exception -> 0x004c }
            r3 = r3.openConnection();	 Catch:{ Exception -> 0x004c }
            r3 = (java.net.HttpURLConnection) r3;	 Catch:{ Exception -> 0x004c }
            r4 = "GET";	 Catch:{ Exception -> 0x004c }
            r3.setRequestMethod(r4);	 Catch:{ Exception -> 0x004c }
            r3.connect();	 Catch:{ Exception -> 0x004c }
            r4 = r3.getResponseCode();	 Catch:{ Exception -> 0x004c }
            if (r4 != r1) goto L_0x004d;
        L_0x0023:
            r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004d }
            r5.<init>();	 Catch:{ Exception -> 0x004d }
            r3 = r3.getInputStream();	 Catch:{ Exception -> 0x004d }
            r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x004d }
            r6 = new byte[r6];	 Catch:{ Exception -> 0x004d }
        L_0x0030:
            r7 = r3.read(r6);	 Catch:{ Exception -> 0x004d }
            if (r7 == r2) goto L_0x003a;	 Catch:{ Exception -> 0x004d }
        L_0x0036:
            r5.write(r6, r0, r7);	 Catch:{ Exception -> 0x004d }
            goto L_0x0030;	 Catch:{ Exception -> 0x004d }
        L_0x003a:
            r2 = r8.f24534b;	 Catch:{ Exception -> 0x004d }
            r6 = "UTF-8";	 Catch:{ Exception -> 0x004d }
            r6 = r5.toString(r6);	 Catch:{ Exception -> 0x004d }
            r2.f24532f = r6;	 Catch:{ Exception -> 0x004d }
            r5.close();	 Catch:{ Exception -> 0x004d }
            r3.close();	 Catch:{ Exception -> 0x004d }
            goto L_0x004d;
        L_0x004c:
            r4 = r2;
        L_0x004d:
            if (r4 != r1) goto L_0x0050;
        L_0x004f:
            r0 = 1;
        L_0x0050:
            r0 = java.lang.Boolean.valueOf(r0);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchViewHandler.loadBranchViewTask.a():java.lang.Boolean");
        }
    }

    private BranchViewHandler() {
    }

    public static BranchViewHandler m26121a() {
        if (f24537d == null) {
            f24537d = new BranchViewHandler();
        }
        return f24537d;
    }

    public final boolean m26135a(JSONObject jSONObject, String str, Context context, IBranchViewEvents iBranchViewEvents) {
        return m26133a(new BranchView(jSONObject, str), context, iBranchViewEvents);
    }

    final boolean m26133a(BranchView branchView, Context context, IBranchViewEvents iBranchViewEvents) {
        if (!this.f24538a) {
            if (!this.f24542f) {
                this.f24538a = false;
                this.f24541e = false;
                if (!(context == null || branchView == null)) {
                    if (BranchView.m26112a(branchView, context)) {
                        if (TextUtils.isEmpty(branchView.f24532f)) {
                            this.f24542f = true;
                            new loadBranchViewTask(this, branchView, context, iBranchViewEvents).execute(new Void[0]);
                        } else {
                            m26127b(branchView, context, iBranchViewEvents);
                        }
                        return true;
                    } else if (iBranchViewEvents != null) {
                        iBranchViewEvents.mo5546d(branchView.f24529c);
                    }
                }
                return false;
            }
        }
        if (iBranchViewEvents != null) {
            iBranchViewEvents.mo5546d(branchView.f24529c);
        }
        return false;
    }

    private void m26127b(final BranchView branchView, Context context, final IBranchViewEvents iBranchViewEvents) {
        if (!(context == null || branchView == null)) {
            final WebView webView = new WebView(context);
            webView.getSettings().setJavaScriptEnabled(true);
            if (VERSION.SDK_INT >= 19) {
                webView.setLayerType(2, null);
            }
            this.f24543g = null;
            if (TextUtils.isEmpty(branchView.f24532f) == null) {
                webView.loadDataWithBaseURL(null, branchView.f24532f, NetworkLog.HTML, "utf-8", null);
                webView.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ BranchViewHandler f24523d;

                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        boolean a = this.f24523d.m26126a(str);
                        if (!a) {
                            webView.loadUrl(str);
                        } else if (this.f24523d.f24544h != null) {
                            this.f24523d.f24544h.dismiss();
                        }
                        return a;
                    }

                    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        super.onPageStarted(webView, str, bitmap);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        this.f24523d.f24543g = true;
                    }

                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        BranchViewHandler.m26124a(this.f24523d, branchView, iBranchViewEvents, webView);
                    }
                });
            }
        }
    }

    private boolean m26126a(java.lang.String r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0032 }
        r2.<init>(r5);	 Catch:{ URISyntaxException -> 0x0032 }
        r5 = r2.getScheme();	 Catch:{ URISyntaxException -> 0x0032 }
        r3 = "branch-cta";	 Catch:{ URISyntaxException -> 0x0032 }
        r5 = r5.equalsIgnoreCase(r3);	 Catch:{ URISyntaxException -> 0x0032 }
        if (r5 == 0) goto L_0x0032;	 Catch:{ URISyntaxException -> 0x0032 }
    L_0x0013:
        r5 = r2.getHost();	 Catch:{ URISyntaxException -> 0x0032 }
        r3 = "accept";	 Catch:{ URISyntaxException -> 0x0032 }
        r5 = r5.equalsIgnoreCase(r3);	 Catch:{ URISyntaxException -> 0x0032 }
        if (r5 == 0) goto L_0x0023;	 Catch:{ URISyntaxException -> 0x0032 }
    L_0x001f:
        r4.f24541e = r1;	 Catch:{ URISyntaxException -> 0x0032 }
    L_0x0021:
        r0 = r1;	 Catch:{ URISyntaxException -> 0x0032 }
        goto L_0x0032;	 Catch:{ URISyntaxException -> 0x0032 }
    L_0x0023:
        r5 = r2.getHost();	 Catch:{ URISyntaxException -> 0x0032 }
        r2 = "cancel";	 Catch:{ URISyntaxException -> 0x0032 }
        r5 = r5.equalsIgnoreCase(r2);	 Catch:{ URISyntaxException -> 0x0032 }
        if (r5 == 0) goto L_0x0032;	 Catch:{ URISyntaxException -> 0x0032 }
    L_0x002f:
        r4.f24541e = r0;	 Catch:{ URISyntaxException -> 0x0032 }
        goto L_0x0021;
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchViewHandler.a(java.lang.String):boolean");
    }

    private static void m26122a(View view) {
        Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(10);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }

    public final boolean m26134a(JSONObject jSONObject, String str) {
        BranchView branchView = new BranchView(jSONObject, str);
        if (Branch.m31871a().f30933d == null) {
            return false;
        }
        Context context = (Activity) Branch.m31871a().f30933d.get();
        if (context == null || !BranchView.m26112a(branchView, context)) {
            return false;
        }
        this.f24539b = new BranchView(jSONObject, str);
        return true;
    }

    static /* synthetic */ void m26124a(BranchViewHandler branchViewHandler, final BranchView branchView, final IBranchViewEvents iBranchViewEvents, WebView webView) {
        if (branchViewHandler.f24543g || Branch.m31871a() == null || Branch.m31871a().f30933d == null) {
            branchViewHandler.f24538a = false;
            if (iBranchViewEvents != null) {
                iBranchViewEvents.mo5546d(branchView.f24529c);
            }
            return;
        }
        Activity activity = (Activity) Branch.m31871a().f30933d.get();
        if (activity != null) {
            BranchView.m26111a(activity.getApplicationContext(), branchView.f24528b);
            branchViewHandler.f24540c = activity.getClass().getName();
            View relativeLayout = new RelativeLayout(activity);
            relativeLayout.setVisibility(8);
            relativeLayout.addView(webView, new LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(0);
            if (branchViewHandler.f24544h == null || !branchViewHandler.f24544h.isShowing()) {
                branchViewHandler.f24544h = new Dialog(activity, 16973834);
                branchViewHandler.f24544h.setContentView(relativeLayout);
                relativeLayout.setVisibility(0);
                webView.setVisibility(0);
                branchViewHandler.f24544h.show();
                m26122a(relativeLayout);
                m26122a((View) webView);
                branchViewHandler.f24538a = true;
                branchViewHandler.f24544h.setOnDismissListener(new OnDismissListener(branchViewHandler) {
                    final /* synthetic */ BranchViewHandler f24526c;

                    public void onDismiss(DialogInterface dialogInterface) {
                        this.f24526c.f24538a = false;
                        this.f24526c.f24544h = null;
                        if (iBranchViewEvents != null) {
                            if (this.f24526c.f24541e != null) {
                                iBranchViewEvents.mo5542b(branchView.f24529c);
                                return;
                            }
                            iBranchViewEvents.mo5544c(branchView.f24529c);
                        }
                    }
                });
            } else {
                if (iBranchViewEvents != null) {
                    iBranchViewEvents.mo5546d(branchView.f24529c);
                }
            }
        }
    }
}
