package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C0436R;
import com.google.android.gms.common.api.internal.zzbx;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzq;

public class GoogleApiAvailability extends zzf {
    public static final int f13808a = zzf.f5975b;
    private static final Object f13809c = new Object();
    private static final GoogleApiAvailability f13810d = new GoogleApiAvailability();
    private String f13811e;

    @SuppressLint({"HandlerLeak"})
    class zza extends Handler {
        private final Context f5733a;
        private /* synthetic */ GoogleApiAvailability f5734b;

        public zza(GoogleApiAvailability googleApiAvailability, Context context) {
            this.f5734b = googleApiAvailability;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f5733a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what != 1) {
                int i = message.what;
                StringBuilder stringBuilder = new StringBuilder(50);
                stringBuilder.append("Don't know how to handle this message: ");
                stringBuilder.append(i);
                Log.w("GoogleApiAvailability", stringBuilder.toString());
                return;
            }
            i = this.f5734b.mo1537a(this.f5733a);
            if (this.f5734b.mo1539a(i)) {
                this.f5734b.m12799a(this.f5733a, i);
            }
        }
    }

    GoogleApiAvailability() {
    }

    public static Dialog m12787a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m12789a((Context) activity, i, zzv.m4885a(activity, zzf.m4928a((Context) activity, i, "d"), i2), onCancelListener);
    }

    public static Dialog m12788a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zzu.m4882c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m12793a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog m12789a(Context context, int i, zzv com_google_android_gms_common_internal_zzv, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(zzu.m4882c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = zzu.m4884e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, com_google_android_gms_common_internal_zzv);
        }
        CharSequence a = zzu.m4877a(context, i);
        if (a != null) {
            builder.setTitle(a);
        }
        return builder.create();
    }

    public static GoogleApiAvailability m12790a() {
        return f13810d;
    }

    @TargetApi(26)
    private final String m12792a(Context context, NotificationManager notificationManager) {
        zzbq.m4813a(zzq.m4917i());
        String c = m12796c();
        if (c == null) {
            c = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(c);
            CharSequence a = zzu.m4876a(context);
            if (notificationChannel == null) {
                notificationChannel = new NotificationChannel(c, a, 4);
            } else if (!a.equals(notificationChannel.getName())) {
                notificationChannel.setName(a);
            }
            notificationManager.createNotificationChannel(notificationChannel);
            return c;
        }
        return c;
    }

    static void m12793a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.m20193a(dialog, onCancelListener).mo3959a(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        ErrorDialogFragment.m4630a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public static boolean m12794a(Activity activity, zzcf com_google_android_gms_common_api_internal_zzcf, int i, OnCancelListener onCancelListener) {
        Dialog a = m12789a((Context) activity, i, zzv.m4887a(com_google_android_gms_common_api_internal_zzcf, zzf.m4928a((Context) activity, i, "d")), onCancelListener);
        if (a == null) {
            return false;
        }
        m12793a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public static boolean m12795b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m12787a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m12793a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    private final String m12796c() {
        String str;
        synchronized (f13809c) {
            str = this.f13811e;
        }
        return str;
    }

    public final int mo1537a(Context context) {
        return super.mo1537a(context);
    }

    public final PendingIntent mo1538a(Context context, int i, int i2) {
        return super.mo1538a(context, i, i2);
    }

    public final void m12799a(Context context, int i) {
        m12800a(context, i, zzf.m4927a(context, i, 0, "n"));
    }

    public final boolean mo1539a(int i) {
        return super.mo1539a(i);
    }

    public final String mo1540b(int i) {
        return super.mo1540b(i);
    }

    final void m12803b(Context context) {
        new zza(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public static zzbx m12791a(Context context, zzby com_google_android_gms_common_api_internal_zzby) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver com_google_android_gms_common_api_internal_zzbx = new zzbx(com_google_android_gms_common_api_internal_zzby);
        context.registerReceiver(com_google_android_gms_common_api_internal_zzbx, intentFilter);
        com_google_android_gms_common_api_internal_zzbx.f5798a = context;
        if (zzp.zzv(context, "com.google.android.gms") != null) {
            return com_google_android_gms_common_api_internal_zzbx;
        }
        com_google_android_gms_common_api_internal_zzby.mo1603a();
        com_google_android_gms_common_api_internal_zzbx.m4732a();
        return null;
    }

    @TargetApi(20)
    public final void m12800a(Context context, int i, PendingIntent pendingIntent) {
        if (i == 18) {
            m12803b(context);
        } else if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            CharSequence b = zzu.m4881b(context, i);
            CharSequence d = zzu.m4883d(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (zzi.m4902a(context)) {
                zzbq.m4813a(zzq.m4914f());
                pendingIntent = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d)).addAction(C0436R.drawable.common_full_open_on_phone, resources.getString(C0436R.string.common_open_on_phone), pendingIntent);
                if (zzq.m4917i() && zzq.m4917i()) {
                    pendingIntent.setChannelId(m12792a(context, notificationManager));
                }
                context = pendingIntent.build();
            } else {
                NotificationCompat.Builder c = new NotificationCompat.Builder(context).m674a(17301642).m683c(resources.getString(C0436R.string.common_google_play_services_notification_ticker));
                c.f1117M.when = System.currentTimeMillis();
                c = c.m680a(true);
                c.f1123e = pendingIntent;
                pendingIntent = c.m679a(b).m682b(d);
                pendingIntent.f1141w = true;
                pendingIntent = pendingIntent.m678a(new NotificationCompat.BigTextStyle().m9997b(d));
                if (zzq.m4917i() && zzq.m4917i()) {
                    pendingIntent.f1112H = m12792a(context, notificationManager);
                }
                context = pendingIntent.m673a();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i = 10436;
                    zzp.zzfln.set(false);
                    break;
                default:
                    i = 39789;
                    break;
            }
            notificationManager.notify(i, context);
        }
    }
}
