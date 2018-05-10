package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.util.Locale;

final class zzchx extends zzcjl {
    static final Pair<String, Long> f17828a = new Pair("", Long.valueOf(0));
    public final zzcib f17829b = new zzcib(this, "health_monitor", Math.max(0, ((Long) zzchc.f6871e.f6893a).longValue()));
    public final zzcia f17830c = new zzcia(this, "last_upload", 0);
    public final zzcia f17831d = new zzcia(this, "last_upload_attempt", 0);
    public final zzcia f17832e = new zzcia(this, "backoff", 0);
    public final zzcia f17833f = new zzcia(this, "last_delete_stale", 0);
    public final zzcia f17834g = new zzcia(this, "midnight_offset", 0);
    public final zzcia f17835h = new zzcia(this, "first_open_time", 0);
    public final zzcic f17836i = new zzcic(this, "app_instance_id");
    String f17837j;
    long f17838k;
    final Object f17839l = new Object();
    public final zzcia f17840m = new zzcia(this, "time_before_start", 10000);
    public final zzcia f17841n = new zzcia(this, "session_timeout", 1800000);
    public final zzchz f17842o = new zzchz(this, "start_new_session");
    public final zzcia f17843p = new zzcia(this, "last_pause_time", 0);
    public final zzcia f17844q = new zzcia(this, "time_active", 0);
    public boolean f17845r;
    private SharedPreferences f17846t;
    private String f17847u;
    private boolean f17848v;
    private long f17849w;

    private final SharedPreferences m18211D() {
        mo1811c();
        m13545L();
        return this.f17846t;
    }

    final Boolean m18213A() {
        mo1811c();
        return !m18211D().contains("use_service") ? null : Boolean.valueOf(m18211D().getBoolean("use_service", false));
    }

    protected final String m18215C() {
        mo1811c();
        String string = m18211D().getString("previous_os_version", null);
        mo1816h().m13545L();
        String str = VERSION.RELEASE;
        if (!(TextUtils.isEmpty(str) || str.equals(string))) {
            Editor edit = m18211D().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    final String m18218b(String str) {
        mo1811c();
        str = (String) m18216a(str).first;
        if (zzclq.m18526f("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzclq.m18526f("MD5").digest(str.getBytes()))});
    }

    final void m18220c(String str) {
        mo1811c();
        Editor edit = m18211D().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    final boolean m18221c(boolean z) {
        mo1811c();
        return m18211D().getBoolean("measurement_enabled", z);
    }

    protected final void l_() {
        this.f17846t = mo1820l().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f17845r = this.f17846t.getBoolean("has_been_opened", false);
        if (!this.f17845r) {
            Editor edit = this.f17846t.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    protected final boolean mo3490w() {
        return true;
    }

    final String m18223y() {
        mo1811c();
        return m18211D().getString("gmp_app_id", null);
    }

    final String m18224z() {
        synchronized (this.f17839l) {
            if (Math.abs(mo1819k().mo1633b() - this.f17838k) < 1000) {
                String str = this.f17837j;
                return str;
            }
            return null;
        }
    }

    final Pair<String, Boolean> m18216a(String str) {
        mo1811c();
        long b = mo1819k().mo1633b();
        if (this.f17847u != null && b < this.f17849w) {
            return new Pair(this.f17847u, Boolean.valueOf(this.f17848v));
        }
        this.f17849w = b + mo1830v().m13489a(str, zzchc.f6870d);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            str = AdvertisingIdClient.getAdvertisingIdInfo(mo1820l());
            if (str != null) {
                this.f17847u = str.getId();
                this.f17848v = str.isLimitAdTrackingEnabled();
            }
            if (this.f17847u == null) {
                this.f17847u = "";
            }
        } catch (String str2) {
            mo1828t().f17821f.m5694a("Unable to get advertising id", str2);
            this.f17847u = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(null);
        return new Pair(this.f17847u, Boolean.valueOf(this.f17848v));
    }

    zzchx(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    final void m18217a(boolean z) {
        mo1811c();
        mo1828t().f17822g.m5694a("Setting useService", Boolean.valueOf(z));
        Editor edit = m18211D().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    final void m18214B() {
        mo1811c();
        mo1828t().f17822g.m5693a("Clearing collection preferences.");
        boolean contains = m18211D().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = m18221c(true);
        }
        Editor edit = m18211D().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m18219b(z);
        }
    }

    final void m18219b(boolean z) {
        mo1811c();
        mo1828t().f17822g.m5694a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m18211D().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }
}
