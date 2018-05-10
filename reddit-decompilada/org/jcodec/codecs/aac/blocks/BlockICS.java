package org.jcodec.codecs.aac.blocks;

import java.io.PrintStream;
import java.lang.reflect.Array;
import org.jcodec.codecs.aac.Profile;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;
import org.jcodec.common.tools.MathUtil;

public class BlockICS extends Block {
    private static final int MAX_LTP_LONG_SFB = 40;
    private static final int POW_SF2_ZERO = 200;
    static float[] ff_aac_pow2sf_tab = new float[428];
    private static VLC[] spectral;
    private static VLC vlc = new VLC(AACTab.ff_aac_scalefactor_code, AACTab.ff_aac_scalefactor_bits);
    private int[] band_type = new int[120];
    private int[] band_type_run_end = new int[120];
    private boolean commonWindow;
    float[][] ff_aac_codebook_vector_vals = new float[][]{AACTab.codebook_vector0_vals, AACTab.codebook_vector0_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector4_vals, AACTab.codebook_vector4_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector10_vals, AACTab.codebook_vector10_vals};
    private int globalGain;
    private int[] group_len = new int[8];
    int maxSfb;
    private int numSwb;
    private int numWindows;
    int num_window_groups;
    private Profile profile;
    private int samplingIndex;
    private boolean scaleFlag;
    private double[] sfs;
    private int[] swbOffset;
    private int windowSequence;

    enum BandType {
        ZERO_BT,
        BT_1,
        BT_2,
        BT_3,
        BT_4,
        FIRST_PAIR_BT,
        BT_6,
        BT_7,
        BT_8,
        BT_9,
        BT_10,
        ESC_BT,
        BT_12,
        NOISE_BT,
        INTENSITY_BT2,
        INTENSITY_BT
    }

    public static class Pulse {
        private int[] amp;
        private int numPulse;
        private int[] pos;

        public Pulse(int i, int[] iArr, int[] iArr2) {
            this.numPulse = i;
            this.pos = iArr;
            this.amp = iArr2;
        }

        public int getNumPulse() {
            return this.numPulse;
        }

        public int[] getPos() {
            return this.pos;
        }

        public int[] getAmp() {
            return this.amp;
        }
    }

    public static class Tns {
        private float[][][] coeff;
        private int[][] direction;
        private int[][] length;
        private int[] nFilt;
        private int[][] order;

        public Tns(int[] iArr, int[][] iArr2, int[][] iArr3, int[][] iArr4, float[][][] fArr) {
            this.nFilt = iArr;
            this.length = iArr2;
            this.order = iArr3;
            this.direction = iArr4;
            this.coeff = fArr;
        }
    }

    private enum WindowSequence {
        ONLY_LONG_SEQUENCE,
        LONG_START_SEQUENCE,
        EIGHT_SHORT_SEQUENCE,
        LONG_STOP_SEQUENCE
    }

    private void readOther(org.jcodec.common.io.BitReader r1, float[] r2, int r3, int r4, int r5, float[] r6, org.jcodec.common.io.VLC r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: org.jcodec.codecs.aac.blocks.BlockICS.readOther(org.jcodec.common.io.BitReader, float[], int, int, int, float[], org.jcodec.common.io.VLC):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.aac.blocks.BlockICS.readOther(org.jcodec.common.io.BitReader, float[], int, int, int, float[], org.jcodec.common.io.VLC):void");
    }

    static {
        r0 = new VLC[11];
        int i = 0;
        r0[0] = new VLCBuilder(AACTab.codes1, AACTab.bits1, AACTab.codebook_vector02_idx).getVLC();
        r0[1] = new VLCBuilder(AACTab.codes2, AACTab.bits2, AACTab.codebook_vector02_idx).getVLC();
        r0[2] = new VLCBuilder(AACTab.codes3, AACTab.bits3, AACTab.codebook_vector02_idx).getVLC();
        r0[3] = new VLCBuilder(AACTab.codes4, AACTab.bits4, AACTab.codebook_vector02_idx).getVLC();
        r0[4] = new VLCBuilder(AACTab.codes5, AACTab.bits5, AACTab.codebook_vector4_idx).getVLC();
        r0[5] = new VLCBuilder(AACTab.codes6, AACTab.bits6, AACTab.codebook_vector4_idx).getVLC();
        r0[6] = new VLCBuilder(AACTab.codes7, AACTab.bits7, AACTab.codebook_vector6_idx).getVLC();
        r0[7] = new VLCBuilder(AACTab.codes8, AACTab.bits8, AACTab.codebook_vector6_idx).getVLC();
        r0[8] = new VLCBuilder(AACTab.codes9, AACTab.bits9, AACTab.codebook_vector8_idx).getVLC();
        r0[9] = new VLCBuilder(AACTab.codes10, AACTab.bits10, AACTab.codebook_vector8_idx).getVLC();
        r0[10] = new VLCBuilder(AACTab.codes11, AACTab.bits11, AACTab.codebook_vector10_idx).getVLC();
        spectral = r0;
        while (i < 428) {
            ff_aac_pow2sf_tab[i] = (float) Math.pow(2.0d, ((double) (i - 200)) / 4.0d);
            i++;
        }
    }

