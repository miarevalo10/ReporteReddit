package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/load/kotlin/reflect/RuntimeModuleData;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KDeclarationContainerImpl.kt */
final class KDeclarationContainerImpl$Data$moduleData$2 extends Lambda implements Function0<RuntimeModuleData> {
    final /* synthetic */ Data f38247a;

    KDeclarationContainerImpl$Data$moduleData$2(Data data) {
        this.f38247a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return ModuleByClassLoaderKt.m26913a(this.f38247a.f25331j.mo6657a());
    }
}
