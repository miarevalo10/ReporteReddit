package org.jcodec.codecs.h264;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.gms.ads.AdRequest;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.write.SliceHeaderWriter;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.FileChannelWrapper;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;
import org.jcodec.containers.mp4.muxer.MP4Muxer;

public class H264Utils {
    private static SliceHeaderReader shr = new SliceHeaderReader();
    private static SliceHeaderWriter shw = new SliceHeaderWriter();

    public static abstract class SliceHeaderTweaker {
        private List<PictureParameterSet> pps;
        private List<SeqParameterSet> sps;

        public abstract void tweak(SliceHeader sliceHeader);

        public SliceHeaderTweaker(List<ByteBuffer> list, List<ByteBuffer> list2) {
            this.sps = H264Utils.readSPS((List) list);
            this.pps = H264Utils.readPPS((List) list2);
        }

        public SliceHeader run(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit) {
            ByteBuffer duplicate = byteBuffer2.duplicate();
            H264Utils.unescapeNAL(byteBuffer);
            BitReader bitReader = new BitReader(byteBuffer);
            SliceHeader readPart1 = H264Utils.shr.readPart1(bitReader);
            PictureParameterSet findPPS = H264Utils.findPPS(this.pps, readPart1.pic_parameter_set_id);
            return part2(byteBuffer, byteBuffer2, nALUnit, H264Utils.findSPS(this.sps, findPPS.pic_parameter_set_id), findPPS, duplicate, bitReader, readPart1);
        }

        public SliceHeader run(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
            ByteBuffer duplicate = byteBuffer2.duplicate();
            H264Utils.unescapeNAL(byteBuffer);
            BitReader bitReader = new BitReader(byteBuffer);
            return part2(byteBuffer, byteBuffer2, nALUnit, seqParameterSet, pictureParameterSet, duplicate, bitReader, H264Utils.shr.readPart1(bitReader));
        }

        private SliceHeader part2(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, ByteBuffer byteBuffer3, BitReader bitReader, SliceHeader sliceHeader) {
            BitWriter bitWriter = new BitWriter(byteBuffer2);
            H264Utils.shr.readPart2(sliceHeader, nALUnit, seqParameterSet, pictureParameterSet, bitReader);
            tweak(sliceHeader);
            H264Utils.shw.write(sliceHeader, nALUnit.type == NALUnitType.IDR_SLICE, nALUnit.nal_ref_idc, bitWriter);
            if (pictureParameterSet.entropy_coding_mode_flag != null) {
                copyDataCABAC(byteBuffer, byteBuffer2, bitReader, bitWriter);
            } else {
                copyDataCAVLC(byteBuffer, byteBuffer2, bitReader, bitWriter);
            }
            byteBuffer3.limit(byteBuffer2.position());
            H264Utils.escapeNAL(byteBuffer3);
            byteBuffer2.position(byteBuffer3.limit());
            return sliceHeader;
        }

        private void copyDataCAVLC(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, BitReader bitReader, BitWriter bitWriter) {
            int curBit = 8 - bitWriter.curBit();
            if (curBit != 0) {
                bitWriter.writeNBit(bitReader.readNBit(curBit), curBit);
            }
            bitWriter.flush();
            bitWriter = bitReader.curBit();
            if (bitWriter != null) {
                curBit = 8 - bitWriter;
                int readNBit = bitReader.readNBit(curBit);
                bitReader.stop();
                while (byteBuffer.hasRemaining() != null) {
                    bitReader = readNBit << bitWriter;
                    readNBit = byteBuffer.get() & 255;
                    byteBuffer2.put((byte) (bitReader | (readNBit >> curBit)));
                }
                byteBuffer2.put((byte) (readNBit << bitWriter));
                return;
            }
            bitReader.stop();
            byteBuffer2.put(byteBuffer);
        }

        private void copyDataCABAC(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, BitReader bitReader, BitWriter bitWriter) {
            long curBit = (long) bitReader.curBit();
            if (curBit != 0) {
                if (((long) ((1 << ((int) (8 - curBit))) - 1)) != ((long) bitReader.readNBit(8 - ((int) curBit)))) {
                    throw new RuntimeException("Invalid CABAC padding");
                }
            }
            if (bitWriter.curBit() != 0) {
                bitWriter.writeNBit(255, 8 - bitWriter.curBit());
            }
            bitWriter.flush();
            bitReader.stop();
            byteBuffer2.put(byteBuffer);
        }
    }

    public static int golomb2Signed(int i) {
        int i2 = i & 1;
        return ((i >> 1) + i2) * ((i2 << 1) - 1);
    }

