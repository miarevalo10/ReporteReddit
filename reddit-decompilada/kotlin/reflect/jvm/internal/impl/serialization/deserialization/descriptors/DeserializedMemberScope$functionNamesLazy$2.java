package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$functionNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope f38888a;

    DeserializedMemberScope$functionNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        this.f38888a = deserializedMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return SetsKt___SetsKt.m32819a(this.f38888a.m38635f().keySet(), (Iterable) this.f38888a.mo7310c());
    }
}
