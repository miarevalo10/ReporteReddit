package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.cache3.Cache;
import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.InternalStore;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.util.KeyParser;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.subjects.PublishSubject;

final class RealInternalStore<Raw, Parsed, Key> implements InternalStore<Parsed, Key> {
    Cache<Key, Single<Parsed>> f18664a;
    Cache<Key, Maybe<Parsed>> f18665b;
    StalePolicy f18666c;
    Persister<Raw, Key> f18667d;
    KeyParser<Key, Raw, Parsed> f18668e;
    PublishSubject<Parsed> f18669f;
    private final PublishSubject<Key> f18670g = PublishSubject.create();
    private Fetcher<Raw, Key> f18671h;

    RealInternalStore(Fetcher<Raw, Key> fetcher, Persister<Raw, Key> persister, KeyParser<Key, Raw, Parsed> keyParser, MemoryPolicy memoryPolicy, StalePolicy stalePolicy) {
        this.f18671h = fetcher;
        this.f18667d = persister;
        this.f18668e = keyParser;
        this.f18666c = stalePolicy;
        this.f18665b = CacheFactory.m8696a(memoryPolicy);
        this.f18664a = CacheFactory.m8697b(memoryPolicy);
        this.f18669f = PublishSubject.create();
    }

    private io.reactivex.Maybe<Parsed> m19622c(Key r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.f18665b;	 Catch:{ ExecutionException -> 0x000d }
        r1 = com.nytimes.android.external.store3.base.impl.RealInternalStore$$Lambda$2.m8702a(r2, r3);	 Catch:{ ExecutionException -> 0x000d }
        r3 = r0.get(r3, r1);	 Catch:{ ExecutionException -> 0x000d }
        r3 = (io.reactivex.Maybe) r3;	 Catch:{ ExecutionException -> 0x000d }
        return r3;
    L_0x000d:
        r3 = io.reactivex.Maybe.empty();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.store3.base.impl.RealInternalStore.c(java.lang.Object):io.reactivex.Maybe<Parsed>");
    }

    public final Single<Parsed> mo2714b(Key key) {
        return Single.defer(RealInternalStore$$Lambda$7.m8703a(this, key));
    }

    private Single<Parsed> m19628e(Key key) {
        try {
            return (Single) this.f18664a.get(key, RealInternalStore$$Lambda$8.m8704a(this, key));
        } catch (Key key2) {
            return Single.error(key2);
        }
    }

    static /* synthetic */ SingleSource m19618a(RealInternalStore realInternalStore, Object obj, Throwable th) throws Exception {
        if (realInternalStore.f18666c == StalePolicy.NETWORK_BEFORE_STALE) {
            return realInternalStore.m19625d(obj).switchIfEmpty(Maybe.error(th)).toSingle();
        }
        return Single.error(th);
    }

    public final Single<Parsed> mo2713a(Key key) {
        return Maybe.defer(RealInternalStore$$Lambda$1.m8701a(this, key)).onErrorResumeNext(Maybe.empty()).switchIfEmpty(mo2714b(key).toMaybe()).toSingle();
    }

    private Maybe<Parsed> m19625d(Key key) {
        return this.f18667d.mo2708a(key).onErrorResumeNext(Maybe.empty()).map(RealInternalStore$$Lambda$3.m15698a(this, key)).doOnSuccess(RealInternalStore$$Lambda$4.m15699a(this, key)).cache();
    }

    static /* synthetic */ void m19621b(RealInternalStore realInternalStore, Object obj, Object obj2) throws Exception {
        realInternalStore.f18665b.put(obj, Maybe.just(obj2));
        if (realInternalStore.f18666c == StalePolicy.REFRESH_ON_STALE && StoreUtil.m8713a(obj, realInternalStore.f18667d) != null) {
            realInternalStore.mo2714b(obj).subscribe(RealInternalStore$$Lambda$5.m15700a(), RealInternalStore$$Lambda$6.m15701a());
        }
    }

    static /* synthetic */ Maybe m19627e(RealInternalStore realInternalStore, Object obj) throws Exception {
        if (StoreUtil.m8712a(realInternalStore.f18667d, realInternalStore.f18666c, obj)) {
            return Maybe.empty();
        }
        return realInternalStore.m19625d(obj);
    }
}
