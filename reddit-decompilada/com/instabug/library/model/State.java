package com.instabug.library.model;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.instabug.library.C0645b;
import com.instabug.library.C0662e;
import com.instabug.library.Feature;
import com.instabug.library.internal.device.C0673a;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0685c;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.C1389c.C07371;
import com.instabug.library.model.C1389c.C0738a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.C0761d;
import com.instabug.library.user.C0770a;
import com.instabug.library.user.UserEvent;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.C0781a;
import com.instabug.library.visualusersteps.C0783b;
import com.instabug.library.visualusersteps.C0783b.C0782a;
import com.instabug.library.visualusersteps.C0786d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.containers.mps.MPSUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class State implements Cacheable, Serializable {
    public static final String KEY_APP_PACKAGE_NAME = "bundle_id";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_BATTERY_LEVEL = "battery_level";
    public static final String KEY_BATTERY_STATUS = "battery_state";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CONSOLE_LOG = "console_log";
    public static final String KEY_CURRENT_VIEW = "current_view";
    public static final String KEY_DENSITY = "density";
    public static final String KEY_DEVICE = "device";
    public static final String KEY_DEVICE_ROOTED = "device_rooted";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_INSTABUG_LOG = "instabug_log";
    public static final String KEY_LOCALE = "locale";
    public static final String KEY_MEMORY_FREE = "memory_free";
    public static final String KEY_MEMORY_TOTAL = "memory_total";
    public static final String KEY_MEMORY_USED = "memory_used";
    public static final String KEY_NETWORK_LOGS = "network_log";
    public static final String KEY_ORIENTATION = "orientation";
    public static final String KEY_OS = "os";
    public static final String KEY_REPORTED_AT = "reported_at";
    public static final String KEY_SCREEN_SIZE = "screen_size";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_STORAGE_FREE = "storage_free";
    public static final String KEY_STORAGE_TOTAL = "storage_total";
    public static final String KEY_STORAGE_USED = "storage_used";
    public static final String KEY_TAGS = "tags";
    public static final String KEY_USER_ATTRIBUTES = "user_attributes";
    public static final String KEY_USER_DATA = "user_data";
    public static final String KEY_USER_EVENTS = "user_events";
    public static final String KEY_USER_STEPS = "user_steps";
    public static final String KEY_VISUAL_USER_STEPS = "user_repro_steps";
    public static final String KEY_WIFI_SSID = "wifi_ssid";
    public static final String KEY_WIFI_STATE = "wifi_state";
    private String OS;
    private String ScreenOrientation;
    private String appPackageName;
    private String appVersion;
    private int batteryLevel;
    private String batteryState;
    private String carrier;
    private ArrayList<C1387a> consoleLog;
    private String currentView;
    private String device;
    private long duration;
    private long freeMemory;
    private long freeStorage;
    private String instabugLog;
    private boolean isDeviceRooted;
    private String locale;
    private String networkLogs;
    private long reportedAt;
    private String screenDensity;
    private String screenSize;
    private String sdkVersion;
    private String tags;
    private long totalMemory;
    private long totalStorage;
    private long usedMemory;
    private long usedStorage;
    private String userAttributes;
    private String userData;
    private String userEmail;
    private String userEvents;
    private ArrayList<C1389c> userSteps;
    private ArrayList<C0783b> visualUserSteps;
    private String wifiSSID;
    private boolean wifiState;

    public static class Builder implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Context context;

        private String getSdkVersion() {
            return "4.11.1";
        }

        static {
            Class cls = State.class;
        }

        public Builder(Context context) {
            this.context = context;
        }

        private static ArrayList<C1387a> getConsoleLog() {
            ArrayList<C1387a> arrayList = new ArrayList();
            if (C0645b.m8104a().m8113b(Feature.CONSOLE_LOGS) != com.instabug.library.Feature.State.ENABLED) {
                return arrayList;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                StringBuilder stringBuilder = new StringBuilder("logcat -v time -d ");
                stringBuilder.append(Process.myPid());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(stringBuilder.toString()).getInputStream(), Charset.forName("UTF-8")));
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList2.add(readLine);
                }
                bufferedReader.close();
                arrayList2.trimToSize();
                int size = arrayList2.size() > 700 ? arrayList2.size() - 700 : 0;
                while (size < arrayList2.size()) {
                    if (((String) arrayList2.get(size)).length() > 18) {
                        C1387a c1387a = new C1387a();
                        c1387a.f15529a = ((String) arrayList2.get(size)).substring(18);
                        c1387a.f15530b = C1387a.m15443a(((String) arrayList2.get(size)).substring(0, 18));
                        arrayList.add(c1387a);
                    }
                    size++;
                }
                arrayList2.clear();
                return arrayList;
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(Builder.class, "Could not read logcat log", e);
                return arrayList;
            }
        }

        public State build(boolean z) {
            State visualUserSteps = new State().setSdkVersion(getSdkVersion()).setLocale(getLocale()).setDuration(getActiveSessionDuration()).setDevice(getDevice()).setIsDeviceRooted(isDeviceRooted()).setOS(getOS()).setCarrier(getCarrier()).setAppVersion(getAppVersion()).setAppPackageName(getAppPackageName()).setBatteryLevel(getBatteryLevel()).setBatteryState(getBatteryState()).setWifiState(getWifiState()).setWifiSSID(getWifiSSID()).setFreeMemory(getFreeMemory()).setUsedMemory(getUsedMemory()).setTotalMemory(getTotalMemory()).setFreeStorage(getFreeStorage()).setUsedStorage(getUsedStorage()).setTotalStorage(getTotalStorage()).setScreenDensity(getScreenDensity()).setScreenSize(getScreenSize()).setScreenOrientation(getScreenOrientation()).setCurrentView(getCurrentView()).setConsoleLog(getConsoleLog()).setUserSteps(getUserSteps()).setUserEmail(getUserEmail()).setUserData(getUserData()).setReportedAt(getReportedAt()).setTags(getTags()).setUserAttributes(UserAttributesCacheManager.getUserAttributes()).setNetworkLogs(getNetworkLogs()).setUserEvents(getUserEvents()).setVisualUserSteps(getVisualUserSteps());
            if (z) {
                visualUserSteps.setInstabugLog(getInstabugLog());
            }
            return visualUserSteps;
        }

        public State buildInternalState() {
            return new State().setSdkVersion(getSdkVersion()).setLocale(getLocale()).setDuration(getActiveSessionDuration()).setDevice(getDevice()).setIsDeviceRooted(isDeviceRooted()).setOS(getOS()).setCarrier(getCarrier()).setAppVersion(getAppVersion()).setAppPackageName(getAppPackageName()).setBatteryLevel(getBatteryLevel()).setBatteryState(getBatteryState()).setWifiState(getWifiState()).setWifiSSID(getWifiSSID()).setFreeMemory(getFreeMemory()).setUsedMemory(getUsedMemory()).setTotalMemory(getTotalMemory()).setFreeStorage(getFreeStorage()).setUsedStorage(getUsedStorage()).setTotalStorage(getTotalStorage()).setScreenDensity(getScreenDensity()).setScreenSize(getScreenSize()).setScreenOrientation(getScreenOrientation()).setCurrentView(getCurrentView()).setReportedAt(getReportedAt());
        }

        private String getLocale() {
            return this.context.getResources().getConfiguration().locale.toString();
        }

        private long getActiveSessionDuration() {
            C0662e a = C0662e.m8164a();
            if (a.f9590a.getSessionStartedAt() == 0) {
                return 0;
            }
            return (System.currentTimeMillis() / 1000) - a.f9590a.getSessionStartedAt();
        }

        public String formatSessionDuration(long j) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = ((int) j) % 60;
            j /= 60;
            int i2 = ((int) j) % 60;
            j = ((int) (j / 60)) % 60;
            if (j <= 9) {
                stringBuilder.append("0");
            }
            stringBuilder.append(j);
            stringBuilder.append(":");
            if (i2 <= 9) {
                stringBuilder.append("0");
            }
            stringBuilder.append(i2);
            stringBuilder.append(":");
            if (i <= 9) {
                stringBuilder.append("0");
            }
            stringBuilder.append(i);
            return stringBuilder.toString();
        }

        private String getDevice() {
            return InstabugDeviceProperties.getDeviceType();
        }

        public boolean isDeviceRooted() {
            try {
                return C0673a.m8184a();
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("Something went wrong while checking if device is rooted or not ");
                stringBuilder.append(e.getMessage());
                InstabugSDKLogger.m8357e(this, stringBuilder.toString());
                return false;
            }
        }

        private String getOS() {
            StringBuilder stringBuilder = new StringBuilder("OS Level ");
            stringBuilder.append(VERSION.SDK_INT);
            return stringBuilder.toString();
        }

        private String getCarrier() {
            try {
                return ((TelephonyManager) this.context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(this, "Got error while get Carrier", e);
                return "Unknown";
            }
        }

        private String getAppPackageName() {
            return InstabugDeviceProperties.getPackageName(this.context);
        }

        private String getAppVersion() {
            return InstabugDeviceProperties.getAppVersion(this.context);
        }

        private int getBatteryLevel() {
            try {
                Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                return (int) ((((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f);
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(this, "Got error while get battery level", e);
                return -1;
            }
        }

        private String getBatteryState() {
            try {
                Object obj;
                int intExtra;
                Object obj2;
                StringBuilder stringBuilder;
                String str;
                Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                int intExtra2 = registerReceiver.getIntExtra("status", -1);
                Object obj3 = null;
                if (intExtra2 != 2) {
                    if (intExtra2 != 5) {
                        obj = null;
                        intExtra = registerReceiver.getIntExtra("plugged", -1);
                        obj2 = intExtra != 2 ? 1 : null;
                        if (intExtra == 1) {
                            obj3 = 1;
                        }
                        if (obj != null) {
                            return "Unplugged";
                        }
                        stringBuilder = new StringBuilder("Charging");
                        str = obj3 == null ? " through AC Charger" : obj2 == null ? " through USB cable" : "";
                        stringBuilder.append(str);
                        return stringBuilder.toString();
                    }
                }
                obj = 1;
                intExtra = registerReceiver.getIntExtra("plugged", -1);
                if (intExtra != 2) {
                }
                if (intExtra == 1) {
                    obj3 = 1;
                }
                if (obj != null) {
                    return "Unplugged";
                }
                stringBuilder = new StringBuilder("Charging");
                if (obj3 == null) {
                    if (obj2 == null) {
                    }
                }
                stringBuilder.append(str);
                return stringBuilder.toString();
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(this, "Got error while get battery state", e);
                return "Unknown";
            }
        }

        private boolean getWifiState() {
            try {
                return ((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(this, "Got error while get wifi state", e);
                return false;
            }
        }

        private java.lang.String getWifiSSID() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.getWifiState();
            if (r0 == 0) goto L_0x0021;
        L_0x0006:
            r0 = r2.context;	 Catch:{ SecurityException -> 0x0019 }
            r1 = "wifi";	 Catch:{ SecurityException -> 0x0019 }
            r0 = r0.getSystemService(r1);	 Catch:{ SecurityException -> 0x0019 }
            r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ SecurityException -> 0x0019 }
            r0 = r0.getConnectionInfo();	 Catch:{ SecurityException -> 0x0019 }
            r0 = r0.getSSID();	 Catch:{ SecurityException -> 0x0019 }
            return r0;
        L_0x0019:
            r0 = "Could not read wifi SSID. To enable please add the following line in your AndroidManifest.xml <uses-permission android:name=\"android.permission.ACCESS_WIFI_STATE\"/>";
            com.instabug.library.util.InstabugSDKLogger.m8357e(r2, r0);
            r0 = "Connected";
            return r0;
        L_0x0021:
            r0 = "Not Connected";
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.State.Builder.getWifiSSID():java.lang.String");
        }

        private long getFreeMemory() {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1048576;
        }

        private long getUsedMemory() {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return (calculateTotalMemory() - memoryInfo.availMem) / 1048576;
        }

        private long getTotalMemory() {
            long calculateTotalMemory = calculateTotalMemory();
            if (calculateTotalMemory != 0) {
                return calculateTotalMemory / 1048576;
            }
            InstabugSDKLogger.m8357e(this, "Got error while calculate total memory");
            return -1;
        }

        private long calculateTotalMemory() {
            if (VERSION.SDK_INT >= 16) {
                return calculateTotalMemoryApi16();
            }
            return calculateTotalMemoryPreApi16();
        }

        @TargetApi(16)
        private long calculateTotalMemoryApi16() {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }

        private long calculateTotalMemoryPreApi16() {
            RandomAccessFile randomAccessFile;
            IOException e;
            Throwable th;
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    String trim = randomAccessFile.readLine().split(":")[1].trim();
                    trim = trim.substring(0, trim.length() - 3).trim();
                    randomAccessFile.close();
                    long parseLong = Long.parseLong(trim) * 1024;
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return parseLong;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e42) {
                IOException iOException = e42;
                randomAccessFile = null;
                e22 = iOException;
                e22.printStackTrace();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return 0;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                randomAccessFile = null;
                th = th4;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }

        private long getFreeStorage() {
            if (externalMemoryAvailable()) {
                return Environment.getExternalStorageDirectory().getUsableSpace() / 1048576;
            }
            InstabugSDKLogger.m8357e(this, "Got error while calculate free storage");
            return -1;
        }

        private long getUsedStorage() {
            if (externalMemoryAvailable()) {
                return (Environment.getExternalStorageDirectory().getTotalSpace() - Environment.getExternalStorageDirectory().getFreeSpace()) / 1048576;
            }
            InstabugSDKLogger.m8357e(this, "Got error while calculate used storage");
            return -1;
        }

        private long getTotalStorage() {
            if (externalMemoryAvailable()) {
                return (long) ((int) (Environment.getExternalStorageDirectory().getTotalSpace() / 1048576));
            }
            InstabugSDKLogger.m8357e(this, "Got error while calculate total storage");
            return -1;
        }

        private boolean externalMemoryAvailable() {
            return Environment.getExternalStorageState().equals("mounted");
        }

        private String getScreenDensity() {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (displayMetrics.densityDpi < 160) {
                return "ldpi";
            }
            if (displayMetrics.densityDpi < 240) {
                return "mdpi";
            }
            if (displayMetrics.densityDpi < 320) {
                return "hdpi";
            }
            if (displayMetrics.densityDpi < MPSUtils.VIDEO_MIN) {
                return "xhdpi";
            }
            return displayMetrics.densityDpi < 640 ? "xxhdpi" : "xxxhdpi";
        }

        private String getScreenSize() {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            return String.format("%sx%s", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        }

        private DisplayMetrics getDisplayMetrics() {
            Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            }
            return displayMetrics;
        }

        private String getScreenOrientation() {
            return this.context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
        }

        private String getCurrentView() {
            return C0761d.m8330a().f9885b;
        }

        private String getInstabugLog() {
            return C0645b.m8104a().m8113b(Feature.INSTABUG_LOGS) == com.instabug.library.Feature.State.ENABLED ? InstabugLog.getLogs() : null;
        }

        private ArrayList<C1389c> getUserSteps() {
            C0761d a = C0761d.m8330a();
            ArrayList<C1389c> arrayList = new ArrayList();
            for (int i = 0; i < a.f9884a.size(); i++) {
                C1389c c1389c = new C1389c();
                c1389c.f15533b = C0761d.m8331a((C0740d) a.f9884a.get(i));
                c1389c.f15532a = ((C0740d) a.f9884a.get(i)).f9829a;
                switch (C07371.f9802a[((C0740d) a.f9884a.get(i)).f9834f.ordinal()]) {
                    case 1:
                        c1389c.f15534c = C0738a.TOUCH;
                        break;
                    case 2:
                        c1389c.f15534c = C0738a.MOTION;
                        break;
                    case 3:
                        c1389c.f15534c = C0738a.APPLICATION;
                        break;
                    default:
                        c1389c.f15534c = C0738a.VIEW;
                        break;
                }
                arrayList.add(c1389c);
            }
            return arrayList;
        }

        private ArrayList<C0783b> getVisualUserSteps() {
            C0786d a = C0786d.m8386a();
            a.m8393b();
            ArrayList<C0783b> arrayList = new ArrayList();
            Iterator it = a.f9943a.f9937a.iterator();
            while (it.hasNext()) {
                C0781a c0781a = (C0781a) it.next();
                C0782a a2 = C0783b.m8378a(null);
                a2.f9922b = c0781a.f9917b;
                a2.f9921a = null;
                a2.f9924d = c0781a.f9916a;
                if (c0781a.f9918c != null) {
                    a2.f9923c = c0781a.f9918c.f9914a;
                    a2.f9927g = c0781a.f9918c.f9915b;
                }
                arrayList.add(a2.m8377a());
                arrayList.addAll(c0781a.f9919d);
            }
            return arrayList;
        }

        private String getUserEmail() {
            return C0770a.m8344b();
        }

        private String getUserData() {
            return SettingsManager.getInstance().getUserData();
        }

        private long getReportedAt() {
            return InstabugDateFormatter.getCurrentUTCTimeStampInSeconds();
        }

        private String getTags() {
            return SettingsManager.getInstance().getTagsAsString();
        }

        public String getNetworkLogs() {
            C0683a.m8190a();
            C0685c b = C0683a.m8192b();
            JSONArray jSONArray = new JSONArray();
            Cursor query = b.f9619a.query("network_logs", null, null, null, null, null, "_id DESC", "100");
            if (query.moveToFirst()) {
                do {
                    NetworkLog networkLog = new NetworkLog();
                    networkLog.setRequest(query.getString(query.getColumnIndex("request")));
                    networkLog.setResponse(query.getString(query.getColumnIndex("response")));
                    networkLog.setMethod(query.getString(query.getColumnIndex("method")));
                    networkLog.setUrl(query.getString(query.getColumnIndex(UpdateFragment.FRAGMENT_URL)));
                    networkLog.setResponseCode(query.getInt(query.getColumnIndex("status")));
                    networkLog.setDate(query.getString(query.getColumnIndex("date")));
                    networkLog.setHeaders(query.getString(query.getColumnIndex("headers")));
                    networkLog.setTotalDuration((long) query.getInt(query.getColumnIndex("response_time")));
                    try {
                        jSONArray.put(networkLog.toJsonObject());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } while (query.moveToNext());
            }
            query.close();
            b.m8198b();
            return jSONArray.toString();
        }

        private String getUserEvents() {
            try {
                return UserEvent.toJson(InstabugUserEventLogger.getInstance().getUserEvents()).toString();
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(this, "Got error while parsing user events logs", e);
                return "";
            }
        }

        private String getUserAttributes() {
            String str = "{}";
            HashMap all = UserAttributesCacheManager.getAll();
            if (all == null || all.size() == 0) {
                return str;
            }
            C1388b c1388b = new C1388b();
            c1388b.f15531a = all;
            try {
                return c1388b.toJson();
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("parsing user attributes got error: ");
                stringBuilder.append(e.getMessage());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
                return str;
            }
        }
    }

    public static class StateItem<V> implements Serializable {
        String key;
        V value;

        public String getKey() {
            return this.key;
        }

        public StateItem<V> setKey(String str) {
            this.key = str;
            return this;
        }

        public V getValue() {
            return this.value;
        }

        public StateItem<V> setValue(V v) {
            this.value = v;
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("key: ");
            stringBuilder.append(getKey());
            stringBuilder.append(", value: ");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public State setSdkVersion(String str) {
        this.sdkVersion = str;
        return this;
    }

    public String getLocale() {
        return this.locale;
    }

    public State setLocale(String str) {
        this.locale = str;
        return this;
    }

    public long getDuration() {
        return this.duration;
    }

    public State setDuration(long j) {
        this.duration = j;
        return this;
    }

    public String getDevice() {
        return this.device;
    }

    public State setDevice(String str) {
        this.device = str;
        return this;
    }

    public boolean isDeviceRooted() {
        return this.isDeviceRooted;
    }

    public State setIsDeviceRooted(boolean z) {
        this.isDeviceRooted = z;
        return this;
    }

    public String getOS() {
        return this.OS;
    }

    public State setOS(String str) {
        this.OS = str;
        return this;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public State setCarrier(String str) {
        this.carrier = str;
        return this;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public State setAppPackageName(String str) {
        this.appPackageName = str;
        return this;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public State setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public State setBatteryLevel(int i) {
        this.batteryLevel = i;
        return this;
    }

    public String getBatteryState() {
        return this.batteryState;
    }

    public State setBatteryState(String str) {
        this.batteryState = str;
        return this;
    }

    public boolean isWifiEnable() {
        return this.wifiState;
    }

    public State setWifiState(boolean z) {
        this.wifiState = z;
        return this;
    }

    public String getWifiSSID() {
        return this.wifiSSID;
    }

    public State setWifiSSID(String str) {
        this.wifiSSID = str;
        return this;
    }

    public long getUsedMemory() {
        return this.usedMemory;
    }

    public State setUsedMemory(long j) {
        this.usedMemory = j;
        return this;
    }

    public long getFreeMemory() {
        return this.freeMemory;
    }

    public State setFreeMemory(long j) {
        this.freeMemory = j;
        return this;
    }

    public long getTotalMemory() {
        return this.totalMemory;
    }

    public State setTotalMemory(long j) {
        this.totalMemory = j;
        return this;
    }

    public long getUsedStorage() {
        return this.usedStorage;
    }

    public State setUsedStorage(long j) {
        this.usedStorage = j;
        return this;
    }

    public long getFreeStorage() {
        return this.freeStorage;
    }

    public State setFreeStorage(long j) {
        this.freeStorage = j;
        return this;
    }

    public long getTotalStorage() {
        return this.totalStorage;
    }

    public State setTotalStorage(long j) {
        this.totalStorage = j;
        return this;
    }

    public String getScreenDensity() {
        return this.screenDensity;
    }

    public State setScreenDensity(String str) {
        this.screenDensity = str;
        return this;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public State setScreenSize(String str) {
        this.screenSize = str;
        return this;
    }

    public String getScreenOrientation() {
        return this.ScreenOrientation;
    }

    public State setScreenOrientation(String str) {
        this.ScreenOrientation = str;
        return this;
    }

    public String getCurrentView() {
        return this.currentView;
    }

    public State setCurrentView(String str) {
        this.currentView = str;
        return this;
    }

    public String getInstabugLog() {
        return this.instabugLog;
    }

    public State setInstabugLog(String str) {
        this.instabugLog = str;
        return this;
    }

    public void updateConsoleLog() {
        setConsoleLog(Builder.getConsoleLog());
    }

    public JSONArray getConsoleLog() {
        return C1387a.m15445a(this.consoleLog);
    }

    public State setConsoleLog(ArrayList<C1387a> arrayList) {
        this.consoleLog = arrayList;
        return this;
    }

    public JSONArray getUserSteps() {
        return C1389c.m15447a(this.userSteps);
    }

    public State setUserSteps(ArrayList<C1389c> arrayList) {
        this.userSteps = arrayList;
        return this;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public State setUserEmail(String str) {
        this.userEmail = str;
        return this;
    }

    public String getUserData() {
        return this.userData;
    }

    public State setUserData(String str) {
        this.userData = str;
        return this;
    }

    public long getReportedAt() {
        return this.reportedAt;
    }

    public State setReportedAt(long j) {
        this.reportedAt = j;
        return this;
    }

    public String getTags() {
        return this.tags;
    }

    public State setTags(String str) {
        this.tags = str;
        return this;
    }

    public String getUserAttributes() {
        return this.userAttributes;
    }

    public State setUserAttributes(String str) {
        this.userAttributes = str;
        return this;
    }

    public String getNetworkLogs() {
        return this.networkLogs;
    }

    public State setNetworkLogs(String str) {
        this.networkLogs = str;
        return this;
    }

    public String getUserEvents() {
        return this.userEvents;
    }

    public State setUserEvents(String str) {
        this.userEvents = str;
        return this;
    }

    public String getVisualUserSteps() {
        return C0783b.m8379a(this.visualUserSteps);
    }

    public State setVisualUserSteps(ArrayList<C0783b> arrayList) {
        this.visualUserSteps = arrayList;
        return this;
    }

    public ArrayList<StateItem> getStateItems() throws JSONException {
        ArrayList<StateItem> arrayList = new ArrayList();
        arrayList.add(new StateItem().setKey(KEY_APP_PACKAGE_NAME).setValue(getAppPackageName()));
        arrayList.add(new StateItem().setKey(KEY_APP_VERSION).setValue(getAppVersion()));
        arrayList.add(new StateItem().setKey(KEY_BATTERY_LEVEL).setValue(Integer.valueOf(getBatteryLevel())));
        arrayList.add(new StateItem().setKey(KEY_BATTERY_STATUS).setValue(getBatteryState()));
        arrayList.add(new StateItem().setKey(KEY_CARRIER).setValue(getCarrier()));
        arrayList.add(new StateItem().setKey(KEY_CURRENT_VIEW).setValue(getCurrentView()));
        arrayList.add(new StateItem().setKey(KEY_DENSITY).setValue(getScreenDensity()));
        arrayList.add(new StateItem().setKey(KEY_DEVICE).setValue(getDevice()));
        arrayList.add(new StateItem().setKey(KEY_DEVICE_ROOTED).setValue(Boolean.valueOf(isDeviceRooted())));
        arrayList.add(new StateItem().setKey(KEY_DURATION).setValue(Long.valueOf(getDuration())));
        arrayList.add(new StateItem().setKey(KEY_EMAIL).setValue(getUserEmail()));
        arrayList.add(new StateItem().setKey(KEY_LOCALE).setValue(getLocale()));
        arrayList.add(new StateItem().setKey(KEY_MEMORY_FREE).setValue(Long.valueOf(getFreeMemory())));
        arrayList.add(new StateItem().setKey(KEY_MEMORY_TOTAL).setValue(Long.valueOf(getTotalMemory())));
        arrayList.add(new StateItem().setKey(KEY_MEMORY_USED).setValue(Long.valueOf(getUsedMemory())));
        arrayList.add(new StateItem().setKey(KEY_ORIENTATION).setValue(getScreenOrientation()));
        arrayList.add(new StateItem().setKey(KEY_OS).setValue(getOS()));
        arrayList.add(new StateItem().setKey(KEY_REPORTED_AT).setValue(Long.valueOf(getReportedAt())));
        arrayList.add(new StateItem().setKey(KEY_SCREEN_SIZE).setValue(getScreenSize()));
        arrayList.add(new StateItem().setKey(KEY_SDK_VERSION).setValue(getSdkVersion()));
        arrayList.add(new StateItem().setKey(KEY_STORAGE_FREE).setValue(Long.valueOf(getFreeStorage())));
        arrayList.add(new StateItem().setKey(KEY_STORAGE_TOTAL).setValue(Long.valueOf(getTotalStorage())));
        arrayList.add(new StateItem().setKey(KEY_STORAGE_USED).setValue(Long.valueOf(getUsedStorage())));
        arrayList.add(new StateItem().setKey(KEY_TAGS).setValue(getTags()));
        arrayList.add(new StateItem().setKey(KEY_WIFI_SSID).setValue(getWifiSSID()));
        arrayList.add(new StateItem().setKey(KEY_WIFI_STATE).setValue(Boolean.valueOf(isWifiEnable())));
        arrayList.add(new StateItem().setKey(KEY_USER_ATTRIBUTES).setValue(getUserAttributes()));
        return arrayList;
    }

    public ArrayList<StateItem> getLogsItems() {
        ArrayList<StateItem> arrayList = new ArrayList();
        arrayList.add(new StateItem().setKey(KEY_CONSOLE_LOG).setValue(getConsoleLog().toString()));
        arrayList.add(new StateItem().setKey(KEY_INSTABUG_LOG).setValue(getInstabugLog()));
        arrayList.add(new StateItem().setKey(KEY_USER_DATA).setValue(getUserData()));
        arrayList.add(new StateItem().setKey(KEY_NETWORK_LOGS).setValue(getNetworkLogs()));
        arrayList.add(new StateItem().setKey(KEY_USER_EVENTS).setValue(getUserEvents()));
        if (C0645b.m8104a().m8113b(Feature.TRACK_USER_STEPS) == com.instabug.library.Feature.State.ENABLED) {
            arrayList.add(new StateItem().setKey(KEY_USER_STEPS).setValue(getUserSteps().toString()));
        }
        if (C0645b.m8104a().m8113b(Feature.REPRO_STEPS) == com.instabug.library.Feature.State.ENABLED) {
            arrayList.add(new StateItem().setKey(KEY_VISUAL_USER_STEPS).setValue(getVisualUserSteps()));
        }
        return arrayList;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ArrayList stateItems = getStateItems();
        int i = 0;
        for (int i2 = 0; i2 < stateItems.size(); i2++) {
            jSONObject.put(((StateItem) stateItems.get(i2)).getKey(), ((StateItem) stateItems.get(i2)).getValue());
        }
        stateItems = getLogsItems();
        while (i < stateItems.size()) {
            jSONObject.put(((StateItem) stateItems.get(i)).getKey(), ((StateItem) stateItems.get(i)).getValue());
            i++;
        }
        InstabugSDKLogger.m8360v(this, jSONObject.toString());
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(KEY_APP_PACKAGE_NAME) != null) {
            setAppPackageName(jSONObject.getString(KEY_APP_PACKAGE_NAME));
        }
        if (jSONObject.has(KEY_APP_VERSION) != null) {
            setAppVersion(jSONObject.getString(KEY_APP_VERSION));
        }
        if (jSONObject.has(KEY_BATTERY_LEVEL) != null) {
            setBatteryLevel(jSONObject.getInt(KEY_BATTERY_LEVEL));
        }
        if (jSONObject.has(KEY_BATTERY_STATUS) != null) {
            setBatteryState(jSONObject.getString(KEY_BATTERY_STATUS));
        }
        if (jSONObject.has(KEY_CARRIER) != null) {
            setCarrier(jSONObject.getString(KEY_CARRIER));
        }
        if (jSONObject.has(KEY_CONSOLE_LOG) != null) {
            setConsoleLog(C1387a.m15444a(new JSONArray(jSONObject.getString(KEY_CONSOLE_LOG))));
        }
        if (jSONObject.has(KEY_CURRENT_VIEW) != null) {
            setCurrentView(jSONObject.getString(KEY_CURRENT_VIEW));
        }
        if (jSONObject.has(KEY_DENSITY) != null) {
            setScreenDensity(jSONObject.getString(KEY_DENSITY));
        }
        if (jSONObject.has(KEY_DEVICE) != null) {
            setDevice(jSONObject.getString(KEY_DEVICE));
        }
        if (jSONObject.has(KEY_DEVICE_ROOTED) != null) {
            setIsDeviceRooted(jSONObject.getBoolean(KEY_DEVICE_ROOTED));
        }
        if (jSONObject.has(KEY_DURATION) != null) {
            setDuration(jSONObject.getLong(KEY_DURATION));
        }
        if (jSONObject.has(KEY_EMAIL) != null) {
            setUserEmail(jSONObject.getString(KEY_EMAIL));
        }
        if (jSONObject.has(KEY_INSTABUG_LOG) != null) {
            setInstabugLog(jSONObject.getString(KEY_INSTABUG_LOG));
        }
        if (jSONObject.has(KEY_LOCALE) != null) {
            setLocale(jSONObject.getString(KEY_LOCALE));
        }
        if (jSONObject.has(KEY_MEMORY_FREE) != null) {
            setFreeMemory(jSONObject.getLong(KEY_MEMORY_FREE));
        }
        if (jSONObject.has(KEY_MEMORY_TOTAL) != null) {
            setTotalMemory(jSONObject.getLong(KEY_MEMORY_TOTAL));
        }
        if (jSONObject.has(KEY_MEMORY_USED) != null) {
            setUsedMemory(jSONObject.getLong(KEY_MEMORY_USED));
        }
        if (jSONObject.has(KEY_ORIENTATION) != null) {
            setScreenOrientation(jSONObject.getString(KEY_ORIENTATION));
        }
        if (jSONObject.has(KEY_OS) != null) {
            setOS(jSONObject.getString(KEY_OS));
        }
        if (jSONObject.has(KEY_REPORTED_AT) != null) {
            setReportedAt(jSONObject.getLong(KEY_REPORTED_AT));
        }
        if (jSONObject.has(KEY_SCREEN_SIZE) != null) {
            setScreenSize(jSONObject.getString(KEY_SCREEN_SIZE));
        }
        if (jSONObject.has(KEY_SDK_VERSION) != null) {
            setSdkVersion(jSONObject.getString(KEY_SDK_VERSION));
        }
        if (jSONObject.has(KEY_STORAGE_FREE) != null) {
            setFreeStorage(jSONObject.getLong(KEY_STORAGE_FREE));
        }
        if (jSONObject.has(KEY_STORAGE_TOTAL) != null) {
            setTotalStorage(jSONObject.getLong(KEY_STORAGE_TOTAL));
        }
        if (jSONObject.has(KEY_STORAGE_USED) != null) {
            setUsedStorage(jSONObject.getLong(KEY_STORAGE_USED));
        }
        if (jSONObject.has(KEY_TAGS) != null) {
            setTags(jSONObject.getString(KEY_TAGS));
        }
        if (jSONObject.has(KEY_USER_DATA) != null) {
            setUserData(jSONObject.getString(KEY_USER_DATA));
        }
        if (jSONObject.has(KEY_USER_STEPS) != null) {
            setUserSteps(C1389c.m15446a(new JSONArray(jSONObject.getString(KEY_USER_STEPS))));
        }
        if (jSONObject.has(KEY_WIFI_SSID) != null) {
            setWifiSSID(jSONObject.getString(KEY_WIFI_SSID));
        }
        if (jSONObject.has(KEY_WIFI_STATE) != null) {
            setWifiState(jSONObject.getBoolean(KEY_WIFI_STATE));
        }
        if (jSONObject.has(KEY_USER_ATTRIBUTES) != null) {
            setUserAttributes(jSONObject.getString(KEY_USER_ATTRIBUTES));
        }
        if (jSONObject.has(KEY_NETWORK_LOGS) != null) {
            setNetworkLogs(jSONObject.getString(KEY_NETWORK_LOGS));
        }
        if (jSONObject.has(KEY_USER_EVENTS) != null) {
            setUserEvents(jSONObject.getString(KEY_USER_EVENTS));
        }
        if (jSONObject.has(KEY_VISUAL_USER_STEPS) != null) {
            setVisualUserSteps(C0783b.m8380a(new JSONArray(jSONObject.getString(KEY_VISUAL_USER_STEPS))));
        }
    }

    public String toString() {
        try {
            return toJson();
        } catch (Throwable e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("Something went wrong while getting state.toString()");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
            return "error";
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        if (String.valueOf(state.getAppVersion()).equals(String.valueOf(getAppVersion())) && state.getBatteryLevel() == getBatteryLevel() && String.valueOf(state.getBatteryState()).equals(String.valueOf(getBatteryState())) && String.valueOf(state.getCarrier()).equals(String.valueOf(getCarrier())) && String.valueOf(state.getConsoleLog()).equals(String.valueOf(getConsoleLog())) && String.valueOf(state.getCurrentView()).equals(String.valueOf(getCurrentView())) && state.getDuration() == getDuration() && String.valueOf(state.getDevice()).equals(String.valueOf(getDevice())) && state.getFreeMemory() == getFreeMemory() && state.getFreeStorage() == getFreeStorage() && String.valueOf(state.getLocale()).equals(String.valueOf(getLocale())) && String.valueOf(state.getOS()).equals(String.valueOf(getOS())) && state.getReportedAt() == getReportedAt() && String.valueOf(state.getScreenDensity()).equals(String.valueOf(getScreenDensity())) && String.valueOf(state.getScreenOrientation()).equals(String.valueOf(getScreenOrientation())) && String.valueOf(state.getScreenSize()).equals(String.valueOf(getScreenSize())) && String.valueOf(state.getSdkVersion()).equals(String.valueOf(getSdkVersion())) && state.getTotalMemory() == getTotalMemory() && state.getTotalStorage() == getTotalStorage() && String.valueOf(state.getTags()).equals(String.valueOf(getTags())) && state.getUsedMemory() == getUsedMemory() && state.getUsedStorage() == getUsedStorage() && String.valueOf(state.getUserData()).equals(String.valueOf(getUserData())) && String.valueOf(state.getUserEmail()).equals(String.valueOf(getUserEmail())) && String.valueOf(state.getUserSteps()).equals(String.valueOf(getUserSteps())) && String.valueOf(state.getWifiSSID()).equals(String.valueOf(getWifiSSID())) && state.isDeviceRooted() == isDeviceRooted() && state.isWifiEnable() == isWifiEnable() && String.valueOf(state.getInstabugLog()).equals(String.valueOf(getInstabugLog())) && String.valueOf(state.getUserAttributes()).equals(String.valueOf(getUserAttributes())) && String.valueOf(state.getNetworkLogs()).equals(String.valueOf(getNetworkLogs())) && String.valueOf(state.getUserEvents()).equals(String.valueOf(getUserEvents())) && String.valueOf(state.getVisualUserSteps()).equals(String.valueOf(getVisualUserSteps())) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return String.valueOf(getReportedAt()).hashCode();
    }
}
