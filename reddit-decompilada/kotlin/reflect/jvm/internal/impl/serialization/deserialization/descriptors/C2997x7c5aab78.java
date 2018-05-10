package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2997x7c5aab78 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ EnumEntry f38877a;
    final /* synthetic */ C2998xaf8327b7 f38878b;
    final /* synthetic */ Name f38879c;

    C2997x7c5aab78(EnumEntry enumEntry, C2998xaf8327b7 c2998xaf8327b7, Name name) {
        this.f38877a = enumEntry;
        this.f38878b = c2998xaf8327b7;
        this.f38879c = name;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38878b.f38880a.f26278b.f40869b.f26245c.f26233f.mo5812a((ProtoContainer) this.f38878b.f38880a.f26278b.f40871f, this.f38877a);
    }
}
