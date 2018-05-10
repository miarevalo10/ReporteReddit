package com.danikula.videocache;

import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import java.io.File;

public class Config {
    public final File f3719a;
    public final FileNameGenerator f3720b;
    public final DiskUsage f3721c;
    public final SourceInfoStorage f3722d;

    public Config(File file, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage) {
        this.f3719a = file;
        this.f3720b = fileNameGenerator;
        this.f3721c = diskUsage;
        this.f3722d = sourceInfoStorage;
    }
}
