package com.reddit.datalibrary.frontpage.job;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;

public class DeletePostJob extends DeleteJob {

    public static class ResultEvent extends BaseEvent {
        public int f16276a;

        public ResultEvent(int i) {
            this.f16276a = i;
        }
    }

    public DeletePostJob(Session session, String str) {
        super(session, str);
    }

    protected final void mo3018a(int i, Throwable th) {
        super.mo3018a(i, th);
        EventBus.getDefault().post(MessageEvent.m8765b(this.f2890k.getString(C1761R.string.error_delete_post_failure)));
    }

    protected final String mo3805h() {
        return Util.f(C1761R.string.success_post_delete);
    }
}
