package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$data$1 extends Lambda implements Function0<Data> {
    final /* synthetic */ KPackageImpl f38265a;

    KPackageImpl$data$1(KPackageImpl kPackageImpl) {
        this.f38265a = kPackageImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new Data(this.f38265a);
    }
}
