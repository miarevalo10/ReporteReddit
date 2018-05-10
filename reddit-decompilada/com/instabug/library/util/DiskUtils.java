package com.instabug.library.util;

import android.content.Context;
import android.net.Uri;
import com.instabug.library.internal.storage.AttachmentManager;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jcodec.codecs.mpeg12.MPEGConst;
import rx.Observable;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class DiskUtils {
    public static synchronized Uri zipFiles(Context context, String str, ArrayList<File> arrayList) {
        synchronized (DiskUtils.class) {
            StringBuilder stringBuilder = new StringBuilder("zipping ");
            stringBuilder.append(arrayList.size());
            stringBuilder.append(" files ... , time in MS:");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(DiskUtils.class, stringBuilder.toString());
            try {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AttachmentManager.getAttachmentDirectory(context));
                stringBuilder.append(File.separator);
                stringBuilder.append(str);
                stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append(".zip");
                File file = new File(stringBuilder.toString());
                OutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                context = arrayList.iterator();
                while (context.hasNext() != null) {
                    File file2 = (File) context.next();
                    if (file2 != null) {
                        zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                        copy(file2, zipOutputStream);
                        zipOutputStream.closeEntry();
                    }
                }
                if (file.length() != 0) {
                    zipOutputStream.close();
                }
                str = new StringBuilder("zipping files have been finished successfully, path: ");
                str.append(file.getPath());
                str.append(", time in MS: ");
                str.append(System.currentTimeMillis());
                InstabugSDKLogger.m8360v(DiskUtils.class, str.toString());
                context = Uri.fromFile(file);
            } catch (Context context2) {
                arrayList = new StringBuilder("zipping files went wrong: ");
                arrayList.append(context2.getMessage());
                arrayList.append(", time in MS: ");
                arrayList.append(System.currentTimeMillis());
                InstabugSDKLogger.m8358e(DiskUtils.class, arrayList.toString(), context2);
                return null;
            }
        }
        return context2;
    }

    private static void copy(java.io.File r1, java.io.OutputStream r2) throws java.io.IOException {
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
        r0 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0009 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0009 }
        copy(r0, r2);	 Catch:{ FileNotFoundException -> 0x0009 }
        return;
    L_0x0009:
        r1 = com.instabug.library.util.DiskUtils.class;
        r2 = "FileNotFoundException: can not copy file to another stream";
        com.instabug.library.util.InstabugSDKLogger.m8357e(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.DiskUtils.copy(java.io.File, java.io.OutputStream):void");
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[MPEGConst.CODE_END];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static ArrayList<File> listFilesInDirectory(File file) {
        ArrayList<File> arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        Collection asList = Arrays.asList(listFiles);
        StringBuilder stringBuilder = new StringBuilder("listing ");
        stringBuilder.append(listFiles.length);
        stringBuilder.append(" files ... at Directory name: ");
        stringBuilder.append(file.getName());
        stringBuilder.append("Directory path: ");
        stringBuilder.append(file.getPath());
        stringBuilder.append(", time in MS:");
        stringBuilder.append(System.currentTimeMillis());
        InstabugSDKLogger.m8360v(DiskUtils.class, stringBuilder.toString());
        arrayList.addAll(asList);
        return arrayList;
    }

    public static Observable<List<File>> getCleanDirectoryObservable(final File file) {
        return Observable.a(new Func0<Observable<List<File>>>() {
            public final /* synthetic */ Object call() {
                List arrayList = new ArrayList();
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (!file.delete()) {
                                arrayList.add(file);
                            }
                        }
                    }
                }
                return Observable.b(arrayList);
            }
        }).b(Schedulers.d());
    }
}
