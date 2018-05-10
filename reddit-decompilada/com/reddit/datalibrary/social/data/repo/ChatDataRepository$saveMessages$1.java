package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.social.data.datasource.local.ChatDiscDataSource;
import com.reddit.social.domain.functions.RawMessagesBatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pair", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$saveMessages$1 extends Lambda implements Function1<RawMessagesBatch, Unit> {
    final /* synthetic */ ChatDataRepository f36323a;
    final /* synthetic */ String f36324b;
    final /* synthetic */ String f36325c;

    ChatDataRepository$saveMessages$1(ChatDataRepository chatDataRepository, String str, String str2) {
        this.f36323a = chatDataRepository;
        this.f36324b = str;
        this.f36325c = str2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        RawMessagesBatch rawMessagesBatch = (RawMessagesBatch) obj;
        Intrinsics.m26847b(rawMessagesBatch, "pair");
        this.f36323a.m28781a();
        ChatDiscDataSource.m34245a(this.f36324b, this.f36325c, rawMessagesBatch.f22304a);
        return Unit.f25273a;
    }
}
