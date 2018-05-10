package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView {
    private final AppCompatBackgroundHelper f11885b;
    private final AppCompatTextHelper f11886c;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.buttonStyle);
    }

    private AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        this.f11885b = new AppCompatBackgroundHelper(this);
        this.f11885b.m1795a(attributeSet, i);
        this.f11886c = AppCompatTextHelper.m1832a((TextView) this);
        this.f11886c.mo591a(attributeSet, i);
        this.f11886c.mo590a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11885b != null) {
            this.f11885b.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11885b != null) {
            this.f11885b.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11885b != null) {
            this.f11885b.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11885b != null ? this.f11885b.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11885b != null) {
            this.f11885b.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11885b != null ? this.f11885b.m1797c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11885b != null) {
            this.f11885b.m1798d();
        }
        if (this.f11886c != null) {
            this.f11886c.mo590a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f11886c != null) {
            this.f11886c.m1840a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @RequiresApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f11886c) {
            this.f11886c.m1845b();
        }
    }

    public void setTextSize(int i, float f) {
        if (a) {
            super.setTextSize(i, f);
            return;
        }
        if (this.f11886c != null) {
            this.f11886c.m1838a(i, f);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f11886c != null && a == null && this.f11886c.f2175b.m1854d() != null) {
            this.f11886c.f2175b.m1853c();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        if (this.f11886c != null) {
            this.f11886c.m1837a(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        if (this.f11886c != null) {
            this.f11886c.m1839a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        if (this.f11886c != null) {
            this.f11886c.m1844a(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        if (a) {
            if (super.getAutoSizeTextType() == 1) {
                return 1;
            }
            return 0;
        } else if (this.f11886c != null) {
            return this.f11886c.f2175b.f2185a;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (a) {
            return super.getAutoSizeStepGranularity();
        }
        return this.f11886c != null ? Math.round(this.f11886c.f2175b.f2187c) : -1;
    }

    public int getAutoSizeMinTextSize() {
        if (a) {
            return super.getAutoSizeMinTextSize();
        }
        return this.f11886c != null ? Math.round(this.f11886c.f2175b.f2188d) : -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (a) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.f11886c != null ? Math.round(this.f11886c.f2175b.f2189e) : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f11886c != null) {
            return this.f11886c.f2175b.f2190f;
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f11886c != null) {
            this.f11886c.m1843a(z);
        }
    }
}
