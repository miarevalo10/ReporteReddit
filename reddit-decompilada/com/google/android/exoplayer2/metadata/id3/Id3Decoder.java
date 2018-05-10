package com.google.android.exoplayer2.metadata.id3;

import android.util.Log;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class Id3Decoder implements MetadataDecoder {
    public static final int f13228a = Util.m4326g("ID3");
    private final FramePredicate f13229b;

    public interface FramePredicate {
        boolean mo1347a(int i, int i2, int i3, int i4, int i5);
    }

    private static final class Id3Header {
        private final int f4668a;
        private final boolean f4669b;
        private final int f4670c;

        public Id3Header(int i, boolean z, int i2) {
            this.f4668a = i;
            this.f4669b = z;
            this.f4670c = i2;
        }
    }

    private static String m12287a(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static int m12290b(int i) {
        if (i != 0) {
            if (i != 3) {
                return 2;
            }
        }
        return 1;
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.f13229b = framePredicate;
    }

    public final Metadata mo1396a(MetadataInputBuffer metadataInputBuffer) {
        metadataInputBuffer = metadataInputBuffer.c;
        return m12295a(metadataInputBuffer.array(), metadataInputBuffer.limit());
    }

    public final Metadata m12295a(byte[] bArr, int i) {
        Id3Header id3Header;
        List arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        int i2 = 10;
        boolean z = false;
        if (parsableByteArray.m4246b() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            bArr = parsableByteArray.m4256g();
            StringBuilder stringBuilder;
            if (bArr != f13228a) {
                stringBuilder = new StringBuilder("Unexpected first three bytes of ID3 tag header: ");
                stringBuilder.append(bArr);
                Log.w("Id3Decoder", stringBuilder.toString());
            } else {
                bArr = parsableByteArray.m4250d();
                parsableByteArray.m4251d(1);
                int d = parsableByteArray.m4250d();
                int m = parsableByteArray.m4262m();
                if (bArr == 2) {
                    if ((d & 64) != 0) {
                        Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    }
                } else if (bArr == 3) {
                    if ((d & 64) != 0) {
                        r9 = parsableByteArray.m4259j();
                        parsableByteArray.m4251d(r9);
                        m -= r9 + 4;
                    }
                } else if (bArr == 4) {
                    if ((d & 64) != 0) {
                        r9 = parsableByteArray.m4262m();
                        parsableByteArray.m4251d(r9 - 4);
                        m -= r9;
                    }
                    if ((d & 16) != 0) {
                        m -= 10;
                    }
                } else {
                    stringBuilder = new StringBuilder("Skipped ID3 tag with unsupported majorVersion=");
                    stringBuilder.append(bArr);
                    Log.w("Id3Decoder", stringBuilder.toString());
                }
                boolean z2 = bArr < 4 && (d & 128) != 0;
                id3Header = new Id3Header(bArr, z2, m);
                if (id3Header == null) {
                    return null;
                }
                bArr = parsableByteArray.f5257b;
                if (id3Header.f4668a == 2) {
                    i2 = 6;
                }
                i = id3Header.f4670c;
                if (id3Header.f4669b) {
                    i = m12283a(parsableByteArray, id3Header.f4670c);
                }
                parsableByteArray.m4247b(bArr + i);
                if (m12289a(parsableByteArray, id3Header.f4668a, i2, false) == null) {
                    if (id3Header.f4668a == 4 || m12289a(parsableByteArray, 4, i2, true) == null) {
                        i = new StringBuilder("Failed to validate ID3 tag with majorVersion=");
                        i.append(id3Header.f4668a);
                        Log.w("Id3Decoder", i.toString());
                        return null;
                    }
                    z = true;
                }
                while (parsableByteArray.m4246b() >= i2) {
                    bArr = m12286a(id3Header.f4668a, parsableByteArray, z, i2, this.f13229b);
                    if (bArr != null) {
                        arrayList.add(bArr);
                    }
                }
                return new Metadata(arrayList);
            }
        }
        id3Header = null;
        if (id3Header == null) {
            return null;
        }
        bArr = parsableByteArray.f5257b;
        if (id3Header.f4668a == 2) {
            i2 = 6;
        }
        i = id3Header.f4670c;
        if (id3Header.f4669b) {
            i = m12283a(parsableByteArray, id3Header.f4670c);
        }
        parsableByteArray.m4247b(bArr + i);
        if (m12289a(parsableByteArray, id3Header.f4668a, i2, false) == null) {
            if (id3Header.f4668a == 4) {
            }
            i = new StringBuilder("Failed to validate ID3 tag with majorVersion=");
            i.append(id3Header.f4668a);
            Log.w("Id3Decoder", i.toString());
            return null;
        }
        while (parsableByteArray.m4246b() >= i2) {
            bArr = m12286a(id3Header.f4668a, parsableByteArray, z, i2, this.f13229b);
            if (bArr != null) {
                arrayList.add(bArr);
            }
        }
        return new Metadata(arrayList);
    }

    private static com.google.android.exoplayer2.metadata.id3.Id3Frame m12286a(int r20, com.google.android.exoplayer2.util.ParsableByteArray r21, boolean r22, int r23, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r24) {
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
        r7 = r20;
        r8 = r21;
        r9 = r21.m4250d();
        r10 = r21.m4250d();
        r11 = r21.m4250d();
        r12 = 3;
        if (r7 < r12) goto L_0x0019;
    L_0x0013:
        r1 = r21.m4250d();
        r14 = r1;
        goto L_0x001a;
    L_0x0019:
        r14 = 0;
    L_0x001a:
        r15 = 4;
        if (r7 != r15) goto L_0x003d;
    L_0x001d:
        r1 = r21.m4263n();
        if (r22 != 0) goto L_0x003a;
    L_0x0023:
        r2 = r1 & 255;
        r3 = r1 >> 8;
        r3 = r3 & 255;
        r3 = r3 << 7;
        r2 = r2 | r3;
        r3 = r1 >> 16;
        r3 = r3 & 255;
        r3 = r3 << 14;
        r2 = r2 | r3;
        r1 = r1 >> 24;
        r1 = r1 & 255;
        r1 = r1 << 21;
        r1 = r1 | r2;
    L_0x003a:
        r16 = r1;
        goto L_0x0049;
    L_0x003d:
        if (r7 != r12) goto L_0x0044;
    L_0x003f:
        r1 = r21.m4263n();
        goto L_0x003a;
    L_0x0044:
        r1 = r21.m4256g();
        goto L_0x003a;
    L_0x0049:
        if (r7 < r12) goto L_0x0051;
    L_0x004b:
        r1 = r21.m4252e();
        r6 = r1;
        goto L_0x0052;
    L_0x0051:
        r6 = 0;
    L_0x0052:
        r5 = 0;
        if (r9 != 0) goto L_0x0065;
    L_0x0055:
        if (r10 != 0) goto L_0x0065;
    L_0x0057:
        if (r11 != 0) goto L_0x0065;
    L_0x0059:
        if (r14 != 0) goto L_0x0065;
    L_0x005b:
        if (r16 != 0) goto L_0x0065;
    L_0x005d:
        if (r6 != 0) goto L_0x0065;
    L_0x005f:
        r1 = r8.f5258c;
        r8.m4249c(r1);
        return r5;
    L_0x0065:
        r1 = r8.f5257b;
        r4 = r1 + r16;
        r1 = r8.f5258c;
        if (r4 <= r1) goto L_0x007a;
    L_0x006d:
        r1 = "Id3Decoder";
        r2 = "Frame size exceeds remaining tag data";
        android.util.Log.w(r1, r2);
        r1 = r8.f5258c;
        r8.m4249c(r1);
        return r5;
    L_0x007a:
        if (r24 == 0) goto L_0x0091;
    L_0x007c:
        r1 = r24;
        r2 = r7;
        r3 = r9;
        r13 = r4;
        r4 = r10;
        r15 = r5;
        r5 = r11;
        r17 = r6;
        r6 = r14;
        r1 = r1.mo1347a(r2, r3, r4, r5, r6);
        if (r1 != 0) goto L_0x0095;
    L_0x008d:
        r8.m4249c(r13);
        return r15;
    L_0x0091:
        r13 = r4;
        r15 = r5;
        r17 = r6;
    L_0x0095:
        r1 = 1;
        if (r7 != r12) goto L_0x00b3;
    L_0x0098:
        r2 = r17;
        r3 = r2 & 128;
        if (r3 == 0) goto L_0x00a0;
    L_0x009e:
        r3 = r1;
        goto L_0x00a1;
    L_0x00a0:
        r3 = 0;
    L_0x00a1:
        r4 = r2 & 64;
        if (r4 == 0) goto L_0x00a7;
    L_0x00a5:
        r4 = r1;
        goto L_0x00a8;
    L_0x00a7:
        r4 = 0;
    L_0x00a8:
        r2 = r2 & 32;
        if (r2 == 0) goto L_0x00ae;
    L_0x00ac:
        r2 = r1;
        goto L_0x00af;
    L_0x00ae:
        r2 = 0;
    L_0x00af:
        r5 = r4;
        r6 = 0;
        r4 = r3;
        goto L_0x00e2;
    L_0x00b3:
        r2 = r17;
        r3 = 4;
        if (r7 != r3) goto L_0x00dd;
    L_0x00b8:
        r3 = r2 & 64;
        if (r3 == 0) goto L_0x00be;
    L_0x00bc:
        r3 = r1;
        goto L_0x00bf;
    L_0x00be:
        r3 = 0;
    L_0x00bf:
        r4 = r2 & 8;
        if (r4 == 0) goto L_0x00c5;
    L_0x00c3:
        r4 = r1;
        goto L_0x00c6;
    L_0x00c5:
        r4 = 0;
    L_0x00c6:
        r5 = r2 & 4;
        if (r5 == 0) goto L_0x00cc;
    L_0x00ca:
        r5 = r1;
        goto L_0x00cd;
    L_0x00cc:
        r5 = 0;
    L_0x00cd:
        r6 = r2 & 2;
        if (r6 == 0) goto L_0x00d3;
    L_0x00d1:
        r6 = r1;
        goto L_0x00d4;
    L_0x00d3:
        r6 = 0;
    L_0x00d4:
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x00da;
    L_0x00d7:
        r2 = r3;
        r3 = r1;
        goto L_0x00e2;
    L_0x00da:
        r2 = r3;
        r3 = 0;
        goto L_0x00e2;
    L_0x00dd:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
    L_0x00e2:
        if (r4 != 0) goto L_0x03ef;
    L_0x00e4:
        if (r5 == 0) goto L_0x00e8;
    L_0x00e6:
        goto L_0x03ef;
    L_0x00e8:
        if (r2 == 0) goto L_0x00ef;
    L_0x00ea:
        r16 = r16 + -1;
        r8.m4251d(r1);
    L_0x00ef:
        if (r3 == 0) goto L_0x00f7;
    L_0x00f1:
        r16 = r16 + -4;
        r2 = 4;
        r8.m4251d(r2);
    L_0x00f7:
        r2 = r16;
        if (r6 == 0) goto L_0x00ff;
    L_0x00fb:
        r2 = m12283a(r8, r2);
    L_0x00ff:
        r6 = r2;
        r2 = 84;
        r3 = 88;
        r4 = 2;
        if (r9 != r2) goto L_0x0149;
    L_0x0107:
        if (r10 != r3) goto L_0x0149;
    L_0x0109:
        if (r11 != r3) goto L_0x0149;
    L_0x010b:
        if (r7 == r4) goto L_0x010f;
    L_0x010d:
        if (r14 != r3) goto L_0x0149;
    L_0x010f:
        if (r6 > 0) goto L_0x0113;
    L_0x0111:
        r1 = r15;
        goto L_0x0171;
    L_0x0113:
        r1 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = m12287a(r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = r6 + -1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = new byte[r3];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r4, r5, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = m12284a(r4, r5, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12.<init>(r4, r5, r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = m12290b(r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = r3 + r5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = r4.length;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r3 >= r5) goto L_0x013f;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0134:
        r1 = m12284a(r4, r3, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = r1 - r3;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5.<init>(r4, r3, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x0141;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x013f:
        r5 = "";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0141:
        r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = "TXXX";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1.<init>(r2, r12, r5);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x0171;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0149:
        if (r9 != r2) goto L_0x017e;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x014b:
        r1 = m12288a(r7, r9, r10, r11, r14);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r6 > 0) goto L_0x0152;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0151:
        goto L_0x0111;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0152:
        r2 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = m12287a(r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = r6 + -1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new byte[r4];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r5, r12, r4);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = m12284a(r5, r12, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4.<init>(r5, r12, r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5.<init>(r1, r15, r4);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0170:
        r1 = r5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0171:
        r12 = r6;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r18 = r13;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x03a9;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0176:
        r0 = move-exception;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = r0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = r13;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x03eb;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x017b:
        r2 = r13;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x03dd;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x017e:
        r5 = 87;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r9 != r5) goto L_0x01c5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0182:
        if (r10 != r3) goto L_0x01c5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0184:
        if (r11 != r3) goto L_0x01c5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0186:
        if (r7 == r4) goto L_0x018a;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0188:
        if (r14 != r3) goto L_0x01c5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x018a:
        if (r6 > 0) goto L_0x018d;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x018c:
        goto L_0x0111;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x018d:
        r1 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = m12287a(r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = r6 + -1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = new byte[r3];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r4, r5, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = m12284a(r4, r5, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12.<init>(r4, r5, r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = m12290b(r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = r3 + r1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = r4.length;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r3 >= r1) goto L_0x01bb;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01ae:
        r1 = m12291b(r4, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = r1 - r3;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2.<init>(r4, r3, r1, r5);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x01bd;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01bb:
        r2 = "";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01bd:
        r5 = new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = "WXXX";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5.<init>(r1, r12, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x0170;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01c5:
        r3 = 87;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r9 != r3) goto L_0x01e5;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01c9:
        r1 = m12288a(r7, r9, r10, r11, r14);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = m12291b(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5.<init>(r2, r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2.<init>(r1, r15, r5);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01e3:
        r1 = r2;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x0171;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01e5:
        r3 = 73;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = 80;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r9 != r5) goto L_0x0212;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01eb:
        r15 = 82;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r10 != r15) goto L_0x0212;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01ef:
        if (r11 != r3) goto L_0x0212;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01f1:
        r15 = 86;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r14 != r15) goto L_0x0212;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x01f5:
        r2 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r2, r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = m12291b(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5.<init>(r2, r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = r4 + r1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = m12293b(r2, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = new com.google.android.exoplayer2.metadata.id3.PrivFrame;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2.<init>(r5, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        goto L_0x01e3;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0212:
        r15 = 71;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r2 = 79;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r9 != r15) goto L_0x0274;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0218:
        r15 = 69;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r10 != r15) goto L_0x0274;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x021c:
        if (r11 != r2) goto L_0x0274;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x021e:
        r15 = 66;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        if (r14 == r15) goto L_0x0224;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0222:
        if (r7 != r4) goto L_0x0274;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
    L_0x0224:
        r2 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r3 = m12287a(r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = r6 + -1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r5 = new byte[r4];	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = 0;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r8.m4245a(r5, r12, r4);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = m12291b(r5, r12);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r15 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r15.<init>(r5, r12, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = 1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r4 = r4 + r1;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r1 = m12284a(r5, r4, r2);	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r12 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x017b, all -> 0x0176 }
        r18 = r13;
        r13 = r1 - r4;
        r12.<init>(r5, r4, r13, r3);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = m12290b(r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = r1 + r4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = m12284a(r5, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r19 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r4 - r1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13.<init>(r5, r1, r6, r3);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12290b(r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = r4 + r1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12293b(r5, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = new com.google.android.exoplayer2.metadata.id3.GeobFrame;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2.<init>(r15, r12, r13, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x026f:
        r1 = r2;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = r19;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x03a9;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0274:
        r19 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r18 = r13;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = 67;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r7 != r4) goto L_0x0283;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x027c:
        if (r9 != r5) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x027e:
        if (r10 != r3) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0280:
        if (r11 != r1) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0282:
        goto L_0x028d;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0283:
        r6 = 65;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r9 != r6) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0287:
        if (r10 != r5) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0289:
        if (r11 != r3) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x028b:
        if (r14 != r1) goto L_0x030f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x028d:
        r1 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = m12287a(r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r19 + -1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = new byte[r6];	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r8.m4245a(r3, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r7 != r4) goto L_0x02c5;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x029f:
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = "image/";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5.<init>(r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r15 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6.<init>(r3, r15, r12, r13);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = com.google.android.exoplayer2.util.Util.m4323d(r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = "image/jpg";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r5.equals(r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r6 == 0) goto L_0x02c3;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x02c1:
        r5 = "image/jpeg";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x02c3:
        r6 = r4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x02ec;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x02c5:
        r5 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = m12291b(r3, r5);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12.<init>(r3, r5, r6, r13);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = com.google.android.exoplayer2.util.Util.m4323d(r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = 47;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = r5.indexOf(r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = -1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r12 != r13) goto L_0x02ec;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x02de:
        r12 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = "image/";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12.<init>(r13);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = r12.toString();	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x02ec:
        r12 = r6 + 1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = r3[r12];	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = r12 & 255;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r6 + r4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = m12284a(r3, r6, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r15 = r4 - r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13.<init>(r3, r6, r15, r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12290b(r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = r4 + r1;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = r3.length;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12293b(r3, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = new com.google.android.exoplayer2.metadata.id3.ApicFrame;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2.<init>(r5, r13, r12, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x026f;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x030f:
        if (r9 != r1) goto L_0x0363;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0311:
        if (r10 != r2) goto L_0x0363;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0313:
        r3 = 77;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r11 != r3) goto L_0x0363;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0317:
        r3 = 77;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r14 == r3) goto L_0x031d;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x031b:
        if (r7 != r4) goto L_0x0363;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x031d:
        r6 = r19;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = 4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r6 >= r1) goto L_0x0324;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0322:
        r1 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x0361;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0324:
        r1 = r21.m4250d();	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = m12287a(r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = new byte[r12];	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r8.m4245a(r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5.<init>(r3, r4, r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = r6 + -4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = new byte[r3];	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r8.m4245a(r12, r4, r3);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = m12284a(r12, r4, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r13.<init>(r12, r4, r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = m12290b(r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = r3 + r4;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = r12.length;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r3 >= r4) goto L_0x035a;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x034f:
        r1 = m12284a(r12, r3, r1);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = r1 - r3;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4.<init>(r12, r3, r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x035c;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x035a:
        r4 = "";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x035c:
        r1 = new com.google.android.exoplayer2.metadata.id3.CommentFrame;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1.<init>(r5, r13, r4);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0361:
        r12 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x03a9;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0363:
        r6 = r19;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r9 != r1) goto L_0x0380;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0367:
        r3 = 72;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r10 != r3) goto L_0x0380;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x036b:
        r3 = 65;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r11 != r3) goto L_0x0380;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x036f:
        if (r14 != r5) goto L_0x0380;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0371:
        r1 = r8;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = r7;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = r22;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = r23;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r12 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r24;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12285a(r1, r2, r3, r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x03a9;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0380:
        r12 = r6;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r9 != r1) goto L_0x0399;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0383:
        r3 = 84;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        if (r10 != r3) goto L_0x0399;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0387:
        if (r11 != r2) goto L_0x0399;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x0389:
        if (r14 != r1) goto L_0x0399;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
    L_0x038b:
        r1 = r8;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r2 = r12;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = r7;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = r22;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r5 = r23;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r6 = r24;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r1 = m12292b(r1, r2, r3, r4, r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x03a9;
    L_0x0399:
        r1 = m12288a(r7, r9, r10, r11, r14);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r2 = new byte[r12];	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r8.m4245a(r2, r3, r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r3 = new com.google.android.exoplayer2.metadata.id3.BinaryFrame;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r3.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03d9 }
        r1 = r3;
    L_0x03a9:
        if (r1 != 0) goto L_0x03d3;
    L_0x03ab:
        r2 = "Id3Decoder";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = "Failed to decode frame: id=";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = m12288a(r7, r9, r10, r11, r14);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r4 = ", frameSize=";	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3.append(r4);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3.append(r12);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        r3 = r3.toString();	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        android.util.Log.w(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x03d0, all -> 0x03cb }
        goto L_0x03d3;
    L_0x03cb:
        r0 = move-exception;
        r1 = r0;
        r2 = r18;
        goto L_0x03eb;
    L_0x03d0:
        r2 = r18;
        goto L_0x03dd;
    L_0x03d3:
        r2 = r18;
        r8.m4249c(r2);
        return r1;
    L_0x03d9:
        r0 = move-exception;
        r2 = r18;
        goto L_0x03ea;
    L_0x03dd:
        r1 = "Id3Decoder";	 Catch:{ all -> 0x03e9 }
        r3 = "Unsupported character encoding";	 Catch:{ all -> 0x03e9 }
        android.util.Log.w(r1, r3);	 Catch:{ all -> 0x03e9 }
        r8.m4249c(r2);
        r1 = 0;
        return r1;
    L_0x03e9:
        r0 = move-exception;
    L_0x03ea:
        r1 = r0;
    L_0x03eb:
        r8.m4249c(r2);
        throw r1;
    L_0x03ef:
        r2 = r13;
        r1 = "Id3Decoder";
        r3 = "Skipping unsupported compressed or encrypted frame";
        android.util.Log.w(r1, r3);
        r8.m4249c(r2);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.a(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static int m12283a(ParsableByteArray parsableByteArray, int i) {
        Object obj = parsableByteArray.f5256a;
        parsableByteArray = parsableByteArray.f5257b;
        while (true) {
            int i2 = parsableByteArray + 1;
            if (i2 >= i) {
                return i;
            }
            if ((obj[parsableByteArray] & 255) == 255 && obj[i2] == (byte) 0) {
                System.arraycopy(obj, parsableByteArray + 2, obj, i2, (i - parsableByteArray) - 2);
                i--;
            }
            parsableByteArray = i2;
        }
    }

    private static String m12288a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int m12284a(byte[] bArr, int i, int i2) {
        i = m12291b(bArr, i);
        if (i2 != 0) {
            if (i2 != 3) {
                while (i < bArr.length - 1) {
                    if (i % 2 == 0 && bArr[i + 1] == 0) {
                        return i;
                    }
                    i = m12291b(bArr, i + 1);
                }
                return bArr.length;
            }
        }
        return i;
    }

    private static int m12291b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] m12293b(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[null];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m12289a(com.google.android.exoplayer2.util.ParsableByteArray r19, int r20, int r21, boolean r22) {
        /*
        r1 = r19;
        r2 = r20;
        r3 = r1.f5257b;
    L_0x0006:
        r4 = r19.m4246b();	 Catch:{ all -> 0x00b7 }
        r5 = 1;
        r6 = r21;
        if (r4 < r6) goto L_0x00b3;
    L_0x000f:
        r4 = 3;
        r7 = 0;
        if (r2 < r4) goto L_0x0020;
    L_0x0013:
        r8 = r19.m4259j();	 Catch:{ all -> 0x00b7 }
        r9 = r19.m4257h();	 Catch:{ all -> 0x00b7 }
        r11 = r19.m4252e();	 Catch:{ all -> 0x00b7 }
        goto L_0x002a;
    L_0x0020:
        r8 = r19.m4256g();	 Catch:{ all -> 0x00b7 }
        r9 = r19.m4256g();	 Catch:{ all -> 0x00b7 }
        r9 = (long) r9;
        r11 = r7;
    L_0x002a:
        r12 = 0;
        if (r8 != 0) goto L_0x0038;
    L_0x002e:
        r8 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r8 != 0) goto L_0x0038;
    L_0x0032:
        if (r11 != 0) goto L_0x0038;
    L_0x0034:
        r1.m4249c(r3);
        return r5;
    L_0x0038:
        r8 = 4;
        if (r2 != r8) goto L_0x006e;
    L_0x003b:
        if (r22 != 0) goto L_0x006e;
    L_0x003d:
        r14 = 8421504; // 0x808080 float:1.180104E-38 double:4.160776E-317;
        r14 = r14 & r9;
        r12 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r12 == 0) goto L_0x0049;
    L_0x0045:
        r1.m4249c(r3);
        return r7;
    L_0x0049:
        r12 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r14 = r9 & r12;
        r16 = 8;
        r16 = r9 >> r16;
        r16 = r16 & r12;
        r18 = 7;
        r16 = r16 << r18;
        r14 = r14 | r16;
        r16 = 16;
        r16 = r9 >> r16;
        r16 = r16 & r12;
        r18 = 14;
        r16 = r16 << r18;
        r14 = r14 | r16;
        r16 = 24;
        r9 = r9 >> r16;
        r9 = r9 & r12;
        r12 = 21;
        r9 = r9 << r12;
        r9 = r9 | r14;
    L_0x006e:
        if (r2 != r8) goto L_0x007f;
    L_0x0070:
        r4 = r11 & 64;
        if (r4 == 0) goto L_0x0076;
    L_0x0074:
        r4 = r5;
        goto L_0x0077;
    L_0x0076:
        r4 = r7;
    L_0x0077:
        r8 = r11 & 1;
        if (r8 == 0) goto L_0x007d;
    L_0x007b:
        r8 = r5;
        goto L_0x008f;
    L_0x007d:
        r8 = r7;
        goto L_0x008f;
    L_0x007f:
        if (r2 != r4) goto L_0x008d;
    L_0x0081:
        r4 = r11 & 32;
        if (r4 == 0) goto L_0x0087;
    L_0x0085:
        r4 = r5;
        goto L_0x0088;
    L_0x0087:
        r4 = r7;
    L_0x0088:
        r8 = r11 & 128;
        if (r8 == 0) goto L_0x007d;
    L_0x008c:
        goto L_0x007b;
    L_0x008d:
        r4 = r7;
        r8 = r4;
    L_0x008f:
        if (r4 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x0093;
    L_0x0092:
        r5 = r7;
    L_0x0093:
        if (r8 == 0) goto L_0x0097;
    L_0x0095:
        r5 = r5 + 4;
    L_0x0097:
        r4 = (long) r5;
        r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x00a0;
    L_0x009c:
        r1.m4249c(r3);
        return r7;
    L_0x00a0:
        r4 = r19.m4246b();	 Catch:{ all -> 0x00b7 }
        r4 = (long) r4;
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r4 >= 0) goto L_0x00ad;
    L_0x00a9:
        r1.m4249c(r3);
        return r7;
    L_0x00ad:
        r4 = (int) r9;
        r1.m4251d(r4);	 Catch:{ all -> 0x00b7 }
        goto L_0x0006;
    L_0x00b3:
        r1.m4249c(r3);
        return r5;
    L_0x00b7:
        r0 = move-exception;
        r2 = r0;
        r1.m4249c(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.a(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    private static ChapterFrame m12285a(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i4 = parsableByteArray2.f5257b;
        int b = m12291b(parsableByteArray2.f5256a, i4);
        String str = new String(parsableByteArray2.f5256a, i4, b - i4, "ISO-8859-1");
        parsableByteArray2.m4249c(b + 1);
        int j = parsableByteArray2.m4259j();
        int j2 = parsableByteArray2.m4259j();
        long h = parsableByteArray2.m4257h();
        long j3 = h == 4294967295L ? -1 : h;
        h = parsableByteArray2.m4257h();
        long j4 = h == 4294967295L ? -1 : h;
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (parsableByteArray2.f5257b < i4) {
            Id3Frame a = m12286a(i2, parsableByteArray2, z, i3, framePredicate);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, j, j2, j3, j4, id3FrameArr);
    }

    private static ChapterTocFrame m12292b(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i4 = parsableByteArray2.f5257b;
        int b = m12291b(parsableByteArray2.f5256a, i4);
        String str = new String(parsableByteArray2.f5256a, i4, b - i4, "ISO-8859-1");
        parsableByteArray2.m4249c(b + 1);
        b = parsableByteArray2.m4250d();
        int i5 = 0;
        boolean z2 = (b & 2) != 0;
        boolean z3 = (b & 1) != 0;
        int d = parsableByteArray2.m4250d();
        String[] strArr = new String[d];
        while (i5 < d) {
            int i6 = parsableByteArray2.f5257b;
            int b2 = m12291b(parsableByteArray2.f5256a, i6);
            strArr[i5] = new String(parsableByteArray2.f5256a, i6, b2 - i6, "ISO-8859-1");
            parsableByteArray2.m4249c(b2 + 1);
            i5++;
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (parsableByteArray2.f5257b < i4) {
            Id3Frame a = m12286a(i2, parsableByteArray2, z, i3, framePredicate);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }
}
