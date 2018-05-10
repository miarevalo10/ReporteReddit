package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import org.jcodec.codecs.mpeg12.MPEGConst;

@KeepName
public final class DataHolder extends zzbfm implements Closeable {
    public static final Creator<DataHolder> CREATOR = new zzf();
    private static final zza f17315k = new zze(new String[0]);
    final String[] f17316a;
    Bundle f17317b;
    final CursorWindow[] f17318c;
    int[] f17319d;
    int f17320e;
    private int f17321f;
    private final int f17322g;
    private final Bundle f17323h;
    private boolean f17324i = false;
    private boolean f17325j = true;

    public static class zza {
        private final String[] f5862a;
        private final ArrayList<HashMap<String, Object>> f5863b;
        private final String f5864c;
        private final HashMap<Object, Integer> f5865d;
        private boolean f5866e;
        private String f5867f;

        private zza(String[] strArr) {
            this.f5862a = (String[]) zzbq.m4808a((Object) strArr);
            this.f5863b = new ArrayList();
            this.f5864c = null;
            this.f5865d = new HashMap();
            this.f5866e = false;
            this.f5867f = null;
        }
    }

    public static class zzb extends RuntimeException {
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f17321f = i;
        this.f17316a = strArr;
        this.f17318c = cursorWindowArr;
        this.f17322g = i2;
        this.f17323h = bundle;
    }

    private boolean m17675a() {
        boolean z;
        synchronized (this) {
            z = this.f17324i;
        }
        return z;
    }

    public final void close() {
        synchronized (this) {
            if (!this.f17324i) {
                this.f17324i = true;
                for (CursorWindow close : this.f17318c) {
                    close.close();
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f17325j && this.f17318c.length > 0 && !m17675a()) {
                close();
                String obj = toString();
                StringBuilder stringBuilder = new StringBuilder(MPEGConst.USER_DATA_START_CODE + String.valueOf(obj).length());
                stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                stringBuilder.append(obj);
                stringBuilder.append(")");
                Log.e("DataBuffer", stringBuilder.toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5550a(parcel, 1, this.f17316a);
        zzbfp.m5549a(parcel, 2, this.f17318c, i);
        zzbfp.m5540a(parcel, 3, this.f17322g);
        zzbfp.m5542a(parcel, 4, this.f17323h);
        zzbfp.m5540a(parcel, 1000, this.f17321f);
        zzbfp.m5537a(parcel, a);
        if ((i & 1) != 0) {
            close();
        }
    }
}
