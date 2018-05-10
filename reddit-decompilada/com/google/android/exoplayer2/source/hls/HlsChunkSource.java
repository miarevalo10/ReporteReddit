package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class HlsChunkSource {
    final DataSource f4858a;
    final DataSource f4859b;
    final TimestampAdjusterProvider f4860c;
    final HlsUrl[] f4861d;
    final HlsPlaylistTracker f4862e;
    final TrackGroup f4863f;
    final List<Format> f4864g;
    boolean f4865h;
    byte[] f4866i;
    IOException f4867j;
    HlsUrl f4868k;
    boolean f4869l;
    Uri f4870m;
    byte[] f4871n;
    String f4872o;
    byte[] f4873p;
    TrackSelection f4874q;

    public static final class HlsChunkHolder {
        public Chunk f4855a;
        public boolean f4856b;
        public HlsUrl f4857c;

        public HlsChunkHolder() {
            m4011a();
        }

        public final void m4011a() {
            this.f4855a = null;
            this.f4856b = false;
            this.f4857c = null;
        }
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int f16996e;

        public final int mo3370b() {
            return 0;
        }

        public final Object mo3371c() {
            return null;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f16996e = mo1455a((Format) trackGroup.f4783b[null]);
        }

        public final void mo3369a(long j) {
            j = SystemClock.elapsedRealtime();
            if (m12636a(this.f16996e, j)) {
                int i = this.b - 1;
                while (i >= 0) {
                    if (m12636a(i, j)) {
                        i--;
                    } else {
                        this.f16996e = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public final int mo3368a() {
            return this.f16996e;
        }
    }

    private static final class EncryptionKeyChunk extends DataChunk {
        public final String f18965b;
        byte[] f18966k;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, format, i, obj, bArr);
            this.f18965b = str;
        }

        protected final void mo3922a(byte[] bArr, int i) throws IOException {
            this.f18966k = Arrays.copyOf(bArr, i);
        }
    }

    public HlsChunkSource(HlsPlaylistTracker hlsPlaylistTracker, HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list) {
        this.f4862e = hlsPlaylistTracker;
        this.f4861d = hlsUrlArr;
        this.f4860c = timestampAdjusterProvider;
        this.f4864g = list;
        timestampAdjusterProvider = new Format[hlsUrlArr.length];
        list = new int[hlsUrlArr.length];
        for (hlsPlaylistTracker = null; hlsPlaylistTracker < hlsUrlArr.length; hlsPlaylistTracker++) {
            timestampAdjusterProvider[hlsPlaylistTracker] = hlsUrlArr[hlsPlaylistTracker].f4880b;
            list[hlsPlaylistTracker] = hlsPlaylistTracker;
        }
        this.f4858a = hlsDataSourceFactory.mo1438a();
        this.f4859b = hlsDataSourceFactory.mo1438a();
        this.f4863f = new TrackGroup(timestampAdjusterProvider);
        this.f4874q = new InitializationTrackSelection(this.f4863f, list);
    }

    final void m4012a(Uri uri, String str, byte[] bArr) {
        Object toByteArray = new BigInteger(Util.m4323d(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (16 - toByteArray.length) + length, toByteArray.length - length);
        this.f4870m = uri;
        this.f4871n = bArr;
        this.f4872o = str;
        this.f4873p = obj;
    }
}
