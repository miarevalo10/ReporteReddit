package org.jcodec.codecs.mpeg12;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.bitstream.SequenceScalableExtension;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;

public class MPEGConst {
    public static int[] BLOCK_POS_X = new int[]{0, 8, 0, 8, 0, 0, 0, 0, 8, 8, 8, 8, 0, 0, 0, 0, 0, 8, 0, 8, 0, 0, 0, 0, 8, 8, 8, 8};
    public static int[] BLOCK_POS_Y = new int[]{0, 0, 8, 8, 0, 0, 8, 8, 0, 0, 8, 8, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    public static int[] BLOCK_TO_CC = new int[]{0, 0, 0, 0, 1, 2, 1, 2, 1, 2, 1, 2};
    public static final int CODE_END = 2048;
    public static final int CODE_ESCAPE = 2049;
    public static final int EXTENSION_START_CODE = 181;
    public static final int GROUP_START_CODE = 184;
    public static final int PICTURE_START_CODE = 0;
    public static final int SEQUENCE_END_CODE = 183;
    public static final int SEQUENCE_ERROR_CODE = 180;
    public static final int SEQUENCE_HEADER_CODE = 179;
    public static final int SLICE_START_CODE_FIRST = 1;
    public static final int SLICE_START_CODE_LAST = 175;
    public static int[] SQUEEZE_X = new int[]{0, 1, 1, 0};
    public static int[] SQUEEZE_Y = new int[]{0, 1, 0, 0};
    public static int[] STEP_Y = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public static final int USER_DATA_START_CODE = 178;
    public static int[] defaultQMatInter = new int[]{16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};
    public static int[] defaultQMatIntra = new int[]{8, 16, 19, 22, 26, 27, 29, 34, 16, 16, 22, 24, 27, 29, 34, 37, 19, 22, 26, 27, 29, 34, 34, 38, 22, 22, 26, 27, 29, 34, 37, 40, 22, 26, 27, 29, 32, 35, 40, 48, 26, 27, 29, 32, 35, 40, 48, 58, 26, 27, 29, 34, 38, 46, 56, 69, 27, 29, 35, 38, 46, 56, 69, 83};
    public static MBType[] mbTypeValB = new MBType[]{new MBType(0, 1, 1, 0, 0, 0, 0), new MBType(0, 1, 1, 1, 0, 0, 0), new MBType(0, 0, 1, 0, 0, 0, 0), new MBType(0, 0, 1, 1, 0, 0, 0), new MBType(0, 1, 0, 0, 0, 0, 0), new MBType(0, 1, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 1, 1, 1, 0, 0, 0), new MBType(1, 1, 0, 1, 0, 0, 0), new MBType(1, 0, 1, 1, 0, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0)};
    public static MBType[] mbTypeValBSpat = new MBType[]{new MBType(0, 1, 1, 0, 0, 0, 0), new MBType(0, 1, 1, 1, 0, 0, 0), new MBType(0, 0, 1, 0, 0, 0, 0), new MBType(0, 0, 1, 1, 0, 0, 0), new MBType(0, 1, 0, 0, 0, 0, 0), new MBType(0, 1, 0, 1, 0, 0, 0), new MBType(0, 0, 1, 0, 0, 1, 0), new MBType(0, 0, 1, 1, 0, 1, 0), new MBType(0, 1, 0, 0, 0, 1, 0), new MBType(0, 1, 0, 1, 0, 1, 0), new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 1, 1, 1, 0, 0, 0), new MBType(1, 1, 0, 1, 0, 0, 0), new MBType(1, 0, 1, 1, 0, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0), new MBType(1, 1, 0, 1, 0, 1, 0), new MBType(1, 0, 1, 1, 0, 1, 0), new MBType(0, 0, 0, 0, 0, 0, 0), new MBType(1, 0, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 1, 0, 0, 0)};
    public static MBType[] mbTypeValI = new MBType[]{new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0)};
    public static MBType[] mbTypeValISpat = new MBType[]{new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0), new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0), new MBType(0, 0, 0, 0, 0, 0, 0)};
    public static MBType[] mbTypeValP = new MBType[]{new MBType(0, 1, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 1, 0, 0, 0), new MBType(0, 1, 0, 0, 0, 0, 0), new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(1, 1, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0)};
    public static MBType[] mbTypeValPSpat = new MBType[]{new MBType(0, 1, 0, 1, 0, 0, 0), new MBType(0, 1, 0, 1, 0, 1, 0), new MBType(0, 0, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 1, 0, 1, 0), new MBType(0, 1, 0, 0, 0, 0, 0), new MBType(0, 0, 0, 0, 1, 0, 0), new MBType(0, 1, 0, 0, 0, 1, 0), new MBType(1, 1, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 0, 1, 0, 0), new MBType(1, 1, 0, 1, 0, 1, 0), new MBType(1, 0, 0, 1, 0, 1, 0), new MBType(0, 0, 0, 0, 0, 1, 0), new MBType(0, 0, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 0, 0, 0, 0)};
    public static MBType[] mbTypeValSNR = new MBType[]{new MBType(0, 0, 0, 1, 0, 0, 0), new MBType(1, 0, 0, 1, 0, 0, 0), new MBType(0, 0, 0, 0, 0, 0, 0)};
    public static int[] qScaleTab1 = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62};
    public static int[] qScaleTab2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 18, 20, 22, 24, 28, 32, 36, 40, 44, 48, 52, 56, 64, 72, 80, 88, 96, 104, 112};
    public static int[][] scan = new int[][]{new int[]{0, 1, 8, 16, 9, 2, 3, 10, 17, 24, 32, 25, 18, 11, 4, 5, 12, 19, 26, 33, 40, 48, 41, 34, 27, 20, 13, 6, 7, 14, 21, 28, 35, 42, 49, 56, 57, 50, 43, 36, 29, 22, 15, 23, 30, 37, 44, 51, 58, 59, 52, 45, 38, 31, 39, 46, 53, 60, 61, 54, 47, 55, 62, 63}, new int[]{0, 8, 16, 24, 1, 9, 2, 10, 17, 25, 32, 40, 48, 56, 57, 49, 41, 33, 26, 18, 3, 11, 4, 12, 19, 27, 34, 42, 50, 58, 35, 43, 51, 59, 20, 28, 5, 13, 6, 14, 21, 29, 36, 44, 52, 60, 37, 45, 53, 61, 22, 30, 7, 15, 23, 31, 38, 46, 54, 62, 39, 47, 55, 63}};
    public static VLC vlcAddressIncrement = new VLC("1", "011", "010", "0011", "0010", "00011", "00010", "0000111", "0000110", "00001011", "00001010", "00001001", "00001000", "00000111", "00000110", "0000010111", "0000010110", "0000010101", "0000010100", "0000010011", "0000010010", "00000100011", "00000100010", "00000100001", "00000100000", "00000011111", "00000011110", "00000011101", "00000011100", "00000011011", "00000011010", "00000011001", "00000011000");
    public static VLC vlcCBP = new VLC("000000001", "01011", "01001", "001101", "1101", "0010111", "0010011", "00011111", "1100", "0010110", "0010010", "00011110", "10011", "00011011", "00010111", "00010011", "1011", "0010101", "0010001", "00011101", "10001", "00011001", "00010101", "00010001", "001111", "00001111", "00001101", "000000011", "01111", "00001011", "00000111", "000000111", "1010", "0010100", "0010000", "00011100", "001110", "00001110", "00001100", "000000010", "10000", "00011000", "00010100", "00010000", "01110", "00001010", "00000110", "000000110", "10010", "00011010", "00010110", "00010010", "01101", "00001001", "00000101", "000000101", "01100", "00001000", "00000100", "000000100", "111", "01010", "01000", "001100");
    public static VLC vlcCoeff0;
    public static VLC vlcCoeff1;
    public static VLC vlcDCSizeChroma = new VLC("00", "01", "10", "110", "1110", "11110", "111110", "1111110", "11111110", "111111110", "1111111110", "1111111111");
    public static VLC vlcDCSizeLuma = new VLC("100", "00", "01", "101", "110", "1110", "11110", "111110", "1111110", "11111110", "111111110", "111111111");
    public static VLC vlcDualPrime = new VLC("11", "0", "10");
    public static VLC vlcMBTypeB = new VLC("10", "11", "010", "011", "0010", "0011", "00011", "00010", "000011", "000010", "000001");
    public static VLC vlcMBTypeBSpat = new VLC("10", "11", "010", "011", "0010", "0011", "000110", "000111", "000100", "000101", "0000110", "0000111", "0000100", "0000101", "00000100", "00000101", "000001100", "000001110", "000001101", "000001111");
    public static VLC vlcMBTypeI = new VLC("1", "01");
    public static VLC vlcMBTypeISpat = new VLC("1", "01", "0011", "0010", "0001");
    public static VLC vlcMBTypeP = new VLC("1", "01", "001", "00011", "00010", "00001", "000001");
    public static VLC vlcMBTypePSpat = new VLC("10", "011", "0000100", "000111", "0010", "0000111", "0011", "010", "000100", "0000110", "11", "000101", "000110", "0000101", "0000010", "0000011");
    public static VLC vlcMBTypeSNR = new VLC("1", "01", "001");
    public static VLC vlcMotionCode = new VLC("1", "01", "001", "0001", "000011", "0000101", "0000100", "0000011", "000001011", "000001010", "000001001", "0000010001", "0000010000", "0000001111", "0000001110", "0000001101", "0000001100");

    public static class MBType {
        public int macroblock_intra;
        public int macroblock_motion_backward;
        public int macroblock_motion_forward;
        public int macroblock_pattern;
        public int macroblock_quant;
        public int permitted_spatial_temporal_weight_classes;
        public int spatial_temporal_weight_code_flag;

        private MBType(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.macroblock_quant = i;
            this.macroblock_motion_forward = i2;
            this.macroblock_motion_backward = i3;
            this.macroblock_pattern = i4;
            this.macroblock_intra = i5;
            this.spatial_temporal_weight_code_flag = i6;
            this.permitted_spatial_temporal_weight_classes = i7;
        }
    }

    static {
        VLCBuilder vLCBuilder = new VLCBuilder();
        vLCBuilder.set(CODE_ESCAPE, "000001");
        vLCBuilder.set(CODE_END, "10");
        vLCBuilder.set(1, "11");
        vLCBuilder.set(65, "011");
        vLCBuilder.set(2, "0100");
        vLCBuilder.set(129, "0101");
        vLCBuilder.set(3, "00101");
        vLCBuilder.set(JpegConst.SOF1, "00111");
        vLCBuilder.set(257, "00110");
        vLCBuilder.set(66, "000110");
        vLCBuilder.set(321, "000111");
        vLCBuilder.set(385, "000101");
        vLCBuilder.set(449, "000100");
        vLCBuilder.set(4, "0000110");
        vLCBuilder.set(130, "0000100");
        vLCBuilder.set(513, "0000111");
        vLCBuilder.set(577, "0000101");
        vLCBuilder.set(5, "00100110");
        vLCBuilder.set(6, "00100001");
        vLCBuilder.set(67, "00100101");
        vLCBuilder.set(JpegConst.SOF2, "00100100");
        vLCBuilder.set(641, "00100111");
        vLCBuilder.set(705, "00100011");
        vLCBuilder.set(769, "00100010");
        vLCBuilder.set(833, "00100000");
        vLCBuilder.set(7, "0000001010");
        vLCBuilder.set(68, "0000001100");
        vLCBuilder.set(131, "0000001011");
        vLCBuilder.set(258, "0000001111");
        vLCBuilder.set(322, "0000001001");
        vLCBuilder.set(897, "0000001110");
        vLCBuilder.set(961, "0000001101");
        vLCBuilder.set(1025, "0000001000");
        vLCBuilder.set(8, "000000011101");
        vLCBuilder.set(9, "000000011000");
        vLCBuilder.set(10, "000000010011");
        vLCBuilder.set(11, "000000010000");
        vLCBuilder.set(69, "000000011011");
        vLCBuilder.set(132, "000000010100");
        vLCBuilder.set(JpegConst.SOF3, "000000011100");
        vLCBuilder.set(259, "000000010010");
        vLCBuilder.set(386, "000000011110");
        vLCBuilder.set(450, "000000010101");
        vLCBuilder.set(514, "000000010001");
        vLCBuilder.set(1089, "000000011111");
        vLCBuilder.set(1153, "000000011010");
        vLCBuilder.set(1217, "000000011001");
        vLCBuilder.set(1281, "000000010111");
        vLCBuilder.set(1345, "000000010110");
        vLCBuilder.set(12, "0000000011010");
        vLCBuilder.set(13, "0000000011001");
        vLCBuilder.set(14, "0000000011000");
        vLCBuilder.set(15, "0000000010111");
        vLCBuilder.set(70, "0000000010110");
        vLCBuilder.set(71, "0000000010101");
        vLCBuilder.set(133, "0000000010100");
        vLCBuilder.set(JpegConst.DHT, "0000000010011");
        vLCBuilder.set(323, "0000000010010");
        vLCBuilder.set(578, "0000000010001");
        vLCBuilder.set(642, "0000000010000");
        vLCBuilder.set(1409, "0000000011111");
        vLCBuilder.set(1473, "0000000011110");
        vLCBuilder.set(1537, "0000000011101");
        vLCBuilder.set(1601, "0000000011100");
        vLCBuilder.set(1665, "0000000011011");
        vLCBuilder.set(16, "00000000011111");
        vLCBuilder.set(17, "00000000011110");
        vLCBuilder.set(18, "00000000011101");
        vLCBuilder.set(19, "00000000011100");
        vLCBuilder.set(20, "00000000011011");
        vLCBuilder.set(21, "00000000011010");
        vLCBuilder.set(22, "00000000011001");
        vLCBuilder.set(23, "00000000011000");
        vLCBuilder.set(24, "00000000010111");
        vLCBuilder.set(25, "00000000010110");
        vLCBuilder.set(26, "00000000010101");
        vLCBuilder.set(27, "00000000010100");
        vLCBuilder.set(28, "00000000010011");
        vLCBuilder.set(29, "00000000010010");
        vLCBuilder.set(30, "00000000010001");
        vLCBuilder.set(31, "00000000010000");
        vLCBuilder.set(32, "000000000011000");
        vLCBuilder.set(33, "000000000010111");
        vLCBuilder.set(34, "000000000010110");
        vLCBuilder.set(35, "000000000010101");
        vLCBuilder.set(36, "000000000010100");
        vLCBuilder.set(37, "000000000010011");
        vLCBuilder.set(38, "000000000010010");
        vLCBuilder.set(39, "000000000010001");
        vLCBuilder.set(40, "000000000010000");
        vLCBuilder.set(72, "000000000011111");
        vLCBuilder.set(73, "000000000011110");
        vLCBuilder.set(74, "000000000011101");
        vLCBuilder.set(75, "000000000011100");
        vLCBuilder.set(76, "000000000011011");
        vLCBuilder.set(77, "000000000011010");
        vLCBuilder.set(78, "000000000011001");
        vLCBuilder.set(79, "0000000000010011");
        vLCBuilder.set(80, "0000000000010010");
        vLCBuilder.set(81, "0000000000010001");
        vLCBuilder.set(82, "0000000000010000");
        vLCBuilder.set(387, "0000000000010100");
        vLCBuilder.set(706, "0000000000011010");
        vLCBuilder.set(770, "0000000000011001");
        vLCBuilder.set(834, "0000000000011000");
        vLCBuilder.set(898, "0000000000010111");
        vLCBuilder.set(962, "0000000000010110");
        vLCBuilder.set(1026, "0000000000010101");
        vLCBuilder.set(1729, "0000000000011111");
        vLCBuilder.set(1793, "0000000000011110");
        vLCBuilder.set(1857, "0000000000011101");
        vLCBuilder.set(1921, "0000000000011100");
        vLCBuilder.set(1985, "0000000000011011");
        vlcCoeff0 = vLCBuilder.getVLC();
        vLCBuilder = new VLCBuilder();
        vLCBuilder.set(CODE_ESCAPE, "000001");
        vLCBuilder.set(CODE_END, "0110");
        vLCBuilder.set(1, "10");
        vLCBuilder.set(65, "010");
        vLCBuilder.set(2, "110");
        vLCBuilder.set(129, "00101");
        vLCBuilder.set(3, "0111");
        vLCBuilder.set(JpegConst.SOF1, "00111");
        vLCBuilder.set(257, "000110");
        vLCBuilder.set(66, "00110");
        vLCBuilder.set(321, "000111");
        vLCBuilder.set(385, "0000110");
        vLCBuilder.set(449, "0000100");
        vLCBuilder.set(4, "11100");
        vLCBuilder.set(130, "0000111");
        vLCBuilder.set(513, "0000101");
        vLCBuilder.set(577, "1111000");
        vLCBuilder.set(5, "11101");
        vLCBuilder.set(6, "000101");
        vLCBuilder.set(67, "1111001");
        vLCBuilder.set(JpegConst.SOF2, "00100110");
        vLCBuilder.set(641, "1111010");
        vLCBuilder.set(705, "00100001");
        vLCBuilder.set(769, "00100101");
        vLCBuilder.set(833, "00100100");
        vLCBuilder.set(7, "000100");
        vLCBuilder.set(68, "00100111");
        vLCBuilder.set(131, "11111100");
        vLCBuilder.set(258, "11111101");
        vLCBuilder.set(322, "000000100");
        vLCBuilder.set(897, "000000101");
        vLCBuilder.set(961, "000000111");
        vLCBuilder.set(1025, "0000001101");
        vLCBuilder.set(8, "1111011");
        vLCBuilder.set(9, "1111100");
        vLCBuilder.set(10, "00100011");
        vLCBuilder.set(11, "00100010");
        vLCBuilder.set(69, "00100000");
        vLCBuilder.set(132, "0000001100");
        vLCBuilder.set(JpegConst.SOF3, "000000011100");
        vLCBuilder.set(259, "000000010010");
        vLCBuilder.set(386, "000000011110");
        vLCBuilder.set(450, "000000010101");
        vLCBuilder.set(514, "000000010001");
        vLCBuilder.set(1089, "000000011111");
        vLCBuilder.set(1153, "000000011010");
        vLCBuilder.set(1217, "000000011001");
        vLCBuilder.set(1281, "000000010111");
        vLCBuilder.set(1345, "000000010110");
        vLCBuilder.set(12, "11111010");
        vLCBuilder.set(13, "11111011");
        vLCBuilder.set(14, "11111110");
        vLCBuilder.set(15, "11111111");
        vLCBuilder.set(70, "0000000010110");
        vLCBuilder.set(71, "0000000010101");
        vLCBuilder.set(133, "0000000010100");
        vLCBuilder.set(JpegConst.DHT, "0000000010011");
        vLCBuilder.set(323, "0000000010010");
        vLCBuilder.set(578, "0000000010001");
        vLCBuilder.set(642, "0000000010000");
        vLCBuilder.set(1409, "0000000011111");
        vLCBuilder.set(1473, "0000000011110");
        vLCBuilder.set(1537, "0000000011101");
        vLCBuilder.set(1601, "0000000011100");
        vLCBuilder.set(1665, "0000000011011");
        vLCBuilder.set(16, "00000000011111");
        vLCBuilder.set(17, "00000000011110");
        vLCBuilder.set(18, "00000000011101");
        vLCBuilder.set(19, "00000000011100");
        vLCBuilder.set(20, "00000000011011");
        vLCBuilder.set(21, "00000000011010");
        vLCBuilder.set(22, "00000000011001");
        vLCBuilder.set(23, "00000000011000");
        vLCBuilder.set(24, "00000000010111");
        vLCBuilder.set(25, "00000000010110");
        vLCBuilder.set(26, "00000000010101");
        vLCBuilder.set(27, "00000000010100");
        vLCBuilder.set(28, "00000000010011");
        vLCBuilder.set(29, "00000000010010");
        vLCBuilder.set(30, "00000000010001");
        vLCBuilder.set(31, "00000000010000");
        vLCBuilder.set(32, "000000000011000");
        vLCBuilder.set(33, "000000000010111");
        vLCBuilder.set(34, "000000000010110");
        vLCBuilder.set(35, "000000000010101");
        vLCBuilder.set(36, "000000000010100");
        vLCBuilder.set(37, "000000000010011");
        vLCBuilder.set(38, "000000000010010");
        vLCBuilder.set(39, "000000000010001");
        vLCBuilder.set(40, "000000000010000");
        vLCBuilder.set(72, "000000000011111");
        vLCBuilder.set(73, "000000000011110");
        vLCBuilder.set(74, "000000000011101");
        vLCBuilder.set(75, "000000000011100");
        vLCBuilder.set(76, "000000000011011");
        vLCBuilder.set(77, "000000000011010");
        vLCBuilder.set(78, "000000000011001");
        vLCBuilder.set(79, "0000000000010011");
        vLCBuilder.set(80, "0000000000010010");
        vLCBuilder.set(81, "0000000000010001");
        vLCBuilder.set(82, "0000000000010000");
        vLCBuilder.set(387, "0000000000010100");
        vLCBuilder.set(706, "0000000000011010");
        vLCBuilder.set(770, "0000000000011001");
        vLCBuilder.set(834, "0000000000011000");
        vLCBuilder.set(898, "0000000000010111");
        vLCBuilder.set(962, "0000000000010110");
        vLCBuilder.set(1026, "0000000000010101");
        vLCBuilder.set(1729, "0000000000011111");
        vLCBuilder.set(1793, "0000000000011110");
        vLCBuilder.set(1857, "0000000000011101");
        vLCBuilder.set(1921, "0000000000011100");
        vLCBuilder.set(1985, "0000000000011011");
        vlcCoeff1 = vLCBuilder.getVLC();
    }

    public static VLC vlcMBType(int i, SequenceScalableExtension sequenceScalableExtension) {
        if (sequenceScalableExtension != null && sequenceScalableExtension.scalable_mode == 2) {
            return vlcMBTypeSNR;
        }
        if (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 1) {
            if (i == 1) {
                return vlcMBTypeI;
            }
            return i == 2 ? vlcMBTypeP : vlcMBTypeB;
        } else if (i == 1) {
            return vlcMBTypeISpat;
        } else {
            return i == 2 ? vlcMBTypePSpat : vlcMBTypeBSpat;
        }
    }

    public static MBType[] mbTypeVal(int i, SequenceScalableExtension sequenceScalableExtension) {
        if (sequenceScalableExtension != null && sequenceScalableExtension.scalable_mode == 2) {
            return mbTypeValSNR;
        }
        if (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 1) {
            if (i == 1) {
                return mbTypeValI;
            }
            return i == 2 ? mbTypeValP : mbTypeValB;
        } else if (i == 1) {
            return mbTypeValISpat;
        } else {
            return i == 2 ? mbTypeValPSpat : mbTypeValBSpat;
        }
    }
}
