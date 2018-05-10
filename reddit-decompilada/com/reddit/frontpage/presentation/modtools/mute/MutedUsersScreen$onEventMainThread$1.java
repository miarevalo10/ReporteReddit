package com.reddit.frontpage.presentation.modtools.mute;

import android.content.DialogInterface;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MutedUsersScreen.kt */
final class MutedUsersScreen$onEventMainThread$1 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ MutedUsersScreen f36995a;

    MutedUsersScreen$onEventMainThread$1(MutedUsersScreen mutedUsersScreen) {
        this.f36995a = mutedUsersScreen;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        ((Number) obj2).intValue();
        Intrinsics.m26847b(dialogInterface, "<anonymous parameter 0>");
        ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a((String) ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20064w.f20068M)).m21889a(this.f36995a.m40781y(), this.f36995a.mo7383a())).m21891a();
        obj = this.f36995a.f40592v;
        if (obj == null) {
            Intrinsics.m26844a("presenter");
        }
        obj.m37372b();
        return Unit.f25273a;
    }
}
