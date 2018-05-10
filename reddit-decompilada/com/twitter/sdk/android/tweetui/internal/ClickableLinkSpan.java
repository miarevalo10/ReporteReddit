package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class ClickableLinkSpan extends ClickableSpan implements HighlightedClickableSpan {
    private final int f30786a;
    private final boolean f30787b;
    public final int f30788c;
    private final boolean f30789d;
    private boolean f30790e;

    public ClickableLinkSpan(int i, int i2) {
        this(i, i2, (byte) 0);
    }

    private ClickableLinkSpan(int i, int i2, byte b) {
        this.f30786a = i;
        this.f30788c = i2;
        this.f30787b = true;
        this.f30789d = false;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (this.f30787b) {
            textPaint.setColor(this.f30788c);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.f30790e) {
            textPaint.bgColor = this.f30786a;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.f30789d) {
            textPaint.setUnderlineText(true);
        }
    }

    public final void mo5509a(boolean z) {
        this.f30790e = z;
    }

    public final boolean mo5510a() {
        return this.f30790e;
    }
}
