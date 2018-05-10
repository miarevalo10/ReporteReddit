package kotlin.reflect.jvm.internal.impl.name;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class ClassId {
    static final /* synthetic */ boolean f25851b = true;
    public final boolean f25852a;
    private final FqName f25853c;
    private final FqName f25854d;

    public static ClassId m27396a(FqName fqName) {
        if (fqName != null) {
            return new ClassId(fqName.m27411d(), fqName.m27412e());
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"topLevelFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "topLevel"}));
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"packageFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"}));
        } else if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"relativeClassName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"}));
        } else {
            this.f25853c = fqName;
            if (f25851b || !fqName2.f25856b.f25861b.isEmpty()) {
                this.f25854d = fqName2;
                this.f25852a = z;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Class name must not be root: ");
            stringBuilder.append(fqName);
            stringBuilder.append(z ? " (local)" : "");
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public ClassId(FqName fqName, Name name) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"packageFqName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"topLevelName", "kotlin/reflect/jvm/internal/impl/name/ClassId", "<init>"}));
        } else {
            this(fqName, FqName.m27406b(name), false);
        }
    }

    public final FqName m27398a() {
        FqName fqName = this.f25853c;
        if (fqName != null) {
            return fqName;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "getPackageFqName"}));
    }

    public final FqName m27399b() {
        FqName fqName = this.f25854d;
        if (fqName != null) {
            return fqName;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "getRelativeClassName"}));
    }

    public final Name m27400c() {
        Name e = this.f25854d.m27412e();
        if (e != null) {
            return e;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "getShortClassName"}));
    }

    public final ClassId m27397a(Name name) {
        if (name != null) {
            return new ClassId(m27398a(), this.f25854d.m27408a(name), this.f25852a);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/name/ClassId", "createNestedClassId"}));
    }

    public final ClassId m27401d() {
        return new ClassId(m27398a(), this.f25854d.m27411d(), this.f25852a);
    }

    public final boolean m27402e() {
        return !this.f25854d.m27411d().f25856b.f25861b.isEmpty();
    }

    public final FqName m27403f() {
        if (this.f25853c.f25856b.f25861b.isEmpty()) {
            FqName fqName = this.f25854d;
            if (fqName != null) {
                return fqName;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "asSingleFqName"}));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f25853c.m27407a());
        stringBuilder.append(".");
        stringBuilder.append(this.f25854d.m27407a());
        return new FqName(stringBuilder.toString());
    }

    public final String m27404g() {
        String a;
        if (this.f25853c.f25856b.f25861b.isEmpty()) {
            a = this.f25854d.m27407a();
            if (a != null) {
                return a;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "asString"}));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f25853c.m27407a().replace('.', '/'));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(this.f25854d.m27407a());
        a = stringBuilder.toString();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/name/ClassId", "asString"}));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ClassId classId = (ClassId) obj;
                return this.f25853c.equals(classId.f25853c) && this.f25854d.equals(classId.f25854d) && this.f25852a == classId.f25852a;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * ((this.f25853c.hashCode() * 31) + this.f25854d.hashCode())) + Boolean.valueOf(this.f25852a).hashCode();
    }

    public final String toString() {
        if (!this.f25853c.f25856b.f25861b.isEmpty()) {
            return m27404g();
        }
        StringBuilder stringBuilder = new StringBuilder(Operation.DIVISION);
        stringBuilder.append(m27404g());
        return stringBuilder.toString();
    }
}
