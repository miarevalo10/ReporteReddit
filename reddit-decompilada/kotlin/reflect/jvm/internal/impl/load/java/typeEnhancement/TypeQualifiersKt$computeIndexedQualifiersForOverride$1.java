package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$computeIndexedQualifiersForOverride$1 extends Lambda implements Function1<KotlinType, List<? extends KotlinType>> {
    public static final TypeQualifiersKt$computeIndexedQualifiersForOverride$1 f38756a = new TypeQualifiersKt$computeIndexedQualifiersForOverride$1();

    TypeQualifiersKt$computeIndexedQualifiersForOverride$1() {
        super(1);
    }

    public static List<KotlinType> m38516a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        final ArrayList arrayList = new ArrayList(1);
        new Function1<KotlinType, Unit>() {
            public final void m38515a(KotlinType kotlinType) {
                Intrinsics.m26847b(kotlinType, "type");
                arrayList.add(kotlinType);
                for (TypeProjection typeProjection : kotlinType.mo6739a()) {
                    if (typeProjection.mo6734a()) {
                        arrayList.add(typeProjection.mo6736c());
                    } else {
                        C29751 c29751 = this;
                        KotlinType c = typeProjection.mo6736c();
                        Intrinsics.m26843a((Object) c, "arg.type");
                        m38515a(c);
                    }
                }
            }
        }.m38515a(kotlinType);
        return arrayList;
    }
}
