package org.jcodec.audio;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.nio.FloatBuffer;
import org.jcodec.common.Assert;
import org.jcodec.common.AudioFormat;

public class ChannelMerge implements AudioFilter {
    private AudioFormat format;

    public int getDelay() {
        return 0;
    }

    public int getNOutputs() {
        return 1;
    }

    public ChannelMerge(AudioFormat audioFormat) {
        this.format = audioFormat;
    }

    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != this.format.getChannels()) {
            jArr = new StringBuilder("Channel merge must be supplied with ");
            jArr.append(this.format.getChannels());
            jArr.append(" input buffers to hold the channels.");
            throw new IllegalArgumentException(jArr.toString());
        } else if (floatBufferArr2.length != 1) {
            throw new IllegalArgumentException("Channel merget invoked on more then one output");
        } else {
            int i;
            floatBufferArr2 = floatBufferArr2[0];
            int i2 = RedditJobManager.f10810d;
            for (i = 0; i < floatBufferArr.length; i++) {
                if (floatBufferArr[i].remaining() < i2) {
                    i2 = floatBufferArr[i].remaining();
                }
            }
            for (FloatBuffer remaining : floatBufferArr) {
                Assert.assertEquals(remaining.remaining(), i2);
            }
            if (floatBufferArr2.remaining() < floatBufferArr.length * i2) {
                floatBufferArr2 = new StringBuilder("Supplied output buffer is not big enough to hold ");
                floatBufferArr2.append(i2);
                floatBufferArr2.append(" * ");
                floatBufferArr2.append(floatBufferArr.length);
                floatBufferArr2.append(" = ");
                floatBufferArr2.append(i2 * floatBufferArr.length);
                floatBufferArr2.append(" output samples.");
                throw new IllegalArgumentException(floatBufferArr2.toString());
            }
            for (i = 0; i < i2; i++) {
                for (FloatBuffer floatBuffer : floatBufferArr) {
                    floatBufferArr2.put(floatBuffer.get());
                }
            }
        }
    }

    public int getNInputs() {
        return this.format.getChannels();
    }
}
