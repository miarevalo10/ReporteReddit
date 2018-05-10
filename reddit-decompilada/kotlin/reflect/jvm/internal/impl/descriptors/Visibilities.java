package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

public class Visibilities {
    public static final Visibility f25504a = new Visibility("private") {
        private static boolean m32937a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "inSameFile"}));
            } else if (declarationDescriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "inSameFile"}));
            } else {
                declarationDescriptor2 = DescriptorUtils.m27663m(declarationDescriptor2);
                if (declarationDescriptor2 != SourceFile.f25499a) {
                    return declarationDescriptor2.equals(DescriptorUtils.m27663m(declarationDescriptor));
                }
                return false;
            }
        }

        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "isVisible"}));
            } else if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "isVisible"}));
            } else {
                DeclarationDescriptor aD_;
                if (DescriptorUtils.m27655e(declarationDescriptorWithVisibility)) {
                    if (declarationDescriptor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "hasContainingSourceFile"}));
                    }
                    if ((DescriptorUtils.m27663m(declarationDescriptor) != SourceFile.f25499a ? 1 : null) != null) {
                        return C25561.m32937a(declarationDescriptorWithVisibility, declarationDescriptor);
                    }
                }
                if ((declarationDescriptorWithVisibility instanceof ConstructorDescriptor) != null) {
                    receiverValue = ((ConstructorDescriptor) declarationDescriptorWithVisibility).mo7820u();
                    if (!(!DescriptorUtils.m27658h(receiverValue) || DescriptorUtils.m27655e(receiverValue) == null || (declarationDescriptor instanceof ConstructorDescriptor) == null || DescriptorUtils.m27655e(declarationDescriptor.aD_()) == null || C25561.m32937a(declarationDescriptorWithVisibility, declarationDescriptor) == null)) {
                        return true;
                    }
                }
                while (aD_ != null) {
                    aD_ = aD_.aD_();
                    if ((aD_ instanceof ClassDescriptor) == null || DescriptorUtils.m27657g(aD_) != null) {
                        if ((aD_ instanceof PackageFragmentDescriptor) != null) {
                            break;
                        }
                    }
                    break;
                }
                if (aD_ == null) {
                    return false;
                }
                while (declarationDescriptor != null) {
                    if (aD_ == declarationDescriptor) {
                        return true;
                    }
                    if ((declarationDescriptor instanceof PackageFragmentDescriptor) != null) {
                        return ((aD_ instanceof PackageFragmentDescriptor) == null || ((PackageFragmentDescriptor) aD_).mo7722d().equals(((PackageFragmentDescriptor) declarationDescriptor).mo7722d()) == null || DescriptorUtils.m27645a(declarationDescriptor, aD_) == null) ? false : true;
                    } else {
                        declarationDescriptor = declarationDescriptor.aD_();
                    }
                }
                return false;
            }
        }
    };
    public static final Visibility f25505b = new Visibility("private_to_this") {
        public final String mo5717a() {
            return "private/*private to this*/";
        }

        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2", "isVisible"}));
            } else if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2", "isVisible"}));
            } else {
                if (Visibilities.f25504a.mo5716a(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor) != null) {
                    if (receiverValue == Visibilities.f25515l) {
                        return true;
                    }
                    if (receiverValue == Visibilities.f25518o) {
                        return false;
                    }
                    declarationDescriptorWithVisibility = DescriptorUtils.m27638a((DeclarationDescriptor) declarationDescriptorWithVisibility, ClassDescriptor.class);
                    if (!(declarationDescriptorWithVisibility == null || (receiverValue instanceof ThisClassReceiver) == null)) {
                        return ((ThisClassReceiver) receiverValue).mo6730b().mo7741v().equals(declarationDescriptorWithVisibility.aJ_());
                    }
                }
                return false;
            }
        }
    };
    public static final Visibility f25506c = new Visibility("protected") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            while (true) {
                boolean z = false;
                if (declarationDescriptorWithVisibility == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "isVisible"}));
                } else if (declarationDescriptor == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "isVisible"}));
                } else {
                    DeclarationDescriptor declarationDescriptor2 = (ClassDescriptor) DescriptorUtils.m27638a((DeclarationDescriptor) declarationDescriptorWithVisibility, ClassDescriptor.class);
                    declarationDescriptor = (ClassDescriptor) DescriptorUtils.m27639a(declarationDescriptor, ClassDescriptor.class, false);
                    if (declarationDescriptor == null) {
                        return false;
                    }
                    if (declarationDescriptor2 != null && DescriptorUtils.m27657g(declarationDescriptor2)) {
                        ClassDescriptor classDescriptor = (ClassDescriptor) DescriptorUtils.m27638a(declarationDescriptor2, ClassDescriptor.class);
                        if (classDescriptor != null && DescriptorUtils.m27650b((ClassDescriptor) declarationDescriptor, classDescriptor)) {
                            return true;
                        }
                    }
                    declarationDescriptor2 = DescriptorUtils.m27640a(declarationDescriptorWithVisibility);
                    ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.m27638a(declarationDescriptor2, ClassDescriptor.class);
                    if (classDescriptor2 == null) {
                        return false;
                    }
                    if (DescriptorUtils.m27650b((ClassDescriptor) declarationDescriptor, classDescriptor2)) {
                        if (declarationDescriptor2 == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"whatDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "doesReceiverFitForProtectedVisibility"}));
                        } else if (declarationDescriptor == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromClass", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "doesReceiverFitForProtectedVisibility"}));
                        } else {
                            if (receiverValue != Visibilities.f25516m) {
                                if (declarationDescriptor2 instanceof CallableMemberDescriptor) {
                                    if (!(declarationDescriptor2 instanceof ConstructorDescriptor)) {
                                        if (receiverValue != Visibilities.f25515l) {
                                            if (receiverValue != Visibilities.f25518o) {
                                                if (receiverValue != null) {
                                                    KotlinType b = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).m33500b() : receiverValue.mo5715a();
                                                    if (!DescriptorUtils.m27647a(b, declarationDescriptor)) {
                                                        if (DynamicTypesKt.m27930a(b)) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                z = true;
                            }
                            if (z) {
                                return true;
                            }
                        }
                    }
                    declarationDescriptor = declarationDescriptor.aD_();
                }
            }
        }
    };
    public static final Visibility f25507d = new Visibility("internal") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4", "isVisible"}));
            } else if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4", "isVisible"}));
            } else {
                if (DescriptorUtils.m27656f((declarationDescriptor instanceof PackageViewDescriptor) != null ? ((PackageViewDescriptor) declarationDescriptor).mo7082d() : declarationDescriptor).mo7088a(DescriptorUtils.m27656f(declarationDescriptorWithVisibility)) == null) {
                    return false;
                }
                return Visibilities.f25519p.mo5946a(declarationDescriptorWithVisibility, declarationDescriptor);
            }
        }
    };
    public static final Visibility f25508e = new Visibility("public") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return true;
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5", "isVisible"}));
            }
        }
    };
    public static final Visibility f25509f = new Visibility("local") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6", "isVisible"}));
            } else if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6", "isVisible"}));
            } else {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        }
    };
    public static final Visibility f25510g = new Visibility("inherited") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7", "isVisible"}));
            } else if (declarationDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7", "isVisible"}));
            } else {
                throw new IllegalStateException("Visibility is unknown yet");
            }
        }
    };
    public static final Visibility f25511h = new Visibility("invisible_fake") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8", "isVisible"}));
            }
        }
    };
    public static final Visibility f25512i = new Visibility("unknown") {
        public final boolean mo5716a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9", "isVisible"}));
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9", "isVisible"}));
            }
        }
    };
    public static final Set<Visibility> f25513j = Collections.unmodifiableSet(SetsKt__SetsKt.m26802a((Object[]) new Visibility[]{f25504a, f25505b, f25507d, f25509f}));
    public static final Visibility f25514k = f25508e;
    public static final ReceiverValue f25515l = new ReceiverValue() {
        public final KotlinType mo5715a() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    @Deprecated
    public static final ReceiverValue f25516m = new ReceiverValue() {
        public final KotlinType mo5715a() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    private static final Map<Visibility, Integer> f25517n;
    private static final ReceiverValue f25518o = new ReceiverValue() {
        public final KotlinType mo5715a() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    private static final ModuleVisibilityHelper f25519p;

    static {
        Map a = CollectionsKt.m28085a();
        a.put(f25505b, Integer.valueOf(0));
        a.put(f25504a, Integer.valueOf(0));
        a.put(f25507d, Integer.valueOf(1));
        a.put(f25506c, Integer.valueOf(1));
        a.put(f25508e, Integer.valueOf(2));
        f25517n = Collections.unmodifiableMap(a);
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        f25519p = it.hasNext() ? (ModuleVisibilityHelper) it.next() : EMPTY.f33090a;
    }

    public static boolean m27095a(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleIgnoringReceiver"}));
        } else if (declarationDescriptor != null) {
            return m27093a(f25515l, declarationDescriptorWithVisibility, declarationDescriptor) == null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleIgnoringReceiver"}));
        }
    }

    private static DeclarationDescriptorWithVisibility m27093a(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "findInvisibleMember"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "findInvisibleMember"}));
        } else {
            DeclarationDescriptor declarationDescriptor2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.aJ_();
            while (declarationDescriptor2 != null && declarationDescriptor2.mo7257j() != f25509f) {
                if (!declarationDescriptor2.mo7257j().mo5716a(receiverValue, declarationDescriptor2, declarationDescriptor)) {
                    return declarationDescriptor2;
                }
                DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.m27638a(declarationDescriptor2, DeclarationDescriptorWithVisibility.class);
            }
            if (declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) {
                receiverValue = m27093a(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).m42809D(), declarationDescriptor);
                if (receiverValue != null) {
                    return receiverValue;
                }
            }
            return null;
        }
    }

    static Integer m27092a(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"first", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compareLocal"}));
        } else if (visibility2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"second", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compareLocal"}));
        } else if (visibility == visibility2) {
            return Integer.valueOf(0);
        } else {
            Integer num = (Integer) f25517n.get(visibility);
            Integer num2 = (Integer) f25517n.get(visibility2);
            if (!(num == null || num2 == null)) {
                if (!num.equals(num2)) {
                    return Integer.valueOf(num.intValue() - num2.intValue());
                }
            }
            return null;
        }
    }

    public static Integer m27097b(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"first", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compare"}));
        } else if (visibility2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"second", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compare"}));
        } else {
            Integer a = visibility.mo5762a(visibility2);
            if (a != null) {
                return a;
            }
            visibility = visibility2.mo5762a(visibility);
            return visibility != null ? Integer.valueOf(-visibility.intValue()) : null;
        }
    }

    public static boolean m27096a(Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visibility", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isPrivate"}));
        }
        if (visibility != f25504a) {
            if (visibility != f25505b) {
                return false;
            }
        }
        return true;
    }
}
