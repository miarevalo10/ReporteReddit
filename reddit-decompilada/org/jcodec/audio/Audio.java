package org.jcodec.audio;

import java.io.IOException;
import java.nio.FloatBuffer;

public class Audio {

    public static class DummyFilter implements AudioFilter {
        private int nInputs;

        public int getDelay() {
            return 0;
        }

        public DummyFilter(int i) {
            this.nInputs = i;
        }

        public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
            for (jArr = null; jArr < floatBufferArr.length; jArr++) {
                if (floatBufferArr2[jArr].remaining() >= floatBufferArr[jArr].remaining()) {
                    floatBufferArr2[jArr].put(floatBufferArr[jArr]);
                } else {
                    floatBufferArr2[jArr].put((FloatBuffer) floatBufferArr[jArr].duplicate().limit(floatBufferArr[jArr].position() + floatBufferArr2[jArr].remaining()));
                }
            }
        }

        public int getNInputs() {
            return this.nInputs;
        }

        public int getNOutputs() {
            return this.nInputs;
        }
    }

    public static void transfer(AudioSource audioSource, AudioSink audioSink) throws IOException {
        transfer(audioSource, new DummyFilter(1), audioSink);
    }

    public static void transfer(AudioSource audioSource, AudioFilter audioFilter, AudioSink audioSink) throws IOException {
        if (audioFilter.getNInputs() != 1) {
            throw new IllegalArgumentException("Audio filter has # inputs != 1");
        } else if (audioFilter.getNOutputs() != 1) {
            throw new IllegalArgumentException("Audio filter has # outputs != 1");
        } else if (audioFilter.getDelay() != 0) {
            throw new IllegalArgumentException("Audio filter has delay");
        } else {
            FloatBuffer[] floatBufferArr = new FloatBuffer[]{FloatBuffer.allocate(4096)};
            FloatBuffer[] floatBufferArr2 = new FloatBuffer[]{FloatBuffer.allocate(8192)};
            long[] jArr = new long[1];
            while (audioSource.read(floatBufferArr[0]) != -1) {
                floatBufferArr[0].flip();
                audioFilter.filter(floatBufferArr, jArr, floatBufferArr2);
                jArr[0] = jArr[0] + ((long) floatBufferArr[0].position());
                rotate(floatBufferArr[0]);
                floatBufferArr2[0].flip();
                audioSink.write(floatBufferArr2[0]);
                floatBufferArr2[0].clear();
            }
        }
    }

    public static void print(FloatBuffer floatBuffer) {
        floatBuffer = floatBuffer.duplicate();
        while (floatBuffer.hasRemaining()) {
            System.out.print(String.format("%.3f,", new Object[]{Float.valueOf(floatBuffer.get())}));
        }
        System.out.println();
    }

    public static void rotate(FloatBuffer floatBuffer) {
        int i = 0;
        while (floatBuffer.hasRemaining()) {
            floatBuffer.put(i, floatBuffer.get());
            i++;
        }
        floatBuffer.position(i);
        floatBuffer.limit(floatBuffer.capacity());
    }
}
