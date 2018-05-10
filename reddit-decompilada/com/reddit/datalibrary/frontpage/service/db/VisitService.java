package com.reddit.datalibrary.frontpage.service.db;

import android.app.IntentService;
import android.content.Intent;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit_Table;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.domain.model.Subreddit;
import org.parceler.Parcels;
import timber.log.Timber;

public class VisitService extends IntentService {
    private static final String f19837a = "VisitService";

    public VisitService() {
        this(f19837a);
    }

    public VisitService(String str) {
        super(str);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("username");
        Subreddit subreddit = (Subreddit) Parcels.m28673a(intent.getParcelableExtra("subreddit"));
        FrontpageApplication.m28875k().mo4635w().m22494a(stringExtra, subreddit).blockingGet();
        if (subreddit.getDisplayName() == null) {
            Timber.e(String.format("Unable to save recent subreddit. Subreddit.getDisplayName() is null. \n\n%s", new Object[]{subreddit.toString()}), new Object[0]);
        } else {
            RecentSubreddit recentSubreddit = new RecentSubreddit((byte) 0);
            recentSubreddit.m36662a(stringExtra);
            recentSubreddit.visitTime = Long.valueOf(System.currentTimeMillis());
            recentSubreddit.m36663b(subreddit.getDisplayName());
            recentSubreddit.m36664c(subreddit.getKindWithId());
            recentSubreddit.headerImg = subreddit.getHeaderImg();
            recentSubreddit.icon = subreddit.getIconImg();
            recentSubreddit.keyColor = subreddit.getKeyColor();
            recentSubreddit.save();
        }
        Timber.b("visited %s", new Object[]{subreddit.getDisplayName()});
        if (SQLite.selectCountOf(new IProperty[]{RecentSubreddit_Table.id}).from(RecentSubreddit.class).where(new SQLOperator[]{RecentSubreddit_Table.username.eq(stringExtra)}).count() > 25) {
            intent = SQLite.select(new IProperty[]{RecentSubreddit_Table.id}).from(RecentSubreddit.class).where(new SQLOperator[]{RecentSubreddit_Table.username.eq(stringExtra)}).orderBy(RecentSubreddit_Table.visitTime.desc()).limit(25);
            SQLite.delete().from(RecentSubreddit.class).where(new SQLOperator[]{RecentSubreddit_Table.username.eq(stringExtra)}).and(RecentSubreddit_Table.id.notIn(intent, new BaseModelQueriable[0])).execute();
        }
        if (SQLite.selectCountOf(new IProperty[]{RecentSubredditDataModel_Table.id}).from(RecentSubredditDataModel.class).where(new SQLOperator[]{RecentSubredditDataModel_Table.username.eq(stringExtra)}).count() > 25) {
            intent = SQLite.select(new IProperty[]{RecentSubredditDataModel_Table.id}).from(RecentSubredditDataModel.class).where(new SQLOperator[]{RecentSubredditDataModel_Table.username.eq(stringExtra)}).orderBy(RecentSubredditDataModel_Table.lastVisited.desc()).limit(25);
            SQLite.delete().from(RecentSubredditDataModel.class).where(new SQLOperator[]{RecentSubredditDataModel_Table.username.eq(stringExtra)}).and(RecentSubredditDataModel_Table.id.notIn(intent, new BaseModelQueriable[0])).execute();
        }
    }
}
