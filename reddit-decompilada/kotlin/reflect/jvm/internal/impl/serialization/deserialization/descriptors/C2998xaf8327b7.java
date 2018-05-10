package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2998xaf8327b7 extends Lambda implements Function1<Name, EnumEntrySyntheticClassDescriptor> {
    final /* synthetic */ EnumEntryClassDescriptors f38880a;

    C2998xaf8327b7(EnumEntryClassDescriptors enumEntryClassDescriptors) {
        this.f38880a = enumEntryClassDescriptors;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "name");
        EnumEntry enumEntry = (EnumEntry) this.f38880a.f26277a.get(name);
        if (enumEntry == null) {
            return null;
        }
        return EnumEntrySyntheticClassDescriptor.m42917a(this.f38880a.f26278b.f40869b.f26245c.f26229b, this.f38880a.f26278b, name, this.f38880a.f26280d, new DeserializedAnnotations(this.f38880a.f26278b.f40869b.f26245c.f26229b, new C2997x7c5aab78(enumEntry, this, name)), SourceElement.f25498a);
    }
}
