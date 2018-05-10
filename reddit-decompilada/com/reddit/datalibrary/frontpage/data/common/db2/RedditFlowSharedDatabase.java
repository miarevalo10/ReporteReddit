package com.reddit.datalibrary.frontpage.data.common.db2;

import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.property.IndexProperty;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.raizlabs.android.dbflow.sql.migration.IndexPropertyMigration;
import com.raizlabs.android.dbflow.sql.migration.UpdateTableMigration;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.reddit.data.events.models.EventDataModel_Table;
import com.reddit.datalibrary.frontpage.data.model.EventDataModel;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo_Table;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit_Table;

public class RedditFlowSharedDatabase {

    public static class Migration9 extends BaseMigration {
        public void migrate(DatabaseWrapper databaseWrapper) {
            new Handler(Looper.getMainLooper()).postDelayed(RedditFlowSharedDatabase$Migration9$$Lambda$0.f10310a, 5000);
        }
    }

    public static class IndexModeratorMigration extends IndexPropertyMigration {
        public IndexProperty getIndexProperty() {
            return Subreddit_Table.index_user_moderator;
        }
    }

    public static class IndexSubscriberMigration extends IndexPropertyMigration {
        public IndexProperty getIndexProperty() {
            return Subreddit_Table.index_user_subscriber;
        }
    }

    public static class Migration3 extends AlterTableMigration<SubredditInfo> {
        public Migration3(Class<SubredditInfo> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, SubredditInfo_Table.description.toString());
            addColumn(SQLiteType.TEXT, SubredditInfo_Table.description_html.toString());
            addColumn(SQLiteType.INTEGER, SubredditInfo_Table.over18.toString());
            addColumn(SQLiteType.TEXT, SubredditInfo_Table.whitelist_status.toString());
            addColumn(SQLiteType.TEXT, SubredditInfo_Table.display_name_prefixed.toString());
        }
    }

    public static class Migration4 extends AlterTableMigration<SubredditInfo> {
        public Migration4(Class<SubredditInfo> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, SubredditInfo_Table.subreddit_type.toString());
        }
    }

    public static class Migration5 extends AlterTableMigration<Subreddit> {
        public Migration5(Class<Subreddit> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, Subreddit_Table.user_favorite.toString());
        }
    }

    public static class Migration7 extends AlterTableMigration<EventDataModel> {
        public Migration7(Class<EventDataModel> cls) {
            super(cls);
        }

        public void onPreMigrate() {
            addColumn(SQLiteType.INTEGER, EventDataModel_Table.dispatched.toString());
        }
    }

    public static class Migration8 extends UpdateTableMigration<EventDataModel> {
        public Migration8(Class<EventDataModel> cls) {
            super(cls);
            set(new SQLOperator[]{EventDataModel_Table.dispatched.eq(Boolean.valueOf(false))});
        }
    }
}
