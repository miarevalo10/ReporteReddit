package com.reddit.frontpage.presentation.modtools.actions;

import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModToolsActionsScreen.kt */
final class ModToolsActionsScreen$Companion$newInstance$1$1 extends Lambda implements Function1<ModToolsAction, Unit> {
    final /* synthetic */ ModToolsActionsScreen f36958a;

    ModToolsActionsScreen$Companion$newInstance$1$1(ModToolsActionsScreen modToolsActionsScreen) {
        this.f36958a = modToolsActionsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ModToolsAction modToolsAction = (ModToolsAction) obj;
        Intrinsics.m26847b(modToolsAction, "it");
        this.f36958a.m40726w().m34793a(modToolsAction);
        return Unit.f25273a;
    }
}
