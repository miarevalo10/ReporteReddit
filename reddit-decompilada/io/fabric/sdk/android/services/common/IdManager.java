package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AdvertisingInfoProvider.C25391;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class IdManager {
    private static final Pattern f24756g = Pattern.compile("[^\\p{Alnum}]");
    private static final String f24757h = Pattern.quote(Operation.DIVISION);
    public final boolean f24758a;
    public final String f24759b;
    AdvertisingInfoProvider f24760c;
    AdvertisingInfo f24761d;
    boolean f24762e;
    FirebaseInfo f24763f;
    private final ReentrantLock f24764i = new ReentrantLock();
    private final InstallerPackageNameProvider f24765j;
    private final boolean f24766k;
    private final Context f24767l;
    private final String f24768m;
    private final Collection<Kit> f24769n;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int f24755h;

        private DeviceIdentifierType(int i) {
            this.f24755h = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<Kit> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f24767l = context;
            this.f24759b = str;
            this.f24768m = str2;
            this.f24769n = collection;
            this.f24765j = new InstallerPackageNameProvider();
            this.f24760c = new AdvertisingInfoProvider(context);
            this.f24763f = new FirebaseInfo();
            this.f24766k = CommonUtils.m26297a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (this.f24766k == null) {
                StringBuilder stringBuilder = new StringBuilder("Device ID collection disabled for ");
                stringBuilder.append(context.getPackageName());
                Fabric.m26243b().mo5562a("Fabric", stringBuilder.toString());
            }
            this.f24758a = CommonUtils.m26297a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (this.f24758a == null) {
                collection = new StringBuilder("User information collection disabled for ");
                collection.append(context.getPackageName());
                Fabric.m26243b().mo5562a("Fabric", collection.toString());
            }
        }
    }

    private static String m26330b(String str) {
        return str == null ? null : f24756g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public final String m26332a() {
        String str = this.f24768m;
        if (str != null) {
            return str;
        }
        String str2;
        SharedPreferences a = CommonUtils.m26282a(this.f24767l);
        AdvertisingInfo i = m26331i();
        if (i != null) {
            str2 = i.f24714a;
            this.f24764i.lock();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    Object string = a.getString("crashlytics.advertising.id", null);
                    if (TextUtils.isEmpty(string)) {
                        a.edit().putString("crashlytics.advertising.id", str2).commit();
                    } else if (!string.equals(str2)) {
                        a.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", str2).commit();
                    }
                }
                this.f24764i.unlock();
            } catch (Throwable th) {
                this.f24764i.unlock();
            }
        }
        str2 = a.getString("crashlytics.installation.id", null);
        return str2 == null ? m26326a(a) : str2;
    }

    public static String m26329b() {
        return String.format(Locale.US, "%s/%s", new Object[]{m26327a(Build.MANUFACTURER), m26327a(Build.MODEL)});
    }

    public static String m26327a(String str) {
        return str.replaceAll(f24757h, "");
    }

    @SuppressLint({"CommitPrefEdits"})
    private String m26326a(SharedPreferences sharedPreferences) {
        this.f24764i.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m26330b(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f24764i.unlock();
            return string;
        } catch (Throwable th) {
            this.f24764i.unlock();
        }
    }

    public final Map<DeviceIdentifierType, String> m26333c() {
        Map hashMap = new HashMap();
        for (Kit kit : this.f24769n) {
            if (kit instanceof DeviceIdentifierProvider) {
                for (Entry entry : ((DeviceIdentifierProvider) kit).getDeviceIdentifiers().entrySet()) {
                    m26328a(hashMap, (DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        Object e = m26335e();
        if (TextUtils.isEmpty(e)) {
            m26328a(hashMap, DeviceIdentifierType.ANDROID_ID, m26336f());
        } else {
            m26328a(hashMap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, e);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public final String m26334d() {
        return this.f24765j.m26339a(this.f24767l);
    }

    public final String m26335e() {
        if (m26337g()) {
            AdvertisingInfo i = m26331i();
            if (!(i == null || i.f24715b)) {
                return i.f24714a;
            }
        }
        return null;
    }

    private static void m26328a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    public final String m26336f() {
        boolean equals = Boolean.TRUE.equals(m26338h());
        if (m26337g() && !equals) {
            String string = Secure.getString(this.f24767l.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return m26330b(string);
            }
        }
        return null;
    }

    public final boolean m26337g() {
        return this.f24766k && !FirebaseInfo.m26325b(this.f24767l);
    }

    private synchronized AdvertisingInfo m26331i() {
        if (!this.f24762e) {
            AdvertisingInfoProvider advertisingInfoProvider = this.f24760c;
            AdvertisingInfo advertisingInfo = new AdvertisingInfo(advertisingInfoProvider.f24716a.mo5606a().getString("advertising_id", ""), advertisingInfoProvider.f24716a.mo5606a().getBoolean("limit_ad_tracking_enabled", false));
            if (AdvertisingInfoProvider.m26266b(advertisingInfo)) {
                Fabric.m26243b().mo5562a("Fabric", "Using AdvertisingInfo from Preference Store");
                new Thread(new C25391(advertisingInfoProvider, advertisingInfo)).start();
            } else {
                advertisingInfo = advertisingInfoProvider.m26267a();
                advertisingInfoProvider.m26268a(advertisingInfo);
            }
            this.f24761d = advertisingInfo;
            this.f24762e = true;
        }
        return this.f24761d;
    }

    public final Boolean m26338h() {
        AdvertisingInfo i = m26331i();
        return i != null ? Boolean.valueOf(i.f24715b) : null;
    }
}
