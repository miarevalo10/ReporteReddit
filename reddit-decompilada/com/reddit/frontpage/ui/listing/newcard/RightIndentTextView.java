package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public class RightIndentTextView extends AppCompatTextView {
    private int f34386b;
    private int f34387c;
    private RightIndentMarginSpan f34388d;
    private int f34389e;
    private int f34390f;
    private int f34391g;

    private class RightIndentMarginSpan implements LeadingMarginSpan2 {
        int f21366a;
        final /* synthetic */ RightIndentTextView f21367b;
        private int f21368c;

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        }

        private RightIndentMarginSpan(RightIndentTextView rightIndentTextView) {
            this.f21367b = rightIndentTextView;
        }

        public int getLeadingMarginLineCount() {
            return this.f21368c;
        }

        public int getLeadingMargin(boolean z) {
            return (!z || this.f21368c > false) ? false : this.f21366a;
        }
    }

    public RightIndentTextView(Context context) {
        super(context);
    }

    public RightIndentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightIndentTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f34390f = getPaddingRight();
    }

    public void setIndentMargin(int i) {
        this.f34386b = i;
    }

    public void setIndentHeight(int i) {
        this.f34387c = i;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                if (!(charSequence instanceof Spannable)) {
                    charSequence = new SpannableString(charSequence);
                }
                Spannable spannable = (Spannable) charSequence;
                int i = 1;
                RightIndentMarginSpan[] rightIndentMarginSpanArr = (RightIndentMarginSpan[]) spannable.getSpans(0, 1, RightIndentMarginSpan.class);
                if (rightIndentMarginSpanArr.length == 0) {
                    TextPaint paint = getPaint();
                    FontMetrics fontMetrics = paint.getFontMetrics();
                    float f = fontMetrics.descent - fontMetrics.ascent;
                    float f2 = getIncludeFontPadding() ? fontMetrics.ascent - fontMetrics.top : 0.0f;
                    int ceil = (int) Math.ceil((double) ((((float) (this.f34387c + this.f34391g)) - f2) / f));
                    this.f34388d = new RightIndentMarginSpan();
                    if (ceil != 0) {
                        if (ceil < TextViewCompat.a(this)) {
                            this.f34388d.f21368c = ceil;
                            this.f34389e = (int) Math.ceil((double) ((((float) ceil) * paint.getFontSpacing()) + f2));
                            this.f34388d.f21366a = this.f34386b;
                            spannable.setSpan(this.f34388d, 0, spannable.length(), 18);
                        }
                    }
                    this.f34389e = 0;
                    spannable.setSpan(this.f34388d, 0, spannable.length(), 18);
                } else {
                    this.f34388d = rightIndentMarginSpanArr[0];
                }
                if (this.f34387c <= 0 || this.f34388d == null || this.f34388d.f21368c != 0) {
                    i = 0;
                }
                if (i != 0) {
                    super.setPadding(getPaddingLeft(), getPaddingTop(), this.f34390f + this.f34386b, getPaddingBottom());
                } else {
                    super.setPadding(getPaddingLeft(), getPaddingTop(), this.f34390f, getPaddingBottom());
                }
                super.setText(charSequence, bufferType);
                return;
            }
        }
        super.setText(charSequence, bufferType);
        this.f34388d = null;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f34390f = i3;
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        if (this.f34389e > 0) {
            canvas.save();
            canvas.translate((float) (-this.f34386b), 0.0f);
            canvas.clipRect(0, 0, RedditJobManager.f10810d, this.f34389e);
            super.onDraw(canvas);
            canvas.restore();
        }
        if (this.f34389e < height) {
            canvas.save();
            canvas.clipRect(0, this.f34389e, getWidth(), getHeight());
            super.onDraw(canvas);
            canvas.restore();
        }
    }
}
