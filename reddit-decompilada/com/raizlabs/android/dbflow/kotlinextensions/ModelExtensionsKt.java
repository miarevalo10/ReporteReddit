package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.AsyncModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004\u001a(\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\u00020\u0006\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\t\u001a(\u0010\u000b\u001a\u00020\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\r\u001a(\u0010\u000e\u001a\u00020\u0006\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\t\u001a(\u0010\u000f\u001a\u00020\u0006\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\t¨\u0006\u0010"}, d2 = {"async", "Lcom/raizlabs/android/dbflow/structure/AsyncModel;", "T", "", "(Ljava/lang/Object;)Lcom/raizlabs/android/dbflow/structure/AsyncModel;", "delete", "", "databaseWrapper", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "(Ljava/lang/Object;Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;)Z", "exists", "insert", "", "(Ljava/lang/Object;Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;)J", "save", "update", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: ModelExtensions.kt */
public final class ModelExtensionsKt {
    private static final <T> AsyncModel<T> async(T t) {
        return new AsyncModel(t);
    }

    private static final <T> boolean save(T t, DatabaseWrapper databaseWrapper) {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).save(t, databaseWrapper);
    }

    static /* synthetic */ boolean save$default(Object obj, DatabaseWrapper databaseWrapper, int i, Object obj2) {
        if ((i & 1) != 0) {
            Intrinsics.b();
            databaseWrapper = FlowManager.getWritableDatabaseForTable(Object.class);
            Intrinsics.a(databaseWrapper, "writableDatabaseForTable<T>()");
        }
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).save(obj, databaseWrapper);
    }

    private static final <T> long insert(T t, DatabaseWrapper databaseWrapper) {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).insert(t, databaseWrapper);
    }

    static /* synthetic */ long insert$default(Object obj, DatabaseWrapper databaseWrapper, int i, Object obj2) {
        if ((i & 1) != 0) {
            Intrinsics.b();
            databaseWrapper = FlowManager.getWritableDatabaseForTable(Object.class);
            Intrinsics.a(databaseWrapper, "writableDatabaseForTable<T>()");
        }
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).insert(obj, databaseWrapper);
    }

    private static final <T> boolean update(T t, DatabaseWrapper databaseWrapper) {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).update(t, databaseWrapper);
    }

    static /* synthetic */ boolean update$default(Object obj, DatabaseWrapper databaseWrapper, int i, Object obj2) {
        if ((i & 1) != 0) {
            Intrinsics.b();
            databaseWrapper = FlowManager.getWritableDatabaseForTable(Object.class);
            Intrinsics.a(databaseWrapper, "writableDatabaseForTable<T>()");
        }
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).update(obj, databaseWrapper);
    }

    private static final <T> boolean delete(T t, DatabaseWrapper databaseWrapper) {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).delete(t, databaseWrapper);
    }

    static /* synthetic */ boolean delete$default(Object obj, DatabaseWrapper databaseWrapper, int i, Object obj2) {
        if ((i & 1) != 0) {
            Intrinsics.b();
            databaseWrapper = FlowManager.getWritableDatabaseForTable(Object.class);
            Intrinsics.a(databaseWrapper, "writableDatabaseForTable<T>()");
        }
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).delete(obj, databaseWrapper);
    }

    private static final <T> boolean exists(T t, DatabaseWrapper databaseWrapper) {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).exists(t, databaseWrapper);
    }

    static /* synthetic */ boolean exists$default(Object obj, DatabaseWrapper databaseWrapper, int i, Object obj2) {
        if ((i & 1) != 0) {
            Intrinsics.b();
            databaseWrapper = FlowManager.getWritableDatabaseForTable(Object.class);
            Intrinsics.a(databaseWrapper, "writableDatabaseForTable<T>()");
        }
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class).exists(obj, databaseWrapper);
    }
}
