package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class PropertyReference1Impl extends PropertyReference1 {
    private final KDeclarationContainer f39703a;
    private final String f39704d;
    private final String f39705e;

    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.f39703a = kDeclarationContainer;
        this.f39704d = str;
        this.f39705e = str2;
    }

    public final KDeclarationContainer mo6931a() {
        return this.f39703a;
    }

    public final String mo5687b() {
        return this.f39704d;
    }

    public final String mo6932c() {
        return this.f39705e;
    }

    public final Object mo7075b(Object obj) {
        return mo7068d().mo5686a(obj);
    }
}
