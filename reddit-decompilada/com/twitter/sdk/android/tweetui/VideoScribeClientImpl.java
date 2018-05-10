package com.twitter.sdk.android.tweetui;

import com.instabug.chat.model.Attachment;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.ArrayList;
import java.util.List;

class VideoScribeClientImpl implements VideoScribeClient {
    final TweetUi f30785a;

    VideoScribeClientImpl(TweetUi tweetUi) {
        this.f30785a = tweetUi;
    }

    public final void mo5507a(ScribeItem scribeItem) {
        List arrayList = new ArrayList();
        arrayList.add(scribeItem);
        scribeItem = this.f30785a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = Attachment.TYPE_VIDEO;
        builder.f23974f = "impression";
        scribeItem.m31787a(builder.m25878a(), arrayList);
    }

    public final void mo5508b(ScribeItem scribeItem) {
        List arrayList = new ArrayList();
        arrayList.add(scribeItem);
        scribeItem = this.f30785a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = Attachment.TYPE_VIDEO;
        builder.f23974f = "play";
        scribeItem.m31787a(builder.m25878a(), arrayList);
    }
}
