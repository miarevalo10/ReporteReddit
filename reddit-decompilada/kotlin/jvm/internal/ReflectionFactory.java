package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;

public class ReflectionFactory {
    public KFunction mo5698a(FunctionReference functionReference) {
        return functionReference;
    }

    public KMutableProperty0 mo5699a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 mo5700a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KProperty0 mo5701a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 mo5702a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KDeclarationContainer mo5697a(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KClass mo5696a(Class cls) {
        return new ClassReference(cls);
    }

    public String mo5695a(Lambda lambda) {
        lambda = lambda.getClass().getGenericInterfaces()[0].toString();
        return lambda.startsWith("kotlin.jvm.functions.") ? lambda.substring(21) : lambda;
    }
}
