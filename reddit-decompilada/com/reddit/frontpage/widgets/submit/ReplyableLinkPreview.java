package com.reddit.frontpage.widgets.submit;

import android.content.Context;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;

public class ReplyableLinkPreview extends ReplyablePreview<TextView> {
    public ReplyableLinkPreview(Context context) {
        super(context, (int) C1761R.layout.merge_replyable_link_preview, '\u0000');
    }

    public final void m30529a(Link link) {
        getReplyTargetView().setText(link.getTitle());
    }

    public final void m30530a(com.reddit.frontpage.domain.model.Link link) {
        getReplyTargetView().setText(link.getTitle());
    }
}
