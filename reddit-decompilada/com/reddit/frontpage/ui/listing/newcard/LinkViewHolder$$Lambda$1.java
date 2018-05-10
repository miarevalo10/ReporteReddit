package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuItem;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;

final /* synthetic */ class LinkViewHolder$$Lambda$1 implements OnMenuItemClickListener {
    private final LinkViewHolder f29128a;
    private final Context f29129b;
    private final SessionManager f29130c;
    private final Session f29131d;

    LinkViewHolder$$Lambda$1(LinkViewHolder linkViewHolder, Context context, SessionManager sessionManager, Session session) {
        this.f29128a = linkViewHolder;
        this.f29129b = context;
        this.f29130c = sessionManager;
        this.f29131d = session;
    }

    public final boolean m30245a(MenuItem menuItem) {
        return this.f29128a.m35122a(this.f29129b, this.f29130c, this.f29131d, menuItem);
    }
}
