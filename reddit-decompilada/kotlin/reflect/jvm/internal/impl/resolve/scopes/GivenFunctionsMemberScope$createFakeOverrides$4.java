package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* compiled from: GivenFunctionsMemberScope.kt */
public final class GivenFunctionsMemberScope$createFakeOverrides$4 extends NonReportingOverrideStrategy {
    final /* synthetic */ GivenFunctionsMemberScope f36155a;
    final /* synthetic */ ArrayList f36156b;

    GivenFunctionsMemberScope$createFakeOverrides$4(GivenFunctionsMemberScope givenFunctionsMemberScope, ArrayList arrayList) {
        this.f36155a = givenFunctionsMemberScope;
        this.f36156b = arrayList;
    }

    public final void mo6690a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.m27693a(callableMemberDescriptor, null);
        this.f36156b.add(callableMemberDescriptor);
    }

    protected final void mo6691a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.m26847b(callableMemberDescriptor, "fromSuper");
        Intrinsics.m26847b(callableMemberDescriptor2, "fromCurrent");
        StringBuilder stringBuilder = new StringBuilder("Conflict in scope of ");
        stringBuilder.append(this.f36155a.f38815b);
        stringBuilder.append(": ");
        stringBuilder.append(callableMemberDescriptor);
        stringBuilder.append(" vs ");
        stringBuilder.append(callableMemberDescriptor2);
        throw ((Throwable) new IllegalStateException(stringBuilder.toString().toString()));
    }
}
