package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: DeserializedAnnotations.kt */
final class DeserializedAnnotationsWithPossibleTargets$annotations$1 extends Lambda implements Function0<List<? extends AnnotationWithTarget>> {
    final /* synthetic */ Function0 f38868a;

    DeserializedAnnotationsWithPossibleTargets$annotations$1(Function0 function0) {
        this.f38868a = function0;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return CollectionsKt.m28089a((Collection) this.f38868a.invoke());
    }
}
