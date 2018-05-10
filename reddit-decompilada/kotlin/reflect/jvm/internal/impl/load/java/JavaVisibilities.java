package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class JavaVisibilities {
    public static final Visibility f25626a = new Visibility("package") {
        public final String mo5717a() {
            return "public/*package*/";
        }

        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return JavaVisibilities.m27151b(declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "isVisible"}));
            }
        }

        protected final Integer mo5762a(Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "compareTo"}));
            } else if (this == visibility) {
                return Integer.valueOf(0);
            } else {
                if (Visibilities.m27096a(visibility) != null) {
                    return Integer.valueOf(1);
                }
                return Integer.valueOf(-1);
            }
        }

        public final Visibility mo5763b() {
            Visibility visibility = Visibilities.f25506c;
            if (visibility != null) {
                return visibility;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "normalize"}));
        }
    };
    public static final Visibility f25627b = new Visibility("protected_static") {
        public final String mo5717a() {
            return "protected/*protected static*/";
        }

        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return JavaVisibilities.m27150a(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "isVisible"}));
            }
        }

        public final Visibility mo5763b() {
            Visibility visibility = Visibilities.f25506c;
            if (visibility != null) {
                return visibility;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "normalize"}));
        }
    };
    public static final Visibility f25628c = new Visibility("protected_and_package") {
        public final String mo5717a() {
            return "protected/*protected and package*/";
        }

        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return JavaVisibilities.m27150a(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "isVisible"}));
            }
        }

        protected final Integer mo5762a(Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "compareTo"}));
            } else if (this == visibility) {
                return Integer.valueOf(0);
            } else {
                if (visibility == Visibilities.f25507d) {
                    return null;
                }
                if (Visibilities.m27096a(visibility) != null) {
                    return Integer.valueOf(1);
                }
                return Integer.valueOf(-1);
            }
        }

        public final Visibility mo5763b() {
            Visibility visibility = Visibilities.f25506c;
            if (visibility != null) {
                return visibility;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "normalize"}));
        }
    };

    static /* synthetic */ boolean m27150a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "isVisibleForProtectedAndPackage"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "isVisibleForProtectedAndPackage"}));
        } else if (m27151b(DescriptorUtils.m27640a(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        } else {
            return Visibilities.f25506c.mo5716a(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    private static boolean m27151b(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"first", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "areInSamePackage"}));
        } else if (declarationDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"second", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "areInSamePackage"}));
        } else {
            PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.m27639a(declarationDescriptor, PackageFragmentDescriptor.class, false);
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.m27639a(declarationDescriptor2, PackageFragmentDescriptor.class, false);
            return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || packageFragmentDescriptor.mo7722d().equals(packageFragmentDescriptor2.mo7722d()) == null) ? false : true;
        }
    }
}
