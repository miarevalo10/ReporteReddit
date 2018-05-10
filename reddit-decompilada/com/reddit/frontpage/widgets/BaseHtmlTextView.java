package com.reddit.frontpage.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.detail.CommentPresentationModel;
import com.reddit.frontpage.util.RedditHtml;
import com.reddit.frontpage.widgets.span.ClickableTableSpanImpl;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.sufficientlysecure.htmltextview.HtmlTextView;
import org.sufficientlysecure.htmltextview.RedditLinkMovementMethod;

public class BaseHtmlTextView extends HtmlTextView {
    public boolean f34501a = false;
    public String f34502b;
    private OnUriClickListener f34503e;
    private CommentPresentationModel f34504f;

    public BaseHtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35289a(context);
    }

    public BaseHtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35289a(context);
    }

    public BaseHtmlTextView(Context context) {
        super(context);
        m35289a(context);
    }

    public void setHtmlFromString(String str) {
        if (str.startsWith("&lt;")) {
            str = Html.fromHtml(str).toString();
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) RedditHtml.m23880a(getContext(), str, this.c, this.d);
        if (VERSION.SDK_INT < 26) {
            setTypeface(ResourcesCompat.a(getContext(), C1761R.font.rdt_regular));
        }
        setText(spannableStringBuilder);
        if (getLinksClickable() != null) {
            setMovementMethod(RedditLinkMovementMethod.m28735a());
        }
    }

    public void setHtmlFromSpanned(Spanned spanned) {
        setText(spanned);
        if (getLinksClickable() != null) {
            setMovementMethod(RedditLinkMovementMethod.m28735a());
        }
    }

    public void setHtmlLinksClickable(boolean z) {
        setLinksClickable(z);
        if (z) {
            setMovementMethod(RedditLinkMovementMethod.m28735a());
        } else {
            setMovementMethod(false);
        }
    }

    public void setOnUriClickListener(OnUriClickListener onUriClickListener) {
        this.f34503e = onUriClickListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        boolean z = this.f34501a;
        this.f34501a = false;
        if (z && this.f34502b != null && this.f34503e != null && motionEvent.getAction() == 1) {
            if (this.f34504f != null) {
                OutboundLinkTracker.m21950a(this.f34502b, this.f34504f, null);
            }
            this.f34503e.mo4969a(this.f34502b);
            this.f34502b = null;
        }
        if (!z) {
            if (isTextSelectable() == null) {
                return false;
            }
        }
        return true;
    }

    private void m35289a(Context context) {
        setClickableTableSpan(new ClickableTableSpanImpl());
        DrawTableLinkSpan drawTableLinkSpan = new DrawTableLinkSpan();
        drawTableLinkSpan.m28722a(context.getString(C1761R.string.html_table_link));
        drawTableLinkSpan.m28721a(ResourcesUtil.m22740i(context, C1761R.attr.rdt_link_text_color));
        setDrawTableLinkSpan(drawTableLinkSpan);
    }
}
