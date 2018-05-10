package com.reddit.datalibrary.frontpage.data.feature.legacy.local;

import android.content.Context;
import com.google.common.collect.ImmutableList;
import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase;
import com.reddit.datalibrary.frontpage.data.provider.DBFlowLoader;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.SessionDependent;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditDisplayName;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit_Table;
import java.util.Collections;
import java.util.List;

@Deprecated
public class LegacyDatabaseSubredditDataSourceLegacy implements LegacyLocalSubredditDataSource {
    public final void mo2936a(final Listing<Subreddit> listing) {
        m15930a(listing.getEntities(), SessionManager.m9191b().f10839b);
        FlowManager.getDatabase(RedditFlowSharedDatabase.class).executeTransaction(new ITransaction(this) {
            final /* synthetic */ LegacyDatabaseSubredditDataSourceLegacy f15869b;

            public void execute(DatabaseWrapper databaseWrapper) {
                SQLite.delete().from(Subreddit.class).where(Subreddit_Table.username.isNull()).execute(databaseWrapper);
                LegacyDatabaseSubredditDataSourceLegacy.m15929a(listing.getEntities(), databaseWrapper);
            }
        });
    }

    public final void mo2934a(Session session, Listing<Subreddit> listing) {
        m15928a(session, listing, Subreddit_Table.user_is_subscriber);
    }

    public final void mo2938b(Session session, Listing<Subreddit> listing) {
        m15928a(session, listing, Subreddit_Table.user_is_moderator);
    }

    public final void mo2935a(final Session session, final List<Multireddit> list) {
        m15930a((List) list, session);
        final DatabaseDefinition database = FlowManager.getDatabase(RedditFlowSharedDatabase.class);
        database.executeTransaction(new ITransaction(this) {
            final /* synthetic */ LegacyDatabaseSubredditDataSourceLegacy f15873d;

            public void execute(DatabaseWrapper databaseWrapper) {
                SQLite.delete().from(Multireddit.class).where(Multireddit_Table.username.is(session.getUsername())).execute(databaseWrapper);
                database.getModelAdapterForTable(Multireddit.class).getListModelSaver().saveAll(list, databaseWrapper);
            }
        });
    }

    private void m15928a(Session session, Listing<Subreddit> listing, Property<Boolean> property) {
        m15930a(listing.getEntities(), session);
        FlowManager.getDatabase(RedditFlowSharedDatabase.class).executeTransaction(new LegacyDatabaseSubredditDataSourceLegacy$$Lambda$1(this, property, session.getUsername(), listing));
    }

    public final DBFlowLoader<Subreddit> mo2933a(Context context) {
        Property property = Subreddit_Table.user_is_subscriber;
        Object username = SessionManager.m9191b().f10840c.getUsername();
        return new DBFlowLoader(context, SQLite.select(new IProperty[0]).from(Subreddit.class).innerJoin(SubredditInfo.class).on(Subreddit_Table._id.withTable().eq(SubredditInfo_Table._id.withTable())).where(property.eq(Boolean.valueOf(true))).and(Subreddit_Table.username.eq(username)).and(SubredditInfo_Table.subreddit_type.notEq((Object) "user")).orderBy(OrderBy.fromProperty(SubredditInfo_Table.display_name).collate(Collate.NOCASE).ascending()));
    }

    public static List<SubredditDisplayName> m15926a() {
        return m15927a(Subreddit_Table.user_is_subscriber);
    }

    public final List<SubredditDisplayName> mo2937b() {
        return m15927a(Subreddit_Table.user_favorite);
    }

    private static List<SubredditDisplayName> m15927a(Property<Boolean> property) {
        property = SQLite.select(SubredditInfo_Table.display_name).from(SubredditInfo.class).innerJoin(Subreddit.class).on(Subreddit_Table._id.withTable().eq(SubredditInfo_Table._id.withTable())).where(property.eq(Boolean.valueOf(true))).and(Subreddit_Table.username.eq(SessionManager.m9191b().f10840c.getUsername())).orderBy(OrderBy.fromProperty(SubredditInfo_Table.display_name).collate(Collate.NOCASE).ascending()).queryCustomList(SubredditDisplayName.class);
        return property == null ? Collections.EMPTY_LIST : property;
    }

    private static void m15930a(List<? extends SessionDependent> list, Session session) {
        for (SessionDependent updateSessionInfo : list) {
            updateSessionInfo.updateSessionInfo(session);
        }
    }

    static void m15929a(List<Subreddit> list, DatabaseWrapper databaseWrapper) {
        DatabaseDefinition database = FlowManager.getDatabase(RedditFlowSharedDatabase.class);
        ModelAdapter modelAdapterForTable = database.getModelAdapterForTable(SubredditInfo.class);
        ModelAdapter modelAdapterForTable2 = database.getModelAdapterForTable(Subreddit.class);
        modelAdapterForTable.getListModelSaver().saveAll(list, databaseWrapper);
        modelAdapterForTable2.getListModelSaver().saveAll(list, databaseWrapper);
    }

    public final List<SubredditDisplayName> mo2939c() {
        List<SubredditDisplayName> queryCustomList = SQLite.select(SubredditInfo_Table.display_name).from(SubredditInfo.class).innerJoin(Subreddit.class).on(Subreddit_Table._id.withTable().eq(SubredditInfo_Table._id.withTable())).where(Subreddit_Table.user_favorite.eq(Boolean.valueOf(true))).and(Subreddit_Table.user_is_subscriber.eq(Boolean.valueOf(true))).and(Subreddit_Table.username.eq(SessionManager.m9191b().f10840c.getUsername())).queryCustomList(SubredditDisplayName.class);
        return queryCustomList == null ? ImmutableList.m14735d() : queryCustomList;
    }
}
