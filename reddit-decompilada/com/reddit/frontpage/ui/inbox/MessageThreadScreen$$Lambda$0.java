package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class MessageThreadScreen$$Lambda$0 implements OnClickListener {
    private final MessageThreadScreen f21246a;
    private final Message f21247b;

    MessageThreadScreen$$Lambda$0(MessageThreadScreen messageThreadScreen, Message message) {
        this.f21246a = messageThreadScreen;
        this.f21247b = message;
    }

    public final void onClick(View view) {
        view = this.f21246a;
        view.a(IntentUtil.m23740a(view.am_(), this.f21247b));
    }
}
