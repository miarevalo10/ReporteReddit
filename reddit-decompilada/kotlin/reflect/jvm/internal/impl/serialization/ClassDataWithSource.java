package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;

/* compiled from: ProtoDatas.kt */
public final class ClassDataWithSource {
    public final ClassData f26142a;
    public final SourceElement f26143b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ClassDataWithSource) {
                ClassDataWithSource classDataWithSource = (ClassDataWithSource) obj;
                if (Intrinsics.m26845a(this.f26142a, classDataWithSource.f26142a) && Intrinsics.m26845a(this.f26143b, classDataWithSource.f26143b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        ClassData classData = this.f26142a;
        int i = 0;
        int hashCode = (classData != null ? classData.hashCode() : 0) * 31;
        SourceElement sourceElement = this.f26143b;
        if (sourceElement != null) {
            i = sourceElement.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClassDataWithSource(classData=");
        stringBuilder.append(this.f26142a);
        stringBuilder.append(", sourceElement=");
        stringBuilder.append(this.f26143b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ClassDataWithSource(ClassData classData, SourceElement sourceElement) {
        Intrinsics.m26847b(classData, "classData");
        Intrinsics.m26847b(sourceElement, "sourceElement");
        this.f26142a = classData;
        this.f26143b = sourceElement;
    }
}
