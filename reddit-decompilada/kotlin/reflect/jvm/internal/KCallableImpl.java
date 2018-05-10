package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017¢\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016¢\u0006\u0002\u0010=J#\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J\u0012\u0010@\u001a\u0004\u0018\u0001092\u0006\u0010A\u001a\u00020BH\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u000b*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\n¢\u0006\u0002\b\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\bR-\u0010%\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# \u000b*\n\u0012\u0004\u0012\u00020#\u0018\u00010&0&0\n¢\u0006\u0002\b\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R!\u0010+\u001a\u0015\u0012\f\u0012\n \u000b*\u0004\u0018\u00010,0,0\n¢\u0006\u0002\b\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\bR-\u00100\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \u000b*\n\u0012\u0004\u0012\u000201\u0018\u00010\u00050\u00050\n¢\u0006\u0002\b\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "Lkotlin/reflect/KParameter;", "getParameters", "parameters_", "Ljava/util/ArrayList;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType_", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters_", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KCallableImpl.kt */
public abstract class KCallableImpl<R> implements KCallable<R> {
    private final LazySoftVal<List<Annotation>> f32568a = ReflectProperties.m26919b(new KCallableImpl$annotations_$1(this));
    private final LazySoftVal<ArrayList<KParameter>> f32569b = ReflectProperties.m26919b(new KCallableImpl$parameters_$1(this));
    private final LazySoftVal<KTypeImpl> f32570c = ReflectProperties.m26919b(new KCallableImpl$returnType_$1(this));
    private final LazySoftVal<List<KTypeParameterImpl>> f32571d = ReflectProperties.m26919b(new KCallableImpl$typeParameters_$1(this));

    public abstract CallableMemberDescriptor mo6676a();

    public abstract FunctionCaller<?> mo6677c();

    public abstract KDeclarationContainerImpl mo6674e();

    public abstract boolean mo6675f();

    public final List<KParameter> m32888g() {
        Object a = this.f32569b.mo5694a();
        Intrinsics.m26843a(a, "parameters_()");
        return (List) a;
    }

    protected final boolean m32889h() {
        return Intrinsics.m26845a(mo5687b(), (Object) "<init>") && mo6674e().mo6657a().isAnnotation();
    }

    public final R mo5686a(Object... objArr) {
        Intrinsics.m26847b(objArr, "args");
        try {
            return mo6677c().mo5688a(objArr);
        } catch (Object[] objArr2) {
            throw new IllegalCallableAccessException(objArr2);
        }
    }
}
