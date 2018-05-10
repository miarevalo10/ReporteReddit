package org.jcodec.movtool.streaming.tracks.avc;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.H264Utils.SliceHeaderTweaker;
import org.jcodec.codecs.h264.encode.H264FixedRateControl;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.tracks.ClipTrack;
import org.jcodec.movtool.streaming.tracks.VirtualPacketWrapper;

public class AVCClipTrack extends ClipTrack {
    private AvcCBox avcC;
    private PictureParameterSet encPPS;
    private SeqParameterSet encSPS;
    private int frameSize;
    private int mbH;
    private int mbW;
    private H264FixedRateControl rc;
    private VideoCodecMeta se;

    public class GopTranscoder {
        private List<VirtualPacket> head;
        private List<ByteBuffer> result;
        private List<VirtualPacket> tail;

        class C26571 extends SliceHeaderTweaker {
            final /* synthetic */ GopTranscoder f33318a;

            C26571(GopTranscoder gopTranscoder) {
                this.f33318a = gopTranscoder;
            }

            protected void tweak(SliceHeader sliceHeader) {
                sliceHeader.pic_parameter_set_id = 1;
            }
        }

        public GopTranscoder(List<VirtualPacket> list, List<VirtualPacket> list2) {
            this.head = list;
            this.tail = list2;
        }

        public List<ByteBuffer> transcode() throws IOException {
            H264Decoder h264Decoder = new H264Decoder();
            h264Decoder.addSps(AVCClipTrack.this.avcC.getSpsList());
            h264Decoder.addPps(AVCClipTrack.this.avcC.getPpsList());
            Picture create = Picture.create(AVCClipTrack.this.mbW << 4, AVCClipTrack.this.mbH << 4, ColorSpace.YUV420);
            for (VirtualPacket data : this.head) {
                h264Decoder.decodeFrame(H264Utils.splitMOVPacket(data.getData(), AVCClipTrack.this.avcC), create.getData());
            }
            H264Encoder h264Encoder = new H264Encoder(AVCClipTrack.this.rc);
            ByteBuffer allocate = ByteBuffer.allocate(AVCClipTrack.this.frameSize);
            List<ByteBuffer> arrayList = new ArrayList();
            for (VirtualPacket data2 : this.tail) {
                Picture decodeFrame = h264Decoder.decodeFrame(H264Utils.splitMOVPacket(data2.getData(), AVCClipTrack.this.avcC), create.getData());
                allocate.clear();
                ByteBuffer encodeFrame = h264Encoder.encodeFrame(decodeFrame, allocate);
                ByteBuffer allocate2 = ByteBuffer.allocate(AVCClipTrack.this.frameSize);
                processFrame(encodeFrame, allocate2);
                arrayList.add(allocate2);
            }
            return arrayList;
        }

        private void processFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            SliceHeaderTweaker c26571 = new C26571(this);
            byteBuffer = byteBuffer.duplicate();
            while (byteBuffer.hasRemaining()) {
                ByteBuffer nextNALUnit = H264Utils.nextNALUnit(byteBuffer);
                if (nextNALUnit == null) {
                    break;
                }
                NALUnit read = NALUnit.read(nextNALUnit);
                if (read.type == NALUnitType.IDR_SLICE) {
                    ByteBuffer duplicate = byteBuffer2.duplicate();
                    byteBuffer2.putInt(0);
                    read.write(byteBuffer2);
                    c26571.run(nextNALUnit, byteBuffer2, read, AVCClipTrack.this.encSPS, AVCClipTrack.this.encPPS);
                    duplicate.putInt((byteBuffer2.position() - duplicate.position()) - 4);
                }
            }
            if (byteBuffer2.remaining() >= 5) {
                byteBuffer2.putInt(byteBuffer2.remaining() - 4);
                new NALUnit(NALUnitType.FILLER_DATA, 0).write(byteBuffer2);
            }
            byteBuffer2.clear();
        }

