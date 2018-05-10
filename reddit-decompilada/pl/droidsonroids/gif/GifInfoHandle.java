package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;

final class GifInfoHandle {
    volatile long f41194a;

    private static native void free(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native int getWidth(long j);

    private static native boolean isOpaque(long j);

    static native long openFd(FileDescriptor fileDescriptor, long j) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    static native void setLoopCount(long j, char c);

    static {
        LibraryLoader.m43278a();
    }

    GifInfoHandle() {
    }

    private GifInfoHandle(String str) throws GifIOException {
        this.f41194a = openFile(str);
    }

    GifInfoHandle(android.content.res.AssetFileDescriptor r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = r4.getFileDescriptor();	 Catch:{ all -> 0x0016 }
        r1 = r4.getStartOffset();	 Catch:{ all -> 0x0016 }
        r0 = openFd(r0, r1);	 Catch:{ all -> 0x0016 }
        r3.f41194a = r0;	 Catch:{ all -> 0x0016 }
        r4.close();	 Catch:{ IOException -> 0x0015 }
        return;
    L_0x0015:
        return;
    L_0x0016:
        r0 = move-exception;
        r4.close();	 Catch:{ IOException -> 0x001a }
    L_0x001a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifInfoHandle.<init>(android.content.res.AssetFileDescriptor):void");
    }

    static GifInfoHandle m43250a(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        return new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    final synchronized long m43254a(Bitmap bitmap) {
        return renderFrame(this.f41194a, bitmap);
    }

    private synchronized void m43251p() {
        free(this.f41194a);
        this.f41194a = 0;
    }

    final synchronized long m43253a() {
        return restoreRemainder(this.f41194a);
    }

    final synchronized boolean m43256b() {
        return reset(this.f41194a);
    }

    final synchronized void m43257c() {
        saveRemainder(this.f41194a);
    }

    final synchronized int m43258d() {
        return getLoopCount(this.f41194a);
    }

    final synchronized int m43259e() {
        return getNativeErrorCode(this.f41194a);
    }

    final synchronized int m43260f() {
        return getDuration(this.f41194a);
    }

    final synchronized int m43261g() {
        return getCurrentPosition(this.f41194a);
    }

    final synchronized int m43262h() {
        return getCurrentFrameIndex(this.f41194a);
    }

    final synchronized int m43263i() {
        return getCurrentLoop(this.f41194a);
    }

    final synchronized void m43255a(int i, Bitmap bitmap) {
        seekToTime(this.f41194a, i, bitmap);
    }

    final synchronized boolean m43264j() {
        return this.f41194a == 0;
    }

    protected final void finalize() throws Throwable {
        try {
            m43251p();
        } finally {
            super.finalize();
        }
    }

    final synchronized long[] m43265k() {
        return getSavedState(this.f41194a);
    }

    final synchronized int m43252a(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f41194a, jArr, bitmap);
    }

    final synchronized int m43266l() {
        return getWidth(this.f41194a);
    }

    final synchronized int m43267m() {
        return getHeight(this.f41194a);
    }

    final synchronized int m43268n() {
        return getNumberOfFrames(this.f41194a);
    }

    final synchronized boolean m43269o() {
        return isOpaque(this.f41194a);
    }
}
