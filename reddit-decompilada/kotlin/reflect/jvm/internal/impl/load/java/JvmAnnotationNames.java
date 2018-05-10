package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

public final class JvmAnnotationNames {
    public static final FqName f25630a = new FqName("kotlin.Metadata");
    public static final String f25631b;
    public static final Name f25632c = Name.m27424a("value");
    public static final FqName f25633d = new FqName("org.jetbrains.annotations.NotNull");
    public static final FqName f25634e = new FqName("org.jetbrains.annotations.Nullable");
    public static final FqName f25635f = new FqName("org.jetbrains.annotations.Mutable");
    public static final FqName f25636g = new FqName("org.jetbrains.annotations.ReadOnly");
    public static final FqName f25637h = new FqName("kotlin.jvm.PurelyImplements");
    public static final FqName f25638i = new FqName("kotlin.jvm.internal.EnhancedNullability");
    public static final FqName f25639j = new FqName("kotlin.jvm.internal.EnhancedMutability");

    static {
        StringBuilder stringBuilder = new StringBuilder("L");
        stringBuilder.append(JvmClassName.m27751a(f25630a).m27752a());
        stringBuilder.append(";");
        f25631b = stringBuilder.toString();
    }
}
