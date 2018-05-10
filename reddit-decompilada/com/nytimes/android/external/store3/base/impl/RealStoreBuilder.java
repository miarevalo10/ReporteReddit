package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.store3.base.DiskRead;
import com.nytimes.android.external.store3.base.DiskWrite;
import com.nytimes.android.external.store3.base.Fetcher;
import com.nytimes.android.external.store3.base.Parser;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.util.KeyParser;
import com.nytimes.android.external.store3.util.NoKeyParser;
import com.nytimes.android.external.store3.util.NoopParserFunc;
import com.nytimes.android.external.store3.util.NoopPersister;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;

public class RealStoreBuilder<Raw, Parsed, Key> {
    public Persister<Raw, Key> f10248a;
    public Fetcher<Raw, Key> f10249b;
    public MemoryPolicy f10250c;
    public StalePolicy f10251d = StalePolicy.UNSPECIFIED;
    private final List<KeyParser> f10252e = new ArrayList();

    class C16861 implements Persister<Raw, Key> {
        final /* synthetic */ DiskRead f18672a;
        final /* synthetic */ DiskWrite f18673b;

        public final Maybe<Raw> mo2708a(Key key) {
            return this.f18672a.mo2708a(key);
        }

        public final Single<Boolean> mo2709a(Key key, Raw raw) {
            return this.f18673b.mo2709a(key, raw);
        }
    }

    public final RealStoreBuilder<Raw, Parsed, Key> m8705a() {
        this.f10251d = StalePolicy.NETWORK_BEFORE_STALE;
        return this;
    }

    public final Store<Parsed, Key> m8706b() {
        if (this.f10248a == null) {
            this.f10248a = NoopPersister.m19634a(this.f10250c);
        }
        if (this.f10252e.isEmpty()) {
            Parser noopParserFunc = new NoopParserFunc();
            this.f10252e.clear();
            this.f10252e.add(new NoKeyParser(noopParserFunc));
        }
        return new RealStore(new RealInternalStore(this.f10249b, this.f10248a, new MultiParser(this.f10252e), this.f10250c, this.f10251d));
    }
}
