package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    public static final Companion f32627a = new Companion();
    private final StorageManager f32628b;
    private final ModuleDescriptor f32629c;

    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public static KindWithArity m27036a(String str, FqName fqName) {
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind.Companion companion = Kind.f25459f;
            fqName = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind.Companion.m27038a(fqName, str);
            if (fqName == null) {
                return null;
            }
            int length = fqName.f25462e.length();
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object substring = str.substring(length);
            Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
            CharSequence charSequence = (CharSequence) substring;
            if ((charSequence.length() == 0 ? 1 : null) == null) {
                str = StringsKt__StringsKt.m42463c(charSequence);
                length = 0;
                while (str.hasNext()) {
                    int a = str.mo6745a() - 48;
                    Object obj = (a < 0 || a > 9) ? 1 : null;
                    if (obj == null) {
                        length = (length * 10) + a;
                    }
                }
                str = Integer.valueOf(length);
                if (str == null) {
                    return new KindWithArity(fqName, str.intValue());
                }
                return null;
            }
            str = null;
            if (str == null) {
                return null;
            }
            return new KindWithArity(fqName, str.intValue());
        }
    }

    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    private static final class KindWithArity {
        public final Kind f25454a;
        final int f25455b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KindWithArity) {
                KindWithArity kindWithArity = (KindWithArity) obj;
                if (Intrinsics.m26845a(this.f25454a, kindWithArity.f25454a)) {
                    if (this.f25455b == kindWithArity.f25455b) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            Kind kind = this.f25454a;
            return ((kind != null ? kind.hashCode() : 0) * 31) + this.f25455b;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("KindWithArity(kind=");
            stringBuilder.append(this.f25454a);
            stringBuilder.append(", arity=");
            stringBuilder.append(this.f25455b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public KindWithArity(Kind kind, int i) {
            Intrinsics.m26847b(kind, "kind");
            this.f25454a = kind;
            this.f25455b = i;
        }
    }

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(moduleDescriptor, "module");
        this.f32628b = storageManager;
        this.f32629c = moduleDescriptor;
    }

    public final boolean mo5706a(FqName fqName, Name name) {
        Intrinsics.m26847b(fqName, "packageFqName");
        Intrinsics.m26847b(name, "name");
        Object a = name.m27429a();
        if (StringsKt__StringsJVMKt.m41944a((String) a, "Function") || StringsKt__StringsJVMKt.m41944a((String) a, "KFunction")) {
            Intrinsics.m26843a(a, "string");
            if (Companion.m27036a(a, fqName) != null) {
                return true;
            }
        }
        return null;
    }

    public final Collection<ClassDescriptor> mo5704a(FqName fqName) {
        Intrinsics.m26847b(fqName, "packageFqName");
        return SetsKt__SetsKt.m26799a();
    }

    public final ClassDescriptor mo5705a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        if (!classId.f25852a) {
            if (!classId.m27402e()) {
                Object a = classId.m27399b().m27407a();
                if ((StringsKt__StringsKt.m42452a((CharSequence) a, (CharSequence) "Function") ^ 1) != 0) {
                    return null;
                }
                FqName a2 = classId.m27398a();
                Intrinsics.m26843a(a, "className");
                Intrinsics.m26843a((Object) a2, "packageFqName");
                KindWithArity b = Companion.m27036a(a, a2);
                if (b == null) {
                    return null;
                }
                Object obj = b.f25454a;
                int i = b.f25455b;
                if (Intrinsics.m26845a(obj, Kind.f25457b)) {
                    return null;
                }
                ModuleDescriptor moduleDescriptor = this.f32629c;
                Intrinsics.m26843a((Object) a2, "packageFqName");
                Iterable f = moduleDescriptor.mo7087a(a2).mo7083f();
                Collection arrayList = new ArrayList();
                for (Object next : f) {
                    if (next instanceof BuiltInsPackageFragment) {
                        arrayList.add(next);
                    }
                }
                return new FunctionClassDescriptor(this.f32628b, (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.m41430d((List) arrayList), obj, i);
            }
        }
        return null;
    }
}
