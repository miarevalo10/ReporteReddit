package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* compiled from: Visibility.kt */
public abstract class Visibility {
    public final boolean f25520a;
    private final String f25521b;

    public abstract boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor);

    public Visibility mo5763b() {
        return this;
    }

    protected Visibility(String str, boolean z) {
        Intrinsics.m26847b(str, "name");
        this.f25521b = str;
        this.f25520a = z;
    }

    public Integer mo5762a(Visibility visibility) {
        Intrinsics.m26847b(visibility, "visibility");
        return Visibilities.m27092a(this, visibility);
    }

    public String mo5717a() {
        return this.f25521b;
    }

    public final String toString() {
        return mo5717a();
    }
}
