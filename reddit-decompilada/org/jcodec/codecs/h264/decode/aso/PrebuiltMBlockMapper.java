package org.jcodec.codecs.h264.decode.aso;

public class PrebuiltMBlockMapper implements Mapper {
    private int firstMBInSlice;
    private int groupId;
    private int indexOfFirstMb;
    private MBToSliceGroupMap map;
    private int picWidthInMbs;

    public PrebuiltMBlockMapper(MBToSliceGroupMap mBToSliceGroupMap, int i, int i2) {
        this.map = mBToSliceGroupMap;
        this.firstMBInSlice = i;
        this.groupId = mBToSliceGroupMap.getGroups()[i];
        this.picWidthInMbs = i2;
        this.indexOfFirstMb = mBToSliceGroupMap.getIndices()[i];
    }

    public int getAddress(int i) {
        return this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
    }

    public boolean leftAvailable(int i) {
        i = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i2 = i - 1;
        return i2 >= this.firstMBInSlice && i % this.picWidthInMbs != 0 && this.map.getGroups()[i2] == this.groupId;
    }

    public boolean topAvailable(int i) {
        i = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb] - this.picWidthInMbs;
        return i >= this.firstMBInSlice && this.map.getGroups()[i] == this.groupId;
    }

    public int getMbX(int i) {
        return getAddress(i) % this.picWidthInMbs;
    }

    public int getMbY(int i) {
        return getAddress(i) / this.picWidthInMbs;
    }

    public boolean topRightAvailable(int i) {
        i = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i2 = (i - this.picWidthInMbs) + 1;
        if (i2 < this.firstMBInSlice || (i + 1) % this.picWidthInMbs == 0 || this.map.getGroups()[i2] != this.groupId) {
            return false;
        }
        return true;
    }

    public boolean topLeftAvailable(int i) {
        i = this.map.getInverse()[this.groupId][i + this.indexOfFirstMb];
        int i2 = (i - this.picWidthInMbs) - 1;
        if (i2 < this.firstMBInSlice || i % this.picWidthInMbs == 0 || this.map.getGroups()[i2] != this.groupId) {
            return false;
        }
        return true;
    }
}