    public static ByteBuffer nextNALUnit(ByteBuffer byteBuffer) {
        skipToNALUnit(byteBuffer);
        return gotoNALUnit(byteBuffer);
    }

    public static final void skipToNALUnit(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int i = -1;
            while (byteBuffer.hasRemaining()) {
                i = (i << 8) | (byteBuffer.get() & 255);
                if ((16777215 & i) == 1) {
                    byteBuffer.position(byteBuffer.position());
                    break;
                }
            }
        }
    }

    public static final ByteBuffer gotoNALUnit(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int position = byteBuffer.position();
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.BIG_ENDIAN);
        int i = -1;
        while (byteBuffer.hasRemaining()) {
            i = (i << 8) | (byteBuffer.get() & 255);
            if ((16777215 & i) == 1) {
                byteBuffer.position(byteBuffer.position() - (i == 1 ? 4 : 3));
                slice.limit(byteBuffer.position() - position);
                return slice;
            }
        }
        return slice;
    }

    public static final void unescapeNAL(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer.duplicate();
            byte b = duplicate.get();
            duplicate2.put(b);
            byte b2 = duplicate.get();
            duplicate2.put(b2);
            while (duplicate.hasRemaining()) {
                byte b3 = duplicate.get();
                if (b != (byte) 0 || b2 != (byte) 0 || b3 != (byte) 3) {
                    duplicate2.put(b3);
                }
                b = b2;
                b2 = b3;
            }
            byteBuffer.limit(duplicate2.position());
        }
    }

    public static final void escapeNAL(ByteBuffer byteBuffer) {
        int[] searchEscapeLocations = searchEscapeLocations(byteBuffer);
        int limit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.limit() + searchEscapeLocations.length);
        int limit2 = byteBuffer.limit() - 1;
        limit--;
        int length = searchEscapeLocations.length - 1;
        while (limit2 >= byteBuffer.position()) {
            byteBuffer.put(limit2, byteBuffer.get(limit));
            if (length >= 0 && searchEscapeLocations[length] == limit) {
                limit2--;
                byteBuffer.put(limit2, (byte) 3);
                length--;
            }
            limit2--;
            limit--;
        }
    }

    private static int[] searchEscapeLocations(ByteBuffer byteBuffer) {
        IntArrayList intArrayList = new IntArrayList();
        byteBuffer = byteBuffer.duplicate();
        int i = byteBuffer.getShort();
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (i == 0 && (b & -4) == 0) {
                intArrayList.add(byteBuffer.position() - 1);
                i = 3;
            }
            i = (short) (((short) (i << 8)) | (b & 255));
        }
        return intArrayList.toArray();
    }

    public static final void escapeNAL(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte b = byteBuffer.get();
        byte b2 = byteBuffer.get();
        byteBuffer2.put(b);
        byteBuffer2.put(b2);
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            if (b == (byte) 0 && b2 == (byte) 0 && (b3 & 255) <= 3) {
                byteBuffer2.put((byte) 3);
                b = (byte) 3;
            } else {
                b = b2;
            }
            byteBuffer2.put(b3);
            b2 = b3;
        }
    }

    public static List<ByteBuffer> splitMOVPacket(ByteBuffer byteBuffer, AvcCBox avcCBox) {
        List<ByteBuffer> arrayList = new ArrayList();
        avcCBox = avcCBox.getNalLengthSize();
        byteBuffer = byteBuffer.duplicate();
        while (byteBuffer.remaining() >= avcCBox) {
            int readLen = readLen(byteBuffer, avcCBox);
            if (readLen == 0) {
                break;
            }
            arrayList.add(NIOUtils.read(byteBuffer, readLen));
        }
        return arrayList;
    }

    private static int readLen(ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 1:
                return byteBuffer.get() & 255;
            case 2:
                return byteBuffer.getShort() & 65535;
            case 3:
                return (byteBuffer.get() & 255) | ((byteBuffer.getShort() & 65535) << 8);
            case 4:
                return byteBuffer.getInt();
            default:
                StringBuilder stringBuilder = new StringBuilder("NAL Unit length size can not be ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static void encodeMOVPacket(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        byteBuffer = byteBuffer.duplicate();
        int position = byteBuffer.position();
        while (true) {
            ByteBuffer nextNALUnit = nextNALUnit(duplicate);
            if (nextNALUnit != null) {
                byteBuffer.position(position);
                byteBuffer.putInt(nextNALUnit.remaining());
                position += nextNALUnit.remaining() + 4;
            } else {
                return;
            }
        }
    }

    public static void wipePS(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, List<ByteBuffer> list, List<ByteBuffer> list2) {
        byteBuffer = byteBuffer.duplicate();
        while (byteBuffer.hasRemaining()) {
            ByteBuffer nextNALUnit = nextNALUnit(byteBuffer);
            if (nextNALUnit == null) {
                break;
            }
            NALUnit read = NALUnit.read(nextNALUnit.duplicate());
            if (read.type == NALUnitType.PPS) {
                if (list2 != null) {
                    list2.add(nextNALUnit);
                }
            } else if (read.type != NALUnitType.SPS) {
                byteBuffer2.putInt(1);
                byteBuffer2.put(nextNALUnit);
            } else if (list != null) {
                list.add(nextNALUnit);
            }
        }
        byteBuffer2.flip();
    }

    public static void wipePS(ByteBuffer byteBuffer, List<ByteBuffer> list, List<ByteBuffer> list2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (duplicate.hasRemaining()) {
            ByteBuffer nextNALUnit = nextNALUnit(duplicate);
            if (nextNALUnit != null) {
                NALUnit read = NALUnit.read(nextNALUnit);
                if (read.type == NALUnitType.PPS) {
                    if (list2 != null) {
                        list2.add(nextNALUnit);
                    }
                    byteBuffer.position(duplicate.position());
                } else if (read.type == NALUnitType.SPS) {
                    if (list != null) {
                        list.add(nextNALUnit);
                    }
                    byteBuffer.position(duplicate.position());
                } else if (read.type == NALUnitType.IDR_SLICE || read.type == NALUnitType.NON_IDR_SLICE) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static AvcCBox createAvcC(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        seqParameterSet.write(allocate);
        allocate.flip();
        escapeNAL(allocate);
        ByteBuffer allocate2 = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        pictureParameterSet.write(allocate2);
        allocate2.flip();
        escapeNAL(allocate2);
        return new AvcCBox(seqParameterSet.profile_idc, 0, seqParameterSet.level_idc, i, Arrays.asList(new ByteBuffer[]{allocate}), Arrays.asList(new ByteBuffer[]{allocate2}));
    }

    public static AvcCBox createAvcC(List<SeqParameterSet> list, List<PictureParameterSet> list2, int i) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (SeqParameterSet seqParameterSet : list) {
            ByteBuffer allocate = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
            seqParameterSet.write(allocate);
            allocate.flip();
            escapeNAL(allocate);
            arrayList.add(allocate);
        }
        for (PictureParameterSet pictureParameterSet : list2) {
            ByteBuffer allocate2 = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
            pictureParameterSet.write(allocate2);
            allocate2.flip();
            escapeNAL(allocate2);
            arrayList2.add(allocate2);
        }
        SeqParameterSet seqParameterSet2 = (SeqParameterSet) list.get(null);
        return new AvcCBox(seqParameterSet2.profile_idc, 0, seqParameterSet2.level_idc, i, arrayList, arrayList2);
    }

    public static SampleEntry createMOVSampleEntry(List<ByteBuffer> list, List<ByteBuffer> list2, int i) {
        SeqParameterSet readSPS = readSPS(NIOUtils.duplicate((ByteBuffer) list.get(0)));
        return createMOVSampleEntry(new AvcCBox(readSPS.profile_idc, 0, readSPS.level_idc, i, list, list2));
    }

    public static SampleEntry createMOVSampleEntry(AvcCBox avcCBox) {
        SeqParameterSet read = SeqParameterSet.read(((ByteBuffer) avcCBox.getSpsList().get(0)).duplicate());
        int i = (read.pic_width_in_mbs_minus1 + 1) << 4;
        int picHeightInMbs = getPicHeightInMbs(read) << 4;
        if (read.frame_cropping_flag) {
            i -= (read.frame_crop_right_offset + read.frame_crop_left_offset) << read.chroma_format_idc.compWidth[1];
        }
        if (read.frame_cropping_flag) {
            picHeightInMbs -= (read.frame_crop_bottom_offset + read.frame_crop_top_offset) << read.chroma_format_idc.compHeight[1];
        }
        SampleEntry videoSampleEntry = MP4Muxer.videoSampleEntry(VisualSampleEntry.TYPE3, new Size(i, picHeightInMbs), "JCodec");
        videoSampleEntry.add(avcCBox);
        return videoSampleEntry;
    }

    public static SampleEntry createMOVSampleEntry(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        ByteBuffer allocate2 = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        seqParameterSet.write(allocate);
        pictureParameterSet.write(allocate2);
        allocate.flip();
        allocate2.flip();
        return createMOVSampleEntry(Arrays.asList(new ByteBuffer[]{allocate}), Arrays.asList(new ByteBuffer[]{allocate2}), i);
    }

    public static boolean idrSlice(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        ByteBuffer nextNALUnit;
        do {
            nextNALUnit = nextNALUnit(byteBuffer);
            if (nextNALUnit == null) {
                return null;
            }
        } while (NALUnit.read(nextNALUnit).type != NALUnitType.IDR_SLICE);
        return true;
    }

    public static boolean idrSlice(List<ByteBuffer> list) {
        for (ByteBuffer duplicate : list) {
            if (NALUnit.read(duplicate.duplicate()).type == NALUnitType.IDR_SLICE) {
                return true;
            }
        }
        return null;
    }

    public static void saveRawFrame(ByteBuffer byteBuffer, AvcCBox avcCBox, File file) throws IOException {
        file = NIOUtils.writableFileChannel(file);
        saveStreamParams(avcCBox, file);
        file.write(byteBuffer.duplicate());
        file.close();
    }

    public static void saveStreamParams(AvcCBox avcCBox, SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        for (ByteBuffer byteBuffer : avcCBox.getSpsList()) {
            seekableByteChannel.write(ByteBuffer.wrap(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 103}));
            escapeNAL(byteBuffer.duplicate(), allocate);
            allocate.flip();
            seekableByteChannel.write(allocate);
            allocate.clear();
        }
        for (ByteBuffer byteBuffer2 : avcCBox.getPpsList()) {
            seekableByteChannel.write(ByteBuffer.wrap(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 104}));
            escapeNAL(byteBuffer2.duplicate(), allocate);
            allocate.flip();
            seekableByteChannel.write(allocate);
            allocate.clear();
        }
    }

    public static int getPicHeightInMbs(SeqParameterSet seqParameterSet) {
        return (seqParameterSet.pic_height_in_map_units_minus1 + 1) << (seqParameterSet.frame_mbs_only_flag ^ 1);
    }

    public static List<ByteBuffer> splitFrame(ByteBuffer byteBuffer) {
        List arrayList = new ArrayList();
        while (true) {
            ByteBuffer nextNALUnit = nextNALUnit(byteBuffer);
            if (nextNALUnit == null) {
                return arrayList;
            }
            arrayList.add(nextNALUnit);
        }
    }

    public static void joinNALUnits(List<ByteBuffer> list, ByteBuffer byteBuffer) {
        for (ByteBuffer byteBuffer2 : list) {
            byteBuffer.putInt(1);
            byteBuffer.put(byteBuffer2.duplicate());
        }
    }

    public static ByteBuffer getAvcCData(AvcCBox avcCBox) {
        ByteBuffer allocate = ByteBuffer.allocate(MPEGConst.CODE_END);
        avcCBox.doWrite(allocate);
        allocate.flip();
        return allocate;
    }

    public static AvcCBox parseAVCC(VideoSampleEntry videoSampleEntry) {
        Box box = (Box) Box.findFirst(videoSampleEntry, Box.class, AvcConfigurationBox.TYPE);
        if (box instanceof AvcCBox) {
            return (AvcCBox) box;
        }
        return parseAVCC(((LeafBox) box).getData().duplicate());
    }

    public static AvcCBox parseAVCC(ByteBuffer byteBuffer) {
        AvcCBox avcCBox = new AvcCBox();
        avcCBox.parse(byteBuffer);
        return avcCBox;
    }

    public static ByteBuffer writeSPS(SeqParameterSet seqParameterSet, int i) {
        i = ByteBuffer.allocate(i + 8);
        seqParameterSet.write(i);
        i.flip();
        escapeNAL(i);
        return i;
    }

    public static SeqParameterSet readSPS(ByteBuffer byteBuffer) {
        byteBuffer = NIOUtils.duplicate(byteBuffer);
        unescapeNAL(byteBuffer);
        return SeqParameterSet.read(byteBuffer);
    }

    public static ByteBuffer writePPS(PictureParameterSet pictureParameterSet, int i) {
        i = ByteBuffer.allocate(i + 8);
        pictureParameterSet.write(i);
        i.flip();
        escapeNAL(i);
        return i;
    }

    public static PictureParameterSet readPPS(ByteBuffer byteBuffer) {
        byteBuffer = NIOUtils.duplicate(byteBuffer);
        unescapeNAL(byteBuffer);
        return PictureParameterSet.read(byteBuffer);
    }

    public static PictureParameterSet findPPS(List<PictureParameterSet> list, int i) {
        for (PictureParameterSet pictureParameterSet : list) {
            if (pictureParameterSet.pic_parameter_set_id == i) {
                return pictureParameterSet;
            }
        }
        return null;
    }

    public static SeqParameterSet findSPS(List<SeqParameterSet> list, int i) {
        for (SeqParameterSet seqParameterSet : list) {
            if (seqParameterSet.seq_parameter_set_id == i) {
                return seqParameterSet;
            }
        }
        return null;
    }

    public static Size getPicSize(SeqParameterSet seqParameterSet) {
        int i = (seqParameterSet.pic_width_in_mbs_minus1 + 1) << 4;
        int picHeightInMbs = getPicHeightInMbs(seqParameterSet) << 4;
        if (seqParameterSet.frame_cropping_flag) {
            i -= (seqParameterSet.frame_crop_left_offset + seqParameterSet.frame_crop_right_offset) << seqParameterSet.chroma_format_idc.compWidth[1];
            picHeightInMbs -= (seqParameterSet.frame_crop_top_offset + seqParameterSet.frame_crop_bottom_offset) << seqParameterSet.chroma_format_idc.compHeight[1];
        }
        return new Size(i, picHeightInMbs);
    }

    public static List<SeqParameterSet> readSPS(List<ByteBuffer> list) {
        List<SeqParameterSet> arrayList = new ArrayList();
        for (ByteBuffer duplicate : list) {
            arrayList.add(readSPS(NIOUtils.duplicate(duplicate)));
        }
        return arrayList;
    }

    public static List<PictureParameterSet> readPPS(List<ByteBuffer> list) {
        List<PictureParameterSet> arrayList = new ArrayList();
        for (ByteBuffer duplicate : list) {
            arrayList.add(readPPS(NIOUtils.duplicate(duplicate)));
        }
        return arrayList;
    }

    public static List<ByteBuffer> writePPS(List<PictureParameterSet> list) {
        List<ByteBuffer> arrayList = new ArrayList();
        for (PictureParameterSet writePPS : list) {
            arrayList.add(writePPS(writePPS, 64));
        }
        return arrayList;
    }

    public static List<ByteBuffer> writeSPS(List<SeqParameterSet> list) {
        List<ByteBuffer> arrayList = new ArrayList();
        for (SeqParameterSet writeSPS : list) {
            arrayList.add(writeSPS(writeSPS, 256));
        }
        return arrayList;
    }

    public static void dumpFrame(FileChannelWrapper fileChannelWrapper, SeqParameterSet[] seqParameterSetArr, PictureParameterSet[] pictureParameterSetArr, List<ByteBuffer> list) throws IOException {
        int i = 0;
        for (SeqParameterSet seqParameterSet : seqParameterSetArr) {
            NIOUtils.writeInt(fileChannelWrapper, 1);
            NIOUtils.writeByte(fileChannelWrapper, (byte) 103);
            fileChannelWrapper.write(writeSPS(seqParameterSet, 128));
        }
        seqParameterSetArr = pictureParameterSetArr.length;
        while (i < seqParameterSetArr) {
            PictureParameterSet pictureParameterSet = pictureParameterSetArr[i];
            NIOUtils.writeInt(fileChannelWrapper, 1);
            NIOUtils.writeByte(fileChannelWrapper, (byte) 104);
            fileChannelWrapper.write(writePPS(pictureParameterSet, 256));
            i++;
        }
        for (ByteBuffer byteBuffer : list) {
            NIOUtils.writeInt(fileChannelWrapper, 1);
            fileChannelWrapper.write(byteBuffer.duplicate());
        }
    }

    public static void toNAL(ByteBuffer byteBuffer, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        ByteBuffer allocate = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        ByteBuffer allocate2 = ByteBuffer.allocate(AdRequest.MAX_CONTENT_URL_LENGTH);
        seqParameterSet.write(allocate);
        pictureParameterSet.write(allocate2);
        allocate.flip();
        allocate2.flip();
        putNAL(byteBuffer, allocate, 103);
        putNAL(byteBuffer, allocate2, 104);
    }

    public static void toNAL(ByteBuffer byteBuffer, List<ByteBuffer> list, List<ByteBuffer> list2) {
        for (ByteBuffer putNAL : list) {
            putNAL(byteBuffer, putNAL, 103);
        }
        for (ByteBuffer putNAL2 : list2) {
            putNAL(byteBuffer, putNAL2, 104);
        }
    }

    private static void putNAL(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer2.remaining() * 2);
        escapeNAL(byteBuffer2, allocate);
        allocate.flip();
        byteBuffer.putInt(1);
        byteBuffer.put((byte) i);
        byteBuffer.put(allocate);
    }
}
