package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: GivenFunctionsMemberScope.kt */
final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
    final /* synthetic */ GivenFunctionsMemberScope f38812a;

    GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        this.f38812a = givenFunctionsMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        List a = this.f38812a.mo7256a();
        return CollectionsKt___CollectionsKt.m41423b((Collection) a, (Iterable) GivenFunctionsMemberScope.m38577a(this.f38812a, a));
    }
}
