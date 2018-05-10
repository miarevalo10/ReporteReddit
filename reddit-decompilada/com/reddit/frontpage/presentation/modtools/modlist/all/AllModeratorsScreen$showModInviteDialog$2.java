package com.reddit.frontpage.presentation.modtools.modlist.all;

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
/* compiled from: AllModeratorsScreen.kt */
final class AllModeratorsScreen$showModInviteDialog$2 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ AllModeratorsScreen f36986a;

    AllModeratorsScreen$showModInviteDialog$2(AllModeratorsScreen allModeratorsScreen) {
        this.f36986a = allModeratorsScreen;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        ((Number) obj2).intValue();
        Intrinsics.m26847b(dialogInterface, "<anonymous parameter 0>");
        ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a((String) ModEventBuilder.f27455f)).m21892b(ModEventBuilder.f27450a)).m21889a(this.f36986a.m40781y(), this.f36986a.mo7383a())).m21895c(ModNoun.f20036H.name())).m21891a();
        this.f36986a.mo7671P().m37361e();
        return Unit.f25273a;
    }
}
