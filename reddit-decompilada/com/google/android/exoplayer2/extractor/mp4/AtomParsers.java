package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.coremedia.iso.boxes.MetaBox;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.Results;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final int f4392a = Util.m4326g("vide");
    private static final int f4393b = Util.m4326g("soun");
    private static final int f4394c = Util.m4326g("text");
    private static final int f4395d = Util.m4326g("sbtl");
    private static final int f4396e = Util.m4326g("subt");
    private static final int f4397f = Util.m4326g("clcp");
    private static final int f4398g = Util.m4326g("cenc");
    private static final int f4399h = Util.m4326g(MetaBox.TYPE);

    private static final class ChunkIterator {
        public final int f4376a;
        public int f4377b;
        public int f4378c;
        public long f4379d;
        private final boolean f4380e;
        private final ParsableByteArray f4381f;
        private final ParsableByteArray f4382g;
        private int f4383h;
        private int f4384i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.f4382g = parsableByteArray;
            this.f4381f = parsableByteArray2;
            this.f4380e = z;
            parsableByteArray2.m4249c(12);
            this.f4376a = parsableByteArray2.m4263n();
            parsableByteArray.m4249c(12);
            this.f4384i = parsableByteArray.m4263n();
            parsableByteArray2 = true;
            if (parsableByteArray.m4259j() != 1) {
                parsableByteArray2 = null;
            }
            Assertions.m4187b(parsableByteArray2, "first_chunk must be 1");
            this.f4377b = -1;
        }

        public final boolean m3790a() {
            int i = this.f4377b + 1;
            this.f4377b = i;
            if (i == this.f4376a) {
                return false;
            }
            long p;
            if (this.f4380e) {
                p = this.f4381f.m4265p();
            } else {
                p = this.f4381f.m4257h();
            }
            this.f4379d = p;
            if (this.f4377b == this.f4383h) {
                this.f4378c = this.f4382g.m4263n();
                this.f4382g.m4251d(4);
                i = this.f4384i - 1;
                this.f4384i = i;
                this.f4383h = i > 0 ? this.f4382g.m4263n() - 1 : -1;
            }
            return true;
        }
    }

    private interface SampleSizeBox {
        int mo1366a();

        int mo1367b();

        boolean mo1368c();
    }

    private static final class StsdData {
        public final TrackEncryptionBox[] f4385a;
        public Format f4386b;
        public int f4387c;
        public int f4388d = 0;

        public StsdData(int i) {
            this.f4385a = new TrackEncryptionBox[i];
        }
    }

    private static final class TkhdData {
        private final int f4389a;
        private final long f4390b;
        private final int f4391c;

        public TkhdData(int i, long j, int i2) {
            this.f4389a = i;
            this.f4390b = j;
            this.f4391c = i2;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final int f12942a = this.f12944c.m4263n();
        private final int f12943b = this.f12944c.m4263n();
        private final ParsableByteArray f12944c;

        public StszSampleSizeBox(LeafAtom leafAtom) {
            this.f12944c = leafAtom.aQ;
            this.f12944c.m4249c(12);
        }

        public final int mo1366a() {
            return this.f12943b;
        }

        public final int mo1367b() {
            return this.f12942a == 0 ? this.f12944c.m4263n() : this.f12942a;
        }

        public final boolean mo1368c() {
            return this.f12942a != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray f12945a;
        private final int f12946b = this.f12945a.m4263n();
        private final int f12947c = (this.f12945a.m4263n() & 255);
        private int f12948d;
        private int f12949e;

        public final boolean mo1368c() {
            return false;
        }

        public Stz2SampleSizeBox(LeafAtom leafAtom) {
            this.f12945a = leafAtom.aQ;
            this.f12945a.m4249c(12);
        }

        public final int mo1366a() {
            return this.f12946b;
        }

        public final int mo1367b() {
            if (this.f12947c == 8) {
                return this.f12945a.m4250d();
            }
            if (this.f12947c == 16) {
                return this.f12945a.m4252e();
            }
            int i = this.f12948d;
            this.f12948d = i + 1;
            if (i % 2 != 0) {
                return this.f12949e & 15;
            }
            this.f12949e = this.f12945a.m4250d();
            return (this.f12949e & 240) >> 4;
        }
    }

    public static Track m3802a(ContainerAtom containerAtom, LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z) throws ParserException {
        int i;
        ContainerAtom containerAtom2 = containerAtom;
        ContainerAtom e = containerAtom2.m12083e(Atom.f4328E);
        ParsableByteArray parsableByteArray = e.m12082d(Atom.f4342S).aQ;
        parsableByteArray.m4249c(16);
        int j2 = parsableByteArray.m4259j();
        if (j2 == f4393b) {
            i = 1;
        } else {
            if (j2 == f4392a) {
                j2 = 2;
            } else {
                if (!(j2 == f4394c || j2 == f4395d || j2 == f4396e)) {
                    if (j2 != f4397f) {
                        i = j2 == f4399h ? 4 : -1;
                    }
                }
                j2 = 3;
            }
            i = j2;
        }
        if (i == -1) {
            return null;
        }
        int i2;
        Object obj;
        long h;
        int j3;
        int j4;
        int i3;
        TkhdData tkhdData;
        long a;
        LeafAtom leafAtom2;
        long h2;
        long a2;
        ContainerAtom e2;
        ParsableByteArray parsableByteArray2;
        int a3;
        long h3;
        int e3;
        StringBuilder stringBuilder;
        Pair create;
        StsdData a4;
        Pair a5;
        ParsableByteArray parsableByteArray3 = containerAtom2.m12082d(Atom.f4338O).aQ;
        int i4 = 8;
        parsableByteArray3.m4249c(8);
        int a6 = Atom.m3787a(parsableByteArray3.m4259j());
        parsableByteArray3.m4251d(a6 == 0 ? 8 : 16);
        int j5 = parsableByteArray3.m4259j();
        parsableByteArray3.m4251d(4);
        int i5 = parsableByteArray3.f5257b;
        int i6 = a6 == 0 ? 4 : 8;
        for (i2 = 0; i2 < i6; i2++) {
            if (parsableByteArray3.f5256a[i5 + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        obj = 1;
        if (obj != null) {
            parsableByteArray3.m4251d(i6);
        } else {
            h = a6 == 0 ? parsableByteArray3.m4257h() : parsableByteArray3.m4265p();
            if (h == 0) {
            }
            parsableByteArray3.m4251d(16);
            a6 = parsableByteArray3.m4259j();
            i2 = parsableByteArray3.m4259j();
            parsableByteArray3.m4251d(4);
            j3 = parsableByteArray3.m4259j();
            j4 = parsableByteArray3.m4259j();
            i3 = (a6 != 0 && i2 == 65536 && j3 == -65536 && j4 == 0) ? 90 : (a6 != 0 && i2 == -65536 && j3 == 65536 && j4 == 0) ? SubsamplingScaleImageView.ORIENTATION_270 : (a6 != -65536 && i2 == 0 && j3 == 0 && j4 == -65536) ? 180 : 0;
            tkhdData = new TkhdData(j5, h, i3);
            if (j != -9223372036854775807L) {
                a = tkhdData.f4390b;
                leafAtom2 = leafAtom;
            } else {
                leafAtom2 = leafAtom;
                a = j;
            }
            parsableByteArray3 = leafAtom2.aQ;
            parsableByteArray3.m4249c(8);
            parsableByteArray3.m4251d(Atom.m3787a(parsableByteArray3.m4259j()) != 0 ? 8 : 16);
            h2 = parsableByteArray3.m4257h();
            a2 = a != -9223372036854775807L ? -9223372036854775807L : Util.m4303a(a, 1000000, h2);
            e2 = e.m12083e(Atom.f4329F).m12083e(Atom.f4330G);
            parsableByteArray2 = e.m12082d(Atom.f4341R).aQ;
            parsableByteArray2.m4249c(8);
            a3 = Atom.m3787a(parsableByteArray2.m4259j());
            parsableByteArray2.m4251d(a3 != 0 ? 8 : 16);
            h3 = parsableByteArray2.m4257h();
            if (a3 == 0) {
                i4 = 4;
            }
            parsableByteArray2.m4251d(i4);
            e3 = parsableByteArray2.m4252e();
            stringBuilder = new StringBuilder();
            stringBuilder.append((char) (((e3 >> 10) & 31) + 96));
            stringBuilder.append((char) (((e3 >> 5) & 31) + 96));
            stringBuilder.append((char) ((e3 & 31) + 96));
            create = Pair.create(Long.valueOf(h3), stringBuilder.toString());
            a4 = m3801a(e2.m12082d(Atom.f4343T).aQ, tkhdData.f4389a, tkhdData.f4391c, (String) create.second, drmInitData, z);
            a5 = m3798a(containerAtom2.m12083e(Atom.f4339P));
            if (a4.f4386b == null) {
                return null;
            }
            return new Track(tkhdData.f4389a, i, ((Long) create.first).longValue(), h2, a2, a4.f4386b, a4.f4388d, a4.f4385a, a4.f4387c, (long[]) a5.first, (long[]) a5.second);
        }
        h = -9223372036854775807L;
        parsableByteArray3.m4251d(16);
        a6 = parsableByteArray3.m4259j();
        i2 = parsableByteArray3.m4259j();
        parsableByteArray3.m4251d(4);
        j3 = parsableByteArray3.m4259j();
        j4 = parsableByteArray3.m4259j();
        if (a6 != 0) {
        }
        if (a6 != 0) {
        }
        if (a6 != -65536) {
        }
        tkhdData = new TkhdData(j5, h, i3);
        if (j != -9223372036854775807L) {
            leafAtom2 = leafAtom;
            a = j;
        } else {
            a = tkhdData.f4390b;
            leafAtom2 = leafAtom;
        }
        parsableByteArray3 = leafAtom2.aQ;
        parsableByteArray3.m4249c(8);
        if (Atom.m3787a(parsableByteArray3.m4259j()) != 0) {
        }
        parsableByteArray3.m4251d(Atom.m3787a(parsableByteArray3.m4259j()) != 0 ? 8 : 16);
        h2 = parsableByteArray3.m4257h();
        if (a != -9223372036854775807L) {
        }
        e2 = e.m12083e(Atom.f4329F).m12083e(Atom.f4330G);
        parsableByteArray2 = e.m12082d(Atom.f4341R).aQ;
        parsableByteArray2.m4249c(8);
        a3 = Atom.m3787a(parsableByteArray2.m4259j());
        if (a3 != 0) {
        }
        parsableByteArray2.m4251d(a3 != 0 ? 8 : 16);
        h3 = parsableByteArray2.m4257h();
        if (a3 == 0) {
            i4 = 4;
        }
        parsableByteArray2.m4251d(i4);
        e3 = parsableByteArray2.m4252e();
        stringBuilder = new StringBuilder();
        stringBuilder.append((char) (((e3 >> 10) & 31) + 96));
        stringBuilder.append((char) (((e3 >> 5) & 31) + 96));
        stringBuilder.append((char) ((e3 & 31) + 96));
        create = Pair.create(Long.valueOf(h3), stringBuilder.toString());
        a4 = m3801a(e2.m12082d(Atom.f4343T).aQ, tkhdData.f4389a, tkhdData.f4391c, (String) create.second, drmInitData, z);
        a5 = m3798a(containerAtom2.m12083e(Atom.f4339P));
        if (a4.f4386b == null) {
            return null;
        }
        return new Track(tkhdData.f4389a, i, ((Long) create.first).longValue(), h2, a2, a4.f4386b, a4.f4388d, a4.f4385a, a4.f4387c, (long[]) a5.first, (long[]) a5.second);
    }

    public static TrackSampleTable m3803a(Track track, ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stszSampleSizeBox;
        Track track2 = track;
        ContainerAtom containerAtom2 = containerAtom;
        GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
        LeafAtom d = containerAtom2.m12082d(Atom.aq);
        if (d != null) {
            stszSampleSizeBox = new StszSampleSizeBox(d);
        } else {
            d = containerAtom2.m12082d(Atom.ar);
            if (d == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stszSampleSizeBox = new Stz2SampleSizeBox(d);
        }
        int a = stszSampleSizeBox.mo1366a();
        if (a == 0) {
            return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z;
        int n;
        int n2;
        Object obj;
        Object obj2;
        long[] jArr;
        Object obj3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        int i6;
        Object obj4;
        Object obj5;
        Object obj6;
        LeafAtom d2 = containerAtom2.m12082d(Atom.as);
        if (d2 == null) {
            d2 = containerAtom2.m12082d(Atom.at);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = d2.aQ;
        ParsableByteArray parsableByteArray2 = containerAtom2.m12082d(Atom.ap).aQ;
        ParsableByteArray parsableByteArray3 = containerAtom2.m12082d(Atom.am).aQ;
        LeafAtom d3 = containerAtom2.m12082d(Atom.an);
        ParsableByteArray parsableByteArray4 = d3 != null ? d3.aQ : null;
        LeafAtom d4 = containerAtom2.m12082d(Atom.ao);
        ParsableByteArray parsableByteArray5 = d4 != null ? d4.aQ : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.m4249c(12);
        int n3 = parsableByteArray3.m4263n() - 1;
        int n4 = parsableByteArray3.m4263n();
        int n5 = parsableByteArray3.m4263n();
        if (parsableByteArray5 != null) {
            parsableByteArray5.m4249c(12);
            n = parsableByteArray5.m4263n();
        } else {
            n = 0;
        }
        int i7 = -1;
        if (parsableByteArray4 != null) {
            parsableByteArray4.m4249c(12);
            n2 = parsableByteArray4.m4263n();
            if (n2 > 0) {
                i7 = parsableByteArray4.m4263n() - 1;
            } else {
                parsableByteArray4 = null;
            }
        } else {
            n2 = 0;
        }
        int i8 = (stszSampleSizeBox.mo1368c() && "audio/raw".equals(track2.f4458f.f4018f) && n3 == 0 && n == 0 && n2 == 0) ? 1 : 0;
        long j2 = 0;
        if (i8 == 0) {
            int i9;
            obj = new long[a];
            obj2 = new int[a];
            jArr = new long[a];
            int i10 = n2;
            obj3 = new int[a];
            ParsableByteArray parsableByteArray6 = parsableByteArray3;
            i = i7;
            long j3 = 0;
            long j4 = j3;
            i2 = i10;
            i7 = 0;
            i3 = 0;
            int i11 = 0;
            i4 = n3;
            i10 = n;
            n3 = 0;
            n = 0;
            int i12 = n5;
            n5 = n4;
            n4 = i12;
            while (n3 < a) {
                int i13;
                ParsableByteArray parsableByteArray7;
                while (i3 == 0) {
                    i5 = a;
                    Assertions.m4186b(chunkIterator.m3790a());
                    i13 = n4;
                    i9 = i4;
                    long j5 = chunkIterator.f4379d;
                    i3 = chunkIterator.f4378c;
                    j3 = j5;
                    a = i5;
                    n4 = i13;
                    i4 = i9;
                }
                i5 = a;
                i13 = n4;
                i9 = i4;
                if (parsableByteArray5 != null) {
                    while (i11 == 0 && i10 > 0) {
                        i11 = parsableByteArray5.m4263n();
                        i7 = parsableByteArray5.m4259j();
                        i10--;
                    }
                    i11--;
                }
                a = i7;
                obj[n3] = j3;
                obj2[n3] = stszSampleSizeBox.mo1367b();
                if (obj2[n3] > n) {
                    n = obj2[n3];
                }
                jArr[n3] = j4 + ((long) a);
                obj3[n3] = parsableByteArray4 == null ? 1 : 0;
                if (n3 == i) {
                    obj3[n3] = 1;
                    i2--;
                    if (i2 > 0) {
                        i = parsableByteArray4.m4263n() - 1;
                    }
                }
                n4 = i2;
                int i14 = i;
                int i15 = a;
                i2 = i13;
                j4 += (long) i2;
                n5--;
                if (n5 != 0 || i9 <= 0) {
                    parsableByteArray7 = parsableByteArray6;
                    i4 = i9;
                } else {
                    parsableByteArray7 = parsableByteArray6;
                    i4 = i9 - 1;
                    n5 = parsableByteArray7.m4263n();
                    i2 = parsableByteArray7.m4263n();
                }
                ParsableByteArray parsableByteArray8 = parsableByteArray7;
                j3 += (long) obj2[n3];
                i3--;
                n3++;
                a = i5;
                i7 = i15;
                i = i14;
                parsableByteArray6 = parsableByteArray8;
                i12 = n4;
                n4 = i2;
                i2 = i12;
            }
            i5 = a;
            i9 = i4;
            Assertions.m4184a(i11 == 0);
            while (i10 > 0) {
                Assertions.m4184a(parsableByteArray5.m4263n() == 0);
                parsableByteArray5.m4259j();
                i10--;
            }
            if (i2 == 0 && n5 == 0 && i3 == 0) {
                if (i9 == 0) {
                    track2 = track;
                    j = j4;
                    i6 = n;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Inconsistent stbl box for track ");
            n4 = i2;
            track2 = track;
            stringBuilder.append(track2.f4453a);
            stringBuilder.append(": remainingSynchronizationSamples ");
            stringBuilder.append(n4);
            stringBuilder.append(", remainingSamplesAtTimestampDelta ");
            stringBuilder.append(n5);
            stringBuilder.append(", remainingSamplesInChunk ");
            stringBuilder.append(i3);
            stringBuilder.append(", remainingTimestampDeltaChanges ");
            stringBuilder.append(i9);
            Log.w("AtomParsers", stringBuilder.toString());
            j = j4;
            i6 = n;
        } else {
            i5 = a;
            long[] jArr2 = new long[chunkIterator.f4376a];
            int[] iArr = new int[chunkIterator.f4376a];
            while (chunkIterator.m3790a()) {
                jArr2[chunkIterator.f4377b] = chunkIterator.f4379d;
                iArr[chunkIterator.f4377b] = chunkIterator.f4378c;
            }
            Results a2 = FixedSampleSizeRechunker.m3805a(stszSampleSizeBox.mo1367b(), jArr2, iArr, (long) n5);
            obj = a2.f4404a;
            obj2 = a2.f4405b;
            i = a2.f4406c;
            jArr = a2.f4407d;
            obj3 = a2.f4408e;
            i6 = i;
            j = 0;
        }
        if (track2.f4460h != null) {
            GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
            if (!gaplessInfoHolder.m3752a()) {
                Object obj7;
                long[] jArr3;
                Object obj8;
                Object obj9;
                if (track2.f4460h.length == 1 && track2.f4454b == 1 && jArr.length >= 2) {
                    long j6 = track2.f4461i[0];
                    j5 = j6 + Util.m4303a(track2.f4460h[0], track2.f4455c, track2.f4456d);
                    if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < j5 && j5 <= j) {
                        long j7 = j - j5;
                        j = Util.m4303a(j6 - jArr[0], (long) track2.f4458f.f4031s, track2.f4455c);
                        long a3 = Util.m4303a(j7, (long) track2.f4458f.f4031s, track2.f4455c);
                        if (!(j == 0 && a3 == 0) && j <= 2147483647L && a3 <= 2147483647L) {
                            gaplessInfoHolder3.f4252b = (int) j;
                            gaplessInfoHolder3.f4253c = (int) a3;
                            Util.m4310a(jArr, track2.f4455c);
                            return new TrackSampleTable(obj, obj2, i6, jArr, obj3);
                        }
                    }
                }
                if (track2.f4460h.length == 1) {
                    int i16 = 0;
                    if (track2.f4460h[0] == 0) {
                        int i17 = 0;
                        while (i17 < jArr.length) {
                            jArr[i17] = Util.m4303a(jArr[i17] - track2.f4461i[i16], 1000000, track2.f4455c);
                            i17++;
                            i16 = 0;
                        }
                        return new TrackSampleTable(obj, obj2, i6, jArr, obj3);
                    }
                }
                boolean z2 = track2.f4454b == 1;
                i = 0;
                a = 0;
                int i18 = 0;
                n3 = 0;
                while (i < track2.f4460h.length) {
                    long j8 = track2.f4461i[i];
                    if (j8 != -1) {
                        obj7 = obj2;
                        j5 = Util.m4303a(track2.f4460h[i], track2.f4455c, track2.f4456d);
                        int a4 = Util.m4301a(jArr, j8, true, true);
                        i4 = Util.m4301a(jArr, j8 + j5, z2, false);
                        i18 += i4 - a4;
                        a |= n3 != a4 ? 1 : 0;
                        n3 = i4;
                    } else {
                        obj7 = obj2;
                    }
                    i++;
                    obj2 = obj7;
                }
                obj7 = obj2;
                i = (i18 != i5 ? 1 : 0) | a;
                Object obj10 = i != 0 ? new long[i18] : obj;
                obj2 = i != 0 ? new int[i18] : obj7;
                if (i != 0) {
                    i6 = 0;
                }
                obj4 = i != 0 ? new int[i18] : obj3;
                long[] jArr4 = new long[i18];
                i3 = i6;
                n4 = 0;
                int i19 = 0;
                while (n4 < track2.f4460h.length) {
                    int i20;
                    boolean z3;
                    long j9 = track2.f4461i[n4];
                    long j10 = track2.f4460h[n4];
                    if (j9 != -1) {
                        Object obj11 = obj4;
                        i20 = n4;
                        Object obj12 = obj10;
                        jArr3 = jArr4;
                        long a5 = Util.m4303a(j10, track2.f4455c, track2.f4456d) + j9;
                        n4 = Util.m4301a(jArr, j9, true, true);
                        a = Util.m4301a(jArr, a5, z2, false);
                        if (i != 0) {
                            i18 = a - n4;
                            obj8 = obj12;
                            System.arraycopy(obj, n4, obj8, i19, i18);
                            obj4 = obj7;
                            System.arraycopy(obj4, n4, obj2, i19, i18);
                            z3 = z2;
                            obj9 = obj11;
                            System.arraycopy(obj3, n4, obj9, i19, i18);
                        } else {
                            z3 = z2;
                            obj4 = obj7;
                            obj9 = obj11;
                            obj8 = obj12;
                        }
                        i18 = i3;
                        while (n4 < a) {
                            obj5 = obj;
                            obj6 = obj3;
                            long j11 = j9;
                            jArr3[i19] = Util.m4303a(j2, 1000000, track2.f4456d) + Util.m4303a(jArr[n4] - j9, 1000000, track2.f4455c);
                            if (i != 0 && obj2[i19] > i18) {
                                i18 = obj4[n4];
                            }
                            i19++;
                            n4++;
                            obj = obj5;
                            obj3 = obj6;
                            j9 = j11;
                        }
                        obj5 = obj;
                        obj6 = obj3;
                        i3 = i18;
                    } else {
                        z3 = z2;
                        obj8 = obj10;
                        jArr3 = jArr4;
                        obj5 = obj;
                        obj6 = obj3;
                        obj9 = obj4;
                        i20 = n4;
                        obj4 = obj7;
                    }
                    j2 += j10;
                    n4 = i20 + 1;
                    obj7 = obj4;
                    obj10 = obj8;
                    j9 = -1;
                    jArr4 = jArr3;
                    obj = obj5;
                    obj3 = obj6;
                    obj4 = obj9;
                    z2 = z3;
                }
                obj8 = obj10;
                jArr3 = jArr4;
                obj9 = obj4;
                i = 0;
                for (i2 = 0; i2 < obj9.length && i == 0; i2++) {
                    i |= (obj9[i2] & 1) != 0 ? 1 : 0;
                }
                if (i != 0) {
                    return new TrackSampleTable(obj8, obj2, i3, jArr3, obj9);
                }
                throw new ParserException("The edited sample sequence does not contain a sync sample.");
            }
        }
        obj5 = obj;
        obj6 = obj3;
        obj4 = obj2;
        Util.m4310a(jArr, track2.f4455c);
        return new TrackSampleTable(obj5, obj4, i6, jArr, obj6);
    }

    public static Metadata m3804a(LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        leafAtom = leafAtom.aQ;
        leafAtom.m4249c(8);
        while (leafAtom.m4246b() >= 8) {
            int i = leafAtom.f5257b;
            int j = leafAtom.m4259j();
            if (leafAtom.m4259j() == Atom.aB) {
                leafAtom.m4249c(i);
                i += j;
                leafAtom.m4251d(12);
                while (leafAtom.f5257b < i) {
                    j = leafAtom.f5257b;
                    int j2 = leafAtom.m4259j();
                    if (leafAtom.m4259j() == Atom.aC) {
                        leafAtom.m4249c(j);
                        j += j2;
                        leafAtom.m4251d(8);
                        List arrayList = new ArrayList();
                        while (leafAtom.f5257b < j) {
                            Entry a = MetadataUtil.m3808a(leafAtom);
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                        if (arrayList.isEmpty() == null) {
                            return new Metadata(arrayList);
                        }
                        return null;
                    }
                    leafAtom.m4251d(j2 - 8);
                }
                return null;
            }
            leafAtom.m4251d(j - 8);
        }
        return null;
    }

    private static StsdData m3801a(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        String str2 = str;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray2.m4249c(12);
        int j = parsableByteArray.m4259j();
        StsdData stsdData = new StsdData(j);
        boolean z2 = false;
        int i3 = 0;
        while (i3 < j) {
            int i4;
            int i5;
            int i6;
            boolean z3;
            StsdData stsdData2;
            int i7;
            boolean z4;
            int i8;
            int i9;
            int i10;
            DrmInitData drmInitData3;
            int i11 = parsableByteArray2.f5257b;
            int j2 = parsableByteArray.m4259j();
            boolean z5 = true;
            Assertions.m4185a(j2 > 0 ? true : z2, (Object) "childAtomSize should be positive");
            int j3 = parsableByteArray.m4259j();
            if (!(j3 == Atom.f4351b || j3 == Atom.f4352c || j3 == Atom.f4349Z || j3 == Atom.al || j3 == Atom.f4353d || j3 == Atom.f4354e || j3 == Atom.f4355f || j3 == Atom.aK)) {
                if (j3 != Atom.aL) {
                    String str3;
                    int i12;
                    int i13;
                    Pair a;
                    DrmInitData drmInitData4;
                    String str4;
                    int i14;
                    int i15;
                    Object obj;
                    int i16;
                    Object obj2;
                    String str5;
                    DrmInitData drmInitData5;
                    int i17;
                    Object obj3;
                    Pair a2;
                    Pair a3;
                    Object obj4;
                    List list;
                    int i18;
                    if (!(j3 == Atom.f4358i || j3 == Atom.aa || j3 == Atom.f4363n || j3 == Atom.f4365p || j3 == Atom.f4367r || j3 == Atom.f4370u || j3 == Atom.f4368s || j3 == Atom.f4369t || j3 == Atom.ay || j3 == Atom.az || j3 == Atom.f4361l || j3 == Atom.f4362m || j3 == Atom.f4359j)) {
                        if (j3 != Atom.aO) {
                            List singletonList;
                            long j4;
                            String str6;
                            if (!(j3 == Atom.aj || j3 == Atom.au || j3 == Atom.av || j3 == Atom.aw)) {
                                if (j3 != Atom.ax) {
                                    if (j3 == Atom.aN) {
                                        stsdData.f4386b = Format.m3573b(Integer.toString(i), "application/x-camera-motion");
                                    }
                                    i4 = i11;
                                    i5 = j2;
                                    i6 = i3;
                                    z3 = z2;
                                    stsdData2 = stsdData;
                                    parsableByteArray2.m4249c(i4 + i5);
                                    i3 = i6 + 1;
                                    stsdData = stsdData2;
                                    z2 = z3;
                                }
                            }
                            parsableByteArray2.m4249c((i11 + 8) + 8);
                            if (j3 == Atom.aj) {
                                str3 = "application/ttml+xml";
                            } else {
                                if (j3 == Atom.au) {
                                    str3 = "application/x-quicktime-tx3g";
                                    i4 = (j2 - 8) - 8;
                                    Object obj5 = new byte[i4];
                                    parsableByteArray2.m4245a(obj5, z2, i4);
                                    singletonList = Collections.singletonList(obj5);
                                    j4 = Long.MAX_VALUE;
                                } else if (j3 == Atom.av) {
                                    str3 = "application/x-mp4-vtt";
                                } else if (j3 == Atom.aw) {
                                    str3 = "application/ttml+xml";
                                    singletonList = null;
                                    j4 = 0;
                                } else if (j3 == Atom.ax) {
                                    str3 = "application/x-mp4-cea-608";
                                    stsdData.f4388d = 1;
                                } else {
                                    throw new IllegalStateException();
                                }
                                str6 = str3;
                                i12 = i11;
                                i7 = j2;
                                i6 = i3;
                                stsdData.f4386b = Format.m3562a(Integer.toString(i), str6, 0, str2, -1, null, j4, singletonList);
                                i4 = i12;
                                stsdData2 = stsdData;
                                i5 = i7;
                                z3 = false;
                                parsableByteArray2.m4249c(i4 + i5);
                                i3 = i6 + 1;
                                stsdData = stsdData2;
                                z2 = z3;
                            }
                            str6 = str3;
                            singletonList = null;
                            j4 = Long.MAX_VALUE;
                            i12 = i11;
                            i7 = j2;
                            i6 = i3;
                            stsdData.f4386b = Format.m3562a(Integer.toString(i), str6, 0, str2, -1, null, j4, singletonList);
                            i4 = i12;
                            stsdData2 = stsdData;
                            i5 = i7;
                            z3 = false;
                            parsableByteArray2.m4249c(i4 + i5);
                            i3 = i6 + 1;
                            stsdData = stsdData2;
                            z2 = z3;
                        }
                    }
                    i12 = i11;
                    i7 = j2;
                    i6 = i3;
                    parsableByteArray2.m4249c((i12 + 8) + 8);
                    if (z) {
                        i11 = parsableByteArray.m4252e();
                        parsableByteArray2.m4251d(6);
                    } else {
                        parsableByteArray2.m4251d(8);
                        i11 = 0;
                    }
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2) {
                                parsableByteArray2.m4251d(16);
                                i4 = (int) Math.round(Double.longBitsToDouble(parsableByteArray.m4261l()));
                                i11 = parsableByteArray.m4263n();
                                parsableByteArray2.m4251d(20);
                                j2 = i11;
                                i13 = parsableByteArray2.f5257b;
                                if (j3 != Atom.aa) {
                                    i3 = i7;
                                    a = m3800a(parsableByteArray2, i12, i3);
                                    if (a == null) {
                                        j3 = ((Integer) a.first).intValue();
                                        if (drmInitData2 != null) {
                                            drmInitData4 = null;
                                        } else {
                                            drmInitData4 = drmInitData2.m3725a(((TrackEncryptionBox) a.second).f4465b);
                                        }
                                        stsdData.f4385a[i6] = (TrackEncryptionBox) a.second;
                                    } else {
                                        drmInitData4 = drmInitData2;
                                    }
                                    parsableByteArray2.m4249c(i13);
                                } else {
                                    i3 = i7;
                                    drmInitData4 = drmInitData2;
                                }
                                if (j3 == Atom.f4363n) {
                                    str3 = "audio/ac3";
                                } else if (j3 == Atom.f4365p) {
                                    str3 = "audio/eac3";
                                } else if (j3 != Atom.f4367r) {
                                    str3 = "audio/vnd.dts";
                                } else {
                                    if (j3 != Atom.f4368s) {
                                        if (j3 == Atom.f4369t) {
                                            if (j3 == Atom.f4370u) {
                                                str3 = "audio/vnd.dts.hd;profile=lbr";
                                            } else if (j3 == Atom.ay) {
                                                str3 = "audio/3gpp";
                                            } else if (j3 != Atom.az) {
                                                str3 = "audio/amr-wb";
                                            } else {
                                                if (j3 != Atom.f4361l) {
                                                    if (j3 == Atom.f4362m) {
                                                        str3 = j3 != Atom.f4359j ? "audio/mpeg" : j3 != Atom.aO ? "audio/alac" : null;
                                                    }
                                                }
                                                str3 = "audio/raw";
                                            }
                                        }
                                    }
                                    str3 = "audio/vnd.dts.hd";
                                }
                                str4 = str3;
                                i14 = i4;
                                i15 = j2;
                                obj = null;
                                j2 = i13;
                                while (j2 - i12 < i3) {
                                    parsableByteArray2.m4249c(j2);
                                    i13 = parsableByteArray.m4259j();
                                    Assertions.m4185a(i13 <= 0 ? z5 : false, (Object) "childAtomSize should be positive");
                                    j3 = parsableByteArray.m4259j();
                                    if (j3 != Atom.f4333J) {
                                        if (z || j3 != Atom.f4360k) {
                                            if (j3 == Atom.f4364o) {
                                                parsableByteArray2.m4249c(8 + j2);
                                                stsdData.f4386b = Ac3Util.m3643a(parsableByteArray2, Integer.toString(i), str2, drmInitData4);
                                            } else if (j3 != Atom.f4366q) {
                                                parsableByteArray2.m4249c(8 + j2);
                                                stsdData.f4386b = Ac3Util.m3645b(parsableByteArray2, Integer.toString(i), str2, drmInitData4);
                                            } else {
                                                if (j3 != Atom.f4371v) {
                                                    i16 = i13;
                                                    obj2 = obj;
                                                    str5 = str4;
                                                    z4 = z5;
                                                    drmInitData5 = drmInitData4;
                                                    i17 = j2;
                                                    i8 = i3;
                                                    stsdData.f4386b = Format.m3558a(Integer.toString(i), str4, -1, -1, i15, i14, null, drmInitData5, str2);
                                                } else {
                                                    i16 = i13;
                                                    obj2 = obj;
                                                    str5 = str4;
                                                    z4 = z5;
                                                    drmInitData5 = drmInitData4;
                                                    i17 = j2;
                                                    i8 = i3;
                                                    if (j3 == Atom.aO) {
                                                        i4 = i16;
                                                        obj3 = new byte[i4];
                                                        i13 = i17;
                                                        parsableByteArray2.m4249c(i13);
                                                        parsableByteArray2.m4245a(obj3, 0, i4);
                                                        str4 = str5;
                                                        j2 = i13 + i4;
                                                        obj = obj3;
                                                        z5 = z4;
                                                        drmInitData4 = drmInitData5;
                                                        i3 = i8;
                                                    }
                                                }
                                                i4 = i16;
                                                i13 = i17;
                                                obj3 = obj2;
                                                str4 = str5;
                                                j2 = i13 + i4;
                                                obj = obj3;
                                                z5 = z4;
                                                drmInitData4 = drmInitData5;
                                                i3 = i8;
                                            }
                                            i4 = i13;
                                            obj2 = obj;
                                            str5 = str4;
                                            z4 = z5;
                                            drmInitData5 = drmInitData4;
                                            i13 = j2;
                                            i8 = i3;
                                            obj3 = obj2;
                                            str4 = str5;
                                            j2 = i13 + i4;
                                            obj = obj3;
                                            z5 = z4;
                                            drmInitData4 = drmInitData5;
                                            i3 = i8;
                                        }
                                    }
                                    i4 = i13;
                                    obj2 = obj;
                                    str5 = str4;
                                    z4 = z5;
                                    drmInitData5 = drmInitData4;
                                    i13 = j2;
                                    i8 = i3;
                                    if (j3 != Atom.f4333J) {
                                        i9 = i13;
                                    } else {
                                        i9 = parsableByteArray2.f5257b;
                                        while (i9 - i13 < i4) {
                                            parsableByteArray2.m4249c(i9);
                                            j3 = parsableByteArray.m4259j();
                                            Assertions.m4185a(j3 <= 0 ? z4 : false, (Object) "childAtomSize should be positive");
                                            if (parsableByteArray.m4259j() == Atom.f4333J) {
                                                i9 += j3;
                                            }
                                        }
                                        i10 = -1;
                                        i9 = -1;
                                        if (i9 == i10) {
                                            a2 = m3799a(parsableByteArray2, i9);
                                            str4 = (String) a2.first;
                                            obj3 = (byte[]) a2.second;
                                            if (!"audio/mp4a-latm".equals(str4)) {
                                                a3 = CodecSpecificDataUtil.m4192a((byte[]) obj3);
                                                i11 = ((Integer) a3.first).intValue();
                                                i15 = ((Integer) a3.second).intValue();
                                                i14 = i11;
                                            }
                                        } else {
                                            obj3 = obj2;
                                            str4 = str5;
                                        }
                                        j2 = i13 + i4;
                                        obj = obj3;
                                        z5 = z4;
                                        drmInitData4 = drmInitData5;
                                        i3 = i8;
                                    }
                                    i10 = -1;
                                    if (i9 == i10) {
                                        obj3 = obj2;
                                        str4 = str5;
                                    } else {
                                        a2 = m3799a(parsableByteArray2, i9);
                                        str4 = (String) a2.first;
                                        obj3 = (byte[]) a2.second;
                                        if (!"audio/mp4a-latm".equals(str4)) {
                                            a3 = CodecSpecificDataUtil.m4192a((byte[]) obj3);
                                            i11 = ((Integer) a3.first).intValue();
                                            i15 = ((Integer) a3.second).intValue();
                                            i14 = i11;
                                        }
                                    }
                                    j2 = i13 + i4;
                                    obj = obj3;
                                    z5 = z4;
                                    drmInitData4 = drmInitData5;
                                    i3 = i8;
                                }
                                obj2 = obj;
                                str5 = str4;
                                drmInitData5 = drmInitData4;
                                i8 = i3;
                                if (stsdData.f4386b == null) {
                                    str4 = str5;
                                    if (str4 != null) {
                                        i11 = "audio/raw".equals(str4) ? 2 : -1;
                                        str3 = Integer.toString(i);
                                        obj4 = obj2;
                                        if (obj4 != null) {
                                            list = null;
                                        } else {
                                            list = Collections.singletonList(obj4);
                                        }
                                        i18 = i12;
                                        z3 = false;
                                        stsdData2 = stsdData;
                                        stsdData2.f4386b = Format.m3557a(str3, str4, -1, -1, i15, i14, i11, list, drmInitData5, 0, str2);
                                        i5 = i8;
                                        i4 = i18;
                                        parsableByteArray2.m4249c(i4 + i5);
                                        i3 = i6 + 1;
                                        stsdData = stsdData2;
                                        z2 = z3;
                                    }
                                }
                                z3 = false;
                                i18 = i12;
                                stsdData2 = stsdData;
                                i5 = i8;
                                i4 = i18;
                                parsableByteArray2.m4249c(i4 + i5);
                                i3 = i6 + 1;
                                stsdData = stsdData2;
                                z2 = z3;
                            }
                            i4 = i12;
                            stsdData2 = stsdData;
                            i5 = i7;
                            z3 = false;
                            parsableByteArray2.m4249c(i4 + i5);
                            i3 = i6 + 1;
                            stsdData = stsdData2;
                            z2 = z3;
                        }
                    }
                    j2 = parsableByteArray.m4252e();
                    parsableByteArray2.m4251d(6);
                    byte[] bArr = parsableByteArray2.f5256a;
                    i3 = parsableByteArray2.f5257b;
                    parsableByteArray2.f5257b = i3 + 1;
                    i4 = (bArr[i3] & 255) << 8;
                    byte[] bArr2 = parsableByteArray2.f5256a;
                    i3 = parsableByteArray2.f5257b;
                    parsableByteArray2.f5257b = i3 + 1;
                    i4 |= bArr2[i3] & 255;
                    parsableByteArray2.f5257b += 2;
                    if (i11 == 1) {
                        parsableByteArray2.m4251d(16);
                    }
                    i13 = parsableByteArray2.f5257b;
                    if (j3 != Atom.aa) {
                        i3 = i7;
                        drmInitData4 = drmInitData2;
                    } else {
                        i3 = i7;
                        a = m3800a(parsableByteArray2, i12, i3);
                        if (a == null) {
                            drmInitData4 = drmInitData2;
                        } else {
                            j3 = ((Integer) a.first).intValue();
                            if (drmInitData2 != null) {
                                drmInitData4 = drmInitData2.m3725a(((TrackEncryptionBox) a.second).f4465b);
                            } else {
                                drmInitData4 = null;
                            }
                            stsdData.f4385a[i6] = (TrackEncryptionBox) a.second;
                        }
                        parsableByteArray2.m4249c(i13);
                    }
                    if (j3 == Atom.f4363n) {
                        str3 = "audio/ac3";
                    } else if (j3 == Atom.f4365p) {
                        str3 = "audio/eac3";
                    } else if (j3 != Atom.f4367r) {
                        if (j3 != Atom.f4368s) {
                            if (j3 == Atom.f4369t) {
                                if (j3 == Atom.f4370u) {
                                    str3 = "audio/vnd.dts.hd;profile=lbr";
                                } else if (j3 == Atom.ay) {
                                    str3 = "audio/3gpp";
                                } else if (j3 != Atom.az) {
                                    if (j3 != Atom.f4361l) {
                                        if (j3 == Atom.f4362m) {
                                            if (j3 != Atom.f4359j) {
                                                if (j3 != Atom.aO) {
                                                }
                                            }
                                        }
                                    }
                                    str3 = "audio/raw";
                                } else {
                                    str3 = "audio/amr-wb";
                                }
                            }
                        }
                        str3 = "audio/vnd.dts.hd";
                    } else {
                        str3 = "audio/vnd.dts";
                    }
                    str4 = str3;
                    i14 = i4;
                    i15 = j2;
                    obj = null;
                    j2 = i13;
                    while (j2 - i12 < i3) {
                        parsableByteArray2.m4249c(j2);
                        i13 = parsableByteArray.m4259j();
                        if (i13 <= 0) {
                        }
                        Assertions.m4185a(i13 <= 0 ? z5 : false, (Object) "childAtomSize should be positive");
                        j3 = parsableByteArray.m4259j();
                        if (j3 != Atom.f4333J) {
                            if (z) {
                            }
                            if (j3 == Atom.f4364o) {
                                parsableByteArray2.m4249c(8 + j2);
                                stsdData.f4386b = Ac3Util.m3643a(parsableByteArray2, Integer.toString(i), str2, drmInitData4);
                            } else if (j3 != Atom.f4366q) {
                                if (j3 != Atom.f4371v) {
                                    i16 = i13;
                                    obj2 = obj;
                                    str5 = str4;
                                    z4 = z5;
                                    drmInitData5 = drmInitData4;
                                    i17 = j2;
                                    i8 = i3;
                                    if (j3 == Atom.aO) {
                                        i4 = i16;
                                        obj3 = new byte[i4];
                                        i13 = i17;
                                        parsableByteArray2.m4249c(i13);
                                        parsableByteArray2.m4245a(obj3, 0, i4);
                                        str4 = str5;
                                        j2 = i13 + i4;
                                        obj = obj3;
                                        z5 = z4;
                                        drmInitData4 = drmInitData5;
                                        i3 = i8;
                                    }
                                } else {
                                    i16 = i13;
                                    obj2 = obj;
                                    str5 = str4;
                                    z4 = z5;
                                    drmInitData5 = drmInitData4;
                                    i17 = j2;
                                    i8 = i3;
                                    stsdData.f4386b = Format.m3558a(Integer.toString(i), str4, -1, -1, i15, i14, null, drmInitData5, str2);
                                }
                                i4 = i16;
                                i13 = i17;
                                obj3 = obj2;
                                str4 = str5;
                                j2 = i13 + i4;
                                obj = obj3;
                                z5 = z4;
                                drmInitData4 = drmInitData5;
                                i3 = i8;
                            } else {
                                parsableByteArray2.m4249c(8 + j2);
                                stsdData.f4386b = Ac3Util.m3645b(parsableByteArray2, Integer.toString(i), str2, drmInitData4);
                            }
                            i4 = i13;
                            obj2 = obj;
                            str5 = str4;
                            z4 = z5;
                            drmInitData5 = drmInitData4;
                            i13 = j2;
                            i8 = i3;
                            obj3 = obj2;
                            str4 = str5;
                            j2 = i13 + i4;
                            obj = obj3;
                            z5 = z4;
                            drmInitData4 = drmInitData5;
                            i3 = i8;
                        }
                        i4 = i13;
                        obj2 = obj;
                        str5 = str4;
                        z4 = z5;
                        drmInitData5 = drmInitData4;
                        i13 = j2;
                        i8 = i3;
                        if (j3 != Atom.f4333J) {
                            i9 = parsableByteArray2.f5257b;
                            while (i9 - i13 < i4) {
                                parsableByteArray2.m4249c(i9);
                                j3 = parsableByteArray.m4259j();
                                if (j3 <= 0) {
                                }
                                Assertions.m4185a(j3 <= 0 ? z4 : false, (Object) "childAtomSize should be positive");
                                if (parsableByteArray.m4259j() == Atom.f4333J) {
                                    i9 += j3;
                                }
                            }
                            i10 = -1;
                            i9 = -1;
                            if (i9 == i10) {
                                a2 = m3799a(parsableByteArray2, i9);
                                str4 = (String) a2.first;
                                obj3 = (byte[]) a2.second;
                                if (!"audio/mp4a-latm".equals(str4)) {
                                    a3 = CodecSpecificDataUtil.m4192a((byte[]) obj3);
                                    i11 = ((Integer) a3.first).intValue();
                                    i15 = ((Integer) a3.second).intValue();
                                    i14 = i11;
                                }
                            } else {
                                obj3 = obj2;
                                str4 = str5;
                            }
                            j2 = i13 + i4;
                            obj = obj3;
                            z5 = z4;
                            drmInitData4 = drmInitData5;
                            i3 = i8;
                        } else {
                            i9 = i13;
                        }
                        i10 = -1;
                        if (i9 == i10) {
                            obj3 = obj2;
                            str4 = str5;
                        } else {
                            a2 = m3799a(parsableByteArray2, i9);
                            str4 = (String) a2.first;
                            obj3 = (byte[]) a2.second;
                            if (!"audio/mp4a-latm".equals(str4)) {
                                a3 = CodecSpecificDataUtil.m4192a((byte[]) obj3);
                                i11 = ((Integer) a3.first).intValue();
                                i15 = ((Integer) a3.second).intValue();
                                i14 = i11;
                            }
                        }
                        j2 = i13 + i4;
                        obj = obj3;
                        z5 = z4;
                        drmInitData4 = drmInitData5;
                        i3 = i8;
                    }
                    obj2 = obj;
                    str5 = str4;
                    drmInitData5 = drmInitData4;
                    i8 = i3;
                    if (stsdData.f4386b == null) {
                        str4 = str5;
                        if (str4 != null) {
                            if ("audio/raw".equals(str4)) {
                            }
                            str3 = Integer.toString(i);
                            obj4 = obj2;
                            if (obj4 != null) {
                                list = Collections.singletonList(obj4);
                            } else {
                                list = null;
                            }
                            i18 = i12;
                            z3 = false;
                            stsdData2 = stsdData;
                            stsdData2.f4386b = Format.m3557a(str3, str4, -1, -1, i15, i14, i11, list, drmInitData5, 0, str2);
                            i5 = i8;
                            i4 = i18;
                            parsableByteArray2.m4249c(i4 + i5);
                            i3 = i6 + 1;
                            stsdData = stsdData2;
                            z2 = z3;
                        }
                    }
                    z3 = false;
                    i18 = i12;
                    stsdData2 = stsdData;
                    i5 = i8;
                    i4 = i18;
                    parsableByteArray2.m4249c(i4 + i5);
                    i3 = i6 + 1;
                    stsdData = stsdData2;
                    z2 = z3;
                }
            }
            i7 = 8;
            int i19 = 2;
            z4 = true;
            i8 = j2;
            i6 = i3;
            z3 = z2;
            stsdData2 = stsdData;
            i4 = i11;
            parsableByteArray2.m4249c((i4 + 8) + 8);
            parsableByteArray2.m4251d(16);
            int e = parsableByteArray.m4252e();
            int e2 = parsableByteArray.m4252e();
            parsableByteArray2.m4251d(50);
            i9 = parsableByteArray2.f5257b;
            if (j3 == Atom.f4349Z) {
                DrmInitData drmInitData6;
                i5 = i8;
                Pair a4 = m3800a(parsableByteArray2, i4, i5);
                if (a4 != null) {
                    j3 = ((Integer) a4.first).intValue();
                    if (drmInitData2 == null) {
                        drmInitData6 = null;
                    } else {
                        drmInitData6 = drmInitData2.m3725a(((TrackEncryptionBox) a4.second).f4465b);
                    }
                    stsdData2.f4385a[i6] = (TrackEncryptionBox) a4.second;
                } else {
                    drmInitData6 = drmInitData2;
                }
                parsableByteArray2.m4249c(i9);
                drmInitData3 = drmInitData6;
            } else {
                i5 = i8;
                drmInitData3 = drmInitData2;
            }
            float f = 1.0f;
            int i20 = -1;
            String str7 = null;
            List list2 = str7;
            byte[] bArr3 = list2;
            boolean z6 = z3;
            while (i9 - i4 < i5) {
                parsableByteArray2.m4249c(i9);
                i10 = parsableByteArray2.f5257b;
                i11 = parsableByteArray.m4259j();
                if (i11 == 0 && parsableByteArray2.f5257b - i4 == i5) {
                    if (str7 != null) {
                        stsdData2.f4386b = Format.m3559a(Integer.toString(i), str7, -1, e, e2, list2, i2, f, bArr3, i20, null, drmInitData3);
                    }
                    parsableByteArray2.m4249c(i4 + i5);
                    i3 = i6 + 1;
                    stsdData = stsdData2;
                    z2 = z3;
                } else {
                    String str8;
                    List list3;
                    Assertions.m4185a(i11 > 0 ? z4 : z3, (Object) "childAtomSize should be positive");
                    j2 = parsableByteArray.m4259j();
                    if (j2 == Atom.f4331H) {
                        Assertions.m4186b(str7 == null ? z4 : z3);
                        str8 = "video/avc";
                        parsableByteArray2.m4249c(i10 + 8);
                        AvcConfig a5 = AvcConfig.m4334a(parsableByteArray);
                        list3 = a5.f5292a;
                        stsdData2.f4387c = a5.f5293b;
                        if (!z6) {
                            f = a5.f5296e;
                        }
                    } else if (j2 == Atom.f4332I) {
                        Assertions.m4186b(str7 == null ? z4 : z3);
                        str8 = "video/hevc";
                        parsableByteArray2.m4249c(i10 + 8);
                        HevcConfig a6 = HevcConfig.m4339a(parsableByteArray);
                        list3 = a6.f5316a;
                        stsdData2.f4387c = a6.f5317b;
                    } else {
                        String str9;
                        if (j2 == Atom.aM) {
                            Assertions.m4186b(str7 == null ? z4 : z3);
                            str9 = j3 == Atom.aK ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        } else if (j2 == Atom.f4356g) {
                            Assertions.m4186b(str7 == null ? z4 : z3);
                            str9 = "video/3gpp";
                        } else {
                            if (j2 == Atom.f4333J) {
                                Assertions.m4186b(str7 == null ? z4 : z3);
                                Pair a7 = m3799a(parsableByteArray2, i10);
                                str8 = (String) a7.first;
                                list2 = Collections.singletonList(a7.second);
                                str7 = str8;
                            } else if (j2 == Atom.ai) {
                                parsableByteArray2.m4249c(i10 + 8);
                                f = ((float) parsableByteArray.m4263n()) / ((float) parsableByteArray.m4263n());
                                z6 = z4;
                            } else if (j2 == Atom.aI) {
                                byte[] copyOfRange;
                                j2 = i10 + 8;
                                while (j2 - i10 < i11) {
                                    parsableByteArray2.m4249c(j2);
                                    i3 = parsableByteArray.m4259j();
                                    if (parsableByteArray.m4259j() == Atom.aJ) {
                                        copyOfRange = Arrays.copyOfRange(parsableByteArray2.f5256a, j2, i3 + j2);
                                        bArr3 = copyOfRange;
                                    } else {
                                        j2 += i3;
                                    }
                                }
                                copyOfRange = null;
                                bArr3 = copyOfRange;
                            } else if (j2 == Atom.aH) {
                                i10 = parsableByteArray.m4250d();
                                parsableByteArray2.m4251d(3);
                                if (i10 == 0) {
                                    switch (parsableByteArray.m4250d()) {
                                        case 0:
                                            i20 = z3;
                                            break;
                                        case 1:
                                            i20 = z4;
                                            break;
                                        case 2:
                                            i20 = i19;
                                            break;
                                        case 3:
                                            i20 = 3;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            i9 += i11;
                        }
                        str7 = str9;
                        i9 += i11;
                    }
                    str7 = str8;
                    list2 = list3;
                    i9 += i11;
                }
            }
            if (str7 != null) {
                stsdData2.f4386b = Format.m3559a(Integer.toString(i), str7, -1, e, e2, list2, i2, f, bArr3, i20, null, drmInitData3);
            }
            parsableByteArray2.m4249c(i4 + i5);
            i3 = i6 + 1;
            stsdData = stsdData2;
            z2 = z3;
        }
        return stsdData;
    }

    private static Pair<long[], long[]> m3798a(ContainerAtom containerAtom) {
        if (containerAtom != null) {
            containerAtom = containerAtom.m12082d(Atom.f4340Q);
            if (containerAtom != null) {
                containerAtom = containerAtom.aQ;
                containerAtom.m4249c(8);
                int a = Atom.m3787a(containerAtom.m4259j());
                int n = containerAtom.m4263n();
                Object obj = new long[n];
                Object obj2 = new long[n];
                for (int i = 0; i < n; i++) {
                    long l;
                    obj[i] = a == 1 ? containerAtom.m4265p() : containerAtom.m4257h();
                    if (a == 1) {
                        l = containerAtom.m4261l();
                    } else {
                        l = (long) containerAtom.m4259j();
                    }
                    obj2[i] = l;
                    byte[] bArr = containerAtom.f5256a;
                    int i2 = containerAtom.f5257b;
                    containerAtom.f5257b = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = containerAtom.f5256a;
                    int i4 = containerAtom.f5257b;
                    containerAtom.f5257b = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    containerAtom.m4251d(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static Pair<String, byte[]> m3799a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m4249c((i + 8) + 4);
        parsableByteArray.m4251d(1);
        m3797a(parsableByteArray);
        parsableByteArray.m4251d(2);
        int d = parsableByteArray.m4250d();
        if ((d & 128) != 0) {
            parsableByteArray.m4251d(2);
        }
        if ((d & 64) != 0) {
            parsableByteArray.m4251d(parsableByteArray.m4252e());
        }
        if ((d & 32) != 0) {
            parsableByteArray.m4251d(2);
        }
        parsableByteArray.m4251d(1);
        m3797a(parsableByteArray);
        Object obj = null;
        switch (parsableByteArray.m4250d()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 96:
            case 97:
                obj = "video/mpeg2";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
            default:
                break;
        }
        parsableByteArray.m4251d(12);
        parsableByteArray.m4251d(1);
        i = m3797a(parsableByteArray);
        Object obj2 = new byte[i];
        parsableByteArray.m4245a(obj2, 0, i);
        return Pair.create(obj, obj2);
    }

    private static int m3797a(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4250d();
        int i = d & 127;
        while ((d & 128) == 128) {
            d = parsableByteArray.m4250d();
            i = (i << 7) | (d & 127);
        }
        return i;
    }

    private static Pair<Integer, TrackEncryptionBox> m3800a(ParsableByteArray parsableByteArray, int i, int i2) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i3 = parsableByteArray2.f5257b;
        while (i3 - i < i2) {
            parsableByteArray2.m4249c(i3);
            int j = parsableByteArray.m4259j();
            boolean z = true;
            Assertions.m4185a(j > 0, (Object) "childAtomSize should be positive");
            if (parsableByteArray.m4259j() == Atom.f4345V) {
                int j2;
                int j3;
                Pair<Integer, TrackEncryptionBox> create;
                int i4 = i3 + 8;
                int i5 = -1;
                int i6 = 0;
                String str = null;
                Integer num = null;
                while (i4 - i3 < j) {
                    parsableByteArray2.m4249c(i4);
                    j2 = parsableByteArray.m4259j();
                    j3 = parsableByteArray.m4259j();
                    if (j3 == Atom.ab) {
                        num = Integer.valueOf(parsableByteArray.m4259j());
                    } else if (j3 == Atom.f4346W) {
                        parsableByteArray2.m4251d(4);
                        str = parsableByteArray2.m4253e(4);
                    } else if (j3 == Atom.f4347X) {
                        i5 = i4;
                        i6 = j2;
                    }
                    i4 += j2;
                }
                if (str != null) {
                    boolean z2;
                    Object obj;
                    Assertions.m4185a(num != null, (Object) "frma atom is mandatory");
                    Assertions.m4185a(i5 != -1, (Object) "schi atom is mandatory");
                    j3 = i5 + 8;
                    while (j3 - i5 < i6) {
                        parsableByteArray2.m4249c(j3);
                        int j4 = parsableByteArray.m4259j();
                        if (parsableByteArray.m4259j() == Atom.f4348Y) {
                            int i7;
                            byte[] bArr;
                            j3 = Atom.m3787a(parsableByteArray.m4259j());
                            parsableByteArray2.m4251d(1);
                            if (j3 == 0) {
                                parsableByteArray2.m4251d(1);
                                j4 = 0;
                                i7 = 0;
                            } else {
                                j3 = parsableByteArray.m4250d();
                                j4 = (j3 & 240) >> 4;
                                i7 = j3 & 15;
                            }
                            boolean z3 = parsableByteArray.m4250d() == 1;
                            j2 = parsableByteArray.m4250d();
                            byte[] bArr2 = new byte[16];
                            z2 = false;
                            parsableByteArray2.m4245a(bArr2, 0, 16);
                            if (z3 && j2 == 0) {
                                j3 = parsableByteArray.m4250d();
                                byte[] bArr3 = new byte[j3];
                                parsableByteArray2.m4245a(bArr3, 0, j3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            obj = num;
                            TrackEncryptionBox trackEncryptionBox = new TrackEncryptionBox(z3, str, j2, bArr2, j4, i7, bArr);
                            if (r4 != null) {
                                z = z2;
                            }
                            Assertions.m4185a(z, (Object) "tenc atom is mandatory");
                            create = Pair.create(obj, r4);
                        } else {
                            Integer num2 = num;
                            j3 += j4;
                        }
                    }
                    obj = num;
                    z2 = false;
                    Object obj2 = null;
                    if (obj2 != null) {
                        z = z2;
                    }
                    Assertions.m4185a(z, (Object) "tenc atom is mandatory");
                    create = Pair.create(obj, obj2);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i3 += j;
        }
        return null;
    }
}
