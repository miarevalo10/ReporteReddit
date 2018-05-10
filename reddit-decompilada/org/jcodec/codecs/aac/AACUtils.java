package org.jcodec.codecs.aac;

import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg4.mp4.EsdsBox;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ChannelLabel;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;

public class AACUtils {
    private static ChannelLabel[][] AAC_DEFAULT_CONFIGS;

    public static class AudioInfo {
        private AudioFormat format;
        private ChannelLabel[] labels;

        public AudioInfo(AudioFormat audioFormat, ChannelLabel[] channelLabelArr) {
            this.format = audioFormat;
            this.labels = channelLabelArr;
        }

        public AudioFormat getFormat() {
            return this.format;
        }

        public ChannelLabel[] getLabels() {
            return this.labels;
        }
    }

    private static int getObjectType(BitReader bitReader) {
        int readNBit = bitReader.readNBit(5);
        return readNBit == ObjectType.AOT_ESCAPE.ordinal() ? 32 + bitReader.readNBit(6) : readNBit;
    }

    static {
        r1 = new ChannelLabel[8][];
        r1[1] = new ChannelLabel[]{ChannelLabel.MONO};
        r1[2] = new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
        r1[3] = new ChannelLabel[]{ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT};
        r1[4] = new ChannelLabel[]{ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_CENTER};
        r1[5] = new ChannelLabel[]{ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
        r1[6] = new ChannelLabel[]{ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.LFE};
        r1[7] = new ChannelLabel[]{ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.SIDE_LEFT, ChannelLabel.SIDE_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.LFE};
        AAC_DEFAULT_CONFIGS = r1;
    }

    public static AudioInfo parseAudioInfo(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        getObjectType(bitReader);
        int readNBit = bitReader.readNBit(4);
        int readNBit2 = readNBit == 15 ? bitReader.readNBit(24) : AACConts.AAC_SAMPLE_RATES[readNBit];
        byteBuffer = bitReader.readNBit(4);
        if (byteBuffer != null) {
            if (byteBuffer < AAC_DEFAULT_CONFIGS.length) {
                byteBuffer = AAC_DEFAULT_CONFIGS[byteBuffer];
                return new AudioInfo(new AudioFormat(readNBit2, 16, byteBuffer.length, true, false), byteBuffer);
            }
        }
        return null;
    }

    public static AudioInfo getChannels(SampleEntry sampleEntry) {
        if (AudioSampleEntry.TYPE3.equals(sampleEntry.getFourcc())) {
            LeafBox leafBox = (LeafBox) Box.findFirst(sampleEntry, LeafBox.class, ESDescriptorBox.TYPE);
            if (leafBox == null) {
                leafBox = (LeafBox) Box.findFirst(sampleEntry, LeafBox.class, null, ESDescriptorBox.TYPE);
            }
            if (leafBox == null) {
                return null;
            }
            sampleEntry = new EsdsBox();
            sampleEntry.parse(leafBox.getData());
            return parseAudioInfo(sampleEntry.getStreamInfo());
        }
        throw new IllegalArgumentException("Not mp4a sample entry");
    }
}
