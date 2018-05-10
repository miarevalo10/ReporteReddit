package com.reddit.social.presentation.messaginglist;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Element;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "it", "Lorg/jsoup/nodes/Element;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
final class LinkEmbedsCache$loadLinkEmbed$2<T, R> implements Function<T, R> {
    final /* synthetic */ String f29877a;

    LinkEmbedsCache$loadLinkEmbed$2(String str) {
        this.f29877a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Element element = (Element) obj;
        Intrinsics.m26847b(element, "it");
        return LinkEmbedsCacheKt.m24705a(element, this.f29877a);
    }
}
