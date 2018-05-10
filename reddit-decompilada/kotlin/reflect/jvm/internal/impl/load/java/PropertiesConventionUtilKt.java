package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: propertiesConventionUtil.kt */
public final class PropertiesConventionUtilKt {
    private static Name m27166a(Name name, boolean z) {
        Intrinsics.m26847b(name, "methodName");
        return m27165a(name, "set", false, z ? "is" : false, 4);
    }

    public static final List<Name> m27164a(Name name) {
        Intrinsics.m26847b(name, "name");
        String a = name.m27429a();
        if (JvmAbi.m27152a(a)) {
            Intrinsics.m26847b(name, "methodName");
            Object a2 = m27165a(name, "get", false, null, 12);
            if (a2 == null) {
                a2 = m27165a(name, "is", false, null, 8);
            }
            return CollectionsKt.m28094b(a2);
        } else if (JvmAbi.m27154b(a)) {
            Intrinsics.m26847b(name, "methodName");
            return CollectionsKt___CollectionsKt.m41446k(CollectionsKt__CollectionsKt.m26796b((Object[]) new Name[]{m27166a(name, false), m27166a(name, true)}));
        } else {
            BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
            builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
            return BuiltinSpecialProperties.m27137a(name);
        }
    }

    private static /* synthetic */ Name m27165a(Name name, String str, boolean z, String str2, int i) {
        Object obj = 1;
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (name.f25866a != 0) {
            return null;
        }
        i = name.m27430b();
        if (!StringsKt__StringsJVMKt.m41944a((String) i, str) || i.length() == str.length()) {
            return null;
        }
        char charAt = i.charAt(str.length());
        if ('a' > charAt || charAt > 'z') {
            obj = null;
        }
        if (obj != null) {
            return null;
        }
        if (str2 != null) {
            if (_Assertions.f25274a == null || z) {
                name = new StringBuilder();
                name.append(str2);
                name.append(StringsKt__StringsKt.m42447a((String) i, (CharSequence) str));
                return Name.m27424a(name.toString());
            }
            throw ((Throwable) new AssertionError("Assertion failed"));
        } else if (!z) {
            return name;
        } else {
            String a = CapitalizeDecapitalizeKt.m28081a(StringsKt__StringsKt.m42447a((String) i, (CharSequence) str));
            if (Name.m27425b(a) == null) {
                return null;
            }
            return Name.m27424a(a);
        }
    }
}
