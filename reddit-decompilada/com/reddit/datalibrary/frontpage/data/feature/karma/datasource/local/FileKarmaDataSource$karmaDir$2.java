package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
final class FileKarmaDataSource$karmaDir$2 extends Lambda implements Function0<File> {
    final /* synthetic */ FileKarmaDataSource f19360a;

    FileKarmaDataSource$karmaDir$2(FileKarmaDataSource fileKarmaDataSource) {
        this.f19360a = fileKarmaDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new File(this.f19360a.f15849g.getCacheDir(), "karma");
    }
}
