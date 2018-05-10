package org.jcodec.codecs.h264.io.model;

import java.util.Comparator;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;

public class Frame extends Picture {
    public static Comparator<Frame> POCAsc = new C21941();
    public static Comparator<Frame> POCDesc = new C21952();
    private int frameNo;
    private int[][][][] mvs;
    private int poc;
    private Frame[][][] refsUsed;
    private boolean shortTerm = true;

    static class C21941 implements Comparator<Frame> {
        C21941() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Frame frame = (Frame) obj;
            Frame frame2 = (Frame) obj2;
            if (frame == null && frame2 == null) {
                return 0;
            }
            if (frame == null) {
                return 1;
            }
            if (frame2 != null) {
                if (frame.poc > frame2.poc) {
                    return 1;
                }
                if (frame.poc == frame2.poc) {
                    return 0;
                }
            }
            return -1;
        }
    }

    static class C21952 implements Comparator<Frame> {
        C21952() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Frame frame = (Frame) obj;
            Frame frame2 = (Frame) obj2;
            if (frame == null && frame2 == null) {
                return 0;
            }
            if (frame == null) {
                return 1;
            }
            if (frame2 != null) {
                if (frame.poc < frame2.poc) {
                    return 1;
                }
                if (frame.poc == frame2.poc) {
                    return 0;
                }
            }
            return -1;
        }
    }

    public Frame(int i, int i2, int[][] iArr, ColorSpace colorSpace, Rect rect, int i3, int[][][][] iArr2, Frame[][][] frameArr, int i4) {
        super(i, i2, iArr, colorSpace, rect);
        this.frameNo = i3;
        this.mvs = iArr2;
        this.refsUsed = frameArr;
        this.poc = i4;
    }

    public static Frame createFrame(Frame frame) {
        Picture createCompatible = frame.createCompatible();
        return new Frame(createCompatible.getWidth(), createCompatible.getHeight(), createCompatible.getData(), createCompatible.getColor(), frame.getCrop(), frame.frameNo, frame.mvs, frame.refsUsed, frame.poc);
    }

    public Frame cropped() {
        Picture cropped = super.cropped();
        return new Frame(cropped.getWidth(), cropped.getHeight(), cropped.getData(), cropped.getColor(), null, this.frameNo, this.mvs, this.refsUsed, this.poc);
    }

    public void copyFrom(Frame frame) {
        super.copyFrom(frame);
        this.frameNo = frame.frameNo;
        this.mvs = frame.mvs;
        this.shortTerm = frame.shortTerm;
        this.refsUsed = frame.refsUsed;
        this.poc = frame.poc;
    }

    public int getFrameNo() {
        return this.frameNo;
    }

    public int[][][][] getMvs() {
        return this.mvs;
    }

    public boolean isShortTerm() {
        return this.shortTerm;
    }

    public void setShortTerm(boolean z) {
        this.shortTerm = z;
    }

    public int getPOC() {
        return this.poc;
    }

    public Frame[][][] getRefsUsed() {
        return this.refsUsed;
    }
}
