package io.fabric.sdk.android.services.network;

import java.util.Map;

public interface HttpRequestFactory {
    HttpRequest mo5599a(HttpMethod httpMethod, String str);

    HttpRequest mo5600a(HttpMethod httpMethod, String str, Map<String, String> map);

    void mo5601a(PinningInfoProvider pinningInfoProvider);
}
