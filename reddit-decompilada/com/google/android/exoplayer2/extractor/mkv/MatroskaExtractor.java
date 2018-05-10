package com.google.android.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class MatroskaExtractor implements Extractor {
    private static final byte[] f12873H = new byte[]{Framer.STDOUT_FRAME_PREFIX, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    private static final byte[] f12874I = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static long f12875J = 1000;
    private static final byte[] f12876K = new byte[]{(byte) 68, (byte) 105, (byte) 97, (byte) 108, (byte) 111, (byte) 103, (byte) 117, (byte) 101, (byte) 58, (byte) 32, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44};
    private static long f12877L = 10000;
    private static final byte[] f12878M = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    private static final UUID f12879N = new UUID(72057594037932032L, -9223371306706625679L);
    public static final ExtractorsFactory f12880a = new C11291();
    static final byte[] f12881b = Util.m4321c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    int f12882A;
    int[] f12883B;
    int f12884C;
    int f12885D;
    int f12886E;
    boolean f12887F;
    ExtractorOutput f12888G;
    private final EbmlReader f12889O;
    private final ParsableByteArray f12890P;
    private final ParsableByteArray f12891Q;
    private final ParsableByteArray f12892R;
    private final ParsableByteArray f12893S;
    private final ParsableByteArray f12894T;
    private final ParsableByteArray f12895U;
    private final ParsableByteArray f12896V;
    private ByteBuffer f12897W;
    private long f12898X;
    private int f12899Y;
    private boolean f12900Z;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private byte ad;
    private int ae;
    private int af;
    private int ag;
    private boolean ah;
    final VarintReader f12901c;
    final SparseArray<Track> f12902d;
    final boolean f12903e;
    final ParsableByteArray f12904f;
    final ParsableByteArray f12905g;
    long f12906h;
    long f12907i;
    long f12908j;
    long f12909k;
    long f12910l;
    Track f12911m;
    boolean f12912n;
    int f12913o;
    long f12914p;
    boolean f12915q;
    long f12916r;
    long f12917s;
    LongArray f12918t;
    LongArray f12919u;
    boolean f12920v;
    int f12921w;
    long f12922x;
    long f12923y;
    int f12924z;

    private static final class Track {
        public float f4276A;
        public float f4277B;
        public float f4278C;
        public float f4279D;
        public float f4280E;
        public float f4281F;
        public int f4282G;
        public int f4283H;
        public int f4284I;
        public long f4285J;
        public long f4286K;
        public boolean f4287L;
        public boolean f4288M;
        String f4289N;
        public TrackOutput f4290O;
        public int f4291P;
        public String f4292a;
        public int f4293b;
        public int f4294c;
        public int f4295d;
        public boolean f4296e;
        public byte[] f4297f;
        public CryptoData f4298g;
        public byte[] f4299h;
        public DrmInitData f4300i;
        public int f4301j;
        public int f4302k;
        public int f4303l;
        public int f4304m;
        public int f4305n;
        public byte[] f4306o;
        public int f4307p;
        public boolean f4308q;
        public int f4309r;
        public int f4310s;
        public int f4311t;
        public int f4312u;
        public int f4313v;
        public float f4314w;
        public float f4315x;
        public float f4316y;
        public float f4317z;

        private Track() {
            this.f4301j = -1;
            this.f4302k = -1;
            this.f4303l = -1;
            this.f4304m = -1;
            this.f4305n = 0;
            this.f4306o = null;
            this.f4307p = -1;
            this.f4308q = false;
            this.f4309r = -1;
            this.f4310s = -1;
            this.f4311t = -1;
            this.f4312u = 1000;
            this.f4313v = HttpStatus.HTTP_OK;
            this.f4314w = -1.0f;
            this.f4315x = -1.0f;
            this.f4316y = -1.0f;
            this.f4317z = -1.0f;
            this.f4276A = -1.0f;
            this.f4277B = -1.0f;
            this.f4278C = -1.0f;
            this.f4279D = -1.0f;
            this.f4280E = -1.0f;
            this.f4281F = -1.0f;
            this.f4282G = 1;
            this.f4283H = -1;
            this.f4284I = EventsFilesManager.MAX_BYTE_SIZE_PER_FILE;
            this.f4285J = 0;
            this.f4286K = 0;
            this.f4288M = true;
            this.f4289N = "eng";
        }

        static java.util.List<byte[]> m3779a(com.google.android.exoplayer2.util.ParsableByteArray r4) throws com.google.android.exoplayer2.ParserException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 16;
            r4.m4251d(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r0 = r4.m4258i();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r2 = 826496599; // 0x31435657 float:2.8425313E-9 double:4.08343576E-315;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r0 == 0) goto L_0x0012;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0010:
            r4 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            return r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0012:
            r0 = r4.f5257b;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r0 = r0 + 20;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r4 = r4.f5256a;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0018:
            r1 = r4.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r1 = r1 + -4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r0 >= r1) goto L_0x0043;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x001d:
            r1 = r4[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r1 != 0) goto L_0x0040;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0021:
            r1 = r0 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r1 != 0) goto L_0x0040;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0027:
            r1 = r0 + 2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r2 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r1 != r2) goto L_0x0040;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x002e:
            r1 = r0 + 3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r2 = 15;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            if (r1 != r2) goto L_0x0040;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0036:
            r1 = r4.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r4 = java.util.Arrays.copyOfRange(r4, r0, r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r4 = java.util.Collections.singletonList(r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            return r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0040:
            r0 = r0 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            goto L_0x0018;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x0043:
            r4 = new com.google.android.exoplayer2.ParserException;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r0 = "Failed to find FourCC VC1 initialization data";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            r4.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
            throw r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004b }
        L_0x004b:
            r4 = new com.google.android.exoplayer2.ParserException;
            r0 = "Error parsing FourCC VC1 codec private";
            r4.<init>(r0);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.a(com.google.android.exoplayer2.util.ParsableByteArray):java.util.List<byte[]>");
        }

        static java.util.List<byte[]> m3780a(byte[] r8) throws com.google.android.exoplayer2.ParserException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 0;
            r1 = r8[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r2 = 2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r1 == r2) goto L_0x000e;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0006:
            r8 = new com.google.android.exoplayer2.ParserException;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x000e:
            r1 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0011:
            r5 = r8[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r6 = -1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r5 != r6) goto L_0x001b;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0016:
            r4 = r4 + 255;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            goto L_0x0011;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x001b:
            r5 = r3 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r8[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r4 + r3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0021:
            r7 = r8[r5];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r7 != r6) goto L_0x002a;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0025:
            r3 = r3 + 255;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r5 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            goto L_0x0021;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x002a:
            r6 = r5 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r8[r5];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 + r5;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r5 == r1) goto L_0x003b;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0033:
            r8 = new com.google.android.exoplayer2.ParserException;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x003b:
            r1 = new byte[r4];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            java.lang.System.arraycopy(r8, r6, r1, r0, r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r6 = r6 + r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = 3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r4 == r5) goto L_0x004e;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0046:
            r8 = new com.google.android.exoplayer2.ParserException;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x004e:
            r6 = r6 + r3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = 5;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r3 == r4) goto L_0x005c;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0054:
            r8 = new com.google.android.exoplayer2.ParserException;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x005c:
            r3 = r8.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 - r6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = new byte[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r8.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r4 - r6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            java.lang.System.arraycopy(r8, r6, r3, r0, r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8 = new java.util.ArrayList;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.add(r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.add(r3);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            return r8;
        L_0x0071:
            r8 = new com.google.android.exoplayer2.ParserException;
            r0 = "Error parsing vorbis codec private";
            r8.<init>(r0);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.a(byte[]):java.util.List<byte[]>");
        }

        static boolean m3781b(com.google.android.exoplayer2.util.ParsableByteArray r8) throws com.google.android.exoplayer2.ParserException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = r8.m4254f();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r1 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            if (r0 != r1) goto L_0x0008;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
        L_0x0007:
            return r1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
        L_0x0008:
            r2 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r3 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            if (r0 != r2) goto L_0x0035;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
        L_0x000e:
            r0 = 24;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r8.m4249c(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r4 = r8.m4261l();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r0 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f12879N;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r6 = r0.getMostSignificantBits();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            if (r0 != 0) goto L_0x0034;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
        L_0x0023:
            r4 = r8.m4261l();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r8 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f12879N;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r6 = r8.getLeastSignificantBits();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0036 }
            r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r8 != 0) goto L_0x0034;
        L_0x0033:
            return r1;
        L_0x0034:
            return r3;
        L_0x0035:
            return r3;
        L_0x0036:
            r8 = new com.google.android.exoplayer2.ParserException;
            r0 = "Error parsing MS/ACM codec private";
            r8.<init>(r0);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.b(com.google.android.exoplayer2.util.ParsableByteArray):boolean");
        }
    }

    static class C11291 implements ExtractorsFactory {
        C11291() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    }

    private final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        final /* synthetic */ MatroskaExtractor f12872a;

        public final void mo1359a(int r1, int r2, com.google.android.exoplayer2.extractor.ExtractorInput r3) throws java.io.IOException, java.lang.InterruptedException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlReaderOutput.a(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 6 more
*/
            /*
            // Can't load method instructions.
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlReaderOutput.a(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void");
        }

        private InnerEbmlReaderOutput(MatroskaExtractor matroskaExtractor) {
            this.f12872a = matroskaExtractor;
        }

        public final int mo1357a(int i) {
            return MatroskaExtractor.m12055a(i);
        }

        public final boolean mo1363b(int i) {
            return MatroskaExtractor.m12062b(i);
        }

        public final void mo1361a(int i, long j, long j2) throws ParserException {
            MatroskaExtractor matroskaExtractor = this.f12872a;
            if (i == 160) {
                matroskaExtractor.f12887F = false;
            } else if (i == 174) {
                matroskaExtractor.f12911m = new Track();
            } else if (i == 187) {
                matroskaExtractor.f12920v = false;
            } else if (i == 19899) {
                matroskaExtractor.f12913o = -1;
                matroskaExtractor.f12914p = -1;
            } else if (i != 20533) {
                if (i == 21968) {
                    matroskaExtractor.f12911m.f4308q = true;
                } else if (i == 25152) {
                } else {
                    if (i != 408125543) {
                        if (i == 475249515) {
                            matroskaExtractor.f12918t = new LongArray();
                            matroskaExtractor.f12919u = new LongArray();
                        } else if (i == 524531317) {
                            if (matroskaExtractor.f12912n == 0) {
                                if (matroskaExtractor.f12903e == 0 || matroskaExtractor.f12916r == -1) {
                                    matroskaExtractor.f12888G.mo1417a(new Unseekable(matroskaExtractor.f12910l));
                                    matroskaExtractor.f12912n = true;
                                    return;
                                }
                                matroskaExtractor.f12915q = true;
                            }
                        }
                    } else if (matroskaExtractor.f12907i == -1 || matroskaExtractor.f12907i == j) {
                        matroskaExtractor.f12907i = j;
                        matroskaExtractor.f12906h = j2;
                    } else {
                        throw new ParserException("Multiple Segment elements not supported");
                    }
                }
            } else {
                matroskaExtractor.f12911m.f4296e = true;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo1364c(int r29) throws com.google.android.exoplayer2.ParserException {
            /*
            r28 = this;
            r0 = r28;
            r1 = r29;
            r2 = r0.f12872a;
            r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
            r4 = 2;
            r5 = 1;
            r6 = 0;
            if (r1 == r3) goto L_0x0756;
        L_0x000d:
            r3 = 174; // 0xae float:2.44E-43 double:8.6E-322;
            r7 = 0;
            r8 = -1;
            if (r1 == r3) goto L_0x015d;
        L_0x0013:
            r3 = 19899; // 0x4dbb float:2.7884E-41 double:9.8314E-320;
            r9 = -1;
            r4 = 475249515; // 0x1c53bb6b float:7.0056276E-22 double:2.348044586E-315;
            if (r1 == r3) goto L_0x0141;
        L_0x001c:
            r3 = 25152; // 0x6240 float:3.5245E-41 double:1.24267E-319;
            if (r1 == r3) goto L_0x0110;
        L_0x0020:
            r3 = 28032; // 0x6d80 float:3.9281E-41 double:1.38496E-319;
            if (r1 == r3) goto L_0x00fc;
        L_0x0024:
            r3 = 357149030; // 0x1549a966 float:4.072526E-26 double:1.76455066E-315;
            r11 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
            if (r1 == r3) goto L_0x00e2;
        L_0x002e:
            r3 = 374648427; // 0x1654ae6b float:1.718026E-25 double:1.85100917E-315;
            if (r1 == r3) goto L_0x00cb;
        L_0x0033:
            if (r1 == r4) goto L_0x0037;
        L_0x0035:
            goto L_0x0777;
        L_0x0037:
            r1 = r2.f12912n;
            if (r1 != 0) goto L_0x0777;
        L_0x003b:
            r1 = r2.f12888G;
            r3 = r2.f12907i;
            r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
            if (r3 == 0) goto L_0x00ba;
        L_0x0043:
            r3 = r2.f12910l;
            r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
            if (r3 == 0) goto L_0x00ba;
        L_0x0049:
            r3 = r2.f12918t;
            if (r3 == 0) goto L_0x00ba;
        L_0x004d:
            r3 = r2.f12918t;
            r3 = r3.f5233a;
            if (r3 == 0) goto L_0x00ba;
        L_0x0053:
            r3 = r2.f12919u;
            if (r3 == 0) goto L_0x00ba;
        L_0x0057:
            r3 = r2.f12919u;
            r3 = r3.f5233a;
            r4 = r2.f12918t;
            r4 = r4.f5233a;
            if (r3 == r4) goto L_0x0062;
        L_0x0061:
            goto L_0x00ba;
        L_0x0062:
            r3 = r2.f12918t;
            r3 = r3.f5233a;
            r4 = new int[r3];
            r8 = new long[r3];
            r9 = new long[r3];
            r10 = new long[r3];
            r11 = r6;
        L_0x006f:
            if (r11 >= r3) goto L_0x0087;
        L_0x0071:
            r12 = r2.f12918t;
            r12 = r12.m4206a(r11);
            r10[r11] = r12;
            r12 = r2.f12907i;
            r14 = r2.f12919u;
            r14 = r14.m4206a(r11);
            r12 = r12 + r14;
            r8[r11] = r12;
            r11 = r11 + 1;
            goto L_0x006f;
        L_0x0087:
            r11 = r3 + -1;
            if (r6 >= r11) goto L_0x009e;
        L_0x008b:
            r11 = r6 + 1;
            r12 = r8[r11];
            r14 = r8[r6];
            r12 = r12 - r14;
            r12 = (int) r12;
            r4[r6] = r12;
            r12 = r10[r11];
            r14 = r10[r6];
            r12 = r12 - r14;
            r9[r6] = r12;
            r6 = r11;
            goto L_0x0087;
        L_0x009e:
            r12 = r2.f12907i;
            r14 = r2.f12906h;
            r12 = r12 + r14;
            r14 = r8[r11];
            r12 = r12 - r14;
            r3 = (int) r12;
            r4[r11] = r3;
            r12 = r2.f12910l;
            r14 = r10[r11];
            r12 = r12 - r14;
            r9[r11] = r12;
            r2.f12918t = r7;
            r2.f12919u = r7;
            r3 = new com.google.android.exoplayer2.extractor.ChunkIndex;
            r3.<init>(r4, r8, r9, r10);
            goto L_0x00c5;
        L_0x00ba:
            r2.f12918t = r7;
            r2.f12919u = r7;
            r3 = new com.google.android.exoplayer2.extractor.SeekMap$Unseekable;
            r6 = r2.f12910l;
            r3.<init>(r6);
        L_0x00c5:
            r1.mo1417a(r3);
            r2.f12912n = r5;
            return;
        L_0x00cb:
            r1 = r2.f12902d;
            r1 = r1.size();
            if (r1 != 0) goto L_0x00db;
        L_0x00d3:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "No valid tracks were found";
            r1.<init>(r2);
            throw r1;
        L_0x00db:
            r1 = r2.f12888G;
            r1.mo1416a();
            goto L_0x0777;
        L_0x00e2:
            r3 = r2.f12908j;
            r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
            if (r1 != 0) goto L_0x00ed;
        L_0x00e8:
            r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r2.f12908j = r3;
        L_0x00ed:
            r3 = r2.f12909k;
            r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
            if (r1 == 0) goto L_0x0777;
        L_0x00f3:
            r3 = r2.f12909k;
            r3 = r2.m12064a(r3);
            r2.f12910l = r3;
            return;
        L_0x00fc:
            r1 = r2.f12911m;
            r1 = r1.f4296e;
            if (r1 == 0) goto L_0x0777;
        L_0x0102:
            r1 = r2.f12911m;
            r1 = r1.f4297f;
            if (r1 == 0) goto L_0x0777;
        L_0x0108:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "Combining encryption and compression is not supported";
            r1.<init>(r2);
            throw r1;
        L_0x0110:
            r1 = r2.f12911m;
            r1 = r1.f4296e;
            if (r1 == 0) goto L_0x0777;
        L_0x0116:
            r1 = r2.f12911m;
            r1 = r1.f4298g;
            if (r1 != 0) goto L_0x0124;
        L_0x011c:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "Encrypted Track found but ContentEncKeyID was not found";
            r1.<init>(r2);
            throw r1;
        L_0x0124:
            r1 = r2.f12911m;
            r3 = new com.google.android.exoplayer2.drm.DrmInitData;
            r4 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r5];
            r5 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
            r7 = com.google.android.exoplayer2.C0377C.f3971b;
            r8 = "video/webm";
            r2 = r2.f12911m;
            r2 = r2.f4298g;
            r2 = r2.f4270b;
            r5.<init>(r7, r8, r2);
            r4[r6] = r5;
            r3.<init>(r4);
            r1.f4300i = r3;
            return;
        L_0x0141:
            r1 = r2.f12913o;
            if (r1 == r8) goto L_0x0155;
        L_0x0145:
            r5 = r2.f12914p;
            r1 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
            if (r1 != 0) goto L_0x014c;
        L_0x014b:
            goto L_0x0155;
        L_0x014c:
            r1 = r2.f12913o;
            if (r1 != r4) goto L_0x0777;
        L_0x0150:
            r3 = r2.f12914p;
            r2.f12916r = r3;
            return;
        L_0x0155:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "Mandatory element SeekID or SeekPosition not found";
            r1.<init>(r2);
            throw r1;
        L_0x015d:
            r1 = r2.f12911m;
            r1 = r1.f4292a;
            r3 = "V_VP8";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0169:
            r3 = "V_VP9";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0171:
            r3 = "V_MPEG2";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0179:
            r3 = "V_MPEG4/ISO/SP";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0181:
            r3 = "V_MPEG4/ISO/ASP";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0189:
            r3 = "V_MPEG4/ISO/AP";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0191:
            r3 = "V_MPEG4/ISO/AVC";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0199:
            r3 = "V_MPEGH/ISO/HEVC";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01a1:
            r3 = "V_MS/VFW/FOURCC";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01a9:
            r3 = "V_THEORA";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01b1:
            r3 = "A_OPUS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01b9:
            r3 = "A_VORBIS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01c1:
            r3 = "A_AAC";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01c9:
            r3 = "A_MPEG/L2";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01d1:
            r3 = "A_MPEG/L3";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01d9:
            r3 = "A_AC3";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01e1:
            r3 = "A_EAC3";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01e9:
            r3 = "A_TRUEHD";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01f1:
            r3 = "A_DTS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x01f9:
            r3 = "A_DTS/EXPRESS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0201:
            r3 = "A_DTS/LOSSLESS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0209:
            r3 = "A_FLAC";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0211:
            r3 = "A_MS/ACM";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0219:
            r3 = "A_PCM/INT/LIT";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0221:
            r3 = "S_TEXT/UTF8";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0229:
            r3 = "S_TEXT/ASS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0231:
            r3 = "S_VOBSUB";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0239:
            r3 = "S_HDMV/PGS";
            r3 = r3.equals(r1);
            if (r3 != 0) goto L_0x024c;
        L_0x0241:
            r3 = "S_DVBSUB";
            r1 = r3.equals(r1);
            if (r1 == 0) goto L_0x024a;
        L_0x0249:
            goto L_0x024c;
        L_0x024a:
            r1 = r6;
            goto L_0x024d;
        L_0x024c:
            r1 = r5;
        L_0x024d:
            if (r1 == 0) goto L_0x0753;
        L_0x024f:
            r1 = r2.f12911m;
            r3 = r2.f12888G;
            r9 = r2.f12911m;
            r9 = r9.f4293b;
            r10 = r1.f4292a;
            r11 = r10.hashCode();
            r12 = 4;
            r13 = 25;
            r14 = 8;
            r15 = 3;
            switch(r11) {
                case -2095576542: goto L_0x03a7;
                case -2095575984: goto L_0x039d;
                case -1985379776: goto L_0x0392;
                case -1784763192: goto L_0x0387;
                case -1730367663: goto L_0x037c;
                case -1482641358: goto L_0x0371;
                case -1482641357: goto L_0x0366;
                case -1373388978: goto L_0x035c;
                case -933872740: goto L_0x0351;
                case -538363189: goto L_0x0346;
                case -538363109: goto L_0x033b;
                case -425012669: goto L_0x032f;
                case -356037306: goto L_0x0323;
                case 62923557: goto L_0x0317;
                case 62923603: goto L_0x030b;
                case 62927045: goto L_0x02ff;
                case 82338133: goto L_0x02f4;
                case 82338134: goto L_0x02e9;
                case 99146302: goto L_0x02dd;
                case 444813526: goto L_0x02d1;
                case 542569478: goto L_0x02c5;
                case 725957860: goto L_0x02b9;
                case 738597099: goto L_0x02ae;
                case 855502857: goto L_0x02a3;
                case 1422270023: goto L_0x0297;
                case 1809237540: goto L_0x028c;
                case 1950749482: goto L_0x0280;
                case 1950789798: goto L_0x0274;
                case 1951062397: goto L_0x0268;
                default: goto L_0x0266;
            };
        L_0x0266:
            goto L_0x03b1;
        L_0x0268:
            r11 = "A_OPUS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0270:
            r10 = 11;
            goto L_0x03b2;
        L_0x0274:
            r11 = "A_FLAC";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x027c:
            r10 = 21;
            goto L_0x03b2;
        L_0x0280:
            r11 = "A_EAC3";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0288:
            r10 = 16;
            goto L_0x03b2;
        L_0x028c:
            r11 = "V_MPEG2";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0294:
            r10 = r4;
            goto L_0x03b2;
        L_0x0297:
            r11 = "S_TEXT/UTF8";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x029f:
            r10 = 24;
            goto L_0x03b2;
        L_0x02a3:
            r11 = "V_MPEGH/ISO/HEVC";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02ab:
            r10 = 7;
            goto L_0x03b2;
        L_0x02ae:
            r11 = "S_TEXT/ASS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02b6:
            r10 = r13;
            goto L_0x03b2;
        L_0x02b9:
            r11 = "A_PCM/INT/LIT";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02c1:
            r10 = 23;
            goto L_0x03b2;
        L_0x02c5:
            r11 = "A_DTS/EXPRESS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02cd:
            r10 = 19;
            goto L_0x03b2;
        L_0x02d1:
            r11 = "V_THEORA";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02d9:
            r10 = 9;
            goto L_0x03b2;
        L_0x02dd:
            r11 = "S_HDMV/PGS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02e5:
            r10 = 27;
            goto L_0x03b2;
        L_0x02e9:
            r11 = "V_VP9";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02f1:
            r10 = r5;
            goto L_0x03b2;
        L_0x02f4:
            r11 = "V_VP8";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x02fc:
            r10 = r6;
            goto L_0x03b2;
        L_0x02ff:
            r11 = "A_DTS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0307:
            r10 = 18;
            goto L_0x03b2;
        L_0x030b:
            r11 = "A_AC3";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0313:
            r10 = 15;
            goto L_0x03b2;
        L_0x0317:
            r11 = "A_AAC";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x031f:
            r10 = 12;
            goto L_0x03b2;
        L_0x0323:
            r11 = "A_DTS/LOSSLESS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x032b:
            r10 = 20;
            goto L_0x03b2;
        L_0x032f:
            r11 = "S_VOBSUB";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0337:
            r10 = 26;
            goto L_0x03b2;
        L_0x033b:
            r11 = "V_MPEG4/ISO/AVC";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0343:
            r10 = 6;
            goto L_0x03b2;
        L_0x0346:
            r11 = "V_MPEG4/ISO/ASP";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x034e:
            r10 = r12;
            goto L_0x03b2;
        L_0x0351:
            r11 = "S_DVBSUB";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0359:
            r10 = 28;
            goto L_0x03b2;
        L_0x035c:
            r11 = "V_MS/VFW/FOURCC";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0364:
            r10 = r14;
            goto L_0x03b2;
        L_0x0366:
            r11 = "A_MPEG/L3";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x036e:
            r10 = 14;
            goto L_0x03b2;
        L_0x0371:
            r11 = "A_MPEG/L2";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0379:
            r10 = 13;
            goto L_0x03b2;
        L_0x037c:
            r11 = "A_VORBIS";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x0384:
            r10 = 10;
            goto L_0x03b2;
        L_0x0387:
            r11 = "A_TRUEHD";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x038f:
            r10 = 17;
            goto L_0x03b2;
        L_0x0392:
            r11 = "A_MS/ACM";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x039a:
            r10 = 22;
            goto L_0x03b2;
        L_0x039d:
            r11 = "V_MPEG4/ISO/SP";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x03a5:
            r10 = r15;
            goto L_0x03b2;
        L_0x03a7:
            r11 = "V_MPEG4/ISO/AP";
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x03b1;
        L_0x03af:
            r10 = 5;
            goto L_0x03b2;
        L_0x03b1:
            r10 = r8;
        L_0x03b2:
            switch(r10) {
                case 0: goto L_0x055a;
                case 1: goto L_0x0557;
                case 2: goto L_0x0554;
                case 3: goto L_0x0546;
                case 4: goto L_0x0546;
                case 5: goto L_0x0546;
                case 6: goto L_0x0531;
                case 7: goto L_0x051d;
                case 8: goto L_0x0503;
                case 9: goto L_0x0500;
                case 10: goto L_0x04f1;
                case 11: goto L_0x04ac;
                case 12: goto L_0x049d;
                case 13: goto L_0x0497;
                case 14: goto L_0x0492;
                case 15: goto L_0x048e;
                case 16: goto L_0x048a;
                case 17: goto L_0x0486;
                case 18: goto L_0x0482;
                case 19: goto L_0x0482;
                case 20: goto L_0x047e;
                case 21: goto L_0x0475;
                case 22: goto L_0x0426;
                case 23: goto L_0x03f5;
                case 24: goto L_0x03f1;
                case 25: goto L_0x03ed;
                case 26: goto L_0x03e3;
                case 27: goto L_0x03df;
                case 28: goto L_0x03bd;
                default: goto L_0x03b5;
            };
        L_0x03b5:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "Unrecognized codec identifier.";
            r1.<init>(r2);
            throw r1;
        L_0x03bd:
            r10 = "application/dvbsubs";
            r11 = new byte[r12];
            r12 = r1.f4299h;
            r12 = r12[r6];
            r11[r6] = r12;
            r12 = r1.f4299h;
            r12 = r12[r5];
            r11[r5] = r12;
            r12 = r1.f4299h;
            r12 = r12[r4];
            r11[r4] = r12;
            r12 = r1.f4299h;
            r12 = r12[r15];
            r11[r15] = r12;
            r11 = java.util.Collections.singletonList(r11);
            goto L_0x04a5;
        L_0x03df:
            r10 = "application/pgs";
            goto L_0x055c;
        L_0x03e3:
            r10 = "application/vobsub";
            r11 = r1.f4299h;
            r11 = java.util.Collections.singletonList(r11);
            goto L_0x04a5;
        L_0x03ed:
            r10 = "text/x-ssa";
            goto L_0x055c;
        L_0x03f1:
            r10 = "application/x-subrip";
            goto L_0x055c;
        L_0x03f5:
            r10 = "audio/raw";
            r11 = r1.f4283H;
            r11 = com.google.android.exoplayer2.util.Util.m4316b(r11);
            if (r11 != 0) goto L_0x0420;
        L_0x03ff:
            r10 = "audio/x-unknown";
            r11 = "MatroskaExtractor";
            r12 = new java.lang.StringBuilder;
            r14 = "Unsupported PCM bit depth: ";
            r12.<init>(r14);
            r14 = r1.f4283H;
            r12.append(r14);
            r14 = ". Setting mimeType to ";
            r12.append(r14);
            r12.append(r10);
            r12 = r12.toString();
            android.util.Log.w(r11, r12);
            goto L_0x055c;
        L_0x0420:
            r4 = r7;
            r22 = r11;
            r11 = r8;
            goto L_0x0560;
        L_0x0426:
            r10 = "audio/raw";
            r11 = new com.google.android.exoplayer2.util.ParsableByteArray;
            r12 = r1.f4299h;
            r11.<init>(r12);
            r11 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.m3781b(r11);
            if (r11 == 0) goto L_0x045e;
        L_0x0435:
            r11 = r1.f4283H;
            r11 = com.google.android.exoplayer2.util.Util.m4316b(r11);
            if (r11 != 0) goto L_0x0420;
        L_0x043d:
            r10 = "audio/x-unknown";
            r11 = "MatroskaExtractor";
            r12 = new java.lang.StringBuilder;
            r14 = "Unsupported PCM bit depth: ";
            r12.<init>(r14);
            r14 = r1.f4283H;
            r12.append(r14);
            r14 = ". Setting mimeType to ";
            r12.append(r14);
            r12.append(r10);
            r12 = r12.toString();
            android.util.Log.w(r11, r12);
            goto L_0x055c;
        L_0x045e:
            r10 = "audio/x-unknown";
            r11 = "MatroskaExtractor";
            r12 = new java.lang.StringBuilder;
            r14 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ";
            r12.<init>(r14);
            r12.append(r10);
            r12 = r12.toString();
            android.util.Log.w(r11, r12);
            goto L_0x055c;
        L_0x0475:
            r10 = "audio/flac";
            r11 = r1.f4299h;
            r11 = java.util.Collections.singletonList(r11);
            goto L_0x04a5;
        L_0x047e:
            r10 = "audio/vnd.dts.hd";
            goto L_0x055c;
        L_0x0482:
            r10 = "audio/vnd.dts";
            goto L_0x055c;
        L_0x0486:
            r10 = "audio/true-hd";
            goto L_0x055c;
        L_0x048a:
            r10 = "audio/eac3";
            goto L_0x055c;
        L_0x048e:
            r10 = "audio/ac3";
            goto L_0x055c;
        L_0x0492:
            r10 = "audio/mpeg";
            r11 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            goto L_0x049b;
        L_0x0497:
            r10 = "audio/mpeg-L2";
            r11 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        L_0x049b:
            r4 = r7;
            goto L_0x04fd;
        L_0x049d:
            r10 = "audio/mp4a-latm";
            r11 = r1.f4299h;
            r11 = java.util.Collections.singletonList(r11);
        L_0x04a5:
            r22 = r8;
            r4 = r11;
            r11 = r22;
            goto L_0x0560;
        L_0x04ac:
            r10 = "audio/opus";
            r12 = new java.util.ArrayList;
            r12.<init>(r15);
            r11 = r1.f4299h;
            r12.add(r11);
            r11 = java.nio.ByteBuffer.allocate(r14);
            r15 = java.nio.ByteOrder.nativeOrder();
            r11 = r11.order(r15);
            r4 = r1.f4285J;
            r4 = r11.putLong(r4);
            r4 = r4.array();
            r12.add(r4);
            r4 = java.nio.ByteBuffer.allocate(r14);
            r5 = java.nio.ByteOrder.nativeOrder();
            r4 = r4.order(r5);
            r14 = r1.f4286K;
            r4 = r4.putLong(r14);
            r4 = r4.array();
            r12.add(r4);
            r22 = r8;
            r4 = r12;
            r11 = 5760; // 0x1680 float:8.071E-42 double:2.846E-320;
            goto L_0x0560;
        L_0x04f1:
            r10 = "audio/vorbis";
            r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r5 = r1.f4299h;
            r5 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.m3780a(r5);
            r11 = r4;
            r4 = r5;
        L_0x04fd:
            r22 = r8;
            goto L_0x0560;
        L_0x0500:
            r10 = "video/x-unknown";
            goto L_0x055c;
        L_0x0503:
            r4 = new com.google.android.exoplayer2.util.ParsableByteArray;
            r5 = r1.f4299h;
            r4.<init>(r5);
            r4 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.m3779a(r4);
            if (r4 == 0) goto L_0x0513;
        L_0x0510:
            r10 = "video/wvc1";
            goto L_0x055d;
        L_0x0513:
            r5 = "MatroskaExtractor";
            r10 = "Unsupported FourCC. Setting mimeType to video/x-unknown";
            android.util.Log.w(r5, r10);
            r10 = "video/x-unknown";
            goto L_0x055d;
        L_0x051d:
            r10 = "video/hevc";
            r4 = new com.google.android.exoplayer2.util.ParsableByteArray;
            r5 = r1.f4299h;
            r4.<init>(r5);
            r4 = com.google.android.exoplayer2.video.HevcConfig.m4339a(r4);
            r5 = r4.f5316a;
            r4 = r4.f5317b;
            r1.f4291P = r4;
            goto L_0x0544;
        L_0x0531:
            r10 = "video/avc";
            r4 = new com.google.android.exoplayer2.util.ParsableByteArray;
            r5 = r1.f4299h;
            r4.<init>(r5);
            r4 = com.google.android.exoplayer2.video.AvcConfig.m4334a(r4);
            r5 = r4.f5292a;
            r4 = r4.f5293b;
            r1.f4291P = r4;
        L_0x0544:
            r4 = r5;
            goto L_0x055d;
        L_0x0546:
            r10 = "video/mp4v-es";
            r4 = r1.f4299h;
            if (r4 != 0) goto L_0x054d;
        L_0x054c:
            goto L_0x055c;
        L_0x054d:
            r4 = r1.f4299h;
            r4 = java.util.Collections.singletonList(r4);
            goto L_0x055d;
        L_0x0554:
            r10 = "video/mpeg2";
            goto L_0x055c;
        L_0x0557:
            r10 = "video/x-vnd.on2.vp9";
            goto L_0x055c;
        L_0x055a:
            r10 = "video/x-vnd.on2.vp8";
        L_0x055c:
            r4 = r7;
        L_0x055d:
            r11 = r8;
            r22 = r11;
        L_0x0560:
            r5 = r1.f4288M;
            r5 = r5 | r6;
            r12 = r1.f4287L;
            if (r12 == 0) goto L_0x0569;
        L_0x0567:
            r12 = 2;
            goto L_0x056a;
        L_0x0569:
            r12 = r6;
        L_0x056a:
            r5 = r5 | r12;
            r12 = com.google.android.exoplayer2.util.MimeTypes.m4212a(r10);
            if (r12 == 0) goto L_0x0597;
        L_0x0571:
            r16 = java.lang.Integer.toString(r9);
            r18 = -1;
            r6 = r1.f4282G;
            r8 = r1.f4284I;
            r9 = r1.f4300i;
            r12 = r1.f4289N;
            r17 = r10;
            r19 = r11;
            r20 = r6;
            r21 = r8;
            r23 = r4;
            r24 = r9;
            r25 = r5;
            r26 = r12;
            r4 = com.google.android.exoplayer2.Format.m3557a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
            r5 = r4;
            r4 = 1;
            goto L_0x073b;
        L_0x0597:
            r12 = com.google.android.exoplayer2.util.MimeTypes.m4213b(r10);
            if (r12 == 0) goto L_0x06c0;
        L_0x059d:
            r5 = r1.f4305n;
            if (r5 != 0) goto L_0x05b7;
        L_0x05a1:
            r5 = r1.f4303l;
            if (r5 != r8) goto L_0x05a8;
        L_0x05a5:
            r5 = r1.f4301j;
            goto L_0x05aa;
        L_0x05a8:
            r5 = r1.f4303l;
        L_0x05aa:
            r1.f4303l = r5;
            r5 = r1.f4304m;
            if (r5 != r8) goto L_0x05b3;
        L_0x05b0:
            r5 = r1.f4302k;
            goto L_0x05b5;
        L_0x05b3:
            r5 = r1.f4304m;
        L_0x05b5:
            r1.f4304m = r5;
        L_0x05b7:
            r5 = r1.f4303l;
            r12 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            if (r5 == r8) goto L_0x05d1;
        L_0x05bd:
            r5 = r1.f4304m;
            if (r5 == r8) goto L_0x05d1;
        L_0x05c1:
            r5 = r1.f4302k;
            r8 = r1.f4303l;
            r5 = r5 * r8;
            r5 = (float) r5;
            r8 = r1.f4301j;
            r14 = r1.f4304m;
            r8 = r8 * r14;
            r8 = (float) r8;
            r5 = r5 / r8;
            r23 = r5;
            goto L_0x05d3;
        L_0x05d1:
            r23 = r12;
        L_0x05d3:
            r5 = r1.f4308q;
            if (r5 == 0) goto L_0x0696;
        L_0x05d7:
            r5 = r1.f4314w;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05dd:
            r5 = r1.f4315x;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05e3:
            r5 = r1.f4316y;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05e9:
            r5 = r1.f4317z;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05ef:
            r5 = r1.f4276A;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05f5:
            r5 = r1.f4277B;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x05fb:
            r5 = r1.f4278C;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x0601:
            r5 = r1.f4279D;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x0607:
            r5 = r1.f4280E;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 == 0) goto L_0x0687;
        L_0x060d:
            r5 = r1.f4281F;
            r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1));
            if (r5 != 0) goto L_0x0614;
        L_0x0613:
            goto L_0x0687;
        L_0x0614:
            r5 = new byte[r13];
            r8 = java.nio.ByteBuffer.wrap(r5);
            r8.put(r6);
            r6 = r1.f4314w;
            r12 = 1195593728; // 0x47435000 float:50000.0 double:5.907017874E-315;
            r6 = r6 * r12;
            r13 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4315x;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4316y;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4317z;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4276A;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4277B;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4278C;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4279D;
            r6 = r6 * r12;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4280E;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4281F;
            r6 = r6 + r13;
            r6 = (int) r6;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4312u;
            r6 = (short) r6;
            r8.putShort(r6);
            r6 = r1.f4313v;
            r6 = (short) r6;
            r8.putShort(r6);
            goto L_0x0688;
        L_0x0687:
            r5 = r7;
        L_0x0688:
            r6 = new com.google.android.exoplayer2.video.ColorInfo;
            r8 = r1.f4309r;
            r12 = r1.f4311t;
            r13 = r1.f4310s;
            r6.<init>(r8, r12, r13, r5);
            r26 = r6;
            goto L_0x0698;
        L_0x0696:
            r26 = r7;
        L_0x0698:
            r16 = java.lang.Integer.toString(r9);
            r5 = r1.f4301j;
            r6 = r1.f4302k;
            r22 = -1;
            r8 = r1.f4306o;
            r9 = r1.f4307p;
            r12 = r1.f4300i;
            r17 = r10;
            r18 = r11;
            r19 = r5;
            r20 = r6;
            r21 = r4;
            r24 = r8;
            r25 = r9;
            r27 = r12;
            r4 = com.google.android.exoplayer2.Format.m3559a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
            r5 = r4;
            r4 = 2;
            goto L_0x073b;
        L_0x06c0:
            r6 = "application/x-subrip";
            r6 = r6.equals(r10);
            if (r6 == 0) goto L_0x06d7;
        L_0x06c8:
            r4 = java.lang.Integer.toString(r9);
            r6 = r1.f4289N;
            r8 = r1.f4300i;
            r4 = com.google.android.exoplayer2.Format.m3563a(r4, r10, r5, r6, r8);
        L_0x06d4:
            r5 = r4;
            r4 = 3;
            goto L_0x073b;
        L_0x06d7:
            r6 = "text/x-ssa";
            r6 = r6.equals(r10);
            if (r6 == 0) goto L_0x070d;
        L_0x06df:
            r4 = new java.util.ArrayList;
            r6 = 2;
            r4.<init>(r6);
            r6 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f12881b;
            r4.add(r6);
            r6 = r1.f4299h;
            r4.add(r6);
            r16 = java.lang.Integer.toString(r9);
            r6 = r1.f4289N;
            r20 = -1;
            r8 = r1.f4300i;
            r22 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r17 = r10;
            r18 = r5;
            r19 = r6;
            r21 = r8;
            r24 = r4;
            r4 = com.google.android.exoplayer2.Format.m3562a(r16, r17, r18, r19, r20, r21, r22, r24);
            goto L_0x06d4;
        L_0x070d:
            r5 = "application/vobsub";
            r5 = r5.equals(r10);
            if (r5 != 0) goto L_0x072e;
        L_0x0715:
            r5 = "application/pgs";
            r5 = r5.equals(r10);
            if (r5 != 0) goto L_0x072e;
        L_0x071d:
            r5 = "application/dvbsubs";
            r5 = r5.equals(r10);
            if (r5 == 0) goto L_0x0726;
        L_0x0725:
            goto L_0x072e;
        L_0x0726:
            r1 = new com.google.android.exoplayer2.ParserException;
            r2 = "Unexpected MIME type.";
            r1.<init>(r2);
            throw r1;
        L_0x072e:
            r5 = java.lang.Integer.toString(r9);
            r6 = r1.f4289N;
            r8 = r1.f4300i;
            r4 = com.google.android.exoplayer2.Format.m3570a(r5, r10, r4, r6, r8);
            goto L_0x06d4;
        L_0x073b:
            r6 = r1.f4293b;
            r3 = r3.mo1415a(r6, r4);
            r1.f4290O = r3;
            r1 = r1.f4290O;
            r1.mo1345a(r5);
            r1 = r2.f12902d;
            r3 = r2.f12911m;
            r3 = r3.f4293b;
            r4 = r2.f12911m;
            r1.put(r3, r4);
        L_0x0753:
            r2.f12911m = r7;
            return;
        L_0x0756:
            r1 = r2.f12921w;
            r3 = 2;
            if (r1 != r3) goto L_0x0777;
        L_0x075b:
            r1 = r2.f12887F;
            if (r1 != 0) goto L_0x0765;
        L_0x075f:
            r1 = r2.f12886E;
            r3 = 1;
            r1 = r1 | r3;
            r2.f12886E = r1;
        L_0x0765:
            r1 = r2.f12902d;
            r3 = r2.f12884C;
            r1 = r1.get(r3);
            r1 = (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track) r1;
            r3 = r2.f12922x;
            r2.m12069a(r1, r3);
            r2.f12921w = r6;
            return;
        L_0x0777:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlReaderOutput.c(int):void");
        }

        public final void mo1360a(int i, long j) throws ParserException {
            MatroskaExtractor matroskaExtractor = this.f12872a;
            boolean z = false;
            StringBuilder stringBuilder;
            switch (i) {
                case 131:
                    matroskaExtractor.f12911m.f4294c = (int) j;
                    return;
                case 136:
                    i = matroskaExtractor.f12911m;
                    if (j == 1) {
                        z = true;
                    }
                    i.f4287L = z;
                    return;
                case 155:
                    matroskaExtractor.f12923y = matroskaExtractor.m12064a(j);
                    return;
                case 159:
                    matroskaExtractor.f12911m.f4282G = (int) j;
                    return;
                case 176:
                    matroskaExtractor.f12911m.f4301j = (int) j;
                    return;
                case MPEGConst.SEQUENCE_HEADER_CODE /*179*/:
                    matroskaExtractor.f12918t.m4207a(matroskaExtractor.m12064a(j));
                    return;
                case 186:
                    matroskaExtractor.f12911m.f4302k = (int) j;
                    return;
                case JpegConst.RST7 /*215*/:
                    matroskaExtractor.f12911m.f4293b = (int) j;
                    return;
                case JpegConst.APP7 /*231*/:
                    matroskaExtractor.f12917s = matroskaExtractor.m12064a(j);
                    return;
                case 241:
                    if (matroskaExtractor.f12920v == 0) {
                        matroskaExtractor.f12919u.m4207a(j);
                        matroskaExtractor.f12920v = true;
                        return;
                    }
                    break;
                case 251:
                    matroskaExtractor.f12887F = true;
                    return;
                case 16980:
                    if (j != 3) {
                        stringBuilder = new StringBuilder("ContentCompAlgo ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 17029:
                    if (j < 1 || j > 2) {
                        stringBuilder = new StringBuilder("DocTypeReadVersion ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                case 17143:
                    if (j != 1) {
                        stringBuilder = new StringBuilder("EBMLReadVersion ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 18401:
                    if (j != 5) {
                        stringBuilder = new StringBuilder("ContentEncAlgo ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 18408:
                    if (j != 1) {
                        stringBuilder = new StringBuilder("AESSettingsCipherMode ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 20529:
                    if (j != 0) {
                        stringBuilder = new StringBuilder("ContentEncodingOrder ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 20530:
                    if (j != 1) {
                        stringBuilder = new StringBuilder("ContentEncodingScope ");
                        stringBuilder.append(j);
                        stringBuilder.append(" not supported");
                        throw new ParserException(stringBuilder.toString());
                    }
                    break;
                case 21420:
                    matroskaExtractor.f12914p = j + matroskaExtractor.f12907i;
                    return;
                case 21432:
                    i = (int) j;
                    if (i == 3) {
                        matroskaExtractor.f12911m.f4307p = 1;
                        return;
                    } else if (i != 15) {
                        switch (i) {
                            case 0:
                                matroskaExtractor.f12911m.f4307p = 0;
                                return;
                            case 1:
                                matroskaExtractor.f12911m.f4307p = 2;
                                return;
                            default:
                                return;
                        }
                    } else {
                        matroskaExtractor.f12911m.f4307p = 3;
                        return;
                    }
                case 21680:
                    matroskaExtractor.f12911m.f4303l = (int) j;
                    return;
                case 21682:
                    matroskaExtractor.f12911m.f4305n = (int) j;
                    return;
                case 21690:
                    matroskaExtractor.f12911m.f4304m = (int) j;
                    return;
                case 21930:
                    i = matroskaExtractor.f12911m;
                    if (j == 1) {
                        z = true;
                    }
                    i.f4288M = z;
                    return;
                case 21945:
                    switch ((int) j) {
                        case 1:
                            matroskaExtractor.f12911m.f4311t = 2;
                            return;
                        case 2:
                            matroskaExtractor.f12911m.f4311t = 1;
                            return;
                        default:
                            return;
                    }
                case 21946:
                    i = (int) j;
                    if (i != 1) {
                        if (i == 16) {
                            matroskaExtractor.f12911m.f4310s = 6;
                            return;
                        } else if (i != 18) {
                            switch (i) {
                                case 6:
                                case 7:
                                    break;
                                default:
                                    return;
                            }
                        } else {
                            matroskaExtractor.f12911m.f4310s = 7;
                            return;
                        }
                    }
                    matroskaExtractor.f12911m.f4310s = 3;
                    return;
                case 21947:
                    matroskaExtractor.f12911m.f4308q = true;
                    i = (int) j;
                    if (i == 1) {
                        matroskaExtractor.f12911m.f4309r = 1;
                        return;
                    } else if (i != 9) {
                        switch (i) {
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                matroskaExtractor.f12911m.f4309r = 2;
                                return;
                            default:
                                return;
                        }
                    } else {
                        matroskaExtractor.f12911m.f4309r = 6;
                        return;
                    }
                case 21948:
                    matroskaExtractor.f12911m.f4312u = (int) j;
                    return;
                case 21949:
                    matroskaExtractor.f12911m.f4313v = (int) j;
                    break;
                case 22186:
                    matroskaExtractor.f12911m.f4285J = j;
                    return;
                case 22203:
                    matroskaExtractor.f12911m.f4286K = j;
                    return;
                case 25188:
                    matroskaExtractor.f12911m.f4283H = (int) j;
                    return;
                case 2352003:
                    matroskaExtractor.f12911m.f4295d = (int) j;
                    return;
                case 2807729:
                    matroskaExtractor.f12908j = j;
                    return;
                default:
                    break;
            }
        }

        public final void mo1358a(int i, double d) throws ParserException {
            MatroskaExtractor matroskaExtractor = this.f12872a;
            if (i == MPEGConst.EXTENSION_START_CODE) {
                matroskaExtractor.f12911m.f4284I = (int) d;
            } else if (i != 17545) {
                switch (i) {
                    case 21969:
                        matroskaExtractor.f12911m.f4314w = (float) d;
                        return;
                    case 21970:
                        matroskaExtractor.f12911m.f4315x = (float) d;
                        return;
                    case 21971:
                        matroskaExtractor.f12911m.f4316y = (float) d;
                        return;
                    case 21972:
                        matroskaExtractor.f12911m.f4317z = (float) d;
                        return;
                    case 21973:
                        matroskaExtractor.f12911m.f4276A = (float) d;
                        return;
                    case 21974:
                        matroskaExtractor.f12911m.f4277B = (float) d;
                        return;
                    case 21975:
                        matroskaExtractor.f12911m.f4278C = (float) d;
                        return;
                    case 21976:
                        matroskaExtractor.f12911m.f4279D = (float) d;
                        return;
                    case 21977:
                        matroskaExtractor.f12911m.f4280E = (float) d;
                        return;
                    case 21978:
                        matroskaExtractor.f12911m.f4281F = (float) d;
                        break;
                    default:
                        break;
                }
            } else {
                matroskaExtractor.f12909k = (long) d;
            }
        }

        public final void mo1362a(int i, String str) throws ParserException {
            MatroskaExtractor matroskaExtractor = this.f12872a;
            if (i != 134) {
                if (i != 17026) {
                    if (i == 2274716) {
                        matroskaExtractor.f12911m.f4289N = str;
                    }
                } else if ("webm".equals(str) == 0 && "matroska".equals(str) == 0) {
                    StringBuilder stringBuilder = new StringBuilder("DocType ");
                    stringBuilder.append(str);
                    stringBuilder.append(" not supported");
                    throw new ParserException(stringBuilder.toString());
                }
                return;
            }
            matroskaExtractor.f12911m.f4292a = str;
        }
    }

    static int m12055a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case MPEGConst.SEQUENCE_HEADER_CODE /*179*/:
            case 186:
            case JpegConst.RST7 /*215*/:
            case JpegConst.APP7 /*231*/:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case MPEGConst.SEQUENCE_END_CODE /*183*/:
            case 187:
            case JpegConst.APP0 /*224*/:
            case JpegConst.APP1 /*225*/:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case MPEGConst.EXTENSION_START_CODE /*181*/:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean m12062b(int i) {
        if (!(i == 357149030 || i == 524531317 || i == 475249515)) {
            if (i != 374648427) {
                return false;
            }
        }
        return true;
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
    }

    private MatroskaExtractor(EbmlReader ebmlReader, int i) {
        this.f12907i = -1;
        this.f12908j = -9223372036854775807L;
        this.f12909k = -9223372036854775807L;
        this.f12910l = -9223372036854775807L;
        this.f12916r = -1;
        this.f12898X = -1;
        this.f12917s = -9223372036854775807L;
        this.f12889O = ebmlReader;
        this.f12889O.mo1355a(new InnerEbmlReaderOutput());
        ebmlReader = true;
        if ((i & 1) != 0) {
            ebmlReader = null;
        }
        this.f12903e = ebmlReader;
        this.f12901c = new VarintReader();
        this.f12902d = new SparseArray();
        this.f12904f = new ParsableByteArray(4);
        this.f12892R = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f12905g = new ParsableByteArray(4);
        this.f12890P = new ParsableByteArray(NalUnitUtil.f5248a);
        this.f12891Q = new ParsableByteArray(4);
        this.f12893S = new ParsableByteArray();
        this.f12894T = new ParsableByteArray();
        this.f12895U = new ParsableByteArray(8);
        this.f12896V = new ParsableByteArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo1353a(com.google.android.exoplayer2.extractor.ExtractorInput r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
        r14 = this;
        r0 = new com.google.android.exoplayer2.extractor.mkv.Sniffer;
        r0.<init>();
        r1 = r15.mo1341d();
        r3 = -1;
        r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r3 == 0) goto L_0x0017;
    L_0x0011:
        r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0017;
    L_0x0016:
        r4 = r1;
    L_0x0017:
        r4 = (int) r4;
        r5 = r0.f4318a;
        r5 = r5.f5256a;
        r6 = 4;
        r7 = 0;
        r15.mo1340c(r5, r7, r6);
        r5 = r0.f4318a;
        r8 = r5.m4257h();
        r0.f4319b = r6;
    L_0x0029:
        r5 = 440786851; // 0x1a45dfa3 float:4.0919297E-23 double:2.1777764E-315;
        r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        r6 = 1;
        if (r5 == 0) goto L_0x0051;
    L_0x0031:
        r5 = r0.f4319b;
        r5 = r5 + r6;
        r0.f4319b = r5;
        if (r5 == r4) goto L_0x00a1;
    L_0x0038:
        r5 = r0.f4318a;
        r5 = r5.f5256a;
        r15.mo1340c(r5, r7, r6);
        r5 = 8;
        r5 = r8 << r5;
        r8 = -256; // 0xffffffffffffff00 float:NaN double:NaN;
        r5 = r5 & r8;
        r8 = r0.f4318a;
        r8 = r8.f5256a;
        r8 = r8[r7];
        r8 = r8 & 255;
        r8 = (long) r8;
        r8 = r8 | r5;
        goto L_0x0029;
    L_0x0051:
        r4 = r0.m3782a(r15);
        r8 = r0.f4319b;
        r8 = (long) r8;
        r10 = -9223372036854775808;
        r12 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r12 == 0) goto L_0x00a2;
    L_0x005e:
        if (r3 == 0) goto L_0x0067;
    L_0x0060:
        r12 = r8 + r4;
        r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r1 < 0) goto L_0x0067;
    L_0x0066:
        goto L_0x00a2;
    L_0x0067:
        r1 = r0.f4319b;
        r1 = (long) r1;
        r12 = r8 + r4;
        r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r1 >= 0) goto L_0x0099;
    L_0x0070:
        r1 = r0.m3782a(r15);
        r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r1 == 0) goto L_0x00a1;
    L_0x0078:
        r1 = r0.m3782a(r15);
        r12 = 0;
        r3 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0098;
    L_0x0082:
        r12 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r12 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r12 <= 0) goto L_0x008a;
    L_0x0089:
        goto L_0x0098;
    L_0x008a:
        if (r3 == 0) goto L_0x0067;
    L_0x008c:
        r3 = (int) r1;
        r15.mo1339c(r3);
        r3 = r0.f4319b;
        r12 = (long) r3;
        r12 = r12 + r1;
        r1 = (int) r12;
        r0.f4319b = r1;
        goto L_0x0067;
    L_0x0098:
        return r7;
    L_0x0099:
        r15 = r0.f4319b;
        r0 = (long) r15;
        r15 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
        if (r15 != 0) goto L_0x00a1;
    L_0x00a0:
        return r6;
    L_0x00a1:
        return r7;
    L_0x00a2:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.a(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f12888G = extractorOutput;
    }

    public final void mo1351a(long j, long j2) {
        this.f12917s = -9223372036854775807L;
        this.f12921w = 0;
        this.f12889O.mo1354a();
        this.f12901c.m3786a();
        m12061b();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        this.ah = false;
        boolean z = true;
        while (z && !this.ah) {
            z = this.f12889O.mo1356a(extractorInput);
            if (z) {
                int i;
                long c = extractorInput.mo1338c();
                if (this.f12915q) {
                    this.f12898X = c;
                    positionHolder.f4268a = this.f12916r;
                    this.f12915q = false;
                } else if (!this.f12912n || this.f12898X == -1) {
                    i = false;
                    if (i != 0) {
                        return 1;
                    }
                } else {
                    positionHolder.f4268a = this.f12898X;
                    this.f12898X = -1;
                }
                i = 1;
                if (i != 0) {
                    return 1;
                }
            }
        }
        if (z) {
            return 0;
        }
        return -1;
    }

    final void m12069a(Track track, long j) {
        MatroskaExtractor matroskaExtractor = this;
        Track track2 = track;
        if ("S_TEXT/UTF8".equals(track2.f4292a)) {
            m12059a(track2, "%02d:%02d:%02d,%03d", 19, f12875J, f12874I);
        } else if ("S_TEXT/ASS".equals(track2.f4292a)) {
            m12059a(track2, "%01d:%02d:%02d:%02d", 21, f12877L, f12878M);
        }
        track2.f4290O.mo1344a(j, matroskaExtractor.f12886E, matroskaExtractor.ag, 0, track2.f4298g);
        matroskaExtractor.ah = true;
        m12061b();
    }

    private void m12061b() {
        this.f12899Y = 0;
        this.ag = 0;
        this.af = 0;
        this.f12900Z = false;
        this.aa = false;
        this.ac = false;
        this.ae = 0;
        this.ad = (byte) 0;
        this.ab = false;
        this.f12893S.m4241a();
    }

    final void m12066a(ExtractorInput extractorInput, int i) throws IOException, InterruptedException {
        if (this.f12904f.f5258c < i) {
            if (this.f12904f.m4248c() < i) {
                this.f12904f.m4244a(Arrays.copyOf(this.f12904f.f5256a, Math.max(this.f12904f.f5256a.length * 2, i)), this.f12904f.f5258c);
            }
            extractorInput.mo1336b(this.f12904f.f5256a, this.f12904f.f5258c, i - this.f12904f.f5258c);
            this.f12904f.m4247b(i);
        }
    }

    final void m12067a(ExtractorInput extractorInput, Track track, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(track.f4292a)) {
            m12058a(extractorInput, f12873H, i);
        } else if ("S_TEXT/ASS".equals(track.f4292a)) {
            m12058a(extractorInput, f12876K, i);
        } else {
            int i2;
            TrackOutput trackOutput = track.f4290O;
            if (!this.f12900Z) {
                if (track.f4296e) {
                    this.f12886E &= -1073741825;
                    i2 = 128;
                    if (!this.aa) {
                        extractorInput.mo1336b(this.f12904f.f5256a, 0, 1);
                        this.f12899Y++;
                        if ((this.f12904f.f5256a[0] & 128) == 128) {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                        this.ad = this.f12904f.f5256a[0];
                        this.aa = true;
                    }
                    if ((this.ad & 1) == 1) {
                        boolean z = (this.ad & 2) == 2;
                        this.f12886E |= 1073741824;
                        if (!this.ab) {
                            extractorInput.mo1336b(this.f12895U.f5256a, 0, 8);
                            this.f12899Y += 8;
                            this.ab = true;
                            byte[] bArr = this.f12904f.f5256a;
                            if (!z) {
                                i2 = 0;
                            }
                            bArr[0] = (byte) (i2 | 8);
                            this.f12904f.m4249c(0);
                            trackOutput.mo1346a(this.f12904f, 1);
                            this.ag++;
                            this.f12895U.m4249c(0);
                            trackOutput.mo1346a(this.f12895U, 8);
                            this.ag += 8;
                        }
                        if (z) {
                            if (!this.ac) {
                                extractorInput.mo1336b(this.f12904f.f5256a, 0, 1);
                                this.f12899Y++;
                                this.f12904f.m4249c(0);
                                this.ae = this.f12904f.m4250d();
                                this.ac = true;
                            }
                            int i3 = this.ae * 4;
                            this.f12904f.m4242a(i3);
                            extractorInput.mo1336b(this.f12904f.f5256a, 0, i3);
                            this.f12899Y += i3;
                            short s = (short) ((this.ae / 2) + 1);
                            i2 = (6 * s) + 2;
                            if (this.f12897W == null || this.f12897W.capacity() < i2) {
                                this.f12897W = ByteBuffer.allocate(i2);
                            }
                            this.f12897W.position(0);
                            this.f12897W.putShort(s);
                            i3 = 0;
                            int i4 = i3;
                            while (i3 < this.ae) {
                                int n = this.f12904f.m4263n();
                                if (i3 % 2 == 0) {
                                    this.f12897W.putShort((short) (n - i4));
                                } else {
                                    this.f12897W.putInt(n - i4);
                                }
                                i3++;
                                i4 = n;
                            }
                            i3 = (i - this.f12899Y) - i4;
                            if (this.ae % 2 == 1) {
                                this.f12897W.putInt(i3);
                            } else {
                                this.f12897W.putShort((short) i3);
                                this.f12897W.putInt(0);
                            }
                            this.f12896V.m4244a(this.f12897W.array(), i2);
                            trackOutput.mo1346a(this.f12896V, i2);
                            this.ag += i2;
                        }
                    }
                } else if (track.f4297f != null) {
                    this.f12893S.m4244a(track.f4297f, track.f4297f.length);
                }
                this.f12900Z = true;
            }
            i += this.f12893S.f5258c;
            if (!"V_MPEG4/ISO/AVC".equals(track.f4292a)) {
                if (!"V_MPEGH/ISO/HEVC".equals(track.f4292a)) {
                    while (this.f12899Y < i) {
                        m12056a(extractorInput, trackOutput, i - this.f12899Y);
                    }
                    if ("A_VORBIS".equals(track.f4292a) != null) {
                        this.f12892R.m4249c(0);
                        trackOutput.mo1346a(this.f12892R, 4);
                        this.ag += 4;
                    }
                }
            }
            byte[] bArr2 = this.f12891Q.f5256a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            int i5 = track.f4291P;
            int i6 = 4 - track.f4291P;
            while (this.f12899Y < i) {
                if (this.af == 0) {
                    i2 = Math.min(i5, this.f12893S.m4246b());
                    extractorInput.mo1336b(bArr2, i6 + i2, i5 - i2);
                    if (i2 > 0) {
                        this.f12893S.m4245a(bArr2, i6, i2);
                    }
                    this.f12899Y += i5;
                    this.f12891Q.m4249c(0);
                    this.af = this.f12891Q.m4263n();
                    this.f12890P.m4249c(0);
                    trackOutput.mo1346a(this.f12890P, 4);
                    this.ag += 4;
                } else {
                    this.af -= m12056a(extractorInput, trackOutput, this.af);
                }
            }
            if ("A_VORBIS".equals(track.f4292a) != null) {
                this.f12892R.m4249c(0);
                trackOutput.mo1346a(this.f12892R, 4);
                this.ag += 4;
            }
        }
    }

    private void m12058a(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.f12894T.m4248c() < length) {
            this.f12894T.f5256a = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.f12894T.f5256a, 0, bArr.length);
        }
        extractorInput.mo1336b(this.f12894T.f5256a, bArr.length, i);
        this.f12894T.m4242a(length);
    }

    private void m12059a(Track track, String str, int i, long j, byte[] bArr) {
        Object obj;
        Object obj2;
        Object obj3 = this.f12894T.f5256a;
        long j2 = this.f12923y;
        if (j2 == -9223372036854775807L) {
            obj = bArr;
            obj2 = obj;
        } else {
            j2 -= ((long) (((int) (j2 / 3600000000L)) * 3600)) * 1000000;
            j2 -= ((long) (((int) (j2 / 60000000)) * 60)) * 1000000;
            int i2 = (int) ((j2 - (((long) ((int) (j2 / 1000000))) * 1000000)) / j);
            obj2 = Util.m4321c(String.format(Locale.US, str, new Object[]{Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(i2)}));
            obj = bArr;
        }
        System.arraycopy(obj2, 0, obj3, i, obj.length);
        track.f4290O.mo1346a(r0.f12894T, r0.f12894T.f5258c);
        r0.ag += r0.f12894T.f5258c;
    }

    private int m12056a(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws IOException, InterruptedException {
        int b = this.f12893S.m4246b();
        if (b > 0) {
            extractorInput = Math.min(i, b);
            trackOutput.mo1346a(this.f12893S, extractorInput);
        } else {
            extractorInput = trackOutput.mo1343a(extractorInput, i, false);
        }
        this.f12899Y += extractorInput;
        this.ag += extractorInput;
        return extractorInput;
    }

    final long m12064a(long j) throws ParserException {
        if (this.f12908j == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return Util.m4303a(j, this.f12908j, 1000);
    }

    static int[] m12060a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }
}
