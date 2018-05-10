package com.googlecode.mp4parser.boxes.mp4;

import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderSpecificInfo;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ProfileLevelIndicationDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ESDescriptorBox extends AbstractDescriptorBox {
    public static final String TYPE = "esds";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("ESDescriptorBox.java", ESDescriptorBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 35);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 39);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 44);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 55);
    }

    public ESDescriptorBox() {
        super(TYPE);
    }

    public ESDescriptor getEsDescriptor() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (ESDescriptor) super.getDescriptor();
    }

    public void setEsDescriptor(ESDescriptor eSDescriptor) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, eSDescriptor);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        super.setDescriptor(eSDescriptor);
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
                ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) obj;
                if (this.data == null) {
                    return eSDescriptorBox.data == null;
                } else {
                    if (this.data.equals(eSDescriptorBox.data) == null) {
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
        return this.data != null ? this.data.hashCode() : 0;
    }

    protected long getContentSize() {
        ESDescriptor esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            return (long) (4 + esDescriptor.m7682b());
        }
        return (long) (4 + this.data.remaining());
    }

    protected void getContent(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        writeVersionAndFlags(byteBuffer);
        ESDescriptor esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[esDescriptor.m7682b()]);
            IsoTypeWriter.m3303c(wrap, 3);
            esDescriptor.m7681a(wrap, esDescriptor.mo2523a());
            IsoTypeWriter.m3299b(wrap, esDescriptor.f15195a);
            IsoTypeWriter.m3303c(wrap, (((esDescriptor.f15196b << 7) | (esDescriptor.f15197c << 6)) | (esDescriptor.f15198d << 5)) | (esDescriptor.f15199e & 31));
            if (esDescriptor.f15196b > 0) {
                IsoTypeWriter.m3299b(wrap, esDescriptor.f15203i);
            }
            if (esDescriptor.f15197c > 0) {
                IsoTypeWriter.m3303c(wrap, esDescriptor.f15200f);
                IsoTypeWriter.m3305c(wrap, esDescriptor.f15201g);
            }
            if (esDescriptor.f15198d > 0) {
                IsoTypeWriter.m3299b(wrap, esDescriptor.f15204j);
            }
            DecoderConfigDescriptor decoderConfigDescriptor = esDescriptor.f15205k;
            ByteBuffer allocate = ByteBuffer.allocate(decoderConfigDescriptor.m7682b());
            IsoTypeWriter.m3303c(allocate, decoderConfigDescriptor.Y);
            decoderConfigDescriptor.m7681a(allocate, decoderConfigDescriptor.mo2523a());
            IsoTypeWriter.m3303c(allocate, decoderConfigDescriptor.f15183a);
            IsoTypeWriter.m3303c(allocate, ((decoderConfigDescriptor.f15184b << 2) | (decoderConfigDescriptor.f15185c << 1)) | 1);
            IsoTypeWriter.m3295a(allocate, decoderConfigDescriptor.f15186d);
            IsoTypeWriter.m3300b(allocate, decoderConfigDescriptor.f15187e);
            IsoTypeWriter.m3300b(allocate, decoderConfigDescriptor.f15188f);
            if (decoderConfigDescriptor.f15189g != null) {
                DecoderSpecificInfo decoderSpecificInfo = decoderConfigDescriptor.f15189g;
                ByteBuffer allocate2 = ByteBuffer.allocate(decoderSpecificInfo.m7682b());
                IsoTypeWriter.m3303c(allocate2, decoderSpecificInfo.Y);
                decoderSpecificInfo.m7681a(allocate2, decoderSpecificInfo.f15193a.length);
                allocate2.put(decoderSpecificInfo.f15193a);
                allocate.put((ByteBuffer) allocate2.rewind());
            }
            if (decoderConfigDescriptor.f15190h != null) {
                AudioSpecificConfig audioSpecificConfig = decoderConfigDescriptor.f15190h;
                ByteBuffer allocate3 = ByteBuffer.allocate(audioSpecificConfig.m7682b());
                IsoTypeWriter.m3303c(allocate3, audioSpecificConfig.Y);
                audioSpecificConfig.m7681a(allocate3, audioSpecificConfig.mo2523a());
                ByteBuffer wrap2 = ByteBuffer.wrap(new byte[audioSpecificConfig.mo2523a()]);
                BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(wrap2);
                AudioSpecificConfig.m15153a(audioSpecificConfig.f15160e, bitWriterBuffer);
                bitWriterBuffer.m7686a(audioSpecificConfig.f15161f, 4);
                if (audioSpecificConfig.f15161f == 15) {
                    bitWriterBuffer.m7686a(audioSpecificConfig.f15162g, 24);
                }
                bitWriterBuffer.m7686a(audioSpecificConfig.f15163h, 4);
                if (audioSpecificConfig.f15159d == 5 || audioSpecificConfig.f15159d == 29) {
                    audioSpecificConfig.f15164i = 5;
                    audioSpecificConfig.f15165j = true;
                    if (audioSpecificConfig.f15159d == 29) {
                        audioSpecificConfig.f15166k = true;
                    }
                    bitWriterBuffer.m7686a(audioSpecificConfig.f15167l, 4);
                    if (audioSpecificConfig.f15167l == 15) {
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15168m, 24);
                    }
                    AudioSpecificConfig.m15153a(audioSpecificConfig.f15159d, bitWriterBuffer);
                    if (audioSpecificConfig.f15159d == 22) {
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15169n, 4);
                    }
                }
                switch (audioSpecificConfig.f15159d) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15177v, 1);
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15178w, 1);
                        if (audioSpecificConfig.f15178w == 1) {
                            bitWriterBuffer.m7686a(audioSpecificConfig.f15179x, 14);
                        }
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15180y, 1);
                        if (audioSpecificConfig.f15163h == 0) {
                            throw new UnsupportedOperationException("can't parse program_config_element yet");
                        }
                        if (audioSpecificConfig.f15159d == 6 || audioSpecificConfig.f15159d == 20) {
                            bitWriterBuffer.m7686a(audioSpecificConfig.f15181z, 3);
                        }
                        if (audioSpecificConfig.f15180y == 1) {
                            if (audioSpecificConfig.f15159d == 22) {
                                bitWriterBuffer.m7686a(audioSpecificConfig.f15134A, 5);
                                bitWriterBuffer.m7686a(audioSpecificConfig.f15135B, 11);
                            }
                            if (audioSpecificConfig.f15159d == 17 || audioSpecificConfig.f15159d == 19 || audioSpecificConfig.f15159d == 20 || audioSpecificConfig.f15159d == 23) {
                                bitWriterBuffer.m7687a(audioSpecificConfig.f15136C);
                                bitWriterBuffer.m7687a(audioSpecificConfig.f15137D);
                                bitWriterBuffer.m7687a(audioSpecificConfig.f15138E);
                            }
                            bitWriterBuffer.m7686a(audioSpecificConfig.f15139F, 1);
                            if (audioSpecificConfig.f15139F == 1) {
                                throw new RuntimeException("not yet implemented");
                            }
                        }
                        break;
                    case 8:
                        throw new UnsupportedOperationException("can't write CelpSpecificConfig yet");
                    case 9:
                        throw new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
                    case 12:
                        throw new UnsupportedOperationException("can't write TTSSpecificConfig yet");
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
                    case 24:
                        throw new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
                    case 25:
                        throw new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
                    case 26:
                    case 27:
                        throw new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
                    case 28:
                        throw new UnsupportedOperationException("can't write SSCSpecificConfig yet");
                    case 30:
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15170o, 1);
                        throw new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
                    case 32:
                    case 33:
                    case 34:
                        throw new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
                    case 35:
                        throw new UnsupportedOperationException("can't write DSTSpecificConfig yet");
                    case 36:
                        bitWriterBuffer.m7686a(audioSpecificConfig.f15171p, 5);
                        throw new UnsupportedOperationException("can't write ALSSpecificConfig yet");
                    case 37:
                    case 38:
                        throw new UnsupportedOperationException("can't write SLSSpecificConfig yet");
                    case 39:
                        throw new UnsupportedOperationException("can't write ELDSpecificConfig yet");
                    case 40:
                    case 41:
                        throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
                    default:
                        break;
                }
                int i = audioSpecificConfig.f15159d;
                if (!(i == 17 || i == 39)) {
                    switch (i) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            break;
                        default:
                            break;
                    }
                }
                bitWriterBuffer.m7686a(audioSpecificConfig.f15172q, 2);
                if (audioSpecificConfig.f15172q != 2) {
                    if (audioSpecificConfig.f15172q != 3) {
                        if (audioSpecificConfig.f15172q == 3) {
                            bitWriterBuffer.m7686a(audioSpecificConfig.f15173r, 1);
                            if (audioSpecificConfig.f15173r == 0) {
                                throw new RuntimeException("not implemented");
                            }
                        }
                        if (audioSpecificConfig.f15176u >= 0) {
                            bitWriterBuffer.m7686a(audioSpecificConfig.f15176u, 11);
                            if (audioSpecificConfig.f15176u == 695) {
                                AudioSpecificConfig.m15153a(audioSpecificConfig.f15164i, bitWriterBuffer);
                                if (audioSpecificConfig.f15164i == 5) {
                                    bitWriterBuffer.m7687a(audioSpecificConfig.f15165j);
                                    if (audioSpecificConfig.f15165j) {
                                        bitWriterBuffer.m7686a(audioSpecificConfig.f15167l, 4);
                                        if (audioSpecificConfig.f15167l == 15) {
                                            bitWriterBuffer.m7686a(audioSpecificConfig.f15168m, 24);
                                        }
                                        if (audioSpecificConfig.f15175t >= 0) {
                                            bitWriterBuffer.m7686a(audioSpecificConfig.f15175t, 11);
                                            if (audioSpecificConfig.f15174s == 1352) {
                                                bitWriterBuffer.m7687a(audioSpecificConfig.f15166k);
                                            }
                                        }
                                    }
                                }
                                if (audioSpecificConfig.f15164i == 22) {
                                    bitWriterBuffer.m7687a(audioSpecificConfig.f15165j);
                                    if (audioSpecificConfig.f15165j) {
                                        i = 4;
                                        bitWriterBuffer.m7686a(audioSpecificConfig.f15167l, 4);
                                        if (audioSpecificConfig.f15167l == 15) {
                                            bitWriterBuffer.m7686a(audioSpecificConfig.f15168m, 24);
                                        }
                                    } else {
                                        i = 4;
                                    }
                                    bitWriterBuffer.m7686a(audioSpecificConfig.f15169n, i);
                                }
                            }
                        }
                        allocate3.put((ByteBuffer) wrap2.rewind());
                        allocate.put((ByteBuffer) allocate3.rewind());
                    }
                }
                throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
            }
            for (ProfileLevelIndicationDescriptor profileLevelIndicationDescriptor : decoderConfigDescriptor.f15191i) {
                ByteBuffer allocate4 = ByteBuffer.allocate(profileLevelIndicationDescriptor.m7682b());
                IsoTypeWriter.m3303c(allocate4, 20);
                profileLevelIndicationDescriptor.m7681a(allocate4, profileLevelIndicationDescriptor.mo2523a());
                IsoTypeWriter.m3303c(allocate4, profileLevelIndicationDescriptor.f15211a);
                allocate.put(allocate4);
            }
            ByteBuffer byteBuffer3 = (ByteBuffer) allocate.rewind();
            SLConfigDescriptor sLConfigDescriptor = esDescriptor.f15206l;
            ByteBuffer allocate5 = ByteBuffer.allocate(sLConfigDescriptor.m7682b());
            IsoTypeWriter.m3303c(allocate5, 6);
            sLConfigDescriptor.m7681a(allocate5, sLConfigDescriptor.mo2523a());
            IsoTypeWriter.m3303c(allocate5, sLConfigDescriptor.f15212a);
            wrap.put(byteBuffer3.array());
            wrap.put(allocate5.array());
            byteBuffer2.put((ByteBuffer) wrap.rewind());
            return;
        }
        byteBuffer2.put(this.data.duplicate());
    }
}
