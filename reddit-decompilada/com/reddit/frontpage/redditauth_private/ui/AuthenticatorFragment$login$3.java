package com.reddit.frontpage.redditauth_private.ui;

import android.widget.EditText;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AuthenticatorFragment.kt */
final class AuthenticatorFragment$login$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ AuthenticatorFragment f37120a;

    AuthenticatorFragment$login$3(AuthenticatorFragment authenticatorFragment) {
        this.f37120a = authenticatorFragment;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((Throwable) obj, "it");
        if (this.f37120a.isBackup != null) {
            obj = AuthenticatorFragment.f37125b;
            obj = AuthenticatorFragment.f37128i;
        } else {
            obj = AuthenticatorFragment.f37125b;
            obj = AuthenticatorFragment.f37129j;
        }
        AppAnalytics.m21873j().m21816a(obj).m21818b("second_factor_failure").m21817a();
        this.f37120a.m37480a(true);
        obj = (EditText) this.f37120a.m37492a(C1761R.id.code);
        Intrinsics.m26843a(obj, "code");
        obj.setError(this.f37120a.getString(C1761R.string.error_bad_code));
        return Unit.f25273a;
    }
}
