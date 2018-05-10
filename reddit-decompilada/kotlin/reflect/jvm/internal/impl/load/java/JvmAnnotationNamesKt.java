package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
public final class JvmAnnotationNamesKt {
    private static final List<FqName> f25640a = CollectionsKt__CollectionsKt.m26796b((Object[]) new FqName[]{JvmAnnotationNames.f25634e, new FqName("android.support.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull")});
    private static final FqName f25641b = new FqName("javax.annotation.Nonnull");
    private static final List<FqName> f25642c = CollectionsKt__CollectionsKt.m26796b((Object[]) new FqName[]{JvmAnnotationNames.f25633d, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull")});
    private static final List<FqName> f25643d = CollectionsKt__CollectionsKt.m26791a((Object) JvmAnnotationNames.f25636g);
    private static final List<FqName> f25644e = CollectionsKt__CollectionsKt.m26791a((Object) JvmAnnotationNames.f25635f);
    private static final Set<FqName> f25645f;

    static {
        Collection arrayList = new ArrayList();
        for (List a : CollectionsKt__CollectionsKt.m26796b((Object[]) new List[]{f25640a, f25642c, f25643d, f25644e, CollectionsKt__CollectionsKt.m26791a((Object) f25641b)})) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList, (Iterable) a);
        }
        f25645f = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    public static final List<FqName> m27158a() {
        return f25640a;
    }

    public static final FqName m27159b() {
        return f25641b;
    }

    public static final List<FqName> m27160c() {
        return f25642c;
    }

    public static final List<FqName> m27161d() {
        return f25643d;
    }

    public static final List<FqName> m27162e() {
        return f25644e;
    }

    public static final Set<FqName> m27163f() {
        return f25645f;
    }
}
