package com.instabug.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.instabug.library.C0593R;
import com.instabug.library.settings.C0754a;

public class IconView extends TextView {
    private Typeface f9908a;
    int f9909g;
    float f9910h;
    int f9911i;
    Paint f9912j;

    public IconView(Context context) {
        this(context, null);
    }

    public IconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9909g = 0;
        this.f9910h = 0.0f;
        this.f9911i = 0;
        if (isInEditMode() == 0) {
            if (this.f9908a == 0) {
                this.f9908a = Typeface.createFromAsset(context.getAssets(), "font_icons.ttf");
            }
            setTypeface(this.f9908a);
            context = context.obtainStyledAttributes(attributeSet, C0593R.styleable.IconView);
            if (context.hasValue(C0593R.styleable.IconView_android_textSize) == null) {
                setTextSize(1, 24.0f);
            }
            if (context.hasValue(C0593R.styleable.IconView_android_padding) == null) {
                setPadding(ViewUtils.convertDpToPx(getContext(), 1.0f));
            }
            if (context.hasValue(C0593R.styleable.IconView_android_textColor) == null) {
                setTextColor(C0754a.m8316b().f9859d);
            }
            attributeSet = context.getInt(C0593R.styleable.IconView_instabug_icon, -1);
            if (attributeSet != -1) {
                setText(C0779a.m8368a(attributeSet));
            }
            context.recycle();
            this.f9912j = new Paint(1);
        }
    }

    public void setPadding(int i) {
        setPadding(i, i, i, i);
    }

    public void setBackgroundColor(int i) {
        this.f9909g = i;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f9910h = f;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f9911i = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.f9912j.setColor(this.f9909g);
        this.f9912j.setStyle(Style.FILL);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, Math.min(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f) - (this.f9910h / 2.0f), this.f9912j);
        this.f9912j.setStrokeWidth(this.f9910h);
        this.f9912j.setColor(this.f9911i);
        this.f9912j.setStyle(Style.STROKE);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, Math.min(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f) - (this.f9910h / 2.0f), this.f9912j);
        super.onDraw(canvas);
    }
}
