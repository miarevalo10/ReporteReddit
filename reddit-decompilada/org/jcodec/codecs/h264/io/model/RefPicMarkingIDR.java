package org.jcodec.codecs.h264.io.model;

public class RefPicMarkingIDR {
    boolean discardDecodedPics;
    boolean useForlongTerm;

    public RefPicMarkingIDR(boolean z, boolean z2) {
        this.discardDecodedPics = z;
        this.useForlongTerm = z2;
    }

    public boolean isDiscardDecodedPics() {
        return this.discardDecodedPics;
    }

    public boolean isUseForlongTerm() {
        return this.useForlongTerm;
    }
}
