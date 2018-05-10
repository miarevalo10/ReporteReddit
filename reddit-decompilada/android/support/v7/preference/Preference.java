package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.List;

public class Preference implements Comparable<Preference> {
    PreferenceGroup f1869A;
    boolean f1870B;
    private boolean f1871C;
    private boolean f1872D;
    private boolean f1873E;
    private boolean f1874F;
    private boolean f1875G;
    private boolean f1876H;
    private boolean f1877I;
    private boolean f1878J;
    private List<Preference> f1879K;
    private boolean f1880L;
    private final OnClickListener f1881M;
    private PreferenceDataStore f1882a;
    private boolean f1883b;
    private int f1884c;
    private CharSequence f1885d;
    private int f1886e;
    private Drawable f1887f;
    private boolean f1888g;
    private boolean f1889h;
    private String f1890i;
    public Context f1891j;
    PreferenceManager f1892k;
    long f1893l;
    public OnPreferenceChangeListener f1894m;
    public OnPreferenceClickListener f1895n;
    int f1896o;
    CharSequence f1897p;
    public String f1898q;
    Intent f1899r;
    String f1900s;
    Bundle f1901t;
    boolean f1902u;
    public Object f1903v;
    boolean f1904w;
    public int f1905x;
    int f1906y;
    OnPreferenceChangeInternalListener f1907z;

    class C01711 implements OnClickListener {
        final /* synthetic */ Preference f1868a;

        C01711(Preference preference) {
            this.f1868a = preference;
        }

        public void onClick(View view) {
            this.f1868a.mo3183a(view);
        }
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new C01721();

        static class C01721 implements Creator<BaseSavedState> {
            C01721() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface OnPreferenceChangeInternalListener {
        void mo495a(Preference preference);

        void mo496b();

        void mo497b(Preference preference);
    }

    public interface OnPreferenceChangeListener {
        boolean m1580a(Object obj);
    }

    public interface OnPreferenceClickListener {
        boolean m1581a();
    }

    protected Object mo498a(TypedArray typedArray, int i) {
        return null;
    }

    public void mo3188a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected void mo501a(boolean z, Object obj) {
    }

    protected void mo482b() {
    }

    protected final boolean m1612d(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.preference.Preference.d(int):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.preference.Preference.d(int):boolean");
    }

