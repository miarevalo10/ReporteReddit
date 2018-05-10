package android.support.v7.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.preference.PreferenceManager.PreferenceComparisonCallback;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreferenceGroupAdapter extends Adapter<PreferenceViewHolder> implements OnPreferenceChangeInternalListener {
    private PreferenceGroup f11645a;
    private List<Preference> f11646b;
    private List<Preference> f11647c;
    private List<PreferenceLayout> f11648f;
    private PreferenceLayout f11649g = new PreferenceLayout();
    private Handler f11650h = new Handler();
    private Runnable f11651i = new C01761(this);

    class C01761 implements Runnable {
        final /* synthetic */ PreferenceGroupAdapter f1911a;

        C01761(PreferenceGroupAdapter preferenceGroupAdapter) {
            this.f1911a = preferenceGroupAdapter;
        }

        public void run() {
            this.f1911a.m10357c();
        }
    }

    private static class PreferenceLayout {
        private int f1912a;
        private int f1913b;
        private String f1914c;

        public PreferenceLayout(PreferenceLayout preferenceLayout) {
            this.f1912a = preferenceLayout.f1912a;
            this.f1913b = preferenceLayout.f1913b;
            this.f1914c = preferenceLayout.f1914c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceLayout)) {
                return false;
            }
            PreferenceLayout preferenceLayout = (PreferenceLayout) obj;
            if (this.f1912a == preferenceLayout.f1912a && this.f1913b == preferenceLayout.f1913b && TextUtils.equals(this.f1914c, preferenceLayout.f1914c) != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (31 * (((527 + this.f1912a) * 31) + this.f1913b)) + this.f1914c.hashCode();
        }
    }

    public final /* synthetic */ void mo43a(ViewHolder viewHolder, int i) {
        m10366c(i).mo500a((PreferenceViewHolder) viewHolder);
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.f11645a = preferenceGroup;
        this.f11645a.f1907z = this;
        this.f11646b = new ArrayList();
        this.f11647c = new ArrayList();
        this.f11648f = new ArrayList();
        if ((this.f11645a instanceof PreferenceScreen) != null) {
            m2019a((boolean) ((PreferenceScreen) this.f11645a).f16591b);
        } else {
            m2019a(true);
        }
        m10357c();
    }

    private void m10357c() {
        for (Preference preference : this.f11647c) {
            preference.f1907z = null;
        }
        List<Preference> arrayList = new ArrayList(this.f11647c.size());
        m10356a((List) arrayList, this.f11645a);
        final List arrayList2 = new ArrayList(arrayList.size());
        for (Preference preference2 : arrayList) {
            if (preference2.f1904w) {
                arrayList2.add(preference2);
            }
        }
        final List list = this.f11646b;
        this.f11646b = arrayList2;
        this.f11647c = arrayList;
        PreferenceManager preferenceManager = this.f11645a.f1892k;
        if (preferenceManager == null || preferenceManager.f1924d == null) {
            this.a_.m2036b();
        } else {
            final PreferenceComparisonCallback preferenceComparisonCallback = preferenceManager.f1924d;
            DiffUtil.m1664a(new Callback(this) {
                final /* synthetic */ PreferenceGroupAdapter f11644d;

                public final int mo491a() {
                    return list.size();
                }

                public final int mo493b() {
                    return arrayList2.size();
                }

                public final boolean mo492a(int i, int i2) {
                    PreferenceComparisonCallback preferenceComparisonCallback = preferenceComparisonCallback;
                    list.get(i);
                    arrayList2.get(i2);
                    return preferenceComparisonCallback.m1645a();
                }

                public final boolean mo494b(int i, int i2) {
                    PreferenceComparisonCallback preferenceComparisonCallback = preferenceComparisonCallback;
                    list.get(i);
                    arrayList2.get(i2);
                    return preferenceComparisonCallback.m1646b();
                }
            }).m1663a((Adapter) this);
        }
        for (Preference preference3 : arrayList) {
            preference3.f1870B = false;
        }
    }

    private static PreferenceLayout m10354a(Preference preference, PreferenceLayout preferenceLayout) {
        if (preferenceLayout == null) {
            preferenceLayout = new PreferenceLayout();
        }
        preferenceLayout.f1914c = preference.getClass().getName();
        preferenceLayout.f1912a = preference.f1905x;
        preferenceLayout.f1913b = preference.f1906y;
        return preferenceLayout;
    }

    public final int mo39a() {
        return this.f11646b.size();
    }

    public final Preference m10366c(int i) {
        if (i >= 0) {
            if (i < mo39a()) {
                return (Preference) this.f11646b.get(i);
            }
        }
        return 0;
    }

    public final void mo495a(Preference preference) {
        int indexOf = this.f11646b.indexOf(preference);
        if (indexOf != -1) {
            this.a_.m2034a(indexOf, 1, preference);
        }
    }

    public final void mo496b() {
        this.f11650h.removeCallbacks(this.f11651i);
        this.f11650h.post(this.f11651i);
    }

    public final void mo497b(Preference preference) {
        if (!this.f11647c.contains(preference)) {
            return;
        }
        int i;
        if (preference.f1904w) {
            i = -1;
            for (Preference preference2 : this.f11647c) {
                if (preference.equals(preference2)) {
                    break;
                } else if (preference2.f1904w) {
                    i++;
                }
            }
            i++;
            this.f11646b.add(i, preference);
            m2031e(i);
            return;
        }
        i = this.f11646b.size();
        int i2 = 0;
        while (i2 < i && !preference.equals(this.f11646b.get(i2))) {
            i2++;
        }
        this.f11646b.remove(i2);
        m2032f(i2);
    }

    public final int mo44b(int i) {
        this.f11649g = m10354a(m10366c(i), this.f11649g);
        i = this.f11648f.indexOf(this.f11649g);
        if (i != -1) {
            return i;
        }
        i = this.f11648f.size();
        this.f11648f.add(new PreferenceLayout(this.f11649g));
        return i;
    }

    private void m10356a(List<Preference> list, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.f11634a);
        }
        int a = preferenceGroup.mo481a();
        for (int i = 0; i < a; i++) {
            Preference a2 = preferenceGroup.m10340a(i);
            list.add(a2);
            PreferenceLayout a3 = m10354a(a2, null);
            if (!this.f11648f.contains(a3)) {
                this.f11648f.add(a3);
            }
            if (a2 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) a2;
                if (preferenceGroup2.mo488f()) {
                    m10356a((List) list, preferenceGroup2);
                }
            }
            a2.f1907z = this;
        }
    }

    public final long mo40a(int i) {
        if (this.f2349e) {
            return m10366c(i).f1893l;
        }
        return -1;
    }

    public final /* synthetic */ ViewHolder mo41a(ViewGroup viewGroup, int i) {
        PreferenceLayout preferenceLayout = (PreferenceLayout) this.f11648f.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(null, C0177R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0177R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = ContextCompat.m714a(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceLayout.f1912a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.m1219a(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (preferenceLayout.f1913b != 0) {
                from.inflate(preferenceLayout.f1913b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }
}
