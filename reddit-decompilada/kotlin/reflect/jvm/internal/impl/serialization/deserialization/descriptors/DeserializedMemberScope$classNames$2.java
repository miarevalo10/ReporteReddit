package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$classNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ Function0 f38887a;

    DeserializedMemberScope$classNames$2(Function0 function0) {
        this.f38887a = function0;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return CollectionsKt___CollectionsKt.m41451p((Iterable) this.f38887a.invoke());
    }
}
