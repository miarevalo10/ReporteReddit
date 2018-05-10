package com.googlecode.mp4parser.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.gms.ads.AdRequest;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class DTSSpecificBox extends AbstractBox {
    public static final String TYPE = "ddts";
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
    private static final StaticPart ajc$tjp_22 = null;
    private static final StaticPart ajc$tjp_23 = null;
    private static final StaticPart ajc$tjp_24 = null;
    private static final StaticPart ajc$tjp_25 = null;
    private static final StaticPart ajc$tjp_26 = null;
    private static final StaticPart ajc$tjp_27 = null;
    private static final StaticPart ajc$tjp_28 = null;
    private static final StaticPart ajc$tjp_29 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_30 = null;
    private static final StaticPart ajc$tjp_31 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    long DTSSamplingFrequency;
    int LBRDurationMod;
    long avgBitRate;
    int channelLayout;
    int coreLFEPresent;
    int coreLayout;
    int coreSize;
    int frameDuration;
    long maxBitRate;
    int multiAssetFlag;
    int pcmSampleDepth;
    int representationType;
    int reserved;
    int reservedBoxPresent;
    int stereoDownmix;
    int streamConstruction;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 89);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 93);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 129);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 137);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 145);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 153);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 161);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 97);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 169);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        ajc$tjp_22 = factory.a("method-execution", factory.a("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 177);
        ajc$tjp_23 = factory.a("method-execution", factory.a("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), MPEGConst.EXTENSION_START_CODE);
        ajc$tjp_24 = factory.a("method-execution", factory.a("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 185);
        ajc$tjp_25 = factory.a("method-execution", factory.a("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        ajc$tjp_26 = factory.a("method-execution", factory.a("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), JpegConst.SOF1);
        ajc$tjp_27 = factory.a("method-execution", factory.a("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 197);
        ajc$tjp_28 = factory.a("method-execution", factory.a("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 201);
        ajc$tjp_29 = factory.a("method-execution", factory.a("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 101);
        ajc$tjp_30 = factory.a("method-execution", factory.a("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), JpegConst.RST1);
        ajc$tjp_31 = factory.a("method-execution", factory.a("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), JpegConst.RST5);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 105);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 109);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 113);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 121);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    protected long getContentSize() {
        return 20;
    }

    public DTSSpecificBox() {
        super(TYPE);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = IsoTypeReader.m3280a(byteBuffer);
        this.maxBitRate = IsoTypeReader.m3280a(byteBuffer);
        this.avgBitRate = IsoTypeReader.m3280a(byteBuffer);
        this.pcmSampleDepth = IsoTypeReader.m3284d(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.frameDuration = bitReaderBuffer.m7683a(2);
        this.streamConstruction = bitReaderBuffer.m7683a(5);
        this.coreLFEPresent = bitReaderBuffer.m7683a(1);
        this.coreLayout = bitReaderBuffer.m7683a(6);
        this.coreSize = bitReaderBuffer.m7683a(14);
        this.stereoDownmix = bitReaderBuffer.m7683a(1);
        this.representationType = bitReaderBuffer.m7683a(3);
        this.channelLayout = bitReaderBuffer.m7683a(16);
        this.multiAssetFlag = bitReaderBuffer.m7683a(1);
        this.LBRDurationMod = bitReaderBuffer.m7683a(1);
        this.reservedBoxPresent = bitReaderBuffer.m7683a(1);
        this.reserved = bitReaderBuffer.m7683a(5);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3300b(byteBuffer, this.DTSSamplingFrequency);
        IsoTypeWriter.m3300b(byteBuffer, this.maxBitRate);
        IsoTypeWriter.m3300b(byteBuffer, this.avgBitRate);
        IsoTypeWriter.m3303c(byteBuffer, this.pcmSampleDepth);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.m7686a(this.frameDuration, 2);
        bitWriterBuffer.m7686a(this.streamConstruction, 5);
        bitWriterBuffer.m7686a(this.coreLFEPresent, 1);
        bitWriterBuffer.m7686a(this.coreLayout, 6);
        bitWriterBuffer.m7686a(this.coreSize, 14);
        bitWriterBuffer.m7686a(this.stereoDownmix, 1);
        bitWriterBuffer.m7686a(this.representationType, 3);
        bitWriterBuffer.m7686a(this.channelLayout, 16);
        bitWriterBuffer.m7686a(this.multiAssetFlag, 1);
        bitWriterBuffer.m7686a(this.LBRDurationMod, 1);
        bitWriterBuffer.m7686a(this.reservedBoxPresent, 1);
        bitWriterBuffer.m7686a(this.reserved, 5);
    }

    public long getAvgBitRate() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avgBitRate;
    }

    public void setAvgBitRate(long j) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avgBitRate = j;
    }

    public long getDTSSamplingFrequency() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.DTSSamplingFrequency;
    }

    public void setDTSSamplingFrequency(long j) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.DTSSamplingFrequency = j;
    }

    public long getMaxBitRate() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.maxBitRate;
    }

    public void setMaxBitRate(long j) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.maxBitRate = j;
    }

    public int getPcmSampleDepth() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.pcmSampleDepth;
    }

    public void setPcmSampleDepth(int i) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.pcmSampleDepth = i;
    }

    public int getFrameDuration() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.frameDuration;
    }

    public void setFrameDuration(int i) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.frameDuration = i;
    }

    public int getStreamConstruction() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.streamConstruction;
    }

    public void setStreamConstruction(int i) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.streamConstruction = i;
    }

    public int getCoreLFEPresent() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.coreLFEPresent;
    }

    public void setCoreLFEPresent(int i) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.coreLFEPresent = i;
    }

    public int getCoreLayout() {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.coreLayout;
    }

    public void setCoreLayout(int i) {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.coreLayout = i;
    }

    public int getCoreSize() {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.coreSize;
    }

    public void setCoreSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.coreSize = i;
    }

    public int getStereoDownmix() {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.stereoDownmix;
    }

    public void setStereoDownmix(int i) {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.stereoDownmix = i;
    }

    public int getRepresentationType() {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.representationType;
    }

    public void setRepresentationType(int i) {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.representationType = i;
    }

    public int getChannelLayout() {
        JoinPoint a = Factory.a(ajc$tjp_22, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.channelLayout;
    }

    public void setChannelLayout(int i) {
        JoinPoint a = Factory.a(ajc$tjp_23, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.channelLayout = i;
    }

    public int getMultiAssetFlag() {
        JoinPoint a = Factory.a(ajc$tjp_24, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.multiAssetFlag;
    }

    public void setMultiAssetFlag(int i) {
        JoinPoint a = Factory.a(ajc$tjp_25, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.multiAssetFlag = i;
    }

    public int getLBRDurationMod() {
        JoinPoint a = Factory.a(ajc$tjp_26, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.LBRDurationMod;
    }

    public void setLBRDurationMod(int i) {
        JoinPoint a = Factory.a(ajc$tjp_27, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.LBRDurationMod = i;
    }

    public int getReserved() {
        JoinPoint a = Factory.a(ajc$tjp_28, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved;
    }

    public void setReserved(int i) {
        JoinPoint a = Factory.a(ajc$tjp_29, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved = i;
    }

    public int getReservedBoxPresent() {
        JoinPoint a = Factory.a(ajc$tjp_30, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reservedBoxPresent;
    }

    public void setReservedBoxPresent(int i) {
        JoinPoint a = Factory.a(ajc$tjp_31, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reservedBoxPresent = i;
    }

    public int[] getDashAudioChannelConfiguration() {
        int i;
        int i2;
        int channelLayout = getChannelLayout();
        if ((channelLayout & 1) == 1) {
            i = 4;
            i2 = 1;
        } else {
            i2 = 0;
            i = i2;
        }
        if ((channelLayout & 2) == 2) {
            i2 += 2;
            i = (i | 1) | 2;
        }
        if ((channelLayout & 4) == 4) {
            i2 += 2;
            i = (i | 16) | 32;
        }
        if ((channelLayout & 8) == 8) {
            i2++;
            i |= 8;
        }
        if ((channelLayout & 16) == 16) {
            i2++;
            i |= 256;
        }
        if ((channelLayout & 32) == 32) {
            i2 += 2;
            i = (i | 4096) | 16384;
        }
        if ((channelLayout & 64) == 64) {
            i2 += 2;
            i = (i | 16) | 32;
        }
        if ((channelLayout & 128) == 128) {
            i2++;
            i |= 8192;
        }
        if ((channelLayout & 256) == 256) {
            i2++;
            i |= MPEGConst.CODE_END;
        }
        if ((channelLayout & AdRequest.MAX_CONTENT_URL_LENGTH) == AdRequest.MAX_CONTENT_URL_LENGTH) {
            i2 += 2;
            i = (i | 64) | 128;
        }
        if ((channelLayout & 1024) == 1024) {
            i2 += 2;
            i = (i | AdRequest.MAX_CONTENT_URL_LENGTH) | 1024;
        }
        if ((channelLayout & MPEGConst.CODE_END) == MPEGConst.CODE_END) {
            i2 += 2;
            i = (i | 16) | 32;
        }
        if ((channelLayout & 4096) == 4096) {
            i2++;
            i |= 8;
        }
        if ((channelLayout & 8192) == 8192) {
            i2 += 2;
            i = (i | 16) | 32;
        }
        if ((channelLayout & 16384) == 16384) {
            i2++;
            i |= 65536;
        }
        if ((32768 & channelLayout) == 32768) {
            i2 += 2;
            i = 131072 | (32768 | i);
        }
        if ((65536 & channelLayout) == 65536) {
            i2++;
        }
        if ((channelLayout & 131072) == 131072) {
            i2 += 2;
        }
        return new int[]{i2, i};
    }
}
