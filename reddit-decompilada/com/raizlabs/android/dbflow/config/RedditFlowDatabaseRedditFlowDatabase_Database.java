package com.raizlabs.android.dbflow.config;

import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.IndexPreviouslyReadMigration;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration10;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration11;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration14;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration15;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration16;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration18;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration19;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration21;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration23;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration24;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration25;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration26;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration27;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration28;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration29;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration3;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration30;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration31;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration4;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration5;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration6;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration7;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration8;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.Migration9;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.CommentDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.LinkDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.MultiredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.requests.models.v1.AdEvent_Table;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution_Table;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.OutboundLink_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit_Table;

public final class RedditFlowDatabaseRedditFlowDatabase_Database extends DatabaseDefinition {
    public final boolean areConsistencyChecksEnabled() {
        return false;
    }

    public final boolean backupEnabled() {
        return false;
    }

    public final int getDatabaseVersion() {
        return 31;
    }

    public final boolean isForeignKeysSupported() {
        return true;
    }

    public RedditFlowDatabaseRedditFlowDatabase_Database(DatabaseHolder databaseHolder) {
        addModelAdapter(new AccountDataModel_Table(databaseHolder, this), databaseHolder);
        addModelAdapter(new AdEvent_Table(this), databaseHolder);
        addModelAdapter(new ClientLink_Table(databaseHolder, this), databaseHolder);
        addModelAdapter(new CommentDataModel_Table(this), databaseHolder);
        addModelAdapter(new ImageResolution_Table(this), databaseHolder);
        addModelAdapter(new LinkDataModel_Table(this), databaseHolder);
        addModelAdapter(new LinkMutationsDataModel_Table(this), databaseHolder);
        addModelAdapter(new ListingDataModel_Table(this), databaseHolder);
        addModelAdapter(new MultiredditDataModel_Table(this), databaseHolder);
        addModelAdapter(new OutboundLink_Table(this), databaseHolder);
        addModelAdapter(new RecentSubredditDataModel_Table(this), databaseHolder);
        addModelAdapter(new RecentSubreddit_Table(this), databaseHolder);
        addModelAdapter(new SubredditDataModel_Table(databaseHolder, this), databaseHolder);
        addModelAdapter(new UserSubredditDataModel_Table(databaseHolder, this), databaseHolder);
        addModelAdapter(new VideoUpload_Table(this), databaseHolder);
        addMigration(31, new Migration31(LinkMutationsDataModel.class));
        addMigration(30, new Migration30(ClientLink.class));
        addMigration(29, new Migration29(AccountDataModel.class));
        addMigration(28, new Migration28(LinkMutationsDataModel.class));
        addMigration(27, new Migration27(UserSubredditDataModel.class));
        addMigration(26, new Migration26(AccountDataModel.class));
        addMigration(25, new Migration25(AccountDataModel.class));
        addMigration(24, new Migration24(ListingDataModel.class));
        addMigration(23, new Migration23(AccountDataModel.class));
        addMigration(21, new Migration21(SubredditDataModel.class));
        addMigration(19, new Migration19(RecentSubredditDataModel.class));
        addMigration(18, new Migration18(SubredditDataModel.class));
        addMigration(16, new Migration16(SubredditDataModel.class));
        addMigration(15, new Migration15(RecentSubreddit.class));
        addMigration(14, new Migration14());
        addMigration(11, new Migration11(ClientLink.class));
        addMigration(10, new Migration10(VideoUpload.class));
        addMigration(9, new Migration9(VideoUpload.class));
        addMigration(8, new Migration8(ClientLink.class));
        addMigration(7, new Migration7(ClientLink.class));
        addMigration(6, new Migration6(ClientLink.class));
        addMigration(5, new Migration5(ClientLink.class));
        addMigration(4, new Migration4(ClientLink.class));
        addMigration(3, new Migration3(ClientLink.class));
        addMigration(0, new IndexPreviouslyReadMigration());
    }

    public final Class<?> getAssociatedDatabaseClassFile() {
        return RedditFlowDatabase.class;
    }
}
