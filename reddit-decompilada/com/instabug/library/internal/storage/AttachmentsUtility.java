package com.instabug.library.internal.storage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AttachmentsUtility {
    private static final double MAX_FILE_SIZE_IN_MB = 50.0d;

    public static File getVideoFile(Context context) {
        context = getNewDirectory(context, "videos");
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder("video-");
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(".mp4");
        return new File(context, stringBuilder.toString());
    }

    public static File getFilesAttachmentDirectory(Context context) {
        return getNewDirectory(context, "attachments");
    }

    public static File getNewDirectory(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DiskUtils.getInstabugDirectory(context));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(str);
        stringBuilder.append(Operation.DIVISION);
        File file = new File(stringBuilder.toString());
        if (file.exists() == null && file.mkdirs() != null) {
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return file;
    }

    public static File getVideoRecordingFramesDirectory(Context context) {
        return getNewDirectory(context, "frames");
    }

    public static String getGalleryImagePath(Activity activity, Uri uri) {
        activity = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        if (activity == null) {
            return null;
        }
        uri = activity.getColumnIndexOrThrow("_data");
        activity.moveToFirst();
        return activity.getString(uri);
    }

    public static Uri getNewFileAttachmentUri(Context context, Uri uri, String str) {
        if (uri == null) {
            return null;
        }
        String toLowerCase = uri.getLastPathSegment().toLowerCase();
        File filesAttachmentDirectory = getFilesAttachmentDirectory(context);
        if (str == null || !SettingsManager.getInstance().getExtraAttachmentFiles().containsKey(uri)) {
            str = toLowerCase;
        }
        File file = new File(filesAttachmentDirectory, str);
        if (file.exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(System.currentTimeMillis()));
            stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            stringBuilder.append(str);
            file = new File(filesAttachmentDirectory, stringBuilder.toString());
        }
        try {
            DiskUtils.copyFromUriIntoFile(context, uri, file);
            if (validateFileSize(file, 0) != null) {
                return Uri.fromFile(file);
            }
            InstabugSDKLogger.m8359i(AttachmentsUtility.class, "Attachment file size exceeds than the limit 50.0");
            return null;
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(AttachmentsUtility.class, context2.getMessage(), context2);
            return null;
        }
    }

    public static Uri getNewFileAttachmentUri(Context context, Uri uri) {
        return getNewFileAttachmentUri(context, uri, null);
    }

    public static File getAttachmentFile(Context context, String str) {
        context = getFilesAttachmentDirectory(context);
        File file = new File(context, str);
        if (!file.exists()) {
            return file;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(System.currentTimeMillis()));
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(str);
        return new File(context, stringBuilder.toString());
    }

    public static Uri getUriFromBytes(Context context, byte[] bArr, String str) {
        context = getAttachmentFile(context, str);
        try {
            saveBytesToFile(bArr, context);
            return Uri.fromFile(context);
        } catch (Context context2) {
            InstabugSDKLogger.m8358e(AttachmentsUtility.class, context2.getMessage(), context2);
            return null;
        }
    }

    private static void saveBytesToFile(byte[] bArr, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private static boolean validateFileSize(File file, double d) {
        long length = file.length();
        double d2 = ((double) length) / 1048576.0d;
        StringBuilder stringBuilder = new StringBuilder("External attachment file size is ");
        stringBuilder.append(length);
        stringBuilder.append(" bytes or ");
        stringBuilder.append(d2);
        stringBuilder.append(" MBs");
        InstabugSDKLogger.m8356d(AttachmentsUtility.class, stringBuilder.toString());
        return d2 > d ? null : true;
    }
}
