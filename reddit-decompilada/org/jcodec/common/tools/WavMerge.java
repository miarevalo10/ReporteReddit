package org.jcodec.common.tools;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.codecs.wav.WavHeader;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.IOUtils;
import org.jcodec.common.NIOUtils;

public class WavMerge {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 3) {
            System.out.println("wavmerge <output wav> <input wav> .... <input wav>");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        int i = 1;
        File[] fileArr = new File[(strArr.length - 1)];
        while (i < strArr.length) {
            fileArr[i - 1] = new File(strArr[i]);
            i++;
        }
        merge(file, fileArr);
    }

    public static void merge(File file, File... fileArr) throws IOException {
        ReadableByteChannel[] readableByteChannelArr = new ReadableByteChannel[fileArr.length];
        WavHeader[] wavHeaderArr = new WavHeader[fileArr.length];
        ByteBuffer[] byteBufferArr = new ByteBuffer[fileArr.length];
        int i = 0;
        short s = (short) -1;
        int i2 = 0;
        while (true) {
            Closeable closeable = null;
            try {
                if (i2 >= fileArr.length) {
                    break;
                }
                readableByteChannelArr[i2] = NIOUtils.readableFileChannel(fileArr[i2]);
                WavHeader read = WavHeader.read(readableByteChannelArr[i2]);
                if (s == (short) -1 || s == read.fmt.bitsPerSample) {
                    s = read.fmt.bitsPerSample;
                    wavHeaderArr[i2] = read;
                    byteBufferArr[i2] = ByteBuffer.allocate(read.getFormat().framesToBytes(4096));
                    i2++;
                } else {
                    throw new RuntimeException("Input files have different sample sizes");
                }
            } catch (Throwable th) {
                file = th;
            }
        }
        fileArr = ByteBuffer.allocate(wavHeaderArr[0].getFormat().framesToBytes(4096) * fileArr.length);
        WavHeader multiChannelWav = WavHeader.multiChannelWav(wavHeaderArr);
        file = NIOUtils.writableFileChannel(file);
        try {
            multiChannelWav.write(file);
            while (true) {
                i2 = 0;
                int i3 = i2;
                while (i2 < byteBufferArr.length) {
                    if (readableByteChannelArr[i2] != null) {
                        byteBufferArr[i2].clear();
                        if (readableByteChannelArr[i2].read(byteBufferArr[i2]) == -1) {
                            NIOUtils.closeQuietly(readableByteChannelArr[i2]);
                            readableByteChannelArr[i2] = null;
                        } else {
                            i3 = 1;
                        }
                        byteBufferArr[i2].flip();
                    }
                    i2++;
                }
                if (i3 == 0) {
                    break;
                }
                fileArr.clear();
                AudioUtil.interleave(wavHeaderArr[0].getFormat(), byteBufferArr, fileArr);
                fileArr.flip();
                file.write(fileArr);
            }
            IOUtils.closeQuietly(file);
            file = readableByteChannelArr.length;
            while (i < file) {
                IOUtils.closeQuietly(readableByteChannelArr[i]);
                i++;
            }
        } catch (File[] fileArr2) {
            closeable = file;
            file = fileArr2;
            IOUtils.closeQuietly(closeable);
            fileArr2 = readableByteChannelArr.length;
            while (i < fileArr2) {
                IOUtils.closeQuietly(readableByteChannelArr[i]);
                i++;
            }
            throw file;
        }
    }
}
