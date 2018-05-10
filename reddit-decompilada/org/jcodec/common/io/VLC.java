package org.jcodec.common.io;

import java.io.PrintStream;
import org.jcodec.common.IntArrayList;

public class VLC {
    private int[] codeSizes;
    private int[] codes;
    private int[] valueSizes;
    private int[] values;

    public VLC(int[] iArr, int[] iArr2) {
        this.codes = iArr;
        this.codeSizes = iArr2;
        invert();
    }

    public VLC(String... strArr) {
        IntArrayList intArrayList = new IntArrayList();
        IntArrayList intArrayList2 = new IntArrayList();
        for (String str : strArr) {
            intArrayList.add(Integer.parseInt(str, 2) << (32 - str.length()));
            intArrayList2.add(str.length());
        }
        this.codes = intArrayList.toArray();
        this.codeSizes = intArrayList2.toArray();
        invert();
    }

    private void invert() {
        IntArrayList intArrayList = new IntArrayList();
        IntArrayList intArrayList2 = new IntArrayList();
        invert(0, 0, 0, intArrayList, intArrayList2);
        this.values = intArrayList.toArray();
        this.valueSizes = intArrayList2.toArray();
    }

    private int invert(int i, int i2, int i3, IntArrayList intArrayList, IntArrayList intArrayList2) {
        VLC vlc = this;
        int i4 = i;
        IntArrayList intArrayList3 = intArrayList;
        IntArrayList intArrayList4 = intArrayList2;
        int i5 = i4 + 256;
        intArrayList3.fill(i4, i5, -1);
        intArrayList4.fill(i4, i5, 0);
        int i6 = i2 << 3;
        int i7 = i5;
        for (int i8 = 0; i8 < vlc.codeSizes.length; i8++) {
            int i9;
            if (vlc.codeSizes[i8] > i6) {
                if (i2 <= 0) {
                    i9 = i3;
                } else if ((vlc.codes[i8] >>> (32 - i6)) == i3) {
                }
                int i10 = vlc.codes[i8] >>> ((32 - i6) - 8);
                i5 = i10 & 255;
                int i11 = vlc.codeSizes[i8] - i6;
                if (i11 <= 8) {
                    for (i10 = 0; i10 < (1 << (8 - i11)); i10++) {
                        int i12 = (i4 + i5) + i10;
                        intArrayList3.set(i12, i8);
                        intArrayList4.set(i12, i11);
                    }
                } else {
                    i5 += i4;
                    if (intArrayList3.get(i5) == -1) {
                        intArrayList3.set(i5, i7);
                        i7 = invert(i7, i2 + 1, i10, intArrayList3, intArrayList4);
                    }
                }
            } else {
                i9 = i3;
            }
        }
        return i7;
    }

    public int readVLC16(BitReader bitReader) {
        int check16Bits = bitReader.check16Bits();
        int i = check16Bits >>> 8;
        int i2 = this.values[i];
        i = this.valueSizes[i];
        if (i == 0) {
            check16Bits = (check16Bits & 255) + i2;
            i2 = this.values[check16Bits];
            bitReader.skipFast(8 + this.valueSizes[check16Bits]);
            return i2;
        }
        bitReader.skipFast(i);
        return i2;
    }

    public int readVLC(BitReader bitReader) {
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (i == 0) {
            int checkNBit = bitReader.checkNBit(8);
            i2 += checkNBit;
            int i5 = this.values[i2];
            i2 = this.valueSizes[i2];
            int i6 = i2 != 0 ? i2 : 8;
            i3 = (i3 << i6) | (checkNBit >> (8 - i6));
            bitReader.skip(i6);
            if (i5 == -1) {
                StringBuilder stringBuilder = new StringBuilder("Invalid code prefix ");
                stringBuilder.append(binary(i3, (i4 << 3) + i6));
                throw new RuntimeException(stringBuilder.toString());
            }
            i4++;
            i = i2;
            i2 = i5;
        }
        return i2;
    }

    private String binary(int i, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = ((1 << ((i2 - i3) - 1)) & i) != 0 ? '1' : '0';
        }
        return new String(cArr);
    }

    public void writeVLC(BitWriter bitWriter, int i) {
        bitWriter.writeNBit(this.codes[i] >>> (32 - this.codeSizes[i]), this.codeSizes[i]);
    }

    public void printTable(PrintStream printStream) {
        for (int i = 0; i < this.values.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(extracted(i));
            stringBuilder.append(" (");
            stringBuilder.append(this.valueSizes[i]);
            stringBuilder.append(") -> ");
            stringBuilder.append(this.values[i]);
            printStream.println(stringBuilder.toString());
        }
    }

    private String extracted(int i) {
        i = Integer.toString(i & 255, 2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 8 - i.length(); i2++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public int[] getCodes() {
        return this.codes;
    }

    public int[] getCodeSizes() {
        return this.codeSizes;
    }
}
