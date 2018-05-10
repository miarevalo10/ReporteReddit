package io.gsonfire.util.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public abstract class AbstractMethodInspector<M> extends AnnotationInspector<Method, M> {
    protected final /* synthetic */ AccessibleObject[] mo5619a(Class cls) {
        return cls.getDeclaredMethods();
    }
}
