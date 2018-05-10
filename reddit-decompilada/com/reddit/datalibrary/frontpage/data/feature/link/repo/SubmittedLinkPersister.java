package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.RecordProvider;
import com.nytimes.android.external.store3.base.RecordState;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.UserLinkKey;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00040\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/repo/SubmittedLinkPersister;", "Lcom/nytimes/android/external/store3/base/Persister;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/UserLinkKey;", "Lcom/nytimes/android/external/store3/base/RecordProvider;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "(Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;)V", "getRecordState", "Lcom/nytimes/android/external/store3/base/RecordState;", "key", "read", "Lio/reactivex/Maybe;", "write", "Lio/reactivex/Single;", "", "links", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class SubmittedLinkPersister implements Persister<Listing<? extends Link>, UserLinkKey>, RecordProvider<UserLinkKey> {
    private final LocalLinkDataSource f18704a;

    public SubmittedLinkPersister(LocalLinkDataSource localLinkDataSource) {
        Intrinsics.b(localLinkDataSource, "local");
        this.f18704a = localLinkDataSource;
    }

    public final /* synthetic */ Maybe mo2708a(Object obj) {
        UserLinkKey userLinkKey = (UserLinkKey) obj;
        Intrinsics.b(userLinkKey, "key");
        return this.f18704a.mo2958a(userLinkKey.f16048a, userLinkKey.f16049b, userLinkKey.f16050c, userLinkKey.f16051d);
    }

    public final /* synthetic */ Single mo2709a(Object obj, Object obj2) {
        UserLinkKey userLinkKey = (UserLinkKey) obj;
        Listing listing = (Listing) obj2;
        Intrinsics.b(userLinkKey, "key");
        Intrinsics.b(listing, "links");
        return this.f18704a.mo2962a(listing, userLinkKey.f16048a, userLinkKey.f16049b, userLinkKey.f16050c, userLinkKey.f16051d);
    }

    public final /* bridge */ /* synthetic */ RecordState mo3787b(Object obj) {
        Intrinsics.b((UserLinkKey) obj, "key");
        return RecordState.STALE;
    }
}
