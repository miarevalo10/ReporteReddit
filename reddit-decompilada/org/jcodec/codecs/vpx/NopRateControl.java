package org.jcodec.codecs.vpx;

public class NopRateControl implements RateControl {
    private int qp;

    public int getSegment() {
        return 0;
    }

    public void report(int i) {
    }

    public void reset() {
    }

    public NopRateControl(int i) {
        this.qp = i;
    }

    public int[] getSegmentQps() {
        return new int[]{this.qp};
    }
}
