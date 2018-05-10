package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader;
import com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode;
import com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class VorbisReader extends StreamReader {
    private VorbisSetup f13028c;
    private int f13029d;
    private boolean f13030e;
    private VorbisIdHeader f13031f;
    private CommentHeader f13032g;

    static final class VorbisSetup {
        public final VorbisIdHeader f4530a;
        public final CommentHeader f4531b;
        public final byte[] f4532c;
        public final Mode[] f4533d;
        public final int f4534e;

        public VorbisSetup(VorbisIdHeader vorbisIdHeader, CommentHeader commentHeader, byte[] bArr, Mode[] modeArr, int i) {
            this.f4530a = vorbisIdHeader;
            this.f4531b = commentHeader;
            this.f4532c = bArr;
            this.f4533d = modeArr;
            this.f4534e = i;
        }
    }

    VorbisReader() {
    }

    public static boolean m12146a(com.google.android.exoplayer2.util.ParsableByteArray r1) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 1;
        r1 = com.google.android.exoplayer2.extractor.ogg.VorbisUtil.m3847a(r0, r1, r0);	 Catch:{ ParserException -> 0x0006 }
        return r1;
    L_0x0006:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ogg.VorbisReader.a(com.google.android.exoplayer2.util.ParsableByteArray):boolean");
    }

    protected final void mo1372a(boolean z) {
        super.mo1372a(z);
        if (z) {
            this.f13028c = null;
            this.f13031f = null;
            this.f13032g = null;
        }
        this.f13029d = 0;
        this.f13030e = false;
    }

    protected final void mo1375c(long j) {
        super.mo1375c(j);
        int i = 0;
        this.f13030e = j != 0 ? 1 : 0;
        if (this.f13031f != null) {
            i = this.f13031f.f4553g;
        }
        this.f13029d = i;
    }

    protected final long mo1374b(ParsableByteArray parsableByteArray) {
        int i = 0;
        if ((parsableByteArray.f5256a[0] & 1) == 1) {
            return -1;
        }
        int i2;
        byte b = parsableByteArray.f5256a[0];
        VorbisSetup vorbisSetup = this.f13028c;
        if (vorbisSetup.f4533d[(b >> 1) & (255 >>> (8 - vorbisSetup.f4534e))].f4543a) {
            i2 = vorbisSetup.f4530a.f4554h;
        } else {
            i2 = vorbisSetup.f4530a.f4553g;
        }
        if (this.f13030e) {
            i = (this.f13029d + i2) / 4;
        }
        long j = (long) i;
        parsableByteArray.m4247b(parsableByteArray.f5258c + 4);
        parsableByteArray.f5256a[parsableByteArray.f5258c - 4] = (byte) ((int) (j & 255));
        parsableByteArray.f5256a[parsableByteArray.f5258c - 3] = (byte) ((int) ((j >>> 8) & 255));
        parsableByteArray.f5256a[parsableByteArray.f5258c - 2] = (byte) ((int) ((j >>> 16) & 255));
        parsableByteArray.f5256a[parsableByteArray.f5258c - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.f13030e = true;
        this.f13029d = i2;
        return j;
    }

    protected final boolean mo1373a(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException, InterruptedException {
        if (this.f13028c != null) {
            return false;
        }
        VorbisSetup vorbisSetup = null;
        if (this.f13031f == null) {
            this.f13031f = VorbisUtil.m3845a(parsableByteArray);
        } else if (this.f13032g == null) {
            this.f13032g = VorbisUtil.m3850b(parsableByteArray);
        } else {
            Object obj = new byte[parsableByteArray.f5258c];
            System.arraycopy(parsableByteArray.f5256a, 0, obj, 0, parsableByteArray.f5258c);
            Mode[] a = VorbisUtil.m3849a(parsableByteArray, this.f13031f.f4548b);
            vorbisSetup = new VorbisSetup(this.f13031f, this.f13032g, obj, a, VorbisUtil.m3844a(a.length - 1));
        }
        this.f13028c = vorbisSetup;
        if (this.f13028c == null) {
            return true;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f13028c.f4530a.f4556j);
        arrayList.add(this.f13028c.f4532c);
        setupData.f4511a = Format.m3558a(null, "audio/vorbis", this.f13028c.f4530a.f4551e, -1, this.f13028c.f4530a.f4548b, (int) this.f13028c.f4530a.f4549c, arrayList, null, null);
        return true;
    }
}
