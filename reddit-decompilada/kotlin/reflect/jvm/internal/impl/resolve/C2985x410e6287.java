package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: overridingUtils.kt */
final class C2985x410e6287 extends Lambda implements Function1<H, Unit> {
    final /* synthetic */ SmartSet f38805a;

    C2985x410e6287(SmartSet smartSet) {
        this.f38805a = smartSet;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SmartSet smartSet = this.f38805a;
        Intrinsics.m26843a(obj, "it");
        smartSet.add(obj);
        return Unit.f25273a;
    }
}
