package com.reddit.datalibrary.frontpage.data.provider;

import android.support.v4.content.Loader;
import com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Transformable;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit_Table;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/RecentSubredditLoaderProvider;", "Lcom/reddit/datalibrary/frontpage/data/provider/LoaderProvider;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/RecentSubreddit;", "()V", "emitLoadEvent", "", "onCreateLoader", "Lcom/reddit/datalibrary/frontpage/data/provider/DBFlowLoader;", "id", "", "args", "Landroid/os/Bundle;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecentSubredditLoaderProvider.kt */
public final class RecentSubredditLoaderProvider extends LoaderProvider<RecentSubreddit> {
    public RecentSubredditLoaderProvider() {
        super(16);
    }

    protected final void mo3803d() {
        EventBus.getDefault().postSticky(new RecentSubredditCursorEvent());
    }

    public final /* synthetic */ Loader mo1526a() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Session c = b.m9203c();
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        From from = QueryExtensionsKt.from(select, Reflection.a(RecentSubreddit.class));
        Operator eq = RecentSubreddit_Table.username.eq(c.getUsername());
        Intrinsics.a(eq, "RecentSubreddit_Table.us…name.eq(session.username)");
        Transformable where = QueryExtensionsKt.where(from, (SQLOperator) eq);
        OrderBy desc = RecentSubreddit_Table.visitTime.desc();
        Intrinsics.a(desc, "visitTime.desc()");
        return new DBFlowLoader(FrontpageApplication.a, QueryExtensionsKt.orderBy(where, desc));
    }
}
