package org.jcodec.containers.mkv;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.Assert;
import org.jcodec.containers.mkv.CuesFactory.CuePointMock;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.MkvBlock;
import org.jcodec.containers.mkv.boxes.MkvSegment;
import org.jcodec.containers.mkv.muxer.MKVMuxer;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.MovieSegment;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;

public class MKVStreamingMuxer {
    private static final int DEFAULT_TIMESCALE = 1000000000;
    private static final int MULTIPLIER = 1000;
    private static final int TIMESCALE = 1000000;
    private static final String VP80_FOURCC = "avc1";
    public MovieSegment headerChunk;
    private EbmlMaster mkvCues;
    private EbmlMaster mkvInfo;
    private EbmlMaster mkvSeekHead;
    private EbmlMaster mkvTracks;
    private EbmlMaster segmentElem;
    private LinkedList<WebmCluster> webmClusters;

    public static class HeaderSegment implements MovieSegment {
        private List<EbmlMaster> header;

        public int getNo() {
            return 0;
        }

        public long getPos() {
            return 0;
        }

        public HeaderSegment(List<EbmlMaster> list) {
            this.header = list;
        }

        public int getDataLen() throws IOException {
            int i = 0;
            for (EbmlMaster ebmlMaster : this.header) {
                if (MKVType.Segment.equals(ebmlMaster.type)) {
                    i = (int) (((long) i) + ((MkvSegment) ebmlMaster).getHeaderSize());
                } else {
                    i = (int) (((long) i) + ebmlMaster.size());
                }
            }
            return i;
        }

