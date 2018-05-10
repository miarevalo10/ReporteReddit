package com.reddit.social.presentation.messaginglist;

import android.support.v4.util.ArrayMap;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f\u0018\u00010\u000eR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/presentation/messaginglist/LinkEmbedsCache;", "", "()V", "CACHE_LINK_EMBEDS", "Landroid/support/v4/util/ArrayMap;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "getCACHE_LINK_EMBEDS", "()Landroid/support/v4/util/ArrayMap;", "loadLinkEmbed", "", "message", "Lcom/reddit/social/presentation/presentationobjects/LinkContentMessageData;", "linkEmbedLoaded", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
public final class LinkEmbedsCache {
    private static final ArrayMap<String, LinkEmbedState> CACHE_LINK_EMBEDS = new ArrayMap();
    public static final LinkEmbedsCache INSTANCE = new LinkEmbedsCache();

    private LinkEmbedsCache() {
    }

    public final ArrayMap<String, LinkEmbedState> getCACHE_LINK_EMBEDS() {
        return CACHE_LINK_EMBEDS;
    }

    public final void loadLinkEmbed(LinkContentMessageData linkContentMessageData, PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        Intrinsics.m26847b(linkContentMessageData, "message");
        long j = linkContentMessageData.f29942b.f22429b;
        linkContentMessageData = linkContentMessageData.f29941a.getUrl();
        Observable.fromCallable(new LinkEmbedsCache$loadLinkEmbed$1(linkContentMessageData)).subscribeOn(SchedulerProvider.m23886b()).map(new LinkEmbedsCache$loadLinkEmbed$2(linkContentMessageData)).observeOn(SchedulerProvider.m23887c()).subscribe(new LinkEmbedsCache$loadLinkEmbed$3(linkContentMessageData, publishSubject, j), new LinkEmbedsCache$loadLinkEmbed$4(linkContentMessageData, publishSubject, j));
    }
}
