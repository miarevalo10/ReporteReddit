package com.reddit.frontpage.sync.routine;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/sync/routine/SubredditSyncRoutine;", "Lcom/reddit/frontpage/sync/routine/SyncRoutine;", "syncId", "", "pollFrequency", "", "(IJ)V", "legacySubredditRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/LegacySubredditRepository;", "getLegacySubredditRepository$app_standardRelease", "()Lcom/reddit/datalibrary/frontpage/data/feature/legacy/LegacySubredditRepository;", "setLegacySubredditRepository$app_standardRelease", "(Lcom/reddit/datalibrary/frontpage/data/feature/legacy/LegacySubredditRepository;)V", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "getSubredditRepository$app_standardRelease", "()Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "setSubredditRepository$app_standardRelease", "(Lcom/reddit/frontpage/domain/repository/SubredditRepository;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditSyncRoutine.kt */
public abstract class SubredditSyncRoutine extends SyncRoutine {
    @Inject
    public LegacySubredditRepository f28857c;
    @Inject
    public SubredditRepository f28858d;

    private SubredditSyncRoutine(int i, long j) {
        super(i, j);
        FrontpageApplication.m28869e().a(this);
    }

    public final LegacySubredditRepository m29924b() {
        LegacySubredditRepository legacySubredditRepository = this.f28857c;
        if (legacySubredditRepository == null) {
            Intrinsics.m26844a("legacySubredditRepository");
        }
        return legacySubredditRepository;
    }

    public final SubredditRepository m29925c() {
        SubredditRepository subredditRepository = this.f28858d;
        if (subredditRepository == null) {
            Intrinsics.m26844a("subredditRepository");
        }
        return subredditRepository;
    }
}
