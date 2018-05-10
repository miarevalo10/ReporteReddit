package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: TypeCheckerContext.kt */
public class TypeCheckerContext {
    final boolean f26355a;
    private int f26356b;
    private boolean f26357c;
    private ArrayDeque<SimpleType> f26358d;
    private Set<SimpleType> f26359e;

    /* compiled from: TypeCheckerContext.kt */
    public static abstract class SupertypesPolicy {

        /* compiled from: TypeCheckerContext.kt */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible f33079a = null;

            static {
                LowerIfFlexible lowerIfFlexible = new LowerIfFlexible();
            }

            private LowerIfFlexible() {
                super();
                f33079a = this;
            }

            public final SimpleType mo5937a(KotlinType kotlinType) {
                Intrinsics.m26847b(kotlinType, "type");
                return FlexibleTypesKt.m27948c(kotlinType);
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class LowerIfFlexibleWithCustomSubstitutor extends SupertypesPolicy {
            private final TypeSubstitutor f33080a;

            public LowerIfFlexibleWithCustomSubstitutor(TypeSubstitutor typeSubstitutor) {
                Intrinsics.m26847b(typeSubstitutor, "substitutor");
                super();
                this.f33080a = typeSubstitutor;
            }

            public final SimpleType mo5937a(KotlinType kotlinType) {
                Intrinsics.m26847b(kotlinType, "type");
                return TypeSubstitutionKt.m27990a(this.f33080a.m28002a(FlexibleTypesKt.m27948c(kotlinType), Variance.f26337a));
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class None extends SupertypesPolicy {
            public static final None f33081a = null;

            static {
                None none = new None();
            }

            private None() {
                super();
                f33081a = this;
            }

            public final /* synthetic */ SimpleType mo5937a(KotlinType kotlinType) {
                Intrinsics.m26847b(kotlinType, "type");
                throw ((Throwable) new UnsupportedOperationException("Should not be called"));
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible f33082a = null;

            static {
                UpperIfFlexible upperIfFlexible = new UpperIfFlexible();
            }

            private UpperIfFlexible() {
                super();
                f33082a = this;
            }

            public final SimpleType mo5937a(KotlinType kotlinType) {
                Intrinsics.m26847b(kotlinType, "type");
                return FlexibleTypesKt.m27949d(kotlinType);
            }
        }

        public abstract SimpleType mo5937a(KotlinType kotlinType);

        private SupertypesPolicy() {
        }
    }

    public static Boolean m28038a(UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.m26847b(unwrappedType, "subType");
        Intrinsics.m26847b(unwrappedType2, "superType");
        return null;
    }

    public TypeCheckerContext(boolean z) {
        this.f26355a = z;
    }

    private final void m28039a() {
        ArrayDeque arrayDeque = this.f26358d;
        if (arrayDeque == null) {
            Intrinsics.m26842a();
        }
        arrayDeque.clear();
        Set set = this.f26359e;
        if (set == null) {
            Intrinsics.m26842a();
        }
        set.clear();
        this.f26357c = false;
    }

    public final boolean m28041a(SimpleType simpleType, Function1<? super SimpleType, Boolean> function1, Function1<? super SimpleType, ? extends SupertypesPolicy> function12) {
        Intrinsics.m26847b(simpleType, "start");
        Intrinsics.m26847b(function1, "predicate");
        Intrinsics.m26847b(function12, "supertypesPolicy");
        int i = this.f26357c ^ 1;
        if (_Assertions.f25274a && i == 0) {
            throw ((Throwable) new AssertionError("Assertion failed"));
        }
        this.f26357c = true;
        if (this.f26358d == null) {
            this.f26358d = new ArrayDeque();
        }
        if (this.f26359e == null) {
            Companion companion = SmartSet.f26429a;
            this.f26359e = Companion.m28116a();
        }
        ArrayDeque arrayDeque = this.f26358d;
        if (arrayDeque == null) {
            Intrinsics.m26842a();
        }
        Set set = this.f26359e;
        if (set == null) {
            Intrinsics.m26842a();
        }
        arrayDeque.push(simpleType);
        while ((arrayDeque.isEmpty() ^ 1) != 0) {
            if (set.size() > 1000) {
                function1 = new StringBuilder("Too many supertypes for type: ");
                function1.append(simpleType);
                function1.append(". Supertypes = ");
                function1.append(CollectionsKt___CollectionsKt.m41412a((Iterable) set, null, null, null, 0, null, null, 63));
                throw ((Throwable) new IllegalStateException(function1.toString().toString()));
            }
            Object obj = (SimpleType) arrayDeque.pop();
            Intrinsics.m26843a(obj, "current");
            if (set.add(obj)) {
                Intrinsics.m26843a(obj, "current");
                if (((Boolean) function1.mo6492a(obj)).booleanValue()) {
                    m28039a();
                    return true;
                }
                Intrinsics.m26843a(obj, "current");
                SupertypesPolicy supertypesPolicy = (SupertypesPolicy) AddToStdlibKt.m28126a(function12.mo6492a(obj), TypeCheckerContext$anySupertype$policy$1.f38944a);
                if (supertypesPolicy != null) {
                    for (Object obj2 : obj.mo6743g().aL_()) {
                        Intrinsics.m26843a(obj2, "supertype");
                        arrayDeque.add(supertypesPolicy.mo5937a(obj2));
                    }
                }
            }
        }
        m28039a();
        return null;
    }
}
