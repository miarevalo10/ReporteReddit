package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;

/* compiled from: StaticScopeForKotlinEnum.kt */
final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ StaticScopeForKotlinEnum f38820a;

    StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        this.f38820a = staticScopeForKotlinEnum;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return CollectionsKt__CollectionsKt.m26796b((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.m27633b(this.f38820a.f38823c), DescriptorFactory.m27628a(this.f38820a.f38823c)});
    }
}
