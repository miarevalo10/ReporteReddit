package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: DescriptorRenderer.kt */
public enum DescriptorRendererModifier {
    ;
    
    public static final Set<DescriptorRendererModifier> f26031j = null;
    public static final Set<DescriptorRendererModifier> f26032k = null;
    public static final Companion f26033l = null;
    private final boolean f26035n;

    /* compiled from: DescriptorRenderer.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private DescriptorRendererModifier(boolean z) {
        this.f26035n = z;
    }

    static {
        f26033l = new Companion();
        Object[] objArr = (Object[]) values();
        Collection arrayList = new ArrayList();
        int i;
        while (i < objArr.length) {
            Object obj = objArr[i];
            if (((DescriptorRendererModifier) obj).f26035n) {
                arrayList.add(obj);
            }
            i++;
        }
        f26031j = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        f26032k = ArraysKt___ArraysKt.m36111k((Object[]) values());
    }
}
