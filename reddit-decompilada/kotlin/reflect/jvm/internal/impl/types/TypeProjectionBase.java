package kotlin.reflect.jvm.internal.impl.types;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public abstract class TypeProjectionBase implements TypeProjection {
    public String toString() {
        if (mo6734a()) {
            return Operation.MULTIPLY;
        }
        if (mo6735b() == Variance.f26337a) {
            return mo6736c().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo6735b());
        stringBuilder.append(" ");
        stringBuilder.append(mo6736c());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeProjection)) {
            return false;
        }
        TypeProjection typeProjection = (TypeProjection) obj;
        return mo6734a() == typeProjection.mo6734a() && mo6735b() == typeProjection.mo6735b() && mo6736c().equals(typeProjection.mo6736c()) != null;
    }

    public int hashCode() {
        return (31 * mo6735b().hashCode()) + (mo6734a() ? 17 : mo6736c().hashCode());
    }
}
