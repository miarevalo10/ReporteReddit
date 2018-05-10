package com.reddit.frontpage.presentation.communities;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "position", "", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesScreen.kt */
final class C2818x2d464220 extends Lambda implements Function2<Integer, Set<? extends String>, Unit> {
    final /* synthetic */ CommunitiesAdapter f36424a;

    C2818x2d464220(CommunitiesAdapter communitiesAdapter) {
        this.f36424a = communitiesAdapter;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        Set set = (Set) obj2;
        Intrinsics.m26847b(set, "idsSeen");
        this.f36424a.f28119b.m40578w().m34646a(intValue, set);
        return Unit.f25273a;
    }
}
