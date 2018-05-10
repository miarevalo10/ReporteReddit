package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.ReflectLambdaKt;

public class ReflectionFactoryImpl extends ReflectionFactory {
    public final KDeclarationContainer mo5697a(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    public final KClass mo5696a(Class cls) {
        return KClassCacheKt.m26908a(cls);
    }

    public final String mo5695a(Lambda lambda) {
        Object a = ReflectLambdaKt.m26890a(lambda);
        if (a != null) {
            KFunctionImpl a2 = UtilKt.m26934a(a);
            if (a2 != null) {
                lambda = ReflectionObjectRenderer.f25341a;
                return ReflectionObjectRenderer.m26927b(a2.m38251d());
            }
        }
        return super.mo5695a(lambda);
    }

    public final KFunction mo5698a(FunctionReference functionReference) {
        return new KFunctionImpl(m32903a((CallableReference) functionReference), functionReference.mo5687b(), functionReference.mo6932c(), functionReference.m32846f());
    }

    public final KProperty0 mo5701a(PropertyReference0 propertyReference0) {
        return new KProperty0Impl(m32903a((CallableReference) propertyReference0), propertyReference0.mo5687b(), propertyReference0.mo6932c(), propertyReference0.m32846f());
    }

    public final KMutableProperty0 mo5699a(MutablePropertyReference0 mutablePropertyReference0) {
        return new KMutableProperty0Impl(m32903a((CallableReference) mutablePropertyReference0), mutablePropertyReference0.mo5687b(), mutablePropertyReference0.mo6932c(), mutablePropertyReference0.m32846f());
    }

    public final KProperty1 mo5702a(PropertyReference1 propertyReference1) {
        return new KProperty1Impl(m32903a((CallableReference) propertyReference1), propertyReference1.mo5687b(), propertyReference1.mo6932c(), propertyReference1.m32846f());
    }

    public final KMutableProperty1 mo5700a(MutablePropertyReference1 mutablePropertyReference1) {
        return new KMutableProperty1Impl(m32903a((CallableReference) mutablePropertyReference1), mutablePropertyReference1.mo5687b(), mutablePropertyReference1.mo6932c(), mutablePropertyReference1.m32846f());
    }

    private static KDeclarationContainerImpl m32903a(CallableReference callableReference) {
        callableReference = callableReference.mo6931a();
        return callableReference instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) callableReference : EmptyContainerForLocal.f38213a;
    }
}
