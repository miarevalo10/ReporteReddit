package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassDescriptor.kt */
final class C2937xcb5175b1 extends Lambda implements Function1<FqName, Boolean> {
    public static final C2937xcb5175b1 f38382a = new C2937xcb5175b1();

    C2937xcb5175b1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "it");
        boolean z = true;
        if (!fqName.f25856b.f25861b.isEmpty()) {
            obj = fqName.m27409b();
            Name name = KotlinBuiltIns.f25414b;
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"segment", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "startsWith"}));
            }
            int indexOf = obj.f25861b.indexOf(46);
            if (!obj.f25861b.isEmpty()) {
                String str = obj.f25861b;
                String a = name.m27429a();
                if (indexOf == -1) {
                    indexOf = obj.f25861b.length();
                }
                if (str.regionMatches(0, a, 0, indexOf) != null) {
                    obj = 1;
                    if (obj != null) {
                        return Boolean.valueOf(z);
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
