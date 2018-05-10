package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: SupertypeLoopChecker.kt */
public interface SupertypeLoopChecker {

    /* compiled from: SupertypeLoopChecker.kt */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY f32638a = null;

        public final Collection<KotlinType> mo5714a(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12) {
            Intrinsics.m26847b(typeConstructor, "currentTypeConstructor");
            Intrinsics.m26847b(collection, "superTypes");
            Intrinsics.m26847b(function1, "neighbors");
            Intrinsics.m26847b(function12, "reportLoop");
            return collection;
        }

        static {
            EMPTY empty = new EMPTY();
        }

        private EMPTY() {
            f32638a = this;
        }
    }

    Collection<KotlinType> mo5714a(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12);
}
