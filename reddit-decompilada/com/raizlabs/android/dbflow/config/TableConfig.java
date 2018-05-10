package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.sql.queriable.ListModelLoader;
import com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;

public final class TableConfig<TModel> {
    private final ListModelLoader<TModel> listModelLoader;
    private final ModelSaver<TModel> modelSaver;
    private final SingleModelLoader<TModel> singleModelLoader;
    private final Class<TModel> tableClass;

    public static final class Builder<TModel> {
        ListModelLoader<TModel> listModelLoader;
        ModelSaver<TModel> modelAdapterModelSaver;
        SingleModelLoader<TModel> singleModelLoader;
        final Class<TModel> tableClass;

        public Builder(Class<TModel> cls) {
            this.tableClass = cls;
        }

        public final Builder<TModel> modelAdapterModelSaver(ModelSaver<TModel> modelSaver) {
            this.modelAdapterModelSaver = modelSaver;
            return this;
        }

        public final Builder<TModel> singleModelLoader(SingleModelLoader<TModel> singleModelLoader) {
            this.singleModelLoader = singleModelLoader;
            return this;
        }

        public final Builder<TModel> listModelLoader(ListModelLoader<TModel> listModelLoader) {
            this.listModelLoader = listModelLoader;
            return this;
        }

        public final TableConfig build() {
            return new TableConfig(this);
        }
    }

    public static <TModel> Builder<TModel> builder(Class<TModel> cls) {
        return new Builder(cls);
    }

    TableConfig(Builder<TModel> builder) {
        this.tableClass = builder.tableClass;
        this.modelSaver = builder.modelAdapterModelSaver;
        this.singleModelLoader = builder.singleModelLoader;
        this.listModelLoader = builder.listModelLoader;
    }

    public final Class<?> tableClass() {
        return this.tableClass;
    }

    public final ModelSaver<TModel> modelSaver() {
        return this.modelSaver;
    }

    public final ListModelLoader<TModel> listModelLoader() {
        return this.listModelLoader;
    }

    public final SingleModelLoader<TModel> singleModelLoader() {
        return this.singleModelLoader;
    }
}
