package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    final List<TypeParameterDescriptor> f40841a;
    final Kind f40842b;
    final int f40843c;
    private final FunctionTypeConstructor f40844f = new FunctionTypeConstructor(this);
    private final FunctionClassScope f40845g = new FunctionClassScope(this.f40846h, this);
    private final StorageManager f40846h;
    private final PackageFragmentDescriptor f40847i;

    /* compiled from: FunctionClassDescriptor.kt */
    public enum Kind {
        ;
        
        public static final Companion f25459f = null;
        public final FqName f25461d;
        public final String f25462e;

        /* compiled from: FunctionClassDescriptor.kt */
        public static final class Companion {
            private Companion() {
            }

            public static Kind m27038a(FqName fqName, String str) {
                Intrinsics.m26847b(fqName, "packageFqName");
                Intrinsics.m26847b(str, "className");
                Object[] objArr = (Object[]) Kind.values();
                for (Object obj : objArr) {
                    Kind kind = (Kind) obj;
                    Object obj2 = (Intrinsics.m26845a(kind.f25461d, (Object) fqName) && StringsKt__StringsJVMKt.m41949b(str, kind.f25462e, false)) ? 1 : null;
                    if (obj2 != null) {
                        break;
                    }
                }
                Object obj3 = null;
                return (Kind) obj3;
            }
        }

        private Kind(FqName fqName, String str) {
            Intrinsics.m26847b(fqName, "packageFqName");
            Intrinsics.m26847b(str, "classNamePrefix");
            this.f25461d = fqName;
            this.f25462e = str;
        }

        static {
            f25459f = new Companion();
        }

        public final Name m27039a(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f25462e);
            stringBuilder.append(i);
            return Name.m27424a(stringBuilder.toString());
        }
    }

    /* compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ FunctionClassDescriptor f38325a;

        public final boolean mo5725d() {
            return false;
        }

        public FunctionTypeConstructor(FunctionClassDescriptor functionClassDescriptor) {
            this.f38325a = functionClassDescriptor;
            super(functionClassDescriptor.f40846h);
        }

        protected final Collection<KotlinType> mo6684a() {
            ArrayList arrayList = new ArrayList(2);
            C2929x86380a31 c2929x86380a31 = new C2929x86380a31(this, arrayList);
            if (Intrinsics.m26845a(this.f38325a.f40842b, Kind.f25457b)) {
                arrayList.add(DescriptorUtilsKt.m27745d(this.f38325a.f40847i).m27015m());
            } else {
                C2929x86380a31 c2929x86380a312 = c2929x86380a31;
                PackageFragmentDescriptor a = this.f38325a.f40847i;
                Name a2 = Name.m27424a(this.f38325a.f40842b.f25462e);
                Intrinsics.m26843a((Object) a2, "Name.identifier(functionKind.classNamePrefix)");
                c2929x86380a312.m38298a(a, a2);
            }
            if (Intrinsics.m26845a(this.f38325a.f40842b, Kind.f25458c)) {
                ModuleDescriptor c = this.f38325a.f40847i.mo7721c();
                FqName fqName = KotlinBuiltIns.f25415c;
                Intrinsics.m26843a((Object) fqName, "BUILT_INS_PACKAGE_FQ_NAME");
                Iterable f = c.mo7087a(fqName).mo7083f();
                Collection arrayList2 = new ArrayList();
                for (Object next : f) {
                    if (next instanceof BuiltInsPackageFragment) {
                        arrayList2.add(next);
                    }
                }
                c2929x86380a31 = c2929x86380a31;
                PackageFragmentDescriptor packageFragmentDescriptor = (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.m41430d((List) arrayList2);
                Name a3 = Kind.f25456a.m27039a(this.f38325a.f40843c);
                Intrinsics.m26843a((Object) a3, "Kind.Function.numberedClassName(arity)");
                c2929x86380a31.m38298a(packageFragmentDescriptor, a3);
            }
            return CollectionsKt.m28089a((Collection) arrayList);
        }

        public final List<TypeParameterDescriptor> mo5723b() {
            return this.f38325a.f40841a;
        }

        protected final SupertypeLoopChecker aK_() {
            return EMPTY.f32638a;
        }

        public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
            return this.f38325a;
        }

        public final String toString() {
            return this.f38325a.toString();
        }
    }

    public final /* bridge */ /* synthetic */ ClassConstructorDescriptor aH_() {
        return null;
    }

    public final /* bridge */ /* synthetic */ ClassDescriptor mo7769e() {
        return null;
    }

    public final boolean mo7772k() {
        return false;
    }

    public final boolean mo7742l() {
        return false;
    }

    public final boolean mo7773m() {
        return false;
    }

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public final boolean mo7745p() {
        return false;
    }

    public FunctionClassDescriptor(StorageManager storageManager, PackageFragmentDescriptor packageFragmentDescriptor, Kind kind, int i) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(packageFragmentDescriptor, "containingDeclaration");
        Intrinsics.m26847b(kind, "functionKind");
        super(storageManager, kind.m27039a(i));
        this.f40846h = storageManager;
        this.f40847i = packageFragmentDescriptor;
        this.f40842b = kind;
        this.f40843c = i;
        storageManager = new ArrayList();
        packageFragmentDescriptor = new Function2<Variance, String, Unit>() {
            public final void m38296a(Variance variance, String str) {
                Intrinsics.m26847b(variance, "variance");
                Intrinsics.m26847b(str, "name");
                ArrayList arrayList = storageManager;
                DeclarationDescriptor declarationDescriptor = this;
                Companion companion = Annotations.f32643a;
                arrayList.add(TypeParameterDescriptorImpl.m42660a(declarationDescriptor, Companion.m27115a(), variance, Name.m27424a(str), storageManager.size()));
            }
        };
        Iterable iterable = (Iterable) new IntRange(1, this.f40843c);
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        kind = iterable.iterator();
        while (kind.hasNext()) {
            int a = ((IntIterator) kind).mo6663a();
            Variance variance = Variance.f26338b;
            StringBuilder stringBuilder = new StringBuilder("P");
            stringBuilder.append(a);
            packageFragmentDescriptor.m38296a(variance, stringBuilder.toString());
            collection.add(Unit.f25273a);
        }
        ((C29281) packageFragmentDescriptor).m38296a(Variance.f26339c, "R");
        this.f40841a = CollectionsKt.m28089a((Collection) storageManager);
    }

    public final TypeConstructor mo7610c() {
        return this.f40844f;
    }

    public final ClassKind mo7771g() {
        return ClassKind.INTERFACE;
    }

    public final Modality aG_() {
        return Modality.f25491d;
    }

    public final Visibility mo7257j() {
        return Visibilities.f25508e;
    }

    public final Annotations mo5718q() {
        Companion companion = Annotations.f32643a;
        return Companion.m27115a();
    }

    public final SourceElement mo7258r() {
        Object obj = SourceElement.f25498a;
        Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
        return obj;
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        return this.f40841a;
    }

    public final String toString() {
        return mo6689i().m27429a();
    }

    public final /* bridge */ /* synthetic */ DeclarationDescriptor aD_() {
        return this.f40847i;
    }

    public final /* bridge */ /* synthetic */ MemberScope mo7767b() {
        return Empty.f38819a;
    }

    public final /* bridge */ /* synthetic */ MemberScope mo7768d() {
        return this.f40845g;
    }

    public final /* synthetic */ Collection mo7770f() {
        return CollectionsKt__CollectionsKt.m26790a();
    }
}
