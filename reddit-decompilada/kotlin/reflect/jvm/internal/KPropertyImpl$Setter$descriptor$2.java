package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Setter;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$Setter$descriptor$2 extends Lambda implements Function0<PropertySetterDescriptor> {
    final /* synthetic */ Setter f38288a;

    KPropertyImpl$Setter$descriptor$2(Setter setter) {
        this.f38288a = setter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object c = this.f38288a.mo7255d().m36189m().mo7827c();
        if (c != null) {
            return c;
        }
        PropertyDescriptor m = this.f38288a.mo7255d().m36189m();
        Companion companion = Annotations.f32643a;
        c = DescriptorFactory.m27631a(m, Companion.m27115a());
        Intrinsics.m26843a(c, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
        return (PropertySetterDescriptor) c;
    }
}
