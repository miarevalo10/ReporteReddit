package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Environment;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FilesDumperPlugin implements DumperPlugin {
    private static final String NAME = "files";
    private final Context mContext;

    public String getName() {
        return NAME;
    }

    public FilesDumperPlugin(Context context) {
        this.mContext = context;
    }

    public void dump(DumperContext dumperContext) throws DumpException {
        Iterator it = dumperContext.getArgsAsList().iterator();
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it, "");
        if ("ls".equals(nextOptionalArg)) {
            doLs(dumperContext.getStdout());
        } else if ("tree".equals(nextOptionalArg)) {
            doTree(dumperContext.getStdout());
        } else if ("download".equals(nextOptionalArg)) {
            doDownload(dumperContext.getStdout(), it);
        } else {
            doUsage(dumperContext.getStdout());
            if ("".equals(nextOptionalArg) == null) {
                StringBuilder stringBuilder = new StringBuilder("Unknown command: ");
                stringBuilder.append(nextOptionalArg);
                throw new DumpUsageException(stringBuilder.toString());
            }
        }
    }

    private void doLs(PrintStream printStream) throws DumpUsageException {
        File baseDir = getBaseDir(this.mContext);
        if (baseDir.isDirectory()) {
            printDirectoryText(baseDir, "", printStream);
        }
    }

    private void doTree(PrintStream printStream) throws DumpUsageException {
        printDirectoryVisual(getBaseDir(this.mContext), 0, printStream);
    }

    private static File getBaseDir(Context context) {
        return context.getFilesDir().getParentFile();
    }

    private static void printDirectoryText(File file, String str, PrintStream printStream) {
        file = file.listFiles();
        for (File file2 : file) {
            StringBuilder stringBuilder;
            if (file2.isDirectory()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(file2.getName());
                stringBuilder.append(Operation.DIVISION);
                printDirectoryText(file2, stringBuilder.toString(), printStream);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(file2.getName());
                printStream.println(stringBuilder.toString());
            }
        }
    }

    private static void printDirectoryVisual(File file, int i, PrintStream printStream) {
        file = file.listFiles();
        for (File file2 : file) {
            printHeaderVisual(i, printStream);
            printStream.print("+---");
            printStream.print(file2.getName());
            printStream.println();
            if (file2.isDirectory()) {
                printDirectoryVisual(file2, i + 1, printStream);
            }
        }
    }

    private static void printHeaderVisual(int i, PrintStream printStream) {
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print("|   ");
        }
    }

    private void doDownload(java.io.PrintStream r5, java.util.Iterator<java.lang.String> r6) throws com.facebook.stetho.dumpapp.DumpUsageException {
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
        r4 = this;
        r0 = "Must specify output file or '-'";
        r0 = com.facebook.stetho.dumpapp.ArgsHelper.nextArg(r6, r0);
        r1 = new java.util.ArrayList;
        r1.<init>();
    L_0x000b:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x0021;
    L_0x0011:
        r2 = r4.mContext;
        r3 = r6.next();
        r3 = (java.lang.String) r3;
        r2 = resolvePossibleAppStoragePath(r2, r3);
        r1.add(r2);
        goto L_0x000b;
    L_0x0021:
        r6 = "-";	 Catch:{ IOException -> 0x0077 }
        r6 = r6.equals(r0);	 Catch:{ IOException -> 0x0077 }
        if (r6 != 0) goto L_0x0032;	 Catch:{ IOException -> 0x0077 }
    L_0x0029:
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0077 }
        r6 = resolvePossibleSdcardPath(r0);	 Catch:{ IOException -> 0x0077 }
        r5.<init>(r6);	 Catch:{ IOException -> 0x0077 }
    L_0x0032:
        r6 = new java.util.zip.ZipOutputStream;	 Catch:{ IOException -> 0x0077 }
        r0 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0077 }
        r0.<init>(r5);	 Catch:{ IOException -> 0x0077 }
        r6.<init>(r0);	 Catch:{ IOException -> 0x0077 }
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r0 = new byte[r0];	 Catch:{ all -> 0x006d }
        r2 = r1.size();	 Catch:{ all -> 0x006d }
        if (r2 <= 0) goto L_0x0056;	 Catch:{ all -> 0x006d }
    L_0x0046:
        r2 = r1.size();	 Catch:{ all -> 0x006d }
        r2 = new java.io.File[r2];	 Catch:{ all -> 0x006d }
        r1 = r1.toArray(r2);	 Catch:{ all -> 0x006d }
        r1 = (java.io.File[]) r1;	 Catch:{ all -> 0x006d }
        r4.addFiles(r6, r0, r1);	 Catch:{ all -> 0x006d }
        goto L_0x0063;	 Catch:{ all -> 0x006d }
    L_0x0056:
        r1 = r4.mContext;	 Catch:{ all -> 0x006d }
        r1 = getBaseDir(r1);	 Catch:{ all -> 0x006d }
        r1 = r1.listFiles();	 Catch:{ all -> 0x006d }
        r4.addFiles(r6, r0, r1);	 Catch:{ all -> 0x006d }
    L_0x0063:
        r6.close();	 Catch:{ IOException -> 0x0067 }
        return;
    L_0x0067:
        r6 = move-exception;
        r0 = 0;
        com.facebook.stetho.common.Util.close(r5, r0);	 Catch:{ IOException -> 0x0077 }
        throw r6;	 Catch:{ IOException -> 0x0077 }
    L_0x006d:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0072 }
        goto L_0x0076;
    L_0x0072:
        r6 = 1;
        com.facebook.stetho.common.Util.close(r5, r6);	 Catch:{ IOException -> 0x0077 }
    L_0x0076:
        throw r0;	 Catch:{ IOException -> 0x0077 }
    L_0x0077:
        r5 = move-exception;
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin.doDownload(java.io.PrintStream, java.util.Iterator):void");
    }

    private void addFiles(ZipOutputStream zipOutputStream, byte[] bArr, File[] fileArr) throws IOException {
        for (File file : fileArr) {
            if (file.isDirectory()) {
                addFiles(zipOutputStream, bArr, file.listFiles());
            } else {
                zipOutputStream.putNextEntry(new ZipEntry(relativizePath(getBaseDir(this.mContext).getParentFile(), file)));
                InputStream fileInputStream = new FileInputStream(file);
                try {
                    copy(fileInputStream, zipOutputStream, bArr);
                } finally {
                    fileInputStream.close();
                }
            }
        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static String relativizePath(File file, File file2) {
        file = file.getAbsolutePath();
        file2 = file2.getAbsolutePath();
        return file2.startsWith(file) ? file2.substring(file.length() + 1) : file2;
    }

    private static File resolvePossibleAppStoragePath(Context context, String str) {
        if (str.startsWith(Operation.DIVISION)) {
            return new File(str);
        }
        return new File(getBaseDir(context), str);
    }

    private static File resolvePossibleSdcardPath(String str) {
        if (str.startsWith(Operation.DIVISION)) {
            return new File(str);
        }
        return new File(Environment.getExternalStorageDirectory(), str);
    }

    private void doUsage(PrintStream printStream) {
        String str = "       dumpapp files ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Usage: dumpapp files ");
        stringBuilder.append("<command> [command-options]");
        printStream.println(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("ls");
        printStream.println(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("tree");
        printStream.println(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("download <output.zip> [<path>...]");
        printStream.println(stringBuilder2.toString());
        printStream.println();
        printStream.println("dumpapp files ls: List files similar to the ls command");
        printStream.println();
        printStream.println("dumpapp files tree: List files similar to the tree command");
        printStream.println();
        printStream.println("dumpapp files download: Fetch internal application storage");
        printStream.println("    <output.zip>: Output location or '-' for stdout");
        printStream.println("    <path>: Fetch only those paths named (directories fetch recursively)");
    }
}
