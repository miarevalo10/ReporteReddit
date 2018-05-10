package com.raizlabs.android.dbflow.kotlinextensions;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import com.raizlabs.android.dbflow.structure.QueryModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.Builder;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.OnModelProcessListener;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u0011\u0010\u0003\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\u0005\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\b\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\n\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u0011\u0010\u000b\u001a\u00020\f\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u0011\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a-\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u0012H\b\u001a-\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u0012H\b\u001a-\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\u0010\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u0012H\b\u001aE\u0010\u0015\u001a\u00020\u0016\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00122$\b\u0004\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u0002H\u0002`\u0019H\b\u001ao\u0010\u001a\u001a\u00020\u0016\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00122$\b\u0004\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u0002H\u0002`\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010 H\b\u001aK\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\"\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00122$\b\u0004\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u0002H\u0002`\u0019H\b\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0002\u0010(\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010*\u001a\u001f\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010+H\u0002\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010-\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u00101\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u00103\u001a$\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u00105\u001a\u001f\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0002*4\u00106\u001a\u0004\b\u0000\u0010\u0002\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u00182\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0018¨\u00067"}, d2 = {"database", "Lcom/raizlabs/android/dbflow/config/DatabaseDefinition;", "T", "databaseForTable", "modelAdapter", "Lcom/raizlabs/android/dbflow/structure/ModelAdapter;", "kotlin.jvm.PlatformType", "modelViewAdapter", "Lcom/raizlabs/android/dbflow/structure/ModelViewAdapter;", "queryModelAdapter", "Lcom/raizlabs/android/dbflow/structure/QueryModelAdapter;", "tableName", "", "writableDatabaseForTable", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "fastInsert", "Lcom/raizlabs/android/dbflow/structure/database/transaction/FastStoreModelTransaction$Builder;", "", "", "fastSave", "fastUpdate", "processInTransaction", "", "processFunction", "Lkotlin/Function2;", "Lcom/raizlabs/android/dbflow/kotlinextensions/ProcessFunction;", "processInTransactionAsync", "success", "Lcom/raizlabs/android/dbflow/structure/database/transaction/Transaction$Success;", "error", "Lcom/raizlabs/android/dbflow/structure/database/transaction/Transaction$Error;", "processListener", "Lcom/raizlabs/android/dbflow/structure/database/transaction/ProcessModelTransaction$OnModelProcessListener;", "processTransaction", "Lcom/raizlabs/android/dbflow/structure/database/transaction/ProcessModelTransaction$Builder;", "set", "Landroid/content/ContentValues;", "key", "value", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Boolean;)V", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Byte;)V", "", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Double;)V", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Float;)V", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Long;)V", "", "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Short;)V", "ProcessFunction", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: DatabaseExtensions.kt */
public final class DatabaseExtensionsKt {
    private static final <T> DatabaseDefinition database() {
        Intrinsics.b();
        return FlowManager.getDatabase(Object.class);
    }

    private static final <T> DatabaseWrapper writableDatabaseForTable() {
        Intrinsics.b();
        return FlowManager.getWritableDatabaseForTable(Object.class);
    }

    private static final <T> DatabaseDefinition databaseForTable() {
        Intrinsics.b();
        return FlowManager.getDatabaseForTable(Object.class);
    }

    private static final <T> String tableName() {
        Intrinsics.b();
        return FlowManager.getTableName(Object.class);
    }

    private static final <T> ModelAdapter<T> modelAdapter() {
        Intrinsics.b();
        return FlowManager.getModelAdapter(Object.class);
    }

    private static final <T> QueryModelAdapter<T> queryModelAdapter() {
        Intrinsics.b();
        return FlowManager.getQueryModelAdapter(Object.class);
    }

    private static final <T> ModelViewAdapter<T> modelViewAdapter() {
        Intrinsics.b();
        return FlowManager.getModelViewAdapter(Object.class);
    }

