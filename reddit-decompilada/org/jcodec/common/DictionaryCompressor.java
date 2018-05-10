package org.jcodec.common;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.common.RunLength.Integer;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.VLC;
import org.jcodec.common.tools.MathUtil;

public class DictionaryCompressor {

    public static class Int extends DictionaryCompressor {
        public void compress(int[] iArr, ByteBuffer byteBuffer) {
            Integer valueStats = getValueStats(iArr);
            int[] counts = valueStats.getCounts();
            int[] values = valueStats.getValues();
            int max = Math.max(1, (1 << (MathUtil.log2(counts.length) - 2)) - 1);
            VLC buildCodes = buildCodes(counts, max);
            int[] codes = buildCodes.getCodes();
            int[] codeSizes = buildCodes.getCodeSizes();
            byteBuffer.putInt(codes.length);
            for (int i = 0; i < codes.length; i++) {
                byteBuffer.put((byte) codeSizes[i]);
                byteBuffer.putShort((short) (codes[i] >>> 16));
                byteBuffer.putInt(values[i]);
            }
            BitWriter bitWriter = new BitWriter(byteBuffer);
            for (int i2 : iArr) {
                for (int i3 = 0; i3 < values.length; i3++) {
                    if (values[i3] == i2) {
                        buildCodes.writeVLC(bitWriter, i3);
                        if (codes[i3] == max) {
                            bitWriter.writeNBit(i3, 16);
                        }
                    }
                }
            }
            bitWriter.flush();
        }

        private Integer getValueStats(int[] iArr) {
            iArr = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(iArr);
            Integer integer = new Integer();
            for (int add : iArr) {
                integer.add(add);
            }
            return integer;
        }
    }

    public static class Long extends DictionaryCompressor {
        public void compress(long[] jArr, ByteBuffer byteBuffer) {
            org.jcodec.common.RunLength.Long valueStats = getValueStats(jArr);
            int[] counts = valueStats.getCounts();
            long[] values = valueStats.getValues();
            VLC buildCodes = buildCodes(counts, jArr.length / 10);
            int[] codes = buildCodes.getCodes();
            int[] codeSizes = buildCodes.getCodeSizes();
            byteBuffer.putInt(codes.length);
            for (int i = 0; i < codes.length; i++) {
                byteBuffer.put((byte) codeSizes[i]);
                byteBuffer.putShort((short) (codes[i] >>> 16));
                byteBuffer.putLong(values[i]);
            }
            BitWriter bitWriter = new BitWriter(byteBuffer);
            for (long j : jArr) {
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (values[i2] == j) {
                        buildCodes.writeVLC(bitWriter, i2);
                        if (codes[i2] == 15) {
                            bitWriter.writeNBit(16, i2);
                        }
                    }
                }
            }
            bitWriter.flush();
        }

        private org.jcodec.common.RunLength.Long getValueStats(long[] jArr) {
            jArr = Arrays.copyOf(jArr, jArr.length);
            Arrays.sort(jArr);
            org.jcodec.common.RunLength.Long longR = new org.jcodec.common.RunLength.Long();
            for (long add : jArr) {
                longR.add(add);
            }
            return longR;
        }
    }

    protected VLC buildCodes(int[] iArr, int i) {
        int i2;
        int i3 = 0;
        int[] iArr2 = new int[iArr.length];
        int[] iArr3 = new int[iArr.length];
        for (i2 = 0; i2 < Math.min(iArr2.length, i); i2++) {
            int i4 = 0;
            int i5 = i4;
            while (i4 < iArr.length) {
                if (iArr[i4] > iArr[i5]) {
                    i5 = i4;
                }
                i4++;
            }
            iArr2[i5] = i2;
            iArr3[i5] = Math.max(1, MathUtil.log2(i2));
            iArr[i5] = Integer.MIN_VALUE;
        }
        i2 = MathUtil.log2(i);
        while (i3 < iArr.length) {
            if (iArr[i3] >= 0) {
                iArr2[i3] = i;
                iArr3[i3] = i2;
            }
            i3++;
        }
        return new VLC(iArr2, iArr3);
    }
}
