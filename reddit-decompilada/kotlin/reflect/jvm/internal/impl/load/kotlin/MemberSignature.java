package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature;

/* compiled from: MemberSignature.kt */
public final class MemberSignature {
    public static final Companion f25800b = new Companion();
    final String f25801a;

    /* compiled from: MemberSignature.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MemberSignature m27344a(String str, String str2) {
            Intrinsics.m26847b(str, "name");
            Intrinsics.m26847b(str2, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            return new MemberSignature(stringBuilder.toString());
        }

        public static MemberSignature m27343a(String str) {
            Intrinsics.m26847b(str, "namePlusDesc");
            return new MemberSignature(str);
        }

        public static MemberSignature m27347b(String str, String str2) {
            Intrinsics.m26847b(str, "name");
            Intrinsics.m26847b(str2, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("#");
            stringBuilder.append(str2);
            return new MemberSignature(stringBuilder.toString());
        }

        public static MemberSignature m27345a(MemberSignature memberSignature, int i) {
            Intrinsics.m26847b(memberSignature, "signature");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(memberSignature.f25801a);
            stringBuilder.append("@");
            stringBuilder.append(i);
            return new MemberSignature(stringBuilder.toString());
        }

        public static MemberSignature m27346a(NameResolver nameResolver, JvmMethodSignature jvmMethodSignature) {
            Intrinsics.m26847b(nameResolver, "nameResolver");
            Intrinsics.m26847b(jvmMethodSignature, "signature");
            String a = nameResolver.mo5829a(jvmMethodSignature.f39922c);
            Intrinsics.m26843a((Object) a, "nameResolver.getString(signature.name)");
            String a2 = nameResolver.mo5829a(jvmMethodSignature.f39923d);
            Intrinsics.m26843a((Object) a2, "nameResolver.getString(signature.desc)");
            return m27344a(a, a2);
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MemberSignature) {
                if (Intrinsics.m26845a(this.f25801a, ((MemberSignature) obj).f25801a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f25801a;
        return str != null ? str.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MemberSignature(signature=");
        stringBuilder.append(this.f25801a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private MemberSignature(String str) {
        this.f25801a = str;
    }
}
