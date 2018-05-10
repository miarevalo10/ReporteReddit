package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser {
    private static final byte[] f5037b = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    private static final byte[] f5038c = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    private static final byte[] f5039d = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    final SubtitleService f5040a;
    private final Paint f5041e = new Paint();
    private final Paint f5042f;
    private final Canvas f5043g;
    private final DisplayDefinition f5044h;
    private final ClutDefinition f5045i;
    private Bitmap f5046j;

    private static final class ClutDefinition {
        public final int f4991a;
        public final int[] f4992b;
        public final int[] f4993c;
        public final int[] f4994d;

        public ClutDefinition(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f4991a = i;
            this.f4992b = iArr;
            this.f4993c = iArr2;
            this.f4994d = iArr3;
        }
    }

    private static final class DisplayDefinition {
        public final int f4995a;
        public final int f4996b;
        public final int f4997c;
        public final int f4998d;
        public final int f4999e;
        public final int f5000f;

        public DisplayDefinition(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f4995a = i;
            this.f4996b = i2;
            this.f4997c = i3;
            this.f4998d = i4;
            this.f4999e = i5;
            this.f5000f = i6;
        }
    }

    private static final class ObjectData {
        public final int f5001a;
        public final boolean f5002b;
        public final byte[] f5003c;
        public final byte[] f5004d;

        public ObjectData(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f5001a = i;
            this.f5002b = z;
            this.f5003c = bArr;
            this.f5004d = bArr2;
        }
    }

    private static final class PageComposition {
        public final int f5005a;
        public final int f5006b;
        public final int f5007c;
        public final SparseArray<PageRegion> f5008d;

        public PageComposition(int i, int i2, int i3, SparseArray<PageRegion> sparseArray) {
            this.f5005a = i;
            this.f5006b = i2;
            this.f5007c = i3;
            this.f5008d = sparseArray;
        }
    }

    private static final class PageRegion {
        public final int f5009a;
        public final int f5010b;

        public PageRegion(int i, int i2) {
            this.f5009a = i;
            this.f5010b = i2;
        }
    }

    private static final class RegionComposition {
        public final int f5011a;
        public final boolean f5012b;
        public final int f5013c;
        public final int f5014d;
        public final int f5015e;
        public final int f5016f;
        public final int f5017g;
        public final int f5018h;
        public final int f5019i;
        public final int f5020j;
        public final SparseArray<RegionObject> f5021k;

        public RegionComposition(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<RegionObject> sparseArray) {
            this.f5011a = i;
            this.f5012b = z;
            this.f5013c = i2;
            this.f5014d = i3;
            this.f5015e = i4;
            this.f5016f = i5;
            this.f5017g = i6;
            this.f5018h = i7;
            this.f5019i = i8;
            this.f5020j = i9;
            this.f5021k = sparseArray;
        }

        public final void m4065a(RegionComposition regionComposition) {
            if (regionComposition != null) {
                regionComposition = regionComposition.f5021k;
                for (int i = 0; i < regionComposition.size(); i++) {
                    this.f5021k.put(regionComposition.keyAt(i), regionComposition.valueAt(i));
                }
            }
        }
    }

    private static final class RegionObject {
        public final int f5022a;
        public final int f5023b;
        public final int f5024c;
        public final int f5025d;
        public final int f5026e;
        public final int f5027f;

        public RegionObject(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f5022a = i;
            this.f5023b = i2;
            this.f5024c = i3;
            this.f5025d = i4;
            this.f5026e = i5;
            this.f5027f = i6;
        }
    }

    private static final class SubtitleService {
        public final int f5028a;
        public final int f5029b;
        public final SparseArray<RegionComposition> f5030c = new SparseArray();
        public final SparseArray<ClutDefinition> f5031d = new SparseArray();
        public final SparseArray<ObjectData> f5032e = new SparseArray();
        public final SparseArray<ClutDefinition> f5033f = new SparseArray();
        public final SparseArray<ObjectData> f5034g = new SparseArray();
        public DisplayDefinition f5035h;
        public PageComposition f5036i;

        public SubtitleService(int i, int i2) {
            this.f5028a = i;
            this.f5029b = i2;
        }
    }

    private static int m4066a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    public DvbParser(int i, int i2) {
        this.f5041e.setStyle(Style.FILL_AND_STROKE);
        this.f5041e.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.f5041e.setPathEffect(null);
        this.f5042f = new Paint();
        this.f5042f.setStyle(Style.FILL);
        this.f5042f.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.f5042f.setPathEffect(null);
        this.f5043g = new Canvas();
        this.f5044h = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.f5045i = new ClutDefinition(0, m4071a(), m4073b(), m4074c());
        this.f5040a = new SubtitleService(i, i2);
    }

    public final List<Cue> m4075a(byte[] bArr, int i) {
        DvbParser dvbParser = this;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i);
        while (true) {
            int i2;
            int c;
            int i3;
            int c2;
            int c3;
            int c4;
            int i4 = 1;
            if (parsableBitArray.m4230a() >= 48) {
                i2 = 8;
                if (parsableBitArray.m4236c(8) == 15) {
                    SubtitleService subtitleService = dvbParser.f5040a;
                    c = parsableBitArray.m4236c(8);
                    i3 = 16;
                    int c5 = parsableBitArray.m4236c(16);
                    c2 = parsableBitArray.m4236c(16);
                    int b = parsableBitArray.m4233b() + c2;
                    if (c2 * 8 > parsableBitArray.m4230a()) {
                        Log.w("DvbParser", "Data field length exceeds limit");
                        parsableBitArray.m4234b(parsableBitArray.m4230a());
                    } else {
                        PageComposition pageComposition;
                        switch (c) {
                            case 16:
                                if (c5 == subtitleService.f5028a) {
                                    PageComposition pageComposition2 = subtitleService.f5036i;
                                    c = parsableBitArray.m4236c(8);
                                    c5 = parsableBitArray.m4236c(4);
                                    int c6 = parsableBitArray.m4236c(2);
                                    parsableBitArray.m4234b(2);
                                    c2 -= 2;
                                    SparseArray sparseArray = new SparseArray();
                                    while (c2 > 0) {
                                        c3 = parsableBitArray.m4236c(i2);
                                        parsableBitArray.m4234b(i2);
                                        c2 -= 6;
                                        sparseArray.put(c3, new PageRegion(parsableBitArray.m4236c(i3), parsableBitArray.m4236c(i3)));
                                        i2 = 8;
                                        i3 = 16;
                                    }
                                    pageComposition = new PageComposition(c, c5, c6, sparseArray);
                                    if (pageComposition.f5007c == 0) {
                                        if (!(pageComposition2 == null || pageComposition2.f5006b == pageComposition.f5006b)) {
                                            subtitleService.f5036i = pageComposition;
                                            break;
                                        }
                                    }
                                    subtitleService.f5036i = pageComposition;
                                    subtitleService.f5030c.clear();
                                    subtitleService.f5031d.clear();
                                    subtitleService.f5032e.clear();
                                    break;
                                }
                                break;
                            case 17:
                                pageComposition = subtitleService.f5036i;
                                if (c5 == subtitleService.f5028a && pageComposition != null) {
                                    RegionComposition a = m4068a(parsableBitArray, c2);
                                    if (pageComposition.f5007c == 0) {
                                        a.m4065a((RegionComposition) subtitleService.f5030c.get(a.f5011a));
                                    }
                                    subtitleService.f5030c.put(a.f5011a, a);
                                    break;
                                }
                            case 18:
                                ClutDefinition b2;
                                if (c5 != subtitleService.f5028a) {
                                    if (c5 == subtitleService.f5029b) {
                                        b2 = m4072b(parsableBitArray, c2);
                                        subtitleService.f5033f.put(b2.f4991a, b2);
                                        break;
                                    }
                                }
                                b2 = m4072b(parsableBitArray, c2);
                                subtitleService.f5031d.put(b2.f4991a, b2);
                                break;
                                break;
                            case 19:
                                ObjectData a2;
                                if (c5 != subtitleService.f5028a) {
                                    if (c5 == subtitleService.f5029b) {
                                        a2 = m4067a(parsableBitArray);
                                        subtitleService.f5034g.put(a2.f5001a, a2);
                                        break;
                                    }
                                }
                                a2 = m4067a(parsableBitArray);
                                subtitleService.f5032e.put(a2.f5001a, a2);
                                break;
                                break;
                            case 20:
                                if (c5 == subtitleService.f5028a) {
                                    int c7;
                                    int c8;
                                    int c9;
                                    int c10;
                                    parsableBitArray.m4234b(4);
                                    boolean c11 = parsableBitArray.m4237c();
                                    parsableBitArray.m4234b(3);
                                    c3 = parsableBitArray.m4236c(16);
                                    c4 = parsableBitArray.m4236c(16);
                                    if (c11) {
                                        c7 = parsableBitArray.m4236c(16);
                                        c8 = parsableBitArray.m4236c(16);
                                        c9 = parsableBitArray.m4236c(16);
                                        c10 = parsableBitArray.m4236c(16);
                                    } else {
                                        c8 = c3;
                                        c10 = c4;
                                        c7 = 0;
                                        c9 = 0;
                                    }
                                    subtitleService.f5035h = new DisplayDefinition(c3, c4, c7, c8, c9, c10);
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                        b -= parsableBitArray.m4233b();
                        Assertions.m4186b(parsableBitArray.f5254c == 0);
                        parsableBitArray.f5253b += b;
                        parsableBitArray.m4239e();
                    }
                }
            }
            if (dvbParser.f5040a.f5036i == null) {
                return Collections.emptyList();
            }
            DisplayDefinition displayDefinition = dvbParser.f5040a.f5035h != null ? dvbParser.f5040a.f5035h : dvbParser.f5044h;
            if (!(dvbParser.f5046j != null && displayDefinition.f4995a + 1 == dvbParser.f5046j.getWidth() && displayDefinition.f4996b + 1 == dvbParser.f5046j.getHeight())) {
                dvbParser.f5046j = Bitmap.createBitmap(displayDefinition.f4995a + 1, displayDefinition.f4996b + 1, Config.ARGB_8888);
                dvbParser.f5043g.setBitmap(dvbParser.f5046j);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray2 = dvbParser.f5040a.f5036i.f5008d;
            c = 0;
            while (c < sparseArray2.size()) {
                SparseArray sparseArray3;
                int i5;
                ArrayList arrayList2;
                int i6;
                Object obj;
                Object obj2;
                PageRegion pageRegion = (PageRegion) sparseArray2.valueAt(c);
                RegionComposition regionComposition = (RegionComposition) dvbParser.f5040a.f5030c.get(sparseArray2.keyAt(c));
                c2 = pageRegion.f5009a + displayDefinition.f4997c;
                i3 = pageRegion.f5010b + displayDefinition.f4999e;
                float f = (float) c2;
                float f2 = (float) i3;
                float f3 = f;
                dvbParser.f5043g.clipRect(f, f2, (float) Math.min(regionComposition.f5013c + c2, displayDefinition.f4998d), (float) Math.min(regionComposition.f5014d + i3, displayDefinition.f5000f), Op.REPLACE);
                ClutDefinition clutDefinition = (ClutDefinition) dvbParser.f5040a.f5031d.get(regionComposition.f5017g);
                if (clutDefinition == null) {
                    clutDefinition = (ClutDefinition) dvbParser.f5040a.f5033f.get(regionComposition.f5017g);
                    if (clutDefinition == null) {
                        clutDefinition = dvbParser.f5045i;
                    }
                }
                SparseArray sparseArray4 = regionComposition.f5021k;
                c3 = 0;
                while (c3 < sparseArray4.size()) {
                    SparseArray sparseArray5;
                    c4 = sparseArray4.keyAt(c3);
                    RegionObject regionObject = (RegionObject) sparseArray4.valueAt(c3);
                    ObjectData objectData = (ObjectData) dvbParser.f5040a.f5032e.get(c4);
                    if (objectData == null) {
                        objectData = (ObjectData) dvbParser.f5040a.f5034g.get(c4);
                    }
                    if (objectData != null) {
                        int[] iArr;
                        Paint paint = objectData.f5002b ? null : dvbParser.f5041e;
                        int i7 = regionComposition.f5016f;
                        sparseArray3 = sparseArray2;
                        int i8 = regionObject.f5024c + c2;
                        i4 = regionObject.f5025d + i3;
                        sparseArray5 = sparseArray4;
                        Canvas canvas = dvbParser.f5043g;
                        i5 = c;
                        if (i7 == 3) {
                            iArr = clutDefinition.f4994d;
                        } else if (i7 == 2) {
                            iArr = clutDefinition.f4993c;
                        } else {
                            iArr = clutDefinition.f4992b;
                        }
                        arrayList2 = arrayList;
                        int[] iArr2 = iArr;
                        int i9 = i7;
                        int i10 = i8;
                        Paint paint2 = paint;
                        Canvas canvas2 = canvas;
                        m4069a(objectData.f5003c, iArr2, i9, i10, i4, paint2, canvas2);
                        byte[] bArr2 = objectData.f5004d;
                        i6 = 1;
                        m4069a(bArr2, iArr2, i9, i10, i4 + 1, paint2, canvas2);
                    } else {
                        arrayList2 = arrayList;
                        sparseArray3 = sparseArray2;
                        i5 = c;
                        sparseArray5 = sparseArray4;
                        i6 = 1;
                    }
                    c3++;
                    i4 = i6;
                    sparseArray2 = sparseArray3;
                    sparseArray4 = sparseArray5;
                    c = i5;
                    arrayList = arrayList2;
                }
                arrayList2 = arrayList;
                sparseArray3 = sparseArray2;
                i6 = i4;
                i5 = c;
                if (regionComposition.f5012b) {
                    obj = 3;
                    if (regionComposition.f5016f == 3) {
                        i2 = clutDefinition.f4994d[regionComposition.f5018h];
                        obj2 = 2;
                    } else {
                        obj2 = 2;
                        if (regionComposition.f5016f == 2) {
                            i2 = clutDefinition.f4993c[regionComposition.f5019i];
                        } else {
                            i2 = clutDefinition.f4992b[regionComposition.f5020j];
                        }
                    }
                    dvbParser.f5042f.setColor(i2);
                    dvbParser.f5043g.drawRect(f3, f2, (float) (regionComposition.f5013c + c2), (float) (regionComposition.f5014d + i3), dvbParser.f5042f);
                } else {
                    obj = 3;
                    obj2 = 2;
                }
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new Cue(Bitmap.createBitmap(dvbParser.f5046j, c2, i3, regionComposition.f5013c, regionComposition.f5014d), f3 / ((float) displayDefinition.f4995a), f2 / ((float) displayDefinition.f4996b), ((float) regionComposition.f5013c) / ((float) displayDefinition.f4995a), ((float) regionComposition.f5014d) / ((float) displayDefinition.f4996b)));
                dvbParser.f5043g.drawColor(0, Mode.CLEAR);
                c = i5 + 1;
                i4 = i6;
                arrayList = arrayList3;
                Object obj3 = obj2;
                obj2 = obj;
                sparseArray2 = sparseArray3;
            }
            return arrayList;
        }
    }

    private static RegionComposition m4068a(ParsableBitArray parsableBitArray, int i) {
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int c = parsableBitArray2.m4236c(8);
        parsableBitArray2.m4234b(4);
        boolean c2 = parsableBitArray.m4237c();
        parsableBitArray2.m4234b(3);
        int i2 = 16;
        int c3 = parsableBitArray2.m4236c(16);
        int c4 = parsableBitArray2.m4236c(16);
        int c5 = parsableBitArray2.m4236c(3);
        int c6 = parsableBitArray2.m4236c(3);
        int i3 = 2;
        parsableBitArray2.m4234b(2);
        int c7 = parsableBitArray2.m4236c(8);
        int c8 = parsableBitArray2.m4236c(8);
        int c9 = parsableBitArray2.m4236c(4);
        int c10 = parsableBitArray2.m4236c(2);
        parsableBitArray2.m4234b(2);
        int i4 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int i5;
            int i6;
            int c11 = parsableBitArray2.m4236c(i2);
            i2 = parsableBitArray2.m4236c(i3);
            int c12 = parsableBitArray2.m4236c(i3);
            int c13 = parsableBitArray2.m4236c(12);
            int i7 = c10;
            parsableBitArray2.m4234b(4);
            int c14 = parsableBitArray2.m4236c(12);
            i4 -= 6;
            if (i2 != 1) {
                if (i2 != 2) {
                    i5 = 0;
                    i6 = i5;
                    sparseArray.put(c11, new RegionObject(i2, c12, c13, c14, i5, i6));
                    c11 = 4;
                    c10 = i7;
                    i3 = 2;
                    i2 = 16;
                }
            }
            i4 -= 2;
            i5 = parsableBitArray2.m4236c(8);
            i6 = parsableBitArray2.m4236c(8);
            sparseArray.put(c11, new RegionObject(i2, c12, c13, c14, i5, i6));
            c11 = 4;
            c10 = i7;
            i3 = 2;
            i2 = 16;
        }
        return new RegionComposition(c, c2, c3, c4, c5, c6, c7, c8, c9, c10, sparseArray);
    }

    private static ClutDefinition m4072b(ParsableBitArray parsableBitArray, int i) {
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i2 = 8;
        int c = parsableBitArray2.m4236c(8);
        parsableBitArray2.m4234b(8);
        int i3 = 2;
        int i4 = i - 2;
        int[] a = m4071a();
        int[] b = m4073b();
        int[] c2 = m4074c();
        while (i4 > 0) {
            int c3;
            int c4;
            int c5;
            int c6 = parsableBitArray2.m4236c(i2);
            int c7 = parsableBitArray2.m4236c(i2);
            i4 -= 2;
            int[] iArr = (c7 & 128) != 0 ? a : (c7 & 64) != 0 ? b : c2;
            if ((c7 & 1) != 0) {
                c7 = parsableBitArray2.m4236c(i2);
                c3 = parsableBitArray2.m4236c(i2);
                c4 = parsableBitArray2.m4236c(i2);
                c5 = parsableBitArray2.m4236c(i2);
                i4 -= 4;
            } else {
                c4 = parsableBitArray2.m4236c(4) << 4;
                i4 -= 2;
                c5 = parsableBitArray2.m4236c(i3) << 6;
                c7 = parsableBitArray2.m4236c(6) << i3;
                c3 = parsableBitArray2.m4236c(4) << 4;
            }
            if (c7 == 0) {
                c5 = 255;
                c3 = 0;
                c4 = 0;
            }
            int i5 = i4;
            double d = (double) c7;
            int i6 = c;
            double d2 = (double) (c3 - 128);
            double d3 = (double) (c4 - 128);
            iArr[c6] = m4066a((byte) (255 - (c5 & 255)), Util.m4297a((int) (d + (1.402d * d2)), 0, 255), Util.m4297a((int) ((d - (0.34414d * d3)) - (0.71414d * d2)), 0, 255), Util.m4297a((int) (d + (1.772d * d3)), 0, 255));
            i4 = i5;
            c = i6;
            i2 = 8;
            i3 = 2;
        }
        return new ClutDefinition(c, a, b, c2);
    }

    private static ObjectData m4067a(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int c = parsableBitArray.m4236c(16);
        parsableBitArray.m4234b(4);
        int c2 = parsableBitArray.m4236c(2);
        boolean c3 = parsableBitArray.m4237c();
        parsableBitArray.m4234b(1);
        byte[] bArr2 = null;
        if (c2 == 1) {
            parsableBitArray.m4234b(parsableBitArray.m4236c(8) * 16);
        } else if (c2 == 0) {
            c2 = parsableBitArray.m4236c(16);
            int c4 = parsableBitArray.m4236c(16);
            if (c2 > 0) {
                bArr2 = new byte[c2];
                parsableBitArray.m4235b(bArr2, c2);
            }
            if (c4 > 0) {
                bArr = new byte[c4];
                parsableBitArray.m4235b(bArr, c4);
                return new ObjectData(c, c3, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(c, c3, bArr2, bArr);
    }

    private static int[] m4071a() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] m4073b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = m4066a(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = 127;
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = m4066a(255, i3, i4, i2);
            }
        }
        return iArr;
    }

    private static int[] m4074c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            int i2 = 255;
            int i3;
            int i4;
            if (i < 8) {
                i3 = (i & 1) != 0 ? 255 : 0;
                i4 = (i & 2) != 0 ? 255 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = m4066a(63, i3, i4, i2);
            } else {
                i3 = i & 136;
                i4 = 170;
                int i5 = 85;
                int i6;
                if (i3 == 0) {
                    i6 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    i3 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i5 = 0;
                    }
                    if ((i & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i] = m4066a(255, i6, i3, i5 + i4);
                } else if (i3 != 8) {
                    i4 = 43;
                    if (i3 == 128) {
                        i6 = (((i & 1) != 0 ? 43 : 0) + 127) + ((i & 16) != 0 ? 85 : 0);
                        i3 = (((i & 2) != 0 ? 43 : 0) + 127) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i4 = 0;
                        }
                        int i7 = 127 + i4;
                        if ((i & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i] = m4066a(255, i6, i3, i7 + i5);
                    } else if (i3 == 136) {
                        i6 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        i3 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i4 = 0;
                        }
                        if ((i & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i] = m4066a(255, i6, i3, i4 + i5);
                    }
                } else {
                    i6 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    i2 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i5 = 0;
                    }
                    if ((i & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i] = m4066a(127, i6, i2, i5 + i4);
                }
            }
        }
        return iArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4069a(byte[] r24, int[] r25, int r26, int r27, int r28, android.graphics.Paint r29, android.graphics.Canvas r30) {
        /*
        r0 = r26;
        r7 = r29;
        r8 = new com.google.android.exoplayer2.util.ParsableBitArray;
        r1 = r24;
        r8.<init>(r1);
        r1 = r27;
        r10 = r28;
        r11 = 0;
        r12 = 0;
    L_0x0011:
        r2 = r8.m4230a();
        if (r2 == 0) goto L_0x01fb;
    L_0x0017:
        r13 = 8;
        r2 = r8.m4236c(r13);
        r3 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        if (r2 == r3) goto L_0x01f5;
    L_0x0021:
        r14 = 3;
        r6 = 4;
        r15 = 1;
        r16 = 0;
        r5 = 2;
        switch(r2) {
            case 16: goto L_0x013f;
            case 17: goto L_0x0096;
            case 18: goto L_0x003f;
            default: goto L_0x002a;
        };
    L_0x002a:
        switch(r2) {
            case 32: goto L_0x003a;
            case 33: goto L_0x0035;
            case 34: goto L_0x002e;
            default: goto L_0x002d;
        };
    L_0x002d:
        goto L_0x0011;
    L_0x002e:
        r2 = 16;
        r11 = m4070a(r2, r13, r8);
        goto L_0x0011;
    L_0x0035:
        r11 = m4070a(r6, r13, r8);
        goto L_0x0011;
    L_0x003a:
        r12 = m4070a(r6, r6, r8);
        goto L_0x0011;
    L_0x003f:
        r14 = r1;
        r1 = r16;
    L_0x0042:
        r2 = r8.m4236c(r13);
        if (r2 == 0) goto L_0x004d;
    L_0x0048:
        r18 = r1;
        r17 = r15;
        goto L_0x0075;
    L_0x004d:
        r2 = r8.m4237c();
        r3 = 7;
        if (r2 != 0) goto L_0x0068;
    L_0x0054:
        r2 = r8.m4236c(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x005a:
        r18 = r1;
        r17 = r2;
        r2 = r16;
        goto L_0x0075;
    L_0x0061:
        r18 = r15;
        r2 = r16;
        r17 = r2;
        goto L_0x0075;
    L_0x0068:
        r2 = r8.m4236c(r3);
        r3 = r8.m4236c(r13);
        r18 = r1;
        r17 = r2;
        r2 = r3;
    L_0x0075:
        if (r17 == 0) goto L_0x008c;
    L_0x0077:
        if (r7 == 0) goto L_0x008c;
    L_0x0079:
        r1 = r25[r2];
        r7.setColor(r1);
        r2 = (float) r14;
        r3 = (float) r10;
        r1 = r14 + r17;
        r4 = (float) r1;
        r1 = r10 + 1;
        r5 = (float) r1;
        r1 = r30;
        r6 = r7;
        r1.drawRect(r2, r3, r4, r5, r6);
    L_0x008c:
        r14 = r14 + r17;
        if (r18 == 0) goto L_0x0093;
    L_0x0090:
        r1 = r14;
        goto L_0x0011;
    L_0x0093:
        r1 = r18;
        goto L_0x0042;
    L_0x0096:
        if (r0 != r14) goto L_0x009d;
    L_0x0098:
        r2 = f5039d;
        r17 = r2;
        goto L_0x009f;
    L_0x009d:
        r17 = 0;
    L_0x009f:
        r4 = r1;
        r1 = r16;
    L_0x00a2:
        r2 = r8.m4236c(r6);
        if (r2 == 0) goto L_0x00ae;
    L_0x00a8:
        r19 = r1;
        r3 = r2;
        r18 = r15;
        goto L_0x0109;
    L_0x00ae:
        r2 = r8.m4237c();
        if (r2 != 0) goto L_0x00c9;
    L_0x00b4:
        r2 = r8.m4236c(r14);
        if (r2 == 0) goto L_0x00c2;
    L_0x00ba:
        r2 = r2 + r5;
        r19 = r1;
        r18 = r2;
    L_0x00bf:
        r3 = r16;
        goto L_0x0109;
    L_0x00c2:
        r19 = r15;
    L_0x00c4:
        r3 = r16;
        r18 = r3;
        goto L_0x0109;
    L_0x00c9:
        r2 = r8.m4237c();
        if (r2 != 0) goto L_0x00dd;
    L_0x00cf:
        r2 = r8.m4236c(r5);
        r2 = r2 + r6;
        r3 = r8.m4236c(r6);
    L_0x00d8:
        r19 = r1;
        r18 = r2;
        goto L_0x0109;
    L_0x00dd:
        r2 = r8.m4236c(r5);
        switch(r2) {
            case 0: goto L_0x0104;
            case 1: goto L_0x00ff;
            case 2: goto L_0x00f3;
            case 3: goto L_0x00e7;
            default: goto L_0x00e4;
        };
    L_0x00e4:
        r19 = r1;
        goto L_0x00c4;
    L_0x00e7:
        r2 = 25;
        r3 = r8.m4236c(r13);
        r2 = r2 + r3;
        r3 = r8.m4236c(r6);
        goto L_0x00d8;
    L_0x00f3:
        r2 = 9;
        r3 = r8.m4236c(r6);
        r2 = r2 + r3;
        r3 = r8.m4236c(r6);
        goto L_0x00d8;
    L_0x00ff:
        r19 = r1;
        r18 = r5;
        goto L_0x00bf;
    L_0x0104:
        r19 = r1;
        r18 = r15;
        goto L_0x00bf;
    L_0x0109:
        if (r18 == 0) goto L_0x012c;
    L_0x010b:
        if (r7 == 0) goto L_0x012c;
    L_0x010d:
        if (r17 == 0) goto L_0x0111;
    L_0x010f:
        r3 = r17[r3];
    L_0x0111:
        r1 = r25[r3];
        r7.setColor(r1);
        r2 = (float) r4;
        r3 = (float) r10;
        r1 = r4 + r18;
        r1 = (float) r1;
        r5 = r10 + 1;
        r5 = (float) r5;
        r21 = r1;
        r1 = r30;
        r22 = r4;
        r4 = r21;
        r9 = 2;
        r6 = r7;
        r1.drawRect(r2, r3, r4, r5, r6);
        goto L_0x012f;
    L_0x012c:
        r22 = r4;
        r9 = r5;
    L_0x012f:
        r4 = r22 + r18;
        if (r19 == 0) goto L_0x0139;
    L_0x0133:
        r8.m4238d();
        r1 = r4;
        goto L_0x0011;
    L_0x0139:
        r5 = r9;
        r1 = r19;
        r6 = 4;
        goto L_0x00a2;
    L_0x013f:
        r9 = r5;
        if (r0 != r14) goto L_0x014b;
    L_0x0142:
        if (r11 != 0) goto L_0x0147;
    L_0x0144:
        r2 = f5038c;
        goto L_0x0148;
    L_0x0147:
        r2 = r11;
    L_0x0148:
        r17 = r2;
        goto L_0x0156;
    L_0x014b:
        if (r0 != r9) goto L_0x0154;
    L_0x014d:
        if (r12 != 0) goto L_0x0152;
    L_0x014f:
        r2 = f5037b;
        goto L_0x0148;
    L_0x0152:
        r2 = r12;
        goto L_0x0148;
    L_0x0154:
        r17 = 0;
    L_0x0156:
        r6 = r1;
        r1 = r16;
    L_0x0159:
        r2 = r8.m4236c(r9);
        if (r2 == 0) goto L_0x0166;
    L_0x015f:
        r19 = r1;
        r3 = r2;
        r18 = r15;
    L_0x0164:
        r5 = 4;
        goto L_0x01bf;
    L_0x0166:
        r2 = r8.m4237c();
        if (r2 == 0) goto L_0x017a;
    L_0x016c:
        r2 = r8.m4236c(r14);
        r2 = r2 + r14;
        r3 = r8.m4236c(r9);
    L_0x0175:
        r19 = r1;
        r18 = r2;
        goto L_0x0164;
    L_0x017a:
        r2 = r8.m4237c();
        if (r2 == 0) goto L_0x0187;
    L_0x0180:
        r19 = r1;
        r18 = r15;
        r3 = r16;
        goto L_0x0164;
    L_0x0187:
        r2 = r8.m4236c(r9);
        switch(r2) {
            case 0: goto L_0x01bb;
            case 1: goto L_0x01b3;
            case 2: goto L_0x01a2;
            case 3: goto L_0x0196;
            default: goto L_0x018e;
        };
    L_0x018e:
        r5 = 4;
        r19 = r1;
    L_0x0191:
        r3 = r16;
        r18 = r3;
        goto L_0x01bf;
    L_0x0196:
        r2 = 29;
        r3 = r8.m4236c(r13);
        r2 = r2 + r3;
        r3 = r8.m4236c(r9);
        goto L_0x0175;
    L_0x01a2:
        r2 = 12;
        r5 = 4;
        r3 = r8.m4236c(r5);
        r2 = r2 + r3;
        r3 = r8.m4236c(r9);
        r19 = r1;
        r18 = r2;
        goto L_0x01bf;
    L_0x01b3:
        r5 = 4;
        r19 = r1;
        r18 = r9;
        r3 = r16;
        goto L_0x01bf;
    L_0x01bb:
        r5 = 4;
        r19 = r15;
        goto L_0x0191;
    L_0x01bf:
        if (r18 == 0) goto L_0x01e3;
    L_0x01c1:
        if (r7 == 0) goto L_0x01e3;
    L_0x01c3:
        if (r17 == 0) goto L_0x01c7;
    L_0x01c5:
        r3 = r17[r3];
    L_0x01c7:
        r1 = r25[r3];
        r7.setColor(r1);
        r2 = (float) r6;
        r3 = (float) r10;
        r1 = r6 + r18;
        r4 = (float) r1;
        r1 = r10 + 1;
        r1 = (float) r1;
        r20 = r1;
        r1 = r30;
        r21 = r5;
        r5 = r20;
        r20 = r6;
        r6 = r7;
        r1.drawRect(r2, r3, r4, r5, r6);
        goto L_0x01e7;
    L_0x01e3:
        r21 = r5;
        r20 = r6;
    L_0x01e7:
        r6 = r20 + r18;
        if (r19 == 0) goto L_0x01f1;
    L_0x01eb:
        r8.m4238d();
        r1 = r6;
        goto L_0x0011;
    L_0x01f1:
        r1 = r19;
        goto L_0x0159;
    L_0x01f5:
        r10 = r10 + 2;
        r1 = r27;
        goto L_0x0011;
    L_0x01fb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.a(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] m4070a(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.m4236c(i2);
        }
        return bArr;
    }
}
