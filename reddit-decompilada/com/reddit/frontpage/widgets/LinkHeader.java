package com.reddit.frontpage.widgets;

import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;

public interface LinkHeader {
    void mo5063a(Runnable runnable);

    void b_(Link link);

    void setDisplaySubredditName(boolean z);

    void setDomainClickListener(OnClickListener onClickListener);

    void setModQueueCheckListener(ModQueueCheckListener<Thing> modQueueCheckListener);

    void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener);

    void setShowOverflow(boolean z);
}