    private static final <T> Builder<T> processTransaction(Collection<? extends T> collection, Function2<? super T, ? super DatabaseWrapper, Unit> function2) {
        collection = new Builder(new DatabaseExtensionsKt$processTransaction$1(function2)).addAll((Collection) collection);
        Intrinsics.a(collection, "ProcessModelTransaction.… wrapper) }).addAll(this)");
        return collection;
    }

    public static final void set(ContentValues contentValues, String str, String str2) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, str2);
    }

    public static final void set(ContentValues contentValues, String str, Byte b) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, b);
    }

    public static final void set(ContentValues contentValues, String str, Short sh) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, sh);
    }

    public static final void set(ContentValues contentValues, String str, Integer num) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, num);
    }

    public static final void set(ContentValues contentValues, String str, Long l) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, l);
    }

    public static final void set(ContentValues contentValues, String str, Float f) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, f);
    }

    public static final void set(ContentValues contentValues, String str, Double d) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, d);
    }

    public static final void set(ContentValues contentValues, String str, Boolean bool) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, bool);
    }

    public static final void set(ContentValues contentValues, String str, byte[] bArr) {
        Intrinsics.b(contentValues, "$receiver");
        Intrinsics.b(str, "key");
        contentValues.put(str, bArr);
    }

    private static final <T> void processInTransaction(Collection<? extends T> collection, Function2<? super T, ? super DatabaseWrapper, Unit> function2) {
        Intrinsics.b();
        FlowManager.getDatabaseForTable(Object.class).executeTransaction(new DatabaseExtensionsKt$processInTransaction$1(collection, function2));
    }

    private static final <T> void processInTransactionAsync(Collection<? extends T> collection, Function2<? super T, ? super DatabaseWrapper, Unit> function2, Success success, Error error, OnModelProcessListener<T> onModelProcessListener) {
        Intrinsics.b();
        DatabaseDefinition databaseForTable = FlowManager.getDatabaseForTable(Object.class);
        collection = new Builder(new DatabaseExtensionsKt$processTransaction$1(function2)).addAll((Collection) collection);
        Intrinsics.a(collection, "ProcessModelTransaction.… wrapper) }).addAll(this)");
        databaseForTable.beginTransactionAsync(collection.processListener(onModelProcessListener).build()).success(success).error(error).execute();
    }

    static /* synthetic */ void processInTransactionAsync$default(Collection collection, Function2 function2, Success success, Error error, OnModelProcessListener onModelProcessListener, int i, Object obj) {
        if ((i & 2) != null) {
            success = null;
        }
        if ((i & 4) != null) {
            error = null;
        }
        if ((i & 8) != 0) {
            onModelProcessListener = null;
        }
        Intrinsics.b();
        i = FlowManager.getDatabaseForTable(Object.class);
        collection = new Builder(new DatabaseExtensionsKt$processTransaction$1(function2)).addAll(collection);
        Intrinsics.a(collection, "ProcessModelTransaction.… wrapper) }).addAll(this)");
        i.beginTransactionAsync(collection.processListener(onModelProcessListener).build()).success(success).error(error).execute();
    }

    private static final <T> FastStoreModelTransaction.Builder<T> fastSave(Collection<? extends T> collection) {
        Intrinsics.b();
        return FastStoreModelTransaction.saveBuilder(FlowManager.getModelAdapter(Object.class)).addAll((Collection) collection);
    }

    private static final <T> FastStoreModelTransaction.Builder<T> fastInsert(Collection<? extends T> collection) {
        Intrinsics.b();
        return FastStoreModelTransaction.insertBuilder(FlowManager.getModelAdapter(Object.class)).addAll((Collection) collection);
    }

    private static final <T> FastStoreModelTransaction.Builder<T> fastUpdate(Collection<? extends T> collection) {
        Intrinsics.b();
        return FastStoreModelTransaction.updateBuilder(FlowManager.getModelAdapter(Object.class)).addAll((Collection) collection);
    }
}
