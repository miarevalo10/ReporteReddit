package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: javaElements.kt */
public interface JavaClass extends JavaClassifier, JavaModifierListOwner, JavaTypeParameterListOwner {
    FqName mo7274b();

    Collection<JavaClassifierType> mo7275c();

    Collection<JavaClass> mo7276d();

    JavaClass mo7277e();

    boolean mo7278f();

    boolean mo7279g();

    boolean mo7280h();

    Collection<JavaMethod> mo7281i();

    Collection<JavaField> mo7282j();

    Collection<JavaConstructor> mo7283k();
}
