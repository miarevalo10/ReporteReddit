package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.reflect.KParameter;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/jvm/functions/Function1;)V", "compare", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 1, 5})
/* compiled from: Comparisons.kt */
public final class KCallableImpl$parameters_$1$$special$$inlined$sortBy$1 implements Comparator<KParameter> {
    KCallableImpl$parameters_$1$$special$$inlined$sortBy$1() {
    }

    public final int compare(KParameter kParameter, KParameter kParameter2) {
        return ComparisonsKt__ComparisonsKt.m26807a(kParameter.mo5692a(), kParameter2.mo5692a());
    }
}
