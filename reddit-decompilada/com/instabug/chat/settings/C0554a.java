package com.instabug.chat.settings;

import android.content.Context;
import com.instabug.library.OnSdkDismissedCallback;

/* compiled from: ChatSettings */
public class C0554a {
    public static void m7935a(Context context) {
        C0555b.m7959a();
        C0556c.m7962a(context.getSharedPreferences("com.instabug.chat", 0));
    }

    public static Runnable m7932a() {
        return C0555b.m7960b().f9296b;
    }

    public static void m7938a(Runnable runnable) {
        C0555b.m7960b().f9296b = runnable;
    }

    public static AttachmentTypesState m7941b() {
        return C0555b.m7960b().f9295a;
    }

    public static void m7936a(AttachmentTypesState attachmentTypesState) {
        C0555b.m7960b().f9295a = attachmentTypesState;
    }

    public static long m7946d() {
        return C0556c.m7961a().f9300a.getLong("ibc_last_chat_time", System.currentTimeMillis());
    }

    public static void m7934a(long j) {
        C0556c.m7961a().f9300a.edit().putLong("ibc_last_chat_time", j).apply();
    }

    public static long m7948e() {
        return C0556c.m7961a().f9300a.getLong("ibc_ttl", 60);
    }

    public static void m7942b(long j) {
        C0556c.m7961a().f9300a.edit().putLong("ibc_ttl", j).apply();
    }

    public static boolean m7951f() {
        return C0556c.m7961a().f9300a.getBoolean("ibc__notifications_state", true);
    }

    public static void m7940a(boolean z) {
        C0556c.m7961a().f9300a.edit().putBoolean("ibc__notifications_state", z).apply();
    }

    public static boolean m7952g() {
        return C0556c.m7961a().f9300a.getBoolean("ibc_notification_sound", false);
    }

    public static void m7943b(boolean z) {
        C0556c.m7961a().f9300a.edit().putBoolean("ibc_notification_sound", z).apply();
    }

    public static boolean m7953h() {
        return C0556c.m7961a().f9300a.getBoolean("ibc_in_app_notification_sound", false);
    }

    public static void m7944c(boolean z) {
        C0556c.m7961a().f9300a.edit().putBoolean("ibc_in_app_notification_sound", z).apply();
    }

    public static void m7947d(boolean z) {
        C0556c.m7961a().f9300a.edit().putBoolean("ibc_conversation_sounds", z).apply();
    }

    public static int m7954i() {
        return C0556c.m7961a().f9300a.getInt("ibc_push_notification_icon", -1);
    }

    public static void m7933a(int i) {
        C0556c.m7961a().f9300a.edit().putInt("ibc_push_notification_icon", i).apply();
    }

    public static boolean m7955j() {
        return C0555b.m7960b().f9297c;
    }

    public static void m7949e(boolean z) {
        C0555b.m7960b().f9297c = z;
    }

    public static OnSdkDismissedCallback m7956k() {
        return C0555b.m7960b().f9298d;
    }

    public static void m7937a(OnSdkDismissedCallback onSdkDismissedCallback) {
        C0555b.m7960b().f9298d = onSdkDismissedCallback;
    }

    public static void m7939a(String str) {
        C0556c.m7961a().f9300a.edit().putString("ibc_push_notification_token", str).apply();
    }

    public static String m7957l() {
        return C0556c.m7961a().f9300a.getString("ibc_push_notification_token", "");
    }

    public static void m7950f(boolean z) {
        C0556c.m7961a().f9300a.edit().putBoolean("ibc_is_push_notification_token_sent", z).apply();
    }

    public static boolean m7958m() {
        return C0556c.m7961a().f9300a.getBoolean("ibc_is_push_notification_token_sent", false);
    }

    public static boolean m7945c() {
        AttachmentTypesState attachmentTypesState = C0555b.m7960b().f9295a;
        if (!(attachmentTypesState.isScreenshotEnabled() || attachmentTypesState.isImageFromGalleryEnabled())) {
            if (!attachmentTypesState.isScreenRecordingEnabled()) {
                return false;
            }
        }
        return true;
    }
}
