package com.reddit.frontpage.redditauth_private.ui;

import android.support.v4.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/redditauth_private/ui/AuthActivity;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
final class AuthenticatorFragment$authActivity$2 extends Lambda implements Function0<AuthActivity> {
    final /* synthetic */ AuthenticatorFragment f37116a;

    AuthenticatorFragment$authActivity$2(AuthenticatorFragment authenticatorFragment) {
        this.f37116a = authenticatorFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        FragmentActivity activity = this.f37116a.getActivity();
        if (activity != null) {
            return (AuthActivity) activity;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.redditauth_private.ui.AuthActivity");
    }
}
