package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BanReasonsScreen.kt */
final class BanReasonsScreen$onCreate$adapter$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ BanReasonsScreen f36978a;

    BanReasonsScreen$onCreate$adapter$1(BanReasonsScreen banReasonsScreen) {
        this.f36978a = banReasonsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "it");
        BanReasonsPresenter banReasonsPresenter = this.f36978a.f39104d;
        if (banReasonsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        Intrinsics.m26847b(str, "banReason");
        banReasonsPresenter.f34068a.mo7182a(new BanReason(str));
        return Unit.f25273a;
    }
}
