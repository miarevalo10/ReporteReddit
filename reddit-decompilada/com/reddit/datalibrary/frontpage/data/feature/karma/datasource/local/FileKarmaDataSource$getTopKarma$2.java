package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import com.squareup.moshi.JsonAdapter;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Karma;", "it", "Lokio/BufferedSource;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
final class FileKarmaDataSource$getTopKarma$2<T, R> implements Function<T, R> {
    final /* synthetic */ FileKarmaDataSource f15838a;

    FileKarmaDataSource$getTopKarma$2(FileKarmaDataSource fileKarmaDataSource) {
        this.f15838a = fileKarmaDataSource;
    }

    public final /* synthetic */ Object apply(Object obj) {
        BufferedSource bufferedSource = (BufferedSource) obj;
        Intrinsics.b(bufferedSource, "it");
        obj = ((JsonAdapter) this.f15838a.f15846d.b()).fromJson(bufferedSource);
        if (obj == null) {
            Intrinsics.a();
        }
        return (List) obj;
    }
}
