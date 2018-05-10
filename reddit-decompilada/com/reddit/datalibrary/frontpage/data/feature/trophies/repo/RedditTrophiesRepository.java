package com.reddit.datalibrary.frontpage.data.feature.trophies.repo;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import com.reddit.frontpage.domain.model.Trophy;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/trophies/repo/RedditTrophiesRepository;", "Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/trophies/remote/RemoteTrophiesDataSource;", "(Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/trophies/remote/RemoteTrophiesDataSource;)V", "getTrophies", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditTrophiesRepository.kt */
public final class RedditTrophiesRepository implements TrophiesRepository {
    private final BackgroundThread f16217a;
    private final RemoteTrophiesDataSource f16218b;

    public RedditTrophiesRepository(BackgroundThread backgroundThread, RemoteTrophiesDataSource remoteTrophiesDataSource) {
        Intrinsics.b(backgroundThread, "backgroundThread");
        Intrinsics.b(remoteTrophiesDataSource, "remote");
        this.f16217a = backgroundThread;
        this.f16218b = remoteTrophiesDataSource;
    }

    public final Single<List<Trophy>> m16189a(String str) {
        if (str == null) {
            Timber.e("NON-NULL-LOGGING_RedditTrophiesRepository.getTrophies:username-null=true", new Object[0]);
        }
        str = SinglesKt.a(this.f16218b.getTrophies(str), this.f16217a).map(RedditTrophiesRepository$getTrophies$1.f16216a);
        Intrinsics.a(str, "remote.getTrophies(usern…  )\n          }\n        }");
        return str;
    }
}
