package com.reddit.frontpage.redditauth_private.ui;

import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.redditauth_private.account.Credentials;
import com.reddit.frontpage.redditauth_private.ui.LoginFragment.OnLoginListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "credentials", "Lcom/reddit/frontpage/redditauth_private/account/Credentials;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
final class AuthenticatorFragment$login$2 extends Lambda implements Function1<Credentials, Unit> {
    final /* synthetic */ AuthenticatorFragment f37117a;
    final /* synthetic */ String f37118b;
    final /* synthetic */ String f37119c;

    AuthenticatorFragment$login$2(AuthenticatorFragment authenticatorFragment, String str, String str2) {
        this.f37117a = authenticatorFragment;
        this.f37118b = str;
        this.f37119c = str2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Credentials credentials = (Credentials) obj;
        Intrinsics.m26847b(credentials, "credentials");
        ((OnLoginListener) this.f37117a.f37132c.mo5678b()).mo7786a(this.f37118b, this.f37119c, Scope.WILD_SCOPE, credentials);
        return Unit.f25273a;
    }
}
