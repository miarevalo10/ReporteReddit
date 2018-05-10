package com.instabug.chat.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.instabug.library.C0593R;

public class CircularImageView extends ImageView {
    private static final ScaleType f9345a = ScaleType.CENTER_CROP;
    private static final Config f9346b = Config.ARGB_8888;
    private final RectF f9347c;
    private final RectF f9348d;
    private final Matrix f9349e;
    private final Paint f9350f;
    private final Paint f9351g;
    private final Paint f9352h;
    private int f9353i;
    private int f9354j;
    private int f9355k;
    private Bitmap f9356l;
    private BitmapShader f9357m;
    private int f9358n;
    private int f9359o;
    private float f9360p;
    private float f9361q;
    private ColorFilter f9362r;
    private boolean f9363s;
    private boolean f9364t;
    private boolean f9365u;

    public CircularImageView(Context context) {
        super(context);
        this.f9347c = new RectF();
        this.f9348d = new RectF();
        this.f9349e = new Matrix();
        this.f9350f = new Paint();
        this.f9351g = new Paint();
        this.f9352h = new Paint();
        this.f9353i = -16777216;
        this.f9354j = 0;
        this.f9355k = 0;
        m7992a();
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9347c = new RectF();
        this.f9348d = new RectF();
        this.f9349e = new Matrix();
        this.f9350f = new Paint();
        this.f9351g = new Paint();
        this.f9352h = new Paint();
        this.f9353i = -16777216;
        this.f9354j = 0;
        this.f9355k = 0;
        context = context.obtainStyledAttributes(attributeSet, C0593R.styleable.CircleImageView, i, 0);
        this.f9354j = context.getDimensionPixelSize(C0593R.styleable.CircleImageView_ibg_civ_border_width, 0);
        this.f9353i = context.getColor(C0593R.styleable.CircleImageView_ibg_civ_border_color, -16777216);
        this.f9365u = context.getBoolean(C0593R.styleable.CircleImageView_ibg_civ_border_overlay, false);
        this.f9355k = context.getColor(C0593R.styleable.CircleImageView_ibg_civ_fill_color, 0);
        context.recycle();
        m7992a();
    }

    private void m7992a() {
        super.setScaleType(f9345a);
        this.f9363s = true;
        if (this.f9364t) {
            m7993b();
            this.f9364t = false;
        }
    }

    public ScaleType getScaleType() {
        return f9345a;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f9345a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f9356l != null) {
            if (this.f9355k != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f9360p, this.f9352h);
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f9360p, this.f9350f);
            if (this.f9354j != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f9361q, this.f9351g);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m7993b();
    }

    public int getBorderColor() {
        return this.f9353i;
    }

    public void setBorderColor(int i) {
        if (i != this.f9353i) {
            this.f9353i = i;
            this.f9351g.setColor(this.f9353i);
            invalidate();
        }
    }

    public void setBorderColorResource(int i) {
        setBorderColor(getContext().getResources().getColor(i));
    }

    public int getFillColor() {
        return this.f9355k;
    }

    public void setFillColor(int i) {
        if (i != this.f9355k) {
            this.f9355k = i;
            this.f9352h.setColor(i);
            invalidate();
        }
    }

    public void setFillColorResource(int i) {
        setFillColor(getContext().getResources().getColor(i));
    }

    public int getBorderWidth() {
        return this.f9354j;
    }

    public void setBorderWidth(int i) {
        if (i != this.f9354j) {
            this.f9354j = i;
            m7993b();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.f9365u) {
            this.f9365u = z;
            m7993b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f9356l = bitmap;
        m7993b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f9356l = m7991a(drawable);
        m7993b();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f9356l = m7991a(getDrawable());
        m7993b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f9356l = uri != null ? m7991a(getDrawable()) : null;
        m7993b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.f9362r) {
            this.f9362r = colorFilter;
            this.f9350f.setColorFilter(this.f9362r);
            invalidate();
        }
    }

    private static Bitmap m7991a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f9346b);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f9346b);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Drawable drawable2) {
            drawable2.printStackTrace();
            return null;
        }
    }

    private void m7993b() {
        if (!this.f9363s) {
            this.f9364t = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f9356l == null) {
                invalidate();
                return;
            }
            float height;
            float width;
            this.f9357m = new BitmapShader(this.f9356l, TileMode.CLAMP, TileMode.CLAMP);
            this.f9350f.setAntiAlias(true);
            this.f9350f.setShader(this.f9357m);
            this.f9351g.setStyle(Style.STROKE);
            this.f9351g.setAntiAlias(true);
            this.f9351g.setColor(this.f9353i);
            this.f9351g.setStrokeWidth((float) this.f9354j);
            this.f9352h.setStyle(Style.FILL);
            this.f9352h.setAntiAlias(true);
            this.f9352h.setColor(this.f9355k);
            this.f9359o = this.f9356l.getHeight();
            this.f9358n = this.f9356l.getWidth();
            float f = 0.0f;
            this.f9348d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f9361q = Math.min((this.f9348d.height() - ((float) this.f9354j)) / 2.0f, (this.f9348d.width() - ((float) this.f9354j)) / 2.0f);
            this.f9347c.set(this.f9348d);
            if (!this.f9365u) {
                this.f9347c.inset((float) this.f9354j, (float) this.f9354j);
            }
            this.f9360p = Math.min(this.f9347c.height() / 2.0f, this.f9347c.width() / 2.0f);
            this.f9349e.set(null);
            if (((float) this.f9358n) * this.f9347c.height() > this.f9347c.width() * ((float) this.f9359o)) {
                height = this.f9347c.height() / ((float) this.f9359o);
                width = (this.f9347c.width() - (((float) this.f9358n) * height)) * 0.5f;
            } else {
                height = this.f9347c.width() / ((float) this.f9358n);
                f = (this.f9347c.height() - (((float) this.f9359o) * height)) * 0.5f;
                width = 0.0f;
            }
            this.f9349e.setScale(height, height);
            this.f9349e.postTranslate(((float) ((int) (width + 0.5f))) + this.f9347c.left, ((float) ((int) (f + 0.5f))) + this.f9347c.top);
            this.f9357m.setLocalMatrix(this.f9349e);
            invalidate();
        }
    }
}
