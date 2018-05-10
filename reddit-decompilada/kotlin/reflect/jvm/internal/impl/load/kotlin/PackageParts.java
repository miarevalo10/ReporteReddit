package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleMapping.kt */
public final class PackageParts {
    final LinkedHashMap<String, String> f25807a = new LinkedHashMap();
    final Set<String> f25808b = ((Set) new LinkedHashSet());
    private final String f25809c;

    public PackageParts(String str) {
        Intrinsics.m26847b(str, "packageFqName");
        this.f25809c = str;
    }

    public final Set<String> m27356a() {
        Object keySet = this.f25807a.keySet();
        Intrinsics.m26843a(keySet, "packageParts.keys");
        return keySet;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageParts) {
            PackageParts packageParts = (PackageParts) obj;
            if (Intrinsics.m26845a(packageParts.f25809c, this.f25809c) && Intrinsics.m26845a(packageParts.f25807a, this.f25807a) && Intrinsics.m26845a(packageParts.f25808b, this.f25808b) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (((this.f25809c.hashCode() * 31) + this.f25807a.hashCode()) * 31) + this.f25808b.hashCode();
    }

    public final String toString() {
        return SetsKt___SetsKt.m32819a(m27356a(), (Iterable) this.f25808b).toString();
    }
}
