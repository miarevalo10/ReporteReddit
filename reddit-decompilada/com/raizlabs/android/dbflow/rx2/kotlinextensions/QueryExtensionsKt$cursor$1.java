package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import android.database.Cursor;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "cursor", "Landroid/database/Cursor;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$cursor$1<T> implements Consumer<Cursor> {
    final /* synthetic */ Function1 $func;

    public QueryExtensionsKt$cursor$1(Function1 function1) {
        this.$func = function1;
    }

    public final void accept(Cursor cursor) {
        Function1 function1 = this.$func;
        Intrinsics.a(cursor, "cursor");
        function1.a(cursor);
    }
}
