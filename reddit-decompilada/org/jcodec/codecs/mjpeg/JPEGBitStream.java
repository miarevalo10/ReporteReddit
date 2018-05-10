package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

public class JPEGBitStream {
    private int[] dcPredictor = new int[3];
    private VLC[] huff;
    private BitReader in;
    private int lumaLen;

    public final int toValue(int i, int i2) {
        return (i2 <= 0 || i >= (1 << (i2 - 1))) ? i : ((-(1 << i2)) + 1) + i;
    }

    public JPEGBitStream(ByteBuffer byteBuffer, VLC[] vlcArr, int i) {
        this.in = new BitReader(byteBuffer);
        this.huff = vlcArr;
        this.lumaLen = i;
    }

    public void readMCU(int[][] iArr) {
        int[] iArr2;
        int readDCValue;
        int i = 0;
        int i2 = i;
        while (i < this.lumaLen) {
            iArr2 = this.dcPredictor;
            int[] iArr3 = iArr[i2];
            readDCValue = readDCValue(this.dcPredictor[0], this.huff[0]);
            iArr3[0] = readDCValue;
            iArr2[0] = readDCValue;
            readACValues(iArr[i2], this.huff[2]);
            i++;
            i2++;
        }
        int[] iArr4 = this.dcPredictor;
        iArr2 = iArr[i2];
        int readDCValue2 = readDCValue(this.dcPredictor[1], this.huff[1]);
        iArr2[0] = readDCValue2;
        iArr4[1] = readDCValue2;
        readACValues(iArr[i2], this.huff[3]);
        i2++;
        iArr4 = this.dcPredictor;
        iArr2 = iArr[i2];
        readDCValue = readDCValue(this.dcPredictor[2], this.huff[1]);
        iArr2[0] = readDCValue;
        iArr4[2] = readDCValue;
        readACValues(iArr[i2], this.huff[3]);
    }

    public int readDCValue(int i, VLC vlc) {
        vlc = vlc.readVLC(this.in);
        return vlc != null ? toValue(this.in.readNBit(vlc), vlc) + i : i;
    }

    public void readACValues(int[] iArr, VLC vlc) {
        int i = 1;
        do {
            int readVLC = vlc.readVLC(this.in);
            if (readVLC == 240) {
                i += 16;
            } else if (readVLC > 0) {
                i += readVLC >> 4;
                int i2 = readVLC & 15;
                iArr[i] = toValue(this.in.readNBit(i2), i2);
                i++;
            }
            if (readVLC == 0) {
                return;
            }
        } while (i < 64);
    }
}
