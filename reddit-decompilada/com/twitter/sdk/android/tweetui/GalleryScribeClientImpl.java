package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.ArrayList;
import java.util.List;

public class GalleryScribeClientImpl implements GalleryScribeClient {
    final TweetUi f30773a;

    public GalleryScribeClientImpl(TweetUi tweetUi) {
        this.f30773a = tweetUi;
    }

    public final void mo5494a() {
        TweetUi tweetUi = this.f30773a;
        EventNamespace[] eventNamespaceArr = new EventNamespace[1];
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "gallery";
        builder.f23974f = "show";
        eventNamespaceArr[0] = builder.m25878a();
        tweetUi.m31788a(eventNamespaceArr);
    }

    public final void mo5495a(ScribeItem scribeItem) {
        List arrayList = new ArrayList();
        arrayList.add(scribeItem);
        scribeItem = this.f30773a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "gallery";
        builder.f23974f = "impression";
        scribeItem.m31787a(builder.m25878a(), arrayList);
    }

    public final void mo5496b() {
        TweetUi tweetUi = this.f30773a;
        EventNamespace[] eventNamespaceArr = new EventNamespace[1];
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "gallery";
        builder.f23974f = "navigate";
        eventNamespaceArr[0] = builder.m25878a();
        tweetUi.m31788a(eventNamespaceArr);
    }

    public final void mo5497c() {
        TweetUi tweetUi = this.f30773a;
        EventNamespace[] eventNamespaceArr = new EventNamespace[1];
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "gallery";
        builder.f23974f = "dismiss";
        eventNamespaceArr[0] = builder.m25878a();
        tweetUi.m31788a(eventNamespaceArr);
    }
}
