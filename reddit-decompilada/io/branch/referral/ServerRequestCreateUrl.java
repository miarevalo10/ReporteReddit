package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchLinkCreateListener;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONObject;

class ServerRequestCreateUrl extends ServerRequest {
    BranchLinkData f30957a;
    BranchLinkCreateListener f30958b;
    private boolean f30959c = true;
    private boolean f30960d;
    private boolean f30961e = true;

    public boolean isGetRequest() {
        return false;
    }

    public ServerRequestCreateUrl(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) == null) {
            if (this.f30958b != null) {
                context = new BranchError("Trouble creating a URL.", -102);
            }
            return true;
        } else if (this.f30959c == null && (PrefHelper.m26170d("bnc_identity_id").equals("bnc_no_value") ^ 1) == null) {
            return true;
        } else {
            return null;
        }
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            serverResponse.m26198a().getString(UpdateFragment.FRAGMENT_URL);
            JSONObject a = this.f30957a.m26101a();
            if (this.f30960d != null) {
                new ExtendedAnswerProvider().m26144a("Branch Share", a, PrefHelper.m26170d("bnc_identity_id"));
            }
        } catch (ServerResponse serverResponse2) {
            serverResponse2.printStackTrace();
        }
    }

    public void handleFailure(int i, String str) {
        if (this.f30958b != null) {
            if (this.f30961e) {
                if (PrefHelper.m26170d("bnc_user_url").equals("bnc_no_value")) {
                    StringBuilder stringBuilder = new StringBuilder("https://bnc.lt/a/");
                    stringBuilder.append(PrefHelper.m26169d());
                    m31924a(stringBuilder.toString());
                } else {
                    m31924a(PrefHelper.m26170d("bnc_user_url"));
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("Trouble creating a URL. ");
            stringBuilder2.append(str);
            BranchError branchError = new BranchError(stringBuilder2.toString(), i);
        }
    }

    public void clearCallbacks() {
        this.f30958b = null;
    }

    private java.lang.String m31924a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r4);
        r4 = "?";
        r0.append(r4);
        r4 = r0.toString();
        r0 = r3.f30957a;
        r0 = r0.f24494a;
        if (r0 == 0) goto L_0x004e;
    L_0x0017:
        r0 = r0.iterator();
    L_0x001b:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x004e;
    L_0x0021:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x001b;
    L_0x0029:
        r2 = r1.length();
        if (r2 <= 0) goto L_0x001b;
    L_0x002f:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Tags;
        r2.append(r4);
        r4 = "=";
        r2.append(r4);
        r2.append(r1);
        r4 = "&";
        r2.append(r4);
        r4 = r2.toString();
        goto L_0x001b;
    L_0x004e:
        r0 = r3.f30957a;
        r0 = r0.f24495b;
        if (r0 == 0) goto L_0x0078;
    L_0x0054:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x0078;
    L_0x005a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Alias;
        r1.append(r4);
        r4 = "=";
        r1.append(r4);
        r1.append(r0);
        r4 = "&";
        r1.append(r4);
        r4 = r1.toString();
    L_0x0078:
        r0 = r3.f30957a;
        r0 = r0.f24497d;
        if (r0 == 0) goto L_0x00a2;
    L_0x007e:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x00a2;
    L_0x0084:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Channel;
        r1.append(r4);
        r4 = "=";
        r1.append(r4);
        r1.append(r0);
        r4 = "&";
        r1.append(r4);
        r4 = r1.toString();
    L_0x00a2:
        r0 = r3.f30957a;
        r0 = r0.f24498e;
        if (r0 == 0) goto L_0x00cc;
    L_0x00a8:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x00cc;
    L_0x00ae:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Feature;
        r1.append(r4);
        r4 = "=";
        r1.append(r4);
        r1.append(r0);
        r4 = "&";
        r1.append(r4);
        r4 = r1.toString();
    L_0x00cc:
        r0 = r3.f30957a;
        r0 = r0.f24499f;
        if (r0 == 0) goto L_0x00f6;
    L_0x00d2:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x00f6;
    L_0x00d8:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Stage;
        r1.append(r4);
        r4 = "=";
        r1.append(r4);
        r1.append(r0);
        r4 = "&";
        r1.append(r4);
        r4 = r1.toString();
    L_0x00f6:
        r0 = r3.f30957a;
        r0 = r0.f24500g;
        if (r0 == 0) goto L_0x0120;
    L_0x00fc:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x0120;
    L_0x0102:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Campaign;
        r1.append(r4);
        r4 = "=";
        r1.append(r4);
        r1.append(r0);
        r4 = "&";
        r1.append(r4);
        r4 = r1.toString();
    L_0x0120:
        r0 = r3.f30957a;
        r0 = r0.f24496c;
        r0 = (long) r0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Type;
        r2.append(r4);
        r4 = "=";
        r2.append(r4);
        r2.append(r0);
        r4 = "&";
        r2.append(r4);
        r4 = r2.toString();
        r0 = r3.f30957a;
        r0 = r0.f24502i;
        r0 = (long) r0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r4);
        r4 = io.branch.referral.Defines.LinkParam.Duration;
        r2.append(r4);
        r4 = "=";
        r2.append(r4);
        r2.append(r0);
        r4 = "&";
        r2.append(r4);
        r4 = r2.toString();
        r0 = r3.f30957a;
        r0 = r0.f24501h;
        if (r0 == 0) goto L_0x019f;
    L_0x016c:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x019f;
    L_0x0172:
        r0 = r0.getBytes();
        r0 = io.branch.referral.Base64.m26096b(r0);
        r1 = "UTF8";	 Catch:{ Exception -> 0x0196 }
        r0 = java.net.URLEncoder.encode(r0, r1);	 Catch:{ Exception -> 0x0196 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0196 }
        r1.<init>();	 Catch:{ Exception -> 0x0196 }
        r1.append(r4);	 Catch:{ Exception -> 0x0196 }
        r2 = "source=android&data=";	 Catch:{ Exception -> 0x0196 }
        r1.append(r2);	 Catch:{ Exception -> 0x0196 }
        r1.append(r0);	 Catch:{ Exception -> 0x0196 }
        r0 = r1.toString();	 Catch:{ Exception -> 0x0196 }
        r4 = r0;
        goto L_0x019f;
    L_0x0196:
        r0 = new io.branch.referral.BranchError;
        r1 = "Trouble creating a URL.";
        r2 = -116; // 0xffffffffffffff8c float:NaN double:NaN;
        r0.<init>(r1, r2);
    L_0x019f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestCreateUrl.a(java.lang.String):java.lang.String");
    }
}
