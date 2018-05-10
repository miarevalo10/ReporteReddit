package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxPreference extends TwoStatePreference {
    private final Listener f16571c;

    private class Listener implements OnCheckedChangeListener {
        final /* synthetic */ CheckBoxPreference f1864a;

        private Listener(CheckBoxPreference checkBoxPreference) {
            this.f1864a = checkBoxPreference;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f1864a.m1600a((Object) Boolean.valueOf(z))) {
                this.f1864a.mo504f(z);
            } else {
                compoundButton.setChecked(z ^ 1);
            }
        }
    }

    private CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private CheckBoxPreference(Context context, AttributeSet attributeSet, int i, byte b) {
        super(context, attributeSet, i);
        this.f16571c = new Listener();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0177R.styleable.CheckBoxPreference, i, 0);
        m10390c(TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.CheckBoxPreference_summaryOn, C0177R.styleable.CheckBoxPreference_android_summaryOn));
        m10391d(TypedArrayUtils.m789c(obtainStyledAttributes, C0177R.styleable.CheckBoxPreference_summaryOff, C0177R.styleable.CheckBoxPreference_android_summaryOff));
        this.f11672b = TypedArrayUtils.m783a(obtainStyledAttributes, C0177R.styleable.CheckBoxPreference_disableDependentsState, C0177R.styleable.CheckBoxPreference_android_disableDependentsState, false);
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m776a(context, C0177R.attr.checkBoxPreferenceStyle, 16842895));
    }

    public final void mo500a(PreferenceViewHolder preferenceViewHolder) {
        super.mo500a(preferenceViewHolder);
        m16768c(preferenceViewHolder.m10369a(16908289));
        m10388b(preferenceViewHolder);
    }

    protected final void mo3183a(View view) {
        super.mo3183a(view);
        if (((AccessibilityManager) this.f1891j.getSystemService("accessibility")).isEnabled()) {
            m16768c(view.findViewById(16908289));
            m10389b(view.findViewById(16908304));
        }
    }

    private void m16768c(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.a);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f16571c);
        }
    }
}
