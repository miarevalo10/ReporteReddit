package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

final class HlsSampleStreamWrapper implements ExtractorOutput, UpstreamFormatChangedListener, SequenceableLoader, com.google.android.exoplayer2.upstream.Loader.Callback<Chunk>, ReleaseCallback {
    private int[] f13409A = new int[0];
    private boolean f13410B;
    private boolean[] f13411C;
    private long f13412D;
    final int f13413a;
    final HlsChunkSource f13414b;
    final Loader f13415c = new Loader("Loader:HlsSampleStreamWrapper");
    final EventDispatcher f13416d;
    final LinkedList<HlsMediaChunk> f13417e = new LinkedList();
    final Handler f13418f = new Handler();
    SampleQueue[] f13419g = new SampleQueue[0];
    boolean f13420h;
    boolean f13421i;
    int f13422j;
    Format f13423k;
    int f13424l;
    boolean f13425m;
    TrackGroupArray f13426n;
    int f13427o;
    boolean[] f13428p;
    long f13429q;
    boolean f13430r;
    boolean f13431s;
    boolean f13432t;
    private final Callback f13433u;
    private final Allocator f13434v;
    private final Format f13435w;
    private final int f13436x;
    private final HlsChunkHolder f13437y = new HlsChunkHolder();
    private final Runnable f13438z = new C04181(this);

    class C04181 implements Runnable {
        final /* synthetic */ HlsSampleStreamWrapper f4877a;

        C04181(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            this.f4877a = hlsSampleStreamWrapper;
        }

        public void run() {
            this.f4877a.m12527i();
        }
    }

    public interface Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void mo3372a(HlsUrl hlsUrl);

