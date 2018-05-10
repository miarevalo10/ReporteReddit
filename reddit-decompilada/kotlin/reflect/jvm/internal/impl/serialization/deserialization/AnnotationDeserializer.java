package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value.Type;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;

/* compiled from: AnnotationDeserializer.kt */
public final class AnnotationDeserializer {
    private final ConstantValueFactory f26205a = new ConstantValueFactory(m27811a());
    private final ModuleDescriptor f26206b;
    private final NotFoundClasses f26207c;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26203a;
        public static final /* synthetic */ int[] f26204b;

        static {
            int[] iArr = new int[Type.values().length];
            f26203a = iArr;
            iArr[Type.BYTE.ordinal()] = 1;
            f26203a[Type.CHAR.ordinal()] = 2;
            f26203a[Type.SHORT.ordinal()] = 3;
            f26203a[Type.INT.ordinal()] = 4;
            f26203a[Type.LONG.ordinal()] = 5;
            f26203a[Type.FLOAT.ordinal()] = 6;
            f26203a[Type.DOUBLE.ordinal()] = 7;
            f26203a[Type.BOOLEAN.ordinal()] = 8;
            f26203a[Type.STRING.ordinal()] = 9;
            f26203a[Type.CLASS.ordinal()] = 10;
            f26203a[Type.ENUM.ordinal()] = 11;
            f26203a[Type.ANNOTATION.ordinal()] = 12;
            f26203a[Type.ARRAY.ordinal()] = 13;
            iArr = new int[Type.values().length];
            f26204b = iArr;
            iArr[Type.BYTE.ordinal()] = 1;
            f26204b[Type.CHAR.ordinal()] = 2;
            f26204b[Type.SHORT.ordinal()] = 3;
            f26204b[Type.INT.ordinal()] = 4;
            f26204b[Type.LONG.ordinal()] = 5;
            f26204b[Type.FLOAT.ordinal()] = 6;
            f26204b[Type.DOUBLE.ordinal()] = 7;
            f26204b[Type.BOOLEAN.ordinal()] = 8;
            f26204b[Type.STRING.ordinal()] = 9;
            f26204b[Type.CLASS.ordinal()] = 10;
            f26204b[Type.ENUM.ordinal()] = 11;
            f26204b[Type.ANNOTATION.ordinal()] = 12;
            f26204b[Type.ARRAY.ordinal()] = 13;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        this.f26206b = moduleDescriptor;
        this.f26207c = notFoundClasses;
    }

    private final KotlinBuiltIns m27811a() {
        return this.f26206b.mo7089b();
    }

    private final ClassDescriptor m27812a(ClassId classId) {
        return FindClassInModuleKt.m27839a(this.f26206b, classId, this.f26207c);
    }

