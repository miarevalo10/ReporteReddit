package com.reddit.frontpage.ui.profile;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import org.parceler.Parcel;

public class UserAccountScreen extends BaseAccountScreen {
    @State
    String username;

    @Parcel
    static class DeepLinker implements ScreenDeepLinker {
        String username;

        DeepLinker() {
        }

        public Screen createScreen() {
            return UserAccountScreen.m41075a(this.username);
        }
    }

    protected final void E_() {
    }

    public String getAnalyticsScreenName() {
        return "profile_about";
    }

    public static UserAccountScreen m41075a(String str) {
        UserAccountScreen userAccountScreen = new UserAccountScreen();
        userAccountScreen.username = str;
        return userAccountScreen;
    }

    public final ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        ((ScreenViewPayload) N.payload).target_type = "account";
        ((ScreenViewPayload) N.payload).target_name = this.username;
        Account account = (Account) AccountStorage.b.a(SessionManager.b().c.getUsername());
        ((ScreenViewPayload) N.payload).user_name = SessionManager.b().c.getUsername();
        if (account != null) {
            ((ScreenViewPayload) N.payload).user_id36 = account.getId();
        }
        return N;
    }
}
