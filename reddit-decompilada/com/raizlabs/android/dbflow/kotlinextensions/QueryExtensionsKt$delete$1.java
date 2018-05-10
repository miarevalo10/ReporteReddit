package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.structure.AsyncModel.OnModelChangedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "it", "onModelChanged", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$delete$1<T> implements OnModelChangedListener<T> {
    final /* synthetic */ Function1 $listener;

    public QueryExtensionsKt$delete$1(Function1 function1) {
        this.$listener = function1;
    }

    public final void onModelChanged(T t) {
        Intrinsics.b(t, "it");
        this.$listener.a(t);
    }
}
