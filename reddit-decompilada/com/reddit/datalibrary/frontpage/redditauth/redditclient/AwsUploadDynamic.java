package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import com.reddit.datalibrary.frontpage.requests.api.v1.Dynamic;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;

public class AwsUploadDynamic implements Dynamic {
    public final void mo3034a(Map<String, String> map) {
        map.put("Accept", "application/xml, text/xml, */*; q=0.01");
        map.put("Origin", "https://www.reddit.com");
        map.put("Connection", "keep-alive");
        map.put("Pragma", "no-cache");
        map.put(HttpRequest.HEADER_CACHE_CONTROL, "no-cache");
        map.put(HttpRequest.HEADER_REFERER, "https://www.reddit.com/");
        map.put(HttpRequest.HEADER_ACCEPT_ENCODING, "gzip, deflate, br");
        map.put("Accept-Language", "en-US,en;q=0.8");
    }
}
