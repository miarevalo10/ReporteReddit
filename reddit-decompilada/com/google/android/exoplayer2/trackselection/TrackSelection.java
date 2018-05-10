package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

public interface TrackSelection {

    public interface Factory {
        TrackSelection mo1454a(TrackGroup trackGroup, int... iArr);
    }

    int mo3368a();

    int mo1455a(Format format);

    Format mo1456a(int i);

    void mo3369a(long j);

    int mo3370b();

    int mo1457b(int i);

    int mo1458c(int i);

    Object mo3371c();

    TrackGroup mo1459d();

    boolean mo1460d(int i);

    int mo1461e();

    Format mo1462f();

    int mo1463g();
}
