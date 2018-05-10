package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.submit.ReplyableMessagePreview;

public class MessageReplyFragment extends ReplyFragmentLegacy {
    public final int mo7473c() {
        return C1761R.string.title_reply_to_message;
    }

    protected final int mo7474d() {
        return C1761R.string.hint_compose_message;
    }

    protected final int mo7475e() {
        return C1761R.string.discard_message;
    }

    protected final int mo7486f() {
        return C1761R.string.action_send;
    }

    public static MessageReplyFragment m41132a(Message message) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("message", message);
        message = new MessageReplyFragment();
        message.setArguments(bundle);
        return message;
    }

    public final View mo7471a() {
        View replyableMessagePreview = new ReplyableMessagePreview(getActivity());
        replyableMessagePreview.m30531a((Message) mo7472b());
        return replyableMessagePreview;
    }

    public final Replyable mo7472b() {
        return (Replyable) getArguments().getSerializable("message");
    }
}
