package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import com.squareup.moshi.JsonAdapter;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import okio.Buffer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokio/Buffer;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
final class FileKarmaDataSource$saveTopKarma$2<V> implements Callable<T> {
    final /* synthetic */ FileKarmaDataSource f10411a;
    final /* synthetic */ List f10412b;

    FileKarmaDataSource$saveTopKarma$2(FileKarmaDataSource fileKarmaDataSource, List list) {
        this.f10411a = fileKarmaDataSource;
        this.f10412b = list;
    }

    public final /* synthetic */ Object call() {
        return new Buffer().a(((JsonAdapter) this.f10411a.f15846d.b()).toJson(this.f10412b));
    }
}
