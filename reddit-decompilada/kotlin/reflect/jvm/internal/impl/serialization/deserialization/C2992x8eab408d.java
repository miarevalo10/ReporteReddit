package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;

/* compiled from: NotFoundClasses.kt */
final class C2992x8eab408d extends Lambda implements Function1<Type, Integer> {
    public static final C2992x8eab408d f38859a = new C2992x8eab408d();

    C2992x8eab408d() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Type type = (Type) obj;
        Intrinsics.m26847b(type, "it");
        return Integer.valueOf(type.m41794h());
    }
}