    public final AnnotationDescriptor m27813a(Annotation annotation, NameResolver nameResolver) {
        Intrinsics.m26847b(annotation, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Object c = nameResolver.mo5831c(annotation.f39778c);
        Intrinsics.m26843a(c, "nameResolver.getClassId(proto.id)");
        ClassDescriptor a = m27812a(c);
        Map a2 = MapsKt__MapsKt.m36116a();
        if (annotation.m40039i() != 0) {
            DeclarationDescriptor declarationDescriptor = a;
            if (!ErrorUtils.m27938a(declarationDescriptor) && DescriptorUtils.m27660j(declarationDescriptor)) {
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt___CollectionsKt.m41442i((Iterable) a.mo7770f());
                if (classConstructorDescriptor != null) {
                    Object obj;
                    Iterable k = classConstructorDescriptor.mo7757k();
                    Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(k)), 16));
                    for (Object obj2 : k) {
                        linkedHashMap.put(((ValueParameterDescriptor) obj2).mo6689i(), obj2);
                    }
                    Collection arrayList = new ArrayList();
                    for (Object obj22 : (Iterable) annotation.f39779d) {
                        Intrinsics.m26843a(obj22, "it");
                        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) linkedHashMap.get(nameResolver.mo5830b(obj22.f39767c));
                        if (valueParameterDescriptor == null) {
                            obj22 = null;
                        } else {
                            Object x = valueParameterDescriptor.mo7777x();
                            Intrinsics.m26843a(x, "parameter.type");
                            obj22 = obj22.f39768d;
                            Intrinsics.m26843a(obj22, "proto.value");
                            obj22 = new Pair(valueParameterDescriptor, m27814a(x, obj22, nameResolver));
                        }
                        if (obj22 != null) {
                            arrayList.add(obj22);
                        }
                    }
                    a2 = MapsKt__MapsKt.m36117a((Iterable) (List) arrayList);
                }
            }
        }
        return (AnnotationDescriptor) new AnnotationDescriptorImpl(a.mo7714h(), a2, SourceElement.f25498a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> m27814a(kotlin.reflect.jvm.internal.impl.types.KotlinType r8, kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value r9, kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver r10) {
        /*
        r7 = this;
        r0 = "expectedType";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = "value";
        kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
        r0 = "nameResolver";
        kotlin.jvm.internal.Intrinsics.m26847b(r10, r0);
        r0 = r9.f39753d;
        if (r0 != 0) goto L_0x0016;
    L_0x0014:
        goto L_0x0305;
    L_0x0016:
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.WhenMappings.f26203a;
        r0 = r0.ordinal();
        r0 = r1[r0];
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 1: goto L_0x02e5;
            case 2: goto L_0x02d8;
            case 3: goto L_0x02cb;
            case 4: goto L_0x02bf;
            case 5: goto L_0x02b4;
            case 6: goto L_0x02a9;
            case 7: goto L_0x029e;
            case 8: goto L_0x028c;
            case 9: goto L_0x0278;
            case 10: goto L_0x0253;
            case 11: goto L_0x01f5;
            case 12: goto L_0x01df;
            case 13: goto L_0x0025;
            default: goto L_0x0023;
        };
    L_0x0023:
        goto L_0x0305;
    L_0x0025:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26982b(r8);
        if (r0 != 0) goto L_0x0034;
    L_0x002b:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26986c(r8);
        if (r0 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x0034;
    L_0x0032:
        r0 = r1;
        goto L_0x0035;
    L_0x0034:
        r0 = r2;
    L_0x0035:
        r9 = r9.f39761l;
        r3 = r9;
        r3 = (java.util.Collection) r3;
        r3 = r3.isEmpty();
        r3 = r3 ^ r2;
        if (r3 == 0) goto L_0x0178;
    L_0x0041:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.m41430d(r9);
        r4 = "arrayElements.first()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r3;
        r4 = r7.m27811a();
        r4 = (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns) r4;
        r5 = r3.f39753d;
        if (r5 != 0) goto L_0x0058;
    L_0x0056:
        goto L_0x015c;
    L_0x0058:
        r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.WhenMappings.f26204b;
        r5 = r5.ordinal();
        r5 = r6[r5];
        switch(r5) {
            case 1: goto L_0x0106;
            case 2: goto L_0x00fc;
            case 3: goto L_0x00f2;
            case 4: goto L_0x00e8;
            case 5: goto L_0x00de;
            case 6: goto L_0x00d4;
            case 7: goto L_0x00ca;
            case 8: goto L_0x00c0;
            case 9: goto L_0x00b6;
            case 10: goto L_0x00a8;
            case 11: goto L_0x008f;
            case 12: goto L_0x0073;
            case 13: goto L_0x0065;
            default: goto L_0x0063;
        };
    L_0x0063:
        goto L_0x015c;
    L_0x0065:
        r8 = "Array of arrays is impossible";
        r9 = new java.lang.IllegalStateException;
        r8 = r8.toString();
        r9.<init>(r8);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x0073:
        r3 = r3.f39760k;
        r3 = r3.f39778c;
        r3 = r10.mo5831c(r3);
        r4 = "nameResolver.getClassId(value.annotation.id)";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        r3 = r7.m27812a(r3);
        r3 = r3.mo7714h();
        r4 = "resolveClass(nameResolve…notation.id)).defaultType";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x008f:
        r3 = r3.f39758i;
        r3 = r10.mo5831c(r3);
        r4 = "nameResolver.getClassId(value.classId)";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        r3 = r7.m27812a(r3);
        r3 = r3.mo7714h();
        r4 = "resolveClass(nameResolve…lue.classId)).defaultType";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00a8:
        r8 = "Arrays of class literals are not supported yet";
        r9 = new java.lang.IllegalStateException;
        r8 = r8.toString();
        r9.<init>(r8);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x00b6:
        r3 = r4.m27027y();
        r4 = "getStringType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00c0:
        r3 = r4.m27025w();
        r4 = "getBooleanType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00ca:
        r3 = r4.m27023u();
        r4 = "getDoubleType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00d4:
        r3 = r4.m27022t();
        r4 = "getFloatType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00de:
        r3 = r4.m27021s();
        r4 = "getLongType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00e8:
        r3 = r4.m27020r();
        r4 = "getIntType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00f2:
        r3 = r4.m27019q();
        r4 = "getShortType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x00fc:
        r3 = r4.m27024v();
        r4 = "getCharType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        goto L_0x010f;
    L_0x0106:
        r3 = r4.m27018p();
        r4 = "getByteType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
    L_0x010f:
        r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3;
        r4 = r7.m27811a();
        r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3;
        if (r3 != 0) goto L_0x0135;
    L_0x0119:
        r8 = new java.lang.IllegalArgumentException;
        r9 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r10 = 3;
        r10 = new java.lang.Object[r10];
        r0 = "kotlinType";
        r10[r1] = r0;
        r0 = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        r10[r2] = r0;
        r0 = 2;
        r1 = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
        r10[r0] = r1;
        r9 = java.lang.String.format(r9, r10);
        r8.<init>(r9);
        throw r8;
    L_0x0135:
        r1 = r4.f25423h;
        r1 = r1.invoke();
        r1 = (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives) r1;
        r1 = r1.f25411b;
        r1 = r1.get(r3);
        r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1;
        if (r1 == 0) goto L_0x014a;
    L_0x0147:
        r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1;
        goto L_0x0197;
    L_0x014a:
        r1 = r7.m27811a();
        r2 = kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
        r1 = r1.m27002a(r2, r3);
        r2 = "builtIns.getArrayType(Va…RIANT, actualElementType)";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
        r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1;
        goto L_0x0197;
    L_0x015c:
        r8 = new java.lang.StringBuilder;
        r9 = "Unknown type: ";
        r8.<init>(r9);
        r9 = r3.f39753d;
        r8.append(r9);
        r8 = r8.toString();
        r9 = new java.lang.IllegalStateException;
        r8 = r8.toString();
        r9.<init>(r8);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x0178:
        if (r0 == 0) goto L_0x017c;
    L_0x017a:
        r1 = r8;
        goto L_0x0197;
    L_0x017c:
        r1 = r7.m27811a();
        r2 = kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
        r3 = r7.m27811a();
        r3 = r3.m27015m();
        r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3;
        r1 = r1.m27002a(r2, r3);
        r2 = "builtIns.getArrayType(Va…T, builtIns.getAnyType())";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
        r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1;
    L_0x0197:
        r2 = r7.m27811a();
        if (r0 == 0) goto L_0x019f;
    L_0x019d:
        r0 = r8;
        goto L_0x01a0;
    L_0x019f:
        r0 = r1;
    L_0x01a0:
        r0 = r2.m27000a(r0);
        r2 = r7.f26205a;
        r9 = (java.lang.Iterable) r9;
        r3 = new java.util.ArrayList;
        r4 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r9);
        r3.<init>(r4);
        r3 = (java.util.Collection) r3;
        r9 = r9.iterator();
    L_0x01b7:
        r4 = r9.hasNext();
        if (r4 == 0) goto L_0x01d5;
    L_0x01bd:
        r4 = r9.next();
        r4 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value) r4;
        r5 = "expectedElementType";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r5);
        r5 = "it";
        kotlin.jvm.internal.Intrinsics.m26843a(r4, r5);
        r4 = r7.m27814a(r0, r4, r10);
        r3.add(r4);
        goto L_0x01b7;
    L_0x01d5:
        r3 = (java.util.List) r3;
        r9 = r2.m27720a(r3, r1);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x01df:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
        r9 = r9.f39760k;
        r1 = "value.annotation";
        kotlin.jvm.internal.Intrinsics.m26843a(r9, r1);
        r9 = r7.m27813a(r9, r10);
        r0.<init>(r9);
        r9 = r0;
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x01f5:
        r0 = r9.f39758i;
        r0 = r10.mo5831c(r0);
        r1 = "nameResolver.getClassId(value.classId)";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r9 = r9.f39759j;
        r9 = r10.mo5830b(r9);
        r10 = "nameResolver.getName(value.enumValueId)";
        kotlin.jvm.internal.Intrinsics.m26843a(r9, r10);
        r10 = r7.m27812a(r0);
        r1 = r10.mo7771g();
        r2 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS;
        r1 = kotlin.jvm.internal.Intrinsics.m26845a(r1, r2);
        if (r1 == 0) goto L_0x0235;
    L_0x021b:
        r10 = r10.mo7739t();
        r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.f32688r;
        r1 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r1;
        r10 = r10.mo6699c(r9, r1);
        r1 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r1 == 0) goto L_0x0235;
    L_0x022b:
        r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10;
        r9 = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.m27717a(r10);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x0235:
        r10 = new java.lang.StringBuilder;
        r1 = "Unresolved enum entry: ";
        r10.<init>(r1);
        r10.append(r0);
        r0 = ".";
        r10.append(r0);
        r10.append(r9);
        r9 = r10.toString();
        r9 = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.m27718a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x0253:
        r8 = new java.lang.StringBuilder;
        r0 = "Class literal annotation arguments are not supported yet (";
        r8.<init>(r0);
        r9 = r9.f39758i;
        r9 = r10.mo5831c(r9);
        r8.append(r9);
        r9 = ")";
        r8.append(r9);
        r8 = r8.toString();
        r9 = new java.lang.IllegalStateException;
        r8 = r8.toString();
        r9.<init>(r8);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x0278:
        r0 = r7.f26205a;
        r9 = r9.f39757h;
        r9 = r10.mo5829a(r9);
        r10 = "nameResolver.getString(value.stringValue)";
        kotlin.jvm.internal.Intrinsics.m26843a(r9, r10);
        r9 = r0.m27731b(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x028c:
        r10 = r7.f26205a;
        r3 = r9.f39754e;
        r5 = 0;
        r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r9 == 0) goto L_0x0297;
    L_0x0296:
        r1 = r2;
    L_0x0297:
        r9 = r10.m27721a(r1);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x029e:
        r10 = r7.f26205a;
        r0 = r9.f39756g;
        r9 = r10.m27725a(r0);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02a9:
        r10 = r7.f26205a;
        r9 = r9.f39755f;
        r9 = r10.m27726a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02b4:
        r10 = r7.f26205a;
        r0 = r9.f39754e;
        r9 = r10.m27728a(r0);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02bf:
        r10 = r7.f26205a;
        r0 = r9.f39754e;
        r9 = (int) r0;
        r9 = r10.m27727a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02cb:
        r10 = r7.f26205a;
        r0 = r9.f39754e;
        r9 = (int) r0;
        r9 = (short) r9;
        r9 = r10.m27730a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02d8:
        r10 = r7.f26205a;
        r0 = r9.f39754e;
        r9 = (int) r0;
        r9 = (char) r9;
        r9 = r10.m27723a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
        goto L_0x02f1;
    L_0x02e5:
        r10 = r7.f26205a;
        r0 = r9.f39754e;
        r9 = (int) r0;
        r9 = (byte) r9;
        r9 = r10.m27722a(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r9;
    L_0x02f1:
        r10 = r9.mo5917a();
        r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.m28064a(r10, r8);
        if (r8 == 0) goto L_0x02fc;
    L_0x02fb:
        return r9;
    L_0x02fc:
        r8 = "Unexpected argument value";
        r8 = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.m27718a(r8);
        r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r8;
        return r8;
    L_0x0305:
        r10 = new java.lang.StringBuilder;
        r0 = "Unsupported annotation argument type: ";
        r10.<init>(r0);
        r9 = r9.f39753d;
        r10.append(r9);
        r9 = " (expected ";
        r10.append(r9);
        r10.append(r8);
        r8 = ")";
        r10.append(r8);
        r8 = r10.toString();
        r9 = new java.lang.IllegalStateException;
        r8 = r8.toString();
        r9.<init>(r8);
        r9 = (java.lang.Throwable) r9;
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.a(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Argument$Value, kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver):kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>");
    }
}
