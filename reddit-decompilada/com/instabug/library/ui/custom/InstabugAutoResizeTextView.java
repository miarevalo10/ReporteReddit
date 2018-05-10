package com.instabug.library.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class InstabugAutoResizeTextView extends TextView {
    private static final int NO_LINE_LIMIT = -1;
    private final RectF _availableSpaceRect;
    private boolean _initialized;
    private int _maxLines;
    private float _maxTextSize;
    private float _minTextSize;
    private TextPaint _paint;
    private final SizeTester _sizeTester;
    private float _spacingAdd;
    private float _spacingMult;
    private int _widthLimit;

    private interface SizeTester {
        int onTestSize(int i, RectF rectF);
    }

    class C13981 implements SizeTester {
        final RectF textRect = new RectF();

        C13981() {
        }

        @TargetApi(16)
        public int onTestSize(int i, RectF rectF) {
            InstabugAutoResizeTextView.this._paint.setTextSize((float) i);
            i = InstabugAutoResizeTextView.this.getTransformationMethod();
            if (i != 0) {
                i = i.getTransformation(InstabugAutoResizeTextView.this.getText(), InstabugAutoResizeTextView.this).toString();
            } else {
                i = InstabugAutoResizeTextView.this.getText().toString();
            }
            int i2 = 0;
            if ((InstabugAutoResizeTextView.this.getMaxLines() == 1 ? 1 : 0) != 0) {
                this.textRect.bottom = InstabugAutoResizeTextView.this._paint.getFontSpacing();
                this.textRect.right = InstabugAutoResizeTextView.this._paint.measureText(i);
            } else {
                StaticLayout staticLayout = new StaticLayout(i, InstabugAutoResizeTextView.this._paint, InstabugAutoResizeTextView.this._widthLimit, Alignment.ALIGN_NORMAL, InstabugAutoResizeTextView.this._spacingMult, InstabugAutoResizeTextView.this._spacingAdd, true);
                if (InstabugAutoResizeTextView.this.getMaxLines() != -1 && staticLayout.getLineCount() > InstabugAutoResizeTextView.this.getMaxLines()) {
                    return 1;
                }
                this.textRect.bottom = (float) staticLayout.getHeight();
                int lineCount = staticLayout.getLineCount();
                int i3 = -1;
                while (i2 < lineCount) {
                    int lineEnd = staticLayout.getLineEnd(i2);
                    if (i2 < lineCount - 1 && lineEnd > 0) {
                        lineEnd--;
                        if (lineEnd < i.length() && !InstabugAutoResizeTextView.this.isValidWordWrap(i.charAt(lineEnd))) {
                            return 1;
                        }
                    }
                    if (((float) i3) < staticLayout.getLineRight(i2) - staticLayout.getLineLeft(i2)) {
                        i3 = ((int) staticLayout.getLineRight(i2)) - ((int) staticLayout.getLineLeft(i2));
                    }
                    i2++;
                }
                this.textRect.right = (float) i3;
            }
            this.textRect.offsetTo(0.0f, 0.0f);
            return rectF.contains(this.textRect) != 0 ? -1 : 1;
        }
    }

    public boolean isValidWordWrap(char c) {
        if (!(c == ' ' || c == '-')) {
            if (c != '\n') {
                return false;
            }
        }
        return true;
    }

    public InstabugAutoResizeTextView(Context context) {
        this(context, null, 16842884);
    }

    public InstabugAutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public InstabugAutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._availableSpaceRect = new RectF();
        this._spacingMult = 1.0f;
        this._spacingAdd = null;
        this._initialized = null;
        this._minTextSize = TypedValue.applyDimension(2, 1094713344, getResources().getDisplayMetrics());
        this._maxTextSize = getTextSize();
        this._paint = new TextPaint(getPaint());
        if (this._maxLines == null) {
            this._maxLines = -1;
        }
        this._sizeTester = new C13981();
        this._initialized = true;
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        adjustTextSize();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        adjustTextSize();
    }

    public void setTextSize(float f) {
        this._maxTextSize = f;
        adjustTextSize();
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this._maxLines = i;
        adjustTextSize();
    }

    public int getMaxLines() {
        return this._maxLines;
    }

    public void setSingleLine() {
        super.setSingleLine();
        this._maxLines = 1;
        adjustTextSize();
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        if (z) {
            this._maxLines = true;
        } else {
            this._maxLines = true;
        }
        adjustTextSize();
    }

    public void setLines(int i) {
        super.setLines(i);
        this._maxLines = i;
        adjustTextSize();
    }

    public void setTextSize(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        this._maxTextSize = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        adjustTextSize();
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this._spacingMult = f2;
        this._spacingAdd = f;
    }

    public void setMinTextSize(float f) {
        this._minTextSize = f;
        adjustTextSize();
    }

    private void adjustTextSize() {
        if (this._initialized) {
            int i = (int) this._minTextSize;
            int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
            this._widthLimit = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            if (this._widthLimit > 0) {
                this._paint = new TextPaint(getPaint());
                this._availableSpaceRect.right = (float) this._widthLimit;
                this._availableSpaceRect.bottom = (float) measuredHeight;
                superSetTextSize(i);
            }
        }
    }

    private void superSetTextSize(int i) {
        super.setTextSize(0, (float) binarySearch(i, (int) this._maxTextSize, this._sizeTester, this._availableSpaceRect));
    }

    private int binarySearch(int i, int i2, SizeTester sizeTester, RectF rectF) {
        i2--;
        int i3 = i;
        while (i <= i2) {
            i3 = (i + i2) >>> 1;
            int onTestSize = sizeTester.onTestSize(i3, rectF);
            if (onTestSize < 0) {
                int i4 = i3 + 1;
                i3 = i;
                i = i4;
            } else if (onTestSize <= 0) {
                return i3;
            } else {
                i3--;
                i2 = i3;
            }
        }
        return i3;
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        adjustTextSize();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            adjustTextSize();
        }
    }
}
