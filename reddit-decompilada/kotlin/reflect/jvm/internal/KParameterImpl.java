package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KParameterImpl.kt */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty[] f32596d = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    final KCallableImpl<?> f32597a;
    final int f32598b;
    final Kind f32599c;
    private final LazySoftVal f32600e;
    private final LazySoftVal f32601f = ReflectProperties.m26919b((Function0) new KParameterImpl$annotations$2(this));

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i, Kind kind, Function0<? extends ParameterDescriptor> function0) {
        Intrinsics.m26847b(kCallableImpl, "callable");
        Intrinsics.m26847b(kind, "kind");
        Intrinsics.m26847b(function0, "computeDescriptor");
        this.f32597a = kCallableImpl;
        this.f32598b = i;
        this.f32599c = kind;
        this.f32600e = ReflectProperties.m26919b(function0);
    }

    public final String mo5692a() {
        ParameterDescriptor b = m32895b();
        if (!(b instanceof ValueParameterDescriptor)) {
            b = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) b;
        if (valueParameterDescriptor == null || valueParameterDescriptor.mo7800b().mo7758l()) {
            return null;
        }
        Name i = valueParameterDescriptor.mo6689i();
        if (i.f25866a) {
            return null;
        }
        return i.m27429a();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (Intrinsics.m26845a(this.f32597a, kParameterImpl.f32597a) && Intrinsics.m26845a(m32895b(), kParameterImpl.m32895b()) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (this.f32597a.hashCode() * 31) + m32895b().hashCode();
    }

    public final String toString() {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f25341a;
        return ReflectionObjectRenderer.m26920a(this);
    }

    private final ParameterDescriptor m32895b() {
        return (ParameterDescriptor) this.f32600e.mo5694a();
    }
}
