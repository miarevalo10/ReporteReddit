package org.jcodec.audio;

import java.nio.FloatBuffer;

public abstract class ConvolutionFilter implements AudioFilter {
    private double[] kernel;

    protected abstract double[] buildKernel();

    public int getNInputs() {
        return 1;
    }

    public int getNOutputs() {
        return 1;
    }

    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != 1) {
            jArr = new StringBuilder();
            jArr.append(getClass().getName());
            jArr.append(" filter is designed to work only on one input");
            throw new IllegalArgumentException(jArr.toString());
        } else if (floatBufferArr2.length != 1) {
            jArr = new StringBuilder();
            jArr.append(getClass().getName());
            jArr.append(" filter is designed to work only on one output");
            throw new IllegalArgumentException(jArr.toString());
        } else {
            floatBufferArr = floatBufferArr[0];
            floatBufferArr2 = floatBufferArr2[0];
            if (this.kernel == null) {
                this.kernel = buildKernel();
            }
            if (floatBufferArr2.remaining() < floatBufferArr.remaining() - this.kernel.length) {
                throw new IllegalArgumentException("Output buffer is too small");
            } else if (floatBufferArr.remaining() <= this.kernel.length) {
                jArr = new StringBuilder("Input buffer should contain > kernel lenght (");
                jArr.append(this.kernel.length);
                jArr.append(") samples.");
                throw new IllegalArgumentException(jArr.toString());
            } else {
                int length = this.kernel.length / 2;
                int position = floatBufferArr.position() + length;
                while (position < floatBufferArr.limit() - length) {
                    double d = 0.0d;
                    for (int i = 0; i < this.kernel.length; i++) {
                        d += this.kernel[i] * ((double) floatBufferArr.get((position + i) - length));
                    }
                    floatBufferArr2.put((float) d);
                    position++;
                }
                floatBufferArr.position(position - length);
            }
        }
    }

    public int getDelay() {
        if (this.kernel == null) {
            this.kernel = buildKernel();
        }
        return this.kernel.length / 2;
    }
}
