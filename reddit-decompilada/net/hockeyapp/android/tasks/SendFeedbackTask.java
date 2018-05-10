package net.hockeyapp.android.tasks;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.utils.HockeyLog;
import net.hockeyapp.android.utils.HttpURLConnectionBuilder;

@SuppressLint({"StaticFieldLeak"})
public class SendFeedbackTask extends ConnectionTask<Void, Void, HashMap<String, String>> {
    public Context f33158a;
    public Handler f33159b;
    public ProgressDialog f33160c;
    public boolean f33161d = true;
    private String f33162e;
    private String f33163f;
    private String f33164g;
    private String f33165h;
    private String f33166i;
    private String f33167j;
    private List<Uri> f33168k;
    private String f33169l;
    private boolean f33170m;
    private int f33171n = -1;

    class C21621 implements FilenameFilter {
        final /* synthetic */ SendFeedbackTask f26598a;

        C21621(SendFeedbackTask sendFeedbackTask) {
            this.f26598a = sendFeedbackTask;
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".jpg");
        }
    }

    protected /* synthetic */ void onPostExecute(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = (java.util.HashMap) r5;
        r0 = r4.f33160c;
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r0 = r4.f33160c;	 Catch:{ Exception -> 0x000b }
        r0.dismiss();	 Catch:{ Exception -> 0x000b }
    L_0x000b:
        r0 = r4.f33159b;
        if (r0 == 0) goto L_0x0054;
    L_0x000f:
        r0 = new android.os.Message;
        r0.<init>();
        r1 = new android.os.Bundle;
        r1.<init>();
        if (r5 == 0) goto L_0x0044;
    L_0x001b:
        r2 = "request_type";
        r3 = "type";
        r3 = r5.get(r3);
        r3 = (java.lang.String) r3;
        r1.putString(r2, r3);
        r2 = "feedback_response";
        r3 = "response";
        r3 = r5.get(r3);
        r3 = (java.lang.String) r3;
        r1.putString(r2, r3);
        r2 = "feedback_status";
        r3 = "status";
        r5 = r5.get(r3);
        r5 = (java.lang.String) r5;
        r1.putString(r2, r5);
        goto L_0x004c;
    L_0x0044:
        r5 = "request_type";
        r2 = "unknown";
        r1.putString(r5, r2);
    L_0x004c:
        r0.setData(r1);
        r5 = r4.f33159b;
        r5.sendMessage(r0);
    L_0x0054:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.SendFeedbackTask.onPostExecute(java.lang.Object):void");
    }

    public SendFeedbackTask(Context context, String str, String str2, String str3, String str4, String str5, String str6, List<Uri> list, String str7, Handler handler, boolean z) {
        this.f33158a = context;
        this.f33162e = str;
        this.f33163f = str2;
        this.f33164g = str3;
        this.f33165h = str4;
        this.f33166i = str5;
        this.f33167j = str6;
        this.f33168k = list;
        this.f33169l = str7;
        this.f33159b = handler;
        this.f33170m = z;
        if (context != null) {
            Constants.m28151a(context);
        }
    }

    public final void m33746a() {
        this.f33158a = null;
        if (this.f33160c != null) {
            this.f33160c.dismiss();
            this.f33160c = null;
        }
    }

    protected void onPreExecute() {
        if ((this.f33160c == null || !this.f33160c.isShowing()) && this.f33161d) {
            this.f33160c = ProgressDialog.show(this.f33158a, "", m33747b(), true, false);
        }
    }

    private HashMap<String, String> m33743c() {
        Throwable th;
        Throwable th2;
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("type", "send");
        HttpURLConnection httpURLConnection = null;
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("name", this.f33163f);
            hashMap2.put(State.KEY_EMAIL, this.f33164g);
            hashMap2.put("subject", this.f33165h);
            hashMap2.put("text", this.f33166i);
            hashMap2.put("bundle_identifier", Constants.f26469c);
            hashMap2.put("bundle_short_version", Constants.f26468b);
            hashMap2.put("bundle_version", Constants.f26467a);
            hashMap2.put("os_version", Constants.f26470d);
            hashMap2.put("oem", Constants.f26473g);
            hashMap2.put("model", Constants.f26472f);
            hashMap2.put(State.KEY_SDK_VERSION, "5.1.0");
            if (this.f33167j != null) {
                hashMap2.put("user_string", this.f33167j);
            }
            if (this.f33169l != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f33162e);
                stringBuilder.append(this.f33169l);
                stringBuilder.append(Operation.DIVISION);
                this.f33162e = stringBuilder.toString();
            }
            HttpURLConnectionBuilder httpURLConnectionBuilder = new HttpURLConnectionBuilder(this.f33162e);
            httpURLConnectionBuilder.f26604a = this.f33169l != null ? HttpRequest.METHOD_PUT : HttpRequest.METHOD_POST;
            HttpURLConnection a = httpURLConnectionBuilder.m28214a(hashMap2).m28212a();
            try {
                a.connect();
                hashMap.put("status", String.valueOf(a.getResponseCode()));
                hashMap.put("response", ConnectionTask.m28194a(a));
                if (a != null) {
                    a.disconnect();
                }
            } catch (Throwable e) {
                HttpURLConnection httpURLConnection2 = a;
                th = e;
                httpURLConnection = httpURLConnection2;
                try {
                    HockeyLog.m28206a("Failed to send feedback message", th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return hashMap;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                httpURLConnection = a;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (IOException e2) {
            th = e2;
            HockeyLog.m28206a("Failed to send feedback message", th);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return hashMap;
        }
        return hashMap;
    }

    private HashMap<String, String> m33744d() {
        Throwable th;
        Throwable th2;
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("type", "send");
        HttpURLConnection httpURLConnection = null;
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("name", this.f33163f);
            hashMap2.put(State.KEY_EMAIL, this.f33164g);
            hashMap2.put("subject", this.f33165h);
            hashMap2.put("text", this.f33166i);
            hashMap2.put("bundle_identifier", Constants.f26469c);
            hashMap2.put("bundle_short_version", Constants.f26468b);
            hashMap2.put("bundle_version", Constants.f26467a);
            hashMap2.put("os_version", Constants.f26470d);
            hashMap2.put("oem", Constants.f26473g);
            hashMap2.put("model", Constants.f26472f);
            hashMap2.put(State.KEY_SDK_VERSION, "5.1.0");
            if (this.f33167j != null) {
                hashMap2.put("user_string", this.f33167j);
            }
            if (this.f33169l != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f33162e);
                stringBuilder.append(this.f33169l);
                stringBuilder.append(Operation.DIVISION);
                this.f33162e = stringBuilder.toString();
            }
            HttpURLConnectionBuilder httpURLConnectionBuilder = new HttpURLConnectionBuilder(this.f33162e);
            httpURLConnectionBuilder.f26604a = this.f33169l != null ? HttpRequest.METHOD_PUT : HttpRequest.METHOD_POST;
            HttpURLConnection a = httpURLConnectionBuilder.m28215a(hashMap2, this.f33158a, this.f33168k).m28212a();
            try {
                a.connect();
                hashMap.put("status", String.valueOf(a.getResponseCode()));
                hashMap.put("response", ConnectionTask.m28194a(a));
                if (a != null) {
                    a.disconnect();
                }
            } catch (Throwable e) {
                HttpURLConnection httpURLConnection2 = a;
                th = e;
                httpURLConnection = httpURLConnection2;
                try {
                    HockeyLog.m28206a("Failed to send feedback message", th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return hashMap;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                httpURLConnection = a;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (IOException e2) {
            th = e2;
            HockeyLog.m28206a("Failed to send feedback message", th);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return hashMap;
        }
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.HashMap<java.lang.String, java.lang.String> m33745e() {
        /*
        r5 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r5.f33162e;
        r0.append(r1);
        r1 = r5.f33169l;
        r1 = net.hockeyapp.android.utils.Util.m28233a(r1);
        r0.append(r1);
        r1 = r5.f33171n;
        r2 = -1;
        if (r1 == r2) goto L_0x0022;
    L_0x0018:
        r1 = "?last_message_id=";
        r0.append(r1);
        r1 = r5.f33171n;
        r0.append(r1);
    L_0x0022:
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = 0;
        r3 = new net.hockeyapp.android.utils.HttpURLConnectionBuilder;	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r0 = r0.toString();	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r3.<init>(r0);	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r0 = r3.m28212a();	 Catch:{ IOException -> 0x005e, all -> 0x005b }
        r2 = "type";
        r3 = "fetch";
        r1.put(r2, r3);	 Catch:{ IOException -> 0x0059 }
        r0.connect();	 Catch:{ IOException -> 0x0059 }
        r2 = "status";
        r3 = r0.getResponseCode();	 Catch:{ IOException -> 0x0059 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ IOException -> 0x0059 }
        r1.put(r2, r3);	 Catch:{ IOException -> 0x0059 }
        r2 = "response";
        r3 = net.hockeyapp.android.tasks.ConnectionTask.m28194a(r0);	 Catch:{ IOException -> 0x0059 }
        r1.put(r2, r3);	 Catch:{ IOException -> 0x0059 }
        if (r0 == 0) goto L_0x006c;
    L_0x0058:
        goto L_0x0069;
    L_0x0059:
        r2 = move-exception;
        goto L_0x0062;
    L_0x005b:
        r1 = move-exception;
        r0 = r2;
        goto L_0x006e;
    L_0x005e:
        r0 = move-exception;
        r4 = r2;
        r2 = r0;
        r0 = r4;
    L_0x0062:
        r3 = "Failed to fetching feedback messages";
        net.hockeyapp.android.utils.HockeyLog.m28206a(r3, r2);	 Catch:{ all -> 0x006d }
        if (r0 == 0) goto L_0x006c;
    L_0x0069:
        r0.disconnect();
    L_0x006c:
        return r1;
    L_0x006d:
        r1 = move-exception;
    L_0x006e:
        if (r0 == 0) goto L_0x0073;
    L_0x0070:
        r0.disconnect();
    L_0x0073:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.SendFeedbackTask.e():java.util.HashMap<java.lang.String, java.lang.String>");
    }

    public final String m33747b() {
        return this.f33170m ? this.f33158a.getString(C2158R.string.hockeyapp_feedback_fetching_feedback_text) : this.f33158a.getString(C2158R.string.hockeyapp_feedback_sending_feedback_text);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        if (this.f33170m != null && this.f33169l != null) {
            return m33745e();
        }
        if (this.f33170m != null) {
            return null;
        }
        if (this.f33168k.isEmpty() != null) {
            return m33743c();
        }
        objArr = m33744d();
        String str = (String) objArr.get("status");
        if (!(str == null || !str.startsWith("2") || this.f33158a == null)) {
            File file = new File(this.f33158a.getCacheDir(), "HockeyApp");
            int i = 0;
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (!(file2 == null || Boolean.valueOf(file2.delete()).booleanValue())) {
                        HockeyLog.m28205a("SendFeedbackTask", "Error deleting file from temporary folder");
                    }
                }
            }
            File[] listFiles = Constants.m28152b(this.f33158a).listFiles(new C21621(this));
            int length = listFiles.length;
            while (i < length) {
                File file3 = listFiles[i];
                if (this.f33168k.contains(Uri.fromFile(file3))) {
                    if (file3.delete()) {
                        StringBuilder stringBuilder = new StringBuilder("Screenshot '");
                        stringBuilder.append(file3.getName());
                        stringBuilder.append("' has been deleted");
                        HockeyLog.m28205a("SendFeedbackTask", stringBuilder.toString());
                    } else {
                        HockeyLog.m28208b("SendFeedbackTask", "Error deleting screenshot");
                    }
                }
                i++;
            }
        }
        return objArr;
    }
}
