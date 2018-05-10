package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: DescriptorRenderer.kt */
public final class ExcludedTypeAnnotations {
    public static final ExcludedTypeAnnotations f26036a = null;
    private static final Set<FqName> f26037b = null;
    private static final Set<FqName> f26038c = null;

    static {
        ExcludedTypeAnnotations excludedTypeAnnotations = new ExcludedTypeAnnotations();
    }

    private ExcludedTypeAnnotations() {
        f26036a = this;
        f26037b = SetsKt__SetsKt.m26802a((Object[]) new FqName[]{new FqName("org.jetbrains.annotations.ReadOnly"), new FqName("org.jetbrains.annotations.Mutable"), new FqName("org.jetbrains.annotations.NotNull"), new FqName("org.jetbrains.annotations.Nullable"), new FqName("android.support.annotation.Nullable"), new FqName("android.support.annotation.NonNull"), new FqName("com.android.annotations.Nullable"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("javax.annotation.Nonnull"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("lombok.NonNull")});
        f26038c = SetsKt__SetsKt.m26802a((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});
    }

    public static Set<FqName> m27617a() {
        return f26037b;
    }

    public static Set<FqName> m27618b() {
        return f26038c;
    }
}
