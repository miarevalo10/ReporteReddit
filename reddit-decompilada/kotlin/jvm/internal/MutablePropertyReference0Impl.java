package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    private final KDeclarationContainer f40278a;
    private final String f40279d;
    private final String f40280e;

    public MutablePropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.f40278a = kDeclarationContainer;
        this.f40279d = str;
        this.f40280e = str2;
    }

    public final KDeclarationContainer mo6931a() {
        return this.f40278a;
    }

    public final String mo5687b() {
        return this.f40279d;
    }

    public final String mo6932c() {
        return this.f40280e;
    }

    public final Object mo7073d() {
        return mo7067i().mo5686a(new Object[0]);
    }
}
