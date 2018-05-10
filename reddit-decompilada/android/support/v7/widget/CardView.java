package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.C0165R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] f2198e = new int[]{16842801};
    private static final CardViewImpl f2199f;
    int f2200a;
    int f2201b;
    final Rect f2202c = new Rect();
    final Rect f2203d = new Rect();
    private boolean f2204g;
    private boolean f2205h;
    private final CardViewDelegate f2206i = new C10241(this);

    class C10241 implements CardViewDelegate {
        final /* synthetic */ CardView f11922a;
        private Drawable f11923b;

        C10241(CardView cardView) {
            this.f11922a = cardView;
        }

        public final void mo594a(Drawable drawable) {
            this.f11923b = drawable;
            this.f11922a.setBackgroundDrawable(drawable);
        }

        public final boolean mo595a() {
            return this.f11922a.getUseCompatPadding();
        }

        public final boolean mo596b() {
            return this.f11922a.getPreventCornerOverlap();
        }

        public final void mo593a(int i, int i2, int i3, int i4) {
            this.f11922a.f2203d.set(i, i2, i3, i4);
            super.setPadding(i + this.f11922a.f2202c.left, i2 + this.f11922a.f2202c.top, i3 + this.f11922a.f2202c.right, i4 + this.f11922a.f2202c.bottom);
        }

        public final void mo592a(int i, int i2) {
            if (i > this.f11922a.f2200a) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f11922a.f2201b) {
                super.setMinimumHeight(i2);
            }
        }

        public final Drawable mo597c() {
            return this.f11923b;
        }

        public final View mo598d() {
            return this.f11922a;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2199f = new CardViewApi21Impl();
        } else if (VERSION.SDK_INT >= 17) {
            f2199f = new CardViewApi17Impl();
        } else {
            f2199f = new CardViewBaseImpl();
        }
        f2199f.mo601a();
    }

    public CardView(Context context) {
        super(context);
        m1858a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1858a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1858a(context, attributeSet, i);
    }

    public boolean getUseCompatPadding() {
        return this.f2204g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2204g != z) {
            this.f2204g = z;
            f2199f.mo611f(this.f2206i);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (f2199f instanceof CardViewApi21Impl) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2199f.mo605b(this.f2206i)), MeasureSpec.getSize(i)), mode);
        }
        mode = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2199f.mo607c(this.f2206i)), MeasureSpec.getSize(i2)), mode);
        }
        super.onMeasure(i, i2);
    }

    private void m1858a(Context context, AttributeSet attributeSet, int i) {
        int color;
        attributeSet = context.obtainStyledAttributes(attributeSet, C0165R.styleable.CardView, i, C0165R.style.CardView);
        if (attributeSet.hasValue(C0165R.styleable.CardView_cardBackgroundColor) != 0) {
            i = attributeSet.getColorStateList(C0165R.styleable.CardView_cardBackgroundColor);
        } else {
            i = getContext().obtainStyledAttributes(f2198e);
            color = i.getColor(0, 0);
            i.recycle();
            i = new float[3];
            Color.colorToHSV(color, i);
            if (i[2] > 1056964608) {
                i = getResources().getColor(C0165R.color.cardview_light_background);
            } else {
                i = getResources().getColor(C0165R.color.cardview_dark_background);
            }
            i = ColorStateList.valueOf(i);
        }
        ColorStateList colorStateList = i;
        float dimension = attributeSet.getDimension(C0165R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = attributeSet.getDimension(C0165R.styleable.CardView_cardElevation, 0.0f);
        i = attributeSet.getDimension(C0165R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f2204g = attributeSet.getBoolean(C0165R.styleable.CardView_cardUseCompatPadding, false);
        this.f2205h = attributeSet.getBoolean(C0165R.styleable.CardView_cardPreventCornerOverlap, true);
        color = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_contentPadding, 0);
        this.f2202c.left = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_contentPaddingLeft, color);
        this.f2202c.top = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_contentPaddingTop, color);
        this.f2202c.right = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_contentPaddingRight, color);
        this.f2202c.bottom = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_contentPaddingBottom, color);
        float f = dimension2 > i ? dimension2 : i;
        this.f2200a = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_android_minWidth, 0);
        this.f2201b = attributeSet.getDimensionPixelSize(C0165R.styleable.CardView_android_minHeight, 0);
        attributeSet.recycle();
        f2199f.mo603a(this.f2206i, context, colorStateList, dimension, dimension2, f);
    }

    public void setMinimumWidth(int i) {
        this.f2200a = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f2201b = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f2199f.mo604a(this.f2206i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2199f.mo604a(this.f2206i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2199f.mo613h(this.f2206i);
    }

    public int getContentPaddingLeft() {
        return this.f2202c.left;
    }

    public int getContentPaddingRight() {
        return this.f2202c.right;
    }

    public int getContentPaddingTop() {
        return this.f2202c.top;
    }

    public int getContentPaddingBottom() {
        return this.f2202c.bottom;
    }

    public void setRadius(float f) {
        f2199f.mo602a(this.f2206i, f);
    }

    public float getRadius() {
        return f2199f.mo609d(this.f2206i);
    }

    public void setCardElevation(float f) {
        f2199f.mo608c(this.f2206i, f);
    }

    public float getCardElevation() {
        return f2199f.mo610e(this.f2206i);
    }

    public void setMaxCardElevation(float f) {
        f2199f.mo606b(this.f2206i, f);
    }

    public float getMaxCardElevation() {
        return f2199f.mo600a(this.f2206i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2205h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2205h) {
            this.f2205h = z;
            f2199f.mo612g(this.f2206i);
        }
    }
}
