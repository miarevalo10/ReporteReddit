package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.IOException;

final class zzaa implements Runnable {
    private final long f8619a;
    private final WakeLock f8620b = ((PowerManager) m7372a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId f8621c;
    private final zzu f8622d;

    zzaa(FirebaseInstanceId firebaseInstanceId, zzu com_google_firebase_iid_zzu, long j) {
        this.f8621c = firebaseInstanceId;
        this.f8622d = com_google_firebase_iid_zzu;
        this.f8619a = j;
        this.f8620b.setReferenceCounted(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m7371d() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.f8621c;
        monitor-enter(r0);
        r1 = com.google.firebase.iid.FirebaseInstanceId.m7358f();	 Catch:{ all -> 0x0028 }
        r1 = r1.m7423a();	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0017;
    L_0x000d:
        r1 = "FirebaseInstanceId";
        r2 = "topic sync succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ all -> 0x0028 }
        r1 = 1;
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        return r1;
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        r0 = r3.m7369a(r1);
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        r0 = 0;
        return r0;
    L_0x0020:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m7358f();
        r0.m7425a(r1);
        goto L_0x0000;
    L_0x0028:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzaa.d():boolean");
    }

    final boolean m7373b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) m7372a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void run() {
        this.f8620b.acquire();
        try {
            boolean z = true;
            this.f8621c.m7362a(true);
            if (this.f8622d.m7404a() == 0) {
                z = false;
            }
            if (z) {
                if (!m7373b()) {
                    BroadcastReceiver com_google_firebase_iid_zzab = new zzab(this);
                    if (FirebaseInstanceId.m7359g()) {
                        Log.d("FirebaseInstanceId", "Connectivity change received registered");
                    }
                    com_google_firebase_iid_zzab.f8623a.m7372a().registerReceiver(com_google_firebase_iid_zzab, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } else if (m7370c() && m7371d()) {
                    this.f8621c.m7362a(false);
                } else {
                    this.f8621c.m7361a(this.f8619a);
                }
                this.f8620b.release();
                return;
            }
            this.f8621c.m7362a(false);
        } finally {
            this.f8620b.release();
        }
    }

    private final boolean m7370c() {
        zzz e = this.f8621c.m7366e();
        if (e != null && !e.m7433b(this.f8622d.m7405b())) {
            return true;
        }
        String str;
        try {
            FirebaseInstanceId firebaseInstanceId = this.f8621c;
            String a = zzu.m7401a(firebaseInstanceId.f8614b);
            String str2 = Operation.MULTIPLY;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                throw new IOException("MAIN_THREAD");
            }
            zzz a2 = FirebaseInstanceId.f8610a.m7422a("", a, str2);
            if (a2 == null || a2.m7433b(firebaseInstanceId.f8615c.m7405b())) {
                String a3 = firebaseInstanceId.m7360a(a, str2, new Bundle());
                if (a3 != null) {
                    FirebaseInstanceId.f8610a.m7424a("", a, str2, a3, firebaseInstanceId.f8615c.m7405b());
                }
                str = a3;
            } else {
                str = a2.f8692a;
            }
            if (str == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (e == null || !(e == null || str.equals(e.f8692a))) {
                Context a4 = m7372a();
                Parcelable intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                intent2.setClass(a4, FirebaseInstanceIdReceiver.class);
                intent2.putExtra("wrapped_intent", intent);
                a4.sendBroadcast(intent2);
            }
            return true;
        } catch (Exception e2) {
            String str3 = "FirebaseInstanceId";
            str = "Token retrieval failed: ";
            String valueOf = String.valueOf(e2.getMessage());
            Log.e(str3, valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
            return false;
        }
    }

    private final boolean m7369a(String str) {
        str = str.split("!");
        if (str.length == 2) {
            String str2 = str[0];
            str = str[1];
            boolean z = true;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str2.equals("U")) {
                            z = true;
                        }
                    }
                } else if (str2.equals("S")) {
                    z = false;
                }
                FirebaseInstanceId firebaseInstanceId;
                zzz e;
                Bundle bundle;
                String str3;
                String valueOf;
                String valueOf2;
                String str4;
                switch (z) {
                    case false:
                        firebaseInstanceId = this.f8621c;
                        e = firebaseInstanceId.m7366e();
                        if (e != null) {
                            if (!e.m7433b(firebaseInstanceId.f8615c.m7405b())) {
                                bundle = new Bundle();
                                str3 = "gcm.topic";
                                valueOf = String.valueOf("/topics/");
                                valueOf2 = String.valueOf(str);
                                bundle.putString(str3, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                                str4 = e.f8692a;
                                str3 = String.valueOf("/topics/");
                                str = String.valueOf(str);
                                firebaseInstanceId.m7360a(str4, str.length() != 0 ? str3.concat(str) : new String(str3), bundle);
                                if (FirebaseInstanceId.m7359g() != null) {
                                    Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                                    break;
                                }
                            }
                        }
                        throw new IOException("token not available");
                    case true:
                        firebaseInstanceId = this.f8621c;
                        e = firebaseInstanceId.m7366e();
                        if (e != null) {
                            if (!e.m7433b(firebaseInstanceId.f8615c.m7405b())) {
                                bundle = new Bundle();
                                str3 = "gcm.topic";
                                valueOf = String.valueOf("/topics/");
                                valueOf2 = String.valueOf(str);
                                bundle.putString(str3, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                                bundle.putString("delete", "1");
                                str4 = e.f8692a;
                                str3 = String.valueOf("/topics/");
                                str = String.valueOf(str);
                                firebaseInstanceId.m7360a(str4, str.length() != 0 ? str3.concat(str) : new String(str3), bundle);
                                if (FirebaseInstanceId.m7359g() != null) {
                                    Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                                    break;
                                }
                            }
                        }
                        throw new IOException("token not available");
                    default:
                        break;
                }
            } catch (String str5) {
                String str6 = "FirebaseInstanceId";
                str2 = "Topic sync failed: ";
                str5 = String.valueOf(str5.getMessage());
                Log.e(str6, str5.length() != 0 ? str2.concat(str5) : new String(str2));
                return false;
            }
        }
        return true;
    }

    final Context m7372a() {
        return this.f8621c.f8614b.m7353a();
    }
}
