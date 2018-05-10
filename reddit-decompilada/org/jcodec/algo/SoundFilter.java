package org.jcodec.algo;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import okhttp3.internal.http.StatusLine;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.AudioFormat;
import org.jcodec.containers.mps.MPSUtils;

public class SoundFilter {
    public static final int[] linear = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, ModuleDescriptor.MODULE_VERSION, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, MPEGConst.SLICE_START_CODE_LAST, 176, 177, MPEGConst.USER_DATA_START_CODE, MPEGConst.SEQUENCE_HEADER_CODE, 180, MPEGConst.EXTENSION_START_CODE, 182, MPEGConst.SEQUENCE_END_CODE, MPEGConst.GROUP_START_CODE, 185, 186, 187, 188, 189, 190, 191, JpegConst.SOF0, JpegConst.SOF1, JpegConst.SOF2, JpegConst.SOF3, JpegConst.DHT, 197, 198, 199, HttpStatus.HTTP_OK, 201, 202, 203, 204, 205, 206, 207, JpegConst.RST0, JpegConst.RST1, JpegConst.RST2, JpegConst.RST3, JpegConst.RST4, JpegConst.RST5, JpegConst.RST6, JpegConst.RST7, JpegConst.SOI, JpegConst.EOI, JpegConst.SOS, JpegConst.DQT, 220, JpegConst.DRI, 222, 223, JpegConst.APP0, JpegConst.APP1, JpegConst.APP2, JpegConst.APP3, JpegConst.APP4, JpegConst.APP5, JpegConst.APP6, JpegConst.APP7, JpegConst.APP8, JpegConst.APP9, JpegConst.APPA, JpegConst.APPB, JpegConst.APPC, JpegConst.APPD, JpegConst.APPE, JpegConst.APPF, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, JpegConst.COM, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, SubsamplingScaleImageView.ORIENTATION_270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, StatusLine.HTTP_TEMP_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, HttpStatus.HTTP_NOT_FOUND, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, MPSUtils.PACK, MPSUtils.SYSTEM, MPSUtils.PSM, MPSUtils.PRIVATE_1, 446, MPSUtils.PRIVATE_2, MPSUtils.AUDIO_MIN, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, MPSUtils.AUDIO_MAX, MPSUtils.VIDEO_MIN, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, MPSUtils.VIDEO_MAX, 496, 497, 498, 499, 500, HttpStatus.HTTP_NOT_IMPLEMENTED, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511};
    public static final int[] sine = new int[]{0, 1, 3, 4, 6, 7, 9, 10, 12, 14, 15, 17, 18, 20, 21, 23, 25, 26, 28, 29, 31, 32, 34, 36, 37, 39, 40, 42, 43, 45, 47, 48, 50, 51, 53, 54, 56, 57, 59, 61, 62, 64, 65, 67, 68, 70, 72, 73, 75, 76, 78, 79, 81, 82, 84, 85, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 106, 107, 109, 110, 112, 113, 115, 116, 118, 119, 121, 122, 124, 125, 127, 128, 130, 132, 133, 135, 136, 138, 139, 141, 142, 144, 145, 147, 148, ModuleDescriptor.MODULE_VERSION, 151, 153, 154, 156, 157, 159, 160, 162, 163, 165, 166, 168, 169, 171, 172, 173, MPEGConst.SLICE_START_CODE_LAST, 176, MPEGConst.USER_DATA_START_CODE, MPEGConst.SEQUENCE_HEADER_CODE, MPEGConst.EXTENSION_START_CODE, 182, MPEGConst.GROUP_START_CODE, 185, 187, 188, 190, 191, JpegConst.SOF1, JpegConst.SOF2, JpegConst.SOF3, 197, 198, HttpStatus.HTTP_OK, 201, 203, 204, 206, 207, JpegConst.RST0, JpegConst.RST2, JpegConst.RST3, JpegConst.RST5, JpegConst.RST6, JpegConst.SOI, JpegConst.EOI, JpegConst.SOS, 220, JpegConst.DRI, 223, JpegConst.APP0, JpegConst.APP1, JpegConst.APP3, JpegConst.APP4, JpegConst.APP6, JpegConst.APP7, JpegConst.APP9, JpegConst.APPA, JpegConst.APPB, JpegConst.APPD, JpegConst.APPE, JpegConst.APPF, 241, 242, 244, 245, 246, 248, 249, 250, 252, 253, 255, 256, 257, 259, 260, 261, 263, 264, 265, 267, 268, 269, 271, 272, 273, 275, 276, 277, 279, 280, 281, 283, 284, 285, 287, 288, 289, 290, 292, 293, 294, 296, 297, 298, 299, 301, 302, 303, 304, 306, StatusLine.HTTP_TEMP_REDIRECT, StatusLine.HTTP_PERM_REDIRECT, 310, 311, 312, 313, 314, 316, 317, 318, 319, 321, 322, 323, 324, 326, 327, 328, 329, 330, 332, 333, 334, 335, 336, 337, 339, 340, 341, 342, 343, 345, 346, 347, 348, 349, 350, 351, 353, 354, 355, 356, 357, 358, 359, 360, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, HttpStatus.HTTP_NOT_FOUND, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 423, 424, 425, 426, 427, 428, 429, 430, 430, 431, 432, 433, 434, 435, 435, 436, 437, 438, 439, 439, 440, 441, MPSUtils.PACK, MPSUtils.SYSTEM, MPSUtils.SYSTEM, MPSUtils.PSM, MPSUtils.PRIVATE_1, 446, MPSUtils.PRIVATE_2, MPSUtils.PRIVATE_2, MPSUtils.AUDIO_MIN, 449, 450, 450, 451, 452, 453, 453, 454, 455, 455, 456, 457, 458, 458, 459, 460, 460, 461, 462, 462, 463, 464, 464, 465, 466, 466, 467, 468, 468, 469, 469, 470, 471, 471, 472, 473, 473, 474, 474, 475, 475, 476, 477, 477, 478, 478, MPSUtils.AUDIO_MAX, MPSUtils.AUDIO_MAX, MPSUtils.VIDEO_MIN, 481, 481, 482, 482, 483, 483, 484, 484, 485, 485, 486, 486, 487, 487, 488, 488, 489, 489, 489, 490, 490, 491, 491, 492, 492, 493, 493, 493, 494, 494, MPSUtils.VIDEO_MAX, MPSUtils.VIDEO_MAX, MPSUtils.VIDEO_MAX, 496, 496, 497, 497, 497, 498, 498, 498, 499, 499, 499, 500, 500, 500, HttpStatus.HTTP_NOT_IMPLEMENTED, HttpStatus.HTTP_NOT_IMPLEMENTED, HttpStatus.HTTP_NOT_IMPLEMENTED, 502, 502, 502, 503, 503, 503, 503, 504, 504, 504, 504, 505, 505, 505, 505, 506, 506, 506, 506, 507, 507, 507, 507, 507, 508, 508, 508, 508, 508, 509, 509, 509, 509, 509, 509, 509, 510, 510, 510, 510, 510, 510, 510, 510, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511, 511};

    public static void in16BitSignedLE(byte[] bArr, int i, int[] iArr) {
        int min = Math.min((bArr.length * i) * 2, iArr.length);
        int i2 = 0;
        int i3 = i2;
        while (i2 < min) {
            int i4 = i3;
            for (i3 = 0; i3 < i; i3++) {
                int i5 = i4 + 1;
                short s = (short) ((((short) ((bArr[i4] & 255) | ((bArr[i5] & 255) << 8))) * iArr[i2]) >> 9);
                bArr[i4] = (byte) (s & 255);
                bArr[i5] = (byte) (s >> 8);
                i4 += 2;
            }
            i2++;
            i3 = i4;
        }
    }

    public static void out16BitSignedLE(byte[] bArr, int i, int[] iArr) {
        int min = Math.min((bArr.length * i) * 2, iArr.length);
        int length = bArr.length - ((min * i) * 2);
        int i2 = 0;
        while (i2 < min) {
            int i3 = length;
            for (length = 0; length < i; length++) {
                int i4 = i3 + 1;
                short s = (short) ((((short) ((bArr[i3] & 255) | ((bArr[i4] & 255) << 8))) * iArr[(512 - i2) - 1]) >> 9);
                bArr[i3] = (byte) (s & 255);
                bArr[i4] = (byte) (s >> 8);
                i3 += 2;
            }
            i2++;
            length = i3;
        }
    }

    public static void in(AudioFormat audioFormat, byte[] bArr, int[] iArr) {
        in16BitSignedLE(bArr, audioFormat.getChannels(), iArr);
    }

    public static void out(AudioFormat audioFormat, byte[] bArr, int[] iArr) {
        out16BitSignedLE(bArr, audioFormat.getChannels(), iArr);
    }
}
