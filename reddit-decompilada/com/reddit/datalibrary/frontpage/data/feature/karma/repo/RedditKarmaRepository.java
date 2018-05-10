package com.reddit.datalibrary.frontpage.data.feature.karma.repo;

import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local.LocalKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote.RemoteKarmaDataSource;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/karma/repo/RedditKarmaRepository;", "Lcom/reddit/frontpage/domain/repository/KarmaRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/remote/RemoteKarmaDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/LocalKarmaDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/remote/RemoteKarmaDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/LocalKarmaDataSource;)V", "store", "Lcom/nytimes/android/external/store3/base/impl/Store;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "", "getStore", "()Lcom/nytimes/android/external/store3/base/impl/Store;", "store$delegate", "Lkotlin/Lazy;", "getTopKarma", "Lio/reactivex/Single;", "username", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditKarmaRepository.kt */
public final class RedditKarmaRepository implements KarmaRepository {
    static final /* synthetic */ KProperty[] f15852a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(RedditKarmaRepository.class), "store", "getStore()Lcom/nytimes/android/external/store3/base/impl/Store;"))};
    private final Lazy f15853b = LazyKt.a((Function0) new RedditKarmaRepository$store$2(this));
    private final BackgroundThread f15854c;
    private final RemoteKarmaDataSource f15855d;
    private final LocalKarmaDataSource f15856e;

    public RedditKarmaRepository(BackgroundThread backgroundThread, RemoteKarmaDataSource remoteKarmaDataSource, LocalKarmaDataSource localKarmaDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteKarmaDataSource, "remote");
        Intrinsics.b(localKarmaDataSource, "local");
        this.f15854c = backgroundThread;
        this.f15855d = remoteKarmaDataSource;
        this.f15856e = localKarmaDataSource;
    }

    public final Single<List<Karma>> m15916a(String str) {
        Intrinsics.b(str, "username");
        str = ((Store) this.f15853b.b()).mo2713a(str);
        Intrinsics.a(str, "store.get(username)");
        return SinglesKt.a(str, this.f15854c);
    }
}
