package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", "S", "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    private static final Set<FqName> f26103i = null;
    private static final Map<String, JvmPrimitiveType> f26104j = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> f26105k = null;
    private final PrimitiveType f26107l;
    private final String f26108m;
    private final String f26109n;
    private final FqName f26110o;

    static {
        f26103i = new HashSet();
        f26104j = new HashMap();
        f26105k = new EnumMap(PrimitiveType.class);
        JvmPrimitiveType[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i];
            f26103i.add(jvmPrimitiveType.m27758d());
            f26104j.put(jvmPrimitiveType.m27756b(), jvmPrimitiveType);
            f26105k.put(jvmPrimitiveType.m27755a(), jvmPrimitiveType);
            i++;
        }
    }

    public static JvmPrimitiveType m27753a(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"}));
        }
        JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType) f26104j.get(str);
        if (jvmPrimitiveType == null) {
            StringBuilder stringBuilder = new StringBuilder("Non-primitive type name passed: ");
            stringBuilder.append(str);
            throw new AssertionError(stringBuilder.toString());
        } else if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"}));
        }
    }

    public static JvmPrimitiveType m27754a(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"}));
        }
        JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType) f26105k.get(primitiveType);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "get"}));
    }

    private JvmPrimitiveType(PrimitiveType primitiveType, String str, String str2, String str3) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveType", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "<init>"}));
        }
        this.f26107l = primitiveType;
        this.f26108m = str;
        this.f26109n = str2;
        this.f26110o = new FqName(str3);
    }

    public final PrimitiveType m27755a() {
        PrimitiveType primitiveType = this.f26107l;
        if (primitiveType != null) {
            return primitiveType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getPrimitiveType"}));
    }

    public final String m27756b() {
        String str = this.f26108m;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getJavaKeywordName"}));
    }

    public final String m27757c() {
        String str = this.f26109n;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getDesc"}));
    }

    public final FqName m27758d() {
        FqName fqName = this.f26110o;
        if (fqName != null) {
            return fqName;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType", "getWrapperFqName"}));
    }
}
