package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Getter;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$Getter$descriptor$2 extends Lambda implements Function0<PropertyGetterDescriptor> {
    final /* synthetic */ Getter f38283a;

    KPropertyImpl$Getter$descriptor$2(Getter getter) {
        this.f38283a = getter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object b = this.f38283a.mo7255d().m36189m().mo7826b();
        if (b != null) {
            return b;
        }
        PropertyDescriptor m = this.f38283a.mo7255d().m36189m();
        Companion companion = Annotations.f32643a;
        b = DescriptorFactory.m27634b(m, Companion.m27115a());
        Intrinsics.m26843a(b, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
        return (PropertyGetterDescriptor) b;
    }
}
