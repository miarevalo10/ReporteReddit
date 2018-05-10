package com.reddit.frontpage.widgets.span;

import android.app.Activity;
import android.net.Uri;
import android.text.style.URLSpan;
import android.view.View;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.util.IntentUtil;

public class UrlToNativeWebViewSpan extends URLSpan {
    public UrlToNativeWebViewSpan(String str) {
        super(str);
    }

    public void onClick(View view) {
        view = view.getContext();
        if (view instanceof Activity) {
            view.startActivity(IntentUtil.m23752a(m24227a(getURL()).toString()));
        }
    }

    public static Uri m24227a(String str) {
        if (!str.startsWith(Operation.DIVISION)) {
            return Uri.parse(str);
        }
        Uri parse = Uri.parse(String.format("reddit://reddit%s", new Object[]{str}));
        if (!(parse.getPathSegments().indexOf("wiki") == 2 || parse.getPathSegments().indexOf("w") == 2)) {
            if (parse.getPathSegments().indexOf("about") != 2) {
                return parse;
            }
        }
        return Uri.parse(String.format("https://reddit.com%s", new Object[]{str}));
    }
}
