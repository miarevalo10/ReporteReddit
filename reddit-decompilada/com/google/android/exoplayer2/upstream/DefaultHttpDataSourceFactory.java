package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties;
import io.fabric.sdk.android.services.events.EventsFilesManager;

public final class DefaultHttpDataSourceFactory extends BaseFactory {
    private final String f19068a;
    private final TransferListener<? super DataSource> f19069b;
    private final int f19070c;
    private final int f19071d;
    private final boolean f19072e;

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener) {
        this(str, transferListener, (byte) 0);
    }

    private DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener, byte b) {
        this.f19068a = str;
        this.f19069b = transferListener;
        this.f19070c = EventsFilesManager.MAX_BYTE_SIZE_PER_FILE;
        this.f19071d = EventsFilesManager.MAX_BYTE_SIZE_PER_FILE;
        this.f19072e = null;
    }

    protected final /* synthetic */ HttpDataSource mo3932a(RequestProperties requestProperties) {
        return new DefaultHttpDataSource(this.f19068a, this.f19069b, this.f19070c, this.f19071d, this.f19072e, requestProperties);
    }
}
