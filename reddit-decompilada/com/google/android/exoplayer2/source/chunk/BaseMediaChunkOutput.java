package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider;

final class BaseMediaChunkOutput implements TrackOutputProvider {
    final SampleQueue[] f13300a;
    private final int[] f13301b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f13301b = iArr;
        this.f13300a = sampleQueueArr;
    }

    public final TrackOutput mo1414a(int i) {
        for (int i2 = 0; i2 < this.f13301b.length; i2++) {
            if (i == this.f13301b[i2]) {
                return this.f13300a[i2];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Unmatched track of type: ");
        stringBuilder.append(i);
        Log.e("BaseMediaChunkOutput", stringBuilder.toString());
        return new DummyTrackOutput();
    }

    public final void m12368a(long j) {
        for (SampleQueue sampleQueue : this.f13300a) {
            if (!(sampleQueue == null || sampleQueue.f13277c == j)) {
                sampleQueue.f13277c = j;
                sampleQueue.f13276b = true;
            }
        }
    }
}
