package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2$$special$$inlined$map$lambda$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ KotlinType f38240a;
    final /* synthetic */ KClassImpl$Data$supertypes$2 f38241b;

    KClassImpl$Data$supertypes$2$$special$$inlined$map$lambda$1(KotlinType kotlinType, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        this.f38240a = kotlinType;
        this.f38241b = kClassImpl$Data$supertypes$2;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ClassifierDescriptor c = this.f38240a.mo6743g().mo5724c();
        StringBuilder stringBuilder;
        if (c instanceof ClassDescriptor) {
            Object a = UtilKt.m26932a((ClassDescriptor) c);
            if (a == null) {
                stringBuilder = new StringBuilder("Unsupported superclass of ");
                stringBuilder.append(this.f38241b.f38242a);
                stringBuilder.append(": ");
                stringBuilder.append(c);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            } else if (Intrinsics.m26845a(this.f38241b.f38242a.f32579h.f38246b.getSuperclass(), a)) {
                r0 = this.f38241b.f38242a.f32579h.f38246b.getGenericSuperclass();
                Intrinsics.m26843a(r0, "jClass.genericSuperclass");
                return r0;
            } else {
                int b = ArraysKt___ArraysKt.m36091b((Object[]) this.f38241b.f38242a.f32579h.f38246b.getInterfaces(), a);
                if (b < 0) {
                    stringBuilder = new StringBuilder("No superclass of ");
                    stringBuilder.append(this.f38241b.f38242a);
                    stringBuilder.append(" in Java reflection for ");
                    stringBuilder.append(c);
                    throw new KotlinReflectionInternalError(stringBuilder.toString());
                }
                r0 = this.f38241b.f38242a.f32579h.f38246b.getGenericInterfaces()[b];
                Intrinsics.m26843a(r0, "jClass.genericInterfaces[index]");
                return r0;
            }
        }
        stringBuilder = new StringBuilder("Supertype not a class: ");
        stringBuilder.append(c);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
