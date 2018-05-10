package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.ReadOnly;

public interface JavaClassFinder {
    JavaClass mo5797a(ClassId classId);

    JavaPackage mo5798a(FqName fqName);

    @ReadOnly
    Set<String> mo5799b(FqName fqName);
}
