package com.googlecode.mp4parser.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.facebook.stetho.server.http.HttpStatus;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    protected int algorithmId = -1;
    List<CencSampleAuxiliaryDataFormat> entries = Collections.emptyList();
    protected int ivSize = -1;
    protected byte[] kid = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 29);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 89);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 93);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 173);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), HttpStatus.HTTP_OK);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), JpegConst.RST0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected AbstractSampleEncryptionBox(java.lang.String r1) {
        /*
        r0 = this;
        r0.<init>(r1);
        r1 = -1;
        r0.algorithmId = r1;
        r0.ivSize = r1;
        r1 = 16;
        r1 = new byte[r1];
        r1 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        r0.kid = r1;
        r1 = java.util.Collections.emptyList();
        r0.entries = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox.<init>(java.lang.String):void");
    }

    public int getOffsetToFirstIV() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return ((getSize() > 4294967296L ? 16 : 8) + (isOverrideTrackEncryptionBoxParameters() ? this.kid.length + 4 : 0)) + 4;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) > 0) {
            this.algorithmId = IsoTypeReader.m3282b(byteBuffer);
            this.ivSize = IsoTypeReader.m3284d(byteBuffer);
            this.kid = new byte[16];
            byteBuffer.get(this.kid);
        }
        long a = IsoTypeReader.m3280a(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        this.entries = parseEntries(duplicate, a, 8);
        if (this.entries == null) {
            this.entries = parseEntries(duplicate2, a, 16);
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining());
        } else {
            byteBuffer.position((byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining());
        }
        if (this.entries == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    private java.util.List<com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat> parseEntries(java.nio.ByteBuffer r8, long r9, int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x0005:
        r1 = 1;
        r1 = r9 - r1;
        r3 = 0;
        r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r9 > 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r9 = new com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;	 Catch:{ BufferUnderflowException -> 0x004d }
        r9.<init>();	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = new byte[r11];	 Catch:{ BufferUnderflowException -> 0x004d }
        r9.f10095a = r10;	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = r9.f10095a;	 Catch:{ BufferUnderflowException -> 0x004d }
        r8.get(r10);	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = r7.getFlags();	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = r10 & 2;	 Catch:{ BufferUnderflowException -> 0x004d }
        if (r10 <= 0) goto L_0x0048;	 Catch:{ BufferUnderflowException -> 0x004d }
    L_0x0026:
        r10 = com.coremedia.iso.IsoTypeReader.m3283c(r8);	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = new com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair[r10];	 Catch:{ BufferUnderflowException -> 0x004d }
        r9.f10096b = r10;	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = 0;	 Catch:{ BufferUnderflowException -> 0x004d }
    L_0x002f:
        r3 = r9.f10096b;	 Catch:{ BufferUnderflowException -> 0x004d }
        r3 = r3.length;	 Catch:{ BufferUnderflowException -> 0x004d }
        if (r10 < r3) goto L_0x0035;	 Catch:{ BufferUnderflowException -> 0x004d }
    L_0x0034:
        goto L_0x0048;	 Catch:{ BufferUnderflowException -> 0x004d }
    L_0x0035:
        r3 = r9.f10096b;	 Catch:{ BufferUnderflowException -> 0x004d }
        r4 = com.coremedia.iso.IsoTypeReader.m3283c(r8);	 Catch:{ BufferUnderflowException -> 0x004d }
        r5 = com.coremedia.iso.IsoTypeReader.m3280a(r8);	 Catch:{ BufferUnderflowException -> 0x004d }
        r4 = r9.m8524a(r4, r5);	 Catch:{ BufferUnderflowException -> 0x004d }
        r3[r10] = r4;	 Catch:{ BufferUnderflowException -> 0x004d }
        r10 = r10 + 1;	 Catch:{ BufferUnderflowException -> 0x004d }
        goto L_0x002f;	 Catch:{ BufferUnderflowException -> 0x004d }
    L_0x0048:
        r0.add(r9);	 Catch:{ BufferUnderflowException -> 0x004d }
        r9 = r1;
        goto L_0x0005;
    L_0x004d:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox.parseEntries(java.nio.ByteBuffer, long, int):java.util.List<com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat>");
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> list) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }

    public boolean isSubSampleEncryption() {
        return (getFlags() & 2) > 0;
    }

    public void setSubSampleEncryption(boolean z) {
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & true);
        }
    }

    protected boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            IsoTypeWriter.m3295a(byteBuffer, this.algorithmId);
            IsoTypeWriter.m3303c(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) getNonEmptyEntriesNum());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            if (cencSampleAuxiliaryDataFormat.m8523a() > 0) {
                if (cencSampleAuxiliaryDataFormat.f10095a.length == 8 || cencSampleAuxiliaryDataFormat.f10095a.length == 16) {
                    byteBuffer.put(cencSampleAuxiliaryDataFormat.f10095a);
                    if (isSubSampleEncryption()) {
                        IsoTypeWriter.m3299b(byteBuffer, cencSampleAuxiliaryDataFormat.f10096b.length);
                        for (Pair pair : cencSampleAuxiliaryDataFormat.f10096b) {
                            IsoTypeWriter.m3299b(byteBuffer, pair.mo3686a());
                            IsoTypeWriter.m3300b(byteBuffer, pair.mo3687b());
                        }
                    }
                } else {
                    throw new RuntimeException("IV must be either 8 or 16 bytes");
                }
            }
        }
    }

    private int getNonEmptyEntriesNum() {
        int i = 0;
        for (CencSampleAuxiliaryDataFormat a : this.entries) {
            if (a.m8523a() > 0) {
                i++;
            }
        }
        return i;
    }

    protected long getContentSize() {
        long length = (isOverrideTrackEncryptionBoxParameters() ? 8 + ((long) this.kid.length) : 4) + 4;
        for (CencSampleAuxiliaryDataFormat a : this.entries) {
            length += (long) a.m8523a();
        }
        return length;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        super.getBox(writableByteChannel);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = ajc$tjp_3;
        r0 = org.mp4parser.aspectj.runtime.reflect.Factory.a(r0, r4, r4, r5);
        com.googlecode.mp4parser.RequiresParseDetailAspect.m7623a();
        com.googlecode.mp4parser.RequiresParseDetailAspect.m7624a(r0);
        r0 = 1;
        if (r4 != r5) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = 0;
        if (r5 == 0) goto L_0x004e;
    L_0x0013:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x001e;
    L_0x001d:
        goto L_0x004e;
    L_0x001e:
        r5 = (com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox) r5;
        r2 = r4.algorithmId;
        r3 = r5.algorithmId;
        if (r2 == r3) goto L_0x0027;
    L_0x0026:
        return r1;
    L_0x0027:
        r2 = r4.ivSize;
        r3 = r5.ivSize;
        if (r2 == r3) goto L_0x002e;
    L_0x002d:
        return r1;
    L_0x002e:
        r2 = r4.entries;
        if (r2 == 0) goto L_0x003d;
    L_0x0032:
        r2 = r4.entries;
        r3 = r5.entries;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0042;
    L_0x003c:
        goto L_0x0041;
    L_0x003d:
        r2 = r5.entries;
        if (r2 == 0) goto L_0x0042;
    L_0x0041:
        return r1;
    L_0x0042:
        r2 = r4.kid;
        r5 = r5.kid;
        r5 = java.util.Arrays.equals(r2, r5);
        if (r5 != 0) goto L_0x004d;
    L_0x004c:
        return r1;
    L_0x004d:
        return r0;
    L_0x004e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        int i = 0;
        int hashCode = 31 * ((((this.algorithmId * 31) + this.ivSize) * 31) + (this.kid != null ? Arrays.hashCode(this.kid) : 0));
        if (this.entries != null) {
            i = this.entries.hashCode();
        }
        return hashCode + i;
    }

    public List<Short> getEntrySizes() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        List<Short> arrayList = new ArrayList(this.entries.size());
        for (CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat : this.entries) {
            short length = (short) cencSampleAuxiliaryDataFormat.f10095a.length;
            if (isSubSampleEncryption()) {
                length = (short) (((short) (length + 2)) + (cencSampleAuxiliaryDataFormat.f10096b.length * 6));
            }
            arrayList.add(Short.valueOf(length));
        }
        return arrayList;
    }
}
