package com.reddit.frontpage.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.sufficientlysecure.htmltextview.ClickableTableSpan;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;

public class RedditHtml {
    private static ThreadLocal<Parser> f21786a = new ThreadLocal();

    private static class HtmlParser {
        private static final HTMLSchema f21785a = new HTMLSchema();
    }

    private static Parser m23881a() {
        Parser parser = (Parser) f21786a.get();
        if (parser == null) {
            parser = new Parser();
            try {
                parser.setProperty("http://www.ccil.org/~cowan/tagsoup/properties/schema", HtmlParser.f21785a);
                f21786a.set(parser);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return parser;
    }

    public static Spanned m23880a(Context context, String str, ClickableTableSpan clickableTableSpan, DrawTableLinkSpan drawTableLinkSpan) {
        context = new HtmlToSpannedConverter(context, str, m23881a(), clickableTableSpan, drawTableLinkSpan).m23718a();
        str = context.length();
        if (str == null) {
            return context;
        }
        clickableTableSpan = null;
        drawTableLinkSpan = str - 1;
        while (drawTableLinkSpan >= null && context.charAt(drawTableLinkSpan) == '\n') {
            clickableTableSpan++;
            drawTableLinkSpan--;
        }
        return clickableTableSpan > null ? ((SpannableStringBuilder) context).delete(str - clickableTableSpan, str) : context;
    }
}
