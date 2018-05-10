package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;

public abstract class InstanceAdapter<TModel> extends RetrievalAdapter<TModel> {
    public abstract TModel newInstance();

    public InstanceAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }
}
