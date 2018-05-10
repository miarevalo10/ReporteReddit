package org.sufficientlysecure.htmltextview;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.span.UrlToNativeWebViewSpan;

public class RedditLinkMovementMethod extends LinkMovementMethod {
    static RedditLinkMovementMethod f27254a;

    public static RedditLinkMovementMethod m28735a() {
        if (f27254a == null) {
            f27254a = new RedditLinkMovementMethod();
        }
        return f27254a;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
        }
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        y = layout.getLineForVertical(y);
        float f = (float) x;
        int offsetForHorizontal = layout.getOffsetForHorizontal(y, f);
        if (offsetForHorizontal != layout.getOffsetForHorizontal(y, 2.14748365E9f) || f <= layout.getLineRight(y)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                if ((textView instanceof BaseHtmlTextView) != null) {
                    ((BaseHtmlTextView) textView).f34501a = true;
                }
                if ((clickableSpanArr[0] instanceof UrlToNativeWebViewSpan) != null) {
                    ((BaseHtmlTextView) textView).f34502b = ((UrlToNativeWebViewSpan) clickableSpanArr[0]).getURL();
                }
                return true;
            }
            Touch.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }
}
