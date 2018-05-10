package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.widget.TextView;

@RequiresApi(17)
class AppCompatTextHelperV17 extends AppCompatTextHelper {
    private TintInfo f11918c;
    private TintInfo f11919d;

    AppCompatTextHelperV17(TextView textView) {
        super(textView);
    }

    final void mo591a(AttributeSet attributeSet, int i) {
        super.mo591a(attributeSet, i);
        Context context = this.a.getContext();
        AppCompatDrawableManager a = AppCompatDrawableManager.m1809a();
        attributeSet = context.obtainStyledAttributes(attributeSet, C0164R.styleable.AppCompatTextHelper, i, 0);
        if (attributeSet.hasValue(C0164R.styleable.AppCompatTextHelper_android_drawableStart) != 0) {
            this.f11918c = AppCompatTextHelper.m1833a(context, a, attributeSet.getResourceId(C0164R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (attributeSet.hasValue(C0164R.styleable.AppCompatTextHelper_android_drawableEnd) != 0) {
            this.f11919d = AppCompatTextHelper.m1833a(context, a, attributeSet.getResourceId(C0164R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        attributeSet.recycle();
    }

    final void mo590a() {
        super.mo590a();
        if (this.f11918c != null || this.f11919d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m1841a(compoundDrawablesRelative[0], this.f11918c);
            m1841a(compoundDrawablesRelative[2], this.f11919d);
        }
    }
}
