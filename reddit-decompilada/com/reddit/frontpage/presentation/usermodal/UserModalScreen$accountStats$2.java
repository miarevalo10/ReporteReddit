package com.reddit.frontpage.presentation.usermodal;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.profile.AccountStatsView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/widgets/profile/AccountStatsView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserModalScreen.kt */
final class UserModalScreen$accountStats$2 extends Lambda implements Function0<AccountStatsView> {
    final /* synthetic */ UserModalScreen f37110a;

    UserModalScreen$accountStats$2(UserModalScreen userModalScreen) {
        this.f37110a = userModalScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = UserModalScreen.m29885a(this.f37110a).findViewById(C1761R.id.account_stats);
        if (findViewById != null) {
            return (AccountStatsView) findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.profile.AccountStatsView");
    }
}
