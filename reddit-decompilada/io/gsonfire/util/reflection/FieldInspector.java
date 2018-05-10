package io.gsonfire.util.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class FieldInspector extends AnnotationInspector<Field, Field> {
    protected final /* synthetic */ AccessibleObject[] mo5619a(Class cls) {
        return cls.getDeclaredFields();
    }
}
