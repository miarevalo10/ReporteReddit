package com.google.android.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class AtomicFile {
    public final File f5214a;
    public final File f5215b;

    private static final class AtomicFileOutputStream extends OutputStream {
        private final FileOutputStream f5212a;
        private boolean f5213b = false;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.f5212a = new FileOutputStream(file);
        }

        public final void close() throws IOException {
            if (!this.f5213b) {
                this.f5213b = true;
                flush();
                try {
                    this.f5212a.getFD().sync();
                } catch (Throwable e) {
                    Log.w("AtomicFile", "Failed to sync file descriptor:", e);
                }
                this.f5212a.close();
            }
        }

        public final void flush() throws IOException {
            this.f5212a.flush();
        }

        public final void write(int i) throws IOException {
            this.f5212a.write(i);
        }

        public final void write(byte[] bArr) throws IOException {
            this.f5212a.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            this.f5212a.write(bArr, i, i2);
        }
    }

    public AtomicFile(File file) {
        this.f5214a = file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        this.f5215b = new File(stringBuilder.toString());
    }

    public final java.io.OutputStream m4188a() throws java.io.IOException {
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
        r3 = this;
        r0 = r3.f5214a;
        r0 = r0.exists();
        if (r0 == 0) goto L_0x003f;
    L_0x0008:
        r0 = r3.f5215b;
        r0 = r0.exists();
        if (r0 != 0) goto L_0x003a;
    L_0x0010:
        r0 = r3.f5214a;
        r1 = r3.f5215b;
        r0 = r0.renameTo(r1);
        if (r0 != 0) goto L_0x003f;
    L_0x001a:
        r0 = "AtomicFile";
        r1 = new java.lang.StringBuilder;
        r2 = "Couldn't rename file ";
        r1.<init>(r2);
        r2 = r3.f5214a;
        r1.append(r2);
        r2 = " to backup file ";
        r1.append(r2);
        r2 = r3.f5215b;
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        goto L_0x003f;
    L_0x003a:
        r0 = r3.f5214a;
        r0.delete();
    L_0x003f:
        r0 = new com.google.android.exoplayer2.util.AtomicFile$AtomicFileOutputStream;	 Catch:{ FileNotFoundException -> 0x0047 }
        r1 = r3.f5214a;	 Catch:{ FileNotFoundException -> 0x0047 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0047 }
        goto L_0x0070;
    L_0x0047:
        r0 = r3.f5214a;
        r0 = r0.getParentFile();
        r0 = r0.mkdirs();
        if (r0 != 0) goto L_0x0069;
    L_0x0053:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r2 = "Couldn't create directory ";
        r1.<init>(r2);
        r2 = r3.f5214a;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0069:
        r0 = new com.google.android.exoplayer2.util.AtomicFile$AtomicFileOutputStream;	 Catch:{ FileNotFoundException -> 0x0071 }
        r1 = r3.f5214a;	 Catch:{ FileNotFoundException -> 0x0071 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0071 }
    L_0x0070:
        return r0;
    L_0x0071:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r2 = "Couldn't create ";
        r1.<init>(r2);
        r2 = r3.f5214a;
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.AtomicFile.a():java.io.OutputStream");
    }
}
