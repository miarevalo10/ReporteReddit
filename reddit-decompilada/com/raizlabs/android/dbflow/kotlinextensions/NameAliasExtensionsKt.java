package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.language.NameAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"nameAlias", "Lcom/raizlabs/android/dbflow/sql/language/NameAlias;", "", "getNameAlias", "(Ljava/lang/String;)Lcom/raizlabs/android/dbflow/sql/language/NameAlias;", "as", "alias", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: NameAliasExtensions.kt */
public final class NameAliasExtensionsKt {
    public static final NameAlias getNameAlias(String str) {
        Intrinsics.b(str, "$receiver");
        return NameAlias.of(str);
    }

    public static final NameAlias as(String str, String str2) {
        Intrinsics.b(str, "$receiver");
        return NameAlias.of(str, str2);
    }

    public static /* synthetic */ NameAlias as$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        return as(str, str2);
    }
}
