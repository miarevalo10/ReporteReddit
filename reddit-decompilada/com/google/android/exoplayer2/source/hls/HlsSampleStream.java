package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleMetadataQueue;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {
    public final int f13407a;
    private final HlsSampleStreamWrapper f13408b;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.f13408b = hlsSampleStreamWrapper;
        this.f13407a = i;
    }

    public final boolean mo1399a() {
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f13408b;
        int i = this.f13407a;
        if (!hlsSampleStreamWrapper.f13432t) {
            if (hlsSampleStreamWrapper.m12528j() || !hlsSampleStreamWrapper.f13419g[i].f13275a.m3956b()) {
                return false;
            }
        }
        return true;
    }

    public final void mo1400b() throws IOException {
        this.f13408b.m12520c();
    }

    public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f13408b;
        int i = this.f13407a;
        if (hlsSampleStreamWrapper.m12528j()) {
            return -3;
        }
        if (!hlsSampleStreamWrapper.f13417e.isEmpty()) {
            while (true) {
                Object obj = 1;
                if (hlsSampleStreamWrapper.f13417e.size() <= 1) {
                    break;
                }
                int i2 = ((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.getFirst()).f18975a;
                for (int i3 = 0; i3 < hlsSampleStreamWrapper.f13419g.length; i3++) {
                    if (hlsSampleStreamWrapper.f13428p[i3]) {
                        SampleMetadataQueue sampleMetadataQueue = hlsSampleStreamWrapper.f13419g[i3].f13275a;
                        if ((sampleMetadataQueue.m3956b() ? sampleMetadataQueue.f4759a[sampleMetadataQueue.m3955b(sampleMetadataQueue.f4763e)] : sampleMetadataQueue.f4769k) == i2) {
                            obj = null;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    break;
                }
                hlsSampleStreamWrapper.f13417e.removeFirst();
            }
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) hlsSampleStreamWrapper.f13417e.getFirst();
            Format format = hlsMediaChunk.e;
            if (!format.equals(hlsSampleStreamWrapper.f13423k)) {
                hlsSampleStreamWrapper.f13416d.m3922a(hlsSampleStreamWrapper.f13413a, format, hlsMediaChunk.f, hlsMediaChunk.g, hlsMediaChunk.h);
            }
            hlsSampleStreamWrapper.f13423k = format;
        }
        return hlsSampleStreamWrapper.f13419g[i].m12350a(formatHolder, decoderInputBuffer, z, hlsSampleStreamWrapper.f13432t, hlsSampleStreamWrapper.f13429q);
    }

    public final void mo1398a(long j) {
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f13408b;
        SampleQueue sampleQueue = hlsSampleStreamWrapper.f13419g[this.f13407a];
        if (!hlsSampleStreamWrapper.f13432t || j <= sampleQueue.f13275a.m3958d()) {
            sampleQueue.m12358a(j, true);
        } else {
            sampleQueue.f13275a.m3960f();
        }
    }
}
