package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.mjpeg.tools.Asserts;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.dct.SimpleIDCT10Bit;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

public class JpegDecoder implements VideoDecoder {
    int[] buf;
    private boolean interlace;
    private boolean topFieldFirst;

    public static final int toValue(int i, int i2) {
        return (i2 <= 0 || i >= (1 << (i2 - 1))) ? i : ((-(1 << i2)) + 1) + i;
    }

    public int probe(ByteBuffer byteBuffer) {
        return 0;
    }

    public JpegDecoder() {
        this(false, false);
    }

    public JpegDecoder(boolean z, boolean z2) {
        this.buf = new int[64];
        this.interlace = z;
        this.topFieldFirst = z2;
    }

    private Picture decodeScan(ByteBuffer byteBuffer, FrameHeader frameHeader, ScanHeader scanHeader, VLC[] vlcArr, int[][] iArr, int[][] iArr2, int i, int i2) {
        FrameHeader frameHeader2 = frameHeader;
        int hmax = frameHeader.getHmax();
        int vmax = frameHeader.getVmax();
        int i3 = hmax << 3;
        int i4 = vmax << 3;
        int i5 = frameHeader2.width;
        int i6 = frameHeader2.height;
        int i7 = hmax + 2;
        int i8 = ((i3 + i5) - 1) >> i7;
        i3 = vmax + 2;
        int i9 = ((i4 + i6) - 1) >> i3;
        i4 = hmax + vmax;
        int i10 = i8 << i7;
        int i11 = i9 << i3;
        ColorSpace colorSpace = i4 == 4 ? ColorSpace.YUV420J : i4 == 3 ? ColorSpace.YUV422J : ColorSpace.YUV444J;
        int i12 = 0;
        Picture picture = new Picture(i10, i11, iArr2, colorSpace, new Rect(0, 0, i5, i6));
        BitReader bitReader = new BitReader(byteBuffer);
        int[] iArr3 = new int[]{1024, 1024, 1024};
        int i13 = 0;
        while (i13 < i9) {
            i11 = i12;
            while (i11 < i8 && bitReader.moreData()) {
                int i14 = i11;
                int i15 = i13;
                int[] iArr4 = iArr3;
                BitReader bitReader2 = bitReader;
                int i16 = i12;
                decodeMCU(bitReader, iArr3, iArr, vlcArr, picture, i11, i13, hmax, vmax, i, i2);
                i11 = i14 + 1;
                i13 = i15;
                iArr3 = iArr4;
                bitReader = bitReader2;
                i12 = i16;
            }
            i13++;
            iArr3 = iArr3;
            bitReader = bitReader;
            i12 = i12;
        }
        return picture;
    }

    void putBlock(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        i5 *= i;
        i4 = ((i4 * i) + (i3 * i5)) + i2;
        i2 = 0;
        i3 = i2;
        while (i2 < 8) {
            for (int i6 = 0; i6 < 8; i6++) {
                iArr[i6 + i4] = MathUtil.clip(iArr2[i6 + i3], 0, 255);
            }
            i4 += i5;
            i3 += 8;
            i2++;
        }
    }

    void decodeMCU(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int i, int i2, int i3, int i4, int i5, int i6) {
        BitReader bitReader2;
        int[] iArr3;
        int[][] iArr4;
        VLC[] vlcArr2;
        Picture picture2;
        JpegDecoder jpegDecoder = this;
        int i7 = i3;
        int i8 = i4;
        int i9 = i << (i7 - 1);
        int i10 = i2 << (i8 - 1);
        int i11 = 0;
        while (i11 < i8) {
            int i12 = 0;
            while (i12 < i7) {
                bitReader2 = bitReader;
                iArr3 = iArr;
                iArr4 = iArr2;
                vlcArr2 = vlcArr;
                picture2 = picture;
                int i13 = i12;
                int i14 = i11;
                decodeBlock(bitReader2, iArr3, iArr4, vlcArr2, picture2, jpegDecoder.buf, (i9 + i12) << 3, (i10 + i11) << 3, 0, 0, i5, i6);
                i12 = i13 + 1;
                i7 = i3;
                i8 = i4;
                i11 = i14;
            }
            i11++;
            i7 = i3;
            i8 = i4;
        }
        bitReader2 = bitReader;
        iArr3 = iArr;
        iArr4 = iArr2;
        vlcArr2 = vlcArr;
        picture2 = picture;
        int i15 = i << 3;
        int i16 = i2 << 3;
        i8 = i5;
        i7 = i6;
        decodeBlock(bitReader2, iArr3, iArr4, vlcArr2, picture2, jpegDecoder.buf, i15, i16, 1, 1, i8, i7);
        decodeBlock(bitReader2, iArr3, iArr4, vlcArr2, picture2, jpegDecoder.buf, i15, i16, 2, 1, i8, i7);
    }

    void decodeBlock(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int[] iArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        BitReader bitReader2 = bitReader;
        Picture picture2 = picture;
        int[] iArr4 = iArr3;
        int i7 = i3;
        Arrays.fill(iArr4, 0);
        int readDCValue = (readDCValue(bitReader2, vlcArr[i4]) * iArr2[i4][0]) + iArr[i7];
        iArr4[0] = readDCValue;
        iArr[i7] = readDCValue;
        readACValues(bitReader2, iArr4, vlcArr[i4 + 2], iArr2[i4]);
        SimpleIDCT10Bit.idct10(iArr4, 0);
        putBlock(picture2.getPlaneData(i7), picture2.getPlaneWidth(i7), iArr4, i, i2, i5, i6);
    }

