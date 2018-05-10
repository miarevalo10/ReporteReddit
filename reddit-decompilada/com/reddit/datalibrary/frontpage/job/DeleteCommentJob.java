package com.reddit.datalibrary.frontpage.job;

import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.C1761R;
import de.greenrobot.event.EventBus;

public class DeleteCommentJob extends DeleteJob {
    public DeleteCommentJob(Session session, Comment comment) {
        super(session, comment);
    }

    protected final void mo3018a(int i, Throwable th) {
        super.mo3018a(i, th);
        EventBus.getDefault().post(MessageEvent.m8765b(this.f2890k.getString(C1761R.string.error_delete_comment_failure)));
    }
}
