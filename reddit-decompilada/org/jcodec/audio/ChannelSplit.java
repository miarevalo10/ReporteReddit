package org.jcodec.audio;

import java.nio.FloatBuffer;
import org.jcodec.common.AudioFormat;

public class ChannelSplit implements AudioFilter {
    private AudioFormat format;

    public int getDelay() {
        return 0;
    }

    public int getNInputs() {
        return 1;
    }

    public ChannelSplit(AudioFormat audioFormat) {
        this.format = audioFormat;
    }

    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != 1) {
            throw new IllegalArgumentException("Channel split invoked on more then one input");
        } else if (floatBufferArr2.length != this.format.getChannels()) {
            jArr = new StringBuilder("Channel split must be supplied with ");
            jArr.append(this.format.getChannels());
            jArr.append(" output buffers to hold the channels.");
            throw new IllegalArgumentException(jArr.toString());
        } else {
            floatBufferArr = floatBufferArr[0];
            int remaining = floatBufferArr.remaining() / floatBufferArr2.length;
            for (int i = 0; i < floatBufferArr2.length; i++) {
                if (floatBufferArr2[i].remaining() < remaining) {
                    jArr = new StringBuilder("Supplied buffer for ");
                    jArr.append(i);
                    jArr.append("th channel doesn't have sufficient space to put the samples ( required: ");
                    jArr.append(remaining);
                    jArr.append(", actual: ");
                    jArr.append(floatBufferArr2[i].remaining());
                    jArr.append(")");
                    throw new IllegalArgumentException(jArr.toString());
                }
            }
            while (floatBufferArr.remaining() >= this.format.getChannels()) {
                for (FloatBuffer put : floatBufferArr2) {
                    put.put(floatBufferArr.get());
                }
            }
        }
    }

    public int getNOutputs() {
        return this.format.getChannels();
    }
}
