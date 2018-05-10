package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C0377C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class DashMediaSource implements MediaSource {
    final EventDispatcher f13353a;
    final Object f13354b;
    Uri f13355c;
    long f13356d;
    long f13357e;
    DashManifest f13358f;
    int f13359g;
    private final boolean f13360h;
    private final Factory f13361i;
    private final DashChunkSource.Factory f13362j;
    private final int f13363k;
    private final long f13364l;
    private final Parser<? extends DashManifest> f13365m;
    private final ManifestCallback f13366n;
    private final SparseArray<DashMediaPeriod> f13367o;
    private final Runnable f13368p;
    private final Runnable f13369q;
    private Listener f13370r;
    private DataSource f13371s;
    private Loader f13372t;
    private LoaderErrorThrower f13373u;
    private Handler f13374v;
    private long f13375w;

    class C04161 implements Runnable {
        final /* synthetic */ DashMediaSource f4797a;

        C04161(DashMediaSource dashMediaSource) {
            this.f4797a = dashMediaSource;
        }

        public void run() {
            this.f4797a.m12418d();
        }
    }

    class C04172 implements Runnable {
        final /* synthetic */ DashMediaSource f4798a;

        C04172(DashMediaSource dashMediaSource) {
            this.f4798a = dashMediaSource;
        }

        public void run() {
            this.f4798a.m12427a(false);
        }
    }

    private static final class PeriodSeekInfo {
        public final boolean f4799a;
        public final long f4800b;
        public final long f4801c;

        public static PeriodSeekInfo m3984a(Period period, long j) {
            Period period2 = period;
            long j2 = j;
            int size = period2.f4832c.size();
            int i = 0;
            boolean z = false;
            long j3 = Long.MAX_VALUE;
            long j4 = 0;
            int i2 = z;
            boolean z2 = i2;
            while (i2 < size) {
                DashSegmentIndex d = ((Representation) ((AdaptationSet) period2.f4832c.get(i2)).f4809c.get(i)).mo1432d();
                if (d == null) {
                    return new PeriodSeekInfo(true, 0, j2);
                }
                int i3;
                z |= d.mo1429b();
                int a = d.mo1424a(j2);
                if (a == 0) {
                    i3 = i2;
                    z2 = true;
                    j4 = 0;
                    j3 = 0;
                } else if (z2) {
                    i3 = i2;
                } else {
                    int a2 = d.mo1423a();
                    i3 = i2;
                    long max = Math.max(j4, d.mo1426a(a2));
                    if (a != -1) {
                        a2 = (a2 + a) - 1;
                        j3 = Math.min(j3, d.mo1426a(a2) + d.mo1427a(a2, j2));
                    }
                    j4 = max;
                }
                i2 = i3 + 1;
                i = 0;
            }
            return new PeriodSeekInfo(z, j4, j3);
        }

        private PeriodSeekInfo(boolean z, long j, long j2) {
            this.f4799a = z;
            this.f4800b = j;
            this.f4801c = j2;
        }
    }

    private static final class DashTimeline extends Timeline {
        private final long f13344b;
        private final long f13345c;
        private final int f13346d;
        private final long f13347e;
        private final long f13348f;
        private final long f13349g;
        private final DashManifest f13350h;

        public final int mo1302b() {
            return 1;
        }

        public DashTimeline(long j, long j2, int i, long j3, long j4, long j5, DashManifest dashManifest) {
            this.f13344b = j;
            this.f13345c = j2;
            this.f13346d = i;
            this.f13347e = j3;
            this.f13348f = j4;
            this.f13349g = j5;
            this.f13350h = dashManifest;
        }

        public final int mo1303c() {
            return this.f13350h.m3998a();
        }

        public final Timeline.Period mo1300a(int i, Timeline.Period period, boolean z) {
            Assertions.m4181a(i, this.f13350h.m3998a());
            Integer num = null;
            Object obj = z ? this.f13350h.m3999a(i).f4830a : null;
            if (z) {
                num = Integer.valueOf(this.f13346d + Assertions.m4181a(i, this.f13350h.m3998a()));
            }
            return period.m3624a(obj, num, this.f13350h.m4000b(i), C0377C.m3540b(this.f13350h.m3999a(i).f4831b - this.f13350h.m3999a(false).f4831b) - this.f13347e);
        }

        public final Window mo1301a(int i, Window window, long j) {
            Assertions.m4181a(i, 1);
            long j2 = this.f13349g;
            if (this.f13350h.f4815d) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > r0.f13348f) {
                        j2 = -9223372036854775807L;
                    }
                }
                long j3 = r0.f13347e + j2;
                long b = r0.f13350h.m4000b(0);
                long j4 = j3;
                int i2 = 0;
                while (i2 < r0.f13350h.m3998a() - 1 && j4 >= b) {
                    j4 -= b;
                    i2++;
                    b = r0.f13350h.m4000b(i2);
                }
                Period a = r0.f13350h.m3999a(i2);
                int size = a.f4832c.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((AdaptationSet) a.f4832c.get(i3)).f4808b == 2) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    DashSegmentIndex d = ((Representation) ((AdaptationSet) a.f4832c.get(i3)).f4809c.get(0)).mo1432d();
                    if (d != null) {
                        if (d.mo1424a(b) != 0) {
                            j2 = (j2 + d.mo1426a(d.mo1425a(j4, b))) - j4;
                        }
                    }
                }
            }
            long j5 = j2;
            return window.m3629a(r0.f13344b, r0.f13345c, true, r0.f13350h.f4815d, j5, r0.f13348f, r0.f13350h.m3998a() - 1, r0.f13347e);
        }

        public final int mo1299a(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            obj = ((Integer) obj).intValue();
            if (obj >= this.f13346d) {
                if (obj < this.f13346d + this.f13350h.m3998a()) {
                    return obj - this.f13346d;
                }
            }
            return -1;
        }
    }

    private static final class Iso8601Parser implements Parser<Long> {
        private Iso8601Parser() {
        }

        public final /* bridge */ /* synthetic */ Object mo1422a(Uri uri, InputStream inputStream) throws IOException {
            return m12406a(inputStream);
        }

        private static Long m12406a(InputStream inputStream) throws IOException {
            inputStream = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(inputStream).getTime());
            } catch (Throwable e) {
                throw new ParserException(e);
            }
        }
    }

    private final class ManifestCallback implements Callback<ParsingLoadable<DashManifest>> {
        final /* synthetic */ DashMediaSource f13351a;

        private ManifestCallback(DashMediaSource dashMediaSource) {
            this.f13351a = dashMediaSource;
        }

        public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            DashMediaSource dashMediaSource = this.f13351a;
            dashMediaSource.f13353a.m3927a(parsingLoadable.f13682a, parsingLoadable.f13683b, j, j2, parsingLoadable.f13685d);
            DashManifest dashManifest = (DashManifest) parsingLoadable.f13684c;
            int a = dashMediaSource.f13358f == null ? 0 : dashMediaSource.f13358f.m3998a();
            long j3 = dashManifest.m3999a(0).f4831b;
            int i = 0;
            while (i < a && dashMediaSource.f13358f.m3999a(i).f4831b < j3) {
                i++;
            }
            if (a - i > dashManifest.m3998a()) {
                Log.w("DashMediaSource", "Out of sync manifest");
                dashMediaSource.m12429c();
                return;
            }
            dashMediaSource.f13358f = dashManifest;
            dashMediaSource.f13356d = j - j2;
            dashMediaSource.f13357e = j;
            if (dashMediaSource.f13358f.f4820i != null) {
                synchronized (dashMediaSource.f13354b) {
                    if (parsingLoadable.f13682a.f5167a == dashMediaSource.f13355c) {
                        dashMediaSource.f13355c = dashMediaSource.f13358f.f4820i;
                    }
                }
            }
            if (a != 0) {
                dashMediaSource.f13359g += i;
                dashMediaSource.m12427a(true);
            } else if (dashMediaSource.f13358f.f4819h != null) {
                UtcTimingElement utcTimingElement = dashMediaSource.f13358f.f4819h;
                Object obj = utcTimingElement.f4853a;
                if (!Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:direct:2014")) {
                    if (!Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:direct:2012")) {
                        if (!Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:http-iso:2014")) {
                            if (!Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:http-iso:2012")) {
                                if (!Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:http-xsdate:2014")) {
                                    if (Util.m4313a(obj, (Object) "urn:mpeg:dash:utc:http-xsdate:2012") == null) {
                                        dashMediaSource.m12426a(new IOException("Unsupported UTC timing scheme"));
                                        return;
                                    }
                                }
                                dashMediaSource.m12424a(utcTimingElement, new XsDateTimeParser());
                                return;
                            }
                        }
                        dashMediaSource.m12424a(utcTimingElement, new Iso8601Parser());
                        return;
                    }
                }
                try {
                    dashMediaSource.m12421a(Util.m4325f(utcTimingElement.f4854b) - dashMediaSource.f13357e);
                } catch (IOException e) {
                    dashMediaSource.m12426a(e);
                }
            } else {
                dashMediaSource.m12427a(true);
            }
        }
    }

    private final class UtcTimestampCallback implements Callback<ParsingLoadable<Long>> {
        final /* synthetic */ DashMediaSource f13352a;

        private UtcTimestampCallback(DashMediaSource dashMediaSource) {
            this.f13352a = dashMediaSource;
        }

        public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
            ParsingLoadable parsingLoadable = (ParsingLoadable) loadable;
            DashMediaSource dashMediaSource = this.f13352a;
            dashMediaSource.f13353a.m3927a(parsingLoadable.f13682a, parsingLoadable.f13683b, j, j2, parsingLoadable.f13685d);
            dashMediaSource.m12421a(((Long) parsingLoadable.f13684c).longValue() - j);
        }
    }

    private static final class XsDateTimeParser implements Parser<Long> {
        private XsDateTimeParser() {
        }

        public final /* synthetic */ Object mo1422a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.m4325f(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        ExoPlayerLibraryInfo.m3553a("goog.exo.dash");
    }

    public DashMediaSource(Uri uri, Factory factory, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, handler, adaptiveMediaSourceEventListener, (byte) 0);
    }

    private DashMediaSource(Uri uri, Factory factory, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, byte b) {
        this(uri, factory, new DashManifestParser(), factory2, handler, adaptiveMediaSourceEventListener);
    }

    private DashMediaSource(Uri uri, Factory factory, Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, parser, factory2, handler, adaptiveMediaSourceEventListener, (byte) 0);
    }

    private DashMediaSource(Uri uri, Factory factory, Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener, byte b) {
        this.f13358f = null;
        this.f13355c = uri;
        this.f13361i = factory;
        this.f13365m = parser;
        this.f13362j = factory2;
        this.f13363k = 3;
        this.f13364l = -1;
        this.f13360h = false;
        this.f13353a = new EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.f13354b = new Object();
        this.f13367o = new SparseArray();
        if (this.f13360h != null) {
            Assertions.m4186b(null.f4815d ^ 1);
            this.f13366n = null;
            this.f13368p = null;
            this.f13369q = null;
            return;
        }
        this.f13366n = new ManifestCallback();
        this.f13368p = new C04161(this);
        this.f13369q = new C04172(this);
    }

    public final void mo1410a(ExoPlayer exoPlayer, Listener listener) {
        this.f13370r = listener;
        if (this.f13360h != null) {
            this.f13373u = new Dummy();
            m12427a((boolean) null);
            return;
        }
        this.f13371s = this.f13361i.mo1475a();
        this.f13372t = new Loader("Loader:DashMediaSource");
        this.f13373u = this.f13372t;
        this.f13374v = new Handler();
        m12418d();
    }

    public final void mo1408a() throws IOException {
        this.f13373u.mo1477c();
    }

    public final MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator) {
        int i = mediaPeriodId.f4752b;
        mediaPeriodId = this.f13353a;
        MediaPeriodId dashMediaPeriod = new DashMediaPeriod(this.f13359g + i, this.f13358f, i, this.f13362j, this.f13363k, new EventDispatcher(mediaPeriodId.f4741a, mediaPeriodId.f4742b, this.f13358f.m3999a(i).f4831b), this.f13375w, this.f13373u, allocator);
        this.f13367o.put(dashMediaPeriod.f16966a, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public final void mo1411a(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        for (ChunkSampleStream c : dashMediaPeriod.f16968c) {
            c.m12394c();
        }
        this.f13367o.remove(dashMediaPeriod.f16966a);
    }

    public final void mo1412b() {
        this.f13371s = null;
        this.f13373u = null;
        if (this.f13372t != null) {
            this.f13372t.m12694a(null);
            this.f13372t = null;
        }
        this.f13356d = 0;
        this.f13357e = 0;
        this.f13358f = null;
        if (this.f13374v != null) {
            this.f13374v.removeCallbacksAndMessages(null);
            this.f13374v = null;
        }
        this.f13375w = 0;
        this.f13367o.clear();
    }

    final void m12425a(ParsingLoadable<?> parsingLoadable, long j, long j2) {
        this.f13353a.m3930b(parsingLoadable.f13682a, parsingLoadable.f13683b, j, j2, parsingLoadable.f13685d);
    }

    private void m12418d() {
        Uri uri;
        synchronized (this.f13354b) {
            uri = this.f13355c;
        }
        m12416a(new ParsingLoadable(this.f13371s, uri, 4, this.f13365m), this.f13366n, this.f13363k);
    }

    final void m12424a(UtcTimingElement utcTimingElement, Parser<Long> parser) {
        m12416a(new ParsingLoadable(this.f13371s, Uri.parse(utcTimingElement.f4854b), 5, parser), new UtcTimestampCallback(), 1);
    }

    final void m12421a(long j) {
        this.f13375w = j;
        m12427a((boolean) 1);
    }

    final void m12426a(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        m12427a(true);
    }

    final void m12427a(boolean z) {
        int i;
        DashMediaSource dashMediaSource = this;
        for (i = 0; i < dashMediaSource.f13367o.size(); i++) {
            int keyAt = dashMediaSource.f13367o.keyAt(i);
            if (keyAt >= dashMediaSource.f13359g) {
                DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) dashMediaSource.f13367o.valueAt(i);
                DashManifest dashManifest = dashMediaSource.f13358f;
                keyAt -= dashMediaSource.f13359g;
                dashMediaPeriod.f16969d = dashManifest;
                dashMediaPeriod.f16970e = keyAt;
                dashMediaPeriod.f16971f = dashManifest.m3999a(keyAt).f4832c;
                if (dashMediaPeriod.f16968c != null) {
                    for (ChunkSampleStream chunkSampleStream : dashMediaPeriod.f16968c) {
                        ((DashChunkSource) chunkSampleStream.f13327b).mo3362a(dashManifest, keyAt);
                    }
                    dashMediaPeriod.f16967b.mo3348a(dashMediaPeriod);
                }
            }
        }
        i = dashMediaSource.f13358f.m3998a() - 1;
        PeriodSeekInfo a = PeriodSeekInfo.m3984a(dashMediaSource.f13358f.m3999a(0), dashMediaSource.f13358f.m4000b(0));
        PeriodSeekInfo a2 = PeriodSeekInfo.m3984a(dashMediaSource.f13358f.m3999a(i), dashMediaSource.f13358f.m4000b(i));
        long j = a.f4800b;
        long j2 = a2.f4801c;
        long j3 = 0;
        if (!dashMediaSource.f13358f.f4815d || a2.f4799a) {
            i = 0;
        } else {
            long b;
            if (dashMediaSource.f13375w != 0) {
                b = C0377C.m3540b(SystemClock.elapsedRealtime() + dashMediaSource.f13375w);
            } else {
                b = C0377C.m3540b(System.currentTimeMillis());
            }
            j2 = Math.min((b - C0377C.m3540b(dashMediaSource.f13358f.f4812a)) - C0377C.m3540b(dashMediaSource.f13358f.m3999a(i).f4831b), j2);
            if (dashMediaSource.f13358f.f4817f != -9223372036854775807L) {
                b = j2 - C0377C.m3540b(dashMediaSource.f13358f.f4817f);
                while (b < 0 && i > 0) {
                    i--;
                    b += dashMediaSource.f13358f.m4000b(i);
                }
                if (i == 0) {
                    b = Math.max(j, b);
                } else {
                    b = dashMediaSource.f13358f.m4000b(0);
                }
                j = b;
            }
            i = 1;
        }
        long j4 = j2 - j;
        for (int i2 = 0; i2 < dashMediaSource.f13358f.m3998a() - 1; i2++) {
            j4 += dashMediaSource.f13358f.m4000b(i2);
        }
        if (dashMediaSource.f13358f.f4815d) {
            long j5 = dashMediaSource.f13364l;
            if (j5 == -1) {
                j5 = dashMediaSource.f13358f.f4818g != -9223372036854775807L ? dashMediaSource.f13358f.f4818g : 30000;
            }
            j3 = j4 - C0377C.m3540b(j5);
            if (j3 < 5000000) {
                j3 = Math.min(5000000, j4 / 2);
            }
        }
        dashMediaSource.f13370r.mo1413a(new DashTimeline(dashMediaSource.f13358f.f4812a, (dashMediaSource.f13358f.f4812a + dashMediaSource.f13358f.m3999a(0).f4831b) + C0377C.m3539a(j), dashMediaSource.f13359g, j, j4, j3, dashMediaSource.f13358f), dashMediaSource.f13358f);
        if (!dashMediaSource.f13360h) {
            dashMediaSource.f13374v.removeCallbacks(dashMediaSource.f13369q);
            if (i != 0) {
                dashMediaSource.f13374v.postDelayed(dashMediaSource.f13369q, 5000);
            }
            if (z) {
                m12429c();
            }
        }
    }

    final void m12429c() {
        if (this.f13358f.f4815d) {
            long j = this.f13358f.f4816e;
            if (j == 0) {
                j = 5000;
            }
            this.f13374v.postDelayed(this.f13368p, Math.max(0, (this.f13356d + j) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void m12416a(ParsingLoadable<T> parsingLoadable, Callback<ParsingLoadable<T>> callback, int i) {
        this.f13353a.m3926a(parsingLoadable.f13682a, parsingLoadable.f13683b, this.f13372t.m12692a(parsingLoadable, callback, i));
    }
}
