package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory f12984a = new C11321();
    private static final int f12985b = Util.m4326g("qt  ");
    private final ParsableByteArray f12986c = new ParsableByteArray(NalUnitUtil.f5248a);
    private final ParsableByteArray f12987d = new ParsableByteArray(4);
    private final ParsableByteArray f12988e = new ParsableByteArray(16);
    private final Stack<ContainerAtom> f12989f = new Stack();
    private int f12990g;
    private int f12991h;
    private long f12992i;
    private int f12993j;
    private ParsableByteArray f12994k;
    private int f12995l;
    private int f12996m;
    private ExtractorOutput f12997n;
    private Mp4Track[] f12998o;
    private long f12999p;
    private boolean f13000q;

    private static final class Mp4Track {
        public final Track f4448a;
        public final TrackSampleTable f4449b;
        public final TrackOutput f4450c;
        public int f4451d;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f4448a = track;
            this.f4449b = trackSampleTable;
            this.f4450c = trackOutput;
        }
    }

    static class C11321 implements ExtractorsFactory {
        C11321() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new Mp4Extractor()};
        }
    }

    public final boolean a_() {
        return true;
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.m3818b(extractorInput);
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f12997n = extractorOutput;
    }

    public final void mo1351a(long j, long j2) {
        this.f12989f.clear();
        int i = 0;
        this.f12993j = 0;
        this.f12995l = 0;
        this.f12996m = 0;
        if (j == 0) {
            m12103c();
            return;
        }
        if (this.f12998o != null) {
            j = this.f12998o;
            int length = j.length;
            while (i < length) {
                Mp4Track mp4Track = j[i];
                TrackSampleTable trackSampleTable = mp4Track.f4449b;
                int a = trackSampleTable.m3822a(j2);
                if (a == -1) {
                    a = trackSampleTable.m3823b(j2);
                }
                mp4Track.f4451d = a;
                i++;
            }
        }
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        Mp4Extractor mp4Extractor = this;
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        while (true) {
            boolean z;
            int i;
            long d;
            int i2;
            Object obj;
            switch (mp4Extractor.f12990g) {
                case 0:
                    z = true;
                    if (mp4Extractor.f12993j == 0) {
                        i = 0;
                        if (!extractorInput2.mo1333a(mp4Extractor.f12988e.f5256a, 0, 8, z)) {
                            if (i == 0) {
                                break;
                            }
                            return -1;
                        }
                        mp4Extractor.f12993j = 8;
                        mp4Extractor.f12988e.m4249c(0);
                        mp4Extractor.f12992i = mp4Extractor.f12988e.m4257h();
                        mp4Extractor.f12991h = mp4Extractor.f12988e.m4259j();
                    }
                    if (mp4Extractor.f12992i == 1) {
                        extractorInput2.mo1336b(mp4Extractor.f12988e.f5256a, 8, 8);
                        mp4Extractor.f12993j += 8;
                        mp4Extractor.f12992i = mp4Extractor.f12988e.m4265p();
                    } else if (mp4Extractor.f12992i == 0) {
                        d = extractorInput.mo1341d();
                        if (d == -1 && !mp4Extractor.f12989f.isEmpty()) {
                            d = ((ContainerAtom) mp4Extractor.f12989f.peek()).aQ;
                        }
                        if (d != -1) {
                            mp4Extractor.f12992i = (d - extractorInput.mo1338c()) + ((long) mp4Extractor.f12993j);
                        }
                    }
                    if (mp4Extractor.f12992i < ((long) mp4Extractor.f12993j)) {
                        throw new ParserException("Atom size less than header length (unsupported).");
                    }
                    i2 = mp4Extractor.f12991h;
                    if (!(i2 == Atom.f4325B || i2 == Atom.f4327D || i2 == Atom.f4328E || i2 == Atom.f4329F || i2 == Atom.f4330G)) {
                        if (i2 != Atom.f4339P) {
                            obj = null;
                            if (obj == null) {
                                d = (extractorInput.mo1338c() + mp4Extractor.f12992i) - ((long) mp4Extractor.f12993j);
                                mp4Extractor.f12989f.add(new ContainerAtom(mp4Extractor.f12991h, d));
                                if (mp4Extractor.f12992i != ((long) mp4Extractor.f12993j)) {
                                    m12102a(d);
                                } else {
                                    m12103c();
                                }
                                i = 1;
                            } else {
                                i2 = mp4Extractor.f12991h;
                                if (!(i2 == Atom.f4341R || i2 == Atom.f4326C || i2 == Atom.f4342S || i2 == Atom.f4343T || i2 == Atom.am || i2 == Atom.an || i2 == Atom.ao || i2 == Atom.f4340Q || i2 == Atom.ap || i2 == Atom.aq || i2 == Atom.ar || i2 == Atom.as || i2 == Atom.at || i2 == Atom.f4338O || i2 == Atom.f4350a)) {
                                    if (i2 == Atom.aA) {
                                        obj = null;
                                        if (obj == null) {
                                            Assertions.m4186b(mp4Extractor.f12993j != 8);
                                            Assertions.m4186b(mp4Extractor.f12992i > 2147483647L);
                                            mp4Extractor.f12994k = new ParsableByteArray((int) mp4Extractor.f12992i);
                                            System.arraycopy(mp4Extractor.f12988e.f5256a, 0, mp4Extractor.f12994k.f5256a, 0, 8);
                                            i = 1;
                                            mp4Extractor.f12990g = 1;
                                        } else {
                                            i = 1;
                                            mp4Extractor.f12994k = null;
                                            mp4Extractor.f12990g = 1;
                                        }
                                    }
                                }
                                obj = 1;
                                if (obj == null) {
                                    i = 1;
                                    mp4Extractor.f12994k = null;
                                    mp4Extractor.f12990g = 1;
                                } else {
                                    if (mp4Extractor.f12993j != 8) {
                                    }
                                    Assertions.m4186b(mp4Extractor.f12993j != 8);
                                    if (mp4Extractor.f12992i > 2147483647L) {
                                    }
                                    Assertions.m4186b(mp4Extractor.f12992i > 2147483647L);
                                    mp4Extractor.f12994k = new ParsableByteArray((int) mp4Extractor.f12992i);
                                    System.arraycopy(mp4Extractor.f12988e.f5256a, 0, mp4Extractor.f12994k.f5256a, 0, 8);
                                    i = 1;
                                    mp4Extractor.f12990g = 1;
                                }
                            }
                            if (i == 0) {
                                return -1;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        i2 = mp4Extractor.f12991h;
                        if (i2 == Atom.aA) {
                            obj = null;
                            if (obj == null) {
                                if (mp4Extractor.f12993j != 8) {
                                }
                                Assertions.m4186b(mp4Extractor.f12993j != 8);
                                if (mp4Extractor.f12992i > 2147483647L) {
                                }
                                Assertions.m4186b(mp4Extractor.f12992i > 2147483647L);
                                mp4Extractor.f12994k = new ParsableByteArray((int) mp4Extractor.f12992i);
                                System.arraycopy(mp4Extractor.f12988e.f5256a, 0, mp4Extractor.f12994k.f5256a, 0, 8);
                                i = 1;
                                mp4Extractor.f12990g = 1;
                            } else {
                                i = 1;
                                mp4Extractor.f12994k = null;
                                mp4Extractor.f12990g = 1;
                            }
                        } else {
                            obj = 1;
                            if (obj == null) {
                                i = 1;
                                mp4Extractor.f12994k = null;
                                mp4Extractor.f12990g = 1;
                            } else {
                                if (mp4Extractor.f12993j != 8) {
                                }
                                Assertions.m4186b(mp4Extractor.f12993j != 8);
                                if (mp4Extractor.f12992i > 2147483647L) {
                                }
                                Assertions.m4186b(mp4Extractor.f12992i > 2147483647L);
                                mp4Extractor.f12994k = new ParsableByteArray((int) mp4Extractor.f12992i);
                                System.arraycopy(mp4Extractor.f12988e.f5256a, 0, mp4Extractor.f12994k.f5256a, 0, 8);
                                i = 1;
                                mp4Extractor.f12990g = 1;
                            }
                        }
                        break;
                    }
                    d = (extractorInput.mo1338c() + mp4Extractor.f12992i) - ((long) mp4Extractor.f12993j);
                    mp4Extractor.f12989f.add(new ContainerAtom(mp4Extractor.f12991h, d));
                    if (mp4Extractor.f12992i != ((long) mp4Extractor.f12993j)) {
                        m12103c();
                    } else {
                        m12102a(d);
                    }
                    i = 1;
                    if (i == 0) {
                        return -1;
                    }
                case 1:
                    Object obj2;
                    d = mp4Extractor.f12992i - ((long) mp4Extractor.f12993j);
                    long c = extractorInput.mo1338c() + d;
                    if (mp4Extractor.f12994k == null) {
                        if (d >= 262144) {
                            positionHolder2.f4268a = extractorInput.mo1338c() + d;
                            obj = 1;
                            m12102a(c);
                            obj2 = (obj != null || mp4Extractor.f12990g == 2) ? null : 1;
                            if (obj2 == null) {
                                break;
                            }
                            return 1;
                        }
                        extractorInput2.mo1335b((int) d);
                    } else {
                        extractorInput2.mo1336b(mp4Extractor.f12994k.f5256a, mp4Extractor.f12993j, (int) d);
                        if (mp4Extractor.f12991h == Atom.f4350a) {
                            ParsableByteArray parsableByteArray = mp4Extractor.f12994k;
                            parsableByteArray.m4249c(8);
                            if (parsableByteArray.m4259j() != f12985b) {
                                parsableByteArray.m4251d(4);
                                while (parsableByteArray.m4246b() > 0) {
                                    if (parsableByteArray.m4259j() == f12985b) {
                                    }
                                }
                                z = false;
                                mp4Extractor.f13000q = z;
                            }
                            z = true;
                            mp4Extractor.f13000q = z;
                        } else if (!mp4Extractor.f12989f.isEmpty()) {
                            ((ContainerAtom) mp4Extractor.f12989f.peek()).m12081a(new LeafAtom(mp4Extractor.f12991h, mp4Extractor.f12994k));
                        }
                    }
                    obj = null;
                    m12102a(c);
                    if (obj != null) {
                        break;
                    }
                    if (obj2 == null) {
                        return 1;
                    }
                case 2:
                    int i3;
                    long j = Long.MAX_VALUE;
                    int i4 = -1;
                    for (i2 = 0; i2 < mp4Extractor.f12998o.length; i2++) {
                        Mp4Track mp4Track = mp4Extractor.f12998o[i2];
                        i3 = mp4Track.f4451d;
                        if (i3 != mp4Track.f4449b.f4488a) {
                            long j2 = mp4Track.f4449b.f4489b[i3];
                            if (j2 < j) {
                                i4 = i2;
                                j = j2;
                            }
                        }
                    }
                    if (i4 == -1) {
                        return -1;
                    }
                    Mp4Track mp4Track2 = mp4Extractor.f12998o[i4];
                    TrackOutput trackOutput = mp4Track2.f4450c;
                    int i5 = mp4Track2.f4451d;
                    long j3 = mp4Track2.f4449b.f4489b[i5];
                    int i6 = mp4Track2.f4449b.f4490c[i5];
                    if (mp4Track2.f4448a.f4459g == 1) {
                        j3 += 8;
                        i6 -= 8;
                    }
                    long j4 = j3;
                    long c2 = (j3 - extractorInput.mo1338c()) + ((long) mp4Extractor.f12995l);
                    if (c2 < 0) {
                        i3 = 1;
                        j3 = j4;
                    } else if (c2 >= 262144) {
                        j3 = j4;
                        i3 = 1;
                    } else {
                        extractorInput2.mo1335b((int) c2);
                        int i7;
                        if (mp4Track2.f4448a.f4462j != 0) {
                            byte[] bArr = mp4Extractor.f12987d.f5256a;
                            bArr[0] = (byte) 0;
                            bArr[1] = (byte) 0;
                            bArr[2] = (byte) 0;
                            i7 = mp4Track2.f4448a.f4462j;
                            i = 4 - mp4Track2.f4448a.f4462j;
                            while (mp4Extractor.f12995l < i6) {
                                if (mp4Extractor.f12996m == 0) {
                                    extractorInput2.mo1336b(mp4Extractor.f12987d.f5256a, i, i7);
                                    mp4Extractor.f12987d.m4249c(0);
                                    mp4Extractor.f12996m = mp4Extractor.f12987d.m4263n();
                                    mp4Extractor.f12986c.m4249c(0);
                                    trackOutput.mo1346a(mp4Extractor.f12986c, 4);
                                    mp4Extractor.f12995l += 4;
                                    i6 += i;
                                } else {
                                    int a = trackOutput.mo1343a(extractorInput2, mp4Extractor.f12996m, false);
                                    mp4Extractor.f12995l += a;
                                    mp4Extractor.f12996m -= a;
                                }
                            }
                        } else {
                            while (mp4Extractor.f12995l < i6) {
                                i7 = trackOutput.mo1343a(extractorInput2, i6 - mp4Extractor.f12995l, false);
                                mp4Extractor.f12995l += i7;
                                mp4Extractor.f12996m -= i7;
                            }
                        }
                        trackOutput.mo1344a(mp4Track2.f4449b.f4492e[i5], mp4Track2.f4449b.f4493f[i5], i6, 0, null);
                        mp4Track2.f4451d++;
                        mp4Extractor.f12995l = 0;
                        mp4Extractor.f12996m = 0;
                        return 0;
                    }
                    positionHolder2.f4268a = j3;
                    return i3;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public final long mo1328b() {
        return this.f12999p;
    }

    public final long mo1329b(long j) {
        long j2 = Long.MAX_VALUE;
        for (Mp4Track mp4Track : this.f12998o) {
            TrackSampleTable trackSampleTable = mp4Track.f4449b;
            int a = trackSampleTable.m3822a(j);
            if (a == -1) {
                a = trackSampleTable.m3823b(j);
            }
            long j3 = trackSampleTable.f4489b[a];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private void m12103c() {
        this.f12990g = 0;
        this.f12993j = 0;
    }

    private void m12102a(long j) throws ParserException {
        Mp4Extractor mp4Extractor = this;
        while (!mp4Extractor.f12989f.isEmpty() && ((ContainerAtom) mp4Extractor.f12989f.peek()).aQ == j) {
            ContainerAtom containerAtom = (ContainerAtom) mp4Extractor.f12989f.pop();
            ContainerAtom containerAtom2;
            if (containerAtom.aP == Atom.f4325B) {
                ArrayList arrayList = new ArrayList();
                Metadata metadata = null;
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                LeafAtom d = containerAtom.m12082d(Atom.aA);
                if (d != null) {
                    metadata = AtomParsers.m3804a(d, mp4Extractor.f13000q);
                    if (metadata != null) {
                        gaplessInfoHolder.m3753a(metadata);
                    }
                }
                long j2 = -9223372036854775807L;
                int i = 0;
                while (i < containerAtom.aS.size()) {
                    int i2;
                    Metadata metadata2;
                    GaplessInfoHolder gaplessInfoHolder2;
                    List list;
                    List list2;
                    ContainerAtom containerAtom3 = (ContainerAtom) containerAtom.aS.get(i);
                    if (containerAtom3.aP == Atom.f4327D) {
                        Track a = AtomParsers.m3802a(containerAtom3, containerAtom.m12082d(Atom.f4326C), -9223372036854775807L, null, mp4Extractor.f13000q);
                        if (a != null) {
                            TrackSampleTable a2 = AtomParsers.m3803a(a, containerAtom3.m12083e(Atom.f4328E).m12083e(Atom.f4329F).m12083e(Atom.f4330G), gaplessInfoHolder);
                            if (a2.f4488a != 0) {
                                Format format;
                                Mp4Track mp4Track;
                                Track track;
                                long j3;
                                Mp4Track mp4Track2 = new Mp4Track(a, a2, mp4Extractor.f12997n.mo1415a(i, a.f4454b));
                                int i3 = a2.f4491d + 30;
                                Format format2 = a.f4458f;
                                String str = format2.f4013a;
                                String str2 = format2.f4017e;
                                String str3 = format2.f4018f;
                                String str4 = format2.f4015c;
                                Mp4Track mp4Track3 = mp4Track2;
                                int i4 = format2.f4014b;
                                long j4 = j2;
                                int i5 = format2.f4022j;
                                int i6 = format2.f4023k;
                                containerAtom2 = containerAtom;
                                float f = format2.f4024l;
                                int i7 = format2.f4025m;
                                i2 = i;
                                float f2 = format2.f4026n;
                                ArrayList arrayList2 = arrayList;
                                byte[] bArr = format2.f4028p;
                                metadata2 = metadata;
                                int i8 = format2.f4027o;
                                GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                                ColorInfo colorInfo = format2.f4029q;
                                Track track2 = a;
                                int i9 = i8;
                                ColorInfo colorInfo2 = colorInfo;
                                Format format3 = new Format(str, str2, str3, str4, i4, i3, i5, i6, f, i7, f2, bArr, i9, colorInfo2, format2.f4030r, format2.f4031s, format2.f4032t, format2.f4033u, format2.f4034v, format2.f4036x, format2.f4037y, format2.f4038z, format2.f4035w, format2.f4020h, format2.f4021i, format2.f4016d);
                                Track track3 = track2;
                                if (track3.f4454b == 1) {
                                    int i10;
                                    String str5;
                                    String str6;
                                    String str7;
                                    int i11;
                                    Track track4;
                                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder3;
                                    if (gaplessInfoHolder4.m3752a()) {
                                        i10 = gaplessInfoHolder4.f4252b;
                                        i = gaplessInfoHolder4.f4253c;
                                        str5 = format3.f4013a;
                                        str6 = format3.f4017e;
                                        str7 = format3.f4018f;
                                        String str8 = format3.f4015c;
                                        i11 = format3.f4014b;
                                        int i12 = format3.f4019g;
                                        int i13 = format3.f4022j;
                                        i8 = format3.f4023k;
                                        float f3 = format3.f4024l;
                                        int i14 = format3.f4025m;
                                        track4 = track3;
                                        float f4 = format3.f4026n;
                                        gaplessInfoHolder2 = gaplessInfoHolder4;
                                        byte[] bArr2 = format3.f4028p;
                                        int i15 = i;
                                        i = format3.f4027o;
                                        int i16 = i10;
                                        ColorInfo colorInfo3 = format3.f4029q;
                                        int i17 = format3.f4030r;
                                        int i18 = format3.f4031s;
                                        int i19 = format3.f4032t;
                                        int i20 = format3.f4036x;
                                        String str9 = format3.f4037y;
                                        int i21 = format3.f4038z;
                                        int i22 = i;
                                        long j5 = format3.f4035w;
                                        List list3 = format3.f4020h;
                                        DrmInitData drmInitData = format3.f4021i;
                                        Metadata metadata3 = format3.f4016d;
                                        format = new Format(str5, str6, str7, str8, i11, i12, i13, i8, f3, i14, f4, bArr2, i22, colorInfo3, i17, i18, i19, i16, i15, i20, str9, i21, j5, list3, drmInitData, metadata3);
                                    } else {
                                        track4 = track3;
                                        gaplessInfoHolder2 = gaplessInfoHolder4;
                                    }
                                    if (metadata2 != null) {
                                        str = format.f4013a;
                                        str5 = format.f4017e;
                                        str6 = format.f4018f;
                                        str7 = format.f4015c;
                                        i6 = format.f4014b;
                                        int i23 = format.f4019g;
                                        i10 = format.f4022j;
                                        i = format.f4023k;
                                        float f5 = format.f4024l;
                                        i11 = format.f4025m;
                                        float f6 = format.f4026n;
                                        bArr = format.f4028p;
                                        i8 = format.f4027o;
                                        int i24 = i8;
                                        Format format4 = format;
                                        mp4Track = mp4Track3;
                                        track = track4;
                                        j3 = j4;
                                        format = new Format(str, str5, str6, str7, i6, i23, i10, i, f5, i11, f6, bArr, i24, format.f4029q, format.f4030r, format.f4031s, format.f4032t, format.f4033u, format.f4034v, format.f4036x, format.f4037y, format.f4038z, format.f4035w, format.f4020h, format.f4021i, metadata2);
                                        format = format4;
                                    } else {
                                        mp4Track = mp4Track3;
                                        j3 = j4;
                                        track = track4;
                                    }
                                } else {
                                    track = track3;
                                    mp4Track = mp4Track3;
                                    j3 = j4;
                                    gaplessInfoHolder2 = gaplessInfoHolder3;
                                }
                                mp4Track.f4450c.mo1345a(format);
                                long max = Math.max(j3, track.f4457e);
                                list = arrayList2;
                                list.add(mp4Track);
                                j2 = max;
                                i = i2 + 1;
                                list2 = list;
                                containerAtom = containerAtom2;
                                metadata = metadata2;
                                gaplessInfoHolder = gaplessInfoHolder2;
                                mp4Extractor = this;
                            }
                        }
                    }
                    containerAtom2 = containerAtom;
                    i2 = i;
                    list = arrayList;
                    metadata2 = metadata;
                    gaplessInfoHolder2 = gaplessInfoHolder;
                    j2 = j2;
                    i = i2 + 1;
                    list2 = list;
                    containerAtom = containerAtom2;
                    metadata = metadata2;
                    gaplessInfoHolder = gaplessInfoHolder2;
                    mp4Extractor = this;
                }
                ArrayList arrayList3 = arrayList;
                mp4Extractor.f12999p = j2;
                mp4Extractor.f12998o = (Mp4Track[]) arrayList3.toArray(new Mp4Track[arrayList3.size()]);
                mp4Extractor.f12997n.mo1416a();
                mp4Extractor.f12997n.mo1417a(mp4Extractor);
                mp4Extractor.f12989f.clear();
                mp4Extractor.f12990g = 2;
            } else {
                containerAtom2 = containerAtom;
                if (!mp4Extractor.f12989f.isEmpty()) {
                    ((ContainerAtom) mp4Extractor.f12989f.peek()).m12080a(containerAtom2);
                }
            }
        }
        if (mp4Extractor.f12990g != 2) {
            m12103c();
        }
    }
}
