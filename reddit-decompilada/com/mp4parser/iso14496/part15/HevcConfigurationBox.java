package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class HevcConfigurationBox extends AbstractBox {
    public static final String TYPE = "hvcC";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_12 = null;
    private static final StaticPart ajc$tjp_13 = null;
    private static final StaticPart ajc$tjp_14 = null;
    private static final StaticPart ajc$tjp_15 = null;
    private static final StaticPart ajc$tjp_16 = null;
    private static final StaticPart ajc$tjp_17 = null;
    private static final StaticPart ajc$tjp_18 = null;
    private static final StaticPart ajc$tjp_19 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_20 = null;
    private static final StaticPart ajc$tjp_21 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = new HevcDecoderConfigurationRecord();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("HevcConfigurationBox.java", HevcConfigurationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord"), 38);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setHevcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord", "hevcDecoderConfigurationRecord", "", "void"), 42);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getGeneral_level_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 90);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "getMin_spatial_segmentation_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 94);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "getParallelismType", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 98);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 102);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 106);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 110);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "getAvgFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 114);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "getNumTemporalLayers", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 118);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 122);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "isTemporalIdNested", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 126);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "equals", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "java.lang.Object", "o", "", "boolean"), 47);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 130);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "getArrays", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "java.util.List"), 134);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "hashCode", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 60);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 65);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getGeneral_profile_space", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 69);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "isGeneral_tier_flag", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "boolean"), 73);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getGeneral_profile_idc", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "int"), 78);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getGeneral_profile_compatibility_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 82);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getGeneral_constraint_indicator_flags", "com.mp4parser.iso14496.part15.HevcConfigurationBox", "", "", "", "long"), 86);
    }

    public HevcConfigurationBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        int i = 23;
        for (Array array : this.hevcDecoderConfigurationRecord.f10091w) {
            i += 3;
            for (byte[] length : array.f10067d) {
                i = (i + 2) + length.length;
            }
        }
        return (long) i;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = this.hevcDecoderConfigurationRecord;
        IsoTypeWriter.m3303c(byteBuffer, hevcDecoderConfigurationRecord.f10069a);
        IsoTypeWriter.m3303c(byteBuffer, ((hevcDecoderConfigurationRecord.f10070b << 6) + (hevcDecoderConfigurationRecord.f10071c ? 32 : 0)) + hevcDecoderConfigurationRecord.f10072d);
        IsoTypeWriter.m3300b(byteBuffer, hevcDecoderConfigurationRecord.f10073e);
        long j = hevcDecoderConfigurationRecord.f10074f;
        if (hevcDecoderConfigurationRecord.f10092x) {
            j |= 140737488355328L;
        }
        if (hevcDecoderConfigurationRecord.f10093y) {
            j |= 70368744177664L;
        }
        if (hevcDecoderConfigurationRecord.f10094z) {
            j |= 35184372088832L;
        }
        if (hevcDecoderConfigurationRecord.f10068A) {
            j |= 17592186044416L;
        }
        IsoTypeWriter.m3304c(byteBuffer, j);
        IsoTypeWriter.m3303c(byteBuffer, hevcDecoderConfigurationRecord.f10075g);
        IsoTypeWriter.m3299b(byteBuffer, (hevcDecoderConfigurationRecord.f10076h << 12) + hevcDecoderConfigurationRecord.f10077i);
        IsoTypeWriter.m3303c(byteBuffer, (hevcDecoderConfigurationRecord.f10078j << 2) + hevcDecoderConfigurationRecord.f10079k);
        IsoTypeWriter.m3303c(byteBuffer, (hevcDecoderConfigurationRecord.f10080l << 2) + hevcDecoderConfigurationRecord.f10081m);
        IsoTypeWriter.m3303c(byteBuffer, (hevcDecoderConfigurationRecord.f10082n << 3) + hevcDecoderConfigurationRecord.f10083o);
        IsoTypeWriter.m3303c(byteBuffer, (hevcDecoderConfigurationRecord.f10084p << 3) + hevcDecoderConfigurationRecord.f10085q);
        IsoTypeWriter.m3299b(byteBuffer, hevcDecoderConfigurationRecord.f10086r);
        IsoTypeWriter.m3303c(byteBuffer, (((hevcDecoderConfigurationRecord.f10087s << 6) + (hevcDecoderConfigurationRecord.f10088t << 3)) + (hevcDecoderConfigurationRecord.f10089u ? 4 : 0)) + hevcDecoderConfigurationRecord.f10090v);
        IsoTypeWriter.m3303c(byteBuffer, hevcDecoderConfigurationRecord.f10091w.size());
        for (Array array : hevcDecoderConfigurationRecord.f10091w) {
            IsoTypeWriter.m3303c(byteBuffer, ((array.f10064a ? 128 : 0) + (array.f10065b ? 64 : 0)) + array.f10066c);
            IsoTypeWriter.m3299b(byteBuffer, array.f10067d.size());
            for (byte[] bArr : array.f10067d) {
                IsoTypeWriter.m3299b(byteBuffer, bArr.length);
                byteBuffer.put(bArr);
            }
        }
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = this.hevcDecoderConfigurationRecord;
        hevcDecoderConfigurationRecord.f10069a = IsoTypeReader.m3284d(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10070b = (d & JpegConst.SOF0) >> 6;
        hevcDecoderConfigurationRecord.f10071c = (d & 32) > 0;
        hevcDecoderConfigurationRecord.f10072d = d & 31;
        hevcDecoderConfigurationRecord.f10073e = IsoTypeReader.m3280a(byteBuffer);
        hevcDecoderConfigurationRecord.f10074f = IsoTypeReader.m3292l(byteBuffer);
        hevcDecoderConfigurationRecord.f10092x = ((hevcDecoderConfigurationRecord.f10074f >> 44) & 8) > 0;
        hevcDecoderConfigurationRecord.f10093y = ((hevcDecoderConfigurationRecord.f10074f >> 44) & 4) > 0;
        hevcDecoderConfigurationRecord.f10094z = ((hevcDecoderConfigurationRecord.f10074f >> 44) & 2) > 0;
        hevcDecoderConfigurationRecord.f10068A = ((hevcDecoderConfigurationRecord.f10074f >> 44) & 1) > 0;
        hevcDecoderConfigurationRecord.f10074f &= 140737488355327L;
        hevcDecoderConfigurationRecord.f10075g = IsoTypeReader.m3284d(byteBuffer);
        d = IsoTypeReader.m3283c(byteBuffer);
        hevcDecoderConfigurationRecord.f10076h = (61440 & d) >> 12;
        hevcDecoderConfigurationRecord.f10077i = d & 4095;
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10078j = (d & 252) >> 2;
        hevcDecoderConfigurationRecord.f10079k = d & 3;
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10080l = (d & 252) >> 2;
        hevcDecoderConfigurationRecord.f10081m = d & 3;
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10082n = (d & 248) >> 3;
        hevcDecoderConfigurationRecord.f10083o = d & 7;
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10084p = (d & 248) >> 3;
        hevcDecoderConfigurationRecord.f10085q = d & 7;
        hevcDecoderConfigurationRecord.f10086r = IsoTypeReader.m3283c(byteBuffer);
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10087s = (d & JpegConst.SOF0) >> 6;
        hevcDecoderConfigurationRecord.f10088t = (d & 56) >> 3;
        hevcDecoderConfigurationRecord.f10089u = (d & 4) > 0;
        hevcDecoderConfigurationRecord.f10090v = d & 3;
        d = IsoTypeReader.m3284d(byteBuffer);
        hevcDecoderConfigurationRecord.f10091w = new ArrayList();
        for (int i = 0; i < d; i++) {
            Array array = new Array();
            int d2 = IsoTypeReader.m3284d(byteBuffer);
            array.f10064a = (d2 & 128) > 0;
            array.f10065b = (d2 & 64) > 0;
            array.f10066c = d2 & 63;
            d2 = IsoTypeReader.m3283c(byteBuffer);
            array.f10067d = new ArrayList();
            for (int i2 = 0; i2 < d2; i2++) {
                Object obj = new byte[IsoTypeReader.m3283c(byteBuffer)];
                byteBuffer.get(obj);
                array.f10067d.add(obj);
            }
            hevcDecoderConfigurationRecord.f10091w.add(array);
        }
    }

    public HevcDecoderConfigurationRecord getHevcDecoderConfigurationRecord() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord;
    }

    public void setHevcDecoderConfigurationRecord(HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, hevcDecoderConfigurationRecord);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.hevcDecoderConfigurationRecord = hevcDecoderConfigurationRecord;
    }

    public boolean equals(Object obj) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, obj);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                HevcConfigurationBox hevcConfigurationBox = (HevcConfigurationBox) obj;
                if (this.hevcDecoderConfigurationRecord == null) {
                    return hevcConfigurationBox.hevcDecoderConfigurationRecord == null;
                } else {
                    if (this.hevcDecoderConfigurationRecord.equals(hevcConfigurationBox.hevcDecoderConfigurationRecord) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord != null ? this.hevcDecoderConfigurationRecord.hashCode() : 0;
    }

    public int getConfigurationVersion() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10069a;
    }

    public int getGeneral_profile_space() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10070b;
    }

    public boolean isGeneral_tier_flag() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10071c;
    }

    public int getGeneral_profile_idc() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10072d;
    }

    public long getGeneral_profile_compatibility_flags() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10073e;
    }

    public long getGeneral_constraint_indicator_flags() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10074f;
    }

    public int getGeneral_level_idc() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10075g;
    }

    public int getMin_spatial_segmentation_idc() {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10077i;
    }

    public int getParallelismType() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10079k;
    }

    public int getChromaFormat() {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10081m;
    }

    public int getBitDepthLumaMinus8() {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10083o;
    }

    public int getBitDepthChromaMinus8() {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10085q;
    }

    public int getAvgFrameRate() {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10086r;
    }

    public int getNumTemporalLayers() {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10088t;
    }

    public int getLengthSizeMinusOne() {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10090v;
    }

    public boolean isTemporalIdNested() {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10089u;
    }

    public int getConstantFrameRate() {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10087s;
    }

    public List<Array> getArrays() {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.hevcDecoderConfigurationRecord.f10091w;
    }
}
