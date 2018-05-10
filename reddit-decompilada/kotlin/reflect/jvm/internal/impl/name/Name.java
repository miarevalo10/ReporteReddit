package kotlin.reflect.jvm.internal.impl.name;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class Name implements Comparable<Name> {
    public final boolean f25866a;
    private final String f25867b;

    public final /* synthetic */ int compareTo(Object obj) {
        return m27428a((Name) obj);
    }

    private Name(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/Name", "<init>"}));
        }
        this.f25867b = str;
        this.f25866a = z;
    }

    public final String m27429a() {
        String str = this.f25867b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/Name", "asString"}));
    }

    public final String m27430b() {
        if (this.f25866a) {
            StringBuilder stringBuilder = new StringBuilder("not identifier: ");
            stringBuilder.append(this);
            throw new IllegalStateException(stringBuilder.toString());
        }
        String a = m27429a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/Name", "getIdentifier"}));
    }

    public final int m27428a(Name name) {
        return this.f25867b.compareTo(name.f25867b);
    }

    public static Name m27424a(String str) {
        if (str != null) {
            return new Name(str, false);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/Name", "identifier"}));
    }

    public static boolean m27425b(String str) {
        if (str != null) {
            return (str.isEmpty() || str.startsWith(Operation.LESS_THAN) || str.contains(".") || str.contains(Operation.DIVISION) != null) ? false : true;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/Name", "isValidIdentifier"}));
        }
    }

    public static Name m27426c(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/Name", "special"}));
        } else if (str.startsWith(Operation.LESS_THAN)) {
            return new Name(str, true);
        } else {
            StringBuilder stringBuilder = new StringBuilder("special name must start with '<': ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static Name m27427d(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/Name", "guessByFirstCharacter"}));
        } else if (str.startsWith(Operation.LESS_THAN)) {
            return m27426c(str);
        } else {
            return m27424a(str);
        }
    }

    public final String toString() {
        return this.f25867b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.f25866a == name.f25866a && this.f25867b.equals(name.f25867b) != null;
    }

    public final int hashCode() {
        return (31 * this.f25867b.hashCode()) + this.f25866a;
    }
}
