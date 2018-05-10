package com.reddit.frontpage.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.instabug.chat.model.Attachment;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.FrontpageApplication;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import timber.log.Timber;

public class FileUtil {
    public static final String f21714a = String.format("%s/%s", new Object[]{Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Reddit"});
    private static final String f21715b = "FileUtil";

    public static File m23689a(int i) throws IOException {
        return m23691a(i == 0 ? ".jpg" : ".mp4");
    }

    public static File m23691a(String str) throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        StringBuilder stringBuilder = new StringBuilder("RDT_");
        stringBuilder.append(format);
        return File.createTempFile(stringBuilder.toString(), str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static int m23688a(Context context, Uri uri) {
        context = context.getContentResolver().getType(uri);
        if (context == null) {
            context = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            if (context != null) {
                context = MimeTypeMap.getSingleton().getMimeTypeFromExtension(context);
                if (context != null) {
                    if (context.contains(Attachment.TYPE_IMAGE) != null) {
                        return 0;
                    }
                    return context.contains(Attachment.TYPE_VIDEO) != null ? 1 : 2;
                }
            }
            return 2;
        } else if (context.contains(Attachment.TYPE_IMAGE) != null) {
            return 0;
        } else {
            return context.contains(Attachment.TYPE_VIDEO) != null ? 1 : 2;
        }
    }

    @SuppressLint({"NewApi"})
    public static String m23697b(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.reddit.frontpage.provider.appdata".equals(uri.getAuthority())) {
                return DocumentsContract.getDocumentId(uri);
            }
            if (m23700b(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    context = new StringBuilder();
                    context.append(Environment.getExternalStorageDirectory());
                    context.append(Operation.DIVISION);
                    context.append(split[1]);
                    return context.toString();
                }
            } else if (m23702c(uri)) {
                uri = DocumentsContract.getDocumentId(uri).split(":");
                return m23698b(m23693a(context, Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{uri[1]}));
            } else if ("com.google.android.apps.docs.storage".equals(uri.getAuthority())) {
                return m23703d(context, uri);
            }
        }
        if (!"content".equalsIgnoreCase(uri.getScheme())) {
            if (uri.getScheme() != null) {
                if ("file".equalsIgnoreCase(uri.getScheme()) == null) {
                    return null;
                }
            }
            return m23698b(uri.toString());
        } else if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            return uri.getLastPathSegment();
        } else {
            if ("com.google.android.apps.photos.contentprovider".equals(uri.getAuthority())) {
                return m23703d(context, uri);
            }
            String path = uri.getPath();
            if (path.startsWith("/document/raw:")) {
                return path.substring(14);
            }
            return m23698b(m23693a(context, uri, null, null));
        }
    }

