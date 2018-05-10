package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.io.IOException;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback<MediaPeriod> {
        void mo3347a(MediaPeriod mediaPeriod);
    }

    long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    void mo3352a(long j);

    void mo3353a(Callback callback, long j);

    long mo3354b(long j);

    TrackGroupArray mo3355b();

    void b_() throws IOException;

    long mo3357c();

    boolean mo1401c(long j);

    long mo1402d();

    long mo1403e();
}
