package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
final class FileKarmaDataSource$saveTopKarma$4<T, R> implements Function<Throwable, Boolean> {
    public static final FileKarmaDataSource$saveTopKarma$4 f15842a = new FileKarmaDataSource$saveTopKarma$4();

    FileKarmaDataSource$saveTopKarma$4() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Intrinsics.b((Throwable) obj, "it");
        Timber.e("Error during saving top karma", new Object[]{r4});
        return Boolean.valueOf(false);
    }
}
