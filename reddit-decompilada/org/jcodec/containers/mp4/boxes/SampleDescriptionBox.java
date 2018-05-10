package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.facebook.stetho.dumpapp.Framer;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import java.nio.ByteBuffer;

public class SampleDescriptionBox extends NodeBox {
    public static final MyFactory FACTORY = new MyFactory();

    public static class MyFactory extends BoxFactory {
        public MyFactory() {
            clear();
            override("ap4h", VideoSampleEntry.class);
            override("apch", VideoSampleEntry.class);
            override("apcn", VideoSampleEntry.class);
            override("apcs", VideoSampleEntry.class);
            override("apco", VideoSampleEntry.class);
            override(VisualSampleEntry.TYPE3, VideoSampleEntry.class);
            override("cvid", VideoSampleEntry.class);
            override("jpeg", VideoSampleEntry.class);
            override("smc ", VideoSampleEntry.class);
            override("rle ", VideoSampleEntry.class);
            override("rpza", VideoSampleEntry.class);
            override("kpcd", VideoSampleEntry.class);
            override("png ", VideoSampleEntry.class);
            override("mjpa", VideoSampleEntry.class);
            override("mjpb", VideoSampleEntry.class);
            override("SVQ1", VideoSampleEntry.class);
            override("SVQ3", VideoSampleEntry.class);
            override(VisualSampleEntry.TYPE1, VideoSampleEntry.class);
            override("dvc ", VideoSampleEntry.class);
            override("dvcp", VideoSampleEntry.class);
            override("gif ", VideoSampleEntry.class);
            override("h263", VideoSampleEntry.class);
            override("tiff", VideoSampleEntry.class);
            override("raw ", VideoSampleEntry.class);
            override("2vuY", VideoSampleEntry.class);
            override("yuv2", VideoSampleEntry.class);
            override("v308", VideoSampleEntry.class);
            override("v408", VideoSampleEntry.class);
            override("v216", VideoSampleEntry.class);
            override("v410", VideoSampleEntry.class);
            override("v210", VideoSampleEntry.class);
            override("m2v1", VideoSampleEntry.class);
            override("m1v1", VideoSampleEntry.class);
            override("xd5b", VideoSampleEntry.class);
            override("dv5n", VideoSampleEntry.class);
            override("jp2h", VideoSampleEntry.class);
            override("mjp2", VideoSampleEntry.class);
            override(AudioSampleEntry.TYPE8, AudioSampleEntry.class);
            override("cac3", AudioSampleEntry.class);
            override("ima4", AudioSampleEntry.class);
            override("aac ", AudioSampleEntry.class);
            override("celp", AudioSampleEntry.class);
            override("hvxc", AudioSampleEntry.class);
            override("twvq", AudioSampleEntry.class);
            override(".mp1", AudioSampleEntry.class);
            override(".mp2", AudioSampleEntry.class);
            override("midi", AudioSampleEntry.class);
            override("apvs", AudioSampleEntry.class);
            override("alac", AudioSampleEntry.class);
            override("aach", AudioSampleEntry.class);
            override("aacl", AudioSampleEntry.class);
            override("aace", AudioSampleEntry.class);
            override("aacf", AudioSampleEntry.class);
            override("aacp", AudioSampleEntry.class);
            override("aacs", AudioSampleEntry.class);
            override(AudioSampleEntry.TYPE1, AudioSampleEntry.class);
            override("AUDB", AudioSampleEntry.class);
            override("ilbc", AudioSampleEntry.class);
            override(new String(new byte[]{(byte) 109, (byte) 115, (byte) 0, (byte) 17}), AudioSampleEntry.class);
            override(new String(new byte[]{(byte) 109, (byte) 115, (byte) 0, Framer.STDOUT_FRAME_PREFIX}), AudioSampleEntry.class);
            override("aes3", AudioSampleEntry.class);
            override("NONE", AudioSampleEntry.class);
            override("raw ", AudioSampleEntry.class);
            override("twos", AudioSampleEntry.class);
            override("sowt", AudioSampleEntry.class);
            override("MAC3 ", AudioSampleEntry.class);
            override("MAC6 ", AudioSampleEntry.class);
            override("ima4", AudioSampleEntry.class);
            override("fl32", AudioSampleEntry.class);
            override("fl64", AudioSampleEntry.class);
            override("in24", AudioSampleEntry.class);
            override("in32", AudioSampleEntry.class);
            override("ulaw", AudioSampleEntry.class);
            override("alaw", AudioSampleEntry.class);
            override("dvca", AudioSampleEntry.class);
            override("QDMC", AudioSampleEntry.class);
            override("QDM2", AudioSampleEntry.class);
            override("Qclp", AudioSampleEntry.class);
            override(".mp3", AudioSampleEntry.class);
            override(AudioSampleEntry.TYPE3, AudioSampleEntry.class);
            override("lpcm", AudioSampleEntry.class);
            override(TimeCodeBox.TYPE, TimecodeSampleEntry.class);
            override("time", TimecodeSampleEntry.class);
            override("c608", SampleEntry.class);
            override("c708", SampleEntry.class);
            override("text", SampleEntry.class);
        }
    }

    public static String fourcc() {
        return com.coremedia.iso.boxes.SampleDescriptionBox.TYPE;
    }

    public SampleDescriptionBox(Header header) {
        super(header);
        this.factory = FACTORY;
    }

    public SampleDescriptionBox() {
        this(new Header(fourcc()));
    }

    public SampleDescriptionBox(SampleEntry... sampleEntryArr) {
        this();
        for (Object add : sampleEntryArr) {
            this.boxes.add(add);
        }
    }

    public void parse(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        byteBuffer.getInt();
        super.parse(byteBuffer);
    }

    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.boxes.size());
        super.doWrite(byteBuffer);
    }
}
