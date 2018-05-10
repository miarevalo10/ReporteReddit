package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$properties$1 extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {
    final /* synthetic */ LazyJavaScope f38418a;

    LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        this.f38418a = lazyJavaScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "name");
        ArrayList arrayList = new ArrayList();
        JavaField b = ((DeclaredMemberIndex) this.f38418a.f38426c.invoke()).mo5784b(name);
        if (!(b == null || b.mo7288b())) {
            arrayList.add(LazyJavaScope.m38382a(this.f38418a, b));
        }
        Collection collection = arrayList;
        this.f38418a.mo7262a(name, collection);
        if (DescriptorUtils.m27660j(this.f38418a.mo7268e()) != null) {
            return CollectionsKt.m28089a(collection);
        }
        return CollectionsKt.m28089a(SignatureEnhancementKt.m27269a(collection));
    }
}
