package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class ParsingLoadable<T> implements Loadable {
    public final DataSpec f13682a;
    public final int f13683b;
    public volatile T f13684c;
    public volatile long f13685d;
    private final DataSource f13686e;
    private final Parser<? extends T> f13687f;
    private volatile boolean f13688g;

    public interface Parser<T> {
        T mo1422a(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i, Parser<? extends T> parser) {
        this.f13686e = dataSource;
        this.f13682a = new DataSpec(uri);
        this.f13683b = i;
        this.f13687f = parser;
    }

    public final void mo1404a() {
        this.f13688g = true;
    }

    public final boolean mo1405b() {
        return this.f13688g;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        Closeable dataSourceInputStream = new DataSourceInputStream(this.f13686e, this.f13682a);
        try {
            dataSourceInputStream.m4148a();
            this.f13684c = this.f13687f.mo1422a(this.f13686e.mo1437b(), dataSourceInputStream);
        } finally {
            this.f13685d = dataSourceInputStream.f5161a;
            Util.m4308a(dataSourceInputStream);
        }
    }
}
