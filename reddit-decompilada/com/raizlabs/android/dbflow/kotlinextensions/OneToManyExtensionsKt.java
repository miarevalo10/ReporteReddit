package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"oneToMany", "Lcom/raizlabs/android/dbflow/kotlinextensions/OneToMany;", "T", "", "query", "Lkotlin/Function0;", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: OneToManyExtensions.kt */
public final class OneToManyExtensionsKt {
    public static final <T> OneToMany<T> oneToMany(Function0<? extends ModelQueriable<T>> function0) {
        Intrinsics.b(function0, "query");
        return new OneToMany(function0);
    }
}
