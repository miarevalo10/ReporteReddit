package org.jcodec.common;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jcodec.common.tools.MathUtil;

public class AudioUtil {
    private static final float f16 = 32767.0f;
    private static final float f24 = 8388607.0f;
    public static final float r16 = 3.0517578E-5f;
    public static final float r24 = 1.1920929E-7f;

    public static void toFloat(AudioFormat audioFormat, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        if (!audioFormat.isSigned()) {
            throw new IllegalArgumentException("Unsigned PCM is not supported ( yet? ).");
        } else if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            floatBuffer = new StringBuilder();
            floatBuffer.append(audioFormat.getSampleSizeInBits());
            floatBuffer.append(" bit PCM is not supported ( yet? ).");
            throw new IllegalArgumentException(floatBuffer.toString());
        } else if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                toFloat16BE(byteBuffer, floatBuffer);
            } else {
                toFloat24BE(byteBuffer, floatBuffer);
            }
        } else if (audioFormat.getSampleSizeInBits() == 16) {
            toFloat16LE(byteBuffer, floatBuffer);
        } else {
            toFloat24LE(byteBuffer, floatBuffer);
        }
    }

    public static void fromFloat(FloatBuffer floatBuffer, AudioFormat audioFormat, ByteBuffer byteBuffer) {
        if (!audioFormat.isSigned()) {
            throw new IllegalArgumentException("Unsigned PCM is not supported ( yet? ).");
        } else if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            byteBuffer = new StringBuilder();
            byteBuffer.append(audioFormat.getSampleSizeInBits());
            byteBuffer.append(" bit PCM is not supported ( yet? ).");
            throw new IllegalArgumentException(byteBuffer.toString());
        } else if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                fromFloat16BE(byteBuffer, floatBuffer);
            } else {
                fromFloat24BE(byteBuffer, floatBuffer);
            }
        } else if (audioFormat.getSampleSizeInBits() == 16) {
            fromFloat16LE(byteBuffer, floatBuffer);
        } else {
            fromFloat24LE(byteBuffer, floatBuffer);
        }
    }

    private static void toFloat24LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            floatBuffer.put(r24 * ((float) (((((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16)) | ((byteBuffer.get() & 255) << 24)) >> 8)));
        }
    }

    private static void toFloat16LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            floatBuffer.put(r16 * ((float) ((short) ((byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8)))));
        }
    }

    private static void toFloat24BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            floatBuffer.put(r24 * ((float) (((((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16)) | ((byteBuffer.get() & 255) << 8)) >> 8)));
        }
    }

    private static void toFloat16BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            floatBuffer.put(r16 * ((float) ((short) (((byteBuffer.get() & 255) << 8) | (byteBuffer.get() & 255)))));
        }
    }

    private static void fromFloat24LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            int clip = MathUtil.clip((int) (floatBuffer.get() * f24), -8388608, 8388607) & 16777215;
            byteBuffer.put((byte) clip);
            byteBuffer.put((byte) (clip >> 8));
            byteBuffer.put((byte) (clip >> 16));
        }
    }

    private static void fromFloat16LE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            int clip = MathUtil.clip((int) (floatBuffer.get() * f16), -32768, 32767) & 65535;
            byteBuffer.put((byte) clip);
            byteBuffer.put((byte) (clip >> 8));
        }
    }

    private static void fromFloat24BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 3 && floatBuffer.hasRemaining()) {
            int clip = MathUtil.clip((int) (floatBuffer.get() * f24), -8388608, 8388607) & 16777215;
            byteBuffer.put((byte) (clip >> 16));
            byteBuffer.put((byte) (clip >> 8));
            byteBuffer.put((byte) clip);
        }
    }

    private static void fromFloat16BE(ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        while (byteBuffer.remaining() >= 2 && floatBuffer.hasRemaining()) {
            int clip = MathUtil.clip((int) (floatBuffer.get() * f16), -32768, 32767) & 65535;
            byteBuffer.put((byte) (clip >> 8));
            byteBuffer.put((byte) clip);
        }
    }

    public static int fromInt(int[] iArr, int i, AudioFormat audioFormat, ByteBuffer byteBuffer) {
        if (!audioFormat.isSigned()) {
            throw new IllegalArgumentException("Unsigned PCM is not supported ( yet? ).");
        } else if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            i = new StringBuilder();
            i.append(audioFormat.getSampleSizeInBits());
            i.append(" bit PCM is not supported ( yet? ).");
            throw new IllegalArgumentException(i.toString());
        } else if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                return fromInt16BE(byteBuffer, iArr, i);
            }
            return fromInt24BE(byteBuffer, iArr, i);
        } else if (audioFormat.getSampleSizeInBits() == 16) {
            return fromInt16LE(byteBuffer, iArr, i);
        } else {
            return fromInt24LE(byteBuffer, iArr, i);
        }
    }

    private static int fromInt24LE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 3 && i2 < i) {
            int i3 = i2 + 1;
            i2 = iArr[i2];
            byteBuffer.put((byte) i2);
            byteBuffer.put((byte) (i2 >> 8));
            byteBuffer.put((byte) (i2 >> 16));
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt16LE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 2 && i2 < i) {
            int i3 = i2 + 1;
            i2 = iArr[i2];
            byteBuffer.put((byte) i2);
            byteBuffer.put((byte) (i2 >> 8));
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt24BE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 3 && i2 < i) {
            int i3 = i2 + 1;
            i2 = iArr[i2];
            byteBuffer.put((byte) (i2 >> 16));
            byteBuffer.put((byte) (i2 >> 8));
            byteBuffer.put((byte) i2);
            i2 = i3;
        }
        return i2;
    }

    private static int fromInt16BE(ByteBuffer byteBuffer, int[] iArr, int i) {
        int i2 = 0;
        while (byteBuffer.remaining() >= 2 && i2 < i) {
            int i3 = i2 + 1;
            i2 = iArr[i2];
            byteBuffer.put((byte) (i2 >> 8));
            byteBuffer.put((byte) i2);
            i2 = i3;
        }
        return i2;
    }

    public static int toInt(AudioFormat audioFormat, ByteBuffer byteBuffer, int[] iArr) {
        if (!audioFormat.isSigned()) {
            throw new IllegalArgumentException("Unsigned PCM is not supported ( yet? ).");
        } else if (audioFormat.getSampleSizeInBits() != 16 && audioFormat.getSampleSizeInBits() != 24) {
            iArr = new StringBuilder();
            iArr.append(audioFormat.getSampleSizeInBits());
            iArr.append(" bit PCM is not supported ( yet? ).");
            throw new IllegalArgumentException(iArr.toString());
        } else if (audioFormat.isBigEndian()) {
            if (audioFormat.getSampleSizeInBits() == 16) {
                return toInt16BE(byteBuffer, iArr);
            }
            return toInt24BE(byteBuffer, iArr);
        } else if (audioFormat.getSampleSizeInBits() == 16) {
            return toInt16LE(byteBuffer, iArr);
        } else {
            return toInt24LE(byteBuffer, iArr);
        }
    }

    private static int toInt24LE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 3 && i < iArr.length) {
            int i2 = i + 1;
            iArr[i] = ((((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16)) | ((byteBuffer.get() & 255) << 24)) >> 8;
            i = i2;
        }
        return i;
    }

    private static int toInt16LE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 2 && i < iArr.length) {
            int i2 = i + 1;
            iArr[i] = (short) ((byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8));
            i = i2;
        }
        return i;
    }

    private static int toInt24BE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 3 && i < iArr.length) {
            int i2 = i + 1;
            iArr[i] = ((((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16)) | ((byteBuffer.get() & 255) << 8)) >> 8;
            i = i2;
        }
        return i;
    }

    private static int toInt16BE(ByteBuffer byteBuffer, int[] iArr) {
        int i = 0;
        while (byteBuffer.remaining() >= 2 && i < iArr.length) {
            int i2 = i + 1;
            iArr[i] = (short) (((byteBuffer.get() & 255) << 8) | (byteBuffer.get() & 255));
            i = i2;
        }
        return i;
    }

    public static void interleave(AudioFormat audioFormat, ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) {
        audioFormat = audioFormat.getSampleSizeInBits() >> 3;
        int length = byteBufferArr.length * audioFormat;
        int i = 0;
        int i2 = i;
        while (i < byteBufferArr.length) {
            if (byteBufferArr[i].remaining() > i2) {
                i2 = byteBufferArr[i].remaining();
            }
            i++;
        }
        for (i = 0; i < i2 && byteBuffer.remaining() >= length; i++) {
            for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
                int i4;
                if (byteBufferArr[i3].remaining() < audioFormat) {
                    for (i4 = 0; i4 < audioFormat; i4++) {
                        byteBuffer.put((byte) 0);
                    }
                } else {
                    for (i4 = 0; i4 < audioFormat; i4++) {
                        byteBuffer.put(byteBufferArr[i3].get());
                    }
                }
            }
        }
    }

    public static void deinterleave(AudioFormat audioFormat, ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        audioFormat = audioFormat.getSampleSizeInBits() >> 3;
        int length = byteBufferArr.length * audioFormat;
        while (byteBuffer.remaining() >= length) {
            for (ByteBuffer put : byteBufferArr) {
                for (int i = 0; i < audioFormat; i++) {
                    put.put(byteBuffer.get());
                }
            }
        }
    }
}
