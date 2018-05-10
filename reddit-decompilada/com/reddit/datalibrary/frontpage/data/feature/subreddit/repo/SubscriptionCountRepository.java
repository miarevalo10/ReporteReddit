package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0006\u0010\u0007R2\u0010\b\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u0004 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;", "", "()V", "value", "", "count", "setCount", "(I)V", "countSubject", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "decrement", "", "increment", "set", "subscriptionCountObservable", "Lio/reactivex/Observable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubscriptionCountRepository.kt */
public final class SubscriptionCountRepository {
    public int f10780a;
    private final BehaviorSubject<Integer> f10781b = BehaviorSubject.a();

    public final void m9126a(int i) {
        if (i >= 0) {
            this.f10780a = i;
            this.f10781b.onNext(Integer.valueOf(i));
        }
    }

    public final Observable<Integer> m9125a() {
        BehaviorSubject behaviorSubject = this.f10781b;
        Intrinsics.a(behaviorSubject, "countSubject");
        return behaviorSubject;
    }
}
