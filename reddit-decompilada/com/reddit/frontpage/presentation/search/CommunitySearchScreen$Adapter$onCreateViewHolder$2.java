package com.reddit.frontpage.presentation.search;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "position", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
final class CommunitySearchScreen$Adapter$onCreateViewHolder$2 extends FunctionReference implements Function1<Integer, Unit> {
    CommunitySearchScreen$Adapter$onCreateViewHolder$2(RecentSearchPresenter recentSearchPresenter) {
        super(1, recentSearchPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(RecentSearchPresenter.class);
    }

    public final String mo5687b() {
        return "onItemDismissed";
    }

    public final String mo6932c() {
        return "onItemDismissed(I)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ((RecentSearchPresenter) this.b).m37462a(((Number) obj).intValue());
        return Unit.f25273a;
    }
}
