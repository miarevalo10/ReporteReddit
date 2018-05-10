package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener;
import com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

final class ExtractorMediaPeriod implements ExtractorOutput, MediaPeriod, UpstreamFormatChangedListener, Callback<ExtractingLoadable>, ReleaseCallback {
    private int f16917A;
    private TrackGroupArray f16918B;
    private long f16919C;
    private boolean[] f16920D;
    private boolean[] f16921E;
    private boolean f16922F;
    private long f16923G;
    private long f16924H;
    private int f16925I;
    final Loader f16926a = new Loader("Loader:ExtractorMediaPeriod");
    final Handler f16927b;
    SampleQueue[] f16928c;
    boolean f16929d;
    boolean f16930e;
    long f16931f;
    boolean f16932g;
    boolean f16933h;
    private final Uri f16934i;
    private final DataSource f16935j;
    private final int f16936k;
    private final Handler f16937l;
    private final EventListener f16938m;
    private final Listener f16939n;
    private final Allocator f16940o;
    private final String f16941p;
    private final long f16942q;
    private final ExtractorHolder f16943r;
    private final ConditionVariable f16944s;
    private final Runnable f16945t;
    private final Runnable f16946u;
    private MediaPeriod.Callback f16947v;
    private SeekMap f16948w;
    private int[] f16949x;
    private boolean f16950y;
    private boolean f16951z;

    class C04131 implements Runnable {
        final /* synthetic */ ExtractorMediaPeriod f4744a;

        C04131(ExtractorMediaPeriod extractorMediaPeriod) {
            this.f4744a = extractorMediaPeriod;
        }

        public void run() {
            ExtractorMediaPeriod.m17206a(this.f4744a);
        }
    }

    class C04142 implements Runnable {
        final /* synthetic */ ExtractorMediaPeriod f4745a;

        C04142(ExtractorMediaPeriod extractorMediaPeriod) {
            this.f4745a = extractorMediaPeriod;
        }

        public void run() {
            if (!this.f4745a.f16933h) {
                this.f4745a.f16947v.mo3348a(this.f4745a);
            }
        }
    }

    private static final class ExtractorHolder {
        Extractor f4748a;
        private final Extractor[] f4749b;
        private final ExtractorOutput f4750c;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
            this.f4749b = extractorArr;
            this.f4750c = extractorOutput;
        }

