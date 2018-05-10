package org.jcodec.containers.mkv.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mkv.CuesFactory;
import org.jcodec.containers.mkv.CuesFactory.CuePointMock;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.SeekHeadFactory;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlDate;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlString;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.MkvBlock;
import org.jcodec.containers.mkv.muxer.MKVMuxerTrack.MKVMuxerTrackType;

public class MKVMuxer {
    private List<EbmlMaster> clusterList = new LinkedList();
    private EbmlMaster mkvCues;
    private EbmlMaster mkvInfo;
    private EbmlMaster mkvSeekHead;
    private EbmlMaster mkvTracks;
    private List<MKVMuxerTrack> tracks = new ArrayList();
    private MKVMuxerTrack videoTrack = null;

    public MKVMuxerTrack createVideoTrack(Size size, String str) {
        if (this.videoTrack == null) {
            this.videoTrack = new MKVMuxerTrack();
            this.tracks.add(this.videoTrack);
            this.videoTrack.codecId = str;
            this.videoTrack.frameDimentions = size;
            this.videoTrack.trackNo = this.tracks.size();
        }
        return this.videoTrack;
    }

    public void mux(SeekableByteChannel seekableByteChannel) throws IOException {
        List<EbmlMaster> arrayList = new ArrayList();
        arrayList.add(defaultEbmlHeader());
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Segment);
        this.mkvInfo = muxInfo();
        this.mkvTracks = muxTracks();
        this.mkvCues = (EbmlMaster) MKVType.createByType(MKVType.Cues);
        this.mkvSeekHead = muxSeekHead();
        muxCues();
        ebmlMaster.add(this.mkvSeekHead);
        ebmlMaster.add(this.mkvInfo);
        ebmlMaster.add(this.mkvTracks);
        ebmlMaster.add(this.mkvCues);
        for (EbmlMaster add : this.clusterList) {
            ebmlMaster.add(add);
        }
        arrayList.add(ebmlMaster);
        for (EbmlMaster ebmlMaster2 : arrayList) {
            ebmlMaster2.mux(seekableByteChannel);
        }
    }

    private EbmlMaster defaultEbmlHeader() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.EBML);
        createChild(ebmlMaster, MKVType.EBMLVersion, 1);
        createChild(ebmlMaster, MKVType.EBMLReadVersion, 1);
        createChild(ebmlMaster, MKVType.EBMLMaxIDLength, 4);
        createChild(ebmlMaster, MKVType.EBMLMaxSizeLength, 8);
        createChild(ebmlMaster, MKVType.DocType, "webm");
        createChild(ebmlMaster, MKVType.DocTypeVersion, 2);
        createChild(ebmlMaster, MKVType.DocTypeReadVersion, 2);
        return ebmlMaster;
    }

    private EbmlMaster muxInfo() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Info);
        createChild(ebmlMaster, MKVType.TimecodeScale, 40000000);
        createChild(ebmlMaster, MKVType.WritingApp, "JCodec v0.1.7");
        createChild(ebmlMaster, MKVType.MuxingApp, "JCodec MKVStreamingMuxer v0.1.7");
        createChild(ebmlMaster, MKVType.Duration, ((double) ((((MkvBlock) this.videoTrack.trackBlocks.get(this.videoTrack.trackBlocks.size() - 1)).absoluteTimecode + 1) * 40000000)) * 1.0d);
        createChild(ebmlMaster, MKVType.DateUTC, new Date());
        return ebmlMaster;
    }

    private EbmlMaster muxTracks() {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Tracks);
        for (int i = 0; i < this.tracks.size(); i++) {
            MKVMuxerTrack mKVMuxerTrack = (MKVMuxerTrack) this.tracks.get(i);
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.TrackEntry);
            createChild(ebmlMaster2, MKVType.TrackNumber, (long) mKVMuxerTrack.trackNo);
            createChild(ebmlMaster2, MKVType.TrackUID, (long) mKVMuxerTrack.trackNo);
            MKVType mKVType;
            StringBuilder stringBuilder;
            if (MKVMuxerTrackType.VIDEO.equals(mKVMuxerTrack.type)) {
                createChild(ebmlMaster2, MKVType.TrackType, 1);
                mKVType = MKVType.Name;
                stringBuilder = new StringBuilder("Track ");
                stringBuilder.append(i + 1);
                stringBuilder.append(" Video");
                createChild(ebmlMaster2, mKVType, stringBuilder.toString());
                createChild(ebmlMaster2, MKVType.CodecID, mKVMuxerTrack.codecId);
                EbmlMaster ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.Video);
                createChild(ebmlMaster3, MKVType.PixelWidth, (long) mKVMuxerTrack.frameDimentions.getWidth());
                createChild(ebmlMaster3, MKVType.PixelHeight, (long) mKVMuxerTrack.frameDimentions.getHeight());
                ebmlMaster2.add(ebmlMaster3);
            } else {
                createChild(ebmlMaster2, MKVType.TrackType, 2);
                mKVType = MKVType.Name;
                stringBuilder = new StringBuilder("Track ");
                stringBuilder.append(i + 1);
                stringBuilder.append(" Audio");
                createChild(ebmlMaster2, mKVType, stringBuilder.toString());
                createChild(ebmlMaster2, MKVType.CodecID, mKVMuxerTrack.codecId);
            }
            ebmlMaster.add(ebmlMaster2);
        }
        return ebmlMaster;
    }

    private void muxCues() {
        CuesFactory cuesFactory = new CuesFactory((this.mkvSeekHead.size() + this.mkvInfo.size()) + this.mkvTracks.size(), (long) (this.videoTrack.trackNo - 1));
        for (MkvBlock singleBlockedCluster : this.videoTrack.trackBlocks) {
            EbmlMaster singleBlockedCluster2 = singleBlockedCluster(singleBlockedCluster);
            this.clusterList.add(singleBlockedCluster2);
            cuesFactory.add(CuePointMock.make(singleBlockedCluster2));
        }
        Iterator it = cuesFactory.createCues().children.iterator();
        while (it.hasNext()) {
            this.mkvCues.add((EbmlBase) it.next());
        }
    }

    private EbmlMaster singleBlockedCluster(MkvBlock mkvBlock) {
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Cluster);
        createChild(ebmlMaster, MKVType.Timecode, mkvBlock.absoluteTimecode - ((long) mkvBlock.timecode));
        ebmlMaster.add(mkvBlock);
        return ebmlMaster;
    }

    private EbmlMaster muxSeekHead() {
        SeekHeadFactory seekHeadFactory = new SeekHeadFactory();
        seekHeadFactory.add(this.mkvInfo);
        seekHeadFactory.add(this.mkvTracks);
        seekHeadFactory.add(this.mkvCues);
        return seekHeadFactory.indexSeekHead();
    }

    public static void createChild(EbmlMaster ebmlMaster, MKVType mKVType, long j) {
        EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(mKVType);
        ebmlUint.set(j);
        ebmlMaster.add(ebmlUint);
    }

    public static void createChild(EbmlMaster ebmlMaster, MKVType mKVType, String str) {
        EbmlString ebmlString = (EbmlString) MKVType.createByType(mKVType);
        ebmlString.set(str);
        ebmlMaster.add(ebmlString);
    }

    public static void createChild(EbmlMaster ebmlMaster, MKVType mKVType, Date date) {
        EbmlDate ebmlDate = (EbmlDate) MKVType.createByType(mKVType);
        ebmlDate.setDate(date);
        ebmlMaster.add(ebmlDate);
    }

    public static void createChild(EbmlMaster ebmlMaster, MKVType mKVType, ByteBuffer byteBuffer) {
        EbmlBin ebmlBin = (EbmlBin) MKVType.createByType(mKVType);
        ebmlBin.set(byteBuffer);
        ebmlMaster.add(ebmlBin);
    }

    public static void createChild(EbmlMaster ebmlMaster, MKVType mKVType, double d) {
        try {
            EbmlFloat ebmlFloat = (EbmlFloat) MKVType.createByType(mKVType);
            ebmlFloat.set(d);
            ebmlMaster.add(ebmlFloat);
        } catch (EbmlMaster ebmlMaster2) {
            StringBuilder stringBuilder = new StringBuilder("Element of type ");
            stringBuilder.append(mKVType);
            stringBuilder.append(" can't be cast to EbmlFloat");
            throw new RuntimeException(stringBuilder.toString(), ebmlMaster2);
        }
    }
}
