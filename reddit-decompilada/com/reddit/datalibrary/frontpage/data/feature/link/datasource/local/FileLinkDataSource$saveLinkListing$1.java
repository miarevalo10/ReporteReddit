package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.nytimes.android.external.store3.base.Persister;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkListingKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
final class FileLinkDataSource$saveLinkListing$1 extends Lambda implements Function0<Persister<BufferedSource, LinkListingKey>> {
    final /* synthetic */ FileLinkDataSource f19401a;

    FileLinkDataSource$saveLinkListing$1(FileLinkDataSource fileLinkDataSource) {
        this.f19401a = fileLinkDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return ((Persister) this.f19401a.f16040g.b());
    }
}
