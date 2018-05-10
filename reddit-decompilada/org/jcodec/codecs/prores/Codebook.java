package org.jcodec.codecs.prores;

public class Codebook {
    int expOrder;
    int golombBits;
    int golombOffset;
    int riceMask;
    int riceOrder;
    int switchBits;

    public Codebook(int i, int i2, int i3) {
        this.riceOrder = i;
        this.expOrder = i2;
        this.switchBits = i3;
        this.golombOffset = (1 << i2) - ((i3 + 1) << i);
        this.golombBits = (i2 - i3) - 1;
        this.riceMask = (1 << i) - 1;
    }
}
