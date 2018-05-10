package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzzv
public final class zznk {
    public LinkedHashMap<String, String> f7924a = new LinkedHashMap();
    private BlockingQueue<zznu> f7925b;
    private ExecutorService f7926c;
    private Map<String, zzno> f7927d = new HashMap();
    private String f7928e;
    private Context f7929f;
    private String f7930g;
    private AtomicBoolean f7931h;
    private File f7932i;

    public zznk(Context context, String str, String str2, Map<String, String> map) {
        this.f7929f = context;
        this.f7930g = str;
        this.f7928e = str2;
        this.f7931h = new AtomicBoolean(false);
        this.f7931h.set(((Boolean) zzkb.m6350f().m6488a(zznh.f7874J)).booleanValue());
        if (this.f7931h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f7932i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f7924a.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f7925b = new ArrayBlockingQueue(30);
        this.f7926c = Executors.newSingleThreadExecutor();
        this.f7926c.execute(new zznl(this));
        this.f7927d.put("action", zzno.f7935b);
        this.f7927d.put("ad_format", zzno.f7935b);
        this.f7927d.put("e", zzno.f7936c);
    }

    public final zzno m6494a(String str) {
        zzno com_google_android_gms_internal_zzno = (zzno) this.f7927d.get(str);
        return com_google_android_gms_internal_zzno != null ? com_google_android_gms_internal_zzno : zzno.f7934a;
    }

    final Map<String, String> m6495a(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m6494a(str).mo2059a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public final boolean m6496a(zznu com_google_android_gms_internal_zznu) {
        return this.f7925b.offer(com_google_android_gms_internal_zznu);
    }

    static /* synthetic */ void m6493a(zznk com_google_android_gms_internal_zznk) {
        FileOutputStream fileOutputStream;
        Throwable e;
        while (true) {
            try {
                zznu com_google_android_gms_internal_zznu = (zznu) com_google_android_gms_internal_zznk.f7925b.take();
                Object b = com_google_android_gms_internal_zznu.m6507b();
                if (!TextUtils.isEmpty(b)) {
                    Map a = com_google_android_gms_internal_zznk.m6495a(com_google_android_gms_internal_zznk.f7924a, com_google_android_gms_internal_zznu.m6508c());
                    Builder buildUpon = Uri.parse(com_google_android_gms_internal_zznk.f7928e).buildUpon();
                    for (Entry entry : a.entrySet()) {
                        buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                    }
                    StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
                    stringBuilder.append("&it=");
                    stringBuilder.append(b);
                    String stringBuilder2 = stringBuilder.toString();
                    if (com_google_android_gms_internal_zznk.f7931h.get()) {
                        File file = com_google_android_gms_internal_zznk.f7932i;
                        if (file != null) {
                            fileOutputStream = null;
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                                try {
                                    fileOutputStream2.write(stringBuilder2.getBytes());
                                    fileOutputStream2.write(10);
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        zzakb.m5369c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        com_google_android_gms_internal_zznk = th;
                                    }
                                } catch (Throwable th2) {
                                    com_google_android_gms_internal_zznk = th2;
                                    fileOutputStream = fileOutputStream2;
                                }
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e3) {
                                    zzakb.m5369c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                                }
                            } catch (IOException e4) {
                                e3 = e4;
                                zzakb.m5369c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e3);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            }
                        } else {
                            zzakb.m5371e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        zzbs.m4486e();
                        zzahn.m5192b(com_google_android_gms_internal_zznk.f7929f, com_google_android_gms_internal_zznk.f7930g, stringBuilder2);
                    }
                }
            } catch (zznk com_google_android_gms_internal_zznk2) {
                zzakb.m5369c("CsiReporter:reporter interrupted", com_google_android_gms_internal_zznk2);
                return;
            }
        }
        throw com_google_android_gms_internal_zznk2;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable e32) {
                zzakb.m5369c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e32);
            }
        }
        throw com_google_android_gms_internal_zznk2;
    }
}
