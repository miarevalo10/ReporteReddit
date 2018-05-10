package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: typeSignatureMapping.kt */
final class C2978xfa72d02b extends Lambda implements Function2<String, String, String> {
    public static final C2978xfa72d02b f38781a = new C2978xfa72d02b();

    C2978xfa72d02b() {
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        Intrinsics.m26847b(str, "outer");
        Intrinsics.m26847b(str2, "inner");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("$");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
