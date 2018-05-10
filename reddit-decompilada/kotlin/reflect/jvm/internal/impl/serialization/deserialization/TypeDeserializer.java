package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer {
    private final Function1<Integer, ClassDescriptor> f26270a = this.f26273d.f26245c.f26229b.mo5930b((Function1) new TypeDeserializer$classDescriptors$1(this));
    private final Function1<Integer, ClassifierDescriptor> f26271b = this.f26273d.f26245c.f26229b.mo5930b((Function1) new TypeDeserializer$typeAliasDescriptors$1(this));
    private final Map<Integer, TypeParameterDescriptor> f26272c;
    private final DeserializationContext f26273d;
    private final TypeDeserializer f26274e;
    private final String f26275f;

    public TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List<TypeParameter> list, String str) {
        Intrinsics.m26847b(deserializationContext, "c");
        Intrinsics.m26847b(list, "typeParameterProtos");
        Intrinsics.m26847b(str, "debugName");
        this.f26273d = deserializationContext;
        this.f26274e = typeDeserializer;
        this.f26275f = str;
        if (list.isEmpty() != null) {
            deserializationContext = MapsKt__MapsKt.m36116a();
        } else {
            deserializationContext = new LinkedHashMap();
            for (IndexedValue indexedValue : CollectionsKt___CollectionsKt.m41452q(list)) {
                str = indexedValue.f25277a;
                TypeParameter typeParameter = (TypeParameter) indexedValue.f25278b;
                ((Map) deserializationContext).put(Integer.valueOf(typeParameter.f40505e), new DeserializedTypeParameterDescriptor(this.f26273d, typeParameter, str));
            }
            deserializationContext = (Map) deserializationContext;
        }
        this.f26272c = deserializationContext;
    }

    public final List<TypeParameterDescriptor> m27889a() {
        return CollectionsKt.m28089a(this.f26272c.values());
    }

    public final KotlinType m27890a(Type type, Annotations annotations) {
        Intrinsics.m26847b(type, "proto");
        Intrinsics.m26847b(annotations, "additionalAnnotations");
        if (!type.m41795i()) {
            return m27887b(type, annotations);
        }
        Object a = this.f26273d.f26246d.mo5829a(type.f40455g);
        SimpleType b = m27887b(type, annotations);
        Type a2 = ProtoTypeTableUtilKt.m27871a(type, this.f26273d.f26248f);
        if (a2 == null) {
            Intrinsics.m26842a();
        }
        annotations = m27887b(a2, annotations);
        FlexibleTypeDeserializer flexibleTypeDeserializer = this.f26273d.f26245c.f26237j;
        Intrinsics.m26843a(a, "id");
        return flexibleTypeDeserializer.mo5823a(type, a, b, annotations);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private kotlin.reflect.jvm.internal.impl.types.SimpleType m27887b(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type r11, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r12) {
        /*
        r10 = this;
        r0 = "proto";
        kotlin.jvm.internal.Intrinsics.m26847b(r11, r0);
        r0 = "additionalAnnotations";
        kotlin.jvm.internal.Intrinsics.m26847b(r12, r0);
        r0 = r11.m41798l();
        if (r0 == 0) goto L_0x0016;
    L_0x0010:
        r0 = r11.f40458j;
        r10.m27885a(r0);
        goto L_0x0021;
    L_0x0016:
        r0 = r11.m41801o();
        if (r0 == 0) goto L_0x0021;
    L_0x001c:
        r0 = r11.f40461m;
        r10.m27885a(r0);
    L_0x0021:
        r0 = r11.m41798l();
        r1 = 0;
        if (r0 == 0) goto L_0x007f;
    L_0x0028:
        r0 = r10.f26270a;
        r2 = r11.f40458j;
        r2 = java.lang.Integer.valueOf(r2);
        r0 = r0.mo6492a(r2);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0;
        if (r0 == 0) goto L_0x003e;
    L_0x0038:
        r0 = r0.mo7610c();
        if (r0 != 0) goto L_0x0198;
    L_0x003e:
        r0 = r10.f26273d;
        r0 = r0.f26245c;
        r0 = r0.f26239l;
        r2 = r10.f26273d;
        r2 = r2.f26246d;
        r3 = r10.f26273d;
        r3 = r3.f26248f;
        r4 = "proto";
        kotlin.jvm.internal.Intrinsics.m26847b(r11, r4);
        r4 = "nameResolver";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r4);
        r4 = "typeTable";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r4);
        r4 = r11.f40458j;
        r2 = r2.mo5831c(r4);
        r4 = "classId";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
        r4 = "classId";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
        r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClassesKt.m27862a(r2, r11, r3);
        r0 = r0.m27859a(r2, r3);
        r0 = r0.mo7610c();
        r2 = "getOrCreateClass(classId…peTable)).typeConstructor";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        goto L_0x0198;
    L_0x007f:
        r0 = r11.m41799m();
        if (r0 == 0) goto L_0x00c2;
    L_0x0085:
        r0 = r11.f40459k;
        r2 = r10;
    L_0x0088:
        r3 = r2.f26272c;
        r4 = java.lang.Integer.valueOf(r0);
        r3 = r3.get(r4);
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r3;
        if (r3 == 0) goto L_0x009c;
    L_0x0096:
        r3 = r3.mo7610c();
        if (r3 != 0) goto L_0x00a2;
    L_0x009c:
        r2 = r2.f26274e;
        if (r2 == 0) goto L_0x00a1;
    L_0x00a0:
        goto L_0x0088;
    L_0x00a1:
        r3 = r1;
    L_0x00a2:
        if (r3 != 0) goto L_0x00bf;
    L_0x00a4:
        r0 = new java.lang.StringBuilder;
        r2 = "Unknown type parameter ";
        r0.<init>(r2);
        r2 = r11.f40459k;
        r0.append(r2);
        r0 = r0.toString();
        r0 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27945e(r0);
        r2 = "ErrorUtils.createErrorTy… ${proto.typeParameter}\")";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        goto L_0x0198;
    L_0x00bf:
        r0 = r3;
        goto L_0x0198;
    L_0x00c2:
        r0 = r11.m41800n();
        if (r0 == 0) goto L_0x0127;
    L_0x00c8:
        r0 = r10.f26273d;
        r0 = r0.f26247e;
        r2 = r10.f26273d;
        r2 = r2.f26246d;
        r3 = r11.f40460l;
        r2 = r2.mo5829a(r3);
        r3 = r10.m27889a();
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x00e0:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x00fc;
    L_0x00e6:
        r4 = r3.next();
        r5 = r4;
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5;
        r5 = r5.mo6689i();
        r5 = r5.m27429a();
        r5 = kotlin.jvm.internal.Intrinsics.m26845a(r5, r2);
        if (r5 == 0) goto L_0x00e0;
    L_0x00fb:
        goto L_0x00fd;
    L_0x00fc:
        r4 = r1;
    L_0x00fd:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4;
        if (r4 == 0) goto L_0x0107;
    L_0x0101:
        r3 = r4.mo7610c();
        if (r3 != 0) goto L_0x00bf;
    L_0x0107:
        r3 = new java.lang.StringBuilder;
        r4 = "Deserialized type parameter ";
        r3.<init>(r4);
        r3.append(r2);
        r2 = " in ";
        r3.append(r2);
        r3.append(r0);
        r0 = r3.toString();
        r0 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27945e(r0);
        r2 = "ErrorUtils.createErrorTy…ter $name in $container\")";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        goto L_0x0198;
    L_0x0127:
        r0 = r11.m41801o();
        if (r0 == 0) goto L_0x018d;
    L_0x012d:
        r0 = r10.f26271b;
        r2 = r11.f40461m;
        r2 = java.lang.Integer.valueOf(r2);
        r0 = r0.mo6492a(r2);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r0;
        if (r0 == 0) goto L_0x0143;
    L_0x013d:
        r0 = r0.mo7610c();
        if (r0 != 0) goto L_0x0198;
    L_0x0143:
        r0 = r10.f26273d;
        r0 = r0.f26245c;
        r0 = r0.f26239l;
        r2 = r10.f26273d;
        r2 = r2.f26246d;
        r3 = r10.f26273d;
        r3 = r3.f26248f;
        r4 = "proto";
        kotlin.jvm.internal.Intrinsics.m26847b(r11, r4);
        r4 = "nameResolver";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r4);
        r4 = "typeTable";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r4);
        r4 = r11.f40461m;
        r2 = r2.mo5831c(r4);
        r0 = r0.f26261a;
        r4 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses$ClassRequest;
        r5 = "classId";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r5);
        r5 = "classId";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r5);
        r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClassesKt.m27862a(r2, r11, r3);
        r4.<init>(r2, r3);
        r0 = r0.mo6492a(r4);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) r0;
        r0 = r0.mo7610c();
        r2 = "typeAliases(ClassRequest…eTable))).typeConstructor";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        goto L_0x0198;
    L_0x018d:
        r0 = "Unknown type";
        r0 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27945e(r0);
        r2 = "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
    L_0x0198:
        r2 = r0.mo5724c();
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2;
        r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27938a(r2);
        if (r2 == 0) goto L_0x01b2;
    L_0x01a4:
        r11 = r0.toString();
        r11 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27936a(r11, r0);
        r12 = "ErrorUtils.createErrorTy….toString(), constructor)";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        return r11;
    L_0x01b2:
        r2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
        r3 = r10.f26273d;
        r3 = r3.f26245c;
        r3 = r3.f26229b;
        r4 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1;
        r4.<init>(r10, r11, r12);
        r4 = (kotlin.jvm.functions.Function0) r4;
        r2.<init>(r3, r4);
        r3 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$1;
        r3.<init>(r10);
        r3 = r3.m38614a(r11);
        r3 = (java.lang.Iterable) r3;
        r4 = new java.util.ArrayList;
        r5 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r3);
        r4.<init>(r5);
        r4 = (java.util.Collection) r4;
        r5 = 0;
        r3 = r3.iterator();
    L_0x01df:
        r6 = r3.hasNext();
        if (r6 == 0) goto L_0x0260;
    L_0x01e5:
        r6 = r3.next();
        r7 = r5 + 1;
        r6 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument) r6;
        r8 = r0.mo5723b();
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.m41425c(r8, r5);
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5;
        r8 = r6.f39845d;
        r9 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection.STAR;
        r8 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r9);
        if (r8 == 0) goto L_0x0229;
    L_0x0201:
        if (r5 != 0) goto L_0x0220;
    L_0x0203:
        r5 = new kotlin.reflect.jvm.internal.impl.types.TypeBasedStarProjectionImpl;
        r6 = r10.f26273d;
        r6 = r6.f26245c;
        r6 = r6.f26230c;
        r6 = r6.mo7089b();
        r6 = r6.m27016n();
        r8 = "c.components.moduleDescr….builtIns.nullableAnyType";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r8);
        r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6;
        r5.<init>(r6);
        r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5;
        goto L_0x025b;
    L_0x0220:
        r6 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
        r6.<init>(r5);
        r5 = r6;
        r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5;
        goto L_0x025b;
    L_0x0229:
        r5 = r6.f39845d;
        r8 = "typeArgumentProto.projection";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r8);
        r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization.m27830a(r5);
        r8 = r10.f26273d;
        r8 = r8.f26248f;
        r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt.m27870a(r6, r8);
        if (r6 != 0) goto L_0x024f;
    L_0x023f:
        r5 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
        r6 = "No type recorded";
        r6 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27943c(r6);
        r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6;
        r5.<init>(r6);
        r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5;
        goto L_0x025b;
    L_0x024f:
        r8 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
        r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.f32643a;
        r8.<init>(r5, r6);
        r5 = r8;
        r5 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r5;
    L_0x025b:
        r4.add(r5);
        r5 = r7;
        goto L_0x01df;
    L_0x0260:
        r4 = (java.util.List) r4;
        r4 = (java.util.Collection) r4;
        r3 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.m28089a(r4);
        r4 = kotlin.reflect.jvm.internal.impl.serialization.Flags.f26150a;
        r5 = r11.f40466r;
        r4 = r4.m33502a(r5);
        r5 = "Flags.SUSPEND_TYPE.get(proto.flags)";
        kotlin.jvm.internal.Intrinsics.m26843a(r4, r5);
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x02e0;
    L_0x027b:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r2;
        r4 = r11.f40454f;
        r5 = r0.mo5723b();
        r5 = r5.size();
        r6 = r3.size();
        r5 = r5 - r6;
        switch(r5) {
            case 0: goto L_0x02ae;
            case 1: goto L_0x0290;
            default: goto L_0x028f;
        };
    L_0x028f:
        goto L_0x02c6;
    L_0x0290:
        r5 = r3.size();
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x02c6;
    L_0x0298:
        r1 = r0.mo5726e();
        r1 = r1.m27004c(r5);
        r1 = r1.mo7610c();
        r5 = "functionTypeConstructor.…on(arity).typeConstructor";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r5);
        r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27951a(r2, r1, r3, r4);
        goto L_0x02c6;
    L_0x02ae:
        r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27951a(r2, r0, r3, r4);
        r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$createSuspendFunctionType$result$1.f38861a;
        r4 = (kotlin.jvm.functions.Function1) r4;
        r2 = kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt.m28126a(r2, r4);
        r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2;
        if (r2 == 0) goto L_0x02c6;
    L_0x02be:
        r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2;
        r1 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.m27035b(r2);
        r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1;
    L_0x02c6:
        if (r1 != 0) goto L_0x02e8;
    L_0x02c8:
        r1 = new java.lang.StringBuilder;
        r2 = "Bad suspend function in metadata with constructor: ";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        r1 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27935a(r0, r3);
        r0 = "ErrorUtils.createErrorTy…eConstructor\", arguments)";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r0);
        goto L_0x02e8;
    L_0x02e0:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r2;
        r1 = r11.f40454f;
        r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27951a(r2, r0, r3, r1);
    L_0x02e8:
        r0 = r10.f26273d;
        r0 = r0.f26248f;
        r11 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt.m27881c(r11, r0);
        if (r11 != 0) goto L_0x02f3;
    L_0x02f2:
        return r1;
    L_0x02f3:
        r11 = r10.m27887b(r11, r12);
        r11 = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.m27955a(r1, r11);
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.b(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    private final SimpleType m27885a(int i) {
        return this.f26273d.f26246d.mo5831c(i).f25852a != 0 ? null : null;
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26275f);
        if (this.f26274e == null) {
            str = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(". Child of ");
            stringBuilder2.append(this.f26274e.f26275f);
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static final /* synthetic */ ClassDescriptor m27882a(TypeDeserializer typeDeserializer, int i) {
        Object c = typeDeserializer.f26273d.f26246d.mo5831c(i);
        if (c.f25852a) {
            typeDeserializer = typeDeserializer.f26273d.f26245c;
            Intrinsics.m26843a(c, "id");
            return typeDeserializer.m27832a(c);
        }
        typeDeserializer = typeDeserializer.f26273d.f26245c.f26230c;
        Intrinsics.m26843a(c, "id");
        return FindClassInModuleKt.m27838a(typeDeserializer, c);
    }

    public static final /* synthetic */ ClassifierDescriptor m27886b(TypeDeserializer typeDeserializer, int i) {
        Object c = typeDeserializer.f26273d.f26246d.mo5831c(i);
        if (c.f25852a) {
            return null;
        }
        typeDeserializer = typeDeserializer.f26273d.f26245c.f26230c;
        Intrinsics.m26843a(c, "id");
        return FindClassInModuleKt.m27840b(typeDeserializer, c);
    }
}
