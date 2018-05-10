package com.reddit.datalibrary.frontpage.requests.api.v1.reddit;

import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.lang.reflect.Type;

public class ListingRequestBuilder2<T extends Listing> extends RedditRequestBuilder<T> {
    public ListingRequestBuilder2(Cannon cannon, Type type) {
        super(cannon, type);
    }

    public final RequestBuilder m19780d(String str) {
        m9327a("after", str);
        return this;
    }
}
