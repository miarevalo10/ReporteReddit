package com.reddit.frontpage.redditauth_private.ui;

import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.redditauth_private.account.TokenRetriever;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/redditauth_private/account/Credentials;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
final class AuthenticatorFragment$login$1<V> implements Callable<T> {
    final /* synthetic */ AuthenticatorFragment f21017a;
    final /* synthetic */ String f21018b;
    final /* synthetic */ String f21019c;
    final /* synthetic */ String f21020d;

    AuthenticatorFragment$login$1(AuthenticatorFragment authenticatorFragment, String str, String str2, String str3) {
        this.f21017a = authenticatorFragment;
        this.f21018b = str;
        this.f21019c = str2;
        this.f21020d = str3;
    }

    public final /* synthetic */ Object call() {
        this.f21017a.getActivity();
        return TokenRetriever.m23230a(new RedditAuthClient(), this.f21018b, this.f21019c, this.f21020d, Scope.WILD_SCOPE);
    }
}
