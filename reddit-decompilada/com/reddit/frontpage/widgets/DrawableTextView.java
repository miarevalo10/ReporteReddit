package com.reddit.frontpage.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.reddit.frontpage.C1761R;

@Deprecated
public class DrawableTextView extends AppCompatTextView {
    private int f34517b;
    private int f34518c;
    private boolean f34519d;

    public DrawableTextView(Context context) {
        this(context, null);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34519d = false;
        context = context.obtainStyledAttributes(attributeSet, C1761R.styleable.DrawableTextView, i, 0);
        try {
            this.f34517b = context.getDimensionPixelSize(1, -1);
            this.f34518c = context.getDimensionPixelSize(0, -1);
            this.f34519d = true;
            m35290a();
        } finally {
            context.recycle();
        }
    }

    public void setCompoundDrawableSize(int i) {
        this.f34517b = i;
        this.f34518c = i;
        m35290a();
    }

    public void setCompoundDrawableWidth(int i) {
        this.f34517b = i;
        m35290a();
    }

    public int getCompoundDrawableWidth() {
        return this.f34517b;
    }

    public void setCompoundDrawableHeight(int i) {
        this.f34518c = i;
        m35290a();
    }

    public int getCompoundDrawableHeight() {
        return this.f34518c;
    }

    private void m35290a() {
        if (this.f34519d) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            if (this.f34517b > 0 || this.f34518c > 0) {
                for (Drawable drawable : compoundDrawablesRelative) {
                    if (drawable != null) {
                        Rect bounds = drawable.getBounds();
                        float height = ((float) bounds.height()) / ((float) bounds.width());
                        float width = (float) bounds.width();
                        float height2 = (float) bounds.height();
                        if (this.f34517b > 0 && this.f34518c > 0) {
                            if (width > 0.0f || height2 > 0.0f) {
                                if (width > ((float) this.f34517b)) {
                                    width = (float) this.f34517b;
                                    height2 = width * height;
                                }
                                if (height2 > ((float) this.f34518c)) {
                                    height2 = (float) this.f34518c;
                                    width = height2 / height;
                                }
                            } else {
                                width = (float) this.f34517b;
                                height2 = (float) this.f34518c;
                            }
                        }
                        bounds.right = bounds.left + Math.round(width);
                        bounds.bottom = bounds.top + Math.round(height2);
                        drawable.setBounds(bounds);
                    }
                }
            }
            super.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        m35290a();
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        m35290a();
    }
}
