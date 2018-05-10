package com.reddit.frontpage.widgets.span;

import android.text.style.ClickableSpan;
import android.view.View;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;

public class SpoilerSpan extends ClickableSpan {
    private final String f22026a;

    public SpoilerSpan(String str) {
        this.f22026a = str;
    }

    public void onClick(View view) {
        RedditAlertDialog redditAlertDialog = new RedditAlertDialog(view.getContext(), (byte) 0);
        redditAlertDialog.f21113a.b(this.f22026a);
        redditAlertDialog.m23323a();
    }
}
