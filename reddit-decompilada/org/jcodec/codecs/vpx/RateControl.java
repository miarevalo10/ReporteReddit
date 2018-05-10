package org.jcodec.codecs.vpx;

public interface RateControl {
    int getSegment();

    int[] getSegmentQps();

    void report(int i);

    void reset();
}
