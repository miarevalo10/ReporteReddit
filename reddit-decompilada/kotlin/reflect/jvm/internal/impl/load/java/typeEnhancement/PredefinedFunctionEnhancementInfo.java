package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedFunctionEnhancementInfo {
    final TypeEnhancementInfo f25756a;
    final List<TypeEnhancementInfo> f25757b;

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List<TypeEnhancementInfo> list) {
        Intrinsics.m26847b(list, "parametersInfo");
        this.f25756a = typeEnhancementInfo;
        this.f25757b = list;
    }

    private /* synthetic */ PredefinedFunctionEnhancementInfo() {
        this(null, CollectionsKt__CollectionsKt.m26790a());
    }
}