        public final com.google.android.exoplayer2.extractor.Extractor m3932a(com.google.android.exoplayer2.extractor.ExtractorInput r6, android.net.Uri r7) throws java.io.IOException, java.lang.InterruptedException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r5 = this;
            r0 = r5.f4748a;
            if (r0 == 0) goto L_0x0007;
        L_0x0004:
            r6 = r5.f4748a;
            return r6;
        L_0x0007:
            r0 = r5.f4749b;
            r1 = r0.length;
            r2 = 0;
        L_0x000b:
            if (r2 >= r1) goto L_0x0026;
        L_0x000d:
            r3 = r0[r2];
            r4 = r3.mo1353a(r6);	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
            if (r4 == 0) goto L_0x0020;	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
        L_0x0015:
            r5.f4748a = r3;	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
            r6.mo1332a();
            goto L_0x0026;
        L_0x001b:
            r7 = move-exception;
            r6.mo1332a();
            throw r7;
        L_0x0020:
            r6.mo1332a();
            r2 = r2 + 1;
            goto L_0x000b;
        L_0x0026:
            r6 = r5.f4748a;
            if (r6 != 0) goto L_0x0049;
        L_0x002a:
            r6 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
            r0 = new java.lang.StringBuilder;
            r1 = "None of the available extractors (";
            r0.<init>(r1);
            r1 = r5.f4749b;
            r1 = com.google.android.exoplayer2.util.Util.m4305a(r1);
            r0.append(r1);
            r1 = ") could read the stream.";
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0, r7);
            throw r6;
        L_0x0049:
            r6 = r5.f4748a;
            r7 = r5.f4750c;
            r6.mo1352a(r7);
            r6 = r5.f4748a;
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ExtractorMediaPeriod.ExtractorHolder.a(com.google.android.exoplayer2.extractor.ExtractorInput, android.net.Uri):com.google.android.exoplayer2.extractor.Extractor");
        }
    }

    interface Listener {
        void mo1409a(long j, boolean z);
    }

    final class ExtractingLoadable implements Loadable {
        final /* synthetic */ ExtractorMediaPeriod f13241a;
        private final Uri f13242b;
        private final DataSource f13243c;
        private final ExtractorHolder f13244d;
        private final ConditionVariable f13245e;
        private final PositionHolder f13246f = new PositionHolder();
        private volatile boolean f13247g;
        private boolean f13248h = true;
        private long f13249i;
        private long f13250j = -1;

        public ExtractingLoadable(ExtractorMediaPeriod extractorMediaPeriod, Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, ConditionVariable conditionVariable) {
            this.f13241a = extractorMediaPeriod;
            this.f13242b = (Uri) Assertions.m4182a((Object) uri);
            this.f13243c = (DataSource) Assertions.m4182a((Object) dataSource);
            this.f13244d = (ExtractorHolder) Assertions.m4182a((Object) extractorHolder);
            this.f13245e = conditionVariable;
        }

        public final void m12311a(long j, long j2) {
            this.f13246f.f4268a = j;
            this.f13249i = j2;
            this.f13248h = 1;
        }

        public final void mo1404a() {
            this.f13247g = true;
        }

        public final boolean mo1405b() {
            return this.f13247g;
        }

        public final void mo1406c() throws IOException, InterruptedException {
            Throwable th;
            boolean z = false;
            while (!z && !this.f13247g) {
                try {
                    long j = this.f13246f.f4268a;
                    this.f13250j = this.f13243c.mo1435a(new DataSpec(this.f13242b, j, -1, this.f13241a.f16941p));
                    if (this.f13250j != -1) {
                        this.f13250j += j;
                    }
                    ExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f13243c, j, this.f13250j);
                    try {
                        Extractor a = this.f13244d.m3932a(defaultExtractorInput, this.f13243c.mo1437b());
                        if (this.f13248h) {
                            a.mo1351a(j, this.f13249i);
                            this.f13248h = false;
                        }
                        while (!z && !this.f13247g) {
                            this.f13245e.m4205c();
                            boolean a2 = a.mo1350a(defaultExtractorInput, this.f13246f);
                            try {
                                if (defaultExtractorInput.mo1338c() > this.f13241a.f16942q + j) {
                                    j = defaultExtractorInput.mo1338c();
                                    this.f13245e.m4204b();
                                    this.f13241a.f16927b.post(this.f13241a.f16946u);
                                }
                                z = a2;
                            } catch (Throwable th2) {
                                th = th2;
                                z = a2;
                            }
                        }
                        if (z) {
                            z = false;
                        } else {
                            this.f13246f.f4268a = defaultExtractorInput.mo1338c();
                        }
                        Util.m4307a(this.f13243c);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    ExtractorInput extractorInput = null;
                }
            }
            return;
            if (!(z || extractorInput == null)) {
                this.f13246f.f4268a = extractorInput.mo1338c();
            }
            Util.m4307a(this.f13243c);
            throw th;
        }
    }

    private final class SampleStreamImpl implements SampleStream {
        final /* synthetic */ ExtractorMediaPeriod f13251a;
        private final int f13252b;

        public SampleStreamImpl(ExtractorMediaPeriod extractorMediaPeriod, int i) {
            this.f13251a = extractorMediaPeriod;
            this.f13252b = i;
        }

        public final boolean mo1399a() {
            ExtractorMediaPeriod extractorMediaPeriod = this.f13251a;
            int i = this.f13252b;
            if (!extractorMediaPeriod.f16932g) {
                if (extractorMediaPeriod.m17234h() || !extractorMediaPeriod.f16928c[i].f13275a.m3956b()) {
                    return false;
                }
            }
            return true;
        }

        public final void mo1400b() throws IOException {
            this.f13251a.f16926a.mo1477c();
        }

        public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            ExtractorMediaPeriod extractorMediaPeriod = this.f13251a;
            int i = this.f13252b;
            if (!extractorMediaPeriod.f16930e) {
                if (!extractorMediaPeriod.m17234h()) {
                    return extractorMediaPeriod.f16928c[i].m12350a(formatHolder, decoderInputBuffer, z, extractorMediaPeriod.f16932g, extractorMediaPeriod.f16931f);
                }
            }
            return -3;
        }

        public final void mo1398a(long j) {
            ExtractorMediaPeriod extractorMediaPeriod = this.f13251a;
            SampleQueue sampleQueue = extractorMediaPeriod.f16928c[this.f13252b];
            if (!extractorMediaPeriod.f16932g || j <= sampleQueue.f13275a.m3958d()) {
                sampleQueue.m12358a(j, true);
            } else {
                sampleQueue.f13275a.m3960f();
            }
        }
    }

    public final /* synthetic */ int mo1418a(Loadable loadable, long j, long j2, final IOException iOException) {
        ExtractingLoadable extractingLoadable = (ExtractingLoadable) loadable;
        m17205a(extractingLoadable);
        if (!(this.f16937l == null || this.f16938m == null)) {
            this.f16937l.post(new Runnable(this) {
                final /* synthetic */ ExtractorMediaPeriod f4747b;

                public void run() {
                    this.f4747b.f16938m.m3934b(iOException);
                }
            });
        }
        if ((iOException instanceof UnrecognizedInputFormatException) != null) {
            return 3;
        }
        j = m17215j() > this.f16925I ? 1 : 0;
        if (this.f16923G == -1 && (this.f16948w == null || this.f16948w.mo1328b() == -9223372036854775807L)) {
            this.f16931f = 0;
            this.f16930e = this.f16929d;
            for (SampleQueue a : this.f16928c) {
                a.m12357a(false);
            }
            extractingLoadable.m12311a(0, 0);
        }
        this.f16925I = m17215j();
        return j != null ? 1 : 0;
    }

    public final /* synthetic */ void mo1419a(Loadable loadable, long j, long j2) {
        m17205a((ExtractingLoadable) loadable);
        this.f16932g = true;
        if (this.f16919C == -9223372036854775807L) {
            loadable = m17216k();
            this.f16919C = loadable == Long.MIN_VALUE ? 0 : loadable + 10000;
            this.f16939n.mo1409a(this.f16919C, this.f16948w.a_());
        }
        this.f16947v.mo3348a(this);
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i, Handler handler, EventListener eventListener, Listener listener, Allocator allocator, String str, int i2) {
        this.f16934i = uri;
        this.f16935j = dataSource;
        this.f16936k = i;
        this.f16937l = handler;
        this.f16938m = eventListener;
        this.f16939n = listener;
        this.f16940o = allocator;
        this.f16941p = str;
        this.f16942q = (long) i2;
        this.f16943r = new ExtractorHolder(extractorArr, this);
        this.f16944s = new ConditionVariable();
        this.f16945t = new C04131(this);
        this.f16946u = new C04142(this);
        this.f16927b = new Handler();
        this.f16949x = new int[0];
        this.f16928c = new SampleQueue[0];
        this.f16924H = 1;
        this.f16923G = -1;
    }

    public final void mo1421f() {
        ExtractorHolder extractorHolder = this.f16943r;
        if (extractorHolder.f4748a != null) {
            extractorHolder.f4748a = null;
        }
        for (SampleQueue a : this.f16928c) {
            a.m12357a(false);
        }
    }

    public final void mo3353a(MediaPeriod.Callback callback, long j) {
        this.f16947v = callback;
        this.f16944s.m4203a();
        m17214i();
    }

    public final TrackGroupArray mo3355b() {
        return this.f16918B;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo3351a(com.google.android.exoplayer2.trackselection.TrackSelection[] r7, boolean[] r8, com.google.android.exoplayer2.source.SampleStream[] r9, boolean[] r10, long r11) {
        /*
        r6 = this;
        r0 = r6.f16929d;
        com.google.android.exoplayer2.util.Assertions.m4186b(r0);
        r0 = r6.f16917A;
        r1 = 0;
        r2 = r1;
    L_0x0009:
        r3 = 1;
        r4 = r7.length;
        if (r2 >= r4) goto L_0x0037;
    L_0x000d:
        r4 = r9[r2];
        if (r4 == 0) goto L_0x0034;
    L_0x0011:
        r4 = r7[r2];
        if (r4 == 0) goto L_0x0019;
    L_0x0015:
        r4 = r8[r2];
        if (r4 != 0) goto L_0x0034;
    L_0x0019:
        r4 = r9[r2];
        r4 = (com.google.android.exoplayer2.source.ExtractorMediaPeriod.SampleStreamImpl) r4;
        r4 = r4.f13252b;
        r5 = r6.f16920D;
        r5 = r5[r4];
        com.google.android.exoplayer2.util.Assertions.m4186b(r5);
        r5 = r6.f16917A;
        r5 = r5 - r3;
        r6.f16917A = r5;
        r3 = r6.f16920D;
        r3[r4] = r1;
        r3 = 0;
        r9[r2] = r3;
    L_0x0034:
        r2 = r2 + 1;
        goto L_0x0009;
    L_0x0037:
        r8 = r6.f16951z;
        if (r8 == 0) goto L_0x0041;
    L_0x003b:
        if (r0 != 0) goto L_0x003f;
    L_0x003d:
        r8 = r3;
        goto L_0x0048;
    L_0x003f:
        r8 = r1;
        goto L_0x0048;
    L_0x0041:
        r4 = 0;
        r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1));
        if (r8 == 0) goto L_0x003f;
    L_0x0047:
        goto L_0x003d;
    L_0x0048:
        r0 = r8;
        r8 = r1;
    L_0x004a:
        r2 = r7.length;
        if (r8 >= r2) goto L_0x00ae;
    L_0x004d:
        r2 = r9[r8];
        if (r2 != 0) goto L_0x00ab;
    L_0x0051:
        r2 = r7[r8];
        if (r2 == 0) goto L_0x00ab;
    L_0x0055:
        r2 = r7[r8];
        r4 = r2.mo1461e();
        if (r4 != r3) goto L_0x005f;
    L_0x005d:
        r4 = r3;
        goto L_0x0060;
    L_0x005f:
        r4 = r1;
    L_0x0060:
        com.google.android.exoplayer2.util.Assertions.m4186b(r4);
        r4 = r2.mo1457b(r1);
        if (r4 != 0) goto L_0x006b;
    L_0x0069:
        r4 = r3;
        goto L_0x006c;
    L_0x006b:
        r4 = r1;
    L_0x006c:
        com.google.android.exoplayer2.util.Assertions.m4186b(r4);
        r4 = r6.f16918B;
        r2 = r2.mo1459d();
        r2 = r4.m3975a(r2);
        r4 = r6.f16920D;
        r4 = r4[r2];
        r4 = r4 ^ r3;
        com.google.android.exoplayer2.util.Assertions.m4186b(r4);
        r4 = r6.f16917A;
        r4 = r4 + r3;
        r6.f16917A = r4;
        r4 = r6.f16920D;
        r4[r2] = r3;
        r4 = new com.google.android.exoplayer2.source.ExtractorMediaPeriod$SampleStreamImpl;
        r4.<init>(r6, r2);
        r9[r8] = r4;
        r10[r8] = r3;
        if (r0 != 0) goto L_0x00ab;
    L_0x0095:
        r0 = r6.f16928c;
        r0 = r0[r2];
        r0.m12359b();
        r2 = r0.m12358a(r11, r3);
        if (r2 != 0) goto L_0x00aa;
    L_0x00a2:
        r0 = r0.m12349a();
        if (r0 == 0) goto L_0x00aa;
    L_0x00a8:
        r0 = r3;
        goto L_0x00ab;
    L_0x00aa:
        r0 = r1;
    L_0x00ab:
        r8 = r8 + 1;
        goto L_0x004a;
    L_0x00ae:
        r7 = r6.f16917A;
        if (r7 != 0) goto L_0x00dd;
    L_0x00b2:
        r6.f16930e = r1;
        r7 = r6.f16926a;
        r7 = r7.m12693a();
        if (r7 == 0) goto L_0x00cf;
    L_0x00bc:
        r7 = r6.f16928c;
        r8 = r7.length;
    L_0x00bf:
        if (r1 >= r8) goto L_0x00c9;
    L_0x00c1:
        r9 = r7[r1];
        r9.m12361d();
        r1 = r1 + 1;
        goto L_0x00bf;
    L_0x00c9:
        r7 = r6.f16926a;
        r7.m12695b();
        goto L_0x00ef;
    L_0x00cf:
        r7 = r6.f16928c;
        r8 = r7.length;
        r9 = r1;
    L_0x00d3:
        if (r9 >= r8) goto L_0x00ef;
    L_0x00d5:
        r10 = r7[r9];
        r10.m12357a(r1);
        r9 = r9 + 1;
        goto L_0x00d3;
    L_0x00dd:
        if (r0 == 0) goto L_0x00ef;
    L_0x00df:
        r11 = r6.mo3354b(r11);
    L_0x00e3:
        r7 = r9.length;
        if (r1 >= r7) goto L_0x00ef;
    L_0x00e6:
        r7 = r9[r1];
        if (r7 == 0) goto L_0x00ec;
    L_0x00ea:
        r10[r1] = r3;
    L_0x00ec:
        r1 = r1 + 1;
        goto L_0x00e3;
    L_0x00ef:
        r6.f16951z = r3;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ExtractorMediaPeriod.a(com.google.android.exoplayer2.trackselection.TrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    public final void mo3352a(long j) {
        int length = this.f16928c.length;
        for (int i = 0; i < length; i++) {
            this.f16928c[i].m12354a(j, false, this.f16920D[i]);
        }
    }

    public final boolean mo1401c(long j) {
        if (this.f16932g == null) {
            if (this.f16929d == null || this.f16917A != null) {
                j = this.f16944s.m4203a();
                if (!this.f16926a.m12693a()) {
                    m17214i();
                    j = 1;
                }
                return j;
            }
        }
        return 0;
    }

    public final long mo1403e() {
        return this.f16917A == 0 ? Long.MIN_VALUE : mo1402d();
    }

    public final long mo3357c() {
        if (!this.f16930e) {
            return -9223372036854775807L;
        }
        this.f16930e = false;
        return this.f16931f;
    }

    public final long mo1402d() {
        if (this.f16932g) {
            return Long.MIN_VALUE;
        }
        if (m17234h()) {
            return this.f16924H;
        }
        long j;
        if (this.f16922F) {
            j = Long.MAX_VALUE;
            int length = this.f16928c.length;
            for (int i = 0; i < length; i++) {
                if (this.f16921E[i]) {
                    j = Math.min(j, this.f16928c[i].f13275a.m3958d());
                }
            }
        } else {
            j = m17216k();
        }
        return j == Long.MIN_VALUE ? this.f16931f : j;
    }

    public final long mo3354b(long j) {
        int i;
        if (!this.f16948w.a_()) {
            j = 0;
        }
        this.f16931f = j;
        this.f16930e = false;
        if (!m17234h()) {
            boolean z;
            int length = this.f16928c.length;
            i = 0;
            while (i < length) {
                SampleQueue sampleQueue = this.f16928c[i];
                sampleQueue.m12359b();
                if (!sampleQueue.m12358a(j, false) && (this.f16921E[i] || !this.f16922F)) {
                    z = false;
                    break;
                }
                sampleQueue.m12360c();
                i++;
            }
            z = true;
            if (z) {
                return j;
            }
        }
        this.f16924H = j;
        this.f16932g = false;
        if (this.f16926a.m12693a()) {
            this.f16926a.m12695b();
        } else {
            for (SampleQueue a : this.f16928c) {
                a.m12357a(false);
            }
        }
        return j;
    }

    public final TrackOutput mo1415a(int i, int i2) {
        i2 = this.f16928c.length;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f16949x[i3] == i) {
                return this.f16928c[i3];
            }
        }
        TrackOutput sampleQueue = new SampleQueue(this.f16940o);
        sampleQueue.f13279e = this;
        int i4 = i2 + 1;
        this.f16949x = Arrays.copyOf(this.f16949x, i4);
        this.f16949x[i2] = i;
        this.f16928c = (SampleQueue[]) Arrays.copyOf(this.f16928c, i4);
        this.f16928c[i2] = sampleQueue;
        return sampleQueue;
    }

    public final void mo1416a() {
        this.f16950y = true;
        this.f16927b.post(this.f16945t);
    }

    public final void mo1417a(SeekMap seekMap) {
        this.f16948w = seekMap;
        this.f16927b.post(this.f16945t);
    }

    public final void mo1440g() {
        this.f16927b.post(this.f16945t);
    }

    private void m17205a(ExtractingLoadable extractingLoadable) {
        if (this.f16923G == -1) {
            this.f16923G = extractingLoadable.f13250j;
        }
    }

    private void m17214i() {
        Loadable extractingLoadable = new ExtractingLoadable(this, this.f16934i, this.f16935j, this.f16943r, this.f16944s);
        if (this.f16929d) {
            Assertions.m4186b(m17234h());
            if (this.f16919C == -9223372036854775807L || this.f16924H < this.f16919C) {
                extractingLoadable.m12311a(this.f16948w.mo1329b(this.f16924H), this.f16924H);
                this.f16924H = -9223372036854775807L;
            } else {
                this.f16932g = true;
                this.f16924H = -9223372036854775807L;
                return;
            }
        }
        this.f16925I = m17215j();
        int i = this.f16936k;
        if (i == -1) {
            if (this.f16929d && this.f16923G == -1) {
                if (this.f16948w == null || this.f16948w.mo1328b() == -9223372036854775807L) {
                    i = 6;
                }
            }
            i = 3;
        }
        this.f16926a.m12692a(extractingLoadable, this, i);
    }

    private int m17215j() {
        SampleQueue[] sampleQueueArr = this.f16928c;
        int i = 0;
        int i2 = 0;
        while (i < sampleQueueArr.length) {
            i2 += sampleQueueArr[i].f13275a.m3947a();
            i++;
        }
        return i2;
    }

    private long m17216k() {
        long j = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.f16928c) {
            j = Math.max(j, sampleQueue.f13275a.m3958d());
        }
        return j;
    }

    final boolean m17234h() {
        return this.f16924H != -9223372036854775807L;
    }

    public final void b_() throws IOException {
        this.f16926a.mo1477c();
    }

    static /* synthetic */ void m17206a(ExtractorMediaPeriod extractorMediaPeriod) {
        if (!(extractorMediaPeriod.f16933h || extractorMediaPeriod.f16929d || extractorMediaPeriod.f16948w == null)) {
            if (extractorMediaPeriod.f16950y) {
                for (SampleQueue sampleQueue : extractorMediaPeriod.f16928c) {
                    if (sampleQueue.f13275a.m3957c() == null) {
                        break;
                    }
                }
                extractorMediaPeriod.f16944s.m4204b();
                int length = extractorMediaPeriod.f16928c.length;
                TrackGroup[] trackGroupArr = new TrackGroup[length];
                extractorMediaPeriod.f16921E = new boolean[length];
                extractorMediaPeriod.f16920D = new boolean[length];
                extractorMediaPeriod.f16919C = extractorMediaPeriod.f16948w.mo1328b();
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= length) {
                        break;
                    }
                    trackGroupArr[i] = new TrackGroup(extractorMediaPeriod.f16928c[i].f13275a.m3957c());
                    String str = r5.f4018f;
                    if (!MimeTypes.m4213b(str)) {
                        if (!MimeTypes.m4212a(str)) {
                            z = false;
                        }
                    }
                    extractorMediaPeriod.f16921E[i] = z;
                    extractorMediaPeriod.f16922F = z | extractorMediaPeriod.f16922F;
                    i++;
                }
                extractorMediaPeriod.f16918B = new TrackGroupArray(trackGroupArr);
                extractorMediaPeriod.f16929d = true;
                extractorMediaPeriod.f16939n.mo1409a(extractorMediaPeriod.f16919C, extractorMediaPeriod.f16948w.a_());
                extractorMediaPeriod.f16947v.mo3347a(extractorMediaPeriod);
            }
        }
    }
}
