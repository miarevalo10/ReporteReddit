package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* compiled from: Delegates.kt */
public final class DescriptorRendererOptionsImpl$property$$inlined$vetoable$1 extends ObservableProperty<T> {
    final /* synthetic */ Object f36135a;
    final /* synthetic */ DescriptorRendererOptionsImpl f36136b;

    DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(Object obj, Object obj2, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        this.f36135a = obj;
        this.f36136b = descriptorRendererOptionsImpl;
        super(obj2);
    }

    protected final boolean mo6729a(KProperty<?> kProperty) {
        if (this.f36136b.f32903a == null) {
            return true;
        }
        throw ((Throwable) new IllegalStateException("Cannot modify readonly DescriptorRendererOptions"));
    }
}
