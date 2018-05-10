package net.hockeyapp.android.tasks;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.instabug.library.model.State;
import java.util.Map;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.utils.HockeyLog;
import org.json.JSONObject;

@SuppressLint({"StaticFieldLeak"})
public class LoginTask extends ConnectionTask<Void, Void, Boolean> {
    public Context f33151a;
    public Handler f33152b;
    public ProgressDialog f33153c;
    private final int f33154d;
    private final String f33155e;
    private final Map<String, String> f33156f;
    private boolean f33157g = true;

    private java.lang.Boolean m33741a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00f9 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r6 = this;
        r0 = 0;
        r1 = r6.f33154d;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r6.f33156f;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = 1;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r1 != r3) goto L_0x001e;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x0008:
        r1 = new net.hockeyapp.android.utils.HttpURLConnectionBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = r6.f33155e;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1.<init>(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = "POST";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1.f26604a = r3;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r1.m28214a(r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r1.m28212a();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x001b:
        r0 = r1;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        goto L_0x00ad;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x001e:
        r3 = 2;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r1 != r3) goto L_0x0070;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x0021:
        r1 = new net.hockeyapp.android.utils.HttpURLConnectionBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = r6.f33155e;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1.<init>(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = "POST";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1.f26604a = r3;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = "email";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = r2.get(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = (java.lang.String) r3;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4 = "password";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r2.get(r4);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5 = "Basic ";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5.<init>();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5.append(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = ":";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5.append(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r5.append(r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r5.toString();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r2.getBytes();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = net.hockeyapp.android.utils.Base64.m28201a(r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4.append(r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r4.toString();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = "Authorization";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1.m28213a(r3, r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r1.m28212a();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        goto L_0x001b;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x0070:
        r3 = 3;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r1 != r3) goto L_0x00d3;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x0073:
        r1 = "type";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r2.get(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = "id";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = r2.get(r3);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.<init>();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4 = r6.f33155e;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r4);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4 = "?";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r4);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = "=";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r2);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r3.toString();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = new net.hockeyapp.android.utils.HttpURLConnectionBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2.<init>(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r2.m28212a();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        goto L_0x001b;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x00ad:
        r0.connect();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r0.getResponseCode();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r1 != r2) goto L_0x00d0;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x00b8:
        r1 = net.hockeyapp.android.tasks.ConnectionTask.m28194a(r0);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r2 != 0) goto L_0x00d0;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x00c2:
        r1 = r6.m33742a(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r0 == 0) goto L_0x00cf;
    L_0x00cc:
        r0.disconnect();
    L_0x00cf:
        return r1;
    L_0x00d0:
        if (r0 == 0) goto L_0x00f9;
    L_0x00d2:
        goto L_0x00f6;
    L_0x00d3:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r4 = "Login mode ";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.<init>(r4);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = " not supported.";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r3.append(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r1 = r3.toString();	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        r2.<init>(r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        throw r2;	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
    L_0x00ec:
        r1 = move-exception;
        goto L_0x00ff;
    L_0x00ee:
        r1 = move-exception;
        r2 = "Failed to login";	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        net.hockeyapp.android.utils.HockeyLog.m28206a(r2, r1);	 Catch:{ IOException -> 0x00ee, all -> 0x00ec }
        if (r0 == 0) goto L_0x00f9;
    L_0x00f6:
        r0.disconnect();
    L_0x00f9:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        return r0;
    L_0x00ff:
        if (r0 == 0) goto L_0x0104;
    L_0x0101:
        r0.disconnect();
    L_0x0104:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.LoginTask.a():java.lang.Boolean");
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m33741a();
    }

    protected /* synthetic */ void onPostExecute(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = (java.lang.Boolean) r4;
        r0 = r3.f33153c;
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r0 = r3.f33153c;	 Catch:{ Exception -> 0x000b }
        r0.dismiss();	 Catch:{ Exception -> 0x000b }
    L_0x000b:
        r0 = r3.f33152b;
        if (r0 == 0) goto L_0x002a;
    L_0x000f:
        r0 = new android.os.Message;
        r0.<init>();
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "success";
        r4 = r4.booleanValue();
        r1.putBoolean(r2, r4);
        r0.setData(r1);
        r4 = r3.f33152b;
        r4.sendMessage(r0);
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.LoginTask.onPostExecute(java.lang.Object):void");
    }

    public LoginTask(Context context, Handler handler, String str, int i, Map<String, String> map) {
        this.f33151a = context;
        this.f33152b = handler;
        this.f33155e = str;
        this.f33154d = i;
        this.f33156f = map;
        if (context != null) {
            Constants.m28151a(context);
        }
    }

    protected void onPreExecute() {
        if ((this.f33153c == null || !this.f33153c.isShowing()) && this.f33157g) {
            this.f33153c = ProgressDialog.show(this.f33151a, "", "Please wait...", true, false);
        }
    }

    private boolean m33742a(String str) {
        SharedPreferences sharedPreferences = this.f33151a.getSharedPreferences("net.hockeyapp.android.login", 0);
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("status");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.f33154d == 1) {
                if (str.equals("identified") != null) {
                    str = jSONObject.getString("iuid");
                    if (!TextUtils.isEmpty(str)) {
                        sharedPreferences.edit().putString("iuid", str).putString(State.KEY_EMAIL, (String) this.f33156f.get(State.KEY_EMAIL)).apply();
                        return true;
                    }
                }
            } else if (this.f33154d == 2) {
                if (str.equals("authorized") != null) {
                    str = jSONObject.getString("auid");
                    if (!TextUtils.isEmpty(str)) {
                        sharedPreferences.edit().putString("auid", str).putString(State.KEY_EMAIL, (String) this.f33156f.get(State.KEY_EMAIL)).apply();
                        return true;
                    }
                }
            } else if (this.f33154d != 3) {
                StringBuilder stringBuilder = new StringBuilder("Login mode ");
                stringBuilder.append(this.f33154d);
                stringBuilder.append(" not supported.");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (str.equals("validated") != null) {
                return true;
            } else {
                sharedPreferences.edit().remove("iuid").remove("auid").remove(State.KEY_EMAIL).apply();
            }
            return false;
        } catch (Throwable e) {
            HockeyLog.m28206a("Failed to parse login response", e);
            return false;
        }
    }
}
