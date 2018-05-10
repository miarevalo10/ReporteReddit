package com.reddit.datalibrary.frontpage.data.feature.karma.repo;

import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.RecordProvider;
import com.nytimes.android.external.store3.base.RecordState;
import com.reddit.frontpage.domain.model.Karma;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00040\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0011"}, d2 = {"com/reddit/datalibrary/frontpage/data/feature/karma/repo/RedditKarmaRepository$store$2$perister$1", "Lcom/nytimes/android/external/store3/base/Persister;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "", "Lcom/nytimes/android/external/store3/base/RecordProvider;", "(Lcom/reddit/datalibrary/frontpage/data/feature/karma/repo/RedditKarmaRepository$store$2;)V", "getRecordState", "Lcom/nytimes/android/external/store3/base/RecordState;", "key", "read", "Lio/reactivex/Maybe;", "username", "write", "Lio/reactivex/Single;", "", "topKarma", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditKarmaRepository.kt */
public final class RedditKarmaRepository$store$2$perister$1 implements Persister<List<? extends Karma>, String>, RecordProvider<String> {
    final /* synthetic */ RedditKarmaRepository$store$2 f18690a;

    RedditKarmaRepository$store$2$perister$1(RedditKarmaRepository$store$2 redditKarmaRepository$store$2) {
        this.f18690a = redditKarmaRepository$store$2;
    }

    public final /* synthetic */ Maybe mo2708a(Object obj) {
        String str = (String) obj;
        Intrinsics.b(str, "username");
        return this.f18690a.f19362a.f15856e.mo2927a(str);
    }

    public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
        String str = (String) obj;
        List list = (List) obj2;
        Intrinsics.b(str, "username");
        Intrinsics.b(list, "topKarma");
        return this.f18690a.f19362a.f15856e.mo2928a(str, list);
    }

    public final /* bridge */ /* synthetic */ RecordState mo3787b(Object obj) {
        Intrinsics.b((String) obj, "key");
        return RecordState.STALE;
    }
}
