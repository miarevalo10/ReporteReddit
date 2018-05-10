package android.support.v7.widget;

import android.content.Context;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] f2132a = new int[]{16843016};
    private final AppCompatTextHelper f2133b;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private AppCompatCheckedTextView(Context context, AttributeSet attributeSet, byte b) {
        super(TintContextWrapper.m2304a(context), attributeSet, 16843720);
        this.f2133b = AppCompatTextHelper.m1832a((TextView) this);
        this.f2133b.mo591a(attributeSet, 16843720);
        this.f2133b.mo590a();
        context = TintTypedArray.m2308a(getContext(), attributeSet, f2132a, 16843720, 0);
        setCheckMarkDrawable(context.m2311a(0));
        context.f2595b.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(AppCompatResources.m1570b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2133b != null) {
            this.f2133b.m1840a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2133b != null) {
            this.f2133b.mo590a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1821a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
