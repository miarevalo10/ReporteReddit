package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor {
    final JavaAnnotation f32720a;
    private final NullableLazyValue<FqName> f32721b = this.f32726g.f25703b.f25685a.mo5931b((Function0) new LazyJavaAnnotationDescriptor$fqName$1(this));
    private final NotNullLazyValue<SimpleType> f32722c = this.f32726g.f25703b.f25685a.mo5926a((Function0) new LazyJavaAnnotationDescriptor$type$1(this));
    private final JavaSourceElement f32723d = this.f32726g.f25703b.f25695k.mo5773a(this.f32720a);
    private final ConstantValueFactory f32724e = new ConstantValueFactory(this.f32726g.f25703b.f25700p.mo7089b());
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> f32725f = this.f32726g.f25703b.f25685a.mo5926a((Function0) new LazyJavaAnnotationDescriptor$allValueArguments$1(this));
    private final LazyJavaResolverContext f32726g;

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaAnnotation, "javaAnnotation");
        this.f32726g = lazyJavaResolverContext;
        this.f32720a = javaAnnotation;
    }

    public final KotlinType mo5719a() {
        Object invoke = this.f32722c.invoke();
        Intrinsics.m26843a(invoke, "type()");
        return (KotlinType) invoke;
    }

    public final Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b() {
        return (Map) this.f32725f.invoke();
    }

    private final ClassDescriptor m33057d() {
        ClassifierDescriptor c = mo5719a().mo6743g().mo5724c();
        if (c != null) {
            return (ClassDescriptor) c;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    private final ConstantValue<?> m33053a(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return this.f32724e.m27724a(((JavaLiteralAnnotationArgument) javaAnnotationArgument).mo6710b());
        }
        ClassDescriptor a;
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            javaAnnotationArgument = ((JavaEnumValueAnnotationArgument) javaAnnotationArgument).mo6709b();
            if (javaAnnotationArgument.mo7288b()) {
                a = this.f32726g.f25703b.f25696l.mo5780a(javaAnnotationArgument.mo7098d());
                if (a != null) {
                    javaAnnotationArgument = a.mo7739t().mo6699c(javaAnnotationArgument.mo7103p(), NoLookupLocation.f32689s);
                    if (javaAnnotationArgument instanceof ClassDescriptor) {
                        return ConstantValueFactory.m27717a((ClassDescriptor) javaAnnotationArgument);
                    }
                }
            }
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name a2 = javaAnnotationArgument.mo5800a();
            if (a2 == null) {
                a2 = JvmAnnotationNames.f25632c;
                Intrinsics.m26843a((Object) a2, "DEFAULT_ANNOTATION_MEMBER_NAME");
            }
            javaAnnotationArgument = ((JavaArrayAnnotationArgument) javaAnnotationArgument).mo6705b();
            if (!mo5719a().mo6742d()) {
                ValueParameterDescriptor a3 = DescriptorResolverUtils.m27178a(a2, m33057d());
                if (a3 != null) {
                    Iterable<JavaAnnotationArgument> iterable = (Iterable) javaAnnotationArgument;
                    Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (JavaAnnotationArgument a4 : iterable) {
                        Object a5 = m33053a(a4);
                        if (a5 == null) {
                            a5 = this.f32724e.m27729a();
                        }
                        arrayList.add(a5);
                    }
                    List list = (List) arrayList;
                    javaAnnotationArgument = this.f32724e;
                    Object x = a3.mo7777x();
                    Intrinsics.m26843a(x, "valueParameter.type");
                    return javaAnnotationArgument.m27720a(list, x);
                }
            }
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return ConstantValueFactory.m27716a((AnnotationDescriptor) new LazyJavaAnnotationDescriptor(this.f32726g, ((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).mo6704b()));
        } else if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
            javaAnnotationArgument = TypeUtils.m28014c(this.f32726g.f25702a.m27225a(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).mo6708b(), JavaTypeResolverKt.m27226a(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 6)));
            a = DescriptorUtilsKt.m27735a(this.f32726g.f25703b.f25700p, new FqName("java.lang.Class"), NoLookupLocation.f32686p);
            if (a != null) {
                javaAnnotationArgument = CollectionsKt__CollectionsKt.m26791a((Object) new TypeProjectionImpl(javaAnnotationArgument));
                Companion companion = Annotations.f32643a;
                return ConstantValueFactory.m27719a((KotlinType) KotlinTypeFactory.m27950a(Companion.m27115a(), a, javaAnnotationArgument));
            }
        }
        return null;
    }

    public final String toString() {
        return DescriptorRenderer.f26012e.mo5891a((AnnotationDescriptor) this, null);
    }

    public final /* bridge */ /* synthetic */ SourceElement mo5721c() {
        return this.f32723d;
    }

    public static final /* synthetic */ ClassDescriptor m33051a(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, FqName fqName) {
        ModuleDescriptor moduleDescriptor = lazyJavaAnnotationDescriptor.f32726g.f25703b.f25700p;
        Object a = ClassId.m27396a(fqName);
        Intrinsics.m26843a(a, "ClassId.topLevel(fqName)");
        return FindClassInModuleKt.m27839a(moduleDescriptor, a, lazyJavaAnnotationDescriptor.f32726g.f25703b.f25688d.m27300a().f26239l);
    }

    public static final /* synthetic */ Map m33056c(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        Collection f = lazyJavaAnnotationDescriptor.m33057d().mo7770f();
        if (f.isEmpty()) {
            return MapsKt__MapsKt.m36116a();
        }
        Iterable a = lazyJavaAnnotationDescriptor.f32720a.mo6701a();
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(a)), 16));
        for (Object next : a) {
            linkedHashMap.put(((JavaAnnotationArgument) next).mo5800a(), next);
        }
        return CollectionsKt.m28091a((Iterable) ((ClassConstructorDescriptor) CollectionsKt___CollectionsKt.m41429d((Iterable) f)).mo7757k(), (Function1) new LazyJavaAnnotationDescriptor$computeValueArguments$1(lazyJavaAnnotationDescriptor, linkedHashMap));
    }
}
