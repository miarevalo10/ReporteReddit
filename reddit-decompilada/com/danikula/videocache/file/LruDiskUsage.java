package com.danikula.videocache.file;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LruDiskUsage implements DiskUsage {
    private static final Logger f12689a = LoggerFactory.a("LruDiskUsage");
    private final ExecutorService f12690b = Executors.newSingleThreadExecutor();

    private class TouchCallable implements Callable<Void> {
        final /* synthetic */ LruDiskUsage f3776a;
        private final File f3777b;

        public TouchCallable(LruDiskUsage lruDiskUsage, File file) {
            this.f3776a = lruDiskUsage;
            this.f3777b = file;
        }

        public /* synthetic */ Object call() throws Exception {
            LruDiskUsage.m11769a(this.f3776a, this.f3777b);
            return null;
        }
    }

    protected abstract boolean mo3285a(long j);

    public final void mo1103a(File file) throws IOException {
        this.f12690b.submit(new TouchCallable(this, file));
    }

    static /* synthetic */ void m11769a(LruDiskUsage lruDiskUsage, File file) throws IOException {
        Files.m3359c(file);
        File<File> b = Files.m3358b(file.getParentFile());
        long j = 0;
        for (File length : b) {
            j += length.length();
        }
        b.size();
        for (File file2 : b) {
            if (!lruDiskUsage.mo3285a(j)) {
                long length2 = file2.length();
                Logger logger;
                StringBuilder stringBuilder;
                if (file2.delete()) {
                    j -= length2;
                    logger = f12689a;
                    stringBuilder = new StringBuilder("Cache file ");
                    stringBuilder.append(file2);
                    stringBuilder.append(" is deleted because it exceeds cache limit");
                    logger.b(stringBuilder.toString());
                } else {
                    logger = f12689a;
                    stringBuilder = new StringBuilder("Error deleting file ");
                    stringBuilder.append(file2);
                    stringBuilder.append(" for trimming cache");
                    logger.d(stringBuilder.toString());
                }
            }
        }
    }
}
