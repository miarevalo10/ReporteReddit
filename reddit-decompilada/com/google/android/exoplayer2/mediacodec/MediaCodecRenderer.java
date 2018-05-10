package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] f18913k = Util.m4327h("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean f18914A;
    private boolean f18915B;
    private boolean f18916C;
    private boolean f18917D;
    private boolean f18918E;
    private ByteBuffer[] f18919F;
    private ByteBuffer[] f18920G;
    private long f18921H;
    private int f18922I;
    private int f18923J;
    private boolean f18924K;
    private boolean f18925L;
    private int f18926M;
    private int f18927N;
    private boolean f18928O;
    private boolean f18929P;
    private boolean f18930Q;
    private boolean f18931R;
    private boolean f18932S;
    private boolean f18933T;
    protected MediaCodec f18934h;
    protected MediaCodecInfo f18935i;
    protected DecoderCounters f18936j;
    private final MediaCodecSelector f18937l;
    private final DrmSessionManager<FrameworkMediaCrypto> f18938m;
    private final boolean f18939n;
    private final DecoderInputBuffer f18940o;
    private final DecoderInputBuffer f18941p;
    private final FormatHolder f18942q;
    private final List<Long> f18943r;
    private final BufferInfo f18944s;
    private Format f18945t;
    private DrmSession<FrameworkMediaCrypto> f18946u;
    private DrmSession<FrameworkMediaCrypto> f18947v;
    private boolean f18948w;
    private boolean f18949x;
    private boolean f18950y;
    private boolean f18951z;

    public static class DecoderInitializationException extends Exception {
        public final String f4652a;
        public final boolean f4653b;
        public final String f4654c;
        public final String f4655d;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            StringBuilder stringBuilder = new StringBuilder("Decoder init failed: [");
            stringBuilder.append(i);
            stringBuilder.append("], ");
            stringBuilder.append(format);
            super(stringBuilder.toString(), th);
            this.f4652a = format.f4018f;
            this.f4653b = z;
            this.f4654c = null;
            format = i < 0 ? "neg_" : "";
            th = new StringBuilder("com.google.android.exoplayer.MediaCodecTrackRenderer_");
            th.append(format);
            th.append(Math.abs(i));
            this.f4655d = th.toString();
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z, String str) {
            StringBuilder stringBuilder = new StringBuilder("Decoder init failed: ");
            stringBuilder.append(str);
            stringBuilder.append(", ");
            stringBuilder.append(format);
            super(stringBuilder.toString(), th);
            this.f4652a = format.f4018f;
            this.f4653b = z;
            this.f4654c = str;
            z = false;
            if (Util.f5283a >= 21 && (th instanceof CodecException) != null) {
                z = ((CodecException) th).getDiagnosticInfo();
            }
            this.f4655d = z;
        }
    }

    public void mo4257A() {
    }

    public abstract int mo4248a(MediaCodecSelector mediaCodecSelector, Format format) throws DecoderQueryException;

    public void mo4250a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    public abstract void mo4251a(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws DecoderQueryException;

    public void mo4252a(String str, long j, long j2) {
    }

    public abstract boolean mo4253a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException;

    public boolean mo4258a(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean mo4259a(boolean z, Format format, Format format2) {
        return false;
    }

    public final int mo3327m() {
        return 8;
    }

    public void mo3916n() {
    }

    public void mo3917o() {
    }

    public void mo4255x() throws ExoPlaybackException {
    }

    public void mo4261z() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r4.f18921H = r0;
        r0 = -1;
        r4.f18922I = r0;
        r4.f18923J = r0;
        r0 = 0;
        r4.f18932S = r0;
        r4.f18924K = r0;
        r1 = r4.f18943r;
        r1.clear();
        r1 = 0;
        r4.f18919F = r1;
        r4.f18920G = r1;
        r4.f18935i = r1;
        r4.f18925L = r0;
        r4.f18928O = r0;
        r4.f18948w = r0;
        r4.f18949x = r0;
        r4.f18950y = r0;
        r4.f18951z = r0;
        r4.f18914A = r0;
        r4.f18916C = r0;
        r4.f18917D = r0;
        r4.f18918E = r0;
        r4.f18929P = r0;
        r4.f18926M = r0;
        r4.f18927N = r0;
        r0 = r4.f18940o;
        r0.f12800c = r1;
        r0 = r4.f18934h;
        if (r0 == 0) goto L_0x0096;
    L_0x003f:
        r0 = r4.f18936j;
        r2 = r0.f4234b;
        r2 = r2 + 1;
        r0.f4234b = r2;
        r0 = r4.f18934h;	 Catch:{ all -> 0x0071, all -> 0x0086 }
        r0.stop();	 Catch:{ all -> 0x0071, all -> 0x0086 }
        r0 = r4.f18934h;	 Catch:{ all -> 0x0061 }
        r0.release();	 Catch:{ all -> 0x0061 }
        r4.f18934h = r1;
        r0 = r4.f18946u;
        if (r0 == 0) goto L_0x0060;
    L_0x0057:
        r0 = r4.f18947v;
        r2 = r4.f18946u;
        if (r0 == r2) goto L_0x0060;
    L_0x005d:
        r4.f18946u = r1;
        return;
    L_0x0060:
        return;
    L_0x0061:
        r0 = move-exception;
        r4.f18934h = r1;
        r2 = r4.f18946u;
        if (r2 == 0) goto L_0x0070;
    L_0x0068:
        r2 = r4.f18947v;
        r3 = r4.f18946u;
        if (r2 == r3) goto L_0x0070;
    L_0x006e:
        r4.f18946u = r1;
    L_0x0070:
        throw r0;
    L_0x0071:
        r0 = move-exception;
        r2 = r4.f18934h;	 Catch:{ all -> 0x0071, all -> 0x0086 }
        r2.release();	 Catch:{ all -> 0x0071, all -> 0x0086 }
        r4.f18934h = r1;
        r2 = r4.f18946u;
        if (r2 == 0) goto L_0x0085;
    L_0x007d:
        r2 = r4.f18947v;
        r3 = r4.f18946u;
        if (r2 == r3) goto L_0x0085;
    L_0x0083:
        r4.f18946u = r1;
    L_0x0085:
        throw r0;
    L_0x0086:
        r0 = move-exception;
        r4.f18934h = r1;
        r2 = r4.f18946u;
        if (r2 == 0) goto L_0x0095;
    L_0x008d:
        r2 = r4.f18947v;
        r3 = r4.f18946u;
        if (r2 == r3) goto L_0x0095;
    L_0x0093:
        r4.f18946u = r1;
    L_0x0095:
        throw r0;
    L_0x0096:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.z():void");
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z) {
        super(i);
        Assertions.m4186b(Util.f5283a >= 16 ? 1 : 0);
        this.f18937l = (MediaCodecSelector) Assertions.m4182a((Object) mediaCodecSelector);
        this.f18938m = drmSessionManager;
        this.f18939n = z;
        this.f18940o = new DecoderInputBuffer(0);
        this.f18941p = DecoderInputBuffer.m11971e();
        this.f18942q = new FormatHolder();
        this.f18943r = new ArrayList();
        this.f18944s = new BufferInfo();
        this.f18926M = 0;
        this.f18927N = 0;
    }

    public final int mo3912a(Format format) throws ExoPlaybackException {
        try {
            int a = mo4248a(this.f18937l, format);
            if ((a & 7) <= 2) {
                return a;
            }
            DrmSessionManager drmSessionManager = this.f18938m;
            format = format.f4021i == null ? true : drmSessionManager == null ? null : drmSessionManager.m3729a();
            return format == null ? (a & -8) | 2 : a;
        } catch (Format format2) {
            throw ExoPlaybackException.m3542a(format2, this.f16763b);
        }
    }

    public MediaCodecInfo mo4249a(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws DecoderQueryException {
        return mediaCodecSelector.mo1389a(format.f4018f, z);
    }

    protected final void m20036y() throws ExoPlaybackException {
        if (this.f18934h == null) {
            if (this.f18945t != null) {
                MediaCrypto mediaCrypto;
                boolean z;
                StringBuilder stringBuilder;
                boolean z2;
                Format format;
                long elapsedRealtime;
                StringBuilder stringBuilder2;
                long elapsedRealtime2;
                DecoderCounters decoderCounters;
                this.f18946u = this.f18947v;
                String str = this.f18945t.f4018f;
                boolean z3 = false;
                if (this.f18946u != null) {
                    FrameworkMediaCrypto frameworkMediaCrypto = (FrameworkMediaCrypto) this.f18946u.m3728c();
                    if (frameworkMediaCrypto == null) {
                        Exception b = this.f18946u.m3727b();
                        if (b != null) {
                            throw ExoPlaybackException.m3542a(b, this.f16763b);
                        }
                        return;
                    }
                    mediaCrypto = frameworkMediaCrypto.f12818a;
                    if (!frameworkMediaCrypto.f12819b && frameworkMediaCrypto.f12818a.requiresSecureDecoderComponent(str)) {
                        z = true;
                        if (this.f18935i == null) {
                            try {
                                this.f18935i = mo4249a(this.f18937l, this.f18945t, z);
                                if (this.f18935i == null && z) {
                                    this.f18935i = mo4249a(this.f18937l, this.f18945t, false);
                                    if (this.f18935i != null) {
                                        stringBuilder = new StringBuilder("Drm session requires secure decoder for ");
                                        stringBuilder.append(str);
                                        stringBuilder.append(", but no secure decoder available. Trying to proceed with ");
                                        stringBuilder.append(this.f18935i.f4646a);
                                        stringBuilder.append(".");
                                        Log.w("MediaCodecRenderer", stringBuilder.toString());
                                    }
                                }
                            } catch (Throwable e) {
                                m20011a(new DecoderInitializationException(this.f18945t, e, z, -49998));
                            }
                            if (this.f18935i == null) {
                                m20011a(new DecoderInitializationException(this.f18945t, null, z, -49999));
                            }
                        }
                        if (!mo4258a(this.f18935i)) {
                            str = this.f18935i.f4646a;
                            z2 = Util.f5283a >= 21 && this.f18945t.f4020h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
                            this.f18948w = z2;
                            if (Util.f5283a >= 18 && !(Util.f5283a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str)))) {
                                if (Util.f5283a == 19 && Util.f5286d.startsWith("SM-G800")) {
                                    if (!"OMX.Exynos.avc.dec".equals(str)) {
                                        if ("OMX.Exynos.avc.dec.secure".equals(str)) {
                                        }
                                    }
                                }
                                z2 = false;
                                this.f18949x = z2;
                                z2 = Util.f5283a >= 24 && (("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(Util.f5284b) || "flounder_lte".equals(Util.f5284b) || "grouper".equals(Util.f5284b) || "tilapia".equals(Util.f5284b)));
                                this.f18950y = z2;
                                z2 = Util.f5283a > 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
                                this.f18951z = z2;
                                z2 = (Util.f5283a > 23 && "OMX.google.vorbis.decoder".equals(str)) || (Util.f5283a <= 19 && "hb2000".equals(Util.f5284b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
                                this.f18914A = z2;
                                z2 = Util.f5283a != 21 && "OMX.google.aac.decoder".equals(str);
                                this.f18915B = z2;
                                format = this.f18945t;
                                if (Util.f5283a <= 18 && format.f4030r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                                    z3 = true;
                                }
                                this.f18916C = z3;
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                stringBuilder2 = new StringBuilder("createCodec:");
                                stringBuilder2.append(str);
                                TraceUtil.m4290a(stringBuilder2.toString());
                                this.f18934h = MediaCodec.createByCodecName(str);
                                TraceUtil.m4289a();
                                TraceUtil.m4290a("configureCodec");
                                mo4251a(this.f18935i, this.f18934h, this.f18945t, mediaCrypto);
                                TraceUtil.m4289a();
                                TraceUtil.m4290a("startCodec");
                                this.f18934h.start();
                                TraceUtil.m4289a();
                                elapsedRealtime2 = SystemClock.elapsedRealtime();
                                mo4252a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                                this.f18919F = this.f18934h.getInputBuffers();
                                this.f18920G = this.f18934h.getOutputBuffers();
                                this.f18921H = this.f16764c != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                                this.f18922I = -1;
                                this.f18923J = -1;
                                this.f18933T = true;
                                decoderCounters = this.f18936j;
                                decoderCounters.f4233a++;
                            }
                            z2 = true;
                            this.f18949x = z2;
                            if (Util.f5283a >= 24) {
                            }
                            this.f18950y = z2;
                            if (Util.f5283a > 17) {
                            }
                            this.f18951z = z2;
                            if (Util.f5283a > 23) {
                            }
                            this.f18914A = z2;
                            if (Util.f5283a != 21) {
                            }
                            this.f18915B = z2;
                            format = this.f18945t;
                            z3 = true;
                            this.f18916C = z3;
                            try {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                stringBuilder2 = new StringBuilder("createCodec:");
                                stringBuilder2.append(str);
                                TraceUtil.m4290a(stringBuilder2.toString());
                                this.f18934h = MediaCodec.createByCodecName(str);
                                TraceUtil.m4289a();
                                TraceUtil.m4290a("configureCodec");
                                mo4251a(this.f18935i, this.f18934h, this.f18945t, mediaCrypto);
                                TraceUtil.m4289a();
                                TraceUtil.m4290a("startCodec");
                                this.f18934h.start();
                                TraceUtil.m4289a();
                                elapsedRealtime2 = SystemClock.elapsedRealtime();
                                mo4252a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                                this.f18919F = this.f18934h.getInputBuffers();
                                this.f18920G = this.f18934h.getOutputBuffers();
                            } catch (Throwable e2) {
                                m20011a(new DecoderInitializationException(this.f18945t, e2, z, str));
                            }
                            if (this.f16764c != 2) {
                            }
                            this.f18921H = this.f16764c != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                            this.f18922I = -1;
                            this.f18923J = -1;
                            this.f18933T = true;
                            decoderCounters = this.f18936j;
                            decoderCounters.f4233a++;
                        }
                    }
                }
                mediaCrypto = null;
                z = false;
                if (this.f18935i == null) {
                    this.f18935i = mo4249a(this.f18937l, this.f18945t, z);
                    this.f18935i = mo4249a(this.f18937l, this.f18945t, false);
                    if (this.f18935i != null) {
                        stringBuilder = new StringBuilder("Drm session requires secure decoder for ");
                        stringBuilder.append(str);
                        stringBuilder.append(", but no secure decoder available. Trying to proceed with ");
                        stringBuilder.append(this.f18935i.f4646a);
                        stringBuilder.append(".");
                        Log.w("MediaCodecRenderer", stringBuilder.toString());
                    }
                    if (this.f18935i == null) {
                        m20011a(new DecoderInitializationException(this.f18945t, null, z, -49999));
                    }
                }
                if (!mo4258a(this.f18935i)) {
                    str = this.f18935i.f4646a;
                    if (Util.f5283a >= 21) {
                    }
                    this.f18948w = z2;
                    if ("OMX.Exynos.avc.dec".equals(str)) {
                        if ("OMX.Exynos.avc.dec.secure".equals(str)) {
                        }
                        z2 = false;
                        this.f18949x = z2;
                        if (Util.f5283a >= 24) {
                        }
                        this.f18950y = z2;
                        if (Util.f5283a > 17) {
                        }
                        this.f18951z = z2;
                        if (Util.f5283a > 23) {
                        }
                        this.f18914A = z2;
                        if (Util.f5283a != 21) {
                        }
                        this.f18915B = z2;
                        format = this.f18945t;
                        z3 = true;
                        this.f18916C = z3;
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        stringBuilder2 = new StringBuilder("createCodec:");
                        stringBuilder2.append(str);
                        TraceUtil.m4290a(stringBuilder2.toString());
                        this.f18934h = MediaCodec.createByCodecName(str);
                        TraceUtil.m4289a();
                        TraceUtil.m4290a("configureCodec");
                        mo4251a(this.f18935i, this.f18934h, this.f18945t, mediaCrypto);
                        TraceUtil.m4289a();
                        TraceUtil.m4290a("startCodec");
                        this.f18934h.start();
                        TraceUtil.m4289a();
                        elapsedRealtime2 = SystemClock.elapsedRealtime();
                        mo4252a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.f18919F = this.f18934h.getInputBuffers();
                        this.f18920G = this.f18934h.getOutputBuffers();
                        if (this.f16764c != 2) {
                        }
                        this.f18921H = this.f16764c != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                        this.f18922I = -1;
                        this.f18923J = -1;
                        this.f18933T = true;
                        decoderCounters = this.f18936j;
                        decoderCounters.f4233a++;
                    }
                    z2 = true;
                    this.f18949x = z2;
                    if (Util.f5283a >= 24) {
                    }
                    this.f18950y = z2;
                    if (Util.f5283a > 17) {
                    }
                    this.f18951z = z2;
                    if (Util.f5283a > 23) {
                    }
                    this.f18914A = z2;
                    if (Util.f5283a != 21) {
                    }
                    this.f18915B = z2;
                    format = this.f18945t;
                    z3 = true;
                    this.f18916C = z3;
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    stringBuilder2 = new StringBuilder("createCodec:");
                    stringBuilder2.append(str);
                    TraceUtil.m4290a(stringBuilder2.toString());
                    this.f18934h = MediaCodec.createByCodecName(str);
                    TraceUtil.m4289a();
                    TraceUtil.m4290a("configureCodec");
                    mo4251a(this.f18935i, this.f18934h, this.f18945t, mediaCrypto);
                    TraceUtil.m4289a();
                    TraceUtil.m4290a("startCodec");
                    this.f18934h.start();
                    TraceUtil.m4289a();
                    elapsedRealtime2 = SystemClock.elapsedRealtime();
                    mo4252a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.f18919F = this.f18934h.getInputBuffers();
                    this.f18920G = this.f18934h.getOutputBuffers();
                    if (this.f16764c != 2) {
                    }
                    this.f18921H = this.f16764c != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.f18922I = -1;
                    this.f18923J = -1;
                    this.f18933T = true;
                    decoderCounters = this.f18936j;
                    decoderCounters.f4233a++;
                }
            }
        }
    }

    public void mo3915a(boolean z) throws ExoPlaybackException {
        this.f18936j = new DecoderCounters();
    }

    public void mo3914a(long j, boolean z) throws ExoPlaybackException {
        this.f18930Q = false;
        this.f18931R = false;
        if (this.f18934h != null) {
            this.f18921H = -9223372036854775807L;
            this.f18922I = -1;
            this.f18923J = -1;
            this.f18933T = true;
            this.f18932S = false;
            this.f18924K = false;
            this.f18943r.clear();
            this.f18917D = false;
            this.f18918E = false;
            if (!this.f18949x) {
                if (!this.f18914A || !this.f18929P) {
                    if (this.f18927N) {
                        mo4261z();
                        m20036y();
                    } else {
                        this.f18934h.flush();
                        this.f18928O = false;
                    }
                    if (this.f18925L != null && this.f18945t != null) {
                        this.f18926M = 1;
                        return;
                    }
                }
            }
            mo4261z();
            m20036y();
            if (this.f18925L != null) {
            }
        }
    }

    public void mo3918p() {
        this.f18945t = null;
        try {
            mo4261z();
        } finally {
            this.f18946u = null;
            this.f18947v = null;
        }
    }

    public final void mo3913a(long j, long j2) throws ExoPlaybackException {
        if (this.f18931R) {
            mo4255x();
            return;
        }
        if (this.f18945t == null) {
            this.f18941p.mo1321a();
            int a = m17066a(this.f18942q, this.f18941p, true);
            if (a == -5) {
                mo4254b(this.f18942q.f4039a);
            } else if (a == -4) {
                Assertions.m4186b(this.f18941p.m3715c());
                this.f18930Q = true;
                m20014t();
                return;
            } else {
                return;
            }
        }
        m20036y();
        if (this.f18934h != null) {
            TraceUtil.m4290a("drainAndFeed");
            do {
            } while (m20012b(j, j2));
            do {
            } while (mo4260s() != null);
            TraceUtil.m4289a();
        } else {
            this.f16765d.mo1398a(j - this.f16766e);
            this.f18941p.mo1321a();
            j = m17066a((FormatHolder) this.f18942q, this.f18941p, (boolean) 0);
            if (j == -5) {
                mo4254b(this.f18942q.f4039a);
            } else if (j == -4) {
                Assertions.m4186b(this.f18941p.m3715c());
                this.f18930Q = true;
                m20014t();
            }
        }
        this.f18936j.m3723a();
    }

    private boolean mo4260s() throws ExoPlaybackException {
        if (!(this.f18934h == null || this.f18927N == 2)) {
            if (!this.f18930Q) {
                if (this.f18922I < 0) {
                    this.f18922I = this.f18934h.dequeueInputBuffer(0);
                    if (this.f18922I < 0) {
                        return false;
                    }
                    this.f18940o.f12800c = this.f18919F[this.f18922I];
                    this.f18940o.mo1321a();
                }
                if (this.f18927N == 1) {
                    if (!this.f18951z) {
                        this.f18929P = true;
                        this.f18934h.queueInputBuffer(this.f18922I, 0, 0, 0, 4);
                        this.f18922I = -1;
                    }
                    this.f18927N = 2;
                    return false;
                } else if (this.f18917D) {
                    this.f18917D = false;
                    this.f18940o.f12800c.put(f18913k);
                    this.f18934h.queueInputBuffer(this.f18922I, 0, f18913k.length, 0, 0);
                    this.f18922I = -1;
                    this.f18928O = true;
                    return true;
                } else {
                    int i;
                    int i2;
                    if (this.f18932S) {
                        i = -4;
                        i2 = 0;
                    } else {
                        if (this.f18926M == 1) {
                            for (i = 0; i < this.f18945t.f4020h.size(); i++) {
                                this.f18940o.f12800c.put((byte[]) this.f18945t.f4020h.get(i));
                            }
                            this.f18926M = 2;
                        }
                        i = this.f18940o.f12800c.position();
                        i2 = i;
                        i = m17066a(this.f18942q, this.f18940o, false);
                    }
                    if (i == -3) {
                        return false;
                    }
                    if (i == -5) {
                        if (this.f18926M == 2) {
                            this.f18940o.mo1321a();
                            this.f18926M = 1;
                        }
                        mo4254b(this.f18942q.f4039a);
                        return true;
                    } else if (this.f18940o.m3715c()) {
                        if (this.f18926M == 2) {
                            this.f18940o.mo1321a();
                            this.f18926M = 1;
                        }
                        this.f18930Q = true;
                        if (this.f18928O) {
                            try {
                                if (!this.f18951z) {
                                    this.f18929P = true;
                                    this.f18934h.queueInputBuffer(this.f18922I, 0, 0, 0, 4);
                                    this.f18922I = -1;
                                }
                                return false;
                            } catch (Exception e) {
                                throw ExoPlaybackException.m3542a(e, this.f16763b);
                            }
                        }
                        m20014t();
                        return false;
                    } else if (!this.f18933T || this.f18940o.m3716d()) {
                        boolean z;
                        long j;
                        CryptoInfo cryptoInfo;
                        int[] iArr;
                        DecoderCounters decoderCounters;
                        this.f18933T = false;
                        boolean f = this.f18940o.m11974f();
                        if (this.f18946u != null) {
                            if (f || !this.f18939n) {
                                int a = this.f18946u.m3726a();
                                if (a == 1) {
                                    throw ExoPlaybackException.m3542a(this.f18946u.m3727b(), this.f16763b);
                                } else if (a != 4) {
                                    z = true;
                                    this.f18932S = z;
                                    if (this.f18932S) {
                                        return false;
                                    }
                                    if (this.f18948w && !f) {
                                        NalUnitUtil.m4224a(this.f18940o.f12800c);
                                        if (this.f18940o.f12800c.position() == 0) {
                                            return true;
                                        }
                                        this.f18948w = false;
                                    }
                                    try {
                                        j = this.f18940o.f12801d;
                                        if (this.f18940o.c_()) {
                                            this.f18943r.add(Long.valueOf(j));
                                        }
                                        this.f18940o.m11975g();
                                        mo4257A();
                                        if (f) {
                                            this.f18934h.queueInputBuffer(this.f18922I, 0, this.f18940o.f12800c.limit(), j, 0);
                                        } else {
                                            cryptoInfo = this.f18940o.f12799b.f4231i;
                                            if (i2 == 0) {
                                                if (cryptoInfo.numBytesOfClearData == null) {
                                                    cryptoInfo.numBytesOfClearData = new int[1];
                                                }
                                                iArr = cryptoInfo.numBytesOfClearData;
                                                iArr[0] = iArr[0] + i2;
                                            }
                                            this.f18934h.queueSecureInputBuffer(this.f18922I, 0, cryptoInfo, j, 0);
                                        }
                                        this.f18922I = -1;
                                        this.f18928O = true;
                                        this.f18926M = 0;
                                        decoderCounters = this.f18936j;
                                        decoderCounters.f4235c++;
                                        return true;
                                    } catch (Exception e2) {
                                        throw ExoPlaybackException.m3542a(e2, this.f16763b);
                                    }
                                }
                            }
                        }
                        z = false;
                        this.f18932S = z;
                        if (this.f18932S) {
                            return false;
                        }
                        NalUnitUtil.m4224a(this.f18940o.f12800c);
                        if (this.f18940o.f12800c.position() == 0) {
                            return true;
                        }
                        this.f18948w = false;
                        j = this.f18940o.f12801d;
                        if (this.f18940o.c_()) {
                            this.f18943r.add(Long.valueOf(j));
                        }
                        this.f18940o.m11975g();
                        mo4257A();
                        if (f) {
                            this.f18934h.queueInputBuffer(this.f18922I, 0, this.f18940o.f12800c.limit(), j, 0);
                        } else {
                            cryptoInfo = this.f18940o.f12799b.f4231i;
                            if (i2 == 0) {
                                if (cryptoInfo.numBytesOfClearData == null) {
                                    cryptoInfo.numBytesOfClearData = new int[1];
                                }
                                iArr = cryptoInfo.numBytesOfClearData;
                                iArr[0] = iArr[0] + i2;
                            }
                            this.f18934h.queueSecureInputBuffer(this.f18922I, 0, cryptoInfo, j, 0);
                        }
                        this.f18922I = -1;
                        this.f18928O = true;
                        this.f18926M = 0;
                        decoderCounters = this.f18936j;
                        decoderCounters.f4235c++;
                        return true;
                    } else {
                        this.f18940o.mo1321a();
                        if (this.f18926M == 2) {
                            this.f18926M = 1;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mo4254b(Format format) throws ExoPlaybackException {
        Format format2 = this.f18945t;
        this.f18945t = format;
        boolean z = true;
        if ((Util.m4313a(this.f18945t.f4021i, format2 == null ? null : format2.f4021i) ^ 1) != null) {
            if (this.f18945t.f4021i == null) {
                this.f18947v = null;
            } else if (this.f18938m == null) {
                throw ExoPlaybackException.m3542a(new IllegalStateException("Media requires a DrmSessionManager"), this.f16763b);
            } else {
                format = this.f18938m;
                Looper.myLooper();
                DrmInitData drmInitData = this.f18945t.f4021i;
                this.f18947v = format.m3730b();
                format = this.f18947v;
                DrmSession drmSession = this.f18946u;
            }
        }
        if (this.f18947v == this.f18946u && this.f18934h != null && mo4259a(this.f18935i.f4647b, format2, this.f18945t) != null) {
            this.f18925L = true;
            this.f18926M = 1;
            if (this.f18950y == null || this.f18945t.f4022j != format2.f4022j || this.f18945t.f4023k != format2.f4023k) {
                z = false;
            }
            this.f18917D = z;
        } else if (this.f18928O != null) {
            this.f18927N = 1;
        } else {
            mo4261z();
            m20036y();
        }
    }

    public boolean mo3920r() {
        return this.f18931R;
    }

    public boolean mo3919q() {
        if (!(this.f18945t == null || this.f18932S)) {
            if ((this.f16767f ? this.f16768g : this.f16765d.mo1399a()) || this.f18923J >= 0 || (this.f18921H != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f18921H)) {
                return true;
            }
        }
        return false;
    }

    private boolean m20012b(long r17, long r19) throws com.google.android.exoplayer2.ExoPlaybackException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r16 = this;
        r12 = r16;
        r0 = r12.f18923J;
        r13 = -1;
        r14 = 1;
        r15 = 0;
        if (r0 >= 0) goto L_0x00ed;
    L_0x0009:
        r0 = r12.f18915B;
        r1 = 0;
        if (r0 == 0) goto L_0x0029;
    L_0x000f:
        r0 = r12.f18929P;
        if (r0 == 0) goto L_0x0029;
    L_0x0013:
        r0 = r12.f18934h;	 Catch:{ IllegalStateException -> 0x001e }
        r3 = r12.f18944s;	 Catch:{ IllegalStateException -> 0x001e }
        r0 = r0.dequeueOutputBuffer(r3, r1);	 Catch:{ IllegalStateException -> 0x001e }
        r12.f18923J = r0;	 Catch:{ IllegalStateException -> 0x001e }
        goto L_0x0033;
    L_0x001e:
        r16.m20014t();
        r0 = r12.f18931R;
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r16.mo4261z();
    L_0x0028:
        return r15;
    L_0x0029:
        r0 = r12.f18934h;
        r3 = r12.f18944s;
        r0 = r0.dequeueOutputBuffer(r3, r1);
        r12.f18923J = r0;
    L_0x0033:
        r0 = r12.f18923J;
        if (r0 < 0) goto L_0x009b;
    L_0x0037:
        r0 = r12.f18918E;
        if (r0 == 0) goto L_0x0047;
    L_0x003b:
        r12.f18918E = r15;
        r0 = r12.f18934h;
        r1 = r12.f18923J;
        r0.releaseOutputBuffer(r1, r15);
        r12.f18923J = r13;
        return r14;
    L_0x0047:
        r0 = r12.f18944s;
        r0 = r0.flags;
        r0 = r0 & 4;
        if (r0 == 0) goto L_0x0055;
    L_0x004f:
        r16.m20014t();
        r12.f18923J = r13;
        return r15;
    L_0x0055:
        r0 = r12.f18920G;
        r1 = r12.f18923J;
        r0 = r0[r1];
        if (r0 == 0) goto L_0x0070;
    L_0x005d:
        r1 = r12.f18944s;
        r1 = r1.offset;
        r0.position(r1);
        r1 = r12.f18944s;
        r1 = r1.offset;
        r2 = r12.f18944s;
        r2 = r2.size;
        r1 = r1 + r2;
        r0.limit(r1);
    L_0x0070:
        r0 = r12.f18944s;
        r0 = r0.presentationTimeUs;
        r2 = r12.f18943r;
        r2 = r2.size();
        r3 = r15;
    L_0x007b:
        if (r3 >= r2) goto L_0x0097;
    L_0x007d:
        r4 = r12.f18943r;
        r4 = r4.get(r3);
        r4 = (java.lang.Long) r4;
        r4 = r4.longValue();
        r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r4 != 0) goto L_0x0094;
    L_0x008d:
        r0 = r12.f18943r;
        r0.remove(r3);
        r0 = r14;
        goto L_0x0098;
    L_0x0094:
        r3 = r3 + 1;
        goto L_0x007b;
    L_0x0097:
        r0 = r15;
    L_0x0098:
        r12.f18924K = r0;
        goto L_0x00ed;
    L_0x009b:
        r0 = r12.f18923J;
        r1 = -2;
        if (r0 != r1) goto L_0x00ce;
    L_0x00a0:
        r0 = r12.f18934h;
        r0 = r0.getOutputFormat();
        r1 = r12.f18950y;
        if (r1 == 0) goto L_0x00bf;
    L_0x00aa:
        r1 = "width";
        r1 = r0.getInteger(r1);
        r2 = 32;
        if (r1 != r2) goto L_0x00bf;
    L_0x00b4:
        r1 = "height";
        r1 = r0.getInteger(r1);
        if (r1 != r2) goto L_0x00bf;
    L_0x00bc:
        r12.f18918E = r14;
        goto L_0x00cd;
    L_0x00bf:
        r1 = r12.f18916C;
        if (r1 == 0) goto L_0x00c8;
    L_0x00c3:
        r1 = "channel-count";
        r0.setInteger(r1, r14);
    L_0x00c8:
        r1 = r12.f18934h;
        r12.mo4250a(r1, r0);
    L_0x00cd:
        return r14;
    L_0x00ce:
        r0 = r12.f18923J;
        r1 = -3;
        if (r0 != r1) goto L_0x00dc;
    L_0x00d3:
        r0 = r12.f18934h;
        r0 = r0.getOutputBuffers();
        r12.f18920G = r0;
        return r14;
    L_0x00dc:
        r0 = r12.f18951z;
        if (r0 == 0) goto L_0x00ec;
    L_0x00e0:
        r0 = r12.f18930Q;
        if (r0 != 0) goto L_0x00e9;
    L_0x00e4:
        r0 = r12.f18927N;
        r1 = 2;
        if (r0 != r1) goto L_0x00ec;
    L_0x00e9:
        r16.m20014t();
    L_0x00ec:
        return r15;
    L_0x00ed:
        r0 = r12.f18915B;
        if (r0 == 0) goto L_0x011e;
    L_0x00f1:
        r0 = r12.f18929P;
        if (r0 == 0) goto L_0x011e;
    L_0x00f5:
        r5 = r12.f18934h;	 Catch:{ IllegalStateException -> 0x0113 }
        r0 = r12.f18920G;	 Catch:{ IllegalStateException -> 0x0113 }
        r1 = r12.f18923J;	 Catch:{ IllegalStateException -> 0x0113 }
        r6 = r0[r1];	 Catch:{ IllegalStateException -> 0x0113 }
        r7 = r12.f18923J;	 Catch:{ IllegalStateException -> 0x0113 }
        r0 = r12.f18944s;	 Catch:{ IllegalStateException -> 0x0113 }
        r8 = r0.flags;	 Catch:{ IllegalStateException -> 0x0113 }
        r0 = r12.f18944s;	 Catch:{ IllegalStateException -> 0x0113 }
        r9 = r0.presentationTimeUs;	 Catch:{ IllegalStateException -> 0x0113 }
        r11 = r12.f18924K;	 Catch:{ IllegalStateException -> 0x0113 }
        r0 = r12;	 Catch:{ IllegalStateException -> 0x0113 }
        r1 = r17;	 Catch:{ IllegalStateException -> 0x0113 }
        r3 = r19;	 Catch:{ IllegalStateException -> 0x0113 }
        r0 = r0.mo4253a(r1, r3, r5, r6, r7, r8, r9, r11);	 Catch:{ IllegalStateException -> 0x0113 }
        goto L_0x013b;
    L_0x0113:
        r16.m20014t();
        r0 = r12.f18931R;
        if (r0 == 0) goto L_0x011d;
    L_0x011a:
        r16.mo4261z();
    L_0x011d:
        return r15;
    L_0x011e:
        r5 = r12.f18934h;
        r0 = r12.f18920G;
        r1 = r12.f18923J;
        r6 = r0[r1];
        r7 = r12.f18923J;
        r0 = r12.f18944s;
        r8 = r0.flags;
        r0 = r12.f18944s;
        r9 = r0.presentationTimeUs;
        r11 = r12.f18924K;
        r0 = r12;
        r1 = r17;
        r3 = r19;
        r0 = r0.mo4253a(r1, r3, r5, r6, r7, r8, r9, r11);
    L_0x013b:
        if (r0 == 0) goto L_0x0144;
    L_0x013d:
        r0 = r12.f18944s;
        r0 = r0.presentationTimeUs;
        r12.f18923J = r13;
        return r14;
    L_0x0144:
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.b(long, long):boolean");
    }

    private void m20014t() throws ExoPlaybackException {
        if (this.f18927N == 2) {
            mo4261z();
            m20036y();
            return;
        }
        this.f18931R = true;
        mo4255x();
    }

    private void m20011a(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        throw ExoPlaybackException.m3542a(decoderInitializationException, this.f16763b);
    }
}
