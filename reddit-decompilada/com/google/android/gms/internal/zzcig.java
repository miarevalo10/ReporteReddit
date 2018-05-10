package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import java.io.IOException;
import java.util.Map;

public final class zzcig extends zzcjl {
    private static int f17850c = 65535;
    private static int f17851d = 2;
    final Map<String, zzcly> f17852a = new ArrayMap();
    final Map<String, String> f17853b = new ArrayMap();
    private final Map<String, Map<String, String>> f17854e = new ArrayMap();
    private final Map<String, Map<String, Boolean>> f17855f = new ArrayMap();
    private final Map<String, Map<String, Boolean>> f17856g = new ArrayMap();
    private final Map<String, Map<String, Integer>> f17857h = new ArrayMap();

    zzcig(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private static Map<String, String> m18226a(zzcly com_google_android_gms_internal_zzcly) {
        Map<String, String> arrayMap = new ArrayMap();
        if (!(com_google_android_gms_internal_zzcly == null || com_google_android_gms_internal_zzcly.f17947c == null)) {
            for (zzclz com_google_android_gms_internal_zzclz : com_google_android_gms_internal_zzcly.f17947c) {
                if (com_google_android_gms_internal_zzclz != null) {
                    arrayMap.put(com_google_android_gms_internal_zzclz.f17952a, com_google_android_gms_internal_zzclz.f17953b);
                }
            }
        }
        return arrayMap;
    }

    private final void m18228b(String str) {
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        if (this.f17852a.get(str) == null) {
            byte[] d = mo1822n().m18015d(str);
            if (d == null) {
                this.f17854e.put(str, null);
                this.f17855f.put(str, null);
                this.f17856g.put(str, null);
                this.f17852a.put(str, null);
                this.f17853b.put(str, null);
                this.f17857h.put(str, null);
                return;
            }
            zzcly a = m18225a(str, d);
            this.f17854e.put(str, m18226a(a));
            m18227a(str, a);
            this.f17852a.put(str, a);
            this.f17853b.put(str, null);
        }
    }

    protected final zzcly m18229a(String str) {
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        m18228b(str);
        return (zzcly) this.f17852a.get(str);
    }

    final String m18230a(String str, String str2) {
        mo1811c();
        m18228b(str);
        Map map = (Map) this.f17854e.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    final boolean m18234b(String str, String str2) {
        mo1811c();
        m18228b(str);
        if (mo1824p().m18569k(str) && zzclq.m18527h(str2)) {
            return true;
        }
        if (mo1824p().m18571l(str) && zzclq.m18513a(str2)) {
            return true;
        }
        Map map = (Map) this.f17855f.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    final boolean m18236c(String str, String str2) {
        mo1811c();
        m18228b(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f17856g.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    final int m18237d(String str, String str2) {
        mo1811c();
        m18228b(str);
        Map map = (Map) this.f17857h.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        return num == null ? 1 : num.intValue();
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

    private final void m18227a(String str, zzcly com_google_android_gms_internal_zzcly) {
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        Map arrayMap3 = new ArrayMap();
        if (!(com_google_android_gms_internal_zzcly == null || com_google_android_gms_internal_zzcly.f17948d == null)) {
            for (zzclx com_google_android_gms_internal_zzclx : com_google_android_gms_internal_zzcly.f17948d) {
                if (TextUtils.isEmpty(com_google_android_gms_internal_zzclx.f17941a)) {
                    mo1828t().f17818c.m5693a("EventConfig contained null event name");
                } else {
                    Object a = Event.m14497a(com_google_android_gms_internal_zzclx.f17941a);
                    if (!TextUtils.isEmpty(a)) {
                        com_google_android_gms_internal_zzclx.f17941a = a;
                    }
                    arrayMap.put(com_google_android_gms_internal_zzclx.f17941a, com_google_android_gms_internal_zzclx.f17942b);
                    arrayMap2.put(com_google_android_gms_internal_zzclx.f17941a, com_google_android_gms_internal_zzclx.f17943c);
                    if (com_google_android_gms_internal_zzclx.f17944d != null) {
                        if (com_google_android_gms_internal_zzclx.f17944d.intValue() >= f17851d) {
                            if (com_google_android_gms_internal_zzclx.f17944d.intValue() <= f17850c) {
                                arrayMap3.put(com_google_android_gms_internal_zzclx.f17941a, com_google_android_gms_internal_zzclx.f17944d);
                            }
                        }
                        mo1828t().f17818c.m5695a("Invalid sampling rate. Event name, sample rate", com_google_android_gms_internal_zzclx.f17941a, com_google_android_gms_internal_zzclx.f17944d);
                    }
                }
            }
        }
        this.f17855f.put(str, arrayMap);
        this.f17856g.put(str, arrayMap2);
        this.f17857h.put(str, arrayMap3);
    }

    protected final boolean m18232a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        String str3 = str;
        m13545L();
        mo1811c();
        zzbq.m4810a(str);
        zzcly a = m18225a(str, bArr);
        m18227a(str3, a);
        this.f17852a.put(str3, a);
        this.f17853b.put(str3, str2);
        this.f17854e.put(str3, m18226a(a));
        zzcjk e = mo1813e();
        zzclr[] com_google_android_gms_internal_zzclrArr = a.f17949e;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzclrArr);
        int length = com_google_android_gms_internal_zzclrArr.length;
        int i = 0;
        while (i < length) {
            int i2;
            zzclr com_google_android_gms_internal_zzclr = com_google_android_gms_internal_zzclrArr[i];
            for (zzcls com_google_android_gms_internal_zzcls : com_google_android_gms_internal_zzclr.f17915c) {
                String a2 = Event.m14497a(com_google_android_gms_internal_zzcls.f17918b);
                if (a2 != null) {
                    com_google_android_gms_internal_zzcls.f17918b = a2;
                }
                zzclt[] com_google_android_gms_internal_zzcltArr = com_google_android_gms_internal_zzcls.f17919c;
                int length2 = com_google_android_gms_internal_zzcltArr.length;
                int i3 = 0;
                while (i3 < length2) {
                    zzclt com_google_android_gms_internal_zzclt = com_google_android_gms_internal_zzcltArr[i3];
                    i2 = length;
                    String a3 = Param.m14498a(com_google_android_gms_internal_zzclt.f17926d);
                    if (a3 != null) {
                        com_google_android_gms_internal_zzclt.f17926d = a3;
                    }
                    i3++;
                    length = i2;
                }
                i2 = length;
            }
            i2 = length;
            for (zzclv com_google_android_gms_internal_zzclv : com_google_android_gms_internal_zzclr.f17914b) {
                String a4 = UserProperty.m14499a(com_google_android_gms_internal_zzclv.f17934b);
                if (a4 != null) {
                    com_google_android_gms_internal_zzclv.f17934b = a4;
                }
            }
            i++;
            length = i2;
        }
        e.mo1822n().m18002a(str3, com_google_android_gms_internal_zzclrArr);
        try {
            a.f17949e = null;
            bArr2 = new byte[a.m6211e()];
            a.mo1928a(zzfjk.m6158a(bArr2, bArr2.length));
        } catch (IOException e2) {
            mo1828t().f17818c.m5695a("Unable to serialize reduced-size config. Storing full config instead. appId", zzchm.m18154a(str), e2);
            bArr2 = bArr;
        }
        zzcjk n = mo1822n();
        zzbq.m4810a(str);
        n.mo1811c();
        n.m13545L();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) n.m17987A().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                n.mo1828t().f17816a.m5694a("Failed to update remote config (got 0). appId", zzchm.m18154a(str));
            }
        } catch (SQLiteException e3) {
            n.mo1828t().f17816a.m5695a("Error storing remote config. appId", zzchm.m18154a(str), e3);
        }
        return true;
    }

    private final zzcly m18225a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzcly();
        }
        zzfjj a = zzfjj.m6130a(bArr, bArr.length);
        zzfjs com_google_android_gms_internal_zzcly = new zzcly();
        try {
            com_google_android_gms_internal_zzcly.mo3478a(a);
            mo1828t().f17822g.m5695a("Parsed config. version, gmp_app_id", com_google_android_gms_internal_zzcly.f17945a, com_google_android_gms_internal_zzcly.f17946b);
            return com_google_android_gms_internal_zzcly;
        } catch (byte[] bArr2) {
            mo1828t().f17818c.m5695a("Unable to merge remote config. appId", zzchm.m18154a(str), bArr2);
            return new zzcly();
        }
    }
}
