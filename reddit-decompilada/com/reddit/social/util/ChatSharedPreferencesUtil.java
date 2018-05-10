package com.reddit.social.util;

import android.accounts.Account;
import android.content.Context;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import com.reddit.frontpage.FrontpageApplication;

import io.fabric.sdk.android.services.events.EventsFilesManager;

import java.util.Map;

import timber.log.Timber;

public class ChatSharedPreferencesUtil {

    static class C23921 extends TypeToken<Map<String, SendBirdAccessTokenData>> {
        C23921() {
        }
    }

    public static Map<String, SendBirdAccessTokenData> m24743a(Context context) {
        Gson gson = new Gson();
        context = context.getSharedPreferences("sendBird", 0).getString("sendbird_access_token_map", null);
        if (context == null) {
            return null;
        }
        try {
            context = (Map) gson.a(context, new C23921().b);
        } catch (Context context2) {
            Timber.c(context2, "getSendBirdAccessTokenData", new Object[0]);
            context2 = null;
        }
        return context2;
    }

    public static void m24745a(Context context, Map<String, SendBirdAccessTokenData> map) {
        if (map != null) {
            context.get SharedPreferences ("sendBird", 0).
            edit().putString("sendbird_access_token_map", new Gson().b(map)).apply();
        }
    }

    public static int m24742a() {
        return FrontpageApplication.f27402a.getSharedPreferences("sendBird", 0).getInt("sendbird_unread_messages_count", 0);
    }

    public static void m24744a(int i) {
        FrontpageApplication.f27402a.getSharedPreferences("sendBird", 0).edit().putInt("sendbird_unread_messages_count", i).apply();
    }

    public static int m24747b() {
        return FrontpageApplication.f27402a.getSharedPreferences("sendBird", 0).getInt("sendbird_max_message_limit", HttpStatus.HTTP_NOT_IMPLEMENTED);
    }

    public static void m24748b(int i) {
        FrontpageApplication.f27402a.getSharedPreferences("sendBird", 0).edit().putInt("sendbird_max_message_limit", i).apply();
    }

    public static boolean m24746a(Context context, String str) {
        Account a = AccountUtil.a(context);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(a.name);
        str = stringBuilder.toString();
        boolean z = context.getSharedPreferences("sendBird", 0).getBoolean(str, true);
        if (z) {
            context.getSharedPreferences("sendBird", 0).edit().putBoolean(str, false).apply();
        }
        return z;
    }
}
