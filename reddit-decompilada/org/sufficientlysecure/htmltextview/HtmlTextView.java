package org.sufficientlysecure.htmltextview;

import android.content.Context;
import android.text.Html;
import android.text.Html.TagHandler;
import android.util.AttributeSet;
import java.util.Scanner;

public class HtmlTextView extends JellyBeanSpanFixTextView {
    private boolean f33455a = true;
    protected ClickableTableSpan f33456c;
    protected DrawTableLinkSpan f33457d;

    public HtmlTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HtmlTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HtmlTextView(Context context) {
        super(context);
    }

    public void setHtml(String str) {
        setHtml$353205f3(str);
    }

    private void setHtml$353205f3(String str) {
        TagHandler htmlTagHandler = new HtmlTagHandler(getPaint());
        htmlTagHandler.f27245e = this.f33456c;
        htmlTagHandler.f27246f = this.f33457d;
        str = HtmlTagHandler.m28724a(str);
        CharSequence charSequence = null;
        if (this.f33455a) {
            str = Html.fromHtml(str, null, htmlTagHandler);
            if (str != null) {
                charSequence = str;
                while (charSequence.length() > null && charSequence.charAt(charSequence.length() - 1) == 10) {
                    charSequence = charSequence.subSequence(null, charSequence.length() - 1);
                }
            }
            setText(charSequence);
        } else {
            setText(Html.fromHtml(str, null, htmlTagHandler));
        }
        setMovementMethod(LocalLinkMovementMethod.m28734a());
    }

    public void setRemoveTrailingWhiteSpace(boolean z) {
        this.f33455a = z;
    }

    @Deprecated
    public void setRemoveFromHtmlSpace(boolean z) {
        this.f33455a = z;
    }

    public void setClickableTableSpan(ClickableTableSpan clickableTableSpan) {
        this.f33456c = clickableTableSpan;
    }

    public void setDrawTableLinkSpan(DrawTableLinkSpan drawTableLinkSpan) {
        this.f33457d = drawTableLinkSpan;
    }

    public void setHtml(int i) {
        i = new Scanner(getContext().getResources().openRawResource(i)).useDelimiter("\\A");
        setHtml$353205f3(i.hasNext() ? i.next() : "");
    }
}
