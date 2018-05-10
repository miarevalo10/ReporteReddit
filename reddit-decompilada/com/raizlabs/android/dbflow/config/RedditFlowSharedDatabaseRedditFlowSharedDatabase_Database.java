package com.raizlabs.android.dbflow.config;

import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.IndexModeratorMigration;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.IndexSubscriberMigration;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration3;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration4;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration5;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration7;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration8;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase.Migration9;
import com.reddit.datalibrary.frontpage.data.model.EventDataModel;
import com.reddit.datalibrary.frontpage.data.model.EventDataModel_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditDisplayName_QueryTable;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit_Table;

public final class RedditFlowSharedDatabaseRedditFlowSharedDatabase_Database extends DatabaseDefinition {
    public final boolean areConsistencyChecksEnabled() {
        return false;
    }

    public final boolean backupEnabled() {
        return false;
    }

    public final String getDatabaseName() {
        return "reddit_shared";
    }

    public final int getDatabaseVersion() {
        return 9;
    }

    public final boolean isForeignKeysSupported() {
        return true;
    }

    public RedditFlowSharedDatabaseRedditFlowSharedDatabase_Database(DatabaseHolder databaseHolder) {
        addModelAdapter(new EventDataModel_Table(this), databaseHolder);
        addModelAdapter(new Multireddit_Table(this), databaseHolder);
        addModelAdapter(new SubredditInfo_Table(this), databaseHolder);
        addModelAdapter(new Subreddit_Table(this), databaseHolder);
        addQueryModelAdapter(new SubredditDisplayName_QueryTable(this), databaseHolder);
        addMigration(9, new Migration9());
        addMigration(8, new Migration8(EventDataModel.class));
        addMigration(7, new Migration7(EventDataModel.class));
        addMigration(5, new Migration5(Subreddit.class));
        addMigration(4, new Migration4(SubredditInfo.class));
        addMigration(3, new Migration3(SubredditInfo.class));
        addMigration(0, new IndexSubscriberMigration());
        addMigration(0, new IndexModeratorMigration());
    }

    public final Class<?> getAssociatedDatabaseClassFile() {
        return RedditFlowSharedDatabase.class;
    }
}
