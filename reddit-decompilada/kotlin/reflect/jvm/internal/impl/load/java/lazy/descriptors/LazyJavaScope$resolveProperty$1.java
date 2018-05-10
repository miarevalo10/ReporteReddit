package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$resolveProperty$1 extends Lambda implements Function0<ConstantValue<?>> {
    final /* synthetic */ LazyJavaScope f38420a;
    final /* synthetic */ JavaField f38421b;
    final /* synthetic */ PropertyDescriptorImpl f38422c;

    LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
        this.f38420a = lazyJavaScope;
        this.f38421b = javaField;
        this.f38422c = propertyDescriptorImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38420a.f38427d.f25703b.f25693i.mo5764a(this.f38421b, this.f38422c);
    }
}
