package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.containers.mps.MTSUtils;

public class HLSFixPMT {

    static class C21981 implements FilenameFilter {
        C21981() {
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(".ts");
        }
    }

    public void fix(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] bArr = new byte[188];
                while (randomAccessFile.read(bArr) == 188) {
                    int i = 0;
                    Assert.assertEquals(71, bArr[0] & 255);
                    int i2 = ((bArr[1] & 255) << 8) | (bArr[2] & 255);
                    int i3 = i2 & 8191;
                    i2 = (i2 >> 14) & 1;
                    if (((bArr[3] & 255) & 32) != 0) {
                        i = (bArr[4] & 255) + 1;
                    }
                    if (i2 == 1) {
                        i += (bArr[4 + i] & 255) + 1;
                    }
                    if (i3 == 0) {
                        if (i2 == 0) {
                            throw new RuntimeException("PAT spans multiple TS packets, not supported!!!!!!");
                        }
                        fixPAT(ByteBuffer.wrap(bArr, 4 + i, 184 - i));
                        randomAccessFile.seek(randomAccessFile.getFilePointer() - 188);
                        randomAccessFile.write(bArr);
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

    public static void fixPAT(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        MTSUtils.parseSection(byteBuffer);
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        while (byteBuffer.remaining() > 4) {
            short s = byteBuffer.getShort();
            short s2 = byteBuffer.getShort();
            if (s != (short) 0) {
                duplicate2.putShort(s);
                duplicate2.putShort(s2);
            }
        }
        if (duplicate2.position() != byteBuffer.position()) {
            byteBuffer = duplicate.duplicate();
            byteBuffer.get();
            byteBuffer.putShort((short) ((((duplicate2.position() - duplicate.position()) + 1) & 4095) | 45056));
            byteBuffer = new CRC32();
            duplicate.limit(duplicate2.position());
            byteBuffer.update(NIOUtils.toArray(duplicate));
            duplicate2.putInt((int) byteBuffer.getValue());
            while (duplicate2.hasRemaining() != null) {
                duplicate2.put((byte) -1);
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length <= 0) {
            exit("Please specify package location");
        }
        int i = 0;
        File file = new File(strArr[0]);
        if (file.isDirectory() == null) {
            exit("Not an HLS package, expected a folder");
        }
        strArr = file.listFiles(new C21981());
        HLSFixPMT hLSFixPMT = new HLSFixPMT();
        int length = strArr.length;
        while (i < length) {
            File file2 = strArr[i];
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder("Processing: ");
            stringBuilder.append(file2.getName());
            printStream.println(stringBuilder.toString());
            hLSFixPMT.fix(file2);
            i++;
        }
    }

    private static void exit(String str) {
        System.err.println("Syntax: hls_fixpmt <hls package location>");
        System.err.println(str);
        System.exit(-1);
    }
}
