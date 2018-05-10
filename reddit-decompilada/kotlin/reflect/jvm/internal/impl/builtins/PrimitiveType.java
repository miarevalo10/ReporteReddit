package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<PrimitiveType> f25436i = null;
    private final Name f25438j;
    private final Name f25439k;
    private FqName f25440l;
    private FqName f25441m;

    static {
        f25436i = Collections.unmodifiableSet(EnumSet.of(CHAR, new PrimitiveType[]{BYTE, SHORT, INT, FLOAT, LONG, DOUBLE}));
    }

    private PrimitiveType(String str) {
        this.f25440l = null;
        this.f25441m = null;
        this.f25438j = Name.m27424a(str);
        r1 = new StringBuilder();
        r1.append(str);
        r1.append("Array");
        this.f25439k = Name.m27424a(r1.toString());
    }

    public final Name m27028a() {
        Name name = this.f25438j;
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getTypeName"}));
    }

    public final Name m27029b() {
        Name name = this.f25439k;
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType", "getArrayTypeName"}));
    }
}
