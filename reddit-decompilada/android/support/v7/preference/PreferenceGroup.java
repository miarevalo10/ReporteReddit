package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference {
    List<Preference> f11634a;
    private boolean f11635b;
    private int f11636c;
    private boolean f11637d;
    private final SimpleArrayMap<String, Long> f11638e;
    private final Handler f11639f;
    private final Runnable f11640g;

    class C01751 implements Runnable {
        final /* synthetic */ PreferenceGroup f1910a;

        C01751(PreferenceGroup preferenceGroup) {
            this.f1910a = preferenceGroup;
        }

        public void run() {
            synchronized (this) {
                this.f1910a.f11638e.clear();
            }
        }
    }

    protected boolean mo488f() {
        return true;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.f11635b = true;
        this.f11636c = 0;
        this.f11637d = false;
        this.f11638e = new SimpleArrayMap();
        this.f11639f = new Handler();
        this.f11640g = new C01751(this);
        this.f11634a = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.PreferenceGroup, i, 0);
        this.f11635b = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.PreferenceGroup_orderingFromXml, C0177R.styleable.PreferenceGroup_orderingFromXml, true);
        obtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, (byte) 0);
    }

    public final int mo481a() {
        return this.f11634a.size();
    }

    public final Preference m10340a(int i) {
        return (Preference) this.f11634a.get(i);
    }

    public final boolean m10345b(Preference preference) {
        if (this.f11634a.contains(preference)) {
            return true;
        }
        int i;
        if (preference.f1896o == RedditJobManager.f10810d) {
            if (this.f11635b) {
                i = this.f11636c;
                this.f11636c = i + 1;
                preference.m1602b(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).f11635b = this.f11635b;
            }
        }
        i = Collections.binarySearch(this.f11634a, preference);
        if (i < 0) {
            i = (i * -1) - 1;
        }
        if (!mo3189a(preference)) {
            return null;
        }
        long a;
        synchronized (this) {
            this.f11634a.add(i, preference);
        }
        PreferenceManager preferenceManager = this.f1892k;
        String str = preference.f1898q;
        if (str == null || !this.f11638e.containsKey(str)) {
            a = preferenceManager.m1648a();
        } else {
            a = ((Long) this.f11638e.get(str)).longValue();
            this.f11638e.remove(str);
        }
        preference.m1594a(preferenceManager, a);
        preference.f1869A = this;
        if (this.f11637d) {
            preference.mo489m();
        }
        m1620l();
        return true;
    }

    protected boolean mo3189a(Preference preference) {
        preference.m1608c(mo503d());
        return true;
    }

    public final void mo489m() {
        super.mo489m();
        this.f11637d = true;
        int a = mo481a();
        for (int i = 0; i < a; i++) {
            m10340a(i).mo489m();
        }
    }

    public final void mo490n() {
        super.mo490n();
        int i = 0;
        this.f11637d = false;
        int a = mo481a();
        while (i < a) {
            m10340a(i).mo490n();
            i++;
        }
    }

    public final void mo487b(boolean z) {
        super.mo487b(z);
        int a = mo481a();
        for (int i = 0; i < a; i++) {
            m10340a(i).m1608c(z);
        }
    }

    protected final void mo485a(Bundle bundle) {
        super.mo485a(bundle);
        int a = mo481a();
        for (int i = 0; i < a; i++) {
            m10340a(i).mo485a(bundle);
        }
    }

    protected final void mo486b(Bundle bundle) {
        super.mo486b(bundle);
        int a = mo481a();
        for (int i = 0; i < a; i++) {
            m10340a(i).mo486b(bundle);
        }
    }

    public final Preference m10346c(CharSequence charSequence) {
        if (TextUtils.equals(this.f1898q, charSequence)) {
            return this;
        }
        int a = mo481a();
        for (int i = 0; i < a; i++) {
            Preference a2 = m10340a(i);
            String str = a2.f1898q;
            if (str != null && str.equals(charSequence)) {
                return a2;
            }
            if (a2 instanceof PreferenceGroup) {
                a2 = ((PreferenceGroup) a2).m10346c(charSequence);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }
}
