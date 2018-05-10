package com.twitter.sdk.android.core.internal;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class MigrationHelper {

    static class FileLastModifiedComparator implements Comparator<File> {
        FileLastModifiedComparator() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return Long.valueOf(((File) obj2).lastModified()).compareTo(Long.valueOf(((File) obj).lastModified()));
        }
    }

    static class PrefixFileNameFilter implements FilenameFilter {
        final String f23939a;

        public PrefixFileNameFilter(String str) {
            this.f23939a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.f23939a);
        }
    }

    public static File m25856a(Context context) {
        return new File(context.getApplicationInfo().dataDir, "shared_prefs");
    }

    public static File m25857a(File file, String str) {
        file = file.listFiles(new PrefixFileNameFilter(str));
        Arrays.sort(file, new FileLastModifiedComparator());
        return file.length > null ? file[null] : null;
    }
}
