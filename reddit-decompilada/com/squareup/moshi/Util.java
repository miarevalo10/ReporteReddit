package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

final class Util {
    public static final Set<Annotation> f23711a = Collections.emptySet();

    public static Set<? extends Annotation> m25737a(AnnotatedElement annotatedElement) {
        return m25738a(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> m25738a(Annotation[] annotationArr) {
        Set set = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.add(annotation);
            }
        }
        return set != null ? Collections.unmodifiableSet(set) : f23711a;
    }

    public static boolean m25739b(Annotation[] annotationArr) {
        for (Annotation annotationType : annotationArr) {
            if (annotationType.annotationType().getSimpleName().equals("Nullable")) {
                return 1;
            }
        }
        return false;
    }
}