    protected int parseICSInfo(BitReader bitReader) {
        bitReader.read1Bit();
        this.windowSequence = bitReader.readNBit(2);
        bitReader.read1Bit();
        this.num_window_groups = 1;
        this.group_len[0] = 1;
        if (this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()) {
            bitReader.readNBit(4);
            for (int i = 0; i < 7; i++) {
                if (bitReader.read1Bit() != 0) {
                    int[] iArr = this.group_len;
                    int i2 = this.num_window_groups - 1;
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    this.num_window_groups++;
                    this.group_len[this.num_window_groups - 1] = 1;
                }
            }
            this.numSwb = AACTab.ff_aac_num_swb_128[this.samplingIndex];
            this.swbOffset = AACTab.ff_swb_offset_128[this.samplingIndex];
            this.numWindows = 8;
        } else {
            this.maxSfb = bitReader.readNBit(6);
            this.numSwb = AACTab.ff_aac_num_swb_1024[this.samplingIndex];
            this.swbOffset = AACTab.ff_swb_offset_1024[this.samplingIndex];
            this.numWindows = 1;
            if (bitReader.read1Bit() != 0) {
                if (this.profile == Profile.MAIN) {
                    decodePrediction(bitReader, this.maxSfb);
                } else if (this.profile == Profile.LC) {
                    throw new RuntimeException("Prediction is not allowed in AAC-LC.\n");
                } else if (bitReader.read1Bit() != 0) {
                    decodeLtp(bitReader, this.maxSfb);
                }
            }
        }
        return 0;
    }

    private void decodePrediction(BitReader bitReader, int i) {
        if (bitReader.read1Bit() != 0) {
            bitReader.readNBit(5);
        }
        for (int i2 = 0; i2 < Math.min(i, AACTab.maxSfbTab[this.samplingIndex]); i2++) {
            bitReader.read1Bit();
        }
    }

    private void decodeLtp(BitReader bitReader, int i) {
        bitReader.readNBit(11);
        float[] fArr = AACTab.ltpCoefTab;
        bitReader.readNBit(3);
        for (int i2 = 0; i2 < Math.min(i, 40); i2++) {
            bitReader.read1Bit();
        }
    }

    private void decodeBandTypes(BitReader bitReader) {
        int i = this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal() ? 3 : 5;
        int i2 = 0;
        int i3 = i2;
        while (i2 < this.num_window_groups) {
            int i4 = i3;
            i3 = 0;
            while (i3 < this.maxSfb) {
                int readNBit = bitReader.readNBit(4);
                if (readNBit == 12) {
                    throw new RuntimeException("invalid band type");
                }
                int readNBit2;
                int i5 = i3;
                while (true) {
                    readNBit2 = bitReader.readNBit(i);
                    int i6 = (1 << i) - 1;
                    if (readNBit2 != i6) {
                        break;
                    }
                    i5 += readNBit2;
                }
                i5 += readNBit2;
                if (bitReader.moreData()) {
                    if (readNBit2 != i6) {
                        if (i5 > this.maxSfb) {
                            throw new RuntimeException(String.format("Number of bands (%d) exceeds limit (%d).\n", new Object[]{Integer.valueOf(i5), Integer.valueOf(this.maxSfb)}));
                        }
                        while (i3 < i5) {
                            this.band_type[i4] = readNBit;
                            int i7 = i4 + 1;
                            this.band_type_run_end[i4] = i5;
                            i3++;
                            i4 = i7;
                        }
                    }
                }
                throw new RuntimeException("Overread");
            }
            i2++;
            i3 = i4;
        }
    }

