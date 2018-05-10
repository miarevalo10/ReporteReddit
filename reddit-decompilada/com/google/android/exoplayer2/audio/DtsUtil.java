package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.gms.ads.AdRequest;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.containers.mps.MPSUtils;

public final class DtsUtil {
    private static final int[] f4193a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] f4194b = new int[]{-1, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] f4195c = new int[]{64, 112, 128, JpegConst.SOF0, JpegConst.APP0, 256, 384, MPSUtils.AUDIO_MIN, AdRequest.MAX_CONTENT_URL_LENGTH, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, MPEGConst.CODE_END, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static Format m3703a(byte[] bArr, String str, String str2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.m4234b(60);
        bArr = f4193a[parsableBitArray.m4236c(6)];
        int i = f4194b[parsableBitArray.m4236c(4)];
        int c = parsableBitArray.m4236c(5);
        int i2 = c >= f4195c.length ? -1 : (f4195c[c] * 1000) / 2;
        parsableBitArray.m4234b(10);
        return Format.m3558a(str, "audio/vnd.dts", i2, -1, bArr + (parsableBitArray.m4236c(2) > 0 ? 1 : 0), i, null, null, str2);
    }

    public static int m3702a(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static int m3701a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
    }

    public static int m3704b(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | (((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4))) + 1;
    }
}
