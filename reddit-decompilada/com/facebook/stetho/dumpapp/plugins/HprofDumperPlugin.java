package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Debug;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class HprofDumperPlugin implements DumperPlugin {
    private static final String NAME = "hprof";
    private final Context mContext;

    private void handlePipeOutput(java.io.OutputStream r4) throws com.facebook.stetho.dumpapp.DumpException {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.mContext;
        r1 = "hprof-dump.hprof";
        r0 = r0.getFileStreamPath(r1);
        r3.writeHprof(r0);	 Catch:{ all -> 0x0043 }
        r1 = new java.io.FileInputStream;	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        r1.<init>(r0);	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = new byte[r2];	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        com.facebook.stetho.common.Util.copy(r1, r4, r2);	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        r1.close();	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        r4 = r0.exists();
        if (r4 == 0) goto L_0x0024;
    L_0x0020:
        r0.delete();
        return;
    L_0x0024:
        return;
    L_0x0025:
        r4 = move-exception;
        r1.close();	 Catch:{ all -> 0x0025, IOException -> 0x002a }
        throw r4;	 Catch:{ all -> 0x0025, IOException -> 0x002a }
    L_0x002a:
        r4 = new com.facebook.stetho.dumpapp.DumpException;	 Catch:{ all -> 0x0043 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0043 }
        r2 = "Failure copying ";	 Catch:{ all -> 0x0043 }
        r1.<init>(r2);	 Catch:{ all -> 0x0043 }
        r1.append(r0);	 Catch:{ all -> 0x0043 }
        r2 = " to dumper output";	 Catch:{ all -> 0x0043 }
        r1.append(r2);	 Catch:{ all -> 0x0043 }
        r1 = r1.toString();	 Catch:{ all -> 0x0043 }
        r4.<init>(r1);	 Catch:{ all -> 0x0043 }
        throw r4;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r4 = move-exception;
        r1 = r0.exists();
        if (r1 == 0) goto L_0x004d;
    L_0x004a:
        r0.delete();
    L_0x004d:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin.handlePipeOutput(java.io.OutputStream):void");
    }

    public String getName() {
        return NAME;
    }

    public HprofDumperPlugin(Context context) {
        this.mContext = context;
    }

    public void dump(DumperContext dumperContext) throws DumpException {
        OutputStream stdout = dumperContext.getStdout();
        dumperContext = dumperContext.getArgsAsList().iterator();
        dumperContext = dumperContext.hasNext() ? (String) dumperContext.next() : null;
        if (dumperContext == null) {
            usage(stdout);
        } else if (Operation.MINUS.equals(dumperContext)) {
            handlePipeOutput(stdout);
        } else {
            File file = new File(dumperContext);
            if (!file.isAbsolute()) {
                file = this.mContext.getFileStreamPath(dumperContext);
            }
            writeHprof(file);
            dumperContext = new StringBuilder("Wrote to ");
            dumperContext.append(file);
            stdout.println(dumperContext.toString());
        }
    }

    private void writeHprof(File file) throws DumpException {
        try {
            truncateAndDeleteFile(file);
            Debug.dumpHprofData(file.getAbsolutePath());
        } catch (IOException e) {
            StringBuilder stringBuilder = new StringBuilder("Failure writing to ");
            stringBuilder.append(file);
            stringBuilder.append(": ");
            stringBuilder.append(e.getMessage());
            throw new DumpException(stringBuilder.toString());
        }
    }

    private static void truncateAndDeleteFile(File file) throws IOException {
        new FileOutputStream(file).close();
        if (!file.delete()) {
            StringBuilder stringBuilder = new StringBuilder("Failed to delete ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void usage(PrintStream printStream) throws DumpUsageException {
        printStream.println("Usage: dumpapp hprof [ path ]");
        printStream.println("Dump HPROF memory usage data from the running application.");
        printStream.println();
        printStream.println("Where path can be any of:");
        printStream.println("  -           Output directly to stdout");
        printStream.println("  <path>      Full path to a writable file on the device");
        printStream.println("  <filename>  Relative filename that will be stored in the app internal storage");
        throw new DumpUsageException("Missing path");
    }
}
