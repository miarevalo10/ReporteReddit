package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.evernote.android.state.StateSaver;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.zzf;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.instabug.library.model.State;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedList;

@zzzv
public final class zzajr {
    public static final Handler f6473a = new Handler(Looper.getMainLooper());
    private static final String f6474b = AdView.class.getName();
    private static final String f6475c = InterstitialAd.class.getName();
    private static final String f6476d = PublisherAdView.class.getName();
    private static final String f6477e = PublisherInterstitialAd.class.getName();
    private static final String f6478f = SearchAdView.class.getName();
    private static final String f6479g = AdLoader.class.getName();

    public static int m5318a(Context context, int i) {
        return m5319a(context.getResources().getDisplayMetrics(), i);
    }

    public static int m5319a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public static String m5320a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m5328a()) {
            string = "emulator";
        }
        return m5321a(string);
    }

    public static java.lang.String m5321a(java.lang.String r9) {
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
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = 2;
        r3 = 0;
        if (r1 >= r2) goto L_0x002e;
    L_0x0006:
        r2 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r4 = r9.getBytes();	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2.update(r4);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r4 = java.util.Locale.US;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r5 = "%032X";	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r6 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r7 = new java.lang.Object[r6];	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r8 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = r2.digest();	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r8.<init>(r6, r2);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r7[r0] = r8;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = java.lang.String.format(r4, r5, r7);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        return r2;
    L_0x002a:
        return r3;
    L_0x002b:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x002e:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajr.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m5322a(java.lang.StackTraceElement[] r5, java.lang.String r6) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = r0 + 1;
        r2 = 0;
        r3 = r5.length;
        if (r1 >= r3) goto L_0x0052;
    L_0x0007:
        r0 = r5[r0];
        r3 = r0.getClassName();
        r0 = r0.getMethodName();
        r4 = "loadAd";
        r0 = r4.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x0050;
    L_0x0019:
        r0 = f6474b;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 != 0) goto L_0x0049;
    L_0x0021:
        r0 = f6475c;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 != 0) goto L_0x0049;
    L_0x0029:
        r0 = f6476d;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 != 0) goto L_0x0049;
    L_0x0031:
        r0 = f6477e;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 != 0) goto L_0x0049;
    L_0x0039:
        r0 = f6478f;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 != 0) goto L_0x0049;
    L_0x0041:
        r0 = f6479g;
        r0 = r0.equalsIgnoreCase(r3);
        if (r0 == 0) goto L_0x0050;
    L_0x0049:
        r5 = r5[r1];
        r5 = r5.getClassName();
        goto L_0x0053;
    L_0x0050:
        r0 = r1;
        goto L_0x0001;
    L_0x0052:
        r5 = r2;
    L_0x0053:
        if (r6 == 0) goto L_0x0094;
    L_0x0055:
        r0 = ".";
        r1 = new java.util.StringTokenizer;
        r1.<init>(r6, r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = 2;
        r4 = r1.hasMoreElements();
        if (r4 == 0) goto L_0x008b;
    L_0x0068:
        r6 = r1.nextToken();
        r0.append(r6);
    L_0x006f:
        r6 = r3 + -1;
        if (r3 <= 0) goto L_0x0087;
    L_0x0073:
        r3 = r1.hasMoreElements();
        if (r3 == 0) goto L_0x0087;
    L_0x0079:
        r3 = ".";
        r0.append(r3);
        r3 = r1.nextToken();
        r0.append(r3);
        r3 = r6;
        goto L_0x006f;
    L_0x0087:
        r6 = r0.toString();
    L_0x008b:
        if (r5 == 0) goto L_0x0094;
    L_0x008d:
        r6 = r5.contains(r6);
        if (r6 != 0) goto L_0x0094;
    L_0x0093:
        return r5;
    L_0x0094:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajr.a(java.lang.StackTraceElement[], java.lang.String):java.lang.String");
    }

    public static Throwable m5323a(Throwable th) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.f7893c)).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        th = null;
        while (!linkedList.isEmpty()) {
            Throwable th2 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th2.getClass().getName(), "<filtered>", "<filtered>", 1));
            int length = stackTrace.length;
            int i = 0;
            int i2 = i;
            while (i < length) {
                Object obj = stackTrace[i];
                if (m5333b(obj.getClassName())) {
                    arrayList.add(obj);
                    i2 = 1;
                } else {
                    String className = obj.getClassName();
                    int i3 = (TextUtils.isEmpty(className) || !(className.startsWith(StateSaver.ANDROID_PREFIX) || className.startsWith(StateSaver.JAVA_PREFIX))) ? 0 : 1;
                    if (i3 == 0) {
                        obj = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(obj);
                }
                i++;
            }
            if (i2 != 0) {
                th = th == null ? new Throwable(th2.getMessage()) : new Throwable(th2.getMessage(), th);
                th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th;
    }

    public static void m5324a(Context context, String str, Bundle bundle) {
        m5325a(context, null, str, bundle, true, new zzajs());
    }

    public static void m5325a(Context context, String str, String str2, Bundle bundle, boolean z, zzaju com_google_android_gms_internal_zzaju) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString(State.KEY_OS, VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                zzf.m4930b();
                int d = zzf.m4934d(context);
                StringBuilder stringBuilder = new StringBuilder(23);
                stringBuilder.append(d);
                stringBuilder.append(".11910000");
                str = stringBuilder.toString();
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str22 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str22, bundle.getString(str22));
        }
        com_google_android_gms_internal_zzaju.mo1719a(appendQueryParameter.toString());
    }

    public static void m5327a(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static boolean m5328a() {
        return Build.DEVICE.startsWith("generic");
    }

    public static int m5329b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m5330b(displayMetrics, i);
    }

    public static int m5330b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public static String m5331b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
    }

    public static boolean m5332b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m5333b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzkb.m6350f().m6488a(zznh.f7894d))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzzv.class);
        } catch (Throwable e) {
            String str2 = "Fail to check class type for class ";
            str = String.valueOf(str);
            zzakb.m5364a(str.length() != 0 ? str2.concat(str) : new String(str2), e);
            return false;
        }
    }

    public static java.lang.String m5334c() {
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
        r0 = java.util.UUID.randomUUID();
        r1 = r0.getLeastSignificantBits();
        r1 = java.math.BigInteger.valueOf(r1);
        r1 = r1.toByteArray();
        r2 = r0.getMostSignificantBits();
        r0 = java.math.BigInteger.valueOf(r2);
        r0 = r0.toByteArray();
        r2 = new java.math.BigInteger;
        r3 = 1;
        r2.<init>(r3, r1);
        r2 = r2.toString();
        r4 = 0;
        r5 = r2;
        r2 = r4;
    L_0x0029:
        r6 = 2;
        if (r2 >= r6) goto L_0x0050;
    L_0x002c:
        r6 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = java.security.MessageDigest.getInstance(r6);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.update(r1);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.update(r0);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r7 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r8 = new byte[r7];	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = r6.digest();	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        java.lang.System.arraycopy(r6, r4, r8, r4, r7);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.<init>(r3, r8);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = r6.toString();	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r5 = r6;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x0029;
    L_0x0050:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajr.c():java.lang.String");
    }

    public static boolean m5335c(Context context) {
        return zzf.m4930b().mo1537a(context) == 0;
    }

    public static int m5336d(Context context) {
        return DynamiteModule.m4960b(context, ModuleDescriptor.MODULE_ID);
    }

    public static int m5337e(Context context) {
        return DynamiteModule.m4953a(context, ModuleDescriptor.MODULE_ID);
    }

    public static boolean m5338f(Context context) {
        int a = zzf.m4930b().mo1537a(context);
        if (a != 0) {
            if (a != 2) {
                return false;
            }
        }
        return true;
    }

    public static boolean m5339g(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @android.annotation.TargetApi(17)
    public static boolean m5340h(android.content.Context r6) {
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
        r0 = r6.getResources();
        r0 = r0.getDisplayMetrics();
        r1 = "window";
        r6 = r6.getSystemService(r1);
        r6 = (android.view.WindowManager) r6;
        r6 = r6.getDefaultDisplay();
        r1 = com.google.android.gms.common.util.zzq.m4911c();
        r2 = 0;
        if (r1 == 0) goto L_0x0023;
    L_0x001b:
        r6.getRealMetrics(r0);
        r1 = r0.heightPixels;
        r3 = r0.widthPixels;
        goto L_0x004f;
    L_0x0023:
        r1 = android.view.Display.class;	 Catch:{ Exception -> 0x005c }
        r3 = "getRawHeight";	 Catch:{ Exception -> 0x005c }
        r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x005c }
        r1 = r1.getMethod(r3, r4);	 Catch:{ Exception -> 0x005c }
        r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x005c }
        r1 = r1.invoke(r6, r3);	 Catch:{ Exception -> 0x005c }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x005c }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x005c }
        r3 = android.view.Display.class;	 Catch:{ Exception -> 0x005c }
        r4 = "getRawWidth";	 Catch:{ Exception -> 0x005c }
        r5 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x005c }
        r3 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x005c }
        r4 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x005c }
        r3 = r3.invoke(r6, r4);	 Catch:{ Exception -> 0x005c }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x005c }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x005c }
    L_0x004f:
        r6.getMetrics(r0);
        r6 = r0.heightPixels;
        r0 = r0.widthPixels;
        if (r6 != r1) goto L_0x005c;
    L_0x0058:
        if (r0 != r3) goto L_0x005c;
    L_0x005a:
        r6 = 1;
        return r6;
    L_0x005c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajr.h(android.content.Context):boolean");
    }

    public static int m5341i(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public static void m5326a(ViewGroup viewGroup, zzjn com_google_android_gms_internal_zzjn, String str, String str2) {
        zzakb.m5371e(str2);
        if (viewGroup.getChildCount() == null) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-16777216);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(-65536);
            str = m5318a(context, 3);
            frameLayout.addView(textView, new LayoutParams(com_google_android_gms_internal_zzjn.f18157f - str, com_google_android_gms_internal_zzjn.f18154c - str, 17));
            viewGroup.addView(frameLayout, com_google_android_gms_internal_zzjn.f18157f, com_google_android_gms_internal_zzjn.f18154c);
        }
    }
}
