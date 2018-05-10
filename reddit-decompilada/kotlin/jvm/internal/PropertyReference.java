package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

public abstract class PropertyReference extends CallableReference implements KProperty {
    public PropertyReference(Object obj) {
        super(obj);
    }

    protected final KProperty m36133j() {
        return (KProperty) super.mo6662h();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return mo6931a().equals(propertyReference.mo6931a()) && mo5687b().equals(propertyReference.mo5687b()) && mo6932c().equals(propertyReference.mo6932c()) && Intrinsics.m26845a(m32846f(), propertyReference.m32846f()) != null;
        } else if (obj instanceof KProperty) {
            return obj.equals(m32847g());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((mo6931a().hashCode() * 31) + mo5687b().hashCode()) * 31) + mo6932c().hashCode();
    }

    public String toString() {
        PropertyReference g = m32847g();
        if (g != this) {
            return g.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("property ");
        stringBuilder.append(mo5687b());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }

    protected final /* bridge */ /* synthetic */ KCallable mo6662h() {
        return (KProperty) super.mo6662h();
    }
}
