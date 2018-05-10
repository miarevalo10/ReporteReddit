package com.nytimes.android.external.fs3.filesystem;

import java.io.File;
import java.io.IOException;

public final class FileSystemFactory {
    public static FileSystem m8691a(File file) throws IOException {
        return new FileSystemImpl(file);
    }
}
