package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.nytimes.android.external.fs3.FileSystemPersister;
import com.nytimes.android.external.fs3.PathResolver;
import com.nytimes.android.external.fs3.filesystem.FileSystemFactory;
import com.nytimes.android.external.store3.base.Persister;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "kotlin.jvm.PlatformType", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkListingKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileLinkDataSource.kt */
final class FileLinkDataSource$linkListingPersister$2 extends Lambda implements Function0<Persister<BufferedSource, LinkListingKey>> {
    final /* synthetic */ FileLinkDataSource f19398a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LinkListingKey;", "resolve"}, k = 3, mv = {1, 1, 9})
    /* compiled from: FileLinkDataSource.kt */
    static final class C15021<T> implements PathResolver<T> {
        public static final C15021 f16031a = new C15021();

        C15021() {
        }

        public final /* synthetic */ String mo2926a(Object obj) {
            LinkListingKey linkListingKey = (LinkListingKey) obj;
            Intrinsics.b(linkListingKey, "it");
            return linkListingKey.toString();
        }
    }

    FileLinkDataSource$linkListingPersister$2(FileLinkDataSource fileLinkDataSource) {
        this.f19398a = fileLinkDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return FileSystemPersister.m19614a(FileSystemFactory.m8691a(((File) this.f19398a.f16036c.b())), (PathResolver) C15021.f16031a);
    }
}
