package com.reddit.datalibrary.frontpage.data.feature.legacy.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit_Table;

final /* synthetic */ class LegacyDatabaseSubredditDataSourceLegacy$$Lambda$1 implements ITransaction {
    private final LegacyDatabaseSubredditDataSourceLegacy f15864a;
    private final Property f15865b;
    private final String f15866c;
    private final Listing f15867d;

    LegacyDatabaseSubredditDataSourceLegacy$$Lambda$1(LegacyDatabaseSubredditDataSourceLegacy legacyDatabaseSubredditDataSourceLegacy, Property property, String str, Listing listing) {
        this.f15864a = legacyDatabaseSubredditDataSourceLegacy;
        this.f15865b = property;
        this.f15866c = str;
        this.f15867d = listing;
    }

    public final void execute(DatabaseWrapper databaseWrapper) {
        Property property = this.f15865b;
        Object obj = this.f15866c;
        Listing listing = this.f15867d;
        SQLite.update(Subreddit.class).set(property.eq(Boolean.valueOf(false))).where(Subreddit_Table.username.eq(obj)).execute(databaseWrapper);
        LegacyDatabaseSubredditDataSourceLegacy.m15929a(listing.getEntities(), databaseWrapper);
    }
}
