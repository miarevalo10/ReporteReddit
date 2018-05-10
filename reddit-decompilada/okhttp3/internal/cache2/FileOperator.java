package okhttp3.internal.cache2;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

final class FileOperator {
    private static final int BUFFER_SIZE = 8192;
    private final byte[] byteArray = new byte[BUFFER_SIZE];
    private final ByteBuffer byteBuffer = ByteBuffer.wrap(this.byteArray);
    private final FileChannel fileChannel;

    public final void read(long r6, okio.Buffer r8, long r9) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x000c;
    L_0x0006:
        r6 = new java.lang.IndexOutOfBoundsException;
        r6.<init>();
        throw r6;
    L_0x000c:
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0049;
    L_0x0010:
        r2 = r5.byteBuffer;	 Catch:{ all -> 0x0042 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ all -> 0x0042 }
        r3 = java.lang.Math.min(r3, r9);	 Catch:{ all -> 0x0042 }
        r3 = (int) r3;	 Catch:{ all -> 0x0042 }
        r2.limit(r3);	 Catch:{ all -> 0x0042 }
        r2 = r5.fileChannel;	 Catch:{ all -> 0x0042 }
        r3 = r5.byteBuffer;	 Catch:{ all -> 0x0042 }
        r2 = r2.read(r3, r6);	 Catch:{ all -> 0x0042 }
        r3 = -1;	 Catch:{ all -> 0x0042 }
        if (r2 != r3) goto L_0x002d;	 Catch:{ all -> 0x0042 }
    L_0x0027:
        r6 = new java.io.EOFException;	 Catch:{ all -> 0x0042 }
        r6.<init>();	 Catch:{ all -> 0x0042 }
        throw r6;	 Catch:{ all -> 0x0042 }
    L_0x002d:
        r2 = r5.byteBuffer;	 Catch:{ all -> 0x0042 }
        r2 = r2.position();	 Catch:{ all -> 0x0042 }
        r3 = r5.byteArray;	 Catch:{ all -> 0x0042 }
        r4 = 0;	 Catch:{ all -> 0x0042 }
        r8.m36495b(r3, r4, r2);	 Catch:{ all -> 0x0042 }
        r2 = (long) r2;
        r6 = r6 + r2;
        r9 = r9 - r2;
        r2 = r5.byteBuffer;
        r2.clear();
        goto L_0x000c;
    L_0x0042:
        r6 = move-exception;
        r7 = r5.byteBuffer;
        r7.clear();
        throw r6;
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.FileOperator.read(long, okio.Buffer, long):void");
    }

    public final void write(long r6, okio.Buffer r8, long r9) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0045;
    L_0x0006:
        r2 = r8.f36201b;
        r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0045;
    L_0x000d:
        r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0044;
    L_0x0011:
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = java.lang.Math.min(r2, r9);	 Catch:{ all -> 0x003d }
        r2 = (int) r2;	 Catch:{ all -> 0x003d }
        r3 = r5.byteArray;	 Catch:{ all -> 0x003d }
        r4 = 0;	 Catch:{ all -> 0x003d }
        r8.mo6750a(r3, r4, r2);	 Catch:{ all -> 0x003d }
        r3 = r5.byteBuffer;	 Catch:{ all -> 0x003d }
        r3.limit(r2);	 Catch:{ all -> 0x003d }
    L_0x0023:
        r3 = r5.fileChannel;	 Catch:{ all -> 0x003d }
        r4 = r5.byteBuffer;	 Catch:{ all -> 0x003d }
        r3 = r3.write(r4, r6);	 Catch:{ all -> 0x003d }
        r3 = (long) r3;	 Catch:{ all -> 0x003d }
        r6 = r6 + r3;	 Catch:{ all -> 0x003d }
        r3 = r5.byteBuffer;	 Catch:{ all -> 0x003d }
        r3 = r3.hasRemaining();	 Catch:{ all -> 0x003d }
        if (r3 != 0) goto L_0x0023;
    L_0x0035:
        r2 = (long) r2;
        r9 = r9 - r2;
        r2 = r5.byteBuffer;
        r2.clear();
        goto L_0x000d;
    L_0x003d:
        r6 = move-exception;
        r7 = r5.byteBuffer;
        r7.clear();
        throw r6;
    L_0x0044:
        return;
    L_0x0045:
        r6 = new java.lang.IndexOutOfBoundsException;
        r6.<init>();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.FileOperator.write(long, okio.Buffer, long):void");
    }

    FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }
}
