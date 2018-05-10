package org.sufficientlysecure.htmltextview;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class LocalLinkMovementMethod extends LinkMovementMethod {
    static LocalLinkMovementMethod f27251a;

    public static LocalLinkMovementMethod m28734a() {
        if (f27251a == null) {
            f27251a = new LocalLinkMovementMethod();
        }
        return f27251a;
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
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
        if (clickableSpanArr.length != 0) {
            if (action == 1) {
                clickableSpanArr[0].onClick(textView);
            } else if (action == 0) {
                Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
            }
            return true;
        }
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }
}
