package org.jcodec.common;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.ppm.PPMEncoder;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.containers.mps.MPSDemuxer;
import org.jcodec.containers.mps.MTSDemuxer;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

public class JCodecUtil {
    private static final VideoDecoder[] knownDecoders = new VideoDecoder[]{new ProresDecoder(), new MPEGDecoder(), new H264Decoder()};

    public enum Format {
        MOV,
        MPEG_PS,
        MPEG_TS
    }

    public static Format detectFormat(File file) throws IOException {
        return detectFormat(NIOUtils.fetchFrom(file, 204800));
    }

    public static Format detectFormat(ReadableByteChannel readableByteChannel) throws IOException {
        return detectFormat(NIOUtils.fetchFrom(readableByteChannel, 204800));
    }

    public static Format detectFormat(ByteBuffer byteBuffer) {
        int probe = MP4Demuxer.probe(byteBuffer.duplicate());
        int probe2 = MPSDemuxer.probe(byteBuffer.duplicate());
        byteBuffer = MTSDemuxer.probe(byteBuffer.duplicate());
        if (probe == 0 && probe2 == 0 && byteBuffer == null) {
            return null;
        }
        return probe > probe2 ? probe > byteBuffer ? Format.MOV : Format.MPEG_TS : probe2 > byteBuffer ? Format.MPEG_PS : Format.MPEG_TS;
    }

    public static VideoDecoder detectDecoder(ByteBuffer byteBuffer) {
        VideoDecoder[] videoDecoderArr = knownDecoders;
        int i = 0;
        int length = videoDecoderArr.length;
        VideoDecoder videoDecoder = null;
        int i2 = 0;
        while (i < length) {
            VideoDecoder videoDecoder2 = videoDecoderArr[i];
            int probe = videoDecoder2.probe(byteBuffer);
            if (probe > i2) {
                videoDecoder = videoDecoder2;
                i2 = probe;
            }
            i++;
        }
        return videoDecoder;
    }

    public static VideoDecoder getVideoDecoder(String str) {
        if (!("apch".equals(str) || "apcs".equals(str) || "apco".equals(str) || "apcn".equals(str))) {
            if (!"ap4h".equals(str)) {
                return "m2v1".equals(str) != null ? new MPEGDecoder() : null;
            }
        }
        return new ProresDecoder();
    }

    public static void savePictureAsPPM(Picture picture, File file) throws IOException {
        Transform transform = ColorUtil.getTransform(picture.getColor(), ColorSpace.RGB);
        Picture create = Picture.create(picture.getWidth(), picture.getHeight(), ColorSpace.RGB);
        transform.transform(picture, create);
        NIOUtils.writeTo(new PPMEncoder().encodeFrame(create), file);
    }

    public static byte[] asciiString(String str) {
        str = str.toCharArray();
        byte[] bArr = new byte[str.length];
        for (int i = 0; i < str.length; i++) {
            bArr[i] = (byte) str[i];
        }
        return bArr;
    }

    public static void writeBER32(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 21) | 128));
        byteBuffer.put((byte) ((i >> 14) | 128));
        byteBuffer.put((byte) ((i >> 7) | 128));
        byteBuffer.put((byte) (i & 127));
    }

    public static void writeBER32Var(ByteBuffer byteBuffer, int i) {
        int log2 = MathUtil.log2(i);
        for (int i2 = 0; i2 < 4 && log2 > 0; i2++) {
            log2 -= 7;
            int i3 = i >> log2;
            if (log2 > 0) {
                i3 |= 128;
            }
            byteBuffer.put((byte) i3);
        }
    }

    public static int readBER32(ByteBuffer byteBuffer) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            byte b = byteBuffer.get();
            i2 = (i2 << 7) | (b & 127);
            if (((b & 255) >> 7) == 0) {
                break;
            }
            i++;
        }
        return i2;
    }

    public static int[] getAsIntArray(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        int[] iArr = new int[i];
        byteBuffer.get(bArr);
        for (byteBuffer = null; byteBuffer < i; byteBuffer++) {
            iArr[byteBuffer] = bArr[byteBuffer] & 255;
        }
        return iArr;
    }

    public static ThreadPoolExecutor getPriorityExecutor(int i) {
        return new ThreadPoolExecutor(i, i, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(10, PriorityFuture.COMP)) {
            protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                return new PriorityFuture(super.newTaskFor(callable), ((PriorityCallable) callable).getPriority());
            }
        };
    }

    public static String removeExtension(String str) {
        return str == null ? null : str.replaceAll("\\.[^\\.]+$", "");
    }
}
