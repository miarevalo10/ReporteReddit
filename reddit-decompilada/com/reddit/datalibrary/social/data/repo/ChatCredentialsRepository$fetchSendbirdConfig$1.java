package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdConfig;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdConfig;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatCredentialsRepository.kt */
final class ChatCredentialsRepository$fetchSendbirdConfig$1<T> implements Consumer<SendBirdConfig> {
    final /* synthetic */ ChatCredentialsRepository f27343a;

    public ChatCredentialsRepository$fetchSendbirdConfig$1(ChatCredentialsRepository chatCredentialsRepository) {
        this.f27343a = chatCredentialsRepository;
    }

    public final /* synthetic */ void accept(Object obj) {
        SendBirdConfig sendBirdConfig = (SendBirdConfig) obj;
        this.f27343a.f19850b = sendBirdConfig;
        ChatSharedPreferencesUtil.m24748b(sendBirdConfig.max_message_length);
    }
}
