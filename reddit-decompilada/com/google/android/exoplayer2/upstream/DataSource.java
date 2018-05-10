package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

public interface DataSource {

    public interface Factory {
        DataSource mo1475a();
    }

    int mo1434a(byte[] bArr, int i, int i2) throws IOException;

    long mo1435a(DataSpec dataSpec) throws IOException;

    void mo1436a() throws IOException;

    Uri mo1437b();
}
