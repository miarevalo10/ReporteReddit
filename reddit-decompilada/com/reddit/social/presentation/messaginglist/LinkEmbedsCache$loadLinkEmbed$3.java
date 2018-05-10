package com.reddit.social.presentation.messaginglist;

import com.reddit.social.presentation.presentationobjects.LinkEmbedState.Loaded;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/social/presentation/messaginglist/LinkEmbed;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
final class LinkEmbedsCache$loadLinkEmbed$3<T> implements Consumer<LinkEmbed> {
    final /* synthetic */ String f29878a;
    final /* synthetic */ PublishSubject f29879b;
    final /* synthetic */ long f29880c;

    LinkEmbedsCache$loadLinkEmbed$3(String str, PublishSubject publishSubject, long j) {
        this.f29878a = str;
        this.f29879b = publishSubject;
        this.f29880c = j;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (LinkEmbed) obj;
        String str = this.f29878a;
        Intrinsics.m26843a(obj, "it");
        Loaded loaded = new Loaded(str, obj);
        LinkEmbedsCache.INSTANCE.getCACHE_LINK_EMBEDS().put(this.f29878a, loaded);
        obj = this.f29879b;
        if (obj != null) {
            obj.onNext(TuplesKt.m26780a(Long.valueOf(this.f29880c), loaded));
        }
    }
}
