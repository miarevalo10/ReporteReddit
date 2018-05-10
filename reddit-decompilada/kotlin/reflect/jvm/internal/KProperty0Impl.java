package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R-\u0010\u0015\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0017*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u00120\u0016¢\u0006\u0002\b\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getter_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KProperty0Impl.kt */
public class KProperty0Impl<R> extends KPropertyImpl<R> implements KProperty0<R> {
    private final LazyVal<Getter<R>> f38272a = ReflectProperties.m26918a((Function0) new KProperty0Impl$getter_$1(this));
    private final Lazy<Object> f38273g = LazyKt.m26776a(LazyThreadSafetyMode.f25264b, (Function0) new KProperty0Impl$delegateFieldValue$1(this));

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KProperty0Impl.kt */
    public static final class Getter<R> extends kotlin.reflect.jvm.internal.KPropertyImpl.Getter<R> implements kotlin.reflect.KProperty0.Getter<R> {
        private final KProperty0Impl<R> f39712b;

        public Getter(KProperty0Impl<? extends R> kProperty0Impl) {
            Intrinsics.m26847b(kProperty0Impl, "property");
            this.f39712b = kProperty0Impl;
        }

        public final R invoke() {
            return this.f39712b.mo7073d();
        }

        public final /* bridge */ /* synthetic */ KPropertyImpl mo7255d() {
            return this.f39712b;
        }
    }

    public final /* synthetic */ kotlin.reflect.KProperty0.Getter mo7067i() {
        return m38261o();
    }

    public final /* synthetic */ kotlin.reflect.jvm.internal.KPropertyImpl.Getter mo7074j() {
        return m38261o();
    }

    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        super(kDeclarationContainerImpl, propertyDescriptor);
    }

    public KProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "signature");
        super(kDeclarationContainerImpl, str, str2, obj);
    }

    private Getter<R> m38261o() {
        Object a = this.f38272a.mo5694a();
        Intrinsics.m26843a(a, "getter_()");
        return (Getter) a;
    }

    public final R mo7073d() {
        return m38261o().mo5686a(new Object[0]);
    }

    public R invoke() {
        return mo7073d();
    }
}