        public ByteBuffer getData() throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(getDataLen());
            for (EbmlMaster ebmlMaster : this.header) {
                if (MKVType.Segment.equals(ebmlMaster.type)) {
                    allocate.put(((MkvSegment) ebmlMaster).getHeader());
                } else {
                    allocate.put(ebmlMaster.getData());
                }
            }
            allocate.flip();
            return allocate;
        }
    }

    public class WebmCluster implements MovieSegment {
        MkvBlock be = ((MkvBlock) MKVType.createByType(MKVType.SimpleBlock));
        EbmlMaster f33281c = ((EbmlMaster) MKVType.createByType(MKVType.Cluster));
        private int chunkNo;
        public VirtualPacket pkt;
        private long previousClustersSize;
        private int trackNo;

        public WebmCluster(VirtualTrack virtualTrack, VirtualPacket virtualPacket, int i, int i2, long j) {
            MKVStreamingMuxer mKVStreamingMuxer;
            this.pkt = virtualPacket;
            this.chunkNo = i;
            this.trackNo = i2 + 1;
            this.previousClustersSize = j;
            MKVMuxer.createChild(this.f33281c, MKVType.Timecode, (long) (virtualPacket.getPts() * 0));
            try {
                mKVStreamingMuxer = new int[]{this.pkt.getDataLen()};
                this.be.frameSizes = mKVStreamingMuxer;
                this.be.timecode = 0;
                this.be.trackNumber = (long) this.trackNo;
                this.be.discardable = false;
                this.be.lacingPresent = false;
                this.be.dataLen = this.be.getDataSize();
                this.f33281c.add(this.be);
            } catch (MKVStreamingMuxer mKVStreamingMuxer2) {
                throw new RuntimeException("Failed to read size of the frame", mKVStreamingMuxer2);
            }
        }

        public ByteBuffer getData() throws IOException {
            this.be.frames = new ByteBuffer[1];
            this.be.frames[0] = this.pkt.getData().duplicate();
            ByteBuffer data = this.f33281c.getData();
            Assert.assertEquals("computed and actuall cluster sizes MUST match", (int) this.f33281c.size(), data.remaining());
            return data;
        }

        public int getNo() {
            return this.chunkNo;
        }

        public long getPos() {
            try {
                return this.previousClustersSize + ((long) MKVStreamingMuxer.this.headerChunk.getDataLen());
            } catch (Throwable e) {
                throw new RuntimeException("Couldn't compute header length", e);
            }
        }

        public int getDataLen() throws IOException {
            return (int) this.f33281c.size();
        }
    }

    public MovieSegment preparePacket(VirtualTrack virtualTrack, VirtualPacket virtualPacket, int i, int i2, long j) {
        MovieSegment webmCluster = new WebmCluster(virtualTrack, virtualPacket, i, i2, j);
        if (this.webmClusters == null) {
            this.webmClusters = new LinkedList();
        }
        this.webmClusters.add(webmCluster);
        return webmCluster;
    }

    public MovieSegment prepareHeader(List<MovieSegment> list, VirtualTrack[] virtualTrackArr) throws IOException {
        list = muxEbmlHeader();
        this.segmentElem = (EbmlMaster) MKVType.createByType(MKVType.Segment);
        this.mkvInfo = muxInfo(virtualTrackArr);
        this.mkvTracks = muxTracks(virtualTrackArr);
        this.mkvCues = (EbmlMaster) MKVType.createByType(MKVType.Cues);
        this.mkvSeekHead = muxSeekHead();
        muxCues(virtualTrackArr);
        this.segmentElem.add(this.mkvSeekHead);
        this.segmentElem.add(this.mkvInfo);
        this.segmentElem.add(this.mkvTracks);
        this.segmentElem.add(this.mkvCues);
        virtualTrackArr = this.webmClusters.iterator();
        while (virtualTrackArr.hasNext()) {
            this.segmentElem.add(((WebmCluster) virtualTrackArr.next()).f33281c);
        }
        virtualTrackArr = new ArrayList();
        virtualTrackArr.add(list);
        virtualTrackArr.add(this.segmentElem);
        this.headerChunk = new HeaderSegment(virtualTrackArr);
        return this.headerChunk;
    }

    private EbmlMaster muxEbmlHeader() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.EBML);
        MKVMuxer.createChild(ebmlMaster, MKVType.EBMLVersion, 1);
        MKVMuxer.createChild(ebmlMaster, MKVType.EBMLReadVersion, 1);
        MKVMuxer.createChild(ebmlMaster, MKVType.EBMLMaxIDLength, 4);
        MKVMuxer.createChild(ebmlMaster, MKVType.EBMLMaxSizeLength, 8);
        MKVMuxer.createChild(ebmlMaster, MKVType.DocType, "webm");
        MKVMuxer.createChild(ebmlMaster, MKVType.DocTypeVersion, 2);
        MKVMuxer.createChild(ebmlMaster, MKVType.DocTypeReadVersion, 2);
        return ebmlMaster;
    }

    private EbmlMaster muxInfo(VirtualTrack[] virtualTrackArr) {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Info);
        MKVMuxer.createChild(ebmlMaster, MKVType.TimecodeScale, 1000000);
        MKVMuxer.createChild(ebmlMaster, MKVType.WritingApp, "JCodec v0.1.7");
        MKVMuxer.createChild(ebmlMaster, MKVType.MuxingApp, "JCodec MKVStreamingMuxer v0.1.7");
        WebmCluster webmCluster = (WebmCluster) this.webmClusters.get(this.webmClusters.size() - 1);
        MKVMuxer.createChild(ebmlMaster, MKVType.Duration, (webmCluster.pkt.getPts() + webmCluster.pkt.getDuration()) * 1000.0d);
        MKVMuxer.createChild(ebmlMaster, MKVType.DateUTC, new Date());
        return ebmlMaster;
    }

    private EbmlMaster muxTracks(VirtualTrack[] virtualTrackArr) {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Tracks);
        int i = 0;
        while (i < virtualTrackArr.length) {
            VirtualTrack virtualTrack = virtualTrackArr[i];
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.TrackEntry);
            i++;
            long j = (long) i;
            MKVMuxer.createChild(ebmlMaster2, MKVType.TrackNumber, j);
            MKVMuxer.createChild(ebmlMaster2, MKVType.TrackUID, j);
            CodecMeta codecMeta = virtualTrack.getCodecMeta();
            MKVType mKVType;
            StringBuilder stringBuilder;
            EbmlMaster ebmlMaster3;
            if ("avc1".equalsIgnoreCase(virtualTrack.getCodecMeta().getFourcc())) {
                MKVMuxer.createChild(ebmlMaster2, MKVType.TrackType, 1);
                mKVType = MKVType.Name;
                stringBuilder = new StringBuilder("Track ");
                stringBuilder.append(i);
                stringBuilder.append(" Video");
                MKVMuxer.createChild(ebmlMaster2, mKVType, stringBuilder.toString());
                MKVMuxer.createChild(ebmlMaster2, MKVType.CodecID, "V_VP8");
                MKVMuxer.createChild(ebmlMaster2, MKVType.CodecPrivate, codecMeta.getCodecPrivate());
                if (codecMeta instanceof VideoCodecMeta) {
                    VideoCodecMeta videoCodecMeta = (VideoCodecMeta) codecMeta;
                    ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.Video);
                    MKVMuxer.createChild(ebmlMaster3, MKVType.PixelWidth, (long) videoCodecMeta.getSize().getWidth());
                    MKVMuxer.createChild(ebmlMaster3, MKVType.PixelHeight, (long) videoCodecMeta.getSize().getHeight());
                    ebmlMaster2.add(ebmlMaster3);
                }
            } else if ("vrbs".equalsIgnoreCase(virtualTrack.getCodecMeta().getFourcc())) {
                MKVMuxer.createChild(ebmlMaster2, MKVType.TrackType, 2);
                mKVType = MKVType.Name;
                stringBuilder = new StringBuilder("Track ");
                stringBuilder.append(i);
                stringBuilder.append(" Audio");
                MKVMuxer.createChild(ebmlMaster2, mKVType, stringBuilder.toString());
                MKVMuxer.createChild(ebmlMaster2, MKVType.CodecID, "A_VORBIS");
                MKVMuxer.createChild(ebmlMaster2, MKVType.CodecPrivate, codecMeta.getCodecPrivate());
                if (codecMeta instanceof AudioCodecMeta) {
                    AudioCodecMeta audioCodecMeta = (AudioCodecMeta) codecMeta;
                    ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.Audio);
                    MKVMuxer.createChild(ebmlMaster3, MKVType.Channels, (long) audioCodecMeta.getChannelCount());
                    MKVMuxer.createChild(ebmlMaster3, MKVType.BitDepth, (long) audioCodecMeta.getSampleSize());
                    MKVMuxer.createChild(ebmlMaster3, MKVType.SamplingFrequency, (long) audioCodecMeta.getSampleRate());
                    ebmlMaster2.add(ebmlMaster3);
                }
            }
            ebmlMaster.add(ebmlMaster2);
        }
        return ebmlMaster;
    }

    private EbmlMaster muxSeekHead() {
        SeekHeadFactory seekHeadFactory = new SeekHeadFactory();
        seekHeadFactory.add(this.mkvInfo);
        seekHeadFactory.add(this.mkvTracks);
        seekHeadFactory.add(this.mkvCues);
        return seekHeadFactory.indexSeekHead();
    }

    private void muxCues(VirtualTrack[] virtualTrackArr) {
        CuesFactory cuesFactory = new CuesFactory((this.mkvSeekHead.size() + this.mkvInfo.size()) + this.mkvTracks.size(), (long) (findFirstVP8TrackIndex(virtualTrackArr) + 1));
        virtualTrackArr = this.webmClusters.iterator();
        while (virtualTrackArr.hasNext()) {
            cuesFactory.add(CuePointMock.make(((WebmCluster) virtualTrackArr.next()).f33281c));
        }
        virtualTrackArr = cuesFactory.createCues().children.iterator();
        while (virtualTrackArr.hasNext()) {
            this.mkvCues.add((EbmlBase) virtualTrackArr.next());
        }
    }

    private static int findFirstVP8TrackIndex(VirtualTrack[] virtualTrackArr) {
        for (int i = 0; i < virtualTrackArr.length; i++) {
            if ("avc1".equalsIgnoreCase(virtualTrackArr[i].getCodecMeta().getFourcc())) {
                return i;
            }
        }
        return -1;
    }
}
