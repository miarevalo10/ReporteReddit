package com.nytimes.android.external.cache3;

import com.nytimes.android.external.cache3.MoreObjects.ToStringHelper;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder<K, V> {
    static final Ticker f10110a = new C14261();
    private static final Logger f10111q = Logger.getLogger(CacheBuilder.class.getName());
    boolean f10112b = true;
    int f10113c = -1;
    int f10114d = -1;
    long f10115e = -1;
    long f10116f = -1;
    Weigher<? super K, ? super V> f10117g;
    Strength f10118h;
    Strength f10119i;
    long f10120j = -1;
    public long f10121k = -1;
    long f10122l = -1;
    Equivalence<Object> f10123m;
    Equivalence<Object> f10124n;
    RemovalListener<? super K, ? super V> f10125o;
    Ticker f10126p;

    class C14261 extends Ticker {
        public final long mo2662a() {
            return 0;
        }

        C14261() {
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

    CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> m8534a() {
        return new CacheBuilder();
    }

    public final CacheBuilder<K, V> m8535a(long j) {
        boolean z = false;
        Preconditions.m8676b(this.f10115e == -1, "maximum size was already set to %s", Long.valueOf(this.f10115e));
        Preconditions.m8676b(this.f10116f == -1, "maximum weight was already set to %s", Long.valueOf(this.f10116f));
        Preconditions.m8675b(this.f10117g == null, "maximum size can not be combined with weigher");
        if (j >= 0) {
            z = true;
        }
        Preconditions.m8673a(z, (Object) "maximum size must not be negative");
        this.f10115e = j;
        return this;
    }

    final Strength m8537b() {
        return (Strength) MoreObjects.m8667a(this.f10118h, Strength.f10168a);
    }

    final Strength m8538c() {
        return (Strength) MoreObjects.m8667a(this.f10119i, Strength.f10168a);
    }

    public final CacheBuilder<K, V> m8536a(long j, TimeUnit timeUnit) {
        Preconditions.m8676b(this.f10120j == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.f10120j));
        Preconditions.m8674a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.f10120j = timeUnit.toNanos(j);
        return this;
    }

    public final <K1 extends K, V1 extends V> Cache<K1, V1> m8539d() {
        m8540e();
        Preconditions.m8675b(this.f10122l == -1, "refreshAfterWrite requires a LoadingCache");
        return new LocalManualCache(this);
    }

    public final void m8540e() {
        boolean z = false;
        if (this.f10117g == null) {
            if (this.f10116f == -1) {
                z = true;
            }
            Preconditions.m8675b(z, "maximumWeight requires weigher");
        } else if (this.f10112b) {
            if (this.f10116f != -1) {
                z = true;
            }
            Preconditions.m8675b(z, "weigher requires maximumWeight");
        } else {
            if (this.f10116f == -1) {
                f10111q.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
            }
        }
    }

    public final String toString() {
        ToStringHelper a = MoreObjects.m8666a(this);
        if (this.f10113c != -1) {
            a.m8663a("initialCapacity", this.f10113c);
        }
        if (this.f10114d != -1) {
            a.m8663a("concurrencyLevel", this.f10114d);
        }
        if (this.f10115e != -1) {
            a.m8664a("maximumSize", this.f10115e);
        }
        if (this.f10116f != -1) {
            a.m8664a("maximumWeight", this.f10116f);
        }
        if (this.f10120j != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f10120j);
            stringBuilder.append("ns");
            a.m8665a("expireAfterWrite", stringBuilder.toString());
        }
        if (this.f10121k != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f10121k);
            stringBuilder.append("ns");
            a.m8665a("expireAfterAccess", stringBuilder.toString());
        }
        if (this.f10118h != null) {
            a.m8665a("keyStrength", Ascii.m8532a(this.f10118h.toString()));
        }
        if (this.f10119i != null) {
            a.m8665a("valueStrength", Ascii.m8532a(this.f10119i.toString()));
        }
        if (this.f10123m != null) {
            a.m8662a("keyEquivalence");
        }
        if (this.f10124n != null) {
            a.m8662a("valueEquivalence");
        }
        if (this.f10125o != null) {
            a.m8662a("removalListener");
        }
        return a.toString();
    }
}
