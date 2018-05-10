package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService {
    FileService() {
    }

    public static boolean m2870a(File file) {
        return file.exists();
    }

    public static long m2871b(File file) {
        return file.length();
    }

    public static File m2869a(String str) {
        return new File(str);
    }
}
