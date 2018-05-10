package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass.Factory;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$methodOwner$2 extends Lambda implements Function0<Class<?>> {
    final /* synthetic */ Data f38264a;

    KPackageImpl$Data$methodOwner$2(Data data) {
        this.f38264a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        String a;
        Factory factory = ReflectKotlinClass.f32847c;
        ReflectKotlinClass a2 = Factory.m27389a(this.f38264a.f32594d.f38266a);
        if (a2 != null) {
            KotlinClassHeader kotlinClassHeader = a2.f32849b;
            if (kotlinClassHeader != null) {
                a = kotlinClassHeader.m27385a();
                if (a != null) {
                    if ((((CharSequence) a).length() <= 0 ? 1 : null) != null) {
                        return this.f38264a.f32594d.f38266a.getClassLoader().loadClass(StringsKt__StringsJVMKt.m41941a(a, '/', '.'));
                    }
                }
                return this.f38264a.f32594d.f38266a;
            }
        }
        a = null;
        if (a != null) {
            if (((CharSequence) a).length() <= 0) {
            }
            if ((((CharSequence) a).length() <= 0 ? 1 : null) != null) {
                return this.f38264a.f32594d.f38266a.getClassLoader().loadClass(StringsKt__StringsJVMKt.m41941a(a, '/', '.'));
            }
        }
        return this.f38264a.f32594d.f38266a;
    }
}
