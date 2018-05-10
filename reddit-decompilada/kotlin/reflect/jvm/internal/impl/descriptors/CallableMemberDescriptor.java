package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {

    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public final boolean m27041a() {
            return this != FAKE_OVERRIDE;
        }
    }

    CallableMemberDescriptor mo7748a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind);

    void mo7749a(Collection<? extends CallableMemberDescriptor> collection);

    Collection<? extends CallableMemberDescriptor> mo7609m();

    CallableMemberDescriptor mo7759s();

    Kind mo7760t();
}
