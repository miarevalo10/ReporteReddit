package com.reddit.social.presentation.messaginglist;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
final class LinkEmbedsCache$loadLinkEmbed$1<V> implements Callable<T> {
    final /* synthetic */ String f22383a;

    LinkEmbedsCache$loadLinkEmbed$1(String str) {
        this.f22383a = str;
    }

    public final /* synthetic */ Object call() {
        Node a = Jsoup.m28433a(this.f22383a).mo6326a();
        return a.m36602a("head", a);
    }
}
