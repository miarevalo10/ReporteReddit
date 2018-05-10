package com.reddit.frontpage.ui.inbox;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class MessageThreadScreen_ViewBinding implements Unbinder {
    private MessageThreadScreen f29004b;

    public MessageThreadScreen_ViewBinding(MessageThreadScreen messageThreadScreen, View view) {
        this.f29004b = messageThreadScreen;
        messageThreadScreen.messageList = (RecyclerView) Utils.b(view, C1761R.id.message_list, "field 'messageList'", RecyclerView.class);
        messageThreadScreen.replyButton = (TextView) Utils.b(view, C1761R.id.reply_to_message_button, "field 'replyButton'", TextView.class);
    }

    public final void m30069a() {
        MessageThreadScreen messageThreadScreen = this.f29004b;
        if (messageThreadScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29004b = null;
        messageThreadScreen.messageList = null;
        messageThreadScreen.replyButton = null;
    }
}
