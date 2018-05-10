package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001 B)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001f\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R9\u0010\u0017\u001a-\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0019*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00140\u00140\u0018¢\u0006\u0002\b\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KProperty1Impl.kt */
public class KProperty1Impl<T, R> extends KPropertyImpl<R> implements KProperty1<T, R> {
    private final LazyVal<Getter<T, R>> f38276a = ReflectProperties.m26918a((Function0) new KProperty1Impl$getter_$1(this));
    private final Lazy<Field> f38277g = LazyKt.m26776a(LazyThreadSafetyMode.f25264b, (Function0) new KProperty1Impl$delegateField$1(this));

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KProperty1Impl.kt */
    public static final class Getter<T, R> extends kotlin.reflect.jvm.internal.KPropertyImpl.Getter<R> implements kotlin.reflect.KProperty1.Getter<T, R> {
        private final KProperty1Impl<T, R> f39713b;

        public Getter(KProperty1Impl<T, ? extends R> kProperty1Impl) {
            Intrinsics.m26847b(kProperty1Impl, "property");
            this.f39713b = kProperty1Impl;
        }

        public final R mo6492a(T t) {
            return this.f39713b.mo7075b(t);
        }

        public final /* bridge */ /* synthetic */ KPropertyImpl mo7255d() {
            return this.f39713b;
        }
    }

    public final /* synthetic */ kotlin.reflect.KProperty1.Getter mo7068d() {
        return m38265i();
    }

    public final /* synthetic */ kotlin.reflect.jvm.internal.KPropertyImpl.Getter mo7074j() {
        return m38265i();
    }

    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "signature");
        super(kDeclarationContainerImpl, str, str2, obj);
    }

    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(kDeclarationContainerImpl, "container");
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        super(kDeclarationContainerImpl, propertyDescriptor);
    }

    private Getter<T, R> m38265i() {
        Object a = this.f38276a.mo5694a();
        Intrinsics.m26843a(a, "getter_()");
        return (Getter) a;
    }

    public final R mo7075b(T t) {
        return m38265i().mo5686a(t);
    }

    public final R mo6492a(T t) {
        return mo7075b(t);
    }
}
