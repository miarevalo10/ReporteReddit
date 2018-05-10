package com.nytimes.android.external.fs3.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import okio.BufferedSource;

public interface FileSystem {
    BufferedSource mo2710a(String str) throws FileNotFoundException;

    void mo2711a(String str, BufferedSource bufferedSource) throws IOException;

    boolean mo2712b(String str);
}
