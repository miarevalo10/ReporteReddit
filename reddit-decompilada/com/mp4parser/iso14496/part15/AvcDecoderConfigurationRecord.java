package com.mp4parser.iso14496.part15;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AvcDecoderConfigurationRecord {
    public int f10047a;
    public int f10048b;
    public int f10049c;
    public int f10050d;
    public int f10051e;
    public List<byte[]> f10052f;
    public List<byte[]> f10053g;
    public boolean f10054h;
    public int f10055i;
    public int f10056j;
    public int f10057k;
    public List<byte[]> f10058l;
    public int f10059m;
    public int f10060n;
    public int f10061o;
    public int f10062p;
    public int f10063q;

    public AvcDecoderConfigurationRecord() {
        this.f10052f = new ArrayList();
        this.f10053g = new ArrayList();
        this.f10054h = true;
        this.f10055i = 1;
        this.f10056j = 0;
        this.f10057k = 0;
        this.f10058l = new ArrayList();
        this.f10059m = 63;
        this.f10060n = 7;
        this.f10061o = 31;
        this.f10062p = 31;
        this.f10063q = 31;
    }

    public AvcDecoderConfigurationRecord(ByteBuffer byteBuffer) {
        this.f10052f = new ArrayList();
        this.f10053g = new ArrayList();
        this.f10054h = true;
        this.f10055i = 1;
        int i = 0;
        this.f10056j = 0;
        this.f10057k = 0;
        this.f10058l = new ArrayList();
        this.f10059m = 63;
        this.f10060n = 7;
        this.f10061o = 31;
        this.f10062p = 31;
        this.f10063q = 31;
        this.f10047a = IsoTypeReader.m3284d(byteBuffer);
        this.f10048b = IsoTypeReader.m3284d(byteBuffer);
        this.f10049c = IsoTypeReader.m3284d(byteBuffer);
        this.f10050d = IsoTypeReader.m3284d(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.f10059m = bitReaderBuffer.m7683a(6);
        this.f10051e = bitReaderBuffer.m7683a(2);
        this.f10060n = bitReaderBuffer.m7683a(3);
        int a = bitReaderBuffer.m7683a(5);
        for (int i2 = 0; i2 < a; i2++) {
            Object obj = new byte[IsoTypeReader.m3283c(byteBuffer)];
            byteBuffer.get(obj);
            this.f10052f.add(obj);
        }
        long d = (long) IsoTypeReader.m3284d(byteBuffer);
        for (a = 0; ((long) a) < d; a++) {
            Object obj2 = new byte[IsoTypeReader.m3283c(byteBuffer)];
            byteBuffer.get(obj2);
            this.f10053g.add(obj2);
        }
        if (byteBuffer.remaining() < 4) {
            this.f10054h = false;
        }
        if (this.f10054h && (this.f10048b == 100 || this.f10048b == 110 || this.f10048b == 122 || this.f10048b == 144)) {
            bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            this.f10061o = bitReaderBuffer.m7683a(6);
            this.f10055i = bitReaderBuffer.m7683a(2);
            this.f10062p = bitReaderBuffer.m7683a(5);
            this.f10056j = bitReaderBuffer.m7683a(3);
            this.f10063q = bitReaderBuffer.m7683a(5);
            this.f10057k = bitReaderBuffer.m7683a(3);
            long d2 = (long) IsoTypeReader.m3284d(byteBuffer);
            while (((long) i) < d2) {
                Object obj3 = new byte[IsoTypeReader.m3283c(byteBuffer)];
                byteBuffer.get(obj3);
                this.f10058l.add(obj3);
                i++;
            }
            return;
        }
        this.f10055i = -1;
        this.f10056j = -1;
        this.f10057k = -1;
    }

    public final void m8516a(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3303c(byteBuffer, this.f10047a);
        IsoTypeWriter.m3303c(byteBuffer, this.f10048b);
        IsoTypeWriter.m3303c(byteBuffer, this.f10049c);
        IsoTypeWriter.m3303c(byteBuffer, this.f10050d);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.m7686a(this.f10059m, 6);
        bitWriterBuffer.m7686a(this.f10051e, 2);
        bitWriterBuffer.m7686a(this.f10060n, 3);
        bitWriterBuffer.m7686a(this.f10053g.size(), 5);
        for (byte[] bArr : this.f10052f) {
            IsoTypeWriter.m3299b(byteBuffer, bArr.length);
            byteBuffer.put(bArr);
        }
        IsoTypeWriter.m3303c(byteBuffer, this.f10053g.size());
        for (byte[] bArr2 : this.f10053g) {
            IsoTypeWriter.m3299b(byteBuffer, bArr2.length);
            byteBuffer.put(bArr2);
        }
        if (!this.f10054h) {
            return;
        }
        if (this.f10048b == 100 || this.f10048b == 110 || this.f10048b == 122 || this.f10048b == 144) {
            bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.m7686a(this.f10061o, 6);
            bitWriterBuffer.m7686a(this.f10055i, 2);
            bitWriterBuffer.m7686a(this.f10062p, 5);
            bitWriterBuffer.m7686a(this.f10056j, 3);
            bitWriterBuffer.m7686a(this.f10063q, 5);
            bitWriterBuffer.m7686a(this.f10057k, 3);
            for (byte[] bArr3 : this.f10058l) {
                IsoTypeWriter.m3299b(byteBuffer, bArr3.length);
                byteBuffer.put(bArr3);
            }
        }
    }

    public final long m8515a() {
        long j = 6;
        for (byte[] length : this.f10052f) {
            j = (j + 2) + ((long) length.length);
        }
        j++;
        for (byte[] length2 : this.f10053g) {
            j = (j + 2) + ((long) length2.length);
        }
        if (this.f10054h && (this.f10048b == 100 || this.f10048b == 110 || this.f10048b == 122 || this.f10048b == 144)) {
            j += 4;
            for (byte[] length3 : this.f10058l) {
                j = (j + 2) + ((long) length3.length);
            }
        }
        return j;
    }

    public final String[] m8517b() {
        ArrayList arrayList = new ArrayList();
        for (byte[] bArr : this.f10053g) {
            try {
                arrayList.add(PictureParameterSet.m15192a(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final java.lang.String[] m8518c() {
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
        r8 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r8.f10052f;
        r1 = r1.iterator();
    L_0x000b:
        r2 = r1.hasNext();
        if (r2 != 0) goto L_0x001e;
    L_0x0011:
        r1 = r0.size();
        r1 = new java.lang.String[r1];
        r0 = r0.toArray(r1);
        r0 = (java.lang.String[]) r0;
        return r0;
    L_0x001e:
        r2 = r1.next();
        r2 = (byte[]) r2;
        r3 = "not parsable";
        r4 = new com.googlecode.mp4parser.authoring.tracks.CleanInputStream;	 Catch:{ IOException -> 0x003c }
        r5 = new java.io.ByteArrayInputStream;	 Catch:{ IOException -> 0x003c }
        r6 = r2.length;	 Catch:{ IOException -> 0x003c }
        r7 = 1;	 Catch:{ IOException -> 0x003c }
        r6 = r6 - r7;	 Catch:{ IOException -> 0x003c }
        r5.<init>(r2, r7, r6);	 Catch:{ IOException -> 0x003c }
        r4.<init>(r5);	 Catch:{ IOException -> 0x003c }
        r2 = com.googlecode.mp4parser.h264.model.SeqParameterSet.m15194a(r4);	 Catch:{ IOException -> 0x003c }
        r2 = r2.toString();	 Catch:{ IOException -> 0x003c }
        goto L_0x003d;
    L_0x003c:
        r2 = r3;
    L_0x003d:
        r0.add(r2);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord.c():java.lang.String[]");
    }

    public final List<String> m8519d() {
        List<String> arrayList = new ArrayList(this.f10052f.size());
        for (byte[] a : this.f10052f) {
            arrayList.add(Hex.m3277a(a));
        }
        return arrayList;
    }

    public final List<String> m8520e() {
        List<String> arrayList = new ArrayList(this.f10053g.size());
        for (byte[] a : this.f10053g) {
            arrayList.add(Hex.m3277a(a));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AvcDecoderConfigurationRecord{configurationVersion=");
        stringBuilder.append(this.f10047a);
        stringBuilder.append(", avcProfileIndication=");
        stringBuilder.append(this.f10048b);
        stringBuilder.append(", profileCompatibility=");
        stringBuilder.append(this.f10049c);
        stringBuilder.append(", avcLevelIndication=");
        stringBuilder.append(this.f10050d);
        stringBuilder.append(", lengthSizeMinusOne=");
        stringBuilder.append(this.f10051e);
        stringBuilder.append(", hasExts=");
        stringBuilder.append(this.f10054h);
        stringBuilder.append(", chromaFormat=");
        stringBuilder.append(this.f10055i);
        stringBuilder.append(", bitDepthLumaMinus8=");
        stringBuilder.append(this.f10056j);
        stringBuilder.append(", bitDepthChromaMinus8=");
        stringBuilder.append(this.f10057k);
        stringBuilder.append(", lengthSizeMinusOnePaddingBits=");
        stringBuilder.append(this.f10059m);
        stringBuilder.append(", numberOfSequenceParameterSetsPaddingBits=");
        stringBuilder.append(this.f10060n);
        stringBuilder.append(", chromaFormatPaddingBits=");
        stringBuilder.append(this.f10061o);
        stringBuilder.append(", bitDepthLumaMinus8PaddingBits=");
        stringBuilder.append(this.f10062p);
        stringBuilder.append(", bitDepthChromaMinus8PaddingBits=");
        stringBuilder.append(this.f10063q);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
