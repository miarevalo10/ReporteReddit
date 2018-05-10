package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class zzchk extends zzcjl {
    private static String[] f17813a = new String[Event.f14802a.length];
    private static String[] f17814b = new String[Param.f14804a.length];
    private static String[] f17815c = new String[UserProperty.f14806a.length];

    zzchk(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final String m18111a(zzcgx com_google_android_gms_internal_zzcgx) {
        return com_google_android_gms_internal_zzcgx == null ? null : !m18121y() ? com_google_android_gms_internal_zzcgx.toString() : m18122a(com_google_android_gms_internal_zzcgx.m18052a());
    }

    private static String m18112a(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        zzbq.m4808a((Object) strArr);
        zzbq.m4808a((Object) strArr2);
        zzbq.m4808a((Object) strArr3);
        int i = 0;
        boolean z = true;
        zzbq.m4817b(strArr.length == strArr2.length);
        if (strArr.length != strArr3.length) {
            z = false;
        }
        zzbq.m4817b(z);
        while (i < strArr.length) {
            if (zzclq.m18521b(str, strArr[i])) {
                synchronized (strArr3) {
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
            i++;
        }
        return str;
    }

    private static void m18113a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private final void m18114a(StringBuilder stringBuilder, int i, zzclt com_google_android_gms_internal_zzclt) {
        if (com_google_android_gms_internal_zzclt != null) {
            m18113a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            m18116a(stringBuilder, i, "complement", com_google_android_gms_internal_zzclt.f17925c);
            m18116a(stringBuilder, i, "param_name", m18130b(com_google_android_gms_internal_zzclt.f17926d));
            int i2 = i + 1;
            String str = "string_filter";
            zzclw com_google_android_gms_internal_zzclw = com_google_android_gms_internal_zzclt.f17923a;
            if (com_google_android_gms_internal_zzclw != null) {
                m18113a(stringBuilder, i2);
                stringBuilder.append(str);
                stringBuilder.append(" {\n");
                if (com_google_android_gms_internal_zzclw.f17936a != null) {
                    Object obj = "UNKNOWN_MATCH_TYPE";
                    switch (com_google_android_gms_internal_zzclw.f17936a.intValue()) {
                        case 1:
                            obj = "REGEXP";
                            break;
                        case 2:
                            obj = "BEGINS_WITH";
                            break;
                        case 3:
                            obj = "ENDS_WITH";
                            break;
                        case 4:
                            obj = "PARTIAL";
                            break;
                        case 5:
                            obj = "EXACT";
                            break;
                        case 6:
                            obj = "IN_LIST";
                            break;
                        default:
                            break;
                    }
                    m18116a(stringBuilder, i2, "match_type", obj);
                }
                m18116a(stringBuilder, i2, "expression", com_google_android_gms_internal_zzclw.f17937b);
                m18116a(stringBuilder, i2, "case_sensitive", com_google_android_gms_internal_zzclw.f17938c);
                if (com_google_android_gms_internal_zzclw.f17939d.length > 0) {
                    m18113a(stringBuilder, i2 + 1);
                    stringBuilder.append("expression_list {\n");
                    for (String str2 : com_google_android_gms_internal_zzclw.f17939d) {
                        m18113a(stringBuilder, i2 + 2);
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("}\n");
                }
                m18113a(stringBuilder, i2);
                stringBuilder.append("}\n");
            }
            m18115a(stringBuilder, i2, "number_filter", com_google_android_gms_internal_zzclt.f17924b);
            m18113a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m18115a(StringBuilder stringBuilder, int i, String str, zzclu com_google_android_gms_internal_zzclu) {
        if (com_google_android_gms_internal_zzclu != null) {
            m18113a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_google_android_gms_internal_zzclu.f17927a != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (com_google_android_gms_internal_zzclu.f17927a.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = Operation.BETWEEN;
                        break;
                    default:
                        break;
                }
                m18116a(stringBuilder, i, "comparison_type", obj);
            }
            m18116a(stringBuilder, i, "match_as_float", com_google_android_gms_internal_zzclu.f17928b);
            m18116a(stringBuilder, i, "comparison_value", com_google_android_gms_internal_zzclu.f17929c);
            m18116a(stringBuilder, i, "min_comparison_value", com_google_android_gms_internal_zzclu.f17930d);
            m18116a(stringBuilder, i, "max_comparison_value", com_google_android_gms_internal_zzclu.f17931e);
            m18113a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m18116a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            m18113a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void m18117a(StringBuilder stringBuilder, String str, zzcmf com_google_android_gms_internal_zzcmf) {
        if (com_google_android_gms_internal_zzcmf != null) {
            long[] jArr;
            int i;
            m18113a(stringBuilder, 3);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            int i2 = 0;
            if (com_google_android_gms_internal_zzcmf.f18009b != null) {
                m18113a(stringBuilder, 4);
                stringBuilder.append("results: ");
                jArr = com_google_android_gms_internal_zzcmf.f18009b;
                int length = jArr.length;
                i = 0;
                int i3 = i;
                while (i < length) {
                    Long valueOf = Long.valueOf(jArr[i]);
                    int i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            if (com_google_android_gms_internal_zzcmf.f18008a != null) {
                m18113a(stringBuilder, 4);
                stringBuilder.append("status: ");
                jArr = com_google_android_gms_internal_zzcmf.f18008a;
                int length2 = jArr.length;
                int i5 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr[i2]);
                    i = i5 + 1;
                    if (i5 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i5 = i;
                }
                stringBuilder.append('\n');
            }
            m18113a(stringBuilder, 3);
            stringBuilder.append("}\n");
        }
    }

    private static void m18118a(StringBuilder stringBuilder, zzcma[] com_google_android_gms_internal_zzcmaArr) {
        if (com_google_android_gms_internal_zzcmaArr != null) {
            for (zzcma com_google_android_gms_internal_zzcma : com_google_android_gms_internal_zzcmaArr) {
                if (com_google_android_gms_internal_zzcma != null) {
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("audience_membership {\n");
                    m18116a(stringBuilder, 2, "audience_id", com_google_android_gms_internal_zzcma.f17955a);
                    m18116a(stringBuilder, 2, "new_audience", com_google_android_gms_internal_zzcma.f17958d);
                    m18117a(stringBuilder, "current_data", com_google_android_gms_internal_zzcma.f17956b);
                    m18117a(stringBuilder, "previous_data", com_google_android_gms_internal_zzcma.f17957c);
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void m18119a(StringBuilder stringBuilder, zzcmb[] com_google_android_gms_internal_zzcmbArr) {
        if (com_google_android_gms_internal_zzcmbArr != null) {
            for (zzcmb com_google_android_gms_internal_zzcmb : com_google_android_gms_internal_zzcmbArr) {
                if (com_google_android_gms_internal_zzcmb != null) {
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("event {\n");
                    m18116a(stringBuilder, 2, "name", m18128a(com_google_android_gms_internal_zzcmb.f17961b));
                    m18116a(stringBuilder, 2, "timestamp_millis", com_google_android_gms_internal_zzcmb.f17962c);
                    m18116a(stringBuilder, 2, "previous_timestamp_millis", com_google_android_gms_internal_zzcmb.f17963d);
                    m18116a(stringBuilder, 2, "count", com_google_android_gms_internal_zzcmb.f17964e);
                    zzcmc[] com_google_android_gms_internal_zzcmcArr = com_google_android_gms_internal_zzcmb.f17960a;
                    if (com_google_android_gms_internal_zzcmcArr != null) {
                        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmcArr) {
                            if (com_google_android_gms_internal_zzcmc != null) {
                                m18113a(stringBuilder, 3);
                                stringBuilder.append("param {\n");
                                m18116a(stringBuilder, 3, "name", m18130b(com_google_android_gms_internal_zzcmc.f17966a));
                                m18116a(stringBuilder, 3, "string_value", com_google_android_gms_internal_zzcmc.f17967b);
                                m18116a(stringBuilder, 3, "int_value", com_google_android_gms_internal_zzcmc.f17968c);
                                m18116a(stringBuilder, 3, "double_value", com_google_android_gms_internal_zzcmc.f17969d);
                                m18113a(stringBuilder, 3);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final void m18120a(StringBuilder stringBuilder, zzcmg[] com_google_android_gms_internal_zzcmgArr) {
        if (com_google_android_gms_internal_zzcmgArr != null) {
            for (zzcmg com_google_android_gms_internal_zzcmg : com_google_android_gms_internal_zzcmgArr) {
                if (com_google_android_gms_internal_zzcmg != null) {
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("user_property {\n");
                    m18116a(stringBuilder, 2, "set_timestamp_millis", com_google_android_gms_internal_zzcmg.f18011a);
                    m18116a(stringBuilder, 2, "name", m18132c(com_google_android_gms_internal_zzcmg.f18012b));
                    m18116a(stringBuilder, 2, "string_value", com_google_android_gms_internal_zzcmg.f18013c);
                    m18116a(stringBuilder, 2, "int_value", com_google_android_gms_internal_zzcmg.f18014d);
                    m18116a(stringBuilder, 2, "double_value", com_google_android_gms_internal_zzcmg.f18015e);
                    m18113a(stringBuilder, 2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private final boolean m18121y() {
        return this.s.m5754e().m18161a(3);
    }

    protected final String m18122a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!m18121y()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            stringBuilder.append(stringBuilder.length() != 0 ? ", " : "Bundle[{");
            stringBuilder.append(m18130b(str));
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    protected final String m18123a(zzcgv com_google_android_gms_internal_zzcgv) {
        if (!m18121y()) {
            return com_google_android_gms_internal_zzcgv.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(com_google_android_gms_internal_zzcgv.f6835a);
        stringBuilder.append("', name='");
        stringBuilder.append(m18128a(com_google_android_gms_internal_zzcgv.f6836b));
        stringBuilder.append("', params=");
        stringBuilder.append(m18111a(com_google_android_gms_internal_zzcgv.f6840f));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected final String m18124a(zzcha com_google_android_gms_internal_zzcha) {
        if (com_google_android_gms_internal_zzcha == null) {
            return null;
        }
        if (!m18121y()) {
            return com_google_android_gms_internal_zzcha.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(com_google_android_gms_internal_zzcha.f17800c);
        stringBuilder.append(",name=");
        stringBuilder.append(m18128a(com_google_android_gms_internal_zzcha.f17798a));
        stringBuilder.append(",params=");
        stringBuilder.append(m18111a(com_google_android_gms_internal_zzcha.f17799b));
        return stringBuilder.toString();
    }

    protected final String m18125a(zzcls com_google_android_gms_internal_zzcls) {
        if (com_google_android_gms_internal_zzcls == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        int i = 0;
        m18116a(stringBuilder, 0, "filter_id", com_google_android_gms_internal_zzcls.f17917a);
        m18116a(stringBuilder, 0, "event_name", m18128a(com_google_android_gms_internal_zzcls.f17918b));
        m18115a(stringBuilder, 1, "event_count_filter", com_google_android_gms_internal_zzcls.f17920d);
        stringBuilder.append("  filters {\n");
        zzclt[] com_google_android_gms_internal_zzcltArr = com_google_android_gms_internal_zzcls.f17919c;
        int length = com_google_android_gms_internal_zzcltArr.length;
        while (i < length) {
            m18114a(stringBuilder, 2, com_google_android_gms_internal_zzcltArr[i]);
            i++;
        }
        m18113a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    protected final String m18126a(zzclv com_google_android_gms_internal_zzclv) {
        if (com_google_android_gms_internal_zzclv == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        m18116a(stringBuilder, 0, "filter_id", com_google_android_gms_internal_zzclv.f17933a);
        m18116a(stringBuilder, 0, "property_name", m18132c(com_google_android_gms_internal_zzclv.f17934b));
        m18114a(stringBuilder, 1, com_google_android_gms_internal_zzclv.f17935c);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String m18127a(zzcmd com_google_android_gms_internal_zzcmd) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (com_google_android_gms_internal_zzcmd.f17971a != null) {
            for (zzcme com_google_android_gms_internal_zzcme : com_google_android_gms_internal_zzcmd.f17971a) {
                if (!(com_google_android_gms_internal_zzcme == null || com_google_android_gms_internal_zzcme == null)) {
                    m18113a(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    m18116a(stringBuilder, 1, "protocol_version", com_google_android_gms_internal_zzcme.f17982a);
                    m18116a(stringBuilder, 1, "platform", com_google_android_gms_internal_zzcme.f17990i);
                    m18116a(stringBuilder, 1, "gmp_version", com_google_android_gms_internal_zzcme.f17998q);
                    m18116a(stringBuilder, 1, "uploading_gmp_version", com_google_android_gms_internal_zzcme.f17999r);
                    m18116a(stringBuilder, 1, "config_version", com_google_android_gms_internal_zzcme.f17977E);
                    m18116a(stringBuilder, 1, "gmp_app_id", com_google_android_gms_internal_zzcme.f18006y);
                    m18116a(stringBuilder, 1, "app_id", com_google_android_gms_internal_zzcme.f17996o);
                    m18116a(stringBuilder, 1, State.KEY_APP_VERSION, com_google_android_gms_internal_zzcme.f17997p);
                    m18116a(stringBuilder, 1, "app_version_major", com_google_android_gms_internal_zzcme.f17975C);
                    m18116a(stringBuilder, 1, "firebase_instance_id", com_google_android_gms_internal_zzcme.f17974B);
                    m18116a(stringBuilder, 1, "dev_cert_hash", com_google_android_gms_internal_zzcme.f18003v);
                    m18116a(stringBuilder, 1, "app_store", com_google_android_gms_internal_zzcme.f17995n);
                    m18116a(stringBuilder, 1, "upload_timestamp_millis", com_google_android_gms_internal_zzcme.f17985d);
                    m18116a(stringBuilder, 1, "start_timestamp_millis", com_google_android_gms_internal_zzcme.f17986e);
                    m18116a(stringBuilder, 1, "end_timestamp_millis", com_google_android_gms_internal_zzcme.f17987f);
                    m18116a(stringBuilder, 1, "previous_bundle_start_timestamp_millis", com_google_android_gms_internal_zzcme.f17988g);
                    m18116a(stringBuilder, 1, "previous_bundle_end_timestamp_millis", com_google_android_gms_internal_zzcme.f17989h);
                    m18116a(stringBuilder, 1, "app_instance_id", com_google_android_gms_internal_zzcme.f18002u);
                    m18116a(stringBuilder, 1, "resettable_device_id", com_google_android_gms_internal_zzcme.f18000s);
                    m18116a(stringBuilder, 1, "device_id", com_google_android_gms_internal_zzcme.f17976D);
                    m18116a(stringBuilder, 1, "limited_ad_tracking", com_google_android_gms_internal_zzcme.f18001t);
                    m18116a(stringBuilder, 1, "os_version", com_google_android_gms_internal_zzcme.f17991j);
                    m18116a(stringBuilder, 1, "device_model", com_google_android_gms_internal_zzcme.f17992k);
                    m18116a(stringBuilder, 1, "user_default_language", com_google_android_gms_internal_zzcme.f17993l);
                    m18116a(stringBuilder, 1, "time_zone_offset_minutes", com_google_android_gms_internal_zzcme.f17994m);
                    m18116a(stringBuilder, 1, "bundle_sequential_index", com_google_android_gms_internal_zzcme.f18004w);
                    m18116a(stringBuilder, 1, "service_upload", com_google_android_gms_internal_zzcme.f18007z);
                    m18116a(stringBuilder, 1, "health_monitor", com_google_android_gms_internal_zzcme.f18005x);
                    if (com_google_android_gms_internal_zzcme.f17978F.longValue() != 0) {
                        m18116a(stringBuilder, 1, "android_id", com_google_android_gms_internal_zzcme.f17978F);
                    }
                    m18120a(stringBuilder, com_google_android_gms_internal_zzcme.f17984c);
                    m18118a(stringBuilder, com_google_android_gms_internal_zzcme.f17973A);
                    m18119a(stringBuilder, com_google_android_gms_internal_zzcme.f17983b);
                    m18113a(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    protected final String m18128a(String str) {
        return str == null ? null : !m18121y() ? str : m18112a(str, Event.f14803b, Event.f14802a, f17813a);
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    protected final String m18130b(String str) {
        return str == null ? null : !m18121y() ? str : m18112a(str, Param.f14805b, Param.f14804a, f17814b);
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    protected final String m18132c(String str) {
        if (str == null) {
            return null;
        }
        if (!m18121y()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m18112a(str, UserProperty.f14807b, UserProperty.f14806a, f17815c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
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
}
