package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.regex.Pattern;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

public class JvmClassName {
    public final String f26093a;
    private FqName f26094b;

    public static JvmClassName m27748a(String str) {
        if (str != null) {
            return new JvmClassName(str);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"internalName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byInternalName"}));
    }

    public static JvmClassName m27749a(ClassId classId) {
        if (classId != null) {
            return m27750a(classId, null);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classId", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"}));
    }

    public static JvmClassName m27750a(ClassId classId, TypeMappingConfiguration<?> typeMappingConfiguration) {
        int i = 2;
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classId", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byClassId"}));
        }
        FqName a = classId.m27398a();
        String[] split = classId.m27399b().m27407a().split(Pattern.quote("."));
        if (split.length == 1) {
            classId = split[0];
        } else if (split.length <= 1 || typeMappingConfiguration == null) {
            classId = classId.m27399b().m27407a().replace('.', '$');
        } else {
            classId = typeMappingConfiguration.mo5838a();
            typeMappingConfiguration = (String) classId.mo6497a(split[0], split[1]);
            while (i < split.length) {
                String str = (String) classId.mo6497a(typeMappingConfiguration, split[i]);
                i++;
            }
            classId = typeMappingConfiguration;
        }
        if (a.m27410c() != null) {
            return new JvmClassName(classId);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.m27407a().replace('.', '/'));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(classId);
        return new JvmClassName(stringBuilder.toString());
    }

    public static JvmClassName m27751a(FqName fqName) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "byFqNameWithoutInnerClasses"}));
        }
        JvmClassName jvmClassName = new JvmClassName(fqName.m27407a().replace('.', '/'));
        jvmClassName.f26094b = fqName;
        return jvmClassName;
    }

    private JvmClassName(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"internalName", "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "<init>"}));
        } else {
            this.f26093a = str;
        }
    }

    public final String m27752a() {
        String str = this.f26093a;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getInternalName"}));
    }

    public String toString() {
        return this.f26093a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f26093a.equals(((JvmClassName) obj).f26093a);
            }
        }
        return null;
    }

    public int hashCode() {
        return this.f26093a.hashCode();
    }
}
