package io.gsonfire.postprocessors.methodinvoker;

import io.gsonfire.annotations.ExposeMethodResult;
import io.gsonfire.util.reflection.AnnotationInspector;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

final class MappedMethodInspector extends AnnotationInspector<Method, MappedMethod> {
    MappedMethodInspector() {
    }

    protected final /* synthetic */ Object mo5618a(AccessibleObject accessibleObject) {
        Method method = (Method) accessibleObject;
        if (method.getParameterTypes().length > 0) {
            throw new IllegalArgumentException("The methods annotated with ExposeMethodResult should have no arguments");
        }
        ExposeMethodResult exposeMethodResult = (ExposeMethodResult) method.getAnnotation(ExposeMethodResult.class);
        return new MappedMethod(method, exposeMethodResult.m26455a(), exposeMethodResult.m26456b());
    }

    protected final /* synthetic */ AccessibleObject[] mo5619a(Class cls) {
        return cls.getDeclaredMethods();
    }
}
