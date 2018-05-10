package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.zzb;
import com.google.firebase.iid.zzi;
import com.google.firebase.iid.zzq;
import com.google.firebase.iid.zzx;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class FirebaseMessagingService extends zzb {
    private static final Queue<String> f14975b = new ArrayDeque(10);

    static void m14894a(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean m14895b(Bundle bundle) {
        return bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"));
    }

    public void m14897a(RemoteMessage remoteMessage) {
    }

    public final boolean mo2455c(android.content.Intent r3) {
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
        r2 = this;
        r0 = "com.google.firebase.messaging.NOTIFICATION_OPEN";
        r1 = r3.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0030;
    L_0x000c:
        r0 = "pending_intent";
        r0 = r3.getParcelableExtra(r0);
        r0 = (android.app.PendingIntent) r0;
        if (r0 == 0) goto L_0x0021;
    L_0x0016:
        r0.send();	 Catch:{ CanceledException -> 0x001a }
        goto L_0x0021;
    L_0x001a:
        r0 = "FirebaseMessaging";
        r1 = "Notification pending intent canceled";
        android.util.Log.e(r0, r1);
    L_0x0021:
        r0 = r3.getExtras();
        r0 = m14895b(r0);
        if (r0 == 0) goto L_0x002e;
    L_0x002b:
        com.google.firebase.messaging.zzd.m7466b(r2, r3);
    L_0x002e:
        r3 = 1;
        return r3;
    L_0x0030:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.c(android.content.Intent):boolean");
    }

    protected final Intent mo2451a(Intent intent) {
        return (Intent) zzx.m7416a().f8686b.poll();
    }

    public final void mo2452b(Intent intent) {
        Object obj;
        String str;
        String str2;
        String valueOf;
        Object obj2;
        int hashCode;
        Bundle extras;
        SendException sendException;
        String str3;
        zzi a;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        int hashCode2 = action.hashCode();
        int i = -1;
        if (hashCode2 != 75300319) {
            if (hashCode2 == 366519424) {
                if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            obj = intent.getStringExtra("google.message_id");
                            if (!TextUtils.isEmpty(obj)) {
                                if (f14975b.contains(obj)) {
                                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                                        str = "FirebaseMessaging";
                                        str2 = "Received duplicate message: ";
                                        valueOf = String.valueOf(obj);
                                        Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        str = intent.getStringExtra("message_type");
                                        if (str == null) {
                                            str = "gcm";
                                        }
                                        hashCode = str.hashCode();
                                        if (hashCode == -2062414158) {
                                            if (hashCode == 102161) {
                                                if (hashCode == 814694033) {
                                                    if (hashCode != 814800675) {
                                                        if (str.equals("send_event")) {
                                                            i = 2;
                                                        }
                                                    }
                                                } else if (str.equals("send_error")) {
                                                    i = 3;
                                                }
                                            } else if (str.equals("gcm")) {
                                                i = 0;
                                            }
                                        } else if (str.equals("deleted_messages")) {
                                            i = 1;
                                        }
                                        switch (i) {
                                            case 0:
                                                if (m14895b(intent.getExtras())) {
                                                    zzd.m7464a(this, intent);
                                                }
                                                extras = intent.getExtras();
                                                if (extras == null) {
                                                    extras = new Bundle();
                                                }
                                                extras.remove("android.support.content.wakelockid");
                                                if (zza.m7443a(extras)) {
                                                    if (!zza.m7438a((Context) this).m7449b(extras)) {
                                                        if (m14895b(extras)) {
                                                            zzd.m7468d(this, intent);
                                                        }
                                                    }
                                                }
                                                m14897a(new RemoteMessage(extras));
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                intent.getStringExtra("google.message_id");
                                                break;
                                            case 3:
                                                if (intent.getStringExtra("google.message_id") == null) {
                                                    intent.getStringExtra("message_id");
                                                }
                                                sendException = new SendException(intent.getStringExtra("error"));
                                                break;
                                            default:
                                                intent = "FirebaseMessaging";
                                                str3 = "Received message with unknown type: ";
                                                str = String.valueOf(str);
                                                Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                                                break;
                                        }
                                    }
                                    if (TextUtils.isEmpty(obj) == null) {
                                        intent = new Bundle();
                                        intent.putString("google.message_id", obj);
                                        a = zzi.m7384a((Context) this);
                                        a.m7387a(new zzq(a.m7386a(), intent));
                                    }
                                    return;
                                }
                                if (f14975b.size() >= 10) {
                                    f14975b.remove();
                                }
                                f14975b.add(obj);
                            }
                            obj2 = null;
                            if (obj2 == null) {
                                str = intent.getStringExtra("message_type");
                                if (str == null) {
                                    str = "gcm";
                                }
                                hashCode = str.hashCode();
                                if (hashCode == -2062414158) {
                                    if (str.equals("deleted_messages")) {
                                        i = 1;
                                    }
                                } else if (hashCode == 102161) {
                                    if (str.equals("gcm")) {
                                        i = 0;
                                    }
                                } else if (hashCode == 814694033) {
                                    if (str.equals("send_error")) {
                                        i = 3;
                                    }
                                } else if (hashCode != 814800675) {
                                    if (str.equals("send_event")) {
                                        i = 2;
                                    }
                                }
                                switch (i) {
                                    case 0:
                                        if (m14895b(intent.getExtras())) {
                                            zzd.m7464a(this, intent);
                                        }
                                        extras = intent.getExtras();
                                        if (extras == null) {
                                            extras = new Bundle();
                                        }
                                        extras.remove("android.support.content.wakelockid");
                                        if (zza.m7443a(extras)) {
                                            if (zza.m7438a((Context) this).m7449b(extras)) {
                                                if (m14895b(extras)) {
                                                    zzd.m7468d(this, intent);
                                                }
                                            }
                                        }
                                        m14897a(new RemoteMessage(extras));
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        intent.getStringExtra("google.message_id");
                                        break;
                                    case 3:
                                        if (intent.getStringExtra("google.message_id") == null) {
                                            intent.getStringExtra("message_id");
                                        }
                                        sendException = new SendException(intent.getStringExtra("error"));
                                        break;
                                    default:
                                        intent = "FirebaseMessaging";
                                        str3 = "Received message with unknown type: ";
                                        str = String.valueOf(str);
                                        if (str.length() == 0) {
                                        }
                                        Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                                        break;
                                }
                            }
                            if (TextUtils.isEmpty(obj) == null) {
                                intent = new Bundle();
                                intent.putString("google.message_id", obj);
                                a = zzi.m7384a((Context) this);
                                a.m7387a(new zzq(a.m7386a(), intent));
                            }
                            return;
                        case 1:
                            if (m14895b(intent.getExtras())) {
                                zzd.m7467c(this, intent);
                                return;
                            }
                            break;
                        default:
                            action = "FirebaseMessaging";
                            str = "Unknown intent action: ";
                            intent = String.valueOf(intent.getAction());
                            Log.d(action, intent.length() != 0 ? str.concat(intent) : new String(str));
                            break;
                    }
                }
            }
        } else if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            obj = 1;
            switch (obj) {
                case null:
                    obj = intent.getStringExtra("google.message_id");
                    if (TextUtils.isEmpty(obj)) {
                        if (f14975b.contains(obj)) {
                            if (f14975b.size() >= 10) {
                                f14975b.remove();
                            }
                            f14975b.add(obj);
                        } else {
                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                str = "FirebaseMessaging";
                                str2 = "Received duplicate message: ";
                                valueOf = String.valueOf(obj);
                                if (valueOf.length() != 0) {
                                }
                                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                str = intent.getStringExtra("message_type");
                                if (str == null) {
                                    str = "gcm";
                                }
                                hashCode = str.hashCode();
                                if (hashCode == -2062414158) {
                                    if (hashCode == 102161) {
                                        if (hashCode == 814694033) {
                                            if (hashCode != 814800675) {
                                                if (str.equals("send_event")) {
                                                    i = 2;
                                                }
                                            }
                                        } else if (str.equals("send_error")) {
                                            i = 3;
                                        }
                                    } else if (str.equals("gcm")) {
                                        i = 0;
                                    }
                                } else if (str.equals("deleted_messages")) {
                                    i = 1;
                                }
                                switch (i) {
                                    case 0:
                                        if (m14895b(intent.getExtras())) {
                                            zzd.m7464a(this, intent);
                                        }
                                        extras = intent.getExtras();
                                        if (extras == null) {
                                            extras = new Bundle();
                                        }
                                        extras.remove("android.support.content.wakelockid");
                                        if (zza.m7443a(extras)) {
                                            if (zza.m7438a((Context) this).m7449b(extras)) {
                                                if (m14895b(extras)) {
                                                    zzd.m7468d(this, intent);
                                                }
                                            }
                                        }
                                        m14897a(new RemoteMessage(extras));
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        intent.getStringExtra("google.message_id");
                                        break;
                                    case 3:
                                        if (intent.getStringExtra("google.message_id") == null) {
                                            intent.getStringExtra("message_id");
                                        }
                                        sendException = new SendException(intent.getStringExtra("error"));
                                        break;
                                    default:
                                        intent = "FirebaseMessaging";
                                        str3 = "Received message with unknown type: ";
                                        str = String.valueOf(str);
                                        if (str.length() == 0) {
                                        }
                                        Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                                        break;
                                }
                            }
                            if (TextUtils.isEmpty(obj) == null) {
                                intent = new Bundle();
                                intent.putString("google.message_id", obj);
                                a = zzi.m7384a((Context) this);
                                a.m7387a(new zzq(a.m7386a(), intent));
                            }
                            return;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        str = intent.getStringExtra("message_type");
                        if (str == null) {
                            str = "gcm";
                        }
                        hashCode = str.hashCode();
                        if (hashCode == -2062414158) {
                            if (str.equals("deleted_messages")) {
                                i = 1;
                            }
                        } else if (hashCode == 102161) {
                            if (str.equals("gcm")) {
                                i = 0;
                            }
                        } else if (hashCode == 814694033) {
                            if (str.equals("send_error")) {
                                i = 3;
                            }
                        } else if (hashCode != 814800675) {
                            if (str.equals("send_event")) {
                                i = 2;
                            }
                        }
                        switch (i) {
                            case 0:
                                if (m14895b(intent.getExtras())) {
                                    zzd.m7464a(this, intent);
                                }
                                extras = intent.getExtras();
                                if (extras == null) {
                                    extras = new Bundle();
                                }
                                extras.remove("android.support.content.wakelockid");
                                if (zza.m7443a(extras)) {
                                    if (zza.m7438a((Context) this).m7449b(extras)) {
                                        if (m14895b(extras)) {
                                            zzd.m7468d(this, intent);
                                        }
                                    }
                                }
                                m14897a(new RemoteMessage(extras));
                                break;
                            case 1:
                                break;
                            case 2:
                                intent.getStringExtra("google.message_id");
                                break;
                            case 3:
                                if (intent.getStringExtra("google.message_id") == null) {
                                    intent.getStringExtra("message_id");
                                }
                                sendException = new SendException(intent.getStringExtra("error"));
                                break;
                            default:
                                intent = "FirebaseMessaging";
                                str3 = "Received message with unknown type: ";
                                str = String.valueOf(str);
                                if (str.length() == 0) {
                                }
                                Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                                break;
                        }
                    }
                    if (TextUtils.isEmpty(obj) == null) {
                        intent = new Bundle();
                        intent.putString("google.message_id", obj);
                        a = zzi.m7384a((Context) this);
                        a.m7387a(new zzq(a.m7386a(), intent));
                    }
                    return;
                case 1:
                    if (m14895b(intent.getExtras())) {
                        zzd.m7467c(this, intent);
                        return;
                    }
                    break;
                default:
                    action = "FirebaseMessaging";
                    str = "Unknown intent action: ";
                    intent = String.valueOf(intent.getAction());
                    if (intent.length() != 0) {
                    }
                    Log.d(action, intent.length() != 0 ? str.concat(intent) : new String(str));
                    break;
            }
        }
        obj = -1;
        switch (obj) {
            case null:
                obj = intent.getStringExtra("google.message_id");
                if (TextUtils.isEmpty(obj)) {
                    if (f14975b.contains(obj)) {
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            str = "FirebaseMessaging";
                            str2 = "Received duplicate message: ";
                            valueOf = String.valueOf(obj);
                            if (valueOf.length() != 0) {
                            }
                            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            str = intent.getStringExtra("message_type");
                            if (str == null) {
                                str = "gcm";
                            }
                            hashCode = str.hashCode();
                            if (hashCode == -2062414158) {
                                if (hashCode == 102161) {
                                    if (hashCode == 814694033) {
                                        if (hashCode != 814800675) {
                                            if (str.equals("send_event")) {
                                                i = 2;
                                            }
                                        }
                                    } else if (str.equals("send_error")) {
                                        i = 3;
                                    }
                                } else if (str.equals("gcm")) {
                                    i = 0;
                                }
                            } else if (str.equals("deleted_messages")) {
                                i = 1;
                            }
                            switch (i) {
                                case 0:
                                    if (m14895b(intent.getExtras())) {
                                        zzd.m7464a(this, intent);
                                    }
                                    extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("android.support.content.wakelockid");
                                    if (zza.m7443a(extras)) {
                                        if (zza.m7438a((Context) this).m7449b(extras)) {
                                            if (m14895b(extras)) {
                                                zzd.m7468d(this, intent);
                                            }
                                        }
                                    }
                                    m14897a(new RemoteMessage(extras));
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    intent.getStringExtra("google.message_id");
                                    break;
                                case 3:
                                    if (intent.getStringExtra("google.message_id") == null) {
                                        intent.getStringExtra("message_id");
                                    }
                                    sendException = new SendException(intent.getStringExtra("error"));
                                    break;
                                default:
                                    intent = "FirebaseMessaging";
                                    str3 = "Received message with unknown type: ";
                                    str = String.valueOf(str);
                                    if (str.length() == 0) {
                                    }
                                    Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                                    break;
                            }
                        }
                        if (TextUtils.isEmpty(obj) == null) {
                            intent = new Bundle();
                            intent.putString("google.message_id", obj);
                            a = zzi.m7384a((Context) this);
                            a.m7387a(new zzq(a.m7386a(), intent));
                        }
                        return;
                    }
                    if (f14975b.size() >= 10) {
                        f14975b.remove();
                    }
                    f14975b.add(obj);
                }
                obj2 = null;
                if (obj2 == null) {
                    str = intent.getStringExtra("message_type");
                    if (str == null) {
                        str = "gcm";
                    }
                    hashCode = str.hashCode();
                    if (hashCode == -2062414158) {
                        if (str.equals("deleted_messages")) {
                            i = 1;
                        }
                    } else if (hashCode == 102161) {
                        if (str.equals("gcm")) {
                            i = 0;
                        }
                    } else if (hashCode == 814694033) {
                        if (str.equals("send_error")) {
                            i = 3;
                        }
                    } else if (hashCode != 814800675) {
                        if (str.equals("send_event")) {
                            i = 2;
                        }
                    }
                    switch (i) {
                        case 0:
                            if (m14895b(intent.getExtras())) {
                                zzd.m7464a(this, intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (zza.m7443a(extras)) {
                                if (zza.m7438a((Context) this).m7449b(extras)) {
                                    if (m14895b(extras)) {
                                        zzd.m7468d(this, intent);
                                    }
                                }
                            }
                            m14897a(new RemoteMessage(extras));
                            break;
                        case 1:
                            break;
                        case 2:
                            intent.getStringExtra("google.message_id");
                            break;
                        case 3:
                            if (intent.getStringExtra("google.message_id") == null) {
                                intent.getStringExtra("message_id");
                            }
                            sendException = new SendException(intent.getStringExtra("error"));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str3 = "Received message with unknown type: ";
                            str = String.valueOf(str);
                            if (str.length() == 0) {
                            }
                            Log.w(intent, str.length() == 0 ? str3.concat(str) : new String(str3));
                            break;
                    }
                }
                if (TextUtils.isEmpty(obj) == null) {
                    intent = new Bundle();
                    intent.putString("google.message_id", obj);
                    a = zzi.m7384a((Context) this);
                    a.m7387a(new zzq(a.m7386a(), intent));
                }
                return;
            case 1:
                if (m14895b(intent.getExtras())) {
                    zzd.m7467c(this, intent);
                    return;
                }
                break;
            default:
                action = "FirebaseMessaging";
                str = "Unknown intent action: ";
                intent = String.valueOf(intent.getAction());
                if (intent.length() != 0) {
                }
                Log.d(action, intent.length() != 0 ? str.concat(intent) : new String(str));
                break;
        }
    }
}
