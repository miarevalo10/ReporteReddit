package com.bumptech.glide.load.engine.executor;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {

    class C02761 implements FilenameFilter {
        final /* synthetic */ Pattern f3482a;

        C02761(Pattern pattern) {
            this.f3482a = pattern;
        }

        public boolean accept(File file, String str) {
            return this.f3482a.matcher(str).matches();
        }
    }

    static int m2984a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return VERSION.SDK_INT < 17 ? Math.max(m2985b(), availableProcessors) : availableProcessors;
    }

    private static int m2985b() {
        File[] listFiles;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            listFiles = new File("/sys/devices/system/cpu/").listFiles(new C02761(Pattern.compile("cpu[0-9]+")));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        return Math.max(1, listFiles != null ? listFiles.length : 0);
    }
}
