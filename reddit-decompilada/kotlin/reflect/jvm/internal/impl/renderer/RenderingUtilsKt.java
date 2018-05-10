package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: RenderingUtils.kt */
public final class RenderingUtilsKt {
    public static final String m27621a(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.m26847b(fqNameUnsafe, "$receiver");
        List f = fqNameUnsafe.m27422f();
        Intrinsics.m26843a((Object) f, "pathSegments()");
        return m27620a(f);
    }

    public static final String m27620a(List<Name> list) {
        Intrinsics.m26847b(list, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        for (Name name : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(m27622a(name));
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m27622a(kotlin.reflect.jvm.internal.impl.name.Name r5) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = r5.f25866a;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x003c;
    L_0x000b:
        r0 = r5.m27429a();
        r3 = kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated.f26039a;
        r3 = r3.contains(r0);
        if (r3 != 0) goto L_0x003b;
    L_0x0017:
        r0 = (java.lang.CharSequence) r0;
        r0 = kotlin.text.StringsKt__StringsKt.m42463c(r0);
    L_0x001d:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0038;
    L_0x0023:
        r3 = r0.mo6745a();
        r4 = java.lang.Character.isLetterOrDigit(r3);
        if (r4 != 0) goto L_0x0033;
    L_0x002d:
        r4 = 95;
        if (r3 == r4) goto L_0x0033;
    L_0x0031:
        r3 = r2;
        goto L_0x0034;
    L_0x0033:
        r3 = r1;
    L_0x0034:
        if (r3 == 0) goto L_0x001d;
    L_0x0036:
        r0 = r2;
        goto L_0x0039;
    L_0x0038:
        r0 = r1;
    L_0x0039:
        if (r0 == 0) goto L_0x003c;
    L_0x003b:
        r1 = r2;
    L_0x003c:
        if (r1 == 0) goto L_0x0067;
    L_0x003e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = r5.m27429a();
        r1 = "asString()";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r1);
        r1 = new java.lang.StringBuilder;
        r2 = "`";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        r0.append(r5);
        r5 = 96;
        r0.append(r5);
        r5 = r0.toString();
        return r5;
    L_0x0067:
        r5 = r5.m27429a();
        r0 = "asString()";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r0);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.a(kotlin.reflect.jvm.internal.impl.name.Name):java.lang.String");
    }
}
