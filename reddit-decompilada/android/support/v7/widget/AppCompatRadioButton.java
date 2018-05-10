package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {
    private final AppCompatCompoundButtonHelper f11897a;
    private final AppCompatTextHelper f11898b;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        this.f11897a = new AppCompatCompoundButtonHelper(this);
        this.f11897a.m1804a(attributeSet, i);
        this.f11898b = new AppCompatTextHelper(this);
        this.f11898b.mo591a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f11897a != null) {
            this.f11897a.m1801a();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f11897a != null ? this.f11897a.m1800a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f11897a != null) {
            this.f11897a.m1802a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f11897a != null ? this.f11897a.f2134a : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f11897a != null) {
            this.f11897a.m1803a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f11897a != null ? this.f11897a.f2135b : null;
    }
}