        void mo3374f();
    }

    public final void mo1417a(SeekMap seekMap) {
    }

    public final /* synthetic */ int mo1418a(Loadable loadable, long j, long j2, IOException iOException) {
        int i;
        HlsChunkSource hlsChunkSource;
        boolean z;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this;
        Chunk chunk = (Chunk) loadable;
        long d = chunk.mo3358d();
        boolean z2 = chunk instanceof HlsMediaChunk;
        boolean z3 = true;
        if (z2) {
            if (d != 0) {
                i = 0;
                hlsChunkSource = hlsSampleStreamWrapper.f13414b;
                if (i != 0) {
                    IOException iOException2 = iOException;
                } else if (ChunkedTrackBlacklistUtil.m3981a(hlsChunkSource.f4874q, hlsChunkSource.f4874q.mo1458c(hlsChunkSource.f4863f.m3974a(chunk.f13304e)), iOException)) {
                    i = 1;
                    if (i == 0) {
                        z3 = false;
                    } else if (z2) {
                        Assertions.m4186b(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk);
                        if (hlsSampleStreamWrapper.f13417e.isEmpty()) {
                            hlsSampleStreamWrapper.f13412D = hlsSampleStreamWrapper.f13429q;
                        }
                    }
                    z = z3;
                    hlsSampleStreamWrapper.f13416d.m3925a(chunk.f13302c, chunk.f13303d, hlsSampleStreamWrapper.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d(), iOException, z);
                    if (!z) {
                        return 0;
                    }
                    if (hlsSampleStreamWrapper.f13421i) {
                        mo1401c(hlsSampleStreamWrapper.f13429q);
                    } else {
                        hlsSampleStreamWrapper.f13433u.mo3348a(hlsSampleStreamWrapper);
                    }
                    return 2;
                }
                i = 0;
                if (i == 0) {
                    z3 = false;
                } else if (z2) {
                    if (((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk) {
                    }
                    Assertions.m4186b(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk);
                    if (hlsSampleStreamWrapper.f13417e.isEmpty()) {
                        hlsSampleStreamWrapper.f13412D = hlsSampleStreamWrapper.f13429q;
                    }
                }
                z = z3;
                hlsSampleStreamWrapper.f13416d.m3925a(chunk.f13302c, chunk.f13303d, hlsSampleStreamWrapper.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d(), iOException, z);
                if (!z) {
                    return 0;
                }
                if (hlsSampleStreamWrapper.f13421i) {
                    hlsSampleStreamWrapper.f13433u.mo3348a(hlsSampleStreamWrapper);
                } else {
                    mo1401c(hlsSampleStreamWrapper.f13429q);
                }
                return 2;
            }
        }
        i = 1;
        hlsChunkSource = hlsSampleStreamWrapper.f13414b;
        if (i != 0) {
            IOException iOException22 = iOException;
        } else if (ChunkedTrackBlacklistUtil.m3981a(hlsChunkSource.f4874q, hlsChunkSource.f4874q.mo1458c(hlsChunkSource.f4863f.m3974a(chunk.f13304e)), iOException)) {
            i = 1;
            if (i == 0) {
                z3 = false;
            } else if (z2) {
                if (((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk) {
                }
                Assertions.m4186b(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk);
                if (hlsSampleStreamWrapper.f13417e.isEmpty()) {
                    hlsSampleStreamWrapper.f13412D = hlsSampleStreamWrapper.f13429q;
                }
            }
            z = z3;
            hlsSampleStreamWrapper.f13416d.m3925a(chunk.f13302c, chunk.f13303d, hlsSampleStreamWrapper.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d(), iOException, z);
            if (!z) {
                return 0;
            }
            if (hlsSampleStreamWrapper.f13421i) {
                mo1401c(hlsSampleStreamWrapper.f13429q);
            } else {
                hlsSampleStreamWrapper.f13433u.mo3348a(hlsSampleStreamWrapper);
            }
            return 2;
        }
        i = 0;
        if (i == 0) {
            z3 = false;
        } else if (z2) {
            if (((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk) {
            }
            Assertions.m4186b(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.removeLast()) != chunk);
            if (hlsSampleStreamWrapper.f13417e.isEmpty()) {
                hlsSampleStreamWrapper.f13412D = hlsSampleStreamWrapper.f13429q;
            }
        }
        z = z3;
        hlsSampleStreamWrapper.f13416d.m3925a(chunk.f13302c, chunk.f13303d, hlsSampleStreamWrapper.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d(), iOException, z);
        if (!z) {
            return 0;
        }
        if (hlsSampleStreamWrapper.f13421i) {
            hlsSampleStreamWrapper.f13433u.mo3348a(hlsSampleStreamWrapper);
        } else {
            mo1401c(hlsSampleStreamWrapper.f13429q);
        }
        return 2;
    }

    public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
        Chunk chunk = (Chunk) loadable;
        HlsChunkSource hlsChunkSource = this.f13414b;
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            hlsChunkSource.f4866i = encryptionKeyChunk.f16959a;
            hlsChunkSource.m4012a(encryptionKeyChunk.c.f5167a, encryptionKeyChunk.f18965b, encryptionKeyChunk.f18966k);
        }
        r0.f13416d.m3924a(chunk.f13302c, chunk.f13303d, r0.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d());
        if (r0.f13421i) {
            r0.f13433u.mo3348a(r0);
        } else {
            mo1401c(r0.f13429q);
        }
    }

    public final /* synthetic */ void mo1420a(Loadable loadable, long j, long j2, boolean z) {
        Chunk chunk = (Chunk) loadable;
        this.f13416d.m3929b(chunk.f13302c, chunk.f13303d, this.f13413a, chunk.f13304e, chunk.f13305f, chunk.f13306g, chunk.f13307h, chunk.f13308i, j, j2, chunk.mo3358d());
        if (!z) {
            m12526h();
            if (r0.f13422j > 0) {
                r0.f13433u.mo3348a(r0);
            }
        }
    }

    public HlsSampleStreamWrapper(int i, Callback callback, HlsChunkSource hlsChunkSource, Allocator allocator, long j, Format format, int i2, EventDispatcher eventDispatcher) {
        this.f13413a = i;
        this.f13433u = callback;
        this.f13414b = hlsChunkSource;
        this.f13434v = allocator;
        this.f13435w = format;
        this.f13436x = i2;
        this.f13416d = eventDispatcher;
        this.f13429q = j;
        this.f13412D = j;
    }

    public final void m12519b() {
        if (!this.f13421i) {
            mo1401c(this.f13429q);
        }
    }

    public final boolean m12518a(long j, boolean z) {
        this.f13429q = j;
        if (!(z || m12528j())) {
            z = this.f13419g.length;
            boolean z2 = false;
            while (z2 < z) {
                SampleQueue sampleQueue = this.f13419g[z2];
                sampleQueue.m12359b();
                if (!sampleQueue.m12358a(j, false) && (this.f13411C[z2] || !this.f13410B)) {
                    z = false;
                    break;
                }
                sampleQueue.m12360c();
                z2++;
            }
            z = true;
            if (z) {
                return false;
            }
        }
        this.f13412D = j;
        this.f13432t = false;
        this.f13417e.clear();
        if (this.f13415c.m12693a() != null) {
            this.f13415c.m12695b();
        } else {
            m12526h();
        }
        return true;
    }

    public final long mo1402d() {
        if (this.f13432t) {
            return Long.MIN_VALUE;
        }
        if (m12528j()) {
            return this.f13412D;
        }
        long j = this.f13429q;
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) this.f13417e.getLast();
        if (!hlsMediaChunk.f18980o) {
            hlsMediaChunk = this.f13417e.size() > 1 ? (HlsMediaChunk) this.f13417e.get(this.f13417e.size() - 2) : null;
        }
        if (hlsMediaChunk != null) {
            j = Math.max(j, hlsMediaChunk.i);
        }
        for (SampleQueue sampleQueue : this.f13419g) {
            j = Math.max(j, sampleQueue.f13275a.m3958d());
        }
        return j;
    }

    public final void mo1421f() {
        m12526h();
    }

    public final void m12517a(boolean z) {
        this.f13414b.f4865h = z;
    }

    final void m12520c() throws IOException {
        this.f13415c.mo1477c();
        HlsChunkSource hlsChunkSource = this.f13414b;
        if (hlsChunkSource.f4867j != null) {
            throw hlsChunkSource.f4867j;
        } else if (hlsChunkSource.f4868k != null) {
            hlsChunkSource.f4862e.m12575b(hlsChunkSource.f4868k);
        }
    }

    final void m12526h() {
        for (SampleQueue a : this.f13419g) {
            a.m12357a(this.f13430r);
        }
        this.f13430r = false;
    }

    public final boolean mo1401c(long j) {
        if (!this.f13432t) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper;
            if (!hlsSampleStreamWrapper.f13415c.m12693a()) {
                int i;
                long elapsedRealtime;
                long j2;
                HlsMediaChunk hlsMediaChunk;
                boolean z;
                HlsMediaPlaylist a;
                int e;
                HlsUrl hlsUrl;
                int i2;
                Segment segment;
                Uri a2;
                DataSpec dataSpec;
                Segment segment2;
                DataSpec dataSpec2;
                DataSpec dataSpec3;
                int i3;
                TimestampAdjusterProvider timestampAdjusterProvider;
                TimestampAdjuster timestampAdjuster;
                long j3;
                Chunk chunk;
                Chunk hlsMediaChunk2;
                HlsChunkHolder hlsChunkHolder;
                List list;
                Object valueOf;
                boolean z2;
                boolean z3;
                Chunk chunk2;
                HlsUrl hlsUrl2;
                boolean z4;
                HlsChunkSource hlsChunkSource = hlsSampleStreamWrapper.f13414b;
                HlsMediaChunk hlsMediaChunk3 = hlsSampleStreamWrapper.f13417e.isEmpty() ? null : (HlsMediaChunk) hlsSampleStreamWrapper.f13417e.getLast();
                long j4 = hlsSampleStreamWrapper.f13412D != -9223372036854775807L ? hlsSampleStreamWrapper.f13412D : j;
                HlsChunkHolder hlsChunkHolder2 = hlsSampleStreamWrapper.f13437y;
                if (hlsMediaChunk3 == null) {
                    i = -1;
                } else {
                    i = hlsChunkSource.f4863f.m3974a(hlsMediaChunk3.e);
                }
                hlsChunkSource.f4868k = null;
                long j5 = 0;
                if (hlsMediaChunk3 != null) {
                    j5 = Math.max(0, (hlsChunkSource.f4869l ? hlsMediaChunk3.i : hlsMediaChunk3.h) - j4);
                }
                hlsChunkSource.f4874q.mo3369a(j5);
                int g = hlsChunkSource.f4874q.mo1463g();
                boolean z5 = i != g;
                HlsUrl hlsUrl3 = hlsChunkSource.f4861d[g];
                MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) hlsChunkSource.f4862e.f13503e.get(hlsUrl3);
                if (mediaPlaylistBundle.f13489b != null) {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    j2 = j4;
                    hlsMediaChunk = hlsMediaChunk3;
                    long max = Math.max(30000, C0377C.m3539a(mediaPlaylistBundle.f13489b.f13465n));
                    if (mediaPlaylistBundle.f13489b.f13461j || mediaPlaylistBundle.f13489b.f13452a == 2 || mediaPlaylistBundle.f13489b.f13452a == 1 || mediaPlaylistBundle.f13490c + max > elapsedRealtime) {
                        z = true;
                        if (z) {
                            hlsChunkHolder2.f4857c = hlsUrl3;
                            hlsChunkSource.f4868k = hlsUrl3;
                        } else {
                            a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                            hlsChunkSource.f4869l = a.f13460i;
                            if (hlsMediaChunk != null) {
                                if (z5) {
                                    hlsMediaChunk3 = hlsMediaChunk;
                                    e = hlsMediaChunk3.mo4256e();
                                    hlsUrl = hlsUrl3;
                                    if (e < a.f13457f) {
                                        hlsChunkSource.f4867j = new BehindLiveWindowException();
                                    } else {
                                        i2 = e - a.f13457f;
                                        if (i2 >= a.f13464m.size()) {
                                            segment = (Segment) a.f13464m.get(i2);
                                            if (segment.f4885e) {
                                                a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                                if (a2.equals(hlsChunkSource.f4870m)) {
                                                    if (!Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                        hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                                    }
                                                    dataSpec = null;
                                                } else {
                                                    hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                                }
                                            } else {
                                                dataSpec = null;
                                                hlsChunkSource.f4870m = null;
                                                hlsChunkSource.f4871n = null;
                                                hlsChunkSource.f4872o = null;
                                                hlsChunkSource.f4873p = null;
                                            }
                                            segment2 = a.f13463l;
                                            if (segment2 != null) {
                                                dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                            }
                                            dataSpec3 = dataSpec;
                                            elapsedRealtime = a.f13454c + segment.f4884d;
                                            i3 = a.f13456e + segment.f4883c;
                                            timestampAdjusterProvider = hlsChunkSource.f4860c;
                                            timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                            if (timestampAdjuster == null) {
                                                j3 = elapsedRealtime;
                                                timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                                timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                            } else {
                                                j3 = elapsedRealtime;
                                            }
                                            chunk = hlsMediaChunk2;
                                            hlsChunkHolder = hlsChunkHolder2;
                                            hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                            hlsChunkHolder.f4855a = chunk;
                                            hlsSampleStreamWrapper = this;
                                        } else if (a.f13461j) {
                                            hlsChunkHolder2.f4856b = true;
                                        } else {
                                            hlsChunkHolder2.f4857c = hlsUrl;
                                            hlsChunkSource.f4868k = hlsUrl;
                                        }
                                    }
                                }
                            }
                            hlsMediaChunk3 = hlsMediaChunk;
                            j4 = hlsMediaChunk3 != null ? j2 : hlsChunkSource.f4869l ? hlsMediaChunk3.i : hlsMediaChunk3.h;
                            if (!a.f13461j || j4 < a.m12535a()) {
                                list = a.f13464m;
                                valueOf = Long.valueOf(j4 - a.f13454c);
                                if (hlsChunkSource.f4862e.f13509k) {
                                    if (hlsMediaChunk3 == null) {
                                        z2 = false;
                                        e = Util.m4298a(list, valueOf, z2) + a.f13457f;
                                        if (e < a.f13457f && hlsMediaChunk3 != null) {
                                            hlsUrl3 = hlsChunkSource.f4861d[i];
                                            a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                                            e = hlsMediaChunk3.mo4256e();
                                            g = i;
                                        }
                                        hlsUrl = hlsUrl3;
                                        if (e < a.f13457f) {
                                            i2 = e - a.f13457f;
                                            if (i2 >= a.f13464m.size()) {
                                                segment = (Segment) a.f13464m.get(i2);
                                                if (segment.f4885e) {
                                                    dataSpec = null;
                                                    hlsChunkSource.f4870m = null;
                                                    hlsChunkSource.f4871n = null;
                                                    hlsChunkSource.f4872o = null;
                                                    hlsChunkSource.f4873p = null;
                                                } else {
                                                    a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                                    if (a2.equals(hlsChunkSource.f4870m)) {
                                                        if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                            hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                                        }
                                                        dataSpec = null;
                                                    } else {
                                                        hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                                    }
                                                }
                                                segment2 = a.f13463l;
                                                if (segment2 != null) {
                                                    dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                                }
                                                dataSpec3 = dataSpec;
                                                elapsedRealtime = a.f13454c + segment.f4884d;
                                                i3 = a.f13456e + segment.f4883c;
                                                timestampAdjusterProvider = hlsChunkSource.f4860c;
                                                timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                                if (timestampAdjuster == null) {
                                                    j3 = elapsedRealtime;
                                                } else {
                                                    j3 = elapsedRealtime;
                                                    timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                                    timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                                }
                                                chunk = hlsMediaChunk2;
                                                hlsChunkHolder = hlsChunkHolder2;
                                                hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                                hlsChunkHolder.f4855a = chunk;
                                                hlsSampleStreamWrapper = this;
                                            } else if (a.f13461j) {
                                                hlsChunkHolder2.f4857c = hlsUrl;
                                                hlsChunkSource.f4868k = hlsUrl;
                                            } else {
                                                hlsChunkHolder2.f4856b = true;
                                            }
                                        } else {
                                            hlsChunkSource.f4867j = new BehindLiveWindowException();
                                        }
                                    }
                                }
                                z2 = true;
                                e = Util.m4298a(list, valueOf, z2) + a.f13457f;
                                hlsUrl3 = hlsChunkSource.f4861d[i];
                                a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                                e = hlsMediaChunk3.mo4256e();
                                g = i;
                                hlsUrl = hlsUrl3;
                                if (e < a.f13457f) {
                                    hlsChunkSource.f4867j = new BehindLiveWindowException();
                                } else {
                                    i2 = e - a.f13457f;
                                    if (i2 >= a.f13464m.size()) {
                                        segment = (Segment) a.f13464m.get(i2);
                                        if (segment.f4885e) {
                                            a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                            if (a2.equals(hlsChunkSource.f4870m)) {
                                                hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                            } else {
                                                if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                    hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                                }
                                                dataSpec = null;
                                            }
                                        } else {
                                            dataSpec = null;
                                            hlsChunkSource.f4870m = null;
                                            hlsChunkSource.f4871n = null;
                                            hlsChunkSource.f4872o = null;
                                            hlsChunkSource.f4873p = null;
                                        }
                                        segment2 = a.f13463l;
                                        if (segment2 != null) {
                                            dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                        }
                                        dataSpec3 = dataSpec;
                                        elapsedRealtime = a.f13454c + segment.f4884d;
                                        i3 = a.f13456e + segment.f4883c;
                                        timestampAdjusterProvider = hlsChunkSource.f4860c;
                                        timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                        if (timestampAdjuster == null) {
                                            j3 = elapsedRealtime;
                                            timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                            timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                        } else {
                                            j3 = elapsedRealtime;
                                        }
                                        chunk = hlsMediaChunk2;
                                        hlsChunkHolder = hlsChunkHolder2;
                                        hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                        hlsChunkHolder.f4855a = chunk;
                                        hlsSampleStreamWrapper = this;
                                    } else if (a.f13461j) {
                                        hlsChunkHolder2.f4856b = true;
                                    } else {
                                        hlsChunkHolder2.f4857c = hlsUrl;
                                        hlsChunkSource.f4868k = hlsUrl;
                                    }
                                }
                            } else {
                                e = a.f13457f + a.f13464m.size();
                                hlsUrl = hlsUrl3;
                                if (e < a.f13457f) {
                                    i2 = e - a.f13457f;
                                    if (i2 >= a.f13464m.size()) {
                                        segment = (Segment) a.f13464m.get(i2);
                                        if (segment.f4885e) {
                                            dataSpec = null;
                                            hlsChunkSource.f4870m = null;
                                            hlsChunkSource.f4871n = null;
                                            hlsChunkSource.f4872o = null;
                                            hlsChunkSource.f4873p = null;
                                        } else {
                                            a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                            if (a2.equals(hlsChunkSource.f4870m)) {
                                                if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                    hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                                }
                                                dataSpec = null;
                                            } else {
                                                hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                            }
                                        }
                                        segment2 = a.f13463l;
                                        if (segment2 != null) {
                                            dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                        }
                                        dataSpec3 = dataSpec;
                                        elapsedRealtime = a.f13454c + segment.f4884d;
                                        i3 = a.f13456e + segment.f4883c;
                                        timestampAdjusterProvider = hlsChunkSource.f4860c;
                                        timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                        if (timestampAdjuster == null) {
                                            j3 = elapsedRealtime;
                                        } else {
                                            j3 = elapsedRealtime;
                                            timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                            timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                        }
                                        chunk = hlsMediaChunk2;
                                        hlsChunkHolder = hlsChunkHolder2;
                                        hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                        hlsChunkHolder.f4855a = chunk;
                                        hlsSampleStreamWrapper = this;
                                    } else if (a.f13461j) {
                                        hlsChunkHolder2.f4857c = hlsUrl;
                                        hlsChunkSource.f4868k = hlsUrl;
                                    } else {
                                        hlsChunkHolder2.f4856b = true;
                                    }
                                } else {
                                    hlsChunkSource.f4867j = new BehindLiveWindowException();
                                }
                            }
                        }
                        z3 = hlsSampleStreamWrapper.f13437y.f4856b;
                        chunk2 = hlsSampleStreamWrapper.f13437y.f4855a;
                        hlsUrl2 = hlsSampleStreamWrapper.f13437y.f4857c;
                        hlsSampleStreamWrapper.f13437y.m4011a();
                        if (z3) {
                            hlsSampleStreamWrapper.f13412D = -9223372036854775807L;
                            hlsSampleStreamWrapper.f13432t = true;
                            return true;
                        } else if (chunk2 != null) {
                            if (hlsUrl2 != null) {
                                hlsSampleStreamWrapper.f13433u.mo3372a(hlsUrl2);
                            }
                            return false;
                        } else {
                            if (chunk2 instanceof HlsMediaChunk) {
                                hlsSampleStreamWrapper.f13412D = -9223372036854775807L;
                                hlsMediaChunk3 = (HlsMediaChunk) chunk2;
                                hlsMediaChunk3.f18979n = hlsSampleStreamWrapper;
                                e = hlsMediaChunk3.f18975a;
                                z4 = hlsMediaChunk3.f18978m;
                                hlsSampleStreamWrapper.f13424l = e;
                                for (SampleQueue sampleQueue : hlsSampleStreamWrapper.f13419g) {
                                    sampleQueue.f13275a.f4769k = e;
                                }
                                if (z4) {
                                    for (SampleQueue sampleQueue2 : hlsSampleStreamWrapper.f13419g) {
                                        sampleQueue2.f13278d = true;
                                    }
                                }
                                hlsSampleStreamWrapper.f13417e.add(hlsMediaChunk3);
                            }
                            hlsSampleStreamWrapper.f13416d.m3923a(chunk2.f13302c, chunk2.f13303d, hlsSampleStreamWrapper.f13413a, chunk2.f13304e, chunk2.f13305f, chunk2.f13306g, chunk2.f13307h, chunk2.f13308i, hlsSampleStreamWrapper.f13415c.m12692a(chunk2, hlsSampleStreamWrapper, hlsSampleStreamWrapper.f13436x));
                            return true;
                        }
                    }
                }
                hlsMediaChunk = hlsMediaChunk3;
                j2 = j4;
                z = false;
                if (z) {
                    a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                    hlsChunkSource.f4869l = a.f13460i;
                    if (hlsMediaChunk != null) {
                        if (z5) {
                            hlsMediaChunk3 = hlsMediaChunk;
                            e = hlsMediaChunk3.mo4256e();
                            hlsUrl = hlsUrl3;
                            if (e < a.f13457f) {
                                hlsChunkSource.f4867j = new BehindLiveWindowException();
                            } else {
                                i2 = e - a.f13457f;
                                if (i2 >= a.f13464m.size()) {
                                    segment = (Segment) a.f13464m.get(i2);
                                    if (segment.f4885e) {
                                        a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                        if (a2.equals(hlsChunkSource.f4870m)) {
                                            hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                        } else {
                                            if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                            }
                                            dataSpec = null;
                                        }
                                    } else {
                                        dataSpec = null;
                                        hlsChunkSource.f4870m = null;
                                        hlsChunkSource.f4871n = null;
                                        hlsChunkSource.f4872o = null;
                                        hlsChunkSource.f4873p = null;
                                    }
                                    segment2 = a.f13463l;
                                    if (segment2 != null) {
                                        dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                    }
                                    dataSpec3 = dataSpec;
                                    elapsedRealtime = a.f13454c + segment.f4884d;
                                    i3 = a.f13456e + segment.f4883c;
                                    timestampAdjusterProvider = hlsChunkSource.f4860c;
                                    timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                    if (timestampAdjuster == null) {
                                        j3 = elapsedRealtime;
                                        timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                        timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                    } else {
                                        j3 = elapsedRealtime;
                                    }
                                    chunk = hlsMediaChunk2;
                                    hlsChunkHolder = hlsChunkHolder2;
                                    hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                    hlsChunkHolder.f4855a = chunk;
                                    hlsSampleStreamWrapper = this;
                                } else if (a.f13461j) {
                                    hlsChunkHolder2.f4856b = true;
                                } else {
                                    hlsChunkHolder2.f4857c = hlsUrl;
                                    hlsChunkSource.f4868k = hlsUrl;
                                }
                            }
                        }
                    }
                    hlsMediaChunk3 = hlsMediaChunk;
                    if (hlsMediaChunk3 != null) {
                        if (hlsChunkSource.f4869l) {
                        }
                    }
                    if (a.f13461j) {
                    }
                    list = a.f13464m;
                    valueOf = Long.valueOf(j4 - a.f13454c);
                    if (hlsChunkSource.f4862e.f13509k) {
                        if (hlsMediaChunk3 == null) {
                            z2 = false;
                            e = Util.m4298a(list, valueOf, z2) + a.f13457f;
                            hlsUrl3 = hlsChunkSource.f4861d[i];
                            a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                            e = hlsMediaChunk3.mo4256e();
                            g = i;
                            hlsUrl = hlsUrl3;
                            if (e < a.f13457f) {
                                i2 = e - a.f13457f;
                                if (i2 >= a.f13464m.size()) {
                                    segment = (Segment) a.f13464m.get(i2);
                                    if (segment.f4885e) {
                                        dataSpec = null;
                                        hlsChunkSource.f4870m = null;
                                        hlsChunkSource.f4871n = null;
                                        hlsChunkSource.f4872o = null;
                                        hlsChunkSource.f4873p = null;
                                    } else {
                                        a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                        if (a2.equals(hlsChunkSource.f4870m)) {
                                            if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                                hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                            }
                                            dataSpec = null;
                                        } else {
                                            hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                        }
                                    }
                                    segment2 = a.f13463l;
                                    if (segment2 != null) {
                                        dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                                    }
                                    dataSpec3 = dataSpec;
                                    elapsedRealtime = a.f13454c + segment.f4884d;
                                    i3 = a.f13456e + segment.f4883c;
                                    timestampAdjusterProvider = hlsChunkSource.f4860c;
                                    timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                                    if (timestampAdjuster == null) {
                                        j3 = elapsedRealtime;
                                    } else {
                                        j3 = elapsedRealtime;
                                        timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                        timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                                    }
                                    chunk = hlsMediaChunk2;
                                    hlsChunkHolder = hlsChunkHolder2;
                                    hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                                    hlsChunkHolder.f4855a = chunk;
                                    hlsSampleStreamWrapper = this;
                                } else if (a.f13461j) {
                                    hlsChunkHolder2.f4857c = hlsUrl;
                                    hlsChunkSource.f4868k = hlsUrl;
                                } else {
                                    hlsChunkHolder2.f4856b = true;
                                }
                            } else {
                                hlsChunkSource.f4867j = new BehindLiveWindowException();
                            }
                        }
                    }
                    z2 = true;
                    e = Util.m4298a(list, valueOf, z2) + a.f13457f;
                    hlsUrl3 = hlsChunkSource.f4861d[i];
                    a = hlsChunkSource.f4862e.m12572a(hlsUrl3);
                    e = hlsMediaChunk3.mo4256e();
                    g = i;
                    hlsUrl = hlsUrl3;
                    if (e < a.f13457f) {
                        hlsChunkSource.f4867j = new BehindLiveWindowException();
                    } else {
                        i2 = e - a.f13457f;
                        if (i2 >= a.f13464m.size()) {
                            segment = (Segment) a.f13464m.get(i2);
                            if (segment.f4885e) {
                                a2 = UriUtil.m4291a(a.o, segment.f4886f);
                                if (a2.equals(hlsChunkSource.f4870m)) {
                                    hlsChunkHolder2.f4855a = new EncryptionKeyChunk(hlsChunkSource.f4859b, new DataSpec(a2, (byte) 0), hlsChunkSource.f4861d[g].f4880b, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), hlsChunkSource.f4866i, segment.f4887g);
                                } else {
                                    if (Util.m4313a(segment.f4887g, hlsChunkSource.f4872o)) {
                                        hlsChunkSource.m4012a(a2, segment.f4887g, hlsChunkSource.f4871n);
                                    }
                                    dataSpec = null;
                                }
                            } else {
                                dataSpec = null;
                                hlsChunkSource.f4870m = null;
                                hlsChunkSource.f4871n = null;
                                hlsChunkSource.f4872o = null;
                                hlsChunkSource.f4873p = null;
                            }
                            segment2 = a.f13463l;
                            if (segment2 != null) {
                                dataSpec2 = new DataSpec(UriUtil.m4291a(a.o, segment2.f4881a), segment2.f4888h, segment2.f4889i, null);
                            }
                            dataSpec3 = dataSpec;
                            elapsedRealtime = a.f13454c + segment.f4884d;
                            i3 = a.f13456e + segment.f4883c;
                            timestampAdjusterProvider = hlsChunkSource.f4860c;
                            timestampAdjuster = (TimestampAdjuster) timestampAdjusterProvider.f4878a.get(i3);
                            if (timestampAdjuster == null) {
                                j3 = elapsedRealtime;
                                timestampAdjuster = new TimestampAdjuster(Long.MAX_VALUE);
                                timestampAdjusterProvider.f4878a.put(i3, timestampAdjuster);
                            } else {
                                j3 = elapsedRealtime;
                            }
                            chunk = hlsMediaChunk2;
                            hlsChunkHolder = hlsChunkHolder2;
                            hlsMediaChunk2 = new HlsMediaChunk(hlsChunkSource.f4858a, new DataSpec(UriUtil.m4291a(a.o, segment.f4881a), segment.f4888h, segment.f4889i, null), dataSpec3, hlsUrl, hlsChunkSource.f4864g, hlsChunkSource.f4874q.mo3370b(), hlsChunkSource.f4874q.mo3371c(), j3, j3 + segment.f4882b, e, i3, hlsChunkSource.f4865h, timestampAdjuster, hlsMediaChunk3, hlsChunkSource.f4871n, hlsChunkSource.f4873p);
                            hlsChunkHolder.f4855a = chunk;
                            hlsSampleStreamWrapper = this;
                        } else if (a.f13461j) {
                            hlsChunkHolder2.f4856b = true;
                        } else {
                            hlsChunkHolder2.f4857c = hlsUrl;
                            hlsChunkSource.f4868k = hlsUrl;
                        }
                    }
                } else {
                    hlsChunkHolder2.f4857c = hlsUrl3;
                    hlsChunkSource.f4868k = hlsUrl3;
                }
                z3 = hlsSampleStreamWrapper.f13437y.f4856b;
                chunk2 = hlsSampleStreamWrapper.f13437y.f4855a;
                hlsUrl2 = hlsSampleStreamWrapper.f13437y.f4857c;
                hlsSampleStreamWrapper.f13437y.m4011a();
                if (z3) {
                    hlsSampleStreamWrapper.f13412D = -9223372036854775807L;
                    hlsSampleStreamWrapper.f13432t = true;
                    return true;
                } else if (chunk2 != null) {
                    if (chunk2 instanceof HlsMediaChunk) {
                        hlsSampleStreamWrapper.f13412D = -9223372036854775807L;
                        hlsMediaChunk3 = (HlsMediaChunk) chunk2;
                        hlsMediaChunk3.f18979n = hlsSampleStreamWrapper;
                        e = hlsMediaChunk3.f18975a;
                        z4 = hlsMediaChunk3.f18978m;
                        hlsSampleStreamWrapper.f13424l = e;
                        while (g < i) {
                            sampleQueue.f13275a.f4769k = e;
                        }
                        if (z4) {
                            while (r6 < i2) {
                                sampleQueue2.f13278d = true;
                            }
                        }
                        hlsSampleStreamWrapper.f13417e.add(hlsMediaChunk3);
                    }
                    hlsSampleStreamWrapper.f13416d.m3923a(chunk2.f13302c, chunk2.f13303d, hlsSampleStreamWrapper.f13413a, chunk2.f13304e, chunk2.f13305f, chunk2.f13306g, chunk2.f13307h, chunk2.f13308i, hlsSampleStreamWrapper.f13415c.m12692a(chunk2, hlsSampleStreamWrapper, hlsSampleStreamWrapper.f13436x));
                    return true;
                } else {
                    if (hlsUrl2 != null) {
                        hlsSampleStreamWrapper.f13433u.mo3372a(hlsUrl2);
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public final long mo1403e() {
        if (m12528j()) {
            return this.f13412D;
        }
        return this.f13432t ? Long.MIN_VALUE : ((HlsMediaChunk) this.f13417e.getLast()).i;
    }

    public final SampleQueue m12511a(int i) {
        int length = this.f13419g.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f13409A[i2] == i) {
                return this.f13419g[i2];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.f13434v);
        sampleQueue.f13279e = this;
        int i3 = length + 1;
        this.f13409A = Arrays.copyOf(this.f13409A, i3);
        this.f13409A[length] = i;
        this.f13419g = (SampleQueue[]) Arrays.copyOf(this.f13419g, i3);
        this.f13419g[length] = sampleQueue;
        return sampleQueue;
    }

    public final void mo1416a() {
        this.f13420h = true;
        this.f13418f.post(this.f13438z);
    }

    public final void mo1440g() {
        this.f13418f.post(this.f13438z);
    }

    final void m12527i() {
        if (!(this.f13425m || this.f13421i)) {
            if (this.f13420h) {
                SampleQueue[] sampleQueueArr = this.f13419g;
                int length = sampleQueueArr.length;
                int i = 0;
                while (i < length) {
                    if (sampleQueueArr[i].f13275a.m3957c() != null) {
                        i++;
                    } else {
                        return;
                    }
                }
                int length2 = this.f13419g.length;
                i = 0;
                int i2 = i;
                int i3 = -1;
                while (true) {
                    boolean z = true;
                    if (i >= length2) {
                        break;
                    }
                    String str = this.f13419g[i].f13275a.m3957c().f4018f;
                    if (!MimeTypes.m4213b(str)) {
                        z = MimeTypes.m4212a(str) ? true : MimeTypes.m4214c(str);
                    }
                    if (z > i2) {
                        i3 = i;
                        i2 = z;
                    } else if (z == i2 && i3 != -1) {
                        i3 = -1;
                    }
                    i++;
                }
                TrackGroup trackGroup = this.f13414b.f4863f;
                int i4 = trackGroup.f4782a;
                this.f13427o = -1;
                this.f13428p = new boolean[length2];
                this.f13411C = new boolean[length2];
                TrackGroup[] trackGroupArr = new TrackGroup[length2];
                for (int i5 = 0; i5 < length2; i5++) {
                    boolean z2;
                    Format[] formatArr;
                    int i6;
                    Format format;
                    Format c = this.f13419g[i5].f13275a.m3957c();
                    String str2 = c.f4018f;
                    if (!MimeTypes.m4213b(str2)) {
                        if (!MimeTypes.m4212a(str2)) {
                            z2 = false;
                            this.f13411C[i5] = z2;
                            this.f13410B = z2 | this.f13410B;
                            if (i5 != i3) {
                                formatArr = new Format[i4];
                                for (i6 = 0; i6 < i4; i6++) {
                                    formatArr[i6] = m12506a(trackGroup.f4783b[i6], c);
                                }
                                trackGroupArr[i5] = new TrackGroup(formatArr);
                                this.f13427o = i5;
                            } else {
                                format = (i2 == 3 || !MimeTypes.m4212a(c.f4018f)) ? null : this.f13435w;
                                trackGroupArr[i5] = new TrackGroup(m12506a(format, c));
                            }
                        }
                    }
                    z2 = true;
                    this.f13411C[i5] = z2;
                    this.f13410B = z2 | this.f13410B;
                    if (i5 != i3) {
                        if (i2 == 3) {
                        }
                        trackGroupArr[i5] = new TrackGroup(m12506a(format, c));
                    } else {
                        formatArr = new Format[i4];
                        for (i6 = 0; i6 < i4; i6++) {
                            formatArr[i6] = m12506a(trackGroup.f4783b[i6], c);
                        }
                        trackGroupArr[i5] = new TrackGroup(formatArr);
                        this.f13427o = i5;
                    }
                }
                this.f13426n = new TrackGroupArray(trackGroupArr);
                this.f13421i = true;
                this.f13433u.mo3374f();
            }
        }
    }

    final void m12513a(int i, boolean z) {
        int i2 = 1;
        Assertions.m4186b(this.f13428p[i] != z);
        this.f13428p[i] = z;
        i = this.f13422j;
        if (!z) {
            i2 = -1;
        }
        this.f13422j = i + i2;
    }

    private static Format m12506a(Format format, Format format2) {
        Format format3 = format;
        Format format4 = format2;
        if (format3 == null) {
            return format4;
        }
        String str = null;
        int g = MimeTypes.m4218g(format4.f4018f);
        if (g == 1) {
            str = m12507a(format3.f4015c, 1);
        } else if (g == 2) {
            str = m12507a(format3.f4015c, 2);
        }
        String str2 = str;
        String str3 = format3.f4013a;
        int i = format3.f4014b;
        int i2 = format3.f4022j;
        int i3 = format3.f4023k;
        int i4 = format3.f4036x;
        String str4 = format3.f4037y;
        String str5 = format4.f4017e;
        String str6 = format4.f4018f;
        int i5 = format4.f4019g;
        float f = format4.f4024l;
        int i6 = format4.f4025m;
        float f2 = format4.f4026n;
        byte[] bArr = format4.f4028p;
        g = format4.f4027o;
        String str7 = str4;
        ColorInfo colorInfo = format4.f4029q;
        int i7 = i4;
        int i8 = format4.f4030r;
        int i9 = format4.f4031s;
        int i10 = format4.f4032t;
        int i11 = format4.f4033u;
        int i12 = format4.f4034v;
        i4 = format4.f4038z;
        float f3 = f2;
        byte[] bArr2 = bArr;
        long j = format4.f4035w;
        long j2 = j;
        return new Format(str3, str5, str6, str2, i, i5, i2, i3, f, i6, f3, bArr2, g, colorInfo, i8, i9, i10, i11, i12, i7, str7, i4, j2, format4.f4020h, format4.f4021i, format4.f4016d);
    }

    final boolean m12528j() {
        return this.f13412D != -9223372036854775807L;
    }

    private static String m12507a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : str) {
            if (i == MimeTypes.m4219h(str2)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > null) {
            return stringBuilder.toString();
        }
        return null;
    }
}
