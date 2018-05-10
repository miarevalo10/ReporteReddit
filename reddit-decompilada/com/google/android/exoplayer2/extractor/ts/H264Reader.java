package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.NalUnitUtil.PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class H264Reader implements ElementaryStreamReader {
    private final SeiReader f13117a;
    private final boolean f13118b;
    private final boolean f13119c;
    private final NalUnitTargetBuffer f13120d = new NalUnitTargetBuffer(true);
    private final NalUnitTargetBuffer f13121e = new NalUnitTargetBuffer(true);
    private final NalUnitTargetBuffer f13122f = new NalUnitTargetBuffer(true);
    private long f13123g;
    private final boolean[] f13124h = new boolean[3];
    private String f13125i;
    private TrackOutput f13126j;
    private SampleReader f13127k;
    private boolean f13128l;
    private long f13129m;
    private final ParsableByteArray f13130n = new ParsableByteArray();

    private static final class SampleReader {
        final TrackOutput f4578a;
        final boolean f4579b;
        final boolean f4580c;
        final SparseArray<SpsData> f4581d = new SparseArray();
        final SparseArray<PpsData> f4582e = new SparseArray();
        final ParsableNalUnitBitArray f4583f = new ParsableNalUnitBitArray(this.f4584g, 0, 0);
        byte[] f4584g = new byte[128];
        int f4585h;
        int f4586i;
        long f4587j;
        boolean f4588k;
        long f4589l;
        SliceHeaderData f4590m = new SliceHeaderData();
        SliceHeaderData f4591n = new SliceHeaderData();
        boolean f4592o;
        long f4593p;
        long f4594q;
        boolean f4595r;

        private static final class SliceHeaderData {
            boolean f4562a;
            boolean f4563b;
            SpsData f4564c;
            int f4565d;
            int f4566e;
            int f4567f;
            int f4568g;
            boolean f4569h;
            boolean f4570i;
            boolean f4571j;
            boolean f4572k;
            int f4573l;
            int f4574m;
            int f4575n;
            int f4576o;
            int f4577p;

            private SliceHeaderData() {
            }

            public final void m3860a() {
                this.f4563b = false;
                this.f4562a = false;
            }

            static /* synthetic */ boolean m3859a(SliceHeaderData sliceHeaderData, SliceHeaderData sliceHeaderData2) {
                return (!sliceHeaderData.f4562a || (sliceHeaderData2.f4562a && sliceHeaderData.f4567f == sliceHeaderData2.f4567f && sliceHeaderData.f4568g == sliceHeaderData2.f4568g && sliceHeaderData.f4569h == sliceHeaderData2.f4569h && (!(sliceHeaderData.f4570i && sliceHeaderData2.f4570i && sliceHeaderData.f4571j != sliceHeaderData2.f4571j) && ((sliceHeaderData.f4565d == sliceHeaderData2.f4565d || !(sliceHeaderData.f4565d == 0 || sliceHeaderData2.f4565d == 0)) && !((sliceHeaderData.f4564c.f5245h == 0 && sliceHeaderData2.f4564c.f5245h == 0 && (sliceHeaderData.f4574m != sliceHeaderData2.f4574m || sliceHeaderData.f4575n != sliceHeaderData2.f4575n)) || ((sliceHeaderData.f4564c.f5245h == 1 && sliceHeaderData2.f4564c.f5245h == 1 && (sliceHeaderData.f4576o != sliceHeaderData2.f4576o || sliceHeaderData.f4577p != sliceHeaderData2.f4577p)) || sliceHeaderData.f4572k != sliceHeaderData2.f4572k || (sliceHeaderData.f4572k && sliceHeaderData2.f4572k && sliceHeaderData.f4573l != sliceHeaderData2.f4573l))))))) ? null : true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f4578a = trackOutput;
            this.f4579b = z;
            this.f4580c = z2;
            m3861a();
        }

        public final void m3863a(SpsData spsData) {
            this.f4581d.append(spsData.f5238a, spsData);
        }

        public final void m3862a(PpsData ppsData) {
            this.f4582e.append(ppsData.f5235a, ppsData);
        }

        public final void m3861a() {
            this.f4588k = false;
            this.f4592o = false;
            this.f4591n.m3860a();
        }
    }

    public final void mo1380b() {
    }

    public H264Reader(SeiReader seiReader, boolean z, boolean z2) {
        this.f13117a = seiReader;
        this.f13118b = z;
        this.f13119c = z2;
    }

    public final void mo1376a() {
        NalUnitUtil.m4225a(this.f13124h);
        this.f13120d.m3865a();
        this.f13121e.m3865a();
        this.f13122f.m3865a();
        this.f13127k.m3861a();
        this.f13123g = 0;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13125i = trackIdGenerator.m3878c();
        this.f13126j = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 2);
        this.f13127k = new SampleReader(this.f13126j, this.f13118b, this.f13119c);
        this.f13117a.m3872a(extractorOutput, trackIdGenerator);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13129m = j;
    }

    private void m12199a(byte[] bArr, int i, int i2) {
        Object obj = bArr;
        int i3 = i;
        int i4 = i2;
        if (!this.f13128l || r0.f13127k.f4580c) {
            r0.f13120d.m3867a(obj, i3, i4);
            r0.f13121e.m3867a(obj, i3, i4);
        }
        r0.f13122f.m3867a(obj, i3, i4);
        SampleReader sampleReader = r0.f13127k;
        if (sampleReader.f4588k) {
            i4 -= i3;
            if (sampleReader.f4584g.length < sampleReader.f4585h + i4) {
                sampleReader.f4584g = Arrays.copyOf(sampleReader.f4584g, (sampleReader.f4585h + i4) * 2);
            }
            System.arraycopy(obj, i3, sampleReader.f4584g, sampleReader.f4585h, i4);
            sampleReader.f4585h += i4;
            sampleReader.f4583f.m4272a(sampleReader.f4584g, 0, sampleReader.f4585h);
            if (sampleReader.f4583f.m4274b(8)) {
                sampleReader.f4583f.m4270a();
                int c = sampleReader.f4583f.m4275c(2);
                sampleReader.f4583f.m4271a(5);
                if (sampleReader.f4583f.m4276c()) {
                    sampleReader.f4583f.m4278e();
                    if (sampleReader.f4583f.m4276c()) {
                        i3 = sampleReader.f4583f.m4278e();
                        if (!sampleReader.f4580c) {
                            sampleReader.f4588k = false;
                            SliceHeaderData sliceHeaderData = sampleReader.f4591n;
                            sliceHeaderData.f4566e = i3;
                            sliceHeaderData.f4563b = true;
                        } else if (sampleReader.f4583f.m4276c()) {
                            int e = sampleReader.f4583f.m4278e();
                            if (sampleReader.f4582e.indexOfKey(e) < 0) {
                                sampleReader.f4588k = false;
                                return;
                            }
                            PpsData ppsData = (PpsData) sampleReader.f4582e.get(e);
                            SpsData spsData = (SpsData) sampleReader.f4581d.get(ppsData.f5236b);
                            if (spsData.f5242e) {
                                if (sampleReader.f4583f.m4274b(2)) {
                                    sampleReader.f4583f.m4271a(2);
                                }
                            }
                            if (sampleReader.f4583f.m4274b(spsData.f5244g)) {
                                boolean z;
                                boolean z2;
                                boolean b;
                                boolean z3;
                                int i5;
                                int c2;
                                int d;
                                int i6;
                                int i7;
                                SliceHeaderData sliceHeaderData2;
                                int c3 = sampleReader.f4583f.m4275c(spsData.f5244g);
                                if (spsData.f5243f) {
                                    z = false;
                                    z2 = z;
                                } else if (sampleReader.f4583f.m4274b(1)) {
                                    z = sampleReader.f4583f.m4273b();
                                    if (!z) {
                                        z2 = false;
                                    } else if (sampleReader.f4583f.m4274b(1)) {
                                        b = sampleReader.f4583f.m4273b();
                                        z2 = true;
                                        z3 = sampleReader.f4586i != 5;
                                        if (z3) {
                                            i5 = 0;
                                        } else if (sampleReader.f4583f.m4276c()) {
                                            i5 = sampleReader.f4583f.m4278e();
                                        }
                                        if (spsData.f5245h != 0) {
                                            if (sampleReader.f4583f.m4274b(spsData.f5246i)) {
                                                c2 = sampleReader.f4583f.m4275c(spsData.f5246i);
                                                if (ppsData.f5237c && !z) {
                                                    if (sampleReader.f4583f.m4276c()) {
                                                        d = sampleReader.f4583f.m4277d();
                                                        i6 = 0;
                                                        i7 = 0;
                                                        sliceHeaderData2 = sampleReader.f4591n;
                                                        sliceHeaderData2.f4564c = spsData;
                                                        sliceHeaderData2.f4565d = c;
                                                        sliceHeaderData2.f4566e = i3;
                                                        sliceHeaderData2.f4567f = c3;
                                                        sliceHeaderData2.f4568g = e;
                                                        sliceHeaderData2.f4569h = z;
                                                        sliceHeaderData2.f4570i = z2;
                                                        sliceHeaderData2.f4571j = b;
                                                        sliceHeaderData2.f4572k = z3;
                                                        sliceHeaderData2.f4573l = i5;
                                                        sliceHeaderData2.f4574m = c2;
                                                        sliceHeaderData2.f4575n = d;
                                                        sliceHeaderData2.f4576o = i7;
                                                        sliceHeaderData2.f4577p = i6;
                                                        sliceHeaderData2.f4562a = true;
                                                        sliceHeaderData2.f4563b = true;
                                                        sampleReader.f4588k = false;
                                                    }
                                                }
                                            }
                                        } else if (spsData.f5245h == 1 || spsData.f5247j) {
                                            c2 = 0;
                                        } else if (sampleReader.f4583f.m4276c()) {
                                            c2 = sampleReader.f4583f.m4277d();
                                            if (!ppsData.f5237c || z) {
                                                i7 = c2;
                                                c2 = 0;
                                                i6 = 0;
                                            } else if (sampleReader.f4583f.m4276c()) {
                                                i7 = c2;
                                                i6 = sampleReader.f4583f.m4277d();
                                                c2 = 0;
                                            }
                                            d = 0;
                                            sliceHeaderData2 = sampleReader.f4591n;
                                            sliceHeaderData2.f4564c = spsData;
                                            sliceHeaderData2.f4565d = c;
                                            sliceHeaderData2.f4566e = i3;
                                            sliceHeaderData2.f4567f = c3;
                                            sliceHeaderData2.f4568g = e;
                                            sliceHeaderData2.f4569h = z;
                                            sliceHeaderData2.f4570i = z2;
                                            sliceHeaderData2.f4571j = b;
                                            sliceHeaderData2.f4572k = z3;
                                            sliceHeaderData2.f4573l = i5;
                                            sliceHeaderData2.f4574m = c2;
                                            sliceHeaderData2.f4575n = d;
                                            sliceHeaderData2.f4576o = i7;
                                            sliceHeaderData2.f4577p = i6;
                                            sliceHeaderData2.f4562a = true;
                                            sliceHeaderData2.f4563b = true;
                                            sampleReader.f4588k = false;
                                        }
                                        i6 = 0;
                                        d = 0;
                                        i7 = 0;
                                        sliceHeaderData2 = sampleReader.f4591n;
                                        sliceHeaderData2.f4564c = spsData;
                                        sliceHeaderData2.f4565d = c;
                                        sliceHeaderData2.f4566e = i3;
                                        sliceHeaderData2.f4567f = c3;
                                        sliceHeaderData2.f4568g = e;
                                        sliceHeaderData2.f4569h = z;
                                        sliceHeaderData2.f4570i = z2;
                                        sliceHeaderData2.f4571j = b;
                                        sliceHeaderData2.f4572k = z3;
                                        sliceHeaderData2.f4573l = i5;
                                        sliceHeaderData2.f4574m = c2;
                                        sliceHeaderData2.f4575n = d;
                                        sliceHeaderData2.f4576o = i7;
                                        sliceHeaderData2.f4577p = i6;
                                        sliceHeaderData2.f4562a = true;
                                        sliceHeaderData2.f4563b = true;
                                        sampleReader.f4588k = false;
                                    }
                                }
                                b = z2;
                                if (sampleReader.f4586i != 5) {
                                }
                                if (z3) {
                                    i5 = 0;
                                } else if (sampleReader.f4583f.m4276c()) {
                                    i5 = sampleReader.f4583f.m4278e();
                                }
                                if (spsData.f5245h != 0) {
                                    if (spsData.f5245h == 1) {
                                    }
                                    c2 = 0;
                                } else if (sampleReader.f4583f.m4274b(spsData.f5246i)) {
                                    c2 = sampleReader.f4583f.m4275c(spsData.f5246i);
                                    if (sampleReader.f4583f.m4276c()) {
                                        d = sampleReader.f4583f.m4277d();
                                        i6 = 0;
                                        i7 = 0;
                                        sliceHeaderData2 = sampleReader.f4591n;
                                        sliceHeaderData2.f4564c = spsData;
                                        sliceHeaderData2.f4565d = c;
                                        sliceHeaderData2.f4566e = i3;
                                        sliceHeaderData2.f4567f = c3;
                                        sliceHeaderData2.f4568g = e;
                                        sliceHeaderData2.f4569h = z;
                                        sliceHeaderData2.f4570i = z2;
                                        sliceHeaderData2.f4571j = b;
                                        sliceHeaderData2.f4572k = z3;
                                        sliceHeaderData2.f4573l = i5;
                                        sliceHeaderData2.f4574m = c2;
                                        sliceHeaderData2.f4575n = d;
                                        sliceHeaderData2.f4576o = i7;
                                        sliceHeaderData2.f4577p = i6;
                                        sliceHeaderData2.f4562a = true;
                                        sliceHeaderData2.f4563b = true;
                                        sampleReader.f4588k = false;
                                    }
                                }
                                i6 = 0;
                                d = 0;
                                i7 = 0;
                                sliceHeaderData2 = sampleReader.f4591n;
                                sliceHeaderData2.f4564c = spsData;
                                sliceHeaderData2.f4565d = c;
                                sliceHeaderData2.f4566e = i3;
                                sliceHeaderData2.f4567f = c3;
                                sliceHeaderData2.f4568g = e;
                                sliceHeaderData2.f4569h = z;
                                sliceHeaderData2.f4570i = z2;
                                sliceHeaderData2.f4571j = b;
                                sliceHeaderData2.f4572k = z3;
                                sliceHeaderData2.f4573l = i5;
                                sliceHeaderData2.f4574m = c2;
                                sliceHeaderData2.f4575n = d;
                                sliceHeaderData2.f4576o = i7;
                                sliceHeaderData2.f4577p = i6;
                                sliceHeaderData2.f4562a = true;
                                sliceHeaderData2.f4563b = true;
                                sampleReader.f4588k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i = parsableByteArray2.f5257b;
        int i2 = parsableByteArray2.f5258c;
        byte[] bArr = parsableByteArray2.f5256a;
        this.f13123g += (long) parsableByteArray.m4246b();
        this.f13126j.mo1346a(parsableByteArray2, parsableByteArray.m4246b());
        while (true) {
            int a = NalUnitUtil.m4222a(bArr, i, i2, r0.f13124h);
            if (a == i2) {
                m12199a(bArr, i, i2);
                return;
            }
            int i3;
            int i4;
            byte[] bArr2;
            int i5;
            SampleReader sampleReader;
            boolean z;
            boolean z2;
            SliceHeaderData sliceHeaderData;
            Object obj;
            long j;
            int i6;
            SampleReader sampleReader2;
            SliceHeaderData sliceHeaderData2;
            int b = NalUnitUtil.m4227b(bArr, a);
            int i7 = a - i;
            if (i7 > 0) {
                m12199a(bArr, i, a);
            }
            i = i2 - a;
            long j2 = r0.f13123g - ((long) i);
            i7 = i7 < 0 ? -i7 : 0;
            long j3 = r0.f13129m;
            if (r0.f13128l) {
                if (r0.f13127k.f4580c) {
                }
                i3 = a;
                i4 = i2;
                bArr2 = bArr;
                i5 = b;
                if (r0.f13122f.m3868b(i7)) {
                    r0.f13130n.m4244a(r0.f13122f.f4610b, NalUnitUtil.m4221a(r0.f13122f.f4610b, r0.f13122f.f4611c));
                    r0.f13130n.m4249c(4);
                    r0.f13117a.m3871a(j3, r0.f13130n);
                }
                sampleReader = r0.f13127k;
                if (sampleReader.f4586i != 9) {
                    if (sampleReader.f4580c || !SliceHeaderData.m3859a(sampleReader.f4591n, sampleReader.f4590m)) {
                        z = true;
                        z2 = sampleReader.f4595r;
                        if (sampleReader.f4586i != 5) {
                            if (sampleReader.f4579b && sampleReader.f4586i == r2) {
                                sliceHeaderData = sampleReader.f4591n;
                                obj = (sliceHeaderData.f4563b || !(sliceHeaderData.f4566e == 7 || sliceHeaderData.f4566e == 2)) ? null : 1;
                                if (obj != null) {
                                }
                            }
                            i = 0;
                            sampleReader.f4595r = i | z2;
                            j = r0.f13129m;
                            if (r0.f13128l) {
                                if (!r0.f13127k.f4580c) {
                                    i6 = i5;
                                    r0.f13122f.m3866a(i6);
                                    sampleReader2 = r0.f13127k;
                                    sampleReader2.f4586i = i6;
                                    sampleReader2.f4589l = j;
                                    sampleReader2.f4587j = j2;
                                    if (sampleReader2.f4579b) {
                                        i = 1;
                                    } else {
                                        i = 1;
                                        if (sampleReader2.f4586i != 1) {
                                        }
                                        sliceHeaderData2 = sampleReader2.f4590m;
                                        sampleReader2.f4590m = sampleReader2.f4591n;
                                        sampleReader2.f4591n = sliceHeaderData2;
                                        sampleReader2.f4591n.m3860a();
                                        sampleReader2.f4585h = 0;
                                        sampleReader2.f4588k = true;
                                        i = i3 + 3;
                                        i2 = i4;
                                        bArr = bArr2;
                                    }
                                    if (!sampleReader2.f4580c) {
                                        if (!(sampleReader2.f4586i == 5 || sampleReader2.f4586i == r2 || sampleReader2.f4586i == 2)) {
                                        }
                                        sliceHeaderData2 = sampleReader2.f4590m;
                                        sampleReader2.f4590m = sampleReader2.f4591n;
                                        sampleReader2.f4591n = sliceHeaderData2;
                                        sampleReader2.f4591n.m3860a();
                                        sampleReader2.f4585h = 0;
                                        sampleReader2.f4588k = true;
                                    }
                                    i = i3 + 3;
                                    i2 = i4;
                                    bArr = bArr2;
                                }
                            }
                            i6 = i5;
                            r0.f13120d.m3866a(i6);
                            r0.f13121e.m3866a(i6);
                            r0.f13122f.m3866a(i6);
                            sampleReader2 = r0.f13127k;
                            sampleReader2.f4586i = i6;
                            sampleReader2.f4589l = j;
                            sampleReader2.f4587j = j2;
                            if (sampleReader2.f4579b) {
                                i = 1;
                            } else {
                                i = 1;
                                if (sampleReader2.f4586i != 1) {
                                }
                                sliceHeaderData2 = sampleReader2.f4590m;
                                sampleReader2.f4590m = sampleReader2.f4591n;
                                sampleReader2.f4591n = sliceHeaderData2;
                                sampleReader2.f4591n.m3860a();
                                sampleReader2.f4585h = 0;
                                sampleReader2.f4588k = true;
                                i = i3 + 3;
                                i2 = i4;
                                bArr = bArr2;
                            }
                            if (!sampleReader2.f4580c) {
                            }
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        }
                        i = 1;
                        sampleReader.f4595r = i | z2;
                        j = r0.f13129m;
                        if (r0.f13128l) {
                            if (!r0.f13127k.f4580c) {
                                i6 = i5;
                                r0.f13122f.m3866a(i6);
                                sampleReader2 = r0.f13127k;
                                sampleReader2.f4586i = i6;
                                sampleReader2.f4589l = j;
                                sampleReader2.f4587j = j2;
                                if (sampleReader2.f4579b) {
                                    i = 1;
                                    if (sampleReader2.f4586i != 1) {
                                    }
                                    sliceHeaderData2 = sampleReader2.f4590m;
                                    sampleReader2.f4590m = sampleReader2.f4591n;
                                    sampleReader2.f4591n = sliceHeaderData2;
                                    sampleReader2.f4591n.m3860a();
                                    sampleReader2.f4585h = 0;
                                    sampleReader2.f4588k = true;
                                    i = i3 + 3;
                                    i2 = i4;
                                    bArr = bArr2;
                                } else {
                                    i = 1;
                                }
                                if (!sampleReader2.f4580c) {
                                }
                                i = i3 + 3;
                                i2 = i4;
                                bArr = bArr2;
                            }
                        }
                        i6 = i5;
                        r0.f13120d.m3866a(i6);
                        r0.f13121e.m3866a(i6);
                        r0.f13122f.m3866a(i6);
                        sampleReader2 = r0.f13127k;
                        sampleReader2.f4586i = i6;
                        sampleReader2.f4589l = j;
                        sampleReader2.f4587j = j2;
                        if (sampleReader2.f4579b) {
                            i = 1;
                        } else {
                            i = 1;
                            if (sampleReader2.f4586i != 1) {
                            }
                            sliceHeaderData2 = sampleReader2.f4590m;
                            sampleReader2.f4590m = sampleReader2.f4591n;
                            sampleReader2.f4591n = sliceHeaderData2;
                            sampleReader2.f4591n.m3860a();
                            sampleReader2.f4585h = 0;
                            sampleReader2.f4588k = true;
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        }
                        if (!sampleReader2.f4580c) {
                        }
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                }
                if (sampleReader.f4592o) {
                    sampleReader.f4578a.mo1344a(sampleReader.f4594q, sampleReader.f4595r, (int) (sampleReader.f4587j - sampleReader.f4593p), i + ((int) (j2 - sampleReader.f4587j)), null);
                }
                sampleReader.f4593p = sampleReader.f4587j;
                sampleReader.f4594q = sampleReader.f4589l;
                sampleReader.f4595r = false;
                z = true;
                sampleReader.f4592o = true;
                z2 = sampleReader.f4595r;
                if (sampleReader.f4586i != 5) {
                    sliceHeaderData = sampleReader.f4591n;
                    if (sliceHeaderData.f4563b) {
                    }
                    if (obj != null) {
                    }
                    i = 0;
                    sampleReader.f4595r = i | z2;
                    j = r0.f13129m;
                    if (r0.f13128l) {
                        if (!r0.f13127k.f4580c) {
                            i6 = i5;
                            r0.f13122f.m3866a(i6);
                            sampleReader2 = r0.f13127k;
                            sampleReader2.f4586i = i6;
                            sampleReader2.f4589l = j;
                            sampleReader2.f4587j = j2;
                            if (sampleReader2.f4579b) {
                                i = 1;
                                if (sampleReader2.f4586i != 1) {
                                }
                                sliceHeaderData2 = sampleReader2.f4590m;
                                sampleReader2.f4590m = sampleReader2.f4591n;
                                sampleReader2.f4591n = sliceHeaderData2;
                                sampleReader2.f4591n.m3860a();
                                sampleReader2.f4585h = 0;
                                sampleReader2.f4588k = true;
                                i = i3 + 3;
                                i2 = i4;
                                bArr = bArr2;
                            } else {
                                i = 1;
                            }
                            if (!sampleReader2.f4580c) {
                            }
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        }
                    }
                    i6 = i5;
                    r0.f13120d.m3866a(i6);
                    r0.f13121e.m3866a(i6);
                    r0.f13122f.m3866a(i6);
                    sampleReader2 = r0.f13127k;
                    sampleReader2.f4586i = i6;
                    sampleReader2.f4589l = j;
                    sampleReader2.f4587j = j2;
                    if (sampleReader2.f4579b) {
                        i = 1;
                    } else {
                        i = 1;
                        if (sampleReader2.f4586i != 1) {
                        }
                        sliceHeaderData2 = sampleReader2.f4590m;
                        sampleReader2.f4590m = sampleReader2.f4591n;
                        sampleReader2.f4591n = sliceHeaderData2;
                        sampleReader2.f4591n.m3860a();
                        sampleReader2.f4585h = 0;
                        sampleReader2.f4588k = true;
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                    if (!sampleReader2.f4580c) {
                    }
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
                i = 1;
                sampleReader.f4595r = i | z2;
                j = r0.f13129m;
                if (r0.f13128l) {
                    if (!r0.f13127k.f4580c) {
                        i6 = i5;
                        r0.f13122f.m3866a(i6);
                        sampleReader2 = r0.f13127k;
                        sampleReader2.f4586i = i6;
                        sampleReader2.f4589l = j;
                        sampleReader2.f4587j = j2;
                        if (sampleReader2.f4579b) {
                            i = 1;
                            if (sampleReader2.f4586i != 1) {
                            }
                            sliceHeaderData2 = sampleReader2.f4590m;
                            sampleReader2.f4590m = sampleReader2.f4591n;
                            sampleReader2.f4591n = sliceHeaderData2;
                            sampleReader2.f4591n.m3860a();
                            sampleReader2.f4585h = 0;
                            sampleReader2.f4588k = true;
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        } else {
                            i = 1;
                        }
                        if (!sampleReader2.f4580c) {
                        }
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                }
                i6 = i5;
                r0.f13120d.m3866a(i6);
                r0.f13121e.m3866a(i6);
                r0.f13122f.m3866a(i6);
                sampleReader2 = r0.f13127k;
                sampleReader2.f4586i = i6;
                sampleReader2.f4589l = j;
                sampleReader2.f4587j = j2;
                if (sampleReader2.f4579b) {
                    i = 1;
                } else {
                    i = 1;
                    if (sampleReader2.f4586i != 1) {
                    }
                    sliceHeaderData2 = sampleReader2.f4590m;
                    sampleReader2.f4590m = sampleReader2.f4591n;
                    sampleReader2.f4591n = sliceHeaderData2;
                    sampleReader2.f4591n.m3860a();
                    sampleReader2.f4585h = 0;
                    sampleReader2.f4588k = true;
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
                if (!sampleReader2.f4580c) {
                }
                i = i3 + 3;
                i2 = i4;
                bArr = bArr2;
            }
            r0.f13120d.m3868b(i7);
            r0.f13121e.m3868b(i7);
            if (r0.f13128l) {
                i3 = a;
                i4 = i2;
                bArr2 = bArr;
                i5 = b;
                if (r0.f13120d.f4609a) {
                    r0.f13127k.m3863a(NalUnitUtil.m4223a(r0.f13120d.f4610b, 3, r0.f13120d.f4611c));
                    r0.f13120d.m3865a();
                } else if (r0.f13121e.f4609a) {
                    r0.f13127k.m3862a(NalUnitUtil.m4229d(r0.f13121e.f4610b, r0.f13121e.f4611c));
                    r0.f13121e.m3865a();
                }
            } else {
                if (r0.f13120d.f4609a && r0.f13121e.f4609a) {
                    List arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(r0.f13120d.f4610b, r0.f13120d.f4611c));
                    arrayList.add(Arrays.copyOf(r0.f13121e.f4610b, r0.f13121e.f4611c));
                    SpsData a2 = NalUnitUtil.m4223a(r0.f13120d.f4610b, 3, r0.f13120d.f4611c);
                    PpsData d = NalUnitUtil.m4229d(r0.f13121e.f4610b, r0.f13121e.f4611c);
                    i4 = i2;
                    bArr2 = bArr;
                    i3 = a;
                    i5 = b;
                    r0.f13126j.mo1345a(Format.m3560a(r0.f13125i, "video/avc", a2.f5239b, a2.f5240c, arrayList, a2.f5241d));
                    r0.f13128l = true;
                    r0.f13127k.m3863a(a2);
                    r0.f13127k.m3862a(d);
                    r0.f13120d.m3865a();
                    r0.f13121e.m3865a();
                }
                i3 = a;
                i4 = i2;
                bArr2 = bArr;
                i5 = b;
            }
            if (r0.f13122f.m3868b(i7)) {
                r0.f13130n.m4244a(r0.f13122f.f4610b, NalUnitUtil.m4221a(r0.f13122f.f4610b, r0.f13122f.f4611c));
                r0.f13130n.m4249c(4);
                r0.f13117a.m3871a(j3, r0.f13130n);
            }
            sampleReader = r0.f13127k;
            if (sampleReader.f4586i != 9) {
                if (sampleReader.f4580c) {
                }
                z = true;
                z2 = sampleReader.f4595r;
                if (sampleReader.f4586i != 5) {
                    sliceHeaderData = sampleReader.f4591n;
                    if (sliceHeaderData.f4563b) {
                    }
                    if (obj != null) {
                    }
                    i = 0;
                    sampleReader.f4595r = i | z2;
                    j = r0.f13129m;
                    if (r0.f13128l) {
                        if (!r0.f13127k.f4580c) {
                            i6 = i5;
                            r0.f13122f.m3866a(i6);
                            sampleReader2 = r0.f13127k;
                            sampleReader2.f4586i = i6;
                            sampleReader2.f4589l = j;
                            sampleReader2.f4587j = j2;
                            if (sampleReader2.f4579b) {
                                i = 1;
                                if (sampleReader2.f4586i != 1) {
                                }
                                sliceHeaderData2 = sampleReader2.f4590m;
                                sampleReader2.f4590m = sampleReader2.f4591n;
                                sampleReader2.f4591n = sliceHeaderData2;
                                sampleReader2.f4591n.m3860a();
                                sampleReader2.f4585h = 0;
                                sampleReader2.f4588k = true;
                                i = i3 + 3;
                                i2 = i4;
                                bArr = bArr2;
                            } else {
                                i = 1;
                            }
                            if (!sampleReader2.f4580c) {
                            }
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        }
                    }
                    i6 = i5;
                    r0.f13120d.m3866a(i6);
                    r0.f13121e.m3866a(i6);
                    r0.f13122f.m3866a(i6);
                    sampleReader2 = r0.f13127k;
                    sampleReader2.f4586i = i6;
                    sampleReader2.f4589l = j;
                    sampleReader2.f4587j = j2;
                    if (sampleReader2.f4579b) {
                        i = 1;
                    } else {
                        i = 1;
                        if (sampleReader2.f4586i != 1) {
                        }
                        sliceHeaderData2 = sampleReader2.f4590m;
                        sampleReader2.f4590m = sampleReader2.f4591n;
                        sampleReader2.f4591n = sliceHeaderData2;
                        sampleReader2.f4591n.m3860a();
                        sampleReader2.f4585h = 0;
                        sampleReader2.f4588k = true;
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                    if (!sampleReader2.f4580c) {
                    }
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
                i = 1;
                sampleReader.f4595r = i | z2;
                j = r0.f13129m;
                if (r0.f13128l) {
                    if (!r0.f13127k.f4580c) {
                        i6 = i5;
                        r0.f13122f.m3866a(i6);
                        sampleReader2 = r0.f13127k;
                        sampleReader2.f4586i = i6;
                        sampleReader2.f4589l = j;
                        sampleReader2.f4587j = j2;
                        if (sampleReader2.f4579b) {
                            i = 1;
                            if (sampleReader2.f4586i != 1) {
                            }
                            sliceHeaderData2 = sampleReader2.f4590m;
                            sampleReader2.f4590m = sampleReader2.f4591n;
                            sampleReader2.f4591n = sliceHeaderData2;
                            sampleReader2.f4591n.m3860a();
                            sampleReader2.f4585h = 0;
                            sampleReader2.f4588k = true;
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        } else {
                            i = 1;
                        }
                        if (!sampleReader2.f4580c) {
                        }
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                }
                i6 = i5;
                r0.f13120d.m3866a(i6);
                r0.f13121e.m3866a(i6);
                r0.f13122f.m3866a(i6);
                sampleReader2 = r0.f13127k;
                sampleReader2.f4586i = i6;
                sampleReader2.f4589l = j;
                sampleReader2.f4587j = j2;
                if (sampleReader2.f4579b) {
                    i = 1;
                } else {
                    i = 1;
                    if (sampleReader2.f4586i != 1) {
                    }
                    sliceHeaderData2 = sampleReader2.f4590m;
                    sampleReader2.f4590m = sampleReader2.f4591n;
                    sampleReader2.f4591n = sliceHeaderData2;
                    sampleReader2.f4591n.m3860a();
                    sampleReader2.f4585h = 0;
                    sampleReader2.f4588k = true;
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
                if (!sampleReader2.f4580c) {
                }
                i = i3 + 3;
                i2 = i4;
                bArr = bArr2;
            }
            if (sampleReader.f4592o) {
                sampleReader.f4578a.mo1344a(sampleReader.f4594q, sampleReader.f4595r, (int) (sampleReader.f4587j - sampleReader.f4593p), i + ((int) (j2 - sampleReader.f4587j)), null);
            }
            sampleReader.f4593p = sampleReader.f4587j;
            sampleReader.f4594q = sampleReader.f4589l;
            sampleReader.f4595r = false;
            z = true;
            sampleReader.f4592o = true;
            z2 = sampleReader.f4595r;
            if (sampleReader.f4586i != 5) {
                sliceHeaderData = sampleReader.f4591n;
                if (sliceHeaderData.f4563b) {
                }
                if (obj != null) {
                }
                i = 0;
                sampleReader.f4595r = i | z2;
                j = r0.f13129m;
                if (r0.f13128l) {
                    if (!r0.f13127k.f4580c) {
                        i6 = i5;
                        r0.f13122f.m3866a(i6);
                        sampleReader2 = r0.f13127k;
                        sampleReader2.f4586i = i6;
                        sampleReader2.f4589l = j;
                        sampleReader2.f4587j = j2;
                        if (sampleReader2.f4579b) {
                            i = 1;
                            if (sampleReader2.f4586i != 1) {
                            }
                            sliceHeaderData2 = sampleReader2.f4590m;
                            sampleReader2.f4590m = sampleReader2.f4591n;
                            sampleReader2.f4591n = sliceHeaderData2;
                            sampleReader2.f4591n.m3860a();
                            sampleReader2.f4585h = 0;
                            sampleReader2.f4588k = true;
                            i = i3 + 3;
                            i2 = i4;
                            bArr = bArr2;
                        } else {
                            i = 1;
                        }
                        if (!sampleReader2.f4580c) {
                        }
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    }
                }
                i6 = i5;
                r0.f13120d.m3866a(i6);
                r0.f13121e.m3866a(i6);
                r0.f13122f.m3866a(i6);
                sampleReader2 = r0.f13127k;
                sampleReader2.f4586i = i6;
                sampleReader2.f4589l = j;
                sampleReader2.f4587j = j2;
                if (sampleReader2.f4579b) {
                    i = 1;
                } else {
                    i = 1;
                    if (sampleReader2.f4586i != 1) {
                    }
                    sliceHeaderData2 = sampleReader2.f4590m;
                    sampleReader2.f4590m = sampleReader2.f4591n;
                    sampleReader2.f4591n = sliceHeaderData2;
                    sampleReader2.f4591n.m3860a();
                    sampleReader2.f4585h = 0;
                    sampleReader2.f4588k = true;
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
                if (!sampleReader2.f4580c) {
                }
                i = i3 + 3;
                i2 = i4;
                bArr = bArr2;
            }
            i = 1;
            sampleReader.f4595r = i | z2;
            j = r0.f13129m;
            if (r0.f13128l) {
                if (!r0.f13127k.f4580c) {
                    i6 = i5;
                    r0.f13122f.m3866a(i6);
                    sampleReader2 = r0.f13127k;
                    sampleReader2.f4586i = i6;
                    sampleReader2.f4589l = j;
                    sampleReader2.f4587j = j2;
                    if (sampleReader2.f4579b) {
                        i = 1;
                        if (sampleReader2.f4586i != 1) {
                        }
                        sliceHeaderData2 = sampleReader2.f4590m;
                        sampleReader2.f4590m = sampleReader2.f4591n;
                        sampleReader2.f4591n = sliceHeaderData2;
                        sampleReader2.f4591n.m3860a();
                        sampleReader2.f4585h = 0;
                        sampleReader2.f4588k = true;
                        i = i3 + 3;
                        i2 = i4;
                        bArr = bArr2;
                    } else {
                        i = 1;
                    }
                    if (!sampleReader2.f4580c) {
                    }
                    i = i3 + 3;
                    i2 = i4;
                    bArr = bArr2;
                }
            }
            i6 = i5;
            r0.f13120d.m3866a(i6);
            r0.f13121e.m3866a(i6);
            r0.f13122f.m3866a(i6);
            sampleReader2 = r0.f13127k;
            sampleReader2.f4586i = i6;
            sampleReader2.f4589l = j;
            sampleReader2.f4587j = j2;
            if (sampleReader2.f4579b) {
                i = 1;
            } else {
                i = 1;
                if (sampleReader2.f4586i != 1) {
                }
                sliceHeaderData2 = sampleReader2.f4590m;
                sampleReader2.f4590m = sampleReader2.f4591n;
                sampleReader2.f4591n = sliceHeaderData2;
                sampleReader2.f4591n.m3860a();
                sampleReader2.f4585h = 0;
                sampleReader2.f4588k = true;
                i = i3 + 3;
                i2 = i4;
                bArr = bArr2;
            }
            if (!sampleReader2.f4580c) {
            }
            i = i3 + 3;
            i2 = i4;
            bArr = bArr2;
        }
    }
}
