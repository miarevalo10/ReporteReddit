package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzv {
    private static int f8675a;
    private static PendingIntent f8676b;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> f8677c = new SimpleArrayMap();
    private final Context f8678d;
    private final zzu f8679e;
    private Messenger f8680f;
    private Messenger f8681g;
    private MessengerCompat f8682h;

    public zzv(Context context, zzu com_google_firebase_iid_zzu) {
        this.f8678d = context;
        this.f8679e = com_google_firebase_iid_zzu;
        this.f8680f = new Messenger(new zzw(this, Looper.getMainLooper()));
    }

    private static synchronized String m7408a() {
        String num;
        synchronized (zzv.class) {
            int i = f8675a;
            f8675a = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static synchronized void m7409a(Context context, Intent intent) {
        synchronized (zzv.class) {
            if (f8676b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f8676b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f8676b);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7411a(java.lang.String r4, java.lang.String r5) {
        /*
        r3 = this;
        r0 = r3.f8677c;
        monitor-enter(r0);
        if (r4 != 0) goto L_0x0027;
    L_0x0005:
        r4 = 0;
    L_0x0006:
        r1 = r3.f8677c;	 Catch:{ all -> 0x0058 }
        r1 = r1.size();	 Catch:{ all -> 0x0058 }
        if (r4 >= r1) goto L_0x0021;
    L_0x000e:
        r1 = r3.f8677c;	 Catch:{ all -> 0x0058 }
        r1 = r1.m1054c(r4);	 Catch:{ all -> 0x0058 }
        r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1;	 Catch:{ all -> 0x0058 }
        r2 = new java.io.IOException;	 Catch:{ all -> 0x0058 }
        r2.<init>(r5);	 Catch:{ all -> 0x0058 }
        r1.m6858a(r2);	 Catch:{ all -> 0x0058 }
        r4 = r4 + 1;
        goto L_0x0006;
    L_0x0021:
        r4 = r3.f8677c;	 Catch:{ all -> 0x0058 }
        r4.clear();	 Catch:{ all -> 0x0058 }
        goto L_0x0056;
    L_0x0027:
        r1 = r3.f8677c;	 Catch:{ all -> 0x0058 }
        r1 = r1.remove(r4);	 Catch:{ all -> 0x0058 }
        r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1;	 Catch:{ all -> 0x0058 }
        if (r1 != 0) goto L_0x004e;
    L_0x0031:
        r5 = "FirebaseInstanceId";
        r1 = "Missing callback for ";
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0058 }
        r2 = r4.length();	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0044;
    L_0x003f:
        r4 = r1.concat(r4);	 Catch:{ all -> 0x0058 }
        goto L_0x0049;
    L_0x0044:
        r4 = new java.lang.String;	 Catch:{ all -> 0x0058 }
        r4.<init>(r1);	 Catch:{ all -> 0x0058 }
    L_0x0049:
        android.util.Log.w(r5, r4);	 Catch:{ all -> 0x0058 }
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x004e:
        r4 = new java.io.IOException;	 Catch:{ all -> 0x0058 }
        r4.<init>(r5);	 Catch:{ all -> 0x0058 }
        r1.m6858a(r4);	 Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.a(java.lang.String, java.lang.String):void");
    }

    private final Bundle m7412b(Bundle bundle) throws IOException {
        Bundle c = m7413c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        c = m7413c(bundle);
        return (c == null || !c.containsKey("google.messenger")) ? c : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final android.os.Bundle m7414a(android.os.Bundle r6) throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.f8679e;
        r0 = r0.m7407d();
        r1 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r1) goto L_0x006e;
    L_0x000b:
        r0 = r5.f8678d;
        r0 = com.google.firebase.iid.zzi.m7384a(r0);
        r1 = new com.google.firebase.iid.zzt;
        r2 = r0.m7386a();
        r1.<init>(r2, r6);
        r0 = r0.m7387a(r1);
        r0 = com.google.android.gms.tasks.Tasks.m6864a(r0);	 Catch:{ InterruptedException -> 0x0025, InterruptedException -> 0x0025 }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x0025, InterruptedException -> 0x0025 }
        return r0;
    L_0x0025:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0054;
    L_0x002f:
        r1 = "FirebaseInstanceId";
        r2 = java.lang.String.valueOf(r0);
        r3 = 22;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Error making request: ";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        android.util.Log.d(r1, r2);
    L_0x0054:
        r1 = r0.getCause();
        r1 = r1 instanceof com.google.firebase.iid.zzs;
        if (r1 == 0) goto L_0x006c;
    L_0x005c:
        r0 = r0.getCause();
        r0 = (com.google.firebase.iid.zzs) r0;
        r0 = r0.f8669a;
        r1 = 4;
        if (r0 != r1) goto L_0x006c;
    L_0x0067:
        r6 = r5.m7412b(r6);
        return r6;
    L_0x006c:
        r6 = 0;
        return r6;
    L_0x006e:
        r6 = r5.m7412b(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.a(android.os.Bundle):android.os.Bundle");
    }

    private final android.os.Bundle m7413c(android.os.Bundle r9) throws java.io.IOException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = m7408a();
        r1 = new com.google.android.gms.tasks.TaskCompletionSource;
        r1.<init>();
        r2 = r8.f8677c;
        monitor-enter(r2);
        r3 = r8.f8677c;	 Catch:{ all -> 0x012b }
        r3.put(r0, r1);	 Catch:{ all -> 0x012b }
        monitor-exit(r2);	 Catch:{ all -> 0x012b }
        r2 = r8.f8679e;
        r2 = r2.m7404a();
        if (r2 != 0) goto L_0x0022;
    L_0x001a:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x0022:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r8.f8679e;
        r3 = r3.m7404a();
        r4 = 2;
        if (r3 != r4) goto L_0x003b;
    L_0x0035:
        r3 = "com.google.iid.TOKEN_REQUEST";
    L_0x0037:
        r2.setAction(r3);
        goto L_0x003e;
    L_0x003b:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        goto L_0x0037;
    L_0x003e:
        r2.putExtras(r9);
        r9 = r8.f8678d;
        m7409a(r9, r2);
        r9 = "kid";
        r3 = 5;
        r5 = java.lang.String.valueOf(r0);
        r5 = r5.length();
        r3 = r3 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r3);
        r3 = "|ID|";
        r5.append(r3);
        r5.append(r0);
        r3 = "|";
        r5.append(r3);
        r3 = r5.toString();
        r2.putExtra(r9, r3);
        r9 = "FirebaseInstanceId";
        r3 = 3;
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x009d;
    L_0x0074:
        r9 = "FirebaseInstanceId";
        r5 = r2.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = 8;
        r7 = java.lang.String.valueOf(r5);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Sending ";
        r7.append(r6);
        r7.append(r5);
        r5 = r7.toString();
        android.util.Log.d(r9, r5);
    L_0x009d:
        r9 = "google.messenger";
        r5 = r8.f8680f;
        r2.putExtra(r9, r5);
        r9 = r8.f8681g;
        if (r9 != 0) goto L_0x00ac;
    L_0x00a8:
        r9 = r8.f8682h;
        if (r9 == 0) goto L_0x00d1;
    L_0x00ac:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r5 = r8.f8681g;	 Catch:{ RemoteException -> 0x00c2 }
        if (r5 == 0) goto L_0x00bc;	 Catch:{ RemoteException -> 0x00c2 }
    L_0x00b6:
        r5 = r8.f8681g;	 Catch:{ RemoteException -> 0x00c2 }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00c2 }
        goto L_0x00e4;	 Catch:{ RemoteException -> 0x00c2 }
    L_0x00bc:
        r5 = r8.f8682h;	 Catch:{ RemoteException -> 0x00c2 }
        r5.m13134a(r9);	 Catch:{ RemoteException -> 0x00c2 }
        goto L_0x00e4;
    L_0x00c2:
        r9 = "FirebaseInstanceId";
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x00d1;
    L_0x00ca:
        r9 = "FirebaseInstanceId";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x00d1:
        r9 = r8.f8679e;
        r9 = r9.m7404a();
        if (r9 != r4) goto L_0x00df;
    L_0x00d9:
        r9 = r8.f8678d;
        r9.sendBroadcast(r2);
        goto L_0x00e4;
    L_0x00df:
        r9 = r8.f8678d;
        r9.startService(r2);
    L_0x00e4:
        r9 = r1.f8211a;	 Catch:{ InterruptedException -> 0x010f, InterruptedException -> 0x010f, ExecutionException -> 0x00fd }
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x010f, InterruptedException -> 0x010f, ExecutionException -> 0x00fd }
        r9 = com.google.android.gms.tasks.Tasks.m6865a(r9, r1);	 Catch:{ InterruptedException -> 0x010f, InterruptedException -> 0x010f, ExecutionException -> 0x00fd }
        r9 = (android.os.Bundle) r9;	 Catch:{ InterruptedException -> 0x010f, InterruptedException -> 0x010f, ExecutionException -> 0x00fd }
        r1 = r8.f8677c;
        monitor-enter(r1);
        r2 = r8.f8677c;	 Catch:{ all -> 0x00f8 }
        r2.remove(r0);	 Catch:{ all -> 0x00f8 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f8 }
        return r9;	 Catch:{ all -> 0x00f8 }
    L_0x00f8:
        r9 = move-exception;	 Catch:{ all -> 0x00f8 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f8 }
        throw r9;
    L_0x00fb:
        r9 = move-exception;
        goto L_0x011e;
    L_0x00fd:
        r9 = move-exception;
        r9 = r9.getCause();	 Catch:{ all -> 0x00fb }
        r1 = r9 instanceof java.io.IOException;	 Catch:{ all -> 0x00fb }
        if (r1 == 0) goto L_0x0109;	 Catch:{ all -> 0x00fb }
    L_0x0106:
        r9 = (java.io.IOException) r9;	 Catch:{ all -> 0x00fb }
        throw r9;	 Catch:{ all -> 0x00fb }
    L_0x0109:
        r1 = new java.io.IOException;	 Catch:{ all -> 0x00fb }
        r1.<init>(r9);	 Catch:{ all -> 0x00fb }
        throw r1;	 Catch:{ all -> 0x00fb }
    L_0x010f:
        r9 = "FirebaseInstanceId";	 Catch:{ all -> 0x00fb }
        r1 = "No response";	 Catch:{ all -> 0x00fb }
        android.util.Log.w(r9, r1);	 Catch:{ all -> 0x00fb }
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00fb }
        r1 = "TIMEOUT";	 Catch:{ all -> 0x00fb }
        r9.<init>(r1);	 Catch:{ all -> 0x00fb }
        throw r9;	 Catch:{ all -> 0x00fb }
    L_0x011e:
        r1 = r8.f8677c;
        monitor-enter(r1);
        r2 = r8.f8677c;	 Catch:{ all -> 0x0128 }
        r2.remove(r0);	 Catch:{ all -> 0x0128 }
        monitor-exit(r1);	 Catch:{ all -> 0x0128 }
        throw r9;
    L_0x0128:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0128 }
        throw r9;
    L_0x012b:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x012b }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.c(android.os.Bundle):android.os.Bundle");
    }

    static /* synthetic */ void m7410a(zzv com_google_firebase_iid_zzv, Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            com_google_firebase_iid_zzv = "FirebaseInstanceId";
            message = "Dropping invalid message";
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    com_google_firebase_iid_zzv.f8682h = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    com_google_firebase_iid_zzv.f8681g = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                CharSequence stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                String str;
                if (stringExtra == null) {
                    action = intent2.getStringExtra("error");
                    if (action == null) {
                        com_google_firebase_iid_zzv = "FirebaseInstanceId";
                        message = String.valueOf(intent2.getExtras());
                        StringBuilder stringBuilder = new StringBuilder(49 + String.valueOf(message).length());
                        stringBuilder.append("Unexpected response, no error or registration id ");
                        stringBuilder.append(message);
                        message = stringBuilder.toString();
                    } else {
                        String str2;
                        String valueOf;
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            str2 = "FirebaseInstanceId";
                            String str3 = "Received InstanceID error ";
                            valueOf = String.valueOf(action);
                            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        }
                        str2 = null;
                        if (action.startsWith("|")) {
                            String[] split = action.split("\\|");
                            if (!"ID".equals(split[1])) {
                                valueOf = "FirebaseInstanceId";
                                String str4 = "Unexpected structured response ";
                                action = String.valueOf(action);
                                Log.w(valueOf, action.length() != 0 ? str4.concat(action) : new String(str4));
                            }
                            if (split.length > 2) {
                                action = split[2];
                                str = split[3];
                                if (str.startsWith(":")) {
                                    str = str.substring(1);
                                }
                                str2 = action;
                                action = str;
                            } else {
                                action = "UNKNOWN";
                            }
                            intent2.putExtra("error", action);
                        }
                        com_google_firebase_iid_zzv.m7411a(str2, action);
                        return;
                    }
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    action = matcher.group(1);
                    str = matcher.group(2);
                    Object extras = intent2.getExtras();
                    extras.putString("registration_id", str);
                    synchronized (com_google_firebase_iid_zzv.f8677c) {
                        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) com_google_firebase_iid_zzv.f8677c.remove(action);
                        if (taskCompletionSource == null) {
                            com_google_firebase_iid_zzv = "FirebaseInstanceId";
                            message = "Missing callback for ";
                            action = String.valueOf(action);
                            Log.w(com_google_firebase_iid_zzv, action.length() != 0 ? message.concat(action) : new String(message));
                            return;
                        }
                        taskCompletionSource.m6859a(extras);
                        return;
                    }
                }
                if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
                    com_google_firebase_iid_zzv = "FirebaseInstanceId";
                    message = "Unexpected response string: ";
                    action = String.valueOf(stringExtra);
                    Log.d(com_google_firebase_iid_zzv, action.length() != 0 ? message.concat(action) : new String(message));
                }
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
                com_google_firebase_iid_zzv = "FirebaseInstanceId";
                message = "Unexpected response action: ";
                action = String.valueOf(action);
                Log.d(com_google_firebase_iid_zzv, action.length() != 0 ? message.concat(action) : new String(message));
            }
            return;
        }
        Log.w(com_google_firebase_iid_zzv, message);
    }
}
