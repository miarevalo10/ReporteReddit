package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import com.birbit.android.jobqueue.log.JqLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import okio.Okio;

class FileStorage {
    private final File f3030a;

    FileStorage(Context context, String str) {
        context = context.getDir("com_birbit_jobqueue_jobs", 0);
        StringBuilder stringBuilder = new StringBuilder("files_");
        stringBuilder.append(str);
        this.f3030a = new File(context, stringBuilder.toString());
        this.f3030a.mkdirs();
    }

    final byte[] m2580a(String str) throws IOException {
        str = m2581b(str);
        if (!str.exists() || !str.canRead()) {
            return null;
        }
        Closeable a = Okio.a(Okio.a(str));
        try {
            byte[] s = a.s();
            return s;
        } finally {
            m2578a(a);
        }
    }

    final File m2581b(String str) {
        File file = this.f3030a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".jobs");
        return new File(file, stringBuilder.toString());
    }

    final void m2579a(Set<String> set) {
        for (String str : this.f3030a.list()) {
            if (str.endsWith(".jobs")) {
                Object obj;
                if (str.length() < 6) {
                    obj = null;
                } else {
                    obj = str.substring(0, str.length() - 5);
                }
                if (!set.contains(obj)) {
                    File file = new File(this.f3030a, str);
                    if (!file.delete()) {
                        StringBuilder stringBuilder = new StringBuilder("cannot delete unused job toFile ");
                        stringBuilder.append(file.getAbsolutePath());
                        JqLog.m2558a(stringBuilder.toString(), new Object[0]);
                    }
                }
            }
        }
    }

    static void m2578a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0.close();	 Catch:{ IOException -> 0x0004 }
        return;
    L_0x0004:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.persistentQueue.sqlite.FileStorage.a(java.io.Closeable):void");
    }
}
