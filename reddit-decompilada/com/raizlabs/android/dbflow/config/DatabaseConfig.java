package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.runtime.BaseTransactionManager;
import com.raizlabs.android.dbflow.runtime.ModelNotifier;
import com.raizlabs.android.dbflow.structure.database.DatabaseHelperListener;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import java.util.HashMap;
import java.util.Map;

public final class DatabaseConfig {
    private final Class<?> databaseClass;
    private final String databaseExtensionName;
    private final String databaseName;
    private final DatabaseHelperListener helperListener;
    private final boolean inMemory;
    private final ModelNotifier modelNotifier;
    private final OpenHelperCreator openHelperCreator;
    private final Map<Class<?>, TableConfig> tableConfigMap;
    private final TransactionManagerCreator transactionManagerCreator;

    public static final class Builder {
        final Class<?> databaseClass;
        String databaseExtensionName;
        String databaseName;
        DatabaseHelperListener helperListener;
        boolean inMemory = false;
        ModelNotifier modelNotifier;
        OpenHelperCreator openHelperCreator;
        final Map<Class<?>, TableConfig> tableConfigMap = new HashMap();
        TransactionManagerCreator transactionManagerCreator;

        public Builder(Class<?> cls) {
            this.databaseClass = cls;
        }

        public final Builder transactionManagerCreator(TransactionManagerCreator transactionManagerCreator) {
            this.transactionManagerCreator = transactionManagerCreator;
            return this;
        }

        public final Builder helperListener(DatabaseHelperListener databaseHelperListener) {
            this.helperListener = databaseHelperListener;
            return this;
        }

        public final Builder addTableConfig(TableConfig<?> tableConfig) {
            this.tableConfigMap.put(tableConfig.tableClass(), tableConfig);
            return this;
        }

        public final Builder modelNotifier(ModelNotifier modelNotifier) {
            this.modelNotifier = modelNotifier;
            return this;
        }

        public final Builder inMemory() {
            this.inMemory = true;
            return this;
        }

        public final Builder databaseName(String str) {
            this.databaseName = str;
            return this;
        }

        public final Builder extensionName(String str) {
            this.databaseExtensionName = str;
            return this;
        }

        public final Builder openHelper(OpenHelperCreator openHelperCreator) {
            this.openHelperCreator = openHelperCreator;
            return this;
        }

        public final DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }

    public interface OpenHelperCreator {
        OpenHelper createHelper(DatabaseDefinition databaseDefinition, DatabaseHelperListener databaseHelperListener);
    }

    public interface TransactionManagerCreator {
        BaseTransactionManager createManager(DatabaseDefinition databaseDefinition);
    }

    public static Builder builder(Class<?> cls) {
        return new Builder(cls);
    }

    public static Builder inMemoryBuilder(Class<?> cls) {
        return new Builder(cls).inMemory();
    }

    DatabaseConfig(Builder builder) {
        this.openHelperCreator = builder.openHelperCreator;
        this.databaseClass = builder.databaseClass;
        this.transactionManagerCreator = builder.transactionManagerCreator;
        this.helperListener = builder.helperListener;
        this.tableConfigMap = builder.tableConfigMap;
        this.modelNotifier = builder.modelNotifier;
        this.inMemory = builder.inMemory;
        if (builder.databaseName == null) {
            this.databaseName = builder.databaseClass.getSimpleName();
        } else {
            this.databaseName = builder.databaseName;
        }
        if (builder.databaseExtensionName == null) {
            builder = ".db";
        } else if (StringUtils.isNotNullOrEmpty(builder.databaseExtensionName)) {
            StringBuilder stringBuilder = new StringBuilder(".");
            stringBuilder.append(builder.databaseExtensionName);
            builder = stringBuilder.toString();
        } else {
            builder = "";
        }
        this.databaseExtensionName = builder;
    }

    public final String getDatabaseExtensionName() {
        return this.databaseExtensionName;
    }

    public final boolean isInMemory() {
        return this.inMemory;
    }

    public final String getDatabaseName() {
        return this.databaseName;
    }

    public final OpenHelperCreator helperCreator() {
        return this.openHelperCreator;
    }

    public final DatabaseHelperListener helperListener() {
        return this.helperListener;
    }

    public final Class<?> databaseClass() {
        return this.databaseClass;
    }

    public final TransactionManagerCreator transactionManagerCreator() {
        return this.transactionManagerCreator;
    }

    public final ModelNotifier modelNotifier() {
        return this.modelNotifier;
    }

    public final Map<Class<?>, TableConfig> tableConfigMap() {
        return this.tableConfigMap;
    }

    public final <TModel> TableConfig<TModel> getTableConfigForTable(Class<TModel> cls) {
        return (TableConfig) tableConfigMap().get(cls);
    }
}
