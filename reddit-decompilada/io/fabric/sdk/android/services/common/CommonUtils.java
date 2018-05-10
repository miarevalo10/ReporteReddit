package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.Fabric;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonUtils {
    public static final Comparator<File> f24733a = new C21141();
    private static Boolean f24734b = null;
    private static final char[] f24735c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long f24736d = -1;

    static class C21141 implements Comparator<File> {
        C21141() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((File) obj).lastModified() - ((File) obj2).lastModified());
        }
    }

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> f24731k = null;

        static {
            Map hashMap = new HashMap(4);
            f24731k = hashMap;
            hashMap.put("armeabi-v7a", ARMV7);
            f24731k.put("armeabi", ARMV6);
            f24731k.put("arm64-v8a", ARM64);
            f24731k.put("x86", X86_32);
        }

        static Architecture m26276a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                Fabric.m26243b().mo5562a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) f24731k.get(obj.toLowerCase(Locale.US));
            if (architecture == null) {
                architecture = UNKNOWN;
            }
            return architecture;
        }
    }

    public static String m26300b(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return Operation.EMPTY_PARAM;
        }
    }

    public static SharedPreferences m26282a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    private static String m26284a(File file, String str) {
        String str2 = null;
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e) {
                        str = e;
                    }
                }
                str2 = split[1];
            } catch (Exception e2) {
                str = e2;
                bufferedReader = null;
                try {
                    StringBuilder stringBuilder = new StringBuilder("Error parsing ");
                    stringBuilder.append(file);
                    Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), str);
                    m26294a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th) {
                    file = th;
                    m26294a(bufferedReader, "Failed to close system file reader.");
                    throw file;
                }
            } catch (Throwable th2) {
                file = th2;
                bufferedReader = null;
                m26294a(bufferedReader, "Failed to close system file reader.");
                throw file;
            }
            m26294a(bufferedReader, "Failed to close system file reader.");
        }
        return str2;
    }

    public static int m26277a() {
        return Architecture.m26276a().ordinal();
    }

    public static synchronized long m26298b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f24736d == -1) {
                long a;
                Object a2 = m26284a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    String toUpperCase = a2.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            a = m26280a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            a = m26280a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            a = m26280a(toUpperCase, "GB", 1073741824);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder("Unexpected meminfo format while computing RAM: ");
                            stringBuilder.append(toUpperCase);
                            Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
                        }
                    } catch (Throwable e) {
                        StringBuilder stringBuilder2 = new StringBuilder("Unexpected meminfo format while computing RAM: ");
                        stringBuilder2.append(toUpperCase);
                        Fabric.m26243b().mo5568c("Fabric", stringBuilder2.toString(), e);
                    }
                    f24736d = a;
                }
                a = 0;
                f24736d = a;
            }
            j = f24736d;
        }
        return j;
    }

    private static long m26280a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[null].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m26281a(String str, Context context) {
        Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m26285a(InputStream inputStream) throws IOException {
        inputStream = new Scanner(inputStream).useDelimiter("\\A");
        return inputStream.hasNext() ? inputStream.next() : "";
    }

    public static String m26287a(String str) {
        return m26288a(str, "SHA-1");
    }

    public static String m26301b(String str) {
        return m26288a(str, "SHA-256");
    }

    private static String m26288a(String str, String str2) {
        return m26290a(str.getBytes(), str2);
    }

    private static String m26286a(InputStream inputStream, String str) {
        try {
            str = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m26289a(str.digest());
                }
                str.update(bArr, 0, read);
            }
        } catch (InputStream inputStream2) {
            Fabric.m26243b().mo5568c("Fabric", "Could not calculate hash for app icon.", inputStream2);
            return "";
        }
    }

    private static String m26290a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return m26289a(instance.digest());
        } catch (byte[] bArr2) {
            StringBuilder stringBuilder = new StringBuilder("Could not create hashing algorithm: ");
            stringBuilder.append(str);
            stringBuilder.append(", returning empty string.");
            Fabric.m26243b().mo5568c("Fabric", stringBuilder.toString(), bArr2);
            return "";
        }
    }

    public static String m26291a(String... strArr) {
        List<String> arrayList = new ArrayList();
        for (int i = 0; i <= 0; i++) {
            String str = strArr[0];
            if (str != null) {
                arrayList.add(str.replace(Operation.MINUS, "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        strArr = new StringBuilder();
        for (String append : arrayList) {
            strArr.append(append);
        }
        String stringBuilder = strArr.toString();
        return stringBuilder.length() > 0 ? m26288a(stringBuilder, "SHA-1") : null;
    }

    public static long m26299b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m26303c(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static Float m26304c(Context context) {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (context == null) {
            return null;
        }
        return Float.valueOf(((float) context.getIntExtra("level", -1)) / ((float) context.getIntExtra("scale", -1)));
    }

    public static boolean m26307d(Context context) {
        if (m26309e(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) {
            return false;
        }
        return true;
    }

    public static void m26292a(Context context, String str) {
        if (m26317m(context) != null) {
            Fabric.m26243b().mo5562a("Fabric", str);
        }
    }

    public static void m26302b(Context context, String str) {
        if (m26317m(context) != null) {
            Fabric.m26243b().mo5570e("Fabric", str);
        }
    }

    public static void m26305c(Context context, String str) {
        if (m26317m(context) != null) {
            Fabric.m26243b().mo5560a(4, "Fabric", str);
        }
    }

    private static boolean m26317m(Context context) {
        if (f24734b == null) {
            f24734b = Boolean.valueOf(m26297a(context, "com.crashlytics.Trace", false));
        }
        return f24734b.booleanValue();
    }

    public static boolean m26297a(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a = m26278a(context, str, "bool");
                if (a > 0) {
                    return resources.getBoolean(a);
                }
                str = m26278a(context, str, "string");
                if (str > null) {
                    return Boolean.parseBoolean(context.getString(str));
                }
            }
        }
        return z;
    }

    public static int m26278a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            context = context.getResources().getResourcePackageName(i);
        } else {
            context = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, context);
    }

    public static boolean m26309e(Context context) {
        context = Secure.getString(context.getContentResolver(), "android_id");
        if (!("sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT))) {
            if (context != null) {
                return null;
            }
        }
        return true;
    }

    public static boolean m26310f(Context context) {
        context = m26309e(context);
        String str = Build.TAGS;
        if ((context == null && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (context != null || file.exists() == null) {
            return null;
        }
        return true;
    }

    public static int m26311g(Context context) {
        int e = m26309e(context);
        if (m26310f(context) != null) {
            e |= 2;
        }
        if (Debug.isDebuggerConnected() == null) {
            if (Debug.waitingForDebugger() == null) {
                context = null;
                return context == null ? e | 4 : e;
            }
        }
        context = true;
        if (context == null) {
        }
    }

    public static int m26279a(Context context, boolean z) {
        context = m26304c(context);
        if (z) {
            if (context != null) {
                if (((double) context.floatValue()) >= 99.0d) {
                    return 3;
                }
                return ((double) context.floatValue()) < 4636666922610458624 ? 2 : null;
            }
        }
        return 1;
    }

    public static String m26289a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = f24735c[i2 >>> 4];
            cArr[i3 + 1] = f24735c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m26312h(Context context) {
        return (context.getApplicationInfo().flags & 2) != null ? true : null;
    }

    public static String m26306d(Context context, String str) {
        str = m26278a(context, str, "string");
        return str > null ? context.getString(str) : "";
    }

    public static void m26294a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                Fabric.m26243b().mo5568c("Fabric", str, closeable2);
            }
        }
    }

    public static void m26295a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Flushable flushable2) {
                Fabric.m26243b().mo5568c("Fabric", str, flushable2);
            }
        }
    }

    public static boolean m26308d(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    public static String m26283a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static void m26296a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m26313i(Context context) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(m26314j(context));
            try {
                String a = m26286a((InputStream) openRawResource, "SHA-1");
                if (!m26308d(a)) {
                    str = a;
                }
                m26294a(openRawResource, "Failed to close icon input stream.");
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    Fabric.m26243b().mo5568c("Fabric", "Could not calculate hash for app icon.", e);
                    m26294a(openRawResource, "Failed to close icon input stream.");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    m26294a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            Fabric.m26243b().mo5568c("Fabric", "Could not calculate hash for app icon.", e);
            m26294a(openRawResource, "Failed to close icon input stream.");
            return null;
        } catch (Context context2) {
            th = context2;
            openRawResource = null;
            m26294a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
    }

    public static int m26314j(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m26315k(Context context) {
        int a = m26278a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = m26278a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        context = context.getResources().getString(a);
        StringBuilder stringBuilder = new StringBuilder("Build ID is: ");
        stringBuilder.append(context);
        Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
        return context;
    }

    public static void m26293a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.CommonUtils.a(java.io.Closeable):void");
    }

    @SuppressLint({"MissingPermission"})
    public static boolean m26316l(Context context) {
        if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
            return true;
        }
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (context == null || context.isConnectedOrConnecting() == null) ? false : true;
    }
}
