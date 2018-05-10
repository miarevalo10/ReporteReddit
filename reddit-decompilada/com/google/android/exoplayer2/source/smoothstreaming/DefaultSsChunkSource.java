package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;

public class DefaultSsChunkSource implements SsChunkSource {
    private final LoaderErrorThrower f17011a;
    private final int f17012b;
    private final TrackSelection f17013c;
    private final ChunkExtractorWrapper[] f17014d;
    private final DataSource f17015e;
    private SsManifest f17016f;
    private int f17017g;
    private IOException f17018h;

    public static final class Factory implements com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory f13513a;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.f13513a = factory;
        }

        public final SsChunkSource mo1441a(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, TrackEncryptionBox[] trackEncryptionBoxArr) {
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, trackSelection, this.f13513a.mo1475a(), trackEncryptionBoxArr);
        }
    }

    public final void mo3360a(Chunk chunk) {
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, TrackSelection trackSelection, DataSource dataSource, TrackEncryptionBox[] trackEncryptionBoxArr) {
        SsManifest ssManifest2 = ssManifest;
        int i2 = i;
        TrackSelection trackSelection2 = trackSelection;
        this.f17011a = loaderErrorThrower;
        this.f17016f = ssManifest2;
        this.f17012b = i2;
        this.f17013c = trackSelection2;
        this.f17015e = dataSource;
        StreamElement streamElement = ssManifest2.f4921f[i2];
        this.f17014d = new ChunkExtractorWrapper[trackSelection.mo1461e()];
        int i3 = 0;
        while (i3 < r0.f17014d.length) {
            int b = trackSelection2.mo1457b(i3);
            Format format = streamElement.f4909j[b];
            int i4 = i3;
            Track track = r7;
            Track track2 = new Track(b, streamElement.f4900a, streamElement.f4902c, -9223372036854775807L, ssManifest2.f4922g, format, 0, trackEncryptionBoxArr, streamElement.f4900a == 2 ? 4 : 0, null, null);
            r0.f17014d[i4] = new ChunkExtractorWrapper(new FragmentedMp4Extractor(3, null, track), format);
            i3 = i4 + 1;
        }
    }

    public final void mo3376a(SsManifest ssManifest) {
        StreamElement streamElement = this.f17016f.f4921f[this.f17012b];
        int i = streamElement.f4910k;
        StreamElement streamElement2 = ssManifest.f4921f[this.f17012b];
        if (i != 0) {
            if (streamElement2.f4910k != 0) {
                int i2 = i - 1;
                long a = streamElement.f4914o[i2] + streamElement.m4022a(i2);
                long j = streamElement2.f4914o[0];
                if (a <= j) {
                    this.f17017g += i;
                } else {
                    this.f17017g += streamElement.m4021a(j);
                }
                this.f17016f = ssManifest;
            }
        }
        this.f17017g += i;
        this.f17016f = ssManifest;
    }

    public final void mo3359a() throws IOException {
        if (this.f17018h != null) {
            throw this.f17018h;
        }
        this.f17011a.mo1477c();
    }

    public final void mo3361a(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk2 = mediaChunk;
        long j2 = j;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.f17018h == null) {
            r0.f17013c.mo3369a(mediaChunk2 != null ? mediaChunk2.i - j2 : 0);
            StreamElement streamElement = r0.f17016f.f4921f[r0.f17012b];
            if (streamElement.f4910k == 0) {
                chunkHolder2.f4790b = r0.f17016f.f4919d ^ true;
                return;
            }
            int a;
            if (mediaChunk2 == null) {
                a = streamElement.m4021a(j2);
            } else {
                a = mediaChunk.mo4256e() - r0.f17017g;
                if (a < 0) {
                    r0.f17018h = new BehindLiveWindowException();
                    return;
                }
            }
            if (a >= streamElement.f4910k) {
                chunkHolder2.f4790b = r0.f17016f.f4919d ^ true;
                return;
            }
            long j3 = streamElement.f4914o[a];
            long a2 = j3 + streamElement.m4022a(a);
            int i = a + r0.f17017g;
            int a3 = r0.f17013c.mo3368a();
            ChunkExtractorWrapper chunkExtractorWrapper = r0.f17014d[a3];
            a3 = r0.f17013c.mo1457b(a3);
            boolean z = false;
            Assertions.m4186b(streamElement.f4909j != null);
            Assertions.m4186b(streamElement.f4913n != null);
            if (a < streamElement.f4913n.size()) {
                z = true;
            }
            Assertions.m4186b(z);
            CharSequence num = Integer.toString(streamElement.f4909j[a3].f4014b);
            CharSequence l = ((Long) streamElement.f4913n.get(a)).toString();
            chunkHolder2.f4789a = new ContainerMediaChunk(r0.f17015e, new DataSpec(UriUtil.m4291a(streamElement.f4911l, streamElement.f4912m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l)), 0, -1, null), r0.f17013c.mo1462f(), r0.f17013c.mo3370b(), r0.f17013c.mo3371c(), j3, a2, i, 1, j3, chunkExtractorWrapper);
        }
    }

    public final boolean mo3363a(Chunk chunk, boolean z, Exception exception) {
        return (!z || ChunkedTrackBlacklistUtil.m3981a(this.f17013c, this.f17013c.mo1455a(chunk.f13304e), exception) == null) ? null : true;
    }
}
