package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    protected final RepresentationHolder[] f16981a;
    private final LoaderErrorThrower f16982b;
    private final int[] f16983c;
    private final TrackSelection f16984d;
    private final int f16985e;
    private final DataSource f16986f;
    private final long f16987g;
    private final int f16988h;
    private DashManifest f16989i;
    private int f16990j;
    private IOException f16991k;
    private boolean f16992l;

    protected static final class RepresentationHolder {
        final ChunkExtractorWrapper f4802a;
        public Representation f4803b;
        public DashSegmentIndex f4804c;
        long f4805d;
        int f4806e;

        RepresentationHolder(long j, Representation representation, boolean z, boolean z2) {
            int i;
            this.f4805d = j;
            this.f4803b = representation;
            j = representation.f4839c.f4017e;
            int i2 = 0;
            if (!MimeTypes.m4214c(j)) {
                if (!"application/ttml+xml".equals(j)) {
                    i = 0;
                    if (i == 0) {
                        this.f4802a = 0;
                    } else {
                        if (!"application/x-rawcc".equals(j)) {
                            if (!(j.startsWith("video/webm") || j.startsWith("audio/webm"))) {
                                if (j.startsWith("application/webm") != null) {
                                    j = 0;
                                    if (j == null) {
                                        j = new MatroskaExtractor(1);
                                    } else {
                                        if (z) {
                                            i2 = 4;
                                        }
                                        if (z2) {
                                            i2 |= 8;
                                        }
                                        j = new FragmentedMp4Extractor(i2);
                                    }
                                }
                            }
                            j = 1;
                            if (j == null) {
                                if (z) {
                                    i2 = 4;
                                }
                                if (z2) {
                                    i2 |= 8;
                                }
                                j = new FragmentedMp4Extractor(i2);
                            } else {
                                j = new MatroskaExtractor(1);
                            }
                        } else {
                            j = new RawCcExtractor(representation.f4839c);
                        }
                        this.f4802a = new ChunkExtractorWrapper(j, representation.f4839c);
                    }
                    this.f4804c = representation.mo1432d();
                }
            }
            i = 1;
            if (i == 0) {
                if (!"application/x-rawcc".equals(j)) {
                    j = new RawCcExtractor(representation.f4839c);
                } else if (j.startsWith("application/webm") != null) {
                    j = 0;
                    if (j == null) {
                        j = new MatroskaExtractor(1);
                    } else {
                        if (z) {
                            i2 = 4;
                        }
                        if (z2) {
                            i2 |= 8;
                        }
                        j = new FragmentedMp4Extractor(i2);
                    }
                } else {
                    j = 1;
                    if (j == null) {
                        if (z) {
                            i2 = 4;
                        }
                        if (z2) {
                            i2 |= 8;
                        }
                        j = new FragmentedMp4Extractor(i2);
                    } else {
                        j = new MatroskaExtractor(1);
                    }
                }
                this.f4802a = new ChunkExtractorWrapper(j, representation.f4839c);
            } else {
                this.f4802a = 0;
            }
            this.f4804c = representation.mo1432d();
        }

        public final int m3992a() {
            return this.f4804c.mo1423a() + this.f4806e;
        }

        public final int m3995b() {
            return this.f4804c.mo1424a(this.f4805d);
        }

        public final long m3994a(int i) {
            return this.f4804c.mo1426a(i - this.f4806e);
        }

        public final long m3996b(int i) {
            return m3994a(i) + this.f4804c.mo1427a(i - this.f4806e, this.f4805d);
        }

        public final int m3993a(long j) {
            return this.f4804c.mo1425a(j, this.f4805d) + this.f4806e;
        }

        public final RangedUri m3997c(int i) {
            return this.f4804c.mo1428b(i - this.f4806e);
        }
    }

    public static final class Factory implements com.google.android.exoplayer2.source.dash.DashChunkSource.Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory f13377a;
        private final int f13378b;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(factory, (byte) 0);
        }

        private Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, byte b) {
            this.f13377a = factory;
            this.f13378b = 1;
        }

        public final DashChunkSource mo1430a(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, boolean z2) {
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, this.f13377a.mo1475a(), j, this.f13378b, z, z2);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, DataSource dataSource, long j, int i3, boolean z, boolean z2) {
        TrackSelection trackSelection2 = trackSelection;
        this.f16982b = loaderErrorThrower;
        this.f16989i = dashManifest;
        this.f16983c = iArr;
        this.f16984d = trackSelection2;
        this.f16985e = i2;
        this.f16986f = dataSource;
        this.f16990j = i;
        this.f16987g = j;
        this.f16988h = i3;
        long b = dashManifest.m4000b(i);
        List b2 = m17272b();
        this.f16981a = new RepresentationHolder[trackSelection.mo1461e()];
        for (int i4 = 0; i4 < r0.f16981a.length; i4++) {
            r0.f16981a[i4] = new RepresentationHolder(b, (Representation) b2.get(trackSelection2.mo1457b(i4)), z, z2);
        }
    }

    public final void mo3362a(DashManifest dashManifest, int i) {
        try {
            this.f16989i = dashManifest;
            this.f16990j = i;
            dashManifest = this.f16989i.m4000b(this.f16990j);
            List b = m17272b();
            for (int i2 = 0; i2 < this.f16981a.length; i2++) {
                Representation representation = (Representation) b.get(this.f16984d.mo1457b(i2));
                RepresentationHolder representationHolder = this.f16981a[i2];
                DashSegmentIndex d = representationHolder.f4803b.mo1432d();
                DashSegmentIndex d2 = representation.mo1432d();
                representationHolder.f4805d = dashManifest;
                representationHolder.f4803b = representation;
                if (d != null) {
                    representationHolder.f4804c = d2;
                    if (d.mo1429b()) {
                        int a = d.mo1424a(representationHolder.f4805d);
                        if (a != 0) {
                            int a2 = (d.mo1423a() + a) - 1;
                            long a3 = d.mo1426a(a2) + d.mo1427a(a2, representationHolder.f4805d);
                            a = d2.mo1423a();
                            long a4 = d2.mo1426a(a);
                            int i3 = (a3 > a4 ? 1 : (a3 == a4 ? 0 : -1));
                            if (i3 == 0) {
                                representationHolder.f4806e += (a2 + 1) - a;
                            } else if (i3 < 0) {
                                throw new BehindLiveWindowException();
                            } else {
                                representationHolder.f4806e += d.mo1425a(a4, representationHolder.f4805d) - a;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (DashManifest dashManifest2) {
            this.f16991k = dashManifest2;
        }
    }

    public final void mo3359a() throws IOException {
        if (this.f16991k != null) {
            throw this.f16991k;
        }
        this.f16982b.mo1477c();
    }

    public final void mo3361a(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk2 = mediaChunk;
        long j2 = j;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.f16991k == null) {
            int b;
            long elapsedRealtime;
            r0.f16984d.mo3369a(mediaChunk2 != null ? mediaChunk2.i - j2 : 0);
            RepresentationHolder representationHolder = r0.f16981a[r0.f16984d.mo3368a()];
            if (representationHolder.f4802a != null) {
                RangedUri rangedUri;
                Representation representation = representationHolder.f4803b;
                RangedUri rangedUri2 = null;
                if (representationHolder.f4802a.f13317c == null) {
                    rangedUri = representation.f4843g;
                } else {
                    rangedUri = null;
                }
                if (representationHolder.f4804c == null) {
                    rangedUri2 = representation.mo1431c();
                }
                if (!(rangedUri == null && rangedUri2 == null)) {
                    DataSource dataSource = r0.f16986f;
                    Format f = r0.f16984d.mo1462f();
                    b = r0.f16984d.mo3370b();
                    Object c = r0.f16984d.mo3371c();
                    String str = representationHolder.f4803b.f4840d;
                    if (rangedUri != null) {
                        RangedUri a = rangedUri.m4003a(rangedUri2, str);
                        if (a != null) {
                            rangedUri = a;
                        }
                    } else {
                        rangedUri = rangedUri2;
                    }
                    chunkHolder2.f4789a = new InitializationChunk(dataSource, new DataSpec(rangedUri.m4002a(str), rangedUri.f4833a, rangedUri.f4834b, representationHolder.f4803b.mo1433e()), f, b, c, representationHolder.f4802a);
                    return;
                }
            }
            if (r0.f16987g != 0) {
                elapsedRealtime = (SystemClock.elapsedRealtime() + r0.f16987g) * 1000;
            } else {
                elapsedRealtime = System.currentTimeMillis() * 1000;
            }
            int b2 = representationHolder.m3995b();
            boolean z = false;
            if (b2 == 0) {
                if (!r0.f16989i.f4815d || r0.f16990j < r0.f16989i.m3998a() - 1) {
                    z = true;
                }
                chunkHolder2.f4790b = z;
                return;
            }
            int a2;
            int a3;
            boolean z2;
            int a4 = representationHolder.m3992a();
            if (b2 == -1) {
                elapsedRealtime = (elapsedRealtime - (r0.f16989i.f4812a * 1000)) - (r0.f16989i.m3999a(r0.f16990j).f4831b * 1000);
                if (r0.f16989i.f4817f != -9223372036854775807L) {
                    a4 = Math.max(a4, representationHolder.m3993a(elapsedRealtime - (r0.f16989i.f4817f * 1000)));
                }
                a2 = representationHolder.m3993a(elapsedRealtime) - 1;
            } else {
                a2 = (b2 + a4) - 1;
            }
            if (mediaChunk2 == null) {
                a3 = Util.m4297a(representationHolder.m3993a(j2), a4, a2);
            } else {
                a3 = mediaChunk.mo4256e();
                if (a3 < a4) {
                    r0.f16991k = new BehindLiveWindowException();
                    return;
                }
            }
            b = a3;
            if (b <= a2) {
                if (!r0.f16992l || b < a2) {
                    Chunk singleSampleMediaChunk;
                    a3 = Math.min(r0.f16988h, (a2 - b) + 1);
                    DataSource dataSource2 = r0.f16986f;
                    int i = r0.f16985e;
                    Format f2 = r0.f16984d.mo1462f();
                    int b3 = r0.f16984d.mo3370b();
                    Object c2 = r0.f16984d.mo3371c();
                    Representation representation2 = representationHolder.f4803b;
                    long a5 = representationHolder.m3994a(b);
                    RangedUri c3 = representationHolder.m3997c(b);
                    String str2 = representation2.f4840d;
                    if (representationHolder.f4802a == null) {
                        singleSampleMediaChunk = new SingleSampleMediaChunk(dataSource2, new DataSpec(c3.m4002a(str2), c3.f4833a, c3.f4834b, representation2.mo1433e()), f2, b3, c2, a5, representationHolder.m3996b(b), b, i, f2);
                    } else {
                        i = 1;
                        int i2 = 1;
                        while (i < a3) {
                            RangedUri a6 = c3.m4003a(representationHolder.m3997c(b + i), str2);
                            if (a6 == null) {
                                break;
                            }
                            i2++;
                            i++;
                            c3 = a6;
                        }
                        long b4 = representationHolder.m3996b((b + i2) - 1);
                        long j3 = b4;
                        long j4 = a5;
                        Chunk containerMediaChunk = new ContainerMediaChunk(dataSource2, new DataSpec(c3.m4002a(str2), c3.f4833a, c3.f4834b, representation2.mo1433e()), f2, b3, c2, j4, j3, b, i2, -representation2.f4841e, representationHolder.f4802a);
                    }
                    chunkHolder2.f4789a = singleSampleMediaChunk;
                    return;
                }
            }
            if (r0.f16989i.f4815d) {
                z2 = true;
                if (r0.f16990j < r0.f16989i.m3998a() - 1) {
                }
                chunkHolder2.f4790b = z;
            }
            z2 = true;
            z = z2;
            chunkHolder2.f4790b = z;
        }
    }

    public final void mo3360a(Chunk chunk) {
        if (chunk instanceof InitializationChunk) {
            chunk = this.f16981a[this.f16984d.mo1455a(((InitializationChunk) chunk).e)];
            if (chunk.f4804c == null) {
                SeekMap seekMap = chunk.f4802a.f13316b;
                if (seekMap != null) {
                    chunk.f4804c = new DashWrappingSegmentIndex((ChunkIndex) seekMap);
                }
            }
        }
    }

    public final boolean mo3363a(Chunk chunk, boolean z, Exception exception) {
        if (!z) {
            return null;
        }
        if (!this.f16989i.f4815d && (chunk instanceof MediaChunk) && (exception instanceof InvalidResponseCodeException) && ((InvalidResponseCodeException) exception).f13676c) {
            z = this.f16981a[this.f16984d.mo1455a(chunk.f13304e)];
            int b = z.m3995b();
            if (!(b == -1 || b == 0 || ((MediaChunk) chunk).mo4256e() <= (z.m3992a() + b) - true)) {
                this.f16992l = true;
                return true;
            }
        }
        return ChunkedTrackBlacklistUtil.m3981a(this.f16984d, this.f16984d.mo1455a(chunk.f13304e), exception);
    }

    private ArrayList<Representation> m17272b() {
        List list = this.f16989i.m3999a(this.f16990j).f4832c;
        ArrayList<Representation> arrayList = new ArrayList();
        for (int i : this.f16983c) {
            arrayList.addAll(((AdaptationSet) list.get(i)).f4809c);
        }
        return arrayList;
    }
}
