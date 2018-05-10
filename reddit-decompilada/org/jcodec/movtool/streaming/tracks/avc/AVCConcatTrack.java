package org.jcodec.movtool.streaming.tracks.avc;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.H264Utils.SliceHeaderTweaker;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class AVCConcatTrack implements VirtualTrack {
    private List<PictureParameterSet> allPps;
    private List<SeqParameterSet> allSps;
    private AvcCBox[] avcCs;
    private int idx = 0;
    private VirtualPacket lastPacket;
    private Map<Integer, Integer> map;
    private int offsetFn = 0;
    private double offsetPts = 0.0d;
    private CodecMeta se;
    private VirtualTrack[] tracks;
    private SliceHeaderTweaker[] tweakers;

    public class AVCConcatPacket implements VirtualPacket {
        private int fnOffset;
        private int idx;
        private VirtualPacket packet;
        private double ptsOffset;

        public AVCConcatPacket(VirtualPacket virtualPacket, double d, int i, int i2) {
            this.packet = virtualPacket;
            this.ptsOffset = d;
            this.fnOffset = i;
            this.idx = i2;
        }

        public ByteBuffer getData() throws IOException {
            return AVCConcatTrack.this.patchPacket(this.idx, this.packet.getData());
        }

        public int getDataLen() throws IOException {
            return this.packet.getDataLen() + 8;
        }

        public double getPts() {
            return this.ptsOffset + this.packet.getPts();
        }

        public double getDuration() {
            return this.packet.getDuration();
        }

        public boolean isKeyframe() {
            return this.packet.isKeyframe();
        }

        public int getFrameNo() {
            return this.fnOffset + this.packet.getFrameNo();
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public AVCConcatTrack(VirtualTrack... virtualTrackArr) {
        this.tracks = virtualTrackArr;
        this.avcCs = new AvcCBox[virtualTrackArr.length];
        this.allPps = new ArrayList();
        this.allSps = new ArrayList();
        this.tweakers = new SliceHeaderTweaker[virtualTrackArr.length];
        int i = 0;
        Rational rational = null;
        int i2 = i;
        while (i2 < virtualTrackArr.length) {
            CodecMeta codecMeta = virtualTrackArr[i2].getCodecMeta();
            if (!(codecMeta instanceof VideoCodecMeta)) {
                throw new RuntimeException("Not a video track.");
            } else if (VisualSampleEntry.TYPE3.equals(codecMeta.getFourcc())) {
                VideoCodecMeta videoCodecMeta = (VideoCodecMeta) codecMeta;
                Rational pasp = videoCodecMeta.getPasp();
                if (rational == null || pasp == null || rational.equals(pasp)) {
                    AvcCBox parseAVCC = H264Utils.parseAVCC(videoCodecMeta.getCodecPrivate());
                    if (i == 0) {
                        i = parseAVCC.getNalLengthSize();
                    } else if (i != parseAVCC.getNalLengthSize()) {
                        throw new RuntimeException("Unable to concat AVC tracks with different NAL length size in AvcC box");
                    }
                    for (ByteBuffer duplicate : parseAVCC.getPpsList()) {
                        PictureParameterSet readPPS = H264Utils.readPPS(NIOUtils.duplicate(duplicate));
                        int i3 = i2 << 8;
                        readPPS.pic_parameter_set_id |= i3;
                        readPPS.seq_parameter_set_id |= i3;
                        this.allPps.add(readPPS);
                    }
                    for (ByteBuffer duplicate2 : parseAVCC.getSpsList()) {
                        SeqParameterSet readSPS = H264Utils.readSPS(NIOUtils.duplicate(duplicate2));
                        readSPS.seq_parameter_set_id |= i2 << 8;
                        this.allSps.add(readSPS);
                    }
                    this.tweakers[i2] = new SliceHeaderTweaker(this, parseAVCC.getSpsList(), parseAVCC.getPpsList()) {
                        final /* synthetic */ AVCConcatTrack f33320b;

                        protected void tweak(SliceHeader sliceHeader) {
                            sliceHeader.pic_parameter_set_id = ((Integer) this.f33320b.map.get(Integer.valueOf((i2 << 8) | sliceHeader.pic_parameter_set_id))).intValue();
                        }
                    };
                    this.avcCs[i2] = parseAVCC;
                    i2++;
                    rational = pasp;
                } else {
                    throw new RuntimeException("Can not concat video tracks with different Pixel Aspect Ratio.");
                }
            } else {
                throw new RuntimeException("Not an AVC track.");
            }
        }
        this.map = mergePS(this.allSps, this.allPps);
        VideoCodecMeta videoCodecMeta2 = (VideoCodecMeta) virtualTrackArr[0].getCodecMeta();
        this.se = new VideoCodecMeta(VisualSampleEntry.TYPE3, H264Utils.getAvcCData(H264Utils.createAvcC(this.allSps, this.allPps, i)), videoCodecMeta2.getSize(), videoCodecMeta2.getPasp());
    }

    private Map<Integer, Integer> mergePS(List<SeqParameterSet> list, List<PictureParameterSet> list2) {
        List arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            SeqParameterSet seqParameterSet = (SeqParameterSet) it.next();
            int i2 = seqParameterSet.seq_parameter_set_id;
            seqParameterSet.seq_parameter_set_id = 0;
            ByteBuffer writeSPS = H264Utils.writeSPS(seqParameterSet, 32);
            i = NIOUtils.find(arrayList, writeSPS);
            if (i == -1) {
                i = arrayList.size();
                arrayList.add(writeSPS);
            }
            for (PictureParameterSet pictureParameterSet : list2) {
                if (pictureParameterSet.seq_parameter_set_id == i2) {
                    pictureParameterSet.seq_parameter_set_id = i;
                }
            }
        }
        Map<Integer, Integer> hashMap = new HashMap();
        List arrayList2 = new ArrayList();
        for (PictureParameterSet pictureParameterSet2 : list2) {
            int i3 = pictureParameterSet2.pic_parameter_set_id;
            pictureParameterSet2.pic_parameter_set_id = 0;
            ByteBuffer writePPS = H264Utils.writePPS(pictureParameterSet2, 128);
            int find = NIOUtils.find(arrayList2, writePPS);
            if (find == -1) {
                find = arrayList2.size();
                arrayList2.add(writePPS);
            }
            hashMap.put(Integer.valueOf(i3), Integer.valueOf(find));
        }
        list.clear();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            SeqParameterSet readSPS = H264Utils.readSPS((ByteBuffer) arrayList.get(i4));
            readSPS.seq_parameter_set_id = i4;
            list.add(readSPS);
        }
        list2.clear();
        while (i < arrayList2.size()) {
            list = H264Utils.readPPS((ByteBuffer) arrayList2.get(i));
            list.pic_parameter_set_id = i;
            list2.add(list);
            i++;
        }
        return hashMap;
    }

    public VirtualPacket nextPacket() throws IOException {
        while (this.idx < this.tracks.length) {
            VirtualPacket nextPacket = this.tracks[this.idx].nextPacket();
            if (nextPacket == null) {
                this.idx++;
                this.offsetPts += this.lastPacket.getPts() + this.lastPacket.getDuration();
                this.offsetFn += this.lastPacket.getFrameNo() + 1;
            } else {
                this.lastPacket = nextPacket;
                return new AVCConcatPacket(nextPacket, this.offsetPts, this.offsetFn, this.idx);
            }
        }
        return null;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }

    public int getPreferredTimescale() {
        return this.tracks[0].getPreferredTimescale();
    }

    public void close() throws IOException {
        for (VirtualTrack close : this.tracks) {
            close.close();
        }
    }

    private ByteBuffer patchPacket(int i, ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + 8);
        for (ByteBuffer byteBuffer2 : H264Utils.splitMOVPacket(byteBuffer, this.avcCs[i])) {
            NALUnit read = NALUnit.read(byteBuffer2);
            if (read.type != NALUnitType.IDR_SLICE) {
                if (read.type != NALUnitType.NON_IDR_SLICE) {
                    StringBuilder stringBuilder = new StringBuilder("Skipping NAL unit: ");
                    stringBuilder.append(read.type);
                    Logger.warn(stringBuilder.toString());
                }
            }
            ByteBuffer duplicate = allocate.duplicate();
            allocate.putInt(0);
            read.write(allocate);
            this.tweakers[i].run(byteBuffer2, allocate, read);
            duplicate.putInt((allocate.position() - duplicate.position()) - 4);
        }
        if (allocate.remaining() >= 5) {
            i = this.avcCs[i].getNalLengthSize();
            byteBuffer = allocate.remaining() - i;
            if (i == 4) {
                allocate.putInt(byteBuffer);
            } else if (i == 2) {
                allocate.putShort((short) byteBuffer);
            } else if (i == 3) {
                allocate.put((byte) (byteBuffer >> 16));
                allocate.putShort((short) (65535 & byteBuffer));
            }
            new NALUnit(NALUnitType.FILLER_DATA, 0).write(allocate);
        }
        allocate.clear();
        return allocate;
    }
}
