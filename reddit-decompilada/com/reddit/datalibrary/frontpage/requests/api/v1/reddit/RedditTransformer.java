package com.reddit.datalibrary.frontpage.requests.api.v1.reddit;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.api.v1.Transformer;

public class RedditTransformer implements Transformer {
    public final RequestBuilder mo3042a(RequestBuilder requestBuilder) {
        return requestBuilder.m9327a("feature", "link_preview").m9327a("obey_over18", "true").m9327a("sr_detail", "true").m9327a("expand_srs", "true").m9327a("from_detail", "true").m9327a("api_type", "json").m9327a("raw_json", "1").m9327a("always_show_media", FrontpageSettings.m9011a().m9027b() ? "0" : "1");
    }
}
