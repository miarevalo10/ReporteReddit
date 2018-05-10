package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource.Factory;

public final class DefaultDataSourceFactory implements Factory {
    private final Context f13667a;
    private final TransferListener<? super DataSource> f13668b;
    private final Factory f13669c;

    public DefaultDataSourceFactory(Context context, TransferListener<? super DataSource> transferListener, Factory factory) {
        this.f13667a = context.getApplicationContext();
        this.f13668b = transferListener;
        this.f13669c = factory;
    }

    public final /* synthetic */ DataSource mo1475a() {
        return new DefaultDataSource(this.f13667a, this.f13668b, this.f13669c.mo1475a());
    }
}
