package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SpanClickHandler {
    final View f24232a;
    Layout f24233b = null;
    float f24234c;
    float f24235d;
    HighlightedClickableSpan f24236e;

    public static void m25958a(TextView textView) {
        final SpanClickHandler spanClickHandler = new SpanClickHandler(textView);
        textView.setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                TextView textView = (TextView) view;
                Layout layout = textView.getLayout();
                if (layout == null) {
                    return false;
                }
                spanClickHandler.f24233b = layout;
                spanClickHandler.f24234c = (float) (textView.getTotalPaddingLeft() + textView.getScrollX());
                spanClickHandler.f24235d = (float) (textView.getTotalPaddingTop() + textView.getScrollY());
                view = spanClickHandler;
                CharSequence text = view.f24233b.getText();
                Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
                if (spanned != null) {
                    int action = motionEvent.getAction() & 255;
                    int x = (int) (motionEvent.getX() - view.f24234c);
                    motionEvent = (int) (motionEvent.getY() - view.f24235d);
                    if (x >= 0 && x < view.f24233b.getWidth() && motionEvent >= null) {
                        if (motionEvent < view.f24233b.getHeight()) {
                            motionEvent = view.f24233b.getLineForVertical(motionEvent);
                            float f = (float) x;
                            if (f >= view.f24233b.getLineLeft(motionEvent)) {
                                if (f <= view.f24233b.getLineRight(motionEvent)) {
                                    if (action == 0) {
                                        motionEvent = view.f24233b.getOffsetForHorizontal(motionEvent, f);
                                        HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(motionEvent, motionEvent, HighlightedClickableSpan.class);
                                        if (highlightedClickableSpanArr.length > 0) {
                                            motionEvent = highlightedClickableSpanArr[0];
                                            motionEvent.mo5509a(true);
                                            view.f24236e = motionEvent;
                                            view.m25961b();
                                            return true;
                                        }
                                    } else if (action == 1) {
                                        motionEvent = view.f24236e;
                                        if (motionEvent != null) {
                                            motionEvent.onClick(view.f24232a);
                                            view.m25960a();
                                            return true;
                                        }
                                    }
                                }
                            }
                            view.m25960a();
                        }
                    }
                    view.m25960a();
                }
                return false;
            }
        });
    }

    private SpanClickHandler(View view) {
        this.f24232a = view;
    }

    final void m25960a() {
        HighlightedClickableSpan highlightedClickableSpan = this.f24236e;
        if (highlightedClickableSpan != null && highlightedClickableSpan.mo5510a()) {
            highlightedClickableSpan.mo5509a(false);
            this.f24236e = null;
            m25961b();
        }
    }

    final void m25961b() {
        this.f24232a.invalidate((int) this.f24234c, (int) this.f24235d, ((int) this.f24234c) + this.f24233b.getWidth(), ((int) this.f24235d) + this.f24233b.getHeight());
    }
}
