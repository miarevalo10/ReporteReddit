package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider {
    private final ValueLoader<String> f24770a = new C25421(this);
    private final MemoryValueCache<String> f24771b = new MemoryValueCache();

    class C25421 implements ValueLoader<String> {
        final /* synthetic */ InstallerPackageNameProvider f31000a;

        C25421(InstallerPackageNameProvider installerPackageNameProvider) {
            this.f31000a = installerPackageNameProvider;
        }

        public /* synthetic */ Object load(Context context) throws Exception {
            context = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return context == null ? "" : context;
        }
    }

    public final String m26339a(Context context) {
        try {
            String str = (String) this.f24771b.get(context, this.f24770a);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Context context2) {
            Fabric.m26243b().mo5568c("Fabric", "Failed to determine installer package name", context2);
            return null;
        }
    }
}
