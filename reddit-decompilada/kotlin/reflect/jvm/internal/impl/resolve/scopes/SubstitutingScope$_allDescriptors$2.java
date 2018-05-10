package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;

/* compiled from: SubstitutingScope.kt */
final class SubstitutingScope$_allDescriptors$2 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ SubstitutingScope f38824a;

    SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        this.f38824a = substitutingScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38824a.m36365a(DefaultImpls.m27789a(this.f38824a.f36161e, null, null, 3));
    }
}
