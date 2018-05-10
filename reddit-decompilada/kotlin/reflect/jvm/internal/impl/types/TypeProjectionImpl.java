package kotlin.reflect.jvm.internal.impl.types;

public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance f36177a;
    private final KotlinType f36178b;

    public final boolean mo6734a() {
        return false;
    }

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"projection", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"}));
        } else {
            this.f36177a = variance;
            this.f36178b = kotlinType;
        }
    }

    public TypeProjectionImpl(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "<init>"}));
        } else {
            this(Variance.f26337a, kotlinType);
        }
    }

    public final Variance mo6735b() {
        Variance variance = this.f36177a;
        if (variance != null) {
            return variance;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "getProjectionKind"}));
    }

    public final KotlinType mo6736c() {
        KotlinType kotlinType = this.f36178b;
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl", "getType"}));
    }
}
