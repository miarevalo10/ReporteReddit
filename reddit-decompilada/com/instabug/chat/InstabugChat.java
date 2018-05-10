package com.instabug.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.instabug.chat.cache.ChatsCacheManager;
import com.instabug.chat.network.InstabugPushNotificationTokenService;
import com.instabug.chat.p005a.C0534b;
import com.instabug.chat.settings.AttachmentTypesState;
import com.instabug.chat.settings.C0554a;
import com.instabug.chat.ui.C0559a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.core.InstabugCore;
import java.util.Map;

public class InstabugChat {
    public static void showChats() {
        if (isReadyToRun()) {
            ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
            if (chatPlugin != null) {
                Context appContext = chatPlugin.getAppContext();
                if (appContext != null) {
                    appContext.startActivity(C0559a.m7964a(appContext));
                }
            }
        }
    }

    public static void openNewChat() {
        if (isReadyToRun()) {
            ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
            if (chatPlugin != null) {
                Context appContext = chatPlugin.getAppContext();
                if (appContext != null) {
                    appContext.startActivity(C0559a.m7967b(appContext));
                }
            }
        }
    }

    public static void setDefaultInvocationMode(int i) {
        if (isReadyToRun()) {
            Instabug.setDefaultInvocationMode(i);
        }
    }

    public static void resetDefaultInvocationMode() {
        if (isReadyToRun()) {
            Instabug.resetDefaultInvocationMode();
        }
    }

    public static void setNewMessageHandler(Runnable runnable) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("runnable").setType(runnable.getClass()));
            C0554a.m7938a(runnable);
        }
    }

    public static int getUnreadMessagesCount() throws IllegalStateException {
        if (!isReadyToRun()) {
            return 0;
        }
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return ChatsCacheManager.getUnreadCount();
    }

    public static void enableNotification(boolean z) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enable").setType(Boolean.class).setValue(Boolean.toString(z)));
            C0554a.m7940a(z);
        }
    }

    public static void enableSystemNotificationSound(boolean z) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySound").setType(Boolean.class).setValue(Boolean.toString(z)));
            C0554a.m7943b(z);
        }
    }

    public static void enableInAppNotificationSound(boolean z) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enable").setType(Boolean.class).setValue(Boolean.toString(z)));
            C0554a.m7944c(z);
        }
    }

    public static void setNotificationIcon(int i) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("notificationIcon").setType(Integer.class));
            C0554a.m7933a(i);
        }
    }

    public static void setPushNotificationRegistrationToken(String str) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("token").setType(String.class));
            if (str != null && !str.isEmpty() && !C0554a.m7957l().equalsIgnoreCase(str) && InstabugCore.getFeatureState(Feature.PUSH_NOTIFICATION) == State.ENABLED) {
                C0554a.m7939a(str);
                C0554a.m7950f(false);
                ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
                if (chatPlugin != null) {
                    str = chatPlugin.getAppContext();
                    if (str != null) {
                        str.startService(new Intent(str, InstabugPushNotificationTokenService.class));
                    }
                }
            }
        }
    }

    public static boolean isInstabugNotification(Bundle bundle) {
        if (!isReadyToRun()) {
            return false;
        }
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(bundle.getClass()));
        return C0534b.m7867a().m7876b(bundle);
    }

    public static boolean isInstabugNotification(Map<String, String> map) {
        if (!isReadyToRun()) {
            return false;
        }
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(map.getClass()));
        return C0534b.m7867a().m7877b((Map) map);
    }

    public static void showNotification(Bundle bundle) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(bundle.getClass()));
            C0534b.m7867a();
            C0534b.m7871a(bundle);
        }
    }

    public static void showNotification(Map<String, String> map) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(map.getClass()));
            C0534b.m7867a();
            C0534b.m7873a((Map) map);
        }
    }

    public static void enableConversationSound(boolean z) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySounds").setType(Boolean.class).setValue(Boolean.toString(z)));
            C0554a.m7947d(z);
        }
    }

    public static void setAttachmentTypesEnabled(boolean z, boolean z2, boolean z3) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("extraScreenshot").setType(Boolean.class).setValue(Boolean.toString(z)), new Parameter().setName("galleryImage").setType(Boolean.class).setValue(Boolean.toString(z2)), new Parameter().setName("screenRecording").setType(Boolean.class).setValue(Boolean.toString(z3)));
            C0554a.m7936a(new AttachmentTypesState(z, z2, z3));
        }
    }

    public static void skipImageAttachmentAnnotation(boolean z) {
        if (isReadyToRun()) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("skipImageAnnotation").setType(Boolean.class).setValue(Boolean.toString(z)));
            C0554a.m7949e(z);
        }
    }

    private static boolean isReadyToRun() {
        ChatPlugin chatPlugin = (ChatPlugin) InstabugCore.getXPlugin(ChatPlugin.class);
        if (chatPlugin != null && chatPlugin.isAppContextAvailable() && isChatFeatureEnabled()) {
            return true;
        }
        return false;
    }

    private static boolean isChatFeatureEnabled() {
        return InstabugCore.getFeatureState(Feature.IN_APP_MESSAGING) == State.ENABLED;
    }

    public static void setOnSdkDismissedCallback(OnSdkDismissedCallback onSdkDismissedCallback) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("onSdkDismissedCallback").setType(OnSdkDismissedCallback.class));
        C0554a.m7937a(onSdkDismissedCallback);
    }
}
