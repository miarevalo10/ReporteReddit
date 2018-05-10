package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

public interface ErrorReporter {
    public static final ErrorReporter f26251b = new C25931();

    static class C25931 implements ErrorReporter {
        public final void mo5771a(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportCannotInferVisibility"}));
            }
        }

        public final void mo5772a(ClassDescriptor classDescriptor, List<String> list) {
            if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportIncompleteHierarchy"}));
            }
        }

        C25931() {
        }
    }

    void mo5771a(CallableMemberDescriptor callableMemberDescriptor);

    void mo5772a(ClassDescriptor classDescriptor, List<String> list);
}
