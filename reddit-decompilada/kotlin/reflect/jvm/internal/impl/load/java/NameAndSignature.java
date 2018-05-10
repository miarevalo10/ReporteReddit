package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: specialBuiltinMembers.kt */
final class NameAndSignature {
    final Name f25646a;
    final String f25647b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NameAndSignature) {
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                if (Intrinsics.m26845a(this.f25646a, nameAndSignature.f25646a) && Intrinsics.m26845a(this.f25647b, nameAndSignature.f25647b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Name name = this.f25646a;
        int i = 0;
        int hashCode = (name != null ? name.hashCode() : 0) * 31;
        String str = this.f25647b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NameAndSignature(name=");
        stringBuilder.append(this.f25646a);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.f25647b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public NameAndSignature(Name name, String str) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(str, "signature");
        this.f25646a = name;
        this.f25647b = str;
    }
}
