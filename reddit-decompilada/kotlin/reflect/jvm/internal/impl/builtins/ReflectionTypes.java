package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ReflectionTypes.kt */
public final class ReflectionTypes {
    public static final /* synthetic */ KProperty[] f25443b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    public static final Companion f25444c = new Companion();
    final Lazy f25445a;
    private final ClassLookup f25446d = ClassLookup.f25442a;
    private final ClassLookup f25447e = ClassLookup.f25442a;
    private final ClassLookup f25448f = ClassLookup.f25442a;
    private final ClassLookup f25449g = ClassLookup.f25442a;
    private final ClassLookup f25450h = ClassLookup.f25442a;
    private final ClassLookup f25451i = ClassLookup.f25442a;

    /* compiled from: ReflectionTypes.kt */
    private static final class ClassLookup {
        public static final ClassLookup f25442a = null;

        static {
            ClassLookup classLookup = new ClassLookup();
        }

        private ClassLookup() {
            f25442a = this;
        }

        public static ClassDescriptor m27030a(ReflectionTypes reflectionTypes, KProperty<?> kProperty) {
            Intrinsics.m26847b(reflectionTypes, "types");
            Intrinsics.m26847b(kProperty, "property");
            String a = StringsKt__StringsJVMKt.m41940a((String) kProperty.mo5687b());
            Intrinsics.m26847b(a, "className");
            Name a2 = Name.m27424a(a);
            MemberScope memberScope = (MemberScope) reflectionTypes.f25445a.mo5678b();
            Intrinsics.m26843a((Object) a2, "name");
            reflectionTypes = memberScope.mo6699c(a2, NoLookupLocation.f32678h);
            if (!(reflectionTypes instanceof ClassDescriptor)) {
                reflectionTypes = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) reflectionTypes;
            if (classDescriptor != null) {
                return classDescriptor;
            }
            Object a3 = ErrorUtils.m27931a(ReflectionTypesKt.m27032a().m27408a(a2).m27407a());
            Intrinsics.m26843a(a3, "ErrorUtils.createErrorCl…E.child(name).asString())");
            return a3;
        }
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class Companion {
        private Companion() {
        }

        public static KotlinType m27031a(ModuleDescriptor moduleDescriptor) {
            Intrinsics.m26847b(moduleDescriptor, "module");
            Object obj = KotlinBuiltIns.f25420j.ai;
            Intrinsics.m26843a(obj, "KotlinBuiltIns.FQ_NAMES.kProperty");
            moduleDescriptor = FindClassInModuleKt.m27838a(moduleDescriptor, obj);
            if (moduleDescriptor == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion companion = Annotations.f32643a;
            Annotations a = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.m27115a();
            Object h = CollectionsKt___CollectionsKt.m41441h(moduleDescriptor.mo7610c().mo5723b());
            Intrinsics.m26843a(h, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.m27950a(a, moduleDescriptor, CollectionsKt__CollectionsKt.m26791a((Object) new StarProjectionImpl((TypeParameterDescriptor) h)));
        }
    }

    public ReflectionTypes(ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        this.f25445a = LazyKt.m26776a(LazyThreadSafetyMode.f25264b, new ReflectionTypes$kotlinReflectScope$2(moduleDescriptor));
    }
}
