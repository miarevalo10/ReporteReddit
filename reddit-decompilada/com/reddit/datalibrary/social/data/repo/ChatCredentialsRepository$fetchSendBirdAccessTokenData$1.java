package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "tokenData", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatCredentialsRepository.kt */
final class ChatCredentialsRepository$fetchSendBirdAccessTokenData$1<T> implements Consumer<SendBirdAccessTokenData> {
    final /* synthetic */ ChatCredentialsRepository f27341a;
    final /* synthetic */ String f27342b;

    public ChatCredentialsRepository$fetchSendBirdAccessTokenData$1(ChatCredentialsRepository chatCredentialsRepository, String str) {
        this.f27341a = chatCredentialsRepository;
        this.f27342b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        ChatCredentialsRepository.m21697a(this.f27341a, this.f27342b, (SendBirdAccessTokenData) obj);
    }
}
