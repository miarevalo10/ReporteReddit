package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.utils.StringsKt;

public final class FqName {
    public static final FqName f25855a = new FqName("");
    public final FqNameUnsafe f25856b;
    private transient FqName f25857c;

    public static FqName m27405a(List<String> list) {
        if (list != null) {
            return new FqName(StringsKt.m28121a(list, "."));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"names", "kotlin/reflect/jvm/internal/impl/name/FqName", "fromSegments"}));
    }

    public FqName(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"}));
        } else {
            this.f25856b = new FqNameUnsafe(str, this);
        }
    }

    public FqName(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"}));
        } else {
            this.f25856b = fqNameUnsafe;
        }
    }

    private FqName(FqNameUnsafe fqNameUnsafe, FqName fqName) {
        if (fqNameUnsafe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqName", "<init>"}));
        }
        this.f25856b = fqNameUnsafe;
        this.f25857c = fqName;
    }

    public final String m27407a() {
        String b = this.f25856b.m27418b();
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "asString"}));
    }

    public final FqNameUnsafe m27409b() {
        FqNameUnsafe fqNameUnsafe = this.f25856b;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "toUnsafe"}));
    }

    public final boolean m27410c() {
        return this.f25856b.f25861b.isEmpty();
    }

    public final FqName m27411d() {
        FqName fqName;
        if (this.f25857c != null) {
            fqName = this.f25857c;
            if (fqName != null) {
                return fqName;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "parent"}));
        } else if (m27410c()) {
            throw new IllegalStateException("root");
        } else {
            FqNameUnsafe fqNameUnsafe = this.f25856b;
            if (fqNameUnsafe.f25862c != null) {
                fqNameUnsafe = fqNameUnsafe.f25862c;
                if (fqNameUnsafe == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "parent"}));
                }
            } else if (fqNameUnsafe.f25861b.isEmpty()) {
                throw new IllegalStateException("root");
            } else {
                fqNameUnsafe.m27417a();
                fqNameUnsafe = fqNameUnsafe.f25862c;
                if (fqNameUnsafe == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "parent"}));
                }
            }
            this.f25857c = new FqName(fqNameUnsafe);
            fqName = this.f25857c;
            if (fqName != null) {
                return fqName;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "parent"}));
        }
    }

    public final FqName m27408a(Name name) {
        if (name != null) {
            return new FqName(this.f25856b.m27416a(name), this);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/FqName", "child"}));
    }

    public final Name m27412e() {
        Name e = this.f25856b.m27421e();
        if (e != null) {
            return e;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "shortName"}));
    }

    public final Name m27413f() {
        Name name;
        FqNameUnsafe fqNameUnsafe = this.f25856b;
        if (fqNameUnsafe.f25861b.isEmpty()) {
            name = FqNameUnsafe.f25858a;
            if (name == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortNameOrSpecial"}));
            }
        }
        name = fqNameUnsafe.m27421e();
        if (name == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortNameOrSpecial"}));
        }
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "shortNameOrSpecial"}));
    }

    public final List<Name> m27414g() {
        List<Name> f = this.f25856b.m27422f();
        if (f != null) {
            return f;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqName", "pathSegments"}));
    }

    public static FqName m27406b(Name name) {
        if (name != null) {
            return new FqName(FqNameUnsafe.m27415b(name));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"shortName", "kotlin/reflect/jvm/internal/impl/name/FqName", "topLevel"}));
    }

    public final String toString() {
        return this.f25856b.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FqName)) {
            return false;
        }
        return this.f25856b.equals(((FqName) obj).f25856b) != null;
    }

    public final int hashCode() {
        return this.f25856b.hashCode();
    }
}
