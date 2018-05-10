package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class HlsMediaChunk extends MediaChunk {
    private static final AtomicInteger f18967p = new AtomicInteger();
    private final Id3Decoder f18968A;
    private final ParsableByteArray f18969B;
    private Extractor f18970C;
    private int f18971D;
    private int f18972E;
    private boolean f18973F;
    private volatile boolean f18974G;
    public final int f18975a;
    public final int f18976b;
    public final HlsUrl f18977l;
    final boolean f18978m;
    HlsSampleStreamWrapper f18979n;
    volatile boolean f18980o;
    private final DataSource f18981q;
    private final DataSpec f18982r;
    private final boolean f18983s;
    private final boolean f18984t;
    private final TimestampAdjuster f18985u;
    private final String f18986v;
    private final Extractor f18987w;
    private final boolean f18988x;
    private final List<Format> f18989y;
    private final boolean f18990z;

    public final boolean mo3923f() {
        return this.f18980o;
    }

    public final long mo3358d() {
        return (long) this.f18972E;
    }

    public final void mo1404a() {
        this.f18974G = true;
    }

    public final boolean mo1405b() {
        return this.f18974G;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        int i;
        DataSpec a;
        int i2 = 0;
        if (this.f18970C == null && !this.f18990z) {
            Extractor tsExtractor;
            FragmentedMp4Extractor fragmentedMp4Extractor;
            if (!("text/vtt".equals(this.f18977l.f4880b.f4018f) || this.f18986v.endsWith(".webvtt"))) {
                if (!this.f18986v.endsWith(".vtt")) {
                    if (this.f18988x) {
                        if (!this.f18986v.endsWith(".mp4")) {
                            if (!this.f18986v.startsWith(".m4", this.f18986v.length() - 4)) {
                                i = 16;
                                List list = this.f18989y;
                                if (list != null) {
                                    i = 48;
                                } else {
                                    list = Collections.emptyList();
                                }
                                String str = this.e.f4015c;
                                if (!TextUtils.isEmpty(str)) {
                                    if (!"audio/mp4a-latm".equals(MimeTypes.m4216e(str))) {
                                        i |= 2;
                                    }
                                    if (!"video/avc".equals(MimeTypes.m4215d(str))) {
                                        i |= 4;
                                    }
                                }
                                tsExtractor = new TsExtractor(2, this.f18985u, new DefaultTsPayloadReaderFactory(i, list));
                                i = true;
                                if (i != 0) {
                                    tsExtractor.mo1352a(this.f18979n);
                                }
                                this.f18970C = tsExtractor;
                            }
                        }
                        fragmentedMp4Extractor = new FragmentedMp4Extractor(0, this.f18985u);
                        tsExtractor = fragmentedMp4Extractor;
                        i = true;
                        if (i != 0) {
                            tsExtractor.mo1352a(this.f18979n);
                        }
                        this.f18970C = tsExtractor;
                    } else {
                        tsExtractor = this.f18987w;
                        i = 0;
                        if (i != 0) {
                            tsExtractor.mo1352a(this.f18979n);
                        }
                        this.f18970C = tsExtractor;
                    }
                }
            }
            fragmentedMp4Extractor = new WebvttExtractor(this.e.f4037y, this.f18985u);
            tsExtractor = fragmentedMp4Extractor;
            i = true;
            if (i != 0) {
                tsExtractor.mo1352a(this.f18979n);
            }
            this.f18970C = tsExtractor;
        }
        if (!(this.f18987w == this.f18970C || this.f18973F)) {
            if (this.f18982r != null) {
                a = this.f18982r.m4149a((long) this.f18971D);
                ExtractorInput defaultExtractorInput;
                try {
                    defaultExtractorInput = new DefaultExtractorInput(this.f18981q, a.f5169c, this.f18981q.mo1435a(a));
                    i = 0;
                    while (i == 0) {
                        if (this.f18974G) {
                            break;
                        }
                        i = this.f18970C.mo1350a(defaultExtractorInput, null);
                    }
                    this.f18971D = (int) (defaultExtractorInput.mo1338c() - this.f18982r.f5169c);
                    Util.m4307a(this.j);
                    this.f18973F = true;
                } catch (Throwable th) {
                    Util.m4307a(this.j);
                }
            }
        }
        if (!this.f18974G) {
            boolean z;
            ExtractorInput defaultExtractorInput2;
            int i3;
            Object obj;
            Metadata a2;
            PrivFrame privFrame;
            long l;
            long b;
            StringBuilder stringBuilder;
            Extractor mp3Extractor;
            if (this.f18983s) {
                a = this.c;
                if (this.f18972E != 0) {
                    z = true;
                    if (!this.f18984t) {
                        this.f18985u.m4287b();
                    } else if (this.f18985u.f5279a == Long.MAX_VALUE) {
                        this.f18985u.m4285a(this.h);
                    }
                    defaultExtractorInput2 = new DefaultExtractorInput(this.j, a.f5169c, this.j.mo1435a(a));
                    if (this.f18970C == null) {
                        defaultExtractorInput2.mo1332a();
                        if (defaultExtractorInput2.mo1337b(this.f18969B.f5256a, 0, 10, true)) {
                            this.f18969B.m4242a(10);
                            if (this.f18969B.m4256g() == Id3Decoder.f13228a) {
                                this.f18969B.m4251d(3);
                                i = this.f18969B.m4262m();
                                i3 = i + 10;
                                if (i3 > this.f18969B.m4248c()) {
                                    obj = this.f18969B.f5256a;
                                    this.f18969B.m4242a(i3);
                                    System.arraycopy(obj, 0, this.f18969B.f5256a, 0, 10);
                                }
                                if (defaultExtractorInput2.mo1337b(this.f18969B.f5256a, 10, i, true)) {
                                    a2 = this.f18968A.m12295a(this.f18969B.f5256a, i);
                                    if (a2 != null) {
                                        for (Entry entry : a2.f4666a) {
                                            if (entry instanceof PrivFrame) {
                                                privFrame = (PrivFrame) entry;
                                                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f16886a)) {
                                                    System.arraycopy(privFrame.f16887b, 0, this.f18969B.f5256a, 0, 8);
                                                    this.f18969B.m4242a(8);
                                                    l = this.f18969B.m4261l();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        l = -9223372036854775807L;
                        if (l == -9223372036854775807L) {
                            b = this.f18985u.m4286b(l);
                        } else {
                            b = this.h;
                        }
                        if (this.f18986v.endsWith(".aac")) {
                            if (!this.f18986v.endsWith(".ac3")) {
                                if (this.f18986v.endsWith(".ec3")) {
                                    if (this.f18986v.endsWith(".mp3")) {
                                        stringBuilder = new StringBuilder("Unknown extension for audio file: ");
                                        stringBuilder.append(this.f18986v);
                                        throw new IllegalArgumentException(stringBuilder.toString());
                                    }
                                    mp3Extractor = new Mp3Extractor(0, b);
                                }
                            }
                            mp3Extractor = new Ac3Extractor(b);
                        } else {
                            mp3Extractor = new AdtsExtractor(b);
                        }
                        mp3Extractor.mo1352a(this.f18979n);
                        this.f18970C = mp3Extractor;
                    }
                    if (z) {
                        defaultExtractorInput2.mo1335b(this.f18972E);
                    }
                    while (i2 == 0) {
                        if (!this.f18974G) {
                            break;
                        }
                        i2 = this.f18970C.mo1350a(defaultExtractorInput2, null);
                    }
                    this.f18972E = (int) (defaultExtractorInput2.mo1338c() - this.c.f5169c);
                    Util.m4307a(this.j);
                    this.f18980o = true;
                }
            }
            a = this.c.m4149a((long) this.f18972E);
            z = false;
            if (!this.f18984t) {
                this.f18985u.m4287b();
            } else if (this.f18985u.f5279a == Long.MAX_VALUE) {
                this.f18985u.m4285a(this.h);
            }
            try {
                defaultExtractorInput2 = new DefaultExtractorInput(this.j, a.f5169c, this.j.mo1435a(a));
                if (this.f18970C == null) {
                    defaultExtractorInput2.mo1332a();
                    if (defaultExtractorInput2.mo1337b(this.f18969B.f5256a, 0, 10, true)) {
                        this.f18969B.m4242a(10);
                        if (this.f18969B.m4256g() == Id3Decoder.f13228a) {
                            this.f18969B.m4251d(3);
                            i = this.f18969B.m4262m();
                            i3 = i + 10;
                            if (i3 > this.f18969B.m4248c()) {
                                obj = this.f18969B.f5256a;
                                this.f18969B.m4242a(i3);
                                System.arraycopy(obj, 0, this.f18969B.f5256a, 0, 10);
                            }
                            if (defaultExtractorInput2.mo1337b(this.f18969B.f5256a, 10, i, true)) {
                                a2 = this.f18968A.m12295a(this.f18969B.f5256a, i);
                                if (a2 != null) {
                                    for (Entry entry2 : a2.f4666a) {
                                        if (entry2 instanceof PrivFrame) {
                                            privFrame = (PrivFrame) entry2;
                                            if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f16886a)) {
                                                System.arraycopy(privFrame.f16887b, 0, this.f18969B.f5256a, 0, 8);
                                                this.f18969B.m4242a(8);
                                                l = this.f18969B.m4261l();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    l = -9223372036854775807L;
                    if (l == -9223372036854775807L) {
                        b = this.h;
                    } else {
                        b = this.f18985u.m4286b(l);
                    }
                    if (this.f18986v.endsWith(".aac")) {
                        if (this.f18986v.endsWith(".ac3")) {
                            if (this.f18986v.endsWith(".ec3")) {
                                if (this.f18986v.endsWith(".mp3")) {
                                    stringBuilder = new StringBuilder("Unknown extension for audio file: ");
                                    stringBuilder.append(this.f18986v);
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                }
                                mp3Extractor = new Mp3Extractor(0, b);
                            }
                        }
                        mp3Extractor = new Ac3Extractor(b);
                    } else {
                        mp3Extractor = new AdtsExtractor(b);
                    }
                    mp3Extractor.mo1352a(this.f18979n);
                    this.f18970C = mp3Extractor;
                }
                if (z) {
                    defaultExtractorInput2.mo1335b(this.f18972E);
                }
                while (i2 == 0) {
                    if (!this.f18974G) {
                        break;
                    }
                    i2 = this.f18970C.mo1350a(defaultExtractorInput2, null);
                }
                this.f18972E = (int) (defaultExtractorInput2.mo1338c() - this.c.f5169c);
                Util.m4307a(this.j);
                this.f18980o = true;
            } catch (Throwable th2) {
                Util.m4307a(this.j);
            }
        }
    }

    public HlsMediaChunk(DataSource dataSource, DataSpec dataSpec, DataSpec dataSpec2, HlsUrl hlsUrl, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, TimestampAdjuster timestampAdjuster, HlsMediaChunk hlsMediaChunk, byte[] bArr, byte[] bArr2) {
        DataSource aes128DataSource;
        boolean z2;
        boolean z3;
        MediaChunk mediaChunk = this;
        DataSource dataSource2 = dataSource;
        HlsUrl hlsUrl2 = hlsUrl;
        int i4 = i3;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3 != null) {
            if (bArr4 != null) {
                aes128DataSource = new Aes128DataSource(dataSource2, bArr3, bArr4);
                super(aes128DataSource, dataSpec, hlsUrl2.f4880b, i, obj, j, j2, i2);
                mediaChunk.f18976b = i4;
                mediaChunk.f18982r = dataSpec2;
                mediaChunk.f18977l = hlsUrl2;
                mediaChunk.f18989y = list;
                mediaChunk.f18984t = z;
                mediaChunk.f18985u = timestampAdjuster;
                mediaChunk.f18983s = mediaChunk.j instanceof Aes128DataSource;
                mediaChunk.f18986v = dataSpec.f5167a.getLastPathSegment();
                z2 = true;
                if (!(mediaChunk.f18986v.endsWith(".aac") || mediaChunk.f18986v.endsWith(".ac3") || mediaChunk.f18986v.endsWith(".ec3"))) {
                    if (mediaChunk.f18986v.endsWith(".mp3")) {
                        z3 = false;
                        mediaChunk.f18990z = z3;
                        if (hlsMediaChunk2 == null) {
                            mediaChunk.f18968A = hlsMediaChunk2.f18968A;
                            mediaChunk.f18969B = hlsMediaChunk2.f18969B;
                            mediaChunk.f18987w = hlsMediaChunk2.f18970C;
                            mediaChunk.f18978m = hlsMediaChunk2.f18977l == hlsUrl2;
                            if (hlsMediaChunk2.f18976b == i4) {
                                if (!mediaChunk.f18978m) {
                                    z2 = false;
                                }
                            }
                            mediaChunk.f18988x = z2;
                        } else {
                            mediaChunk.f18968A = mediaChunk.f18990z ? new Id3Decoder() : null;
                            mediaChunk.f18969B = mediaChunk.f18990z ? new ParsableByteArray(10) : null;
                            mediaChunk.f18987w = null;
                            mediaChunk.f18978m = false;
                            mediaChunk.f18988x = true;
                        }
                        mediaChunk.f18981q = dataSource2;
                        mediaChunk.f18975a = f18967p.getAndIncrement();
                    }
                }
                z3 = true;
                mediaChunk.f18990z = z3;
                if (hlsMediaChunk2 == null) {
                    if (mediaChunk.f18990z) {
                    }
                    mediaChunk.f18968A = mediaChunk.f18990z ? new Id3Decoder() : null;
                    if (mediaChunk.f18990z) {
                    }
                    mediaChunk.f18969B = mediaChunk.f18990z ? new ParsableByteArray(10) : null;
                    mediaChunk.f18987w = null;
                    mediaChunk.f18978m = false;
                    mediaChunk.f18988x = true;
                } else {
                    mediaChunk.f18968A = hlsMediaChunk2.f18968A;
                    mediaChunk.f18969B = hlsMediaChunk2.f18969B;
                    mediaChunk.f18987w = hlsMediaChunk2.f18970C;
                    if (hlsMediaChunk2.f18977l == hlsUrl2) {
                    }
                    mediaChunk.f18978m = hlsMediaChunk2.f18977l == hlsUrl2;
                    if (hlsMediaChunk2.f18976b == i4) {
                        if (!mediaChunk.f18978m) {
                            z2 = false;
                        }
                    }
                    mediaChunk.f18988x = z2;
                }
                mediaChunk.f18981q = dataSource2;
                mediaChunk.f18975a = f18967p.getAndIncrement();
            }
        }
        aes128DataSource = dataSource2;
        super(aes128DataSource, dataSpec, hlsUrl2.f4880b, i, obj, j, j2, i2);
        mediaChunk.f18976b = i4;
        mediaChunk.f18982r = dataSpec2;
        mediaChunk.f18977l = hlsUrl2;
        mediaChunk.f18989y = list;
        mediaChunk.f18984t = z;
        mediaChunk.f18985u = timestampAdjuster;
        mediaChunk.f18983s = mediaChunk.j instanceof Aes128DataSource;
        mediaChunk.f18986v = dataSpec.f5167a.getLastPathSegment();
        z2 = true;
        if (mediaChunk.f18986v.endsWith(".mp3")) {
            z3 = false;
            mediaChunk.f18990z = z3;
            if (hlsMediaChunk2 == null) {
                mediaChunk.f18968A = hlsMediaChunk2.f18968A;
                mediaChunk.f18969B = hlsMediaChunk2.f18969B;
                mediaChunk.f18987w = hlsMediaChunk2.f18970C;
                if (hlsMediaChunk2.f18977l == hlsUrl2) {
                }
                mediaChunk.f18978m = hlsMediaChunk2.f18977l == hlsUrl2;
                if (hlsMediaChunk2.f18976b == i4) {
                    if (!mediaChunk.f18978m) {
                        z2 = false;
                    }
                }
                mediaChunk.f18988x = z2;
            } else {
                if (mediaChunk.f18990z) {
                }
                mediaChunk.f18968A = mediaChunk.f18990z ? new Id3Decoder() : null;
                if (mediaChunk.f18990z) {
                }
                mediaChunk.f18969B = mediaChunk.f18990z ? new ParsableByteArray(10) : null;
                mediaChunk.f18987w = null;
                mediaChunk.f18978m = false;
                mediaChunk.f18988x = true;
            }
            mediaChunk.f18981q = dataSource2;
            mediaChunk.f18975a = f18967p.getAndIncrement();
        }
        z3 = true;
        mediaChunk.f18990z = z3;
        if (hlsMediaChunk2 == null) {
            if (mediaChunk.f18990z) {
            }
            mediaChunk.f18968A = mediaChunk.f18990z ? new Id3Decoder() : null;
            if (mediaChunk.f18990z) {
            }
            mediaChunk.f18969B = mediaChunk.f18990z ? new ParsableByteArray(10) : null;
            mediaChunk.f18987w = null;
            mediaChunk.f18978m = false;
            mediaChunk.f18988x = true;
        } else {
            mediaChunk.f18968A = hlsMediaChunk2.f18968A;
            mediaChunk.f18969B = hlsMediaChunk2.f18969B;
            mediaChunk.f18987w = hlsMediaChunk2.f18970C;
            if (hlsMediaChunk2.f18977l == hlsUrl2) {
            }
            mediaChunk.f18978m = hlsMediaChunk2.f18977l == hlsUrl2;
            if (hlsMediaChunk2.f18976b == i4) {
                if (!mediaChunk.f18978m) {
                    z2 = false;
                }
            }
            mediaChunk.f18988x = z2;
        }
        mediaChunk.f18981q = dataSource2;
        mediaChunk.f18975a = f18967p.getAndIncrement();
    }
}
