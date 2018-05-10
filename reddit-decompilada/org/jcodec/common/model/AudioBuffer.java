package org.jcodec.common.model;

import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;

public class AudioBuffer {
    private ByteBuffer data;
    private AudioFormat format;
    private int nFrames;

    public AudioBuffer(ByteBuffer byteBuffer, AudioFormat audioFormat, int i) {
        this.data = byteBuffer;
        this.format = audioFormat;
        this.nFrames = i;
    }

    public AudioBuffer(AudioBuffer audioBuffer) {
        this.data = audioBuffer.data;
        this.format = audioBuffer.format;
        this.nFrames = audioBuffer.nFrames;
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public AudioFormat getFormat() {
        return this.format;
    }

    public int getNFrames() {
        return this.nFrames;
    }
}
