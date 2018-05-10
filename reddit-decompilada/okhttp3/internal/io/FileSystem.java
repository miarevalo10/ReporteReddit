package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
    public static final FileSystem SYSTEM = new C26261();

    class C26261 implements FileSystem {
        C26261() {
        }

        public final Source source(File file) throws FileNotFoundException {
            return Okio.m28294a(file);
        }

        public final okio.Sink sink(java.io.File r2) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = okio.Okio.m28298b(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = okio.Okio.m28298b(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.io.FileSystem.1.sink(java.io.File):okio.Sink");
        }

        public final okio.Sink appendingSink(java.io.File r2) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = okio.Okio.m28301c(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = okio.Okio.m28301c(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.io.FileSystem.1.appendingSink(java.io.File):okio.Sink");
        }

        public final void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder stringBuilder = new StringBuilder("failed to delete ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }

        public final boolean exists(File file) {
            return file.exists();
        }

        public final long size(File file) {
            return file.length();
        }

        public final void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                StringBuilder stringBuilder = new StringBuilder("failed to rename ");
                stringBuilder.append(file);
                stringBuilder.append(" to ");
                stringBuilder.append(file2);
                throw new IOException(stringBuilder.toString());
            }
        }

        public final void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder stringBuilder = new StringBuilder("not a readable directory: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
            file = listFiles.length;
            int i = 0;
            while (i < file) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("failed to delete ");
                    stringBuilder2.append(file2);
                    throw new IOException(stringBuilder2.toString());
                }
            }
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
