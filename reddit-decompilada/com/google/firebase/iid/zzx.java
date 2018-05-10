package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayDeque;
import java.util.Queue;

public final class zzx {
    private static zzx f8684c;
    final Queue<Intent> f8685a = new ArrayDeque();
    public Queue<Intent> f8686b = new ArrayDeque();
    private final SimpleArrayMap<String, String> f8687d = new SimpleArrayMap();
    private Boolean f8688e = null;

    private zzx() {
    }

    public static PendingIntent m7415a(Context context, int i, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, 1073741824);
    }

    public static synchronized zzx m7416a() {
        zzx com_google_firebase_iid_zzx;
        synchronized (zzx.class) {
            if (f8684c == null) {
                f8684c = new zzx();
            }
            com_google_firebase_iid_zzx = f8684c;
        }
        return com_google_firebase_iid_zzx;
    }

    final int m7417a(Context context, Intent intent) {
        String str;
        ComponentName a_;
        synchronized (this.f8687d) {
            str = (String) this.f8687d.get(intent.getAction());
        }
        boolean z = false;
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                if (resolveService.serviceInfo != null) {
                    ServiceInfo serviceInfo = resolveService.serviceInfo;
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        if (serviceInfo.name != null) {
                            str = serviceInfo.name;
                            if (str.startsWith(".")) {
                                String valueOf = String.valueOf(context.getPackageName());
                                str = String.valueOf(str);
                                str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                            }
                            synchronized (this.f8687d) {
                                this.f8687d.put(intent.getAction(), str);
                            }
                        }
                    }
                    String str2 = serviceInfo.packageName;
                    str = serviceInfo.name;
                    StringBuilder stringBuilder = new StringBuilder((94 + String.valueOf(str2).length()) + String.valueOf(str).length());
                    stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                    stringBuilder.append(str2);
                    stringBuilder.append(Operation.DIVISION);
                    stringBuilder.append(str);
                    Log.e("FirebaseInstanceId", stringBuilder.toString());
                    if (this.f8688e == null) {
                        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                            z = true;
                        }
                        this.f8688e = Boolean.valueOf(z);
                    }
                    if (this.f8688e.booleanValue()) {
                        a_ = WakefulBroadcastReceiver.a_(context, intent);
                    } else {
                        a_ = context.startService(intent);
                        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                    }
                    if (a_ == null) {
                        return -1;
                    }
                    Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                    return HttpStatus.HTTP_NOT_FOUND;
                }
            }
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            if (this.f8688e == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.f8688e = Boolean.valueOf(z);
            }
            if (this.f8688e.booleanValue()) {
                a_ = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            } else {
                a_ = WakefulBroadcastReceiver.a_(context, intent);
            }
            if (a_ == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            str2 = "Restricting intent to a specific service: ";
            String valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
        try {
            if (this.f8688e == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.f8688e = Boolean.valueOf(z);
            }
            if (this.f8688e.booleanValue()) {
                a_ = WakefulBroadcastReceiver.a_(context, intent);
            } else {
                a_ = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (a_ == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf3 = String.valueOf(e2);
            StringBuilder stringBuilder2 = new StringBuilder(45 + String.valueOf(valueOf3).length());
            stringBuilder2.append("Failed to start service while in background: ");
            stringBuilder2.append(valueOf3);
            Log.e("FirebaseInstanceId", stringBuilder2.toString());
            return 402;
        }
    }
}
