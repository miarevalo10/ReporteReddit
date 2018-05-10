package com.reddit.frontpage.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.preferences.RedditPreferenceRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\nR\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\u00060\nR\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/di/module/UserPreferenceDataModule;", "", "()V", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "context", "Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/UserSettingsStorage$UserSettings;", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/UserSettingsStorage;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "userSettings", "username", "", "userSharedPreferences", "application", "Landroid/app/Application;", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserPreferenceDataModule.kt */
public final class UserPreferenceDataModule {
    public static final Companion f20257a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/di/module/UserPreferenceDataModule$Companion;", "", "()V", "FILE_NAME_PREFIX_PREFERENCES", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserPreferenceDataModule.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static PreferenceRepository m22381a(Context context, SharedPreferences sharedPreferences, UserSettings userSettings, BackgroundThread backgroundThread) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(sharedPreferences, "prefs");
        Intrinsics.m26847b(userSettings, "settings");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        return new RedditPreferenceRepository(context, userSettings, sharedPreferences, backgroundThread);
    }

    public static String m22382a(Session session) {
        Intrinsics.m26847b(session, SDKCoreEvent.Session.TYPE_SESSION);
        session = session.getUsername();
        return session == null ? "Reddit for Android" : session;
    }

    public static UserSettings m22380a(String str) {
        Intrinsics.m26847b(str, "username");
        return new UserSettings(UserSettingsStorage.a(), str);
    }

    public static SharedPreferences m22379a(String str, Application application) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(application, "application");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shared_preferences_");
        stringBuilder.append(str);
        Object sharedPreferences = application.getSharedPreferences(stringBuilder.toString(), 0);
        Intrinsics.m26843a(sharedPreferences, "application.getSharedPre… Context.MODE_PRIVATE\n  )");
        return sharedPreferences;
    }
}
