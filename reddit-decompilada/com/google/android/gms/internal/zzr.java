package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public abstract class zzr<T> implements Comparable<zzr<T>> {
    final int f7966a;
    final String f7967b;
    final int f7968c;
    final zzx f7969d;
    Integer f7970e;
    zzv f7971f;
    boolean f7972g;
    boolean f7973h;
    zzaa f7974i;
    zzc f7975j;
    zzt f7976k;
    final Object f7977l;
    private final zza f7978m;
    private boolean f7979n;
    private boolean f7980o;

    public zzr(int i, String str, zzx com_google_android_gms_internal_zzx) {
        this.f7978m = zza.f6232a ? new zza() : null;
        this.f7972g = true;
        int i2 = 0;
        this.f7979n = false;
        this.f7973h = false;
        this.f7980o = false;
        this.f7975j = null;
        this.f7977l = new Object();
        this.f7966a = i;
        this.f7967b = str;
        this.f7969d = com_google_android_gms_internal_zzx;
        this.f7974i = new zzh();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.f7968c = i2;
    }

    protected abstract zzw<T> mo1727a(zzp com_google_android_gms_internal_zzp);

    final void m6624a(zzt com_google_android_gms_internal_zzt) {
        synchronized (this.f7977l) {
            this.f7976k = com_google_android_gms_internal_zzt;
        }
    }

    protected abstract void mo1728a(T t);

    public byte[] mo3444a() throws zza {
        return null;
    }

    public Map<String, String> mo3445b() throws zza {
        return Collections.emptyMap();
    }

    public final void m6628b(String str) {
        if (zza.f6232a) {
            this.f7978m.m5040a(str, Thread.currentThread().getId());
        }
    }

    public final int m6629c() {
        return this.f7974i.mo1950a();
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzr com_google_android_gms_internal_zzr = (zzr) obj;
        zzu com_google_android_gms_internal_zzu = zzu.NORMAL;
        zzu com_google_android_gms_internal_zzu2 = zzu.NORMAL;
        return com_google_android_gms_internal_zzu == com_google_android_gms_internal_zzu2 ? this.f7970e.intValue() - com_google_android_gms_internal_zzr.f7970e.intValue() : com_google_android_gms_internal_zzu2.ordinal() - com_google_android_gms_internal_zzu.ordinal();
    }

    final void m6631d() {
        synchronized (this.f7977l) {
            if (this.f7976k != null) {
                this.f7976k.mo1873a(this);
            }
        }
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(this.f7968c));
        str = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        valueOf = "[ ] ";
        String str2 = this.f7967b;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.f7970e);
        StringBuilder stringBuilder = new StringBuilder(((((3 + String.valueOf(valueOf).length()) + String.valueOf(str2).length()) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
        stringBuilder.append(valueOf);
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf2);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf3);
        return stringBuilder.toString();
    }

    final void m6630c(String str) {
        if (this.f7971f != null) {
            zzv com_google_android_gms_internal_zzv = this.f7971f;
            synchronized (com_google_android_gms_internal_zzv.f8098a) {
                com_google_android_gms_internal_zzv.f8098a.remove(this);
            }
            synchronized (com_google_android_gms_internal_zzv.f8099b) {
                Iterator it = com_google_android_gms_internal_zzv.f8099b.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        if (zza.f6232a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzs(this, str, id));
            } else {
                this.f7978m.m5040a(str, id);
                this.f7978m.m5039a(toString());
            }
        }
    }
}
