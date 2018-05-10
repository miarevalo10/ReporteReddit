package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* compiled from: AnnotationUseSiteTarget.kt */
public enum AnnotationUseSiteTarget {
    ;
    
    public static final Companion f25531k = null;
    public final String f25533j;

    /* compiled from: AnnotationUseSiteTarget.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AnnotationUseSiteTarget m27107a(DeclarationDescriptor declarationDescriptor) {
            Intrinsics.m26847b(declarationDescriptor, "descriptor");
            if (declarationDescriptor instanceof PropertyDescriptor) {
                return AnnotationUseSiteTarget.f25524c;
            }
            if (declarationDescriptor instanceof ValueParameterDescriptor) {
                return AnnotationUseSiteTarget.f25528g;
            }
            if (declarationDescriptor instanceof PropertyGetterDescriptor) {
                return AnnotationUseSiteTarget.f25525d;
            }
            return (declarationDescriptor instanceof PropertySetterDescriptor) != null ? AnnotationUseSiteTarget.f25526e : null;
        }
    }

    private AnnotationUseSiteTarget(String str) {
        if (str == null) {
            r1 = name();
            if (r1 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = r1.toLowerCase();
            Intrinsics.m26843a((Object) str, "(this as java.lang.String).toLowerCase()");
        }
        this.f25533j = str;
    }

    static {
        f25531k = new Companion();
    }
}
