package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: capitalizeDecapitalize.kt */
public final class CapitalizeDecapitalizeKt {
    public static final String m28081a(String str) {
        Intrinsics.m26847b(str, "$receiver");
        CapitalizeDecapitalizeKt$decapitalizeSmart$1 capitalizeDecapitalizeKt$decapitalizeSmart$1 = new CapitalizeDecapitalizeKt$decapitalizeSmart$1(str);
        CharSequence charSequence = str;
        int i = 0;
        if ((charSequence.length() == 0 ? 1 : 0) == 0) {
            CapitalizeDecapitalizeKt$decapitalizeSmart$1 capitalizeDecapitalizeKt$decapitalizeSmart$12 = capitalizeDecapitalizeKt$decapitalizeSmart$1;
            if (capitalizeDecapitalizeKt$decapitalizeSmart$12.m38726a(0)) {
                StringBuilder stringBuilder;
                Object substring;
                if (str.length() != 1) {
                    if (capitalizeDecapitalizeKt$decapitalizeSmart$12.m38726a(1)) {
                        CapitalizeDecapitalizeKt$decapitalizeSmart$2 capitalizeDecapitalizeKt$decapitalizeSmart$2 = new CapitalizeDecapitalizeKt$decapitalizeSmart$2();
                        for (Object next : StringsKt__StringsKt.m42466d(charSequence)) {
                            if ((capitalizeDecapitalizeKt$decapitalizeSmart$1.m38726a(((Number) next).intValue()) ^ 1) != 0) {
                                break;
                            }
                        }
                        Object next2 = null;
                        Integer num = (Integer) next2;
                        if (num == null) {
                            return capitalizeDecapitalizeKt$decapitalizeSmart$2.m38728a(str);
                        }
                        int intValue = num.intValue() - 1;
                        stringBuilder = new StringBuilder();
                        capitalizeDecapitalizeKt$decapitalizeSmart$2 = capitalizeDecapitalizeKt$decapitalizeSmart$2;
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String str2 = str;
                        String substring2 = str2.substring(0, intValue);
                        Intrinsics.m26843a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        stringBuilder.append(capitalizeDecapitalizeKt$decapitalizeSmart$2.m38728a(substring2));
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        substring = str2.substring(intValue);
                        Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
                        stringBuilder.append(substring);
                        return stringBuilder.toString();
                    }
                }
                Intrinsics.m26847b(str, "$receiver");
                if ((charSequence.length() == 0 ? 1 : 0) == 0) {
                    char charAt = str.charAt(0);
                    if ('A' <= charAt && charAt <= 'Z') {
                        i = 1;
                    }
                    if (i != 0) {
                        charAt = Character.toLowerCase(charAt);
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        substring = str.substring(1);
                        Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(String.valueOf(charAt));
                        stringBuilder.append(substring);
                        return stringBuilder.toString();
                    }
                }
                return str;
            }
        }
        return str;
    }

    public static final String m28082b(String str) {
        Intrinsics.m26847b(str, "$receiver");
        int i = 0;
        if ((((CharSequence) str).length() == 0 ? 1 : 0) != 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            i = 1;
        }
        if (i == 0) {
            return str;
        }
        charAt = Character.toUpperCase(charAt);
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = str.substring(1);
        Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(charAt));
        stringBuilder.append(substring);
        return stringBuilder.toString();
    }

    public static final String m28083c(String str) {
        Intrinsics.m26847b(str, "$receiver");
        StringBuilder stringBuilder = new StringBuilder(str.length());
        str = StringsKt__StringsKt.m42463c(str);
        while (str.hasNext()) {
            char a = str.mo6745a();
            Object obj = ('A' > a || a > 'Z') ? null : 1;
            if (obj != null) {
                a = Character.toLowerCase(a);
            }
            stringBuilder.append(a);
        }
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "builder.toString()");
        return stringBuilder2;
    }
}
