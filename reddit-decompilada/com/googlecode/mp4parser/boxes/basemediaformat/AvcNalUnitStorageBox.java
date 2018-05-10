package com.googlecode.mp4parser.boxes.basemediaformat;

import com.coremedia.iso.Hex;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class AvcNalUnitStorageBox extends AbstractBox {
    public static final String TYPE = "avcn";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    AvcDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AvcNalUnitStorageBox.java", AvcNalUnitStorageBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getAvcDecoderConfigurationRecord", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 44);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getLengthSizeMinusOne", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "int"), 49);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getSPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 53);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getPPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 57);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getSequenceParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 61);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getSequenceParameterSetExtsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 65);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getPictureParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 69);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 89);
    }

    public AvcNalUnitStorageBox() {
        super(TYPE);
    }

    public AvcNalUnitStorageBox(AvcConfigurationBox avcConfigurationBox) {
        super(TYPE);
        this.avcDecoderConfigurationRecord = avcConfigurationBox.getavcDecoderConfigurationRecord();
    }

    public AvcDecoderConfigurationRecord getAvcDecoderConfigurationRecord() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord;
    }

    public int getLengthSizeMinusOne() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10051e;
    }

    public String[] getSPS() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8518c();
    }

    public String[] getPPS() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8517b();
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8519d();
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        AvcDecoderConfigurationRecord avcDecoderConfigurationRecord = this.avcDecoderConfigurationRecord;
        List<String> arrayList = new ArrayList(avcDecoderConfigurationRecord.f10058l.size());
        for (byte[] a2 : avcDecoderConfigurationRecord.f10058l) {
            arrayList.add(Hex.m3277a(a2));
        }
        return arrayList;
    }

    public List<String> getPictureParameterSetsAsStrings() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8520e();
    }

    protected long getContentSize() {
        return this.avcDecoderConfigurationRecord.m8515a();
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord.m8516a(byteBuffer);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("AvcNalUnitStorageBox{SPS=");
        stringBuilder.append(this.avcDecoderConfigurationRecord.m8519d());
        stringBuilder.append(",PPS=");
        stringBuilder.append(this.avcDecoderConfigurationRecord.m8520e());
        stringBuilder.append(",lengthSize=");
        stringBuilder.append(this.avcDecoderConfigurationRecord.f10051e + 1);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
