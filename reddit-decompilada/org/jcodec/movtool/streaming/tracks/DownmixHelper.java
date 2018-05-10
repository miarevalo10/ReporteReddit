package org.jcodec.movtool.streaming.tracks;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mp4.boxes.EndianBox.Endian;
import org.jcodec.containers.mp4.boxes.channel.Label;
import org.jcodec.movtool.streaming.AudioCodecMeta;

public class DownmixHelper {
    private static float rev = 4.656613E-10f;
    private int[][] channels;
    private int[][] counts;
    private ThreadLocal<float[][]> fltBuf = new ThreadLocal();
    private float[][] matrix;
    private int nSamples;
    private AudioCodecMeta[] se;

    public static final float clamp1f(float f) {
        return f > 1.0f ? 1.0f : f < -1.0f ? -1.0f : f;
    }

    public DownmixHelper(AudioCodecMeta[] audioCodecMetaArr, int i, boolean[][] zArr) {
        this.nSamples = i;
        this.se = audioCodecMetaArr;
        i = new ArrayList();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < audioCodecMetaArr.length) {
            Label[] channelLabels = audioCodecMetaArr[i2].getChannelLabels();
            IntArrayList intArrayList = new IntArrayList();
            int i3 = 0;
            while (i3 < channelLabels.length) {
                if (zArr == null || zArr[i2][i3]) {
                    intArrayList.add(i3);
                    switch (channelLabels[i3]) {
                        case Left:
                        case LeftTotal:
                        case LeftCenter:
                            i.add(new float[]{1.0f, 0.0f});
                            arrayList.add(new int[]{1, 0});
                            break;
                        case LeftSurround:
                        case RearSurroundLeft:
                            i.add(new float[]{0.7f, 0.0f});
                            arrayList.add(new int[]{1, 0});
                            break;
                        case Right:
                        case RightTotal:
                        case RightCenter:
                            i.add(new float[]{0.0f, 1.0f});
                            arrayList.add(new int[]{0, 1});
                            break;
                        case RightSurround:
                        case RearSurroundRight:
                            i.add(new float[]{0.0f, 0.7f});
                            arrayList.add(new int[]{0, 1});
                            break;
                        case Mono:
                        case LFEScreen:
                        case Center:
                        case LFE2:
                        case Discrete:
                            i.add(new float[]{0.7f, 0.7f});
                            arrayList.add(new int[]{1, 1});
                            break;
                        case Unused:
                            break;
                        default:
                            if ((channelLabels[i3].getVal() >>> 16) != 1) {
                                break;
                            }
                            i.add(new float[]{0.7f, 0.7f});
                            arrayList.add(new int[]{1, 1});
                            StringBuilder stringBuilder = new StringBuilder("Discrete");
                            stringBuilder.append(channelLabels[i3].getVal() & 65535);
                            Logger.info(stringBuilder.toString());
                            break;
                    }
                }
                i3++;
            }
            arrayList2.add(intArrayList.toArray());
            i2++;
        }
        this.matrix = (float[][]) i.toArray(new float[0][]);
        this.counts = (int[][]) arrayList.toArray(new int[0][]);
        this.channels = (int[][]) arrayList2.toArray(new int[0][]);
    }

    public void downmix(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        if (this.matrix.length == 0) {
            byteBuffer.limit(this.nSamples << 2);
            return;
        }
        float[][] fArr = (float[][]) this.fltBuf.get();
        if (fArr == null) {
            fArr = (float[][]) Array.newInstance(float.class, new int[]{this.matrix.length, this.nSamples});
            this.fltBuf.set(fArr);
        }
        int i = 0;
        int i2 = i;
        while (i < this.se.length) {
            int i3 = i2;
            i2 = 0;
            while (i2 < this.channels[i].length) {
                toFloat(fArr[i3], this.se[i], byteBufferArr[i], this.channels[i][i2], this.se[i].getChannelCount());
                i2++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        for (byteBufferArr = null; byteBufferArr < this.nSamples; byteBufferArr++) {
            float f = 0.0f;
            int i4 = 0;
            int i5 = i4;
            float f2 = 1.0f;
            float f3 = f2;
            float f4 = 0.0f;
            for (i = i5; i < this.matrix.length; i++) {
                float f5 = fArr[i][byteBufferArr];
                float f6 = this.matrix[i][0] * f5;
                float f7 = this.matrix[i][1] * f5;
                f += f6;
                f2 *= f6;
                f4 += f7;
                f3 *= f7;
                i4 += this.counts[i][0];
                i5 += this.counts[i][1];
            }
            if (i4 > 1) {
                f = clamp1f(f - f2);
            }
            if (i5 > 1) {
                f4 = clamp1f(f4 - f3);
            }
            short s = (short) ((int) (f4 * 32767.0f));
            byteBuffer.putShort((short) ((int) (f * 32767.0f)));
            byteBuffer.putShort(s);
        }
        byteBuffer.flip();
    }

    private void toFloat(float[] fArr, AudioCodecMeta audioCodecMeta, ByteBuffer byteBuffer, int i, int i2) {
        byte[] array;
        int arrayOffset;
        int i3 = 0;
        if (byteBuffer.hasArray()) {
            array = byteBuffer.array();
            arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            byteBuffer = byteBuffer.remaining();
        } else {
            array = NIOUtils.toArray(byteBuffer);
            byteBuffer = array.length;
            arrayOffset = 0;
        }
        if (audioCodecMeta.getSampleSize() == 3) {
            i2 *= 3;
            byteBuffer = Math.min(this.nSamples, byteBuffer / i2);
            if (audioCodecMeta.getEndian() == Endian.BIG_ENDIAN) {
                arrayOffset += i * 3;
                while (i3 < byteBuffer) {
                    fArr[i3] = nextSample24BE(array, arrayOffset);
                    i3++;
                    arrayOffset += i2;
                }
            } else {
                arrayOffset += i * 3;
                while (i3 < byteBuffer) {
                    fArr[i3] = nextSample24LE(array, arrayOffset);
                    i3++;
                    arrayOffset += i2;
                }
            }
        } else {
            i2 *= 2;
            byteBuffer = Math.min(this.nSamples, byteBuffer / i2);
            if (audioCodecMeta.getEndian() == Endian.BIG_ENDIAN) {
                arrayOffset += i * 2;
                while (i3 < byteBuffer) {
                    fArr[i3] = nextSample16BE(array, arrayOffset);
                    i3++;
                    arrayOffset += i2;
                }
            } else {
                arrayOffset += i * 2;
                while (i3 < byteBuffer) {
                    fArr[i3] = nextSample16LE(array, arrayOffset);
                    i3++;
                    arrayOffset += i2;
                }
            }
        }
        while (byteBuffer < this.nSamples) {
            fArr[byteBuffer] = null;
            byteBuffer++;
        }
    }

    private static final float nextSample24BE(byte[] bArr, int i) {
        return rev * ((float) (((bArr[i + 2] & 255) << 8) | (((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16))));
    }

    private static final float nextSample24LE(byte[] bArr, int i) {
        return rev * ((float) (((bArr[i + 2] & 255) << 24) | (((bArr[i] & 255) << 8) | ((bArr[i + 1] & 255) << 16))));
    }

    private static final float nextSample16BE(byte[] bArr, int i) {
        return rev * ((float) (((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24)));
    }

    private static final float nextSample16LE(byte[] bArr, int i) {
        return rev * ((float) (((bArr[i + 1] & 255) << 24) | ((bArr[i] & 255) << 16)));
    }
}
