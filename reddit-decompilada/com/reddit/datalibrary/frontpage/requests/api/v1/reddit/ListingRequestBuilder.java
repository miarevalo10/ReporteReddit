package com.reddit.datalibrary.frontpage.requests.api.v1.reddit;

import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import java.io.Serializable;
import java.lang.reflect.Type;

@Deprecated
public class ListingRequestBuilder<T extends Listing> extends RedditRequestBuilder<T> {
    private RedditSort f18806m;

    public static class RedditSort implements Serializable {
        private final String f10921a;
        private final String f10922b;
    }

    public ListingRequestBuilder(Cannon cannon, Type type) {
        super(cannon, type);
    }

    public final RequestBuilder m19782d(String str) {
        m9327a("after", str);
        return this;
    }

    public final void mo3033a() {
        if (this.f18806m != null) {
            m9325a(this.f18806m.f10921a);
            if (this.f18806m.f10922b != null) {
                m9327a("t", this.f18806m.f10922b);
            }
        }
        super.mo3033a();
    }
}
