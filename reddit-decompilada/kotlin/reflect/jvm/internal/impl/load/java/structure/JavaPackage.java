package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: javaElements.kt */
public interface JavaPackage extends JavaElement {
    Collection<JavaClass> mo6711a(Function1<? super Name, Boolean> function1);

    FqName mo6712a();

    Collection<JavaPackage> mo6713b();
}