    public static String m23694a(Uri uri) {
        Closeable openInputStream;
        Closeable bufferedOutputStream;
        Throwable e;
        try {
            File a;
            openInputStream = FrontpageApplication.f27402a.getContentResolver().openInputStream(uri);
            try {
                a = m23689a(1);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a), 65536);
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedOutputStream = null;
                Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
                Util.m23989a(openInputStream);
                Util.m23989a(bufferedOutputStream);
                return null;
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
                Util.m23989a(openInputStream);
                Util.m23989a(bufferedOutputStream);
                return null;
            } catch (Throwable th) {
                uri = th;
                bufferedOutputStream = null;
                Util.m23989a(openInputStream);
                Util.m23989a(bufferedOutputStream);
                throw uri;
            }
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read > 0) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedOutputStream.flush();
                        String absolutePath = a.getAbsolutePath();
                        Util.m23989a(openInputStream);
                        Util.m23989a(bufferedOutputStream);
                        return absolutePath;
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
                Util.m23989a(openInputStream);
                Util.m23989a(bufferedOutputStream);
                return null;
            } catch (IOException e5) {
                e = e5;
                Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
                Util.m23989a(openInputStream);
                Util.m23989a(bufferedOutputStream);
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            openInputStream = null;
            bufferedOutputStream = openInputStream;
            Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
            Util.m23989a(openInputStream);
            Util.m23989a(bufferedOutputStream);
            return null;
        } catch (IOException e7) {
            e = e7;
            openInputStream = null;
            bufferedOutputStream = openInputStream;
            Timber.c(e, "Failed to copy file [%s]", new Object[]{uri.toString()});
            Util.m23989a(openInputStream);
            Util.m23989a(bufferedOutputStream);
            return null;
        } catch (Throwable th2) {
            uri = th2;
            Util.m23989a(openInputStream);
            Util.m23989a(bufferedOutputStream);
            throw uri;
        }
    }

    private static String m23698b(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("file:")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("file:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String m23703d(Context context, Uri uri) {
        try {
            context = m23690a(context.getContentResolver().openInputStream(uri), m23688a(context, uri));
        } catch (Context context2) {
            uri = new StringBuilder();
            uri.append(f21715b);
            uri.append(": ");
            uri.append(context2.getMessage());
            Timber.e(uri.toString(), new Object[null]);
            context2 = null;
        }
        if (context2 != null) {
            return m23698b(context2.getAbsolutePath());
        }
        return null;
    }

    private static boolean m23700b(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean m23702c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static String m23693a(Context context, Uri uri, String str, String[] strArr) {
        try {
            context = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (context != null) {
                try {
                    if (context.moveToFirst() != null) {
                        uri = context.getString(context.getColumnIndexOrThrow("_data"));
                        if (context != null) {
                            context.close();
                        }
                        return uri;
                    }
                } catch (Throwable th) {
                    uri = th;
                    if (context != null) {
                        context.close();
                    }
                    throw uri;
                }
            }
            if (context != null) {
                context.close();
            }
            return null;
        } catch (Throwable th2) {
            uri = th2;
            context = null;
            if (context != null) {
                context.close();
            }
            throw uri;
        }
    }

    private static File m23690a(InputStream inputStream, int i) {
        OutputStream fileOutputStream;
        try {
            i = m23689a(i);
            fileOutputStream = new FileOutputStream(i);
            byte[] bArr = new byte[65536];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            try {
                inputStream.close();
            } catch (InputStream inputStream2) {
                Timber.c(inputStream2, f21715b, new Object[0]);
            }
            return i;
        } catch (int i2) {
            try {
                Timber.c(i2, f21715b, new Object[0]);
                return null;
            } finally {
                try {
                    inputStream2.close();
                } catch (InputStream inputStream22) {
                    Timber.c(inputStream22, f21715b, new Object[0]);
                }
            }
        } catch (Throwable th) {
            fileOutputStream.close();
        }
    }

    public static void m23696a(File file, File file2) throws IOException {
        Closeable fileInputStream;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                file = new FileOutputStream(file2);
            } catch (Throwable th) {
                file2 = th;
                IOUtil.m23719a(fileInputStream);
                IOUtil.m23719a(closeable);
                throw file2;
            }
            try {
                file2 = new byte[65536];
                while (true) {
                    int read = fileInputStream.read(file2);
                    if (read > 0) {
                        file.write(file2, 0, read);
                    } else {
                        IOUtil.m23719a(fileInputStream);
                        IOUtil.m23719a(file);
                        return;
                    }
                }
            } catch (Throwable th2) {
                file2 = th2;
                closeable = file;
                IOUtil.m23719a(fileInputStream);
                IOUtil.m23719a(closeable);
                throw file2;
            }
        } catch (Throwable th3) {
            file2 = th3;
            fileInputStream = null;
            IOUtil.m23719a(fileInputStream);
            IOUtil.m23719a(closeable);
            throw file2;
        }
    }

    public static File m23692a(String str, String str2) throws NoSuchAlgorithmException, IOException {
        File file = new File(f21714a);
        if (file.mkdirs() || file.isDirectory()) {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.length());
            String substring = new BigInteger(1, instance.digest()).toString(16).substring(0, 7);
            if (TextUtils.isEmpty(str2)) {
                str = MimeTypeMap.getFileExtensionFromUrl(str);
                if (!TextUtils.isEmpty(str)) {
                    str2 = String.format("%s.%s", new Object[]{substring, str});
                } else if (TextUtils.isEmpty(str2)) {
                    str2 = substring;
                } else {
                    str2 = String.format("%s.%s", new Object[]{substring, str2});
                }
            } else {
                String str3 = str2;
                str2 = String.format("%s.%s", new Object[]{substring, str2});
                str = str3;
            }
            File file2 = new File(f21714a, str2);
            str2 = 1;
            while (file2.exists()) {
                String format;
                if (TextUtils.isEmpty(str)) {
                    format = String.format(Locale.US, "%s-%d", new Object[]{substring, Integer.valueOf(str2)});
                } else {
                    format = String.format(Locale.US, "%s-%d.%s", new Object[]{substring, Integer.valueOf(str2), str});
                }
                str2++;
                file2 = new File(f21714a, format);
            }
            return file2;
        }
        throw new IOException(String.format("Unable to create the directory: %s", new Object[]{file.toString()}));
    }

    public static void m23695a(Context context, String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setTitle(str2);
        if (VERSION.SDK_INT >= 11) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str2);
        ((DownloadManager) context.getSystemService("download")).enqueue(request);
    }

    @TargetApi(19)
    public static Hashtable<String, Object> m23701c(Context context, Uri uri) {
        if ((VERSION.SDK_INT >= 19 ? 1 : 0) == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (!"com.google.android.apps.photos.contentprovider".equals(uri.getAuthority())) {
                    return m23699b(context, uri, null, null);
                }
                Hashtable<String, Object> b = m23699b(context, uri, null, null);
                try {
                    context = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
                    uri = File.createTempFile("sendbird", ".jpg");
                    context.compress(CompressFormat.JPEG, 80, new BufferedOutputStream(new FileOutputStream(uri)));
                    b.put("path", uri.getAbsolutePath());
                    b.put("size", Integer.valueOf((int) uri.length()));
                } catch (Context context2) {
                    uri = new StringBuilder();
                    uri.append(f21715b);
                    uri.append(": ");
                    uri.append(context2.getMessage());
                    Timber.e(uri.toString(), new Object[0]);
                }
                return b;
            } else if ("file".equalsIgnoreCase(uri.getScheme()) != null) {
                context2 = new Hashtable();
                context2.put("path", uri.getPath());
                context2.put("size", Integer.valueOf((int) new File((String) context2.get("path")).length()));
                context2.put("mime", "application/octet-stream");
                return context2;
            }
        } else if (m23700b(uri)) {
            context2 = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(context2[0]) != null) {
                uri = new Hashtable();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Environment.getExternalStorageDirectory());
                stringBuilder.append(Operation.DIVISION);
                stringBuilder.append(context2[1]);
                uri.put("path", stringBuilder.toString());
                uri.put("size", Integer.valueOf((int) new File((String) uri.get("path")).length()));
                uri.put("mime", "application/octet-stream");
                return uri;
            }
        } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
            return m23699b(context2, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
        } else if (m23702c(uri)) {
            Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
            Uri uri2 = Attachment.TYPE_IMAGE.equals(obj) ? Media.EXTERNAL_CONTENT_URI : Attachment.TYPE_VIDEO.equals(obj) ? Video.Media.EXTERNAL_CONTENT_URI : Attachment.TYPE_AUDIO.equals(obj) ? Audio.Media.EXTERNAL_CONTENT_URI : null;
            String[] strArr = new String[]{uri[1]};
            if (uri2 == null) {
                return null;
            }
            return m23699b(context2, uri2, "_id=?", strArr);
        }
        return null;
    }

    private static java.util.Hashtable<java.lang.String, java.lang.Object> m23699b(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "mime_type";
        r1 = "_data";
        r2 = "_size";
        r1 = new java.lang.String[]{r1, r0, r2};
        r2 = 0;
        r3 = r9.getContentResolver();	 Catch:{ IllegalArgumentException -> 0x0023 }
        r8 = 0;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r4 = r10;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r5 = r1;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r6 = r11;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r7 = r12;	 Catch:{ IllegalArgumentException -> 0x0023 }
        r3 = r3.query(r4, r5, r6, r7, r8);	 Catch:{ IllegalArgumentException -> 0x0023 }
        r9 = r3;
        goto L_0x0035;
    L_0x001a:
        r9 = move-exception;
        r10 = r9;
        r9 = r2;
        goto L_0x00ac;
    L_0x001f:
        r9 = move-exception;
        r10 = r9;
        r9 = r2;
        goto L_0x0087;
    L_0x0023:
        r0 = "mimetype";	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r3 = 1;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r1[r3] = r0;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r3 = r9.getContentResolver();	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r8 = 0;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r4 = r10;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r5 = r1;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r6 = r11;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r7 = r12;	 Catch:{ Exception -> 0x001f, all -> 0x001a }
        r9 = r3.query(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x001f, all -> 0x001a }
    L_0x0035:
        if (r9 == 0) goto L_0x0081;
    L_0x0037:
        r10 = r9.moveToFirst();	 Catch:{ Exception -> 0x007f }
        if (r10 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x007f }
    L_0x003d:
        r10 = "_data";	 Catch:{ Exception -> 0x007f }
        r10 = r9.getColumnIndexOrThrow(r10);	 Catch:{ Exception -> 0x007f }
        r10 = r9.getString(r10);	 Catch:{ Exception -> 0x007f }
        r11 = r9.getColumnIndexOrThrow(r0);	 Catch:{ Exception -> 0x007f }
        r11 = r9.getString(r11);	 Catch:{ Exception -> 0x007f }
        r12 = "_size";	 Catch:{ Exception -> 0x007f }
        r12 = r9.getColumnIndexOrThrow(r12);	 Catch:{ Exception -> 0x007f }
        r12 = r9.getInt(r12);	 Catch:{ Exception -> 0x007f }
        r0 = new java.util.Hashtable;	 Catch:{ Exception -> 0x007f }
        r0.<init>();	 Catch:{ Exception -> 0x007f }
        if (r10 != 0) goto L_0x0062;	 Catch:{ Exception -> 0x007f }
    L_0x0060:
        r10 = "";	 Catch:{ Exception -> 0x007f }
    L_0x0062:
        if (r11 != 0) goto L_0x0066;	 Catch:{ Exception -> 0x007f }
    L_0x0064:
        r11 = "application/octet-stream";	 Catch:{ Exception -> 0x007f }
    L_0x0066:
        r1 = "path";	 Catch:{ Exception -> 0x007f }
        r0.put(r1, r10);	 Catch:{ Exception -> 0x007f }
        r10 = "mime";	 Catch:{ Exception -> 0x007f }
        r0.put(r10, r11);	 Catch:{ Exception -> 0x007f }
        r10 = "size";	 Catch:{ Exception -> 0x007f }
        r11 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x007f }
        r0.put(r10, r11);	 Catch:{ Exception -> 0x007f }
        if (r9 == 0) goto L_0x007e;
    L_0x007b:
        r9.close();
    L_0x007e:
        return r0;
    L_0x007f:
        r10 = move-exception;
        goto L_0x0087;
    L_0x0081:
        if (r9 == 0) goto L_0x00aa;
    L_0x0083:
        r9.close();
        goto L_0x00aa;
    L_0x0087:
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ab }
        r11.<init>();	 Catch:{ all -> 0x00ab }
        r12 = f21715b;	 Catch:{ all -> 0x00ab }
        r11.append(r12);	 Catch:{ all -> 0x00ab }
        r12 = ": ";	 Catch:{ all -> 0x00ab }
        r11.append(r12);	 Catch:{ all -> 0x00ab }
        r10 = r10.getMessage();	 Catch:{ all -> 0x00ab }
        r11.append(r10);	 Catch:{ all -> 0x00ab }
        r10 = r11.toString();	 Catch:{ all -> 0x00ab }
        r11 = 0;	 Catch:{ all -> 0x00ab }
        r11 = new java.lang.Object[r11];	 Catch:{ all -> 0x00ab }
        timber.log.Timber.e(r10, r11);	 Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x00aa;
    L_0x00a9:
        goto L_0x0083;
    L_0x00aa:
        return r2;
    L_0x00ab:
        r10 = move-exception;
    L_0x00ac:
        if (r9 == 0) goto L_0x00b1;
    L_0x00ae:
        r9.close();
    L_0x00b1:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.FileUtil.b(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.util.Hashtable<java.lang.String, java.lang.Object>");
    }
}
