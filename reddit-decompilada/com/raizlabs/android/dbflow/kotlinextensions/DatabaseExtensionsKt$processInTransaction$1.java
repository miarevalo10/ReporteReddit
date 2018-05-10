package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "db", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 1, 7})
/* compiled from: DatabaseExtensions.kt */
public final class DatabaseExtensionsKt$processInTransaction$1 implements ITransaction {
    final /* synthetic */ Function2 $processFunction;
    final /* synthetic */ Collection receiver$0;

    public DatabaseExtensionsKt$processInTransaction$1(Collection collection, Function2 function2) {
        this.receiver$0 = collection;
        this.$processFunction = function2;
    }

    public final void execute(DatabaseWrapper databaseWrapper) {
        for (Object next : this.receiver$0) {
            Function2 function2 = this.$processFunction;
            Intrinsics.a(databaseWrapper, "db");
            function2.a(next, databaseWrapper);
        }
    }
}
