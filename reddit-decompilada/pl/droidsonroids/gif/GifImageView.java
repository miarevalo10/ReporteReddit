package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView extends ImageView {
    private boolean f41193a;

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43249a(GifViewUtils.m43274a(this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m43249a(GifViewUtils.m43274a(this, attributeSet, i, null));
    }

    @RequiresApi(21)
    public GifImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m43249a(GifViewUtils.m43274a(this, attributeSet, i, i2));
    }

    private void m43249a(GifImageViewAttributes gifImageViewAttributes) {
        this.f41193a = gifImageViewAttributes.c;
        if (gifImageViewAttributes.f41569a > 0) {
            super.setImageResource(gifImageViewAttributes.f41569a);
        }
        if (gifImageViewAttributes.f41570b > 0) {
            super.setBackgroundResource(gifImageViewAttributes.f41570b);
        }
    }

    public void setImageURI(Uri uri) {
        if (!GifViewUtils.m43276a((ImageView) this, uri)) {
            super.setImageURI(uri);
        }
    }

    public void setImageResource(int i) {
        if (!GifViewUtils.m43277a(this, true, i)) {
            super.setImageResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        if (!GifViewUtils.m43277a(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.f41193a ? getDrawable() : null;
        if (this.f41193a) {
            drawable = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable2, drawable);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof GifViewSavedState) {
            GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
            super.onRestoreInstanceState(gifViewSavedState.getSuperState());
            gifViewSavedState.m43272a(getDrawable(), 0);
            gifViewSavedState.m43272a(getBackground(), 1);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setFreezesAnimation(boolean z) {
        this.f41193a = z;
    }
}
