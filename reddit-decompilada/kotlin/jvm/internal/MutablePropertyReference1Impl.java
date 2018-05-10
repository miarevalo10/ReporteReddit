package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    private final KDeclarationContainer f40281a;
    private final String f40282d;
    private final String f40283e;

    public MutablePropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.f40281a = kDeclarationContainer;
        this.f40282d = str;
        this.f40283e = str2;
    }

    public final KDeclarationContainer mo6931a() {
        return this.f40281a;
    }

    public final String mo5687b() {
        return this.f40282d;
    }

    public final String mo6932c() {
        return this.f40283e;
    }

    public final Object mo7075b(Object obj) {
        return mo7068d().mo5686a(obj);
    }
}
