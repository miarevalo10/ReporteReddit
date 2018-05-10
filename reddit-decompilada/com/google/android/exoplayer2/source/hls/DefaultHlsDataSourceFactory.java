package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource.Factory;

public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {
    private final Factory f13400a;

    public DefaultHlsDataSourceFactory(Factory factory) {
        this.f13400a = factory;
    }

    public final DataSource mo1438a() {
        return this.f13400a.mo1475a();
    }
}
