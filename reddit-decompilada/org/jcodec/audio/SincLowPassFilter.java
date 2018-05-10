package org.jcodec.audio;

public class SincLowPassFilter extends ConvolutionFilter {
    private double cutoffFreq;
    private int kernelSize;

    public SincLowPassFilter(int i, int i2) {
        this(((double) i) / ((double) i2));
    }

    public SincLowPassFilter(double d) {
        this(40, d);
    }

    public SincLowPassFilter(int i, double d) {
        this.kernelSize = i;
        this.cutoffFreq = d;
    }

    protected double[] buildKernel() {
        double[] dArr = new double[this.kernelSize];
        int i = 0;
        double d = 0.0d;
        for (int i2 = 0; i2 < r0.kernelSize; i2++) {
            if (i2 - (r0.kernelSize / 2) != 0) {
                dArr[i2] = (Math.sin((r0.cutoffFreq * 6.283185307179586d) * ((double) (i2 - (r0.kernelSize / 2)))) / ((double) (i2 - (r0.kernelSize / 2)))) * (0.54d - (0.46d * Math.cos((6.283185307179586d * ((double) i2)) / ((double) r0.kernelSize))));
            } else {
                dArr[i2] = 6.283185307179586d * r0.cutoffFreq;
            }
            d += dArr[i2];
        }
        while (i < r0.kernelSize) {
            dArr[i] = dArr[i] / d;
            i++;
        }
        return dArr;
    }
}
