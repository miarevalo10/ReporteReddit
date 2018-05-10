package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class TypeEnhancementInfo {
    final Map<Integer, JavaTypeQualifiers> f25775a;

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> map) {
        Intrinsics.m26847b(map, "map");
        this.f25775a = map;
    }
}
