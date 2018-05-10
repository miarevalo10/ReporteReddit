package org.jcodec.codecs.vpx;

public class VP8FixedRateControl implements RateControl {
    private int rate;

    public int getSegment() {
        return 0;
    }

    public int[] getSegmentQps() {
        return null;
    }

    public void report(int i) {
    }

    public void reset() {
    }

    public VP8FixedRateControl(int i) {
        this.rate = i;
    }
}
