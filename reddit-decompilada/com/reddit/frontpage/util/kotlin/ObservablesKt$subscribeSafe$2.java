package com.reddit.frontpage.util.kotlin;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: Observables.kt */
final class ObservablesKt$subscribeSafe$2<T> implements Consumer<Throwable> {
    public static final ObservablesKt$subscribeSafe$2 f29410a = new ObservablesKt$subscribeSafe$2();

    ObservablesKt$subscribeSafe$2() {
    }

    public final /* synthetic */ void accept(Object obj) {
        Timber.c((Throwable) obj, null, new Object[0]);
    }
}
