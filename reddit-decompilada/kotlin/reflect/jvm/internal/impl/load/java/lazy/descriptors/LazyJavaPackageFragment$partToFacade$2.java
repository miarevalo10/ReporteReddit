package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements Function0<HashMap<String, String>> {
    final /* synthetic */ LazyJavaPackageFragment f38406a;

    LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.f38406a = lazyJavaPackageFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f38406a.m42680b().entrySet()) {
            String str = (String) entry.getKey();
            KotlinClassHeader c = ((KotlinJvmBinaryClass) entry.getValue()).mo5853c();
            switch (WhenMappings.f25705a[c.f25837a.ordinal()]) {
                case 1:
                    String a = c.m27385a();
                    if (a != null) {
                        hashMap.put(str, StringsKt__StringsKt.m42458b(a, '/'));
                        break;
                    }
                    break;
                case 2:
                    hashMap.put(str, str);
                    break;
                default:
                    break;
            }
        }
        return hashMap;
    }
}
