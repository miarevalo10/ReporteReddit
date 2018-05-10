package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;

public final class FqNameUnsafe {
    static final Name f25858a = Name.m27426c("<root>");
    private static final Pattern f25859d = Pattern.compile("\\.");
    private static final Function1<String, Name> f25860e = new C27621();
    public final String f25861b;
    transient FqNameUnsafe f25862c;
    private transient FqName f25863f;
    private transient Name f25864g;

    static class C27621 implements Function1<String, Name> {
        C27621() {
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            return Name.m27427d((String) obj);
        }
    }

    FqNameUnsafe(String str, FqName fqName) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"}));
        } else if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"safe", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"}));
        } else {
            this.f25861b = str;
            this.f25863f = fqName;
        }
    }

    private FqNameUnsafe(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"}));
        } else {
            this.f25861b = str;
        }
    }

    private FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "<init>"}));
        }
        this.f25861b = str;
        this.f25862c = fqNameUnsafe;
        this.f25864g = name;
    }

    final void m27417a() {
        int lastIndexOf = this.f25861b.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.f25864g = Name.m27427d(this.f25861b.substring(lastIndexOf + 1));
            this.f25862c = new FqNameUnsafe(this.f25861b.substring(0, lastIndexOf));
            return;
        }
        this.f25864g = Name.m27427d(this.f25861b);
        this.f25862c = FqName.f25855a.m27409b();
    }

    public final String m27418b() {
        String str = this.f25861b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "asString"}));
    }

    public final boolean m27419c() {
        if (this.f25863f == null) {
            if (m27418b().indexOf(60) >= 0) {
                return false;
            }
        }
        return true;
    }

    public final FqName m27420d() {
        FqName fqName;
        if (this.f25863f != null) {
            fqName = this.f25863f;
            if (fqName != null) {
                return fqName;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toSafe"}));
        }
        this.f25863f = new FqName(this);
        fqName = this.f25863f;
        if (fqName != null) {
            return fqName;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toSafe"}));
    }

    public final Name m27421e() {
        Name name;
        if (this.f25864g != null) {
            name = this.f25864g;
            if (name != null) {
                return name;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortName"}));
        } else if (this.f25861b.isEmpty()) {
            throw new IllegalStateException("root");
        } else {
            m27417a();
            name = this.f25864g;
            if (name != null) {
                return name;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "shortName"}));
        }
    }

    public static FqNameUnsafe m27415b(Name name) {
        if (name != null) {
            return new FqNameUnsafe(name.m27429a(), FqName.f25855a.m27409b(), name);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"shortName", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "topLevel"}));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FqNameUnsafe)) {
            return false;
        }
        return this.f25861b.equals(((FqNameUnsafe) obj).f25861b) != null;
    }

    public final int hashCode() {
        return this.f25861b.hashCode();
    }

    public final FqNameUnsafe m27416a(Name name) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "child"}));
        }
        String a;
        if (this.f25861b.isEmpty()) {
            a = name.m27429a();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f25861b);
            stringBuilder.append(".");
            stringBuilder.append(name.m27429a());
            a = stringBuilder.toString();
        }
        return new FqNameUnsafe(a, this, name);
    }

    public final List<Name> m27422f() {
        List<Name> emptyList = this.f25861b.isEmpty() ? Collections.emptyList() : ArraysKt___ArraysKt.m36086a((Object[]) f25859d.split(this.f25861b), f25860e);
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "pathSegments"}));
    }

    public final String toString() {
        String a = this.f25861b.isEmpty() ? f25858a.m27429a() : this.f25861b;
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe", "toString"}));
    }
}
