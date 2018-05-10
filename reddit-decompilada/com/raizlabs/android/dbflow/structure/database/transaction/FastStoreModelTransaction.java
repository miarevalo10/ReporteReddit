package com.raizlabs.android.dbflow.structure.database.transaction;

import com.raizlabs.android.dbflow.structure.InternalAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FastStoreModelTransaction<TModel> implements ITransaction {
    final InternalAdapter<TModel> internalAdapter;
    final List<TModel> models;
    final ProcessModelList<TModel> processModelList;

    public static final class Builder<TModel> {
        private final InternalAdapter<TModel> internalAdapter;
        List<TModel> models = new ArrayList();
        private final ProcessModelList<TModel> processModelList;

        Builder(ProcessModelList<TModel> processModelList, InternalAdapter<TModel> internalAdapter) {
            this.processModelList = processModelList;
            this.internalAdapter = internalAdapter;
        }

        public final Builder<TModel> add(TModel tModel) {
            this.models.add(tModel);
            return this;
        }

        @SafeVarargs
        public final Builder<TModel> addAll(TModel... tModelArr) {
            this.models.addAll(Arrays.asList(tModelArr));
            return this;
        }

        public final Builder<TModel> addAll(Collection<? extends TModel> collection) {
            if (collection != null) {
                this.models.addAll(collection);
            }
            return this;
        }

        public final FastStoreModelTransaction<TModel> build() {
            return new FastStoreModelTransaction(this);
        }
    }

    interface ProcessModelList<TModel> {
        void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper);
    }

    static class C14761 implements ProcessModelList<TModel> {
        C14761() {
        }

        public final void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
            internalAdapter.saveAll(list, databaseWrapper);
        }
    }

    static class C14772 implements ProcessModelList<TModel> {
        C14772() {
        }

        public final void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
            internalAdapter.insertAll(list, databaseWrapper);
        }
    }

    static class C14783 implements ProcessModelList<TModel> {
        C14783() {
        }

        public final void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
            internalAdapter.updateAll(list, databaseWrapper);
        }
    }

    static class C14794 implements ProcessModelList<TModel> {
        C14794() {
        }

        public final void processModel(List<TModel> list, InternalAdapter<TModel> internalAdapter, DatabaseWrapper databaseWrapper) {
            internalAdapter.deleteAll(list, databaseWrapper);
        }
    }

    public static <TModel> Builder<TModel> saveBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder(new C14761(), internalAdapter);
    }

    public static <TModel> Builder<TModel> insertBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder(new C14772(), internalAdapter);
    }

    public static <TModel> Builder<TModel> updateBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder(new C14783(), internalAdapter);
    }

    public static <TModel> Builder<TModel> deleteBuilder(InternalAdapter<TModel> internalAdapter) {
        return new Builder(new C14794(), internalAdapter);
    }

    FastStoreModelTransaction(Builder<TModel> builder) {
        this.models = builder.models;
        this.processModelList = builder.processModelList;
        this.internalAdapter = builder.internalAdapter;
    }

    public void execute(DatabaseWrapper databaseWrapper) {
        if (this.models != null) {
            this.processModelList.processModel(this.models, this.internalAdapter, databaseWrapper);
        }
    }
}
