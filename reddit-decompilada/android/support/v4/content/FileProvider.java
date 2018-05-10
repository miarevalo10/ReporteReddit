package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class FileProvider extends ContentProvider {
    private static final String[] f1182a = new String[]{"_display_name", "_size"};
    private static final File f1183b = new File(Operation.DIVISION);
    private static HashMap<String, PathStrategy> f1184c = new HashMap();
    private PathStrategy f1185d;

    interface PathStrategy {
        Uri mo265a(File file);

        File mo266a(Uri uri);
    }

    static class SimplePathStrategy implements PathStrategy {
        final HashMap<String, File> f11413a = new HashMap();
        private final String f11414b;

        public SimplePathStrategy(String str) {
            this.f11414b = str;
        }

        public final android.net.Uri mo265a(java.io.File r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r5 = this;
            r0 = r6.getCanonicalPath();	 Catch:{ IOException -> 0x00bc }
            r6 = 0;
            r1 = r5.f11413a;
            r1 = r1.entrySet();
            r1 = r1.iterator();
        L_0x000f:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x0043;
        L_0x0015:
            r2 = r1.next();
            r2 = (java.util.Map.Entry) r2;
            r3 = r2.getValue();
            r3 = (java.io.File) r3;
            r3 = r3.getPath();
            r4 = r0.startsWith(r3);
            if (r4 == 0) goto L_0x000f;
        L_0x002b:
            if (r6 == 0) goto L_0x0041;
        L_0x002d:
            r3 = r3.length();
            r4 = r6.getValue();
            r4 = (java.io.File) r4;
            r4 = r4.getPath();
            r4 = r4.length();
            if (r3 <= r4) goto L_0x000f;
        L_0x0041:
            r6 = r2;
            goto L_0x000f;
        L_0x0043:
            if (r6 != 0) goto L_0x0059;
        L_0x0045:
            r6 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to find configured root that contains ";
            r1.<init>(r2);
            r1.append(r0);
            r0 = r1.toString();
            r6.<init>(r0);
            throw r6;
        L_0x0059:
            r1 = r6.getValue();
            r1 = (java.io.File) r1;
            r1 = r1.getPath();
            r2 = "/";
            r2 = r1.endsWith(r2);
            if (r2 == 0) goto L_0x0074;
        L_0x006b:
            r1 = r1.length();
            r0 = r0.substring(r1);
            goto L_0x007e;
        L_0x0074:
            r1 = r1.length();
            r1 = r1 + 1;
            r0 = r0.substring(r1);
        L_0x007e:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r6 = r6.getKey();
            r6 = (java.lang.String) r6;
            r6 = android.net.Uri.encode(r6);
            r1.append(r6);
            r6 = 47;
            r1.append(r6);
            r6 = "/";
            r6 = android.net.Uri.encode(r0, r6);
            r1.append(r6);
            r6 = r1.toString();
            r0 = new android.net.Uri$Builder;
            r0.<init>();
            r1 = "content";
            r0 = r0.scheme(r1);
            r1 = r5.f11414b;
            r0 = r0.authority(r1);
            r6 = r0.encodedPath(r6);
            r6 = r6.build();
            return r6;
        L_0x00bc:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to resolve canonical path for ";
            r1.<init>(r2);
            r1.append(r6);
            r6 = r1.toString();
            r0.<init>(r6);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.FileProvider.SimplePathStrategy.a(java.io.File):android.net.Uri");
        }

        public final java.io.File mo266a(android.net.Uri r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r5.getEncodedPath();
            r1 = 1;
            r2 = 47;
            r2 = r0.indexOf(r2, r1);
            r3 = r0.substring(r1, r2);
            r3 = android.net.Uri.decode(r3);
            r2 = r2 + r1;
            r0 = r0.substring(r2);
            r0 = android.net.Uri.decode(r0);
            r1 = r4.f11413a;
            r1 = r1.get(r3);
            r1 = (java.io.File) r1;
            if (r1 != 0) goto L_0x003a;
        L_0x0026:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Unable to find configured root for ";
            r1.<init>(r2);
            r1.append(r5);
            r5 = r1.toString();
            r0.<init>(r5);
            throw r0;
        L_0x003a:
            r5 = new java.io.File;
            r5.<init>(r1, r0);
            r0 = r5.getCanonicalFile();	 Catch:{ IOException -> 0x005a }
            r5 = r0.getPath();
            r1 = r1.getPath();
            r5 = r5.startsWith(r1);
            if (r5 != 0) goto L_0x0059;
        L_0x0051:
            r5 = new java.lang.SecurityException;
            r0 = "Resolved path jumped beyond configured root";
            r5.<init>(r0);
            throw r5;
        L_0x0059:
            return r0;
        L_0x005a:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to resolve canonical path for ";
            r1.<init>(r2);
            r1.append(r5);
            r5 = r1.toString();
            r0.<init>(r5);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.FileProvider.SimplePathStrategy.a(android.net.Uri):java.io.File");
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f1185d = m725a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public static Uri m724a(Context context, String str, File file) {
        return m725a(context, str).mo265a(file);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        uri = this.f1185d.mo266a(uri);
        if (strArr == null) {
            strArr = f1182a;
        }
        strArr2 = new String[strArr.length];
        str2 = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            int i3;
            Object obj = strArr[i];
            if ("_display_name".equals(obj)) {
                strArr2[i2] = "_display_name";
                i3 = i2 + 1;
                str2[i2] = uri.getName();
            } else if ("_size".equals(obj)) {
                strArr2[i2] = "_size";
                i3 = i2 + 1;
                str2[i2] = Long.valueOf(uri.length());
            } else {
                i++;
            }
            i2 = i3;
            i++;
        }
        uri = new String[i2];
        System.arraycopy(strArr2, 0, uri, 0, i2);
        strArr = new Object[i2];
        System.arraycopy(str2, 0, strArr, 0, i2);
        str = new MatrixCursor(uri, 1);
        str.addRow(strArr);
        return str;
    }

    public String getType(Uri uri) {
        uri = this.f1185d.mo266a(uri);
        int lastIndexOf = uri.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            uri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri.getName().substring(lastIndexOf + 1));
            if (uri != null) {
                return uri;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.f1185d.mo266a(uri).delete() != null ? 1 : null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        uri = this.f1185d.mo266a(uri);
        if ("r".equals(str)) {
            str = 268435456;
        } else {
            if (!"w".equals(str)) {
                if (!"wt".equals(str)) {
                    if ("wa".equals(str)) {
                        str = 704643072;
                    } else if ("rw".equals(str)) {
                        str = 939524096;
                    } else if ("rwt".equals(str)) {
                        str = 1006632960;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Invalid mode: ");
                        stringBuilder.append(str);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            str = 738197504;
        }
        return ParcelFileDescriptor.open(uri, str);
    }

    private static PathStrategy m725a(Context context, String str) {
        PathStrategy pathStrategy;
        File a;
        synchronized (f1184c) {
            pathStrategy = (PathStrategy) f1184c.get(str);
            if (pathStrategy == null) {
                try {
                    pathStrategy = new SimplePathStrategy(str);
                    XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
                    if (loadXmlMetaData == null) {
                        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                    }
                    while (true) {
                        int next = loadXmlMetaData.next();
                        if (next == 1) {
                            break;
                        } else if (next == 2) {
                            String name = loadXmlMetaData.getName();
                            File file = null;
                            CharSequence attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                            String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                            if ("root-path".equals(name)) {
                                file = f1183b;
                            } else if ("files-path".equals(name)) {
                                file = context.getFilesDir();
                            } else if ("cache-path".equals(name)) {
                                file = context.getCacheDir();
                            } else if ("external-path".equals(name)) {
                                file = Environment.getExternalStorageDirectory();
                            } else if ("external-files-path".equals(name)) {
                                r3 = ContextCompat.m716a(context);
                                if (r3.length > 0) {
                                    file = r3[0];
                                }
                            } else if ("external-cache-path".equals(name)) {
                                r3 = ContextCompat.m718b(context);
                                if (r3.length > 0) {
                                    file = r3[0];
                                }
                            }
                            if (file != null) {
                                a = m726a(file, attributeValue2);
                                if (TextUtils.isEmpty(attributeValue)) {
                                    throw new IllegalArgumentException("Name must not be empty");
                                }
                                pathStrategy.f11413a.put(attributeValue, a.getCanonicalFile());
                            } else {
                                continue;
                            }
                        }
                    }
                    f1184c.put(str, pathStrategy);
                } catch (Context context2) {
                    StringBuilder stringBuilder = new StringBuilder("Failed to resolve canonical path for ");
                    stringBuilder.append(a);
                    throw new IllegalArgumentException(stringBuilder.toString(), context2);
                } catch (Context context22) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", context22);
                } catch (Context context222) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", context222);
                }
            }
        }
        return pathStrategy;
    }

    private static File m726a(File file, String... strArr) {
        File file2 = file;
        for (file = null; file <= null; file++) {
            String str = strArr[0];
            if (str != null) {
                file2 = new File(file2, str);
            }
        }
        return file2;
    }
}
