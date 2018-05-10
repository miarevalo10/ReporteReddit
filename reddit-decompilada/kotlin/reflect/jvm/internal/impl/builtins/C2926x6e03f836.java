package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: functionTypes.kt */
final class C2926x6e03f836 extends Lambda implements Function1<String, Boolean> {
    public static final C2926x6e03f836 f38316a = new C2926x6e03f836();

    C2926x6e03f836() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "it");
        return Boolean.valueOf(Name.m27425b(str));
    }
}
