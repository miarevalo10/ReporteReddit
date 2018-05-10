package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014 \u0005*\t\u0018\u00010\u0003¢\u0006\u0002\b\u00040\u0003¢\u0006\u0002\b\u00042\u0018\u0010\u0006\u001a\u0014 \u0005*\t\u0018\u00010\u0003¢\u0006\u0002\b\u00040\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "first", "Lorg/jetbrains/kotlin/descriptors/Visibility;", "Lorg/jetbrains/annotations/NotNull;", "kotlin.jvm.PlatformType", "second", "compare"}, k = 3, mv = {1, 1, 5})
/* compiled from: KDeclarationContainerImpl.kt */
final class C2137x62283bb<T> implements Comparator<Visibility> {
    public static final C2137x62283bb f25335a = new C2137x62283bb();

    C2137x62283bb() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        obj = Visibilities.m27097b((Visibility) obj, (Visibility) obj2);
        return obj != null ? obj.intValue() : null;
    }
}
