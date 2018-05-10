package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {
    public static final ExtractorsFactory f13199a = new C11371();
    private static final long f13200b = ((long) Util.m4326g("AC-3"));
    private static final long f13201c = ((long) Util.m4326g("EAC3"));
    private static final long f13202d = ((long) Util.m4326g("HEVC"));
    private final int f13203e;
    private final List<TimestampAdjuster> f13204f;
    private final ParsableByteArray f13205g;
    private final SparseIntArray f13206h;
    private final Factory f13207i;
    private final SparseArray<TsPayloadReader> f13208j;
    private final SparseBooleanArray f13209k;
    private ExtractorOutput f13210l;
    private int f13211m;
    private boolean f13212n;
    private TsPayloadReader f13213o;

    static class C11371 implements ExtractorsFactory {
        C11371() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new TsExtractor()};
        }
    }

    private class PatReader implements SectionPayloadReader {
        final /* synthetic */ TsExtractor f13192a;
        private final ParsableBitArray f13193b = new ParsableBitArray(new byte[4]);

        public final void mo1387a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        }

        public PatReader(TsExtractor tsExtractor) {
            this.f13192a = tsExtractor;
        }

        public final void mo1386a(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.m4250d() == 0) {
                parsableByteArray.m4251d(7);
                int b = parsableByteArray.m4246b() / 4;
                for (int i = 0; i < b; i++) {
                    parsableByteArray.m4243a(this.f13193b, 4);
                    int c = this.f13193b.m4236c(16);
                    this.f13193b.m4234b(3);
                    if (c == 0) {
                        this.f13193b.m4234b(13);
                    } else {
                        c = this.f13193b.m4236c(13);
                        this.f13192a.f13208j.put(c, new SectionReader(new PmtReader(this.f13192a, c)));
                        this.f13192a.f13211m = this.f13192a.f13211m + 1;
                    }
                }
                if (this.f13192a.f13203e != 2) {
                    this.f13192a.f13208j.remove(0);
                }
            }
        }
    }

    private class PmtReader implements SectionPayloadReader {
        final /* synthetic */ TsExtractor f13194a;
        private final ParsableBitArray f13195b = new ParsableBitArray(new byte[5]);
        private final SparseArray<TsPayloadReader> f13196c = new SparseArray();
        private final SparseIntArray f13197d = new SparseIntArray();
        private final int f13198e;

        public final void mo1387a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        }

        public PmtReader(TsExtractor tsExtractor, int i) {
            this.f13194a = tsExtractor;
            this.f13198e = i;
        }

        public final void mo1386a(ParsableByteArray parsableByteArray) {
            PmtReader pmtReader = this;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.m4250d() == 2) {
                TimestampAdjuster timestampAdjuster;
                int e;
                int i;
                int i2;
                int i3;
                int b;
                int c;
                int c2;
                int c3;
                int i4;
                int i5;
                String str;
                List list;
                int d;
                long h;
                TimestampAdjuster timestampAdjuster2;
                int i6;
                int i7;
                List arrayList;
                String trim;
                byte[] bArr;
                EsInfo esInfo;
                int i8;
                Object obj;
                Object f;
                Object obj2;
                int size;
                int i9;
                TsPayloadReader tsPayloadReader;
                ExtractorOutput h2;
                TrackIdGenerator trackIdGenerator;
                TimestampAdjuster timestampAdjuster3;
                if (!(pmtReader.f13194a.f13203e == 1 || pmtReader.f13194a.f13203e == 2)) {
                    if (pmtReader.f13194a.f13211m != 1) {
                        timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) pmtReader.f13194a.f13204f.get(0)).f5279a);
                        pmtReader.f13194a.f13204f.add(timestampAdjuster);
                        parsableByteArray2.m4251d(2);
                        e = parsableByteArray.m4252e();
                        i = 5;
                        parsableByteArray2.m4251d(5);
                        parsableByteArray2.m4243a(pmtReader.f13195b, 2);
                        i2 = 4;
                        pmtReader.f13195b.m4234b(4);
                        i3 = 12;
                        parsableByteArray2.m4251d(pmtReader.f13195b.m4236c(12));
                        if (pmtReader.f13194a.f13203e == 2 && pmtReader.f13194a.f13213o == null) {
                            pmtReader.f13194a.f13213o = pmtReader.f13194a.f13207i.mo1382a(21, new EsInfo(21, null, null, new byte[0]));
                            pmtReader.f13194a.f13213o.mo1385a(timestampAdjuster, pmtReader.f13194a.f13210l, new TrackIdGenerator(e, 21, 8192));
                        }
                        pmtReader.f13196c.clear();
                        pmtReader.f13197d.clear();
                        b = parsableByteArray.m4246b();
                        while (b > 0) {
                            parsableByteArray2.m4243a(pmtReader.f13195b, i);
                            c = pmtReader.f13195b.m4236c(8);
                            pmtReader.f13195b.m4234b(3);
                            c2 = pmtReader.f13195b.m4236c(13);
                            pmtReader.f13195b.m4234b(i2);
                            c3 = pmtReader.f13195b.m4236c(i3);
                            i3 = parsableByteArray2.f5257b;
                            i4 = i3 + c3;
                            i5 = -1;
                            str = null;
                            list = null;
                            while (parsableByteArray2.f5257b < i4) {
                                d = parsableByteArray.m4250d();
                                i2 = parsableByteArray2.f5257b + parsableByteArray.m4250d();
                                if (d == i) {
                                    h = parsableByteArray.m4257h();
                                    if (h != TsExtractor.f13200b) {
                                        if (h != TsExtractor.f13201c) {
                                            if (h == TsExtractor.f13202d) {
                                                i5 = 36;
                                            }
                                            timestampAdjuster2 = timestampAdjuster;
                                            i6 = e;
                                            i7 = 4;
                                            parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                            i2 = i7;
                                            timestampAdjuster = timestampAdjuster2;
                                            e = i6;
                                            i = 5;
                                        }
                                        timestampAdjuster2 = timestampAdjuster;
                                        i6 = e;
                                        i5 = 135;
                                        i7 = 4;
                                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                        i2 = i7;
                                        timestampAdjuster = timestampAdjuster2;
                                        e = i6;
                                        i = 5;
                                    }
                                } else if (d == 106) {
                                    if (d == 122) {
                                        timestampAdjuster2 = timestampAdjuster;
                                        i6 = e;
                                        i5 = 135;
                                        i7 = 4;
                                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                        i2 = i7;
                                        timestampAdjuster = timestampAdjuster2;
                                        e = i6;
                                        i = 5;
                                    } else if (d != 123) {
                                        timestampAdjuster2 = timestampAdjuster;
                                        i5 = 138;
                                        i6 = e;
                                        i7 = 4;
                                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                        i2 = i7;
                                        timestampAdjuster = timestampAdjuster2;
                                        e = i6;
                                        i = 5;
                                    } else {
                                        if (d != 10) {
                                            str = parsableByteArray2.m4253e(3).trim();
                                        } else {
                                            i = 3;
                                            if (d == 89) {
                                                arrayList = new ArrayList();
                                                while (parsableByteArray2.f5257b < i2) {
                                                    trim = parsableByteArray2.m4253e(i).trim();
                                                    i = parsableByteArray.m4250d();
                                                    timestampAdjuster2 = timestampAdjuster;
                                                    bArr = new byte[4];
                                                    i6 = e;
                                                    parsableByteArray2.m4245a(bArr, 0, 4);
                                                    arrayList.add(new DvbSubtitleInfo(trim, i, bArr));
                                                    timestampAdjuster = timestampAdjuster2;
                                                    e = i6;
                                                    i = 3;
                                                }
                                                timestampAdjuster2 = timestampAdjuster;
                                                i6 = e;
                                                i7 = 4;
                                                list = arrayList;
                                                i5 = 89;
                                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                                i2 = i7;
                                                timestampAdjuster = timestampAdjuster2;
                                                e = i6;
                                                i = 5;
                                            }
                                        }
                                        timestampAdjuster2 = timestampAdjuster;
                                        i6 = e;
                                        i7 = 4;
                                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                        i2 = i7;
                                        timestampAdjuster = timestampAdjuster2;
                                        e = i6;
                                        i = 5;
                                    }
                                }
                                timestampAdjuster2 = timestampAdjuster;
                                i6 = e;
                                i5 = 129;
                                i7 = 4;
                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                i2 = i7;
                                timestampAdjuster = timestampAdjuster2;
                                e = i6;
                                i = 5;
                            }
                            timestampAdjuster2 = timestampAdjuster;
                            i6 = e;
                            i7 = i2;
                            parsableByteArray2.m4249c(i4);
                            esInfo = new EsInfo(i5, str, list, Arrays.copyOfRange(parsableByteArray2.f5256a, i3, i4));
                            if (c == 6) {
                                c = esInfo.f4627a;
                            }
                            b -= c3 + 5;
                            i8 = pmtReader.f13194a.f13203e != 2 ? c : c2;
                            if (pmtReader.f13194a.f13209k.get(i8)) {
                                if (pmtReader.f13194a.f13203e != 2) {
                                    obj = 21;
                                    if (c == 21) {
                                        f = pmtReader.f13194a.f13213o;
                                        if (pmtReader.f13194a.f13203e == 2 || c2 < pmtReader.f13197d.get(i8, 8192)) {
                                            pmtReader.f13197d.put(i8, c2);
                                            pmtReader.f13196c.put(i8, f);
                                        }
                                    }
                                } else {
                                    obj = 21;
                                }
                                f = pmtReader.f13194a.f13207i.mo1382a(c, esInfo);
                                if (pmtReader.f13194a.f13203e == 2) {
                                }
                                pmtReader.f13197d.put(i8, c2);
                                pmtReader.f13196c.put(i8, f);
                            } else {
                                obj = 21;
                            }
                            obj2 = obj;
                            i2 = i7;
                            timestampAdjuster = timestampAdjuster2;
                            e = i6;
                            i = 5;
                            i3 = 12;
                        }
                        timestampAdjuster2 = timestampAdjuster;
                        i6 = e;
                        size = pmtReader.f13197d.size();
                        i9 = 0;
                        while (i9 < size) {
                            i8 = pmtReader.f13197d.keyAt(i9);
                            pmtReader.f13194a.f13209k.put(i8, true);
                            tsPayloadReader = (TsPayloadReader) pmtReader.f13196c.valueAt(i9);
                            if (tsPayloadReader == null) {
                                if (tsPayloadReader == pmtReader.f13194a.f13213o) {
                                    h2 = pmtReader.f13194a.f13210l;
                                    i = i6;
                                    trackIdGenerator = new TrackIdGenerator(i, i8, 8192);
                                    timestampAdjuster3 = timestampAdjuster2;
                                    tsPayloadReader.mo1385a(timestampAdjuster3, h2, trackIdGenerator);
                                } else {
                                    timestampAdjuster3 = timestampAdjuster2;
                                    i = i6;
                                }
                                pmtReader.f13194a.f13208j.put(pmtReader.f13197d.valueAt(i9), tsPayloadReader);
                            } else {
                                timestampAdjuster3 = timestampAdjuster2;
                                i = i6;
                            }
                            i9++;
                            timestampAdjuster2 = timestampAdjuster3;
                            i6 = i;
                        }
                        if (pmtReader.f13194a.f13203e == 2) {
                            pmtReader.f13194a.f13208j.remove(pmtReader.f13198e);
                            pmtReader.f13194a.f13211m = pmtReader.f13194a.f13203e != 1 ? 0 : pmtReader.f13194a.f13211m - 1;
                            if (pmtReader.f13194a.f13211m == 0) {
                                pmtReader.f13194a.f13210l.mo1416a();
                                pmtReader.f13194a.f13212n = true;
                            }
                        } else if (!pmtReader.f13194a.f13212n) {
                            pmtReader.f13194a.f13210l.mo1416a();
                            pmtReader.f13194a.f13211m = 0;
                            pmtReader.f13194a.f13212n = true;
                        }
                    }
                }
                timestampAdjuster = (TimestampAdjuster) pmtReader.f13194a.f13204f.get(0);
                parsableByteArray2.m4251d(2);
                e = parsableByteArray.m4252e();
                i = 5;
                parsableByteArray2.m4251d(5);
                parsableByteArray2.m4243a(pmtReader.f13195b, 2);
                i2 = 4;
                pmtReader.f13195b.m4234b(4);
                i3 = 12;
                parsableByteArray2.m4251d(pmtReader.f13195b.m4236c(12));
                pmtReader.f13194a.f13213o = pmtReader.f13194a.f13207i.mo1382a(21, new EsInfo(21, null, null, new byte[0]));
                pmtReader.f13194a.f13213o.mo1385a(timestampAdjuster, pmtReader.f13194a.f13210l, new TrackIdGenerator(e, 21, 8192));
                pmtReader.f13196c.clear();
                pmtReader.f13197d.clear();
                b = parsableByteArray.m4246b();
                while (b > 0) {
                    parsableByteArray2.m4243a(pmtReader.f13195b, i);
                    c = pmtReader.f13195b.m4236c(8);
                    pmtReader.f13195b.m4234b(3);
                    c2 = pmtReader.f13195b.m4236c(13);
                    pmtReader.f13195b.m4234b(i2);
                    c3 = pmtReader.f13195b.m4236c(i3);
                    i3 = parsableByteArray2.f5257b;
                    i4 = i3 + c3;
                    i5 = -1;
                    str = null;
                    list = null;
                    while (parsableByteArray2.f5257b < i4) {
                        d = parsableByteArray.m4250d();
                        i2 = parsableByteArray2.f5257b + parsableByteArray.m4250d();
                        if (d == i) {
                            h = parsableByteArray.m4257h();
                            if (h != TsExtractor.f13200b) {
                                if (h != TsExtractor.f13201c) {
                                    if (h == TsExtractor.f13202d) {
                                        i5 = 36;
                                    }
                                    timestampAdjuster2 = timestampAdjuster;
                                    i6 = e;
                                    i7 = 4;
                                    parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                    i2 = i7;
                                    timestampAdjuster = timestampAdjuster2;
                                    e = i6;
                                    i = 5;
                                }
                                timestampAdjuster2 = timestampAdjuster;
                                i6 = e;
                                i5 = 135;
                                i7 = 4;
                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                i2 = i7;
                                timestampAdjuster = timestampAdjuster2;
                                e = i6;
                                i = 5;
                            }
                        } else if (d == 106) {
                            if (d == 122) {
                                timestampAdjuster2 = timestampAdjuster;
                                i6 = e;
                                i5 = 135;
                                i7 = 4;
                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                i2 = i7;
                                timestampAdjuster = timestampAdjuster2;
                                e = i6;
                                i = 5;
                            } else if (d != 123) {
                                if (d != 10) {
                                    i = 3;
                                    if (d == 89) {
                                        arrayList = new ArrayList();
                                        while (parsableByteArray2.f5257b < i2) {
                                            trim = parsableByteArray2.m4253e(i).trim();
                                            i = parsableByteArray.m4250d();
                                            timestampAdjuster2 = timestampAdjuster;
                                            bArr = new byte[4];
                                            i6 = e;
                                            parsableByteArray2.m4245a(bArr, 0, 4);
                                            arrayList.add(new DvbSubtitleInfo(trim, i, bArr));
                                            timestampAdjuster = timestampAdjuster2;
                                            e = i6;
                                            i = 3;
                                        }
                                        timestampAdjuster2 = timestampAdjuster;
                                        i6 = e;
                                        i7 = 4;
                                        list = arrayList;
                                        i5 = 89;
                                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                        i2 = i7;
                                        timestampAdjuster = timestampAdjuster2;
                                        e = i6;
                                        i = 5;
                                    }
                                } else {
                                    str = parsableByteArray2.m4253e(3).trim();
                                }
                                timestampAdjuster2 = timestampAdjuster;
                                i6 = e;
                                i7 = 4;
                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                i2 = i7;
                                timestampAdjuster = timestampAdjuster2;
                                e = i6;
                                i = 5;
                            } else {
                                timestampAdjuster2 = timestampAdjuster;
                                i5 = 138;
                                i6 = e;
                                i7 = 4;
                                parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                                i2 = i7;
                                timestampAdjuster = timestampAdjuster2;
                                e = i6;
                                i = 5;
                            }
                        }
                        timestampAdjuster2 = timestampAdjuster;
                        i6 = e;
                        i5 = 129;
                        i7 = 4;
                        parsableByteArray2.m4251d(i2 - parsableByteArray2.f5257b);
                        i2 = i7;
                        timestampAdjuster = timestampAdjuster2;
                        e = i6;
                        i = 5;
                    }
                    timestampAdjuster2 = timestampAdjuster;
                    i6 = e;
                    i7 = i2;
                    parsableByteArray2.m4249c(i4);
                    esInfo = new EsInfo(i5, str, list, Arrays.copyOfRange(parsableByteArray2.f5256a, i3, i4));
                    if (c == 6) {
                        c = esInfo.f4627a;
                    }
                    b -= c3 + 5;
                    if (pmtReader.f13194a.f13203e != 2) {
                    }
                    if (pmtReader.f13194a.f13209k.get(i8)) {
                        obj = 21;
                    } else {
                        if (pmtReader.f13194a.f13203e != 2) {
                            obj = 21;
                        } else {
                            obj = 21;
                            if (c == 21) {
                                f = pmtReader.f13194a.f13213o;
                                if (pmtReader.f13194a.f13203e == 2) {
                                }
                                pmtReader.f13197d.put(i8, c2);
                                pmtReader.f13196c.put(i8, f);
                            }
                        }
                        f = pmtReader.f13194a.f13207i.mo1382a(c, esInfo);
                        if (pmtReader.f13194a.f13203e == 2) {
                        }
                        pmtReader.f13197d.put(i8, c2);
                        pmtReader.f13196c.put(i8, f);
                    }
                    obj2 = obj;
                    i2 = i7;
                    timestampAdjuster = timestampAdjuster2;
                    e = i6;
                    i = 5;
                    i3 = 12;
                }
                timestampAdjuster2 = timestampAdjuster;
                i6 = e;
                size = pmtReader.f13197d.size();
                i9 = 0;
                while (i9 < size) {
                    i8 = pmtReader.f13197d.keyAt(i9);
                    pmtReader.f13194a.f13209k.put(i8, true);
                    tsPayloadReader = (TsPayloadReader) pmtReader.f13196c.valueAt(i9);
                    if (tsPayloadReader == null) {
                        timestampAdjuster3 = timestampAdjuster2;
                        i = i6;
                    } else {
                        if (tsPayloadReader == pmtReader.f13194a.f13213o) {
                            timestampAdjuster3 = timestampAdjuster2;
                            i = i6;
                        } else {
                            h2 = pmtReader.f13194a.f13210l;
                            i = i6;
                            trackIdGenerator = new TrackIdGenerator(i, i8, 8192);
                            timestampAdjuster3 = timestampAdjuster2;
                            tsPayloadReader.mo1385a(timestampAdjuster3, h2, trackIdGenerator);
                        }
                        pmtReader.f13194a.f13208j.put(pmtReader.f13197d.valueAt(i9), tsPayloadReader);
                    }
                    i9++;
                    timestampAdjuster2 = timestampAdjuster3;
                    i6 = i;
                }
                if (pmtReader.f13194a.f13203e == 2) {
                    pmtReader.f13194a.f13208j.remove(pmtReader.f13198e);
                    if (pmtReader.f13194a.f13203e != 1) {
                    }
                    pmtReader.f13194a.f13211m = pmtReader.f13194a.f13203e != 1 ? 0 : pmtReader.f13194a.f13211m - 1;
                    if (pmtReader.f13194a.f13211m == 0) {
                        pmtReader.f13194a.f13210l.mo1416a();
                        pmtReader.f13194a.f13212n = true;
                    }
                } else if (pmtReader.f13194a.f13212n) {
                    pmtReader.f13194a.f13210l.mo1416a();
                    pmtReader.f13194a.f13211m = 0;
                    pmtReader.f13194a.f13212n = true;
                }
            }
        }
    }

    public TsExtractor() {
        this((byte) 0);
    }

    private TsExtractor(byte b) {
        this((byte) 1, 0);
    }

    public TsExtractor(int i, int i2) {
        this(i, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i2));
    }

    public TsExtractor(int i, TimestampAdjuster timestampAdjuster, Factory factory) {
        this.f13207i = (Factory) Assertions.m4182a((Object) factory);
        this.f13203e = i;
        if (i != 1) {
            if (i != 2) {
                this.f13204f = new ArrayList();
                this.f13204f.add(timestampAdjuster);
                this.f13205g = new ParsableByteArray(9400);
                this.f13209k = new SparseBooleanArray();
                this.f13208j = new SparseArray();
                this.f13206h = new SparseIntArray();
                m12250d();
            }
        }
        this.f13204f = Collections.singletonList(timestampAdjuster);
        this.f13205g = new ParsableByteArray(9400);
        this.f13209k = new SparseBooleanArray();
        this.f13208j = new SparseArray();
        this.f13206h = new SparseIntArray();
        m12250d();
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        byte[] bArr = this.f13205g.f5256a;
        extractorInput.mo1340c(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] == (byte) 71) {
                    i2++;
                } else {
                    i++;
                }
            }
            extractorInput.mo1335b(i);
            return true;
        }
        return false;
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13210l = extractorOutput;
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
    }

    public final void mo1351a(long j, long j2) {
        j = this.f13204f.size();
        for (int i = 0; i < j; i++) {
            ((TimestampAdjuster) this.f13204f.get(i)).f5280b = -9223372036854775807L;
        }
        this.f13205g.m4241a();
        this.f13206h.clear();
        m12250d();
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int b;
        byte[] bArr = this.f13205g.f5256a;
        if (9400 - this.f13205g.f5257b < 188) {
            b = this.f13205g.m4246b();
            if (b > 0) {
                System.arraycopy(bArr, this.f13205g.f5257b, bArr, 0, b);
            }
            this.f13205g.m4244a(bArr, b);
        }
        while (this.f13205g.m4246b() < 188) {
            b = this.f13205g.f5258c;
            int a = extractorInput.mo1331a(bArr, b, 9400 - b);
            if (a == -1) {
                return -1;
            }
            this.f13205g.m4247b(b + a);
        }
        extractorInput = this.f13205g.f5258c;
        b = this.f13205g.f5257b;
        while (b < extractorInput && bArr[b] != (byte) 71) {
            b++;
        }
        this.f13205g.m4249c(b);
        b += 188;
        if (b > extractorInput) {
            return 0;
        }
        positionHolder = this.f13205g.m4259j();
        if ((8388608 & positionHolder) != 0) {
            this.f13205g.m4249c(b);
            return 0;
        }
        TsPayloadReader tsPayloadReader;
        a = 1;
        boolean z = (4194304 & positionHolder) != 0;
        int i = (2096896 & positionHolder) >> 8;
        int i2 = (positionHolder & 32) != 0 ? 1 : 0;
        int i3 = (positionHolder & 16) != 0 ? 1 : 0;
        if (this.f13203e != 2) {
            positionHolder &= 15;
            int i4 = this.f13206h.get(i, positionHolder - 1);
            this.f13206h.put(i, positionHolder);
            if (i4 == positionHolder) {
                if (i3 != 0) {
                    this.f13205g.m4249c(b);
                    return 0;
                }
            } else if (positionHolder != ((i4 + 1) & 15)) {
                if (i2 != 0) {
                    this.f13205g.m4251d(this.f13205g.m4250d());
                }
                if (i3 != 0) {
                    tsPayloadReader = (TsPayloadReader) this.f13208j.get(i);
                    if (tsPayloadReader != null) {
                        if (a != 0) {
                            tsPayloadReader.mo1383a();
                        }
                        this.f13205g.m4247b(b);
                        tsPayloadReader.mo1384a(this.f13205g, z);
                        this.f13205g.m4247b(extractorInput);
                    }
                }
                this.f13205g.m4249c(b);
                return 0;
            }
        }
        a = 0;
        if (i2 != 0) {
            this.f13205g.m4251d(this.f13205g.m4250d());
        }
        if (i3 != 0) {
            tsPayloadReader = (TsPayloadReader) this.f13208j.get(i);
            if (tsPayloadReader != null) {
                if (a != 0) {
                    tsPayloadReader.mo1383a();
                }
                this.f13205g.m4247b(b);
                tsPayloadReader.mo1384a(this.f13205g, z);
                this.f13205g.m4247b(extractorInput);
            }
        }
        this.f13205g.m4249c(b);
        return 0;
    }

    private void m12250d() {
        this.f13209k.clear();
        this.f13208j.clear();
        SparseArray a = this.f13207i.mo1381a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            this.f13208j.put(a.keyAt(i), a.valueAt(i));
        }
        this.f13208j.put(0, new SectionReader(new PatReader(this)));
        this.f13213o = null;
    }
}
