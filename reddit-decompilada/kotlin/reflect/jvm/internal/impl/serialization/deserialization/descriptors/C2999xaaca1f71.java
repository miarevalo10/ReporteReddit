package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2999xaaca1f71 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ EnumEntryClassDescriptors f38881a;

    C2999xaaca1f71(EnumEntryClassDescriptors enumEntryClassDescriptors) {
        this.f38881a = enumEntryClassDescriptors;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return EnumEntryClassDescriptors.m27894c(this.f38881a);
    }
}