    int readDCValue(BitReader bitReader, VLC vlc) {
        vlc = vlc.readVLC16(bitReader);
        return vlc != null ? toValue(bitReader.readNBit(vlc), vlc) : null;
    }

    void readACValues(BitReader bitReader, int[] iArr, VLC vlc, int[] iArr2) {
        int i = 1;
        do {
            int readVLC16 = vlc.readVLC16(bitReader);
            if (readVLC16 == 240) {
                i += 16;
            } else if (readVLC16 > 0) {
                i += readVLC16 >> 4;
                int i2 = readVLC16 & 15;
                iArr[JpegConst.naturalOrder[i]] = toValue(bitReader.readNBit(i2), i2) * iArr2[i];
                i++;
            }
            if (readVLC16 == 0) {
                return;
            }
        } while (i < 64);
    }

    public Picture decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        if (!this.interlace) {
            return decodeField(byteBuffer, iArr, 0, 1);
        }
        Picture decodeField = decodeField(byteBuffer, iArr, this.topFieldFirst ^ 1, 2);
        decodeField(byteBuffer, iArr, this.topFieldFirst, 2);
        return new Picture(decodeField.getWidth(), decodeField.getHeight() << 1, iArr, decodeField.getColor());
    }

    public Picture decodeField(ByteBuffer byteBuffer, int[][] iArr, int i, int i2) {
        ByteBuffer byteBuffer2 = byteBuffer;
        VLC[] vlcArr = new VLC[]{JpegConst.YDC_DEFAULT, JpegConst.CDC_DEFAULT, JpegConst.YAC_DEFAULT, JpegConst.CAC_DEFAULT};
        int[][] iArr2 = new int[4][];
        ScanHeader scanHeader = null;
        Picture picture = null;
        FrameHeader frameHeader = picture;
        while (byteBuffer.hasRemaining()) {
            int i3 = byteBuffer.get() & 255;
            if (i3 != 0) {
                if (i3 == 255) {
                    do {
                        i3 = byteBuffer.get() & 255;
                    } while (i3 == 255);
                    if (i3 != JpegConst.SOF0) {
                        ByteBuffer read;
                        if (i3 != JpegConst.DHT) {
                            if (i3 != JpegConst.DQT) {
                                if (i3 != JpegConst.SOS) {
                                    if (i3 != JpegConst.SOI && (i3 < JpegConst.RST0 || i3 > JpegConst.RST7)) {
                                        if (i3 == JpegConst.EOI) {
                                            break;
                                        } else if (i3 >= JpegConst.APP0 && i3 <= JpegConst.COM) {
                                            NIOUtils.read(byteBuffer2, (byteBuffer.getShort() & 65535) - 2);
                                        } else if (i3 == JpegConst.DRI) {
                                            byteBuffer.getShort();
                                            Asserts.assertEquals(0, byteBuffer.getShort() & 65535);
                                        } else {
                                            StringBuilder stringBuilder = new StringBuilder("unhandled marker ");
                                            stringBuilder.append(JpegConst.toString(i3));
                                            throw new IllegalStateException(stringBuilder.toString());
                                        }
                                    }
                                } else if (scanHeader != null) {
                                    throw new IllegalStateException("unhandled - more than one scan header");
                                } else {
                                    ScanHeader read2 = ScanHeader.read(byteBuffer);
                                    picture = decodeScan(readToMarker(byteBuffer), frameHeader, read2, vlcArr, iArr2, iArr, i, i2);
                                    scanHeader = read2;
                                }
                            } else {
                                read = NIOUtils.read(byteBuffer2, (byteBuffer.getShort() & 65535) - 2);
                                while (read.hasRemaining()) {
                                    iArr2[read.get() & 255] = readQuantTable(read);
                                }
                            }
                        } else {
                            read = NIOUtils.read(byteBuffer2, (byteBuffer.getShort() & 65535) - 2);
                            while (read.hasRemaining()) {
                                int i4 = read.get() & 255;
                                vlcArr[((i4 >> 3) & 2) | (i4 & 1)] = readHuffmanTable(read);
                            }
                        }
                    } else {
                        frameHeader = FrameHeader.read(byteBuffer);
                    }
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("@");
                    stringBuilder2.append(Long.toHexString((long) byteBuffer.position()));
                    stringBuilder2.append(" Marker expected: 0x");
                    stringBuilder2.append(Integer.toHexString(i3));
                    throw new RuntimeException(stringBuilder2.toString());
                }
            }
        }
        return picture;
    }

    private static ByteBuffer readToMarker(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == (byte) -1) {
                if (byteBuffer.get() != (byte) 0) {
                    byteBuffer.position(byteBuffer.position() - 2);
                    break;
                }
                allocate.put((byte) -1);
            } else {
                allocate.put(b);
            }
        }
        allocate.flip();
        return allocate;
    }

    private static VLC readHuffmanTable(ByteBuffer byteBuffer) {
        VLCBuilder vLCBuilder = new VLCBuilder();
        byte[] toArray = NIOUtils.toArray(NIOUtils.read(byteBuffer, 16));
        int i = 0;
        int i2 = i;
        while (i < 16) {
            int i3 = toArray[i] & 255;
            int i4 = i2;
            i2 = 0;
            while (i2 < i3) {
                int i5 = i4 + 1;
                vLCBuilder.set(i4, i + 1, byteBuffer.get() & 255);
                i2++;
                i4 = i5;
            }
            i2 = i4 << 1;
            i++;
        }
        return vLCBuilder.getVLC();
    }

    private static int[] readQuantTable(ByteBuffer byteBuffer) {
        int[] iArr = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr[i] = byteBuffer.get() & 255;
        }
        return iArr;
    }
}
