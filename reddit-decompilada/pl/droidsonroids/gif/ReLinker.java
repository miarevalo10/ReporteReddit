package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class ReLinker {
    private static final String f41203a = System.mapLibraryName("pl_droidsonroids_gif");

    private ReLinker() {
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    static void m43283a(Context context) {
        synchronized (ReLinker.class) {
            System.load(m43287b(context).getAbsolutePath());
        }
    }

    private static java.io.File m43287b(android.content.Context r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = f41203a;
        r0.append(r1);
        r1 = "1.2.10";
        r0.append(r1);
        r0 = r0.toString();
        r1 = new java.io.File;
        r2 = "lib";
        r3 = 0;
        r2 = r9.getDir(r2, r3);
        r1.<init>(r2, r0);
        r2 = r1.isFile();
        if (r2 == 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = new java.io.File;
        r4 = r9.getCacheDir();
        r2.<init>(r4, r0);
        r0 = r2.isFile();
        if (r0 == 0) goto L_0x0036;
    L_0x0035:
        return r2;
    L_0x0036:
        r0 = "pl_droidsonroids_gif_surface";
        r0 = java.lang.System.mapLibraryName(r0);
        r4 = new pl.droidsonroids.gif.ReLinker$1;
        r4.<init>(r0);
        m43285a(r1, r4);
        m43285a(r2, r4);
        r9 = r9.getApplicationInfo();
        r0 = new java.io.File;
        r9 = r9.sourceDir;
        r0.<init>(r9);
        r9 = 0;
        r0 = m43282a(r0);	 Catch:{ all -> 0x00c4 }
        r4 = r1;
        r1 = r3;
    L_0x0059:
        r5 = r1 + 1;
        r6 = 5;
        if (r1 >= r6) goto L_0x00be;
    L_0x005e:
        r1 = m43281a(r0);	 Catch:{ all -> 0x00bc }
        if (r1 != 0) goto L_0x007f;	 Catch:{ all -> 0x00bc }
    L_0x0064:
        r9 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00bc }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bc }
        r2 = "Library ";	 Catch:{ all -> 0x00bc }
        r1.<init>(r2);	 Catch:{ all -> 0x00bc }
        r2 = f41203a;	 Catch:{ all -> 0x00bc }
        r1.append(r2);	 Catch:{ all -> 0x00bc }
        r2 = " for supported ABIs not found in APK file";	 Catch:{ all -> 0x00bc }
        r1.append(r2);	 Catch:{ all -> 0x00bc }
        r1 = r1.toString();	 Catch:{ all -> 0x00bc }
        r9.<init>(r1);	 Catch:{ all -> 0x00bc }
        throw r9;	 Catch:{ all -> 0x00bc }
    L_0x007f:
        r1 = r0.getInputStream(r1);	 Catch:{ IOException -> 0x00ae, all -> 0x00a4 }
        r6 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00a2, all -> 0x00a0 }
        r6.<init>(r4);	 Catch:{ IOException -> 0x00a2, all -> 0x00a0 }
        m43286a(r1, r6);	 Catch:{ IOException -> 0x00b0, all -> 0x009c }
        m43284a(r1);	 Catch:{ all -> 0x00bc }
        m43284a(r6);	 Catch:{ all -> 0x00bc }
        r9 = 1;	 Catch:{ all -> 0x00bc }
        r4.setReadable(r9, r3);	 Catch:{ all -> 0x00bc }
        r4.setExecutable(r9, r3);	 Catch:{ all -> 0x00bc }
        r4.setWritable(r9);	 Catch:{ all -> 0x00bc }
        goto L_0x00be;	 Catch:{ all -> 0x00bc }
    L_0x009c:
        r9 = move-exception;	 Catch:{ all -> 0x00bc }
        r2 = r9;	 Catch:{ all -> 0x00bc }
        r9 = r6;	 Catch:{ all -> 0x00bc }
        goto L_0x00a7;	 Catch:{ all -> 0x00bc }
    L_0x00a0:
        r2 = move-exception;	 Catch:{ all -> 0x00bc }
        goto L_0x00a7;	 Catch:{ all -> 0x00bc }
    L_0x00a2:
        r6 = r9;	 Catch:{ all -> 0x00bc }
        goto L_0x00b0;	 Catch:{ all -> 0x00bc }
    L_0x00a4:
        r1 = move-exception;	 Catch:{ all -> 0x00bc }
        r2 = r1;	 Catch:{ all -> 0x00bc }
        r1 = r9;	 Catch:{ all -> 0x00bc }
    L_0x00a7:
        m43284a(r1);	 Catch:{ all -> 0x00bc }
        m43284a(r9);	 Catch:{ all -> 0x00bc }
        throw r2;	 Catch:{ all -> 0x00bc }
    L_0x00ae:
        r1 = r9;	 Catch:{ all -> 0x00bc }
        r6 = r1;	 Catch:{ all -> 0x00bc }
    L_0x00b0:
        r7 = 2;	 Catch:{ all -> 0x00bc }
        if (r5 <= r7) goto L_0x00b4;	 Catch:{ all -> 0x00bc }
    L_0x00b3:
        r4 = r2;	 Catch:{ all -> 0x00bc }
    L_0x00b4:
        m43284a(r1);	 Catch:{ all -> 0x00bc }
        m43284a(r6);	 Catch:{ all -> 0x00bc }
        r1 = r5;
        goto L_0x0059;
    L_0x00bc:
        r9 = move-exception;
        goto L_0x00c8;
    L_0x00be:
        if (r0 == 0) goto L_0x00c3;
    L_0x00c0:
        r0.close();	 Catch:{ IOException -> 0x00c3 }
    L_0x00c3:
        return r4;
    L_0x00c4:
        r0 = move-exception;
        r8 = r0;
        r0 = r9;
        r9 = r8;
    L_0x00c8:
        if (r0 == 0) goto L_0x00cd;
    L_0x00ca:
        r0.close();	 Catch:{ IOException -> 0x00cd }
    L_0x00cd:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.ReLinker.b(android.content.Context):java.io.File");
    }

    private static java.util.zip.ZipFile m43282a(java.io.File r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
    L_0x0001:
        r1 = r0 + 1;
        r2 = 5;
        if (r0 >= r2) goto L_0x000f;
    L_0x0006:
        r0 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x000d }
        r2 = 1;	 Catch:{ IOException -> 0x000d }
        r0.<init>(r3, r2);	 Catch:{ IOException -> 0x000d }
        goto L_0x0010;
    L_0x000d:
        r0 = r1;
        goto L_0x0001;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        if (r0 != 0) goto L_0x002a;
    L_0x0012:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Could not open APK file: ";
        r1.<init>(r2);
        r3 = r3.getAbsolutePath();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.ReLinker.a(java.io.File):java.util.zip.ZipFile");
    }

    private static void m43285a(File file, FilenameFilter filenameFilter) {
        file = file.getParentFile().listFiles(filenameFilter);
        if (file != null) {
            for (File delete : file) {
                delete.delete();
            }
        }
    }

    private static void m43286a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void m43284a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.ReLinker.a(java.io.Closeable):void");
    }

    private static ZipEntry m43281a(ZipFile zipFile) {
        int i = 0;
        String[] strArr = VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        int length = strArr.length;
        while (i < length) {
            String str = strArr[i];
            StringBuilder stringBuilder = new StringBuilder("lib/");
            stringBuilder.append(str);
            stringBuilder.append(Operation.DIVISION);
            stringBuilder.append(f41203a);
            ZipEntry entry = zipFile.getEntry(stringBuilder.toString());
            if (entry != null) {
                return entry;
            }
            i++;
        }
        return null;
    }
}
