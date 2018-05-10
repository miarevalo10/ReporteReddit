package com.raizlabs.android.dbflow.config;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class FlowConfig {
    private final Context context;
    private final Map<Class<?>, DatabaseConfig> databaseConfigMap;
    private final Set<Class<? extends DatabaseHolder>> databaseHolders;
    private final boolean openDatabasesOnInit;

    public static class Builder {
        final Context context;
        final Map<Class<?>, DatabaseConfig> databaseConfigMap = new HashMap();
        Set<Class<? extends DatabaseHolder>> databaseHolders = new HashSet();
        boolean openDatabasesOnInit;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder addDatabaseHolder(Class<? extends DatabaseHolder> cls) {
            this.databaseHolders.add(cls);
            return this;
        }

        public Builder addDatabaseConfig(DatabaseConfig databaseConfig) {
            this.databaseConfigMap.put(databaseConfig.databaseClass(), databaseConfig);
            return this;
        }

        public Builder openDatabasesOnInit(boolean z) {
            this.openDatabasesOnInit = z;
            return this;
        }

        public FlowConfig build() {
            return new FlowConfig(this);
        }
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    FlowConfig(Builder builder) {
        this.databaseHolders = Collections.unmodifiableSet(builder.databaseHolders);
        this.databaseConfigMap = builder.databaseConfigMap;
        this.context = builder.context;
        this.openDatabasesOnInit = builder.openDatabasesOnInit;
    }

    public final Set<Class<? extends DatabaseHolder>> databaseHolders() {
        return this.databaseHolders;
    }

    public final Map<Class<?>, DatabaseConfig> databaseConfigMap() {
        return this.databaseConfigMap;
    }

    public final DatabaseConfig getConfigForDatabase(Class<?> cls) {
        return (DatabaseConfig) databaseConfigMap().get(cls);
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean openDatabasesOnInit() {
        return this.openDatabasesOnInit;
    }
}
