package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.EnumSet;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper f25659a = null;
    private static final Map<String, EnumSet<KotlinTarget>> f25660b = null;
    private static final Map<String, KotlinRetention> f25661c = null;

    static {
        JavaAnnotationTargetMapper javaAnnotationTargetMapper = new JavaAnnotationTargetMapper();
    }

    private JavaAnnotationTargetMapper() {
        f25659a = this;
        f25660b = MapsKt__MapsKt.m36121a(TuplesKt.m26780a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.m26780a("TYPE", EnumSet.of(KotlinTarget.f25564a, KotlinTarget.f25577n)), TuplesKt.m26780a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.f25565b)), TuplesKt.m26780a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.f25566c)), TuplesKt.m26780a("FIELD", EnumSet.of(KotlinTarget.f25568e)), TuplesKt.m26780a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.f25569f)), TuplesKt.m26780a("PARAMETER", EnumSet.of(KotlinTarget.f25570g)), TuplesKt.m26780a("CONSTRUCTOR", EnumSet.of(KotlinTarget.f25571h)), TuplesKt.m26780a("METHOD", EnumSet.of(KotlinTarget.f25572i, KotlinTarget.f25573j, KotlinTarget.f25574k)), TuplesKt.m26780a("TYPE_USE", EnumSet.of(KotlinTarget.f25575l)));
        f25661c = MapsKt__MapsKt.m36121a(TuplesKt.m26780a("RUNTIME", KotlinRetention.f25538a), TuplesKt.m26780a("CLASS", KotlinRetention.f25539b), TuplesKt.m26780a("SOURCE", KotlinRetention.f25540c));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> m27185a(java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> r4, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r5) {
        /*
        r0 = "arguments";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r0);
        r0 = "builtIns";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r4 = (java.lang.Iterable) r4;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r4 = r4.iterator();
    L_0x0017:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x0029;
    L_0x001d:
        r1 = r4.next();
        r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
        if (r2 == 0) goto L_0x0017;
    L_0x0025:
        r0.add(r1);
        goto L_0x0017;
    L_0x0029:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r4 = (java.util.Collection) r4;
        r0 = r0.iterator();
    L_0x0038:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0077;
    L_0x003e:
        r1 = r0.next();
        r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument) r1;
        r1 = r1.mo6709b();
        r1 = r1.mo7103p();
        if (r1 == 0) goto L_0x0053;
    L_0x004e:
        r1 = r1.m27429a();
        goto L_0x0054;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        r2 = f25660b;
        if (r2 != 0) goto L_0x0060;
    L_0x0058:
        r4 = new kotlin.TypeCastException;
        r5 = "null cannot be cast to non-null type kotlin.collections.Map<K, V>";
        r4.<init>(r5);
        throw r4;
    L_0x0060:
        r2 = (java.util.Map) r2;
        r1 = r2.get(r1);
        r1 = (java.util.EnumSet) r1;
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1 = (java.util.Set) r1;
        goto L_0x0071;
    L_0x006d:
        r1 = kotlin.collections.SetsKt__SetsKt.m26799a();
    L_0x0071:
        r1 = (java.lang.Iterable) r1;
        kotlin.collections.CollectionsKt__MutableCollectionsKt.m38194a(r4, r1);
        goto L_0x0038;
    L_0x0077:
        r4 = (java.util.List) r4;
        r4 = (java.lang.Iterable) r4;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r4 = r4.iterator();
    L_0x0086:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x00cc;
    L_0x008c:
        r1 = r4.next();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget) r1;
        if (r1 != 0) goto L_0x00b2;
    L_0x0094:
        r4 = new java.lang.IllegalArgumentException;
        r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r0 = 3;
        r0 = new java.lang.Object[r0];
        r1 = 0;
        r2 = "target";
        r0[r1] = r2;
        r1 = 1;
        r2 = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        r0[r1] = r2;
        r1 = 2;
        r2 = "getAnnotationTargetEnumEntry";
        r0[r1] = r2;
        r5 = java.lang.String.format(r5, r0);
        r4.<init>(r5);
        throw r4;
    L_0x00b2:
        r2 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.f25420j;
        r2 = r2.f25357D;
        r2 = r2.m27412e();
        r2 = r5.m26999a(r2);
        r1 = r1.name();
        r1 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26966a(r2, r1);
        if (r1 == 0) goto L_0x0086;
    L_0x00c8:
        r0.add(r1);
        goto L_0x0086;
    L_0x00cc:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r4 = new java.util.ArrayList;
        r1 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r0);
        r4.<init>(r1);
        r4 = (java.util.Collection) r4;
        r0 = r0.iterator();
    L_0x00df:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x00f9;
    L_0x00e5:
        r1 = r0.next();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1;
        r2 = new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
        r3 = "it";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r3);
        r2.<init>(r1);
        r4.add(r2);
        goto L_0x00df;
    L_0x00f9:
        r4 = (java.util.List) r4;
        r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.f25649a;
        r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.m27184b();
        r1 = r5.m27013k();
        r0 = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.m27178a(r0, r1);
        r1 = new kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
        if (r0 == 0) goto L_0x0113;
    L_0x010d:
        r0 = r0.mo7777x();
        if (r0 != 0) goto L_0x0120;
    L_0x0113:
        r0 = "Error: AnnotationTarget[]";
        r0 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27943c(r0);
        r2 = "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0;
    L_0x0120:
        r1.<init>(r4, r0, r5);
        r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper.a(java.util.List, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns):kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>");
    }

    public static ConstantValue<?> m27186a(JavaAnnotationArgument javaAnnotationArgument, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(javaAnnotationArgument, "element");
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        EnumValue enumValue = null;
        if (!(javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument)) {
            javaAnnotationArgument = null;
        }
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
        if (javaEnumValueAnnotationArgument != null) {
            javaEnumValueAnnotationArgument = javaEnumValueAnnotationArgument;
            Map map = f25661c;
            javaAnnotationArgument = javaEnumValueAnnotationArgument.mo6709b().mo7103p();
            javaAnnotationArgument = javaAnnotationArgument != null ? javaAnnotationArgument.m27429a() : null;
            if (map == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            KotlinRetention kotlinRetention = (KotlinRetention) map.get(javaAnnotationArgument);
            if (kotlinRetention != null) {
                kotlinRetention = kotlinRetention;
                if (kotlinRetention == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"retention", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationRetentionEnumEntry"}));
                }
                javaAnnotationArgument = KotlinBuiltIns.m26966a(kotlinBuiltIns.m26999a(KotlinBuiltIns.f25420j.f25358E.m27412e()), kotlinRetention.name());
                if ((javaAnnotationArgument instanceof ClassDescriptor) == null) {
                    javaAnnotationArgument = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) javaAnnotationArgument;
                if (classDescriptor != null) {
                    enumValue = (EnumValue) new EnumValue(classDescriptor);
                }
                enumValue = enumValue;
            }
            enumValue = enumValue;
        }
        return enumValue;
    }
}
