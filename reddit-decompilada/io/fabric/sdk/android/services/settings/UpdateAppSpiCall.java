package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequestFactory;

public class UpdateAppSpiCall extends AbstractAppSpiCall {
    public final /* bridge */ /* synthetic */ boolean mo6604a(AppRequestData appRequestData) {
        return super.mo6604a(appRequestData);
    }

    public UpdateAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.PUT);
    }
}
