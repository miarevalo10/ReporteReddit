package org.jcodec.codecs.h264.io.model;

import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public void write(BitWriter bitWriter) {
        int i = 0;
        if (this.useDefaultScalingMatrixFlag) {
            CAVLCWriter.writeSE(bitWriter, 0, "SPS: ");
            return;
        }
        int i2 = 8;
        while (i < this.scalingList.length) {
            CAVLCWriter.writeSE(bitWriter, (this.scalingList[i] - i2) - 256, "SPS: ");
            i2 = this.scalingList[i];
            i++;
        }
    }

    public static ScalingList read(BitReader bitReader, int i) {
        ScalingList scalingList = new ScalingList();
        scalingList.scalingList = new int[i];
        int i2 = 8;
        int i3 = i2;
        int i4 = 0;
        while (i4 < i) {
            if (i2 != 0) {
                i2 = ((CAVLCReader.readSE(bitReader, "deltaScale") + i3) + 256) % 256;
                boolean z = i4 == 0 && i2 == 0;
                scalingList.useDefaultScalingMatrixFlag = z;
            }
            int[] iArr = scalingList.scalingList;
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = scalingList.scalingList[i4];
            i4++;
        }
        return scalingList;
    }
}
