package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;

public class PreferenceManager {
    PreferenceDataStore f1921a;
    boolean f1922b;
    PreferenceScreen f1923c;
    PreferenceComparisonCallback f1924d;
    OnPreferenceTreeClickListener f1925e;
    OnDisplayPreferenceDialogListener f1926f;
    OnNavigateToScreenListener f1927g;
    private Context f1928h;
    private long f1929i = 0;
    private SharedPreferences f1930j;
    private Editor f1931k;
    private String f1932l;
    private int f1933m;
    private int f1934n = 0;

    public interface OnDisplayPreferenceDialogListener {
        void mo3194b(Preference preference);
    }

    public interface OnNavigateToScreenListener {
        void mo3192a();
    }

    public interface OnPreferenceTreeClickListener {
        boolean mo3193a(Preference preference);
    }

    public static abstract class PreferenceComparisonCallback {
        public abstract boolean m1645a();

        public abstract boolean m1646b();
    }

    public PreferenceManager(Context context) {
        this.f1928h = context;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("_preferences");
        this.f1932l = stringBuilder.toString();
        this.f1930j = null;
    }

    public final PreferenceScreen m1650a(Context context, int i, PreferenceScreen preferenceScreen) {
        m1647a(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).m1641a(i, (PreferenceGroup) preferenceScreen);
        preferenceScreen2.m1593a(this);
        m1647a((boolean) 0);
        return preferenceScreen2;
    }

    final long m1648a() {
        long j;
        synchronized (this) {
            j = this.f1929i;
            this.f1929i = 1 + j;
        }
        return j;
    }

    public final Preference m1649a(CharSequence charSequence) {
        if (this.f1923c == null) {
            return null;
        }
        return this.f1923c.m10346c(charSequence);
    }

    final Editor m1652c() {
        if (this.f1921a != null) {
            return null;
        }
        if (!this.f1922b) {
            return m1651b().edit();
        }
        if (this.f1931k == null) {
            this.f1931k = m1651b().edit();
        }
        return this.f1931k;
    }

    private void m1647a(boolean z) {
        if (!(z || this.f1931k == null)) {
            this.f1931k.apply();
        }
        this.f1922b = z;
    }

    public final SharedPreferences m1651b() {
        if (this.f1921a != null) {
            return null;
        }
        if (this.f1930j == null) {
            Context context;
            if (this.f1934n != 1) {
                context = this.f1928h;
            } else {
                context = ContextCompat.m720c(this.f1928h);
            }
            this.f1930j = context.getSharedPreferences(this.f1932l, this.f1933m);
        }
        return this.f1930j;
    }
}
