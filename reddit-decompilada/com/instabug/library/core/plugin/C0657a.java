package com.instabug.library.core.plugin;

import android.content.Context;
import com.instabug.library.core.plugin.PluginPromptOption.C0656a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: PluginsManager */
public class C0657a {
    private static List<Plugin> f9584a;

    public static synchronized void m8158a(Context context) {
        StringBuilder stringBuilder;
        synchronized (C0657a.class) {
            if (f9584a == null) {
                f9584a = new ArrayList();
                String[] strArr = new String[]{"com.instabug.crash.CrashPlugin", "com.instabug.survey.SurveyPlugin", "com.instabug.chat.ChatPlugin", "com.instabug.bug.BugPlugin"};
                for (int i = 0; i < 4; i++) {
                    String str = strArr[i];
                    try {
                        Plugin plugin = (Plugin) Class.forName(str).newInstance();
                        plugin.init(context);
                        f9584a.add(plugin);
                        stringBuilder = new StringBuilder("pluginClassPath: ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8356d(C0657a.class, stringBuilder.toString());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        stringBuilder = new StringBuilder("Can't get: ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8357e(C0657a.class, stringBuilder.toString());
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public static void m8157a() {
        if (f9584a == null) {
            InstabugSDKLogger.m8357e(C0657a.class, "PluginsManager.releasePlugins() was called before PluginsManager.init() was called");
        }
        for (Plugin release : f9584a) {
            release.release();
        }
    }

    public static long m8159b() {
        if (f9584a == null) {
            InstabugSDKLogger.m8357e(C0657a.class, "PluginsManager.getLastActivityTime() was called before PluginsManager.init() was called");
        }
        long j = 0;
        for (Plugin lastActivityTime : f9584a) {
            long lastActivityTime2 = lastActivityTime.getLastActivityTime();
            if (lastActivityTime2 > j) {
                j = lastActivityTime2;
            }
        }
        return j;
    }

    public static ArrayList<PluginPromptOption> m8160c() {
        Object arrayList = new ArrayList();
        for (Plugin plugin : f9584a) {
            StringBuilder stringBuilder = new StringBuilder("plugin: ");
            stringBuilder.append(plugin.toString());
            InstabugSDKLogger.m8360v(C0657a.class, stringBuilder.toString());
            Collection promptOptions = plugin.getPromptOptions();
            if (promptOptions != null) {
                arrayList.addAll(promptOptions);
            }
        }
        Collections.sort(arrayList, new C0656a());
        return arrayList;
    }

    public static boolean m8161d() {
        if (f9584a != null) {
            for (Plugin state : f9584a) {
                if (state.getState() != 0) {
                    return true;
                }
            }
        }
        if (!SettingsManager.getInstance().isPromptOptionsScreenShown()) {
            if (!SettingsManager.getInstance().isRequestPermissionScreenShown()) {
                return false;
            }
        }
        return true;
    }

    public static Plugin m8156a(Class cls) {
        if (f9584a != null) {
            for (Plugin plugin : f9584a) {
                if (cls.isInstance(plugin)) {
                    return plugin;
                }
            }
        }
        return null;
    }
}