    private void decodeScalefactors(BitReader bitReader) {
        BitReader bitReader2 = bitReader;
        r2 = new int[3];
        int i = 1;
        r2[1] = this.globalGain - 90;
        int i2 = 2;
        r2[2] = 0;
        String[] strArr = new String[]{"Global gain", "Noise gain", "Intensity stereo position"};
        int i3 = 0;
        int i4 = i3;
        int i5 = 1;
        while (i3 < r0.num_window_groups) {
            int i6;
            int i7 = i5;
            i5 = i4;
            i4 = 0;
            while (i4 < r0.maxSfb) {
                int i8 = r0.band_type_run_end[i5];
                if (r0.band_type[i5] == BandType.ZERO_BT.ordinal()) {
                    while (i4 < i8) {
                        r0.sfs[i5] = 0.0d;
                        i4++;
                        i5++;
                    }
                } else {
                    int i9;
                    PrintStream printStream;
                    int i10 = 100;
                    if (r0.band_type[i5] != BandType.INTENSITY_BT.ordinal()) {
                        if (r0.band_type[i5] != BandType.INTENSITY_BT2.ordinal()) {
                            if (r0.band_type[i5] == BandType.NOISE_BT.ordinal()) {
                                while (i4 < i8) {
                                    i9 = i7 - 1;
                                    if (i7 > 0) {
                                        r2[i] = r2[i] + (bitReader2.readNBit(9) - 256);
                                    } else {
                                        r2[i] = r2[i] + (vlc.readVLC(bitReader2) - 60);
                                    }
                                    i7 = MathUtil.clip(r2[i], -100, 155);
                                    if (r2[i] != i7) {
                                        printStream = System.out;
                                        Object[] objArr = new Object[i2];
                                        objArr[0] = Integer.valueOf(r2[i]);
                                        objArr[i] = Integer.valueOf(i7);
                                        printStream.println(String.format("Noise gain clipped (%d -> %d).\nIf you heard an audible artifact, there may be a bug in the decoder. ", objArr));
                                    }
                                    r0.sfs[i5] = (double) (-ff_aac_pow2sf_tab[i7 + 200]);
                                    i4++;
                                    i5++;
                                    i7 = i9;
                                    i2 = 2;
                                }
                            } else {
                                while (i4 < i8) {
                                    r2[0] = r2[0] + (vlc.readVLC(bitReader2) - 60);
                                    if (r2[0] > 255) {
                                        throw new RuntimeException(String.format("%s (%d) out of range.\n", new Object[]{strArr[0], Integer.valueOf(r2[0])}));
                                    }
                                    r0.sfs[i5] = (double) (-ff_aac_pow2sf_tab[(r2[0] - 100) + 200]);
                                    i4++;
                                    i5++;
                                }
                                i6 = i;
                                i2 = 2;
                                i = i6;
                            }
                        }
                    }
                    while (i4 < i8) {
                        r2[2] = r2[2] + (vlc.readVLC(bitReader2) - 60);
                        i9 = MathUtil.clip(r2[2], -155, i10);
                        if (r2[2] != i9) {
                            printStream = System.out;
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(r2[2]);
                            i6 = 1;
                            objArr2[1] = Integer.valueOf(i9);
                            printStream.println(String.format("Intensity stereo position clipped (%d -> %d).\nIf you heard an audible artifact, there may be a bug in the decoder. ", objArr2));
                        } else {
                            i6 = i;
                        }
                        r0.sfs[i5] = (double) ff_aac_pow2sf_tab[(-i9) + 200];
                        i4++;
                        i5++;
                        i = i6;
                        i10 = 100;
                    }
                    i6 = i;
                    i2 = 2;
                    i = i6;
                }
                i6 = i;
                i = i6;
            }
            i6 = i;
            i3++;
            i4 = i5;
            i5 = i7;
        }
    }

    private Pulse decodePulses(BitReader bitReader) {
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int i = 1;
        int readNBit = bitReader.readNBit(2) + 1;
        int readNBit2 = bitReader.readNBit(6);
        if (readNBit2 >= this.numSwb) {
            throw new RuntimeException("pulseSwb >= numSwb");
        }
        iArr[0] = this.swbOffset[readNBit2];
        iArr[0] = iArr[0] + bitReader.readNBit(5);
        if (iArr[0] > 1023) {
            throw new RuntimeException("pos[0] > 1023");
        }
        iArr2[0] = bitReader.readNBit(4);
        while (i < readNBit) {
            iArr[i] = bitReader.readNBit(5) + iArr[i - 1];
            if (iArr[i] > 1023) {
                StringBuilder stringBuilder = new StringBuilder("pos[");
                stringBuilder.append(i);
                stringBuilder.append("] > 1023");
                throw new RuntimeException(stringBuilder.toString());
            }
            iArr2[i] = bitReader.readNBit(5);
            i++;
        }
        return new Pulse(readNBit, iArr, iArr2);
    }

