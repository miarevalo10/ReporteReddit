package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;

/* compiled from: ResolutionScope.kt */
public interface ResolutionScope {

    /* compiled from: ResolutionScope.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ Collection m27789a(ResolutionScope resolutionScope, DescriptorKindFilter descriptorKindFilter, Function1 function1, int i) {
            if ((i & 1) != 0) {
                descriptorKindFilter = DescriptorKindFilter.f26113c;
            }
            if ((i & 2) != 0) {
                function1 = MemberScope.f32953f;
                function1 = Companion.m27788a();
            }
            return resolutionScope.mo6695a(descriptorKindFilter, function1);
        }
    }

    Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation);
}
