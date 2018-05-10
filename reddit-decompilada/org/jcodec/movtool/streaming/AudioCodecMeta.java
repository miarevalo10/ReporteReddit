package org.jcodec.movtool.streaming;

import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;
import org.jcodec.containers.mp4.boxes.EndianBox.Endian;
import org.jcodec.containers.mp4.boxes.channel.Label;

public class AudioCodecMeta extends CodecMeta {
    private int channelCount;
    private Endian endian;
    private Label[] labels;
    private boolean pcm;
    private int sampleRate;
    private int sampleSize;

    public AudioCodecMeta(String str, int i, int i2, int i3, Endian endian, boolean z, Label[] labelArr, ByteBuffer byteBuffer) {
        super(str, byteBuffer);
        this.sampleSize = i;
        this.channelCount = i2;
        this.sampleRate = i3;
        this.endian = endian;
        this.pcm = z;
        this.labels = labelArr;
    }

    public AudioCodecMeta(String str, ByteBuffer byteBuffer, AudioFormat audioFormat, boolean z, Label[] labelArr) {
        super(str, byteBuffer);
        this.sampleSize = audioFormat.getSampleSizeInBits() >> 3;
        this.channelCount = audioFormat.getChannels();
        this.sampleRate = audioFormat.getSampleRate();
        this.endian = audioFormat.isBigEndian() != null ? Endian.BIG_ENDIAN : Endian.LITTLE_ENDIAN;
        this.pcm = z;
        this.labels = labelArr;
    }

    public int getFrameSize() {
        return this.sampleSize * this.channelCount;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public Endian getEndian() {
        return this.endian;
    }

    public boolean isPCM() {
        return this.pcm;
    }

    public AudioFormat getFormat() {
        return new AudioFormat(this.sampleRate, this.sampleSize << 3, this.channelCount, true, this.endian == Endian.BIG_ENDIAN);
    }

    public Label[] getChannelLabels() {
        return this.labels;
    }
}
