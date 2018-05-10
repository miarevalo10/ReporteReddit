package com.raizlabs.android.dbflow.config;

import com.reddit.data.events.AnalyticsDatabase;
import com.reddit.data.events.models.EventDataModel_Table;

public final class AnalyticsDatabaseAnalyticsDatabase_Database extends DatabaseDefinition {
    public final boolean areConsistencyChecksEnabled() {
        return false;
    }

    public final boolean backupEnabled() {
        return false;
    }

    public final String getDatabaseName() {
        return "reddit_analytics";
    }

    public final int getDatabaseVersion() {
        return 1;
    }

    public final boolean isForeignKeysSupported() {
        return true;
    }

    public AnalyticsDatabaseAnalyticsDatabase_Database(DatabaseHolder databaseHolder) {
        addModelAdapter(new EventDataModel_Table(this), databaseHolder);
    }

    public final Class<?> getAssociatedDatabaseClassFile() {
        return AnalyticsDatabase.class;
    }
}
