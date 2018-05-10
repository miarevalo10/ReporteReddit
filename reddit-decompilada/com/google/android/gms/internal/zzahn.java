package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.support.customtabs.CustomTabsClient;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.instabug.chat.model.Attachment;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzahn {
    public static final Handler f6379a = new zzagg(Looper.getMainLooper());
    public boolean f6380b = false;
    private final Object f6381c = new Object();
    private boolean f6382d = true;
    private String f6383e;
    private boolean f6384f = false;
    private Pattern f6385g;
    private Pattern f6386h;

    public static Bitmap m5151a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Uri m5152a(String str, String str2, String str3) throws UnsupportedOperationException {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        indexOf++;
        StringBuilder stringBuilder = new StringBuilder(str.substring(0, indexOf));
        stringBuilder.append(str2);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(str3);
        stringBuilder.append("&");
        stringBuilder.append(str.substring(indexOf));
        return Uri.parse(stringBuilder.toString());
    }

    public static DisplayMetrics m5154a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow m5155a(View view, int i, int i2) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String m5157a() {
        return UUID.randomUUID().toString();
    }

    public static String m5158a(Context context, View view, zzjn com_google_android_gms_internal_zzjn) {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.ae)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", com_google_android_gms_internal_zzjn.f18156e);
            jSONObject2.put("height", com_google_android_gms_internal_zzjn.f18153b);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", m5223o(context));
            if (!com_google_android_gms_internal_zzjn.f18155d) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", i);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            zzakb.m5369c("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public static String m5161a(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[MPEGConst.CODE_END];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public static String m5162a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static Map<String, String> m5163a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Map hashMap = new HashMap();
        for (String str : zzbs.m4488g().mo3437a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    private final JSONArray m5164a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m5174a(jSONArray, a);
        }
        return jSONArray;
    }

    public static void m5165a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void m5166a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public static void m5167a(android.content.Context r1, android.content.Intent r2) {
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
        r1.startActivity(r2);	 Catch:{ Throwable -> 0x0004 }
        return;
    L_0x0004:
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.addFlags(r0);
        r1.startActivity(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.a(android.content.Context, android.content.Intent):void");
    }

    @TargetApi(18)
    public static void m5168a(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cv)).booleanValue()) {
                m5191b(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder stringBuilder = new StringBuilder(26 + String.valueOf(uri2).length());
            stringBuilder.append("Opening ");
            stringBuilder.append(uri2);
            stringBuilder.append(" in a new browser.");
            zzakb.m5366b(stringBuilder.toString());
        } catch (Throwable e) {
            zzakb.m5367b("No browser is found.", e);
        }
    }

    public static void m5169a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            String str3 = State.KEY_DEVICE;
            zzbs.m4486e();
            bundle.putString(str3, m5187b());
            bundle.putString("eids", TextUtils.join(",", zznh.m6489a()));
        }
        zzkb.m6345a();
        zzajr.m5325a(context, str, str2, bundle, z, new zzahq(context, str));
    }

    public static void m5170a(Context context, String str, List<String> list) {
        for (String com_google_android_gms_internal_zzajh : list) {
            new zzajh(context, str, com_google_android_gms_internal_zzajh).mo1645e();
        }
    }

    public static void m5172a(zzjj com_google_android_gms_internal_zzjj) {
        Bundle bundle = com_google_android_gms_internal_zzjj.f18146m != null ? com_google_android_gms_internal_zzjj.f18146m : new Bundle();
        if (bundle.getBundle(AdMobAdapter.class.getName()) != null) {
            bundle = bundle.getBundle(AdMobAdapter.class.getName());
        } else {
            Bundle bundle2 = new Bundle();
            bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            bundle = bundle2;
        }
        bundle.putBoolean("render_test_label", true);
    }

    public static void m5173a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f6379a.post(runnable);
        }
    }

    private final void m5174a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            obj = m5189b((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = m5227a((Map) obj);
        } else if (obj instanceof Collection) {
            obj = m5164a((Collection) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            JSONArray jSONArray2 = new JSONArray();
            for (Object a : objArr) {
                m5174a(jSONArray2, a);
            }
            jSONArray.put(jSONArray2);
            return;
        } else {
            jSONArray.put(obj);
            return;
        }
        jSONArray.put(obj);
    }

    private final void m5175a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            obj = m5189b((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = m5227a((Map) obj);
        } else {
            Collection collection;
            if (obj instanceof Collection) {
                if (str == null) {
                    str = "null";
                }
                collection = (Collection) obj;
            } else if (obj instanceof Object[]) {
                collection = Arrays.asList((Object[]) obj);
            } else {
                jSONObject.put(str, obj);
                return;
            }
            obj = m5164a(collection);
        }
        jSONObject.put(str, obj);
    }

    private static boolean m5176a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @TargetApi(24)
    public static boolean m5177a(Activity activity, Configuration configuration) {
        zzkb.m6345a();
        int a = zzajr.m5318a((Context) activity, configuration.screenHeightDp);
        int a2 = zzajr.m5318a((Context) activity, configuration.screenWidthDp);
        DisplayMetrics a3 = m5154a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = a3.heightPixels;
        int i2 = a3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        identifier = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzkb.m6350f().m6488a(zznh.cF)).intValue();
        return m5176a(i, a + identifier, round) && m5176a(i2, a2, round);
    }

    public static boolean m5178a(Context context) {
        String format;
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity != null) {
            if (resolveActivity.activityInfo != null) {
                boolean z;
                String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
                if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{"keyboard"}));
                    z = false;
                } else {
                    z = true;
                }
                if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{"keyboardHidden"}));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{State.KEY_ORIENTATION}));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{"screenLayout"}));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{"uiMode"}));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
                    zzakb.m5371e(String.format(str, new Object[]{"screenSize"}));
                    z = false;
                }
                if ((resolveActivity.activityInfo.configChanges & MPEGConst.CODE_END) != 0) {
                    return z;
                }
                format = String.format(str, new Object[]{"smallestScreenSize"});
                zzakb.m5371e(format);
                return false;
            }
        }
        format = "Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.";
        zzakb.m5371e(format);
        return false;
    }

    public static boolean m5180a(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return m5181a(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, m5224p(context));
    }

    public static boolean m5181a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        boolean z2;
        if (!zzbs.m4486e().f6382d) {
            if (keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) {
                if (!((Boolean) zzkb.m6350f().m6488a(zznh.ba)).booleanValue() || !m5200c(view)) {
                    z = false;
                    if (view.getVisibility() == 0 && view.isShown()) {
                        if (powerManager != null) {
                            if (powerManager.isScreenOn()) {
                                z2 = false;
                                if (z2 && r5) {
                                    if (((Boolean) zzkb.m6350f().m6488a(zznh.aY)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                                        return true;
                                    }
                                }
                            }
                        }
                        z2 = true;
                        if (((Boolean) zzkb.m6350f().m6488a(zznh.aY)).booleanValue()) {
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
        z = true;
        if (powerManager != null) {
            if (powerManager.isScreenOn()) {
                z2 = false;
                if (((Boolean) zzkb.m6350f().m6488a(zznh.aY)).booleanValue()) {
                }
                return true;
            }
        }
        z2 = true;
        if (((Boolean) zzkb.m6350f().m6488a(zznh.aY)).booleanValue()) {
        }
        return true;
    }

    public static boolean m5183a(java.lang.ClassLoader r1, java.lang.Class<?> r2, java.lang.String r3) {
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
        r1 = java.lang.Class.forName(r3, r0, r1);	 Catch:{ Throwable -> 0x000a }
        r1 = r2.isAssignableFrom(r1);	 Catch:{ Throwable -> 0x000a }
        return r1;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.a(java.lang.ClassLoader, java.lang.Class, java.lang.String):boolean");
    }

    public static int[] m5184a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m5215g();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public static int m5185b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(22 + String.valueOf(str).length());
            stringBuilder.append("Could not parse value:");
            stringBuilder.append(str);
            zzakb.m5371e(stringBuilder.toString());
            return 0;
        }
    }

    public static Bitmap m5186b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap f = m5209f(view);
        if (f == null) {
            f = m5206e(view);
        }
        return f;
    }

    public static String m5187b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static java.lang.String m5188b(android.content.Context r1, java.lang.String r2) {
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
        r1 = r1.openFileInput(r2);	 Catch:{ IOException -> 0x0010 }
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x0010 }
        r1 = com.google.android.gms.common.util.zzn.m4908a(r1);	 Catch:{ IOException -> 0x0010 }
        r0 = "UTF-8";	 Catch:{ IOException -> 0x0010 }
        r2.<init>(r1, r0);	 Catch:{ IOException -> 0x0010 }
        return r2;
    L_0x0010:
        r1 = "Error reading from internal storage.";
        com.google.android.gms.internal.zzakb.m5366b(r1);
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.b(android.content.Context, java.lang.String):java.lang.String");
    }

    private final JSONObject m5189b(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m5175a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m5190b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    @TargetApi(18)
    public static void m5191b(Context context, Intent intent) {
        if (intent != null && zzq.m4912d()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void m5192b(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m5170a(context, str, arrayList);
    }

    public static void m5193b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bd)).booleanValue()) {
            m5169a(context, str, str2, bundle, z);
        }
    }

    public static void m5194b(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzahh.m5148a(runnable);
        }
    }

    public static boolean m5195b(zzjj com_google_android_gms_internal_zzjj) {
        Bundle bundle = com_google_android_gms_internal_zzjj.f18146m != null ? com_google_android_gms_internal_zzjj.f18146m : new Bundle();
        return (bundle.getBundle(AdMobAdapter.class.getName()) != null ? bundle.getBundle(AdMobAdapter.class.getName()) : new Bundle()).getBoolean("render_test_label", false);
    }

    public static int[] m5196b(Activity activity) {
        int[] a = m5184a(activity);
        r1 = new int[2];
        zzkb.m6345a();
        r1[0] = zzajr.m5329b((Context) activity, a[0]);
        zzkb.m6345a();
        r1[1] = zzajr.m5329b((Context) activity, a[1]);
        return r1;
    }

    public static float m5197c() {
        return zzbs.m4479B().m5258a();
    }

    protected static java.lang.String m5198c(android.content.Context r1) {
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
        r0 = new android.webkit.WebView;	 Catch:{ Throwable -> 0x000e }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x000e }
        r1 = r0.getSettings();	 Catch:{ Throwable -> 0x000e }
        r1 = r1.getUserAgentString();	 Catch:{ Throwable -> 0x000e }
        return r1;
    L_0x000e:
        r1 = m5210f();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.c(android.content.Context):java.lang.String");
    }

    public static void m5199c(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Throwable e) {
            zzakb.m5367b("Error writing to file in internal storage.", e);
        }
    }

    public static boolean m5200c(View view) {
        Activity activity;
        Window window;
        view = view.getRootView();
        LayoutParams layoutParams = null;
        if (view != null) {
            Context context = view.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
                if (activity == null) {
                    return false;
                }
                window = activity.getWindow();
                if (window == null) {
                    layoutParams = window.getAttributes();
                }
                return layoutParams == null && (layoutParams.flags & 524288) != 0;
            }
        }
        activity = null;
        if (activity == null) {
            return false;
        }
        window = activity.getWindow();
        if (window == null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams == null) {
        }
    }

    public static boolean m5201c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static int[] m5202c(Activity activity) {
        Window window = activity.getWindow();
        int[] g = (window == null || window.findViewById(16908290) == null) ? m5215g() : new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
        r0 = new int[2];
        zzkb.m6345a();
        r0[0] = zzajr.m5329b((Context) activity, g[0]);
        zzkb.m6345a();
        r0[1] = zzajr.m5329b((Context) activity, g[1]);
        return r0;
    }

    public static int m5203d(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public static Builder m5204d(Context context) {
        return new Builder(context);
    }

    public static boolean m5205d() {
        return zzbs.m4479B().m5261b();
    }

    private static Bitmap m5206e(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0) {
                if (height != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    view.layout(0, 0, width, height);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            zzakb.m5371e("Width or height of view is zero");
            return null;
        } catch (Throwable e) {
            zzakb.m5367b("Fail to capture the webview", e);
            return null;
        }
    }

    public static zzmt m5208e(Context context) {
        return new zzmt(context);
    }

    private static Bitmap m5209f(View view) {
        Bitmap bitmap = null;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            return bitmap;
        } catch (Throwable e) {
            zzakb.m5367b("Fail to capture the web view", e);
            return null;
        }
    }

    private static String m5210f() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ");
            stringBuffer.append(VERSION.RELEASE);
        }
        stringBuffer.append("; ");
        stringBuffer.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ");
            stringBuffer.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/");
                stringBuffer.append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String m5211f(String str) {
        return TextUtils.isEmpty(str) ? "" : str.split(";")[0].trim();
    }

    public static boolean m5212f(android.content.Context r6) {
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
        r1 = "activity";	 Catch:{ Throwable -> 0x0055 }
        r1 = r6.getSystemService(r1);	 Catch:{ Throwable -> 0x0055 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0055 }
        r2 = "keyguard";	 Catch:{ Throwable -> 0x0055 }
        r2 = r6.getSystemService(r2);	 Catch:{ Throwable -> 0x0055 }
        r2 = (android.app.KeyguardManager) r2;	 Catch:{ Throwable -> 0x0055 }
        if (r1 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0013:
        if (r2 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0055 }
    L_0x0015:
        return r0;	 Catch:{ Throwable -> 0x0055 }
    L_0x0016:
        r1 = r1.getRunningAppProcesses();	 Catch:{ Throwable -> 0x0055 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0055 }
    L_0x001c:
        return r0;	 Catch:{ Throwable -> 0x0055 }
    L_0x001d:
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0055 }
    L_0x0021:
        r3 = r1.hasNext();	 Catch:{ Throwable -> 0x0055 }
        if (r3 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0027:
        r3 = r1.next();	 Catch:{ Throwable -> 0x0055 }
        r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3;	 Catch:{ Throwable -> 0x0055 }
        r4 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0055 }
        r5 = r3.pid;	 Catch:{ Throwable -> 0x0055 }
        if (r4 != r5) goto L_0x0021;	 Catch:{ Throwable -> 0x0055 }
    L_0x0035:
        r1 = r3.importance;	 Catch:{ Throwable -> 0x0055 }
        r3 = 100;	 Catch:{ Throwable -> 0x0055 }
        if (r1 != r3) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x003b:
        r1 = r2.inKeyguardRestrictedInputMode();	 Catch:{ Throwable -> 0x0055 }
        if (r1 != 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0041:
        r1 = "power";	 Catch:{ Throwable -> 0x0055 }
        r6 = r6.getSystemService(r1);	 Catch:{ Throwable -> 0x0055 }
        r6 = (android.os.PowerManager) r6;	 Catch:{ Throwable -> 0x0055 }
        if (r6 != 0) goto L_0x004d;	 Catch:{ Throwable -> 0x0055 }
    L_0x004b:
        r6 = r0;	 Catch:{ Throwable -> 0x0055 }
        goto L_0x0051;	 Catch:{ Throwable -> 0x0055 }
    L_0x004d:
        r6 = r6.isScreenOn();	 Catch:{ Throwable -> 0x0055 }
    L_0x0051:
        if (r6 == 0) goto L_0x0055;
    L_0x0053:
        r6 = 1;
        return r6;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.f(android.content.Context):boolean");
    }

    public static Bitmap m5213g(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            Bitmap f;
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bF)).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    f = m5209f(window.getDecorView().getRootView());
                }
                return null;
            }
            f = m5206e(((Activity) context).getWindow().getDecorView());
            return f;
        } catch (Throwable e) {
            zzakb.m5367b("Fail to capture screen shot", e);
        }
    }

    public static String m5214g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(";");
        if (split.length == 1) {
            return "";
        }
        for (int i = 1; i < split.length; i++) {
            if (split[i].trim().startsWith(HttpRequest.PARAM_CHARSET)) {
                String[] split2 = split[i].trim().split(Operation.EQUALS);
                if (split2.length > 1) {
                    return split2[1].trim();
                }
            }
        }
        return "";
    }

    private static int[] m5215g() {
        return new int[]{0, 0};
    }

    public static AudioManager m5216h(Context context) {
        return (AudioManager) context.getSystemService(Attachment.TYPE_AUDIO);
    }

    public static float m5217i(Context context) {
        AudioManager h = m5216h(context);
        if (h == null) {
            return 0.0f;
        }
        int streamMaxVolume = h.getStreamMaxVolume(3);
        return streamMaxVolume == 0 ? 0.0f : ((float) h.getStreamVolume(3)) / ((float) streamMaxVolume);
    }

    public static int m5218j(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    @TargetApi(16)
    public static boolean m5219k(Context context) {
        if (context == null || !zzq.m4910b()) {
            return false;
        }
        KeyguardManager p = m5224p(context);
        if (p != null && p.isKeyguardLocked()) {
            return true;
        }
        return false;
    }

    public static boolean m5220l(android.content.Context r3) {
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
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        r1 = "com.google.android.gms.ads.internal.ClientApi";	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        r3.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r3 = move-exception;
        r1 = "Error loading class.";
        com.google.android.gms.internal.zzakb.m5367b(r1, r3);
        r1 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = "AdUtil.isLiteSdk";
        r1.m13246a(r3, r2);
        return r0;
    L_0x001b:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.l(android.content.Context):boolean");
    }

    public static int m5221m(Context context) {
        return DynamiteModule.m4960b(context, ModuleDescriptor.MODULE_ID);
    }

    public static int m5222n(Context context) {
        return DynamiteModule.m4953a(context, ModuleDescriptor.MODULE_ID);
    }

    private static java.lang.String m5223o(android.content.Context r2) {
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
        r1 = "activity";	 Catch:{ Exception -> 0x002d }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x002d }
        r2 = (android.app.ActivityManager) r2;	 Catch:{ Exception -> 0x002d }
        if (r2 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x002d }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x002d }
    L_0x000c:
        r1 = 1;	 Catch:{ Exception -> 0x002d }
        r2 = r2.getRunningTasks(r1);	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0013:
        r1 = r2.isEmpty();	 Catch:{ Exception -> 0x002d }
        if (r1 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0019:
        r1 = 0;	 Catch:{ Exception -> 0x002d }
        r2 = r2.get(r1);	 Catch:{ Exception -> 0x002d }
        r2 = (android.app.ActivityManager.RunningTaskInfo) r2;	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0022:
        r1 = r2.topActivity;	 Catch:{ Exception -> 0x002d }
        if (r1 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0026:
        r2 = r2.topActivity;	 Catch:{ Exception -> 0x002d }
        r2 = r2.getClassName();	 Catch:{ Exception -> 0x002d }
        return r2;
    L_0x002d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.o(android.content.Context):java.lang.String");
    }

    private static KeyguardManager m5224p(Context context) {
        Object systemService = context.getSystemService("keyguard");
        return (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
    }

    public final java.lang.String m5225a(android.content.Context r5, java.lang.String r6) {
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
        r4 = this;
        r0 = r4.f6381c;
        monitor-enter(r0);
        r1 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        if (r1 == 0) goto L_0x000b;	 Catch:{ all -> 0x00d3 }
    L_0x0007:
        r5 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d3 }
        return r5;	 Catch:{ all -> 0x00d3 }
    L_0x000b:
        if (r6 != 0) goto L_0x0013;	 Catch:{ all -> 0x00d3 }
    L_0x000d:
        r5 = m5210f();	 Catch:{ all -> 0x00d3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d3 }
        return r5;
    L_0x0013:
        r1 = com.google.android.gms.ads.internal.zzbs.m4488g();	 Catch:{ Exception -> 0x001d }
        r1 = r1.mo4388a(r5);	 Catch:{ Exception -> 0x001d }
        r4.f6383e = r1;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r1 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00d3 }
        if (r1 == 0) goto L_0x006e;	 Catch:{ all -> 0x00d3 }
    L_0x0025:
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ all -> 0x00d3 }
        r1 = com.google.android.gms.internal.zzajr.m5332b();	 Catch:{ all -> 0x00d3 }
        if (r1 != 0) goto L_0x0068;	 Catch:{ all -> 0x00d3 }
    L_0x002e:
        r1 = 0;	 Catch:{ all -> 0x00d3 }
        r4.f6383e = r1;	 Catch:{ all -> 0x00d3 }
        r1 = f6379a;	 Catch:{ all -> 0x00d3 }
        r2 = new com.google.android.gms.internal.zzahp;	 Catch:{ all -> 0x00d3 }
        r2.<init>(r4, r5);	 Catch:{ all -> 0x00d3 }
        r1.post(r2);	 Catch:{ all -> 0x00d3 }
    L_0x003b:
        r1 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        if (r1 != 0) goto L_0x006e;
    L_0x003f:
        r1 = r4.f6381c;	 Catch:{ InterruptedException -> 0x0045 }
        r1.wait();	 Catch:{ InterruptedException -> 0x0045 }
        goto L_0x003b;
    L_0x0045:
        r1 = m5210f();	 Catch:{ all -> 0x00d3 }
        r4.f6383e = r1;	 Catch:{ all -> 0x00d3 }
        r1 = "Interrupted, use default user agent: ";	 Catch:{ all -> 0x00d3 }
        r2 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00d3 }
        r3 = r2.length();	 Catch:{ all -> 0x00d3 }
        if (r3 == 0) goto L_0x005e;	 Catch:{ all -> 0x00d3 }
    L_0x0059:
        r1 = r1.concat(r2);	 Catch:{ all -> 0x00d3 }
        goto L_0x0064;	 Catch:{ all -> 0x00d3 }
    L_0x005e:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00d3 }
        r2.<init>(r1);	 Catch:{ all -> 0x00d3 }
        r1 = r2;	 Catch:{ all -> 0x00d3 }
    L_0x0064:
        com.google.android.gms.internal.zzakb.m5371e(r1);	 Catch:{ all -> 0x00d3 }
        goto L_0x003b;	 Catch:{ all -> 0x00d3 }
    L_0x0068:
        r1 = m5198c(r5);	 Catch:{ all -> 0x00d3 }
        r4.f6383e = r1;	 Catch:{ all -> 0x00d3 }
    L_0x006e:
        r1 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00d3 }
        r2 = 10;	 Catch:{ all -> 0x00d3 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00d3 }
        r3 = r3.length();	 Catch:{ all -> 0x00d3 }
        r2 = r2 + r3;	 Catch:{ all -> 0x00d3 }
        r3 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00d3 }
        r3 = r3.length();	 Catch:{ all -> 0x00d3 }
        r2 = r2 + r3;	 Catch:{ all -> 0x00d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d3 }
        r3.<init>(r2);	 Catch:{ all -> 0x00d3 }
        r3.append(r1);	 Catch:{ all -> 0x00d3 }
        r1 = " (Mobile; ";	 Catch:{ all -> 0x00d3 }
        r3.append(r1);	 Catch:{ all -> 0x00d3 }
        r3.append(r6);	 Catch:{ all -> 0x00d3 }
        r6 = r3.toString();	 Catch:{ all -> 0x00d3 }
        r4.f6383e = r6;	 Catch:{ all -> 0x00d3 }
        r5 = com.google.android.gms.internal.zzbhf.m5574a(r5);	 Catch:{ Exception -> 0x00b7 }
        r5 = r5.m5570a();	 Catch:{ Exception -> 0x00b7 }
        if (r5 == 0) goto L_0x00c1;	 Catch:{ Exception -> 0x00b7 }
    L_0x00a8:
        r5 = r4.f6383e;	 Catch:{ Exception -> 0x00b7 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x00b7 }
        r6 = ";aia";	 Catch:{ Exception -> 0x00b7 }
        r5 = r5.concat(r6);	 Catch:{ Exception -> 0x00b7 }
        r4.f6383e = r5;	 Catch:{ Exception -> 0x00b7 }
        goto L_0x00c1;
    L_0x00b7:
        r5 = move-exception;
        r6 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x00d3 }
        r1 = "AdUtil.getUserAgent";	 Catch:{ all -> 0x00d3 }
        r6.m13246a(r5, r1);	 Catch:{ all -> 0x00d3 }
    L_0x00c1:
        r5 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x00d3 }
        r6 = ")";	 Catch:{ all -> 0x00d3 }
        r5 = r5.concat(r6);	 Catch:{ all -> 0x00d3 }
        r4.f6383e = r5;	 Catch:{ all -> 0x00d3 }
        r5 = r4.f6383e;	 Catch:{ all -> 0x00d3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d3 }
        return r5;	 Catch:{ all -> 0x00d3 }
    L_0x00d3:
        r5 = move-exception;	 Catch:{ all -> 0x00d3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d3 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public final JSONObject m5226a(Bundle bundle) {
        if (bundle != null) {
            try {
                return m5189b(bundle);
            } catch (Throwable e) {
                zzakb.m5367b("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    public final JSONObject m5227a(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m5175a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str2 = "Could not convert map to JSON: ";
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public final void m5228a(Context context, String str, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m5225a(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean m5229b(Context context) {
        if (this.f6384f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzahr(), intentFilter);
        this.f6384f = true;
        return true;
    }

    public final boolean m5230d(java.lang.String r4) {
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
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0046 }
        r0 = r3.f6385g;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x000d:
        r0 = com.google.android.gms.internal.zznh.ak;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m6488a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r2 = r3.f6385g;	 Catch:{ all -> 0x0043 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0043 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0037;	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r0 = com.google.android.gms.internal.zznh.ak;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m6488a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0043 }
        r3.f6385g = r0;	 Catch:{ all -> 0x0043 }
    L_0x0037:
        r0 = r3.f6385g;	 Catch:{ all -> 0x0043 }
        r4 = r0.matcher(r4);	 Catch:{ all -> 0x0043 }
        r4 = r4.matches();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        return r4;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r4 = move-exception;	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r4;	 Catch:{ PatternSyntaxException -> 0x0046 }
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.d(java.lang.String):boolean");
    }

    public final boolean m5231e(java.lang.String r4) {
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
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0046 }
        r0 = r3.f6386h;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x000d:
        r0 = com.google.android.gms.internal.zznh.al;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m6488a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r2 = r3.f6386h;	 Catch:{ all -> 0x0043 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0043 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0037;	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r0 = com.google.android.gms.internal.zznh.al;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m6488a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0043 }
        r3.f6386h = r0;	 Catch:{ all -> 0x0043 }
    L_0x0037:
        r0 = r3.f6386h;	 Catch:{ all -> 0x0043 }
        r4 = r0.matcher(r4);	 Catch:{ all -> 0x0043 }
        r4 = r4.matches();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        return r4;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r4 = move-exception;	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r4;	 Catch:{ PatternSyntaxException -> 0x0046 }
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.e(java.lang.String):boolean");
    }

    public static boolean m5179a(Context context, String str, String str2) {
        return zzbhf.m5574a(context).f6711a.getPackageManager().checkPermission(str2, str) == null ? true : null;
    }

    public static void m5171a(Context context, List<String> list) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!TextUtils.isEmpty(zzftr.m6249a(activity))) {
                if (list == null) {
                    context = "Cannot ping urls: empty list.";
                } else if (zzoe.m14110a(context)) {
                    zzoe com_google_android_gms_internal_zzoe = new zzoe();
                    com_google_android_gms_internal_zzoe.f14572d = new zzaho(list, com_google_android_gms_internal_zzoe, context);
                    if (com_google_android_gms_internal_zzoe.f14570b == null) {
                        context = zzftr.m6249a(activity);
                        if (context != null) {
                            com_google_android_gms_internal_zzoe.f14571c = new zzfts(com_google_android_gms_internal_zzoe);
                            CustomTabsClient.m142a(activity, context, com_google_android_gms_internal_zzoe.f14571c);
                        }
                    }
                    return;
                } else {
                    context = "Cannot ping url because custom tabs is not supported";
                }
                zzagf.m13278a(context);
            }
        }
    }

    public static java.lang.String m5159a(android.content.Context r7, com.google.android.gms.internal.zzcv r8, java.lang.String r9, android.view.View r10, android.app.Activity r11) {
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
        if (r8 != 0) goto L_0x0003;
    L_0x0002:
        return r9;
    L_0x0003:
        r0 = android.net.Uri.parse(r9);	 Catch:{ Exception -> 0x0030 }
        r1 = r8.m5821a(r0);	 Catch:{ Exception -> 0x0030 }
        r2 = 0;	 Catch:{ Exception -> 0x0030 }
        if (r1 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0030 }
    L_0x000e:
        r1 = com.google.android.gms.internal.zzcv.f7186a;	 Catch:{ Exception -> 0x0030 }
        r3 = r1.length;	 Catch:{ Exception -> 0x0030 }
        r4 = r2;	 Catch:{ Exception -> 0x0030 }
    L_0x0012:
        if (r4 >= r3) goto L_0x0025;	 Catch:{ Exception -> 0x0030 }
    L_0x0014:
        r5 = r1[r4];	 Catch:{ Exception -> 0x0030 }
        r6 = r0.getPath();	 Catch:{ Exception -> 0x0030 }
        r5 = r6.endsWith(r5);	 Catch:{ Exception -> 0x0030 }
        if (r5 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x0030 }
    L_0x0020:
        r2 = 1;	 Catch:{ Exception -> 0x0030 }
        goto L_0x0025;	 Catch:{ Exception -> 0x0030 }
    L_0x0022:
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0030 }
        goto L_0x0012;	 Catch:{ Exception -> 0x0030 }
    L_0x0025:
        if (r2 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x0030 }
    L_0x0027:
        r0 = r8.m5818a(r0, r7, r10, r11);	 Catch:{ Exception -> 0x0030 }
    L_0x002b:
        r7 = r0.toString();	 Catch:{ Exception -> 0x0030 }
        return r7;
    L_0x0030:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzahn.a(android.content.Context, com.google.android.gms.internal.zzcv, java.lang.String, android.view.View, android.app.Activity):java.lang.String");
    }

    public static Bundle m5207e() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.f7916y)).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.f7917z)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", zzbs.m4490i().f14077f.get());
        } catch (Throwable e) {
            zzakb.m5369c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public static Bundle m5153a(zzhk com_google_android_gms_internal_zzhk) {
        if (com_google_android_gms_internal_zzhk == null) {
            return null;
        }
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.f7881Q)).booleanValue()) {
            if (!((Boolean) zzkb.m6350f().m6488a(zznh.f7883S)).booleanValue()) {
                return null;
            }
        }
        if (zzbs.m4490i().m13248a() && zzbs.m4490i().m13252b()) {
            return null;
        }
        String str;
        String str2;
        if (com_google_android_gms_internal_zzhk.f7670a) {
            synchronized (com_google_android_gms_internal_zzhk.f7671b) {
                com_google_android_gms_internal_zzhk.f7670a = false;
                com_google_android_gms_internal_zzhk.f7671b.notifyAll();
                zzakb.m5366b("ContentFetchThread: wakeup");
            }
        }
        com_google_android_gms_internal_zzhk = com_google_android_gms_internal_zzhk.f7672c.m6279a();
        if (com_google_android_gms_internal_zzhk != null) {
            str = com_google_android_gms_internal_zzhk.f7642f;
            str2 = com_google_android_gms_internal_zzhk.f7643g;
            com_google_android_gms_internal_zzhk = com_google_android_gms_internal_zzhk.f7644h;
            if (str != null) {
                zzbs.m4490i().m13241a(str);
            }
            if (com_google_android_gms_internal_zzhk != null) {
                zzbs.m4490i().m13250b((String) com_google_android_gms_internal_zzhk);
            }
        } else {
            str = zzbs.m4490i().m13259g();
            com_google_android_gms_internal_zzhk = zzbs.m4490i().m13260h();
            str2 = null;
        }
        Bundle bundle = new Bundle(1);
        if (com_google_android_gms_internal_zzhk != null) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.f7883S)).booleanValue() && !zzbs.m4490i().m13252b()) {
                bundle.putString("v_fp_vertical", com_google_android_gms_internal_zzhk);
            }
        }
        if (str != null) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.f7881Q)).booleanValue() != null && zzbs.m4490i().m13248a() == null) {
                bundle.putString("fingerprint", str);
                if (str.equals(str2) == null) {
                    bundle.putString("v_fp", str2);
                }
            }
        }
        if (bundle.isEmpty() == null) {
            return bundle;
        }
        return null;
    }
}
