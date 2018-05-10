package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: AbstractTypeConstructor.kt */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    private final NotNullLazyValue<Supertypes> f33059a;

    /* compiled from: AbstractTypeConstructor.kt */
    private static final class Supertypes {
        List<? extends KotlinType> f26310a = CollectionsKt__CollectionsKt.m26791a((Object) ErrorUtils.f26313a);
        final Collection<KotlinType> f26311b;

        public Supertypes(Collection<? extends KotlinType> collection) {
            Intrinsics.m26847b(collection, "allSupertypes");
            this.f26311b = collection;
        }
    }

    public abstract Collection<KotlinType> mo6684a();

    public void mo6685a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
    }

    public abstract SupertypeLoopChecker aK_();

    public KotlinType mo6687f() {
        return null;
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics.m26847b(storageManager, "storageManager");
        this.f33059a = storageManager.mo5928a(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.f38918a, new AbstractTypeConstructor$supertypes$3(this));
    }

    public final /* synthetic */ Collection aL_() {
        return m33577h();
    }

    public final List<KotlinType> m33577h() {
        return ((Supertypes) this.f33059a.invoke()).f26310a;
    }

    protected Collection<KotlinType> mo6733g() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public static final /* synthetic */ Collection m33572a(TypeConstructor typeConstructor) {
        AbstractTypeConstructor abstractTypeConstructor = (AbstractTypeConstructor) (!(typeConstructor instanceof AbstractTypeConstructor) ? null : typeConstructor);
        if (abstractTypeConstructor != null) {
            abstractTypeConstructor = abstractTypeConstructor;
            return CollectionsKt___CollectionsKt.m41423b((Collection) ((Supertypes) abstractTypeConstructor.f33059a.invoke()).f26311b, (Iterable) abstractTypeConstructor.mo6733g());
        }
        Object aL_ = typeConstructor.aL_();
        Intrinsics.m26843a(aL_, "supertypes");
        return aL_;
    }
}
