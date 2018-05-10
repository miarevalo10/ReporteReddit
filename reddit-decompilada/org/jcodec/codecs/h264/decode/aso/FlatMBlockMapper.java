package org.jcodec.codecs.h264.decode.aso;

public class FlatMBlockMapper implements Mapper {
    private int firstMBAddr;
    private int frameWidthInMbs;

    public FlatMBlockMapper(int i, int i2) {
        this.frameWidthInMbs = i;
        this.firstMBAddr = i2;
    }

    public boolean leftAvailable(int i) {
        i += this.firstMBAddr;
        return !(i % this.frameWidthInMbs == 0) && i > this.firstMBAddr;
    }

    public boolean topAvailable(int i) {
        return (i + this.firstMBAddr) - this.frameWidthInMbs >= this.firstMBAddr;
    }

    public int getAddress(int i) {
        return this.firstMBAddr + i;
    }

    public int getMbX(int i) {
        return getAddress(i) % this.frameWidthInMbs;
    }

    public int getMbY(int i) {
        return getAddress(i) / this.frameWidthInMbs;
    }

    public boolean topRightAvailable(int i) {
        i += this.firstMBAddr;
        return !((i + 1) % this.frameWidthInMbs == 0) && (i - this.frameWidthInMbs) + 1 >= this.firstMBAddr;
    }

    public boolean topLeftAvailable(int i) {
        i += this.firstMBAddr;
        return !(i % this.frameWidthInMbs == 0) && (i - this.frameWidthInMbs) - 1 >= this.firstMBAddr;
    }
}
