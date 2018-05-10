package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> implements Neighbors<N> {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1 f32730a = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1();

    /* compiled from: LazyJavaStaticClassScope.kt */
    static final class C29431 extends Lambda implements Function1<KotlinType, ClassDescriptor> {
        public static final C29431 f38436a = new C29431();

        C29431() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            obj = ((KotlinType) obj).mo6743g().mo5724c();
            if (!(obj instanceof ClassDescriptor)) {
                obj = null;
            }
            return (ClassDescriptor) obj;
        }
    }

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1() {
    }

    public final /* synthetic */ Iterable mo5785a(Object obj) {
        return SequencesKt___SequencesKt.m33720h(SequencesKt___SequencesKt.m33718f(CollectionsKt___CollectionsKt.m41455t(((ClassDescriptor) obj).mo7610c().aL_()), C29431.f38436a));
    }
}
