package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;

public class AppCompatEditText extends EditText implements TintableBackgroundView {
    private final AppCompatBackgroundHelper f11888a;
    private final AppCompatTextHelper f11889b;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        this.f11888a = new AppCompatBackgroundHelper(this);
        this.f11888a.m1795a(attributeSet, i);
        this.f11889b = AppCompatTextHelper.m1832a((TextView) this);
        this.f11889b.mo591a(attributeSet, i);
        this.f11889b.mo590a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11888a != null) {
            this.f11888a.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11888a != null) {
            this.f11888a.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11888a != null) {
            this.f11888a.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11888a != null ? this.f11888a.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11888a != null) {
            this.f11888a.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11888a != null ? this.f11888a.m1797c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11888a != null) {
            this.f11888a.m1798d();
        }
        if (this.f11889b != null) {
            this.f11889b.mo590a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f11889b != null) {
            this.f11889b.m1840a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1821a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
