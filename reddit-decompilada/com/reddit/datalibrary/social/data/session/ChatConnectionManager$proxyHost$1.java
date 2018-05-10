package com.reddit.datalibrary.social.data.session;

import com.reddit.datalibrary.frontpage.requests.models.v2.SendBirdAccessTokenData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "tokenData", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/SendBirdAccessTokenData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatConnectionManager.kt */
final class ChatConnectionManager$proxyHost$1<T> implements Consumer<SendBirdAccessTokenData> {
    final /* synthetic */ ChatConnectionManager f27386a;

    ChatConnectionManager$proxyHost$1(ChatConnectionManager chatConnectionManager) {
        this.f27386a = chatConnectionManager;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f27386a.f19861c = (SendBirdAccessTokenData) obj;
    }
}
