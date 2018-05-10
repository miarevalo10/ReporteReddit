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
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {
    private static final int[] f11894a = new int[]{16843126};
    private final AppCompatBackgroundHelper f11895b;
    private final AppCompatTextHelper f11896c;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        context = TintTypedArray.m2308a(getContext(), attributeSet, f11894a, i, 0);
        if (context.m2322f(0)) {
            setDropDownBackgroundDrawable(context.m2311a(0));
        }
        context.f2595b.recycle();
        this.f11895b = new AppCompatBackgroundHelper(this);
        this.f11895b.m1795a(attributeSet, i);
        this.f11896c = AppCompatTextHelper.m1832a((TextView) this);
        this.f11896c.mo591a(attributeSet, i);
        this.f11896c.mo590a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11895b != null) {
            this.f11895b.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11895b != null) {
            this.f11895b.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11895b != null) {
            this.f11895b.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11895b != null ? this.f11895b.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11895b != null) {
            this.f11895b.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11895b != null ? this.f11895b.m1797c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11895b != null) {
            this.f11895b.m1798d();
        }
        if (this.f11896c != null) {
            this.f11896c.mo590a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f11896c != null) {
            this.f11896c.m1840a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1821a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
