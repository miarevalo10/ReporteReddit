package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ClassificationBox extends AbstractFullBox {
    public static final String TYPE = "clsf";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private String classificationEntity;
    private String classificationInfo;
    private int classificationTableIndex;
    private String language;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("ClassificationBox.java", ClassificationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 48);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 56);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 60);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "language", "", "void"), 68);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 101);
    }

    public ClassificationBox() {
        super(TYPE);
    }

    public String getLanguage() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.language;
    }

    public String getClassificationEntity() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.classificationEntity;
    }

    public int getClassificationTableIndex() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.classificationTableIndex;
    }

    public String getClassificationInfo() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.classificationInfo;
    }

    public void setClassificationEntity(String str) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.classificationEntity = str;
    }

    public void setClassificationTableIndex(int i) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.classificationTableIndex = i;
    }

    public void setLanguage(String str) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.language = str;
    }

    public void setClassificationInfo(String str) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.classificationInfo = str;
    }

    protected long getContentSize() {
        return (long) ((8 + Utf8.m3309b(this.classificationInfo)) + 1);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.classificationEntity = IsoFile.m17056a(bArr);
        this.classificationTableIndex = IsoTypeReader.m3283c(byteBuffer);
        this.language = IsoTypeReader.m3290j(byteBuffer);
        this.classificationInfo = IsoTypeReader.m3285e(byteBuffer);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.m17057a(this.classificationEntity));
        IsoTypeWriter.m3299b(byteBuffer, this.classificationTableIndex);
        IsoTypeWriter.m3297a(byteBuffer, this.language);
        byteBuffer.put(Utf8.m3308a(this.classificationInfo));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassificationBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append("classificationEntity=");
        stringBuilder.append(getClassificationEntity());
        stringBuilder.append(";classificationTableIndex=");
        stringBuilder.append(getClassificationTableIndex());
        stringBuilder.append(";language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";classificationInfo=");
        stringBuilder.append(getClassificationInfo());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
