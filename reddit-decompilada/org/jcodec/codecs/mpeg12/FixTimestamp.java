package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.containers.mps.MPSUtils;

public abstract class FixTimestamp {
    protected abstract long doWithTimestamp(int i, long j, boolean z);

    public boolean isAudio(int i) {
        return i >= 191 && i <= 223;
    }

    public boolean isVideo(int i) {
        return i >= JpegConst.APP0 && i <= JpegConst.APPF;
    }

    public void fix(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] bArr = new byte[188];
                while (randomAccessFile.read(bArr) == 188) {
                    Assert.assertEquals(71, bArr[0] & 255);
                    int i = ((bArr[1] & 255) << 8) | (bArr[2] & 255);
                    int i2 = i & 8191;
                    if (!(((i >> 14) & 1) == 0 || i2 == 0)) {
                        ByteBuffer wrap = ByteBuffer.wrap(bArr, 4, MPEGConst.GROUP_START_CODE);
                        if ((bArr[3] & 32) != 0) {
                            NIOUtils.skip(wrap, wrap.get() & 255);
                        }
                        if (wrap.remaining() >= 10) {
                            i2 = wrap.getInt();
                            if ((i2 >> 8) == 1) {
                                while (wrap.hasRemaining() && (i2 < MPSUtils.PRIVATE_2 || i2 >= MPSUtils.VIDEO_MAX)) {
                                    i2 = (i2 << 8) | (wrap.get() & 255);
                                }
                                if (i2 >= MPSUtils.PRIVATE_2 && i2 < MPSUtils.VIDEO_MAX) {
                                    wrap.getShort();
                                    int i3 = wrap.get() & 255;
                                    wrap.position(wrap.position() - 1);
                                    if ((i3 & JpegConst.SOF0) == 128) {
                                        fixMpeg2(i2 & 255, wrap);
                                    } else {
                                        fixMpeg1(i2 & 255, wrap);
                                    }
                                    randomAccessFile.seek(randomAccessFile.getFilePointer() - 188);
                                    randomAccessFile.write(bArr);
                                }
                            }
                        }
                    }
                }
                randomAccessFile.close();
            } catch (Throwable th) {
                file = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw file;
        }
    }

    public void fixMpeg1(int i, ByteBuffer byteBuffer) {
        int i2 = byteBuffer.getInt() & 255;
        while (i2 == 255) {
            i2 = byteBuffer.get() & 255;
        }
        if ((i2 & JpegConst.SOF0) == 64) {
            byteBuffer.get();
            i2 = byteBuffer.get() & 255;
        }
        int i3 = i2 & 240;
        if (i3 == 32) {
            byteBuffer.position(byteBuffer.position() - 1);
            fixTs(i, byteBuffer, true);
        } else if (i3 == 48) {
            byteBuffer.position(byteBuffer.position() - 1);
            fixTs(i, byteBuffer, true);
            fixTs(i, byteBuffer, false);
        } else if (i2 != 15) {
            throw new RuntimeException("Invalid data");
        }
    }

    public long fixTs(int i, ByteBuffer byteBuffer, boolean z) {
        byte b = byteBuffer.get();
        long doWithTimestamp = doWithTimestamp(i, (((((((long) b) & 14) << 29) | ((long) ((byteBuffer.get() & 255) << 22))) | ((long) (((byteBuffer.get() & 255) >> 1) << 15))) | ((long) ((byteBuffer.get() & 255) << 7))) | ((long) ((byteBuffer.get() & 255) >> 1)), z);
        byteBuffer.position(byteBuffer.position() - 5);
        byteBuffer.put((byte) ((int) ((((long) (b & 240)) | (doWithTimestamp >>> 29)) | 1)));
        byteBuffer.put((byte) ((int) (doWithTimestamp >>> 22)));
        byteBuffer.put((byte) ((int) ((doWithTimestamp >>> 14) | 1)));
        byteBuffer.put((byte) ((int) (doWithTimestamp >>> 7)));
        byteBuffer.put((byte) ((int) ((doWithTimestamp << 1) | 1)));
        return doWithTimestamp;
    }

    public void fixMpeg2(int i, ByteBuffer byteBuffer) {
        byteBuffer.get();
        int i2 = byteBuffer.get() & 255;
        byteBuffer.get();
        i2 &= JpegConst.SOF0;
        if (i2 == 128) {
            fixTs(i, byteBuffer, true);
            return;
        }
        if (i2 == JpegConst.SOF0) {
            fixTs(i, byteBuffer, true);
            fixTs(i, byteBuffer, false);
        }
    }
}
