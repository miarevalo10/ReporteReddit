package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    private static String[] f5908A = new String[]{"service_esmobile", "service_googleme"};
    private long f5909a;
    private int f5910b;
    int f5911c;
    long f5912d;
    public final Context f5913e;
    final Handler f5914f;
    protected zzj f5915g;
    protected AtomicInteger f5916h;
    private long f5917i;
    private zzam f5918j;
    private final Looper f5919k;
    private final zzag f5920l;
    private final zzf f5921m;
    private final Object f5922n;
    private final Object f5923o;
    private zzay f5924p;
    private T f5925q;
    private final ArrayList<zzi<?>> f5926r;
    private zzl f5927s;
    private int f5928t;
    private final zzf f5929u;
    private final zzg f5930v;
    private final int f5931w;
    private final String f5932x;
    private ConnectionResult f5933y;
    private boolean f5934z;

    protected zzd(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg) {
        this(context, looper, zzag.m4782a(context), zzf.m4930b(), i, (zzf) zzbq.m4808a((Object) com_google_android_gms_common_internal_zzf), (zzg) zzbq.m4808a((Object) com_google_android_gms_common_internal_zzg), null);
    }

    protected zzd(Context context, Looper looper, zzag com_google_android_gms_common_internal_zzag, zzf com_google_android_gms_common_zzf, int i, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg, String str) {
        this.f5922n = new Object();
        this.f5923o = new Object();
        this.f5926r = new ArrayList();
        this.f5928t = 1;
        this.f5933y = null;
        this.f5934z = false;
        this.f5916h = new AtomicInteger(0);
        this.f5913e = (Context) zzbq.m4809a((Object) context, (Object) "Context must not be null");
        this.f5919k = (Looper) zzbq.m4809a((Object) looper, (Object) "Looper must not be null");
        this.f5920l = (zzag) zzbq.m4809a((Object) com_google_android_gms_common_internal_zzag, (Object) "Supervisor must not be null");
        this.f5921m = (zzf) zzbq.m4809a((Object) com_google_android_gms_common_zzf, (Object) "API availability must not be null");
        this.f5914f = new zzh(this, looper);
        this.f5931w = i;
        this.f5929u = com_google_android_gms_common_internal_zzf;
        this.f5930v = com_google_android_gms_common_internal_zzg;
        this.f5932x = str;
    }

    private final boolean m4828a(int i, int i2, T t) {
        synchronized (this.f5922n) {
            if (this.f5928t != i) {
                return false;
            }
            m4825a(i2, (IInterface) t);
            return true;
        }
    }

    private final String mo1649n() {
        return this.f5932x == null ? this.f5913e.getClass().getName() : this.f5932x;
    }

    private final boolean m4838s() {
        boolean z;
        synchronized (this.f5922n) {
            z = this.f5928t == 3;
        }
        return z;
    }

    private final boolean m4839t() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.f5934z;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.mo1648b();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = 0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r2.mo1648b();	 Catch:{ ClassNotFoundException -> 0x0022 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0022 }
        r0 = 1;
        return r0;
    L_0x0022:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.t():boolean");
    }

    public abstract T mo1646a(IBinder iBinder);

    public abstract String mo1647a();

    protected final void m4842a(int i, int i2) {
        this.f5914f.sendMessage(this.f5914f.obtainMessage(7, i2, -1, new zzo(this, i)));
    }

    protected final void m4843a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f5914f.sendMessage(this.f5914f.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    public final void m4846a(zzj com_google_android_gms_common_internal_zzj) {
        this.f5915g = (zzj) zzbq.m4809a((Object) com_google_android_gms_common_internal_zzj, (Object) "Connection progress callbacks cannot be null.");
        m4825a(2, null);
    }

    public final void m4847a(zzp com_google_android_gms_common_internal_zzp) {
        com_google_android_gms_common_internal_zzp.mo1605a();
    }

    public final void m4848a(String str, PrintWriter printWriter) {
        String str2;
        synchronized (this.f5922n) {
            int i = this.f5928t;
            IInterface iInterface = this.f5925q;
        }
        synchronized (this.f5923o) {
            zzay com_google_android_gms_common_internal_zzay = this.f5924p;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                str2 = "DISCONNECTED";
                break;
            case 2:
                str2 = "REMOTE_CONNECTING";
                break;
            case 3:
                str2 = "LOCAL_CONNECTING";
                break;
            case 4:
                str2 = "CONNECTED";
                break;
            case 5:
                str2 = "DISCONNECTING";
                break;
            default:
                str2 = "UNKNOWN";
                break;
        }
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(mo1648b()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (com_google_android_gms_common_internal_zzay == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(com_google_android_gms_common_internal_zzay.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f5909a > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f5909a;
            String format = simpleDateFormat.format(new Date(this.f5909a));
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.f5912d > 0) {
            CharSequence charSequence;
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f5911c) {
                case 1:
                    charSequence = "CAUSE_SERVICE_DISCONNECTED";
                    break;
                case 2:
                    charSequence = "CAUSE_NETWORK_LOST";
                    break;
                default:
                    charSequence = String.valueOf(this.f5911c);
                    break;
            }
            printWriter.append(charSequence);
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f5912d;
            format = simpleDateFormat.format(new Date(this.f5912d));
            stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.f5917i > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.m4633a(this.f5910b));
            PrintWriter append2 = printWriter.append(" lastFailedTime=");
            long j2 = this.f5917i;
            String format2 = simpleDateFormat.format(new Date(this.f5917i));
            StringBuilder stringBuilder2 = new StringBuilder(21 + String.valueOf(format2).length());
            stringBuilder2.append(j2);
            stringBuilder2.append(" ");
            stringBuilder2.append(format2);
            append2.println(stringBuilder2.toString());
        }
    }

    public abstract String mo1648b();

    public boolean mo3957c() {
        return false;
    }

    public Intent mo3958d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public void mo4292e() {
        this.f5916h.incrementAndGet();
        synchronized (this.f5926r) {
            int size = this.f5926r.size();
            for (int i = 0; i < size; i++) {
                ((zzi) this.f5926r.get(i)).m4872d();
            }
            this.f5926r.clear();
        }
        synchronized (this.f5923o) {
            this.f5924p = null;
        }
        m4825a(1, null);
    }

    public final boolean m4853f() {
        boolean z;
        synchronized (this.f5922n) {
            z = this.f5928t == 4;
        }
        return z;
    }

    public final boolean m4854g() {
        boolean z;
        synchronized (this.f5922n) {
            if (this.f5928t != 2) {
                if (this.f5928t != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean mo4023h() {
        return false;
    }

    public final IBinder m4856i() {
        synchronized (this.f5923o) {
            if (this.f5924p == null) {
                return null;
            }
            IBinder asBinder = this.f5924p.asBinder();
            return asBinder;
        }
    }

    public Account mo3422k() {
        return null;
    }

    public zzc[] mo3423m() {
        return new zzc[0];
    }

    protected Set<Scope> n_() {
        return Collections.EMPTY_SET;
    }

    public Bundle mo4022p() {
        return new Bundle();
    }

    protected final void m4862q() {
        if (!m4853f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T m4863r() throws DeadObjectException {
        T t;
        synchronized (this.f5922n) {
            if (this.f5928t == 5) {
                throw new DeadObjectException();
            }
            m4862q();
            zzbq.m4814a(this.f5925q != null, (Object) "Client is connected but service is null");
            t = this.f5925q;
        }
        return t;
    }

    protected final void m4844a(ConnectionResult connectionResult) {
        this.f5910b = connectionResult.f17257b;
        this.f5917i = System.currentTimeMillis();
    }

    private final void m4825a(int i, T t) {
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        zzbq.m4817b(z);
        synchronized (this.f5922n) {
            this.f5928t = i;
            this.f5925q = t;
            ServiceConnection serviceConnection;
            switch (i) {
                case 1:
                    if (this.f5927s != 0) {
                        serviceConnection = this.f5927s;
                        mo1649n();
                        this.f5920l.m4783a(mo1647a(), "com.google.android.gms", 129, serviceConnection);
                        this.f5927s = 0;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String str;
                    StringBuilder stringBuilder;
                    int i2;
                    if (!(this.f5927s == 0 || this.f5918j == 0)) {
                        t = this.f5918j.f5896a;
                        str = this.f5918j.f5897b;
                        stringBuilder = new StringBuilder((70 + String.valueOf(t).length()) + String.valueOf(str).length());
                        stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
                        stringBuilder.append(t);
                        stringBuilder.append(" on ");
                        stringBuilder.append(str);
                        Log.e("GmsClient", stringBuilder.toString());
                        i = this.f5920l;
                        t = this.f5918j.f5896a;
                        str = this.f5918j.f5897b;
                        i2 = this.f5918j.f5898c;
                        serviceConnection = this.f5927s;
                        mo1649n();
                        i.m4783a(t, str, i2, serviceConnection);
                        this.f5916h.incrementAndGet();
                    }
                    this.f5927s = new zzl(this, this.f5916h.get());
                    this.f5918j = new zzam("com.google.android.gms", mo1647a());
                    i = this.f5920l;
                    t = this.f5918j.f5896a;
                    str = this.f5918j.f5897b;
                    i2 = this.f5918j.f5898c;
                    serviceConnection = this.f5927s;
                    mo1649n();
                    if (i.mo1623a(new zzah(t, str, i2), serviceConnection) == 0) {
                        t = this.f5918j.f5896a;
                        str = this.f5918j.f5897b;
                        stringBuilder = new StringBuilder((34 + String.valueOf(t).length()) + String.valueOf(str).length());
                        stringBuilder.append("unable to connect to service: ");
                        stringBuilder.append(t);
                        stringBuilder.append(" on ");
                        stringBuilder.append(str);
                        Log.e("GmsClient", stringBuilder.toString());
                        m4842a(16, this.f5916h.get());
                        break;
                    }
                    break;
                case 4:
                    this.f5909a = System.currentTimeMillis();
                    break;
                default:
                    break;
            }
        }
    }

    public final void m4860o() {
        int a = this.f5921m.mo1537a(this.f5913e);
        if (a != 0) {
            m4825a(1, null);
            this.f5915g = (zzj) zzbq.m4809a(new zzm(this), (Object) "Connection progress callbacks cannot be null.");
            this.f5914f.sendMessage(this.f5914f.obtainMessage(3, this.f5916h.get(), a, null));
            return;
        }
        m4846a(new zzm(this));
    }

    public final void m4845a(zzan com_google_android_gms_common_internal_zzan, Set<Scope> set) {
        Bundle p = mo4022p();
        zzz com_google_android_gms_common_internal_zzz = new zzz(this.f5931w);
        com_google_android_gms_common_internal_zzz.f17343a = this.f5913e.getPackageName();
        com_google_android_gms_common_internal_zzz.f17346d = p;
        if (set != null) {
            com_google_android_gms_common_internal_zzz.f17345c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (mo4023h() != null) {
            com_google_android_gms_common_internal_zzz.f17347e = mo3422k() != null ? mo3422k() : new Account("<<default account>>", "com.google");
            if (com_google_android_gms_common_internal_zzan != null) {
                com_google_android_gms_common_internal_zzz.f17344b = com_google_android_gms_common_internal_zzan.asBinder();
            }
        }
        com_google_android_gms_common_internal_zzz.f17348f = mo3423m();
        try {
            synchronized (this.f5923o) {
                if (this.f5924p != null) {
                    this.f5924p.mo1628a(new zzk(this, this.f5916h.get()), com_google_android_gms_common_internal_zzz);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (zzan com_google_android_gms_common_internal_zzan2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", com_google_android_gms_common_internal_zzan2);
            this.f5914f.sendMessage(this.f5914f.obtainMessage(6, this.f5916h.get(), 1));
        } catch (zzan com_google_android_gms_common_internal_zzan22) {
            throw com_google_android_gms_common_internal_zzan22;
        } catch (zzan com_google_android_gms_common_internal_zzan222) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", com_google_android_gms_common_internal_zzan222);
            m4843a(8, null, null, this.f5916h.get());
        }
    }

    public final String m4857j() {
        if (m4853f() && this.f5918j != null) {
            return this.f5918j.f5897b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    static /* synthetic */ void m4826a(zzd com_google_android_gms_common_internal_zzd) {
        int i;
        if (com_google_android_gms_common_internal_zzd.m4838s()) {
            i = 5;
            com_google_android_gms_common_internal_zzd.f5934z = true;
        } else {
            i = 4;
        }
        com_google_android_gms_common_internal_zzd.f5914f.sendMessage(com_google_android_gms_common_internal_zzd.f5914f.obtainMessage(i, com_google_android_gms_common_internal_zzd.f5916h.get(), 16));
    }
}
