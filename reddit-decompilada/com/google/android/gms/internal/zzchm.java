package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class zzchm extends zzcjl {
    public final zzcho f17816a;
    final zzcho f17817b;
    public final zzcho f17818c;
    public final zzcho f17819d;
    final zzcho f17820e;
    final zzcho f17821f;
    public final zzcho f17822g;
    private final String f17823h = ((String) zzchc.f6869c.f6893a);
    private final char f17824i;
    private final long f17825j = 11910;
    private final zzcho f17826k;
    private final zzcho f17827l;

    protected static Object m18154a(String str) {
        return str == null ? null : new zzchp(str);
    }

    private static String m18155a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        String valueOf;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? Operation.MINUS : "";
            valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder((43 + String.valueOf(str).length()) + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(round);
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(round2);
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof zzchp ? ((zzchp) obj).f6903a : z ? Operation.MINUS : String.valueOf(obj);
            } else {
                Throwable th = (Throwable) obj;
                StringBuilder stringBuilder2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                valueOf = m18157b(AppMeasurement.class.getCanonicalName());
                String b = m18157b(zzcim.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m18157b(className);
                            if (className.equals(valueOf) || className.equals(b)) {
                                stringBuilder2.append(": ");
                                stringBuilder2.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                return stringBuilder2.toString();
            }
        }
    }

    private static String m18156a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        obj = m18155a(z, obj);
        obj2 = m18155a(z, obj2);
        Object a = m18155a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    private static String m18157b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    protected final void m18159a(int i, String str) {
        Log.println(i, this.f17823h, str);
    }

    protected final boolean m18161a(int i) {
        return Log.isLoggable(this.f17823h, i);
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return false;
    }

    zzchm(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
        if (mo1830v().m13515w() != null) {
            com_google_android_gms_internal_zzcim = 67;
        } else {
            int i = 99;
        }
        this.f17824i = com_google_android_gms_internal_zzcim;
        this.f17816a = new zzcho(this, 6, false, false);
        this.f17817b = new zzcho(this, 6, true, false);
        this.f17826k = new zzcho(this, 6, false, true);
        this.f17818c = new zzcho(this, 5, false, false);
        this.f17827l = new zzcho(this, 5, true, false);
        this.f17819d = new zzcho(this, 5, false, true);
        this.f17820e = new zzcho(this, 4, false, false);
        this.f17821f = new zzcho(this, 3, false, false);
        this.f17822g = new zzcho(this, 2, false, false);
    }

    protected final void m18160a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m18161a(i)) {
            m18159a(i, m18156a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= true) {
            String str2;
            zzbq.m4808a((Object) str);
            z = this.s.f6977d;
            if (!z) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (z.m13544K()) {
                if (i < 0) {
                    i = false;
                }
                if (i >= true) {
                    i = 8;
                }
                z2 = "2";
                i = "01VDIWEA?".charAt(i);
                char c = this.f17824i;
                long j = this.f17825j;
                obj = m18156a(true, str, obj, obj2, obj3);
                obj3 = new StringBuilder((23 + String.valueOf(z2).length()) + String.valueOf(obj).length());
                obj3.append(z2);
                obj3.append(i);
                obj3.append(c);
                obj3.append(j);
                obj3.append(":");
                obj3.append(obj);
                i = obj3.toString();
                if (i.length() > true) {
                    i = str.substring(0, 1024);
                }
                z.m18271a(new zzchn(this, i));
            } else {
                str2 = "Scheduler not initialized. Not logging error/warn";
            }
            m18159a((int) true, str2);
        }
    }

    public final String m18184y() {
        String string;
        Pair pair;
        String str;
        StringBuilder stringBuilder;
        zzcib com_google_android_gms_internal_zzcib = mo1829u().f17829b;
        com_google_android_gms_internal_zzcib.f6935d.mo1811c();
        com_google_android_gms_internal_zzcib.f6935d.mo1811c();
        long b = com_google_android_gms_internal_zzcib.m5705b();
        if (b == 0) {
            com_google_android_gms_internal_zzcib.m5704a();
            b = 0;
        } else {
            b = Math.abs(b - com_google_android_gms_internal_zzcib.f6935d.mo1819k().mo1632a());
        }
        if (b >= com_google_android_gms_internal_zzcib.f6934c) {
            if (b > (com_google_android_gms_internal_zzcib.f6934c << 1)) {
                com_google_android_gms_internal_zzcib.m5704a();
            } else {
                string = com_google_android_gms_internal_zzcib.f6935d.m18211D().getString(com_google_android_gms_internal_zzcib.f6933b, null);
                long j = com_google_android_gms_internal_zzcib.f6935d.m18211D().getLong(com_google_android_gms_internal_zzcib.f6932a, 0);
                com_google_android_gms_internal_zzcib.m5704a();
                if (string != null) {
                    if (j > 0) {
                        pair = new Pair(string, Long.valueOf(j));
                        if (pair != null) {
                            if (pair == zzchx.f17828a) {
                                string = String.valueOf(pair.second);
                                str = (String) pair.first;
                                stringBuilder = new StringBuilder((1 + String.valueOf(string).length()) + String.valueOf(str).length());
                                stringBuilder.append(string);
                                stringBuilder.append(":");
                                stringBuilder.append(str);
                                return stringBuilder.toString();
                            }
                        }
                        return null;
                    }
                }
                pair = zzchx.f17828a;
                if (pair != null) {
                    if (pair == zzchx.f17828a) {
                        string = String.valueOf(pair.second);
                        str = (String) pair.first;
                        stringBuilder = new StringBuilder((1 + String.valueOf(string).length()) + String.valueOf(str).length());
                        stringBuilder.append(string);
                        stringBuilder.append(":");
                        stringBuilder.append(str);
                        return stringBuilder.toString();
                    }
                }
                return null;
            }
        }
        pair = null;
        if (pair != null) {
            if (pair == zzchx.f17828a) {
                string = String.valueOf(pair.second);
                str = (String) pair.first;
                stringBuilder = new StringBuilder((1 + String.valueOf(string).length()) + String.valueOf(str).length());
                stringBuilder.append(string);
                stringBuilder.append(":");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
