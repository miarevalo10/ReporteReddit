package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SwitchPreferenceCompat extends TwoStatePreference {
    private final Listener f16592c;
    private CharSequence f16593d;
    private CharSequence f16594e;

    private class Listener implements OnCheckedChangeListener {
        final /* synthetic */ SwitchPreferenceCompat f1937a;

        private Listener(SwitchPreferenceCompat switchPreferenceCompat) {
            this.f1937a = switchPreferenceCompat;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f1937a.m1600a((Object) Boolean.valueOf(z))) {
                this.f1937a.mo504f(z);
            } else {
                compoundButton.setChecked(z ^ 1);
            }
        }
    }

    private SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16592c = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.SwitchPreferenceCompat, i, 0);
        m10390c(TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.SwitchPreferenceCompat_summaryOn, C0177R.styleable.SwitchPreferenceCompat_android_summaryOn));
        m10391d(TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.SwitchPreferenceCompat_summaryOff, C0177R.styleable.SwitchPreferenceCompat_android_summaryOff));
        this.f16593d = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.SwitchPreferenceCompat_switchTextOn, C0177R.styleable.SwitchPreferenceCompat_android_switchTextOn);
        mo3849c();
        this.f16594e = TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.SwitchPreferenceCompat_switchTextOff, C0177R.styleable.SwitchPreferenceCompat_android_switchTextOff);
        mo3849c();
        this.f11672b = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.SwitchPreferenceCompat_disableDependentsState, C0177R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
    }

    private SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0177R.attr.switchPreferenceCompatStyle, (byte) 0);
    }

    public final void mo500a(PreferenceViewHolder preferenceViewHolder) {
        super.mo500a(preferenceViewHolder);
        m16805c(preferenceViewHolder.m10369a(C0177R.id.switchWidget));
        m10388b(preferenceViewHolder);
    }

    protected final void mo3183a(View view) {
        super.mo3183a(view);
        if (((AccessibilityManager) this.f1891j.getSystemService("accessibility")).isEnabled()) {
            m16805c(view.findViewById(C0177R.id.switchWidget));
            m10389b(view.findViewById(16908304));
        }
    }

    private void m16805c(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.a);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f16593d);
            switchCompat.setTextOff(this.f16594e);
            switchCompat.setOnCheckedChangeListener(this.f16592c);
        }
    }
}
