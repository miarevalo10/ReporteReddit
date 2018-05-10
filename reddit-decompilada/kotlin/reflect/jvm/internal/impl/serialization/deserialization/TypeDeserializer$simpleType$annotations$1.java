package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements Function0<List<? extends AnnotationWithTarget>> {
    final /* synthetic */ TypeDeserializer f38863a;
    final /* synthetic */ Type f38864b;
    final /* synthetic */ Annotations f38865c;

    TypeDeserializer$simpleType$annotations$1(TypeDeserializer typeDeserializer, Type type, Annotations annotations) {
        this.f38863a = typeDeserializer;
        this.f38864b = type;
        this.f38865c = annotations;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<AnnotationDescriptor> a = this.f38863a.f26273d.f26245c.f26233f.mo5807a(this.f38864b, this.f38863a.f26273d.f26246d);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (AnnotationDescriptor annotationWithTarget : a) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        return CollectionsKt___CollectionsKt.m41423b((Collection) (List) arrayList, (Iterable) this.f38865c.mo6683c());
    }
}
