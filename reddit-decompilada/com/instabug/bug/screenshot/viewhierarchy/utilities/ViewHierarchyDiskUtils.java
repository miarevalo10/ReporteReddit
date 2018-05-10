package com.instabug.bug.screenshot.viewhierarchy.utilities;

import android.content.Context;
import android.net.Uri;
import com.instabug.bug.screenshot.viewhierarchy.C0482b;
import com.instabug.bug.screenshot.viewhierarchy.C0484c;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class ViewHierarchyDiskUtils {
    public static void saveViewHierarchyImage(C0482b c0482b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getViewHierarchyImagesDirectory(c0482b.f9131n.getContext()).getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(c0482b.f9118a);
        stringBuilder.append(".png");
        File file = new File(stringBuilder.toString());
        try {
            if (c0482b.f9127j != null) {
                DiskUtils.saveBitmapOnDisk(c0482b.f9127j, file);
                c0482b.f9128k = Uri.fromFile(file);
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder("trying to save a null value bitmap, time in MS: ");
            stringBuilder2.append(System.currentTimeMillis());
            InstabugSDKLogger.m8356d(ViewHierarchyDiskUtils.class, stringBuilder2.toString());
        } catch (C0482b c0482b2) {
            stringBuilder = new StringBuilder("save viewHierarchy image got error: ");
            stringBuilder.append(c0482b2.getMessage());
            stringBuilder.append(", time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8358e(ViewHierarchyDiskUtils.class, stringBuilder.toString(), c0482b2);
        }
    }

    public static synchronized Uri zipViewHierarchyImages(C0482b c0482b) {
        synchronized (ViewHierarchyDiskUtils.class) {
            StringBuilder stringBuilder = new StringBuilder("zip viewHierarchy images just started, time in MS: ");
            stringBuilder.append(System.currentTimeMillis());
            InstabugSDKLogger.m8360v(ViewHierarchyDiskUtils.class, stringBuilder.toString());
            try {
                stringBuilder = new StringBuilder();
                stringBuilder.append(DiskUtils.getInstabugDirectory(c0482b.f9131n.getContext()));
                stringBuilder.append(File.separator);
                stringBuilder.append("view_hierarchy_attachment_");
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append(".zip");
                File file = new File(stringBuilder.toString());
                OutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                for (C0482b c0482b2 : C0484c.m7789b(c0482b)) {
                    if (c0482b2.f9128k != null) {
                        File file2 = new File(c0482b2.f9128k.getPath());
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(c0482b2.f9118a);
                        stringBuilder2.append(".png");
                        zipOutputStream.putNextEntry(new ZipEntry(stringBuilder2.toString()));
                        copy(file2, zipOutputStream);
                        zipOutputStream.closeEntry();
                        if (file2.delete()) {
                            StringBuilder stringBuilder3 = new StringBuilder("file zipped successfully, path: ");
                            stringBuilder3.append(file2.getPath());
                            stringBuilder3.append(", time in MS: ");
                            stringBuilder3.append(System.currentTimeMillis());
                            InstabugSDKLogger.m8360v(ViewHierarchyDiskUtils.class, stringBuilder3.toString());
                        }
                    }
                }
                if (file.length() != 0) {
                    zipOutputStream.close();
                }
                stringBuilder = new StringBuilder("zip viewHierarchy images done successfully, path: ");
                stringBuilder.append(file.getPath());
                stringBuilder.append(", time in MS: ");
                stringBuilder.append(System.currentTimeMillis());
                InstabugSDKLogger.m8360v(ViewHierarchyDiskUtils.class, stringBuilder.toString());
                c0482b = Uri.fromFile(file);
            } catch (C0482b c0482b3) {
                stringBuilder = new StringBuilder("zip viewHierarchy images got error: ");
                stringBuilder.append(c0482b3.getMessage());
                stringBuilder.append(", time in MS: ");
                stringBuilder.append(System.currentTimeMillis());
                InstabugSDKLogger.m8358e(ViewHierarchyDiskUtils.class, stringBuilder.toString(), c0482b3);
                return null;
            }
        }
        return c0482b3;
    }

    private static void copy(File file, OutputStream outputStream) throws IOException {
        copy(new FileInputStream(file), outputStream);
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

    public static File getViewHierarchyImagesDirectory(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DiskUtils.getInstabugDirectory(context));
        stringBuilder.append("/view-hierarchy-images/");
        File file = new File(stringBuilder.toString());
        if (file.exists() == null && file.mkdir() != null) {
            StringBuilder stringBuilder2 = new StringBuilder("temp directory created successfully: ");
            stringBuilder2.append(file.getPath());
            stringBuilder2.append(", time in MS: ");
            stringBuilder2.append(System.currentTimeMillis());
            InstabugSDKLogger.m8359i(ViewHierarchyDiskUtils.class, stringBuilder2.toString());
        }
        return file;
    }
}
