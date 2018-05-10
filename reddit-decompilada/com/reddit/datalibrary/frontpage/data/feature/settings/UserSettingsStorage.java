package com.reddit.datalibrary.frontpage.data.feature.settings;

import android.content.SharedPreferences;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountPrefs;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.JsonUtil;
import java.util.Locale;
import timber.log.Timber;

public class UserSettingsStorage {
    private static UserSettingsStorage f10771a;
    private final SharedPreferences f10772b = FrontpageApplication.a.getSharedPreferences("com.reddit.user_settings", 0);

    public class UserSettings {
        public AccountPrefs f10768a;
        final /* synthetic */ UserSettingsStorage f10769b;
        private final String f10770c;

        public UserSettings(UserSettingsStorage userSettingsStorage, String str) {
            this.f10769b = userSettingsStorage;
            this.f10770c = str;
            userSettingsStorage = userSettingsStorage.f10772b.getString(m9088a(str), null);
            if (userSettingsStorage == null) {
                this.f10768a = new AccountPrefs();
                return;
            }
            this.f10768a = (AccountPrefs) JsonUtil.a(userSettingsStorage, AccountPrefs.class);
            m9091b();
        }

        private static String m9088a(String str) {
            return String.format(Locale.ENGLISH, "account_prefs:%d:%s", new Object[]{Integer.valueOf(0), str});
        }

        public final void m9090a(AccountPrefs accountPrefs) {
            String a = JsonUtil.a(accountPrefs);
            this.f10769b.f10772b.edit().putString(m9088a(this.f10770c), a).apply();
            this.f10768a = accountPrefs;
            accountPrefs = new StringBuilder("rendered: ");
            accountPrefs.append(a);
            Timber.b(accountPrefs.toString(), new Object[0]);
        }

        public final AccountPrefs m9089a() {
            return this.f10768a;
        }

        public final void m9091b() {
            m9090a(this.f10768a);
        }
    }

    private UserSettingsStorage() {
    }

    public static UserSettingsStorage m9093a() {
        if (f10771a == null) {
            f10771a = new UserSettingsStorage();
        }
        return f10771a;
    }

    public final UserSettings m9095a(String str) {
        return new UserSettings(this, str);
    }

    public final UserSettings m9094a(Session session) {
        if (session.isAnonymous()) {
            return new UserSettings(this, Operation.MULTIPLY);
        }
        return new UserSettings(this, session.getUsername());
    }
}
