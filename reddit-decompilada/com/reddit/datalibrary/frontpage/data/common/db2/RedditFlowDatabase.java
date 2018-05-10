package com.reddit.datalibrary.frontpage.data.common.db2;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.raizlabs.android.dbflow.sql.migration.IndexPropertyMigration;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel;
import com.reddit.datalibrary.frontpage.data.model.AccountDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel;
import com.reddit.datalibrary.frontpage.data.model.LinkMutationsDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.ListingDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel;
import com.reddit.datalibrary.frontpage.data.model.UserSubredditDataModel_Table;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.RecentSubreddit_Table;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.Util;
import java.util.concurrent.CountDownLatch;

public class RedditFlowDatabase {
    private static volatile CountDownLatch f10308a = new CountDownLatch(1);
    private static boolean f10309b = false;

    public static class Migration14 extends BaseMigration {
        public void migrate(DatabaseWrapper databaseWrapper) {
            FrontpageApplication.a.deleteDatabase("reddit-database.db");
        }
    }

    public static class IndexPreviouslyReadMigration extends IndexPropertyMigration {
        public IndexProperty getIndexProperty() {
            return ClientLink_Table.index_previously_read;
        }
    }

    public static class Migration10 extends AlterTableMigration<VideoUpload> {
        public Migration10(Class<VideoUpload> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, VideoUpload_Table.uploadDuration.toString());
            addColumn(SQLiteType.TEXT, VideoUpload_Table.uploadError.toString());
            addColumn(SQLiteType.INTEGER, VideoUpload_Table.videoWidth.toString());
            addColumn(SQLiteType.INTEGER, VideoUpload_Table.videoHeight.toString());
        }
    }

    public static class Migration11 extends AlterTableMigration<ClientLink> {
        public Migration11(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, ClientLink_Table.video_width.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.video_height.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.video_duration.toString());
            addColumn(SQLiteType.TEXT, ClientLink_Table.video_dash_url.toString());
            addColumn(SQLiteType.TEXT, ClientLink_Table.video_scrubber_media_url.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.video_is_gif.toString());
        }
    }

    public static class Migration15 extends AlterTableMigration<RecentSubreddit> {
        public Migration15(Class<RecentSubreddit> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, RecentSubreddit_Table.subredditId.toString());
        }
    }

    public static class Migration16 extends AlterTableMigration<SubredditDataModel> {
        public Migration16(Class<SubredditDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, SubredditDataModel_Table.publicDescription.toString());
        }
    }

    public static class Migration18 extends AlterTableMigration<SubredditDataModel> {
        public Migration18(Class<SubredditDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.createdUtc.toString());
        }
    }

    public static class Migration19 extends AlterTableMigration<RecentSubredditDataModel> {
        public Migration19(Class<RecentSubredditDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, RecentSubredditDataModel_Table.createdUtc.toString());
            addColumn(SQLiteType.TEXT, RecentSubredditDataModel_Table.username.toString());
        }
    }

    public static class Migration21 extends AlterTableMigration<SubredditDataModel> {
        public Migration21(Class<SubredditDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, SubredditDataModel_Table.headerImg.toString());
            addColumn(SQLiteType.TEXT, SubredditDataModel_Table.title.toString());
            addColumn(SQLiteType.TEXT, SubredditDataModel_Table.publicDescriptionHtml.toString());
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.newModMailEnabled.toString());
            addColumn(SQLiteType.TEXT, SubredditDataModel_Table.submitType.toString());
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.allowImages.toString());
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.allowVideos.toString());
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.spoilersEnabled.toString());
            addColumn(SQLiteType.INTEGER, SubredditDataModel_Table.updatedTimestampUtc.toString());
        }
    }

    public static class Migration23 extends AlterTableMigration<AccountDataModel> {
        public Migration23(Class<AccountDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, AccountDataModel_Table.suspensionExpiration.toString());
        }
    }

    public static class Migration24 extends AlterTableMigration<ListingDataModel> {
        public Migration24(Class<ListingDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, ListingDataModel_Table.adDistance.toString());
        }
    }

    public static class Migration25 extends AlterTableMigration<AccountDataModel> {
        public Migration25(Class<AccountDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            RedditFlowDatabase.f10309b = true;
            addColumn(SQLiteType.TEXT, AccountDataModel_Table.iconUrl.toString());
        }
    }

    public static class Migration26 extends AlterTableMigration<AccountDataModel> {
        public Migration26(Class<AccountDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, AccountDataModel_Table.showMyActiveCommunities.toString());
        }
    }

    public static class Migration27 extends AlterTableMigration<UserSubredditDataModel> {
        public Migration27(Class<UserSubredditDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, UserSubredditDataModel_Table.showInDefaultSubreddits.toString());
        }
    }

    public static class Migration28 extends AlterTableMigration<LinkMutationsDataModel> {
        public Migration28(Class<LinkMutationsDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, LinkMutationsDataModel_Table.readTimestampUtc.toString());
        }
    }

    public static class Migration29 extends AlterTableMigration<AccountDataModel> {
        public Migration29(Class<AccountDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            if (!RedditFlowDatabase.f10309b) {
                addColumn(SQLiteType.TEXT, AccountDataModel_Table.iconUrl.toString());
            }
        }
    }

    public static class Migration30 extends AlterTableMigration<ClientLink> {
        public Migration30(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, ClientLink_Table.vote_key.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.is_betrayed.toString());
            addColumn(SQLiteType.TEXT, ClientLink_Table.circlepost_websocket_url.toString());
        }
    }

    public static class Migration31 extends AlterTableMigration<LinkMutationsDataModel> {
        public Migration31(Class<LinkMutationsDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, LinkMutationsDataModel_Table.isSaved.toString());
        }
    }

    public static class Migration3 extends AlterTableMigration<ClientLink> {
        public Migration3(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addForeignKeyColumn(SQLiteType.TEXT, ClientLink_Table._gifPreview_url.toString(), "`image_resolution`(`url`) ON UPDATE NO ACTION ON DELETE NO ACTION");
        }
    }

    public static class Migration4 extends AlterTableMigration<ClientLink> {
        public Migration4(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, ClientLink_Table.locked.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.quarantined.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.stickied.toString());
            addColumn(SQLiteType.TEXT, ClientLink_Table.distinguished.toString());
        }
    }

    public static class Migration5 extends AlterTableMigration<ClientLink> {
        public Migration5(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, ClientLink_Table.spoiler.toString());
        }
    }

    public static class Migration6 extends AlterTableMigration<ClientLink> {
        public Migration6(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, ClientLink_Table.brand_safe.toString());
            addColumn(SQLiteType.TEXT, ClientLink_Table.subreddit_name_prefixed.toString());
        }
    }

    public static class Migration7 extends AlterTableMigration<ClientLink> {
        public Migration7(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, ClientLink_Table.location_name.toString());
        }
    }

    public static class Migration8 extends AlterTableMigration<ClientLink> {
        public Migration8(Class<ClientLink> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, ClientLink_Table.scrubber_media_url.toString());
            addColumn(SQLiteType.INTEGER, ClientLink_Table.is_video.toString());
        }
    }

    public static class Migration9 extends AlterTableMigration<VideoUpload> {
        public Migration9(Class<VideoUpload> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, VideoUpload_Table.originalDuration.toString());
            addColumn(SQLiteType.INTEGER, VideoUpload_Table.duration.toString());
            addColumn(SQLiteType.TEXT, VideoUpload_Table.source.toString());
        }
    }

    public static void m8767a() {
        FlowManager.init(FlowConfig.builder(FrontpageApplication.a).addDatabaseConfig(DatabaseConfig.builder(RedditFlowDatabase.class).databaseName(m8772f()).build()).build());
        f10308a.countDown();
    }

    public static void m8768b() {
        Util.c(RedditFlowDatabase.class.getSimpleName(), "swapDatabase");
        f10309b = false;
        FlowManager.getDatabase(RedditFlowDatabase.class).reopen(DatabaseConfig.builder(RedditFlowDatabase.class).databaseName(m8772f()).build());
    }

    public static void m8769c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10308a;	 Catch:{ InterruptedException -> 0x0006 }
        r0.await();	 Catch:{ InterruptedException -> 0x0006 }
        return;
    L_0x0006:
        r0 = "DB wait interrupted";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        timber.log.Timber.c(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowDatabase.c():void");
    }

    private static String m8772f() {
        Session session = SessionManager.m9191b().f10840c;
        String username = session.isAnonymous() ? "anonymous" : session.getUsername();
        StringBuilder stringBuilder = new StringBuilder("reddit_user_");
        stringBuilder.append(username);
        return stringBuilder.toString();
    }
}
