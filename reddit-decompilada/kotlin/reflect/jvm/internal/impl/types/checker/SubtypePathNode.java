package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: utils.kt */
final class SubtypePathNode {
    final KotlinType f26353a;
    final SubtypePathNode f26354b;

    public SubtypePathNode(KotlinType kotlinType, SubtypePathNode subtypePathNode) {
        Intrinsics.m26847b(kotlinType, "type");
        this.f26353a = kotlinType;
        this.f26354b = subtypePathNode;
    }
}
