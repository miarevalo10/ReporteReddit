package kotlin.reflect.jvm.internal.impl.name;

public class SpecialNames {
    public static final Name f25870a = Name.m27426c("<no name provided>");
    public static final Name f25871b = Name.m27426c("<root package>");
    public static final Name f25872c = Name.m27424a("Companion");
    public static final Name f25873d = Name.m27424a("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    public static boolean m27433b(Name name) {
        if (name != null) {
            return !name.m27429a().isEmpty() && name.f25866a == null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/SpecialNames", "isSafeIdentifier"}));
        }
    }

    public static Name m27432a(Name name) {
        if (name == null || name.f25866a) {
            name = f25873d;
        }
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/SpecialNames", "safeIdentifier"}));
    }
}
