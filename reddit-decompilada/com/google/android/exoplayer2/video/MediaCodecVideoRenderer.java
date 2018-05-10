package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.C04291;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.C04302;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.C04313;
import com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.C04324;
import org.jcodec.containers.mps.MPSUtils;

@TargetApi(16)
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int[] f19510l = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, MPSUtils.VIDEO_MIN};
    private long f19511A;
    private long f19512B;
    private int f19513C;
    private int f19514D;
    private int f19515E;
    private float f19516F;
    private int f19517G;
    private int f19518H;
    private int f19519I;
    private float f19520J;
    private int f19521K;
    private int f19522L;
    private int f19523M;
    private float f19524N;
    private boolean f19525O;
    private int f19526P;
    private long f19527Q;
    private int f19528R;
    OnFrameRenderedListenerV23 f19529k;
    private final Context f19530m;
    private final VideoFrameReleaseTimeHelper f19531n;
    private final EventDispatcher f19532o;
    private final long f19533p;
    private final int f19534q = 50;
    private final boolean f19535r;
    private final long[] f19536s;
    private Format[] f19537t;
    private CodecMaxValues f19538u;
    private boolean f19539v;
    private Surface f19540w;
    private Surface f19541x;
    private int f19542y;
    private boolean f19543z;

    protected static final class CodecMaxValues {
        public final int f5318a;
        public final int f5319b;
        public final int f5320c;

        public CodecMaxValues(int i, int i2, int i3) {
            this.f5318a = i;
            this.f5319b = i2;
            this.f5320c = i3;
        }
    }

    @TargetApi(23)
    private final class OnFrameRenderedListenerV23 implements OnFrameRenderedListener {
        final /* synthetic */ MediaCodecVideoRenderer f5321a;

        private OnFrameRenderedListenerV23(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodec mediaCodec) {
            this.f5321a = mediaCodecVideoRenderer;
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == this.f5321a.f19529k) {
                this.f5321a.mo4260s();
            }
        }
    }

    private static boolean m20827b(long j) {
        return j < -30000;
    }

    protected final void mo4261z() {
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
        r0 = 0;
        super.mo4261z();	 Catch:{ all -> 0x0019 }
        r1 = r4.f19541x;
        if (r1 == 0) goto L_0x0018;
    L_0x0008:
        r1 = r4.f19540w;
        r2 = r4.f19541x;
        if (r1 != r2) goto L_0x0010;
    L_0x000e:
        r4.f19540w = r0;
    L_0x0010:
        r1 = r4.f19541x;
        r1.release();
        r4.f19541x = r0;
        return;
    L_0x0018:
        return;
    L_0x0019:
        r1 = move-exception;
        r2 = r4.f19541x;
        if (r2 == 0) goto L_0x002d;
    L_0x001e:
        r2 = r4.f19540w;
        r3 = r4.f19541x;
        if (r2 != r3) goto L_0x0026;
    L_0x0024:
        r4.f19540w = r0;
    L_0x0026:
        r2 = r4.f19541x;
        r2.release();
        r4.f19541x = r0;
    L_0x002d:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.z():void");
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Handler handler, VideoRendererEventListener videoRendererEventListener) {
        boolean z = false;
        super(2, mediaCodecSelector, drmSessionManager, false);
        this.f19533p = j;
        this.f19530m = context.getApplicationContext();
        this.f19531n = new VideoFrameReleaseTimeHelper(context);
        this.f19532o = new EventDispatcher(handler, videoRendererEventListener);
        if (!(Util.f5283a > 22 || "foster".equals(Util.f5284b) == null || "NVIDIA".equals(Util.f5285c) == null)) {
            z = true;
        }
        this.f19535r = z;
        this.f19536s = new long[10];
        this.f19527Q = -9223372036854775807L;
        this.f19511A = -9223372036854775807L;
        this.f19517G = -1;
        this.f19518H = -1;
        this.f19520J = -1.0f;
        this.f19516F = -1.0f;
        this.f19542y = 1;
        m20834v();
    }

    protected final int mo4248a(MediaCodecSelector mediaCodecSelector, Format format) throws DecoderQueryException {
        String str = format.f4018f;
        int i = 0;
        if (!MimeTypes.m4213b(str)) {
            return 0;
        }
        boolean z;
        DrmInitData drmInitData = format.f4021i;
        if (drmInitData != null) {
            int i2 = 0;
            z = i2;
            while (i2 < drmInitData.f4248b) {
                z |= drmInitData.f4247a[i2].f4245e;
                i2++;
            }
        } else {
            z = false;
        }
        mediaCodecSelector = mediaCodecSelector.mo1389a(str, z);
        if (mediaCodecSelector == null) {
            return 1;
        }
        boolean z2;
        String str2 = format.f4015c;
        if (str2 != null) {
            if (mediaCodecSelector.f4650e != null) {
                String f = MimeTypes.m4217f(str2);
                if (f != null) {
                    StringBuilder stringBuilder;
                    if (mediaCodecSelector.f4650e.equals(f)) {
                        Pair a = MediaCodecUtil.m3898a(str2);
                        if (a != null) {
                            CodecProfileLevel[] a2 = mediaCodecSelector.m3890a();
                            int length = a2.length;
                            int i3 = 0;
                            while (i3 < length) {
                                CodecProfileLevel codecProfileLevel = a2[i3];
                                if (codecProfileLevel.profile != ((Integer) a.first).intValue() || codecProfileLevel.level < ((Integer) a.second).intValue()) {
                                    i3++;
                                }
                            }
                            stringBuilder = new StringBuilder("codec.profileLevel, ");
                            stringBuilder.append(str2);
                            stringBuilder.append(", ");
                            stringBuilder.append(f);
                            mediaCodecSelector.m3891b(stringBuilder.toString());
                        }
                    } else {
                        stringBuilder = new StringBuilder("codec.mime ");
                        stringBuilder.append(str2);
                        stringBuilder.append(", ");
                        stringBuilder.append(f);
                        mediaCodecSelector.m3891b(stringBuilder.toString());
                    }
                    z2 = false;
                    if (z2 && format.f4022j > 0 && format.f4023k > 0) {
                        if (Util.f5283a < 21) {
                            z2 = mediaCodecSelector.m3889a(format.f4022j, format.f4023k, (double) format.f4024l);
                        } else {
                            z2 = format.f4022j * format.f4023k > MediaCodecUtil.m3904b();
                            if (!z2) {
                                StringBuilder stringBuilder2 = new StringBuilder("FalseCheck [legacyFrameSize, ");
                                stringBuilder2.append(format.f4022j);
                                stringBuilder2.append("x");
                                stringBuilder2.append(format.f4023k);
                                stringBuilder2.append("] [");
                                stringBuilder2.append(Util.f5287e);
                                stringBuilder2.append("]");
                                Log.d("MediaCodecVideoRenderer", stringBuilder2.toString());
                            }
                        }
                    }
                    format = mediaCodecSelector.f4647b == null ? 16 : 8;
                    if (mediaCodecSelector.f4648c != null) {
                        i = 32;
                    }
                    return (z2 ? 4 : 3) | (format | i);
                }
            }
        }
        z2 = true;
        if (Util.f5283a < 21) {
            if (format.f4022j * format.f4023k > MediaCodecUtil.m3904b()) {
            }
            if (z2) {
                StringBuilder stringBuilder22 = new StringBuilder("FalseCheck [legacyFrameSize, ");
                stringBuilder22.append(format.f4022j);
                stringBuilder22.append("x");
                stringBuilder22.append(format.f4023k);
                stringBuilder22.append("] [");
                stringBuilder22.append(Util.f5287e);
                stringBuilder22.append("]");
                Log.d("MediaCodecVideoRenderer", stringBuilder22.toString());
            }
        } else {
            z2 = mediaCodecSelector.m3889a(format.f4022j, format.f4023k, (double) format.f4024l);
        }
        if (mediaCodecSelector.f4647b == null) {
        }
        if (mediaCodecSelector.f4648c != null) {
            i = 32;
        }
        if (z2) {
        }
        return (z2 ? 4 : 3) | (format | i);
    }

    protected final void mo3915a(boolean z) throws ExoPlaybackException {
        super.mo3915a(z);
        this.f19526P = this.f16762a.f4059b;
        this.f19525O = this.f19526P;
        z = this.f19532o;
        DecoderCounters decoderCounters = this.j;
        if (z.f5360b != null) {
            z.f5359a.post(new C04291(z, decoderCounters));
        }
        z = this.f19531n;
        z.f5335h = false;
        if (z.f5329b) {
            z.f5328a.f5324b.sendEmptyMessage(1);
        }
    }

    protected final void mo3921a(Format[] formatArr, long j) throws ExoPlaybackException {
        this.f19537t = formatArr;
        if (this.f19527Q == -9223372036854775807L) {
            this.f19527Q = j;
        } else {
            if (this.f19528R == this.f19536s.length) {
                StringBuilder stringBuilder = new StringBuilder("Too many stream changes, so dropping offset: ");
                stringBuilder.append(this.f19536s[this.f19528R - 1]);
                Log.w("MediaCodecVideoRenderer", stringBuilder.toString());
            } else {
                this.f19528R++;
            }
            this.f19536s[this.f19528R - 1] = j;
        }
        super.mo3921a(formatArr, j);
    }

    protected final void mo3914a(long j, boolean z) throws ExoPlaybackException {
        super.mo3914a(j, z);
        m20833u();
        this.f19514D = 0;
        if (this.f19528R != 0) {
            this.f19527Q = this.f19536s[this.f19528R - 1];
            this.f19528R = 0;
        }
        if (z) {
            m20832t();
        } else {
            this.f19511A = -9223372036854775807L;
        }
    }

    public final boolean mo3919q() {
        if (super.mo3919q() && (this.f19543z || ((this.f19541x != null && this.f19540w == this.f19541x) || this.f18934h == null || this.f19525O))) {
            this.f19511A = -9223372036854775807L;
            return true;
        } else if (this.f19511A == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f19511A) {
                return true;
            }
            this.f19511A = -9223372036854775807L;
            return false;
        }
    }

    protected final void mo3916n() {
        super.mo3916n();
        this.f19513C = 0;
        this.f19512B = SystemClock.elapsedRealtime();
    }

    protected final void mo3917o() {
        this.f19511A = -9223372036854775807L;
        m20821C();
        super.mo3917o();
    }

    protected final void mo3918p() {
        this.f19517G = -1;
        this.f19518H = -1;
        this.f19520J = -1.0f;
        this.f19516F = -1.0f;
        this.f19527Q = -9223372036854775807L;
        this.f19528R = 0;
        m20834v();
        m20833u();
        VideoFrameReleaseTimeHelper videoFrameReleaseTimeHelper = this.f19531n;
        if (videoFrameReleaseTimeHelper.f5329b) {
            videoFrameReleaseTimeHelper.f5328a.f5324b.sendEmptyMessage(2);
        }
        this.f19529k = null;
        this.f19525O = false;
        try {
            super.mo3918p();
        } finally {
            this.j.m3723a();
            this.f19532o.m4346a(this.j);
        }
    }

    public final void mo3312a(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.f19541x != 0) {
                    surface = this.f19541x;
                } else {
                    i = this.f18935i;
                    if (i != 0 && m20828b(i.f4649d)) {
                        this.f19541x = DummySurface.m4337a(this.f19530m, i.f4649d);
                        surface = this.f19541x;
                    }
                }
            }
            if (this.f19540w != surface) {
                this.f19540w = surface;
                i = this.f16764c;
                if (i == 1 || i == 2) {
                    MediaCodec mediaCodec = this.f18934h;
                    if (Util.f5283a < 23 || mediaCodec == null || surface == null || this.f19539v) {
                        mo4261z();
                        m20036y();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.f19541x) {
                    m20834v();
                    m20833u();
                } else {
                    m20820B();
                    m20833u();
                    if (i == 2) {
                        m20832t();
                        return;
                    }
                }
                return;
            }
            if (!(surface == null || surface == this.f19541x)) {
                m20820B();
                if (this.f19543z != 0) {
                    this.f19532o.m4345a(this.f19540w);
                }
            }
        } else if (i == 4) {
            this.f19542y = ((Integer) obj).intValue();
            i = this.f18934h;
            if (i != 0) {
                i.setVideoScalingMode(this.f19542y);
            }
        } else {
            super.mo3312a(i, obj);
        }
    }

    protected final boolean mo4258a(MediaCodecInfo mediaCodecInfo) {
        if (this.f19540w == null) {
            if (m20828b(mediaCodecInfo.f4649d) == null) {
                return null;
            }
        }
        return true;
    }

    protected final void mo4251a(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws DecoderQueryException {
        CodecMaxValues codecMaxValues;
        MediaCodecInfo mediaCodecInfo2 = mediaCodecInfo;
        MediaCodec mediaCodec2 = mediaCodec;
        Format format2 = format;
        Format[] formatArr = this.f19537t;
        int i = format2.f4022j;
        int i2 = format2.f4023k;
        int c = m20830c(format);
        if (formatArr.length == 1) {
            codecMaxValues = new CodecMaxValues(i, i2, c);
        } else {
            int length = formatArr.length;
            int i3 = i2;
            int i4 = c;
            i2 = 0;
            c = i;
            for (i = i2; i < length; i++) {
                Format format3 = formatArr[i];
                if (m20829b(mediaCodecInfo2.f4647b, format2, format3)) {
                    int i5;
                    if (format3.f4022j != -1) {
                        if (format3.f4023k != -1) {
                            i5 = 0;
                            i2 |= i5;
                            c = Math.max(c, format3.f4022j);
                            i3 = Math.max(i3, format3.f4023k);
                            i4 = Math.max(i4, m20830c(format3));
                        }
                    }
                    i5 = 1;
                    i2 |= i5;
                    c = Math.max(c, format3.f4022j);
                    i3 = Math.max(i3, format3.f4023k);
                    i4 = Math.max(i4, m20830c(format3));
                }
            }
            if (i2 != 0) {
                StringBuilder stringBuilder = new StringBuilder("Resolutions unknown. Codec max resolution: ");
                stringBuilder.append(c);
                stringBuilder.append("x");
                stringBuilder.append(i3);
                Log.w("MediaCodecVideoRenderer", stringBuilder.toString());
                Point a = m20823a(mediaCodecInfo2, format2);
                if (a != null) {
                    c = Math.max(c, a.x);
                    i3 = Math.max(i3, a.y);
                    i4 = Math.max(i4, m20822a(format2.f4018f, c, i3));
                    stringBuilder = new StringBuilder("Codec max resolution adjusted to: ");
                    stringBuilder.append(c);
                    stringBuilder.append("x");
                    stringBuilder.append(i3);
                    Log.w("MediaCodecVideoRenderer", stringBuilder.toString());
                }
            }
            codecMaxValues = new CodecMaxValues(c, i3, i4);
        }
        r0.f19538u = codecMaxValues;
        codecMaxValues = r0.f19538u;
        boolean z = r0.f19535r;
        i2 = r0.f19526P;
        MediaFormat b = format.m3577b();
        b.setInteger("max-width", codecMaxValues.f5318a);
        b.setInteger("max-height", codecMaxValues.f5319b);
        if (codecMaxValues.f5320c != -1) {
            b.setInteger("max-input-size", codecMaxValues.f5320c);
        }
        if (z) {
            b.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            b.setFeatureEnabled("tunneled-playback", true);
            b.setInteger("audio-session-id", i2);
        }
        if (r0.f19540w == null) {
            Assertions.m4186b(m20828b(mediaCodecInfo2.f4649d));
            if (r0.f19541x == null) {
                r0.f19541x = DummySurface.m4337a(r0.f19530m, mediaCodecInfo2.f4649d);
            }
            r0.f19540w = r0.f19541x;
        }
        mediaCodec2.configure(b, r0.f19540w, mediaCrypto, 0);
        if (Util.f5283a >= 23 && r0.f19525O) {
            r0.f19529k = new OnFrameRenderedListenerV23(mediaCodec2);
        }
    }

    protected final void mo4252a(String str, long j, long j2) {
        EventDispatcher eventDispatcher = this.f19532o;
        if (eventDispatcher.f5360b != null) {
            eventDispatcher.f5359a.post(new C04302(eventDispatcher, str, j, j2));
        }
        str = (("deb".equals(Util.f5284b) == null && "flo".equals(Util.f5284b) == null) || "OMX.qcom.video.decoder.avc".equals(str) == null) ? null : true;
        this.f19539v = str;
    }

    protected final void mo4254b(Format format) throws ExoPlaybackException {
        super.mo4254b(format);
        EventDispatcher eventDispatcher = this.f19532o;
        if (eventDispatcher.f5360b != null) {
            eventDispatcher.f5359a.post(new C04313(eventDispatcher, format));
        }
        this.f19516F = format.f4026n == -1.0f ? 1.0f : format.f4026n;
        this.f19515E = m20831d(format);
    }

    protected final void mo4257A() {
        if (Util.f5283a < 23 && this.f19525O) {
            mo4260s();
        }
    }

    protected final void mo4250a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int i = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : 0;
        if (i != 0) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f19517G = integer;
        if (i != 0) {
            i = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i = mediaFormat.getInteger("height");
        }
        this.f19518H = i;
        this.f19520J = this.f19516F;
        if (Util.f5283a < 21) {
            this.f19519I = this.f19515E;
        } else if (this.f19515E == 90 || this.f19515E == 270) {
            mediaFormat = this.f19517G;
            this.f19517G = this.f19518H;
            this.f19518H = mediaFormat;
            this.f19520J = 1065353216 / this.f19520J;
        }
        mediaCodec.setVideoScalingMode(this.f19542y);
    }

    protected final boolean mo4259a(boolean z, Format format, Format format2) {
        return m20829b(z, format, format2) && format2.f4022j <= this.f19538u.f5318a && format2.f4023k <= this.f19538u.f5319b && m20830c(format2) <= this.f19538u.f5320c;
    }

    protected final boolean mo4253a(long r25, long r27, android.media.MediaCodec r29, java.nio.ByteBuffer r30, int r31, int r32, long r33, boolean r35) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r24 = this;
        r0 = r24;
        r1 = r29;
        r2 = r31;
        r3 = r33;
    L_0x0008:
        r5 = r0.f19528R;
        r6 = 0;
        r7 = 1;
        if (r5 == 0) goto L_0x002b;
    L_0x000e:
        r5 = r0.f19536s;
        r8 = r5[r6];
        r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x002b;
    L_0x0016:
        r5 = r0.f19536s;
        r8 = r5[r6];
        r0.f19527Q = r8;
        r5 = r0.f19528R;
        r5 = r5 - r7;
        r0.f19528R = r5;
        r5 = r0.f19536s;
        r8 = r0.f19536s;
        r9 = r0.f19528R;
        java.lang.System.arraycopy(r5, r7, r8, r6, r9);
        goto L_0x0008;
    L_0x002b:
        if (r35 == 0) goto L_0x0031;
    L_0x002d:
        r0.m20824a(r1, r2);
        return r7;
    L_0x0031:
        r8 = r3 - r25;
        r5 = r0.f19540w;
        r10 = r0.f19541x;
        if (r5 != r10) goto L_0x0044;
    L_0x0039:
        r3 = m20827b(r8);
        if (r3 == 0) goto L_0x0043;
    L_0x003f:
        r0.m20824a(r1, r2);
        return r7;
    L_0x0043:
        return r6;
    L_0x0044:
        r5 = r0.f19543z;
        r10 = 21;
        if (r5 != 0) goto L_0x005a;
    L_0x004a:
        r3 = com.google.android.exoplayer2.util.Util.f5283a;
        if (r3 < r10) goto L_0x0056;
    L_0x004e:
        r3 = java.lang.System.nanoTime();
        r0.m20825a(r1, r2, r3);
        goto L_0x0059;
    L_0x0056:
        r0.m20826b(r1, r2);
    L_0x0059:
        return r7;
    L_0x005a:
        r5 = r0.f16764c;
        r11 = 2;
        if (r5 == r11) goto L_0x0060;
    L_0x005f:
        return r6;
    L_0x0060:
        r11 = android.os.SystemClock.elapsedRealtime();
        r13 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r13;
        r11 = r11 - r27;
        r8 = r8 - r11;
        r11 = java.lang.System.nanoTime();
        r8 = r8 * r13;
        r8 = r8 + r11;
        r5 = r0.f19531n;
        r16 = r11;
        r10 = r3 * r13;
        r12 = r5.f5335h;
        if (r12 == 0) goto L_0x00b9;
    L_0x007a:
        r13 = r5.f5332e;
        r12 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r12 == 0) goto L_0x008b;
    L_0x0080:
        r12 = r5.f5338k;
        r14 = 1;
        r12 = r12 + r14;
        r5.f5338k = r12;
        r12 = r5.f5334g;
        r5.f5333f = r12;
    L_0x008b:
        r12 = r5.f5338k;
        r14 = 6;
        r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r12 < 0) goto L_0x00b0;
    L_0x0093:
        r12 = r5.f5337j;
        r12 = r10 - r12;
        r14 = r5.f5338k;
        r12 = r12 / r14;
        r14 = r5.f5333f;
        r12 = r12 + r14;
        r14 = r5.m4342a(r12, r8);
        if (r14 == 0) goto L_0x00a6;
    L_0x00a3:
        r5.f5335h = r6;
        goto L_0x00b9;
    L_0x00a6:
        r14 = r5.f5336i;
        r14 = r14 + r12;
        r6 = r5.f5337j;
        r6 = r14 - r6;
        r18 = r6;
        goto L_0x00bc;
    L_0x00b0:
        r6 = r5.m4342a(r10, r8);
        if (r6 == 0) goto L_0x00b9;
    L_0x00b6:
        r6 = 0;
        r5.f5335h = r6;
    L_0x00b9:
        r18 = r8;
        r12 = r10;
    L_0x00bc:
        r6 = r5.f5335h;
        r14 = 0;
        if (r6 != 0) goto L_0x00cb;
    L_0x00c2:
        r5.f5337j = r10;
        r5.f5336i = r8;
        r5.f5338k = r14;
        r6 = 1;
        r5.f5335h = r6;
    L_0x00cb:
        r5.f5332e = r3;
        r5.f5334g = r12;
        r3 = r5.f5328a;
        if (r3 == 0) goto L_0x00ee;
    L_0x00d3:
        r3 = r5.f5328a;
        r3 = r3.f5323a;
        r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1));
        if (r3 != 0) goto L_0x00dc;
    L_0x00db:
        goto L_0x00ee;
    L_0x00dc:
        r3 = r5.f5328a;
        r3 = r3.f5323a;
        r6 = r5.f5330c;
        r20 = r3;
        r22 = r6;
        r3 = com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.m4341a(r18, r20, r22);
        r5 = r5.f5331d;
        r18 = r3 - r5;
    L_0x00ee:
        r3 = r18;
        r5 = r3 - r16;
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 / r7;
        r7 = m20827b(r5);
        if (r7 == 0) goto L_0x0132;
    L_0x00fb:
        r3 = "dropVideoBuffer";
        com.google.android.exoplayer2.util.TraceUtil.m4290a(r3);
        r3 = 0;
        r1.releaseOutputBuffer(r2, r3);
        com.google.android.exoplayer2.util.TraceUtil.m4289a();
        r1 = r0.j;
        r2 = r1.f4238f;
        r3 = 1;
        r2 = r2 + r3;
        r1.f4238f = r2;
        r1 = r0.f19513C;
        r1 = r1 + r3;
        r0.f19513C = r1;
        r1 = r0.f19514D;
        r1 = r1 + r3;
        r0.f19514D = r1;
        r1 = r0.j;
        r2 = r0.f19514D;
        r3 = r0.j;
        r3 = r3.f4239g;
        r2 = java.lang.Math.max(r2, r3);
        r1.f4239g = r2;
        r1 = r0.f19513C;
        r2 = r0.f19534q;
        if (r1 != r2) goto L_0x0130;
    L_0x012d:
        r24.m20821C();
    L_0x0130:
        r7 = 1;
        return r7;
    L_0x0132:
        r7 = 1;
        r8 = com.google.android.exoplayer2.util.Util.f5283a;
        r9 = 21;
        if (r8 < r9) goto L_0x0146;
    L_0x0139:
        r8 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));
        if (r5 >= 0) goto L_0x0144;
    L_0x0140:
        r0.m20825a(r1, r2, r3);
        return r7;
    L_0x0144:
        r1 = 0;
        goto L_0x0168;
    L_0x0146:
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x0144;
    L_0x014c:
        r3 = 11000; // 0x2af8 float:1.5414E-41 double:5.4347E-320;
        r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x0163;
    L_0x0152:
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r5 = r5 - r3;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 / r3;	 Catch:{ InterruptedException -> 0x015c }
        java.lang.Thread.sleep(r5);	 Catch:{ InterruptedException -> 0x015c }
        goto L_0x0163;
    L_0x015c:
        r3 = java.lang.Thread.currentThread();
        r3.interrupt();
    L_0x0163:
        r0.m20826b(r1, r2);
        r1 = 1;
        return r1;
    L_0x0168:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    private void m20824a(MediaCodec mediaCodec, int i) {
        TraceUtil.m4290a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.m4289a();
        mediaCodec = this.j;
        mediaCodec.f4237e++;
    }

    private void m20826b(MediaCodec mediaCodec, int i) {
        m20835w();
        TraceUtil.m4290a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.m4289a();
        mediaCodec = this.j;
        mediaCodec.f4236d++;
        this.f19514D = null;
        mo4260s();
    }

    @TargetApi(21)
    private void m20825a(MediaCodec mediaCodec, int i, long j) {
        m20835w();
        TraceUtil.m4290a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        TraceUtil.m4289a();
        mediaCodec = this.j;
        mediaCodec.f4236d++;
        this.f19514D = null;
        mo4260s();
    }

    private boolean m20828b(boolean z) {
        return Util.f5283a >= 23 && !this.f19525O && (!z || DummySurface.m4338a(this.f19530m));
    }

    private void m20832t() {
        this.f19511A = this.f19533p > 0 ? SystemClock.elapsedRealtime() + this.f19533p : -9223372036854775807L;
    }

    private void m20833u() {
        this.f19543z = false;
        if (Util.f5283a >= 23 && this.f19525O) {
            MediaCodec mediaCodec = this.f18934h;
            if (mediaCodec != null) {
                this.f19529k = new OnFrameRenderedListenerV23(mediaCodec);
            }
        }
    }

    final void mo4260s() {
        if (!this.f19543z) {
            this.f19543z = true;
            this.f19532o.m4345a(this.f19540w);
        }
    }

    private void m20834v() {
        this.f19521K = -1;
        this.f19522L = -1;
        this.f19524N = -1.0f;
        this.f19523M = -1;
    }

    private void m20835w() {
        if (this.f19517G != -1 || this.f19518H != -1) {
            if (this.f19521K != this.f19517G || this.f19522L != this.f19518H || this.f19523M != this.f19519I || this.f19524N != this.f19520J) {
                this.f19532o.m4344a(this.f19517G, this.f19518H, this.f19519I, this.f19520J);
                this.f19521K = this.f19517G;
                this.f19522L = this.f19518H;
                this.f19523M = this.f19519I;
                this.f19524N = this.f19520J;
            }
        }
    }

    private void m20820B() {
        if (this.f19521K != -1 || this.f19522L != -1) {
            this.f19532o.m4344a(this.f19521K, this.f19522L, this.f19523M, this.f19524N);
        }
    }

    private void m20821C() {
        if (this.f19513C > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.f19512B;
            EventDispatcher eventDispatcher = this.f19532o;
            int i = this.f19513C;
            if (eventDispatcher.f5360b != null) {
                eventDispatcher.f5359a.post(new C04324(eventDispatcher, i, j));
            }
            this.f19513C = 0;
            this.f19512B = elapsedRealtime;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point m20823a(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r13, com.google.android.exoplayer2.Format r14) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
        r0 = r14.f4023k;
        r1 = r14.f4022j;
        r2 = 0;
        if (r0 <= r1) goto L_0x0009;
    L_0x0007:
        r0 = 1;
        goto L_0x000a;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        if (r0 == 0) goto L_0x000f;
    L_0x000c:
        r1 = r14.f4023k;
        goto L_0x0011;
    L_0x000f:
        r1 = r14.f4022j;
    L_0x0011:
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r3 = r14.f4022j;
        goto L_0x0018;
    L_0x0016:
        r3 = r14.f4023k;
    L_0x0018:
        r4 = (float) r3;
        r5 = (float) r1;
        r4 = r4 / r5;
        r5 = f19510l;
        r6 = r5.length;
    L_0x001e:
        r7 = 0;
        if (r2 >= r6) goto L_0x009f;
    L_0x0021:
        r8 = r5[r2];
        r9 = (float) r8;
        r9 = r9 * r4;
        r9 = (int) r9;
        if (r8 <= r1) goto L_0x009e;
    L_0x0028:
        if (r9 > r3) goto L_0x002c;
    L_0x002a:
        goto L_0x009e;
    L_0x002c:
        r10 = com.google.android.exoplayer2.util.Util.f5283a;
        r11 = 21;
        if (r10 < r11) goto L_0x0079;
    L_0x0032:
        if (r0 == 0) goto L_0x0036;
    L_0x0034:
        r10 = r9;
        goto L_0x0037;
    L_0x0036:
        r10 = r8;
    L_0x0037:
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x003b;
    L_0x003a:
        r8 = r9;
    L_0x003b:
        r9 = r13.f4651f;
        if (r9 != 0) goto L_0x0045;
    L_0x003f:
        r8 = "align.caps";
        r13.m3891b(r8);
        goto L_0x006b;
    L_0x0045:
        r9 = r13.f4651f;
        r9 = r9.getVideoCapabilities();
        if (r9 != 0) goto L_0x0053;
    L_0x004d:
        r8 = "align.vCaps";
        r13.m3891b(r8);
        goto L_0x006b;
    L_0x0053:
        r7 = r9.getWidthAlignment();
        r9 = r9.getHeightAlignment();
        r11 = new android.graphics.Point;
        r10 = com.google.android.exoplayer2.util.Util.m4296a(r10, r7);
        r10 = r10 * r7;
        r7 = com.google.android.exoplayer2.util.Util.m4296a(r8, r9);
        r7 = r7 * r9;
        r11.<init>(r10, r7);
        r7 = r11;
    L_0x006b:
        r8 = r14.f4024l;
        r9 = r7.x;
        r10 = r7.y;
        r11 = (double) r8;
        r8 = r13.m3889a(r9, r10, r11);
        if (r8 == 0) goto L_0x009b;
    L_0x0078:
        return r7;
    L_0x0079:
        r7 = 16;
        r8 = com.google.android.exoplayer2.util.Util.m4296a(r8, r7);
        r8 = r8 * r7;
        r9 = com.google.android.exoplayer2.util.Util.m4296a(r9, r7);
        r7 = r7 * r9;
        r9 = r8 * r7;
        r10 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.m3904b();
        if (r9 > r10) goto L_0x009b;
    L_0x008d:
        r13 = new android.graphics.Point;
        if (r0 == 0) goto L_0x0093;
    L_0x0091:
        r14 = r7;
        goto L_0x0094;
    L_0x0093:
        r14 = r8;
    L_0x0094:
        if (r0 == 0) goto L_0x0097;
    L_0x0096:
        r7 = r8;
    L_0x0097:
        r13.<init>(r14, r7);
        return r13;
    L_0x009b:
        r2 = r2 + 1;
        goto L_0x001e;
    L_0x009e:
        return r7;
    L_0x009f:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.a(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, com.google.android.exoplayer2.Format):android.graphics.Point");
    }

    private static int m20830c(Format format) {
        if (format.f4019g == -1) {
            return m20822a(format.f4018f, format.f4022j, format.f4023k);
        }
        int i = 0;
        int i2 = 0;
        while (i < format.f4020h.size()) {
            i2 += ((byte[]) format.f4020h.get(i)).length;
            i++;
        }
        return format.f4019g + i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m20822a(java.lang.String r5, int r6, int r7) {
        /*
        r0 = -1;
        if (r6 == r0) goto L_0x0076;
    L_0x0003:
        if (r7 != r0) goto L_0x0007;
    L_0x0005:
        goto L_0x0076;
    L_0x0007:
        r1 = r5.hashCode();
        r2 = 4;
        r3 = 3;
        r4 = 2;
        switch(r1) {
            case -1664118616: goto L_0x0044;
            case -1662541442: goto L_0x003a;
            case 1187890754: goto L_0x0030;
            case 1331836730: goto L_0x0026;
            case 1599127256: goto L_0x001c;
            case 1599127257: goto L_0x0012;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x004e;
    L_0x0012:
        r1 = "video/x-vnd.on2.vp9";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x001a:
        r5 = 5;
        goto L_0x004f;
    L_0x001c:
        r1 = "video/x-vnd.on2.vp8";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0024:
        r5 = r3;
        goto L_0x004f;
    L_0x0026:
        r1 = "video/avc";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x002e:
        r5 = r4;
        goto L_0x004f;
    L_0x0030:
        r1 = "video/mp4v-es";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0038:
        r5 = 1;
        goto L_0x004f;
    L_0x003a:
        r1 = "video/hevc";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0042:
        r5 = r2;
        goto L_0x004f;
    L_0x0044:
        r1 = "video/3gpp";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x004c:
        r5 = 0;
        goto L_0x004f;
    L_0x004e:
        r5 = r0;
    L_0x004f:
        switch(r5) {
            case 0: goto L_0x0070;
            case 1: goto L_0x0070;
            case 2: goto L_0x0057;
            case 3: goto L_0x0055;
            case 4: goto L_0x0053;
            case 5: goto L_0x0053;
            default: goto L_0x0052;
        };
    L_0x0052:
        return r0;
    L_0x0053:
        r6 = r6 * r7;
        goto L_0x0072;
    L_0x0055:
        r6 = r6 * r7;
        goto L_0x0071;
    L_0x0057:
        r5 = "BRAVIA 4K 2015";
        r1 = com.google.android.exoplayer2.util.Util.f5286d;
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x0062;
    L_0x0061:
        return r0;
    L_0x0062:
        r5 = 16;
        r6 = com.google.android.exoplayer2.util.Util.m4296a(r6, r5);
        r7 = com.google.android.exoplayer2.util.Util.m4296a(r7, r5);
        r6 = r6 * r7;
        r6 = r6 * r5;
        r6 = r6 * r5;
        goto L_0x0071;
    L_0x0070:
        r6 = r6 * r7;
    L_0x0071:
        r2 = r4;
    L_0x0072:
        r6 = r6 * r3;
        r4 = r4 * r2;
        r6 = r6 / r4;
        return r6;
    L_0x0076:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.a(java.lang.String, int, int):int");
    }

    private static boolean m20829b(boolean z, Format format, Format format2) {
        return format.f4018f.equals(format2.f4018f) && m20831d(format) == m20831d(format2) && (z || (format.f4022j == format2.f4022j && format.f4023k == format2.f4023k));
    }

    private static int m20831d(Format format) {
        return format.f4025m == -1 ? null : format.f4025m;
    }
}
