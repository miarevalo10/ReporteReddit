package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$annotations_$1 extends Lambda implements Function0<List<? extends Annotation>> {
    final /* synthetic */ KCallableImpl f38216a;

    KCallableImpl$annotations_$1(KCallableImpl kCallableImpl) {
        this.f38216a = kCallableImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return UtilKt.m26933a((Annotated) this.f38216a.mo6676a());
    }
}
