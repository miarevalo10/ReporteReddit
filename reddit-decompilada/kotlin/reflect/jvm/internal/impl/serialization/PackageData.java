package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;

/* compiled from: ProtoDatas.kt */
public final class PackageData {
    public final NameResolver f26176a;
    public final Package f26177b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PackageData) {
                PackageData packageData = (PackageData) obj;
                if (Intrinsics.m26845a(this.f26176a, packageData.f26176a) && Intrinsics.m26845a(this.f26177b, packageData.f26177b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        NameResolver nameResolver = this.f26176a;
        int i = 0;
        int hashCode = (nameResolver != null ? nameResolver.hashCode() : 0) * 31;
        Package packageR = this.f26177b;
        if (packageR != null) {
            i = packageR.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PackageData(nameResolver=");
        stringBuilder.append(this.f26176a);
        stringBuilder.append(", packageProto=");
        stringBuilder.append(this.f26177b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public PackageData(NameResolver nameResolver, Package packageR) {
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(packageR, "packageProto");
        this.f26176a = nameResolver;
        this.f26177b = packageR;
    }
}
