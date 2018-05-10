package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzv;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;

final class zzy {
    private SharedPreferences f8689a;
    private Context f8690b;

    public zzy(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzy(Context context, String str) {
        this.f8690b = context;
        this.f8689a = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        str = String.valueOf("-no-backup");
        File file = new File(zzv.m4922a(this.f8690b), str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m7420c()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    m7427b();
                    FirebaseInstanceId.m7356a().m7367h();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    private static String m7418a(String str, String str2) {
        String str3 = "|S|";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + String.valueOf(str3).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static String m7419b(String str, String str2, String str3) {
        String str4 = "|T|";
        StringBuilder stringBuilder = new StringBuilder((((1 + String.valueOf(str).length()) + String.valueOf(str4).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    private final synchronized boolean m7420c() {
        return this.f8689a.getAll().isEmpty();
    }

    private final void m7421f(String str) {
        Editor edit = this.f8689a.edit();
        for (String str2 : this.f8689a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public final synchronized zzz m7422a(String str, String str2, String str3) {
        return zzz.m7431a(this.f8689a.getString(m7419b(str, str2, str3), null));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String m7423a() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f8689a;	 Catch:{ all -> 0x0024 }
        r1 = "topic_operaion_queue";
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022;
    L_0x000c:
        r1 = ",";
        r0 = r0.split(r1);	 Catch:{ all -> 0x0024 }
        r1 = r0.length;	 Catch:{ all -> 0x0024 }
        r3 = 1;
        if (r1 <= r3) goto L_0x0022;
    L_0x0016:
        r1 = r0[r3];	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0022;
    L_0x001e:
        r0 = r0[r3];	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);
        return r0;
    L_0x0022:
        monitor-exit(r4);
        return r2;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.a():java.lang.String");
    }

    public final synchronized void m7424a(String str, String str2, String str3, String str4, String str5) {
        str4 = zzz.m7432a(str4, str5, System.currentTimeMillis());
        if (str4 != null) {
            Editor edit = this.f8689a.edit();
            edit.putString(m7419b(str, str2, str3), str4);
            edit.commit();
        }
    }

    public final synchronized boolean m7425a(String str) {
        boolean z;
        String string = this.f8689a.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            str = String.valueOf(str);
            this.f8689a.edit().putString("topic_operaion_queue", string.substring((str.length() != 0 ? valueOf.concat(str) : new String(valueOf)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    final synchronized KeyPair m7426b(String str) {
        KeyPair a;
        a = zza.m7368a();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.f8689a.edit();
        edit.putString(m7418a(str, "|P|"), Base64.encodeToString(a.getPublic().getEncoded(), 11));
        edit.putString(m7418a(str, "|K|"), Base64.encodeToString(a.getPrivate().getEncoded(), 11));
        edit.putString(m7418a(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return a;
    }

    public final synchronized void m7427b() {
        this.f8689a.edit().clear().commit();
    }

    final synchronized void m7428c(String str) {
        m7421f(String.valueOf(str).concat("|"));
    }

    public final synchronized void m7429d(String str) {
        m7421f(String.valueOf(str).concat("|T|"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.security.KeyPair m7430e(java.lang.String r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f8689a;	 Catch:{ all -> 0x0079 }
        r1 = "|P|";
        r1 = m7418a(r5, r1);	 Catch:{ all -> 0x0079 }
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0079 }
        r1 = r4.f8689a;	 Catch:{ all -> 0x0079 }
        r3 = "|K|";
        r5 = m7418a(r5, r3);	 Catch:{ all -> 0x0079 }
        r5 = r1.getString(r5, r2);	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0077;
    L_0x001c:
        if (r5 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0077;
    L_0x001f:
        r1 = 8;
        r0 = android.util.Base64.decode(r0, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = android.util.Base64.decode(r5, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = "RSA";
        r1 = java.security.KeyFactory.getInstance(r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r0);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r0 = r1.generatePublic(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = r1.generatePrivate(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = new java.security.KeyPair;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1.<init>(r0, r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        monitor-exit(r4);
        return r1;
    L_0x0048:
        r5 = move-exception;
        r0 = "FirebaseInstanceId";
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0079 }
        r1 = 19;
        r3 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0079 }
        r3 = r3.length();	 Catch:{ all -> 0x0079 }
        r1 = r1 + r3;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0079 }
        r3.<init>(r1);	 Catch:{ all -> 0x0079 }
        r1 = "Invalid key stored ";
        r3.append(r1);	 Catch:{ all -> 0x0079 }
        r3.append(r5);	 Catch:{ all -> 0x0079 }
        r5 = r3.toString();	 Catch:{ all -> 0x0079 }
        android.util.Log.w(r0, r5);	 Catch:{ all -> 0x0079 }
        r5 = com.google.firebase.iid.FirebaseInstanceId.m7356a();	 Catch:{ all -> 0x0079 }
        r5.m7367h();	 Catch:{ all -> 0x0079 }
        monitor-exit(r4);
        return r2;
    L_0x0077:
        monitor-exit(r4);
        return r2;
    L_0x0079:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.e(java.lang.String):java.security.KeyPair");
    }
}
