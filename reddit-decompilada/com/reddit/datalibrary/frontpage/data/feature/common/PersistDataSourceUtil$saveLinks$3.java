package com.reddit.datalibrary.frontpage.data.feature.common;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/common/Key;", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: PersistDataSourceUtil.kt */
final class PersistDataSourceUtil$saveLinks$3<T, R> implements Function<Throwable, Boolean> {
    public static final PersistDataSourceUtil$saveLinks$3 f15824a = new PersistDataSourceUtil$saveLinks$3();

    PersistDataSourceUtil$saveLinks$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.b((Throwable) obj, "it");
        Timber.e("Error saving links", new Object[]{r4});
        return Boolean.valueOf(false);
    }
}
