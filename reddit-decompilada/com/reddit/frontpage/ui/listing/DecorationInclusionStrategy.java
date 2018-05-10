package com.reddit.frontpage.ui.listing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B!\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\b¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0004R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "", "check", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "checks", "", "(Ljava/util/List;)V", "addCheck", "includeOffset", "position", "Defaults", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DecorationInclusionStrategy.kt */
public final class DecorationInclusionStrategy {
    public static final Defaults f21272b = new Defaults();
    final List<Function1<Integer, Boolean>> f21273a;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy$Defaults;", "", "()V", "excludeStartStrategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "includeStartStrategy", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DecorationInclusionStrategy.kt */
    public static final class Defaults {
        private Defaults() {
        }

        public static DecorationInclusionStrategy m23387a() {
            return new DecorationInclusionStrategy((Function1) DecorationInclusionStrategy$Defaults$includeStartStrategy$1.f37260a);
        }

        public static DecorationInclusionStrategy m23388b() {
            return new DecorationInclusionStrategy((Function1) DecorationInclusionStrategy$Defaults$excludeStartStrategy$1.f37259a);
        }
    }

    private /* synthetic */ DecorationInclusionStrategy() {
        this((List) new ArrayList());
    }

    private DecorationInclusionStrategy(List<Function1<Integer, Boolean>> list) {
        Intrinsics.m26847b(list, "checks");
        this.f21273a = list;
    }

    public DecorationInclusionStrategy(Function1<? super Integer, Boolean> function1) {
        Intrinsics.m26847b(function1, "check");
        this(CollectionsKt__CollectionsKt.m26797c(function1));
    }

    public final DecorationInclusionStrategy m23389a(Function1<? super Integer, Boolean> function1) {
        Intrinsics.m26847b(function1, "check");
        this.f21273a.add(function1);
        return this;
    }
}
