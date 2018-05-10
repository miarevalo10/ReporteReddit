package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: notFoundClasses.kt */
public final class NotFoundClassesKt {
    public static final ClassId m27233a(String str) {
        Intrinsics.m26847b(str, "fqName");
        NotFoundClassesKt$splitCanonicalFqName$1 notFoundClassesKt$splitCanonicalFqName$1 = NotFoundClassesKt$splitCanonicalFqName$1.f38449a;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (IndexedValue indexedValue : StringsKt___StringsKt.m42686i(str)) {
            int i3 = indexedValue.f25277a;
            char charValue = ((Character) indexedValue.f25278b).charValue();
            if (charValue != '.') {
                if (charValue == '<') {
                    i++;
                } else if (charValue == '>') {
                    i--;
                }
            } else if (i != 0) {
                continue;
            } else if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else {
                String substring = str.substring(i2, i3);
                Intrinsics.m26843a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(NotFoundClassesKt$splitCanonicalFqName$1.m38412a(substring));
                i2 = i3 + 1;
            }
        }
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        str = str.substring(i2);
        Intrinsics.m26843a((Object) str, "(this as java.lang.String).substring(startIndex)");
        arrayList.add(NotFoundClassesKt$splitCanonicalFqName$1.m38412a(str));
        Object a = ClassId.m27396a(new FqName(CollectionsKt___CollectionsKt.m41412a((Iterable) arrayList, (CharSequence) ".", null, null, 0, null, (Function1) C2944x7b5dab48.f38448a, 30)));
        Intrinsics.m26843a(a, "ClassId.topLevel(resultingClassFqName)");
        return a;
    }
}
