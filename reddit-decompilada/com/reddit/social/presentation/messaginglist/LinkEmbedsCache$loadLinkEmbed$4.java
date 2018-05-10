package com.reddit.social.presentation.messaginglist;

import com.reddit.social.presentation.presentationobjects.LinkEmbedState.Error;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.TuplesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkEmbedsCache.kt */
final class LinkEmbedsCache$loadLinkEmbed$4<T> implements Consumer<Throwable> {
    final /* synthetic */ String f29881a;
    final /* synthetic */ PublishSubject f29882b;
    final /* synthetic */ long f29883c;

    LinkEmbedsCache$loadLinkEmbed$4(String str, PublishSubject publishSubject, long j) {
        this.f29881a = str;
        this.f29882b = publishSubject;
        this.f29883c = j;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = new Error(this.f29881a);
        LinkEmbedsCache.INSTANCE.getCACHE_LINK_EMBEDS().put(this.f29881a, obj);
        PublishSubject publishSubject = this.f29882b;
        if (publishSubject != null) {
            publishSubject.onNext(TuplesKt.m26780a(Long.valueOf(this.f29883c), obj));
        }
    }
}
