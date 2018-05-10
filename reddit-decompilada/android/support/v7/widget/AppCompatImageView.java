package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TintableImageSourceView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper f11892a;
    private final AppCompatImageHelper f11893b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m2304a(context), attributeSet, i);
        this.f11892a = new AppCompatBackgroundHelper(this);
        this.f11892a.m1795a(attributeSet, i);
        this.f11893b = new AppCompatImageHelper(this);
        this.f11893b.m1825a(attributeSet, i);
    }

    public void setImageResource(int i) {
        if (this.f11893b != null) {
            this.f11893b.m1822a(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f11893b != null) {
            this.f11893b.m1829d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f11893b != null) {
            this.f11893b.m1829d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f11893b != null) {
            this.f11893b.m1829d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f11892a != null) {
            this.f11892a.m1792a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f11892a != null) {
            this.f11892a.m1791a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f11892a != null) {
            this.f11892a.m1793a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f11892a != null ? this.f11892a.m1796b() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f11892a != null) {
            this.f11892a.m1794a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f11892a != null ? this.f11892a.m1797c() : null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f11893b != null) {
            this.f11893b.m1823a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f11893b != null ? this.f11893b.m1827b() : null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f11893b != null) {
            this.f11893b.m1824a(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        return this.f11893b != null ? this.f11893b.m1828c() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11892a != null) {
            this.f11892a.m1798d();
        }
        if (this.f11893b != null) {
            this.f11893b.m1829d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f11893b.m1826a() && super.hasOverlappingRendering();
    }
}
