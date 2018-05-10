package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {

    static class CentralDirectory {
        long f800a;
        long f801b;

        CentralDirectory() {
        }
    }

    static long m413a(File file) throws IOException {
        long j = "r";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, j);
        try {
            j = m414a(randomAccessFile, m415a(randomAccessFile));
            return j;
        } finally {
            randomAccessFile.close();
        }
    }

    private static CentralDirectory m415a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j = 0;
        if (length < 0) {
            StringBuilder stringBuilder = new StringBuilder("File too short to be a zip file: ");
            stringBuilder.append(randomAccessFile.length());
            throw new ZipException(stringBuilder.toString());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() != reverseBytes) {
                length--;
            } else {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.f801b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                centralDirectory.f800a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return centralDirectory;
            }
        } while (length >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    private static long m414a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = centralDirectory.f801b;
        randomAccessFile.seek(centralDirectory.f800a);
        byte[] bArr = new byte[16384];
        centralDirectory = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (centralDirectory != -1) {
            crc32.update(bArr, 0, centralDirectory);
            j -= (long) centralDirectory;
            if (j == 0) {
                break;
            }
            centralDirectory = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
