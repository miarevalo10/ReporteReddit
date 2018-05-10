package org.jcodec.codecs.vp8;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.codecs.vp8.Macroblock.Subblock;
import org.jcodec.codecs.vp8.VP8Util.PLANE;
import org.jcodec.codecs.vp8.VP8Util.QuantizationParams;
import org.jcodec.codecs.vp8.VP8Util.SubblockConstants;
import org.jcodec.common.Assert;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class VP8Decoder {
    private int height;
    private Macroblock[][] mbs;
    private int width;

    public void decode(ByteBuffer byteBuffer) throws IOException {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        VP8Decoder vP8Decoder = this;
        ByteBuffer byteBuffer2 = byteBuffer;
        byte[] bArr = new byte[3];
        byteBuffer2.get(bArr);
        boolean z2 = VP8Util.getBitInBytes(bArr, 0) == 0;
        VP8Util.getBitsInBytes(bArr, 1, 3);
        VP8Util.getBitInBytes(bArr, 4);
        int bitsInBytes = VP8Util.getBitsInBytes(bArr, 5, 19);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(printHexByte(byteBuffer.get()));
        stringBuilder.append(" ");
        stringBuilder.append(printHexByte(byteBuffer.get()));
        stringBuilder.append(" ");
        stringBuilder.append(printHexByte(byteBuffer.get()));
        int i5 = (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8);
        vP8Decoder.width = ((byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8)) & 16383;
        vP8Decoder.height = i5 & 16383;
        int macroblockCount = VP8Util.getMacroblockCount(vP8Decoder.height);
        i5 = VP8Util.getMacroblockCount(vP8Decoder.width);
        int i6 = macroblockCount + 2;
        int i7 = i5 + 2;
        vP8Decoder.mbs = (Macroblock[][]) Array.newInstance(Macroblock.class, new int[]{i6, i7});
        for (i = 0; i < i6; i++) {
            for (i2 = 0; i2 < i7; i2++) {
                vP8Decoder.mbs[i][i2] = new Macroblock(i, i2);
            }
        }
        int position = byteBuffer.position();
        BooleanArithmeticDecoder booleanArithmeticDecoder = new BooleanArithmeticDecoder(byteBuffer2, 0);
        booleanArithmeticDecoder.decodeBit();
        booleanArithmeticDecoder.decodeBit();
        i7 = booleanArithmeticDecoder.decodeBit();
        Assert.assertEquals("Frame has segmentation, segment decoding is not ", 0, i7);
        i = booleanArithmeticDecoder.decodeBit();
        int decodeInt = booleanArithmeticDecoder.decodeInt(6);
        i = decodeInt == 0 ? 0 : i > 0 ? 1 : 2;
        int decodeInt2 = booleanArithmeticDecoder.decodeInt(3);
        int decodeBit = booleanArithmeticDecoder.decodeBit();
        Assert.assertEquals(1, decodeBit);
        Assert.assertEquals(1, booleanArithmeticDecoder.decodeBit());
        int[] iArr = new int[VP8Util.MAX_REF_LF_DELTAS];
        int[] iArr2 = new int[VP8Util.MAX_MODE_LF_DELTAS];
        int i8 = decodeInt2;
        for (i2 = 0; i2 < VP8Util.MAX_REF_LF_DELTAS; i2++) {
            if (booleanArithmeticDecoder.decodeBit() > 0) {
                iArr[i2] = booleanArithmeticDecoder.decodeInt(6);
                if (booleanArithmeticDecoder.decodeBit() > 0) {
                    iArr[i2] = iArr[i2] * -1;
                }
            }
        }
        for (decodeInt2 = 0; decodeInt2 < VP8Util.MAX_MODE_LF_DELTAS; decodeInt2++) {
            if (booleanArithmeticDecoder.decodeBit() > 0) {
                iArr2[decodeInt2] = booleanArithmeticDecoder.decodeInt(6);
                if (booleanArithmeticDecoder.decodeBit() > 0) {
                    iArr2[decodeInt2] = iArr2[decodeInt2] * -1;
                }
            }
        }
        Assert.assertEquals(0, booleanArithmeticDecoder.decodeInt(2));
        byteBuffer.limit();
        byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.position(bitsInBytes + position);
        BooleanArithmeticDecoder booleanArithmeticDecoder2 = new BooleanArithmeticDecoder(byteBuffer2, 0);
        int decodeInt3 = booleanArithmeticDecoder.decodeInt(7);
        int delta = booleanArithmeticDecoder.decodeBit() > 0 ? VP8Util.delta(booleanArithmeticDecoder) : 0;
        int delta2 = booleanArithmeticDecoder.decodeBit() > 0 ? VP8Util.delta(booleanArithmeticDecoder) : 0;
        int delta3 = booleanArithmeticDecoder.decodeBit() > 0 ? VP8Util.delta(booleanArithmeticDecoder) : 0;
        int delta4 = booleanArithmeticDecoder.decodeBit() > 0 ? VP8Util.delta(booleanArithmeticDecoder) : 0;
        int delta5 = booleanArithmeticDecoder.decodeBit() > 0 ? VP8Util.delta(booleanArithmeticDecoder) : 0;
        booleanArithmeticDecoder.decodeBit();
        QuantizationParams quantizationParams = new QuantizationParams(decodeInt3, delta, delta2, delta3, delta4, delta5);
        int[][][][] defaultCoefProbs = VP8Util.getDefaultCoefProbs();
        for (int i9 = 0; i9 < VP8Util.BLOCK_TYPES; i9++) {
            position = 0;
            while (position < VP8Util.COEF_BANDS) {
                z = z2;
                i2 = 0;
                while (i2 < VP8Util.PREV_COEF_CONTEXTS) {
                    i3 = 0;
                    while (true) {
                        i4 = i;
                        if (i3 >= VP8Util.MAX_ENTROPY_TOKENS - 1) {
                            break;
                        }
                        if (booleanArithmeticDecoder.decodeBool(VP8Util.vp8CoefUpdateProbs[i9][position][i2][i3]) > 0) {
                            defaultCoefProbs[i9][position][i2][i3] = booleanArithmeticDecoder.decodeInt(8);
                        }
                        i3++;
                        i = i4;
                    }
                    i2++;
                    i = i4;
                }
                i4 = i;
                position++;
                z2 = z;
            }
            z = z2;
            i4 = i;
        }
        z = z2;
        i4 = i;
        i3 = booleanArithmeticDecoder.decodeBit();
        Assert.assertEquals(1, i3);
        position = booleanArithmeticDecoder.decodeInt(8);
        i = 0;
        while (i < macroblockCount) {
            int i10;
            int[] iArr3;
            int i11;
            int i12;
            i2 = 0;
            while (i2 < i5) {
                i2++;
                Macroblock macroblock = vP8Decoder.mbs[i + 1][i2];
                if (i7 > 0) {
                    throw new UnsupportedOperationException("TODO: frames with multiple segments are not supported yet");
                } else if (decodeBit > 0) {
                    int i13;
                    int i14;
                    i10 = decodeBit;
                    decodeBit = decodeInt + iArr[0];
                    iArr3 = iArr;
                    if (decodeBit < 0) {
                        decodeBit = 0;
                    } else if (decodeBit > 63) {
                        decodeBit = 63;
                    }
                    macroblock.filterLevel = decodeBit;
                    if (i3 > 0) {
                        macroblock.skipCoeff = booleanArithmeticDecoder.decodeBool(position);
                    }
                    macroblock.lumaMode = booleanArithmeticDecoder.readTree(VP8Util.keyFrameYModeTree, VP8Util.keyFrameYModeProb);
                    int i15 = 4;
                    if (macroblock.lumaMode == 4) {
                        decodeBit = 0;
                        while (decodeBit < i15) {
                            i11 = i3;
                            i3 = 0;
                            while (i3 < i15) {
                                Subblock subblock = macroblock.ySubblocks[decodeBit][i3];
                                i13 = position;
                                i12 = i7;
                                i14 = i2;
                                subblock.mode = booleanArithmeticDecoder.readTree(SubblockConstants.subblockModeTree, SubblockConstants.keyFrameSubblockModeProb[subblock.getAbove(PLANE.Y1, vP8Decoder.mbs).mode][subblock.getLeft(PLANE.Y1, vP8Decoder.mbs).mode]);
                                i3++;
                                position = i13;
                                i7 = i12;
                                i2 = i14;
                                i15 = 4;
                            }
                            i13 = position;
                            i12 = i7;
                            i14 = i2;
                            decodeBit++;
                            i3 = i11;
                            i15 = 4;
                        }
                        i11 = i3;
                        i13 = position;
                        i12 = i7;
                        i14 = i2;
                        position = i15;
                    } else {
                        i11 = i3;
                        i13 = position;
                        i12 = i7;
                        i14 = i2;
                        switch (macroblock.lumaMode) {
                            case 1:
                                decodeBit = 2;
                                break;
                            case 2:
                                decodeBit = 3;
                                break;
                            case 3:
                                decodeBit = 1;
                                break;
                            default:
                                decodeBit = 0;
                                break;
                        }
                        for (i3 = 0; i3 < 4; i3++) {
                            for (i15 = 0; i15 < 4; i15++) {
                                macroblock.ySubblocks[i15][i3].mode = decodeBit;
                            }
                        }
                    }
                    macroblock.chromaMode = booleanArithmeticDecoder.readTree(VP8Util.vp8UVModeTree, VP8Util.vp8KeyFrameUVModeProb);
                    decodeBit = i10;
                    iArr = iArr3;
                    i3 = i11;
                    position = i13;
                    i7 = i12;
                    i2 = i14;
                } else {
                    throw new UnsupportedOperationException("TODO: frames with loopFilterDeltaFlag <= 0 are not supported yet");
                }
            }
            i10 = decodeBit;
            i11 = i3;
            iArr3 = iArr;
            i12 = i7;
            i++;
            position = position;
        }
        for (decodeBit = 0; decodeBit < macroblockCount; decodeBit++) {
            i3 = 0;
            while (i3 < i5) {
                i3++;
                macroblock = vP8Decoder.mbs[decodeBit + 1][i3];
                macroblock.decodeMacroBlock(vP8Decoder.mbs, booleanArithmeticDecoder2, defaultCoefProbs);
                macroblock.dequantMacroBlock(vP8Decoder.mbs, quantizationParams);
            }
        }
        if (i4 > 0 && decodeInt != 0 && i4 == 2) {
            decodeBit = i8;
            boolean z3 = z;
            FilterUtil.loopFilterUV(vP8Decoder.mbs, decodeBit, z3);
            FilterUtil.loopFilterY(vP8Decoder.mbs, decodeBit, z3);
        }
    }

    public Picture getPicture() {
        Picture create = Picture.create(this.width, this.height, ColorSpace.YUV420);
        int i = 0;
        int[] planeData = create.getPlaneData(0);
        int[] planeData2 = create.getPlaneData(1);
        int i2 = 2;
        int[] planeData3 = create.getPlaneData(2);
        int macroblockCount = VP8Util.getMacroblockCount(this.width);
        int macroblockCount2 = VP8Util.getMacroblockCount(this.height);
        int i3 = macroblockCount * 16;
        int i4 = macroblockCount * 8;
        int i5 = 0;
        while (i5 < macroblockCount2) {
            VP8Decoder vP8Decoder;
            int i6;
            int i7;
            int[] iArr;
            int i8 = i;
            while (i8 < macroblockCount) {
                int i9;
                int i10;
                int i11 = i8 + 1;
                Macroblock macroblock = vP8Decoder.mbs[i5 + 1][i11];
                int i12 = i;
                while (true) {
                    i = 4;
                    if (i12 >= 4) {
                        break;
                    }
                    i2 = 0;
                    while (i2 < i) {
                        i9 = 0;
                        while (i9 < i) {
                            i6 = macroblockCount;
                            macroblockCount = 0;
                            while (macroblockCount < i) {
                                i = ((i5 << 4) + (i12 << 2)) + i9;
                                i7 = macroblockCount2;
                                macroblockCount2 = ((i8 << 4) + (i2 << 2)) + macroblockCount;
                                if (macroblockCount2 < i3) {
                                    i10 = i11;
                                    if (i < planeData.length / i3) {
                                        planeData[(i * i3) + macroblockCount2] = macroblock.ySubblocks[i12][i2].val[(i9 * 4) + macroblockCount];
                                    }
                                } else {
                                    i10 = i11;
                                }
                                macroblockCount++;
                                macroblockCount2 = i7;
                                i11 = i10;
                                i = 4;
                            }
                            i7 = macroblockCount2;
                            i10 = i11;
                            i9++;
                            macroblockCount = i6;
                            i = 4;
                        }
                        i6 = macroblockCount;
                        i7 = macroblockCount2;
                        i10 = i11;
                        i2++;
                        vP8Decoder = this;
                        i = 4;
                    }
                    i6 = macroblockCount;
                    i7 = macroblockCount2;
                    i10 = i11;
                    i12++;
                    vP8Decoder = this;
                    i2 = 2;
                }
                i6 = macroblockCount;
                i7 = macroblockCount2;
                i10 = i11;
                i = i2;
                i9 = 0;
                while (i9 < i) {
                    i2 = 0;
                    while (i2 < i) {
                        macroblockCount = 0;
                        while (true) {
                            macroblockCount2 = 4;
                            if (macroblockCount >= 4) {
                                break;
                            }
                            i11 = 0;
                            while (i11 < macroblockCount2) {
                                i12 = ((i5 << 3) + (i9 << 2)) + macroblockCount;
                                i = ((i8 << 3) + (i2 << 2)) + i11;
                                if (i >= i4 || i12 >= planeData2.length / i4) {
                                    iArr = planeData;
                                } else {
                                    int i13 = (macroblockCount * 4) + i11;
                                    macroblockCount2 = macroblock.uSubblocks[i9][i2].val[i13];
                                    iArr = planeData;
                                    int i14 = macroblock.vSubblocks[i9][i2].val[i13];
                                    i12 = (i12 * i4) + i;
                                    planeData2[i12] = macroblockCount2;
                                    planeData3[i12] = i14;
                                }
                                i11++;
                                planeData = iArr;
                                macroblockCount2 = 4;
                            }
                            iArr = planeData;
                            macroblockCount++;
                        }
                        iArr = planeData;
                        i2++;
                        i = 2;
                    }
                    iArr = planeData;
                    i9++;
                    i = 2;
                }
                i2 = i;
                macroblockCount = i6;
                macroblockCount2 = i7;
                i8 = i10;
                vP8Decoder = this;
                i = 0;
            }
            iArr = planeData;
            i6 = macroblockCount;
            i7 = macroblockCount2;
            i5++;
            vP8Decoder = this;
            i = 0;
            i2 = 2;
        }
        return create;
    }

    public static String printHexByte(byte b) {
        StringBuilder stringBuilder = new StringBuilder("0x");
        stringBuilder.append(Integer.toHexString(b & 255));
        return stringBuilder.toString();
    }
}
