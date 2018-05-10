package com.reddit.social.presentation.messaginglist.content;

import com.reddit.datalibrary.frontpage.requests.models.v2.RedditLinkImageInfo;
import com.reddit.social.presentation.presentationobjects.RedditImageContentMessageData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/RedditLinkImageInfo;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditImage.kt */
final class RedditImageKt$fetchRedditData$1<T> implements Consumer<RedditLinkImageInfo> {
    final /* synthetic */ RedditImageMessageContent f29902a;
    final /* synthetic */ RedditImageContentMessageData f29903b;

    RedditImageKt$fetchRedditData$1(RedditImageMessageContent redditImageMessageContent, RedditImageContentMessageData redditImageContentMessageData) {
        this.f29902a = redditImageMessageContent;
        this.f29903b = redditImageContentMessageData;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (RedditLinkImageInfo) obj;
        Timber.b("Success", new Object[0]);
        RedditImageContentMessageData redditImageContentMessageData = this.f29903b;
        Intrinsics.m26843a(obj, "result");
        redditImageContentMessageData.f29949c = obj.m21640a();
        this.f29903b.f29950d = obj.m21641b();
        this.f29903b.f29951e = obj.m21642c();
        RedditImageKt.m24730c(this.f29902a, this.f29903b);
    }
}
