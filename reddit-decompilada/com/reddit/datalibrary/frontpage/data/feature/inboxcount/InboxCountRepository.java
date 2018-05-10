package com.reddit.datalibrary.frontpage.data.feature.inboxcount;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.BadgeCount;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/inboxcount/InboxCountRepository;", "", "()V", "inboxCount", "Lcom/reddit/datalibrary/frontpage/data/feature/inboxcount/InboxCountRepository$InboxCount;", "getInboxCount", "()Lcom/reddit/datalibrary/frontpage/data/feature/inboxcount/InboxCountRepository$InboxCount;", "setInboxCount", "(Lcom/reddit/datalibrary/frontpage/data/feature/inboxcount/InboxCountRepository$InboxCount;)V", "inboxCountSubject", "Lio/reactivex/subjects/BehaviorSubject;", "getInboxCountSubject", "()Lio/reactivex/subjects/BehaviorSubject;", "decrementMessageCount", "", "decrementModMailCount", "decrementNotificationCount", "fetchBadgeCount", "inboxCountObservable", "Lio/reactivex/Observable;", "refresh", "", "markAllRead", "processBadgeCount", "badgeCount", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/BadgeCount;", "InboxCount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InboxCountRepository.kt */
public final class InboxCountRepository {
    public static final InboxCountRepository f10408a = new InboxCountRepository();
    private static final BehaviorSubject<InboxCount> f10409b;
    private static InboxCount f10410c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/inboxcount/InboxCountRepository$InboxCount;", "", "notificationCount", "", "messageCount", "modMailCount", "(III)V", "getMessageCount", "()I", "setMessageCount", "(I)V", "getModMailCount", "setModMailCount", "getNotificationCount", "setNotificationCount", "clearAll", "", "decrementMessageCount", "decrementModMailCount", "decrementNotificationCount", "getInboxCount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: InboxCountRepository.kt */
    public static final class InboxCount {
        public int f10405a;
        public int f10406b;
        public int f10407c = 0;

        public InboxCount(int i, int i2) {
            this.f10405a = i;
            this.f10406b = i2;
        }

        public final void m8833a() {
            this.f10405a = 0;
            this.f10406b = 0;
            this.f10407c = 0;
        }
    }

    static {
        BehaviorSubject a = BehaviorSubject.a();
        Intrinsics.a(a, "BehaviorSubject.create()");
        f10409b = a;
    }

    private InboxCountRepository() {
    }

    public static void m8834a() {
        InboxCount inboxCount = f10410c;
        if (inboxCount != null) {
            if (inboxCount.f10406b > 0) {
                inboxCount.f10406b--;
            }
            f10409b.onNext(inboxCount);
        }
    }

    public static void m8836b() {
        InboxCount inboxCount = f10410c;
        if (inboxCount != null) {
            if (inboxCount.f10405a > 0) {
                inboxCount.f10405a--;
            }
            f10409b.onNext(inboxCount);
        }
    }

    public static void m8837c() {
        InboxCount inboxCount = f10410c;
        if (inboxCount != null) {
            if (inboxCount.f10407c > 0) {
                inboxCount.f10407c--;
            }
            f10409b.onNext(inboxCount);
        }
    }

    public static void m8835a(BadgeCount badgeCount) {
        Intrinsics.b(badgeCount, "badgeCount");
        InboxCount inboxCount = new InboxCount(badgeCount.a(), badgeCount.b());
        f10409b.onNext(inboxCount);
        f10410c = inboxCount;
    }

    public static void m8838d() {
        InboxCount inboxCount = f10410c;
        if (inboxCount != null) {
            inboxCount.m8833a();
            f10409b.onNext(inboxCount);
        }
    }

    public static void m8839e() {
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        if (b.m9203c().isAnonymous()) {
            InboxCount inboxCount = f10410c;
            if (inboxCount != null) {
                inboxCount.m8833a();
                f10409b.onNext(inboxCount);
                return;
            }
            return;
        }
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        RemoteRedditApiDataSource.m8902b().subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(InboxCountRepository$fetchBadgeCount$1.f15836a, InboxCountRepository$fetchBadgeCount$2.f15837a);
    }

    public static Observable<InboxCount> m8840f() {
        if (f10410c == null) {
            m8839e();
        }
        return f10409b;
    }
}
