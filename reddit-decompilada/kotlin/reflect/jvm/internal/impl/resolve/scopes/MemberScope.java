package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
public interface MemberScope extends ResolutionScope {
    public static final Companion f32953f = new Companion();

    /* compiled from: MemberScope.kt */
    public static final class Companion {
        private static final Function1<Name, Boolean> f26139a = null;

        private Companion() {
            f26139a = MemberScope$Companion$ALL_NAME_FILTER$1.f38818a;
        }

        public static Function1<Name, Boolean> m27788a() {
            return f26139a;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class Empty extends MemberScopeImpl {
        public static final Empty f38819a = null;

        static {
            Empty empty = new Empty();
        }

        private Empty() {
            f38819a = this;
        }

        public final Set<Name> aE_() {
            return SetsKt__SetsKt.m26799a();
        }

        public final Set<Name> aF_() {
            return SetsKt__SetsKt.m26799a();
        }
    }

    Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation);

    Set<Name> aE_();

    Set<Name> aF_();

    Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation);
}
