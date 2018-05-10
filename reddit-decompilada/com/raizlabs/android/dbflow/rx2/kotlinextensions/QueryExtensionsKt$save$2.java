package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "success", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$save$2<T> implements Consumer<Boolean> {
    final /* synthetic */ Function1 $func;

    public QueryExtensionsKt$save$2(Function1 function1) {
        this.$func = function1;
    }

    public final void accept(Boolean bool) {
        Function1 function1 = this.$func;
        Intrinsics.a(bool, "success");
        function1.a(bool);
    }
}
