package com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local;

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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FileKarmaDataSource.kt */
final class FileKarmaDataSource$persister$2 extends Lambda implements Function0<Persister<BufferedSource, String>> {
    final /* synthetic */ FileKarmaDataSource f19361a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", "resolve"}, k = 3, mv = {1, 1, 9})
    /* compiled from: FileKarmaDataSource.kt */
    static final class C14961<T> implements PathResolver<T> {
        public static final C14961 f15839a = new C14961();

        C14961() {
        }

        public final /* synthetic */ String mo2926a(Object obj) {
            String str = (String) obj;
            Intrinsics.b(str, "it");
            return str;
        }
    }

    FileKarmaDataSource$persister$2(FileKarmaDataSource fileKarmaDataSource) {
        this.f19361a = fileKarmaDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return FileSystemPersister.m19614a(FileSystemFactory.m8691a(((File) this.f19361a.f15845c.b())), (PathResolver) C14961.f15839a);
    }
}
