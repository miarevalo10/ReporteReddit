package com.reddit.frontpage.redditauth_private.ui;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.redditauth_private.ui.AuthActivity.NavigationListener;
import com.reddit.frontpage.redditauth_private.ui.AuthenticatorFragment.Companion;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment$navigationListener$1", "Lcom/reddit/frontpage/redditauth_private/ui/AuthActivity$NavigationListener;", "(Lcom/reddit/frontpage/redditauth_private/ui/AuthenticatorFragment;)V", "CONTROL_NAME_BACK", "", "logNavigateAway", "", "onBackPressed", "onUpPressed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
public final class AuthenticatorFragment$navigationListener$1 implements NavigationListener {
    final /* synthetic */ AuthenticatorFragment f28839a;
    private final String f28840b = "second_factor_back_to_signin";

    AuthenticatorFragment$navigationListener$1(AuthenticatorFragment authenticatorFragment) {
        this.f28839a = authenticatorFragment;
    }

    public final void mo4939a() {
        m29911c();
    }

    public final void mo4940b() {
        m29911c();
    }

    private final void m29911c() {
        String a;
        Companion companion;
        if (this.f28839a.isBackup) {
            companion = AuthenticatorFragment.f37125b;
            a = AuthenticatorFragment.f37128i;
        } else {
            companion = AuthenticatorFragment.f37125b;
            a = AuthenticatorFragment.f37129j;
        }
        AppAnalytics.m21858b().m21824a(a).m21826b(this.f28840b).m21825a();
    }
}
