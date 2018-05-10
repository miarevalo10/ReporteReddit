package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;

/* compiled from: ProtoDatas.kt */
public final class ClassData {
    public final NameResolver f26140a;
    public final Class f26141b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ClassData) {
                ClassData classData = (ClassData) obj;
                if (Intrinsics.m26845a(this.f26140a, classData.f26140a) && Intrinsics.m26845a(this.f26141b, classData.f26141b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        NameResolver nameResolver = this.f26140a;
        int i = 0;
        int hashCode = (nameResolver != null ? nameResolver.hashCode() : 0) * 31;
        Class classR = this.f26141b;
        if (classR != null) {
            i = classR.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClassData(nameResolver=");
        stringBuilder.append(this.f26140a);
        stringBuilder.append(", classProto=");
        stringBuilder.append(this.f26141b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ClassData(NameResolver nameResolver, Class classR) {
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(classR, "classProto");
        this.f26140a = nameResolver;
        this.f26141b = classR;
    }
}
