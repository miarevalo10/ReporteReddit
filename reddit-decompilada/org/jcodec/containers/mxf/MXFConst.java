package org.jcodec.containers.mxf;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.Codec;
import org.jcodec.containers.mxf.model.AES3PCMDescriptor;
import org.jcodec.containers.mxf.model.CDCIEssenceDescriptor;
import org.jcodec.containers.mxf.model.ContentStorage;
import org.jcodec.containers.mxf.model.EssenceContainerData;
import org.jcodec.containers.mxf.model.FileDescriptor;
import org.jcodec.containers.mxf.model.GenericDataEssenceDescriptor;
import org.jcodec.containers.mxf.model.GenericDescriptor;
import org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor;
import org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor;
import org.jcodec.containers.mxf.model.Identification;
import org.jcodec.containers.mxf.model.IndexSegment;
import org.jcodec.containers.mxf.model.J2KPictureDescriptor;
import org.jcodec.containers.mxf.model.MPEG2VideoDescriptor;
import org.jcodec.containers.mxf.model.MXFMetadata;
import org.jcodec.containers.mxf.model.MXFPartitionPack;
import org.jcodec.containers.mxf.model.MaterialPackage;
import org.jcodec.containers.mxf.model.Preface;
import org.jcodec.containers.mxf.model.RGBAEssenceDescriptor;
import org.jcodec.containers.mxf.model.Sequence;
import org.jcodec.containers.mxf.model.SourceClip;
import org.jcodec.containers.mxf.model.SourcePackage;
import org.jcodec.containers.mxf.model.TimecodeComponent;
import org.jcodec.containers.mxf.model.TimelineTrack;
import org.jcodec.containers.mxf.model.UL;
import org.jcodec.containers.mxf.model.WaveAudioDescriptor;

public class MXFConst {
    public static UL GENERIC_DESCRIPTOR_KLV = new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1);
    public static UL HEADER_PARTITION_KLV = new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2);
    public static UL INDEX_KLV = new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 2, 1, 1, 16, 1, 0);
    public static Map<UL, Class<? extends MXFMetadata>> klMetadataMapping;

    public enum MXFCodecMapping {
        MPEG2_XDCAM(new UL(6, 14, 43, 52, 4, 1, 1, 3, 4, 1, 2, 2, 1, 4, 3, 0), Codec.MPEG2),
        MPEG2_ML(new UL(6, 14, 43, 52, 4, 1, 1, 3, 4, 1, 2, 2, 1, 1, 17, 0), Codec.MPEG2),
        MPEG2_D10_PAL(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 1, 2, 2, 1, 2, 1, 1), Codec.MPEG2),
        MPEG2_HL(new UL(6, 14, 43, 52, 4, 1, 1, 3, 4, 1, 2, 2, 1, 3, 3, 0), Codec.MPEG2),
        MPEG2_HL_422_I(new UL(6, 14, 43, 52, 4, 1, 1, 3, 4, 1, 2, 2, 1, 4, 2, 0), Codec.MPEG2),
        MPEG4_XDCAM_PROXY(new UL(6, 14, 43, 52, 4, 1, 1, 3, 4, 1, 2, 2, 1, 32, 2, 3), Codec.MPEG4),
        DV_25_PAL(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 1, 2, 2, 2, 1, 2, 0), Codec.DV),
        JPEG2000(new UL(6, 14, 43, 52, 4, 1, 1, 7, 4, 1, 2, 2, 3, 1, 1, 0), Codec.J2K),
        RAW(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 1, 2, 1, 127, 0, 0, 0), null),
        VC3_DNXD(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 1, 2, 2, 3, 2, 0, 0), Codec.VC3),
        AVC_INTRA(new UL(6, 14, 43, 52, 4, 1, 1, 10, 4, 1, 2, 2, 1, 50, 0, 0), Codec.H264),
        V210(new UL(6, 14, 43, 52, 4, 1, 1, 10, 4, 1, 2, 1, 1, 2, 2, 0), Codec.V210),
        PCM_S16LE_1(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 2, 2, 1, 0), null),
        PCM_S16LE_3(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 2, 2, 1, 1), null),
        PCM_S16LE_2(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 2, 2, 1, 127), null),
        PCM_S16BE(new UL(6, 14, 43, 52, 4, 1, 1, 7, 4, 2, 2, 1, 126), null),
        PCM_ALAW(new UL(6, 14, 43, 52, 4, 1, 1, 4, 4, 2, 2, 2, 3, 1, 1, 0), Codec.ALAW),
        AC3(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 2, 2, 2, 3, 2, 1, 0), Codec.AC3),
        MP2(new UL(6, 14, 43, 52, 4, 1, 1, 1, 4, 2, 2, 2, 3, 2, 5, 0), Codec.MP3);
        
        private Codec codec;
        private UL ul;

        private MXFCodecMapping(UL ul, Codec codec) {
            this.ul = ul;
            this.codec = codec;
        }

        public final UL getUl() {
            return this.ul;
        }

        public final Codec getCodec() {
            return this.codec;
        }
    }

    public static class KLVFill extends MXFMetadata {
        public void read(ByteBuffer byteBuffer) {
        }

        public KLVFill(UL ul) {
            super(ul);
        }
    }

    static {
        Map hashMap = new HashMap();
        klMetadataMapping = hashMap;
        hashMap.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 24, 0), ContentStorage.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 55, 0), SourcePackage.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 15, 0), Sequence.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 47, 0), Preface.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 48, 0), Identification.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 17, 0), SourceClip.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 35, 0), EssenceContainerData.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 58, 0), TimelineTrack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 59, 0), TimelineTrack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 54, 0), MaterialPackage.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 2, 1, 1, 16, 1, 0), IndexSegment.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 68, 0), GenericDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 91, 0), GenericDataEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 91, 0), GenericDataEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 92, 0), GenericDataEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 67, 0), GenericDataEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 66, 0), GenericSoundEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 40, 0), CDCIEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 41, 0), RGBAEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 81, 0), MPEG2VideoDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 72, 0), WaveAudioDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 37, 0), FileDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 39, 0), GenericPictureEssenceDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 71, 0), AES3PCMDescriptor.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 5, 1, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2, 1, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2, 2, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2, 3, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 2, 4, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 3, 1, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 3, 2, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 3, 3, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 3, 4, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 4, 2, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 5, 1, 1, 13, 1, 2, 1, 1, 4, 4, 0), MXFPartitionPack.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 20, 0), TimecodeComponent.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 1, 1, 1, 2, 3, 1, 2, 16, 1, 0, 0, 0), KLVFill.class);
        klMetadataMapping.put(new UL(6, 14, 43, 52, 2, 83, 1, 1, 13, 1, 1, 1, 1, 1, 90, 0), J2KPictureDescriptor.class);
    }
}
