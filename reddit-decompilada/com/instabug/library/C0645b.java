package com.instabug.library;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.instabug.library.Feature.State;
import com.instabug.library.core.eventbus.coreeventbus.C0655a;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Feature;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: InstabugFeaturesManager */
public class C0645b {
    static final State f9574a = State.ENABLED;
    private static final Object f9575b = new Object();
    private static volatile C0645b f9576e;
    private ConcurrentHashMap<Feature, State> f9577c = new ConcurrentHashMap();
    private ConcurrentHashMap<Feature, Boolean> f9578d = new ConcurrentHashMap();

    /* compiled from: InstabugFeaturesManager */
    class C06392 implements Runnable {
        final /* synthetic */ Context f9556a;
        final /* synthetic */ C0645b f9557b;

        C06392(C0645b c0645b, Context context) {
            this.f9557b = c0645b;
            this.f9556a = context;
        }

        public void run() {
            int i = 0;
            SharedPreferences sharedPreferences = this.f9556a.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0);
            Feature[] values = Feature.values();
            int length = values.length;
            while (i < length) {
                Feature feature = values[i];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(feature.name());
                stringBuilder.append("AVAIL");
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(feature.name());
                stringBuilder3.append("AVAIL");
                boolean z = sharedPreferences.getBoolean(stringBuilder3.toString(), true);
                if (sharedPreferences.contains(stringBuilder2)) {
                    this.f9557b.f9578d.put(feature, Boolean.valueOf(z));
                    stringBuilder = new StringBuilder("Feature ");
                    stringBuilder.append(feature);
                    stringBuilder.append(" saved availability ");
                    stringBuilder.append(z);
                    stringBuilder.append(" restored from shared preferences");
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                } else if (this.f9557b.f9578d.containsKey(feature)) {
                    stringBuilder = new StringBuilder("Not restoring feature ");
                    stringBuilder.append(feature);
                    stringBuilder.append(" availability as it's already set to ");
                    stringBuilder.append(this.f9557b.f9578d.get(feature));
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                } else {
                    this.f9557b.f9578d.putIfAbsent(feature, Boolean.valueOf(z));
                    stringBuilder = new StringBuilder("Restored feature ");
                    stringBuilder.append(feature);
                    stringBuilder.append(" availability ");
                    stringBuilder.append(z);
                    stringBuilder.append(" from shared preferences");
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                }
                if (this.f9557b.f9577c.containsKey(feature)) {
                    stringBuilder = new StringBuilder("Not restoring feature ");
                    stringBuilder.append(feature);
                    stringBuilder.append(" state as it's already set to ");
                    stringBuilder.append(this.f9557b.f9577c.get(feature));
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(feature.name());
                    stringBuilder.append("STATE");
                    State valueOf = State.valueOf(sharedPreferences.getString(stringBuilder.toString(), C0645b.f9574a.name()));
                    this.f9557b.f9577c.putIfAbsent(feature, valueOf);
                    stringBuilder3 = new StringBuilder("Restored feature ");
                    stringBuilder3.append(feature);
                    stringBuilder3.append(" state ");
                    stringBuilder3.append(valueOf);
                    stringBuilder3.append(" from shared preferences");
                    InstabugSDKLogger.m8356d(this, stringBuilder3.toString());
                }
                i++;
            }
        }
    }

    /* compiled from: InstabugFeaturesManager */
    class C13533 implements Callbacks<String, Throwable> {
        final /* synthetic */ Context f15458a;
        final /* synthetic */ C0645b f15459b;

        public C13533(C0645b c0645b, Context context) {
            this.f15459b = c0645b;
            this.f15458a = context;
        }

        public /* synthetic */ void onFailed(Object obj) {
            InstabugSDKLogger.m8358e(C0645b.class, "Something went wrong while do fetching features request", (Throwable) obj);
        }

        public /* synthetic */ void onSucceeded(Object obj) {
            String str = (String) obj;
            try {
                this.f15458a.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).edit().putLong("LAST_FETCHED_AT", System.currentTimeMillis()).apply();
                InstabugSDKLogger.m8356d(C0645b.class, "Features fetched successfully");
                JSONObject jSONObject = new JSONObject(str);
                this.f15459b.m8111a(Feature.CRASH_REPORTING, jSONObject.optBoolean("crash_reporting", true));
                this.f15459b.m8111a(Feature.PUSH_NOTIFICATION, jSONObject.optBoolean("push_notifications", true));
                this.f15459b.m8111a(Feature.WHITE_LABELING, jSONObject.optBoolean("white_label", true));
                this.f15459b.m8111a(Feature.IN_APP_MESSAGING, jSONObject.optBoolean("in_app_messaging", true));
                this.f15459b.m8111a(Feature.MULTIPLE_ATTACHMENTS, jSONObject.optBoolean("multiple_attachments", true));
                this.f15459b.m8111a(Feature.TRACK_USER_STEPS, jSONObject.optBoolean(com.instabug.library.model.State.KEY_USER_STEPS, true));
                this.f15459b.m8111a(Feature.REPRO_STEPS, jSONObject.optBoolean("repro_steps", true));
                this.f15459b.m8111a(Feature.CONSOLE_LOGS, jSONObject.optBoolean(com.instabug.library.model.State.KEY_CONSOLE_LOG, true));
                this.f15459b.m8111a(Feature.INSTABUG_LOGS, jSONObject.optBoolean("ibg_log", true));
                this.f15459b.m8111a(Feature.USER_DATA, jSONObject.optBoolean(com.instabug.library.model.State.KEY_USER_DATA, true));
                this.f15459b.m8111a(Feature.SURVEYS, jSONObject.optBoolean("surveys", true));
                this.f15459b.m8111a(Feature.VIEW_HIERARCHY, jSONObject.optBoolean("view_hierarchy", true));
                this.f15459b.m8111a(Feature.USER_EVENTS, jSONObject.optBoolean(com.instabug.library.model.State.KEY_USER_EVENTS, true));
                this.f15459b.m8111a(Feature.DISCLAIMER, jSONObject.optBoolean("disclaimer_text", false));
                C0655a.m8155a(new SDKCoreEvent(Feature.TYPE_FEATURES, Feature.VALUE_FETCHED));
            } catch (Object obj2) {
                InstabugSDKLogger.m8358e(C0645b.class, "Something went wrong while parsing fetching features request's response", obj2);
            }
        }
    }

    public static C0645b m8104a() {
        if (f9576e == null) {
            synchronized (f9575b) {
                if (f9576e == null) {
                    f9576e = new C0645b();
                }
            }
        }
        return f9576e;
    }

    private C0645b() {
    }

    final void m8111a(Feature feature, boolean z) {
        if (this.f9578d.containsKey(feature) && ((Boolean) this.f9578d.get(feature)).booleanValue() == z) {
            StringBuilder stringBuilder = new StringBuilder("Feature ");
            stringBuilder.append(feature);
            stringBuilder.append(" availability is already ");
            stringBuilder.append(z);
            stringBuilder.append(", ignoring");
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            return;
        }
        stringBuilder = new StringBuilder("Setting feature ");
        stringBuilder.append(feature);
        stringBuilder.append(" availability to ");
        stringBuilder.append(z);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        this.f9578d.put(feature, Boolean.valueOf(z));
    }

    public final boolean m8112a(Feature feature) {
        if (this.f9578d.containsKey(feature)) {
            StringBuilder stringBuilder = new StringBuilder("Feature ");
            stringBuilder.append(feature);
            stringBuilder.append(" availability is ");
            stringBuilder.append(this.f9578d.get(feature));
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            return ((Boolean) this.f9578d.get(feature)).booleanValue();
        }
        stringBuilder = new StringBuilder("Feature ");
        stringBuilder.append(feature);
        stringBuilder.append(" availability not found, returning true");
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        return true;
    }

    public final void m8110a(Feature feature, State state) {
        if (this.f9577c.containsKey(feature) && this.f9577c.get(feature) == state) {
            StringBuilder stringBuilder = new StringBuilder("Feature ");
            stringBuilder.append(feature);
            stringBuilder.append(" state is already ");
            stringBuilder.append(state);
            stringBuilder.append(" ignoring");
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            return;
        }
        stringBuilder = new StringBuilder("Setting ");
        stringBuilder.append(feature);
        stringBuilder.append(" state to ");
        stringBuilder.append(state);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        this.f9577c.put(feature, state);
    }

    public final State m8113b(Feature feature) {
        boolean z = m8112a(feature) && m8112a(Feature.INSTABUG);
        StringBuilder stringBuilder = new StringBuilder("Feature ");
        stringBuilder.append(feature);
        stringBuilder.append(" isAvailable = ");
        stringBuilder.append(z);
        stringBuilder.append(", and it's state is ");
        stringBuilder.append(this.f9577c.get(feature));
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (!z) {
            stringBuilder2 = new StringBuilder("Feature ");
            stringBuilder2.append(feature);
            stringBuilder2.append(" isn't available, returning ");
            stringBuilder2.append(State.DISABLED);
            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
            return State.DISABLED;
        } else if (this.f9577c.containsKey(feature)) {
            return (State) this.f9577c.get(feature);
        } else {
            stringBuilder2 = new StringBuilder("Feature ");
            stringBuilder2.append(feature);
            stringBuilder2.append(" is available, but no specific state is set. Returning ");
            stringBuilder2.append(f9574a);
            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
            return f9574a;
        }
    }

    final void m8109a(final Context context) {
        new Thread(new Runnable(this) {
            final /* synthetic */ C0645b f9555b;

            public void run() {
                Editor edit = context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).edit();
                for (Feature feature : this.f9555b.f9578d.keySet()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(feature.name());
                    stringBuilder.append("AVAIL");
                    edit.putBoolean(stringBuilder.toString(), ((Boolean) this.f9555b.f9578d.get(feature)).booleanValue());
                    stringBuilder = new StringBuilder("Saved feature ");
                    stringBuilder.append(feature);
                    stringBuilder.append(" availability ");
                    stringBuilder.append(this.f9555b.f9578d.get(feature));
                    stringBuilder.append(" to shared preferences");
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                }
                for (Feature feature2 : this.f9555b.f9577c.keySet()) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(feature2.name());
                    stringBuilder.append("STATE");
                    edit.putString(stringBuilder.toString(), ((State) this.f9555b.f9577c.get(feature2)).name());
                    stringBuilder = new StringBuilder("Saved feature ");
                    stringBuilder.append(feature2);
                    stringBuilder.append(" state ");
                    stringBuilder.append(this.f9555b.f9577c.get(feature2));
                    stringBuilder.append(" to shared preferences");
                    InstabugSDKLogger.m8356d(this, stringBuilder.toString());
                }
                edit.apply();
            }
        }).start();
    }

    public static long m8107b(Context context) {
        return context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).getLong("LAST_FETCHED_AT", 0);
    }
}
