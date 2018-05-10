package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.text.Html;
import android.text.SpannableStringBuilder;
import java.io.Serializable;

public class HtmlText extends SpannableStringBuilder implements Serializable {
    public static HtmlText m9386a(String str) {
        return new HtmlText(Html.fromHtml(str));
    }

    protected HtmlText() {
    }

    public HtmlText(CharSequence charSequence) {
        super(charSequence);
    }

    public static CharSequence m9387a(CharSequence charSequence, int i, int i2) {
        while (i < i2 && Character.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        while (i2 > i && Character.isWhitespace(charSequence.charAt(i2 - 1))) {
            i2--;
        }
        return charSequence.subSequence(i, i2);
    }
}
