package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "", "model", "kotlin.jvm.PlatformType", "wrapper", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "processModel", "(Ljava/lang/Object;Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;)V"}, k = 3, mv = {1, 1, 7})
/* compiled from: DatabaseExtensions.kt */
public final class DatabaseExtensionsKt$processTransaction$1<TModel> implements ProcessModel<T> {
    final /* synthetic */ Function2 $processFunction;

    public DatabaseExtensionsKt$processTransaction$1(Function2 function2) {
        this.$processFunction = function2;
    }

    public final void processModel(T t, DatabaseWrapper databaseWrapper) {
        Function2 function2 = this.$processFunction;
        Intrinsics.a(t, "model");
        Intrinsics.a(databaseWrapper, "wrapper");
        function2.a(t, databaseWrapper);
    }
}
