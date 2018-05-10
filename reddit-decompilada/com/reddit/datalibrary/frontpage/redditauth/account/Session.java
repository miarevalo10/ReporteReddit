package com.reddit.datalibrary.frontpage.redditauth.account;

import android.text.TextUtils;
import com.reddit.data.events.models.AnalyticsSession;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import java.io.Serializable;

public class Session implements AnalyticsSession, Serializable {
    public final SessionId f16288a;
    public volatile String f16289b;
    volatile long f16290c;

    public static class SessionId implements Serializable {
        private final String f10834a;
        private final String f10835b;

        private SessionId(String str, String str2) {
            this.f10834a = str;
            this.f10835b = str2;
        }

        public static SessionId m9180a(String str, String str2) {
            return new SessionId(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    SessionId sessionId = (SessionId) obj;
                    return TextUtils.equals(this.f10834a, sessionId.f10834a) && TextUtils.equals(this.f10835b, sessionId.f10835b) != null;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = 31 * (this.f10834a != null ? this.f10834a.hashCode() : 0);
            if (this.f10835b != null) {
                i = this.f10835b.hashCode();
            }
            return hashCode + i;
        }
    }

    public Session(String str, String str2, String str3) {
        this.f16288a = new SessionId(str, str2);
        this.f16289b = str3;
    }

    public final SessionId m16309a() {
        return this.f16288a;
    }

    public String getUsername() {
        return this.f16288a.f10834a;
    }

    public final String m16311b() {
        return this.f16289b;
    }

    public final long m16312c() {
        return this.f16290c;
    }

    public final boolean m16313d() {
        if (this.f16289b != null && this.f16290c >= System.currentTimeMillis()) {
            if (!TextUtils.equals(this.f16289b, "invalid-token")) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnonymous() {
        return TextUtils.isEmpty(this.f16288a.f10834a);
    }

    final void m16310a(String str, long j) {
        this.f16289b = str;
        this.f16290c = j;
    }

    public String getSessionId() {
        return Config.m9154b();
    }

    public Long getSessionCreatedTimestamp() {
        return Long.valueOf(Config.m9156c());
    }

    public String getLoId() {
        return Config.f10820h;
    }

    public String getRedditAdId() {
        return Config.f10822j;
    }

    public String getAccountId() {
        Account account = (Account) AccountStorage.f15744b.m8751a(getUsername());
        return account != null ? account.getId() : null;
    }

    public Long getAccountCreatedUtc() {
        Account account = (Account) AccountStorage.f15744b.m8751a(getUsername());
        return account != null ? Long.valueOf(account.getCreatedUtc()) : null;
    }

    public boolean isBetaTester() {
        return FrontpageSettings.m9011a().m9051l(getUsername());
    }

    public String getThemeName() {
        return String.format("%smode", new Object[]{FrontpageSettings.m9011a().m9028c(true).name().toLowerCase()});
    }

    public String getListingViewType() {
        return FrontpageSettings.m9011a().m9030c() ? "compact" : "card";
    }
}
