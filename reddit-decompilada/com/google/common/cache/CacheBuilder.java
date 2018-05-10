package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache.SimpleStatsCounter;
import com.google.common.cache.AbstractCache.StatsCounter;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder<K, V> {
    static final Supplier<? extends StatsCounter> f8250a = Suppliers.m6935a(new C11471());
    static final CacheStats f8251b = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<StatsCounter> f8252c = new C11482();
    static final Ticker f8253d = new C11493();
    private static final Logger f8254u = Logger.getLogger(CacheBuilder.class.getName());
    boolean f8255e = true;
    int f8256f = -1;
    int f8257g = -1;
    long f8258h = -1;
    long f8259i = -1;
    Weigher<? super K, ? super V> f8260j;
    Strength f8261k;
    Strength f8262l;
    long f8263m = -1;
    long f8264n = -1;
    long f8265o = -1;
    Equivalence<Object> f8266p;
    Equivalence<Object> f8267q;
    RemovalListener<? super K, ? super V> f8268r;
    Ticker f8269s;
    Supplier<? extends StatsCounter> f8270t = f8250a;

    static class C11471 implements StatsCounter {
        public final void mo2330a() {
        }

        public final void mo2331a(int i) {
        }

        public final void mo2332a(long j) {
        }

        public final void mo2334b(int i) {
        }

        public final void mo2335b(long j) {
        }

        C11471() {
        }

        public final CacheStats mo2333b() {
            return CacheBuilder.f8251b;
        }
    }

    static class C11482 implements Supplier<StatsCounter> {
        C11482() {
        }

        public final /* synthetic */ Object mo2328a() {
            return new SimpleStatsCounter();
        }
    }

    static class C11493 extends Ticker {
        public final long mo2329a() {
            return 0;
        }

        C11493() {
        }
    }

    enum NullListener implements RemovalListener<Object, Object> {
        ;

        private NullListener(String str) {
        }
    }

    enum OneWeigher implements Weigher<Object, Object> {
        ;

        private OneWeigher(String str) {
        }
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> m6950a() {
        return new CacheBuilder();
    }

    public final CacheBuilder<K, V> m6952b() {
        Object obj = Strength.f8319c;
        Preconditions.m6923b(this.f8261k == null, "Key strength was already set to %s", this.f8261k);
        this.f8261k = (Strength) Preconditions.m6908a(obj);
        return this;
    }

    final Strength m6953c() {
        return (Strength) MoreObjects.m6895a(this.f8261k, Strength.f8317a);
    }

    final Strength m6954d() {
        return (Strength) MoreObjects.m6895a(this.f8262l, Strength.f8317a);
    }

    public final String toString() {
        ToStringHelper a = MoreObjects.m6894a(this);
        if (this.f8256f != -1) {
            a.m6891a("initialCapacity", this.f8256f);
        }
        if (this.f8257g != -1) {
            a.m6891a("concurrencyLevel", this.f8257g);
        }
        if (this.f8258h != -1) {
            a.m6892a("maximumSize", this.f8258h);
        }
        if (this.f8259i != -1) {
            a.m6892a("maximumWeight", this.f8259i);
        }
        if (this.f8263m != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f8263m);
            stringBuilder.append("ns");
            a.m6893a("expireAfterWrite", stringBuilder.toString());
        }
        if (this.f8264n != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f8264n);
            stringBuilder.append("ns");
            a.m6893a("expireAfterAccess", stringBuilder.toString());
        }
        if (this.f8261k != null) {
            a.m6893a("keyStrength", Ascii.m6871a(this.f8261k.toString()));
        }
        if (this.f8262l != null) {
            a.m6893a("valueStrength", Ascii.m6871a(this.f8262l.toString()));
        }
        if (this.f8266p != null) {
            a.m6890a("keyEquivalence");
        }
        if (this.f8267q != null) {
            a.m6890a("valueEquivalence");
        }
        if (this.f8268r != null) {
            a.m6890a("removalListener");
        }
        return a.toString();
    }

    public final <K1 extends K, V1 extends V> LoadingCache<K1, V1> m6951a(CacheLoader<? super K1, V1> cacheLoader) {
        boolean z = false;
        if (this.f8260j == null) {
            if (this.f8259i == -1) {
                z = true;
            }
            Preconditions.m6922b(z, (Object) "maximumWeight requires weigher");
        } else if (this.f8255e) {
            if (this.f8259i != -1) {
                z = true;
            }
            Preconditions.m6922b(z, (Object) "weigher requires maximumWeight");
        } else if (this.f8259i == -1) {
            f8254u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
        return new LocalLoadingCache(this, cacheLoader);
    }
}