        public synchronized List<ByteBuffer> getResult() throws IOException {
            if (this.result == null) {
                this.result = transcode();
            }
            return this.result;
        }
    }

    public class TranscodePacket extends VirtualPacketWrapper {
        private int off;
        private GopTranscoder tr;

        public boolean isKeyframe() {
            return true;
        }

        public TranscodePacket(VirtualPacket virtualPacket, GopTranscoder gopTranscoder, int i) {
            super(virtualPacket);
            this.tr = gopTranscoder;
            this.off = i;
        }

        public ByteBuffer getData() throws IOException {
            return NIOUtils.duplicate((ByteBuffer) this.tr.getResult().get(this.off));
        }

        public int getDataLen() throws IOException {
            return AVCClipTrack.this.frameSize;
        }
    }

    public AVCClipTrack(VirtualTrack virtualTrack, int i, int i2) {
        super(virtualTrack, i, i2);
        VideoCodecMeta videoCodecMeta = (VideoCodecMeta) virtualTrack.getCodecMeta();
        if (VisualSampleEntry.TYPE3.equals(videoCodecMeta.getFourcc()) == 0) {
            throw new RuntimeException("Not an AVC source track");
        }
        this.rc = new H264FixedRateControl(1024);
        i = new H264Encoder(this.rc);
        this.avcC = H264Utils.parseAVCC(videoCodecMeta.getCodecPrivate());
        i2 = H264Utils.readSPS(NIOUtils.duplicate((ByteBuffer) this.avcC.getSpsList().get(0)));
        this.mbW = i2.pic_width_in_mbs_minus1 + 1;
        this.mbH = H264Utils.getPicHeightInMbs(i2);
        this.encSPS = i.initSPS(H264Utils.getPicSize(i2));
        this.encSPS.seq_parameter_set_id = 1;
        this.encPPS = i.initPPS();
        this.encPPS.seq_parameter_set_id = 1;
        this.encPPS.pic_parameter_set_id = 1;
        this.encSPS.profile_idc = i2.profile_idc;
        this.encSPS.level_idc = i2.level_idc;
        this.encSPS.frame_mbs_only_flag = i2.frame_mbs_only_flag;
        this.encSPS.frame_crop_bottom_offset = i2.frame_crop_bottom_offset;
        this.encSPS.frame_crop_left_offset = i2.frame_crop_left_offset;
        this.encSPS.frame_crop_right_offset = i2.frame_crop_right_offset;
        this.encSPS.frame_crop_top_offset = i2.frame_crop_top_offset;
        this.encSPS.vuiParams = i2.vuiParams;
        this.avcC.getSpsList().add(H264Utils.writeSPS(this.encSPS, 128));
        this.avcC.getPpsList().add(H264Utils.writePPS(this.encPPS, 20));
        this.se = new VideoCodecMeta(VisualSampleEntry.TYPE3, H264Utils.getAvcCData(this.avcC), videoCodecMeta.getSize(), videoCodecMeta.getPasp());
        this.frameSize = this.rc.calcFrameSize(this.mbW * this.mbH);
        this.frameSize += this.frameSize >> 4;
    }

    protected List<VirtualPacket> getGop(VirtualTrack virtualTrack, int i) throws IOException {
        VirtualPacket nextPacket = virtualTrack.nextPacket();
        List arrayList = new ArrayList();
        while (nextPacket != null && nextPacket.getFrameNo() < i) {
            if (nextPacket.isKeyframe()) {
                arrayList.clear();
            }
            arrayList.add(nextPacket);
            nextPacket = virtualTrack.nextPacket();
        }
        i = new ArrayList();
        while (nextPacket != null && !nextPacket.isKeyframe()) {
            i.add(nextPacket);
            nextPacket = virtualTrack.nextPacket();
        }
        virtualTrack = new ArrayList();
        GopTranscoder gopTranscoder = new GopTranscoder(arrayList, i);
        for (int i2 = 0; i2 < i.size(); i2++) {
            virtualTrack.add(new TranscodePacket((VirtualPacket) i.get(i2), gopTranscoder, i2));
        }
        virtualTrack.add(nextPacket);
        return virtualTrack;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }
}
