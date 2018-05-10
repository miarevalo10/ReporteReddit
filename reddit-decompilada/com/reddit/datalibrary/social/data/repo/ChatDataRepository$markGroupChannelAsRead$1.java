package com.reddit.datalibrary.social.data.repo;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "total", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$markGroupChannelAsRead$1<T> implements Consumer<Integer> {
    final /* synthetic */ ChatDataRepository f27356a;
    final /* synthetic */ int f27357b;

    ChatDataRepository$markGroupChannelAsRead$1(ChatDataRepository chatDataRepository, int i) {
        this.f27356a = chatDataRepository;
        this.f27357b = i;
    }

    public final /* synthetic */ void accept(Object obj) {
        ChatDataRepository.m28779a(((Integer) obj).intValue() - this.f27357b);
    }
}
