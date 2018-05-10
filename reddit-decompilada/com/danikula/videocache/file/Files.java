package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Files {
    private static final Logger f3775a = LoggerFactory.a("Files");

    private static final class LastModifiedComparator implements Comparator<File> {
        private LastModifiedComparator() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            obj = (((File) obj).lastModified() > ((File) obj2).lastModified() ? 1 : (((File) obj).lastModified() == ((File) obj2).lastModified() ? 0 : -1));
            if (obj < null) {
                return -1;
            }
            return obj == null ? null : 1;
        }
    }

    static void m3357a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder("File ");
                stringBuilder.append(file);
                stringBuilder.append(" is not directory!");
                throw new IOException(stringBuilder.toString());
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    static List<File> m3358b(File file) {
        List<File> linkedList = new LinkedList();
        file = file.listFiles();
        if (file == null) {
            return linkedList;
        }
        linkedList = Arrays.asList(file);
        Collections.sort(linkedList, new LastModifiedComparator());
        return linkedList;
    }

    static void m3359c(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                long length = file.length();
                if (length != 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                    length--;
                    randomAccessFile.seek(length);
                    byte readByte = randomAccessFile.readByte();
                    randomAccessFile.seek(length);
                    randomAccessFile.write(readByte);
                    randomAccessFile.close();
                } else if (!(file.delete() && file.createNewFile())) {
                    StringBuilder stringBuilder = new StringBuilder("Error recreate zero-size file ");
                    stringBuilder.append(file);
                    throw new IOException(stringBuilder.toString());
                }
                if (file.lastModified() < currentTimeMillis) {
                    f3775a.a("Last modified date {} is not set for file {}", new Date(file.lastModified()), file.getAbsolutePath());
                }
            }
        }
    }
}
