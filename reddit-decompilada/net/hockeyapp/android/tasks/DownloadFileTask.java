package net.hockeyapp.android.tasks;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import net.hockeyapp.android.listeners.DownloadFileListener;

@SuppressLint({"StaticFieldLeak"})
public class DownloadFileTask extends AsyncTask<Void, Integer, Long> {
    protected Context f26586a;
    protected DownloadFileListener f26587b;
    protected String f26588c;
    protected String f26589d;
    protected File f26590e;
    protected ProgressDialog f26591f;
    private String f26592g = null;

    class C21601 implements OnClickListener {
        final /* synthetic */ DownloadFileTask f26584a;

        C21601(DownloadFileTask downloadFileTask) {
            this.f26584a = downloadFileTask;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f26584a.f26587b.mo5954a(Boolean.valueOf(0));
        }
    }

    class C21612 implements OnClickListener {
        final /* synthetic */ DownloadFileTask f26585a;

        C21612(DownloadFileTask downloadFileTask) {
            this.f26585a = downloadFileTask;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f26585a.f26587b.mo5954a(Boolean.valueOf(1));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return mo5956a();
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        mo5957a((Long) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        mo5958a((Integer[]) objArr);
    }

    public DownloadFileTask(Context context, String str, DownloadFileListener downloadFileListener) {
        this.f26586a = context;
        this.f26588c = str;
        str = new StringBuilder();
        str.append(UUID.randomUUID());
        str.append(".apk");
        this.f26589d = str.toString();
        this.f26590e = new File(context.getExternalFilesDir(null), "Download");
        this.f26587b = downloadFileListener;
    }

    protected java.lang.Long mo5956a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = 0;
        r1 = 0;
        r3 = new java.net.URL;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4 = r13.m28199b();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4 = 6;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3 = m28195a(r3, r4);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3.connect();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4 = r3.getContentLength();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r3.getContentType();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        if (r5 == 0) goto L_0x002f;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x001e:
        r6 = "text";	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r5.contains(r6);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        if (r5 == 0) goto L_0x002f;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x0026:
        r3 = "The requested download does not appear to be a file.";	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r13.f26592g = r3;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3 = java.lang.Long.valueOf(r1);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        return r3;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x002f:
        r5 = r13.f26590e;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r5.mkdirs();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        if (r5 != 0) goto L_0x0059;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x0037:
        r5 = r13.f26590e;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r5.exists();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        if (r5 != 0) goto L_0x0059;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x003f:
        r3 = new java.io.IOException;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = "Could not create the dir(s):";	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r13.f26590e;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5 = r5.getAbsolutePath();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4.append(r5);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        throw r3;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
    L_0x0059:
        r5 = new java.io.File;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r6 = r13.f26590e;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r7 = r13.f26589d;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r5.<init>(r6, r7);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r6 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3 = r3.getInputStream();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00af }
        r3.<init>(r5);	 Catch:{ IOException -> 0x00af }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r7 = r1;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
    L_0x0075:
        r5 = r6.read(r0);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r9 = -1;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        if (r5 == r9) goto L_0x0099;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
    L_0x007c:
        r9 = (long) r5;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r7 = r7 + r9;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r9 = 1;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r9 = new java.lang.Integer[r9];	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r10 = (float) r7;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r11 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r10 = r10 * r11;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r11 = (float) r4;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r10 = r10 / r11;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r10 = java.lang.Math.round(r10);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r11 = 0;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r9[r11] = r10;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r13.publishProgress(r9);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r3.write(r0, r11, r5);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        goto L_0x0075;	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
    L_0x0099:
        r3.flush();	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r0 = java.lang.Long.valueOf(r7);	 Catch:{ IOException -> 0x00aa, all -> 0x00a7 }
        r3.close();	 Catch:{ IOException -> 0x00a6 }
        r6.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x00a6:
        return r0;
    L_0x00a7:
        r1 = move-exception;
        r0 = r3;
        goto L_0x00d9;
    L_0x00aa:
        r0 = move-exception;
        r12 = r3;
        r3 = r0;
        r0 = r12;
        goto L_0x00b6;
    L_0x00af:
        r3 = move-exception;
        goto L_0x00b6;
    L_0x00b1:
        r1 = move-exception;
        r6 = r0;
        goto L_0x00d9;
    L_0x00b4:
        r3 = move-exception;
        r6 = r0;
    L_0x00b6:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d8 }
        r5 = "Failed to download ";	 Catch:{ all -> 0x00d8 }
        r4.<init>(r5);	 Catch:{ all -> 0x00d8 }
        r5 = r13.f26588c;	 Catch:{ all -> 0x00d8 }
        r4.append(r5);	 Catch:{ all -> 0x00d8 }
        r4 = r4.toString();	 Catch:{ all -> 0x00d8 }
        net.hockeyapp.android.utils.HockeyLog.m28206a(r4, r3);	 Catch:{ all -> 0x00d8 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x00d8 }
        if (r0 == 0) goto L_0x00d2;
    L_0x00cf:
        r0.close();	 Catch:{ IOException -> 0x00d7 }
    L_0x00d2:
        if (r6 == 0) goto L_0x00d7;	 Catch:{ IOException -> 0x00d7 }
    L_0x00d4:
        r6.close();	 Catch:{ IOException -> 0x00d7 }
    L_0x00d7:
        return r1;
    L_0x00d8:
        r1 = move-exception;
    L_0x00d9:
        if (r0 == 0) goto L_0x00de;
    L_0x00db:
        r0.close();	 Catch:{ IOException -> 0x00e3 }
    L_0x00de:
        if (r6 == 0) goto L_0x00e3;	 Catch:{ IOException -> 0x00e3 }
    L_0x00e0:
        r6.close();	 Catch:{ IOException -> 0x00e3 }
    L_0x00e3:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.DownloadFileTask.a():java.lang.Long");
    }

    protected static URLConnection m28195a(URL url, int i) throws IOException {
        HttpURLConnection httpURLConnection;
        while (true) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "HockeySDK/Android 5.1.0");
            httpURLConnection.setInstanceFollowRedirects(true);
            int responseCode = httpURLConnection.getResponseCode();
            if ((responseCode == 301 || responseCode == 302 || responseCode == 303) && i != 0) {
                URL url2 = new URL(httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION));
                if (url.getProtocol().equals(url2.getProtocol()) != null) {
                    break;
                }
                httpURLConnection.disconnect();
                i--;
                url = url2;
            } else {
                return httpURLConnection;
            }
        }
        return httpURLConnection;
    }

    protected void mo5958a(java.lang.Integer... r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r1 = 0;	 Catch:{ Exception -> 0x0037 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ Exception -> 0x0037 }
    L_0x0005:
        r0 = new android.app.ProgressDialog;	 Catch:{ Exception -> 0x0037 }
        r2 = r4.f26586a;	 Catch:{ Exception -> 0x0037 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0037 }
        r4.f26591f = r0;	 Catch:{ Exception -> 0x0037 }
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r2 = 1;	 Catch:{ Exception -> 0x0037 }
        r0.setProgressStyle(r2);	 Catch:{ Exception -> 0x0037 }
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r2 = r4.f26586a;	 Catch:{ Exception -> 0x0037 }
        r3 = net.hockeyapp.android.C2158R.string.hockeyapp_update_loading;	 Catch:{ Exception -> 0x0037 }
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x0037 }
        r0.setMessage(r2);	 Catch:{ Exception -> 0x0037 }
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r0.setCancelable(r1);	 Catch:{ Exception -> 0x0037 }
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r0.show();	 Catch:{ Exception -> 0x0037 }
    L_0x002b:
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0037 }
        r5 = r5[r1];	 Catch:{ Exception -> 0x0037 }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x0037 }
        r0.setProgress(r5);	 Catch:{ Exception -> 0x0037 }
        return;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.DownloadFileTask.a(java.lang.Integer[]):void");
    }

    protected void mo5957a(java.lang.Long r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f26591f;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r4.f26591f;	 Catch:{ Exception -> 0x0009 }
        r0.dismiss();	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        r0 = r5.longValue();
        r2 = 0;
        r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r5 <= 0) goto L_0x005c;
    L_0x0013:
        r5 = r4.f26587b;
        r5.mo5953a(r4);
        r5 = new android.content.Intent;
        r0 = "android.intent.action.INSTALL_PACKAGE";
        r5.<init>(r0);
        r0 = new java.io.File;
        r1 = r4.f26590e;
        r2 = r4.f26589d;
        r0.<init>(r1, r2);
        r0 = android.net.Uri.fromFile(r0);
        r1 = "application/vnd.android.package-archive";
        r5.setDataAndType(r0, r1);
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r5.setFlags(r0);
        r0 = 0;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 24;
        if (r1 < r2) goto L_0x0051;
    L_0x003d:
        r0 = android.os.StrictMode.getVmPolicy();
        r1 = new android.os.StrictMode$VmPolicy$Builder;
        r1.<init>();
        r1 = r1.penaltyLog();
        r1 = r1.build();
        android.os.StrictMode.setVmPolicy(r1);
    L_0x0051:
        r1 = r4.f26586a;
        r1.startActivity(r5);
        if (r0 == 0) goto L_0x005b;
    L_0x0058:
        android.os.StrictMode.setVmPolicy(r0);
    L_0x005b:
        return;
    L_0x005c:
        r5 = new android.app.AlertDialog$Builder;	 Catch:{ Exception -> 0x0096 }
        r0 = r4.f26586a;	 Catch:{ Exception -> 0x0096 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0096 }
        r0 = net.hockeyapp.android.C2158R.string.hockeyapp_download_failed_dialog_title;	 Catch:{ Exception -> 0x0096 }
        r5.setTitle(r0);	 Catch:{ Exception -> 0x0096 }
        r0 = r4.f26592g;	 Catch:{ Exception -> 0x0096 }
        if (r0 != 0) goto L_0x0075;	 Catch:{ Exception -> 0x0096 }
    L_0x006c:
        r0 = r4.f26586a;	 Catch:{ Exception -> 0x0096 }
        r1 = net.hockeyapp.android.C2158R.string.hockeyapp_download_failed_dialog_message;	 Catch:{ Exception -> 0x0096 }
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0096 }
        goto L_0x0077;	 Catch:{ Exception -> 0x0096 }
    L_0x0075:
        r0 = r4.f26592g;	 Catch:{ Exception -> 0x0096 }
    L_0x0077:
        r5.setMessage(r0);	 Catch:{ Exception -> 0x0096 }
        r0 = net.hockeyapp.android.C2158R.string.hockeyapp_download_failed_dialog_negative_button;	 Catch:{ Exception -> 0x0096 }
        r1 = new net.hockeyapp.android.tasks.DownloadFileTask$1;	 Catch:{ Exception -> 0x0096 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0096 }
        r5.setNegativeButton(r0, r1);	 Catch:{ Exception -> 0x0096 }
        r0 = net.hockeyapp.android.C2158R.string.hockeyapp_download_failed_dialog_positive_button;	 Catch:{ Exception -> 0x0096 }
        r1 = new net.hockeyapp.android.tasks.DownloadFileTask$2;	 Catch:{ Exception -> 0x0096 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0096 }
        r5.setPositiveButton(r0, r1);	 Catch:{ Exception -> 0x0096 }
        r5 = r5.create();	 Catch:{ Exception -> 0x0096 }
        r5.show();	 Catch:{ Exception -> 0x0096 }
        return;
    L_0x0096:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.tasks.DownloadFileTask.a(java.lang.Long):void");
    }

    protected final String m28199b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26588c);
        stringBuilder.append("&type=apk");
        return stringBuilder.toString();
    }
}
