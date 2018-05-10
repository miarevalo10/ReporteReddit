package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView {
    private static final int[] f11882a = new int[]{16843126};
    private final AppCompatBackgroundHelper f11883b;
    private final AppCompatTextHelper f11884c;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        context = TintTypedArray.m2308a(getContext(), attributeSet, f11882a, i, 0);
        if (context.m2322f(0)) {
            setDropDownBackgroundDrawable(context.m2311a(0));
        }
        context.f2595b.recycle();
        this.f11883b = new AppCompatBackgroundHelper(this);
        this.f11883b.m1795a(attributeSet, i);
        this.f11884c = AppCompatTextHelper.m1832a((TextView) this);
        this.f11884c.mo591a(attributeSet, i);
        this.f11884c.mo590a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11883b != null) {
            this.f11883b.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11883b != null) {
            this.f11883b.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11883b != null) {
            this.f11883b.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11883b != null ? this.f11883b.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11883b != null) {
            this.f11883b.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11883b != null ? this.f11883b.m1797c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11883b != null) {
            this.f11883b.m1798d();
        }
        if (this.f11884c != null) {
            this.f11884c.mo590a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f11884c != null) {
            this.f11884c.m1840a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1821a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
