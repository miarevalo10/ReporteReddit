package com.reddit.frontpage.widgets.submit;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class ReplyableMessagePreview extends ReplyablePreview<BaseHtmlTextView> {
    public ReplyableMessagePreview(Context context) {
        super(context, (int) C1761R.layout.merge_replyable_message_preview, '\u0000');
    }

    public final void m30531a(Message message) {
        ((BaseHtmlTextView) getReplyTargetView()).setHtmlFromString(message.body_html);
    }
}
