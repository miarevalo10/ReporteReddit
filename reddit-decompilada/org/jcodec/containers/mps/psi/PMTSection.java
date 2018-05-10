package org.jcodec.containers.mps.psi;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.MPSUtils.MPEGMediaDescriptor;
import org.jcodec.containers.mps.MTSUtils.StreamType;

public class PMTSection extends PSISection {
    private int pcrPid;
    private PMTStream[] streams;
    private Tag[] tags;

    public static class PMTStream {
        private List<MPEGMediaDescriptor> descriptors;
        private int pid;
        private StreamType streamType;
        private int streamTypeTag;

        public PMTStream(int i, int i2, List<MPEGMediaDescriptor> list) {
            this.streamTypeTag = i;
            this.pid = i2;
            this.descriptors = list;
            this.streamType = StreamType.fromTag(i);
        }

        public int getStreamTypeTag() {
            return this.streamTypeTag;
        }

        public StreamType getStreamType() {
            return this.streamType;
        }

        public int getPid() {
            return this.pid;
        }

        public List<MPEGMediaDescriptor> getDesctiptors() {
            return this.descriptors;
        }
    }

    public static class Tag {
        private ByteBuffer content;
        private int tag;

        public Tag(int i, ByteBuffer byteBuffer) {
            this.tag = i;
            this.content = byteBuffer;
        }

        public int getTag() {
            return this.tag;
        }

        public ByteBuffer getContent() {
            return this.content;
        }
    }

    public PMTSection(PSISection pSISection, int i, Tag[] tagArr, PMTStream[] pMTStreamArr) {
        super(pSISection);
        this.pcrPid = i;
        this.tags = tagArr;
        this.streams = pMTStreamArr;
    }

    public int getPcrPid() {
        return this.pcrPid;
    }

    public Tag[] getTags() {
        return this.tags;
    }

    public PMTStream[] getStreams() {
        return this.streams;
    }

    public static PMTSection parse(ByteBuffer byteBuffer) {
        PSISection parse = PSISection.parse(byteBuffer);
        int i = (byteBuffer.getShort() & 65535) & 8191;
        List parseTags = parseTags(NIOUtils.read(byteBuffer, (byteBuffer.getShort() & 65535) & 4095));
        List arrayList = new ArrayList();
        while (byteBuffer.remaining() > 4) {
            Logger.info(String.format("Elementary stream: [%d,%d]", new Object[]{Integer.valueOf(byteBuffer.get() & 255), Integer.valueOf((byteBuffer.getShort() & 65535) & 8191)}));
            arrayList.add(new PMTStream(r5, r6, MPSUtils.parseDescriptors(NIOUtils.read(byteBuffer, (byteBuffer.getShort() & 65535) & 4095))));
        }
        return new PMTSection(parse, i, (Tag[]) parseTags.toArray(new Tag[0]), (PMTStream[]) arrayList.toArray(new PMTStream[0]));
    }

    static List<Tag> parseTags(ByteBuffer byteBuffer) {
        List<Tag> arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            Logger.info(String.format("TAG: [0x%x, 0x%x]", new Object[]{Integer.valueOf(byteBuffer.get()), Integer.valueOf(byteBuffer.get())}));
            arrayList.add(new Tag(r1, NIOUtils.read(byteBuffer, r2)));
        }
        return arrayList;
    }
}
