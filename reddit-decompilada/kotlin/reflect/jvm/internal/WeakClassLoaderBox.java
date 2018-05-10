package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: moduleByClassLoader.kt */
final class WeakClassLoaderBox {
    ClassLoader f25345a;
    private final WeakReference<ClassLoader> f25346b;
    private final int f25347c;

    public WeakClassLoaderBox(ClassLoader classLoader) {
        Intrinsics.m26847b(classLoader, "classLoader");
        this.f25346b = new WeakReference(classLoader);
        this.f25347c = System.identityHashCode(classLoader);
        this.f25345a = classLoader;
    }

    public final boolean equals(Object obj) {
        return ((obj instanceof WeakClassLoaderBox) && ((ClassLoader) this.f25346b.get()) == ((ClassLoader) ((WeakClassLoaderBox) obj).f25346b.get())) ? true : null;
    }

    public final int hashCode() {
        return this.f25347c;
    }

    public final String toString() {
        ClassLoader classLoader = (ClassLoader) this.f25346b.get();
        if (classLoader != null) {
            String classLoader2 = classLoader.toString();
            if (classLoader2 != null) {
                return classLoader2;
            }
        }
        return "<null>";
    }
}
