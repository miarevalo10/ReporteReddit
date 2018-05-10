package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public final class SubredditDisplayName_QueryTable extends QueryModelAdapter<SubredditDisplayName> {
    public static final Property<String> display_name = new Property(SubredditDisplayName.class, "display_name");

    public final /* synthetic */ void loadFromCursor(FlowCursor flowCursor, Object obj) {
        ((SubredditDisplayName) obj).display_name = flowCursor.getStringOrDefault("display_name");
    }

    public SubredditDisplayName_QueryTable(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final Class<SubredditDisplayName> getModelClass() {
        return SubredditDisplayName.class;
    }

    public final /* synthetic */ Object newInstance() {
        return new SubredditDisplayName();
    }
}
