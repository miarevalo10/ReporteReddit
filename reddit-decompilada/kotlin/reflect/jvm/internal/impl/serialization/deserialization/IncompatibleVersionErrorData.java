package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T extends BinaryVersion> {
    private final T f26252a;
    private final T f26253b;
    private final String f26254c;
    private final ClassId f26255d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof IncompatibleVersionErrorData) {
                IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
                if (Intrinsics.m26845a(this.f26252a, incompatibleVersionErrorData.f26252a) && Intrinsics.m26845a(this.f26253b, incompatibleVersionErrorData.f26253b) && Intrinsics.m26845a(this.f26254c, incompatibleVersionErrorData.f26254c) && Intrinsics.m26845a(this.f26255d, incompatibleVersionErrorData.f26255d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        BinaryVersion binaryVersion = this.f26252a;
        int i = 0;
        int hashCode = (binaryVersion != null ? binaryVersion.hashCode() : 0) * 31;
        BinaryVersion binaryVersion2 = this.f26253b;
        hashCode = (hashCode + (binaryVersion2 != null ? binaryVersion2.hashCode() : 0)) * 31;
        String str = this.f26254c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ClassId classId = this.f26255d;
        if (classId != null) {
            i = classId.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("IncompatibleVersionErrorData(actualVersion=");
        stringBuilder.append(this.f26252a);
        stringBuilder.append(", expectedVersion=");
        stringBuilder.append(this.f26253b);
        stringBuilder.append(", filePath=");
        stringBuilder.append(this.f26254c);
        stringBuilder.append(", classId=");
        stringBuilder.append(this.f26255d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        Intrinsics.m26847b(t, "actualVersion");
        Intrinsics.m26847b(t2, "expectedVersion");
        Intrinsics.m26847b(str, "filePath");
        Intrinsics.m26847b(classId, "classId");
        this.f26252a = t;
        this.f26253b = t2;
        this.f26254c = str;
        this.f26255d = classId;
    }
}
