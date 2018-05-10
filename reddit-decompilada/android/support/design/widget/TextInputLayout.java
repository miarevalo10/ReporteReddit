package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0016R;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.WithHint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class TextInputLayout extends LinearLayout implements WithHint {
    private boolean f11138A;
    private Drawable f11139B;
    private Drawable f11140C;
    private ColorStateList f11141D;
    private boolean f11142E;
    private Mode f11143F;
    private boolean f11144G;
    private ColorStateList f11145H;
    private ColorStateList f11146I;
    private boolean f11147J;
    private boolean f11148K;
    private ValueAnimator f11149L;
    private boolean f11150M;
    private boolean f11151N;
    private boolean f11152O;
    EditText f11153a;
    TextView f11154b;
    boolean f11155c;
    final CollapsingTextHelper f11156d;
    private final FrameLayout f11157e;
    private CharSequence f11158f;
    private boolean f11159g;
    private CharSequence f11160h;
    private Paint f11161i;
    private final Rect f11162j;
    private LinearLayout f11163k;
    private int f11164l;
    private Typeface f11165m;
    private boolean f11166n;
    private int f11167o;
    private boolean f11168p;
    private CharSequence f11169q;
    private TextView f11170r;
    private int f11171s;
    private int f11172t;
    private int f11173u;
    private boolean f11174v;
    private boolean f11175w;
    private Drawable f11176x;
    private CharSequence f11177y;
    private CheckableImageButton f11178z;

    class C00421 implements TextWatcher {
        final /* synthetic */ TextInputLayout f691a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C00421(TextInputLayout textInputLayout) {
            this.f691a = textInputLayout;
        }

        public void afterTextChanged(Editable editable) {
            this.f691a.m9633a(this.f691a.f11152O ^ 1, false);
            if (this.f691a.f11155c) {
                this.f691a.m9632a(editable.length());
            }
        }
    }

    class C00432 extends AnimatorListenerAdapter {
        final /* synthetic */ TextInputLayout f692a;

        C00432(TextInputLayout textInputLayout) {
            this.f692a = textInputLayout;
        }

        public void onAnimationStart(Animator animator) {
            this.f692a.f11154b.setVisibility(0);
        }
    }

    class C00454 implements OnClickListener {
        final /* synthetic */ TextInputLayout f695a;

        C00454(TextInputLayout textInputLayout) {
            this.f695a = textInputLayout;
        }

        public void onClick(View view) {
            this.f695a.m9624a(false);
        }
    }

    class C00465 implements AnimatorUpdateListener {
        final /* synthetic */ TextInputLayout f696a;

        C00465(TextInputLayout textInputLayout) {
            this.f696a = textInputLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f696a.f11156d.m202a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C00471();
        CharSequence f11135a;
        boolean f11136b;

        static class C00471 implements ClassLoaderCreator<SavedState> {
            C00471() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11135a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            classLoader = true;
            if (parcel.readInt() != 1) {
                classLoader = null;
            }
            this.f11136b = classLoader;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f11135a, parcel, i);
            parcel.writeInt(this.f11136b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("TextInputLayout.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" error=");
            stringBuilder.append(this.f11135a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ TextInputLayout f11137a;

        TextInputAccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f11137a = textInputLayout;
        }

        public final void mo84a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo84a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void mo122b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo122b(view, accessibilityEvent);
            view = this.f11137a.f11156d.f500i;
            if (!TextUtils.isEmpty(view)) {
                accessibilityEvent.getText().add(view);
            }
        }

        public final void mo38a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo38a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m1324a(TextInputLayout.class.getSimpleName());
            view = this.f11137a.f11156d.f500i;
            if (!TextUtils.isEmpty(view)) {
                accessibilityNodeInfoCompat.f1523a.setText(view);
            }
            if (this.f11137a.f11153a != null) {
                view = this.f11137a.f11153a;
                if (VERSION.SDK_INT >= 17) {
                    accessibilityNodeInfoCompat.f1523a.setLabelFor(view);
                }
            }
            view = this.f11137a.f11154b != null ? this.f11137a.f11154b.getText() : null;
            if (!TextUtils.isEmpty(view)) {
                if (VERSION.SDK_INT >= 19) {
                    accessibilityNodeInfoCompat.f1523a.setContentInvalid(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    accessibilityNodeInfoCompat.f1523a.setError(view);
                }
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f11162j = new Rect();
        this.f11156d = new CollapsingTextHelper(this);
        ThemeUtils.m333a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f11157e = new FrameLayout(context);
        this.f11157e.setAddStatesFromChildren(true);
        addView(this.f11157e);
        this.f11156d.m208a(AnimationUtils.f407b);
        CollapsingTextHelper collapsingTextHelper = this.f11156d;
        collapsingTextHelper.f501j = new AccelerateInterpolator();
        collapsingTextHelper.m211b();
        this.f11156d.m212b(8388659);
        context = TintTypedArray.m2308a(context, attributeSet, C0016R.styleable.TextInputLayout, i, C0016R.style.Widget_Design_TextInputLayout);
        this.f11159g = context.m2312a(C0016R.styleable.TextInputLayout_hintEnabled, true);
        setHint(context.m2316c(C0016R.styleable.TextInputLayout_android_hint));
        this.f11148K = context.m2312a(C0016R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (context.m2322f(C0016R.styleable.TextInputLayout_android_textColorHint) != null) {
            attributeSet = context.m2320e(C0016R.styleable.TextInputLayout_android_textColorHint);
            this.f11146I = attributeSet;
            this.f11145H = attributeSet;
        }
        if (context.m2323g(C0016R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(context.m2323g(C0016R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.f11167o = context.m2323g(C0016R.styleable.TextInputLayout_errorTextAppearance, 0);
        attributeSet = context.m2312a(C0016R.styleable.TextInputLayout_errorEnabled, false);
        boolean a = context.m2312a(C0016R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(context.m2310a(C0016R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f11172t = context.m2323g(C0016R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.f11173u = context.m2323g(C0016R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f11175w = context.m2312a(C0016R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.f11176x = context.m2311a(C0016R.styleable.TextInputLayout_passwordToggleDrawable);
        this.f11177y = context.m2316c(C0016R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (context.m2322f(C0016R.styleable.TextInputLayout_passwordToggleTint)) {
            this.f11142E = true;
            this.f11141D = context.m2320e(C0016R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (context.m2322f(C0016R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.f11144G = true;
            this.f11143F = ViewUtils.m357a(context.m2310a(C0016R.styleable.TextInputLayout_passwordToggleTintMode, -1));
        }
        context.f2595b.recycle();
        setErrorEnabled(attributeSet);
        setCounterEnabled(a);
        m9631f();
        if (ViewCompat.m1237d(this) == null) {
            ViewCompat.m1214a((View) this, 1);
        }
        ViewCompat.m1220a((View) this, new TextInputAccessibilityDelegate(this));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            i = new FrameLayout.LayoutParams(layoutParams);
            i.gravity = 16 | (i.gravity & -113);
            this.f11157e.addView(view, i);
            this.f11157e.setLayoutParams(layoutParams);
            m9619a();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if ((this.f11165m != null && !this.f11165m.equals(typeface)) || (this.f11165m == null && typeface != null)) {
            this.f11165m = typeface;
            this.f11156d.m207a(typeface);
            if (this.f11170r != null) {
                this.f11170r.setTypeface(typeface);
            }
            if (this.f11154b != null) {
                this.f11154b.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.f11165m;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f11158f != null) {
            if (this.f11153a != null) {
                CharSequence hint = this.f11153a.getHint();
                this.f11153a.setHint(this.f11158f);
                try {
                    super.dispatchProvideAutofillStructure(viewStructure, i);
                    return;
                } finally {
                    this.f11153a.setHint(hint);
                }
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    private void setEditText(EditText editText) {
        if (this.f11153a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f11153a = editText;
        if (m9630e() == null) {
            this.f11156d.m207a(this.f11153a.getTypeface());
        }
        editText = this.f11156d;
        float textSize = this.f11153a.getTextSize();
        if (editText.f495d != textSize) {
            editText.f495d = textSize;
            editText.m211b();
        }
        int gravity = this.f11153a.getGravity();
        this.f11156d.m212b(48 | (gravity & -113));
        this.f11156d.m203a(gravity);
        this.f11153a.addTextChangedListener(new C00421(this));
        if (this.f11145H == null) {
            this.f11145H = this.f11153a.getHintTextColors();
        }
        if (!(this.f11159g == null || TextUtils.isEmpty(this.f11160h) == null)) {
            this.f11158f = this.f11153a.getHint();
            setHint(this.f11158f);
            this.f11153a.setHint(null);
        }
        if (this.f11170r != null) {
            m9632a(this.f11153a.getText().length());
        }
        if (this.f11163k != null) {
            m9626b();
        }
        m9629d();
        m9633a((boolean) null, true);
    }

    private void m9619a() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11157e.getLayoutParams();
        if (this.f11159g) {
            if (this.f11161i == null) {
                this.f11161i = new Paint();
            }
            this.f11161i.setTypeface(this.f11156d.m201a());
            this.f11161i.setTextSize(this.f11156d.f496e);
            i = (int) (-this.f11161i.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.f11157e.requestLayout();
        }
    }

    final void m9633a(boolean z, boolean z2) {
        boolean z3;
        boolean isEnabled = isEnabled();
        boolean z4 = (this.f11153a == null || TextUtils.isEmpty(this.f11153a.getText())) ? false : true;
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        int isEmpty = TextUtils.isEmpty(getError()) ^ 1;
        if (this.f11145H != null) {
            this.f11156d.m214b(this.f11145H);
        }
        if (isEnabled && this.f11174v && this.f11170r != null) {
            this.f11156d.m205a(this.f11170r.getTextColors());
        } else if (isEnabled && z3 && this.f11146I != null) {
            this.f11156d.m205a(this.f11146I);
        } else if (this.f11145H != null) {
            this.f11156d.m205a(this.f11145H);
        }
        if (!z4) {
            if (isEnabled()) {
                if (!z3) {
                    if (isEmpty != 0) {
                    }
                }
            }
            if (z2 || !this.f11147J) {
                if (this.f11149L && this.f11149L.isRunning()) {
                    this.f11149L.cancel();
                }
                if (z && this.f11148K) {
                    m9620a(0.0f);
                } else {
                    this.f11156d.m202a(0.0f);
                }
                this.f11147J = true;
            }
            return;
        }
        if (!z2) {
            if (this.f11147J) {
            }
            return;
        }
        if (this.f11149L && this.f11149L.isRunning()) {
            this.f11149L.cancel();
        }
        if (z && this.f11148K) {
            m9620a(1.0f);
        } else {
            this.f11156d.m202a(1.0f);
        }
        this.f11147J = false;
    }

    public EditText getEditText() {
        return this.f11153a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f11159g) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(MPEGConst.CODE_END);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f11160h = charSequence;
        this.f11156d.m209a(charSequence);
    }

    public CharSequence getHint() {
        return this.f11159g ? this.f11160h : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f11159g) {
            this.f11159g = z;
            z = this.f11153a.getHint();
            if (!this.f11159g) {
                if (!TextUtils.isEmpty(this.f11160h) && TextUtils.isEmpty(z)) {
                    this.f11153a.setHint(this.f11160h);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(z)) {
                if (TextUtils.isEmpty(this.f11160h)) {
                    setHint(z);
                }
                this.f11153a.setHint(null);
            }
            if (this.f11153a) {
                m9619a();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f11156d.m215c(i);
        this.f11146I = this.f11156d.f497f;
        if (this.f11153a != 0) {
            m9633a(false, false);
            m9619a();
        }
    }

    private void m9623a(TextView textView, int i) {
        if (this.f11163k == null) {
            this.f11163k = new LinearLayout(getContext());
            this.f11163k.setOrientation(0);
            addView(this.f11163k, -1, -2);
            this.f11163k.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f11153a != null) {
                m9626b();
            }
        }
        this.f11163k.setVisibility(0);
        this.f11163k.addView(textView, i);
        this.f11164l++;
    }

    private void m9626b() {
        ViewCompat.m1215a(this.f11163k, ViewCompat.m1248i(this.f11153a), 0, ViewCompat.m1249j(this.f11153a), this.f11153a.getPaddingBottom());
    }

    private void m9622a(TextView textView) {
        if (this.f11163k != null) {
            this.f11163k.removeView(textView);
            textView = this.f11164l - 1;
            this.f11164l = textView;
            if (textView == null) {
                this.f11163k.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.f11166n;
        if (r0 == r5) goto L_0x0088;
    L_0x0004:
        r0 = r4.f11154b;
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r4.f11154b;
        r0 = r0.animate();
        r0.cancel();
    L_0x0011:
        r0 = 0;
        if (r5 == 0) goto L_0x0079;
    L_0x0014:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r2 = r4.getContext();
        r1.<init>(r2);
        r4.f11154b = r1;
        r1 = r4.f11154b;
        r2 = android.support.design.C0016R.id.textinput_error;
        r1.setId(r2);
        r1 = r4.f11165m;
        if (r1 == 0) goto L_0x0031;
    L_0x002a:
        r1 = r4.f11154b;
        r2 = r4.f11165m;
        r1.setTypeface(r2);
    L_0x0031:
        r1 = 1;
        r2 = r4.f11154b;	 Catch:{ Exception -> 0x0050 }
        r3 = r4.f11167o;	 Catch:{ Exception -> 0x0050 }
        android.support.v4.widget.TextViewCompat.m1429a(r2, r3);	 Catch:{ Exception -> 0x0050 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0050 }
        r3 = 23;	 Catch:{ Exception -> 0x0050 }
        if (r2 < r3) goto L_0x004f;	 Catch:{ Exception -> 0x0050 }
    L_0x003f:
        r2 = r4.f11154b;	 Catch:{ Exception -> 0x0050 }
        r2 = r2.getTextColors();	 Catch:{ Exception -> 0x0050 }
        r2 = r2.getDefaultColor();	 Catch:{ Exception -> 0x0050 }
        r3 = -65281; // 0xffffffffffff00ff float:NaN double:NaN;
        if (r2 != r3) goto L_0x004f;
    L_0x004e:
        goto L_0x0050;
    L_0x004f:
        r1 = r0;
    L_0x0050:
        if (r1 == 0) goto L_0x0068;
    L_0x0052:
        r1 = r4.f11154b;
        r2 = android.support.v7.appcompat.C0164R.style.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.TextViewCompat.m1429a(r1, r2);
        r1 = r4.f11154b;
        r2 = r4.getContext();
        r3 = android.support.v7.appcompat.C0164R.color.error_color_material;
        r2 = android.support.v4.content.ContextCompat.m719c(r2, r3);
        r1.setTextColor(r2);
    L_0x0068:
        r1 = r4.f11154b;
        r2 = 4;
        r1.setVisibility(r2);
        r1 = r4.f11154b;
        android.support.v4.view.ViewCompat.m1246h(r1);
        r1 = r4.f11154b;
        r4.m9623a(r1, r0);
        goto L_0x0086;
    L_0x0079:
        r4.f11168p = r0;
        r4.m9628c();
        r0 = r4.f11154b;
        r4.m9622a(r0);
        r0 = 0;
        r4.f11154b = r0;
    L_0x0086:
        r4.f11166n = r5;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(int i) {
        this.f11167o = i;
        if (this.f11154b != null) {
            TextViewCompat.m1429a(this.f11154b, i);
        }
    }

    public void setError(final CharSequence charSequence) {
        boolean z = ViewCompat.m1206G(this) && isEnabled() && (this.f11154b == null || !TextUtils.equals(this.f11154b.getText(), charSequence));
        this.f11169q = charSequence;
        if (!this.f11166n) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.f11168p = true ^ TextUtils.isEmpty(charSequence);
        this.f11154b.animate().cancel();
        if (this.f11168p) {
            this.f11154b.setText(charSequence);
            this.f11154b.setVisibility(0);
            if (z) {
                if (this.f11154b.getAlpha() == 1.0f) {
                    this.f11154b.setAlpha(0.0f);
                }
                this.f11154b.animate().alpha(1.0f).setDuration(200).setInterpolator(AnimationUtils.f409d).setListener(new C00432(this)).start();
            } else {
                this.f11154b.setAlpha(1.0f);
            }
        } else if (this.f11154b.getVisibility() == 0) {
            if (z) {
                this.f11154b.animate().alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.f408c).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ TextInputLayout f694b;

                    public void onAnimationEnd(Animator animator) {
                        this.f694b.f11154b.setText(charSequence);
                        this.f694b.f11154b.setVisibility(4);
                    }
                }).start();
            } else {
                this.f11154b.setText(charSequence);
                this.f11154b.setVisibility(4);
            }
        }
        m9628c();
        m9633a(z, false);
    }

    public void setCounterEnabled(boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.f11155c;
        if (r0 == r4) goto L_0x006e;
    L_0x0004:
        if (r4 == 0) goto L_0x0064;
    L_0x0006:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r1 = r3.getContext();
        r0.<init>(r1);
        r3.f11170r = r0;
        r0 = r3.f11170r;
        r1 = android.support.design.C0016R.id.textinput_counter;
        r0.setId(r1);
        r0 = r3.f11165m;
        if (r0 == 0) goto L_0x0023;
    L_0x001c:
        r0 = r3.f11170r;
        r1 = r3.f11165m;
        r0.setTypeface(r1);
    L_0x0023:
        r0 = r3.f11170r;
        r1 = 1;
        r0.setMaxLines(r1);
        r0 = r3.f11170r;	 Catch:{ Exception -> 0x0031 }
        r1 = r3.f11172t;	 Catch:{ Exception -> 0x0031 }
        android.support.v4.widget.TextViewCompat.m1429a(r0, r1);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0047;
    L_0x0031:
        r0 = r3.f11170r;
        r1 = android.support.v7.appcompat.C0164R.style.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.TextViewCompat.m1429a(r0, r1);
        r0 = r3.f11170r;
        r1 = r3.getContext();
        r2 = android.support.v7.appcompat.C0164R.color.error_color_material;
        r1 = android.support.v4.content.ContextCompat.m719c(r1, r2);
        r0.setTextColor(r1);
    L_0x0047:
        r0 = r3.f11170r;
        r1 = -1;
        r3.m9623a(r0, r1);
        r0 = r3.f11153a;
        if (r0 != 0) goto L_0x0056;
    L_0x0051:
        r0 = 0;
        r3.m9632a(r0);
        goto L_0x006c;
    L_0x0056:
        r0 = r3.f11153a;
        r0 = r0.getText();
        r0 = r0.length();
        r3.m9632a(r0);
        goto L_0x006c;
    L_0x0064:
        r0 = r3.f11170r;
        r3.m9622a(r0);
        r0 = 0;
        r3.f11170r = r0;
    L_0x006c:
        r3.f11155c = r4;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setCounterEnabled(boolean):void");
    }

    public void setCounterMaxLength(int i) {
        if (this.f11171s != i) {
            if (i > 0) {
                this.f11171s = i;
            } else {
                this.f11171s = -1;
            }
            if (this.f11155c != 0) {
                m9632a(this.f11153a == 0 ? 0 : this.f11153a.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        m9621a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    private static void m9621a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m9621a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f11171s;
    }

    final void m9632a(int i) {
        boolean z = this.f11174v;
        if (this.f11171s == -1) {
            this.f11170r.setText(String.valueOf(i));
            this.f11174v = false;
        } else {
            this.f11174v = i > this.f11171s;
            if (z != this.f11174v) {
                TextViewCompat.m1429a(this.f11170r, this.f11174v ? this.f11173u : this.f11172t);
            }
            this.f11170r.setText(getContext().getString(C0016R.string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f11171s)}));
        }
        if (this.f11153a != 0 && z != this.f11174v) {
            m9633a(false, false);
            m9628c();
        }
    }

    private void m9628c() {
        if (this.f11153a != null) {
            Drawable background = this.f11153a.getBackground();
            if (background != null) {
                int i = VERSION.SDK_INT;
                if (i == 21 || i == 22) {
                    Drawable background2 = this.f11153a.getBackground();
                    if (!(background2 == null || this.f11150M)) {
                        Drawable newDrawable = background2.getConstantState().newDrawable();
                        if (background2 instanceof DrawableContainer) {
                            this.f11150M = DrawableUtils.m252a((DrawableContainer) background2, newDrawable.getConstantState());
                        }
                        if (!this.f11150M) {
                            ViewCompat.m1219a(this.f11153a, newDrawable);
                            this.f11150M = true;
                        }
                    }
                }
                if (DrawableUtils.m1960c(background)) {
                    background = background.mutate();
                }
                if (this.f11168p && this.f11154b != null) {
                    background.setColorFilter(AppCompatDrawableManager.m1807a(this.f11154b.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.f11174v || this.f11170r == null) {
                    DrawableCompat.m843f(background);
                    this.f11153a.refreshDrawableState();
                } else {
                    background.setColorFilter(AppCompatDrawableManager.m1807a(this.f11170r.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.f11168p) {
            savedState.f11135a = getError();
        }
        savedState.f11136b = this.f11138A;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setError(savedState.f11135a);
            if (savedState.f11136b != null) {
                m9624a(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f11152O = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f11152O = null;
    }

    public CharSequence getError() {
        return this.f11166n ? this.f11169q : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f11148K = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f11159g) {
            this.f11156d.m206a(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        m9629d();
        super.onMeasure(i, i2);
    }

    private void m9629d() {
        if (this.f11153a != null) {
            int i = (this.f11175w && (m9630e() || this.f11138A)) ? 1 : false;
            Drawable[] b;
            if (i != 0) {
                if (this.f11178z == null) {
                    this.f11178z = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C0016R.layout.design_text_input_password_icon, this.f11157e, false);
                    this.f11178z.setImageDrawable(this.f11176x);
                    this.f11178z.setContentDescription(this.f11177y);
                    this.f11157e.addView(this.f11178z);
                    this.f11178z.setOnClickListener(new C00454(this));
                }
                if (this.f11153a != null && ViewCompat.m1253n(this.f11153a) <= 0) {
                    this.f11153a.setMinimumHeight(ViewCompat.m1253n(this.f11178z));
                }
                this.f11178z.setVisibility(0);
                this.f11178z.setChecked(this.f11138A);
                if (this.f11139B == null) {
                    this.f11139B = new ColorDrawable();
                }
                this.f11139B.setBounds(0, 0, this.f11178z.getMeasuredWidth(), 1);
                b = TextViewCompat.m1431b(this.f11153a);
                if (b[2] != this.f11139B) {
                    this.f11140C = b[2];
                }
                TextViewCompat.m1430a(this.f11153a, b[0], b[1], this.f11139B, b[3]);
                this.f11178z.setPadding(this.f11153a.getPaddingLeft(), this.f11153a.getPaddingTop(), this.f11153a.getPaddingRight(), this.f11153a.getPaddingBottom());
                return;
            }
            if (this.f11178z != null && this.f11178z.getVisibility() == 0) {
                this.f11178z.setVisibility(8);
            }
            if (this.f11139B != null) {
                b = TextViewCompat.m1431b(this.f11153a);
                if (b[2] == this.f11139B) {
                    TextViewCompat.m1430a(this.f11153a, b[0], b[1], this.f11140C, b[3]);
                    this.f11139B = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.m1570b(getContext(), i) : 0);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f11176x = drawable;
        if (this.f11178z != null) {
            this.f11178z.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : 0);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f11177y = charSequence;
        if (this.f11178z != null) {
            this.f11178z.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f11176x;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f11177y;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.f11175w != z) {
            this.f11175w = z;
            if (!z && this.f11138A && this.f11153a) {
                this.f11153a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f11138A = false;
            m9629d();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f11141D = colorStateList;
        this.f11142E = true;
        m9631f();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.f11143F = mode;
        this.f11144G = true;
        m9631f();
    }

    private void m9624a(boolean z) {
        if (this.f11175w) {
            int selectionEnd = this.f11153a.getSelectionEnd();
            if (m9630e()) {
                this.f11153a.setTransformationMethod(null);
                this.f11138A = true;
            } else {
                this.f11153a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f11138A = false;
            }
            this.f11178z.setChecked(this.f11138A);
            if (z) {
                this.f11178z.jumpDrawablesToCurrentState();
            }
            this.f11153a.setSelection(selectionEnd);
        }
    }

    private boolean m9630e() {
        return this.f11153a != null && (this.f11153a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void m9631f() {
        if (this.f11176x == null) {
            return;
        }
        if (this.f11142E || this.f11144G) {
            this.f11176x = DrawableCompat.m844g(this.f11176x).mutate();
            if (this.f11142E) {
                DrawableCompat.m833a(this.f11176x, this.f11141D);
            }
            if (this.f11144G) {
                DrawableCompat.m836a(this.f11176x, this.f11143F);
            }
            if (this.f11178z != null && this.f11178z.getDrawable() != this.f11176x) {
                this.f11178z.setImageDrawable(this.f11176x);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f11159g && this.f11153a) {
            Rect rect = this.f11162j;
            ViewGroupUtils.m352a((ViewGroup) this, this.f11153a, rect);
            i = rect.left + this.f11153a.getCompoundPaddingLeft();
            i3 = rect.right - this.f11153a.getCompoundPaddingRight();
            this.f11156d.m204a(i, rect.top + this.f11153a.getCompoundPaddingTop(), i3, rect.bottom - this.f11153a.getCompoundPaddingBottom());
            this.f11156d.m213b(i, getPaddingTop(), i3, (i4 - i2) - getPaddingBottom());
            this.f11156d.m211b();
        }
    }

    protected void drawableStateChanged() {
        if (!this.f11151N) {
            boolean z = true;
            this.f11151N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!ViewCompat.m1206G(this) || !isEnabled()) {
                z = false;
            }
            m9633a(z, false);
            m9628c();
            if ((this.f11156d != null ? this.f11156d.m210a(drawableState) | 0 : 0) != 0) {
                invalidate();
            }
            this.f11151N = false;
        }
    }

    private void m9620a(float f) {
        if (this.f11156d.f492a != f) {
            if (this.f11149L == null) {
                this.f11149L = new ValueAnimator();
                this.f11149L.setInterpolator(AnimationUtils.f406a);
                this.f11149L.setDuration(200);
                this.f11149L.addUpdateListener(new C00465(this));
            }
            this.f11149L.setFloatValues(new float[]{this.f11156d.f492a, f});
            this.f11149L.start();
        }
    }
}
