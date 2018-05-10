package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0013\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0015*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00100\u00100\u0014¢\u0006\u0002\b\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "R", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "setter", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "setter_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KProperty0Impl.kt */
public final class KMutableProperty0Impl<R> extends KProperty0Impl<R> implements KMutableProperty0<R> {
    final LazyVal<Setter<R>> f39707a = ReflectProperties.m26918a((Function0) new KMutableProperty0Impl$setter_$1(this));

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", "", "value", "(Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KProperty0Impl.kt */
    public static final class Setter<R> extends kotlin.reflect.jvm.internal.KPropertyImpl.Setter<R> implements kotlin.reflect.KMutableProperty0.Setter<R> {
        private final KMutableProperty0Impl<R> f39706b;

        public Setter(KMutableProperty0Impl<R> kMutableProperty0Impl) {
            Intrinsics.m26847b(kMutableProperty0Impl, "property");
            this.f39706b = kMutableProperty0Impl;
        }

        public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
            Object a = this.f39706b.f39707a.mo5694a();
            Intrinsics.m26843a(a, "setter_()");
            ((Setter) a).mo5686a(obj);
            return Unit.f25273a;
        }

        public final /* bridge */ /* synthetic */ KPropertyImpl mo7255d() {
            return this.f39706b;
        }
    }

    public KMutableProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        super(kDeclarationContainerImpl, propertyDescriptor);
    }

    public KMutableProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "signature");
        super(kDeclarationContainerImpl, str, str2, obj);
    }
}