    private Tns decodeTns(BitReader bitReader) {
        BlockICS blockICS;
        BitReader bitReader2 = bitReader;
        int i = 1;
        int i2 = this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal() ? 1 : 0;
        int i3 = i2 != 0 ? 7 : blockICS.profile == Profile.MAIN ? 20 : 12;
        int[] iArr = new int[blockICS.numWindows];
        int i4 = 2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{blockICS.numWindows, 2});
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{blockICS.numWindows, 2});
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{blockICS.numWindows, 2});
        int i5 = 2 * i2;
        int i6 = 5 - i5;
        float[][][] fArr = (float[][][]) Array.newInstance(float.class, new int[]{blockICS.numWindows, 2, 1 << i6});
        int i7 = 0;
        while (i7 < blockICS.numWindows) {
            int i8;
            int i9;
            int i10;
            int readNBit = bitReader2.readNBit(2 - i2);
            iArr[i7] = readNBit;
            if (readNBit != 0) {
                readNBit = bitReader.read1Bit();
                i = 0;
                while (i < iArr[i7]) {
                    iArr2[i7][i] = bitReader2.readNBit(6 - i5);
                    int[] iArr5 = iArr3[i7];
                    i4 = bitReader2.readNBit(i6);
                    iArr5[i] = i4;
                    if (i4 > i3) {
                        throw new RuntimeException(String.format("TNS filter order %d is greater than maximum %d.\n", new Object[]{Integer.valueOf(iArr3[i7][i]), Integer.valueOf(i3)}));
                    }
                    if (iArr3[i7][i] != 0) {
                        iArr4[i7][i] = bitReader.read1Bit();
                        int read1Bit = bitReader.read1Bit();
                        i4 = (readNBit + 3) - read1Bit;
                        i8 = 2;
                        read1Bit = (read1Bit * 2) + readNBit;
                        int i11 = 0;
                        while (true) {
                            i9 = i2;
                            if (i11 >= iArr3[i7][i]) {
                                break;
                            }
                            fArr[i7][i][i11] = AACTab.tns_tmp2_map[read1Bit][bitReader2.readNBit(i4)];
                            i11++;
                            i2 = i9;
                        }
                    } else {
                        i9 = i2;
                        i8 = 2;
                    }
                    i++;
                    i4 = i8;
                    i2 = i9;
                    blockICS = this;
                }
                i9 = i2;
                i8 = i4;
                i10 = 1;
            } else {
                i9 = i2;
                i10 = i;
                i8 = i4;
            }
            i7++;
            i = i10;
            i4 = i8;
            i2 = i9;
            blockICS = this;
        }
        return new Tns(iArr, iArr2, iArr3, iArr4, fArr);
    }

    void VMUL4(float[] fArr, int i, float[] fArr2, int i2, float f) {
        fArr[i] = fArr2[i2 & 3] * f;
        fArr[i + 1] = fArr2[(i2 >> 2) & 3] * f;
        fArr[i + 2] = fArr2[(i2 >> 4) & 3] * f;
        fArr[i + 3] = fArr2[(i2 >> 6) & 3] * f;
    }

    void VMUL4S(float[] fArr, int i, float[] fArr2, int i2, int i3, float f) {
        fArr[i + 0] = fArr2[i & 3] * f;
        fArr[i + 1] = fArr2[(i >> 2) & 3] * f;
        fArr[i + 2] = fArr2[(i >> 4) & 3] * f;
        fArr[i + 3] = fArr2[(i >> 6) & 3] * f;
    }

    void VMUL2(float[] fArr, int i, float[] fArr2, int i2, float f) {
        fArr[i] = fArr2[i2 & 15] * f;
        fArr[i + 1] = fArr2[(i2 >> 4) & 15] * f;
    }

    void VMUL2S(float[] fArr, int i, float[] fArr2, int i2, int i3, float f) {
        fArr[i] = fArr2[i2 & 15] * f;
        fArr[i + 1] = fArr2[(i2 >> 4) & 15] * f;
    }

    private void decodeSpectrum(BitReader bitReader) {
        float[] fArr = new float[1024];
        int i = 0;
        int i2 = i;
        while (i2 < this.num_window_groups) {
            int i3 = i;
            int i4 = 0;
            while (i4 < this.maxSfb) {
                i = this.band_type[i3] - 1;
                if (i < BandType.INTENSITY_BT2.ordinal() - 1 && i != BandType.NOISE_BT.ordinal() - 1) {
                    float[] fArr2 = this.ff_aac_codebook_vector_vals[i];
                    VLC vlc = spectral[i];
                    switch (i >> 1) {
                        case 0:
                            readBandType1And2(bitReader, fArr, i3, i2, i4, fArr2, vlc);
                            break;
                        case 1:
                            readBandType3And4(bitReader, fArr, i3, i2, i4, fArr2, vlc);
                            break;
                        case 2:
                            readBandType5And6(bitReader, fArr, i3, i2, i4, fArr2, vlc);
                            break;
                        case 3:
                        case 4:
                            readBandType7Through10(bitReader, fArr, i3, i2, i4, fArr2, vlc);
                            break;
                        default:
                            readOther(bitReader, fArr, i3, i2, i4, fArr2, vlc);
                            break;
                    }
                }
                i4++;
                i3++;
            }
            i2++;
            i = i3;
        }
    }

    private void readBandType3And4(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc) {
        BitReader bitReader2 = bitReader;
        int i4 = this.group_len[i2];
        int i5 = this.swbOffset[i3 + 1] - this.swbOffset[i3];
        int i6 = this.swbOffset[i3];
        int i7 = 0;
        while (i7 < i4) {
            VLC vlc2 = vlc;
            int i8 = i5;
            int i9 = i6;
            do {
                int i10;
                int readVLC = vlc2.readVLC(bitReader2);
                int i11 = (readVLC >> 8) & 15;
                if (i11 == 0) {
                    i10 = 0;
                } else {
                    i10 = bitReader2.readNBit(i11);
                }
                VMUL4S(fArr, i9, fArr2, readVLC, i10, (float) r7.sfs[i]);
                i9 += 4;
                i8 -= 4;
            } while (i8 > 0);
            i7++;
            i6 += 128;
        }
    }

    private void readBandType7Through10(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc) {
        BitReader bitReader2 = bitReader;
        int i4 = this.group_len[i2];
        int i5 = this.swbOffset[i3 + 1] - this.swbOffset[i3];
        int i6 = this.swbOffset[i3];
        int i7 = 0;
        while (i7 < i4) {
            VLC vlc2 = vlc;
            int i8 = i5;
            int i9 = i6;
            do {
                int i10;
                int readVLC = vlc2.readVLC(bitReader2);
                int i11 = (readVLC >> 8) & 15;
                if (i11 == 0) {
                    i10 = 0;
                } else {
                    i10 = bitReader2.readNBit(i11) << (readVLC >> 12);
                }
                VMUL2S(fArr, i9, fArr2, readVLC, i10, (float) r7.sfs[i]);
                i9 += 2;
                i8 -= 2;
            } while (i8 > 0);
            i7++;
            i6 += 128;
        }
    }

    private void readBandType1And2(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc) {
        int i4 = this.group_len[i2];
        int i5 = this.swbOffset[i3 + 1] - this.swbOffset[i3];
        int i6 = 0;
        int i7 = this.swbOffset[i3];
        while (i6 < i4) {
            BitReader bitReader2 = bitReader;
            VLC vlc2 = vlc;
            int i8 = i5;
            int i9 = i7;
            do {
                VMUL4(fArr, i9, fArr2, vlc2.readVLC(bitReader2), (float) r6.sfs[i]);
                i9 += 4;
                i8 -= 4;
            } while (i8 > 0);
            i6++;
            i7 += 128;
        }
    }

    private void readBandType5And6(BitReader bitReader, float[] fArr, int i, int i2, int i3, float[] fArr2, VLC vlc) {
        int i4 = this.group_len[i2];
        int i5 = this.swbOffset[i3 + 1] - this.swbOffset[i3];
        int i6 = 0;
        int i7 = this.swbOffset[i3];
        while (i6 < i4) {
            BitReader bitReader2 = bitReader;
            VLC vlc2 = vlc;
            int i8 = i5;
            int i9 = i7;
            do {
                VMUL2(fArr, i9, fArr2, vlc2.readVLC(bitReader2), (float) r6.sfs[i]);
                i9 += 2;
                i8 -= 2;
            } while (i8 > 0);
            i6++;
            i7 += 128;
        }
    }

    public void parse(BitReader bitReader) {
        this.globalGain = bitReader.readNBit(8);
        if (!(this.commonWindow || this.scaleFlag)) {
            parseICSInfo(bitReader);
        }
        decodeBandTypes(bitReader);
        decodeScalefactors(bitReader);
        if (!this.scaleFlag) {
            if (bitReader.read1Bit() != 0) {
                if (this.windowSequence == WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()) {
                    throw new RuntimeException("Pulse tool not allowed in eight short sequence.");
                }
                decodePulses(bitReader);
            }
            if (bitReader.read1Bit() != 0) {
                decodeTns(bitReader);
            }
            if (bitReader.read1Bit() != 0) {
                throw new RuntimeException("SSR is not supported");
            }
        }
        decodeSpectrum(bitReader);
    }
}