    public /* synthetic */ int compareTo(Object obj) {
        Preference preference = (Preference) obj;
        if (this.f1896o != preference.f1896o) {
            return this.f1896o - preference.f1896o;
        }
        if (this.f1897p == preference.f1897p) {
            return null;
        }
        if (this.f1897p == null) {
            return 1;
        }
        if (preference.f1897p == null) {
            return -1;
        }
        return this.f1897p.toString().compareToIgnoreCase(preference.f1897p.toString());
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1896o = RedditJobManager.f10810d;
        this.f1884c = 0;
        this.f1888g = true;
        this.f1889h = true;
        this.f1902u = true;
        this.f1871C = true;
        this.f1872D = true;
        this.f1904w = true;
        this.f1873E = true;
        this.f1874F = true;
        this.f1876H = true;
        this.f1878J = true;
        this.f1905x = C0177R.layout.preference;
        this.f1881M = new C01711(this);
        this.f1891j = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.Preference, i, i2);
        this.f1886e = TypedArrayUtils.m777a(obtainStyledAttributes, C0177R.styleable.Preference_icon, C0177R.styleable.Preference_android_icon, 0);
        this.f1898q = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.Preference_key, C0177R.styleable.Preference_android_key);
        this.f1897p = TypedArrayUtils.m790d(obtainStyledAttributes, C0177R.styleable.Preference_title, C0177R.styleable.Preference_android_title);
        this.f1885d = TypedArrayUtils.m790d(obtainStyledAttributes, C0177R.styleable.Preference_summary, C0177R.styleable.Preference_android_summary);
        this.f1896o = TypedArrayUtils.m786b(obtainStyledAttributes, C0177R.styleable.Preference_order, C0177R.styleable.Preference_android_order);
        this.f1900s = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.Preference_fragment, C0177R.styleable.Preference_android_fragment);
        this.f1905x = TypedArrayUtils.m777a(obtainStyledAttributes, C0177R.styleable.Preference_layout, C0177R.styleable.Preference_android_layout, C0177R.layout.preference);
        this.f1906y = TypedArrayUtils.m777a(obtainStyledAttributes, C0177R.styleable.Preference_widgetLayout, C0177R.styleable.Preference_android_widgetLayout, 0);
        this.f1888g = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_enabled, C0177R.styleable.Preference_android_enabled, true);
        this.f1889h = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_selectable, C0177R.styleable.Preference_android_selectable, true);
        this.f1902u = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_persistent, C0177R.styleable.Preference_android_persistent, true);
        this.f1890i = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.Preference_dependency, C0177R.styleable.Preference_android_dependency);
        this.f1873E = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_allowDividerAbove, C0177R.styleable.Preference_allowDividerAbove, this.f1889h);
        this.f1874F = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_allowDividerBelow, C0177R.styleable.Preference_allowDividerBelow, this.f1889h);
        if (obtainStyledAttributes.hasValue(C0177R.styleable.Preference_defaultValue) != null) {
            this.f1903v = mo498a(obtainStyledAttributes, C0177R.styleable.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(C0177R.styleable.Preference_android_defaultValue) != null) {
            this.f1903v = mo498a(obtainStyledAttributes, C0177R.styleable.Preference_android_defaultValue);
        }
        this.f1878J = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_shouldDisableView, C0177R.styleable.Preference_android_shouldDisableView, true);
        this.f1875G = obtainStyledAttributes.hasValue(C0177R.styleable.Preference_singleLineTitle);
        if (this.f1875G != null) {
            this.f1876H = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_singleLineTitle, C0177R.styleable.Preference_android_singleLineTitle, true);
        }
        this.f1877I = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.Preference_iconSpaceReserved, C0177R.styleable.Preference_android_iconSpaceReserved, false);
        obtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, null);
    }

    private PreferenceDataStore mo481a() {
        if (this.f1882a != null) {
            return this.f1882a;
        }
        return this.f1892k != null ? this.f1892k.f1921a : null;
    }

    public void mo500a(PreferenceViewHolder preferenceViewHolder) {
        CharSequence charSequence;
        preferenceViewHolder.c.setOnClickListener(this.f1881M);
        preferenceViewHolder.c.setId(this.f1884c);
        TextView textView = (TextView) preferenceViewHolder.m10369a(16908310);
        int i = 8;
        if (textView != null) {
            charSequence = this.f1897p;
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
                if (this.f1875G) {
                    textView.setSingleLine(this.f1876H);
                }
            }
        }
        textView = (TextView) preferenceViewHolder.m10369a(16908304);
        if (textView != null) {
            charSequence = mo3187h();
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.m10369a(16908294);
        if (imageView != null) {
            if (!(this.f1886e == 0 && this.f1887f == null)) {
                if (this.f1887f == null) {
                    this.f1887f = ContextCompat.m714a(this.f1891j, this.f1886e);
                }
                if (this.f1887f != null) {
                    imageView.setImageDrawable(this.f1887f);
                }
            }
            int i2 = this.f1887f != null ? 0 : this.f1877I ? 4 : 8;
            imageView.setVisibility(i2);
        }
        View a = preferenceViewHolder.m10369a(C0177R.id.icon_frame);
        if (a == null) {
            a = preferenceViewHolder.m10369a(16908350);
        }
        if (a != null) {
            if (this.f1887f != null) {
                i = 0;
            } else if (this.f1877I) {
                i = 4;
            }
            a.setVisibility(i);
        }
        if (this.f1878J) {
            m1585a(preferenceViewHolder.c, mo3190j());
        } else {
            m1585a(preferenceViewHolder.c, true);
        }
        boolean z = this.f1889h;
        preferenceViewHolder.c.setFocusable(z);
        preferenceViewHolder.c.setClickable(z);
        preferenceViewHolder.f11653a = this.f1873E;
        preferenceViewHolder.f11654b = this.f1874F;
    }

    private void m1585a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m1585a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final void m1602b(int i) {
        if (i != this.f1896o) {
            this.f1896o = i;
            m1620l();
        }
    }

    public final void m1604b(CharSequence charSequence) {
        if ((charSequence == null && this.f1897p != null) || (charSequence != null && !charSequence.equals(this.f1897p))) {
            this.f1897p = charSequence;
            mo3849c();
        }
    }

    public final void m1607c(int i) {
        m1604b(this.f1891j.getString(i));
    }

    public CharSequence mo3187h() {
        return this.f1885d;
    }

    public void mo3185a(CharSequence charSequence) {
        if ((charSequence == null && this.f1885d != null) || (charSequence != null && !charSequence.equals(this.f1885d))) {
            this.f1885d = charSequence;
            mo3849c();
        }
    }

    public final void m1598a(boolean z) {
        if (this.f1888g != z) {
            this.f1888g = z;
            mo487b(mo503d());
            mo3849c();
        }
    }

    public boolean mo3190j() {
        return this.f1888g && this.f1871C && this.f1872D;
    }

    public final void m1619k() {
        if (this.f1904w) {
            this.f1904w = false;
            if (this.f1907z != null) {
                this.f1907z.mo497b(this);
            }
        }
    }

    private boolean mo488f() {
        return !TextUtils.isEmpty(this.f1898q);
    }

    private boolean mo3186g() {
        return this.f1892k != null && this.f1902u && mo488f();
    }

    public final boolean m1600a(Object obj) {
        if (this.f1894m != null) {
            if (this.f1894m.m1580a(obj) == null) {
                return null;
            }
        }
        return true;
    }

    protected void mo3849c() {
        if (this.f1907z != null) {
            this.f1907z.mo495a(this);
        }
    }

    protected final void m1620l() {
        if (this.f1907z != null) {
            this.f1907z.mo496b();
        }
    }

    protected final void m1593a(PreferenceManager preferenceManager) {
        this.f1892k = preferenceManager;
        if (!this.f1883b) {
            this.f1893l = preferenceManager.m1648a();
        }
        if (mo481a() != null) {
            mo501a(true, this.f1903v);
            return;
        }
        if (mo3186g() != null) {
            if (this.f1892k != null) {
                if (mo481a() == null) {
                    preferenceManager = this.f1892k.m1651b();
                    if (preferenceManager.contains(this.f1898q) == null) {
                        mo501a(true, null);
                    }
                }
            }
            preferenceManager = null;
            if (preferenceManager.contains(this.f1898q) == null) {
                mo501a(true, null);
            }
        }
        if (this.f1903v != null) {
            mo501a((boolean) null, this.f1903v);
        }
    }

    protected final void m1594a(PreferenceManager preferenceManager, long j) {
        this.f1893l = j;
        this.f1883b = 1;
        try {
            m1593a(preferenceManager);
        } finally {
            this.f1883b = 0;
        }
    }

    private Preference mo3184a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f1892k != null) {
                return this.f1892k.m1649a((CharSequence) str);
            }
        }
        return null;
    }

    public void mo487b(boolean z) {
        List list = this.f1879K;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Preference) list.get(i)).mo504f(z);
            }
        }
    }

    private void mo504f(boolean z) {
        if (this.f1871C == z) {
            this.f1871C = z ^ 1;
            mo487b(mo503d());
            mo3849c();
        }
    }

    public final void m1608c(boolean z) {
        if (this.f1872D == z) {
            this.f1872D = z ^ 1;
            mo487b(mo503d());
            mo3849c();
        }
    }

    public boolean mo503d() {
        return !mo3190j();
    }

    private void m1584a(Editor editor) {
        if ((this.f1892k.f1922b ^ 1) != 0) {
            editor.apply();
        }
    }

    protected final boolean m1609c(String str) {
        if (!mo3186g()) {
            return null;
        }
        if (TextUtils.equals(str, m1610d(null))) {
            return true;
        }
        if (mo481a() != null) {
            PreferenceDataStore.m1625a();
        } else {
            Editor c = this.f1892k.m1652c();
            c.putString(this.f1898q, str);
            m1584a(c);
        }
        return true;
    }

    protected final String m1610d(String str) {
        if (!mo3186g()) {
            return str;
        }
        if (mo481a() != null) {
            return PreferenceDataStore.m1624a(str);
        }
        return this.f1892k.m1651b().getString(this.f1898q, str);
    }

    protected final int m1614e(int i) {
        if (!mo3186g()) {
            return i;
        }
        if (mo481a() != null) {
            return PreferenceDataStore.m1623a(i);
        }
        return this.f1892k.m1651b().getInt(this.f1898q, i);
    }

    protected final boolean m1613d(boolean z) {
        if (!mo3186g()) {
            return false;
        }
        if (z == m1616e(z ^ 1)) {
            return true;
        }
        if (mo481a() != null) {
            PreferenceDataStore.m1628c();
        } else {
            Editor c = this.f1892k.m1652c();
            c.putBoolean(this.f1898q, z);
            m1584a(c);
        }
        return true;
    }

    protected final boolean m1616e(boolean z) {
        if (!mo3186g()) {
            return z;
        }
        if (mo481a() != null) {
            return PreferenceDataStore.m1626a(z);
        }
        return this.f1892k.m1651b().getBoolean(this.f1898q, z);
    }

    void mo485a(Bundle bundle) {
        if (mo488f()) {
            this.f1880L = false;
            Parcelable e = mo502e();
            if (!this.f1880L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (e != null) {
                bundle.putParcelable(this.f1898q, e);
            }
        }
    }

    protected Parcelable mo502e() {
        this.f1880L = true;
        return BaseSavedState.EMPTY_STATE;
    }

    void mo486b(Bundle bundle) {
        if (mo488f()) {
            Parcelable parcelable = bundle.getParcelable(this.f1898q);
            if (parcelable != null) {
                this.f1880L = false;
                mo499a(parcelable);
                if (this.f1880L == null) {
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }

    protected void mo499a(Parcelable parcelable) {
        this.f1880L = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected void mo3183a(View view) {
        if (mo3190j() != null) {
            mo482b();
            if (this.f1895n == null || this.f1895n.m1581a() == null) {
                view = this.f1892k;
                if (view != null) {
                    view = view.f1925e;
                    if (!(view == null || view.mo3193a(this) == null)) {
                        return;
                    }
                }
                if (this.f1899r != null) {
                    this.f1891j.startActivity(this.f1899r);
                }
            }
        }
    }

    public void mo489m() {
        if (!TextUtils.isEmpty(this.f1890i)) {
            Preference a = mo3184a(this.f1890i);
            if (a != null) {
                if (a.f1879K == null) {
                    a.f1879K = new ArrayList();
                }
                a.f1879K.add(this);
                mo504f(a.mo503d());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Dependency \"");
            stringBuilder.append(this.f1890i);
            stringBuilder.append("\" not found for preference \"");
            stringBuilder.append(this.f1898q);
            stringBuilder.append("\" (title: \"");
            stringBuilder.append(this.f1897p);
            stringBuilder.append("\"");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void mo490n() {
        if (this.f1890i != null) {
            Preference a = mo3184a(this.f1890i);
            if (!(a == null || a.f1879K == null)) {
                a.f1879K.remove(this);
            }
        }
        this.f1870B = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.f1897p;
        if (!TextUtils.isEmpty(charSequence)) {
            stringBuilder.append(charSequence);
            stringBuilder.append(' ');
        }
        charSequence = mo3187h();
        if (!TextUtils.isEmpty(charSequence)) {
            stringBuilder.append(charSequence);
            stringBuilder.append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
