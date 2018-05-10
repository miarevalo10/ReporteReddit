package org.jcodec.audio;

import java.nio.FloatBuffer;

public class LanczosInterpolator implements AudioFilter {
    private double rateStep;

    public int getDelay() {
        return 3;
    }

    public int getNInputs() {
        return 1;
    }

    public int getNOutputs() {
        return 1;
    }

    public static double lanczos(double d, int i) {
        if (d < ((double) (-i))) {
            return 0.0d;
        }
        double d2 = (double) i;
        if (d > d2) {
            return 0.0d;
        }
        double d3 = 3.141592653589793d * d;
        return ((Math.sin(d3) * d2) * Math.sin(d3 / d2)) / ((9.869604401089358d * d) * d);
    }

    public LanczosInterpolator(int i, int i2) {
        this.rateStep = ((double) i) / ((double) i2);
    }

    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        LanczosInterpolator lanczosInterpolator = this;
        FloatBuffer[] floatBufferArr3 = floatBufferArr;
        FloatBuffer[] floatBufferArr4 = floatBufferArr2;
        StringBuilder stringBuilder;
        if (floatBufferArr3.length != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" filter is designed to work only on one input");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (floatBufferArr4.length != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" filter is designed to work only on one output");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            int i = 0;
            FloatBuffer floatBuffer = floatBufferArr3[0];
            FloatBuffer floatBuffer2 = floatBufferArr4[0];
            if (((double) floatBuffer2.remaining()) < ((double) (floatBuffer.remaining() - 6)) / lanczosInterpolator.rateStep) {
                throw new IllegalArgumentException("Output buffer is too small");
            } else if (floatBuffer.remaining() <= 6) {
                throw new IllegalArgumentException("Input buffer should contain > 6 samples.");
            } else {
                int i2 = 0;
                while (true) {
                    double ceil = ((3.0d + (((double) i2) * lanczosInterpolator.rateStep)) + (Math.ceil(((double) jArr[i]) / lanczosInterpolator.rateStep) * lanczosInterpolator.rateStep)) - ((double) jArr[i]);
                    int floor = (int) Math.floor(ceil);
                    int ceil2 = (int) Math.ceil(ceil);
                    if (floor >= floatBuffer.limit() - 3) {
                        floatBuffer.position(floor - 3);
                        return;
                    }
                    int i3;
                    FloatBuffer floatBuffer3;
                    double d = ((double) floor) - ceil;
                    if (d < -0.001d) {
                        double d2 = ((double) ceil2) - ceil;
                        ceil = lanczos(d, 3);
                        double lanczos = lanczos(d2, 3);
                        i3 = i2;
                        double lanczos2 = lanczos(d - 1.0d, 3);
                        FloatBuffer floatBuffer4 = floatBuffer2;
                        double lanczos3 = lanczos(d2 + 1.0d, 3);
                        d = lanczos(d - 2.0d, 3);
                        double lanczos4 = lanczos(d2 + 2.0d, 3);
                        floatBuffer3 = floatBuffer4;
                        floatBuffer3.put((float) (((((((((double) floatBuffer.get(ceil2)) * lanczos) + (((double) floatBuffer.get(ceil2 + 1)) * lanczos3)) + (((double) floatBuffer.get(ceil2 + 2)) * lanczos4)) + (((double) floatBuffer.get(floor)) * ceil)) + (((double) floatBuffer.get(floor - 1)) * lanczos2)) + (((double) floatBuffer.get(floor - 2)) * d)) * (1.0d / (((((ceil + lanczos2) + d) + lanczos) + lanczos3) + lanczos4))));
                    } else {
                        floatBuffer3 = floatBuffer2;
                        i3 = i2;
                        floatBuffer3.put(floatBuffer.get(floor));
                    }
                    i2 = i3 + 1;
                    floatBuffer2 = floatBuffer3;
                    lanczosInterpolator = this;
                    i = 0;
                }
            }
        }
    }
}
