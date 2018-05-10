package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ToggleImageButton extends ImageButton {
    private static final int[] f24202e = new int[]{C2075R.attr.state_toggled_on};
    boolean f24203a;
    String f24204b;
    String f24205c;
    final boolean f24206d;

    public ToggleImageButton(Context context) {
        this(context, null);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C2075R.styleable.ToggleImageButton, i, 0);
            try {
                attributeSet = context.getString(C2075R.styleable.ToggleImageButton_contentDescriptionOn);
                i = context.getString(C2075R.styleable.ToggleImageButton_contentDescriptionOff);
                if (attributeSet == null) {
                    attributeSet = (String) getContentDescription();
                }
                this.f24204b = attributeSet;
                if (i == 0) {
                    i = (String) getContentDescription();
                }
                this.f24205c = i;
                this.f24206d = context.getBoolean(C2075R.styleable.ToggleImageButton_toggleOnClick, 1);
                setToggledOn(false);
                if (context != null) {
                    context.recycle();
                }
            } catch (Throwable th) {
                attributeSet = th;
                if (context != null) {
                    context.recycle();
                }
                throw attributeSet;
            }
        } catch (Throwable th2) {
            attributeSet = th2;
            context = null;
            if (context != null) {
                context.recycle();
            }
            throw attributeSet;
        }
    }

    public int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 2);
        if (this.f24203a) {
            mergeDrawableStates(i, f24202e);
        }
        return i;
    }

    public boolean performClick() {
        if (this.f24206d) {
            setToggledOn(this.f24203a ^ 1);
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z) {
        this.f24203a = z;
        setContentDescription(z ? this.f24204b : this.f24205c);
        refreshDrawableState();
    }
}
