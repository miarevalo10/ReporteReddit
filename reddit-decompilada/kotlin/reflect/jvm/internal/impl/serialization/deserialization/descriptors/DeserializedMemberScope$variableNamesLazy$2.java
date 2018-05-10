package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$variableNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope f38898a;

    DeserializedMemberScope$variableNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        this.f38898a = deserializedMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return SetsKt___SetsKt.m32819a(this.f38898a.m38636g().keySet(), (Iterable) this.f38898a.mo7311d());
    }
}
