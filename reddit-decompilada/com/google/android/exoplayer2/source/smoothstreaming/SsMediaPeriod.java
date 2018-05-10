package com.google.android.exoplayer2.source.smoothstreaming;

import android.util.Base64;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader.Callback;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;
import java.util.ArrayList;

final class SsMediaPeriod implements MediaPeriod, Callback<ChunkSampleStream<SsChunkSource>> {
    MediaPeriod.Callback f17019a;
    SsManifest f17020b;
    ChunkSampleStream<SsChunkSource>[] f17021c;
    private final Factory f17022d;
    private final LoaderErrorThrower f17023e;
    private final int f17024f;
    private final EventDispatcher f17025g;
    private final Allocator f17026h;
    private final TrackGroupArray f17027i;
    private final TrackEncryptionBox[] f17028j;
    private CompositeSequenceableLoader f17029k;

    public final void mo3352a(long j) {
    }

    public final long mo3357c() {
        return -9223372036854775807L;
    }

    public SsMediaPeriod(SsManifest ssManifest, Factory factory, int i, EventDispatcher eventDispatcher, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f17022d = factory;
        this.f17023e = loaderErrorThrower;
        this.f17024f = i;
        this.f17025g = eventDispatcher;
        this.f17026h = allocator;
        this.f17027i = m17310a(ssManifest);
        factory = ssManifest.f4920e;
        if (factory != null) {
            byte[] a = m17312a(factory.f4899b);
            this.f17028j = new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, a, 0, 0, null)};
        } else {
            this.f17028j = null;
        }
        this.f17020b = ssManifest;
        this.f17021c = new ChunkSampleStream[0];
        this.f17029k = new CompositeSequenceableLoader(this.f17021c);
    }

    public final void mo3353a(MediaPeriod.Callback callback, long j) {
        this.f17019a = callback;
        callback.mo3347a(this);
    }

    public final void b_() throws IOException {
        this.f17023e.mo1477c();
    }

    public final TrackGroupArray mo3355b() {
        return this.f17027i;
    }

    public final long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SsMediaPeriod ssMediaPeriod = this;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < trackSelectionArr2.length) {
            ChunkSampleStream chunkSampleStream;
            if (sampleStreamArr[i] != null) {
                chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i];
                if (trackSelectionArr2[i] != null) {
                    if (zArr[i]) {
                        arrayList.add(chunkSampleStream);
                    }
                }
                chunkSampleStream.m12394c();
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && trackSelectionArr2[i] != null) {
                TrackSelection trackSelection = trackSelectionArr2[i];
                int a = ssMediaPeriod.f17027i.m3975a(trackSelection.mo1459d());
                ChunkSource a2 = ssMediaPeriod.f17022d.mo1441a(ssMediaPeriod.f17023e, ssMediaPeriod.f17020b, a, trackSelection, ssMediaPeriod.f17028j);
                ChunkSampleStream chunkSampleStream2 = chunkSampleStream;
                chunkSampleStream = new ChunkSampleStream(ssMediaPeriod.f17020b.f4921f[a].f4900a, null, a2, ssMediaPeriod, ssMediaPeriod.f17026h, j, ssMediaPeriod.f17024f, ssMediaPeriod.f17025g);
                arrayList.add(chunkSampleStream2);
                sampleStreamArr[i] = chunkSampleStream2;
                zArr2[i] = true;
            }
            i++;
            trackSelectionArr2 = trackSelectionArr;
        }
        ssMediaPeriod.f17021c = new ChunkSampleStream[arrayList.size()];
        arrayList.toArray(ssMediaPeriod.f17021c);
        ssMediaPeriod.f17029k = new CompositeSequenceableLoader(ssMediaPeriod.f17021c);
        return j;
    }

    public final boolean mo1401c(long j) {
        return this.f17029k.mo1401c(j);
    }

    public final long mo1403e() {
        return this.f17029k.mo1403e();
    }

    public final long mo1402d() {
        return this.f17029k.mo1402d();
    }

    public final long mo3354b(long j) {
        for (ChunkSampleStream b : this.f17021c) {
            b.m12393b(j);
        }
        return j;
    }

    private static TrackGroupArray m17310a(SsManifest ssManifest) {
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.f4921f.length];
        for (int i = 0; i < ssManifest.f4921f.length; i++) {
            trackGroupArr[i] = new TrackGroup(ssManifest.f4921f[i].f4909j);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static byte[] m17312a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            stringBuilder.append((char) bArr[i]);
        }
        bArr = stringBuilder.toString();
        bArr = Base64.decode(bArr.substring(bArr.indexOf("<KID>") + 5, bArr.indexOf("</KID>")), 0);
        m17311a(bArr, 0, 3);
        m17311a(bArr, 1, 2);
        m17311a(bArr, 4, 5);
        m17311a(bArr, 6, 7);
        return bArr;
    }

    private static void m17311a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
