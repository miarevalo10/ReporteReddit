package com.reddit.datalibrary.social.data.datasource.local;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bJ\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/local/ChatCountChangeDataSource;", "", "()V", "changeSubject", "Lio/reactivex/subjects/PublishSubject;", "getChangeSubject", "()Lio/reactivex/subjects/PublishSubject;", "chatCountChangeObservable", "Lio/reactivex/Observable;", "chatCountChanged", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatCountChangeDataSource.kt */
public final class ChatCountChangeDataSource {
    public static final ChatCountChangeDataSource f19838a = new ChatCountChangeDataSource();
    private static final PublishSubject<Object> f19839b;

    static {
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "PublishSubject.create()");
        f19839b = create;
    }

    private ChatCountChangeDataSource() {
    }

    public static Observable<Object> m21694a() {
        return f19839b;
    }

    public static void m21695b() {
        f19839b.onNext("");
    }
}
